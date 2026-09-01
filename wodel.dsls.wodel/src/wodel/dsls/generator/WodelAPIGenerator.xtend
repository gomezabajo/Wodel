package wodel.dsls.generator

import org.eclipse.xtext.generator.AbstractGenerator
import mutatorenvironment.Program
import org.eclipse.core.resources.IProject
import java.util.Map
import java.util.List
import java.io.File
import mutatorenvironment.MutatorEnvironment
import wodel.utils.manager.ModelManager
import org.eclipse.core.runtime.Platform
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.core.resources.ResourcesPlugin
import org.eclipse.emf.ecore.EObject
import java.util.ArrayList

/**
 * @author Pablo Gomez-Abajo - Wodel Java code generator.
 * 
 * Generates the code to programmatically execute the Wodel program.
 * 
 */
abstract class WodelAPIGenerator extends AbstractGenerator {
	
	protected URI fileURI
	protected Program program
	protected IProject project = null
	protected String xmiFileName

	protected boolean standalone = false
	
	
	/** Explicit project context used by semantic/XMI headless generation. */
	def void setGenerationProject(IProject generationProject) {
    	this.project = generationProject
	}

	def static IProject projectOf(Resource r) {
		val uri = r?.URI
		if (uri !== null && uri.platformResource) {
			val projectName = uri.segment(1) // platform:/resource/<project>/...
			return ResourcesPlugin.workspace.root.getProject(projectName)
		}
		null
	}
	
	def String getMutatorPath(MutatorEnvironment e, IProject project, File[] files) {
		var IProject p = projectOf(e.eResource)
		p = p !== null ? p : project 
		var String mutatorPath = null
		if (mutatorPath === null && files !== null) {
			for (File file : files) {
				if (mutatorPath !== null) {
					return mutatorPath
				}
				if (file !== null) {
				 	if (file.exists && file.isFile == true) {
						var path = file.path.replace("\\", "/")
						if (path.indexOf("/" + p.name + "/") != -1) {
							var mutatorFolderAndFile = path.substring(path.lastIndexOf("/" + p.name + "/"))
							if (mutatorFolderAndFile.equals(fileURI.toPlatformString(true))) {
								mutatorPath = "file:/" + p.getLocation.toFile.getPath.replace("\\", "/") + "/" + mutatorFolderAndFile.substring(("/" + p.name + "/").length)
							}
						}
					}
					if (file.exists && file.isDirectory)  {
						mutatorPath = getMutatorPath(e, p, file.listFiles)
					}
				}
			}
		}
		return mutatorPath
	}
	
