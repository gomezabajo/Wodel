package wodel.dsls.generator

import org.eclipse.xtext.generator.AbstractGenerator
import java.util.List
import org.eclipse.core.resources.IProject
import mutatorenvironment.Program
import java.util.Map
import mutatorenvironment.Mutator
import java.util.LinkedHashMap
import org.osgi.framework.Bundle
import wodel.utils.manager.ProjectUtils
import java.io.File
import java.util.ArrayList
import mutatorenvironment.MutatorEnvironment
import mutatorenvironment.ModifyInformationMutator
import mutatorenvironment.RandomTypeSelection
import mutatorenvironment.CompleteTypeSelection
import mutatorenvironment.SpecificObjectSelection
import org.eclipse.emf.ecore.EAttribute
import mutatorenvironment.AttributeSwap
import mutatorenvironment.AttributeCopy
import mutatorenvironment.AttributeOperation
import mutatorenvironment.ObjectAttributeType
import mutatorenvironment.SpecificIntegerType
import mutatorenvironment.RandomIntegerType
import mutatorenvironment.RandomIntegerNumberType
import mutatorenvironment.SpecificDoubleType
import mutatorenvironment.RandomDoubleType
import mutatorenvironment.RandomDoubleNumberType
import mutatorenvironment.MinValueType
import mutatorenvironment.MaxValueType
import org.eclipse.emf.ecore.EReference
import mutatorenvironment.ReferenceSwap
import mutatorenvironment.ReferenceInit
import mutatorenvironment.OtherTypeSelection
import mutatorenvironment.ReferenceAdd
import mutatorenvironment.ReferenceRemove
import mutatorenvironment.ReferenceAtt
import mutatorenvironment.Block
import wodel.utils.manager.MutatorUtils
import mutatorenvironment.CreateObjectMutator
import mutatorenvironment.SelectObjectMutator
import mutatorenvironment.SelectSampleMutator
import mutatorenvironment.AttributeEvaluation
import mutatorenvironment.ReferenceEvaluation
import mutatorenvironment.CloneObjectMutator
import mutatorenvironment.RetypeObjectMutator
import mutatorenvironment.ModifySourceReferenceMutator
import mutatorenvironment.ModifyTargetReferenceMutator
import mutatorenvironment.CreateReferenceMutator
import mutatorenvironment.RemoveObjectMutator
import mutatorenvironment.RemoveRandomReferenceMutator
import mutatorenvironment.RemoveSpecificReferenceMutator
import mutatorenvironment.RemoveCompleteReferenceMutator
import mutatorenvironment.CompositeMutator
import mutatorenvironment.AttributeScalar
import mutatorenvironment.AttributeSet
import mutatorenvironment.AttributeUnset
import mutatorenvironment.AttributeReverse
import mutatorenvironment.ReferenceSet
import mutatorenvironment.Definition
import mutatorenvironment.Repeat
import mutatorenvironment.AttributeType
import mutatorenvironment.StringType
import mutatorenvironment.DoubleType
import mutatorenvironment.BooleanType
import mutatorenvironment.IntegerType
import mutatorenvironment.ListStringType
import mutatorenvironment.ListType
import mutatorenvironment.RandomType
import mutatorenvironment.SpecificStringType
import mutatorenvironment.RandomStringType
import mutatorenvironment.UpperStringType
import mutatorenvironment.LowerStringType
import mutatorenvironment.CatStartStringType
import mutatorenvironment.CatEndStringType
import mutatorenvironment.ReplaceStringType
import mutatorenvironment.RandomStringNumberType
import mutatorenvironment.SpecificBooleanType
import mutatorenvironment.RandomBooleanType
import mutatorenvironment.ObSelectionStrategy
import mutatorenvironment.Expression
import mutatorenvironment.TypedSelection
import mutatorenvironment.BinaryOperator
import mutatorenvironment.NullTypeSelection
import mutatorenvironment.ReferenceUnset
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.core.resources.ResourcesPlugin
import wodel.dsls.generator.mutators.stochastic.WodelGeneratorModifyInformationMutator
import wodel.dsls.generator.mutators.exhaustive.WodelGeneratorGenericOperatorExhaustiveMutator
import wodel.dsls.generator.mutators.stochastic.WodelGeneratorGenericOperatorStochasticMutator
import wodel.dsls.generator.mutators.stochastic.WodelGeneratorCreateObjectMutator
import wodel.dsls.generator.mutators.stochastic.WodelGeneratorSelectObjectMutator
import wodel.dsls.generator.mutators.stochastic.WodelGeneratorSelectSampleMutator
import wodel.dsls.generator.mutators.stochastic.WodelGeneratorCloneObjectMutator
import wodel.dsls.generator.mutators.stochastic.WodelGeneratorRetypeObjectMutator
import wodel.dsls.generator.mutators.stochastic.WodelGeneratorModifySourceReferenceMutator
import wodel.dsls.generator.mutators.stochastic.WodelGeneratorModifyTargetReferenceMutator
import wodel.dsls.generator.mutators.stochastic.WodelGeneratorCreateReferenceMutator
import wodel.dsls.generator.mutators.stochastic.WodelGeneratorRemoveObjectMutator
import wodel.dsls.generator.mutators.stochastic.WodelGeneratorRemoveRandomReferenceMutator
import wodel.dsls.generator.mutators.stochastic.WodelGeneratorRemoveSpecificReferenceMutator
import wodel.dsls.generator.mutators.stochastic.WodelGeneratorRemoveCompleteReferenceMutator
import wodel.dsls.generator.mutators.exhaustive.WodelGeneratorModifyInformationExhaustiveMutator
import wodel.dsls.generator.mutators.exhaustive.WodelGeneratorCreateObjectExhaustiveMutator
import wodel.dsls.generator.mutators.exhaustive.WodelGeneratorSelectObjectExhaustiveMutator
import wodel.dsls.generator.mutators.exhaustive.WodelGeneratorSelectSampleExhaustiveMutator
import wodel.dsls.generator.mutators.exhaustive.WodelGeneratorCloneObjectExhaustiveMutator
import wodel.dsls.generator.mutators.exhaustive.WodelGeneratorRetypeObjectExhaustiveMutator
import wodel.dsls.generator.mutators.exhaustive.WodelGeneratorModifySourceReferenceExhaustiveMutator
import wodel.dsls.generator.mutators.exhaustive.WodelGeneratorModifyTargetReferenceExhaustiveMutator
import wodel.dsls.generator.mutators.exhaustive.WodelGeneratorCreateReferenceExhaustiveMutator
import wodel.dsls.generator.mutators.exhaustive.WodelGeneratorRemoveObjectExhaustiveMutator
import wodel.dsls.generator.mutators.exhaustive.WodelGeneratorRemoveRandomReferenceExhaustiveMutator
import wodel.dsls.generator.mutators.exhaustive.WodelGeneratorRemoveSpecificReferenceExhaustiveMutator
import wodel.dsls.generator.mutators.exhaustive.WodelGeneratorRemoveCompleteReferenceExhaustiveMutator
import mutatorenvironment.Evaluation
import wodel.dsls.runner.WodelUtils
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.util.EcoreUtil

/**
 * @author Pablo Gomez-Abajo - Wodel Java code generator.
 * 
 * Generates the Java code for the mutations.
 * 
 * This class was started by Victor Lopez Rivero.
 * Since March, 2015 it is continued by Pablo Gomez Abajo.
 *  
 */

abstract class WodelMutatorGenerator extends AbstractGenerator {
	protected int[] nMethod
	protected int[] nMethodCall
	protected int[] nCompositeMethod
	protected int[] nRegistryMethod
	protected int[] nRegistryMethodCall
	protected int[] nCompositeRegistryMethod
	protected List<String> compositeCommands
	protected List<String> compositeRegistryCommands
	protected int[] nCommands
	protected int[] nMutation
	protected int[] nRegistryMutation
	protected int[] nCompositeCommands
	protected int[] nExpression
	protected List<Integer> expressionList
	protected int[] nReference
	protected String methodName
	protected String registryMethodName
	protected String commandName
	protected String attributeName
	protected String referenceName
	protected String compositeMethodName
	protected String compositeRegistryMethodName
	protected String compositeCommandName
	protected boolean executeMutation
	protected int[] nMut

	protected boolean standalone = false
	protected IProject project = null
	protected URI fileURI
	protected String className
	protected Program program
	protected Map<Mutator, Integer> mutIndexes = new LinkedHashMap<Mutator, Integer>()
	
	protected Bundle bundle
	
	protected WodelGeneratorGenericOperatorExhaustiveMutator wodelExhaustiveMutatorGenerator
	protected WodelGeneratorGenericOperatorStochasticMutator wodelStochasticMutatorGenerator
	
	
	//WodelMutatorGenerator class constructor
	new() {
		nMethod = newIntArrayOfSize(1)
		nMethod.set(0, 0)
		nMethodCall = newIntArrayOfSize(1)
		nMethodCall.set(0, 0)
		nCompositeMethod = newIntArrayOfSize(1)
		nCompositeMethod.set(0, 0)
		nRegistryMethod = newIntArrayOfSize(1)
		nRegistryMethod.set(0, 0)
		nRegistryMethodCall = newIntArrayOfSize(1)
		nRegistryMethodCall.set(0, 0)
		nCompositeRegistryMethod = newIntArrayOfSize(1)
		nCompositeRegistryMethod.set(0, 0)
		compositeCommands = new ArrayList<String>()
		compositeRegistryCommands = new ArrayList<String>()
		nCommands = newIntArrayOfSize(1)
		nCommands.set(0, 0)
		nMutation = newIntArrayOfSize(1)
		nMutation.set(0, 0)
		nRegistryMutation = newIntArrayOfSize(1)
		nRegistryMutation.set(0, 0)
		nCompositeCommands = newIntArrayOfSize(1)
		nCompositeCommands.set(0, 0)
		nExpression = newIntArrayOfSize(1)
		nExpression.set(0, 0)
		expressionList = newIntArrayOfSize(1)
		expressionList.set(0, 0)
		nReference = newIntArrayOfSize(1)
		nReference.set(0, 0)
		nMut = newIntArrayOfSize(1)
		nMut.set(0, 0)
		executeMutation = true
		standalone = false
		project = null
	}
	
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
	
	def launcher(List<MutatorEnvironment> mutEnvironment, IProject project, List<String> mutators) '''

	«IF mutEnvironment !== null && !mutEnvironment.isEmpty»

    //«var MutatorEnvironment e = mutEnvironment.size() > 0 ? mutEnvironment.get(0) : null»
	//«this.project = project !== null? project : projectOf(mutEnvironment.get(0).eResource)»
package mutator.«project.name»;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.AbstractMap.SimpleEntry;

import org.eclipse.core.resources.IProject;
import wodel.utils.exceptions.AbstractCreationException;
import wodel.utils.exceptions.MaxSmallerThanMinException;
import wodel.utils.exceptions.MetaModelNotFoundException;
import wodel.utils.exceptions.ModelNotFoundException;
import wodel.utils.exceptions.ObjectNoTargetableException;
import wodel.utils.exceptions.ObjectNotContainedException;
import wodel.utils.exceptions.ReferenceNonExistingException;
import wodel.utils.exceptions.WrongAttributeTypeException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EPackage;

«FOR mutatorName : mutators»
«IF standalone == false»
import mutator.«mutatorName»Dynamic.«mutatorName»Dynamic;
«ELSE»
import mutator.«mutatorName»Standalone.«mutatorName»Standalone;
«ENDIF»
«ENDFOR»
«IF standalone == false»
import wodel.utils.manager.IMutatorExecutor;
«ELSE»
import wodel.utils.manager.IMutatorStandaloneExecutor;
«ENDIF»
import wodel.utils.manager.IWodelTest;
import wodel.utils.manager.ModelManager;
import wodel.utils.manager.MutatorUtils;
import wodel.utils.manager.MutatorUtils.MutationResults;

«IF standalone == false»
public class «project.name.replaceAll("[.]", "_")»DynamicLauncher implements IMutatorExecutor {
«ELSE»
public class «project.name.replaceAll("[.]", "_")»StandaloneLauncher implements IMutatorStandaloneExecutor {
«ENDIF»

	«IF standalone == false»
	public MutationResults execute(int maxAttempts, int numMutants, boolean registry, boolean metrics, boolean debugMetrics, String[] blockNames, IProject project, IProgressMonitor monitor, boolean serialize, Object testObject, Map<String, List<String>> classes, Map<String, EPackage> registeredPackages, long executionSeed) throws ReferenceNonExistingException, WrongAttributeTypeException, 
												  MaxSmallerThanMinException, AbstractCreationException, ObjectNoTargetableException, 
												  ObjectNotContainedException, MetaModelNotFoundException, ModelNotFoundException, IOException {
	«ELSE»
	public MutationResults execute(int maxAttempts, int numMutants, boolean registry, boolean metrics, boolean debugMetrics, String[] blockNames, IProgressMonitor monitor, boolean serialize, Object testObject, Map<String, List<String>> classes, Map<String, EPackage> registeredPackages, long executionSeed) throws ReferenceNonExistingException, WrongAttributeTypeException, 
												  MaxSmallerThanMinException, AbstractCreationException, ObjectNoTargetableException, 
												  ObjectNotContainedException, MetaModelNotFoundException, ModelNotFoundException, IOException {
	«ENDIF»
	
    IWodelTest test = testObject != null ? (IWodelTest) testObject : null;
	«IF e.definition instanceof Program»
	String ecoreURI = "«e.definition.metamodel»";
	//Load MetaModel
	List<EPackage> packages = ModelManager.loadMetaModel(ecoreURI, this.getClass());
	//checks whether the meta-model is dynamically registered
	boolean isRegistered = ModelManager.isRegistered(packages);
	Map<String, EPackage> localRegisteredPackages = null;
	if (isRegistered == true) {
		if (registeredPackages != null) {
			List<EPackage> packageList = new ArrayList<EPackage>();
			packageList.addAll(registeredPackages.values());
			ModelManager.unregisterMetaModel(packageList);
		}
		localRegisteredPackages = ModelManager.unregisterMetaModel(packages);
	}
	«ENDIF»

	MutationResults mutationResults = new MutationResults();
	«FOR mutatorName : mutators»
	«IF standalone == false»
		MutatorUtils mut«mutatorName» = new «mutatorName»Dynamic();
		MutationResults results«mutatorName» = null;
		try {
			results«mutatorName» = mut«mutatorName».execute(maxAttempts, numMutants, registry, metrics, debugMetrics, packages, registeredPackages, localRegisteredPackages, blockNames, project, monitor, serialize, test, classes, executionSeed);
	«ELSE»
		MutatorUtils mut«mutatorName» = new «mutatorName»Standalone();
		MutationResults results«mutatorName» = null;
		try {
			results«mutatorName» = mut«mutatorName».execute(maxAttempts, numMutants, registry, metrics, debugMetrics, packages, registeredPackages, localRegisteredPackages, blockNames, monitor, serialize, test, classes, executionSeed);
	«ENDIF»
		mutationResults.setNumMutatorsApplied(mutationResults.getNumMutatorsApplied() + results«mutatorName».getNumMutatorsApplied());
		mutationResults.setNumMutantsGenerated(mutationResults.getNumMutantsGenerated() + results«mutatorName».getNumMutantsGenerated());
		if (results«mutatorName».getMutatorsApplied() != null) {
			if (mutationResults.getMutatorsApplied() == null) {
				mutationResults.setMutatorsApplied(new ArrayList<String>());
			}
			mutationResults.getMutatorsApplied().addAll(results«mutatorName».getMutatorsApplied()); 
		}
		}
		finally {
			
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
	«ENDFOR»
	
	return mutationResults;
	}
	«ENDIF»
}
	'''
		
	def getRandom(int range) {
		if(range==1) return 0
		
        var int value = System.nanoTime().intValue % range
        if (value<0) value= value*-1
        
        return value
	}
	
	
	def method(Mutator mut, boolean exhaustive, MutatorEnvironment e, Block b, boolean last) '''
		«IF exhaustive == false»
		«IF standalone == false»
		private List<Mutator> «methodName»(List<EPackage> packages, List<Resource> models, Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects, Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList, boolean serialize, IWodelTest test, Map<String, List<String>> classes) throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException {
		«ELSE»
		private List<Mutator> «methodName»(List<EPackage> packages, List<Resource> models, Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects, Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList, boolean serialize, IWodelTest test, Map<String, List<String>> classes) throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException {
		«ENDIF»
			List<Mutator> mutations = new ArrayList<Mutator>();
		«IF mut instanceof ModifyInformationMutator»
			//MODIFY INFORMATION MUTATOR CODE: «{wodelStochasticMutatorGenerator = new WodelGeneratorModifyInformationMutator(); ""}»
		«ENDIF»
		«IF mut instanceof CreateObjectMutator»
			//CREATE OBJECT MUTATOR CODE: «{wodelStochasticMutatorGenerator = new WodelGeneratorCreateObjectMutator(); ""}»
		«ENDIF»
		«IF mut instanceof SelectObjectMutator»
			//SELECT OBJECT MUTATOR CODE: «{wodelStochasticMutatorGenerator = new WodelGeneratorSelectObjectMutator(); ""}»
		«ENDIF»
		«IF mut instanceof SelectSampleMutator»
			//SELECT SAMPLE MUTATOR CODE: «{wodelStochasticMutatorGenerator = new WodelGeneratorSelectSampleMutator(); ""}»
		«ENDIF»
		«IF mut instanceof CloneObjectMutator»
			//CLONE OBJECT MUTATOR CODE: «{wodelStochasticMutatorGenerator = new WodelGeneratorCloneObjectMutator(); ""}»
		«ENDIF»
		«IF mut instanceof RetypeObjectMutator»
			//RETYPE OBJECT MUTATOR CODE: «{wodelStochasticMutatorGenerator = new WodelGeneratorRetypeObjectMutator(); ""}»
		«ENDIF»
		«IF mut instanceof ModifySourceReferenceMutator»
			//MODIFY SOURCE REFERENCE MUTATOR CODE: «{wodelStochasticMutatorGenerator = new WodelGeneratorModifySourceReferenceMutator(); ""}»
		«ENDIF»
		«IF mut instanceof ModifyTargetReferenceMutator»
			//MODIFY TARGET REFERENCE MUTATOR CODE: «{wodelStochasticMutatorGenerator = new WodelGeneratorModifyTargetReferenceMutator(); ""}»
		«ENDIF»
		«IF mut instanceof CreateReferenceMutator»
			//CREATE REFERENCE MUTATOR CODE: «{wodelStochasticMutatorGenerator = new WodelGeneratorCreateReferenceMutator(); ""}»
		«ENDIF»
		«IF mut instanceof RemoveObjectMutator»
			//REMOVE OBJECT MUTATOR CODE: «{wodelStochasticMutatorGenerator = new WodelGeneratorRemoveObjectMutator(); ""}»
		«ENDIF»
		«IF mut instanceof RemoveRandomReferenceMutator»
			//REMOVE RANDOM REFERENCE MUTATOR CODE: «{wodelStochasticMutatorGenerator = new WodelGeneratorRemoveRandomReferenceMutator(); ""}»
		«ENDIF»
		«IF mut instanceof RemoveSpecificReferenceMutator»
			//REMOVE SPECIFIC REFERENCE MUTATOR CODE: «{wodelStochasticMutatorGenerator = new WodelGeneratorRemoveSpecificReferenceMutator(); ""}»
		«ENDIF»
		«IF mut instanceof RemoveCompleteReferenceMutator»
			//REMOVE COMPLETE REFERENCE MUTATOR CODE: «{wodelStochasticMutatorGenerator = new WodelGeneratorRemoveCompleteReferenceMutator(); ""}»
		«ENDIF»
			//GENERATE CORRESPONDING CODE: «wodelStochasticMutatorGenerator.apply(mut, methodName, nMutation, nRegistryMutation, program, project, className, standalone)»
			return mutations;	
		}
		«ELSE»
		«IF standalone == false»
		private int «methodName»(List<EPackage> packages, List<Resource> models,
					Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
					Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList,
					Map<String, String> hashmapModelFilenames, String modelFilename, List<String> mutPaths,
					Map<String, EObject> hmMutator, Resource seed, Map<String, EPackage> registeredPackages, Map<String, EPackage> localRegisteredPackages,
					Map<String, String> hashmapModelFolders, String ecoreURI, boolean registry,
					Set<String> hashsetMutantsBlock, List<String> fromNames, Map<String,
					List<String>> hashmapMutVersions, Mutations muts, IProject project, IProgressMonitor monitor, int[] k, boolean serialize, IWodelTest test, Map<String, List<String>> classes)
					throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException,
					ObjectNotContainedException, ObjectNoTargetableException, AbstractCreationException, WrongAttributeTypeException, IOException {
		«ELSE»
		private int «methodName»(List<EPackage> packages, List<Resource> models,
					Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
					Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList,
					Map<String, String> hashmapModelFilenames, String modelFilename, List<String> mutPaths,
					Map<String, EObject> hmMutator, Resource seed, Map<String, EPackage> registeredPackages, Map<String, EPackage> localRegisteredPackages,
					Map<String, String> hashmapModelFolders, String ecoreURI, boolean registry,
					Set<String> hashsetMutantsBlock, List<String> fromNames, Map<String,
					List<String>> hashmapMutVersions, Mutations muts, IProgressMonitor monitor, int[] k, boolean serialize, IWodelTest test, Map<String, List<String>> classes)
					throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException,
					ObjectNotContainedException, ObjectNoTargetableException, AbstractCreationException, WrongAttributeTypeException, IOException {
		«ENDIF»
		int numMutantsGenerated = 0;
		«IF mut instanceof ModifyInformationMutator»
			//MODIFY INFORMATION EXHAUSTIVE MUTATOR CODE: «{wodelExhaustiveMutatorGenerator = new WodelGeneratorModifyInformationExhaustiveMutator(); ""}»
		«ENDIF»
		«IF mut instanceof CreateObjectMutator»
			//CREATE OBJECT EXHAUSTIVE MUTATOR CODE: «{wodelExhaustiveMutatorGenerator = new WodelGeneratorCreateObjectExhaustiveMutator(); ""}»
		«ENDIF»
		«IF mut instanceof SelectObjectMutator»
			//SELECT OBJECT EXHAUSTIVE MUTATOR CODE: «{wodelExhaustiveMutatorGenerator = new WodelGeneratorSelectObjectExhaustiveMutator(); ""}»
		«ENDIF»
		«IF mut instanceof SelectSampleMutator»
			//SELECT SAMPLE EXHAUSTIVE MUTATOR CODE: «{wodelExhaustiveMutatorGenerator = new WodelGeneratorSelectSampleExhaustiveMutator(); ""}»
		«ENDIF»
		«IF mut instanceof CloneObjectMutator»
			//CLONE OBJECT EXHAUSTIVE MUTATOR CODE: «{wodelExhaustiveMutatorGenerator = new WodelGeneratorCloneObjectExhaustiveMutator(); ""}»
		«ENDIF»
		«IF mut instanceof RetypeObjectMutator»
			//RETYPE OBJECT EXHAUSTIVE MUTATOR CODE: «{wodelExhaustiveMutatorGenerator = new WodelGeneratorRetypeObjectExhaustiveMutator(); ""}»
		«ENDIF»
		«IF mut instanceof ModifySourceReferenceMutator»
			//MODIFY SOURCE REFERENCE EXHAUSTIVE MUTATOR CODE: «{wodelExhaustiveMutatorGenerator = new WodelGeneratorModifySourceReferenceExhaustiveMutator(); ""}»
		«ENDIF»
		«IF mut instanceof ModifyTargetReferenceMutator»
			//MODIFY TARGET REFERENCE EXHAUSTIVE MUTATOR CODE: «{wodelExhaustiveMutatorGenerator = new WodelGeneratorModifyTargetReferenceExhaustiveMutator(); ""}»
		«ENDIF»
		«IF mut instanceof CreateReferenceMutator»
			//CREATE REFERENCE EXHAUSTIVE MUTATOR CODE: «{wodelExhaustiveMutatorGenerator = new WodelGeneratorCreateReferenceExhaustiveMutator(); ""}»
		«ENDIF»
		«IF mut instanceof RemoveObjectMutator»
			//REMOVE OBJECT EXHAUSTIVE MUTATOR CODE: «{wodelExhaustiveMutatorGenerator = new WodelGeneratorRemoveObjectExhaustiveMutator(); ""}»
		«ENDIF»
		«IF mut instanceof RemoveRandomReferenceMutator»
			//REMOVE RANDOM REFERENCE EXHAUSTIVE MUTATOR CODE: «{wodelExhaustiveMutatorGenerator = new WodelGeneratorRemoveRandomReferenceExhaustiveMutator(); ""}»
		«ENDIF»
		«IF mut instanceof RemoveSpecificReferenceMutator»
			//REMOVE SPECIFIC REFERENCE EXHAUSTIVE MUTATOR CODE: «{wodelExhaustiveMutatorGenerator = new WodelGeneratorRemoveSpecificReferenceExhaustiveMutator(); ""}»
		«ENDIF»
		«IF mut instanceof RemoveCompleteReferenceMutator»
			//REMOVE COMPLETE REFERENCE EXHAUSTIVE MUTATOR CODE: «{wodelExhaustiveMutatorGenerator = new WodelGeneratorRemoveCompleteReferenceExhaustiveMutator(); ""}»
		«ENDIF»
			//GENERATE CORRESPONDING CODE: «wodelExhaustiveMutatorGenerator.apply(mut, e, b, methodName, nMutation, nMethodCall, nRegistryMutation, nRegistryMethodCall, executeMutation, last, className, fileURI, program, project, standalone)»
			return numMutantsGenerated;
	}
		«ENDIF»
	'''
	
