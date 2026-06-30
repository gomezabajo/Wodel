package efinder.emfocl.tests.ocldataset;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.ExpressionInOCL;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.pivot.resource.ASResource;
import org.eclipse.ocl.pivot.resource.CSResource;
import org.eclipse.ocl.pivot.utilities.OCL;
import org.eclipse.ocl.xtext.completeocl.utilities.CompleteOCLCSResource;
import org.eclipse.ocl.xtext.completeoclcs.CompleteOCLDocumentCS;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.google.common.base.Preconditions;

import efinder.core.EFinderModel;
import efinder.core.IBoundsProvider;
import efinder.core.IModelFinder.Result;
import efinder.core.errors.Report;
import efinder.core.errors.UnsupportedTranslationException;
import efinder.core.footprint.FootprintComputation;
import efinder.core.footprint.IFootprint;
import efinder.core.transform.TupleToClassTransform;
import efinder.core.transform.UnfoldRecursionTransform;
import efinder.emfocl.PivotOclCompiler;
import efinder.emfocl.TypeError;
import efinder.ir.Constraint;
import efinder.ir.Specification;
import efinder.usemv.UseMvFinder;
import efinder.usemv.UseMvResult;

public class Dataset {

	private List<DatasetFile> files = new ArrayList<>();

	public static enum Mode {
		COMPLETE_FILE,
		PER_INVARIANT
	}
	
	private void addOclFile(@NonNull String filename) {
		files.add(new OclDatasetFile(filename));
	}

	private void addEcoreFile(@NonNull String filename) {
		files.add(new EcoreDatasetFile(filename));
	}
	
	public static Dataset load(@NonNull String metaJson, @NonNull String repos) throws FileNotFoundException, IOException, ParseException {
		return load(metaJson, repos, (_s) -> true, Collections.emptySet());
	}
	
	public static Dataset load(@NonNull String metaJson, @NonNull String repos, @Nullable Predicate<String> filter, @NonNull Set<String> invalidCases) throws FileNotFoundException, IOException, ParseException {
		Dataset dataset = new Dataset();
		
		JSONParser parser = new JSONParser();        
        Object obj = parser.parse(new FileReader(metaJson));
        JSONObject root = (JSONObject) obj;
        
        JSONObject files = (JSONObject) root.get("oclas");
        Map<String, String> hashToFile = new HashMap<>();
        
        for (Object key: files.keySet()) {
        	JSONArray elements = (JSONArray) files.get(key);

        	// Each element is a reference to an Ecore or an OCL file
        	for (Object object : elements) {
				String s = (String) object;				
				if ( filter != null && ! filter.test(s) )
					continue;
				
				Logger.log("Adding: " + s);
				
				String hash = hashFile(repos + File.separator + s);
				if ( hash != null ) {
					if ( hashToFile.containsKey(hash) ) {
						Logger.log("Duplicated: " + s + " - " + hashToFile.get(hash));
						continue;
					}
					hashToFile.put(hash, s);
				}
				
				if ( invalidCases.contains(s) ) {
					continue;
				}
								
				if ( s.endsWith(".ocl")) {
					dataset.addOclFile(repos + File.separator + s);
				}
				else if ( s.endsWith(".ecore") ) {
					dataset.addEcoreFile(repos + File.separator + s);
				} else {
					throw new RuntimeException("Cannot handle: " + s);
				}
        	}
        }
        
        return dataset;
	}
	
	private abstract class DatasetFile {
		protected @NonNull String filename;

		public DatasetFile(@NonNull String filename) {
			this.filename = filename;
		}

		protected abstract void evaluate(@NonNull ExecutionRecord stats, @NonNull Mode mode);