	def compile(MutatorEnvironment e, IProject project, String mutatorName, String className) '''
	//«this.project = projectOf(e.eResource)»
	//«this.project = this.project !== null ? this.project : project»
	package mutator.«mutatorName»;
	
	import java.io.IOException;
	import java.util.ArrayList;
	import java.util.List;
	import java.util.Map;
	import java.util.TreeMap;
	import org.eclipse.core.resources.IProject;
	import org.eclipse.core.runtime.IProgressMonitor;
	import org.eclipse.core.runtime.NullProgressMonitor;
	import org.eclipse.emf.ecore.EPackage;
	
	import wodel.utils.exceptions.AbstractCreationException;
	import wodel.utils.exceptions.MaxSmallerThanMinException;
	import wodel.utils.exceptions.MetaModelNotFoundException;
	import wodel.utils.exceptions.ModelNotFoundException;
	import wodel.utils.exceptions.ObjectNoTargetableException;
	import wodel.utils.exceptions.ObjectNotContainedException;
	import wodel.utils.exceptions.ReferenceNonExistingException;
	import wodel.utils.exceptions.WrongAttributeTypeException;
	import wodel.utils.manager.ModelManager;
	«IF standalone == false»
	import mutator.«mutatorName»Dynamic.«mutatorName»Dynamic;
	import wodel.utils.manager.IMutatorAPI;
	«ELSE»
	import mutator.«mutatorName»Standalone.«mutatorName»Standalone;
	import org.eclipse.core.runtime.NullProgressMonitor;
	import wodel.utils.manager.MutatorStandaloneAPI;
	«ENDIF»
	import wodel.utils.manager.MutatorUtils;

		«IF standalone == false»		
	public class «className» implements IMutatorAPI {
		
		public static MutatorUtils.MutationResults createMutants(
		        String[] mutationOperators,
		        IProject project,
		        IProgressMonitor monitor)
		    throws ReferenceNonExistingException,
		           WrongAttributeTypeException,
		           MaxSmallerThanMinException,
		           AbstractCreationException,
		           ObjectNoTargetableException,
		           ObjectNotContainedException,
		           MetaModelNotFoundException,
		           ModelNotFoundException,
		           IOException {
		return createMutants(mutationOperators, project, monitor, System.nanoTime());
		} 
		«ELSE»
	public class «className» extends MutatorStandaloneAPI {

		public static MutatorUtils.MutationResults createMutants(
		        String[] mutationOperators,
		        boolean registry)
		    throws ReferenceNonExistingException,
		           WrongAttributeTypeException,
		           MaxSmallerThanMinException,
		           AbstractCreationException,
		           ObjectNoTargetableException,
		           ObjectNotContainedException,
		           MetaModelNotFoundException,
		           ModelNotFoundException,
		           IOException {
		return createMutants(mutationOperators, registry, System.nanoTime());
		}
		«ENDIF»
		«IF standalone == false»		
		public static MutatorUtils.MutationResults createMutants(
		        String[] mutationOperators,
		        IProject project,
		        IProgressMonitor monitor,
		        long executionSeed)
		    throws ReferenceNonExistingException,
		           WrongAttributeTypeException,
		           MaxSmallerThanMinException,
		           AbstractCreationException,
		           ObjectNoTargetableException,
		           ObjectNotContainedException,
		           MetaModelNotFoundException,
		           ModelNotFoundException,
		           IOException {
		«ELSE»
		public static MutatorUtils.MutationResults createMutants(
		        String[] mutationOperators,
		        boolean registry,
		        long executionSeed)
		    throws ReferenceNonExistingException,
		           WrongAttributeTypeException,
		           MaxSmallerThanMinException,
		           AbstractCreationException,
		           ObjectNoTargetableException,
		           ObjectNotContainedException,
		           MetaModelNotFoundException,
		           ModelNotFoundException,
		           IOException {
		«ENDIF»
			
			System.out.println("Wodel mutator file: «mutatorName»");
			
			String ecoreURI = "«ModelManager.getMetaModel(e)»";
			
			List<EPackage> packages = null;
			try {
				«IF standalone == false»
				packages = ModelManager.loadMetaModel("«ModelManager.getMetaModel(e)»", «className».class);
				«ELSE»
				packages = ModelManager.loadMetaModelNoException("«project.name»", ecoreURI);
				«ENDIF»
			}
			catch (Exception e) {
			}
			boolean isRegistered = ModelManager.isRegistered(packages);
			Map<String, EPackage> registeredPackages = ModelManager.registeredMetaModels(packages);
			Map<String, EPackage> localRegisteredPackages = null;
			if (isRegistered == true) {
				if (registeredPackages != null) {
					List<EPackage> packageList = new ArrayList<EPackage>();
					packageList.addAll(registeredPackages.values());
					ModelManager.unregisterMetaModel(packageList);
				}
				localRegisteredPackages = ModelManager.unregisterMetaModel(packages);
			}
			//«var int maxAttempts = 3»
            //«var int numMutants = 10»
            //«var boolean registry = true»
            //«try {
            	maxAttempts = Integer.parseInt(Platform.getPreferencesService().getString("wodel.dsls.Wodel", "Number of attempts", "3", null))
            	numMutants = Integer.parseInt(Platform.getPreferencesService().getString("wodel.dsls.Wodel", "Number of mutants", "3", null))
            	registry = Platform.getPreferencesService().getBoolean("wodel.dsls.Wodel", "Generate registry", true, null)
            } catch (Exception ex) {}»
			int maxAttempts = «maxAttempts»;
			int numMutants = «numMutants»;
			
			«IF standalone == false»
			boolean registry = «registry»;
			«ENDIF»
			
			«IF standalone == false»
			//«var boolean metrics = false»
			//«var boolean debugMetrics = false»
			//«try {
			  	metrics = Platform.getPreferencesService().getBoolean("wodel.dsls.Wodel", "Generate net mutant footprints", false, null)
			   	debugMetrics = Platform.getPreferencesService().getBoolean("wodel.dsls.Wodel", "Generate debug mutant footprints", false, null)
			} catch (Exception ex) {}»
			boolean metrics = «metrics»;
			boolean debugMetrics = «debugMetrics»;
			MutatorUtils mut«mutatorName» =
			«IF standalone == false»
			    new «mutatorName»Dynamic();
			«ELSE»
			    new «mutatorName»Standalone();
			«ENDIF»
			
			MutatorUtils.MutationResults mutationResults = null;
			try {
			    mutationResults = mut«mutatorName».execute(
			        maxAttempts,
			        numMutants,
			        registry,
			        metrics,
			        debugMetrics,
			        packages,
			        registeredPackages,
			        localRegisteredPackages,
			        mutationOperators,
			        new NullProgressMonitor(),
			        true,
			        null,
			        new TreeMap<String, List<String>>(),
			        executionSeed);
			«ELSE»
			boolean metrics = false;
			boolean debugMetrics = false;
			
			MutatorUtils mut«mutatorName» =
			«IF standalone == false»
			    new «mutatorName»Dynamic();
			«ELSE»
			    new «mutatorName»Standalone();
			«ENDIF»
			MutatorUtils.MutationResults mutationResults = null;
			try {
				mutationResults =
			    mut«mutatorName».execute(
			        maxAttempts,
			        numMutants,
			        registry,
			        metrics,
			        debugMetrics,
			        packages,
			        registeredPackages,
			        localRegisteredPackages,
			        mutationOperators,
			        new NullProgressMonitor(),
			        true,
			        null,
			        new TreeMap<String, List<String>>(),
			        executionSeed);
			«ENDIF»
					}finally {
						
				if (isRegistered == true) {
					if (localRegisteredPackages != null) {
					            ModelManager.registerMetaModel(
					                localRegisteredPackages);
					        }
					
					        if (registeredPackages != null) {
					            ModelManager.registerMetaModel(
					                registeredPackages);
					        }
				}
				}

			
			«IF standalone == true»
			System.out.println(
			    "«mutatorName» Mutant generation process finished.");
			«ENDIF»
			return mutationResults;
		}
	}
	'''
	def launcherDynamic(MutatorEnvironment e, IProject project, List<String> mutators, Map<String, List<String>> mutMap) '''

	//«this.project = projectOf(e.eResource)»
	//«this.project = this.project !== null ? this.project : project»
package mutator.«project.name»;

import java.util.ArrayList;
import java.util.List;

import wodel.utils.manager.MutatorAPILauncher;

public class «project.name.replaceAll("[.]", "_")»DynamicAPILauncher {
	public static void main(String[] args) 
	{

		String ecoreURI = "«ModelManager.getMetaModel(e)»";
		List<String> mutatorNames = new ArrayList<String>();
		«FOR mutatorName : mutMap.keySet»
		mutatorNames.add("«mutatorName»");
		«ENDFOR»
		List<List<String>> operatorNames = new ArrayList<List<String>>();
		«FOR mut : mutMap.keySet»
		List<String> mutatorOperatorNames«mut» = new ArrayList<String>();
		«FOR operator : mutMap.get(mut)»
		mutatorOperatorNames«mut».add("«operator»");
		«ENDFOR»
		operatorNames.add(mutatorOperatorNames«mut»);
		«ENDFOR»
		String[] arrMutatorNames = new String[mutatorNames.size()];
		mutatorNames.toArray(arrMutatorNames);
		String[][] arrOperatorNames = new String[mutatorNames.size()][];
		int i = 0;
		for (List<String> mutOpNames : operatorNames) {
			String[] arrMutatorOperatorNames = new String[mutOpNames.size()];
			mutOpNames.toArray(arrMutatorOperatorNames);
			arrOperatorNames[i] = arrMutatorOperatorNames;
			i++;
		}
		MutatorAPILauncher.createMutants("«project.name»", ecoreURI, «project.name.replaceAll("[.]", "_")»APILauncher.class, arrMutatorNames, arrOperatorNames, "D:\\seed", "D:\\mutants");
	}
}
	'''
	