	def compositeMethod(CompositeMutator mut, boolean exhaustive)'''
		«IF mut.eContainer instanceof MutatorEnvironment»
		//INC COUNTER: «nMutation.set(0, nMutation.get(0) + 1)»
		//INC COUNTER: «nRegistryMutation.set(0, nRegistryMutation.get(0) + 1)»
		«ENDIF»
		«IF standalone == false»
		private List<Mutator> «compositeMethodName»(List<EPackage> packages, List<Resource> models, Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects, Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList, boolean serialize, IWodelTest test, Map<String, List<String>> classes) throws ReferenceNonExistingException {
		«ELSE»
		private List<Mutator> «compositeMethodName»(List<EPackage> packages, List<Resource> models, Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects, Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList, boolean serialize, IWodelTest test, Map<String, List<String>> classes) throws ReferenceNonExistingException {
		«ENDIF»
			List<Mutator> mutations = new ArrayList<Mutator>();
			«var int localNCompositeMethod = nCompositeMethod.get(0) + 1»
			«var int localNMethod = nMethod.get(0) + 1»
			«FOR c : mut.commands»
			«IF c instanceof CompositeMutator»
				//COMMAND: «nCompositeCommands.set(0, nCompositeCommands.get(0)) + 1»
				«IF c.fixed == 0»
				«IF (c.max - c.min > 0)»
				int cmax«nCompositeCommands.get(0)» = getRandom(«c.max - c.min») + «c.min»;
				«ENDIF»
				«IF (c.min == 0) && (c.max == 0)»
				int cmax«nCompositeCommands.get(0)» = 1;
				«ELSEIF (c.min == c.max)»
				int cmax«nCompositeCommands.get(0)» = «c.min»;
				«ENDIF»
				«ELSE»
				int cmax«nCompositeCommands.get(0)» = «c.fixed»;
				«ENDIF»
				for (int j«nCompositeCommands.get(0)» = 0; j«nCompositeCommands.get(0)» < cmax«nCompositeCommands.get(0)»; j«nCompositeCommands.get(0)»++) {
					//COMPOSITE METHOD NAME:«compositeMethodName = "compositeMutation" + localNCompositeMethod.toString()»
					List<Mutator> l«compositeMethodName» = «compositeMethodName»(packages, models, hmObjects, hmList);
					//COMPOSITE METHOD INC: «localNCompositeMethod++»
					if (l«compositeMethodName» != null) {
						if (l«compositeMethodName».size() > 0) {
							mutations.addAll(l«compositeMethodName»);
						}
					}
				}
				//COMPOSITE METHOD INC: «localNCompositeMethod += MutatorUtils.compositeMutatorSize(c) - 1»
			«ELSE»
			//COMMAND: «nCommands.set(0, nCommands.get(0) + 1)»
			«IF c.fixed == 0»
			«IF (c.max - c.min > 0)»
			int max«nCommands.get(0)» = getRandom(«c.max - c.min») + «c.min»;
			«ENDIF»
			«IF (c.max == 0) && (c.min == 0)»
			int max«nCommands.get(0)» = 1;
			«ELSEIF (c.min == c.max)»
			int max«nCommands.get(0)» = «c.min»;
			«ENDIF»
			«ELSE»
			int max«nCommands.get(0)» = «c.fixed»;
			«ENDIF»
			for (int j = 0; j < max«nCommands.get(0)»; j++) {
				«IF c.name !== null»
				//NAME:«commandName = c.name + nCommands.get(0).toString()»
				«ELSE»
				//NAME:«commandName = nCommands.get(0).toString()»
				«ENDIF»
				//METHOD NAME:«methodName = "mutation" + localNMethod.toString()»
					
				List<Mutator> l«commandName» = «methodName»(packages, models, hmObjects, hmList, serialize, test, classes);
				if (l«commandName» != null) {
					if (l«commandName».size() > 0) {
						mutations.addAll(l«commandName»);
					}
				}
			}
			//METHOD INC: «localNMethod++»
			«ENDIF»
			«ENDFOR»
			return mutations;	
		}
	'''
	def Object generateMethods(Mutator mut, boolean exhaustive, MutatorEnvironment e, Block b, boolean last) '''
		«IF mut instanceof CompositeMutator»
			//COUNTER COMPOSITE: «nCompositeMethod.set(0, nCompositeMethod.get(0) + 1)»
			//COMPOSITE METHOD NAME:«compositeMethodName = "compositeMutation" + nCompositeMethod.get(0).toString()»
			«IF compositeCommands === null»
			//CREATION ARRAYLIST NUM COMMANDS: «compositeCommands = new ArrayList<String>()»
			«ENDIF»
			//ADDING NUM COMMANDS: «compositeCommands.add(compositeMethodName)»
			«mut.compositeMethod(exhaustive)»
			«FOR c : mut.commands»
				«(c as Mutator).generateMethods(exhaustive, e, b, last)»
			«ENDFOR»
		«ELSE»
			//COUNTER: «nMethod.set(0, nMethod.get(0) + 1)»
			//METHOD CALL: «nMethodCall.set(0, nMethod.get(0))»
			//METHOD NAME:«methodName = "mutation" + nMethod.get(0).toString()»
			«(mut as Mutator).method(exhaustive, e, b, last)»			
		«ENDIF»
	'''
	def registryMethod(Mutator mut, boolean exhaustive)'''
	«IF standalone == false»
	private AppMutation «registryMethodName»(Mutator mut, Map<String, EObject> hmMutator, Resource seed, Resource mutant, EObject clue, List<String> mutPaths, List<EPackage> packages) {
	«ELSE»
	private AppMutation «registryMethodName»(Mutator mut, Map<String, EObject> hmMutator, Resource seed, Resource mutant, EObject clue, List<String> mutPaths, List<EPackage> packages) {
	«ENDIF»
		AppMutation appMut = null;
	«IF mut instanceof CreateObjectMutator»
		ObjectCreated cMut = AppliedMutationsFactory.eINSTANCE.createObjectCreated();
		EObject foundObject = findEObjectForRegistry(seed, mutant, mut.getObject(), mut.getObjectByID(), mut.getObjectByURI(), mutPaths, packages);
		if (foundObject != null) {
			cMut.getObject().add(foundObject);
		}
		if (hmMutator.get("m«nRegistryMutation.get(0)»") != null) {
			cMut.setDef(hmMutator.get("m«nRegistryMutation.get(0)»"));
			appMut = cMut;
		}
	«ENDIF»
	«IF mut instanceof CloneObjectMutator»
		ObjectCloned cMut = AppliedMutationsFactory.eINSTANCE.createObjectCloned();
		if (mut.getObject() != null) {
			cMut.getObject().add(mut.getObject());
		}
		if (hmMutator.get("m«nRegistryMutation.get(0)»") != null) {
			cMut.setDef(hmMutator.get("m«nRegistryMutation.get(0)»"));
			appMut = cMut;
		}
	«ENDIF»
	«IF mut instanceof RetypeObjectMutator»
		ObjectRetyped rMut = AppliedMutationsFactory.eINSTANCE.createObjectRetyped();
		if (mut.getObject() != null) {
			rMut.getObject().add(mut.getObject());
		}
		EObject foundObject = findEObjectForRegistry(seed, mutant, mut.getRemovedObject(), mut.getObjectByID(), mut.getObjectByURI(), mutPaths, packages);
		if (foundObject != null) {
			rMut.getRemovedObject().add(foundObject);
		}
		rMut.setType(mut.getEType());
		rMut.setNewType(mut.getNewEType());
		if (hmMutator.get("m«nRegistryMutation.get(0)»") != null) {
			rMut.setDef(hmMutator.get("m«nRegistryMutation.get(0)»"));
			appMut = rMut;
		}
	«ENDIF»
	«IF mut instanceof RemoveObjectMutator»
		ObjectRemoved rMut = AppliedMutationsFactory.eINSTANCE.createObjectRemoved();
		/*
		 * Robust fallback for removed objects.
		 *
		 * If the original identity can no longer be reconstructed,
		 * derive the removed EObject directly from seed vs mutant.
		 */
		EObject foundObject = clue;
		if (foundObject == null
		        && seed != null
		        && mutant != null) {
		
		    EMFDiff.ModelDelta delta =
		        EMFDiff.findAddedAndRemovedEObjects(
		            seed,
		            mutant);
		
		    if (delta != null
		            && delta.getRemoved() != null) {
		
		        for (EObject removed :
		                delta.getRemoved()) {
		
		            if (removed == null
		                    || removed.eClass() == null) {
		
		                continue;
		            }
		
		            EClass expectedType =
		                mut.getEType();
		
		            if (expectedType == null) {
		                continue;
		            }
		
		            /*
		             * Exact type or compatible subtype.
		             */
		            if (expectedType == removed.eClass()
		                    || expectedType.isSuperTypeOf(
		                        removed.eClass())) {
		
		                foundObject =
		                    removed;
		
		                break;
		            }
		        }
		    }
		}
		if (foundObject == null) {
			return appMut;
		}
		rMut.getObject().add(foundObject);
		rMut.setType(mut.getEType());
		if (hmMutator.get("m«nRegistryMutation.get(0)»") != null) {
			rMut.setDef(hmMutator.get("m«nRegistryMutation.get(0)»"));
			appMut = rMut;
		}
	«ENDIF»
	«IF mut instanceof CreateReferenceMutator»
		ReferenceCreated rMut = AppliedMutationsFactory.eINSTANCE.createReferenceCreated();
		if (mut.getObject() != null) {
			rMut.getObject().add(mut.getObject());
		}
		if (((CreateReferenceMutator) mut).getReference() != null) {
			rMut.getRef().add(((CreateReferenceMutator) mut).getReference());
			rMut.setRefName(((CreateReferenceMutator) mut).getRefName());
		}
		if (hmMutator.get("m«nRegistryMutation.get(0)»") != null) {
			rMut.setDef(hmMutator.get("m«nRegistryMutation.get(0)»"));
			appMut = rMut;
		}
	«ENDIF»
	«IF mut instanceof RemoveRandomReferenceMutator»
		ReferenceRemoved rMut = AppliedMutationsFactory.eINSTANCE.createReferenceRemoved();
		List<EObject> objects = new ArrayList<EObject>();
		objects.addAll(findEObjectsForRegistry(seed, mutant, mut, mutPaths, packages));
		rMut.getObject().addAll(objects);
		if (((RemoveReferenceMutator) mut).getReference() != null) {
			rMut.getRef().add(((RemoveReferenceMutator) mut).getReference());
			rMut.setRefName(((RemoveReferenceMutator) mut).getRefName());
		}
		if (hmMutator.get("m«nRegistryMutation.get(0)»") != null) {
			rMut.setDef(hmMutator.get("m«nRegistryMutation.get(0)»"));
			appMut = rMut;
		}
	«ENDIF»
	«IF mut instanceof RemoveSpecificReferenceMutator»
		ReferenceRemoved rMut = AppliedMutationsFactory.eINSTANCE.createReferenceRemoved();
		List<EObject> objects = new ArrayList<EObject>();
		objects.addAll(findEObjectsForRegistry(seed, mutant, mut, mutPaths, packages));
		rMut.getObject().addAll(objects);
		if (((RemoveReferenceMutator) mut).getReference() != null) {
			rMut.getRef().add(((RemoveReferenceMutator) mut).getReference());
			rMut.setRefName(((RemoveReferenceMutator) mut).getRefName());
		}
		if (hmMutator.get("m«nRegistryMutation.get(0)»") != null) {
			rMut.setDef(hmMutator.get("m«nRegistryMutation.get(0)»"));
			appMut = rMut;
		}
	«ENDIF»
	«IF mut instanceof RemoveCompleteReferenceMutator»
		ReferenceRemoved rMut = AppliedMutationsFactory.eINSTANCE.createReferenceRemoved();
		List<EObject> objects = new ArrayList<EObject>();
		objects.addAll(findEObjectsForRegistry(seed, mutant, mut, mutPaths, packages));
		rMut.getObject().addAll(objects);
		if (((RemoveReferenceMutator) mut).getReference() != null) {
			rMut.getRef().add(((RemoveReferenceMutator) mut).getReference());
			rMut.setRefName(((RemoveReferenceMutator) mut).getRefName());
		}
		if (hmMutator.get("m«nRegistryMutation.get(0)»") != null) {
			rMut.setDef(hmMutator.get("m«nRegistryMutation.get(0)»"));
			appMut = rMut;
		}
	«ENDIF»
	«IF mut instanceof ModifyInformationMutator»
			InformationChanged icMut = AppliedMutationsFactory.eINSTANCE.createInformationChanged();
			ModifyInformationMutator mutator = (ModifyInformationMutator) mut;
			//Resource mutant = mutator.getModel();
			icMut.setObject(mut.getObject());
		«IF (mut as ModifyInformationMutator).attributes.size > 0»
			EList<AttributeChanged> attsMut = icMut.getAttChanges();
			Object oldAttVal = null;
			Object newAttVal = null;
			//ATTRIBUTE COUNTER: «var attCounter = 0»
		«FOR AttributeSet att : (mut as ModifyInformationMutator).attributes»
			//«var EAttribute eattfirst = att.attribute.get(0)»
			//«var EAttribute eattsec = eattfirst»
			«IF att instanceof AttributeScalar»
			AttributeChanged attMut«attCounter» = null;
			attMut«attCounter» = AppliedMutationsFactory.eINSTANCE.createAttributeChanged();
			attMut«attCounter».setAttName("«eattfirst.name»");
			«ENDIF»
			«IF att instanceof AttributeOperation»
			AttributeChanged attMut«attCounter» = null;
			attMut«attCounter» = AppliedMutationsFactory.eINSTANCE.createAttributeChanged();
			attMut«attCounter».setAttName("«eattfirst.name»");
			«ENDIF»
			«IF att instanceof AttributeSwap»
			//«eattsec = att.attribute.get(1)»
			appliedMutations.AttributeSwap attMut«attCounter» = null;
			attMut«attCounter» = AppliedMutationsFactory.eINSTANCE.createAttributeSwap();
			attMut«attCounter».setFirstName("«eattsec.name»");
			EObject otherObject = null;
			if (mutator.getOtherObject() != null) {
				otherObject = ModelManager.getObject(seed, mutator.getOtherObject());
				if (otherObject == null) {
					otherObject = ModelManager.getObject(mutant, mutator.getOtherObject());
				}
				if (otherObject != null) {
					attMut«attCounter».setAttObject(otherObject);
				}
			}
			attMut«attCounter».setAttName("«eattfirst.name»");
			«ENDIF»
			«IF att instanceof AttributeCopy»
			//«eattsec = att.attribute.get(1)»
			AttributeChanged attMut«attCounter» = null;
			attMut«attCounter» = AppliedMutationsFactory.eINSTANCE.createAttributeChanged();
			attMut«attCounter».setAttName("«eattfirst.name»");
			«ENDIF»
			«IF att instanceof AttributeUnset»
			AttributeChanged attMut«attCounter» = null;
			attMut«attCounter» = AppliedMutationsFactory.eINSTANCE.createAttributeChanged();
			attMut«attCounter».setAttName("«eattfirst.name»");
			«ENDIF»
			«IF att instanceof AttributeReverse»
			AttributeChanged attMut«attCounter» = null;
			attMut«attCounter» = AppliedMutationsFactory.eINSTANCE.createAttributeChanged();
			attMut«attCounter».setAttName("«eattfirst.name»");
			«ENDIF»
			oldAttVal = mutator.getOldAttValue("«eattfirst.name»");
			newAttVal = mutator.getNewAttValue("«eattfirst.name»");
			if (oldAttVal != null) {
				attMut«attCounter».setOldVal(oldAttVal.toString());
			}
			if (newAttVal != null) {
				attMut«attCounter».setNewVal(newAttVal.toString());
			}
			if (hmMutator.get("m«nRegistryMutation.get(0)»") != null) {
				attMut«attCounter».setDef(hmMutator.get("m«nRegistryMutation.get(0)»"));
				attsMut.add(attMut«attCounter»);
				icMut.setDef(hmMutator.get("m«nRegistryMutation.get(0)»"));
			}
			else {
				attMut«attCounter» = null;
				icMut = null;
			}
			//ATTRIBUTE COUNTER INC: «attCounter++»
		«ENDFOR»
		«ENDIF»
		«IF (mut as ModifyInformationMutator).references.size > 0»
			EList<ReferenceChanged> refsMut = icMut.getRefChanges();
			EObject previous = null;
			EObject next = null;
			//REFERENCE COUNTER: «var refCounter = 0»
		«FOR ReferenceSet ref : (mut as ModifyInformationMutator).references»
			«IF ref instanceof ReferenceInit || ref instanceof ReferenceAdd || ref instanceof ReferenceRemove || ref instanceof ReferenceUnset»
			//«var EReference eref = ref.reference.get(0)»
			ReferenceChanged refMut«refCounter» = null;
			refMut«refCounter» = AppliedMutationsFactory.eINSTANCE.createReferenceChanged();
			refMut«refCounter».setRefName("«eref.name»");
			refMut«refCounter».getObject().add(mutator.getObject());
			refMut«refCounter».getMutantObject().add(mutator.getObject());
			refMut«refCounter».setFrom(mutator.getPrevious("«ref.reference.get(0).name»"));
			refMut«refCounter».setTo(mutator.getNext("«ref.reference.get(0).name»"));
			«ENDIF»
			«IF ref instanceof ReferenceSwap»
			//«var ereffirst = ref.reference.get(0)»
			//«var erefsec = ref.reference.get(1)»
			appliedMutations.ReferenceSwap refMut«refCounter» = null;
			refMut«refCounter» = AppliedMutationsFactory.eINSTANCE.createReferenceSwap();
			refMut«refCounter».setFirstName("«ereffirst.name»");
			EObject refObject = null;
			if (mutator.getRefObject() != null) {
				refObject = ModelManager.getObject(seed, mutator.getRefObject());
				if (refObject == null) {
					refObject = ModelManager.getObject(mutant, mutator.getRefObject());
				}
				if (refObject != null) {
					refMut«refCounter».setRefObject(refObject);
				}
			}
			refMut«refCounter».setRefName("«erefsec.name»");
			refMut«refCounter».setOtherFrom(mutator.getOtherSource("«ereffirst.name»"));
			refMut«refCounter».setOtherFromName(mutator.getOtherSourceName("«ereffirst.name»"));
			refMut«refCounter».setOtherTo(mutator.getOtherTarget("«ereffirst.name»"));
			refMut«refCounter».setOtherToName(mutator.getOtherTargetName("«ereffirst.name»"));
			«ENDIF»
			«IF ref instanceof ReferenceAtt»
			//«var att = ref.attribute»
			appliedMutations.ReferenceAtt refMut«refCounter» = null;
			refMut«refCounter» = AppliedMutationsFactory.eINSTANCE.createReferenceAtt();
			refMut«refCounter».setAttName("«att.name»");
			EObject refAttObject = null;
			if (mutator.getRefAttObject() != null) {
				refAttObject = ModelManager.getObject(seed, mutator.getRefAttObject());
				if (refAttObject == null) {
					refAttObject = ModelManager.getObject(mutant, mutator.getRefAttObject());
				}
				if (refAttObject != null) {
					refMut«refCounter».getObject().add(refAttObject);
				}
			}
			refMut«refCounter».setRefName("«ref.reference.get(0).name»");
			Object oldRefAttVal«refCounter» = null;
			Object newRefAttVal«refCounter» = null;
			if (((ModifyInformationMutator) mut).getOldRefAttValue("«att.name»") != null) {
				oldRefAttVal«refCounter» = mutator.getOldRefAttValue("«att.name»");
			}
			if (((ModifyInformationMutator) mut).getNewRefAttValue("«att.name»") != null) {
				newRefAttVal«refCounter» = mutator.getNewRefAttValue("«att.name»");
			}
			if (oldRefAttVal«refCounter» != null) {
				refMut«refCounter».setOldVal(oldRefAttVal«refCounter».toString());
			}
			if (newRefAttVal«refCounter» != null) {
				refMut«refCounter».setNewVal(newRefAttVal«refCounter».toString());
			}
			if (hmMutator.get("m«nRegistryMutation.get(0)»") != null) {
				refMut«refCounter».setDef(hmMutator.get("m«nRegistryMutation.get(0)»"));
			}
			«ENDIF»
			if (hmMutator.get("m«nRegistryMutation.get(0)»") != null) {
				previous = mutator.getPrevious("«ref.reference.get(0).name»");
				next = mutator.getNext("«ref.reference.get(0).name»");
				if (previous != null) {
					refMut«refCounter».setFrom(previous);
					refMut«refCounter».setMutantFrom(previous);
				}
				if (next != null) {
					refMut«refCounter».setTo(next);
					refMut«refCounter».setMutantTo(next);
				}
				refMut«refCounter».setSrcRefName(mutator.getSrcRefType());
				refMut«refCounter».setDef(hmMutator.get("m«nRegistryMutation.get(0)»"));
				refsMut.add(refMut«refCounter»);
				icMut.setDef(hmMutator.get("m«nRegistryMutation.get(0)»"));
			}
			else {
				refMut«refCounter» = null;
				icMut = null;
			}
			//REFERENCE COUNTER INC: «refCounter++»
		«ENDFOR»
		«ENDIF»
			appMut = icMut;
	«ENDIF»
	«IF mut instanceof ModifySourceReferenceMutator»
			SourceReferenceChanged srcMut = AppliedMutationsFactory.eINSTANCE.createSourceReferenceChanged();
			srcMut.getObject().add(mut.getObject());
			srcMut.setFrom(((ModifySourceReferenceMutator) mut).getSource());
			srcMut.setTo(((ModifySourceReferenceMutator) mut).getNewSource());
			srcMut.setRefName(((ModifySourceReferenceMutator) mut).getRefType());
			if (hmMutator.get("m«nRegistryMutation.get(0)»") != null) {
				srcMut.setDef(hmMutator.get("m«nRegistryMutation.get(0)»"));
				appMut = srcMut;
			}
	«ENDIF»
	«IF mut instanceof ModifyTargetReferenceMutator»
			TargetReferenceChanged trcMut = AppliedMutationsFactory.eINSTANCE.createTargetReferenceChanged();
			ModifyTargetReferenceMutator mutator = (ModifyTargetReferenceMutator) mut;
			//Resource mutant = mutator.getModel();
			EObject object = ModelManager.getObject(seed, mutator.getObject());
			if (object == null) {
				object = ModelManager.getObject(mutant, mutator.getObject());
			}
			if (object != null) {
				trcMut.getObject().add(object);
			}
			EObject from = ModelManager.getObject(seed, mutator.getSource());
			if (from == null) {
				from = ModelManager.getObject(mutant, mutator.getSource());
			}
			if (from != null) {
				trcMut.setFrom(from);
			}
			trcMut.setSrcRefName(mutator.getSrcRefType());
			EObject to = ModelManager.getObject(seed, mutator.getNewTarget());
			if (to == null) {
				to = ModelManager.getObject(mutant, mutator.getNewTarget());
			}
			if (to != null) {
				trcMut.setTo(to);
			}
			EObject oldTo = ModelManager.getObjectByURIEnding(seed, mutator.getOldTargetURI());
			if (oldTo == null) {
				oldTo = ModelManager.getObjectByURIEnding(mutant, mutator.getOldTargetURI());
			}
			if (oldTo != null) {
				trcMut.setOldTo(oldTo);
			}
			trcMut.setRefName(mutator.getRefType());
			if (hmMutator.get("m«nRegistryMutation.get(0)»") != null) {
				trcMut.setDef(hmMutator.get("m«nRegistryMutation.get(0)»"));
				appMut = trcMut;
			}
	«ENDIF»
	«IF mut instanceof SelectObjectMutator»
		if (hmMutator.get("m«nRegistryMutation.get(0)»") != null) {
			appMut = AppliedMutationsFactory.eINSTANCE.createAppMutation();
			appMut.setDef(hmMutator.get("m«nRegistryMutation.get(0)»"));
		}
	«ENDIF»
	«IF mut instanceof SelectSampleMutator»
		if (hmMutator.get("m«nRegistryMutation.get(0)»") != null) {
			appMut = AppliedMutationsFactory.eINSTANCE.createAppMutation();
			appMut.setDef(hmMutator.get("m«nRegistryMutation.get(0)»"));
		}
	«ENDIF»
		return appMut;
	}
   '''
   
