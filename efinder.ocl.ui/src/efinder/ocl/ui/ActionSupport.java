package efinder.ocl.ui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.ocl.pivot.Model;
import org.eclipse.ocl.xtext.completeoclcs.CompleteOCLDocumentCS;

import efinder.core.IBoundsProvider;
import efinder.core.IModelFinder.Result;
import efinder.core.IModelFinder.ScrollingResult;
import efinder.core.management.EMFModel;
import efinder.core.management.EcoreMetamodel;
import efinder.emfocl.runner.EFinderRunner;
import efinder.usemv.UseMvFinder;
import efinder.usemv.UseMvFinder.FindingMode;

/**
 * A class to encapsulate the actions performed as response of UI interactions.
 * 
 * @author jesus
 */
public class ActionSupport {

	@NonNull
	private IConstraintsConfiguration configuration;

	public ActionSupport(@NonNull IConstraintsConfiguration configuration) {
		this.configuration = configuration;
	}
	
	public void generateExample(boolean useScrolling, int numExamples) {
		invokeFinder(null, useScrolling, numExamples);
	}
	
    public void completeModel(@NonNull IResource r, boolean useScrolling, int numExamples) {
		if ( r != null ) {
			ResourceSet rs = new ResourceSetImpl();
			
			Resource model = rs.getResource(URI.createFileURI(r.getFullPath().toOSString()), true);
			Set<EPackage> packages = new HashSet<EPackage>();
			// We need a way to the packages of the model
			model.getAllContents().forEachRemaining(v -> packages.add(v.eClass().getEPackage()));
			
			EMFModel partialModel = new EMFModel(model, new EcoreMetamodel(packages));
			invokeFinder(partialModel, useScrolling, numExamples);
		}
	}
	
    protected void invokeFinder(@Nullable EMFModel partialModel, boolean useScrolling, int numExamples) {    	
    	// TODO: Get the bounds provider
		EFinderRunner runner = getFinder(partialModel, useScrolling);
		
		try {
			@NonNull Result result = runner.find();
			if ( result.isSat() ) {
				configuration.showMessage("SAT!");
				
				if ( ! useScrolling ) {
					EMFModel witness  = result.getWitness();
					saveModel(witness);

					// This is something that we have removed for the moment. 
					// The user needs to go the folder to check the models.
					//
					// witnessFoundList.createModel(witness);
					// this.tblViewerModel.setInput(witnessFoundList);
					// this.tblViewerModel.refresh();
					// this.treeViewer = UIUtils.createModelViewer(cmpModelView, newModel, null, this.treeViewer);
				} else {
					ScrollingResult scroll = (ScrollingResult) result;
					Iterator<EMFModel> it = scroll.iterator();
					int i = 0;
					while (it.hasNext()) {
						saveModel(it.next());
						i++;
						if (numExamples == i)
							break;
					}
				}
			} else if ( result.isUnsat() ) {
				configuration.showMessage("UNSAT!");
			} else {
				configuration.showMessage("There are errors");
			}
		} catch ( Exception e ) {
			e.printStackTrace();
			configuration.showMessage(e.getMessage());
		}
	}

	private void saveModel(EMFModel witness) throws IOException, FileNotFoundException {
		Resource newModel = witness.getResource();
		if (configuration.getProject() != null) {
			IFolder outputs = configuration.getOutputFolder();
			saveModelAutomatically(newModel, outputs, "output");
		}
	}
    
	private void saveModelAutomatically(Resource newModel, IFolder outputs, String prefix)
			throws IOException, FileNotFoundException {
		
		int size = new File(outputs.getLocation().toOSString()).list().length;

		IFile f = outputs.getFile(prefix + "." + (size + 1) + ".xmi");
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put(XMIResource.OPTION_SCHEMA_LOCATION, Boolean.TRUE);
		newModel.save(new FileOutputStream(f.getLocation().toOSString()), map);
	
		configuration.log("Saved " + f.getFullPath().toOSString());
	}

	@NonNull
	private EFinderRunner getFinder(@Nullable EMFModel partialModel, boolean useScrolling) {
		CompleteOCLDocumentCS doc = configuration.getDocument().getDoc();
		Model pivot = (Model) doc.getPivot();

		IBoundsProvider provider = getBounds(doc);
		
		UseMvFinder finder = new UseMvFinder()
				.withBoundsProvider(provider);

		if (useScrolling) 
			finder.withMode(FindingMode.SCROLL);
		
		if (partialModel != null)
			finder.withPartialModel(partialModel);
		
		
		EFinderRunner runner = EFinderRunner.
				withOclModel(pivot).
				withFinder(finder);
		return runner;
	}

	private IBoundsProvider getBounds(CompleteOCLDocumentCS doc) {
		IBoundsProvider provider;
		CommentBasedBoundsProvider commentedBounds = new CommentBasedBoundsProvider(doc);
		if (commentedBounds.hasBounds()) {
			provider = commentedBounds;
		} else {
			provider = IBoundsProvider.FIXED;
		}
		return provider;
	}

}