		protected List<EFinderModel> processPivot(ExecutionRecord stats, Model pivot, @Nullable ResourceSet rs, @NonNull Mode mode) {
			PivotOclCompiler compiler = rs == null ?
					new PivotOclCompiler(pivot) :
					new PivotOclCompiler(pivot, rs).withPackages(rs.getResources());
					
			EFinderModel ir;
			
			try {
				ir = compiler.compile();
			} catch (UnsupportedTranslationException e) {
				// A trick to count this in the stats properly
				Report report = new Report();
				report.addUnsupported(e.getMessage(), null, Report.Action.STOP, e.getReason());
				stats.processed(filename, new UseMvResult.Unsupported(report), null);
				return Collections.emptyList();
			}
			
			
			new efinder.emfocl.use.EMFOCL2UseFixer().transform(ir);
			new TupleToClassTransform().transform(ir);
			new UnfoldRecursionTransform().transform(ir);
			
			if (mode == Mode.COMPLETE_FILE) {
				Result result = doFind(ir);
				stats.processed(filename, result, ir);
				return Collections.singletonList(ir);
			} else {
				List<EFinderModel> models = new ArrayList<>();
				Specification spec = ir.getSpecification();
				for (Constraint constraint : spec.getConstraints()) {					
				    Copier copier = new Copier();
				    Specification newSpec = (Specification) copier.copy(spec);
				    copier.copyReferences();
				    
					Constraint target = (Constraint) copier.get(constraint);
					newSpec.getConstraints().removeIf(c -> c != target);
					Preconditions.checkState(newSpec.getConstraints().size() == 1);
					
					
					EFinderModel oneInvariantModel = new EFinderModel(newSpec);
					Result result = doFind(oneInvariantModel);
					stats.processed(filename + "#" + target.getName(), result, oneInvariantModel);					
					models.add(oneInvariantModel);
				}	
				return models;
			}		
		}

		private Result doFind(EFinderModel ir) {
			UseMvFinder finder = new UseMvFinder();
			finder.withBoundsProvider(new IBoundsProvider.Fixed(2, 5));
			IFootprint footprint = new FootprintComputation().compute(ir);
			Result result = finder.find(ir, footprint);
			Logger.log("SAT = " + result.isSat());
			return result;
		}		
	}
	
	private class OclDatasetFile extends DatasetFile {

		public OclDatasetFile(@NonNull String filename) {
			super(filename);
		}

		@Override
		protected void evaluate(@NonNull ExecutionRecord stats, @NonNull Mode mode) {
			Logger.log("Processing " + filename);
			//ASResource as = oclToAs(URI.createFileURI(path));
			CompleteOCLDocumentCS doc = loadCompleteDoc(URI.createFileURI(filename));
			CompleteOCLCSResource r = (CompleteOCLCSResource) doc.eResource();
			if (!r.getErrors().isEmpty()) {
				stats.doNotValidate(filename);
			}
			
			CompleteOCLDocumentCS document = (CompleteOCLDocumentCS) r.getContents().get(0);
			Model pivot = (Model) document.getPivot();
			
			processPivot(stats, pivot, null, mode);
		}

		protected CompleteOCLDocumentCS loadCompleteDoc(URI uri) {
			ResourceSet rs = new ResourceSetImpl();
			CSResource r = (CSResource) rs.getResource(uri, true);
			return (CompleteOCLDocumentCS) r.getContents().get(0);
		}		
	}
	
	private class EcoreDatasetFile extends DatasetFile {

		public EcoreDatasetFile(@NonNull String filename) {
			super(filename);
		}