   	def compositeRegistryMethod(CompositeMutator mut, boolean exhaustive)'''
   	«IF mut.eContainer instanceof MutatorEnvironment»
	//LOCAL COPY REGISTRY COUNTER: «var int localNRegistryMutation = nRegistryMutation.get(0)»
	«IF standalone == false»
	private AppMutation «compositeRegistryMethodName»(List<Mutator> muts, Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmMutator, Resource seed, boolean serialize, IWodelTest test, Map<String, List<String>> classes) {
	«ELSE»
	private AppMutation «compositeRegistryMethodName»(List<Mutator> muts, Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmMutator, Resource seed, boolean serialize, IWodelTest test, Map<String, List<String>> classes) {
	«ENDIF»
		CompositeMutation appMut = AppliedMutationsFactory.eINSTANCE.createCompositeMutation();
		appMut.setSize(«MutatorUtils.mutatorSize(mut)»);
		List<AppMutation> appMuts = new ArrayList<AppMutation>();
		«var int localNRegistryMethod = nRegistryMethod.get(0) + 1»
		«var int mutCounter = 0»
		«FOR c : mut.commands»
		//REGISTRY METHOD NAME:«registryMethodName = "registry" + localNRegistryMethod.toString()»
		//REGISTRY COUNTER INC: «localNRegistryMutation++»
		AppMutation appMut«mutCounter + 1» = «registryMethodName»(muts.get(«mutCounter»), hmMutator, seed, null, null);
		if (hmMutator.get("m«nRegistryMutation.get(0)»") != null) {
			appMut«mutCounter + 1».setDef(hmMutator.get("m«localNRegistryMutation»"));
			appMuts.add(appMut«mutCounter + 1»);
			//REGISTRY METHOD INC: «localNRegistryMethod++»
			//COUNTER: «mutCounter++»
		}
		«ENDFOR»
		if (hmMutator.get("m«nRegistryMutation.get(0)»") != null) {
			appMut.getMuts().addAll(appMuts);
			appMut.setDef(hmMutator.get("m«nRegistryMutation.get(0)»"));
		}
		else {
			appMut = null;
		}
		return appMut;
	}
	«ENDIF»
   '''
	def Object generateRegistryMethods(Mutator mut, boolean exhaustive) '''
		«IF mut instanceof CompositeMutator»
			//COUNTER COMPOSITE REGISTRY: «nCompositeRegistryMethod.set(0, nCompositeRegistryMethod.get(0) + 1)»
			//COMPOSITE REGISTRY METHOD NAME:«compositeRegistryMethodName = "compositeRegistry" + nCompositeRegistryMethod.get(0).toString()»
			«IF compositeRegistryCommands === null»
			//CREATION ARRAYLIST NUM REGISTRY COMMANDS: «compositeRegistryCommands = new ArrayList<String>()»
			«ENDIF»
			//ADDING NUM COMMANDS: «compositeRegistryCommands.add(compositeRegistryMethodName)»
			«mut.compositeRegistryMethod(exhaustive)»
			«FOR c : mut.commands»
				«c.generateRegistryMethods(exhaustive)»
			«ENDFOR»
			//COUNTER REGISTRY: «nRegistryMethod.set(0, nRegistryMethod.get(0) + MutatorUtils.mutatorSize(mut))»
		«ELSE»
			//COUNTER: «nRegistryMethod.set(0, nRegistryMethod.get(0) + 1)»
			//METHOD NAME:«registryMethodName = "registry" + nRegistryMethod.get(0).toString()»
			«mut.registryMethod(exhaustive)»			
		«ENDIF»
	'''
	
	def generateBlock(Block b,
		boolean exhaustive
	) '''
		//SAVE COUNTER: «var int localNMethod = nMethod.get(0)»
		//SAVE COUNTER: «var int localNCompositeMethod = nCompositeMethod.get(0)»
		//SAVE COUNTER: «var int localNMutation = nMutation.get(0)»
		//SAVE COUNTER: «var int localNRegistryMutation = nRegistryMutation.get(0)»
		//SAVE COUNTER: «var int localNRegistryMethod = nRegistryMethod.get(0)»
		//SAVE COUNTER: «var int localNRegistryMethodCall = nRegistryMethodCall.get(0)»
		//SAVE COUNTER: «var int localNCompositeRegistryMethod = nCompositeRegistryMethod.get(0)»
		//SAVE COUNTER: «var int localNCompositeCommands = nCompositeCommands.get(0)»
		«FOR c : b.commands»
			«c.generateMethods(exhaustive, b.eContainer as MutatorEnvironment, b, EcoreUtil.equals(c, b.commands.get(b.commands.size() - 1)))»
			«c.generateRegistryMethods(exhaustive)»
		«ENDFOR»
		«IF standalone == false»
		public int block_«b.name»(int maxAttempts, int numMutants, boolean registry, List<EPackage> packages, Map<String, EPackage> registeredPackages, Map<String, EPackage> localRegisteredPackages, List<String> fromNames, Map<String, Set<String>> hashmapMutants, Map<String, List<String>> hashmapMutVersions, IProject project, IProgressMonitor monitor, int[] k, boolean serialize, IWodelTest test, Map<String, List<String>> classes, long executionSeed) throws ReferenceNonExistingException, WrongAttributeTypeException, 
												  MaxSmallerThanMinException, AbstractCreationException, ObjectNoTargetableException, 
												  ObjectNotContainedException, MetaModelNotFoundException, ModelNotFoundException, IOException {
		«ELSE»
		public int block_«b.name»(int maxAttempts, int numMutants, boolean registry, List<EPackage> packages, Map<String, EPackage> registeredPackages, Map<String, EPackage> localRegisteredPackages, List<String> fromNames, Map<String, Set<String>> hashmapMutants, Map<String, List<String>> hashmapMutVersions, IProgressMonitor monitor, int[] k, boolean serialize, IWodelTest test, Map<String, List<String>> classes, long executionSeed) throws ReferenceNonExistingException, WrongAttributeTypeException, 
												  MaxSmallerThanMinException, AbstractCreationException, ObjectNoTargetableException, 
												  ObjectNotContainedException, MetaModelNotFoundException, ModelNotFoundException, IOException {
		«ENDIF»
		int numMutantsGenerated = 0;
		if (maxAttempts <= 0) {
			maxAttempts = 1;
		}
		MutatorUtils.beginRegistryLookupResources();
		try {
		//TEMP COUNTER: «var int tempNMethod = nMethod.get(0)»
		//TEMP COUNTER: «var int tempNCompositeMethod = nCompositeMethod.get(0)»
		//TEMP COUNTER: «var int tempNMutation = nMutation.get(0)»
		//TEMP COUNTER: «var int tempNRegistryMutation = nRegistryMutation.get(0)»
		//TEMP COUNTER: «var int tempNRegistryMethod = nRegistryMethod.get(0)»
		//TEMP COUNTER: «var int tempNRegistryMethodCall = nRegistryMethodCall.get(0)»
		//TEMP COUNTER: «var int tempNCompositeRegistryMethod = nCompositeRegistryMethod.get(0)»
		//TEMP COUNTER: «var int tempNCompositeCommands = nCompositeCommands.get(0)»
		//RESET COUNTER: «nMethod.set(0, localNMethod)»
		//RESET COUNTER: «nCompositeMethod.set(0, localNCompositeMethod)»
		//RESET COUNTER: «nMutation.set(0, localNMutation)»
		//RESET COUNTER: «nRegistryMutation.set(0, localNRegistryMutation)»
		//RESET COUNTER: «nRegistryMethod.set(0, localNRegistryMethod)»
		//RESET COUNTER: «nRegistryMethodCall.set(0, localNRegistryMethodCall)»
		//RESET COUNTER: «nCompositeRegistryMethod.set(0, localNCompositeRegistryMethod)»
		//RESET COUNTER: «nCompositeCommands.set(0, localNCompositeCommands)»
		//«var e = b.eContainer as MutatorEnvironment»
		«IF e.definition instanceof Program»
		«e.multipleBlock(b)»
		«ENDIF»
		//RESTORE COUNTER: «nMethod.set(0, tempNMethod)»
		//RESTORE COUNTER: «nCompositeMethod.set(0, tempNCompositeMethod)»
		//RESTORE COUNTER: «nMutation.set(0, tempNMutation)»
		//RESTORE COUNTER: «nRegistryMutation.set(0, tempNRegistryMutation)»
		//RESTORE COUNTER: «nRegistryMethod.set(0, tempNRegistryMethod)»
		//RESTORE COUNTER: «nRegistryMethodCall.set(0, tempNRegistryMethodCall)»
		//RESTORE COUNTER: «nCompositeRegistryMethod.set(0, tempNCompositeRegistryMethod)»
		//RESTORE COUNTER: «nCompositeCommands.set(0, tempNCompositeCommands)»
		}
		finally {
		        MutatorUtils.endRegistryLookupResources();
		}
		return numMutantsGenerated;
	}
	'''
	

	/**
	 * Computes execution levels for mutation blocks.
	 *
	 * Blocks in the same level are independent with respect to the explicit
	 * Wodel "from" relation and can therefore be executed in parallel.
	 * A block is placed one level after its deepest predecessor.
	 */
	def List<List<Block>> getBlockExecutionLevels(MutatorEnvironment e) {
		val List<List<Block>> levels = new ArrayList<List<Block>>()
		val Map<Block, Integer> cache = new LinkedHashMap<Block, Integer>()

		for (Block b : e.blocks) {
			if (b.commands !== null && !b.commands.empty) {
				val int level = getBlockExecutionLevel(b, cache, new ArrayList<Block>())
				while (levels.size <= level) {
					levels.add(new ArrayList<Block>())
				}
				levels.get(level).add(b)
			}
		}
		return levels
	}

	/**
	 * Recursive helper used by getBlockExecutionLevels.
	 * It also protects code generation against circular block dependencies.
	 */
	private def int getBlockExecutionLevel(Block b, Map<Block, Integer> cache, List<Block> visiting) {
		val Integer cached = cache.get(b)
		if (cached !== null) {
			return cached
		}

		if (visiting.contains(b)) {
			val List<Block> cycleBlocks = new ArrayList<Block>(visiting)
			cycleBlocks.add(b)
			val String cycle = cycleBlocks.map[name].join(" -> ")
			throw new IllegalStateException("Circular Wodel block dependency: " + cycle)
		}

		visiting.add(b)
		var int level = 0
		for (Block parent : b.from) {
			level = Math.max(level, getBlockExecutionLevel(parent, cache, visiting) + 1)
		}
		visiting.remove(b)
		cache.put(b, level)
		return level
	}

	def compile(MutatorEnvironment e, IProject project, String mutatorName) ''' 

//«this.project = project !== null ? project : ProjectUtils.project»
package mutator.«className»;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import wodel.utils.manager.IWodelTest;
import wodel.utils.manager.ModelManager;
import wodel.utils.manager.MutatorMetricsGenerator;
import wodel.utils.manager.DebugMutatorMetricsGenerator;
import wodel.utils.manager.NetMutatorMetricsGenerator;

import org.eclipse.core.resources.IProject;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;

import appliedMutations.*;
import wodel.utils.commands.*;
import wodel.utils.commands.selection.strategies.*;
import wodel.utils.commands.strategies.*;

import wodel.utils.exceptions.AbstractCreationException;
import wodel.utils.exceptions.MaxSmallerThanMinException;
import wodel.utils.exceptions.MetaModelNotFoundException;
import wodel.utils.exceptions.ModelNotFoundException;
import wodel.utils.exceptions.ObjectNoTargetableException;
import wodel.utils.exceptions.ObjectNotContainedException;
import wodel.utils.exceptions.ReferenceNonExistingException;
import wodel.utils.exceptions.WrongAttributeTypeException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.common.util.EList;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;

import wodel.utils.manager.MutatorUtils;
import wodel.utils.manager.MutatorUtils.OwnedResourceScope;
import wodel.utils.manager.EMFCopier;

import mutatorenvironment.MutatorenvironmentPackage;
import mutatormetrics.MutatormetricsPackage;
import mutatorenvironment.miniOCL.MiniOCLPackage;

import wodel.utils.manager.EMFDiff;
import wodel.utils.manager.EMFDiff.ModelDelta;
import wodel.utils.manager.WodelRandomContext;
import wodel.utils.manager.WodelTempModelContext;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLParserPoolImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceFactoryImpl;
import org.eclipse.emf.ecore.xmi.impl.XMLResourceImpl;

import org.eclipse.emf.ecore.EClass;

import java.util.random.RandomGenerator;
import java.util.Random;

public class «className» extends MutatorUtils {

	«IF standalone == false»
	private Map<Integer, Mutator> overallMutators = new LinkedHashMap<Integer, Mutator>();
	«ELSE»
	private Map<Integer, Mutator> overallMutators = new LinkedHashMap<Integer, Mutator>();
	«ENDIF» 

	«IF standalone == false»
	private List<EObject> mutatedObjects = null;
	«ELSE»
	private List<EObject> mutatedObjects = null;
	«ENDIF»
	
	private static long blockSeed(
	        long executionSeed,
	        String blockName) {
	
	    long value =
	        executionSeed
	        ^ ((long) blockName.hashCode()
	            << 32)
	        ^ blockName.hashCode();
	
	    value ^= value >>> 33;
	    value *= 0xff51afd7ed558ccdL;
	    value ^= value >>> 33;
	    value *= 0xc4ceb9fe1a85ec53L;
	    value ^= value >>> 33;
	
	    return value;
	}
	
	private static void registerPackage(
	        ResourceSet resourceSet,
	        EPackage ePackage) {
	
	    if (ePackage == null) {
	        return;
	    }
	
	    String nsURI =
	        ePackage.getNsURI();
	
	    if (nsURI != null &&
	        !nsURI.isBlank()) {
	
	        resourceSet
	            .getPackageRegistry()
	            .put(
	                nsURI,
	                ePackage);
	    }
	
	    for (EPackage subpackage :
	            ePackage.getESubpackages()) {
	
	        registerPackage(
	            resourceSet,
	            subpackage);
	    }
	}
	
	/**
		 * @param packages
		 *            MetaModel
		 * @param modelURI
		 *            URI of the Model
		 * @return Resource Loaded Model
		 * @throws
		 */
		public static Resource loadModelHeadless(
		        List<EPackage> packages,
		        String strURI) {
		
		    if (strURI == null ||
		        strURI.isBlank()) {
		        return null;
		    }
		
		    File file =
		        new File(strURI);
		
		    if (!file.isFile()) {
		        System.err.println(
		            "Model does not exist: "
		            + file.getAbsolutePath());
		
		        return null;
		    }
		
		    ResourceSet resourceSet =
		        ModelManager.initializeResource(
		            strURI);
		
		    URI uri =
		        URI.createFileURI(
		            file.getAbsolutePath());
		
		    if (packages != null) {
		
		        for (EPackage p : packages) {
		
		            registerPackage(
		                resourceSet,
		                p);
		        }
		    }
		
		    Map<Object, Object> options =
		        resourceSet.getLoadOptions();
		
		    options.put(
		        XMLResource.OPTION_USE_PARSER_POOL,
		        new XMLParserPoolImpl());
		
		    options.put(
		        XMLResource.OPTION_USE_DEPRECATED_METHODS,
		        Boolean.FALSE);
		
		    options.put(
		        XMLResource.OPTION_USE_XML_NAME_TO_FEATURE_MAP,
		        new LinkedHashMap<Object, Object>());
		
		    options.put(
		        XMLResource.OPTION_DEFER_ATTACHMENT,
		        Boolean.TRUE);
		
		    options.put(
		        XMLResource.OPTION_DEFER_IDREF_RESOLUTION,
		        Boolean.TRUE);
		
		    options.put(
		        XMLResource.OPTION_PROCESS_DANGLING_HREF,
		        XMLResource.OPTION_PROCESS_DANGLING_HREF_DISCARD);
		
		    try {
		
		        Resource model =
		            resourceSet.createResource(uri);
		
		        if (model == null) {
		            return null;
		        }
		
		System.err.println(
		    "Loading domain model: " + strURI);
		
		System.err.println(
		    "packages = "
		    + (packages == null ? "null" : packages.size()));
		
		if (packages != null) {
		    for (EPackage p : packages) {
		        System.err.println(
		            "  package: "
		            + p.getName()
		            + " -> "
		            + p.getNsURI());
		
		        resourceSet
		            .getPackageRegistry()
		            .put(
		                p.getNsURI(),
		                p);
		    }
		}
		
		System.err.println(
		    "pythonast registered locally = "
		    + resourceSet
		        .getPackageRegistry()
		        .containsKey(
		            "http://www.python.org/pythonast/3.14"));
		            
		        model.load(options);
		
		        if (!model.getErrors().isEmpty()) {
		
		            for (Resource.Diagnostic error :
		                    model.getErrors()) {
		
		                System.err.println(
		                    "Model load error: "
		                    + error.getMessage());
		            }
		
		            model.unload();
		            return null;
		        }
		
		        return model;
		    }
		    catch (IOException e) {
		
		        System.err.println(
		            "Cannot load model: "
		            + file.getAbsolutePath());
		
		        e.printStackTrace(
		            System.err);
		
		        return null;
		    }
		}
	

		/**
		 * Result produced by one block worker. The maps contain only the changes
		 * introduced by that block, so merging is performed by the coordinator
		 * thread and never concurrently.
		 */
		protected static final class BlockExecutionResult {
			private final String blockName;
			private int numMutantsGenerated;
			private final Map<String, Set<String>> mutantDelta;
			private final Map<String, List<String>> mutantVersionDelta;
	
			public BlockExecutionResult(String blockName,
					int numMutantsGenerated,
					Map<String, Set<String>> mutantDelta,
					Map<String, List<String>> mutantVersionDelta) {
				this.blockName = blockName;
				this.numMutantsGenerated = numMutantsGenerated;
				this.mutantDelta = mutantDelta;
				this.mutantVersionDelta = mutantVersionDelta;
			}
			
			public String getBlockName() {
				return blockName;
			}
			public int getNumMutantsGenerated() {
				return numMutantsGenerated;
			}
			public void setNumMutantsGenerated(int value) {
				numMutantsGenerated = value;
			}
			public Map<String, Set<String>> getMutantDelta() {
				return mutantDelta;
			}
			public Map<String, List<String>> getMutantVersionDelta() {
				return mutantVersionDelta;
			}
			
		}
	
		protected static Map<String, Set<String>> copyMutantMap(Map<String, Set<String>> source) {
			Map<String, Set<String>> copy = new LinkedHashMap<String, Set<String>>();
			for (Map.Entry<String, Set<String>> entry : source.entrySet()) {
				copy.put(entry.getKey(), new LinkedHashSet<String>(entry.getValue()));
			}
			return copy;
		}
	
		protected static Map<String, List<String>> copyMutantVersionMap(Map<String, List<String>> source) {
			Map<String, List<String>> copy = new LinkedHashMap<String, List<String>>();
			for (Map.Entry<String, List<String>> entry : source.entrySet()) {
				copy.put(entry.getKey(), new ArrayList<String>(entry.getValue()));
			}
			return copy;
		}
	
		protected static Map<String, Set<String>> mutantDelta(
				Map<String, Set<String>> before,
				Map<String, Set<String>> after) {
			Map<String, Set<String>> delta = new LinkedHashMap<String, Set<String>>();
			for (Map.Entry<String, Set<String>> entry : after.entrySet()) {
				Set<String> values = new LinkedHashSet<String>(entry.getValue());
				Set<String> oldValues = before.get(entry.getKey());
				if (oldValues != null) {
					values.removeAll(oldValues);
				}
				if (!values.isEmpty()) {
					delta.put(entry.getKey(), values);
				}
			}
			return delta;
		}
	
		protected static Map<String, List<String>> mutantVersionDelta(
				Map<String, List<String>> before,
				Map<String, List<String>> after) {
			Map<String, List<String>> delta = new LinkedHashMap<String, List<String>>();
			for (Map.Entry<String, List<String>> entry : after.entrySet()) {
				List<String> values = new ArrayList<String>(entry.getValue());
				List<String> oldValues = before.get(entry.getKey());
				if (oldValues != null) {
					/* Remove one occurrence for every pre-existing occurrence. */
					for (String oldValue : oldValues) {
						values.remove(oldValue);
					}
				}
				if (!values.isEmpty()) {
					delta.put(entry.getKey(), values);
				}
			}
			return delta;
		}
	
		protected static void mergeMutants(
				Map<String, Set<String>> target,
				Map<String, Set<String>> delta) {
			for (Map.Entry<String, Set<String>> entry : delta.entrySet()) {
				Set<String> values = target.get(entry.getKey());
				if (values == null) {
					values = new LinkedHashSet<String>();
					target.put(entry.getKey(), values);
				}
				values.addAll(entry.getValue());
			}
		}
	
		protected static void mergeMutantVersions(
				Map<String, List<String>> target,
				Map<String, List<String>> delta) {
			for (Map.Entry<String, List<String>> entry : delta.entrySet()) {
				List<String> values = target.get(entry.getKey());
				if (values == null) {
					values = new ArrayList<String>();
					target.put(entry.getKey(), values);
				}
				values.addAll(entry.getValue());
			}
		}
	
		protected static BlockExecutionResult getBlockResult(Future<BlockExecutionResult> future)
				throws ReferenceNonExistingException, WrongAttributeTypeException,
				MaxSmallerThanMinException, AbstractCreationException, ObjectNoTargetableException,
				ObjectNotContainedException, MetaModelNotFoundException, ModelNotFoundException, IOException {
			try {
				return future.get();
			}
			catch (InterruptedException exception) {
				Thread.currentThread().interrupt();
				throw new IOException("Parallel Wodel mutant generation was interrupted.", exception);
			}
			catch (ExecutionException exception) {
				Throwable cause = exception.getCause();
				if (cause instanceof ReferenceNonExistingException) throw (ReferenceNonExistingException) cause;
				if (cause instanceof WrongAttributeTypeException) throw (WrongAttributeTypeException) cause;
				if (cause instanceof MaxSmallerThanMinException) throw (MaxSmallerThanMinException) cause;
				if (cause instanceof AbstractCreationException) throw (AbstractCreationException) cause;
				if (cause instanceof ObjectNoTargetableException) throw (ObjectNoTargetableException) cause;
				if (cause instanceof ObjectNotContainedException) throw (ObjectNotContainedException) cause;
				if (cause instanceof MetaModelNotFoundException) throw (MetaModelNotFoundException) cause;
				if (cause instanceof ModelNotFoundException) throw (ModelNotFoundException) cause;
				if (cause instanceof IOException) throw (IOException) cause;
				if (cause instanceof RuntimeException) throw (RuntimeException) cause;
				if (cause instanceof Error) throw (Error) cause;
				throw new IOException("Error during parallel Wodel mutant generation.", cause);
			}
		}

	public static boolean isBlockSelected(
	        String blockName,
	        String[] blockNames) {

	    return blockNames == null
	        || blockNames.length == 0
	        || Arrays.asList(blockNames)
	                 .contains(blockName);
	}
	
	«IF e.definition instanceof Program»
	//RESET COUNTER: «nMethod.set(0, 0)»
	//RESET COUNTER: «nCompositeMethod.set(0, 0)»
	//RESET COUNTER: «nRegistryMethod.set(0, 0)»
	//RESET COUNTER: «nRegistryMethodCall.set(0, 0)»
	//RESET COUNTER: «nCompositeRegistryMethod.set(0, 0)»
	//RESET COUNTER: «nMutation.set(0, 0)»
	//RESET COUNTER: «nRegistryMutation.set(0, 0)»
	//RESET COUNTER: «nCompositeCommands.set(0, 0)»
   	«IF e.commands.size > 0»
	«FOR c : e.commands»
		«c.generateMethods(((e.definition) as Program).exhaustive, c.eContainer as MutatorEnvironment, null, EcoreUtil.equals(c, e.commands.get(e.commands.size() - 1)))»
		«c.generateRegistryMethods(((e.definition) as Program).exhaustive)»
	«ENDFOR»
	
	@Override
	«IF standalone == false»
	public MutationResults execute(int maxAttempts, int numMutants, boolean registry, boolean metrics, boolean debugMetrics, List<EPackage> packages, Map<String, EPackage> registeredPackages, Map<String, EPackage> localRegisteredPackages, String[] blockNames, IProject project, IProgressMonitor monitor, boolean serialize, IWodelTest test, Map<String, List<String>> classes, long executionSeed) throws ReferenceNonExistingException, WrongAttributeTypeException, 
												  MaxSmallerThanMinException, AbstractCreationException, ObjectNoTargetableException, 
												  ObjectNotContainedException, MetaModelNotFoundException, ModelNotFoundException, IOException {
	«ELSE»
	public MutationResults execute(int maxAttempts, int numMutants, boolean registry, boolean metrics, boolean debugMetrics, List<EPackage> packages, Map<String, EPackage> registeredPackages, Map<String, EPackage> localRegisteredPackages, String[] blockNames, IProgressMonitor monitor, boolean serialize, IWodelTest test, Map<String, List<String>> classes, long executionSeed) throws ReferenceNonExistingException, WrongAttributeTypeException, 
												  MaxSmallerThanMinException, AbstractCreationException, ObjectNoTargetableException, 
												  ObjectNotContainedException, MetaModelNotFoundException, ModelNotFoundException, IOException {
	«ENDIF»
												  	
		MutationResults mutationResults = new MutationResults();

		if (maxAttempts <= 0) {
			maxAttempts = 1;
		}
		int totalTasks = 0;
		if (metrics == true) {
			totalTasks++;
		}
		if (debugMetrics == true) {
			totalTasks++;
		}
		«IF (e.definition as Program).exhaustive == false»
		//«nMut.set(0, (e.definition as Program).num)»
	   	«IF nMut.get(0) != 0»
	   	numMutants = «nMut.get(0)»;
	   	«ENDIF»
	   	«ELSE»
	   	numMutants = -1;
	   	«ENDIF»

	   	int totalMutants = 0;
		Map<String, List<String>> hashmapMutVersions = new LinkedHashMap<String, List<String>>();

		//RESET COUNTER: «nMethod.set(0, 0)»
		//RESET COUNTER: «nCompositeMethod.set(0, 0)»
		//RESET COUNTER: «nMutation.set(0, 0)»
		//RESET COUNTER: «nRegistryMutation.set(0, 0)»
		//RESET COUNTER: «nRegistryMethod.set(0, 0)»
		//RESET COUNTER: «nRegistryMethodCall.set(0, 0)»
		//RESET COUNTER: «nCompositeRegistryMethod.set(0, 0)»
		//RESET COUNTER: «nCompositeCommands.set(0, 0)»
		«IF e.definition instanceof Program»
		«e.multiple»
		«ENDIF»

		//Generate metrics model
	   	String metricsecore = MutatormetricsPackage.class.getProtectionDomain().getCodeSource().getLocation().getPath().replace("/bin/", "/") + "model/MutatorMetrics.ecore";
	   	metricsecore = metricsecore.substring(1, metricsecore.length());

		MutatorMetricsGenerator metricsGenerator = null;
	   	if (metrics == true) {
	   		List<EPackage> metricspackages = ModelManager.loadMetaModel(metricsecore);
	   		monitor.subTask("Generating dynamic net metrics");
	   		«IF standalone == false»
	   		metricsGenerator = new NetMutatorMetricsGenerator(metricspackages, «className».class.getProtectionDomain().getCodeSource().getLocation().getPath().replace("/bin/", "/")+ "«((e as MutatorEnvironment).definition as Program).output»", "«((e as MutatorEnvironment).definition as Program).metamodel»", «className».class.getProtectionDomain().getCodeSource().getLocation().getPath().replace("/bin/", "/")+ "«((e as MutatorEnvironment).definition as Program).source.path»", "«fileURI.lastSegment»", hashmapMutVersions, this.getClass());
	   		«ELSE»
	   		metricsGenerator = new NetMutatorMetricsGenerator(metricspackages, «className».class.getProtectionDomain().getCodeSource().getLocation().getPath().replace("/bin/", "/")+ "«((e as MutatorEnvironment).definition as Program).output»", "«((e as MutatorEnvironment).definition as Program).metamodel»", «className».class.getProtectionDomain().getCodeSource().getLocation().getPath().replace("/bin/", "/")+ "«((e as MutatorEnvironment).definition as Program).source.path»", "«fileURI.lastSegment»", hashmapMutVersions, «className».class);
	   		«ENDIF»
	   		metricsGenerator.run();
	   		monitor.worked(1);
	   	}
	   	if (debugMetrics == true) {
			List<EPackage> metricspackages = ModelManager.loadMetaModel(metricsecore);
	   		monitor.subTask("Generating dynamic debug metrics");
	   		«IF standalone == true»
	   		metricsGenerator = new DebugMutatorMetricsGenerator(metricspackages, «className».class.getProtectionDomain().getCodeSource().getLocation().getPath().replace("/bin/", "/")+ "«((e as MutatorEnvironment).definition as Program).output»", "«((e as MutatorEnvironment).definition as Program).metamodel»", «className».class.getProtectionDomain().getCodeSource().getLocation().getPath().replace("/bin/", "/")+ "«((e as MutatorEnvironment).definition as Program).source.path»", "«fileURI.lastSegment»", hashmapMutVersions, this.getClass());
	   		«ELSE»
	   		metricsGenerator = new DebugMutatorMetricsGenerator(metricspackages, «className».class.getProtectionDomain().getCodeSource().getLocation().getPath().replace("/bin/", "/")+ "«((e as MutatorEnvironment).definition as Program).output»", "«((e as MutatorEnvironment).definition as Program).metamodel»", «className».class.getProtectionDomain().getCodeSource().getLocation().getPath().replace("/bin/", "/")+ "«((e as MutatorEnvironment).definition as Program).source.path»", "«fileURI.lastSegment»", hashmapMutVersions, «className».class);
	   		«ENDIF»
	   		metricsGenerator.run();
	   		monitor.worked(1);   			
	   	}
	   	mutationResults.setNumMutatorsApplied(mutationResults.getNumMutatorsApplied() + 1);
	   	if (mutationResults.getMutatorsApplied() == null) {
	   		mutationResults.setMutatorsApplied(new ArrayList<String>());
	   	}
	   	mutationResults.getMutatorsApplied().add("");
	   	
	   	return mutationResults;
	}
}
	«ENDIF»
	«ENDIF»
	«IF e.blocks.size() > 0»
	//RESET COUNTER: «nMethod.set(0, 0)»
	//RESET COUNTER: «nCompositeMethod.set(0, 0)»
	//RESET COUNTER: «nMutation.set(0, 0)»
	//RESET COUNTER: «nRegistryMutation.set(0, 0)»
	//RESET COUNTER: «nRegistryMethod.set(0, 0)»
	//RESET COUNTER: «nRegistryMethodCall.set(0, 0)»
	//RESET COUNTER: «nCompositeRegistryMethod.set(0, 0)»
	//RESET COUNTER: «nCompositeCommands.set(0, 0)»
	«FOR b : e.blocks»
		«IF b.commands.size() > 0»
			«b.generateBlock((e.definition as Program).exhaustive)»
		«ENDIF»
	«ENDFOR»
	@Override
	«IF standalone == false»
	public MutationResults execute(int maxAttempts, int numMutants, boolean registry, boolean metrics, boolean debugMetrics, List<EPackage> packages, Map<String, EPackage> registeredPackages, Map<String, EPackage> localRegisteredPackages, String[] blockNames, IProject project, IProgressMonitor monitor, boolean serialize, IWodelTest test, Map<String, List<String>> classes, long executionSeed) throws ReferenceNonExistingException, WrongAttributeTypeException, 
												  MaxSmallerThanMinException, AbstractCreationException, ObjectNoTargetableException, 
												  ObjectNotContainedException, MetaModelNotFoundException, ModelNotFoundException, IOException {
	«ELSE»
	public MutationResults execute(int maxAttempts, int numMutants, boolean registry, boolean metrics, boolean debugMetrics, List<EPackage> packages, Map<String, EPackage> registeredPackages, Map<String, EPackage> localRegisteredPackages, String[] blockNames, IProgressMonitor monitor, boolean serialize, IWodelTest test, Map<String, List<String>> classes, long executionSeed) throws ReferenceNonExistingException, WrongAttributeTypeException, 
												  MaxSmallerThanMinException, AbstractCreationException, ObjectNoTargetableException, 
												  ObjectNotContainedException, MetaModelNotFoundException, ModelNotFoundException, IOException {
	«ENDIF»

		MutationResults mutationResults = new MutationResults();

		if (maxAttempts <= 0) {
			maxAttempts = 1;
		}
		final int blockMaxAttempts = maxAttempts;
		final int blockNumMutants = numMutants;

		int totalTasks = «e.blocks.size»;
		if (metrics == true) {
			totalTasks++;
		}
		if (debugMetrics == true) {
			totalTasks++;
		}
		monitor.beginTask("Generating mutants", totalTasks);

		/*
		 * These two maps are owned by the coordinator thread. Worker blocks
		 * receive private copies and return only their deltas. This avoids
		 * concurrent writes to LinkedHashMap/ArrayList/LinkedHashSet.
		 */
		Map<String, Set<String>> hashmapMutants = new LinkedHashMap<String, Set<String>>();
		Map<String, List<String>> hashmapMutVersions = new LinkedHashMap<String, List<String>>();

final List<EPackage> basePackages =
    packages == null
        ? Collections.emptyList()
        : Collections.unmodifiableList(
            new ArrayList<EPackage>(
                packages));
		/*
		 * Java 21: each submitted block runs in its own virtual thread.
		 * Explicit Wodel "from" dependencies are respected by executing one
		 * dependency level at a time and joining the whole level before the
		 * next level is submitted.
		 */
		ExecutorService blockExecutor = Executors.newVirtualThreadPerTaskExecutor();

		try {
			«FOR level : e.blockExecutionLevels»
			/* Dependency level */
			«FOR b : level»
			Future<BlockExecutionResult> future_«b.name» = null;
			if («className».isBlockSelected("«b.name»", blockNames)) {
				monitor.subTask("Scheduling mutant generation for block «b.name»");

				final Map<String, Set<String>> baseMutants_«b.name» =
					copyMutantMap(hashmapMutants);
				final Map<String, List<String>> baseMutantVersions_«b.name» =
					copyMutantVersionMap(hashmapMutVersions);

				future_«b.name» = blockExecutor.submit(() -> {
					    
					RandomGenerator blockRandom =
					            new Random(blockSeed(executionSeed, "«b.name»"));
					
					        WodelRandomContext.set(
					            blockRandom);
					            WodelTempModelContext.begin(
					            «IF standalone == false»
					            				«mutatorName»Dynamic.class,
					            «ELSE»
					                            «mutatorName»Standalone.class,
					            «ENDIF»
					                            "«b.name»",
					                            executionSeed);
					try {
					//«val String metaModel = e.resolveMetaModelPath(project)»
					//String ecoreURI = "«metaModel»";
					//List<EPackage> initialPackages = ModelManager.loadMetaModelNoException("«project.name»", ecoreURI);
					
					
					/*
					 * A fresh generated-mutator instance isolates overallMutators and
					 * mutatedObjects for this block. The standalone helper methods are
					 * deliberately generated as instance methods for the same reason.
					 */
					«className» worker = new «className»();

		/*
         * IMPORTANT:
         * Every parallel block owns its package-list
         * container. Mutation code is allowed to replace
         * its contents without affecting another block.
         */
        List<EPackage> localPackages =
            new ArrayList<EPackage>(
                basePackages);
                
					Map<String, Set<String>> localMutants =
						copyMutantMap(baseMutants_«b.name»);
					Map<String, List<String>> localMutantVersions =
						copyMutantVersionMap(baseMutantVersions_«b.name»);

					List<String> fromNames = new ArrayList<String>();
					«FOR from : b.from»
					fromNames.add("«from.name»");
					«ENDFOR»
					List<String> localFromNames = Collections.unmodifiableList(
					            new ArrayList<String>(
					                fromNames)); 

					int[] k = new int[] { 0 };
					«IF standalone == false»
					int generated = worker.block_«b.name»(
						blockMaxAttempts, blockNumMutants, registry, localPackages,
						registeredPackages, localRegisteredPackages, localFromNames,
						localMutants, localMutantVersions, project,
						new NullProgressMonitor(), k, serialize, test, classes, executionSeed);
					«ELSE»
					int generated = worker.block_«b.name»(
						blockMaxAttempts, blockNumMutants, registry, localPackages,
						registeredPackages, localRegisteredPackages, localFromNames,
						localMutants, localMutantVersions,
						new NullProgressMonitor(), k, serialize, test, classes, executionSeed);
					«ENDIF»
					
					return new BlockExecutionResult(
						"«b.name»",
						generated,
						mutantDelta(baseMutants_«b.name», localMutants),
						mutantVersionDelta(baseMutantVersions_«b.name», localMutantVersions));
					}
					finally {
						WodelTempModelContext.end();
					
					            WodelRandomContext.clear();
					        }
				});
			}
			«ENDFOR»

			/* Join this level before scheduling blocks that depend on it. */
			«FOR b : level»
			if (future_«b.name» != null) {
				BlockExecutionResult blockResult_«b.name» = getBlockResult(future_«b.name»);

				mergeMutants(hashmapMutants, blockResult_«b.name».getMutantDelta());
				mergeMutantVersions(hashmapMutVersions, blockResult_«b.name».getMutantVersionDelta());

				if (blockResult_«b.name».getNumMutantsGenerated() > 0) {
					mutationResults.setNumMutatorsApplied(mutationResults.getNumMutatorsApplied() + 1);
					if (mutationResults.getMutatorsApplied() == null) {
						mutationResults.setMutatorsApplied(new ArrayList<String>());
					}
					mutationResults.getMutatorsApplied().add(blockResult_«b.name».getBlockName());
					mutationResults.setNumMutantsGenerated(mutationResults.getNumMutantsGenerated() + blockResult_«b.name».getNumMutantsGenerated());
				}
				monitor.worked(1);
			}
			«ENDFOR»
			«ENDFOR»
		}
		finally {
			blockExecutor.shutdownNow();
		}

		//Generate metrics model
	   	String metricsecore = MutatormetricsPackage.class.getProtectionDomain().getCodeSource().getLocation().getPath().replace("/bin/", "/") + "model/MutatorMetrics.ecore";
	   	metricsecore = metricsecore.substring(1, metricsecore.length());

		MutatorMetricsGenerator metricsGenerator = null;
		if (metrics == true) {
			List<EPackage> metricspackages = ModelManager.loadMetaModel(metricsecore);
			monitor.subTask("Generating dynamic net metrics");
			«IF standalone == false»
			metricsGenerator = new NetMutatorMetricsGenerator(metricspackages, «className».class.getProtectionDomain().getCodeSource().getLocation().getPath().replace("/bin/", "/")+ "«((e as MutatorEnvironment).definition as Program).output»", "«((e as MutatorEnvironment).definition as Program).metamodel»", «className».class.getProtectionDomain().getCodeSource().getLocation().getPath().replace("/bin/", "/")+ "«((e as MutatorEnvironment).definition as Program).source.path»", "«fileURI.lastSegment»", hashmapMutVersions, this.getClass());
			«ELSE»
			metricsGenerator = new NetMutatorMetricsGenerator(metricspackages, «className».class.getProtectionDomain().getCodeSource().getLocation().getPath().replace("/bin/", "/")+ "«((e as MutatorEnvironment).definition as Program).output»", "«((e as MutatorEnvironment).definition as Program).metamodel»", «className».class.getProtectionDomain().getCodeSource().getLocation().getPath().replace("/bin/", "/")+ "«((e as MutatorEnvironment).definition as Program).source.path»", "«fileURI.lastSegment»", hashmapMutVersions, «className».class);
			«ENDIF»
	   		metricsGenerator.run();
	   		monitor.worked(1);
		}
		if (debugMetrics == true) {
			List<EPackage> metricspackages = ModelManager.loadMetaModel(metricsecore);
			monitor.subTask("Generating dynamic debug metrics");
			«IF standalone == false»
			metricsGenerator = new DebugMutatorMetricsGenerator(metricspackages, «className».class.getProtectionDomain().getCodeSource().getLocation().getPath().replace("/bin/", "/")+ "«((e as MutatorEnvironment).definition as Program).output»", "«((e as MutatorEnvironment).definition as Program).metamodel»", «className».class.getProtectionDomain().getCodeSource().getLocation().getPath().replace("/bin/", "/")+ "«((e as MutatorEnvironment).definition as Program).source.path»", "«fileURI.lastSegment»", hashmapMutVersions, this.getClass());
			«ELSE»
			metricsGenerator = new DebugMutatorMetricsGenerator(metricspackages, «className».class.getProtectionDomain().getCodeSource().getLocation().getPath().replace("/bin/", "/")+ "«((e as MutatorEnvironment).definition as Program).output»", "«((e as MutatorEnvironment).definition as Program).metamodel»", «className».class.getProtectionDomain().getCodeSource().getLocation().getPath().replace("/bin/", "/")+ "«((e as MutatorEnvironment).definition as Program).source.path»", "«fileURI.lastSegment»", hashmapMutVersions, «className».class);
			«ENDIF»
	   		metricsGenerator.run();
			monitor.worked(1);   			
		}
		
		return mutationResults;
	}
}
	«ENDIF»

	'''
	def multiple(MutatorEnvironment e) '''
	
	    «e.definition.multipleCompile»
	   	«e.execute»

	}
	'''
	