	def String resolveMetaModelPath(EObject metaModel, IProject project) {
    if (metaModel instanceof MutatorEnvironment) {
        val mut = metaModel as MutatorEnvironment

        if (mut.definition instanceof Program) {
            val program = mut.definition as Program
            val value = program.metamodel.replace("\\", "/")
            val projectRoot =
                project.location.toFile.absolutePath.replace("\\", "/")

            // Already an absolute Windows path
            if (value.matches("^[A-Za-z]:/.*")) {
                return value
            }

            val platformPrefix =
                "platform:/resource/" + project.name + "/"

            if (value.startsWith(platformPrefix)) {
                return projectRoot + "/" +
                    value.substring(platformPrefix.length)
            }

            val projectPrefix = "/" + project.name + "/"

            if (value.startsWith(projectPrefix)) {
                return projectRoot + "/" +
                    value.substring(projectPrefix.length)
            }

            // Project-relative path
            if (!value.startsWith("/")) {
                return projectRoot + "/" + value
            }

            return value
        }
    }

    return null
}

	def launcherStandalone(List<MutatorEnvironment> mutEnvironment, IProject project, Map<String, List<String>> mutMap) '''
	
	«IF mutEnvironment !== null && !mutEnvironment.isEmpty»

	//«this.project = projectOf(mutEnvironment.get(0).eResource)»
	//«this.project = this.project !== null ? this.project : project»
	//«var String className = project.name.replaceAll("[.]", "_") + "StandaloneAPILauncher"»
	
package mutator.«project.name»;

import java.util.ArrayList;
import java.util.List;

import wodel.utils.exceptions.AbstractCreationException;
import wodel.utils.exceptions.MaxSmallerThanMinException;
import wodel.utils.exceptions.MetaModelNotFoundException;
import wodel.utils.exceptions.ModelNotFoundException;
import wodel.utils.exceptions.ObjectNoTargetableException;
import wodel.utils.exceptions.ObjectNotContainedException;
import wodel.utils.exceptions.ReferenceNonExistingException;
import wodel.utils.exceptions.WrongAttributeTypeException;
import java.io.IOException;
import java.io.File;
import wodel.utils.manager.IOUtils;
import wodel.utils.manager.MutatorUtils;
import wodel.utils.manager.ModelManager;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.eclipse.emf.ecore.EPackage;


«FOR String mutatorName : mutMap.keySet»
import mutator.«mutatorName».«mutatorName»StandaloneAPI;
«ENDFOR»

public class «project.name.replaceAll("[.]", "_")»StandaloneAPILauncher {
	
		public static boolean registerMetaModel(List<EPackage> packages) {
			if (packages == null) {
				return false;
			}
			for (EPackage pck : packages) {
				EPackage.Registry.INSTANCE.put(pck.getNsURI(), pck);
				if (pck.getESubpackages() != null && !pck.getESubpackages().isEmpty()) {
					registerMetaModel(pck.getESubpackages());
				}
			}
			return true;
		}
		
				private static void merge(
				        MutatorUtils.MutationResults target,
				        MutatorUtils.MutationResults source) {
				
				    if (source == null) {
				        return;
				    }
				
				    target.setNumMutatorsApplied(
				        target.getNumMutatorsApplied()
				        + source.getNumMutatorsApplied());
				
				    target.setNumMutantsGenerated(
				        target.getNumMutantsGenerated()
				        + source.getNumMutantsGenerated());
				
				    if (source.getMutatorsApplied() != null) {
				
				        List<String> applied =
				            target.getMutatorsApplied();
				
				        if (applied == null) {
				
				            applied =
				                new ArrayList<String>();
				
				            target.setMutatorsApplied(
				                applied);
				        }
				
				        applied.addAll(
				            source.getMutatorsApplied());
				    }
				}
				
				public static List<String> getAllOperatorNames() {
					//«var List<String> mutMapKeyList = new ArrayList<String>()»
					//«mutMapKeyList.addAll(mutMap.keySet)»
					 return List.of(
									
					    «FOR String mut : mutMapKeyList.subList(0, mutMap.keySet().size() - 1)»
					        «FOR String operator : mutMap.get(mut)»
						    "«operator»",
							«ENDFOR»
					    «ENDFOR»
					    
					    «FOR String operator : mutMap.get(mutMapKeyList.get(mutMapKeyList.size() - 1)).subList(0, mutMap.get(mutMapKeyList.get(mutMapKeyList.size() - 1)).size() - 1)»
						    "«operator»",
						«ENDFOR»
						"«mutMap.get(mutMapKeyList.get(mutMapKeyList.size() - 1)).get(mutMap.get(mutMapKeyList.get(mutMapKeyList.size() - 1)).size() - 1)»");
				}
				
				public static List<String> getOperatorNames(String mutator) {
				    List<String> operatorNames =
				        new ArrayList<String>();
				
				    «FOR mut : mutMap.keySet»
				    if (mutator.compareTo("«mut»") == 0) {
				        «FOR operator : mutMap.get(mut)»
				    operatorNames.add("«operator»");
				        «ENDFOR»
				    }
				    «ENDFOR»
				
				    return operatorNames;
				}
		
	
	
	public static MutatorUtils.MutationResults createMutants(
	        String inputFolder,
	        String outputFolder,
	        String ecoreURI,
	        long executionSeed)
	    throws ReferenceNonExistingException,
	           WrongAttributeTypeException,
	           MaxSmallerThanMinException,
	           AbstractCreationException,
	           ObjectNoTargetableException,
	           ObjectNotContainedException,
	           MetaModelNotFoundException,
	           ModelNotFoundException,
	           IOException {
	
	    return createMutants(
	        inputFolder,
	        outputFolder,
	        null,
	        true,
	        executionSeed);
	}
	
	public static MutatorUtils.MutationResults createMutants(
	        String inputFolder,
	        String outputFolder,
	        String[] blockNames,
	        boolean registry,
	        long executionSeed)
	    throws ReferenceNonExistingException,
	           WrongAttributeTypeException,
	           MaxSmallerThanMinException,
	           AbstractCreationException,
	           ObjectNoTargetableException,
	           ObjectNotContainedException,
	           MetaModelNotFoundException,
	           ModelNotFoundException,
	           IOException {
String ecoreURI =
        "«ModelManager.getMetaModel(mutEnvironment.get(0))»";

    List<String> mutatorNames =
        new ArrayList<String>();

    «FOR mutatorName : mutMap.keySet»
    mutatorNames.add(
        "«mutatorName»");
    «ENDFOR»

    List<List<String>> operatorNames =
        new ArrayList<List<String>>();

    «FOR mut : mutMap.keySet»
    List<String> mutatorOperatorNames«mut» = getOperatorNames("«mut»");

    operatorNames.add(
        mutatorOperatorNames«mut»);
    «ENDFOR»

    String[] arrMutatorNames =
        new String[mutatorNames.size()];

    mutatorNames.toArray(
        arrMutatorNames);

    String[][] arrOperatorNames =
        new String[mutatorNames.size()][];

    int i = 0;

    for (List<String> mutOpNames :
            operatorNames) {

        String[] arrMutatorOperatorNames =
            new String[mutOpNames.size()];

        mutOpNames.toArray(
            arrMutatorOperatorNames);

        arrOperatorNames[i] =
            arrMutatorOperatorNames;

        i++;
    }


    /*
     * Adapt the caller-supplied input folder to the
     * filesystem location embedded in the Wodel
     * mutation program.
     */
    String inputWodelFolder = "«project.location.toFile.absolutePath.replace("\\", "/")»/data/model";

Path requestedInput =
    Paths.get(inputFolder)
         .toAbsolutePath()
         .normalize();

Path internalInput =
    Paths.get(inputWodelFolder)
         .toAbsolutePath()
         .normalize();

if (!requestedInput.equals(internalInput)) {

    IOUtils.deleteFolder(
        internalInput.toString(),
        "model");

    IOUtils.copyFolder(
        requestedInput.toFile(),
        internalInput.toFile(),
        "model");
}

    Path inputWodelPath =
        Paths.get(inputWodelFolder)
             .toAbsolutePath()
             .normalize();
    
    /*
     * inputWodelFolder = <project>/data/model
     *
     * parent      = <project>/data
     * parent      = <project>
     */
    Path projectPath =
        inputWodelPath
            .getParent()
            .getParent();
    
    Path outputWodelPath =
        projectPath
            .resolve("data")
            .resolve("out")
            .toAbsolutePath()
            .normalize();
    
    String outputWodelFolder =
        outputWodelPath.toString();
    
    List<String> mutatorList =
        MutatorUtils.getMutators(
            projectPath.toFile().listFiles());

    IOUtils.deleteFolder(
        outputWodelFolder,
        "model",
        mutatorList);


    MutatorUtils.MutationResults total =
        new MutatorUtils.MutationResults();

    i = 0;

    «FOR String mutatorName : mutMap.keySet»

    String[] selectedOperators«mutatorName» =
        blockNames != null
            ? blockNames
            : arrOperatorNames[i];

    MutatorUtils.MutationResults result«mutatorName» =
    «IF standalone == false»
        «mutatorName»DynamicAPI.createMutants(
    «ELSE»
        «mutatorName»StandaloneAPI.createMutants(
    «ENDIF»
            selectedOperators«mutatorName»,
            registry,
            executionSeed);

    merge(
        total,
        result«mutatorName»);

    i++;

    «ENDFOR»


Path requestedOutput =
    Paths.get(outputFolder)
         .toAbsolutePath()
         .normalize();

Path internalOutput =
    Paths.get(outputWodelFolder)
         .toAbsolutePath()
         .normalize();

if (!requestedOutput.equals(internalOutput)) {

    Files.createDirectories(
        requestedOutput);

    IOUtils.copyFolder(
        internalOutput.toFile(),
        requestedOutput.toFile(),
        "model",
        mutatorList);
}
    System.out.println(
        "Complete mutant generation process finished.");

    return total;
}			
	
	public static void main(String[] args)
	        throws ReferenceNonExistingException,
	               WrongAttributeTypeException,
	               MaxSmallerThanMinException,
	               AbstractCreationException,
	               ObjectNoTargetableException,
	               ObjectNotContainedException,
	               MetaModelNotFoundException,
	               ModelNotFoundException,
	               IOException {
	
	    if (args.length != 2) {
	        System.err.println(
	            "Use: args[0] = inputFolder; " +
	            "args[1] = outputFolder");
	        System.exit(2);
	    }
	
	    MutatorUtils.MutationResults result =
	        createMutants(args[0], args[1], null, true, System.nanoTime());
	
	    System.out.println(
	        "WODEL_RESULT mutants=" +
	        result.getNumMutantsGenerated() +
	        " mutators=" +
	        result.getNumMutatorsApplied());
	
	    if (result.getMutatorsApplied() != null) {
	        System.out.println(
	            "WODEL_RESULT operators=" +
	            result.getMutatorsApplied());
	    }
	}
}
«ENDIF»
	'''
}