		@Override
		protected void evaluate(@NonNull ExecutionRecord stats, @NonNull Mode mode) {
			Logger.log("Processing " + filename);
			
			ResourceSet rs = new ResourceSetImpl();
			Resource r;
			ASResource as = null;
			try {
				r = rs.getResource(URI.createFileURI(filename), true);
				EcoreUtil.resolveAll(rs);
				for (EObject root : r.getContents()) {
					Diagnostic d = Diagnostician.INSTANCE.validate(root);
					if (d.getSeverity() == Diagnostic.ERROR) {
						stats.doNotValidate(filename);
						return;
					}
				}
				
				// Register packages
				for (Resource res : rs.getResources()) {
					res.getAllContents().forEachRemaining(o -> {
						if (o instanceof EPackage) {
							EPackage pkg = (EPackage) o;
							rs.getPackageRegistry().put(pkg.getNsURI(), pkg);
						}
					});
				}
				
				as = toAs(r);
			} catch ( Exception e ) {
				e.printStackTrace();
				stats.loadError(filename);
				return;
			}
			Model pivot = as.getModel();
			processPivot(stats, pivot, rs, mode);
		}
		
		protected  ASResource toAs(Resource resource) throws org.eclipse.ocl.pivot.utilities.ParserException {
	    	ResourceSet rs = resource.getResourceSet();
			
			// This is needed if it not running under Eclipse... and also within Eclipse it seems
			if ( true ) {
				((ResourceSetImpl) rs).setURIResourceMap(new HashMap<URI, Resource>());
		        ((ResourceSetImpl) rs).getURIResourceMap().put(URI.createURI("platform:/plugin/org.eclipse.emf.ecore/model/Ecore.ecore"), EcorePackage.eINSTANCE.eResource());   
		        
		        // Needed for cases like occiware/OCCI-Studio/plugins/org.eclipse.cmf.occi.core/model/OCCI.ecore
		        URI uri = URI.createFileURI("../../org.eclipse.emf.ecore/model/Ecore.ecore");
		        uri = uri.resolve(resource.getURI());
		        ((ResourceSetImpl) rs).getURIResourceMap().put(uri, EcorePackage.eINSTANCE.eResource());
		        
		        // ../../org.eclipse.gmf.runtime.notation/model/notation.ecore
			}
			
	        OCL ocl = OCL.newInstance(OCL.NO_PROJECTS, rs);
	        //Resource resource = rs.getResource(uri, true);
	        @NonNull ASResource as = ocl.ecore2as(resource);
	        
	        Collection<ExpressionInOCL> expressions = new LinkedList<>();
	        collectOclExpressions(as.getModel(), expressions);
	        for(ExpressionInOCL e : expressions) {
	        	ocl.parseSpecification(e);
	        }
	        
	        return as;
		}

		protected  void collectOclExpressions(EObject object, Collection<ExpressionInOCL> expressions) {
	        if (object instanceof ExpressionInOCL) {
	            expressions.add((ExpressionInOCL) object);
	        }
	        object.eContents().forEach(o -> collectOclExpressions(o, expressions));
	    }
	}

	public void evaluate(@NonNull Mode mode, ExecutionRecord stats) {
		stats.setExpectedFiles(files.size());
		for (DatasetFile datasetFile : files) {
			try {
				datasetFile.evaluate(stats, mode);
			} catch (org.eclipse.ocl.pivot.internal.delegate.OCLDelegateException e) {
				e.printStackTrace();
				// This typically happens when we read a feature which is derived but it is not marked as changeable
				stats.typeError(datasetFile.filename, "ocl-delegate-exception");
			} catch (TypeError e) {
				stats.typeError(datasetFile.filename, e.getReason());
			} catch (Exception e) {
				e.printStackTrace();
				stats.unknownFailure(datasetFile.filename);	
			}
		}
	}
	
	/** 
	 * Computes the hash of file. This is used here to use only unique files, per content.
	 */
	private static String hashFile(String file) {
		try {
		 MessageDigest md = MessageDigest.getInstance("MD5");
		 byte[] contents = Files.readAllBytes(new File(file).getAbsoluteFile().toPath());		 
		 md.update(contents);		 
		 byte[] digest = md.digest();		 
		 // String myHash = DatatypeConverter.printHexBinary(digest).toUpperCase();		         	
		 return Base64.getEncoder().encodeToString(digest);
		} catch ( Exception e ) {
			e.printStackTrace();
			return null;
		}
	}

}