	def multipleBlock(MutatorEnvironment e,
		Block b
	) '''
	
	   «e.definition.multipleBlockCompile(b)»
	   «IF (e.definition as Program).exhaustive == false»
	   «var nMut = 0»
	   «IF (b.fixed == 0)»
	   «IF (b.max - b.min > 0)»
			//«nMut = b.min + (b.max - b.min).getRandom»
		«ENDIF»
		«IF (b.min == 0) && (b.max == 0)»
			//«nMut = (e.definition as Program).num»
		«ELSEIF (b.min == b.max)»
			//«nMut = b.min»
		«ENDIF»
		«ELSE»
			//«nMut = b.fixed»
		«ENDIF»
	   	«IF nMut != 0»
	   	numMutants = «nMut»;
	   	«ENDIF»
	   	«ELSE»
	   	numMutants = -1;
	   	«ENDIF»
	   	
	   	
	   	«e.executeBlock(b
	   	)»

	}
	'''
   
	def multipleCompile(Definition e) '''
	//«val String projectRoot = project.location.toFile.absolutePath.replace("\\", "/")»
		«IF e instanceof Program»
		String ecoreURI = "«e.metamodel»";
		«/*IF e.source.multiple == true*/»
		«IF standalone»
		String modelURI =
		    "«projectRoot»/«e.source.path»".replace("\\", "/");
		
		String modelsURI =
		    "«projectRoot»/«e.output»".replace("\\", "/");
		«ELSE»
		String modelURI =
		    «className».class
		        .getProtectionDomain()
		        .getCodeSource()
		        .getLocation()
		        .getPath()
		        .replace("/bin/", "/")
		    + "«e.source.path»";
		
		String modelsURI =
		    «className».class
		        .getProtectionDomain()
		        .getCodeSource()
		        .getLocation()
		        .getPath()
		        .replace("/bin/", "/")
		    + "«e.output»";
		«ENDIF»
		Map<String, String> hashmapModelFilenames = new LinkedHashMap<String, String>();
		«IF (e.source.path.endsWith("/"))»
		File[] files = new File(modelURI).listFiles();
		«ELSE»
		File[] files = new File[1];
		files[0] = new File(modelURI);
		«ENDIF»
		for (int i = 0; i < files.length; i++) {
			if (files[i].isFile() == true) {
				String pathfile = files[i].getPath();
				if (pathfile.endsWith(".model") == true) {
					hashmapModelFilenames.put(pathfile.replace("\\", "/"), modelsURI + files[i].getName().substring(0, files[i].getName().length() - ".model".length()));
				}
			}
		}
		«ENDIF»
		
		«IF e instanceof Program»
		//Load Model
		Set<String> modelFilenames = hashmapModelFilenames.keySet();
	   	if (numMutants > 0) {
	   		totalMutants = numMutants * «MutatorUtils.getNumberOfSeedModels(e.eContainer as MutatorEnvironment, className + ".class.getProtectionDomain().getCodeSource().getLocation().getPath().replace(\"/bin/\", \"/\")" + project.name + "/")»;
	   	}
		totalTasks += totalMutants;
		monitor.beginTask("Generating mutants", totalTasks);
		int count = 0;
		for (String modelFilename : modelFilenames) {
			Set<String> hashsetMutants = new LinkedHashSet<String>();
			hashsetMutants.add(modelFilename);

		«ENDIF»
   '''
   
	def multipleBlockCompile(Definition e, Block b) '''
		//«val String projectRoot = project.location.toFile.absolutePath.replace("\\", "/")»
		«IF e instanceof Program»
		String ecoreURI = "«e.metamodel»".replace("\\", "/");
		«IF standalone»
		String modelURI = "«projectRoot»/«e.source.path»".replace("\\", "/");
		
		String modelsURI = "«projectRoot»/«e.output»".replace("\\", "/");
		«ELSE»
		String modelURI =
		    «className».class
		        .getProtectionDomain()
		        .getCodeSource()
		        .getLocation()
		        .getPath()
		        .replace("/bin/", "/")
		    + "«e.source.path»";
		
		String modelsURI =
		    «className».class
		        .getProtectionDomain()
		        .getCodeSource()
		        .getLocation()
		        .getPath()
		        .replace("/bin/", "/")
		    + "«e.output»";
		«ENDIF»
		Map<String, String> hashmapModelFilenames = new LinkedHashMap<String, String>();
		Map<String, String> hashmapModelFolders = new LinkedHashMap<String, String>();
		Map<String, String> seedModelFilenames = new LinkedHashMap<String, String>();
		«IF (e.source.path.endsWith("/"))»
		File[] files = new File(modelURI).listFiles();
		«ELSE»
		File[] files = new File[1];
		files[0] = new File(modelURI);
		«ENDIF»
		for (int i = 0; i < files.length; i++) {
			if (files[i].isFile() == true) {
				if (files[i].getName().endsWith(".model") == true) {
					if (fromNames.size() == 0) {
						String pathfile = files[i].getPath();
						if (pathfile.endsWith(".model") == true) {
							hashmapModelFilenames.put(pathfile.replace("\\", "/"), modelsURI + files[i].getName().substring(0, files[i].getName().length() - ".model".length()));
							seedModelFilenames.put(pathfile.replace("\\", "/"), files[i].getPath());
						}
					}
					else {
						for (String fromName : fromNames) {
							String modelFolder = modelsURI + files[i].getName().substring(0, files[i].getName().length() - ".model".length()) + "/" + fromName + "/";
							File[] mutFiles = new File(modelFolder).listFiles();
							if (mutFiles != null) {
								for (int j = 0; j < mutFiles.length; j++) {
									if (mutFiles[j].isFile() == true) {
										String pathfile = mutFiles[j].getPath();
										if (pathfile.endsWith(".model") == true) {
											hashmapModelFilenames.put(pathfile.replace("\\", "/"), modelsURI + files[i].getName().substring(0, files[i].getName().length() - ".model".length()));
											hashmapModelFolders.put(pathfile.replace("\\", "/"), fromName + "/" + mutFiles[j].getName().substring(0, mutFiles[j].getName().length() - ".model".length()));
											seedModelFilenames.put(pathfile.replace("\\", "/"), files[i].getPath());
										}
									}
									else {
										generateModelPaths(fromName, mutFiles[j], mutFiles[j].getName(), hashmapModelFilenames, hashmapModelFolders, seedModelFilenames, modelsURI, files[i]);
									}
								}
							}
						}
					}
				}
			}
		}
		«ENDIF»
		
		«IF e instanceof Program»

		//Load Model
		Set<String> modelFilenames = hashmapModelFilenames.keySet();
		for (String modelFilename : modelFilenames) {
			String seedModelFilename = seedModelFilenames.get(modelFilename);
			Set<String> hashsetMutantsBlock = null;
			«IF b.repeat == Repeat.YES»
			hashsetMutantsBlock = new LinkedHashSet<String>();
			«ELSEIF b.repeat == Repeat.NO»
			if (seedModelFilename != null) {
				if (hashmapMutants.get(seedModelFilename) != null) {
					hashsetMutantsBlock = hashmapMutants.get(seedModelFilename);
				}
			}
			if (hashsetMutantsBlock == null) {
				hashsetMutantsBlock = new LinkedHashSet<String>();
			}
			«ENDIF»
			if (hashsetMutantsBlock.contains(seedModelFilename) == false) {
				hashsetMutantsBlock.add(seedModelFilename);
			}

		«ENDIF»
   '''

    def method(AttributeSet e, boolean flag, boolean isList, List<Integer> counter, int position, boolean exhaustive, String obSelectionVariableName) '''
    	«IF isList == true»
    	«IF e.attribute.get(0) !== null»
		«val EAttribute attribute = e.attribute.get(0)»
		«IF counter.get(0) == 1»
		List<AttributeConfigurationStrategy> atts = null;
		if (attsList.get("«attributeName»") != null) {
			atts = attsList.get("«attributeName»");
		}
		else {
			atts = new ArrayList<AttributeConfigurationStrategy>();
		}
		«ELSE»
		«IF position == 1»
		List<AttributeConfigurationStrategy> atts = new ArrayList<AttributeConfigurationStrategy>();
		«ENDIF»
		«ENDIF»
		//NAME:«attributeName = attribute.name»
		«ELSE»
		//NAME:«attributeName = ""»
		«ENDIF»
		«IF e instanceof AttributeScalar»
		«e.value.method(flag, counter, exhaustive, obSelectionVariableName)»
		atts.add(attConfig);
   		«ENDIF»
   		«IF e instanceof AttributeUnset»
		atts.add(attConfig);
   		«ENDIF»
   		«IF e instanceof AttributeReverse»
		«IF counter.get(0) == 1»
   		AttributeConfigurationStrategy attConfig = new ReverseBooleanConfigurationStrategy("«attributeName»");
   		«ELSE»
   		attConfig = new ReverseBooleanConfigurationStrategy("«attributeName»"); 
		«ENDIF»
		atts.add(attConfig);
   		«ENDIF»
		«IF e instanceof AttributeCopy»
		«IF counter.get(0) == 1»
		AttributeConfigurationStrategy attConfig = null;
		«ENDIF»
		«IF e.object instanceof RandomTypeSelection»
		attConfig = new CopyAttributeConfigurationStrategy((«obSelectionVariableName» != null ? «obSelectionVariableName».getObject() : null), "«(e.object as RandomTypeSelection).type.name»", "«attributeName»", "«e.getAttribute().get(1).name»"); 
		atts.add(attConfig);
   		«ENDIF»
		«IF e.object instanceof SpecificObjectSelection»
		«IF counter.get(0) == 1 && !(e instanceof AttributeCopy)»
		AttributeConfigurationStrategy attConfig = null;
		«ENDIF»
		«IF exhaustive == false»
		attConfig = new CopyAttributeConfigurationStrategy((«obSelectionVariableName» != null ? «obSelectionVariableName».getObject() : null), (hmObjects.get("«(e.object as SpecificObjectSelection).objSel.name»") != null ? hmObjects.get("«(e.object as SpecificObjectSelection).objSel.name»").getKey() : null), "«attributeName»", "«e.getAttribute().get(1).name»"); 
		«ELSE»
		attConfig = new CopyAttributeConfigurationStrategy((«obSelectionVariableName» != null ? «obSelectionVariableName».getObject() : null), (hmObjects.get("«(e.object as SpecificObjectSelection).objSel.name»") != null ? hmObjects.get("«(e.object as SpecificObjectSelection).objSel.name»").getKey() : null), "«attributeName»", "«e.getAttribute().get(1).name»");
   		«ENDIF»
   		atts.add(attConfig);
   		«ENDIF»
   		«ENDIF»
		attsList.put("«attributeName»", atts);
   		«ELSE»
    	«IF e.attribute.get(0) !== null»
		«val EAttribute attribute = e.attribute.get(0)»
		//NAME:«attributeName = attribute.name»
		«ELSE»
		//NAME:«attributeName = ""»
		«ENDIF»
		«IF e instanceof AttributeScalar»
		«e.value.method(flag, counter, exhaustive, obSelectionVariableName)»;
		atts.put("«attributeName»", attConfig);
   		«ENDIF»
   		«IF e instanceof AttributeUnset»
		«IF counter.get(0) == 1»
		AttributeConfigurationStrategy attConfig = null;
		«ENDIF»
   		atts.put("«attributeName»", attConfig);
   		«ENDIF»
   		«IF e instanceof AttributeReverse»
   		attConfig = new ReverseBooleanConfigurationStrategy("«attributeName»");
   		atts.put("«attributeName»", attConfig);
   		«ENDIF»
		«IF e instanceof AttributeCopy»
		«IF counter.get(0) == 1»
		AttributeConfigurationStrategy attConfig = null;
		«ENDIF»
		«IF e.object instanceof RandomTypeSelection»
		attConfig = new CopyAttributeConfigurationStrategy((«obSelectionVariableName» != null ? «obSelectionVariableName».getObject() : null), "«(e.object as RandomTypeSelection).type.name»", "«attributeName»", "«e.getAttribute().get(1).name»");
		atts.put("«attributeName»", attConfig);
   		«ENDIF»
		«IF e.object instanceof SpecificObjectSelection»
		«IF exhaustive == false»
		attConfig = new CopyAttributeConfigurationStrategy((«obSelectionVariableName» != null ? «obSelectionVariableName».getObject() : null), (hmObjects.get("«(e.object as SpecificObjectSelection).objSel.name»") != null ? hmObjects.get("«(e.object as SpecificObjectSelection).objSel.name»").getKey() : null), "«attributeName»", "«e.getAttribute().get(1).name»");
		atts.put("«attributeName»", attConfig);
		«ELSE»
		attConfig = new CopyAttributeConfigurationStrategy((«obSelectionVariableName» != null ? «obSelectionVariableName».getObject() : null), (hmObjects.get("«(e.object as SpecificObjectSelection).objSel.name»") != null ? hmObjects.get("«(e.object as SpecificObjectSelection).objSel.name»").getKey() : null), "«attributeName»", "«e.getAttribute().get(1).name»");
		atts.put("«attributeName»", attConfig);
		«ENDIF»
   		«ENDIF»
   		«ENDIF»
   		«ENDIF»
	'''
	
	def method(ReferenceSet e, boolean exhaustive) '''
		«IF e.reference.get(0) !== null»
		«val EReference reference = e.reference.get(0)»
		//NAME:«referenceName = reference.name»
		«ELSE»
		//NAME:«referenceName = ""»
		«ENDIF»
		«IF e instanceof ReferenceInit || e instanceof ReferenceRemove || e instanceof ReferenceAdd»
		«e.object.method(referenceName, exhaustive)»
   		refs.put("«referenceName»", refSelection«nReference»);
   		«ENDIF»
	'''	
	def method(AttributeType e, boolean flag, List<Integer> counter, boolean exhaustive, String obSelectionVariableName) '''
	«IF e instanceof StringType»
		«(e as StringType).method(exhaustive, counter)»
	«ELSEIF e instanceof DoubleType»
		«(e as DoubleType).method(exhaustive, counter)»
	«ELSEIF e instanceof BooleanType»
		«(e as BooleanType).method(exhaustive, counter)»
	«ELSEIF e instanceof IntegerType»
		«(e as IntegerType).method(exhaustive, counter)»
	«ELSEIF e instanceof ListStringType»
		«(e as ListStringType).method(flag, exhaustive, counter, obSelectionVariableName)»
	«ELSEIF e instanceof ListType»
		«(e as ListType).method(flag, exhaustive, counter, obSelectionVariableName)»
	«ELSEIF e instanceof RandomType»
		«(e as RandomType).method(flag, exhaustive, counter, obSelectionVariableName)»
	«ELSEIF e instanceof MinValueType»
		«(e as MinValueType).method(exhaustive, counter)»
	«ELSEIF e instanceof MaxValueType»
		«(e as MaxValueType).method(exhaustive, counter)»
	«ELSEIF e instanceof RandomIntegerNumberType»
		«(e as RandomIntegerNumberType).method(exhaustive, counter)»
	«ELSEIF e instanceof RandomDoubleNumberType»
		«(e as RandomDoubleNumberType).method(exhaustive, counter)»
	«ENDIF»
	'''
	
	//********************
	//DATA TYPES COMPILES
	def method(StringType e, boolean exhaustive, List<Integer> counter) ''' 
		«IF counter.get(0) == 1»
		AttributeConfigurationStrategy attConfig = null;
		«ENDIF»
		«IF e instanceof SpecificStringType»
			attConfig = new SpecificStringConfigurationStrategy("«(e as SpecificStringType).value»");
		«ELSEIF e instanceof RandomStringType»
		    «var RandomStringType r = (e as RandomStringType)»
			attConfig = new RandomStringConfigurationStrategy(«r.min», «r.max», false);
		«ELSEIF e instanceof UpperStringType»
			«IF !attributeName.equals("")»
			attConfig = new UpperStringConfigurationStrategy("«attributeName»");
			«ENDIF»
		«ELSEIF e instanceof LowerStringType»
			«IF !attributeName.equals("")»
			attConfig = new LowerStringConfigurationStrategy("«attributeName»");
			«ENDIF»
		«ELSEIF e instanceof CatStartStringType»
			«IF !attributeName.equals("")»
			attConfig = new CatStartStringConfigurationStrategy("«(e as CatStartStringType).value»", "«attributeName»");
			«ENDIF»
		«ELSEIF e instanceof CatEndStringType»
			«IF !attributeName.equals("")»
			attConfig = new CatEndStringConfigurationStrategy("«(e as CatEndStringType).value»", "«attributeName»");
			«ENDIF»
		«ELSEIF e instanceof ReplaceStringType»
			«IF !attributeName.equals("")»
			attConfig = new ReplaceStringConfigurationStrategy("«attributeName»", "«(e as ReplaceStringType).oldstring»", "«(e as ReplaceStringType).newstring»");
			«ENDIF»
		«ELSEIF e instanceof RandomStringNumberType»
		    «var RandomStringNumberType r = (e as RandomStringNumberType)»
			attConfig = new RandomStringNumberConfigurationStrategy(«r.min», «r.max», false);
		«ENDIF»
	'''
				
	def method(DoubleType e, boolean exhaustive, List<Integer> counter) ''' 
		«IF counter.get(0) == 1»
		AttributeConfigurationStrategy attConfig = null;
		«ENDIF»
		«IF e instanceof SpecificDoubleType»
			attConfig = new SpecificDoubleConfigurationStrategy(«(e as SpecificDoubleType).value»);
		«ELSEIF e instanceof RandomDoubleType»
			«var RandomDoubleType r = (e as RandomDoubleType)»
			attConfig = new RandomDoubleConfigurationStrategy(«r.min», «r.max», false);
		«ENDIF»
	'''	
	def method(BooleanType e, boolean exhaustive, List<Integer> counter) ''' 
		«IF counter.get(0) == 1»
		AttributeConfigurationStrategy attConfig = null;
		«ENDIF»
		«IF e instanceof SpecificBooleanType»
			attConfig = new SpecificBooleanConfigurationStrategy(«(e as SpecificBooleanType).value»);
		«ELSEIF e instanceof RandomBooleanType»
			attConfig = new RandomBooleanConfigurationStrategy();
		«ENDIF»
		'''	
	def method(IntegerType e, boolean exhaustive, List<Integer> counter) '''
		«IF counter.get(0) == 1»
		AttributeConfigurationStrategy attConfig = null;
		«ENDIF»
		«IF e instanceof SpecificIntegerType» 		
			attConfig = new SpecificIntegerConfigurationStrategy(«(e as SpecificIntegerType).value»);
		«ELSEIF e instanceof RandomIntegerType»
			«var RandomIntegerType r = (e as RandomIntegerType)»
			attConfig = new RandomIntegerConfigurationStrategy(«r.min», «r.max», false);		
		«ENDIF»
		'''
	def method(ListStringType e, boolean flag, boolean exhaustive, List<Integer> counter, String obSelectionVariableName) '''
		«IF counter.get(0) == 1»
		AttributeConfigurationStrategy attConfig = null;
		«ENDIF»
		«IF e instanceof ListStringType»
			«IF !attributeName.equals("")»
				«IF flag == false»
					attConfig = new ListStringConfigurationStrategy(ModelManager.getStringAttribute("«attributeName»", («obSelectionVariableName» != null) ? «obSelectionVariableName».getObject() : null), "«(e as ListStringType).value»", "«attributeName»");
				«ELSE»
					attConfig = new ListStringConfigurationStrategy(ModelManager.getStringAttribute("«attributeName»", refObjectSelected), "«(e as ListStringType).value»", "«attributeName»");
				«ENDIF»
			«ENDIF»
		«ENDIF»
		'''
		
	def method(ListType e, boolean flag, boolean exhaustive, List<Integer> counter, String obSelectionVariableName) '''
		«IF counter.get(0) == 1»
		AttributeConfigurationStrategy attConfig = null;
		«ENDIF»
		«IF e instanceof ListType»
			«IF !attributeName.equals("")»
				«IF flag == false»
					attConfig = new ListConfigurationStrategy((EObject) ModelManager.getAttribute("«attributeName»", («obSelectionVariableName» != null) ? «obSelectionVariableName».getObject() : null), "«(e as ListType).value»", "«attributeName»");
				«ELSE»
					attConfig = new ListConfigurationStrategy((EObject) ModelManager.getAttribute("«attributeName»", refObjectSelected), "«(e as ListType).value»", "«attributeName»");
				«ENDIF»
			«ELSE»
				null
			«ENDIF»
		«ENDIF»
		'''
	def method(RandomType e, boolean flag, boolean exhaustive, List<Integer> counter, String obSelectionVariableName) '''
		«IF counter.get(0) == 1»
		AttributeConfigurationStrategy attConfig = null;
		«ENDIF»
		«IF e instanceof RandomType»
			«IF !attributeName.equals("")»
				«IF flag == false»
					attConfig = new RandomConfigurationStrategy(ModelManager.getAttribute("«attributeName»", «obSelectionVariableName».getObject()), "«attributeName»");
				«ELSE»
					attConfig = new RandomConfigurationStrategy(ModelManager.getAttribute("«attributeName»", refObjectSelected), "«attributeName»");
				«ENDIF»
			«ELSE»
				null
			«ENDIF»
		«ENDIF»
		'''
	def method(MinValueType e, boolean exhaustive, List<Integer> counter) '''
		«IF counter.get(0) == 1»
		AttributeConfigurationStrategy attConfig = null;
		«ENDIF»
		attConfig = new MinValueConfigurationStrategy(packages, model, "«MutatorUtils.getTypeName(e)»", "«e.attribute.name»");
		'''
	def method(MaxValueType e, boolean exhaustive, List<Integer> counter) '''
		«IF counter.get(0) == 1»
		AttributeConfigurationStrategy attConfig = null;
		«ENDIF»
		attConfig = new MaxValueConfigurationStrategy(packages, model, "«MutatorUtils.getTypeName(e)»", "«e.attribute.name»");
		'''
	def method(RandomIntegerNumberType e, boolean exhaustive, List<Integer> counter) '''
		«IF counter.get(0) == 1»
		AttributeConfigurationStrategy attConfig = null;
		«ENDIF»
		«IF e.object instanceof SpecificObjectSelection»
		//«var SpecificObjectSelection sel = e.object as SpecificObjectSelection»
		«IF exhaustive == false»
		attConfig = new RandomIntegerConfigurationStrategy(«e.min», ModelManager.getIntAttribute("«e.max.name»", (hmObjects.get("«sel.objSel.name»") != null ? hmObjects.get("«sel.objSel.name»").getKey() : null)), false);
		«ELSE»
		attConfig = new RandomIntegerConfigurationStrategy(«e.min», ModelManager.getIntAttribute("«e.max.name»", (hmObjects.get("«sel.objSel.name»") != null ? hmObjects.get("«sel.objSel.name»").getKey() : null)), false);
		«ENDIF»
		«ENDIF»
		'''
	def method(RandomDoubleNumberType e, boolean exhaustive, List<Integer> counter) '''
		«IF counter.get(0) == 1»
		AttributeConfigurationStrategy attConfig = null;
		«ENDIF»
		«IF e.object instanceof SpecificObjectSelection»
		//«var SpecificObjectSelection sel = e.object as SpecificObjectSelection»
		attConfig = new RandomDoubleConfigurationStrategy(«e.min», ModelManager.getDoubleAttribute("«e.max.name»", (hmObjects.get("«sel.objSel.name»") != null ? hmObjects.get("«sel.objSel.name»").getKey() : null)), false);
		«ENDIF»
	'''

	def add(AttributeOperation op, String obSelectionVariableName, List<Integer> counter) '''
		atts.add(new AddOperationConfigurationStrategy(«obSelectionVariableName».getMetaModel(), «obSelectionVariableName».getModel(), "«MutatorUtils.getTypeName(op)»", "«attributeName»", «obSelectionVariableName».getObject(), value));
		attsList.put("«attributeName»", atts); 
	'''

	def subtract(AttributeOperation op, String obSelectionVariableName, List<Integer> counter) '''
		atts.add(new SubtractOperationConfigurationStrategy(«obSelectionVariableName».getMetaModel(), «obSelectionVariableName».getModel(), "«MutatorUtils.getTypeName(op)»", "«attributeName»", «obSelectionVariableName».getObject(), value));
		attsList.put("«attributeName»", atts); 
	'''

	def multiply(AttributeOperation op, String obSelectionVariableName, List<Integer> counter) '''
		atts.add(new MultiplyOperationConfigurationStrategy(«obSelectionVariableName».getMetaModel(), «obSelectionVariableName».getModel(), "«MutatorUtils.getTypeName(op)»", "«attributeName»", «obSelectionVariableName».getObject(), value));
		attsList.put("«attributeName»", atts); 
	'''

	def divide(AttributeOperation op, String obSelectionVariableName, List<Integer> counter) '''
		atts.add(new DivideOperationConfigurationStrategy(«obSelectionVariableName».getMetaModel(), «obSelectionVariableName».getModel(), "«MutatorUtils.getTypeName(op)»", "«attributeName»", «obSelectionVariableName».getObject(), value));
		attsList.put("«attributeName»", atts); 
	'''

	def module(AttributeOperation op, String obSelectionVariableName, List<Integer> counter) '''
		atts.add(new ModuleOperationConfigurationStrategy(«obSelectionVariableName».getMetaModel(), «obSelectionVariableName».getModel(), "«MutatorUtils.getTypeName(op)»", "«attributeName»", «obSelectionVariableName».getObject(), value));
		attsList.put("«attributeName»", atts); 
	'''
	//END DATA TYPES COMPILES
	//************************
	//********************
	//REFERENCES COMPILES
	def method(ObSelectionStrategy e, String referenceName, boolean exhaustive) '''
  		//REFERENCES COMPILES: «nReference.set(0, nReference.get(0) + 1)»
		«IF e instanceof RandomTypeSelection»
			RandomTypeSelection refRts«nReference.get(0)» = new RandomTypeSelection(packages, model, "«(e as RandomTypeSelection).type.name»");
			«IF e.expression !== null && expressionList !== null»
			List<EObject> refObjects«nReference.get(0)» = refRts«nReference.get(0)».getObjects();
			//INDEX EXPRESSION: « var int indexExpression = expressionList.size() - 1»
			Expression exp«expressionList.get(indexExpression)» = new Expression();
	   		«e.expression.method(0, false)»
	   		List<EObject> refSelectedObjects«nReference.get(0)» = evaluate(refObjects«nReference.get(0)», exp«expressionList.get(indexExpression)»);
			EObject refObject«nReference.get(0)» = null;
			if (refSelectedObjects«nReference.get(0)».size() > 0) {
				refObject«nReference.get(0)» = refSelectedObjects«nReference.get(0)».get(ModelManager.getRandomIndex(refSelectedObjects«nReference.get(0)»));
			}
			«ELSE»
			EObject refObject«nReference.get(0)» = refRts«nReference.get(0)».getObject();
			«ENDIF»
			ObSelectionStrategy refSelection«nReference.get(0)» = null;
			if (refObject«nReference.get(0)» != null) {
			refSelection«nReference.get(0)» = 
				new SpecificObjectSelection(packages, model, refObject«nReference.get(0)»);
			}
	    «ELSEIF e instanceof OtherTypeSelection»
			OtherTypeSelection refOts«nReference.get(0)» = new OtherTypeSelection(packages, model, "«(e as OtherTypeSelection).type.name»", ModelManager.getReference("«referenceName»", objectSelection.getObject()));
			«IF e.expression !== null && expressionList !== null»
			List<EObject> refObjects«nReference.get(0)» = refOts«nReference.get(0)».getObjects();
			//INDEX EXPRESSION: « var int indexExpression = expressionList.size() - 1»
			Expression exp«expressionList.get(indexExpression)» = new Expression();
	   		«e.expression.method(0, false)»
	   		List<EObject> refSelectedObjects«nReference.get(0)» = evaluate(refObjects«nReference.get(0)», exp«expressionList.get(indexExpression)»);
			EObject refObject«nReference.get(0)» = null;
			if (refSelectedObjects«nReference.get(0)».size() > 0) {
				refObject«nReference.get(0)» = refSelectedObjects«nReference.get(0)».get(ModelManager.getRandomIndex(refSelectedObjects«nReference.get(0)»));
			}
			«ELSE»
			EObject refObject«nReference.get(0)» = refOts«nReference.get(0)».getObject();
			«ENDIF»
			ObSelectionStrategy refSelection«nReference.get(0)» = null;
			if (refObject«nReference.get(0)» != null) {
			refSelection«nReference.get(0)» = new SpecificObjectSelection(packages, model, refObject«nReference.get(0)»);
			}
	    «ELSEIF e instanceof NullTypeSelection»
			NullTypeSelection refNts«nReference.get(0)» = new NullTypeSelection(packages, model, "«(e as NullTypeSelection).type.name»", ModelManager.getReference("«referenceName»", objectSelection.getObject()));
			«IF e.expression !== null && expressionList !== null»
			List<EObject> refObjects«nReference.get(0)» = refNts«nReference.get(0)».getObjects();
			//INDEX EXPRESSION: « var int indexExpression = expressionList.size() - 1»
			Expression exp«expressionList.get(indexExpression)» = new Expression();
	   		«e.expression.method(0, false)»
	   		List<EObject> refSelectedObjects«nReference.get(0)» = evaluate(refObjects«nReference.get(0)», exp«expressionList.get(indexExpression)»);
			EObject refObject«nReference.get(0)» = null;
			if (refSelectedObjects«nReference.get(0)».size() > 0) {
				refObject«nReference.get(0)» = refSelectedObjects«nReference.get(0)».get(ModelManager.getRandomIndex(refSelectedObjects«nReference.get(0)»));
			}
			«ELSE»
			EObject refObject«nReference.get(0)» = refOts«nReference.get(0)».getObject();
			«ENDIF»
			ObSelectionStrategy refSelection«nReference.get(0)» = null;
			if (refObject«nReference.get(0)» != null) {
			refSelection«nReference.get(0)» = new SpecificObjectSelection(packages, model, refObject«nReference.get(0)»);
			}
		«ELSEIF e instanceof CompleteTypeSelection»
			RandomTypeSelection refRts«nReference.get(0)» = new RandomTypeSelection(packages, model, "«(e as CompleteTypeSelection).type.name»");
			EObject refObject«nReference.get(0)» = refRts«nReference.get(0)».getObject();
			ObSelectionStrategy refSelection«nReference.get(0)» = new SpecificObjectSelection(packages, model,	refObject«nReference.get(0)»);
		«ELSEIF e instanceof SpecificObjectSelection»
			ObSelectionStrategy refSelection«nReference.get(0)» = null;
			«IF exhaustive == false»
			SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(e as SpecificObjectSelection).objSel.name»_«nReference.get(0)» = hmObjects.get("«(e as SpecificObjectSelection).objSel.name»");
			«ELSE»
			SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(e as SpecificObjectSelection).objSel.name»_«nReference.get(0)» = hmObjects.get("«(e as SpecificObjectSelection).objSel.name»");
			«ENDIF»
			if (entry_«(e as SpecificObjectSelection).objSel.name»_«nReference.get(0)» != null) {
			«IF e.refType !== null»
				refSelection«nReference.get(0)» = new SpecificObjectSelection(packages, model, entry_«(e as SpecificObjectSelection).objSel.name»_«nReference.get(0)».getKey(), "«e.refType.name»");
			«ELSE»
				refSelection«nReference.get(0)» = new SpecificObjectSelection(packages, model, entry_«(e as SpecificObjectSelection).objSel.name»_«nReference.get(0)».getKey());
			«ENDIF»
			} else {
			«IF exhaustive == false»
				List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_«(e as SpecificObjectSelection).objSel.name»_«nReference.get(0)» = hmList.get("«(e as SpecificObjectSelection).objSel.name»");
			«ELSE»
				List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_«(e as SpecificObjectSelection).objSel.name»_«nReference.get(0)» = hmList.get("«(e as SpecificObjectSelection).objSel.name»");
			«ENDIF»
				if (listEntry_«(e as SpecificObjectSelection).objSel.name»_«nReference.get(0)» != null) {
					List<EObject> objs = new ArrayList<EObject>();
					for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_«(e as SpecificObjectSelection).objSel.name»_«nReference.get(0)») {
						EObject obj = ModelManager.getObject(model, ent.getKey());
						objs.add(obj);
					}
				«IF e.refType !== null»
					refSelection«nReference.get(0)» = new SpecificObjectSelection(packages, model, objs, "«e.refType.name»");
				«ELSE»
					refSelection«nReference.get(0)» = new SpecificObjectSelection(packages, model, objs);
				«ENDIF»
				}
				else {
					«IF exhaustive == false»
					return mutations;
					«ELSE»
					return numMutantsGenerated;
					«ENDIF»
				}
			}
		«ENDIF»
	'''
	//END REFERENCES COMPILES
	//************************
   
	private def compileAuxiliarExpression(int expressionPosition) {
		var indexExpression = expressionList.size() - 1
		var List<Integer> expressionArray = new ArrayList<Integer>()
		var int i = 0
		while (i < expressionPosition) {
			expressionArray.add(i)
			i++
		}
		return 
	'''
		«FOR expressionCounter : expressionArray»
			«IF expressionCounter == 0»
			Expression auxExp«expressionList.get(indexExpression)» = new Expression();
			auxExp«expressionList.get(indexExpression)».first = exp«expressionList.get(indexExpression)».first;
			auxExp«expressionList.get(indexExpression)».operator = new ArrayList<Operator>();
			«ELSE»
			«IF expressionCounter == 1»
			Operator op«expressionCounter - 1»_«expressionList.get(indexExpression)» = new Operator();
			op«expressionCounter - 1»_«expressionList.get(indexExpression)».type = exp«expressionList.get(indexExpression)».operator.get(«expressionCounter - 1»).type;
			auxExp«expressionList.get(indexExpression)».operator.add(op«expressionCounter - 1»_«expressionList.get(indexExpression)»);
			auxExp«expressionList.get(indexExpression)».second = new ArrayList<Evaluation>();
			exp«expressionList.get(indexExpression)».second.add(exp«expressionList.get(indexExpression)».second.get(«expressionCounter - 1»));
			«ELSE»
			Operator op«expressionCounter - 1»_«expressionList.get(indexExpression)» = new Operator();
			op«expressionCounter - 1»_«expressionList.get(indexExpression)».type = exp«expressionList.get(indexExpression)».operator.get(«expressionCounter - 1»).type;
			auxExp«expressionList.get(indexExpression)».operator.add(op«expressionCounter - 1»_«expressionList.get(indexExpression)»);
			exp«expressionList.get(indexExpression)».second.add(exp«expressionList.get(indexExpression)».second.get(«expressionCounter - 1»));
			«ENDIF»
			«ENDIF»
		«ENDFOR»
	'''
	}
   //*********
   // CLAUSES
   def Object method(Expression exp, int recursionIndexExpression, boolean resources) '''
  		//INDEX EXPRESSION: «val int indexExpression = expressionList.size() - 1»
  		«IF exp.first instanceof AttributeEvaluation»
  		«IF (exp.first as AttributeEvaluation).value instanceof ObjectAttributeType»
  		exp«expressionList.get(indexExpression)».first = new AttributeEvaluation();
  		//ATTRIBUTE: «val AttributeEvaluation attev = exp.first as AttributeEvaluation»
  		((AttributeEvaluation) exp«expressionList.get(indexExpression)».first).name = "«attev.name.name»";
  		((AttributeEvaluation) exp«expressionList.get(indexExpression)».first).operator = "«(attev.value as ObjectAttributeType).operator»";
  		((AttributeEvaluation) exp«expressionList.get(indexExpression)».first).values = new ArrayList<Object>();
  		«IF (attev.value as ObjectAttributeType).attribute.upperBound > 1 || (attev.value as ObjectAttributeType).attribute.upperBound == -1»
  		((AttributeEvaluation) exp«expressionList.get(indexExpression)».first).values.addAll(ModelManager.getStringAttributes("«(attev.value as ObjectAttributeType).attribute.name»", hmObjects.get("«(attev.value as ObjectAttributeType).objSel.name»") != null ? hmObjects.get("«(attev.value as ObjectAttributeType).objSel.name»").getKey() : null));
  		«ELSE»
  		((AttributeEvaluation) exp«expressionList.get(indexExpression)».first).values.add(ModelManager.getStringAttribute("«(attev.value as ObjectAttributeType).attribute.name»", hmObjects.get("«(attev.value as ObjectAttributeType).objSel.name»") != null ? hmObjects.get("«(attev.value as ObjectAttributeType).objSel.name»").getKey() : null));
  		«ENDIF»
   		«ENDIF»
   		«IF (exp.first as AttributeEvaluation).value instanceof AttributeType»
		exp«expressionList.get(indexExpression)».first = new AttributeEvaluation();
		//ATTRIBUTE: «val AttributeEvaluation attev = exp.first as AttributeEvaluation»
		((AttributeEvaluation) exp«expressionList.get(indexExpression)».first).name = "«attev.name.name»";
		((AttributeEvaluation) exp«expressionList.get(indexExpression)».first).operator = "«(attev.value as AttributeType).operator»";
		((AttributeEvaluation) exp«expressionList.get(indexExpression)».first).values = new ArrayList<Object>();
   		«IF attev.value instanceof StringType»
   			((AttributeEvaluation) exp«expressionList.get(indexExpression)».first).values.add("«(attev.value as SpecificStringType).value»");
   			((AttributeEvaluation) exp«expressionList.get(indexExpression)».first).type = "String";
		«ENDIF»
		«IF attev.value instanceof DoubleType»
   			((AttributeEvaluation) exp«expressionList.get(indexExpression)».first).values.add(«(attev.value as SpecificDoubleType).value»);
   			((AttributeEvaluation) exp«expressionList.get(indexExpression)».first).type = "double";
		«ENDIF»
		«IF attev.value instanceof BooleanType»
   			((AttributeEvaluation) exp«expressionList.get(indexExpression)».first).values.add(«(attev.value as SpecificBooleanType).value»);
   			((AttributeEvaluation) exp«expressionList.get(indexExpression)».first).type = "Boolean";
		«ENDIF»
		«IF attev.value instanceof IntegerType»
   			((AttributeEvaluation) exp«expressionList.get(indexExpression)».first).values.add(«(attev.value as SpecificIntegerType).value»);
   			((AttributeEvaluation) exp«expressionList.get(indexExpression)».first).type = "int";
		«ENDIF»
		«IF attev.value instanceof MinValueType»
			//«var int expressionPosition = 0»
			«IF resources == false»
			«IF expressionPosition == 0»
			MinValueConfigurationStrategy min«expressionList.get(indexExpression)» = new MinValueConfigurationStrategy(packages, model, "«MutatorUtils.getTypeName(attev.value as MinValueType)»", "«(attev.value as MinValueType).attribute.name»");
			«ELSE»
			«compileAuxiliarExpression(expressionPosition)»
			List<EObject> auxObjects = evaluate(objects, auxExp«expressionList.get(indexExpression)»);
			MinValueConfigurationStrategy min«expressionList.get(indexExpression)» = new MinValueConfigurationStrategy(packages, model, "«MutatorUtils.getTypeName(attev.value as MinValueType)»", auxObjects, "«(attev.value as MinValueType).attribute.name»");
			«ENDIF»
			((AttributeEvaluation) exp«expressionList.get(indexExpression)».first).values.add(min«expressionList.get(indexExpression)».getValue());
			«ELSE»
			«IF expressionPosition == 0»
			MinValueConfigurationStrategy min«expressionList.get(indexExpression)» = new MinValueConfigurationStrategy(resourcePackages, resources, "«MutatorUtils.getTypeName(attev.value as MinValueType)»", "«(attev.value as MinValueType).attribute.name»");
			«ELSE»
			«compileAuxiliarExpression(expressionPosition)»
			List<EObject> auxObjects = evaluate(objects, auxExp«expressionList.get(indexExpression)»);
			MinValueConfigurationStrategy min«expressionList.get(indexExpression)» = new MinValueConfigurationStrategy(packages, model, "«MutatorUtils.getTypeName(attev.value as MinValueType)»", auxObjects, "«(attev.value as MinValueType).attribute.name»");
			«ENDIF»
			((AttributeEvaluation) exp«expressionList.get(indexExpression)».first).values.add(min«expressionList.get(indexExpression)».getValue());
			«ENDIF»
   			«IF (attev.value as MinValueType).attribute.getEType.name.equals("EInt")»
			((AttributeEvaluation) exp«expressionList.get(indexExpression)».first).type = "int";
   			«ENDIF»
   			«IF (attev.value as MinValueType).attribute.getEType.name.equals("EFloat")»
			((AttributeEvaluation) exp«expressionList.get(indexExpression)».first).type = "float";
   			«ENDIF»
   			«IF (attev.value as MinValueType).attribute.getEType.name.equals("EDouble")»
			((AttributeEvaluation) exp«expressionList.get(indexExpression)».first).type = "double";
   			«ENDIF»
		«ENDIF»
		«IF attev.value instanceof MaxValueType»
			//«var int expressionPosition = 0»
			«IF resources == false»
			«IF expressionPosition == 0»
			MaxValueConfigurationStrategy max«expressionList.get(indexExpression)» = new MaxValueConfigurationStrategy(packages, model, "«MutatorUtils.getTypeName(attev.value as MaxValueType)»", "«(attev.value as MaxValueType).attribute.name»");
			«ELSE»
			«compileAuxiliarExpression(expressionPosition)»
			List<EObject> auxObjects = evaluate(objects, auxExp«expressionList.get(indexExpression)»);
			MaxValueConfigurationStrategy max«expressionList.get(indexExpression)» = new MaxValueConfigurationStrategy(packages, model, "«MutatorUtils.getTypeName(attev.value as MaxValueType)»", auxObjects, "«(attev.value as MaxValueType).attribute.name»");
			«ENDIF»
			((AttributeEvaluation) exp«expressionList.get(indexExpression)».first).values.add(max«expressionList.get(indexExpression)».getValue());
			«ELSE»
			«IF expressionPosition == 0»
			MaxValueConfigurationStrategy max«expressionList.get(indexExpression)» = new MaxValueConfigurationStrategy(resourcePackages, resources, "«MutatorUtils.getTypeName(attev.value as MaxValueType)»", "«(attev.value as MaxValueType).attribute.name»");
			«ELSE»
			«compileAuxiliarExpression(expressionPosition)»
			List<EObject> auxObjects = evaluate(objects, auxExp«expressionList.get(indexExpression)»);
			MaxValueConfigurationStrategy max«expressionList.get(indexExpression)» = new MaxValueConfigurationStrategy(packages, model, "«MutatorUtils.getTypeName(attev.value as MaxValueType)»", auxObjects, "«(attev.value as MaxValueType).attribute.name»");
			«ENDIF»
			((AttributeEvaluation) exp«expressionList.get(indexExpression)».first).values.add(max«expressionList.get(indexExpression)».getValue());
			«ENDIF»
   			«IF (attev.value as MaxValueType).attribute.getEType.name.equals("EInt")»
			((AttributeEvaluation) exp«expressionList.get(indexExpression)».first).type = "int";
   			«ENDIF»
   			«IF (attev.value as MaxValueType).attribute.getEType.name.equals("EFloat")»
			((AttributeEvaluation) exp«expressionList.get(indexExpression)».first).type = "float";
   			«ENDIF»
   			«IF (attev.value as MaxValueType).attribute.getEType.name.equals("EDouble")»
			((AttributeEvaluation) exp«expressionList.get(indexExpression)».first).type = "double";
   			«ENDIF»
		«ENDIF»
		«IF attev.value instanceof ListStringType»
			//«val ListStringType list = attev.value as ListStringType»
			«FOR item : list.value»
			((AttributeEvaluation) exp«expressionList.get(indexExpression)».first).values.add("«item»");
   			«ENDFOR»
			((AttributeEvaluation) exp«expressionList.get(indexExpression)».first).type = "String";
		«ENDIF»
		«IF attev.value instanceof ListType»
			//«val ListType list = attev.value as ListType»
			«FOR item : list.value»
			((AttributeEvaluation) exp«expressionList.get(indexExpression)».first).values.add("«item»");
   			«ENDFOR»
			((AttributeEvaluation) exp«expressionList.get(indexExpression)».first).type = "String";
		«ENDIF»
   		«ENDIF»
   		«ENDIF»
   		«IF exp.first instanceof ReferenceEvaluation»
		exp«expressionList.get(indexExpression)».first = new ReferenceEvaluation();
		//REFERENCE: «val ReferenceEvaluation refev = exp.first as ReferenceEvaluation»
	   	«IF refev.name !== null»
			((ReferenceEvaluation) exp«expressionList.get(indexExpression)».first).name = "«refev.name.name»";
			«IF refev.value instanceof TypedSelection && recursionIndexExpression != 0»
			refNames«expressionList.get(recursionIndexExpression)».add("«refev.name.name»");
			«ENDIF»
   		«ELSE»
			((ReferenceEvaluation) exp«expressionList.get(indexExpression)».first).name = null;
			((ReferenceEvaluation) exp«expressionList.get(indexExpression)».first).container = «refev.container»;
		«ENDIF»
		«IF refev.refName !== null»
			((ReferenceEvaluation) exp«expressionList.get(indexExpression)».first).refName = "«refev.refName.name»";
			«IF refev.refRefName !== null»
			((ReferenceEvaluation) exp«expressionList.get(indexExpression)».first).refRefName = "«refev.refRefName.name»";
			«ELSE»
			((ReferenceEvaluation) exp«expressionList.get(indexExpression)».first).refRefName = null;
			«ENDIF»
		«ELSE»
			((ReferenceEvaluation) exp«expressionList.get(indexExpression)».first).refName = null;
		«ENDIF»
		«IF refev.attName !== null»
			((ReferenceEvaluation) exp«expressionList.get(indexExpression)».first).attName = "«refev.attName.name»";
		«ELSE»
			((ReferenceEvaluation) exp«expressionList.get(indexExpression)».first).attName = null;
		«ENDIF»
		((ReferenceEvaluation) exp«expressionList.get(indexExpression)».first).operator = "«refev.operator»";
		«IF refev.value === null»
			«IF refev.attValue === null»
			((ReferenceEvaluation) exp«expressionList.get(indexExpression)».first).value = null;
			«ELSE»
	  		«IF refev.attValue instanceof ObjectAttributeType»
  			((ReferenceEvaluation) exp«expressionList.get(indexExpression)».first).value = ModelManager.getStringAttribute("«(refev.attValue as ObjectAttributeType).attribute.name»", hmObjects.get("«(refev.attValue as ObjectAttributeType).objSel.name»").getKey());
	   		«ENDIF»
   			«IF refev.attValue instanceof AttributeType»
   			«IF refev.attValue instanceof StringType»
   				((ReferenceEvaluation) exp«expressionList.get(indexExpression)».first).value = "«(refev.attValue as SpecificStringType).value»";
			«ENDIF»
   			«IF refev.attValue instanceof DoubleType»
   				((ReferenceEvaluation) exp«expressionList.get(indexExpression)».first).value = "«(refev.attValue as SpecificDoubleType).value»";
   			«ENDIF»
   			«IF refev.attValue instanceof BooleanType»
   				((ReferenceEvaluation) exp«expressionList.get(indexExpression)».first).value = "«(refev.attValue as SpecificBooleanType).value»";
   			«ENDIF»
   			«IF refev.attValue instanceof IntegerType»
   				((ReferenceEvaluation) exp«expressionList.get(indexExpression)».first).value = "«(refev.attValue as SpecificIntegerType).value»";
			«ENDIF»
			«IF refev.attValue instanceof MinValueType»
			«IF resources == false»
			«IF indexExpression == 0»
				MinValueConfigurationStrategy min«expressionList.get(indexExpression)» = new MinValueConfigurationStrategy(packages, model, "«MutatorUtils.getTypeName(refev.attValue as MinValueType)»", "«(refev.attValue as MinValueType).attribute.name»");
			«ELSE»
				«compileAuxiliarExpression(indexExpression)»
				List<EObject> auxObjects = evaluate(objects, auxExp«expressionList.get(indexExpression)»);
				MinValueConfigurationStrategy min«expressionList.get(indexExpression)» = new MinValueConfigurationStrategy(packages, model, "«MutatorUtils.getTypeName(refev.attValue as MinValueType)»", auxObjects, "«(refev.attValue as MinValueType).attribute.name»");
			«ENDIF»
				((ReferenceEvaluation) exp«expressionList.get(indexExpression)».first).value = min«expressionList.get(indexExpression)».getValue();
			«ELSE»
			«IF indexExpression == 0»
				MinValueConfigurationStrategy min«expressionList.get(indexExpression)» = new MinValueConfigurationStrategy(resourcePackages, resources, "«MutatorUtils.getTypeName(refev.attValue as MinValueType)»", "«(refev.attValue as MinValueType).attribute.name»");
			«ELSE»
				«compileAuxiliarExpression(indexExpression)»
				List<EObject> auxObjects = evaluate(objects, auxExp«expressionList.get(indexExpression)»);
				MinValueConfigurationStrategy min«expressionList.get(indexExpression)» = new MinValueConfigurationStrategy(resourcePackages, resources, "«MutatorUtils.getTypeName(refev.attValue as MinValueType)»", auxObjects, "«(refev.attValue as MinValueType).attribute.name»");
			«ENDIF»
				((ReferenceEvaluation) exp«expressionList.get(indexExpression)».first).value = min«expressionList.get(indexExpression)».getValue();
			«ENDIF»
			«IF refev.attValue instanceof MaxValueType»
			//«var int expressionPosition = 0»
			«IF resources == false»
			«IF expressionPosition == 0»
				MaxValueConfigurationStrategy max«expressionList.get(indexExpression)» = new MaxValueConfigurationStrategy(packages, model, "«MutatorUtils.getTypeName(refev.attValue as MaxValueType)»", "«(refev.attValue as MaxValueType).attribute.name»");
			«ELSE»
				«compileAuxiliarExpression(expressionPosition)»
				List<EObject> auxObjects = evaluate(objects, auxExp«expressionList.get(indexExpression)»);
				MaxValueConfigurationStrategy max«expressionList.get(indexExpression)» = new MaxValueConfigurationStrategy(packages, model, "«MutatorUtils.getTypeName(refev.attValue as MaxValueType)»", auxObjects, "«(refev.attValue as MaxValueType).attribute.name»");
			«ENDIF»
				((ReferenceEvaluation) exp«expressionList.get(indexExpression)».first).value = max«expressionList.get(indexExpression)».getValue();
			«ELSE»
			«IF expressionPosition == 0»
				MaxValueConfigurationStrategy max«expressionList.get(indexExpression)» = new MaxValueConfigurationStrategy(resourcePackages, resources, "«MutatorUtils.getTypeName(refev.attValue as MaxValueType)»", "«(refev.attValue as MaxValueType).attribute.name»");
			«ELSE»
				«compileAuxiliarExpression(expressionPosition)»
				List<EObject> auxObjects = evaluate(objects, auxExp«expressionList.get(indexExpression)»);
				MaxValueConfigurationStrategy max«expressionList.get(indexExpression)» = new MaxValueConfigurationStrategy(packages, model, "«MutatorUtils.getTypeName(refev.attValue as MaxValueType)»", auxObjects, "«(refev.attValue as MaxValueType).attribute.name»");
			«ENDIF»
				((ReferenceEvaluation) exp«expressionList.get(indexExpression)».first).value = max«expressionList.get(indexExpression)».getValue();
			«ENDIF»
			«ENDIF»
			«ENDIF»
			«ENDIF»
			«ENDIF»
   		«ELSEIF refev.value instanceof SpecificObjectSelection»
   			«IF refev.refType === null && refev.value.refType === null»
   			SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«expressionList.get(indexExpression)» = hmObjects.get("«(refev.value as SpecificObjectSelection).objSel.name»");
   			if (entry_«expressionList.get(indexExpression)» != null) {
				((ReferenceEvaluation) exp«expressionList.get(indexExpression)».first).value = new SpecificObjectSelection(entry_«expressionList.get(indexExpression)».getValue().getValue(), entry_«expressionList.get(indexExpression)».getValue().getKey(), entry_«expressionList.get(indexExpression)».getKey()).getObject();
			}
	   		«ELSE»
	   		«IF refev.refType !== null»
	   		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«expressionList.get(indexExpression)» = hmObjects.get("«(refev.value as SpecificObjectSelection).objSel.name»");
	   		if (entry_«expressionList.get(indexExpression)» != null) {
	   			EObject srcObjExp = entry_«expressionList.get(indexExpression)».getKey();
	   			for (EReference ref : srcObjExp.eClass().getEAllReferences()) {
	   				if (ref.getName().equals("«refev.refType.name»")) {
	   				((ReferenceEvaluation) exp«expressionList.get(indexExpression)».first).value = srcObjExp.eGet(ref);		
	   				}
	   			}
	   		}
			«ENDIF»
	   		«IF refev.value.refType !== null»
	   		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«expressionList.get(indexExpression)» = hmObjects.get("«(refev.value as SpecificObjectSelection).objSel.name»");
	   		if (entry_«expressionList.get(indexExpression)» != null) {
		   		EObject srcObjExp = entry_«expressionList.get(indexExpression)».getKey();
		   		for (EReference ref : srcObjExp.eClass().getEAllReferences()) {
	   				if (ref.getName().equals("«refev.value.refType.name»")) {
	   					((ReferenceEvaluation) exp«expressionList.get(indexExpression)».first).value = srcObjExp.eGet(ref);		
	   				}
	   			}
	   		}
			«ENDIF»
	   		«ENDIF»
		«ELSE»
		«IF refev.value instanceof RandomTypeSelection»
		«IF refev.value.expression instanceof Expression»
			//EXPRESSION LEVEL: «nExpression.set(0, nExpression.get(0) + 1)»
			//EXPRESSION LEVEL: «expressionList.add(nExpression.get(0))»
			//INDEX EXPRESSION: «val int nestedIndexExpression = expressionList.size() - 1»
			RandomTypeSelection expRts«expressionList.get(nestedIndexExpression)» = new RandomTypeSelection(packages, model, "«(refev.value as RandomTypeSelection).type.name»");
			List<EObject> expObjects«expressionList.get(nestedIndexExpression)» = expRts«expressionList.get(nestedIndexExpression)».getObjects();
			Expression exp«expressionList.get(nestedIndexExpression)» = new Expression();
	   		«refev.value.expression.method(nestedIndexExpression, resources)»
			List<EObject> selectedObjects«expressionList.get(nestedIndexExpression)» = evaluate(expObjects«expressionList.get(nestedIndexExpression)», exp«expressionList.get(nestedIndexExpression)»);
			EObject object«expressionList.get(nestedIndexExpression)» = null;
			if (selectedObjects«expressionList.get(nestedIndexExpression)».size() > 0) {
				object«expressionList.get(nestedIndexExpression)» = selectedObjects«expressionList.get(nestedIndexExpression)».get(ModelManager.getRandomIndex(selectedObjects«expressionList.get(nestedIndexExpression)»));
			}
			((ReferenceEvaluation) exp«expressionList.get(indexExpression)».first).value = new SpecificObjectSelection(packages, model, object«expressionList.get(nestedIndexExpression)»).getObject();
		«ELSE»
		((ReferenceEvaluation) exp«expressionList.get(indexExpression)».first).value = new RandomTypeSelection(packages, model, "«(refev.value as RandomTypeSelection).type.name»").getObject();
		«ENDIF»
		«ELSE»
		«IF refev.value instanceof TypedSelection»
		«IF refev.value.expression instanceof Expression»
			//EXPRESSION LEVEL: «nExpression.set(0, nExpression.get(0) + 1)»
			//EXPRESSION LEVEL: «expressionList.add(nExpression.get(0))»
			//INDEX EXPRESSION: «val int nestedIndexExpression = expressionList.size() - 1»
			TypedSelection expRts«expressionList.get(nestedIndexExpression)» = new TypedSelection(packages, model, "«(refev.value as TypedSelection).type.name»");
			List<EObject> expObjects«expressionList.get(nestedIndexExpression)» = expRts«expressionList.get(nestedIndexExpression)».getObjects();
			Expression exp«expressionList.get(nestedIndexExpression)» = new Expression();
			List<String> refNames«expressionList.get(nestedIndexExpression)» = new ArrayList<String>();
	   		«refev.value.expression.method(nestedIndexExpression, resources)»
			List<EObject> selectedObjects«expressionList.get(nestedIndexExpression)» = evaluate(expObjects«expressionList.get(nestedIndexExpression)», exp«expressionList.get(nestedIndexExpression)»);
			refNames«expressionList.get(nestedIndexExpression)».add("«refev.name.name»");
			Collections.reverse(refNames«expressionList.get(nestedIndexExpression)»);
			selectedObjects«expressionList.get(nestedIndexExpression)» = ModelManager.getReferredObjects(refNames«expressionList.get(nestedIndexExpression)», objects, selectedObjects1);
			EObject object«expressionList.get(nestedIndexExpression)» = null;
			if (selectedObjects«expressionList.get(nestedIndexExpression)».size() > 0) {
				object«expressionList.get(nestedIndexExpression)» = selectedObjects«expressionList.get(nestedIndexExpression)».get(ModelManager.getRandomIndex(selectedObjects«expressionList.get(nestedIndexExpression)»));
			}
			((ReferenceEvaluation) exp«expressionList.get(indexExpression)».first).value = new SpecificObjectSelection(packages, model, object«expressionList.get(nestedIndexExpression)»).getObject();
		«ELSE»
		((ReferenceEvaluation) exp«expressionList.get(indexExpression)».first).value = new TypedSelection(packages, model, "«(refev.value as TypedSelection).type.name»").getObject();
		«ENDIF»
		«ENDIF»
   		«ENDIF»
		«ENDIF»
   		«ENDIF»
		exp«expressionList.get(indexExpression)».operator = new ArrayList<Operator>();
		//OPNAME: «var int opName = 0»
   		«FOR BinaryOperator op : exp.operator»
			Operator op«opName»_«expressionList.get(indexExpression)» = new Operator();
			op«opName»_«expressionList.get(indexExpression)».type = "«op.type»";
			exp«expressionList.get(indexExpression)».operator.add(op«opName»_«expressionList.get(indexExpression)»);
			//OPNAME + 1: « opName = opName + 1»
   		«ENDFOR»
		exp«expressionList.get(indexExpression)».second = new ArrayList<Evaluation>();
		//EVNAME: «var int evName = 0»
		//EVCOUNTER: «var int expressionPosition = 0»
   		«FOR Evaluation ev : exp.second»
   			//«expressionPosition++»
   			«IF ev instanceof AttributeEvaluation»
   			«IF (ev as AttributeEvaluation).value instanceof ObjectAttributeType»
			AttributeEvaluation ev«evName»_«expressionList.get(indexExpression)» = new AttributeEvaluation();
			ev«evName»_«expressionList.get(indexExpression)».name = "«ev.name.name»";
			ev«evName»_«expressionList.get(indexExpression)».operator = "«(ev.value as ObjectAttributeType).operator»";
			ev«evName»_«expressionList.get(indexExpression)».values = new ArrayList<Object>();
   			«ENDIF»
   			«IF (ev as AttributeEvaluation).value instanceof AttributeType»
			AttributeEvaluation ev«evName»_«expressionList.get(indexExpression)» = new AttributeEvaluation();
			ev«evName»_«expressionList.get(indexExpression)».name = "«ev.name.name»";
			ev«evName»_«expressionList.get(indexExpression)».operator = "«(ev.value as AttributeType).operator»";
			ev«evName»_«expressionList.get(indexExpression)».values = new ArrayList<Object>();
   			«IF ev.value instanceof StringType»
				ev«evName»_«expressionList.get(indexExpression)».operator = "«(ev.value as SpecificStringType).operator»";
				ev«evName»_«expressionList.get(indexExpression)».values.add("«(ev.value as SpecificStringType).value»");;
				ev«evName»_«expressionList.get(indexExpression)».type = "String";
			«ENDIF»
			«IF ev.value instanceof DoubleType»
				ev«evName»_«expressionList.get(indexExpression)».operator = "«(ev.value as SpecificDoubleType).operator»";
				ev«evName»_«expressionList.get(indexExpression)».values.add(«(ev.value as SpecificDoubleType).value»);
				ev«evName»_«expressionList.get(indexExpression)».type = "double";
			«ENDIF»
			«IF ev.value instanceof BooleanType»
				ev«evName»_«expressionList.get(indexExpression)».operator = "«(ev.value as SpecificBooleanType).operator»";
				ev«evName»_«expressionList.get(indexExpression)».values.add(«(ev.value as SpecificBooleanType).value»);
				ev«evName»_«expressionList.get(indexExpression)».type = "Boolean";
			«ENDIF»
			«IF ev.value instanceof IntegerType»
				ev«evName»_«expressionList.get(indexExpression)».operator = "«(ev.value as SpecificIntegerType).operator»";
				ev«evName»_«expressionList.get(indexExpression)».values.add(«(ev.value as SpecificIntegerType).value»);
				ev«evName»_«expressionList.get(indexExpression)».type = "int";
			«ENDIF»
			«IF ev.value instanceof MinValueType»
			«IF resources == false»
			«IF expressionPosition == 0»
			MinValueConfigurationStrategy min«evName»_«expressionList.get(indexExpression)» = new MinValueConfigurationStrategy(packages, model, "«MutatorUtils.getTypeName(ev.value as MinValueType)»", "«(ev.value as MinValueType).attribute.name»");
			«ELSE»
			«compileAuxiliarExpression(expressionPosition)»
			List<EObject> auxObjects = evaluate(objects, auxExp«expressionList.get(indexExpression)»);
			MinValueConfigurationStrategy min«evName»_«expressionList.get(indexExpression)» = new MinValueConfigurationStrategy(packages, model, "«MutatorUtils.getTypeName(ev.value as MinValueType)»", auxObjects, "«(ev.value as MinValueType).attribute.name»");
			«ENDIF»
			((AttributeEvaluation) ev«evName»_«expressionList.get(indexExpression)»).values.add(min«evName»_«expressionList.get(indexExpression)».getValue());
			«ELSE»
			«IF expressionPosition == 0»
			MinValueConfigurationStrategy min«evName»_«expressionList.get(indexExpression)» = new MinValueConfigurationStrategy(packages, resources, "«MutatorUtils.getTypeName(ev.value as MinValueType)»", "«(ev.value as MinValueType).attribute.name»");
			«ELSE»
			«compileAuxiliarExpression(expressionPosition)»
			List<EObject> auxObjects = evaluate(objects, auxExp«expressionList.get(indexExpression)»);
			MinValueConfigurationStrategy min«evName»_«expressionList.get(indexExpression)» = new MinValueConfigurationStrategy(packages, resources, "«MutatorUtils.getTypeName(ev.value as MinValueType)»", auxObjects, "«(ev.value as MinValueType).attribute.name»");
			«ENDIF»
			((AttributeEvaluation) ev«evName»_«expressionList.get(indexExpression)»).values.add(min«evName»_«expressionList.get(indexExpression)».getValue());
			«ENDIF»
   			«IF (ev.value as MinValueType).attribute.getEType.name.equals("EInt")»
			((AttributeEvaluation) ev«evName»_«expressionList.get(indexExpression)»).type = "int";
   			«ENDIF»
   			«IF (ev.value as MinValueType).attribute.getEType.name.equals("EFloat")»
			((AttributeEvaluation) ev«evName»_«expressionList.get(indexExpression)»).type = "float";
   			«ENDIF»
   			«IF (ev.value as MinValueType).attribute.getEType.name.equals("EDouble")»
			((AttributeEvaluation) ev«evName»_«expressionList.get(indexExpression)»).type = "double";
   			«ENDIF»
			«ENDIF»
			«IF ev.value instanceof MaxValueType»
			«IF resources == false»
			«IF expressionPosition == 0»
			MaxValueConfigurationStrategy max«evName»_«expressionList.get(indexExpression)» = new MaxValueConfigurationStrategy(packages, model, "«MutatorUtils.getTypeName(ev.value as MaxValueType)»", "«(ev.value as MaxValueType).attribute.name»");
			«ELSE»
			«compileAuxiliarExpression(expressionPosition)»
			List<EObject> auxObjects = evaluate(objects, auxExp«expressionList.get(indexExpression)»);
			MaxValueConfigurationStrategy max«evName»_«expressionList.get(indexExpression)» = new MaxValueConfigurationStrategy(packages, model, "«MutatorUtils.getTypeName(ev.value as MaxValueType)»", auxObjects, "«(ev.value as MaxValueType).attribute.name»");
			«ENDIF»
			((AttributeEvaluation) ev«evName»_«expressionList.get(indexExpression)»).values.add(max«evName»_«expressionList.get(indexExpression)».getValue());
			«ELSE»
			«IF expressionPosition == 0»
			MaxValueConfigurationStrategy max«evName»_«expressionList.get(indexExpression)» = new MaxValueConfigurationStrategy(packages, resources, "«MutatorUtils.getTypeName(ev.value as MaxValueType)»", "«(ev.value as MaxValueType).attribute.name»");
			«ELSE»
			«compileAuxiliarExpression(expressionPosition)»
			List<EObject> auxObjects = evaluate(objects, auxExp«expressionList.get(indexExpression)»);
			MaxValueConfigurationStrategy max«evName»_«expressionList.get(indexExpression)» = new MaxValueConfigurationStrategy(packages, resources, "«MutatorUtils.getTypeName(ev.value as MaxValueType)»", auxObjects, "«(ev.value as MaxValueType).attribute.name»");
			«ENDIF»
			((AttributeEvaluation) ev«evName»_«expressionList.get(indexExpression)»).values.add(max«evName»_«expressionList.get(indexExpression)».getValue());
			«ENDIF»
   			«IF (ev.value as MaxValueType).attribute.getEType.name.equals("EInt")»
			((AttributeEvaluation) ev«evName»_«expressionList.get(indexExpression)»).type = "int";
   			«ENDIF»
   			«IF (ev.value as MaxValueType).attribute.getEType.name.equals("EInt")»
			((AttributeEvaluation) ev«evName»_«expressionList.get(indexExpression)»).type = "float";
   			«ENDIF»
   			«IF (ev.value as MaxValueType).attribute.getEType.name.equals("EDouble")»
			((AttributeEvaluation) ev«evName»_«expressionList.get(indexExpression)»).type = "double";
   			«ENDIF»
			«ENDIF»
   			«ENDIF»
   			«ENDIF»
   			«IF ev instanceof ReferenceEvaluation»
   			ReferenceEvaluation ev«evName»_«expressionList.get(indexExpression)» = new ReferenceEvaluation();
	   		«IF ev.name !== null»
   			   	ev«evName»_«expressionList.get(indexExpression)».name = "«ev.name.name»";
				«IF ev.value instanceof TypedSelection && recursionIndexExpression != 0»
				refNames«expressionList.get(recursionIndexExpression)».add("«ev.name.name»");
				«ENDIF»
	   		«ELSE»
	   			ev«evName»_«expressionList.get(indexExpression)».name = null;
	   			ev«evName»_«expressionList.get(indexExpression)».container = «ev.container»;
	   		«ENDIF»
	   		«IF ev.refName !== null»
   			   	ev«evName»_«expressionList.get(indexExpression)».refName = "«ev.refName.name»";
	   		«ELSE»
	   			ev«evName»_«expressionList.get(indexExpression)».refName = null;
	   		«ENDIF»
			«IF ev.attName !== null»
				ev«evName»_«expressionList.get(indexExpression)».attName = "«ev.attName.name»";
			«ELSE»
				ev«evName»_«expressionList.get(indexExpression)».attName = null;
			«ENDIF»
		   	ev«evName»_«expressionList.get(indexExpression)».operator = "«ev.operator»";
   			«IF ev.value === null»
   				«IF ev.attValue === null»
   				ev«evName»_«expressionList.get(indexExpression)».value = null;
   				«ELSE»
   				«IF ev.attValue instanceof ObjectAttributeType»
   				ev«evName»_«expressionList.get(indexExpression)».value = ModelManager.getStringAttribute("«(ev.attValue as ObjectAttributeType).attribute.name»", hmObjects.get("«(ev.attValue as ObjectAttributeType).objSel.name»").getKey());
   				«ENDIF»
   				«IF ev.attValue instanceof AttributeType»
	   			«IF ev.attValue instanceof StringType || ev.attValue instanceof DoubleType || ev.attValue instanceof BooleanType || ev.attValue instanceof IntegerType»
   					ev«evName»_«expressionList.get(indexExpression)».value = "«(ev.attValue as SpecificStringType).value»";
				«ENDIF»
				«IF ev.attValue instanceof MinValueType»
					MinValueConfigurationStrategy min_ev«evName»_«expressionList.get(indexExpression)» = new MinValueConfigurationStrategy(packages, model, "«MutatorUtils.getTypeName(ev.attValue as MinValueType)»", "«(ev.attValue as MinValueType).attribute.name»");
					ev«evName»_«expressionList.get(indexExpression)».value = min_ev«evName»_«expressionList.get(indexExpression)».getValue().toString();
				«ENDIF»
				«IF ev.attValue instanceof MinValueType»
					MaxValueConfigurationStrategy max_ev«evName»_«expressionList.get(indexExpression)» = new MaxValueConfigurationStrategy(packages, model, "«MutatorUtils.getTypeName(ev.attValue as MaxValueType)»", "«(ev.attValue as MaxValueType).attribute.name»");
					ev«evName»_«expressionList.get(indexExpression)».value = max_ev«evName»_«expressionList.get(indexExpression)».getValue().toString();
				«ENDIF»
   				«ENDIF»
   				«ENDIF»
   			«ELSEIF ev.value instanceof SpecificObjectSelection»
   				«IF ev.refType === null && ev.value.refType === null»
					SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry«evName»_«expressionList.get(indexExpression)» = hmObjects.get("«(ev.value as SpecificObjectSelection).objSel.name»");
					if (entry«evName»_«expressionList.get(indexExpression)» != null) {
   						ev«evName»_«expressionList.get(indexExpression)».value = new SpecificObjectSelection(entry«evName»_«expressionList.get(indexExpression)».getValue().getValue(), entry«evName»_«expressionList.get(indexExpression)».getValue().getKey(), entry«evName»_«expressionList.get(indexExpression)».getKey()).getObject();
   					}
	   			«ELSE»
	   			«IF ev.refType !== null»
					SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry«evName»_«expressionList.get(indexExpression)» = hmObjects.get("«(ev.value as SpecificObjectSelection).objSel.name»");
					if (entry«evName»_«expressionList.get(indexExpression)» != null) {
	   					EObject srcObjExp«evName»_«expressionList.get(indexExpression)» = entry«evName»_«expressionList.get(indexExpression)».getKey();
   						for (EReference ref : srcObjExp«evName»_«expressionList.get(indexExpression)».eClass().getEAllReferences()) {
   							if (ref.getName().equals("«ev.refType.name»")) {
   								ev«evName»_«expressionList.get(indexExpression)».value = srcObjExp«evName»_«expressionList.get(indexExpression)».eGet(ref);		
   							}
	   					}
	   				}
	   			«ENDIF»
	   			«IF ev.value.refType !== null»
					SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry«evName»_«expressionList.get(indexExpression)» = hmObjects.get("«(ev.value as SpecificObjectSelection).objSel.name»");
					if (entry«evName»_«expressionList.get(indexExpression)» != null) {
		   				EObject srcObjExp«evName»_«expressionList.get(indexExpression)» = entry«evName»_«expressionList.get(indexExpression)».getKey();
		   				for (EReference ref : srcObjExp«evName»_«expressionList.get(indexExpression)».eClass().getEAllReferences()) {
	   						if (ref.getName().equals("«ev.value.refType.name»")) {
	   							ev«evName»_«expressionList.get(indexExpression)».value = srcObjExp«evName»_«expressionList.get(indexExpression)».eGet(ref);		
	   						}
	   					}
	   				}
	   			«ENDIF»
	   			«ENDIF»
			«ELSE»
			«IF ev.value instanceof RandomTypeSelection»
			«IF ev.value.expression instanceof Expression»
				//EXPRESSION LEVEL: «nExpression.set(0, nExpression.get(0) + 1)»
				//EXPRESSION LEVEL: «expressionList.add(nExpression.get(0))»
				//INDEX EXPRESSION: «val int nestedIndexExpression = expressionList.size() - 1»
				RandomTypeSelection expRts«expressionList.get(nestedIndexExpression)» = new RandomTypeSelection(packages, model, "«(ev.value as RandomTypeSelection).type.name»");
				List<EObject> expObjects«expressionList.get(nestedIndexExpression)» = expRts«expressionList.get(nestedIndexExpression)».getObjects();
				Expression exp«expressionList.get(nestedIndexExpression)» = new Expression();
				«ev.value.expression.method(nestedIndexExpression, resources)»
				List<EObject> selectedObjects«evName»_«expressionList.get(nestedIndexExpression)» = evaluate(expObjects«expressionList.get(nestedIndexExpression)», exp«expressionList.get(nestedIndexExpression)»);
				EObject object«evName»_«expressionList.get(nestedIndexExpression)» = null;
				if (selectedObjects«evName»_«expressionList.get(nestedIndexExpression)».size() > 0) {
					object«evName»_«expressionList.get(nestedIndexExpression)» = selectedObjects«evName»_«expressionList.get(nestedIndexExpression)».get(ModelManager.getRandomIndex(selectedObjects«evName»_«expressionList.get(nestedIndexExpression)»));
				}
				ev«evName»_«expressionList.get(indexExpression)».value = new SpecificObjectSelection(packages, model, object«evName»_«expressionList.get(nestedIndexExpression)»).getObject();
			«ELSE»
			ev«evName»_«expressionList.get(indexExpression)».value = new RandomTypeSelection(packages, model, "«(ev.value as RandomTypeSelection).type.name»").getObject();
			«ENDIF»
			«ELSE»
			«IF ev.value instanceof TypedSelection»
			«IF ev.value.expression instanceof Expression»
				//EXPRESSION LEVEL: «nExpression.set(0, nExpression.get(0) + 1)»
				//EXPRESSION LEVEL: «expressionList.add(nExpression.get(0))»
				//INDEX EXPRESSION: «val int nestedIndexExpression = expressionList.size() - 1»
				TypedSelection expRts«expressionList.get(nestedIndexExpression)» = new TypedSelection(packages, model, "«(ev.value as TypedSelection).type.name»");
				List<EObject> expObjects«expressionList.get(nestedIndexExpression)» = expRts«expressionList.get(nestedIndexExpression)».getObjects();
				Expression exp«expressionList.get(nestedIndexExpression)» = new Expression();
				List<String> refNames«expressionList.get(nestedIndexExpression)» = new ArrayList<String>();
	   			«ev.value.expression.method(nestedIndexExpression, resources)»
				List<EObject> selectedObjects«evName»_«expressionList.get(nestedIndexExpression)» = evaluate(expObjects«expressionList.get(nestedIndexExpression)», exp«expressionList.get(nestedIndexExpression)»);
				refNames«expressionList.get(nestedIndexExpression)».add("«ev.name.name»");
				Collections.reverse(refNames«expressionList.get(nestedIndexExpression)»);
				selectedObjects«evName»_«expressionList.get(nestedIndexExpression)» = ModelManager.getReferredObjects(refNames«expressionList.get(nestedIndexExpression)», objects, selectedObjects1);
				EObject object«evName»_«expressionList.get(nestedIndexExpression)» = null;
				if (selectedObjects«evName»_«expressionList.get(nestedIndexExpression)».size() > 0) {
					object«evName»_«expressionList.get(nestedIndexExpression)» = selectedObjects«evName»_«expressionList.get(nestedIndexExpression)».get(ModelManager.getRandomIndex(selectedObjects«evName»_«expressionList.get(nestedIndexExpression)»));
				}
				ev«evName»_«expressionList.get(indexExpression)».value = new SpecificObjectSelection(packages, model, object«evName»_«expressionList.get(nestedIndexExpression)»).getObject();
			«ELSE»
			ev«evName»_«expressionList.get(indexExpression)».value = new TypedSelection(packages, model, "«(ev.value as TypedSelection).type.name»").getObject();
			«ENDIF»
			«ENDIF»
			«ENDIF»
			«ENDIF»
			«ENDIF»
   			exp«expressionList.get(indexExpression)».second.add(ev«evName»_«expressionList.get(indexExpression)»);
   			//EVNAME + 1: « evName = evName + 1»
   		«ENDFOR»
   '''
   //END CLAUSES

   //*********
   // EACH CLAUSES
   def each(Expression exp) '''
  		//INDEX EXPRESSION: «val indexExpression = expressionList.size() - 1»
  		«IF exp.first instanceof AttributeEvaluation»
  		//ATTRIBUTE: «val attev = exp.first as AttributeEvaluation»
  		selectedObjects = unique(selectedObjects, "«attev.name.name»", false);
   		«ENDIF»
  		«IF exp.first instanceof ReferenceEvaluation»
  		exp«expressionList.get(indexExpression)».first = new ReferenceEvaluation();
  		//REFERENCE: «val refev = exp.first as ReferenceEvaluation»
  		selectedObjects = unique(selectedObjects, "«refev.name.name»", true);
  		«ENDIF»
  		«FOR Evaluation ev : exp.second»
   			«IF ev instanceof AttributeEvaluation»
   			selectedObjects = unique(selectedObjects, "«ev.name.name»", false);
   			«ENDIF»
   			«IF ev instanceof ReferenceEvaluation»
   			selectedObjects = unique(selectedObjects, "«ev.name.name»", true);
	  		«ENDIF»
   		«ENDFOR»
   		objects = selectedObjects;
   '''
   //END CLAUSES
   //COMMANDS
   
   def execute(MutatorEnvironment e)'''
   //«val String projectRoot = project.location.toFile.absolutePath.replace("\\", "/")»
   		«var String fileName = e.eResource.URI.lastSegment»
		«IF standalone»
		
		String xmiFilename =
		    "«projectRoot»/«program.output»«fileName.replaceAll(".mutator", ".model")»".replace("\\", "/");
		
		«ELSE»
		
		String xmiFilename =
		    «className».class
		        .getProtectionDomain()
		        .getCodeSource()
		        .getLocation()
		        .getPath()
		        .replace("/bin/", "/")
		    + "«program.output + fileName.replaceAll(".mutator", ".model")»";
		xmiFilename = xmiFilename.substring(1, xmiFilename.length());

		«ENDIF»
		«IF standalone == false»
   		//Generate metrics model
		String mutatorecore = MutatorenvironmentPackage.class.getProtectionDomain().getCodeSource().getLocation().getPath().replace("/bin/", "/")+ "model/MutatorEnvironment.ecore";
		mutatorecore = mutatorecore.substring(1, mutatorecore.length()); 
		
		//Load MetaModel
		List<EPackage> mutatorpackages = ModelManager.loadMetaModel(mutatorecore);
		Resource mutatormodel = ModelManager.loadModel(mutatorpackages, URI.createURI("file:/" + xmiFilename).toFileString());
		«ELSE»
MutatorenvironmentPackage.eINSTANCE.eClass();
MiniOCLPackage.eINSTANCE.eClass();

/*
EPackage.Registry.INSTANCE.put(
    MutatorenvironmentPackage.eNS_URI,
    MutatorenvironmentPackage.eINSTANCE
);
*/

List<EPackage> mutatorpackages =
    new ArrayList<EPackage>();

mutatorpackages.add(
    MutatorenvironmentPackage.eINSTANCE
);
mutatorpackages.add(
	MiniOCLPackage.eINSTANCE
);

Resource mutatormodel =
    loadModelHeadless(
        mutatorpackages,
        URI.createURI("file:/" + xmiFilename)
           .toFileString()
    );

if (mutatormodel == null) {
    throw new IOException(
        "Cannot load standalone Wodel semantic model: "
        + xmiFilename
    );
}
		«ENDIF»
		
		Map<String, EObject> hmMutator = getMutators(ModelManager.getObjects(mutatormodel));
		«IF (e.definition as Program).exhaustive == true»
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hashmapEObject = new LinkedHashMap<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>();
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hashmapList = new LinkedHashMap<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>>();
			monitor.subTask("Mutants generation");
			«IF standalone == false»
			Resource model = ModelManager.loadModel(packages, URI.createURI("file:/" + modelFilename).toFileString());
			«ELSE»
			Resource model = loadModelHeadless(packages, URI.createURI("file:/" + modelFilename).toFileString());
			«ENDIF»
			List<Resource> models = new ArrayList<Resource>();
			models.add(model);
			«IF standalone == false»
			Resource seed = ModelManager.loadModel(packages, URI.createURI("file:/" + modelFilename).toFileString());
			«ELSE»
			Resource seed = loadModelHeadless(packages, URI.createURI("file:/" + modelFilename).toFileString());
			«ENDIF»
			List<String> mutPaths = new ArrayList<String>();
			Mutations muts = AppliedMutationsFactory.eINSTANCE.createMutations();
		//COUNTER: «nMethod.set(0, nMethod.get(0) + 1)»
		//COMMAND: «nCommands.set(0, nCommands.get(0) + 1)»
		//REGISTRY COUNTER: «nRegistryMethod.set(0, nRegistryMethod.get(0) + 1)»
		//«var Mutator c = e.commands.get(0)»
		«IF c.name !== null»
			//NAME:«commandName = c.name + nCommands.get(0).toString()»
		«ELSE»
			//NAME:«commandName = "mut" + nCommands.get(0).toString()»
		«ENDIF»
		//METHOD NAME:«methodName = "mutation" + nMethod.get(0).toString()»
		
		«IF standalone == false»
		mutationResults.setNumMutantsGenerated(mutationResults.getNumMutantsGenerated() + «methodName»(packages, models, hashmapEObject, hashmapList, hashmapModelFilenames,
							modelFilename, mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages, null, ecoreURI,
							registry, hashsetMutants, null, hashmapMutVersions, muts, project, monitor, new int[] {0}, serialize, test, classes, executionSeed));
		«ELSE»
		mutationResults.setNumMutantsGenerated(mutationResults.getNumMutantsGenerated() + «methodName»(packages, models, hashmapEObject, hashmapList, hashmapModelFilenames,
							modelFilename, mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages, null, ecoreURI,
							registry, hashsetMutants, null, hashmapMutVersions, muts, monitor, new int[] {0}, serialize, test, classes, executionSeed));
		«ENDIF»
		«ELSE»
		int numMutantsToGenerate = numMutants;
		«IF !(e instanceof Block)»
		int[] k = new int[1];
		k[0] = 0;
		«ELSE»
		k[0] = 0;
		«ENDIF»
		for (int i = 0; i < numMutantsToGenerate; i++) {
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hashmapEObject = new LinkedHashMap<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>();
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hashmapList = new LinkedHashMap<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>>();
			String mutFilename = hashmapModelFilenames.get(modelFilename) + "/" + "Output" + i + ".model";
			String mutFilenameRelativePath = mutFilename.indexOf("/«this.project.getName»/") != -1 ? mutFilename.substring(mutFilename.lastIndexOf("/«this.project.getName»/"), mutFilename.length()) : mutFilename;
			monitor.subTask("Mutant " + (count * numMutantsToGenerate + i + 1) + "/" + totalMutants + ": " + mutFilenameRelativePath);
			String mutPath = hashmapModelFilenames.get(modelFilename) + "/" + "Output" + i + "vs";
			boolean isRepeated = true;
			int attempts = 0;
			int max = 0;
			while ((isRepeated == true) && (attempts < maxAttempts)) {
				«IF standalone == false»
				Resource model = ModelManager.loadModel(packages, URI.createURI("file:/" + modelFilename).toFileString());
				«ELSE»
				Resource model = loadModelHeadless(packages, URI.createURI("file:/" + modelFilename).toFileString());
				«ENDIF»
				List<Resource> models = new ArrayList<Resource>();
				models.add(model);
				«IF standalone == false»
				Resource seed = ModelManager.loadModel(packages, URI.createURI("file:/" + modelFilename).toFileString());
				«ELSE»
				Resource seed = loadModelHeadless(packages, URI.createURI("file:/" + modelFilename).toFileString());
				«ENDIF»
				List<String> mutPaths = new ArrayList<String>();
				Mutations muts = AppliedMutationsFactory.eINSTANCE.createMutations();
				attempts++;
   	   			«FOR c : e.commands »
   	   				«IF c instanceof Mutator»
   	   				«c.compile»
   	   				«ENDIF»
				«ENDFOR»


				//MUTANT COMPLETION AND REGISTRY
				Map<String, List<String>> rules = new LinkedHashMap<String, List<String>>();
       			«FOR constraint : e.constraints»
				if (rules.get("«constraint.type.name»") == null) {
					rules.put("«constraint.type.name»", new ArrayList<String>());
				}
				List<String> newrules = rules.get("«constraint.type.name»");
				«IF constraint.expressions !== null»
       			«FOR expression : constraint.expressions»
				newrules.add("«WodelUtils.getConstraintText(fileName, expression)»");
       			«ENDFOR»
      			«ENDIF»
       			«IF constraint.rules !== null»
       			«FOR rule : constraint.rules»
				newrules.add("«rule»");
       			«ENDFOR»
      			«ENDIF»
				rules.put("«constraint.type.name»", newrules);
      			«ENDFOR»
				int[] mutantIndex = new int[1];
				mutantIndex[0] = i;
				Mutations registryMuts = MutatorUtils.copyMutationsForRegistry(muts);
				«IF standalone == false»
				isRepeated = registryMutant(ecoreURI, packages, registeredPackages, localRegisteredPackages, seed, model, rules, registryMuts, modelFilename, mutFilename, registry, hashsetMutants, hashmapModelFilenames, mutantIndex, mutPaths, hashmapMutVersions, project, serialize, test, classes, this.getClass(), true);
				«ELSE»
				isRepeated = registryMutantStandalone(ecoreURI, packages, registeredPackages, localRegisteredPackages, seed, model, rules, registryMuts, modelFilename, mutFilename, registry, hashsetMutants, hashmapModelFilenames, mutantIndex, mutPaths, hashmapMutVersions, "«project.name»", serialize, test, classes, «className».class, true);
				«ENDIF»
				if (isRepeated == false) {
					mutationResults.setNumMutantsGenerated(mutationResults.getNumMutantsGenerated() + 1);
				}

				//Reload input
				try {
					model.unload();
					model.load(null); 
					seed.unload();
					seed.load(null);
				} catch (Exception e) {}
			}
			monitor.worked(1);
		}
		«ENDIF»
		count++;
		mutatedObjects = null;
		
	'''
	
	def executeBlock(MutatorEnvironment e,
		Block b
	)'''
	
	//«val String projectRoot = project.location.toFile.absolutePath.replace("\\", "/")»
   		«var String fileName = e.eResource.URI.lastSegment»
		«IF standalone»
		
		String xmiFilename =
		    "«projectRoot»/«program.output»«fileName.replaceAll(".mutator", ".model")»".replace("\\", "/");
		
		«ELSE»
		
		String xmiFilename =
		    «className».class
		        .getProtectionDomain()
		        .getCodeSource()
		        .getLocation()
		        .getPath()
		        .replace("/bin/", "/")
		    + "«program.output + fileName.replaceAll(".mutator", ".model")»";
		xmiFilename = xmiFilename.substring(1, xmiFilename.length());
		«ENDIF»
		//Generate metrics model
		«IF standalone == false»
		String mutatorecore = MutatorenvironmentPackage.class.getProtectionDomain().getCodeSource().getLocation().getPath().replace("/bin/", "/")+ "model/MutatorEnvironment.ecore";
		mutatorecore = mutatorecore.substring(1, mutatorecore.length()); 
		//Load MetaModel
		List<EPackage> mutatorpackages = ModelManager.loadMetaModel(mutatorecore);
		Resource mutatormodel = ModelManager.loadModel(mutatorpackages, URI.createURI("file:/" + xmiFilename).toFileString());
		«ELSE»
MutatorenvironmentPackage.eINSTANCE.eClass();
MiniOCLPackage.eINSTANCE.eClass();

/*
EPackage.Registry.INSTANCE.put(
    MutatorenvironmentPackage.eNS_URI,
    MutatorenvironmentPackage.eINSTANCE
);
*/


List<EPackage> mutatorpackages =
    new ArrayList<EPackage>();

mutatorpackages.add(
    MutatorenvironmentPackage.eINSTANCE
);
mutatorpackages.add(
	MiniOCLPackage.eINSTANCE
);


Resource mutatormodel =
    loadModelHeadless(
        mutatorpackages,
        URI.createURI("file:/" + xmiFilename)
           .toFileString()
    );

if (mutatormodel == null) {
    throw new IOException(
        "Cannot load standalone Wodel semantic model: "
        + xmiFilename
    );
}
		«ENDIF»
		
		Map<String, EObject> hmMutator = getMutators(ModelManager.getObjects(mutatormodel));
		
		«IF (e.definition as Program).exhaustive == true»
		Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hashmapEObject = new LinkedHashMap<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>();
		Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hashmapList = new LinkedHashMap<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>>();
		«IF standalone == false»
		Resource model = ModelManager.loadModel(packages, URI.createURI("file:/" + modelFilename).toFileString());
		«ELSE»
		Resource model = loadModelHeadless(packages, URI.createURI("file:/" + modelFilename).toFileString());
		«ENDIF»
		List<Resource> models = new ArrayList<Resource>();
		models.add(model);
		«IF standalone == false»
		Resource seed = ModelManager.loadModel(packages, URI.createURI("file:/" + modelFilename).toFileString());
		«ELSE»
		Resource seed = loadModelHeadless(packages, URI.createURI("file:/" + modelFilename).toFileString());
		«ENDIF»
		List<String> mutPaths = new ArrayList<String>();
		Mutations muts = AppliedMutationsFactory.eINSTANCE.createMutations();

		//COUNTER: «nMethod.set(0, nMethod.get(0) + 1)»	
		//COMMAND: «nCommands.set(0, nCommands.get(0) + 1)»
		//REGISTRY COUNTER: «nRegistryMethod.set(0, nRegistryMethod.get(0) + 1)»
		«IF b.commands.size() > 0»
		//«var c = b.commands.get(0)»
		«IF c.name !== null»
			//NAME:«commandName = c.name + nCommands.get(0).toString()»
		«ELSE»
			//NAME:«commandName = "mut" + nCommands.get(0).toString()»
		«ENDIF»
		«ENDIF»
		//METHOD NAME:«methodName = "mutation" + nMethod.get(0).toString()»
		
	   		«IF (e.definition as Program).exhaustive == true»
			try {
			«ENDIF»
		«IF standalone == false»
		«methodName»(packages, models, hashmapEObject, hashmapList, hashmapModelFilenames,
							modelFilename, mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,
							registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, project, monitor, k, serialize, test, classes);
		«ELSE»
		«methodName»(packages, models, hashmapEObject, hashmapList, hashmapModelFilenames,
							modelFilename, mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,
							registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, monitor, k, serialize, test, classes);
		«ENDIF»
		numMutantsGenerated = k[0];
		«ELSE»
		int numMutantsToGenerate = numMutants;
		«IF !(b instanceof Block)»
		int[] k = new int[1];
		k[0] = 0;
		«ELSE»
		k[0] = 0;
		«ENDIF»
   	   			
		for (int i = 0; i < numMutantsToGenerate; i++) {
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hashmapEObject = new LinkedHashMap<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>();
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hashmapList = new LinkedHashMap<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>>();
   	   		«IF b.from.size == 0»
			String mutFilename = hashmapModelFilenames.get(modelFilename) + "/«b.name»/Output" + i + ".model";
			String mutPath = hashmapModelFilenames.get(modelFilename) + "/«b.name»/Output" + i + "vs";
   	   		«ELSE»
			String mutFilename = hashmapModelFilenames.get(modelFilename) + "/«b.name»/" + hashmapModelFolders.get(modelFilename) + "/Output" + i + ".model";
			String mutPath = hashmapModelFilenames.get(modelFilename) + "/«b.name»/" + hashmapModelFolders.get(modelFilename) + "/Output" + i + "vs";
   	   		«ENDIF»
			boolean isRepeated = true;
			int attempts = 0;
			int max = 0;
			while ((isRepeated == true) && (attempts < maxAttempts)) {
				«IF standalone == false»
				Resource model = ModelManager.loadModel(packages, URI.createURI("file:/" + modelFilename).toFileString());
				«ELSE»
				Resource model = loadModelHeadless(packages, URI.createURI("file:/" + modelFilename).toFileString());
				«ENDIF»
				List<Resource> models = new ArrayList<Resource>();
				models.add(model);
				«IF standalone == false»
				Resource seed = ModelManager.loadModel(packages, URI.createURI("file:/" + modelFilename).toFileString());
				«ELSE»
				Resource seed = loadModelHeadless(packages, URI.createURI("file:/" + modelFilename).toFileString());
				«ENDIF»
				List<String> mutPaths = new ArrayList<String>();
				Mutations muts = AppliedMutationsFactory.eINSTANCE.createMutations();
				attempts++;
   	   			«FOR Mutator c : b.commands»
   	   				«IF c instanceof Mutator»
   	   				«c.compile»
   	   				«ENDIF»
				«ENDFOR»
				
				// MUTANT COMPLETION AND REGISTRY
				Map<String, List<String>> rules = new LinkedHashMap<String, List<String>>();
	       		«FOR constraint : e.constraints»
				if (rules.get("«constraint.type.name»") == null) {
					rules.put("«constraint.type.name»", new ArrayList<String>());
				}
				List<String> newrules = rules.get("«constraint.type.name»");
	       		«IF constraint.expressions !== null»
       			«FOR expression : constraint.expressions»
				newrules.add("«WodelUtils.getConstraintText(fileName, expression)»");
       			«ENDFOR»
       			«ENDIF»
       			«IF constraint.rules !== null»
       			«FOR rule : constraint.rules»
				newrules.add("«rule»");
       			«ENDFOR»
       			«ENDIF»
				rules.put("«constraint.type.name»", newrules);
       			«ENDFOR»
				int[] mutantIndex = new int[1];
				mutantIndex[0] = i;
				Mutations registryMuts = MutatorUtils.copyMutationsForRegistry(muts);
				«IF standalone == false»
				//System.out.println("ecoreURI: " + ecoreURI);
				isRepeated = registryMutantWithBlocks(ecoreURI, packages, registeredPackages, localRegisteredPackages, seed, model, rules, registryMuts, modelFilename, mutFilename, registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "«b.name»", fromNames, mutantIndex, mutPaths, hashmapMutVersions, project, serialize, test, classes, this.getClass(), true, false);
				«ELSE»
				//System.out.println("ecoreURI: " + ecoreURI);
				isRepeated = registryMutantWithBlocksStandalone(ecoreURI, packages, registeredPackages, localRegisteredPackages, seed, model, rules, registryMuts, modelFilename, mutFilename, registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "«b.name»", fromNames, mutantIndex, mutPaths, hashmapMutVersions, "«project.name»", serialize, test, classes, «className».class, true, false);
				«ENDIF»
				if (isRepeated == false) {
					numMutantsGenerated++;
					k[0] = k[0] + 1;
				}

				//Reload input
				try {
					model.unload();
					model.load(null);
					seed.unload();
					seed.load(null);
				} catch (Exception e) {}
			}
		}		
		«ENDIF»
   		«IF b.repeat == Repeat.YES»
   		hashmapMutants.put(modelFilename, hashsetMutantsBlock);
   		«ENDIF»
   		«IF (e.definition as Program).exhaustive == true»
		//Frees memory
		}
		finally {
		    MutatorUtils.disposeResource(model);
		    MutatorUtils.disposeResource(seed);
		    MutatorUtils.disposeResource(mutatormodel);
		}
		«ENDIF»
   		
   		mutatedObjects = null;
	'''
	
	def compile(Mutator e)'''
	«IF e instanceof CompositeMutator»
		//COUNTER: «nMethod.set(0, nMethod.get(0) + MutatorUtils.mutatorSize(e))»
		//COMPOSITE REGISTRY COUNTER: «nCompositeRegistryMethod.set(0, nCompositeRegistryMethod.get(0) + 1)»
		«IF (e.fixed == 0)»
		«IF (e.max - e.min > 0)»
		int max«nCompositeCommands.get(0)» = getRandom(«e.max - e.min») + «e.min»;
		«ENDIF»
		«IF (e.min == 0) && (e.max == 0)»
		int max«nCompositeCommands.get(0)» = 1;
		«ELSEIF (e.min == e.max)»
		int max«nCompositeCommands.get(0)» = «e.min»;
		«ENDIF»
		«ELSE»
		int max«nCompositeCommands.get(0)» = «e.fixed»;
		«ENDIF»
		for (int j«nCompositeCommands.get(0)» = 0; j«nCompositeCommands.get(0)» < max«nCompositeCommands.get(0)»; j«nCompositeCommands.get(0)»++) {
		«IF e.name !== null»
			//NAME:«compositeCommandName = e.name + nCompositeCommands.get(0).toString()»
		«ELSE»
			//NAME:«compositeCommandName = "composite"+ nCompositeCommands.get(0).toString()»
		«ENDIF»

		//COMPOSITE METHOD NAME:«compositeMethodName = compositeCommands.get(nCompositeCommands.get(0))»
		//COMMAND: «nCompositeCommands.set(0, nCompositeCommands.get(0) + MutatorUtils.compositeMutatorSize(e))»
		List<Mutator> l«compositeCommandName» = «compositeMethodName»(packages, models, hashmapEObject, hashmapList, serialize, test, classes);
		//COUNTER: «nRegistryMutation.set(0, nRegistryMutation.get(0) + 1)»
		//REGISTRY METHOD NAME:«compositeRegistryMethodName = "compositeRegistry" + nCompositeRegistryMethod.toString()»
		
		if (l«compositeCommandName» != null) {
			for (Mutator mut : l«compositeCommandName») {
				«IF executeMutation == true»
				if (mut != null) {
					Object mutated = mut.mutate();
				}
				«ENDIF»
			}
			AppMutation appMut = «compositeRegistryMethodName»(l«compositeCommandName», hmMutator, seed);
			if (appMut != null) {
				muts.getMuts().add(appMut);
			}
		}
		}
		//COUNTER: «nRegistryMutation.set(0, nRegistryMutation.get(0) + MutatorUtils.mutatorSize(e))»
	«ELSE»
		//COUNTER: «nMethod.set(0, nMethod.get(0) + 1)»	
		//COMMAND: «nCommands.set(0, nCommands.get(0) + 1)»
		//REGISTRY COUNTER: «nRegistryMethod.set(0, nRegistryMethod.get(0) + 1)»
		«IF (e.fixed == 0)»
		«IF (e.max - e.min > 0)»
		max = getRandom(«e.max - e.min») + «e.min»;
		«ENDIF»
		«IF (e.min == 0) && (e.max == 0)»
		max = 1;
		«ELSEIF (e.min == e.max)»
		max = «e.min»;
		«ENDIF»
		«ELSE»
		max = «e.fixed»;
		«ENDIF»
		«IF !(e.eContainer instanceof Block)»
		k[0] = 0;
		«ENDIF»
		for (int j = 0; j < max; j++) {
		«IF e.name !== null»
			//NAME:«commandName = e.name + nCommands.get(0).toString()»
		«ELSE»
			//NAME:«commandName = "com" + nCommands.get(0).toString()»
		«ENDIF»
		//METHOD NAME:«methodName = "mutation" + nMethod.get(0).toString()»
		
		List<Mutator> l«commandName» = «methodName»(packages, models, hashmapEObject, hashmapList, serialize, test, classes);
		//COUNTER: «nRegistryMutation.set(0, nRegistryMutation.get(0) + 1)»
		//REGISTRY METHOD NAME:«registryMethodName = "registry" + nRegistryMethod.get(0).toString()»
		
		if (l«commandName» != null) {
			for (Mutator mut : l«commandName») {
				«IF executeMutation == true»
				if (mut != null) {
										/*
									     * IMPORTANT:
									     * Capture the removed EObject from the PRE-MUTATION
									     * source model. Do not use mut.getObject() here:
									     * RemoveObjectMutator only populates that information
									     * during mutate().
									     */
									    EObject clue =
									        findEObjectForRegistry(
									            seed,
									            model,
									            mut.getObject(),
									            null,
									            null,
									            mutPaths,
									            packages);
					
					Object mutated = mut.mutate();
					if (mutated != null) {
						«IF e instanceof CreateObjectMutator || e instanceof SelectObjectMutator || e instanceof CloneObjectMutator || e instanceof RetypeObjectMutator»
						«IF e.name !== null»
						if (mutated instanceof EObject) {
						«IF e instanceof CreateObjectMutator»
							SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(mut.getModel(), mut.getMetaModel());
							SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(mut.getObject(), resourceEntry);
							hashmapEObject.put("«e.name»", entry);
						«ENDIF»
						«IF e instanceof SelectObjectMutator»
							«IF e.object instanceof SpecificObjectSelection || e.object instanceof RandomTypeSelection»
							SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(mut.getModel(), mut.getMetaModel());
							SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(mut.getObject(), resourceEntry);
							hashmapEObject.put("«e.name»", entry);
							«ENDIF»
							«IF e.object instanceof CompleteTypeSelection»
							List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEObjects = null;
							if (hashmapList.get("«e.name»") != null) {
								listEObjects = hashmapList.get("«e.name»");
							}
							else {
								listEObjects = new ArrayList<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>();
							}
							SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(mut.getModel(), mut.getMetaModel());
							SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(mut.getObject(), resourceEntry);
							listEObjects.add(entry);
							hashmapList.put("«e.name»", listEObjects);
							«ENDIF»
						«ENDIF»
						«IF e instanceof CloneObjectMutator»
							«IF e.object instanceof SpecificObjectSelection || e.object instanceof RandomTypeSelection»
							SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(mut.getModel(), mut.getMetaModel());
							SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(mut.getObject(), resourceEntry);
							hashmapEObject.put("«e.name»", entry);
							«ENDIF»
							«IF e.object instanceof CompleteTypeSelection»
							List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEObjects = null;
							if (hashmapList.get("«e.name»") != null) {
								listEObjects = hashmapList.get("«e.name»");
							}
							else {
								listEObjects = new ArrayList<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>();
							}
							SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(mut.getModel(), mut.getMetaModel());
							SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(mut.getObject(), resourceEntry);
							listEObjects.add(entry);
							hashmapList.put("«e.name»", listEObjects);
							«ENDIF»
						«ENDIF»
						«IF e instanceof RetypeObjectMutator»
							«IF e.object instanceof SpecificObjectSelection || e.object instanceof RandomTypeSelection»
							SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(mut.getModel(), mut.getMetaModel());
							SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(mut.getObject(), resourceEntry);
							hashmapEObject.put("«e.name»", entry);
							«ENDIF»
							«IF e.object instanceof CompleteTypeSelection»
							List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEObjects = null;
							if (hashmapList.get("«e.name»") != null) {
								listEObjects = hashmapList.get("«e.name»");
							}
							else {
								listEObjects = new ArrayList<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>();
							}
							SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(mut.getModel(), mut.getMetaModel());
							SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(mut.getObject(), resourceEntry);
							listEObjects.add(entry);
							hashmapList.put("«e.name»", listEObjects);
							«ENDIF»
						«ENDIF»
						}
						«ENDIF»
						«ENDIF»
						«IF e.name !== null»
						«IF e instanceof SelectSampleMutator»
						if (mutated instanceof List<?>) {
							List<EObject> mutObjects = ((SelectSampleMutator) mut).getObjects();
							List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEObjects = null;
							if (hashmapList.get("«e.name»") != null) {
								listEObjects = hashmapList.get("«e.name»");
							}
							else {
								listEObjects = new ArrayList<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>();
							}
							SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(mut.getModel(), mut.getMetaModel());
							SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(mut.getObject(), resourceEntry);
							listEObjects.add(entry);
							hashmapList.put("«e.name»", listEObjects);
						}
						«ENDIF»
						«ENDIF»
						«IF (e instanceof SelectObjectMutator == false) && (e instanceof SelectSampleMutator == false)»
						String mutatorPath = mutPath + "/Output" + i + "_" + j + "_" + k[0] + "_«nMethod.get(0)».model";
						ModelManager.saveOutModel(model, mutatorPath);
						if (mutPaths.contains(mutatorPath) == false) {
							mutPaths.add(mutatorPath);
						}
						«ENDIF»
						AppMutation appMut = «registryMethodName»(mut, hmMutator, seed, model, clue, mutPaths, packages);
						if (appMut != null) {
							muts.getMuts().add(appMut);
						}
					}
				}
				«ENDIF»
			}
		}
		}
	«ENDIF»
    '''
	def compile(Mutator e, int index)'''
		//COUNTER: «nMethod.set(0, index)»	
		//COMMAND: «nCommands.set(0, nCommands.get(0) + 1)»
		//REGISTRY COUNTER: «nRegistryMethod.set(0, index)»
		«IF (e.fixed == 0)»
		«IF (e.max - e.min > 0)»
		max = getRandom(«e.max - e.min») + «e.min»;
		«ENDIF»
		«IF (e.min == 0) && (e.max == 0)»
		max = 1;
		«ELSEIF (e.min == e.max)»
		max = «e.min»;
		«ENDIF»
		«ELSE»
		max = «e.fixed»;
		«ENDIF»
		«IF !(e.eContainer instanceof Block)»
		k[0] = 0;
		«ENDIF»
		for (int j = 0; j < max; j++) {
		«IF e.name !== null»
			//NAME:«commandName = e.name + nCommands.toString()»
		«ELSE»
			//NAME:«commandName = nCommands.toString()»
		«ENDIF»
		//METHOD NAME:«methodName = "mutation" + nMethod.toString()»
		
		List<Mutator> l«commandName» = «methodName»(packages, models, hashmapEObject, hashmapList, serialize, test, classes);
		//COUNTER: «nRegistryMutation.set(0, nRegistryMutation.get(0) + 1)»
		//REGISTRY METHOD NAME:«registryMethodName = "registry" + nRegistryMethod.get(0).toString()»
		
		if (l«commandName» != null) {
		if (overallMutators.get(«index») == null) {
			for (Mutator mut : l«commandName») {
				«IF executeMutation == true»
				if (mut != null) {
					Object mutated = mut.mutate();
					if (mutated != null) {
						«IF e instanceof CreateObjectMutator || e instanceof SelectObjectMutator || e instanceof CloneObjectMutator || e instanceof RetypeObjectMutator»
						«IF e.name !== null»
						if (mutated instanceof EObject) {
						«IF e instanceof CreateObjectMutator»
							SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(mut.getModel(), mut.getMetaModel());
							SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(mut.getObject(), resourceEntry);
							hashmapEObject.put("«e.name»", entry);
						«ENDIF»
						«IF e instanceof SelectObjectMutator»
							«IF e.object instanceof SpecificObjectSelection || e.object instanceof RandomTypeSelection»
							SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(mut.getModel(), mut.getMetaModel());
							SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(mut.getObject(), resourceEntry);
							hashmapEObject.put("«e.name»", entry);
							«ENDIF»
							«IF e.object instanceof CompleteTypeSelection»
							List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEObjects = null;
							if (hashmapList.get("«e.name»") != null) {
								listEObjects = hashmapList.get("«e.name»");
							}
							else {
								listEObjects = new ArrayList<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>();
							}
							SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(mut.getModel(), mut.getMetaModel());
							SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(mut.getObject(), resourceEntry);
							listEObjects.add(entry);
							hashmapList.put("«e.name»", listEObjects);
							«ENDIF»
						«ENDIF»
						«IF e instanceof CloneObjectMutator»
							«IF e.object instanceof SpecificObjectSelection || e.object instanceof RandomTypeSelection»
							SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(mut.getModel(), mut.getMetaModel());
							SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(mut.getObject(), resourceEntry);
							hashmapEObject.put("«e.name»", entry);
							«ENDIF»
							«IF e.object instanceof CompleteTypeSelection»
							List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEObjects = null;
							if (hashmapList.get("«e.name»") != null) {
								listEObjects = hashmapList.get("«e.name»");
							}
							else {
								listEObjects = new ArrayList<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>();
							}
							SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(mut.getModel(), mut.getMetaModel());
							SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(mut.getObject(), resourceEntry);
							listEObjects.add(entry);
							hashmapList.put("«e.name»", listEObjects);
							«ENDIF»
						«ENDIF»
						«IF e instanceof RetypeObjectMutator»
							«IF e.object instanceof SpecificObjectSelection || e.object instanceof RandomTypeSelection»
							SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(mut.getModel(), mut.getMetaModel());
							SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(mut.getObject(), resourceEntry);
							hashmapEObject.put("«e.name»", entry);
							«ENDIF»
							«IF e.object instanceof CompleteTypeSelection»
							List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEObjects = null;
							if (hashmapList.get("«e.name»") != null) {
								listEObjects = hashmapList.get("«e.name»");
							}
							else {
								listEObjects = new ArrayList<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>();
							}
							SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(mut.getModel(), mut.getMetaModel());
							SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(mut.getObject(), resourceEntry);
							listEObjects.add(entry);
							hashmapList.put("«e.name»", listEObjects);
							«ENDIF»
						«ENDIF»
						}
						«ENDIF»
						«ENDIF»
						«IF e.name !== null»
						«IF e instanceof SelectSampleMutator»
						if (mutated instanceof List<?>) {
							List<EObject> mutObjects = ((SelectSampleMutator) mut).getObjects();
							List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEObjects = null;
							if (hashmapList.get("«e.name»") != null) {
								listEObjects = hashmapList.get("«e.name»");
							}
							else {
								listEObjects = new ArrayList<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>();
							}
							SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(mut.getModel(), mut.getMetaModel());
							SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(mut.getObject(), resourceEntry);
							listEObjects.add(entry);
							hashmapList.put("«e.name»", listEObjects);
						}
						«ENDIF»
						«ENDIF»
						«IF (e instanceof SelectObjectMutator == false) && (e instanceof SelectSampleMutator == false)»
						String mutatorPath = mutPath + "/Output" + i + "_" + j + "_" + k[0] + "_«nMethod».model";
						ModelManager.saveOutModel(model, mutatorPath);
						if (mutPaths.contains(mutatorPath) == false) {
							mutPaths.add(mutatorPath);
						}
						«ENDIF»
						AppMutation appMut = «registryMethodName»(mut, hmMutator, seed, mutPaths, packages);
						if (appMut != null) {
							muts.getMuts().add(appMut);
						}
					}
				}
				«ENDIF»
			}
		}
		else {
			Mutator mut = overallMutators.get(«index»);
			mut.setModel(model);
			Object mutated = mut.mutate();
			if (mutated != null) {
				«IF e instanceof CreateObjectMutator || e instanceof SelectObjectMutator || e instanceof CloneObjectMutator || e instanceof RetypeObjectMutator»
				«IF e.name !== null»
				if (mutated instanceof EObject) {
				«IF e instanceof CreateObjectMutator»
					SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(mut.getModel(), mut.getMetaModel());
					SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(mut.getObject(), resourceEntry);
					hashmapEObject.put("«e.name»", entry);
				«ENDIF»
				«IF e instanceof SelectObjectMutator»
					«IF e.object instanceof SpecificObjectSelection || e.object instanceof RandomTypeSelection»
					SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(mut.getModel(), mut.getMetaModel());
					SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(mut.getObject(), resourceEntry);
					hashmapEObject.put("«e.name»", entry);
				«ENDIF»
				«IF e.object instanceof CompleteTypeSelection»
					List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEObjects = null;
					if (hashmapList.get("«e.name»") != null) {
						listEObjects = hashmapList.get("«e.name»");
					}
					else {
						listEObjects = new ArrayList<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>();
					}
					SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(mut.getModel(), mut.getMetaModel());
					SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(mut.getObject(), resourceEntry);
					listEObjects.add(entry);
					hashmapList.put("«e.name»", listEObjects);
					«ENDIF»
				«ENDIF»
				«IF e instanceof CloneObjectMutator»
					«IF e.object instanceof SpecificObjectSelection || e.object instanceof RandomTypeSelection»
					SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(mut.getModel(), mut.getMetaModel());
					SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(mut.getObject(), resourceEntry);
					hashmapEObject.put("«e.name»", entry);
				«ENDIF»
				«IF e.object instanceof CompleteTypeSelection»
					List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEObjects = null;
					if (hashmapList.get("«e.name»") != null) {
						listEObjects = hashmapList.get("«e.name»");
					}
					else {
						listEObjects = new ArrayList<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>();
					}
					SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(mut.getModel(), mut.getMetaModel());
					SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(mut.getObject(), resourceEntry);
					listEObjects.add(entry);
					hashmapList.put("«e.name»", listEObjects);
				«ENDIF»
				«ENDIF»
				«IF e instanceof RetypeObjectMutator»
					«IF e.object instanceof SpecificObjectSelection || e.object instanceof RandomTypeSelection»
					SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(mut.getModel(), mut.getMetaModel());
					SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(mut.getObject(), resourceEntry);
					hashmapEObject.put("«e.name»", entry);
				«ENDIF»
				«IF e.object instanceof CompleteTypeSelection»
					List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEObjects = null;
					if (hashmapList.get("«e.name»") != null) {
						listEObjects = hashmapList.get("«e.name»");
					}
					else {
						listEObjects = new ArrayList<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>();
					}
					SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(mut.getModel(), mut.getMetaModel());
					SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(mut.getObject(), resourceEntry);
					listEObjects.add(entry);
					hashmapList.put("«e.name»", listEObjects);
				«ENDIF»
				«ENDIF»
				}
				«ENDIF»
				«ENDIF»
				«IF e.name !== null»
				«IF e instanceof SelectSampleMutator»
				if (mutated instanceof List<?>) {
					List<EObject> mutObjects = ((SelectSampleMutator) mut).getObjects();
					List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEObjects = null;
					if (hashmapList.get("«e.name»") != null) {
						listEObjects = hashmapList.get("«e.name»");
					}
					else {
						listEObjects = new ArrayList<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>();
					}
					SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(EMFCopier.clone(mut.getModel()), mut.getMetaModel());
					SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(mut.getObject(), resourceEntry);
					listEObjects.add(entry);
					hashmapList.put("«e.name»", listEObjects);
				}
				«ENDIF»
				«ENDIF»
				«IF (e instanceof SelectObjectMutator == false) && (e instanceof SelectSampleMutator == false)»
				String mutatorPath = mutPath + "/Output" + i + "_" + j + "_" + k[0] + "_«nMethod».model";
				ModelManager.saveOutModel(model, mutatorPath);
				if (mutPaths.contains(mutatorPath) == false) {
					mutPaths.add(mutatorPath);
				}
				«ENDIF»
				AppMutation appMut = «registryMethodName»(mut, hmMutator, seed, mutPaths, packages);
				if (appMut != null) {
					muts.getMuts().add(appMut);
			}
		}
		}
		}
		}
	'''
	
   //END COMMANDS
   //*************
}