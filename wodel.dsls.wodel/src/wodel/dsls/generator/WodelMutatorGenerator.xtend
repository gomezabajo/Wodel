package wodel.dsls.generator

import org.eclipse.xtext.generator.AbstractGenerator
import java.util.List
import org.eclipse.core.resources.IProject
import mutatorenvironment.Program
import java.util.Map
import mutatorenvironment.Mutator
import java.util.HashMap
import org.osgi.framework.Bundle
import wodel.utils.manager.ProjectUtils
import java.io.File
import java.util.ArrayList
import mutatorenvironment.MutatorEnvironment
import wodel.utils.manager.ModelManager
import mutatorenvironment.ModifyInformationMutator
import mutatorenvironment.RandomTypeSelection
import mutatorenvironment.CompleteTypeSelection
import mutatorenvironment.SpecificObjectSelection
import mutatorenvironment.SpecificClosureSelection
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
import mutatorenvironment.ArithmeticOperator
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
import wodel.dsls.WodelUtils
import mutatorenvironment.Source
import mutatorenvironment.SelectObjectMutator
import mutatorenvironment.SelectSampleMutator
import mutatorenvironment.AttributeEvaluation
import mutatorenvironment.ReferenceEvaluation
import org.eclipse.emf.ecore.EStructuralFeature
import mutatorenvironment.SampleClause
import mutatorenvironment.CloneObjectMutator
import org.eclipse.emf.ecore.EClass
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
import org.eclipse.emf.ecore.util.EcoreUtil
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
	private int nMethod = 0
	private int nMethodCall = 0
	private int nCompositeMethod = 0
	private int nRegistryMethod = 0
	private int nRegistryMethodCall = 0
	private int nCompositeRegistryMethod = 0
	private List<String> compositeCommands
	private List<String> compositeRegistryCommands
	private int nCommands = 0
	private int nMutation = 0
	private int nRegistryMutation = 0
	private int nCompositeCommands = 0
	private int nExpression = 0
	private List<Integer> expressionList
	private int nReference = 0
	private String methodName
	private String registryMethodName
	private String commandName
	private String attributeName
	private String referenceName
	private String compositeMethodName
	private String compositeRegistryMethodName
	private String compositeCommandName
	private boolean executeMutation = true
	private int nMut

	protected boolean standalone = false
	protected IProject project = null
	protected String fileName
	protected String className
	protected String path
	protected String xmiFileName
	protected Program program
	protected Map<Mutator, Integer> mutIndexes = new HashMap<Mutator, Integer>()
	
	protected Bundle bundle
	protected String metricsURL
	protected String mutatorURL

	def String getProjectName() {
		var String projectName = null
		if (ProjectUtils.project !== null) {
			projectName = ProjectUtils.project.name
		}
		else {
			projectName = ProjectUtils.projectName
		}
		return projectName
	}

	def List<String> getMutators(File[] files) {
		var List<String> mutators = new ArrayList<String>()
		if (files !== null) {
			for (File file : files) {
				if (file !== null) {
					if (file.isFile == true) {
						if (file.getName().endsWith(".mutator")) {
							var mutator = file.getName().replaceAll(".mutator", "")
							if (!mutators.contains(mutator)) {
								mutators.add(mutator)
							}
						}
					}
					else if (file.isDirectory == true) {
						var List<String> nextMutators = new ArrayList<String>()
						nextMutators.addAll(getMutators(file.listFiles))
						for (String nextMutator : nextMutators) {
							if (!mutators.contains(nextMutator)) {
								mutators.add(nextMutator)
							}
						}
					}
				}
			}
		}
		return mutators
	}
	
	def String getMutatorPath(MutatorEnvironment e, File[] files) {
		var String mutatorPath = null
		if (mutatorPath === null && files !== null) {
			for (File file : files) {
				if (mutatorPath !== null) {
					return mutatorPath
				}
				if (file !== null) {
				 	if (file.isFile == true) {
						if (file.getName().equals(fileName)) {
							var mutatorFolderAndFile = file.path.substring(file.path.indexOf(getProjectName)).replace("\\", "/")
							mutatorPath = "file:/" + ModelManager.getWorkspaceAbsolutePath(e)+"/"+mutatorFolderAndFile
						}
					}
					else  {
						mutatorPath = getMutatorPath(e, file.listFiles)
					}
				}
			}
		}
		return mutatorPath
	}
	
	
	def launcher(MutatorEnvironment e, List<String> mutators) '''

package mutator.«getProjectName»;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
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
public class «getProjectName.replaceAll("[.]", "_")»DynamicLauncher implements IMutatorExecutor {
«ELSE»
public class «getProjectName.replaceAll("[.]", "_")»StandaloneLauncher implements IMutatorStandaloneExecutor {
«ENDIF»

	«IF standalone == false»
	public MutationResults execute(int maxAttempts, int numMutants, boolean registry, boolean metrics, boolean debugMetrics, String[] blockNames, IProject project, IProgressMonitor monitor, boolean serialize, Object testObject, TreeMap<String, List<String>> classes, HashMap<String, EPackage> registeredPackages) throws ReferenceNonExistingException, WrongAttributeTypeException, 
												  MaxSmallerThanMinException, AbstractCreationException, ObjectNoTargetableException, 
												  ObjectNotContainedException, MetaModelNotFoundException, ModelNotFoundException, IOException {
	«ELSE»
	public MutationResults execute(int maxAttempts, int numMutants, boolean registry, boolean metrics, boolean debugMetrics, String[] blockNames, IProgressMonitor monitor, boolean serialize, Object testObject, TreeMap<String, List<String>> classes, HashMap<String, EPackage> registeredPackages) throws ReferenceNonExistingException, WrongAttributeTypeException, 
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
		MutationResults results«mutatorName» = mut«mutatorName».execute(maxAttempts, numMutants, registry, metrics, debugMetrics, packages, registeredPackages, localRegisteredPackages, blockNames, project, monitor, serialize, test, classes);
	«ELSE»
		MutatorUtils mut«mutatorName» = new «mutatorName»Standalone();
		MutationResults results«mutatorName» = mut«mutatorName».execute(maxAttempts, numMutants, registry, metrics, debugMetrics, packages, registeredPackages, localRegisteredPackages, blockNames, monitor, serialize, test, classes);
	«ENDIF»
		mutationResults.numMutatorsApplied += results«mutatorName».numMutatorsApplied;
		mutationResults.numMutantsGenerated += results«mutatorName».numMutantsGenerated;
		if (results«mutatorName».mutatorsApplied != null) {
			if (mutationResults.mutatorsApplied == null) {
				mutationResults.mutatorsApplied = new ArrayList<String>();
			}
			mutationResults.mutatorsApplied.addAll(results«mutatorName».mutatorsApplied); 
		}
	«ENDFOR»
	if (isRegistered == true) {
		ModelManager.registerMetaModel(localRegisteredPackages);
		if (registeredPackages != null) {
			ModelManager.registerMetaModel(registeredPackages);
		}
	}
	
	return mutationResults;
	}
}
	'''
		
	def getRandom(int range) {
		if(range==1) return 0
		
        var int value = System.nanoTime().intValue % range
        if (value<0) value= value*-1
        
        return value
	}
	
	
	def modifyInformationMutator(ModifyInformationMutator mut) '''
		//MODIFY INFORMATION «methodName»
		«IF mut.object instanceof RandomTypeSelection»
			RandomTypeSelection rts = new RandomTypeSelection(packages, model, "«(mut.object as RandomTypeSelection).type.name»", mutatedObjects);
			«IF mut.object.expression === null»
				EObject object = rts.getObject();
			«ELSE»
				List<EObject> objects = rts.getObjects();
				//EXPRESSION LIST: «expressionList = new ArrayList<Integer>()»
				//EXPRESSION LEVEL: «nExpression = 0»
				//EXPRESSION LEVEL: «expressionList.add(0)»
				Expression exp«expressionList.get(0)» = new Expression();
				«mut.object.expression.method(0)»
				List<EObject> selectedObjects = evaluate(objects, exp«expressionList.get(0)»);
				EObject object = null;
				if (selectedObjects.size() > 0) {
					object = selectedObjects.get(ModelManager.getRandomIndex(selectedObjects));
				}
			«ENDIF»
			ObSelectionStrategy objectSelection = null;
			«IF mut.object.refType !== null»
			List<EObject> o = ModelManager.getReferences("«mut.object.refType.name»", object);
			object = o.get(ModelManager.getRandomIndex(o));
			«ENDIF»
			if (object != null) {
				objectSelection = new SpecificObjectSelection(packages, model, object);
			}
		«ELSEIF mut.object instanceof CompleteTypeSelection»
			CompleteTypeSelection cts = new CompleteTypeSelection(packages, model, "«(mut.object as CompleteTypeSelection).type.name»", mutatedObjects);
			List<EObject> objects = cts.getObjects();
			«IF mut.object.expression !== null»
				//EXPRESSION LIST: «expressionList = new ArrayList<Integer>()»
				//EXPRESSION LEVEL: «nExpression = 0»
				//EXPRESSION LEVEL: «expressionList.add(0)»
				Expression exp«expressionList.get(0)» = new Expression();
				«mut.object.expression.method(0)»
				objects = evaluate(objects, exp«expressionList.get(0)»);
			«ENDIF»
			«IF mut.object.refType !== null»
			List<EObject> tmpObjects = new ArrayList<EObject>();
			for (EObject eobject : objects) {
				List<EObject> o = ModelManager.getReferences("«mut.object.refType.name»", objectSelection.getObject());
				tmpObjects.addAll(o);
			}
			objects = tmpObjects;
			«ENDIF»
			«IF mut.name!== null»
				List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry = new ArrayList<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>();
				SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(model, packages);
				for (EObject obj : objects) {
					SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>> entry = new SimpleEntry(obj, resourceEntry);
					listEntry.add(entry);
				}
				hmList.put("«mut.name»", listEntry);
			«ENDIF»
			List<ObSelectionStrategy> listSelection = new ArrayList<ObSelectionStrategy>();
			for (EObject obj : objects) {
				ObSelectionStrategy objectSelection = new SpecificObjectSelection(packages, model, obj);
				listSelection.add(objectSelection);
			}
		«ELSEIF mut.object instanceof SpecificObjectSelection»
			ObSelectionStrategy objectSelection = null;
			if (hmObjects.get("«(mut.object as SpecificObjectSelection).objSel.name»") != null) {
				SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.object as SpecificObjectSelection).objSel.name» = hmObjects.get("«(mut.object as SpecificObjectSelection).objSel.name»");
				objectSelection = new SpecificObjectSelection(entry_«(mut.object as SpecificObjectSelection).objSel.name».getValue().getValue(), entry_«(mut.object as SpecificObjectSelection).objSel.name».getValue().getKey(), entry_«(mut.object as SpecificObjectSelection).objSel.name».getKey());
			} else {
				if (hmList.get("«(mut.object as SpecificObjectSelection).objSel.name»") != null) {
					List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_«(mut.object as SpecificObjectSelection).objSel.name» = hmList.get("«(mut.object as SpecificObjectSelection).objSel.name»");
					List<EObject> objs = new ArrayList<EObject>();
					for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_«(mut.object as SpecificObjectSelection).objSel.name») {
						EObject obj = ent.getKey();
						objs.add(obj);
					}
					objectSelection = new SpecificObjectSelection(listEntry_«(mut.object as SpecificObjectSelection).objSel.name».get(0).getValue().getValue(), listEntry_«(mut.object as SpecificObjectSelection).objSel.name».get(0).getValue().getKey(), objs);
				}
				else {
					return mutations;
				}
			}
			«IF mut.object.refType !== null»
			List<EObject> o = ModelManager.getReferences("«mut.object.refType.name»", objectSelection.getObject());
			EObject object = o.get(ModelManager.getRandomIndex(o));
			objectSelection = new SpecificObjectSelection(model, packages, object);
			«ENDIF»
		«ELSEIF mut.object instanceof SpecificClosureSelection»
			«IF ((mut.object as SpecificClosureSelection).objSel !== null && (mut.object as SpecificClosureSelection).refType !== null)»
			ObSelectionStrategy objectSelection = null;
			if (hmObjects.get("«(mut.object as SpecificClosureSelection).objSel.name»") != null) {
				SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.object as SpecificClosureSelection).objSel.name» = hmObjects.get("«(mut.object as SpecificClosureSelection).objSel.name»");
				objectSelection = new SpecificClosureSelection(entry_«(mut.object as SpecificClosureSelection).objSel.name».getValue().getValue(), entry_«(mut.object as SpecificClosureSelection).objSel.name».getValue().getKey(), entry_«(mut.object as SpecificClosureSelection).objSel.name».getKey(), "«(mut.object as SpecificClosureSelection).refType.name»");
			}
			else {
				if (hmList.get("«(mut.object as SpecificClosureSelection).objSel.name»") != null) {
					List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_«(mut.object as SpecificClosureSelection).objSel.name» = hmList.get("«(mut.object as SpecificClosureSelection).objSel.name»");
					List<EObject> objs = new ArrayList<EObject>();
					for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_«(mut.object as SpecificClosureSelection).objSel.name») {
						EObject obj = ent.getKey();
						objs.add(obj);
					}
					objectSelection = new SpecificObjectSelection(listEntry_«(mut.object as SpecificClosureSelection).objSel.name».get(0).getValue().getValue(), listEntry_«(mut.object as SpecificClosureSelection).objSel.name».get(0).getValue().getKey(), objs, "«(mut.object as SpecificClosureSelection).refType.name»");
				}
				else {
					return mutations;
				}
			}
			«IF mut.object.refType !== null»
			List<EObject> o = ModelManager.getReferences("«mut.object.refType.name»", objectSelection.getObject());
			EObject object = o.get(ModelManager.getRandomIndex(o));
			objectSelection = new SpecificObjectSelection(model, packages, object);
			«ENDIF»
			«ENDIF»
		«ENDIF»
				
		Map<String, List<AttributeConfigurationStrategy>> attsList = new HashMap<String, List<AttributeConfigurationStrategy>>();
		//COUNTER:«var counter = 0»
		«FOR c : mut.attributes »
			//COUNTER:«counter++»
			«IF c.attribute.get(0) !==null»
				«val EAttribute attribute = c.attribute.get(0)»
				//NAME:«attributeName = attribute.name»
			«ELSE»
				//NAME:«attributeName = ""»
			«ENDIF»
			«IF c instanceof AttributeSwap»
			   	«val attributeSwap = c as AttributeSwap»
			   	«IF attributeSwap.object !== null»
			   		«IF attributeSwap.object instanceof RandomTypeSelection»
			   		if (hmObjects.get("«(attributeSwap.object as RandomTypeSelection).name»") != null) {
			   			List<AttributeConfigurationStrategy> atts = null;
			   			if (attsList.get("«attributeName»") != null) {
			   				atts = attsList.get("«attributeName»");
			   			}
			   			else {
			   				atts = new ArrayList<AttributeConfigurationStrategy>();
			   			}
			   			SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(attributeSwap.object as RandomTypeSelection).name» = hmObjects.get("«(attributeSwap.object as RandomTypeSelection).name»");
			   			atts.add(new SwapAttributeConfigurationStrategy(entry_«(attributeSwap.object as RandomTypeSelection).name».getKey(), "«(attributeSwap.object as RandomTypeSelection).type.name»", "«c.getAttribute().get(0).name»", "«c.getAttribute().get(1).name»", entry_«(attributeSwap.object as RandomTypeSelection).name».getValue().getKey()));
			   			attsList.put("«attributeName»", atts);
			   		}
		   			«ELSEIF attributeSwap.object instanceof SpecificObjectSelection»
			   		if (objectSelection != null && objectSelection.getObject() != null) {
			   			if (hmObjects.get("«(attributeSwap.object as SpecificObjectSelection).objSel.name»") != null) {
			   				List<AttributeConfigurationStrategy> atts = null;
			   				if (attsList.get("«attributeName»") != null) {
			   					atts = attsList.get("«attributeName»");
			   				}
			   				else {
			   					atts = new ArrayList<AttributeConfigurationStrategy>();
							}
							SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(attributeSwap.object as SpecificObjectSelection).objSel.name» = hmObjects.get("«(attributeSwap.object as SpecificObjectSelection).objSel.name»");
			   				atts.add(new SwapAttributeConfigurationStrategy(objectSelection.getObject(), entry_«(attributeSwap.object as SpecificObjectSelection).objSel.name».getKey(), "«c.getAttribute().get(0).name»", "«c.getAttribute().get(1).name»"));
			   				attsList.put("«attributeName»", atts);
			   			} else {
			   				return mutations;
			   			}
			   		}
		   			«ENDIF»
		   		«ELSE»
			   		if (objectSelection != null && objectSelection.getObject() != null) {
			   			List<AttributeConfigurationStrategy> atts = null;
			   			if (attsList.get("«attributeName»") != null) {
			   				atts = attsList.get("«attributeName»");
			   			}
			   			else {
			   				atts = new ArrayList<AttributeConfigurationStrategy>();
			   			}
			   			atts.add(new SwapAttributeConfigurationStrategy(objectSelection.getObject(), "«c.getAttribute().get(0).name»", "«c.getAttribute().get(1).name»"));
			   			attsList.put("«attributeName»", atts);
			   		}
				«ENDIF»
			«ELSEIF c instanceof AttributeCopy»
		   		«val attributeCopy = c as AttributeCopy»
		   		«IF attributeCopy.object !== null»
					«IF attributeCopy.object instanceof RandomTypeSelection»
						if (objectSelection != null && objectSelection.getObject() != null) {
							List<AttributeConfigurationStrategy> atts = null;
							if (attsList.get("«attributeName»") != null) {
								atts = attsList.get("«attributeName»");
							}
							else {
								atts = new ArrayList<AttributeConfigurationStrategy>();
							}
							atts.add(new CopyAttributeConfigurationStrategy(objectSelection.getObject(), "«(attributeCopy.object as RandomTypeSelection).type.name»", "«c.getAttribute().get(0).name»", "«c.getAttribute().get(1).name»", objectSelection.getModel()));
							attsList.put("«attributeName»", atts);
			   			}
					«ELSEIF attributeCopy.object instanceof SpecificObjectSelection»
						if (objectSelection != null && objectSelection.getObject() != null) {
							if (hmObjects.get("«(attributeCopy.object as SpecificObjectSelection).objSel.name»") != null) {
								List<AttributeConfigurationStrategy> atts = null;
								if (attsList.get("«attributeName»") != null) {
									atts = attsList.get("«attributeName»");
								}
								else {
									atts = new ArrayList<AttributeConfigurationStrategy>();
								}
					   			SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(attributeCopy.object as SpecificObjectSelection).objSel.name» = hmObjects.get("«(attributeCopy.object as SpecificObjectSelection).objSel.name»");
								atts.add(new CopyAttributeConfigurationStrategy(objectSelection.getObject(), entry_«(attributeCopy.object as SpecificObjectSelection).objSel.name».getKey(), "«c.getAttribute().get(0).name»", "«c.getAttribute().get(1).name»"));
								attsList.put("«attributeName»", atts);
							} else {
								return mutations;
							}
						}
					«ENDIF»
	   			«ELSE»
					if (objectSelection != null && objectSelection.getObject() != null) {
						List<AttributeConfigurationStrategy> atts = null;
						if (attsList.get("«attributeName»") != null) {
							atts = attsList.get("«attributeName»");
						}
						else {
							atts = new ArrayList<AttributeConfigurationStrategy>();
						}
						atts.add(new CopyAttributeConfigurationStrategy(objectSelection.getObject(), "«c.getAttribute().get(0).name»", "«c.getAttribute().get(1).name»"));
						attsList.put("«attributeName»", atts);
					}
	   			«ENDIF»
	   		«ELSEIF c instanceof AttributeOperation»
	   			«val attributeOperation = c as AttributeOperation»
	   			if (objectSelection != null && objectSelection.getObject() != null) {
	   			«IF attributeOperation.value instanceof ObjectAttributeType»
	   				//«val ObjectAttributeType objectAtt = attributeOperation.value as ObjectAttributeType»
		   			SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«objectAtt.objSel.name» = hmObjects.get("«objectAtt.objSel.name»");
	   				Object value = ModelManager.getAttribute("«objectAtt.attribute.name»", entry_«objectAtt.objSel.name».getKey());
	   			«ENDIF»
	   			«IF attributeOperation.value instanceof SpecificIntegerType»
	   				//«val SpecificIntegerType specInt = attributeOperation.value as SpecificIntegerType»
	   				Object value = «specInt.value»;
	   			«ENDIF»
	   			«IF attributeOperation.value instanceof RandomIntegerType»
	   				//«val RandomIntegerType rnInt = attributeOperation.value as RandomIntegerType»
	   				int min = «rnInt.min»;
	   				int max = «rnInt.max»;
	   				Object value = (min == 0 && max == 0) ? 0 : ModelManager.rn.nextInt(max - min) + min;
	   			«ENDIF»
	   			«IF attributeOperation.value instanceof RandomIntegerNumberType»
	   				//«val RandomIntegerNumberType rnNumInt = attributeOperation.value as RandomIntegerNumberType»
	   				int min = «rnNumInt.min»;
	   				int max = 0;
	   				«IF rnNumInt.object instanceof SpecificObjectSelection»
	   				//«val SpecificObjectSelection sel = rnNumInt.object as SpecificObjectSelection»
					SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«sel.objSel.name» = hmObjects.get("«sel.objSel.name»");
	   				max = ModelManager.getIntAttribute("«rnNumInt.max.name»", entry_"«sel.objSel.name»".getKey());
	   				«ENDIF»
	   				Object value = (min == 0 && max == 0) ? 0 : ModelManager.rn.nextInt(max - min) + min;
	   			«ENDIF»
	   			«IF attributeOperation.value instanceof SpecificDoubleType»
	   				//«val SpecificDoubleType specDouble = attributeOperation.value as SpecificDoubleType»
	   				Object value = «specDouble.value»;
	   			«ENDIF»
	   			«IF attributeOperation.value instanceof RandomDoubleType»
	   				//«val RandomDoubleType rnDouble = attributeOperation.value as RandomDoubleType»
	   				int min = (int) Math.floor(«rnDouble.min» * 100);
	   				int max = (int) Math.floor(«rnDouble.max» * 100);
	   				Object value = 0.0;
	   				if (min != 0 || max != 0) {
	   					int rn = ModelManager.rn.nextInt(max - min) + min;
	   					value = rn / 100.0;
	   				}
	   			«ENDIF»
	   			«IF attributeOperation.value instanceof RandomDoubleNumberType»
					//«val RandomDoubleNumberType rnNumDouble = attributeOperation.value as RandomDoubleNumberType»
					int min = (int) Math.floor(«rnNumDouble.min» * 100);
					int max = 0;
	   				«IF rnNumDouble.object instanceof SpecificObjectSelection»
	   				//«val SpecificObjectSelection sel = rnNumDouble.object as SpecificObjectSelection»
					SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«sel.objSel.name» = hmObjects.get("«sel.objSel.name»");
					max = (int) Math.floor(ModelManager.getDoubleAttribute("«rnNumDouble.max.name»", entry_«sel.objSel.name».getKey()) * 100);
	   				«ENDIF»
					Object value = 0.0;
					if (min != 0 || max != 0) {
						int rn = ModelManager.rn.nextInt(max - min) + min;
						value = rn / 100.0;
					}
	   			«ENDIF»
	   			«IF attributeOperation.value instanceof MinValueType»
	   				//«val MinValueType minValue = attributeOperation.value as MinValueType»
	   				MinValueConfigurationStrategy minStrategy = new MinValueConfigurationStrategy(objectSelection.getMetaModel(), objectSelection.getModel(), "«MutatorUtils.getTypeName(minValue)»", "«minValue.attribute.name»");
	   				Object value = minStrategy.getValue(); 
	   			«ENDIF»
	   			«IF attributeOperation.value instanceof MaxValueType»
	   				//«val MaxValueType maxValue = attributeOperation.value as MaxValueType»
	   				MaxValueConfigurationStrategy maxStrategy = new MaxValueConfigurationStrategy(objectSelection.getMetaModel(), objectSelection.getModel(), "«MutatorUtils.getTypeName(maxValue)»", "«maxValue.attribute.name»");
	   				Object value = maxStrategy.getValue(); 
	   			«ENDIF»
	   			«IF attributeOperation.operator == ArithmeticOperator.ADD»
	   				List<AttributeConfigurationStrategy> atts = null;
	   				if (attsList.get("«attributeName»") != null) {
	   					atts = attsList.get("«attributeName»");
	   				}
	   				else {
	   					atts = new ArrayList<AttributeConfigurationStrategy>();
	   				}
	   				«attributeOperation.add("objectSelection")»
	   			«ENDIF»
	   			«IF attributeOperation.operator == ArithmeticOperator.SUBTRACT»
	   				List<AttributeConfigurationStrategy> atts = null;
	   				if (attsList.get("«attributeName»") != null) {
	   					atts = attsList.get("«attributeName»");
	   				}
	   				else {
	   					atts = new ArrayList<AttributeConfigurationStrategy>();
	   				}
	   				«attributeOperation.subtract("objectSelection")»
	   			«ENDIF»
	   			«IF attributeOperation.operator == ArithmeticOperator.MULTIPLY»
	   				List<AttributeConfigurationStrategy> atts = null;
					if (attsList.get("«attributeName»") != null) {
						atts = attsList.get("«attributeName»");
					}
					else {
						atts = new ArrayList<AttributeConfigurationStrategy>();
					}
	   				«attributeOperation.multiply("objectSelection")»
	   			«ENDIF»
	   			«IF attributeOperation.operator == ArithmeticOperator.DIVIDE»
	   				List<AttributeConfigurationStrategy> atts = null;
	   				if (attsList.get("«attributeName»") != null) {
	   					atts = attsList.get("«attributeName»");
	   				}
	   				else {
	   					atts = new ArrayList<AttributeConfigurationStrategy>();
	   				}
	   			«attributeOperation.divide("objectSelection")»
	   			«ENDIF»
	   			«IF attributeOperation.operator == ArithmeticOperator.MODULE»
	   				List<AttributeConfigurationStrategy> atts = null;
					if (attsList.get("«attributeName»") != null) {
						atts = attsList.get("«attributeName»");
					}
					else {
						atts = new ArrayList<AttributeConfigurationStrategy>();
					}
	   				«attributeOperation.module("objectSelection")»
	   			«ENDIF»
	   			}
			«ELSE»
			«IF mut.object instanceof CompleteTypeSelection»
			for (ObSelectionStrategy objectSelection : listSelection) {
			«ENDIF»
			if (objectSelection != null) {
				«c.method(false, true, counter, false, "objectSelection")»
			}
			«IF mut.object instanceof CompleteTypeSelection»
			}
			«ENDIF»
			«ENDIF»
   		«ENDFOR»
		Map<String, List<ReferenceConfigurationStrategy>> refsList = new HashMap<String, List<ReferenceConfigurationStrategy>>();
		Map<String, List<AttributeConfigurationStrategy>> attsRefList = new HashMap<String, List<AttributeConfigurationStrategy>>();
		List<EObject> objsAttRef = new ArrayList<EObject>();
		//COUNTER:«counter = 0»
		«FOR c : mut.references »
			//COUNTER:«counter++»
			«IF c.reference.get(0) !==null»
				«val EReference reference = c.reference.get(0)»
				//NAME:«referenceName = reference.name»
			«ELSE»
				//NAME:«referenceName = ""»
			«ENDIF»
		  	«IF c instanceof ReferenceSwap»
	   			«val referenceSwap = c as ReferenceSwap»
	   			«IF referenceSwap.object !== null»
					«IF referenceSwap.object instanceof RandomTypeSelection»
					if (hmObjects.get("«(referenceSwap.object as RandomTypeSelection).name»") != null) {
						List<ReferenceConfigurationStrategy> refs = null;
						if (refsList.get("«referenceName»") != null) {
							refs = refsList.get("«referenceName»");
						}
						else {
							refs = new ArrayList<ReferenceConfigurationStrategy>();
						}
						SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(referenceSwap.object as RandomTypeSelection).name» = hmObjects.get("«(referenceSwap.object as RandomTypeSelection).name»");
						refs.add(new SwapReferenceConfigurationStrategy(entry_«(referenceSwap.object as RandomTypeSelection).name».getKey(), "«(referenceSwap.object as RandomTypeSelection).type.name»", "«c.getReference().get(0).name»", "«c.getReference().get(1).name»", entry_«(referenceSwap.object as RandomTypeSelection).name».getValue().getKey()));
						refsList.put("«referenceName», refs);
					}
	   				«ELSEIF referenceSwap.object instanceof SpecificObjectSelection»
					if (objectSelection != null && objectSelection.getObject() != null) {
						if (hmObjects.get("«(referenceSwap.object as SpecificObjectSelection).objSel.name»") != null) {
							List<ReferenceConfigurationStrategy> refs = null;
							if (refsList.get("«referenceName»") != null) {
								refs = refsList.get("«referenceName»");
							}
					   		else {
								refs = new ArrayList<ReferenceConfigurationStrategy>();
					   		}
							SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(referenceSwap.object as SpecificObjectSelection).objSel.name» = hmObjects.get("«(referenceSwap.object as SpecificObjectSelection).objSel.name»");
							refs.add(new SwapReferenceConfigurationStrategy(objectSelection.getObject(), entry_«(referenceSwap.object as SpecificObjectSelection).objSel.name».getKey(), "«c.getReference().get(0).name»", "«c.getReference().get(1).name»"));
							refsList.put("«referenceName»", refs);
						} else {
							return mutations;
						}
					}
	   				«ENDIF»
		   		«ELSE»
				if (objectSelection != null && objectSelection.getObject() != null) {
					List<ReferenceConfigurationStrategy> refs = null;
					if (refsList.get("«referenceName»") != null) {
						refs = refsList.get("«referenceName»");
					}
					else {
						refs = new ArrayList<ReferenceConfigurationStrategy>();
					}
					refs.add(new SwapReferenceConfigurationStrategy(objectSelection.getObject(), "«c.getReference().get(0).name»", "«c.getReference().get(1).name»"));
					refsList.put("«referenceName»", refs);
				}
		   		«ENDIF»
		   	«ENDIF»
	   		«IF c instanceof ReferenceInit»
	   		«val referenceInit = c as ReferenceInit»
	   			«IF referenceInit.object instanceof SpecificObjectSelection»
	   				if (objectSelection != null && objectSelection.getObject() != null) {
	   					if (hmObjects.get("«(referenceInit.object as SpecificObjectSelection).objSel.name»") != null) {
	   						List<ReferenceConfigurationStrategy> refs = null;
	   						if (refsList.get("«referenceName»") != null) {
	   							refs = refsList.get("«referenceName»");
	   						}
	   						else {
	   							refs = new ArrayList<ReferenceConfigurationStrategy>();
	   						}
							SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(referenceInit.object as SpecificObjectSelection).objSel.name» = hmObjects.get("«(referenceInit.object as SpecificObjectSelection).objSel.name»");
							«IF (referenceInit.object as SpecificObjectSelection).refType === null»
	   						refs.add(new SpecificReferenceConfigurationStrategy(entry_«(referenceInit.object as SpecificObjectSelection).objSel.name».getValue().getKey(), objectSelection.getObject(), entry_«(referenceInit.object as SpecificObjectSelection).objSel.name».getKey(), "«referenceInit.getReference().get(0).name»"));
	   						«ELSE»
	   						refs.add(new SpecificReferenceConfigurationStrategy(entry_«(referenceInit.object as SpecificObjectSelection).objSel.name».getValue().getKey(), objectSelection.getObject(), (EObject) entry_«(referenceInit.object as SpecificObjectSelection).objSel.name».getKey().eGet(ModelManager.getReferenceByName("«(referenceInit.object as SpecificObjectSelection).refType.name»", entry_«(referenceInit.object as SpecificObjectSelection).objSel.name».getKey())), "«referenceInit.getReference().get(0).name»", false));
	   						«ENDIF»
	   						refsList.put("«referenceName»", refs);
	   					} else {
	   						return mutations;
	   					}
	   				}
	   			«ENDIF»
	   			«IF referenceInit.object instanceof OtherTypeSelection»
	   			if (objectSelection != null && objectSelection.getObject() != null) {
	   				List<ReferenceConfigurationStrategy> refs = null;
	   				if (refsList.get("«referenceName»") != null) {
	   					refs = refsList.get("«referenceName»");
	   				}
	   				else {
	   					refs = new ArrayList<ReferenceConfigurationStrategy>();
	   				}
	   				refs.add(new RandomReferenceConfigurationStrategy(objectSelection.getModel(), objectSelection.getObject(), "«referenceInit.getReference().get(0).name»", "«(referenceInit.object as OtherTypeSelection).type.name»"));
	   				refsList.put("«referenceName»", refs);
	   			}
	   			«ENDIF»
			«ENDIF»
			«IF c instanceof ReferenceAdd»
	   		«val referenceAdd = c as ReferenceAdd»
	   			«IF referenceAdd.object instanceof SpecificObjectSelection»
	   				if (objectSelection != null && objectSelection.getObject() != null) {
	   					if (hmObjects.get("«(referenceAdd.object as SpecificObjectSelection).objSel.name»") != null) {
	   						List<ReferenceConfigurationStrategy> refs = null;
	   						if (refsList.get("«referenceName»") != null) {
	   							refs = refsList.get("«referenceName»");
	   						}
	   						else {
	   							refs = new ArrayList<ReferenceConfigurationStrategy>();
	   						}
							SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(referenceAdd.object as SpecificObjectSelection).objSel.name» = hmObjects.get("«(referenceAdd.object as SpecificObjectSelection).objSel.name»");
							«IF (referenceAdd.object as SpecificObjectSelection).refType === null»
	   						refs.add(new SpecificReferenceConfigurationStrategy(entry_«(referenceAdd.object as SpecificObjectSelection).objSel.name».getValue().getKey(), objectSelection.getObject(), entry_«(referenceAdd.object as SpecificObjectSelection).objSel.name».getKey(), "«referenceAdd.getReference().get(0).name»", false));
	   						«ELSE»
	   						refs.add(new SpecificReferenceConfigurationStrategy(entry_«(referenceAdd.object as SpecificObjectSelection).objSel.name».getValue().getKey(), objectSelection.getObject(), (EObject) entry_«(referenceAdd.object as SpecificObjectSelection).objSel.name».getKey().eGet(ModelManager.getReferenceByName("«(referenceAdd.object as SpecificObjectSelection).refType.name»", entry_«(referenceAdd.object as SpecificObjectSelection).objSel.name».getKey())), "«referenceAdd.getReference().get(0).name»", false));
	   						«ENDIF»
	   						refsList.put("«referenceName»", refs);
	   					} else {
	   						return mutations;
	   					}
	   				}
	   			«ENDIF»
	   			«IF referenceAdd.object instanceof OtherTypeSelection»
	   				if (objectSelection != null && objectSelection.getObject() != null) {
	   					List<ReferenceConfigurationStrategy> refs = null;
	   					if (refsList.get("«referenceName»") != null) {
	   						refs = refsList.get("«referenceName»");
	   					}
	   					else {
	   						refs = new ArrayList<ReferenceConfigurationStrategy>();
					}
	   				refs.add(new RandomReferenceConfigurationStrategy(objectSelection.getModel(), objectSelection.getObject(), "«referenceAdd.getReference().get(0).name»", "«(referenceAdd.object as OtherTypeSelection).type.name»", false));
	   				refsList.put("«referenceName»", refs);
	   			}
	   			«ENDIF»
			«ENDIF»
			«IF c instanceof ReferenceRemove»
	   		«val referenceRemove = c as ReferenceRemove»
	   			«IF referenceRemove.object instanceof SpecificObjectSelection»
	   				if (objectSelection != null && objectSelection.getObject() != null) {
	   					if (hmObjects.get("«(referenceRemove.object as SpecificObjectSelection).objSel.name»") != null) {
	   						List<ReferenceConfigurationStrategy> refs = null;
	   						if (refsList.get("«referenceName»") != null) {
	   							refs = refsList.get("«referenceName»");
	   						}
	   						else {
	   							refs = new ArrayList<ReferenceConfigurationStrategy>();
	   						}
							SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(referenceRemove.object as SpecificObjectSelection).objSel.name» = hmObjects.get("«(referenceRemove.object as SpecificObjectSelection).objSel.name»");
	   						refs.add(new SpecificReferenceConfigurationStrategy(entry_«(referenceRemove.object as SpecificObjectSelection).objSel.name».getValue().getKey(), objectSelection.getObject(), entry_«(referenceRemove.object as SpecificObjectSelection).objSel.name».getKey(), "«referenceRemove.getReference().get(0).name»", true));
	   						refsList.put("«referenceName»", refs);
	   					} else {
	   						return mutations;
	   					}
	   				}
	   			«ENDIF»
	   			«IF referenceRemove.object instanceof OtherTypeSelection»
	   				if (objectSelection != null && objectSelection.getObject() != null) {
	   					List<ReferenceConfigurationStrategy> refs = null;
	   					if (refsList.get("«referenceName»") != null) {
	   						refs = refsList.get("«referenceName»");
	   					}
	   					else {
	   						refs = new ArrayList<ReferenceConfigurationStrategy>();
	   					}
	   					refs.add(new RandomReferenceConfigurationStrategy(objectSelection.getModel(), objectSelection.getObject(), "«referenceRemove.getReference().get(0).name»", "«(referenceRemove.object as OtherTypeSelection).type.name»", true));
	   					refsList.put("«referenceName»", refs);
	   				}
	   			«ENDIF»
			«ENDIF»
			«IF c instanceof ReferenceAtt»
	   			«val referenceAtt = c as ReferenceAtt»
	   			«IF referenceAtt.reference !== null»
					«IF referenceAtt.attribute !== null»
					//NAME:«attributeName = referenceAtt.attribute.name»
					«IF referenceAtt.value !== null»
					«IF (referenceAtt.eContainer as ModifyInformationMutator).object instanceof SpecificObjectSelection»
					EObject refObjectSelected = null;
					if (hmObjects.get("«((referenceAtt.eContainer as ModifyInformationMutator).object as SpecificObjectSelection).objSel.name»") != null) {
						for (EReference ref : hmObjects.get("«((referenceAtt.eContainer as ModifyInformationMutator).object as SpecificObjectSelection).objSel.name»").getKey().eClass().getEReferences()) {
							if (ref.getName().equals("«referenceAtt.reference.get(0).name»")) {
								SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«((referenceAtt.eContainer as ModifyInformationMutator).object as SpecificObjectSelection).objSel.name» = hmObjects.get("«((referenceAtt.eContainer as ModifyInformationMutator).object as SpecificObjectSelection).objSel.name»");
								refObjectSelected = (EObject) entry_«((referenceAtt.eContainer as ModifyInformationMutator).object as SpecificObjectSelection).objSel.name».getKey().eGet(ref);
								break;
							}
						}
					}
					«ELSEIF (referenceAtt.eContainer as ModifyInformationMutator).object instanceof RandomTypeSelection»
					EObject refObjectSelected = null;
					if (objectSelection != null) {
						if (objectSelection.getObject() != null) {
							for (EReference ref : objectSelection.getObject().eClass().getEReferences()) {
								if (ref.getName().equals("«referenceAtt.reference.get(0).name»")) {
									refObjectSelected = (EObject) objectSelection.getObject().eGet(ref);
									break;
								}
							}
						}
					}
					«ENDIF»
					if (refObjectSelected != null) {
						objsAttRef.add(refObjectSelected);
						ListAttributeConfigurationStrategy> attsRef = null;
						if (attsRefList.get("«attributeName»") != null) {
							attsRef = attsRefList.get("«attributeName»");
						}
						else {
							attsRef = new ArrayList<AttributeConfigurationStrategy>();
						}
						attsRef.add(«referenceAtt.value.method(true, false, "objectSelection")»);
						attsRefList.put("«attributeName»", attsRef);
					}
					«ENDIF»
					«ENDIF»
		   		«ENDIF»
		   	«ENDIF»
		«ENDFOR»
		«IF mut.object instanceof CompleteTypeSelection»
	   		for (ObSelectionStrategy objectSelection : listSelection) {
	   			if (mutatedObjects != null) {
					mutatedObjects.add(objectSelection.getObject());
				}
	   			ModifyInformationMutator mut = new ModifyInformationMutator(objectSelection.getModel(), objectSelection.getMetaModel(), objectSelection, attsList, refsList, objsAttRef, attsRefList);
	   			//INC COUNTER: «nMutation++»
	   			//INC COUNTER: «nRegistryMutation++»
	   			if (mut != null) {
	   				mut.setId("m«nMutation»");
	   				mutations.add(mut);
	   			}
	   		}
	   	«ELSE»
	   		if (objectSelection != null) {
	   			if (mutatedObjects != null) {
					mutatedObjects.add(objectSelection.getObject());
				}
	   			ModifyInformationMutator mut = new ModifyInformationMutator(objectSelection.getModel(), objectSelection.getMetaModel(), objectSelection, attsList, refsList, objsAttRef, attsRefList);
	   			//INC COUNTER: «nMutation++»
	   			//INC COUNTER: «nRegistryMutation++»
	   			if (mut != null) {
	   				mut.setId("m«nMutation»");
	   				mutations.add(mut);
	   			}
	   		}
		«ENDIF»
		//END MODIFY INFORMATION «methodName»
	'''
	
	def modifyInformationMutatorExhaustive(ModifyInformationMutator mut, MutatorEnvironment e, Block b, boolean last) '''
		//MODIFY INFORMATION «methodName»
		«IF mut.object instanceof RandomTypeSelection»
		RandomTypeSelection rts = new RandomTypeSelection(packages, model, "«(mut.object as RandomTypeSelection).type.name»", mutatedObjects);
		«IF mut.object.expression === null»
			List<EObject> objects = rts.getObjects();
		«ELSE»
			List<EObject> objects = rts.getObjects();
			//EXPRESSION LIST: «expressionList = new ArrayList<Integer>()»
			//EXPRESSION LEVEL: «nExpression = 0»
			//EXPRESSION LEVEL: «expressionList.add(0)»
			Expression exp«expressionList.get(0)» = new Expression();
			«mut.object.expression.method(0)»
			objects = evaluate(objects, exp«expressionList.get(0)»);
		«ENDIF»
		«ELSEIF mut.object instanceof CompleteTypeSelection»
			CompleteTypeSelection cts = new CompleteTypeSelection(packages, model, "«(mut.object as CompleteTypeSelection).type.name»", mutatedObjects);
			List<EObject> objects = cts.getObjects();
		«IF mut.object.expression !== null»
			//EXPRESSION LIST: «expressionList = new ArrayList<Integer>()»
			//EXPRESSION LEVEL: «nExpression = 0»
			//EXPRESSION LEVEL: «expressionList.add(0)»
			Expression exp«expressionList.get(0)» = new Expression();
			«mut.object.expression.method(0)»
			objects = evaluate(objects, exp«expressionList.get(0)»);
		«ENDIF»
		«ELSEIF mut.object instanceof SpecificObjectSelection»
			List<EObject> objects = new ArrayList<EObject>();
			ObSelectionStrategy objectSelection = null;
			if (hmObjects.get("«(mut.object as SpecificObjectSelection).objSel.name»") != null) {
				SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.object as SpecificObjectSelection).objSel.name» = hmObjects.get("«(mut.object as SpecificObjectSelection).objSel.name»");
				EObject recovered = ModelManager.getObject(model, entry_«(mut.object as SpecificObjectSelection).objSel.name».getKey());
				if (recovered == null) {
					recovered = entry_«(mut.object as SpecificObjectSelection).objSel.name».getKey();
				}
				objectSelection = new SpecificObjectSelection(packages, model, recovered);
			} else {
				if (hmList.get("«(mut.object as SpecificObjectSelection).objSel.name»") != null) {
					List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_«(mut.object as SpecificObjectSelection).objSel.name» = hmList.get("«(mut.object as SpecificObjectSelection).objSel.name»");
					List<EObject> objs = new ArrayList<EObject>();
					for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_«(mut.object as SpecificObjectSelection).objSel.name») {
						EObject obj = ModelManager.getObject(model, ent.getKey());
						objs.add(obj);
					}
					objectSelection = new SpecificObjectSelection(packages, model, objs);
				}
				else {
					return numMutantsGenerated;
				}
			}
			if (objectSelection != null) {
				objects.add(objectSelection.getObject());
			}
			«IF mut.object.refType !== null»
			List<EObject> o = ModelManager.getReferences("«mut.object.refType.name»", objectSelections.get(0).getObject());
			EObject object = o.get(ModelManager.getRandomIndex(o));
			objectSelection = new SpecificObjectSelection(model, packages, object);
			objects.add(object);
			«ENDIF»
		«ELSEIF mut.object instanceof SpecificClosureSelection»
			«IF ((mut.object as SpecificClosureSelection).objSel !== null && (mut.object as SpecificClosureSelection).refType !== null)»
			List<EObject> objects = new ArrayList<EObject>();
			ObSelectionStrategy objectSelection = null;
			if (hmObjects.get("«(mut.object as SpecificClosureSelection).objSel.name»") != null) {
				SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.object as SpecificClosureSelection).objSel.name» = hmObjects.get("«(mut.object as SpecificClosureSelection).objSel.name»");
				EObject recovered = ModelManager.getObject(model, entry_«(mut.object as SpecificClosureSelection).objSel.name».getKey());
				if (recovered == null) {
					recovered = entry_«(mut.object as SpecificClosureSelection).objSel.name».getKey();
				}
				objectSelection = new SpecificObjectSelection(packages, model, recovered);
			}
			else {
				if (hmList.get("«(mut.object as SpecificClosureSelection).objSel.name»") != null) {
					List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_«(mut.object as SpecificClosureSelection).objSel.name» = hmList.get("«(mut.object as SpecificClosureSelection).objSel.name»");
					List<EObject> objs = new ArrayList<EObject>();
					for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_«(mut.object as SpecificClosureSelection).objSel.name») {
						EObject obj = ModelManager.getObject(model, ent.getKey());
						objs.add(obj);
					}
					objectSelection = new SpecificClosureSelection(listEntry_«(mut.object as SpecificClosureSelection).objSel.name».get(0).getValue().getValue(), listEntry_«(mut.object as SpecificClosureSelection).objSel.name».get(0).getValue().getKey(), objs, "«(mut.object as SpecificClosureSelection).refType.name»");
				}
				else {
					return numMutantsGenerated;
				}
			}
			if (objectSelection != null) {
				objects.add(objectSelection.getObjects());
			}
			«IF mut.object.refType !== null»
			List<EObject> o = ModelManager.getReferences("«mut.object.refType.name»", objectSelection.getObject());
			EObject object = o.get(ModelManager.getRandomIndex(o));
			objectSelection = new SpecificObjectSelection(model, packages, object);
			objects.add(object);
			«ENDIF»
			«ENDIF»
		«ENDIF»
			for (EObject object : objects) {
				«IF standalone == false»
				String modelsFolder = ModelManager.getModelsFolder(this.getClass());
				«ELSE»
				String modelsFolder = ModelManager.getModelsFolder(«className».class);
				«ENDIF»
				String tempModelsFolder = modelsFolder.replace(modelsFolder.indexOf("/") > 0 ? modelsFolder.substring(modelsFolder.indexOf("/") + 1, modelsFolder.length()) : modelsFolder, "temp");
				modelsFolder = modelsFolder.replace("/", "\\"); 
				tempModelsFolder = tempModelsFolder.replace("/", "\\");
				Resource resource = ModelManager.cloneModel(model, model.getURI().toFileString().replace(modelsFolder + "\\", tempModelsFolder + "\\").replace(".model", ".«methodName»." + numMutantsGenerated +".model"));
				ObSelectionStrategy obSelection = null;
				«IF mut.object.refType !== null»
				List<EObject> o = ModelManager.getReferences("«mut.object.refType.name»", object);
				object = o.get(ModelManager.getRandomIndex(o));
				«ENDIF»
				object = ModelManager.getObject(resource, object);
				if (object != null) {
					obSelection = new SpecificObjectSelection(packages, resource, object);
					Map<String, List<AttributeConfigurationStrategy>> attsList = new HashMap<String, List<AttributeConfigurationStrategy>>();
		//COUNTER:«var counter = 0»
		«FOR c : mut.attributes »
			//COUNTER:«counter++»
			«IF c.attribute.get(0) !==null»
				«val EAttribute attribute = c.attribute.get(0)»
				//NAME:«attributeName = attribute.name»
			«ELSE»
				//NAME:«attributeName = ""»
			«ENDIF»
			«IF c instanceof AttributeSwap»
			   	«val attributeSwap = c as AttributeSwap»
			   	«IF attributeSwap.object !== null»
			   		«IF attributeSwap.object instanceof RandomTypeSelection»
			   		if (hmObjects.get("«(attributeSwap.object as RandomTypeSelection).name»") != null) {
						List<AttributeConfigurationStrategy> atts = new ArrayList<AttributeConfigurationStrategy>();
			   			if (attsList.get("«attributeName»") != null) {
			   				atts = attsList.get("«attributeName»");
			   			}
			   			else {
			   				atts = new ArrayList<AttributeConfigurationStrategy>();
			   			}
			   			SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(attributeSwap.object as RandomTypeSelection).name» = hmObjects.get("«(attributeSwap.object as RandomTypeSelection).name»");
			   			EObject recovered = ModelManager.getObject(resource, entry_«(attributeSwap.object as RandomTypeSelection).name».getKey());
						if (recovered == null) {
							recovered = entry_«(attributeSwap.object as RandomTypeSelection).name».getKey();
						}
			   			atts.add(new SwapAttributeConfigurationStrategy(recovered, "«(attributeSwap.object as RandomTypeSelection).type.name»", "«c.getAttribute().get(0).name»", "«c.getAttribute().get(1).name»", resource));
			   			attsList.put("«attributeName»", atts);
			   		}
		   			«ELSEIF attributeSwap.object instanceof SpecificObjectSelection»
			   		if (obSelection != null && obSelection.getObject() != null) {
			   			if (hmObjects.get("«(attributeSwap.object as SpecificObjectSelection).objSel.name»") != null) {
							List<AttributeConfigurationStrategy> atts = new ArrayList<AttributeConfigurationStrategy>();
			   				if (attsList.get("«attributeName»") != null) {
			   					atts = attsList.get("«attributeName»");
			   				}
			   				else {
			   					atts = new ArrayList<AttributeConfigurationStrategy>();
			   				}
				   			SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(attributeSwap.object as SpecificObjectSelection).objSel.name» = hmObjects.get("«(attributeSwap.object as SpecificObjectSelection).objSel.name»");
				   			EObject recovered = ModelManager.getObject(resource, entry_«(attributeSwap.object as SpecificObjectSelection).objSel.name».getKey());
							if (recovered == null) {
								recovered = entry_«(attributeSwap.object as SpecificObjectSelection).objSel.name».getKey();
							}
			   				atts.add(new SwapAttributeConfigurationStrategy(obSelection.getObject(), recovered, "«c.getAttribute().get(0).name»", "«c.getAttribute().get(1).name»"));
			   				attsList.put("«attributeName»", atts);
			   			} else {
			   				return numMutantsGenerated;
			   			}
			   		}
		   			«ENDIF»
		   		«ELSE»
			   		if (obSelection != null && obSelection.getObject() != null) {
						List<AttributeConfigurationStrategy> atts = new ArrayList<AttributeConfigurationStrategy>();
			   			if (attsList.get("«attributeName»") != null) {
			   				atts = attsList.get("«attributeName»");
			   			}
			   			else {
			   				atts = new ArrayList<AttributeConfigurationStrategy>();
			   			}
			   			atts.add(new SwapAttributeConfigurationStrategy(obSelection.getObject(), "«c.getAttribute().get(0).name»", "«c.getAttribute().get(1).name»"));
			   			attsList.put("«attributeName»", atts);
			   		}
				«ENDIF»
			«ELSEIF c instanceof AttributeCopy»
		   		«val attributeCopy = c as AttributeCopy»
		   		«IF attributeCopy.object !== null»
					«IF attributeCopy.object instanceof RandomTypeSelection»
						if (obSelection != null && obSelection.getObject() != null) {
							List<AttributeConfigurationStrategy> atts = new ArrayList<AttributeConfigurationStrategy>();
							if (attsList.get("«attributeName»") != null) {
								atts = attsList.get("«attributeName»");
							}
							else {
								atts = new ArrayList<AttributeConfigurationStrategy>();
							}
							atts.add(new CopyAttributeConfigurationStrategy(obSelection.getObject(), "«(attributeCopy.object as RandomTypeSelection).type.name»", "«c.getAttribute().get(0).name»", "«c.getAttribute().get(1).name»", obSelection.getModel()));
							attsList.put("«attributeName»", atts);
			   			}
					«ELSEIF attributeCopy.object instanceof SpecificObjectSelection»
						if (obSelection != null && obSelection.getObject() != null) {
							if (hmObjects.get("«(attributeCopy.object as SpecificObjectSelection).objSel.name»") != null) {
								List<AttributeConfigurationStrategy> atts = new ArrayList<AttributeConfigurationStrategy>();
								if (attsList.get("«attributeName»") != null) {
									atts = attsList.get("«attributeName»");
								}
								else {
									atts = new ArrayList<AttributeConfigurationStrategy>();
								}
					   			SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(attributeCopy.object as SpecificObjectSelection).objSel.name» = hmObjects.get("«(attributeCopy.object as SpecificObjectSelection).objSel.name»");
					   			EObject recovered = ModelManager.getObject(resource, entry_«(attributeCopy.object as SpecificObjectSelection).objSel.name».getKey());
								if (recovered == null) {
									recovered = entry_«(attributeCopy.object as SpecificObjectSelection).objSel.name».getKey();
								}
								atts.add(new CopyAttributeConfigurationStrategy(obSelection.getObject(), recovered, "«c.getAttribute().get(0).name»", "«c.getAttribute().get(1).name»"));
								attsList.put("«attributeName»", atts);
							} else {
								return numMutantsGenerated;
							}
						}
					«ENDIF»
	   			«ELSE»
					if (obSelection != null && obSelection.getObject() != null) {
						List<AttributeConfigurationStrategy> atts = new ArrayList<AttributeConfigurationStrategy>();
						if (attsList.get("«attributeName»") != null) {
							atts = attsList.get("«attributeName»");
						}
						else {
							atts = new ArrayList<AttributeConfigurationStrategy>();
						}
						atts.add(new CopyAttributeConfigurationStrategy(obSelection.getObject(), "«c.getAttribute().get(0).name»", "«c.getAttribute().get(1).name»"));
						attsList.put("«attributeName»", atts);
					}
	   			«ENDIF»
	   		«ELSEIF c instanceof AttributeOperation»
	   			«val attributeOperation = c as AttributeOperation»
	   			if (obSelection != null && obSelection.getObject() != null) {
	   			«IF attributeOperation.value instanceof ObjectAttributeType»
	   				//«val ObjectAttributeType objectAtt = attributeOperation.value as ObjectAttributeType»
		   			SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«objectAtt.objSel.name» = hmObjects.get("«objectAtt.objSel.name»");
		   			EObject recovered = ModelManager.getObject(resource, entry_«objectAtt.objSel.name».getKey());
					if (recovered == null) {
						recovered = entry_«objectAtt.objSel.name».getKey();
					}
	   				Object value = ModelManager.getAttribute("«objectAtt.attribute.name»", recovered);
	   			«ENDIF»
	   			«IF attributeOperation.value instanceof SpecificIntegerType»
	   				//«val SpecificIntegerType specInt = attributeOperation.value as SpecificIntegerType»
	   				Object value = «specInt.value»;
	   			«ENDIF»
	   			«IF attributeOperation.value instanceof RandomIntegerType»
	   				//«val RandomIntegerType rnInt = attributeOperation.value as RandomIntegerType»
	   				int min = «rnInt.min»;
	   				int max = «rnInt.max»;
	   				Object value = (min == 0 && max == 0) ? 0 : ModelManager.rn.nextInt(max - min) + min;
	   			«ENDIF»
	   			«IF attributeOperation.value instanceof RandomIntegerNumberType»
	   				//«val RandomIntegerNumberType rnNumInt = attributeOperation.value as RandomIntegerNumberType»
	   				int min = «rnNumInt.min»;
	   				int max = 0;
	   				«IF rnNumInt.object instanceof SpecificObjectSelection»
	   				//«val SpecificObjectSelection sel = rnNumInt.object as SpecificObjectSelection»
					SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«sel.objSel.name» = hmObjects.get("«sel.objSel.name»");
		   			EObject recovered = ModelManager.getObject(resource, entry_«sel.objSel.name».getKey());
					if (recovered == null) {
						recovered = entry_«sel.objSel.name».getKey();
					}
	   				max = ModelManager.getIntAttribute("«rnNumInt.max.name»", recovered);
	   				«ENDIF»
	   				Object value = (min == 0 && max == 0) ? 0 : ModelManager.rn.nextInt(max - min) + min;
	   			«ENDIF»
	   			«IF attributeOperation.value instanceof SpecificDoubleType»
	   				//«val SpecificDoubleType specDouble = attributeOperation.value as SpecificDoubleType»
	   				Object value = «specDouble.value»;
	   			«ENDIF»
	   			«IF attributeOperation.value instanceof RandomDoubleType»
	   				//«val RandomDoubleType rnDouble = attributeOperation.value as RandomDoubleType»
	   				int min = (int) Math.floor(«rnDouble.min» * 100);
	   				int max = (int) Math.floor(«rnDouble.max» * 100);
	   				Object value = 0.0;
	   				if (min != 0 || max != 0) {
	   					int rn = ModelManager.rn.nextInt(max - min) + min;
	   					value = rn / 100.0;
	   				}
	   			«ENDIF»
	   			«IF attributeOperation.value instanceof RandomDoubleNumberType»
					//«val RandomDoubleNumberType rnNumDouble = attributeOperation.value as RandomDoubleNumberType»
					int min = (int) Math.floor(«rnNumDouble.min» * 100);
					int max = 0;
	   				«IF rnNumDouble.object instanceof SpecificObjectSelection»
	   				//«val SpecificObjectSelection sel = rnNumDouble.object as SpecificObjectSelection»
					SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«sel.objSel.name» = hmObjects.get("«sel.objSel.name»");
		   			EObject recovered = ModelManager.getObject(resource, entry_«sel.objSel.name».getKey());
					if (recovered == null) {
						recovered = entry_«sel.objSel.name».getKey();
					}
					max = (int) Math.floor(ModelManager.getDoubleAttribute("«rnNumDouble.max.name»", recovered) * 100);
	   				«ENDIF»
					Object value = 0.0;
					if (min != 0 || max != 0) {
						int rn = ModelManager.rn.nextInt(max - min) + min;
						value = rn / 100.0;
					}
	   			«ENDIF»
	   			«IF attributeOperation.value instanceof MinValueType»
	   				//«val MinValueType minValue = attributeOperation.value as MinValueType»
	   				MinValueConfigurationStrategy minStrategy = new MinValueConfigurationStrategy(obSelection.getMetaModel(), obSelection.getModel(), "«MutatorUtils.getTypeName(minValue)»", "«minValue.attribute.name»");
	   				Object value = minStrategy.getValue(); 
	   			«ENDIF»
	   			«IF attributeOperation.value instanceof MaxValueType»
	   				//«val MaxValueType maxValue = attributeOperation.value as MaxValueType»
	   				MaxValueConfigurationStrategy maxStrategy = new MaxValueConfigurationStrategy(obSelection.getMetaModel(), obSelection.getModel(), "«MutatorUtils.getTypeName(maxValue)»", "«maxValue.attribute.name»");
	   				Object value = maxStrategy.getValue(); 
	   			«ENDIF»
	   			«IF attributeOperation.operator == ArithmeticOperator.ADD»
	   				List<AttributeConfigurationStrategy> atts = null;
	   				if (attsList.get("«attributeName»") != null) {
	   					atts = attsList.get("«attributeName»");
	   				}
	   				else {
	   					atts = new ArrayList<AttributeConfigurationStrategy>();
	   				}
	   				«attributeOperation.add("obSelection")»
	   			«ENDIF»
	   			«IF attributeOperation.operator == ArithmeticOperator.SUBTRACT»
	   				List<AttributeConfigurationStrategy> atts = null;
	   				if (attsList.get("«attributeName»") != null) {
	   					atts = attsList.get("«attributeName»");
	   				}
	   				else {
	   					atts = new ArrayList<AttributeConfigurationStrategy>();
	   				}
	   				«attributeOperation.subtract("obSelection")»
	   			«ENDIF»
	   			«IF attributeOperation.operator == ArithmeticOperator.MULTIPLY»
	   				List<AttributeConfigurationStrategy> atts = null;
					if (attsList.get("«attributeName»") != null) {
						atts = attsList.get("«attributeName»");
					}
					else {
						atts = new ArrayList<AttributeConfigurationStrategy>();
					}
	   				«attributeOperation.multiply("obSelection")»
	   			«ENDIF»
	   			«IF attributeOperation.operator == ArithmeticOperator.DIVIDE»
	   				List<AttributeConfigurationStrategy> atts = null;
	   				if (attsList.get("«attributeName»") != null) {
	   					atts = attsList.get("«attributeName»");
	   				}
	   				else {
	   					atts = new ArrayList<AttributeConfigurationStrategy>();
	   				}
	   			«attributeOperation.divide("obSelection")»
	   			«ENDIF»
	   			«IF attributeOperation.operator == ArithmeticOperator.MODULE»
	   				List<AttributeConfigurationStrategy> atts = null;
					if (attsList.get("«attributeName»") != null) {
						atts = attsList.get("«attributeName»");
					}
					else {
						atts = new ArrayList<AttributeConfigurationStrategy>();
					}
	   				«attributeOperation.module("obSelection")»
	   			«ENDIF»
	   			«ENDIF»
				if (obSelection != null) {
					«c.method(false, true, counter, true, "obSelection")»
				}
				«ENDFOR»
		Map<String, List<ReferenceConfigurationStrategy>> refsList = new HashMap<String, List<ReferenceConfigurationStrategy>>();
		Map<String, List<AttributeConfigurationStrategy>> attsRefList = new HashMap<String, List<AttributeConfigurationStrategy>>();
		List<EObject> objsAttRef = new ArrayList<EObject>();
		//COUNTER:«counter = 0»
		«FOR c : mut.references »
			//COUNTER:«counter++»
			«IF c.reference.get(0) !==null»
				«val EReference reference = c.reference.get(0)»
				//NAME:«referenceName = reference.name»
			«ELSE»
				//NAME:«referenceName = ""»
			«ENDIF»
		  	«IF c instanceof ReferenceSwap»
	   			«val referenceSwap = c as ReferenceSwap»
	   			«IF referenceSwap.object !== null»
					«IF referenceSwap.object instanceof RandomTypeSelection»
					if (hmObjects.get("«(referenceSwap.object as RandomTypeSelection).name»") != null) {
						List<ReferenceConfigurationStrategy> refs = null;
						if (refsList.get("«referenceName»") != null) {
							refs = refsList.get("«referenceName»");
						}
						else {
							refs = new ArrayList<ReferenceConfigurationStrategy>();
						}
						SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(referenceSwap.object as RandomTypeSelection).name» = hmObjects.get("«(referenceSwap.object as RandomTypeSelection).name»");
			   			EObject recovered = ModelManager.getObject(resource, entry_«(referenceSwap.object as RandomTypeSelection).name».getKey());
						if (recovered == null) {
							recovered = entry_«(referenceSwap.object as RandomTypeSelection).name».getKey();
						}
						refs.add(new SwapReferenceConfigurationStrategy(recovered, "«(referenceSwap.object as RandomTypeSelection).type.name»", "«c.getReference().get(0).name»", "«c.getReference().get(1).name»", resource));
						refsList.put("«referenceName», refs);
					}
	   				«ELSEIF referenceSwap.object instanceof SpecificObjectSelection»
					if (obSelection != null && obSelection.getObject() != null) {
						if (hmObjects.get("«(referenceSwap.object as SpecificObjectSelection).objSel.name»") != null) {
							List<ReferenceConfigurationStrategy> refs = null;
							if (refsList.get("«referenceName»") != null) {
								refs = refsList.get("«referenceName»");
							}
					   		else {
								refs = new ArrayList<ReferenceConfigurationStrategy>();
					   		}
							SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(referenceSwap.object as SpecificObjectSelection).objSel.name» = hmObjects.get("«(referenceSwap.object as SpecificObjectSelection).objSel.name»");
				   			EObject recovered = ModelManager.getObject(resource, entry_«(referenceSwap.object as SpecificObjectSelection).objSel.name».getKey());
							if (recovered == null) {
								recovered = entry_«(referenceSwap.object as SpecificObjectSelection).objSel.name».getKey();
							}
							refs.add(new SwapReferenceConfigurationStrategy(obSelection.getObject(), recovered, "«c.getReference().get(0).name»", "«c.getReference().get(1).name»"));
							refsList.put("«referenceName»", refs);
						} else {
							return numMutantsGenerated;
						}
					}
	   				«ENDIF»
		   		«ELSEIF referenceSwap.reference !== null»
		   			List<ReferenceConfigurationStrategy> refs = null;
		   			if (refsList.get("«referenceName»") != null) {
		   				refs = refsList.get("«referenceName»");
		   			}
			   		else {
						refs = new ArrayList<ReferenceConfigurationStrategy>();
			   		}
					refs.add(new SwapReferenceConfigurationStrategy(obSelection.getObject(), "«(mut.object as RandomTypeSelection).type.name»", "«c.getReference().get(0).name»", "«c.getReference().get(1).name»", resource));
					refsList.put("«referenceName»", refs);
		   		«ELSE»
				if (obSelection != null && obSelection.getObject() != null) {
					List<ReferenceConfigurationStrategy> refs = null;
					if (refsList.get("«referenceName»") != null) {
						refs = refsList.get("«referenceName»");
					}
					else {
						refs = new ArrayList<ReferenceConfigurationStrategy>();
					}
					refs.add(new SwapReferenceConfigurationStrategy(obSelection.getObject(), "«c.getReference().get(0).name»", "«c.getReference().get(1).name»"));
					refsList.put("«referenceName»", refs);
				}
		   		«ENDIF»
		   	«ENDIF»
	   		«IF c instanceof ReferenceInit»
	   		«val referenceInit = c as ReferenceInit»
	   			«IF referenceInit.object instanceof SpecificObjectSelection»
	   				if (obSelection != null && obSelection.getObject() != null) {
	   					if (hmObjects.get("«(referenceInit.object as SpecificObjectSelection).objSel.name»") != null) {
	   						List<ReferenceConfigurationStrategy> refs = null;
	   						if (refsList.get("«referenceName»") != null) {
	   							refs = refsList.get("«referenceName»");
	   						}
	   						else {
	   							refs = new ArrayList<ReferenceConfigurationStrategy>();
	   						}
							SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(referenceInit.object as SpecificObjectSelection).objSel.name» = hmObjects.get("«(referenceInit.object as SpecificObjectSelection).objSel.name»");
				   			EObject recovered = ModelManager.getObject(resource, entry_«(referenceInit.object as SpecificObjectSelection).objSel.name».getKey());
							if (recovered == null) {
								recovered = entry_«(referenceInit.object as SpecificObjectSelection).objSel.name».getKey();
							}
	   						refs.add(new SpecificReferenceConfigurationStrategy(obSelection.getModel(), obSelection.getObject(), recovered, "«referenceInit.getReference().get(0).name»"));
	   						refsList.put("«referenceName»", refs);
	   					} else {
	   						return numMutantsGenerated;
	   					}
	   				}
	   			«ENDIF»
	   			«IF referenceInit.object instanceof OtherTypeSelection»
	   			if (obSelection != null && obSelection.getObject() != null) {
	   				List<ReferenceConfigurationStrategy> refs = null;
	   				if (refsList.get("«referenceName»") != null) {
	   					refs = refsList.get("«referenceName»");
	   				}
	   				else {
	   					refs = new ArrayList<ReferenceConfigurationStrategy>();
	   				}
	   				refs.add(new RandomReferenceConfigurationStrategy(obSelection.getModel(), obSelection.getObject(), "«referenceInit.getReference().get(0).name»", "«(referenceInit.object as OtherTypeSelection).type.name»"));
	   				refsList.put("«referenceName»", refs);
	   			}
	   			«ENDIF»
			«ENDIF»
			«IF c instanceof ReferenceAdd»
	   		«val referenceAdd = c as ReferenceAdd»
	   			«IF referenceAdd.object instanceof SpecificObjectSelection»
	   				if (obSelection != null && obSelection.getObject() != null) {
	   					if (hmObjects.get("«(referenceAdd.object as SpecificObjectSelection).objSel.name»") != null) {
	   						List<ReferenceConfigurationStrategy> refs = null;
	   						if (refsList.get("«referenceName»") != null) {
	   							refs = refsList.get("«referenceName»");
	   						}
	   						else {
	   							refs = new ArrayList<ReferenceConfigurationStrategy>();
	   						}
							SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(referenceAdd.object as SpecificObjectSelection).objSel.name» = hmObjects.get("«(referenceAdd.object as SpecificObjectSelection).objSel.name»");
				   			EObject recovered = ModelManager.getObject(resource, entry_«(referenceAdd.object as SpecificObjectSelection).objSel.name».getKey());
							if (recovered == null) {
								recovered = entry_«(referenceAdd.object as SpecificObjectSelection).objSel.name».getKey();
							}
	   						refs.add(new SpecificReferenceConfigurationStrategy(obSelection.getModel(), obSelection.getObject(), recovered, "«referenceAdd.getReference().get(0).name»", false));
	   						refsList.put("«referenceName»", refs);
	   					} else {
	   						return numMutantsGenerated;
	   					}
	   				}
	   			«ENDIF»
	   			«IF referenceAdd.object instanceof OtherTypeSelection»
	   				if (obSelection != null && obSelection.getObject() != null) {
	   					List<ReferenceConfigurationStrategy> refs = null;
	   					if (refsList.get("«referenceName»") != null) {
	   						refs = refsList.get("«referenceName»");
	   					}
	   					else {
	   						refs = new ArrayList<ReferenceConfigurationStrategy>();
					}
	   				refs.add(new RandomReferenceConfigurationStrategy(obSelection.getModel(), obSelection.getObject(), "«referenceAdd.getReference().get(0).name»", "«(referenceAdd.object as OtherTypeSelection).type.name»", false));
	   				refsList.put("«referenceName»", refs);
	   			}
	   			«ENDIF»
			«ENDIF»
			«IF c instanceof ReferenceRemove»
	   		«val referenceRemove = c as ReferenceRemove»
	   			«IF referenceRemove.object instanceof SpecificObjectSelection»
	   				if (obSelection != null && obSelection.getObject() != null) {
	   					if (hmObjects.get("«(referenceRemove.object as SpecificObjectSelection).objSel.name»") != null) {
	   						List<ReferenceConfigurationStrategy> refs = null;
	   						if (refsList.get("«referenceName»") != null) {
	   							refs = refsList.get("«referenceName»");
	   						}
	   						else {
	   							refs = new ArrayList<ReferenceConfigurationStrategy>();
	   						}
							SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(referenceRemove.object as SpecificObjectSelection).objSel.name» = hmObjects.get("«(referenceRemove.object as SpecificObjectSelection).objSel.name»");
				   			EObject recovered = ModelManager.getObject(resource, entry_«(referenceRemove.object as SpecificObjectSelection).objSel.name».getKey());
							if (recovered == null) {
								recovered = entry_«(referenceRemove.object as SpecificObjectSelection).objSel.name».getKey();
							}
	   						refs.add(new SpecificReferenceConfigurationStrategy(obSelection.getModel(), obSelection.getObject(), recovered, "«referenceRemove.getReference().get(0).name»", true));
	   						refsList.put("«referenceName»", refs);
	   					} else {
	   						return numMutantsGenerated;
	   					}
	   				}
	   			«ENDIF»
	   			«IF referenceRemove.object instanceof OtherTypeSelection»
	   				if (obSelection != null && obSelection.getObject() != null) {
	   					List<ReferenceConfigurationStrategy> refs = null;
	   					if (refsList.get("«referenceName»") != null) {
	   						refs = refsList.get("«referenceName»");
	   					}
	   					else {
	   						refs = new ArrayList<ReferenceConfigurationStrategy>();
	   					}
	   					refs.add(new RandomReferenceConfigurationStrategy(obSelection.getModel(), obSelection.getObject(), "«referenceRemove.getReference().get(0).name»", "«(referenceRemove.object as OtherTypeSelection).type.name»", true));
	   					refsList.put("«referenceName»", refs);
	   				}
	   			«ENDIF»
			«ENDIF»
			«IF c instanceof ReferenceAtt»
	   			«val referenceAtt = c as ReferenceAtt»
	   			«IF referenceAtt.reference !== null»
					«IF referenceAtt.attribute !== null»
					//NAME:«attributeName = referenceAtt.attribute.name»
					«IF referenceAtt.value !== null»
					«IF (referenceAtt.eContainer as ModifyInformationMutator).object instanceof SpecificObjectSelection»
					EObject refObjectSelected = null;
					if (hmObjects.get("«((referenceAtt.eContainer as ModifyInformationMutator).object as SpecificObjectSelection).objSel.name»") != null) {
						for (EReference ref : hmObjects.get("«((referenceAtt.eContainer as ModifyInformationMutator).object as SpecificObjectSelection).objSel.name»").getKey().eClass().getEReferences()) {
							if (ref.getName().equals("«referenceAtt.reference.get(0).name»")) {
								SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«((referenceAtt.eContainer as ModifyInformationMutator).object as SpecificObjectSelection).objSel.name» = hmObjects.get("«((referenceAtt.eContainer as ModifyInformationMutator).object as SpecificObjectSelection).objSel.name»");
					   			refObjectSelected = ModelManager.getObject(resource, entry_«((referenceAtt.eContainer as ModifyInformationMutator).object as SpecificObjectSelection).objSel.name».getKey());
								break;
							}
						}
					}
					«ELSEIF (referenceAtt.eContainer as ModifyInformationMutator).object instanceof RandomTypeSelection»
					EObject refObjectSelected = null;
					if (obSelection != null) {
						if (obSelection.getObject() != null) {
							for (EReference ref : obSelection.getObject().eClass().getEReferences()) {
								if (ref.getName().equals("«referenceAtt.reference.get(0).name»")) {
									refObjectSelected = (EObject) obSelection.getObject().eGet(ref);
									break;
								}
							}
						}
					}
					«ENDIF»
					if (refObjectSelected != null) {
						objsAttRef.add(refObjectSelected);
						List<AttributeConfigurationStrategy> attsRef = null;
						if (attsRefList.get("«attributeName»") != null) {
							attsRef = attsRefList.get("«attributeName»");
						}
						else {
							attsRef = new ArrayList<AttributeConfigurationStrategy>();
						}
						attsRef.add(«referenceAtt.value.method(true, true, "obSelection")»);
						attsRefList.put("«attributeName»", attsRef);
					}
					«ENDIF»
					«ENDIF»
		   		«ENDIF»
		   	«ENDIF»
		«ENDFOR»
			ModifyInformationMutator mut = new ModifyInformationMutator(obSelection.getModel(),
					obSelection.getMetaModel(), obSelection, attsList, refsList,
					objsAttRef, attsRefList);
			Mutator mutator = null;
			if (muts == null) {
				muts = AppliedMutationsFactory.eINSTANCE.createMutations();
			}

		//COUNTER: «nRegistryMutation = nRegistryMutation + 1»
		//COUNTER: «nRegistryMethodCall = nRegistryMethodCall + 1»
		//REGISTRY METHOD NAME:«registryMethodName = "registry" + nRegistryMethodCall.toString()»
		«IF executeMutation == true»
			if (mut != null) {
				Object mutated = mut.mutate();
					if (mutated != null) {
					«IF mut.name !== null»
					SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(mut.getModel(), mut.getMetaModel());
					SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(mut.getObject(), resourceEntry);
					hmObjects.put("«mut.name»", entry);
					«ENDIF»
						AppMutation appMut = «registryMethodName»(mut, hmMutator, seed, mutPaths, packages);
						if (appMut != null) {
							muts.getMuts().add(appMut);
						}
					}
				}
				«ENDIF»
				mutator = mut;
				if (mutator != null) {
				//«nMethodCall = nMethodCall + 1»
				«IF last == false»
				«IF standalone == false»
				mutation«nMethodCall»(packages, obSelection.getModel(), hmObjects, hmList, hashmapModelFilenames,
									modelFilename, mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,
									registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, project, monitor, k, serialize, test, classes);
				«ELSE»
				mutation«nMethodCall»(packages, obSelection.getModel(), hmObjects, hmList, hashmapModelFilenames,
									modelFilename, mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,
									registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, monitor, k, serialize, test, classes);
				«ENDIF»
				numMutantsGenerated = k[0];
				«ENDIF»
				«IF last == true»
				// MUTANT COMPLETION AND REGISTRY
				Map<String, List<String>> rules = new HashMap<String, List<String>>();
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
				«IF b === null»
				String mutFilename = hashmapModelFilenames.get(modelFilename) + "/" + "Output" + k[0] + ".model";
				«ELSE»
		   		«IF b.from.size == 0»
					String mutFilename = hashmapModelFilenames.get(modelFilename) + "/«b.name»/Output" + k[0] + ".model";
		   		«ELSE»
					String mutFilename = hashmapModelFilenames.get(modelFilename) + "/«b.name»/" + hashmapModelFolders.get(modelFilename) + "/Output" + k[0] + ".model";
		   		«ENDIF»
		   		«ENDIF»
		   		«IF b === null»
		   		«IF standalone == false»
		   			boolean isRepeated = registryMutant(ecoreURI, packages, registeredPackages, localRegisteredPackages, seed, mutator.getModel(), rules, muts, modelFilename, mutFilename, registry, hashsetMutantsBlock, hashmapModelFilenames, k, mutPaths, hashmapMutVersions, project, serialize, test, classes, this.getClass(), true);
		   		«ELSE»
		   			boolean isRepeated = registryMutantStandalone(ecoreURI, packages, registeredPackages, localRegisteredPackages, seed, mutator.getModel(), rules, muts, modelFilename, mutFilename, registry, hashsetMutantsBlock, hashmapModelFilenames, k, mutPaths, hashmapMutVersions, "«getProjectName»", serialize, test, classes, «className».class, true);
		   		«ENDIF»
		   		«ELSE»
		   		«IF standalone == false»
					boolean isRepeated = registryMutantWithBlocks(ecoreURI, packages, registeredPackages, localRegisteredPackages, seed, mutator.getModel(), rules, muts, modelFilename, mutFilename, registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "«b.name»", fromNames, k, mutPaths, hashmapMutVersions, project, serialize, test, classes, this.getClass(), true, false);
				«ELSE»
					boolean isRepeated = registryMutantWithBlocksStandalone(ecoreURI, packages, registeredPackages, localRegisteredPackages, seed, mutator.getModel(), rules, muts, modelFilename, mutFilename, registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "«b.name»", fromNames, k, mutPaths, hashmapMutVersions, "«getProjectName»", serialize, test, classes, «className».class, true, false);
				«ENDIF»
				«ENDIF»
					if (isRepeated == false) {
						numMutantsGenerated++;
						monitor.worked(1);
						k[0] = k[0] + 1;
					}
					muts = null;
		«ENDIF»
				}
			}
		}
		//END MODIFY INFORMATION «methodName»
	'''

	def createObjectMutator(CreateObjectMutator mut) '''
		//CREATE OBJECT «methodName»
		«IF mut.container === null»
			List<EObject> containers = ModelManager.getParentObjects(packages, model, "«mut.type.name»");
			EObject container = containers.get(ModelManager.getRandomIndex(containers));
			ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, container);
			SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model, null, null);
		«ELSE»
			«IF mut.container instanceof RandomTypeSelection»
				RandomTypeSelection rts = new RandomTypeSelection(packages, model, "«(mut.container as RandomTypeSelection).type.name»");
				EObject container = rts.getObject();
				ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, container);
				«IF mut.container.refType !== null»
					SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model, "«mut.container.refType.name»", containerSelection);
				«ELSE»
					SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model, null, null);
				«ENDIF»
			«ENDIF»
			«IF mut.container instanceof CompleteTypeSelection»
				«/* THE SAME AS RANDOM */»
				RandomTypeSelection rts = new RandomTypeSelection(packages, model, "«(mut.container as CompleteTypeSelection).type.name»");
				EObject container = rts.getObject();
				ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, container);
				«IF mut.container.refType !== null»
					SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model, "«mut.container.refType.name»", containerSelection);
				«ELSE»
					SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model, null, null);
				«ENDIF»
			«ENDIF»
			«IF mut.container instanceof SpecificObjectSelection»
				ObSelectionStrategy containerSelection = null;
				SpecificReferenceSelection referenceSelection = null;
				SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.container as SpecificObjectSelection).objSel.name» = hmObjects.get("«(mut.container as SpecificObjectSelection).objSel.name»");
				if (entry_«(mut.container as SpecificObjectSelection).objSel.name» != null) {
				«IF mut.container.refType !== null»
					containerSelection = new SpecificObjectSelection(entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getValue(), entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getKey(), entry_«(mut.container as SpecificObjectSelection).objSel.name».getKey());
					referenceSelection = new SpecificReferenceSelection(entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getValue(), entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getKey(), "«mut.container.refType.name»", entry_«(mut.container as SpecificObjectSelection).objSel.name».getKey());
				«ELSE»
					referenceSelection = new SpecificReferenceSelection(entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getValue(), entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getKey(), null, null);
				«ENDIF»
				} else {
					return mutations;
				}
			«ENDIF»
			«IF mut.container instanceof SpecificClosureSelection»
				ObSelectionStrategy containerSelection = null;
				SpecificReferenceSelection referenceSelection = null;
				SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.container as SpecificClosureSelection).objSel.name» = hmObjects.get("«(mut.container as SpecificClosureSelection).objSel.name»");
				if (entry_«(mut.container as SpecificClosureSelection).objSel.name» != null) {
				«IF mut.container.refType !== null»
					containerSelection = new SpecificClosureSelection(entry_«(mut.container as SpecificClosureSelection).objSel.name».getValue().getValue(), entry_«(mut.container as SpecificClosureSelection).objSel.name».getValue().getKey(), entry_«(mut.container as SpecificClosureSelection).objSel.name».getKey(), "«(mut.container as SpecificClosureSelection).objSel.name»");
					referenceSelection = new SpecificReferenceSelection(entry_«(mut.container as SpecificClosureSelection).objSel.name».getValue().getValue(), entry_«(mut.container as SpecificClosureSelection).objSel.name».getValue().getKey(), "«mut.container.refType.name»", entry_«(mut.container as SpecificClosureSelection).objSel.name».getKey());
				«ELSE»
					referenceSelection = new SpecificReferenceSelection(entry_«(mut.container as SpecificClosureSelection).objSel.name».getValue().getValue(), entry_«(mut.container as SpecificClosureSelection).objSel.name».getValue().getKey(), null, null);
				} else {
					return mutations;
				}
				«ENDIF»
			«ENDIF»
		«ENDIF»
		Map<String, AttributeConfigurationStrategy> atts = new HashMap<String, AttributeConfigurationStrategy>();
		ObSelectionStrategy objectSelection = null;
		//«var counter = 0»
		«FOR c : mut.attributes»
			//«counter++»
			«c.method(false, false, counter, false, "objectSelection")»
		«ENDFOR»
		Map<String, ObSelectionStrategy> refs = new HashMap<String, ObSelectionStrategy>();
		«FOR c : mut.references»
			«c.method(false)»
		«ENDFOR»
		CreateObjectMutator mut = new CreateObjectMutator(model, packages, referenceSelection, containerSelection, atts, refs, "«mut.type.name»");
		//INC COUNTER: «nMutation++»
		//INC COUNTER: «nRegistryMutation++»
		if (mut != null) {
			mut.setId("m«nMutation»");
			mutations.add(mut);
		}
		//END CREATE OBJECT «methodName»
	'''

	def createObjectMutatorExhaustive(CreateObjectMutator mut, MutatorEnvironment e, Block b, boolean last) '''
		//CREATE OBJECT «methodName»
		«IF mut.container === null»
			List<EObject> containers = ModelManager.getParentObjects(packages, model, "«mut.type.name»");
			EObject container = containers.get(ModelManager.getRandomIndex(containers));
			ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, container);
			SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model, null, null);
		«ELSE»
			«IF mut.container instanceof RandomTypeSelection»
				RandomTypeSelection rts = new RandomTypeSelection(packages, model, "«(mut.container as RandomTypeSelection).type.name»");
				EObject container = rts.getObject();
				ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, container);
				«IF mut.container.refType !== null»
					SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model, "«mut.container.refType.name»", containerSelection);
				«ELSE»
					SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model, null, null);
				«ENDIF»
			«ENDIF»
			«IF mut.container instanceof CompleteTypeSelection»
				«/* THE SAME AS RANDOM */»
				RandomTypeSelection rts = new RandomTypeSelection(packages, model, "«(mut.container as CompleteTypeSelection).type.name»");
				EObject container = rts.getObject();
				ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, container);
				«IF mut.container.refType !== null»
					SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model, "«mut.container.refType.name»", containerSelection);
				«ELSE»
					SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model, null, null);
				«ENDIF»
			«ENDIF»
			«IF mut.container instanceof SpecificObjectSelection»
				ObSelectionStrategy containerSelection = null;
				SpecificReferenceSelection referenceSelection = null;
				SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.container as SpecificObjectSelection).objSel.name» = hmObjects.get("«(mut.container as SpecificObjectSelection).objSel.name»");
				if (entry_«(mut.container as SpecificObjectSelection).objSel.name» != null) {
					EObject recovered = ModelManager.getObject(model, entry_«(mut.container as SpecificObjectSelection).objSel.name».getKey());
					if (recovered == null) {
						recovered = entry_«(mut.container as SpecificObjectSelection).objSel.name».getKey();
					}
				«IF mut.container.refType !== null»
					containerSelection = new SpecificObjectSelection(packages, model, recovered);
					referenceSelection = new SpecificReferenceSelection(packages, model, "«mut.container.refType.name»", recovered);
				«ELSE»
					referenceSelection = new SpecificReferenceSelection(packages, model, null, null);
				«ENDIF»
				} else {
					return numMutantsGenerated;
				}
			«ENDIF»
			«IF mut.container instanceof SpecificClosureSelection»
				ObSelectionStrategy containerSelection = null;
				SpecificReferenceSelection referenceSelection = null;
				SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.container as SpecificClosureSelection).objSel.name» = hmObjects.get("«(mut.container as SpecificClosureSelection).objSel.name»");
				if (entry_«(mut.container as SpecificClosureSelection).objSel.name» != null) {
					EObject recovered = ModelManager.getObject(model, entry_«(mut.container as SpecificClosureSelection).objSel.name».getKey());
					if (recovered == null) {
						recovered = entry_«(mut.container as SpecificClosureSelection).objSel.name».getKey();
					}
				«IF mut.container.refType !== null»
					containerSelection = new SpecificClosureSelection(packages, model, recovered, "«(mut.container as SpecificClosureSelection).objSel.name»");
					referenceSelection = new SpecificReferenceSelection(pakages, model, "«mut.container.refType.name»", recovered);
				«ELSE»
					referenceSelection = new SpecificReferenceSelection(packages, model, null, null);
				} else {
					return numMutantsGenerated;
				}
				«ENDIF»
			«ENDIF»
		«ENDIF»
		Map<String, AttributeConfigurationStrategy> atts = new HashMap<String, AttributeConfigurationStrategy>();
		ObSelectionStrategy objectSelection = null;
		//«var counter = 0»
		«FOR c : mut.attributes»
			//«counter++»
			«c.method(false, false, counter, true, "objectSelection")»
		«ENDFOR»
		Map<String, ObSelectionStrategy> refs = new HashMap<String, ObSelectionStrategy>();
		«FOR c : mut.references»
			«c.method(true)»
		«ENDFOR»
		CreateObjectMutator mut = new CreateObjectMutator(model, packages, referenceSelection, containerSelection, atts, refs, "«mut.type.name»");
		Mutator mutator = null;
		if (muts == null) {
			muts = AppliedMutationsFactory.eINSTANCE.createMutations();
		}

		//COUNTER: «nRegistryMutation = nRegistryMutation + 1»
		//COUNTER: «nRegistryMethodCall = nRegistryMethodCall + 1»
		//REGISTRY METHOD NAME:«registryMethodName = "registry" + nRegistryMethodCall.toString()»
		«IF executeMutation == true»
			if (mut != null) {
				Object mutated = mut.mutate();
					if (mutated != null) {
						«IF mut.name !== null»
						SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(mut.getModel(), mut.getMetaModel());
						SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(mut.getObject(), resourceEntry);
						hmObjects.put("«mut.name»", entry);
						«ENDIF»
						AppMutation appMut = «registryMethodName»(mut, hmMutator, seed, mutPaths, packages);
						if (appMut != null) {
							muts.getMuts().add(appMut);
						}
					}
				}
				«ENDIF»
				mutator = mut;
				if (mutator != null) {
				//«nMethodCall = nMethodCall + 1»
				«IF last == false»
				«IF standalone == false»
				mutation«nMethodCall»(packages, model, hmObjects, hmList, hashmapModelFilenames,
									modelFilename, mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,
									registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, project, monitor, k, serialize, test, classes);
				«ELSE»
				mutation«nMethodCall»(packages, model, hmObjects, hmList, hashmapModelFilenames,
									modelFilename, mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,
									registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, monitor, k, serialize, test, classes);
				«ENDIF»
				numMutantsGenerated = k[0];
				«ENDIF»
				«IF last == true»
				// MUTANT COMPLETION AND REGISTRY
				Map<String, List<String>> rules = new HashMap<String, List<String>>();
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
				«IF b === null»
				String mutFilename = hashmapModelFilenames.get(modelFilename) + "/" + "Output" + k[0] + ".model";
				«ELSE»
		   		«IF b.from.size == 0»
					String mutFilename = hashmapModelFilenames.get(modelFilename) + "/«b.name»/Output" + k[0] + ".model";
		   		«ELSE»
					String mutFilename = hashmapModelFilenames.get(modelFilename) + "/«b.name»/" + hashmapModelFolders.get(modelFilename) + "/Output" + k[0] + ".model";
		   		«ENDIF»
		   		«ENDIF»
		   		«IF b === null»
		   		«IF standalone == false»
		   			boolean isRepeated = registryMutant(ecoreURI, packages, registeredPackages, localRegisteredPackages, seed, mutator.getModel(), rules, muts, modelFilename, mutFilename, registry, hashsetMutantsBlock, hashmapModelFilenames, k, mutPaths, hashmapMutVersions, project, serialize, test, classes, this.getClass(), true);
		   		«ELSE»
		   			boolean isRepeated = registryMutantStandalone(ecoreURI, packages, registeredPackages, localRegisteredPackages, seed, mutator.getModel(), rules, muts, modelFilename, mutFilename, registry, hashsetMutantsBlock, hashmapModelFilenames, k, mutPaths, hashmapMutVersions, "«getProjectName»", serialize, test, classes, «className».class, true);
		   		«ENDIF»
		   		«ELSE»
		   		«IF standalone == false»
					boolean isRepeated = registryMutantWithBlocks(ecoreURI, packages, registeredPackages, localRegisteredPackages, seed, mutator.getModel(), rules, muts, modelFilename, mutFilename, registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "«b.name»", fromNames, k, mutPaths, hashmapMutVersions, project, serialize, test, classes, this.getClass(), true, false);
				«ELSE»
					boolean isRepeated = registryMutantWithBlocksStandalone(ecoreURI, packages, registeredPackages, localRegisteredPackages, seed, mutator.getModel(), rules, muts, modelFilename, mutFilename, registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "«b.name»", fromNames, k, mutPaths, hashmapMutVersions, "«getProjectName»", serialize, test, classes, «className».class, true, false);
				«ENDIF»
				«ENDIF»
					if (isRepeated == false) {
						numMutantsGenerated++;
						monitor.worked(1);
						k[0] = k[0] + 1;
					}
					muts = null;
		«ENDIF»
			}
		//END CREATE OBJECT «methodName»
	'''
	
	def selectObjectMutator(SelectObjectMutator mut) '''
	//SELECT OBJECT «methodName»
		ObSelectionStrategy containerSelection = null;
		SpecificReferenceSelection referenceSelection = null;
		List<EPackage> resourcePackages = packages;
		List<Resource> resources = new ArrayList<Resource>();
		resources.add(model);
		//«var boolean rts = false»
		«IF mut.object instanceof RandomTypeSelection || mut.object instanceof CompleteTypeSelection»
			«IF mut.object.resource === null»
			«IF mut.container === null»
			«IF mut.object instanceof RandomTypeSelection»
			//«rts = true»
			RandomTypeSelection rts = new RandomTypeSelection(packages, model, "«(mut.object as RandomTypeSelection).type.name»");
			«ENDIF»
			«IF mut.object instanceof CompleteTypeSelection»
			//«rts = true»
			RandomTypeSelection rts = new RandomTypeSelection(packages, model, "«(mut.object as CompleteTypeSelection).type.name»");
			«ENDIF»
			«ELSE»
				«IF mut.container instanceof RandomTypeSelection»
					//«rts = true»
					RandomTypeSelection rts = new RandomTypeSelection(packages, model, "«(mut.container as RandomTypeSelection).type.name»");
					EObject container = rts.getObject();
					«IF mut.container.refType !== null»
					//«var refName = mut.container.refType.name»
					«IF mut.container.refRefType !== null»
					container = ModelManager.getReference("«mut.container.refType.name»", container);
					//«refName = mut.container.refRefType.name»
					«IF mut.container.refRefRefType !== null»
					container = ModelManager.getReference("«mut.container.refRefType.name»", container);
					//«refName = mut.container.refRefRefType.name»
					«ENDIF»
					«ENDIF»
					containerSelection = new SpecificObjectSelection(packages, model, container);
					referenceSelection = new SpecificReferenceSelection(packages, model, "«refName»", containerSelection);
					«ELSE»
						referenceSelection = new SpecificReferenceSelection(packages, model, null, null);
					«ENDIF»
				«ELSEIF mut.container instanceof CompleteTypeSelection»
					«/* THE SAME AS RANDOM */»
					//«rts = true»
					RandomTypeSelection rts = new RandomTypeSelection(packages, model, "«(mut.container as CompleteTypeSelection).type.name»");
					EObject container = rts.getObject();
					containerSelection = new SpecificObjectSelection(packages, model, container);
					«IF mut.container.refType !== null»
						referenceSelection = new SpecificReferenceSelection(packages, model, "«mut.container.refType.name»", containerSelection);
					«ELSE»
						referenceSelection = new SpecificReferenceSelection(packages, model, null, null);
					«ENDIF»
				«ELSEIF mut.container instanceof SpecificObjectSelection»
					SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.container as SpecificObjectSelection).objSel.name» = hmObjects.get("«(mut.container as SpecificObjectSelection).objSel.name»");
					if (entry_«(mut.container as SpecificObjectSelection).objSel.name» != null) {
						resourcePackages = entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getValue();
						resources = new ArrayList<Resource>();
						resources.add(entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getKey());
						containerSelection = new SpecificObjectSelection(entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getValue(), entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getKey(), entry_«(mut.container as SpecificObjectSelection).objSel.name».getKey());
					} else {
						List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_«(mut.container as SpecificObjectSelection).objSel.name» = hmList.get("«(mut.container as SpecificObjectSelection).objSel.name»");
						if (listEntry_«(mut.container as SpecificObjectSelection).objSel.name» != null) {
							List<EObject> objs = new ArrayList<EObject>();
							resourcePackages = listEntry_«(mut.container as SpecificObjectSelection).objSel.name».get(0).getValue().getValue();
							resources = new ArrayList<Resource>();
							resources.add(listEntry_«(mut.container as SpecificObjectSelection).objSel.name».get(0).getValue().getKey());
							for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_«(mut.container as SpecificObjectSelection).objSel.name») {
								EObject obj = ent.getKey();
								objs.add(obj);
							}
							containerSelection = new SpecificObjectSelection(listEntry_«(mut.container as SpecificObjectSelection).objSel.name».get(0).getValue().getValue(), listEntry_«(mut.container as SpecificObjectSelection).objSel.name».get(0).getValue().getKey(), objs);
						}
						else {
							return mutations;
						}
					}
					if (entry_«(mut.container as SpecificObjectSelection).objSel.name» != null) {
						resourcePackages = entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getValue();
						resources = new ArrayList<Resource>();
						resources.add(entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getKey());
						List<EObject> recovered = new ArrayList<EObject>();
						recovered.add(entry_«(mut.container as SpecificObjectSelection).objSel.name».getKey());
						«IF mut.container.refType !== null»
							//«var refName = mut.container.refType.name»
							«IF mut.container.refRefType !== null»
							Object ob = ModelManager.getReferenced("«mut.container.refType.name»", recovered.get(0));
							if (ob instanceof EObject) {
								recovered.add((EObject) ob);
							}
							else {
								recovered.add(((List<EObject>) ob).get(ModelManager.getRandomIndex((List<EObject>) ob)));
							}
							//«refName = mut.container.refRefType.name»
							containerSelection = new SpecificObjectSelection(entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getValue(), entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getKey(), recovered.get(1));
							referenceSelection = new SpecificReferenceSelection(entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getValue(), entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getKey(), "«refName»", recovered.get(1));
							«IF mut.container.refRefRefType !== null»
							ob = ModelManager.getReferenced("«mut.container.refRefType.name»", recovered.get(1));
							List<EObject> tmp = new ArrayList<EObject>();
							tmp.add(recovered.get(1));
							if (ob instanceof EObject) {
								tmp.add((EObject) ob);
							}
							else {
								tmp.add(((List<EObject>) ob).get(ModelManager.getRandomIndex((List<EObject>) ob)));
							}
							recovered = tmp;
							//«refName = mut.container.refRefRefType.name»
							containerSelection = new SpecificObjectSelection(entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getValue(), entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getKey(), recovered.get(1));
							referenceSelection = new SpecificReferenceSelection(entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getValue(), entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getKey(), "«refName»", recovered.get(1));
							«ENDIF»
							«ELSE»
							containerSelection = new SpecificObjectSelection(entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getValue(), entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getKey(), recovered.get(0));
							referenceSelection = new SpecificReferenceSelection(entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getValue(), entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getKey(), "«refName»", recovered.get(0));
							«ENDIF»
						} else {
							List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_«(mut.container as SpecificObjectSelection).objSel.name» = hmList.get("«(mut.container as SpecificObjectSelection).objSel.name»");
							if (listEntry_«(mut.container as SpecificObjectSelection).objSel.name» != null) {
								List<EObject> objs = new ArrayList<EObject>();
								resourcePackages = listEntry_«(mut.container as SpecificObjectSelection).objSel.name».get(0).getValue().getValue();
								resources = new ArrayList<Resource>();
								resources.add(listEntry_«(mut.container as SpecificObjectSelection).objSel.name».get(0).getValue().getKey());
								for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_«(mut.container as SpecificObjectSelection).objSel.name») {
									EObject obj = ent.getKey();
									objs.add(obj);
								}
								referenceSelection = new SpecificReferenceSelection(listEntry_«(mut.container as SpecificObjectSelection).objSel.name».get(0).getValue().getValue(), listEntry_«(mut.container as SpecificObjectSelection).objSel.name».get(0).getValue().getKey(), "«mut.container.refType.name»", listEntry_«(mut.container as SpecificObjectSelection).objSel.name».get(0).getKey());
							}
							else {
								return mutations;
							}
						}
					«ELSE»
						referenceSelection = new SpecificReferenceSelection(packages, model, null, null);
					«ENDIF»
				«ELSEIF mut.container instanceof SpecificClosureSelection»
					SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.container as SpecificClosureSelection).objSel.name» = hmObjects.get("«(mut.container as SpecificClosureSelection).objSel.name»");
					if (entry_«(mut.container as SpecificClosureSelection).objSel.name» != null) {
						resourcePackages = entry_«(mut.container as SpecificClosureSelection).objSel.name».getValue().getValue();
						resources = new ArrayList<Resource>();
						resources.add(entry_«(mut.container as SpecificClosureSelection).objSel.name».getValue().getKey());
						containerSelection = new SpecificClosureSelection(entry_«(mut.container as SpecificClosureSelection).objSel.name».getValue().getValue(), entry_«(mut.container as SpecificClosureSelection).objSel.name».getValue().getKey(), entry_«(mut.container as SpecificClosureSelection).objSel.name».getKey(), "«(mut.container as SpecificClosureSelection).refType.name»");
					} else {
						List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_«(mut.container as SpecificClosureSelection).objSel.name» = hmList.get("«(mut.container as SpecificClosureSelection).objSel.name»");
						if (listEntry_«(mut.container as SpecificClosureSelection).objSel.name» != null) {
							List<EObject> objs = new ArrayList<EObject>();
							resourcePackages = listEntry_«(mut.container as SpecificClosureSelection).objSel.name».get(0).getValue().getValue();
							resources = new ArrayList<Resource>();
							resources.add(listEntry_«(mut.container as SpecificClosureSelection).objSel.name».get(0).getValue().getKey());
							for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_«(mut.container as SpecificClosureSelection).objSel.name») {
								EObject obj = ent.getKey();
								objs.add(obj);
							}
							referenceSelection = new SpecificReferenceSelection(listEntry_«(mut.container as SpecificClosureSelection).objSel.name».get(0).getValue().getValue(), listEntry_«(mut.container as SpecificClosureSelection).objSel.name».get(0).getValue().getKey(), "«mut.container.refType.name»", listEntry_«(mut.container as SpecificClosureSelection).objSel.name».get(0).getKey());
						}
						else {
							return mutations;
						}
					}
					«IF mut.container.refType !== null»
						if (entry_«(mut.container as SpecificClosureSelection).objSel.name» != null) {
							resourcePackages = entry_«(mut.container as SpecificClosureSelection).objSel.name».getValue().getValue();
							resources = new ArrayList<Resource>();
							resources.add(entry_«(mut.container as SpecificClosureSelection).objSel.name».getValue().getKey());
							referenceSelection = new SpecificReferenceSelection(entry_«(mut.container as SpecificClosureSelection).objSel.name».getValue().getValue(), entry_«(mut.container as SpecificClosureSelection).objSel.name».getValue().getKey(), "«mut.container.refType.name»", entry_«(mut.container as SpecificClosureSelection).objSel.name».getKey());
						} else {
							return mutations;
						}
					«ELSE»
						referenceSelection = new SpecificReferenceSelection(packages, model, null, null);
					«ENDIF»
				«ENDIF»
				«IF rts == true»
				rts = new RandomTypeSelection(packages, model, "«mut.object.type.name»", referenceSelection, containerSelection);
				«ELSE»
				RandomTypeSelection rts = new RandomTypeSelection(containerSelection.getMetaModel(), containerSelection.getModel(), "«mut.object.type.name»", referenceSelection, containerSelection);
				«ENDIF»
				«IF ((mut.object.expression === null) && (mut.container.expression === null))»
					EObject object = rts.getObject();
				«ENDIF»
			«ENDIF»
			«IF ((mut.object.expression === null) && (mut.container === null))»
				EObject object = rts.getObject();
			«ENDIF»
			«IF mut.object.refType !== null»
			Object o = object.eGet("«mut.object.refType»");
			if (o instanceof EObject) {
				object = (EObject) o;
			}
			if (o instanceof List<?>) {
				object = ((List<EObject) o).get(ModelManager.getRandomIndex((List<EObject) o));
			}
			«ENDIF»
			«ELSE»
			//«val List<String> resourceURIs = new ArrayList<String>()»
			//«val List<String> ecoreURIs = new ArrayList<String>()»
			//«val String resourceName = mut.object.resource»
			//«var mutatorenvironment.Resource resource = null»
			«FOR res : program.resources»
				«IF res.name.equals(resourceName)»
					//«resource = res» 
				«ENDIF»
			«ENDFOR»
			«IF resource !== null»
			//«val Source source = resource.path»
			//«val String resourcePath = ModelManager.workspaceAbsolutePath + "/" + getProjectName + "/" + source.path»
			«IF (new File(resourcePath)).exists()»
			«FOR resourceFile : (new File(resourcePath)).listFiles»
				«IF resourceFile.name.endsWith(".model")»
					//«resourceURIs.add(resourceFile.path)»
				«ENDIF»
				«IF resourceFile.name.endsWith(".ecore")»
					//«ecoreURIs.add(resourceFile.path)»
				«ENDIF»
			«ENDFOR»
			«ENDIF»
			//«val String metamodelPath = resource.metamodel.replace("\\", "/")»
			«IF standalone == false»
			resourcePackages = ModelManager.loadMetaModel("«metamodelPath»", this.getClass());
			«ELSE»
			resourcePackages = ModelManager.loadMetaModel("«metamodelPath»", «className».class);
			«ENDIF»
			resources = new ArrayList<Resource>();
			«FOR resourceURI : resourceURIs»
			«IF standalone == false»
			resources.add(ModelManager.loadModel(resourcePackages, URI.createURI("file:/" + "«resourceURI»").toFileString()));
			«ELSE»
			resources.add(ModelManager.loadModelNoException(resourcePackages, URI.createURI("file:/" + "«resourceURI»").toFileString()));
			«ENDIF»
			«ENDFOR»
			«FOR ecoreURI : ecoreURIs»
			//«val ecoreURI2 = ecoreURI.replace("\\", "/")»
			«IF standalone == false»
			resources.add(ModelManager.loadMetaModelAsResource(resourcePackages, "«ecoreURI2»"));
			«ELSE»
			resources.add(ModelManager.loadMetaModelAsResourceNoException(resourcePackages, "file:/«ecoreURI2»"));
			«ENDIF»
			«ENDFOR»
			«IF mut.container === null»
			«IF mut.object instanceof RandomTypeSelection»
			//«rts = true»
			RandomTypeSelection rts = new RandomTypeSelection(resourcePackages, resources, "«(mut.object as RandomTypeSelection).type.name»");
			«ENDIF»
			«IF mut.object instanceof CompleteTypeSelection»
			//«rts = true»
			RandomTypeSelection rts = new RandomTypeSelection(resourcePackages, resources, "«(mut.object as CompleteTypeSelection).type.name»");
			«ENDIF»
			«ELSE»
				«IF mut.container instanceof RandomTypeSelection»
					//«rts = true»
					RandomTypeSelection rts = new RandomTypeSelection(resourcePackages, resources, "«(mut.container as RandomTypeSelection).type.name»");
					EObject container = rts.getObject();
					containerSelection = new SpecificObjectSelection(resourcePackages, resources, container);
					«IF mut.container.refType !== null»
						referenceSelection = new SpecificReferenceSelection(resourcePackages, resources, "«mut.container.refType.name»", containerSelection);
					«ELSE»
						referenceSelection = new SpecificReferenceSelection(resourcePackages, resources, null, null);
					«ENDIF»
				«ELSEIF mut.container instanceof CompleteTypeSelection»
					«/* THE SAME AS RANDOM */»
					//«rts = true»
					RandomTypeSelection rts = new RandomTypeSelection(resourcePackages, resources, "«(mut.container as CompleteTypeSelection).type.name»");
					EObject container = rts.getObject();
					containerSelection = new SpecificObjectSelection(resourcePackages, resources, container);
					«IF mut.container.refType !== null»
						referenceSelection = new SpecificReferenceSelection(resourcePackages, resources, "«mut.container.refType.name»", containerSelection);
					«ELSE»
						referenceSelection = new SpecificReferenceSelection(resourcePackages, resources, null, null);
					«ENDIF»
				«ELSEIF mut.container instanceof SpecificObjectSelection»
					SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.container as SpecificObjectSelection).objSel.name» = hmObjects.get("«(mut.container as SpecificObjectSelection).objSel.name»");
					if (entry_«(mut.container as SpecificObjectSelection).objSel.name» != null) {
						resourcePackages = entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getValue();
						resources = new ArrayList<Resource>();
						resources.add(entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getKey());
						containerSelection = new SpecificObjectSelection(entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getValue(), entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getKey(), entry_«(mut.container as SpecificObjectSelection).objSel.name».getKey());
					} else {
						List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_«(mut.container as SpecificObjectSelection).objSel.name» = hmList.get("«(mut.container as SpecificObjectSelection).objSel.name»");
						if (listEntry_«(mut.container as SpecificObjectSelection).objSel.name» != null) {
							List<EObject> objs = new ArrayList<EObject>();
							resourcePackages = listEntry_«(mut.container as SpecificObjectSelection).objSel.name».get(0).getValue().getValue();
							resources = new ArrayList<Resource>();
							resources.add(listEntry_«(mut.container as SpecificObjectSelection).objSel.name».get(0).getValue().getKey());
							for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_«(mut.container as SpecificObjectSelection).objSel.name») {
								EObject obj = ent.getKey();
								objs.add(obj);
							}
							containerSelection = new SpecificObjectSelection(listEntry_«(mut.container as SpecificObjectSelection).objSel.name».get(0).getValue().getValue(), listEntry_«(mut.container as SpecificObjectSelection).objSel.name».get(0).getValue().getKey(), objs);
						}
						else {
							return mutations;
						}
					}
					«IF mut.container.refType !== null»
						SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.container as SpecificObjectSelection).objSel.name» = hmObjects.get("«(mut.container as SpecificObjectSelection).objSel.name»");
						if (entry_«(mut.container as SpecificObjectSelection).objSel.name» != null) {
							resourcePackages = listEntry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getValue();
							resources = new ArrayList<Resource>();
							resources.add(listEntry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getKey());
							referenceSelection = new SpecificReferenceSelection(entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getValue(), entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getKey(), "«mut.container.refType.name»", entry_«(mut.container as SpecificObjectSelection).objSel.name».getKey());
						} else {
							List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_«(mut.container as SpecificObjectSelection).objSel.name» = hmList.get("«(mut.container as SpecificObjectSelection).objSel.name»");
							if (listEntry_«(mut.container as SpecificObjectSelection).objSel.name» != null) {
								List<EObject> objs = new ArrayList<EObject>();
								resourcePackages = listEntry_«(mut.container as SpecificObjectSelection).objSel.name».get(0).getValue().getValue();
								resources = new ArrayList<Resource>();
								resources.add(listEntry_«(mut.container as SpecificObjectSelection).objSel.name».get(0).getValue().getKey());
								for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_«(mut.container as SpecificObjectSelection).objSel.name») {
									EObject obj = ent.getKey();
									objs.add(obj);
								}
								referenceSelection = new SpecificReferenceSelection(listEntry_«(mut.container as SpecificObjectSelection).objSel.name».get(0).getValue().getValue(), listEntry_«(mut.container as SpecificObjectSelection).objSel.name».get(0).getValue().getKey(), "«mut.container.refType.name»", listEntry_«(mut.container as SpecificObjectSelection).objSel.name».get(0).getKey());
							}
							else {
								return mutations;
							}
						}
					«ELSE»
						referenceSelection = new SpecificReferenceSelection(resourcePackages, resources, null, null);
					«ENDIF»
				«ELSEIF mut.container instanceof SpecificClosureSelection»
					SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.container as SpecificClosureSelection).objSel.name» = hmObjects.get("«(mut.container as SpecificClosureSelection).objSel.name»");
					if (entry_«(mut.container as SpecificClosureSelection).objSel.name» != null) {
						resourcePackages = entry_«(mut.container as SpecificClosureSelection).objSel.name».getValue().getValue();
						resources = new ArrayList<Resource>();
						resources.add(entry_«(mut.container as SpecificClosureSelection).objSel.name».getValue().getKey());
						containerSelection = new SpecificClosureSelection(entry_«(mut.container as SpecificClosureSelection).objSel.name».getValue().getValue(), entry_«(mut.container as SpecificClosureSelection).objSel.name».getValue().getKey(), entry_«(mut.container as SpecificClosureSelection).objSel.name».getKey(), "«(mut.container as SpecificClosureSelection).refType.name»");
					} else {
						List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_«(mut.container as SpecificClosureSelection).objSel.name» = hmList.get("«(mut.container as SpecificObjectSelection).objSel.name»");
						if (listEntry_«(mut.container as SpecificClosureSelection).objSel.name» != null) {
							List<EObject> objs = new ArrayList<EObject>();
							resourcePackages = listEntry_«(mut.container as SpecificClosureSelection).objSel.name».get(0).getValue().getValue();
							resources = new ArrayList<Resource>();
							resources.add(listEntry_«(mut.container as SpecificClosureSelection).objSel.name».get(0).getValue().getKey());
							for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_«(mut.container as SpecificClosureSelection).objSel.name») {
								EObject obj = ent.getKey();
								objs.add(obj);
							}
							containerSelection = new SpecificObjectSelection(listEntry_«(mut.container as SpecificClosureSelection).objSel.name».get(0).getValue().getValue(), listEntry_«(mut.container as SpecificClosureSelection).objSel.name».get(0).getValue().getKey(), objs);
						}
						else {
							return mutations;
						}
					}
					«IF mut.container.refType !== null»
						if (entry_«(mut.container as SpecificClosureSelection).objSel.name» != null) {
							resourcePackages = entry_«(mut.container as SpecificClosureSelection).objSel.name».getValue().getValue();
							resources = new ArrayList<Resource>();
							resources.add(entry_«(mut.container as SpecificClosureSelection).objSel.name».getValue().getKey());
							referenceSelection = new SpecificReferenceSelection(entry_«(mut.container as SpecificClosureSelection).objSel.name».getValue().getValue(), entry_«(mut.container as SpecificClosureSelection).objSel.name».getValue().getKey(), "«mut.container.refType.name»", entry_«(mut.container as SpecificClosureSelection).objSel.name».getKey());
						} else {
							List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_«(mut.container as SpecificClosureSelection).objSel.name» = hmList.get("«(mut.container as SpecificClosureSelection).objSel.name»");
							if (listEntry_«(mut.container as SpecificClosureSelection).objSel.name» != null) {
								List<EObject> objs = new ArrayList<EObject>();
								resourcePackages = listEntry_«(mut.container as SpecificClosureSelection).objSel.name».get(0).getValue().getValue();
								resources = new ArrayList<Resource>();
								resources.add(listEntry_«(mut.container as SpecificClosureSelection).objSel.name».get(0).getValue().getKey());
								for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_«(mut.container as SpecificClosureSelection).objSel.name») {
									EObject obj = ent.getKey();
									objs.add(obj);
								}
								referenceSelection = new SpecificReferenceSelection(listEntry_«(mut.container as SpecificClosureSelection).objSel.name».get(0).getValue().getValue(), listEntry_«(mut.container as SpecificObjectSelection).objSel.name».get(0).getValue().getKey(), "«mut.container.refType.name»", listEntry_«(mut.container as SpecificClosureSelection).objSel.name».get(0).getKey());
							}
							else {
								return mutations;
							}
						}
					«ELSE»
						referenceSelection = new SpecificReferenceSelection(resourcePackages, resources, null, null);
					«ENDIF»
				«ENDIF»
				«IF rts == true»
				rts = new RandomTypeSelection(resourcePackages, resources, "«mut.object.type.name»", referenceSelection, containerSelection);
				«ELSE»
				RandomTypeSelection rts = new RandomTypeSelection(resourcePackages, resources, "«mut.object.type.name»", referenceSelection, containerSelection);
				«ENDIF»
				«IF ((mut.object.expression === null) && (mut.container.expression === null))»
					EObject object = rts.getObject();
				«ENDIF»
			«ENDIF»
			«IF ((mut.object.expression === null) && (mut.container === null))»
				EObject object = rts.getObject();
			«ENDIF»
			«IF mut.object.refType !== null»
			List<EObject> o = ModelManager.getReferences("«mut.object.refType.name»", object);
			object = o.get(ModelManager.getRandomIndex(o));
			«ENDIF»
			«ENDIF»
			«ENDIF»
			
			«IF (mut.object.expression !== null)»
				«IF (mut.container === null)»
				List<EObject> objects = rts.getObjects();
				//EXPRESSION LIST: «expressionList = new ArrayList<Integer>()»
				//EXPRESSION LEVEL: «nExpression = 0»
				//EXPRESSION LEVEL: «expressionList.add(0)»
				Expression exp«expressionList.get(0)» = new Expression();
				«mut.object.expression.method(0)»
				List<EObject> selectedObjects = evaluate(objects, exp«expressionList.get(0)»);
				«IF mut.object instanceof RandomTypeSelection»
				EObject object = null;
				if (selectedObjects.size() > 0) {
					object = selectedObjects.get(ModelManager.getRandomIndex(selectedObjects));
				}
				«ENDIF»
				«IF mut.object instanceof CompleteTypeSelection»
				objects = selectedObjects;
				«ENDIF»
				«ELSEIF (mut.container.expression === null)»
				List<EObject> objects = rts.getObjects();
				//EXPRESSION LIST: «expressionList = new ArrayList<Integer>()»
				//EXPRESSION LEVEL: «nExpression = 0»
				//EXPRESSION LEVEL: «expressionList.add(0)»
				Expression exp«expressionList.get(0)» = new Expression();
				«mut.object.expression.method(0)»
				List<EObject> selectedObjects = evaluate(objects, exp«expressionList.get(0)»);
   				«IF mut.object instanceof RandomTypeSelection»
				EObject object = null;
				if (selectedObjects.size() > 0) {
					object = selectedObjects.get(ModelManager.getRandomIndex(selectedObjects));
				}
				«ENDIF»
				«IF mut.object instanceof CompleteTypeSelection»
				objects = selectedObjects;
				«ENDIF»
				«ENDIF»
			«ENDIF»
			«IF (mut.object.expression === null)»
				«IF ((mut.container !== null) && (mut.container.expression !== null))»
				List<EObject> objects = rts.getObjects();
				//EXPRESSION LIST: «expressionList = new ArrayList<Integer>()»
				//EXPRESSION LEVEL: «nExpression = 0»
				//EXPRESSION LEVEL: «expressionList.add(0)»
				Expression exp«expressionList.get(0)» = new Expression();
				«mut.container.expression.method(0)»
				List<EObject> selectedObjects = evaluate(objects, exp«expressionList.get(0)»);
   				«IF mut.object instanceof RandomTypeSelection»
   				EObject object = null;
				if (selectedObjects.size() > 0) {
					object = selectedObjects.get(ModelManager.getRandomIndex(selectedObjects));
				}
				«ENDIF»
				«IF mut.object instanceof CompleteTypeSelection»
				objects = selectedObjects;
				«ENDIF»
				«ENDIF»
				«IF ((mut.container !== null) && (mut.container.expression === null))»
				«IF mut.object instanceof CompleteTypeSelection»
				List<EObject> objects = rts.getObjects();
				«ENDIF»
				«ENDIF»
			«ENDIF»
			«IF mut.object instanceof RandomTypeSelection || mut.object instanceof SpecificObjectSelection»
			ObSelectionStrategy objectSelection = null; 
			if (object != null) {
				objectSelection = new SpecificObjectSelection(resourcePackages, resources, object);
			}
			«ENDIF»
			«ELSEIF mut.object instanceof CompleteTypeSelection»
				RandomTypeSelection rts = new RandomTypeSelection(packages, model, "«(mut.object as CompleteTypeSelection).type.name»");
				EObject object = rts.getObject();
				ObSelectionStrategy objectSelection = new SpecificObjectSelection(packages, model, object);
			«ELSEIF mut.object instanceof SpecificObjectSelection»
				ObSelectionStrategy objectSelection = null;
				SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.container as SpecificObjectSelection).objSel.name» = hmObjects.get("«(mut.container as SpecificObjectSelection).objSel.name»");
				if (entry_«(mut.container as SpecificObjectSelection).objSel.name» != null) {
					resourcePackages = entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getValue();
					resources = new ArrayList<Resource>();
					resources.add(entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getKey());
					objectSelection = new SpecificObjectSelection(entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getValue(), entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getKey(), entry_«(mut.container as SpecificObjectSelection).objSel.name».getKey());
				} else {
					return mutations;
				}
			«ELSEIF mut.object instanceof SpecificClosureSelection»
				ObSelectionStrategy objectSelection = null;
				SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.container as SpecificClosureSelection).objSel.name» = hmObjects.get("«(mut.container as SpecificClosureSelection).objSel.name»");
				if (entry_«(mut.container as SpecificClosureSelection).objSel.name» != null) {
					resourcePackages = entry_«(mut.container as SpecificClosureSelection).objSel.name».getValue().getValue();
					resources = new ArrayList<Resource>();
					resources.add(entry_«(mut.container as SpecificClosureSelection).objSel.name».getValue().getKey());
					objectSelection = new SpecificClosureSelection(entry_«(mut.container as SpecificClosureSelection).objSel.name».getValue().getValue(), entry_«(mut.container as SpecificClosureSelection).objSel.name».getValue().getKey(), entry_«(mut.container as SpecificClosureSelection).objSel.name».getKey(), "«(mut.object as SpecificClosureSelection).refType.name»");
				} else {
					return mutations;
				}
			«ELSE»
				List<EObject> objects = ModelManager.getParentObjects(packages, model, "«mut.type.name»");
				EObject container = containers.get(ModelManager.getRandomIndex(objects));
				ObSelectionStrategy objectSelection = new SpecificObjectSelection(packages, model, object);
			«ENDIF»
			«IF mut.object instanceof CompleteTypeSelection»
			for (EObject obj : objects) {
				SelectObjectMutator mut = new SelectObjectMutator(resources, resourcePackages, referenceSelection, containerSelection, obj);
			   	//INC COUNTER: «nMutation++»
	   			//INC COUNTER: «nRegistryMutation++»
			   	if (mut != null) {
			   		mut.setId("m«nMutation»");
					mutations.add(mut);
				}
			}
			«ELSE»
			SelectObjectMutator mut = null;
			if (objectSelection != null) {
				mut = new SelectObjectMutator(objectSelection.getModel(), objectSelection.getMetaModel(), referenceSelection, containerSelection, objectSelection);
			}
			//INC COUNTER: «nMutation++»
   			//INC COUNTER: «nRegistryMutation++»
			if (mut != null) {
				mut.setId("m«nMutation»");
				mutations.add(mut);
			}
			«ENDIF»
			//END SELECT OBJECT «methodName»
	'''
	
	def selectObjectMutatorExhaustive(SelectObjectMutator mut, MutatorEnvironment e, Block b, boolean last) '''
		//SELECT OBJECT «methodName»
		ObSelectionStrategy containerSelection = null;
		SpecificReferenceSelection referenceSelection = null;
		List<EPackage> resourcePackages = packages;
		List<Resource> resources = new ArrayList<Resource>();
		resources.add(model);
		//«var boolean rts = false»
		«IF mut.object instanceof RandomTypeSelection || mut.object instanceof CompleteTypeSelection»
			«IF mut.object.resource === null»
			«IF mut.container === null»
			«IF mut.object instanceof RandomTypeSelection»
			//«rts = true»
			RandomTypeSelection rts = new RandomTypeSelection(packages, model, "«(mut.object as RandomTypeSelection).type.name»");
			«ENDIF»
			«IF mut.object instanceof CompleteTypeSelection»
			//«rts = true»
			RandomTypeSelection rts = new RandomTypeSelection(packages, model, "«(mut.object as CompleteTypeSelection).type.name»");
			«ENDIF»
			«ELSE»
			«IF mut.container instanceof RandomTypeSelection»
				//«rts = true»
				RandomTypeSelection rts = new RandomTypeSelection(packages, model, "«(mut.container as RandomTypeSelection).type.name»");
				EObject container = rts.getObject();
				«IF mut.container.refType !== null»
					//«var refName = mut.container.refType.name»
					«IF mut.container.refRefType !== null»
					container = ModelManager.getReference("«mut.container.refType.name»", container);
					//«refName = mut.container.refRefType.name»
					«IF mut.container.refRefRefType !== null»
					container = ModelManager.getReference("«mut.container.refRefType.name»", container);
					//«refName = mut.container.refRefRefType.name»
					«ENDIF»
					«ENDIF»
					containerSelection = new SpecificObjectSelection(packages, model, container);
					referenceSelection = new SpecificReferenceSelection(packages, model, "«refName»", containerSelection);
				«ELSE»
					containerSelection = new SpecificObjectSelection(packages, model, container);
					referenceSelection = new SpecificReferenceSelection(packages, model, null, null);
				«ENDIF»
			«ELSEIF mut.container instanceof CompleteTypeSelection»
				//«rts = true»
				RandomTypeSelection rts = new RandomTypeSelection(packages, model, "«(mut.container as CompleteTypeSelection).type.name»");
				EObject container = rts.getObject();
				containerSelection = new SpecificObjectSelection(packages, model, container);
				«IF mut.container.refType !== null»
					referenceSelection = new SpecificReferenceSelection(packages, model, "«mut.container.refType.name»", containerSelection);
				«ELSE»
					referenceSelection = new SpecificReferenceSelection(packages, model, null, null);
				«ENDIF»
				«ELSEIF mut.container instanceof SpecificObjectSelection»
					SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.container as SpecificObjectSelection).objSel.name» = hmObjects.get("«(mut.container as SpecificObjectSelection).objSel.name»");
					if (entry_«(mut.container as SpecificObjectSelection).objSel.name» != null) {
						EObject recovered = ModelManager.getObject(model, entry_«(mut.container as SpecificObjectSelection).objSel.name».getKey());
						if (recovered == null) {
							recovered = entry_«(mut.container as SpecificObjectSelection).objSel.name».getKey();
						}
						resourcePackages = packages;
						resources = new ArrayList<Resource>();
						resources.add(model);
						containerSelection = new SpecificObjectSelection(resourcePackages, model, recovered);
					} else {
						List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_«(mut.container as SpecificObjectSelection).objSel.name» = hmList.get("«(mut.container as SpecificObjectSelection).objSel.name»");
						if (listEntry_«(mut.container as SpecificObjectSelection).objSel.name» != null) {
							List<EObject> objs = new ArrayList<EObject>();
							resourcePackages = packages;
							resources = new ArrayList<Resource>();
							resources.add(model);
							for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_«(mut.container as SpecificObjectSelection).objSel.name») {
								EObject obj = ModelManager.getObject(model, ent.getKey());
								if (obj == null) {
									obj = ent.getKey();
								}
								objs.add(obj);
							}
							containerSelection = new SpecificObjectSelection(resourcePackages, model, objs);
						}
						else {
							return numMutantsGenerated;
						}
					}
					«IF mut.container.refType !== null»
						if (entry_«(mut.container as SpecificObjectSelection).objSel.name» != null) {
							Object valueRecovered = null;
							EObject obRecovered = ModelManager.getObject(model, entry_«(mut.container as SpecificObjectSelection).objSel.name».getKey());
							//«var refName = mut.container.refType.name»
							«IF mut.container.refRefType !== null»
							valueRecovered = ModelManager.getReferenced("«mut.container.refType.name»", obRecovered);
							//«refName = mut.container.refRefType.name»
							«IF mut.container.refRefRefType !== null»
							valueRecovered = ModelManager.getReferenced("«mut.container.refRefType.name»", obRecovered);
							//«refName = mut.container.refRefRefType.name»
							«ENDIF»
							«ENDIF»
							if (valueRecovered == null) {
								obRecovered = entry_«(mut.container as SpecificObjectSelection).objSel.name».getKey();
								//«refName = mut.container.refType.name»
								«IF mut.container.refRefType !== null»
								valueRecovered = ModelManager.getReferenced("«mut.container.refType.name»", obRecovered);
								//«refName = mut.container.refRefType.name»
								«IF mut.container.refRefRefType !== null»
								valueRecovered = ModelManager.getReferenced("«mut.container.refRefType.name»", obRecovered);
								//«refName = mut.container.refRefRefType.name»
								«ENDIF»
								«ENDIF»
							}
							EObject recovered = valueRecovered instanceof List<?> ? ((List<EObject>) valueRecovered).get(0) : (EObject) valueRecovered;
							containerSelection = new SpecificObjectSelection(resourcePackages, model, recovered);
							resourcePackages = packages;
							resources = new ArrayList<Resource>();
							resources.add(model);
							referenceSelection = new SpecificReferenceSelection(resourcePackages, model, "«refName»", recovered);
						} else {
							List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_«(mut.container as SpecificObjectSelection).objSel.name» = hmList.get("«(mut.container as SpecificObjectSelection).objSel.name»");
							if (listEntry_«(mut.container as SpecificObjectSelection).objSel.name» != null) {
								List<EObject> objs = new ArrayList<EObject>();
								resourcePackages = packages;
								resources = new ArrayList<Resource>();
								resources.add(model);
								EObject obRecovered = ModelManager.getObject(model, listEntry_«(mut.container as SpecificObjectSelection).objSel.name».get(0).getKey());
								if (obRecovered == null) {
									obRecovered = listEntry_«(mut.container as SpecificObjectSelection).objSel.name».get(0).getKey();
								}
								Object valueRecovered = obRecovered;
								//«refName = mut.container.refType.name»
								«IF mut.container.refRefType !== null»
								valueRecovered = ModelManager.getReferenced("«mut.container.refType.name»", obRecovered);
								//«refName = mut.container.refRefType.name»
								«IF mut.container.refRefRefType !== null»
								valueRecovered = ModelManager.getReferenced("«mut.container.refRefType.name»", obRecovered);
								//«refName = mut.container.refRefRefType.name»
								«ENDIF»
								«ENDIF»
							    EObject recovered = valueRecovered instanceof List<?> ? ((List<EObject>) valueRecovered).get(0) : (EObject) valueRecovered;
								containerSelection = new SpecificObjectSelection(resourcePackages, model, recovered);
								referenceSelection = new SpecificReferenceSelection(resourcePackages, model, "«refName»", recovered);
							}
							else {
								return numMutantsGenerated;
							}
						}
					«ELSE»
						referenceSelection = new SpecificReferenceSelection(packages, model, null, null);
					«ENDIF»
				«ELSEIF mut.container instanceof SpecificClosureSelection»
					SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.container as SpecificClosureSelection).objSel.name» = hmObjects.get("«(mut.container as SpecificClosureSelection).objSel.name»");
					if (entry_«(mut.container as SpecificClosureSelection).objSel.name» != null) {
						EObject recovered = ModelManager.getObject(model, entry_«(mut.container as SpecificClosureSelection).objSel.name».getKey());
						if (recovered == null) {
							recovered = entry_«(mut.container as SpecificClosureSelection).objSel.name».getKey();
						}
						resourcePackages = packages;
						resources = new ArrayList<Resource>();
						resources.add(model);
						containerSelection = new SpecificClosureSelection(resourcePackages, model, recovered, "«(mut.container as SpecificClosureSelection).refType.name»");
					} else {
						List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_«(mut.container as SpecificClosureSelection).objSel.name» = hmList.get("«(mut.container as SpecificClosureSelection).objSel.name»");
						if (listEntry_«(mut.container as SpecificClosureSelection).objSel.name» != null) {
							List<EObject> objs = new ArrayList<EObject>();
							resourcePackages = packages;
							resources = new ArrayList<Resource>();
							resources.add(model);
							for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_«(mut.container as SpecificClosureSelection).objSel.name») {
								EObject obj = ModelManager.getObject(model, entry.getKey());
								if (obj == null) {
									obj = ent.getKey();
								}
								objs.add(obj);
							}
							referenceSelection = new SpecificReferenceSelection(resourcePackages, model, "«mut.container.refType.name»", recovered);
						}
						else {
							return numMutantsGenerated;
						}
					}
					«IF mut.container.refType !== null»
						if (entry_«(mut.container as SpecificClosureSelection).objSel.name» != null) {
							EObject recovered = ModelManager.getObject(model, entry_«(mut.container as SpecificClosureSelection).objSel.name».getKey());
							if (recovered == null) {
								recovered = entry_«(mut.container as SpecificClosureSelection).objSel.name».getKey();
							}
							resourcePackages = packages;
							resources = new ArrayList<Resource>();
							resources.add(model);
							referenceSelection = new SpecificReferenceSelection(resourcePackages, model, "«mut.container.refType.name»", recovered);
						} else {
							return numMutantsGenerated;
						}
					«ELSE»
						referenceSelection = new SpecificReferenceSelection(packages, model, null, null);
					«ENDIF»
				«ENDIF»
				«IF rts == true»
				rts = new RandomTypeSelection(packages, model, "«mut.object.type.name»", referenceSelection, containerSelection);
				«ELSE»
				RandomTypeSelection rts = new RandomTypeSelection(containerSelection.getMetaModel(), containerSelection.getModel(), "«mut.object.type.name»", referenceSelection, containerSelection);
				«ENDIF»
				«IF ((mut.object.expression === null) && (mut.container.expression === null))»
					List<EObject> objects = rts.getObjects();
				«ENDIF»
			«ENDIF»
			«IF ((mut.object.expression === null) && (mut.container === null))»
				List<EObject> objects = rts.getObjects();
			«ENDIF»
			«IF (mut.object.expression !== null)»
				«IF (mut.container === null)»
				List<EObject> objects = rts.getObjects();
				//EXPRESSION LIST: «expressionList = new ArrayList<Integer>()»
				//EXPRESSION LEVEL: «nExpression = 0»
				//EXPRESSION LEVEL: «expressionList.add(0)»
				Expression exp«expressionList.get(0)» = new Expression();
				«mut.object.expression.method(0)»
				objects = evaluate(objects, exp«expressionList.get(0)»);
				«ELSEIF (mut.container.expression === null)»
				List<EObject> objects = rts.getObjects();
				//EXPRESSION LIST: «expressionList = new ArrayList<Integer>()»
				//EXPRESSION LEVEL: «nExpression = 0»
				//EXPRESSION LEVEL: «expressionList.add(0)»
				Expression exp«expressionList.get(0)» = new Expression();
				«mut.object.expression.method(0)»
				objects = evaluate(objects, exp«expressionList.get(0)»);
				«ENDIF»
			«ENDIF»
			«IF (mut.object.expression === null)»
				«IF ((mut.container !== null) && (mut.container.expression !== null))»
				List<EObject> objects = rts.getObjects();
				//EXPRESSION LIST: «expressionList = new ArrayList<Integer>()»
				//EXPRESSION LEVEL: «nExpression = 0»
				//EXPRESSION LEVEL: «expressionList.add(0)»
				Expression exp«expressionList.get(0)» = new Expression();
				«mut.container.expression.method(0)»
				objects = evaluate(objects, exp«expressionList.get(0)»);
				«ENDIF»
				«IF ((mut.container !== null) && (mut.container.expression === null))»
				«IF mut.object instanceof CompleteTypeSelection»
				List<EObject> objects = rts.getObjects();
				«ENDIF»
				«ENDIF»
			«ENDIF»
			for (EObject object : objects) {
				«IF standalone == false»
				String modelsFolder = ModelManager.getModelsFolder(this.getClass());
				«ELSE»
				String modelsFolder = ModelManager.getModelsFolder(«className».class);
				«ENDIF»
				String tempModelsFolder = modelsFolder.replace(modelsFolder.indexOf("/") > 0 ? modelsFolder.substring(modelsFolder.indexOf("/") + 1, modelsFolder.length()) : modelsFolder, "temp");
				modelsFolder = modelsFolder.replace("/", "\\"); 
				tempModelsFolder = tempModelsFolder.replace("/", "\\");
				Resource resource = ModelManager.cloneModel(model, model.getURI().toFileString().replace(modelsFolder + "\\", tempModelsFolder + "\\").replace(".model", ".«methodName»." + numMutantsGenerated +".model"));
				ObSelectionStrategy objectSelection = null;
				«IF mut.object.refType !== null && mut.object.refType.many»
				List<EObject> o = ModelManager.getReferences("«mut.object.refType.name»", object);
				object = o.get(ModelManager.getRandomIndex(o));
				«ELSEIF mut.object.refType !== null && !mut.object.refType.many»
				object = (EObject) ModelManager.getReferenced("«mut.object.refType.name»", object);
				«ENDIF»
				object = ModelManager.getObject(resource, object);
				if (object != null) {
					objectSelection = new SpecificObjectSelection(packages, resource, object);
					SelectObjectMutator mut = new SelectObjectMutator(objectSelection.getModel(), objectSelection.getMetaModel(), referenceSelection, containerSelection, objectSelection);
					Mutator mutator = null;
					if (muts == null) {
						muts = AppliedMutationsFactory.eINSTANCE.createMutations();
					}
		//COUNTER: «nRegistryMutation = nRegistryMutation + 1»
		//COUNTER: «nRegistryMethodCall = nRegistryMethodCall + 1»
		//REGISTRY METHOD NAME:«registryMethodName = "registry" + nRegistryMethodCall.toString()»
		«IF executeMutation == true»
			if (mut != null) {
				Object mutated = mut.mutate();
					if (mutated != null) {
						«IF mut.name !== null»
						SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(mut.getModel(), mut.getMetaModel());
						SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(mut.getObject(), resourceEntry);
						hmObjects.put("«mut.name»", entry);
						«ENDIF»
						AppMutation appMut = «registryMethodName»(mut, hmMutator, seed, mutPaths, packages);
						if (appMut != null) {
							muts.getMuts().add(appMut);
						}
					}
				}
				«ENDIF»
				mutator = mut;
				if (mutator != null) {
				//«nMethodCall = nMethodCall + 1»
				«IF last == false»
				«IF standalone == false»
				mutation«nMethodCall»(packages, resource, hmObjects, hmList, hashmapModelFilenames,
									modelFilename, mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,
									registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, project, monitor, k, serialize, test, classes);
				«ELSE»
				mutation«nMethodCall»(packages, resource, hmObjects, hmList, hashmapModelFilenames,
									modelFilename, mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,
									registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, monitor, k, serialize, test, classes);
				«ENDIF»
				numMutantsGenerated = k[0];
				«ENDIF»
				«IF last == true»
				// MUTANT COMPLETION AND REGISTRY
				Map<String, List<String>> rules = new HashMap<String, List<String>>();
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
				«IF b === null»
				String mutFilename = hashmapModelFilenames.get(modelFilename) + "/" + "Output" + k[0] + ".model";
				«ELSE»
		   		«IF b.from.size == 0»
					String mutFilename = hashmapModelFilenames.get(modelFilename) + "/«b.name»/Output" + k[0] + ".model";
		   		«ELSE»
					String mutFilename = hashmapModelFilenames.get(modelFilename) + "/«b.name»/" + hashmapModelFolders.get(modelFilename) + "/Output" + k[0] + ".model";
		   		«ENDIF»
		   		«ENDIF»
		   		«IF b === null»
		   		«IF standalone == false»
		   			boolean isRepeated = registryMutant(ecoreURI, packages, registeredPackages, localRegisteredPackages, seed, mutator.getModel(), rules, muts, modelFilename, mutFilename, registry, hashsetMutantsBlock, hashmapModelFilenames, k, mutPaths, hashmapMutVersions, project, serialize, test, classes, this.getClass(), true);
		   		«ELSE»
		   			boolean isRepeated = registryMutantStandalone(ecoreURI, packages, registeredPackages, localRegisteredPackages, seed, mutator.getModel(), rules, muts, modelFilename, mutFilename, registry, hashsetMutantsBlock, hashmapModelFilenames, k, mutPaths, hashmapMutVersions, "«getProjectName»", serialize, test, classes, «className».class, true);
		   		«ENDIF»
		   		«ELSE»
		   		«IF standalone == false»
					boolean isRepeated = registryMutantWithBlocks(ecoreURI, packages, registeredPackages, localRegisteredPackages, seed, mutator.getModel(), rules, muts, modelFilename, mutFilename, registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "«b.name»", fromNames, k, mutPaths, hashmapMutVersions, project, serialize, test, classes, this.getClass(), true, false);
				«ELSE»
					boolean isRepeated = registryMutantWithBlocksStandalone(ecoreURI, packages, registeredPackages, localRegisteredPackages, seed, mutator.getModel(), rules, muts, modelFilename, mutFilename, registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "«b.name»", fromNames, k, mutPaths, hashmapMutVersions, "«getProjectName»", serialize, test, classes, «className».class, true, false);
				«ENDIF»
					if (isRepeated == false) {
						numMutantsGenerated++;
						monitor.worked(1);
						k[0] = k[0] + 1;
					}
					muts = null;
				}
		«ENDIF»
			}
			«ELSE»
			//«val List<String> resourceURIs = new ArrayList<String>()»
			//«val List<String> ecoreURIs = new ArrayList<String>()»
			//«val String resourceName = mut.object.resource»
			//«var mutatorenvironment.Resource resource = null»
			«FOR res : program.resources»
				«IF res.name.equals(resourceName)»
					//«resource = res» 
				«ENDIF»
			«ENDFOR»
			«IF resource !== null»
			//«val Source source = resource.path»
			//«val String resourcePath = ModelManager.workspaceAbsolutePath + "/" + getProjectName + "/" + source.path»
			«FOR resourceFile : (new File(resourcePath)).listFiles»
				«IF resourceFile.name.endsWith(".model")»
					//«resourceURIs.add(resourceFile.path)»
				«ENDIF»
				«IF resourceFile.name.endsWith(".ecore")»
					//«ecoreURIs.add(resourceFile.path)»
				«ENDIF»
			«ENDFOR»
			//«val String metamodelPath = resource.metamodel.replace("\\", "/")»
			«IF standalone == false»
			resourcePackages = ModelManager.loadMetaModel("«metamodelPath»", this.getClass());
			«ELSE»
			resourcePackages = ModelManager.loadMetaModel("«metamodelPath»", «className».class);
			«ENDIF»
			resources = new ArrayList<Resource>();
			«FOR resourceURI : resourceURIs»
			«IF standalone == false»
			resources.add(ModelManager.loadModel(resourcePackages, URI.createURI("file:/" + "«resourceURI»").toFileString()));
			«ELSE»
			resources.add(ModelManager.loadModelNoException(resourcePackages, URI.createURI("file:/" + "«resourceURI»").toFileString()));
			«ENDIF»
			«ENDFOR»
			«FOR ecoreURI : ecoreURIs»
			//«val ecoreURI2 = ecoreURI.replace("\\", "/")»
			«IF standalone == false»
			resources.add(ModelManager.loadMetaModelAsResource(resourcePackages, "«ecoreURI2»"));
			«ELSE»
			resources.add(ModelManager.loadMetaModelAsResourceNoException(resourcePackages, "file:/«ecoreURI2»"));
			«ENDIF»
			«ENDFOR»
			«IF mut.container === null»
			«IF mut.object instanceof RandomTypeSelection»
			//«rts = true»
			RandomTypeSelection rts = new RandomTypeSelection(resourcePackages, resources, "«(mut.object as RandomTypeSelection).type.name»");
			«ENDIF»
			«IF mut.object instanceof CompleteTypeSelection»
			//«rts = true»
			RandomTypeSelection rts = new RandomTypeSelection(resourcePackages, resources, "«(mut.object as CompleteTypeSelection).type.name»");
			«ENDIF»
			«ELSE»
				«IF mut.container instanceof RandomTypeSelection»
					//«rts = true»
					RandomTypeSelection rts = new RandomTypeSelection(resourcePackages, resources, "«(mut.container as RandomTypeSelection).type.name»");
					EObject container = rts.getObject();
					containerSelection = new SpecificObjectSelection(resourcePackages, resources, container);
					«IF mut.container.refType !== null»
						referenceSelection = new SpecificReferenceSelection(resourcePackages, resources, "«mut.container.refType.name»", containerSelection);
					«ELSE»
						referenceSelection = new SpecificReferenceSelection(resourcePackages, resources, null, null);
					«ENDIF»
				«ELSEIF mut.container instanceof CompleteTypeSelection»
					«/* THE SAME AS RANDOM */»
					//«rts = true»
					RandomTypeSelection rts = new RandomTypeSelection(resourcePackages, resources, "«(mut.container as CompleteTypeSelection).type.name»");
					EObject container = rts.getObject();
					containerSelection = new SpecificObjectSelection(resourcePackages, resources, container);
					«IF mut.container.refType !== null»
						referenceSelection = new SpecificReferenceSelection(resourcePackages, resources, "«mut.container.refType.name»", containerSelection);
					«ELSE»
						referenceSelection = new SpecificReferenceSelection(resourcePackages, resources, null, null);
					«ENDIF»
				«ELSEIF mut.container instanceof SpecificObjectSelection»
					SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.container as SpecificObjectSelection).objSel.name» = hmObjects.get("«(mut.container as SpecificObjectSelection).objSel.name»");
					if (entry_«(mut.container as SpecificObjectSelection).objSel.name» != null) {
						EObject recovered = ModelManager.getObject(resource, entry_«(mut.container as SpecificObjectSelection).objSel.name».getKey());
						if (recovered == null) {
							recovered = entry_«(mut.container as SpecificObjectSelection).objSel.name».getKey();
						}
						resourcePackages = packages;
						resources = new ArrayList<Resource>();
						resources.add(resource);
						containerSelection = new SpecificObjectSelection(resourcePackages, resource, recovered);
					} else {
						List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_«(mut.container as SpecificObjectSelection).objSel.name» = hmList.get("«(mut.container as SpecificObjectSelection).objSel.name»");
						if (listEntry_«(mut.container as SpecificObjectSelection).objSel.name» != null) {
							List<EObject> objs = new ArrayList<EObject>();
							resourcePackages = packages;
							resources = new ArrayList<Resource>();
							resources.add(resource);
							for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_«(mut.container as SpecificObjectSelection).objSel.name») {
								EObject obj = ModelManager.getObject(resource, ent.getKey());
								if (obj == null) {
									obj = ent.getKey();
								}
								objs.add(obj);
							}
							containerSelection = new SpecificObjectSelection(resourcePackages, resource, objs);
						}
						else {
							return numMutantsGenerated;
						}
					}
					«IF mut.container.refType !== null»
						SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.container as SpecificObjectSelection).objSel.name» = hmObjects.get("«(mut.container as SpecificObjectSelection).objSel.name»");
						if (entry_«(mut.container as SpecificObjectSelection).objSel.name» != null) {
							EObject recovered = ModelManager.getObject(resource, entry_«(mut.container as SpecificObjectSelection).objSel.name».getKey());
							if (recovered == null) {
								recovered = entry_«(mut.container as SpecificObjectSelection).objSel.name».getKey();
							}
							resourcePackages = packages;
							resources = new ArrayList<Resource>();
							resources.add(resource);
							referenceSelection = new SpecificReferenceSelection(resourcePackages, resource, "«mut.container.refType.name»", recovered);
						} else {
							List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_«(mut.container as SpecificObjectSelection).objSel.name» = hmList.get("«(mut.container as SpecificObjectSelection).objSel.name»");
							if (listEntry_«(mut.container as SpecificObjectSelection).objSel.name» != null) {
								EObject recovered = ModelManager.getObject(resource, listEntry_«(mut.container as SpecificObjectSelection).objSel.name».get(0).getKey());
								if (recovered == null) {
									recovered = listEntry_«(mut.container as SpecificObjectSelection).objSel.name».get(0).getKey();
								}
								resourcePackages = packages;
								resources = new ArrayList<Resource>();
								resources.add(resource);
								referenceSelection = new SpecificReferenceSelection(resourcePackages, resource, "«mut.container.refType.name»", recovered);
							}
							else {
								return numMutantsGenerated;
							}
						}
					«ELSE»
						referenceSelection = new SpecificReferenceSelection(resourcePackages, resources, null, null);
					«ENDIF»
				«ELSEIF mut.container instanceof SpecificClosureSelection»
					SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.container as SpecificClosureSelection).objSel.name» = hmObjects.get("«(mut.container as SpecificClosureSelection).objSel.name»");
					if (entry_«(mut.container as SpecificClosureSelection).objSel.name» != null) {
						EObject recovered = ModelManager.getObject(resource, entry_«(mut.container as SpecificClosureSelection).objSel.name».getKey());
						if (recovered == null) {
							recovered = entry_«(mut.container as SpecificClosureSelection).objSel.name».getKey();
						}
						resourcePackages = packages;
						resources = new ArrayList<Resource>();
						resources.add(resource);
						containerSelection = new SpecificClosureSelection(resourcePackages, resource, recovered, "«(mut.container as SpecificClosureSelection).refType.name»");
					} else {
						List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_«(mut.container as SpecificClosureSelection).objSel.name» = hmList.get("«(mut.container as SpecificObjectSelection).objSel.name»");
						if (listEntry_«(mut.container as SpecificClosureSelection).objSel.name» != null) {
							EObject recovered = ModelManager.getObject(resource, listEntry_«(mut.container as SpecificClosureSelection).objSel.name».get(0).getKey());
							if (recovered == null) {
								recovered = listEntry_«(mut.container as SpecificClosureSelection).objSel.name».get(0).getKey();
							}
							List<EObject> objs = new ArrayList<EObject>();
							resourcePackages = packages;
							resources = new ArrayList<Resource>();
							resources.add(resource);
							for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_«(mut.container as SpecificClosureSelection).objSel.name») {
								EObject obj = ModelManager.getObject(resource, ent.getKey());
								if (obj == null) {
									obj = ent.getKey();
								}
								objs.add(obj);
							}
							containerSelection = new SpecificObjectSelection(resourcePackages, resource, objs);
						}
						else {
							return numMutantsGenerated;
						}
					}
					«IF mut.container.refType !== null»
						if (entry_«(mut.container as SpecificClosureSelection).objSel.name» != null) {
							EObject recovered = ModelManager.getObject(resource, entry_«(mut.container as SpecificClosureSelection).objSel.name».getKey());
							if (recovered == null) {
								recovered = entry_«(mut.container as SpecificClosureSelection).objSel.name».getKey();
							}
							resourcePackages = packages;
							resources = new ArrayList<Resource>();
							resources.add(resource);
							referenceSelection = new SpecificReferenceSelection(resourcePackages, resource, "«mut.container.refType.name»", objs);
						} else {
							List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_«(mut.container as SpecificClosureSelection).objSel.name» = hmList.get("«(mut.container as SpecificClosureSelection).objSel.name»");
							if (listEntry_«(mut.container as SpecificClosureSelection).objSel.name» != null) {
								EObject recovered = ModelManager.getObject(resource, listEntry_«(mut.container as SpecificObjectSelection).objSel.name».get(0).getKey());
								if (recovered == null) {
									recovered = listEntry_«(mut.container as SpecificObjectSelection).objSel.name».get(0).getKey();
								}
								resourcePackages = packages;
								resources = new ArrayList<Resource>();
								resources.add(resource);
								referenceSelection = new SpecificReferenceSelection(resourcePackages, resource, "«mut.container.refType.name»", recovered);
							}
							else {
								return numMutantsGenerated;
							}
						}
					«ELSE»
						referenceSelection = new SpecificReferenceSelection(resourcePackages, resources, null, null);
					«ENDIF»
				«ENDIF»
				«IF rts == true»
				rts = new RandomTypeSelection(resourcePackages, resources, "«mut.object.type.name»", referenceSelection, containerSelection);
				«ELSE»
				RandomTypeSelection rts = new RandomTypeSelection(resourcePackages, resources, "«mut.object.type.name»", referenceSelection, containerSelection);
				«ENDIF»
				«IF ((mut.object.expression === null) && (mut.container.expression === null))»
					List<EObject> objects = rts.getObjects();
				«ENDIF»
			«ENDIF»
			«IF mut.object.expression === null»
				List<EObject> objects = rts.getObjects();
			«ELSE»
			«IF (mut.object.expression !== null)»
				«IF (mut.container === null)»
				List<EObject> objects = rts.getObjects();
				//EXPRESSION LIST: «expressionList = new ArrayList<Integer>()»
				//EXPRESSION LEVEL: «nExpression = 0»
				//EXPRESSION LEVEL: «expressionList.add(0)»
				Expression exp«expressionList.get(0)» = new Expression();
				«mut.object.expression.method(0)»
				objects = evaluate(objects, exp«expressionList.get(0)»);
				«ELSEIF (mut.container.expression === null)»
				List<EObject> objects = rts.getObjects();
				//EXPRESSION LIST: «expressionList = new ArrayList<Integer>()»
				//EXPRESSION LEVEL: «nExpression = 0»
				//EXPRESSION LEVEL: «expressionList.add(0)»
				Expression exp«expressionList.get(0)» = new Expression();
				«mut.object.expression.method(0)»
				objects = evaluate(objects, exp«expressionList.get(0)»);
				«ENDIF»
			«ENDIF»
			«IF (mut.object.expression === null)»
				«IF ((mut.container !== null) && (mut.container.expression !== null))»
				List<EObject> objects = rts.getObjects();
				//EXPRESSION LIST: «expressionList = new ArrayList<Integer>()»
				//EXPRESSION LEVEL: «nExpression = 0»
				//EXPRESSION LEVEL: «expressionList.add(0)»
				Expression exp«expressionList.get(0)» = new Expression();
				«mut.container.expression.method(0)»
				objects = evaluate(objects, exp«expressionList.get(0)»);
				«ENDIF»
				«IF ((mut.container !== null) && (mut.container.expression === null))»
				«IF mut.object instanceof CompleteTypeSelection»
				List<EObject> objects = rts.getObjects();
				«ENDIF»
				«ENDIF»
			«ENDIF»
			«ENDIF»
			for (EObject object : objects) {
				«IF standalone == false»
				String modelsFolder = ModelManager.getModelsFolder(this.getClass());
				«ELSE»
				String modelsFolder = ModelManager.getModelsFolder(«className».class);
				«ENDIF»
				String tempModelsFolder = modelsFolder.replace(modelsFolder.indexOf("/") > 0 ? modelsFolder.substring(modelsFolder.indexOf("/") + 1, modelsFolder.length()) : modelsFolder, "temp");
				modelsFolder = modelsFolder.replace("/", "\\"); 
				tempModelsFolder = tempModelsFolder.replace("/", "\\");
				Resource resource = ModelManager.cloneModel(model, model.getURI().toFileString().replace(modelsFolder + "\\", tempModelsFolder + "\\").replace(".model", ".«methodName»." + numMutantsGenerated +".model"));
				ObSelectionStrategy objectSelection = null;
				«IF mut.object.refType !== null && mut.object.refType.many»
				List<EObject> o = ModelManager.getReferences("«mut.object.refType.name»", object);
				object = o.get(ModelManager.getRandomIndex(o));
				«ELSEIF mut.object.refType !== null && !mut.object.refType.many»
				object = (EObject) ModelManager.getReferenced("«mut.object.refType.name»", object);
				«ENDIF»
				object = ModelManager.getObject(resource, object);
				if (object != null) {
					objectSelection = new SpecificObjectSelection(packages, resource, object);
					SelectObjectMutator mut = new SelectObjectMutator(objectSelection.getModel(), objectSelection.getMetaModel(), referenceSelection, containerSelection, objectSelection);
					Mutator mutator = null;
					if (muts == null) {
						muts = AppliedMutationsFactory.eINSTANCE.createMutations();
					}
		//COUNTER: «nRegistryMutation = nRegistryMutation + 1»
		//COUNTER: «nRegistryMethodCall = nRegistryMethodCall + 1»
		//REGISTRY METHOD NAME:«registryMethodName = "registry" + nRegistryMethodCall.toString()»
		«IF executeMutation == true»
			if (mut != null) {
				Object mutated = mut.mutate();
					if (mutated != null) {
					«IF mut.name !== null»
					SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(mut.getModel(), mut.getMetaModel());
					SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(mut.getObject(), resourceEntry);
					hmObjects.put("«mut.name»", entry);
					«ENDIF»
						AppMutation appMut = «registryMethodName»(mut, hmMutator, seed, mutPaths, packages);
						if (appMut != null) {
							muts.getMuts().add(appMut);
						}
					}
				}
				«ENDIF»
				mutator = mut;
				if (mutator != null) {
				//«nMethodCall = nMethodCall + 1»
				«IF last == false»
				«IF standalone == false»
				mutation«nMethodCall»(packages, obSelection.getModel(), hmObjects, hmList, hashmapModelFilenames,
									modelFilename, mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,
									registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, project, monitor, k, serialize, test, classes);
				«ELSE»
				mutation«nMethodCall»(packages, obSelection.getModel(), hmObjects, hmList, hashmapModelFilenames,
									modelFilename, mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,
									registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, monitor, k, serialize, test, classes);
				«ENDIF»
				numMutantsGenerated = k[0];
				«ENDIF»
				«IF last == true»
				// MUTANT COMPLETION AND REGISTRY
				Map<String, List<String>> rules = new HashMap<String, List<String>>();
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
				«IF b === null»
				String mutFilename = hashmapModelFilenames.get(modelFilename) + "/" + "Output" + k[0] + ".model";
				«ELSE»
		   		«IF b.from.size == 0»
					String mutFilename = hashmapModelFilenames.get(modelFilename) + "/«b.name»/Output" + k[0] + ".model";
		   		«ELSE»
					String mutFilename = hashmapModelFilenames.get(modelFilename) + "/«b.name»/" + hashmapModelFolders.get(modelFilename) + "/Output" + k[0] + ".model";
		   		«ENDIF»
		   		«ENDIF»
		   		«IF b === null»
		   		«IF standalone == false»
		   			boolean isRepeated = registryMutant(ecoreURI, packages, registeredPackages, localRegisteredPackages, seed, mutator.getModel(), rules, muts, modelFilename, mutFilename, registry, hashsetMutantsBlock, hashmapModelFilenames, k, mutPaths, hashmapMutVersions, project, serialize, test, classes, this.getClass(), true);
		   		«ELSE»
		   			boolean isRepeated = registryMutantStandalone(ecoreURI, packages, registeredPackages, localRegisteredPackages, seed, mutator.getModel(), rules, muts, modelFilename, mutFilename, registry, hashsetMutantsBlock, hashmapModelFilenames, k, mutPaths, hashmapMutVersions, "«getProjectName»", serialize, test, classes, «className».class, true);
		   		«ENDIF»
		   		«ELSE»
		   		«IF standalone == false»
					boolean isRepeated = registryMutantWithBlocks(ecoreURI, packages, registeredPackages, localRegisteredPackages, seed, mutator.getModel(), rules, muts, modelFilename, mutFilename, registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "«b.name»", fromNames, k, mutPaths, hashmapMutVersions, project, serialize, test, classes, this.getClass(), true, false);
				«ELSE»
					boolean isRepeated = registryMutantWithBlocksStandalone(ecoreURI, packages, registeredPackages, localRegisteredPackages, seed, mutator.getModel(), rules, muts, modelFilename, mutFilename, registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "«b.name»", fromNames, k, mutPaths, hashmapMutVersions, "«getProjectName»", serialize, test, classes, «className».class, true, false);
				«ENDIF»
				«ENDIF»
				«ENDIF»
					if (isRepeated == false) {
						numMutantsGenerated++;
						monitor.worked(1);
						k[0] = k[0] + 1;
					}
					muts = null;
				}
		«ENDIF»
				}
		}
			«ENDIF»
			«ENDIF»
			«ELSEIF mut.object instanceof SpecificObjectSelection || mut.object instanceof SpecificClosureSelection»
				«IF mut.object instanceof SpecificObjectSelection» 
				ObSelectionStrategy objectSelection = null;
				SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.object as SpecificObjectSelection).objSel.name» = hmObjects.get("«(mut.object as SpecificObjectSelection).objSel.name»");
				if (entry_«(mut.object as SpecificObjectSelection).objSel.name» != null) {
					resourcePackages = entry_«(mut.object as SpecificObjectSelection).objSel.name».getValue().getValue();
					resources = new ArrayList<Resource>();
					resources.add(entry_«(mut.object as SpecificObjectSelection).objSel.name».getValue().getKey());
					objectSelection = new SpecificObjectSelection(entry_«(mut.object as SpecificObjectSelection).objSel.name».getValue().getValue(), entry_«(mut.object as SpecificObjectSelection).objSel.name».getValue().getKey(), entry_«(mut.object as SpecificObjectSelection).objSel.name».getKey());
				} else {
					return numMutantsGenerated;
				}
				«ENDIF»
				«IF mut.object instanceof SpecificClosureSelection»
				ObSelectionStrategy obSelection = null;
				SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.object as SpecificClosureSelection).objSel.name» = hmObjects.get("«(mut.object as SpecificClosureSelection).objSel.name»");
				if (entry_«(mut.object as SpecificClosureSelection).objSel.name» != null) {
					resourcePackages = entry_«(mut.object as SpecificClosureSelection).objSel.name».getValue().getValue();
					resources = new ArrayList<Resource>();
					resources.add(entry_«(mut.object as SpecificClosureSelection).objSel.name».getValue().getKey());
					objectSelection = new SpecificClosureSelection(entry_«(mut.object as SpecificClosureSelection).objSel.name».getValue().getValue(), entry_«(mut.object as SpecificClosureSelection).objSel.name».getValue().getKey(), entry_«(mut.object as SpecificClosureSelection).objSel.name».getKey(), "«(mut.object as SpecificClosureSelection).refType.name»");
				} else {
					return numMutantsGenerated;
				}
				«ENDIF»
				if (objectSelection.getObjects() != null) {
					for (EObject object : objectSelection.getObjects()) {
						«IF standalone == false»
						String modelsFolder = ModelManager.getModelsFolder(this.getClass());
						«ELSE»
						String modelsFolder = ModelManager.getModelsFolder(«className».class);
						«ENDIF»
						String tempModelsFolder = modelsFolder.replace(modelsFolder.indexOf("/") > 0 ? modelsFolder.substring(modelsFolder.indexOf("/") + 1, modelsFolder.length()) : modelsFolder, "temp");
						modelsFolder = modelsFolder.replace("/", "\\"); 
						tempModelsFolder = tempModelsFolder.replace("/", "\\");
						Resource resource = ModelManager.cloneModel(model, model.getURI().toFileString().replace(modelsFolder + "\\", tempModelsFolder + "\\").replace(".model", ".«methodName»." + numMutantsGenerated +".model"));
						ObSelectionStrategy obSelection = null;
						«IF mut.object.refType !== null && mut.object.refType.many»
						List<EObject> o = ModelManager.getReferences("«mut.object.refType.name»", object);
						object = o.get(ModelManager.getRandomIndex(o);
						«ELSEIF mut.object.refType !== null && !mut.object.refType.many»
						object = (EObject) ModelManager.getReferenced("«mut.object.refType.name»", object);
						«ENDIF»
						object = ModelManager.getObject(resource, object);
						if (object != null) {
							obSelection = new SpecificObjectSelection(packages, resource, object);
							SelectObjectMutator mut = new SelectObjectMutator(obSelection.getModel(), obSelection.getMetaModel(), referenceSelection, containerSelection, obSelection);
							Mutator mutator = null;
							if (muts == null) {
								muts = AppliedMutationsFactory.eINSTANCE.createMutations();
							}
							//COUNTER: «nRegistryMutation = nRegistryMutation + 1»
							//COUNTER: «nRegistryMethodCall = nRegistryMethodCall + 1»
							//REGISTRY METHOD NAME:«registryMethodName = "registry" + nRegistryMethodCall.toString()»
							«IF executeMutation == true»
							if (mut != null) {
								Object mutated = mut.mutate();
								if (mutated != null) {
									«IF mut.name !== null»
									SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(mut.getModel(), mut.getMetaModel());
									SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(mut.getObject(), resourceEntry);
									hmObjects.put("«mut.name»", entry);
									«ENDIF»
									AppMutation appMut = «registryMethodName»(mut, hmMutator, seed, mutPaths, packages);
									if (appMut != null) {
										muts.getMuts().add(appMut);
									}
								}
							}
							«ENDIF»
							mutator = mut;
							if (mutator != null) {
							//«nMethodCall = nMethodCall + 1»
							«IF last == false»
							«IF standalone == false»
							mutation«nMethodCall»(packages, obSelection.getModel(), hmObjects, hmList, hashmapModelFilenames,
									modelFilename, mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,
									registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, project, monitor, k, serialize, test, classes);
							«ELSE»
							mutation«nMethodCall»(packages, obSelection.getModel(), hmObjects, hmList, hashmapModelFilenames,
									modelFilename, mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,
									registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, monitor, k, serialize, test, classes);
							«ENDIF»
							«ENDIF»
							«IF last == true»
							// MUTANT COMPLETION AND REGISTRY
							Map<String, List<String>> rules = new HashMap<String, List<String>>();
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
							«IF b === null»
							String mutFilename = hashmapModelFilenames.get(modelFilename) + "/" + "Output" + k[0] + ".model";
							«ELSE»
				   			«IF b.from.size == 0»
								String mutFilename = hashmapModelFilenames.get(modelFilename) + "/«b.name»/Output" + k[0] + ".model";
				   			«ELSE»
								String mutFilename = hashmapModelFilenames.get(modelFilename) + "/«b.name»/" + hashmapModelFolders.get(modelFilename) + "/Output" + k[0] + ".model";
				   			«ENDIF»
				   			«ENDIF»
				   			«IF b === null»
				   			«IF standalone == false»
					   			boolean isRepeated = registryMutant(ecoreURI, packages, registeredPackages, localRegisteredPackages, seed, mutator.getModel(), rules, muts, modelFilename, mutFilename, registry, hashsetMutantsBlock, hashmapModelFilenames, k, mutPaths, hashmapMutVersions, project, serialize, test, classes, this.getClass(), true);
					   		«ELSE»
					   			boolean isRepeated = registryMutantStandalone(ecoreURI, packages, registeredPackages, localRegisteredPackages, seed, mutator.getModel(), rules, muts, modelFilename, mutFilename, registry, hashsetMutantsBlock, hashmapModelFilenames, k, mutPaths, hashmapMutVersions, "«getProjectName»", serialize, test, classes, «className».class, true);
					   		«ENDIF»
				   			«ELSE»
				   			«IF standalone == false»
								boolean isRepeated = registryMutantWithBlocks(ecoreURI, packages, registeredPackages, localRegisteredPackages, seed, mutator.getModel(), rules, muts, modelFilename, mutFilename, registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "«b.name»", fromNames, k, mutPaths, hashmapMutVersions, project, serialize, test, classes, this.getClass(), true, false);
							«ELSE»
								boolean isRepeated = registryMutantWithBlocksStandalone(ecoreURI, packages, registeredPackages, localRegisteredPackages, seed, mutator.getModel(), rules, muts, modelFilename, mutFilename, registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "«b.name»", fromNames, k, mutPaths, hashmapMutVersions, "«getProjectName»", serialize, test, classes, «className».class, true, false);
							«ENDIF»
							«ENDIF»
								if (isRepeated == false) {
									numMutantsGenerated++;
									monitor.worked(1);
									k[0] = k[0] + 1;
								}
								muts = null;
							}
				«ENDIF»
						}
					}
				}
			}
			if (objectSelection.getObject() != null) {
				EObject object = objectSelection.getObject();
				«IF standalone == false»
				String modelsFolder = ModelManager.getModelsFolder(this.getClass());
				«ELSE»
				String modelsFolder = ModelManager.getModelsFolder(«className».class);
				«ENDIF»
				String tempModelsFolder = modelsFolder.replace(modelsFolder.indexOf("/") > 0 ? modelsFolder.substring(modelsFolder.indexOf("/") + 1, modelsFolder.length()) : modelsFolder, "temp");
				modelsFolder = modelsFolder.replace("/", "\\"); 
				tempModelsFolder = tempModelsFolder.replace("/", "\\");
				Resource resource = ModelManager.cloneModel(model, model.getURI().toFileString().replace(modelsFolder + "\\", tempModelsFolder + "\\").replace(".model", ".«methodName»." + numMutantsGenerated +".model"));
				ObSelectionStrategy obSelection = null;
				«IF mut.object.refType !== null && mut.object.refType.many»
				List<EObject> o = ModelManager.getReferences("«mut.object.refType.name»", object);
				object = o.get(ModelManager.getRandomIndex(o));
				«ELSEIF mut.object.refType !== null && !mut.object.refType.many»
				object = (EObject) ModelManager.getReferenced("«mut.object.refType.name»", object);
				«ENDIF»
				object = ModelManager.getObject(resource, object);
				if (object != null) {
					obSelection = new SpecificObjectSelection(packages, resource, object);
					SelectObjectMutator mut = new SelectObjectMutator(obSelection.getModel(), obSelection.getMetaModel(), referenceSelection, containerSelection, obSelection);
					Mutator mutator = null;
					if (muts == null) {
						muts = AppliedMutationsFactory.eINSTANCE.createMutations();
					}
					«IF executeMutation == true»
					if (mut != null) {
						Object mutated = mut.mutate();
						if (mutated != null) {
							«IF mut.name !== null»
							SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(mut.getModel(), mut.getMetaModel());
							SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(mut.getObject(), resourceEntry);
							hmObjects.put("«mut.name»", entry);
							«ENDIF»
							AppMutation appMut = «registryMethodName»(mut, hmMutator, seed, mutPaths, packages);
							if (appMut != null) {
								muts.getMuts().add(appMut);
							}
						}
					}
					«ENDIF»
					mutator = mut;
					if (mutator != null) {
					«IF last == false»
					«IF standalone == false»
					mutation«nMethodCall»(packages, obSelection.getModel(), hmObjects, hmList, hashmapModelFilenames,
							modelFilename, mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,
							registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, project, monitor, k, serialize, test, classes);
					«ELSE»
					mutation«nMethodCall»(packages, obSelection.getModel(), hmObjects, hmList, hashmapModelFilenames,
							modelFilename, mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,
							registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, monitor, k, serialize, test, classes);
					«ENDIF»
					numMutantsGenerated = k[0];
					«ENDIF»
					«IF last == true»
					// MUTANT COMPLETION AND REGISTRY
					Map<String, List<String>> rules = new HashMap<String, List<String>>();
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
					«IF b === null»
					String mutFilename = hashmapModelFilenames.get(modelFilename) + "/" + "Output" + k[0] + ".model";
					«ELSE»
					«IF b.from.size == 0»
					String mutFilename = hashmapModelFilenames.get(modelFilename) + "/«b.name»/Output" + k[0] + ".model";
					«ELSE»
					String mutFilename = hashmapModelFilenames.get(modelFilename) + "/«b.name»/" + hashmapModelFolders.get(modelFilename) + "/Output" + k[0] + ".model";
					«ENDIF»
					«ENDIF»
					«IF b === null»
					«IF standalone == false»
			  			boolean isRepeated = registryMutant(ecoreURI, packages, registeredPackages, localRegisteredPackages, seed, mutator.getModel(), rules, muts, modelFilename, mutFilename, registry, hashsetMutantsBlock, hashmapModelFilenames, k, mutPaths, hashmapMutVersions, project, serialize, test, classes, this.getClass(), true);
			  		«ELSE»
			  			boolean isRepeated = registryMutantStandalone(ecoreURI, packages, registeredPackages, localRegisteredPackages, seed, mutator.getModel(), rules, muts, modelFilename, mutFilename, registry, hashsetMutantsBlock, hashmapModelFilenames, k, mutPaths, hashmapMutVersions, "«getProjectName»", serialize, test, classes, «className».class, true);
			  		«ENDIF»
					«ELSE»
					«IF standalone == false»
						boolean isRepeated = registryMutantWithBlocks(ecoreURI, packages, registeredPackages, localRegisteredPackages, seed, mutator.getModel(), rules, muts, modelFilename, mutFilename, registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "«b.name»", fromNames, k, mutPaths, hashmapMutVersions, project, serialize, test, classes, this.getClass(), true, false);
					«ELSE»
						boolean isRepeated = registryMutantWithBlocksStandalone(ecoreURI, packages, registeredPackages, localRegisteredPackages, seed, mutator.getModel(), rules, muts, modelFilename, mutFilename, registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "«b.name»", fromNames, k, mutPaths, hashmapMutVersions, "«getProjectName»", serialize, test, classes, «className».class, true, false);
					«ENDIF»
					«ENDIF»
						if (isRepeated == false) {
							numMutantsGenerated++;
							monitor.worked(1);
							k[0] = k[0] + 1;
						}
						muts = null;
					}
		«ENDIF»
			}
		}
	«ENDIF»
	}
	//END SELECT OBJECT «methodName»
	'''

	def selectSampleMutator(SelectSampleMutator mut) '''
 		//SELECT SAMPLE OBJECT «methodName»
		List<EPackage> resourcePackages = packages;
		List<Resource> resources = new ArrayList<Resource>();
		resources.add(model);
		SpecificReferenceSelection referenceSelection = null;
		«IF mut.object.resource === null»
		«IF mut.object instanceof RandomTypeSelection || mut.object instanceof CompleteTypeSelection»
			«IF mut.object instanceof RandomTypeSelection»
			RandomTypeSelection rts = new RandomTypeSelection(packages, model, "«(mut.object as RandomTypeSelection).type.name»");
			«ENDIF»
			«IF mut.object instanceof CompleteTypeSelection»
			RandomTypeSelection rts = new RandomTypeSelection(packages, model, "«(mut.object as CompleteTypeSelection).type.name»");
			«ENDIF»
			«IF (mut.object.expression === null)»
				EObject object = rts.getObject();
			«ELSE»
				List<EObject> objects = rts.getObjects();
				//EXPRESSION LIST: «expressionList = new ArrayList<Integer>()»
				//EXPRESSION LEVEL: «nExpression = 0»
				//EXPRESSION LEVEL: «expressionList.add(0)»
				Expression exp«expressionList.get(0)» = new Expression();
				«mut.object.expression.method(0)»
				List<EObject> selectedObjects = evaluate(objects, exp«expressionList.get(0)»);
				«IF mut.object instanceof RandomTypeSelection»
				EObject object = null;
				if (selectedObjects.size() > 0) {
					object = selectedObjects.get(ModelManager.getRandomIndex(selectedObjects));
				}
				«ENDIF»
				«IF mut.object instanceof CompleteTypeSelection»
				objects = selectedObjects;
				«ENDIF»
			«ENDIF»
		«IF mut.object instanceof RandomTypeSelection»
		ObSelectionStrategy objectSelection = null; 
		if (object != null) {
			objectSelection = new SpecificObjectSelection(packages, model, object);
		}
		«ENDIF»
		«ELSEIF mut.object instanceof CompleteTypeSelection»
			RandomTypeSelection rts = new RandomTypeSelection(packages, model, "«(mut.object as CompleteTypeSelection).type.name»");
			EObject object = rts.getObject();
			ObSelectionStrategy objectSelection = new SpecificObjectSelection(packages, model, object);
		«ELSEIF mut.object instanceof SpecificObjectSelection»
			ObSelectionStrategy objectSelection = null;
			SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.object as SpecificObjectSelection).objSel.name» = hmObjects.get("«(mut.object as SpecificObjectSelection).objSel.name»");
			if (entry_«(mut.object as SpecificObjectSelection).objSel.name» != null) {
				resourcePackages = entry_«(mut.object as SpecificObjectSelection).objSel.name».getValue().getValue();
				resources = new ArrayList<Resource>();
				resources.add(entry_«(mut.object as SpecificObjectSelection).objSel.name».getValue().getKey());
				objectSelection = new SpecificObjectSelection(entry_«(mut.object as SpecificObjectSelection).objSel.name».getValue().getValue(), entry_«(mut.object as SpecificObjectSelection).objSel.name».getValue().getKey(), entry_«(mut.object as SpecificObjectSelection).objSel.name».getKey());
			} else {
				List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_«(mut.object as SpecificObjectSelection).objSel.name» = hmList.get("«(mut.object as SpecificObjectSelection).objSel.name»");
				if (listEntry_«(mut.object as SpecificObjectSelection).objSel.name» != null) {
					List<EObject> objs = new ArrayList<EObject>();
					resourcePackages = listEntry_«(mut.object as SpecificObjectSelection).objSel.name».get(0).getValue().getValue();
					resources = new ArrayList<Resource>();
					resources.add(listEntry_«(mut.object as SpecificObjectSelection).objSel.name».get(0).getValue().getKey());
					for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_«(mut.object as SpecificObjectSelection).objSel.name») {
						EObject obj = ent.getKey();
						objs.add(obj);
					}
					objectSelection = new SpecificObjectSelection(listEntry_«(mut.object as SpecificObjectSelection).objSel.name».get(0).getValue().getValue(), listEntry_«(mut.object as SpecificObjectSelection).objSel.name».get(0).getValue().getKey(), objs);
				}
				else {
					return mutations;
				}
			}
		«ELSEIF mut.object instanceof SpecificClosureSelection»
			ObSelectionStrategy objectSelection = null;
			SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.object as SpecificClosureSelection).objSel.name» = hmObjects.get("«(mut.object as SpecificClosureSelection).objSel.name»");
			if (entry_«(mut.object as SpecificClosureSelection).objSel.name» != null) {
				resourcePackages = entry_«(mut.object as SpecificClosureSelection).objSel.name».getValue().getValue();
				resources = new ArrayList<Resource>();
				resources.add(entry_«(mut.object as SpecificClosureSelection).objSel.name».getValue().getKey());
				objectSelection = new SpecificClosureSelection(entry_«(mut.object as SpecificClosureSelection).objSel.name».getValue().getValue(), entry_«(mut.object as SpecificClosureSelection).objSel.name».getValue().getKey(), entry_«(mut.object as SpecificClosureSelection).objSel.name».getKey(), "«(mut.object as SpecificClosureSelection).refType.name»");
			} else {
				return mutations;
			}
		«ELSE»
			List<EObject> objects = ModelManager.getParentObjects(packages, model, "«mut.type.name»");
			EObject container = containers.get(ModelManager.getRandomIndex(objects));
			ObSelectionStrategy objectSelection = new SpecificObjectSelection(packages, model, object);
		«ENDIF»
		if (objectSelection != null) {
		«IF mut.object.refType !== null»
			referenceSelection = new SpecificReferenceSelection(objectSelection.getMetaModel(), objectSelection.getModel(), "«mut.object.refType.name»", objectSelection.getObject());
		«ELSE»
			referenceSelection = new SpecificReferenceSelection(objectSelection.getMetaModel(), model, null, null);
		«ENDIF»
		}
		List<String> features = new ArrayList<String>();
		«IF mut.clause == SampleClause.EQUALS»
		boolean equals = true;
		«ENDIF»
		«IF mut.clause == SampleClause.DISTINCT»
		boolean equals = false;
		«ENDIF»
		«IF mut.features.size > 0»
		«FOR EStructuralFeature feature : mut.features»
		if (!features.contains("«feature.name»")) {
			features.add("«feature.name»");	
		}
		«ENDFOR»
		«ELSE»
		equals = false;
		«ENDIF»
		«IF mut.object.expression !== null»
		«IF mut.object.expression.first instanceof ReferenceEvaluation»
		//«var ReferenceEvaluation ev = mut.object.expression.first as ReferenceEvaluation»
		if (!features.contains("«ev.name.name»")) {
			features.add("«ev.name.name»");
		}
		«ENDIF»
		«IF mut.object.expression.first instanceof AttributeEvaluation»
		//«var AttributeEvaluation ev = mut.object.expression.first as AttributeEvaluation»
		if (!features.contains("«ev.name.name»")) {
			features.add("«ev.name.name»");
		}
		«ENDIF»
		«IF mut.object.expression.second !== null && mut.object.expression.second.size > 0»
		«FOR ev : mut.object.expression.second»
		«IF ev instanceof ReferenceEvaluation»
		if (!features.contains("«ev.name.name»")) {
			features.add("«ev.name.name»");
		}
		«ENDIF»
		«IF ev instanceof AttributeEvaluation»
		if (!features.contains("«ev.name.name»")) {
			features.add("«ev.name.name»");
		}
		«ENDIF»
		«ENDFOR»
		«ENDIF»
		«ENDIF»
		«ELSE»
			//«val List<String> resourceURIs = new ArrayList<String>()»
			//«val List<String> ecoreURIs = new ArrayList<String>()»
			//«val String resourceName = mut.object.resource»
			//«var mutatorenvironment.Resource resource = null»
			«FOR res : program.resources»
				«IF res.name.equals(resourceName)»
					//«resource = res» 
				«ENDIF»
			«ENDFOR»
			«IF resource !== null»
			//«val Source source = resource.path»
			//«val String resourcePath = ModelManager.workspaceAbsolutePath + "/" + getProjectName + "/" + source.path»
			«FOR resourceFile : (new File(resourcePath)).listFiles»
				«IF resourceFile.name.endsWith(".model")»
					//«resourceURIs.add(resourceFile.path)»
				«ENDIF»
				«IF resourceFile.name.endsWith(".ecore")»
					//«ecoreURIs.add(resourceFile.path)»
				«ENDIF»
			«ENDFOR»
			//«val String metamodelPath = resource.metamodel.replace("\\", "/")»
			«IF standalone == false»
			List<EPackage> resourcePackages = ModelManager.loadMetaModel("«metamodelPath»", this.getClass());
			«ELSE»
			List<EPackage> resourcePackages = ModelManager.loadMetaModel("«metamodelPath»", «className».class);
			«ENDIF»
			List<Resource> resources = new ArrayList<Resource>();
			«FOR resourceURI : resourceURIs»
			«IF standalone == false»
			resources.add(ModelManager.loadModel(resourcePackages, URI.createURI("file:/" + "«resourceURI»").toFileString()));
			«ELSE»
			resources.add(ModelManager.loadModelNoException(resourcePackages, URI.createURI("file:/" + "«resourceURI»").toFileString()));
			«ENDIF»
			«ENDFOR»
			«FOR ecoreURI : ecoreURIs»
			//«val ecoreURI2 = ecoreURI.replace("\\", "/")»
			«IF standalone == false»
			resources.add(ModelManager.loadMetaModelAsResource(resourcePackages, "«ecoreURI2»"));
			«ELSE»
			resources.add(ModelManager.loadMetaModelAsResourceNoException(resourcePackages, "file:/«ecoreURI2»"));
			«ENDIF»
			«ENDFOR»
		«IF mut.object instanceof RandomTypeSelection || mut.object instanceof CompleteTypeSelection»
			«IF mut.object instanceof RandomTypeSelection»
			RandomTypeSelection rts = new RandomTypeSelection(resourcePackages, resources, "«(mut.object as RandomTypeSelection).type.name»");
			«ENDIF»
			«IF mut.object instanceof CompleteTypeSelection»
			RandomTypeSelection rts = new RandomTypeSelection(resourcePackages, resources, "«(mut.object as CompleteTypeSelection).type.name»");
			«ENDIF»
			«IF (mut.object.expression === null)»
				EObject object = rts.getObject();
			«ELSE»
				List<EObject> objects = rts.getObjects();
				//EXPRESSION LIST: «expressionList = new ArrayList<Integer>()»
				//EXPRESSION LEVEL: «nExpression = 0»
				//EXPRESSION LEVEL: «expressionList.add(0)»
				Expression exp«expressionList.get(0)» = new Expression();
				«mut.object.expression.method(0)»
				List<EObject> selectedObjects = evaluate(objects, exp«expressionList.get(0)»);
				«IF mut.object instanceof RandomTypeSelection»
				EObject object = null;
				if (selectedObjects.size() > 0) {
					object = selectedObjects.get(ModelManager.getRandomIndex(selectedObjects));
				}
				«ENDIF»
				«IF mut.object instanceof CompleteTypeSelection»
				objects = selectedObjects;
				«ENDIF»
			«ENDIF»
		«IF mut.object instanceof RandomTypeSelection»
		ObSelectionStrategy objectSelection = null; 
		if (object != null) {
			objectSelection = new SpecificObjectSelection(resourcePackages, resources, object);
		}
		«ENDIF»
		«ELSEIF mut.object instanceof CompleteTypeSelection»
			RandomTypeSelection rts = new RandomTypeSelection(resourcePackages, resources, "«(mut.object as CompleteTypeSelection).type.name»");
			EObject object = rts.getObject();
			ObSelectionStrategy objectSelection = new SpecificObjectSelection(resourcePackages, resources, object);
		«ELSEIF mut.object instanceof SpecificObjectSelection»
			ObSelectionStrategy objectSelection = null;
			SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.object as SpecificObjectSelection).objSel.name» = hmObjects.get("«(mut.object as SpecificObjectSelection).objSel.name»");
			if (entry_«(mut.object as SpecificObjectSelection).objSel.name» != null) {
				resourcePackages = entry_«(mut.object as SpecificObjectSelection).objSel.name».getValue().getValue();
				resources = new ArrayList<Resource>();
				resources.add(entry_«(mut.object as SpecificObjectSelection).objSel.name».getValue().getKey());
				objectSelection = new SpecificObjectSelection(entry_«(mut.object as SpecificObjectSelection).objSel.name».getValue().getValue(), entry_«(mut.object as SpecificObjectSelection).objSel.name».getValue().getKey(), entry_«(mut.object as SpecificObjectSelection).objSel.name».getKey());
			} else {
				List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_«(mut.object as SpecificObjectSelection).objSel.name» = hmList.get("«(mut.object as SpecificObjectSelection).objSel.name»");
				if (listEntry_«(mut.object as SpecificObjectSelection).objSel.name» != null) {
					List<EObject> objs = new ArrayList<EObject>();
					resourcePackages = listEntry_«(mut.object as SpecificObjectSelection).objSel.name».get(0).getValue().getValue();
					resources = new ArrayList<Resource>();
					resources.add(listEntry_«(mut.object as SpecificObjectSelection).objSel.name».get(0).getValue().getKey());
					for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_«(mut.object as SpecificObjectSelection).objSel.name») {
						EObject obj = ent.getKey();
						objs.add(obj);
					}
					objectSelection = new SpecificObjectSelection(listEntry_«(mut.object as SpecificObjectSelection).objSel.name».get(0).getValue().getValue(), listEntry_«(mut.object as SpecificObjectSelection).objSel.name».get(0).getValue().getKey(), objs);
				}
				else {
					return mutations;
				}
			}
		«ELSEIF mut.object instanceof SpecificClosureSelection»
			ObSelectionStrategy objectSelection = null;
			SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.object as SpecificClosureSelection).objSel.name» = hmObjects.get("«(mut.object as SpecificClosureSelection).objSel.name»");
			if (entry_«(mut.object as SpecificClosureSelection).objSel.name» != null) {
				resourcePackages = entry_«(mut.object as SpecificObjectSelection).objSel.name».getValue().getValue();
				resources = new ArrayList<Resource>();
				resources.add(entry_«(mut.object as SpecificObjectSelection).objSel.name».getValue().getKey());
				objectSelection = new SpecificClosureSelection(entry_«(mut.object as SpecificClosureSelection).objSel.name».getValue().getValue(), entry_«(mut.object as SpecificClosureSelection).objSel.name».getValue().getKey(), entry_«(mut.object as SpecificClosureSelection).objSel.name».getKey(), "«(mut.object as SpecificClosureSelection).refType.name»");
			} else {
				return mutations;
			}
		«ELSE»
			List<EObject> objects = ModelManager.getParentObjects(packages, model, "«mut.type.name»");
			EObject container = containers.get(ModelManager.getRandomIndex(objects));
			ObSelectionStrategy objectSelection = new SpecificObjectSelection(packages, model, object);
		«ENDIF»
		if (objectSelection != null) {
		«IF mut.object.refType !== null»
			referenceSelection = new SpecificReferenceSelection(objectSelection.getMetaModel(), objectSelection.getModel(), "«mut.object.refType.name»", objectSelection.getObject());
		«ELSE»
			referenceSelection = new SpecificReferenceSelection(objectSelection.getMetaModel(), model, null, null);
		«ENDIF»
		}
		List<String> features = new ArrayList<String>();
		«IF mut.clause == SampleClause.EQUALS»
		boolean equals = true;
		«ENDIF»
		«IF mut.clause == SampleClause.DISTINCT»
		boolean equals = false;
		«ENDIF»
		«IF mut.features.size > 0»
		«FOR EStructuralFeature feature : mut.features»
		if (!features.contains("«feature.name»")) {
			features.add("«feature.name»");	
		}
		«ENDFOR»
		«ELSE»
		equals = false;
		«ENDIF»
		«IF mut.object.expression !== null»
		«IF mut.object.expression.first instanceof ReferenceEvaluation»
		//«var ReferenceEvaluation ev = mut.object.expression.first as ReferenceEvaluation»
		if (!features.contains("«ev.name.name»")) {
			features.add("«ev.name.name»");
		}
		«ENDIF»
		«IF mut.object.expression.first instanceof AttributeEvaluation»
		//«var AttributeEvaluation ev = mut.object.expression.first as AttributeEvaluation»
		if (!features.contains("«ev.name.name»")) {
			features.add("«ev.name.name»");
		}
		«ENDIF»
		«IF mut.object.expression.second !== null && mut.object.expression.second.size > 0»
		«FOR ev : mut.object.expression.second»
		«IF ev instanceof ReferenceEvaluation»
		if (!features.contains("«ev.name.name»")) {
			features.add("«ev.name.name»");
		}
		«ENDIF»
		«IF ev instanceof AttributeEvaluation»
		if (!features.contains("«ev.name.name»")) {
			features.add("«ev.name.name»");
		}
		«ENDIF»
		«ENDFOR»
		«ENDIF»
		«ENDIF»
		«ENDIF»
		«ENDIF»
		SelectSampleMutator mut = null;
		if (objectSelection != null) {
			mut = new SelectSampleMutator(objectSelection.getModel(), objectSelection.getMetaModel(), referenceSelection, objectSelection, equals, features);
		}
		//INC COUNTER: «nMutation++»
		//INC COUNTER: «nRegistryMutation++»
		if (mut != null) {
			mut.setId("m«nMutation»");
			mutations.add(mut);
		}
		//END SELECT SAMPLE OBJECT «methodName»
	'''

	def selectSampleMutatorExhaustive(SelectSampleMutator mut) '''
 		//SELECT SAMPLE OBJECT «methodName»
		//END SELECT SAMPLE OBJECT «methodName»
	'''
	
	def cloneObjectMutator(CloneObjectMutator mut) '''
			//CLONE OBJECT «methodName»
			«IF mut.object instanceof RandomTypeSelection»
				RandomTypeSelection rts = new RandomTypeSelection(packages, model, "«(mut.object as RandomTypeSelection).type.name»");
				«IF mut.object.expression === null»
					EObject object = rts.getObject();
				«ELSE»
					List<EObject> objects = rts.getObjects();
					//EXPRESSION LIST: «expressionList = new ArrayList<Integer>()»
					//EXPRESSION LEVEL: «nExpression = 0»
					//EXPRESSION LEVEL: «expressionList.add(0)»
					Expression exp«expressionList.get(0)» = new Expression();
	   				«mut.object.expression.method(0)»
					List<EObject> selectedObjects = evaluate(objects, exp«expressionList.get(0)»);
					EObject object = null;
					if (selectedObjects.size() > 0) {
						object = selectedObjects.get(ModelManager.getRandomIndex(selectedObjects));
					}
				«ENDIF»
				ObSelectionStrategy objectSelection = null; 
				if (object != null) {
					objectSelection = new SpecificObjectSelection(packages, model, object);
				}
			«ELSEIF mut.object instanceof CompleteTypeSelection»
				RandomTypeSelection rts = new RandomTypeSelection(packages, model, "«(mut.object as CompleteTypeSelection).type.name»");
				EObject object = rts.getObject();
				ObSelectionStrategy objectSelection = new SpecificObjectSelection(packages, model, object);
			«ELSEIF mut.object instanceof SpecificObjectSelection»
				ObSelectionStrategy objectSelection = null;
				SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.object as SpecificObjectSelection).objSel.name» = hmObjects.get("«(mut.object as SpecificObjectSelection).objSel.name»");
				if (entry_«(mut.object as SpecificObjectSelection).objSel.name» != null) {
					objectSelection = new SpecificObjectSelection(entry_«(mut.object as SpecificObjectSelection).objSel.name».getValue().getValue(), entry_«(mut.object as SpecificObjectSelection).objSel.name».getValue().getKey(), entry_«(mut.object as SpecificObjectSelection).objSel.name».getKey());
				} else {
					List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_«(mut.object as SpecificObjectSelection).objSel.name» = hmList.get("«(mut.object as SpecificObjectSelection).objSel.name»");
					if (listEntry_«(mut.object as SpecificObjectSelection).objSel.name» != null) {
						List<EObject> objs = new ArrayList<EObject>();
						for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_«(mut.object as SpecificObjectSelection).objSel.name») {
							EObject obj = ent.getKey();
							objs.add(obj);
						}
						objectSelection = new SpecificObjectSelection(listEntry_«(mut.object as SpecificObjectSelection).objSel.name».get(0).getValue().getValue(), listEntry_«(mut.object as SpecificObjectSelection).objSel.name».get(0).getValue().getKey(), objs);
					}
					else {
						return mutations;
					}
				}
			«ELSEIF mut.object instanceof SpecificClosureSelection»
				ObSelectionStrategy objectSelection = null;
				SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.object as SpecificClosureSelection).objSel.name» = hmObjects.get("«(mut.object as SpecificClosureSelection).objSel.name»");
				if (entry_«(mut.object as SpecificClosureSelection).objSel.name» != null) {
					objectSelection = new SpecificClosureSelection(entry_«(mut.object as SpecificClosureSelection).objSel.name».getValue().getValue(), entry_«(mut.object as SpecificClosureSelection).objSel.name».getValue().getKey(), entry_«(mut.object as SpecificClosureSelection).objSel.name».getKey(), "«(mut.object as SpecificClosureSelection).refType.name»");
				} else {
					return mutations;
				}
			«ENDIF»
			EObject container = null;
			ObSelectionStrategy containerSelection = null;
			if (objectSelection != null) {
			«IF mut.container === null»
				container = ModelManager.getContainer(objectSelection.getModel(), objectSelection.getObject());
				containerSelection = new SpecificObjectSelection(objectSelection.getMetaModel(), objectSelection.getModel(), container);
			«ELSE»
				«IF mut.container instanceof RandomTypeSelection»
					RandomTypeSelection rts = new RandomTypeSelection(objectSelection.getMetaModel(), objectSelection.getModel(), "«(mut.container as RandomTypeSelection).type.name»");
					container = rts.getObject();
					containerSelection = new SpecificObjectSelection(objectSelection.getMetaModel(), objectSelection.getModel(), container);
				«ENDIF»
				«IF mut.container instanceof CompleteTypeSelection»
					«/* THE SAME AS RANDOM */»
					RandomTypeSelection rts = new RandomTypeSelection(objectSelection.getMetaModel(), objectSelection.getModel(), "«(mut.container as CompleteTypeSelection).type.name»");
					container = rts.getObject();
					containerSelection = new SpecificObjectSelection(objectSelection.getMetaModel(), objectSelection.getModel(), container);
				«ENDIF»
				«IF mut.container instanceof SpecificObjectSelection»
					SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.container as SpecificObjectSelection).objSel.name» = hmObjects.get("«(mut.container as SpecificObjectSelection).objSel.name»");
					if (entry_«(mut.container as SpecificObjectSelection).objSel.name» != null) {
						containerSelection = new SpecificObjectSelection(entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getValue(), entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getKey(), entry_«(mut.container as SpecificObjectSelection).objSel.name».getKey());
					} else {
						return mutations;
					}
				«ENDIF»
				«IF mut.container instanceof SpecificClosureSelection»
					SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.container as SpecificClosureSelection).objSel.name» = hmObjects.get("«(mut.container as SpecificClosureSelection).objSel.name»");
					if (entry_«(mut.container as SpecificClosureSelection).objSel.name» != null) {
						containerSelection = new SpecificClosureSelection(entry_«(mut.container as SpecificClosureSelection).objSel.name».getValue().getValue(), entry_«(mut.container as SpecificClosureSelection).objSel.name».getValue().getKey(), entry_«(mut.container as SpecificClosureSelection).objSel.name».getKey(), "«(mut.container as SpecificClosureSelection).refType.name»");
					} else {
						return mutations;
					}
				«ENDIF»
			«ENDIF»
			}
			«IF mut.container !== null && mut.container.refType !== null»
				SpecificReferenceSelection referenceSelection = null;
				«IF mut.container instanceof SpecificObjectSelection»
				SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.container as SpecificObjectSelection).objSel.name» = hmObjects.get("«(mut.container as SpecificObjectSelection).objSel.name»");
				if (entry_«(mut.container as SpecificObjectSelection).objSel.name» != null) {
					referenceSelection = new SpecificReferenceSelection(entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getValue(), entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getKey(), "«mut.container.refType.name»", entry_«(mut.container as SpecificObjectSelection).objSel.name».getKey());
				} else {
					return mutations;
				}
				«ELSEIF mut.container instanceof SpecificClosureSelection»
				SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.container as SpecificClosureSelection).objSel.name» = hmObjects.get("«(mut.container as SpecificClosureSelection).objSel.name»");
				if (entry_«(mut.container as SpecificClosureSelection).objSel.name» != null) {
					referenceSelection = new SpecificReferenceSelection(entry_«(mut.container as SpecificClosureSelection).objSel.name».getValue().getValue(), entry_«(mut.container as SpecificClosureSelection).objSel.name».getValue().getKey(), "«mut.container.refType.name»", entry_«(mut.container as SpecificClosureSelection).objSel.name».getKey());
				} else {
					return mutations;
				}
				«ELSE»
				SpecificReferenceSelection referenceSelection = null;
				if (containerSelection != null) {
					referenceSelection = new SpecificReferenceSelection(containerSelection.getMetaModel(), containerSelection.getModel(), "«mut.container.refType.name»", containerSelection);
				}
				«ENDIF»
			«ELSE»
				SpecificReferenceSelection referenceSelection = null;
				if (containerSelection != null) {
					referenceSelection = new SpecificReferenceSelection(containerSelection.getMetaModel(), containerSelection.getModel(), null, null);
				}
			«ENDIF»
			Map<String, AttributeConfigurationStrategy> atts = new HashMap<String, AttributeConfigurationStrategy>();
			//«var counter = 0»
			«FOR c : mut.attributes»
				//«counter ++»
				«c.method(false, false, counter, false, "objectSelection")»
			«ENDFOR»
			Map<String, ObSelectionStrategy> refs = new HashMap<String, ObSelectionStrategy>();
			«FOR c : mut.references»
				«c.method(false)»
			«ENDFOR»
			CloneObjectMutator mut = null;
			if (objectSelection != null && objectSelection.getObject() != null) {
			«IF mut.object instanceof SpecificObjectSelection»
			«IF (mut.object as SpecificObjectSelection).objSel instanceof SelectObjectMutator»
				mut = new CloneObjectMutator(objectSelection.getModel(), objectSelection.getMetaModel(), objectSelection.getObject(), «mut.contents», referenceSelection, containerSelection, atts, refs, "«((mut.object as SpecificObjectSelection).objSel as SelectObjectMutator).object.type.name»");
			«ENDIF»
			«IF (mut.object as SpecificObjectSelection).objSel instanceof CreateObjectMutator»
				mut = new CloneObjectMutator(objectSelection.getModel(), objectSelection.getMetaModel(), objectSelection.getObject(), «mut.contents», referenceSelection, containerSelection, atts, refs, "«((mut.object as SpecificObjectSelection).objSel as CreateObjectMutator).type.name»");
			«ENDIF»
			«IF (mut.object as SpecificObjectSelection).objSel instanceof CloneObjectMutator»
				mut = new CloneObjectMutator(objectSelection.getModel(), objectSelection.getMetaModel(), objectSelection.getObject(), «mut.contents», referenceSelection, containerSelection, atts, refs, "«((mut.object as SpecificObjectSelection).objSel as CloneObjectMutator).object.type.name»");
			«ENDIF»
			«ENDIF»
			«IF mut.object instanceof RandomTypeSelection»
				mut = new CloneObjectMutator(objectSelection.getModel(), objectSelection.getMetaModel(), objectSelection.getObject(), «mut.contents», referenceSelection, containerSelection, atts, refs, "«(mut.object as RandomTypeSelection).type.name»");
			«ENDIF»
			}
			//INC COUNTER: «nMutation++»
  			//INC COUNTER: «nRegistryMutation++»
			if (mut != null) {
				mut.setId("m«nMutation»");
				mutations.add(mut);
			}
			//END CLONE OBJECT «methodName»
	'''

	def cloneObjectMutatorExhaustive(CloneObjectMutator mut, MutatorEnvironment e, Block b, boolean last) '''
			//CLONE OBJECT «methodName»
			«IF mut.object instanceof RandomTypeSelection»
				RandomTypeSelection rts = new RandomTypeSelection(packages, model, "«(mut.object as RandomTypeSelection).type.name»");
				«IF mut.object.expression === null»
					List<EObject> objects = rts.getObjects();
				«ELSE»
					List<EObject> objects = rts.getObjects();
					//EXPRESSION LIST: «expressionList = new ArrayList<Integer>()»
					//EXPRESSION LEVEL: «nExpression = 0»
					//EXPRESSION LEVEL: «expressionList.add(0)»
					Expression exp«expressionList.get(0)» = new Expression();
	   				«mut.object.expression.method(0)»
					objects = evaluate(objects, exp«expressionList.get(0)»);
				«ENDIF»
			«ELSEIF mut.object instanceof CompleteTypeSelection»
				RandomTypeSelection cts = new RandomTypeSelection(packages, model, "«(mut.object as CompleteTypeSelection).type.name»");
				List<EObject> objects = cts.getObjects();
				«IF mut.object.expression === null»
					List<EObject> objects = cts.getObjects();
				«ELSE»
				//EXPRESSION LIST: «expressionList = new ArrayList<Integer>()»
				//EXPRESSION LEVEL: «nExpression = 0»
				//EXPRESSION LEVEL: «expressionList.add(0)»
				Expression exp«expressionList.get(0)» = new Expression();
				«mut.object.expression.method(0)»
				objects = evaluate(objects, exp«expressionList.get(0)»);
			«ENDIF»
			«ELSEIF mut.object instanceof SpecificObjectSelection»
			    List<EObject> objects = new ArrayList<EObject>();
				ObSelectionStrategy objectSelection = null;
				if (hmObjects.get("«(mut.object as SpecificObjectSelection).objSel.name»") != null) {
					SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.object as SpecificObjectSelection).objSel.name» = hmObjects.get("«(mut.object as SpecificObjectSelection).objSel.name»");
					EObject recovered = ModelManager.getObject(model, entry_«(mut.object as SpecificObjectSelection).objSel.name».getKey());
					if (recovered == null) {
						recovered = entry_«(mut.object as SpecificObjectSelection).objSel.name».getKey();
					}
					objectSelection = new SpecificObjectSelection(packages, model, recovered);
				} else {
					if (hmList.get("«(mut.object as SpecificObjectSelection).objSel.name»") != null) {
						List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_«(mut.object as SpecificObjectSelection).objSel.name» = hmList.get("«(mut.object as SpecificObjectSelection).objSel.name»");
						List<EObject> objs = new ArrayList<EObject>();
						for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_«(mut.object as SpecificObjectSelection).objSel.name») {
							EObject obj = ModelManager.getObject(model, ent.getKey());
							objs.add(obj);
						}
						objectSelection = new SpecificObjectSelection(packages, model, objs);
					}
					else {
						return numMutantsGenerated;
					}
				}
				if (objectSelection != null) {
					objects.add(objectSelection.getObject());
				}
				«IF mut.object.refType !== null»
				List<EObject> o = ModelManager.getReferences("«mut.object.refType.name»", objectSelections.get(0).getObject());
				EObject object = o.get(ModelManager.getRandomIndex(o));
				objectSelection = new SpecificObjectSelection(model, packages, object);
				objects.add(object);
				«ENDIF»
			«ELSEIF mut.object instanceof SpecificClosureSelection»
				«IF ((mut.object as SpecificClosureSelection).objSel !== null && (mut.object as SpecificClosureSelection).refType !== null)»
				List<EObject> objects = new ArrayList<EObject>();
				ObSelectionStrategy objectSelection = null;
				if (hmObjects.get("«(mut.object as SpecificClosureSelection).objSel.name»") != null) {
					SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.object as SpecificClosureSelection).objSel.name» = hmObjects.get("«(mut.object as SpecificClosureSelection).objSel.name»");
					EObject recovered = ModelManager.getObject(model, entry_«(mut.object as SpecificClosureSelection).objSel.name».getKey());
					if (recovered == null) {
						recovered = entry_«(mut.object as SpecificClosureSelection).objSel.name».getKey();
					}
					objectSelection = new SpecificObjectSelection(packages, model, recovered);
				} else {
					if (hmList.get("«(mut.object as SpecificClosureSelection).objSel.name»") != null) {
						List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_«(mut.object as SpecificClosureSelection).objSel.name» = hmList.get("«(mut.object as SpecificClosureSelection).objSel.name»");
						List<EObject> objs = new ArrayList<EObject>();
						for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_«(mut.object as SpecificClosureSelection).objSel.name») {
							EObject obj = ModelManager.getObject(model, ent.getKey());
							objs.add(obj);
						}
						objectSelection = new SpecificObjectSelection(packages, model, objs);
					}
					else {
						return numMutantsGenerated;
					}
				}
				if (objectSelection != null) {
					objects.add(objectSelection.getObject());
				}
				«IF mut.object.refType !== null»
				List<EObject> o = ModelManager.getReferences("«mut.object.refType.name»", objectSelection.getObject());
				EObject object = o.get(ModelManager.getRandomIndex(o));
				objectSelection = new SpecificObjectSelection(model, packages, object);
				objects.add(object);
				«ENDIF»
				«ENDIF»
			«ENDIF»
		«IF mut.container === null»
		    for (int obn = 0; obn < objects.size(); obn++) {
			Resource m = EMFCopier.copyResource(model);
			«IF mut.object instanceof SpecificObjectSelection || mut.object instanceof SpecificClosureSelection»
			List<EObject> mObjects = ModelManager.getObjects(m, objects);
			«ENDIF»
			«IF mut.object instanceof RandomTypeSelection»
			rts = new RandomTypeSelection(packages, m, "«(mut.object as RandomTypeSelection).type.name»");
			List<EObject> mObjects = rts.getObjects();
			«ENDIF»
			«IF mut.object instanceof CompleteTypeSelection»
			cts = new RandomTypeSelection(packages, m, "«(mut.object as CompleteTypeSelection).type.name»");
			List<EObject> mObjects = cts.getObjects();
			«ENDIF»
				«IF mut.object instanceof SpecificObjectSelection || mut.object instanceof SpecificClosureSelection»
				if (mObjects.size() > obn) {
					objectSelection = new SpecificObjectSelection(packages, m, mObjects.get(obn));
				}
				else {
					continue;
				}
				«ENDIF»
				«IF mut.object instanceof RandomTypeSelection»
				ObSelectionStrategy objectSelection = null;
				if (mObjects.size() > obn) {
					objectSelection = new SpecificObjectSelection(packages, m, mObjects.get(obn));
				}
				else {
					continue;
				}
				«ENDIF»
				«IF mut.object instanceof CompleteTypeSelection»
				ObSelectionStrategy objectSelection = null;
				if (mObjects.size() > obn) {
					objectSelection = new SpecificObjectSelection(packages, m, mObjects.get(obn));
				}
				else {
					continue;
				}
				«ENDIF»
				EObject container = ModelManager.getContainer(m, objectSelection.getObject());
				ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, m, container);
				SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, m, null, null);
		«ELSE»
			«IF mut.container instanceof RandomTypeSelection»
				RandomTypeSelection rts = new RandomTypeSelection(packages, model, "«(mut.container as RandomTypeSelection).type.name»");
				EObject container = rts.getObject();
				ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, container);
				«IF mut.container.refType !== null»
					SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model, "«mut.container.refType.name»", containerSelection);
				«ELSE»
					SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model, null, null);
				«ENDIF»
			«ENDIF»
			«IF mut.container instanceof CompleteTypeSelection»
				«/* THE SAME AS RANDOM */»
				RandomTypeSelection rts = new RandomTypeSelection(packages, model, "«(mut.container as CompleteTypeSelection).type.name»");
				EObject container = rts.getObject();
				ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, container);
				«IF mut.container.refType !== null»
					SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model, "«mut.container.refType.name»", containerSelection);
				«ELSE»
					SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model, null, null);
				«ENDIF»
			«ENDIF»
			«IF mut.container instanceof SpecificObjectSelection»
				ObSelectionStrategy containerSelection = null;
				SpecificReferenceSelection referenceSelection = null;
				SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.container as SpecificObjectSelection).objSel.name» = hmObjects.get("«(mut.container as SpecificObjectSelection).objSel.name»");
				if (entry_«(mut.container as SpecificObjectSelection).objSel.name» != null) {
					EObject recovered = ModelManager.getObject(model, entry_«(mut.container as SpecificObjectSelection).objSel.name».getKey());
					if (recovered == null) {
						recovered = entry_«(mut.container as SpecificObjectSelection).objSel.name».getKey();
					}
				«IF mut.container.refType !== null»
					containerSelection = new SpecificObjectSelection(packages, model, recovered);
					referenceSelection = new SpecificReferenceSelection(packages, model, "«mut.container.refType.name»", recovered);
				«ELSE»
					referenceSelection = new SpecificReferenceSelection(packages, model, null, null);
				«ENDIF»
				} else {
					return numMutantsGenerated;
				}
			«ENDIF»
			«IF mut.container instanceof SpecificClosureSelection»
				ObSelectionStrategy containerSelection = null;
				SpecificReferenceSelection referenceSelection = null;
				SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.container as SpecificClosureSelection).objSel.name» = hmObjects.get("«(mut.container as SpecificClosureSelection).objSel.name»");
				if (entry_«(mut.container as SpecificClosureSelection).objSel.name» != null) {
					EObject recovered = ModelManager.getObject(model, entry_«(mut.container as SpecificClosureSelection).objSel.name».getKey());
					if (recovered == null) {
						recovered = entry_«(mut.container as SpecificClosureSelection).objSel.name».getKey();
					}
				«IF mut.container.refType !== null»
					containerSelection = new SpecificClosureSelection(packages, model, recovered, "«(mut.container as SpecificClosureSelection).objSel.name»");
					referenceSelection = new SpecificReferenceSelection(pakages, model, "«mut.container.refType.name»", recovered);
				«ELSE»
					referenceSelection = new SpecificReferenceSelection(packages, model, null, null);
				} else {
					return numMutantsGenerated;
				}
				«ENDIF»
			«ENDIF»
		«ENDIF»
		Map<String, AttributeConfigurationStrategy> atts = new HashMap<String, AttributeConfigurationStrategy>();
		//«var counter = 0»
		«FOR c : mut.attributes»
			//«counter++»
			«c.method(false, false, counter, true, "objectSelection")»
		«ENDFOR»
		Map<String, ObSelectionStrategy> refs = new HashMap<String, ObSelectionStrategy>();
		«FOR c : mut.references»
			«c.method(true)»
		«ENDFOR»
		«IF mut.container !== null»
		«IF mut.object instanceof RandomTypeSelection»
		CloneObjectMutator mut = new CloneObjectMutator(model, packages, objectSelection.getObject(), «mut.contents», referenceSelection, containerSelection, atts, refs, "«(mut.object as RandomTypeSelection).type.name»");
		«ELSEIF mut.object instanceof CompleteTypeSelection»
		CloneObjectMutator mut = new CloneObjectMutator(model, packages, objectSelection.getObject(), «mut.contents», referenceSelection, containerSelection, atts, refs, "«(mut.object as CompleteTypeSelection).type.name»");
		«ELSEIF mut.object instanceof SpecificObjectSelection»
		CloneObjectMutator mut = new CloneObjectMutator(model, packages, objectSelection.getObject(), «mut.contents», referenceSelection, containerSelection, atts, refs, "«((mut.object as SpecificObjectSelection).objSel as SelectObjectMutator).object.type.name»");
		«ELSEIF mut.object instanceof SpecificClosureSelection»
		CloneObjectMutator mut = new CloneObjectMutator(model, packages, objectSelection.getObject(), «mut.contents», referenceSelection, containerSelection, atts, refs, "«((mut.object as SpecificClosureSelection).objSel as SelectObjectMutator).object.type.name»");
		«ENDIF»
		«ENDIF»
		«IF mut.container === null»
		«IF mut.object instanceof RandomTypeSelection»
		CloneObjectMutator mut = new CloneObjectMutator(m, packages, objectSelection.getObject(), «mut.contents», referenceSelection, containerSelection, atts, refs, "«(mut.object as RandomTypeSelection).type.name»");
		«ELSEIF mut.object instanceof CompleteTypeSelection»
		CloneObjectMutator mut = new CloneObjectMutator(m, packages, objectSelection.getObject(), «mut.contents», referenceSelection, containerSelection, atts, refs, "«(mut.object as CompleteTypeSelection).type.name»");
		«ELSEIF mut.object instanceof SpecificObjectSelection»
		CloneObjectMutator mut = new CloneObjectMutator(m, packages, objectSelection.getObject(), «mut.contents», referenceSelection, containerSelection, atts, refs, "«((mut.object as SpecificObjectSelection).objSel as SelectObjectMutator).object.type.name»");
		«ELSEIF mut.object instanceof SpecificClosureSelection»
		CloneObjectMutator mut = new CloneObjectMutator(m, packages, objectSelection.getObject(), «mut.contents», referenceSelection, containerSelection, atts, refs, "«((mut.object as SpecificClosureSelection).objSel as SelectObjectMutator).object.type.name»");
		«ENDIF»
		«ENDIF»
		Mutator mutator = null;
		if (muts == null) {
			muts = AppliedMutationsFactory.eINSTANCE.createMutations();
		}

		//COUNTER: «nRegistryMutation = nRegistryMutation + 1»
		//COUNTER: «nRegistryMethodCall = nRegistryMethodCall + 1»
		//REGISTRY METHOD NAME:«registryMethodName = "registry" + nRegistryMethodCall.toString()»
		«IF executeMutation == true»
			if (mut != null) {
				Object mutated = mut.mutate();
					if (mutated != null) {
						«IF mut.name !== null»
						SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(mut.getModel(), mut.getMetaModel());
						SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(mut.getObject(), resourceEntry);
						hmObjects.put("«mut.name»", entry);
						«ENDIF»
						AppMutation appMut = «registryMethodName»(mut, hmMutator, seed, mutPaths, packages);
						if (appMut != null) {
							muts.getMuts().add(appMut);
						}
					}
				}
				«ENDIF»
				mutator = mut;
				if (mutator != null) {
				//«nMethodCall = nMethodCall + 1»
				«IF last == false»
				«IF mut.container !== null»
				«IF standalone == false»
				mutation«nMethodCall»(packages, model, hmObjects, hmList, hashmapModelFilenames,
									modelFilename, mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,
									registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, project, monitor, k, serialize, test, classes);
				«ELSE»
				mutation«nMethodCall»(packages, model, hmObjects, hmList, hashmapModelFilenames,
									modelFilename, mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,
									registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, project, k, serialize, test, classes);
				«ENDIF»
				numMutantsGenerated = k[0];
				«ENDIF»
				«IF mut.container === null»
				«IF standalone == false»
				mutation«nMethodCall»(packages, model, hmObjects, hmList, hashmapModelFilenames,
									modelFilename, mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,
									registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, project, monitor, k, serialize, test, classes);
				«ELSE»
				mutation«nMethodCall»(packages, model, hmObjects, hmList, hashmapModelFilenames,
									modelFilename, mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,
									registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, monitor, k, serialize, test, classes);
				«ENDIF»
				numMutantsGenerated = k[0];
				}
				«ENDIF»
				«ENDIF»
				«IF last == true»
				// MUTANT COMPLETION AND REGISTRY
				Map<String, List<String>> rules = new HashMap<String, List<String>>();
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
				«IF b === null»
				String mutFilename = hashmapModelFilenames.get(modelFilename) + "/" + "Output" + k[0] + ".model";
				«ELSE»
		   		«IF b.from.size == 0»
					String mutFilename = hashmapModelFilenames.get(modelFilename) + "/«b.name»/Output" + k[0] + ".model";
		   		«ELSE»
					String mutFilename = hashmapModelFilenames.get(modelFilename) + "/«b.name»/" + hashmapModelFolders.get(modelFilename) + "/Output" + k[0] + ".model";
		   		«ENDIF»
		   		«ENDIF»
		   		«IF b === null»
		   		«IF standalone == false»
		   			boolean isRepeated = registryMutant(ecoreURI, packages, registeredPackages, localRegisteredPackages, seed, mutator.getModel(), rules, muts, modelFilename, mutFilename, registry, hashsetMutantsBlock, hashmapModelFilenames, k, mutPaths, hashmapMutVersions, project, serialize, test, classes, this.getClass(), true);
		   		«ELSE»
		   			boolean isRepeated = registryMutantStandalone(ecoreURI, packages, registeredPackages, localRegisteredPackages, seed, mutator.getModel(), rules, muts, modelFilename, mutFilename, registry, hashsetMutantsBlock, hashmapModelFilenames, k, mutPaths, hashmapMutVersions, "«getProjectName»", serialize, test, classes, «className».class, true);
		   		«ENDIF»
		   		«ELSE»
		   		«IF standalone == false»
					boolean isRepeated = registryMutantWithBlocks(ecoreURI, packages, registeredPackages, localRegisteredPackages, seed, mutator.getModel(), rules, muts, modelFilename, mutFilename, registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "«b.name»", fromNames, k, mutPaths, hashmapMutVersions, project, serialize, test, classes, this.getClass(), true, false);
				«ELSE»
					boolean isRepeated = registryMutantWithBlocksStandalone(ecoreURI, packages, registeredPackages, localRegisteredPackages, seed, mutator.getModel(), rules, muts, modelFilename, mutFilename, registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "«b.name»", fromNames, k, mutPaths, hashmapMutVersions, "«getProjectName»", serialize, test, classes, «className».class, true, false);
				«ENDIF»
				«ENDIF»
					if (isRepeated == false) {
						numMutantsGenerated++;
						monitor.worked(1);
						k[0] = k[0] + 1;
					}
					muts = null;
		«IF mut.container === null»
			}
		«ENDIF»
		«ENDIF»
			}
			//END CLONE OBJECT «methodName»
	'''
	
	def retypeObjectMutator(RetypeObjectMutator mut) '''
			//RETYPE OBJECT «methodName»
			List<String> mutTypes = new ArrayList<String>();
			«IF mut.object instanceof RandomTypeSelection»
			//«var RandomTypeSelection selection = mut.object as RandomTypeSelection»
			«IF selection.types !== null && selection.types.size > 0»
			«FOR EClass type : selection.types»
			mutTypes.add("«type.name»");
			«ENDFOR»
			«ELSEIF selection.type !== null»
			mutTypes.add("«selection.type.name»");
			«ENDIF»
			«ELSEIF mut.object instanceof CompleteTypeSelection»
			//«var CompleteTypeSelection selection = mut.object as CompleteTypeSelection»
			«IF selection.types !== null && selection.types.size > 0»
			«FOR EClass type : selection.types»
			mutTypes.add("«type.name»");
			«ENDFOR»
			«ELSEIF selection.type !== null»
			mutTypes.add("«selection.type.name»");
			«ENDIF»
			«ENDIF»
			List<String> targetTypes = new ArrayList<String>();
			«IF mut.types !== null && mut.types.size > 0»
			«FOR EClass type : mut.types»
			targetTypes.add("«type.name»");
			«ENDFOR»
			«ELSEIF mut.type !== null»
			targetTypes.add("«mut.type.name»");
			«ENDIF»
			«IF mut.object instanceof RandomTypeSelection»
				RandomTypeSelection rts = new RandomTypeSelection(packages, model, mutTypes);
				«IF mut.object.expression === null»
					EObject object = rts.getObject();
				«ELSE»
					List<EObject> objects = rts.getObjects();
					//EXPRESSION LIST: «expressionList = new ArrayList<Integer>()»
					//EXPRESSION LEVEL: «nExpression = 0»
					//EXPRESSION LEVEL: «expressionList.add(0)»
					Expression exp«expressionList.get(0)» = new Expression();
	   				«mut.object.expression.method(0)»
					List<EObject> selectedObjects = evaluate(objects, exp«expressionList.get(0)»);
					EObject object = null;
					if (selectedObjects.size() > 0) {
						object = selectedObjects.get(ModelManager.getRandomIndex(selectedObjects));
					}
				«ENDIF»
				ObSelectionStrategy objectSelection = null; 
				if (object != null) {
					objectSelection = new SpecificObjectSelection(packages, model, object);
				}
			«ELSEIF mut.object instanceof CompleteTypeSelection»
				RandomTypeSelection rts = new RandomTypeSelection(packages, model, mutTypes);
				EObject object = rts.getObject();
				ObSelectionStrategy objectSelection = new SpecificObjectSelection(packages, model, object);
			«ELSEIF mut.object instanceof SpecificObjectSelection»
				ObSelectionStrategy objectSelection = null;
				SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.container as SpecificObjectSelection).objSel.name» = hmObjects.get("«(mut.container as SpecificObjectSelection).objSel.name»");
				if (entry_«(mut.container as SpecificObjectSelection).objSel.name» != null) {
					objectSelection = new SpecificObjectSelection(entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getValue(), entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getKey(), entry_«(mut.container as SpecificObjectSelection).objSel.name».getKey());
				} else {
					List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_«(mut.container as SpecificObjectSelection).objSel.name» = hmList.get("«(mut.container as SpecificObjectSelection).objSel.name»");
					if (listEntry_«(mut.container as SpecificObjectSelection).objSel.name» != null) {
						List<EObject> objs = new ArrayList<EObject>();
						for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_«(mut.container as SpecificObjectSelection).objSel.name») {
							EObject obj = ent.getKey();
							objs.add(obj);
						}
						objectSelection = new SpecificObjectSelection(listEntry_«(mut.container as SpecificObjectSelection).objSel.name».get(0).getValue().getValue(), listEntry_«(mut.container as SpecificObjectSelection).objSel.name».get(0).getValue().getKey(), objs);
					}
					else {
						return mutations;
					}
				}
			«ELSEIF mut.object instanceof SpecificClosureSelection»
				ObSelectionStrategy objectSelection = null;
				SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.container as SpecificClosureSelection).objSel.name» = hmObjects.get("«(mut.container as SpecificClosureSelection).objSel.name»");
				if (entry_«(mut.container as SpecificClosureSelection).objSel.name» != null) {
					objectSelection = new SpecificClosureSelection(entry_«(mut.container as SpecificClosureSelection).objSel.name».getValue().getValue(), entry_«(mut.container as SpecificClosureSelection).objSel.name».getValue().getKey(), entry_«(mut.container as SpecificClosureSelection).objSel.name».getKey(), "«(mut.object as SpecificClosureSelection).refType.name»");
				} else {
					return mutations;
				}
			«ENDIF»
			EObject container = null;
			ObSelectionStrategy containerSelection = null;
			if (objectSelection != null) {
			«IF mut.container === null»
				container = ModelManager.getContainer(objectSelection.getModel(), objectSelection.getObject());
				containerSelection = new SpecificObjectSelection(objectSelection.getMetaModel(), objectSelection.getModel(), container);
			«ELSE»
				«IF mut.container instanceof RandomTypeSelection»
					RandomTypeSelection rtsContainer = new RandomTypeSelection(objectSelection.getMetaModel(), objectSelection.getModel(), "«(mut.container as RandomTypeSelection).type.name»");
					container = rtsContainer.getObject();
					containerSelection = new SpecificObjectSelection(objectSelection.getMetaModel(), objectSelection.getModel(), container);
				«ENDIF»
				«IF mut.container instanceof CompleteTypeSelection»
					«/* THE SAME AS RANDOM */»
					RandomTypeSelection rtsContainer = new RandomTypeSelection(objectSelection.getMetaModel(), objectSelection.getModel(), "«(mut.container as CompleteTypeSelection).type.name»");
					container = rtsContainer.getObject();
					containerSelection = new SpecificObjectSelection(objectSelection.getMetaModel(), objectSelection.getModel(), container);
				«ENDIF»
				«IF mut.container instanceof SpecificObjectSelection»
					«IF mut.refType !== null»
					SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.container as SpecificObjectSelection).objSel.name» = hmObjects.get("«(mut.container as SpecificObjectSelection).objSel.name»");
					if (entry_«(mut.container as SpecificObjectSelection).objSel.name» != null) {
						containerSelection = new SpecificObjectSelection(entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getValue(), entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getKey(), entry_«(mut.container as SpecificObjectSelection).objSel.name».getKey());
					} else {
						return mutations;
					}
					«ENDIF»
				«ENDIF»
				«IF mut.container instanceof SpecificClosureSelection»
					«IF mut.refType !== null»
					SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.container as SpecificClosureSelection).objSel.name» = hmObjects.get("«(mut.container as SpecificClosureSelection).objSel.name»");
					if (entry_«(mut.container as SpecificClosureSelection).objSel.name» != null) {
						containerSelection = new SpecificClosureSelection(entry_«(mut.container as SpecificClosureSelection).objSel.name».getValue().getValue(), entry_«(mut.container as SpecificClosureSelection).objSel.name».getValue().getKey(), entry_«(mut.container as SpecificClosureSelection).objSel.name».getKey(), "«(mut.container as SpecificClosureSelection).refType.name»");
					} else {
						return mutations;
					}
					«ENDIF»
				«ENDIF»
			«ENDIF»
			}
			«IF mut.refType !== null»
				SpecificReferenceSelection referenceSelection = null;
				«IF mut.container instanceof SpecificObjectSelection»
				SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.container as SpecificClosureSelection).objSel.name» = hmObjects.get("«(mut.container as SpecificClosureSelection).objSel.name»");
				if (entry_«(mut.container as SpecificClosureSelection).objSel.name» != null) {
					referenceSelection = new SpecificReferenceSelection(entry_«(mut.container as SpecificClosureSelection).objSel.name».getValue().getValue(), entry_«(mut.container as SpecificClosureSelection).objSel.name».getValue().getKey(), "«mut.refType.name»", entry_«(mut.container as SpecificClosureSelection).objSel.name».getKey());
				} else {
					return mutations;
				}
				«ELSEIF mut.container instanceof SpecificClosureSelection»
				SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.container as SpecificClosureSelection).objSel.name» = hmObjects.get("«(mut.container as SpecificClosureSelection).objSel.name»");
				if (entry_«(mut.container as SpecificClosureSelection).objSel.name» != null) {
					referenceSelection = new SpecificReferenceSelection(entry_«(mut.container as SpecificClosureSelection).objSel.name».getValue().getValue(), entry_«(mut.container as SpecificClosureSelection).objSel.name».getValue().getKey(), "«mut.refType.name»", entry_«(mut.container as SpecificClosureSelection).objSel.name».getKey());
				} else {
					return mutations;
				}
				«ELSE»
				SpecificReferenceSelection referenceSelection = null;
				if (containerSelection != null) {
					referenceSelection = new SpecificReferenceSelection(containerSelection.getMetaModel(), containerSelection.getModel(), "«mut.refType.name»", containerSelection);
				}
				«ENDIF»
			«ELSE»
				SpecificReferenceSelection referenceSelection = null;
				if (containerSelection != null) {
					referenceSelection = new SpecificReferenceSelection(containerSelection.getMetaModel(), containerSelection.getModel(), null, null);
				}
			«ENDIF»
			Map<String, AttributeConfigurationStrategy> atts = new HashMap<String, AttributeConfigurationStrategy>();
			//«var counter = 0»
			«FOR c : mut.attributes»
				//«counter ++»
				«c.method(false, false, counter, false, "objectSelection")»
			«ENDFOR»
			Map<String, ObSelectionStrategy> refs = new HashMap<String, ObSelectionStrategy>();
			«FOR c : mut.references»
				«c.method(false)»
			«ENDFOR»
			RetypeObjectMutator mut = null;
			if (objectSelection != null && objectSelection.getObject() != null) {
				mut = new RetypeObjectMutator(objectSelection.getModel(), objectSelection.getMetaModel(), objectSelection.getObject(), referenceSelection, containerSelection, atts, refs, targetTypes);
			}
			//INC COUNTER: «nMutation++»
   			//INC COUNTER: «nRegistryMutation++»
			if (mut != null) {
				mut.setId("m«nMutation»");
				mutations.add(mut);
			}
	'''
	
	def retypeObjectMutatorExhaustive(RetypeObjectMutator mut, MutatorEnvironment e, Block b, boolean last) '''
		//RETYPE OBJECT «methodName»
		List<String> mutTypes = new ArrayList<String>();
		//«var boolean definedObjects = false»
		«IF mut.object instanceof RandomTypeSelection»
		//«var RandomTypeSelection selection = mut.object as RandomTypeSelection»
		«IF selection.types !== null && selection.types.size > 0»
		«FOR EClass type : selection.types»
		mutTypes.add("«type.name»");
		«ENDFOR»
		«ELSEIF selection.type !== null»
		mutTypes.add("«selection.type.name»");
		«ENDIF»
		«ELSEIF mut.object instanceof CompleteTypeSelection»
		//«var CompleteTypeSelection selection = mut.object as CompleteTypeSelection»
		«IF selection.types !== null && selection.types.size > 0»
		«FOR EClass type : selection.types»
		mutTypes.add("«type.name»");
		«ENDFOR»
		«ELSEIF selection.type !== null»
		mutTypes.add("«selection.type.name»");
		«ENDIF»
		«ENDIF»
		List<String> targetTypes = new ArrayList<String>();
		«IF mut.types !== null && mut.types.size > 0»
		«FOR EClass type : mut.types»
		targetTypes.add("«type.name»");
		«ENDFOR»
		«ELSEIF mut.type !== null»
		targetTypes.add("«mut.type.name»");
		«ENDIF»
		«IF mut.object instanceof RandomTypeSelection»
		RandomTypeSelection rts = new RandomTypeSelection(packages, model, mutTypes);
		«IF mut.object.expression === null»
		List<EObject> objects = rts.getObjects();
		//«definedObjects = true»
		«ELSE»
		List<EObject> objects = rts.getObjects();
		//«definedObjects = true»
		//EXPRESSION LIST: «expressionList = new ArrayList<Integer>()»
		//EXPRESSION LEVEL: «nExpression = 0»
		//EXPRESSION LEVEL: «expressionList.add(0)»
		Expression exp«expressionList.get(0)» = new Expression();
		«mut.object.expression.method(0)»
		List<EObject> selectedObjects = evaluate(objects, exp«expressionList.get(0)»);
		«IF definedObjects == false»
		List<EObject> objects = null;
		//«definedObjects = true»
		«ENDIF»
		if (selectedObjects.size() > 0) {
			objects = selectedObjects;
		}
		«ENDIF»
		ObSelectionStrategy objectSelection = null; 
		if (objects != null && objects.size() > 0) {
			objectSelection = new SpecificObjectSelection(packages, model, objects.get(0));
		}
		«ELSEIF mut.object instanceof CompleteTypeSelection»
		RandomTypeSelection rts = new RandomTypeSelection(packages, model, mutTypes);
		EObject object = rts.getObject();
		ObSelectionStrategy objectSelection = new SpecificObjectSelection(packages, model, objects.get(0));
		«ELSEIF mut.object instanceof SpecificObjectSelection»
		ObSelectionStrategy objectSelection = null;
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.container as SpecificObjectSelection).objSel.name» = hmObjects.get("«(mut.container as SpecificObjectSelection).objSel.name»");
		if (entry_«(mut.container as SpecificObjectSelection).objSel.name» != null) {
			objectSelection = new SpecificObjectSelection(entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getValue(), entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getKey(), entry_«(mut.container as SpecificObjectSelection).objSel.name».getKey());
		} else {
			List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_«(mut.container as SpecificObjectSelection).objSel.name» = hmList.get("«(mut.container as SpecificObjectSelection).objSel.name»");
			if (listEntry_«(mut.container as SpecificObjectSelection).objSel.name» != null) {
				List<EObject> objs = new ArrayList<EObject>();
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_«(mut.container as SpecificObjectSelection).objSel.name») {
					EObject obj = ent.getKey();
					objs.add(obj);
				}
				objectSelection = new SpecificObjectSelection(listEntry_«(mut.container as SpecificObjectSelection).objSel.name».get(0).getValue().getValue(), listEntry_«(mut.container as SpecificObjectSelection).objSel.name».get(0).getValue().getKey(), objs);
			}
			else {
				return mutations;
			}
		}
		«ELSEIF mut.object instanceof SpecificClosureSelection»
		ObSelectionStrategy objectSelection = null;
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.container as SpecificClosureSelection).objSel.name» = hmObjects.get("«(mut.container as SpecificClosureSelection).objSel.name»");
		if (entry_«(mut.container as SpecificClosureSelection).objSel.name» != null) {
			objectSelection = new SpecificClosureSelection(entry_«(mut.container as SpecificClosureSelection).objSel.name».getValue().getValue(), entry_«(mut.container as SpecificClosureSelection).objSel.name».getValue().getKey(), entry_«(mut.container as SpecificClosureSelection).objSel.name».getKey(), "«(mut.object as SpecificClosureSelection).refType.name»");
		} else {
			return mutations;
		}
		«ENDIF»
		EObject container = null;
		ObSelectionStrategy containerSelection = null;
		if (objectSelection != null) {
		«IF mut.container === null»
			container = ModelManager.getContainer(objectSelection.getModel(), objectSelection.getObject());
			containerSelection = new SpecificObjectSelection(objectSelection.getMetaModel(), objectSelection.getModel(), container);
		«ELSE»
		«IF mut.container instanceof RandomTypeSelection»
			RandomTypeSelection rtsContainer = new RandomTypeSelection(objectSelection.getMetaModel(), objectSelection.getModel(), "«(mut.container as RandomTypeSelection).type.name»");
			container = rtsContainer.getObject();
			containerSelection = new SpecificObjectSelection(objectSelection.getMetaModel(), objectSelection.getModel(), container);
		«ENDIF»
		«IF mut.container instanceof CompleteTypeSelection»
			«/* THE SAME AS RANDOM */»
			RandomTypeSelection rtsContainer = new RandomTypeSelection(objectSelection.getMetaModel(), objectSelection.getModel(), "«(mut.container as CompleteTypeSelection).type.name»");
			container = rtsContainer.getObject();
			containerSelection = new SpecificObjectSelection(objectSelection.getMetaModel(), objectSelection.getModel(), container);
		«ENDIF»
		«IF mut.container instanceof SpecificObjectSelection»
			«IF mut.refType !== null»
			SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.container as SpecificObjectSelection).objSel.name» = hmObjects.get("«(mut.container as SpecificObjectSelection).objSel.name»");
			if (entry_«(mut.container as SpecificObjectSelection).objSel.name» != null) {
				containerSelection = new SpecificObjectSelection(entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getValue(), entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getKey(), entry_«(mut.container as SpecificObjectSelection).objSel.name».getKey());
			} else {
				return mutations;
			}
			«ENDIF»
		«ENDIF»
		«IF mut.container instanceof SpecificClosureSelection»
			«IF mut.refType !== null»
			SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.container as SpecificClosureSelection).objSel.name» = hmObjects.get("«(mut.container as SpecificClosureSelection).objSel.name»");
			if (entry_«(mut.container as SpecificClosureSelection).objSel.name» != null) {
				containerSelection = new SpecificClosureSelection(entry_«(mut.container as SpecificClosureSelection).objSel.name».getValue().getValue(), entry_«(mut.container as SpecificClosureSelection).objSel.name».getValue().getKey(), entry_«(mut.container as SpecificClosureSelection).objSel.name».getKey(), "«(mut.container as SpecificClosureSelection).refType.name»");
			} else {
				return mutations;
			}
			«ENDIF»
		«ENDIF»
		«ENDIF»
		}
		«IF mut.refType !== null»
		SpecificReferenceSelection referenceSelection = null;
		«IF mut.container instanceof SpecificObjectSelection»
			SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.container as SpecificClosureSelection).objSel.name» = hmObjects.get("«(mut.container as SpecificClosureSelection).objSel.name»");
		if (entry_«(mut.container as SpecificClosureSelection).objSel.name» != null) {
			referenceSelection = new SpecificReferenceSelection(entry_«(mut.container as SpecificClosureSelection).objSel.name».getValue().getValue(), entry_«(mut.container as SpecificClosureSelection).objSel.name».getValue().getKey(), "«mut.refType.name»", entry_«(mut.container as SpecificClosureSelection).objSel.name».getKey());
		} else {
			return mutations;
		}
		«ELSEIF mut.container instanceof SpecificClosureSelection»
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.container as SpecificClosureSelection).objSel.name» = hmObjects.get("«(mut.container as SpecificClosureSelection).objSel.name»");
		if (entry_«(mut.container as SpecificClosureSelection).objSel.name» != null) {
			referenceSelection = new SpecificReferenceSelection(entry_«(mut.container as SpecificClosureSelection).objSel.name».getValue().getValue(), entry_«(mut.container as SpecificClosureSelection).objSel.name».getValue().getKey(), "«mut.refType.name»", entry_«(mut.container as SpecificClosureSelection).objSel.name».getKey());
		} else {
			return mutations;
		}
		«ELSE»
		SpecificReferenceSelection referenceSelection = null;
		if (containerSelection != null) {
			referenceSelection = new SpecificReferenceSelection(containerSelection.getMetaModel(), containerSelection.getModel(), "«mut.refType.name»", containerSelection);
		}
		«ENDIF»
		«ELSE»
		SpecificReferenceSelection referenceSelection = null;
		if (containerSelection != null) {
			referenceSelection = new SpecificReferenceSelection(containerSelection.getMetaModel(), containerSelection.getModel(), null, null);
		}
		«ENDIF»
		«IF mut.container === null»
		    for (int obn = 0; obn < objects.size(); obn++) {
			Resource m = EMFCopier.copyResource(model);
			«IF mut.object instanceof SpecificObjectSelection || mut.object instanceof SpecificClosureSelection»
			List<EObject> mObjects = ModelManager.getObjects(m, objects);
			«ENDIF»
			«IF mut.object instanceof RandomTypeSelection»
			rts = new RandomTypeSelection(packages, m, mutTypes);
			List<EObject> mObjects = rts.getObjects();
			«ENDIF»
			«IF mut.object instanceof CompleteTypeSelection»
			cts = new RandomTypeSelection(packages, m, mutTypes);
			List<EObject> mObjects = cts.getObjects();
			«ENDIF»
				«IF mut.object instanceof SpecificObjectSelection || mut.object instanceof SpecificClosureSelection»
				ObSelectionStrategy obSelection = null;
				if (mObjects.size() > obn) {
					obSelection = new SpecificObjectSelection(packages, m, mObjects.get(obn));
				}
				else {
					continue;
				}
				«ENDIF»
				«IF mut.object instanceof RandomTypeSelection»
				ObSelectionStrategy obSelection = null;
				if (mObjects.size() > obn) {
					obSelection = new SpecificObjectSelection(packages, m, mObjects.get(obn));
				}
				else {
					continue;
				}
				«ENDIF»
				«IF mut.object instanceof CompleteTypeSelection»
				ObSelectionStrategy obSelection = null;
				if (mObjects.size() > obn) { 
					obSelection = new SpecificObjectSelection(packages, m, mObjects.get(obn));
				}
				else {
					continue;
				}
				«ENDIF»
				EObject c = ModelManager.getContainer(m, obSelection.getObject());
				ObSelectionStrategy cSelection = new SpecificObjectSelection(packages, m, c);
				SpecificReferenceSelection rSelection = new SpecificReferenceSelection(packages, m, null, null);
		«ENDIF»
		Map<String, AttributeConfigurationStrategy> atts = new HashMap<String, AttributeConfigurationStrategy>();
		//«var counter = 0»
		«FOR c : mut.attributes»
			//«counter++»
			«c.method(false, false, counter, true, "obSelection")»
		«ENDFOR»
		Map<String, ObSelectionStrategy> refs = new HashMap<String, ObSelectionStrategy>();
		«FOR c : mut.references»
			«c.method(true)»
		«ENDFOR»
		«IF mut.container !== null»
		«IF mut.object instanceof RandomTypeSelection || mut.object instanceof CompleteTypeSelection || mut.object instanceof SpecificObjectSelection || mut.object instanceof SpecificClosureSelection»
		RetypeObjectMutator mut = new RetypeObjectMutator(model, packages, objectSelection.getObject(), referenceSelection, containerSelection, atts, refs, targetTypes);
		«ENDIF»
		«ENDIF»
		«IF mut.container === null»
		«IF mut.object instanceof RandomTypeSelection || mut.object instanceof CompleteTypeSelection || mut.object instanceof SpecificObjectSelection || mut.object instanceof SpecificClosureSelection»
		RetypeObjectMutator mut = new RetypeObjectMutator(m, packages, obSelection.getObject(), rSelection, cSelection, atts, refs, targetTypes);
		«ENDIF»
		«ENDIF»
		Mutator mutator = null;
		if (muts == null) {
			muts = AppliedMutationsFactory.eINSTANCE.createMutations();
		}

		//COUNTER: «nRegistryMutation = nRegistryMutation + 1»
		//COUNTER: «nRegistryMethodCall = nRegistryMethodCall + 1»
		//REGISTRY METHOD NAME:«registryMethodName = "registry" + nRegistryMethodCall.toString()»
		«IF executeMutation == true»
			if (mut != null) {
				Object mutated = mut.mutate();
					if (mutated != null) {
						«IF mut.name !== null»
						SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(mut.getModel(), mut.getMetaModel());
						SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(mut.getObject(), resourceEntry);
						hmObjects.put("«mut.name»", entry);
						«ENDIF»
						AppMutation appMut = «registryMethodName»(mut, hmMutator, seed, mutPaths, packages);
						if (appMut != null) {
							muts.getMuts().add(appMut);
						}
					}
				}
				«ENDIF»
				mutator = mut;
				if (mutator != null) {
				//«nMethodCall = nMethodCall + 1»
				«IF last == false»
				«IF mut.container !== null»
				«IF standalone == false»
				mutation«nMethodCall»(packages, model, hmObjects, hmList, hashmapModelFilenames,
									modelFilename, mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,
									registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, project, monitor, k, serialize, test, classes);
				«ELSE»
				mutation«nMethodCall»(packages, model, hmObjects, hmList, hashmapModelFilenames,
									modelFilename, mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,
									registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, monitor, k, serialize, test, classes);
				«ENDIF»
				numMutantsGenerated = k[0];
				«ENDIF»
				«IF mut.container === null»
				«IF standalone == false»
				mutation«nMethodCall»(packages, model, hmObjects, hmList, hashmapModelFilenames,
									modelFilename, mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,
									registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, project, monitor, k, serialize, test, classes);
				«ELSE»
				mutation«nMethodCall»(packages, model, hmObjects, hmList, hashmapModelFilenames,
									modelFilename, mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,
									registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, monitor, k, serialize, test, classes);
				«ENDIF»
				numMutantsGenerated = k[0];
				}
				«ENDIF»
				«ENDIF»
				«IF last == true»
				// MUTANT COMPLETION AND REGISTRY
				Map<String, List<String>> rules = new HashMap<String, List<String>>();
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
				«IF b === null»
				String mutFilename = hashmapModelFilenames.get(modelFilename) + "/" + "Output" + k[0] + ".model";
				«ELSE»
		   		«IF b.from.size == 0»
					String mutFilename = hashmapModelFilenames.get(modelFilename) + "/«b.name»/Output" + k[0] + ".model";
		   		«ELSE»
					String mutFilename = hashmapModelFilenames.get(modelFilename) + "/«b.name»/" + hashmapModelFolders.get(modelFilename) + "/Output" + k[0] + ".model";
		   		«ENDIF»
		   		«ENDIF»
		   		«IF b === null»
		   		«IF standalone == false»
		   			boolean isRepeated = registryMutant(ecoreURI, packages, registeredPackages, localRegisteredPackages, seed, mutator.getModel(), rules, muts, modelFilename, mutFilename, registry, hashsetMutantsBlock, hashmapModelFilenames, k, mutPaths, hashmapMutVersions, project, serialize, test, classes, this.getClass(), true);
		   		«ELSE»
		   			boolean isRepeated = registryMutantStandalone(ecoreURI, packages, registeredPackages, localRegisteredPackages, seed, mutator.getModel(), rules, muts, modelFilename, mutFilename, registry, hashsetMutantsBlock, hashmapModelFilenames, k, mutPaths, hashmapMutVersions, "«getProjectName»", serialize, test, classes, «className».class, true);
		   		«ENDIF»
		   		«ELSE»
		   		«IF standalone == false»
					boolean isRepeated = registryMutantWithBlocks(ecoreURI, packages, registeredPackages, localRegisteredPackages, seed, mutator.getModel(), rules, muts, modelFilename, mutFilename, registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "«b.name»", fromNames, k, mutPaths, hashmapMutVersions, project, serialize, test, classes, this.getClass(), true, false);
				«ELSE»
					boolean isRepeated = registryMutantWithBlocksStandalone(ecoreURI, packages, registeredPackages, localRegisteredPackages, seed, mutator.getModel(), rules, muts, modelFilename, mutFilename, registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "«b.name»", fromNames, k, mutPaths, hashmapMutVersions, "«getProjectName»", serialize, test, classes, «className».class, true, false);
				«ENDIF»
				«ENDIF»
					if (isRepeated == false) {
						numMutantsGenerated++;
						monitor.worked(1);
						k[0] = k[0] + 1;
					}
					muts = null;
		«IF mut.container === null»
			}
		«ENDIF»
		«ENDIF»
			}
			//END RETYPE OBJECT «methodName»
	'''

	def modifySourceReferenceMutator(ModifySourceReferenceMutator mut) '''
		//MODIFY SOURCE REFERENCE «methodName»
			«IF mut.source instanceof RandomTypeSelection»
				RandomTypeSelection sourceSelection = new RandomTypeSelection(packages, model, "«(mut.source as RandomTypeSelection).type.name»");
			«ELSEIF mut.source instanceof CompleteTypeSelection»
				List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_«(mut.source as CompleteTypeSelection).type.name» = hmList.get("«(mut.source as CompleteTypeSelection).type.name»");
				List<EObject> objects = new ArrayList<EObject>();
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_«(mut.source as CompleteTypeSelection).type.name») {
					EObject obj = ent.getKey();
					objects.add(obj);
				}
				List<ObSelectionStrategy> listSourceSelection = new ArrayList<ObSelectionStrategy>();
				for (EObject obj : objects) {
					ObSelectionStrategy objectSelection = new SpecificObjectSelection(packages, model, obj);
					listSourceSelection.add(objectSelection);
				}
			«ELSEIF mut.source instanceof SpecificObjectSelection»
				ObSelectionStrategy sourceSelection = null;
				SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.source as SpecificObjectSelection).objSel.name» = hmObjects.get("«(mut.source as SpecificObjectSelection).objSel.name»");
				if (entry_«(mut.source as SpecificObjectSelection).objSel.name» != null) {
					sourceSelection = new SpecificObjectSelection(entry_«(mut.source as SpecificObjectSelection).objSel.name».getValue().getValue(), entry_«(mut.source as SpecificObjectSelection).objSel.name».getValue().getKey(), entry_«(mut.source as SpecificObjectSelection).objSel.name».getKey());
				} else {
					return mutations;
				}
			«ELSE»
				ObSelectionStrategy sourceSelection = new SpecificObjectSelection(packages, model, (EObject) null);
			«ENDIF»
			«IF mut.newSource instanceof RandomTypeSelection»
				RandomTypeSelection newSourceSelection = new RandomTypeSelection(packages, model, "«(mut.newSource as RandomTypeSelection).type.name»");
			«ELSEIF mut.newSource instanceof OtherTypeSelection»
				EObject otherSourceSelection = null; 
				«IF mut.source instanceof CompleteTypeSelection»
					otherSourceSelection = sourceSelection.get(0).getObject();
				«ELSE»
					otherSourceSelection = sourceSelection.getObject();
				«ENDIF»
				Object otherRef = null;
				if (otherSourceSelection != null) {
					for (EReference ref : otherSourceSelection.eClass().getEAllReferences()) {
						if (ref.getName().equals("«mut.refType.name»")) {
							otherRef = otherSourceSelection.eGet(ref);
							break;
						}
					}
				}
				OtherTypeSelection newSourceSelection = new OtherTypeSelection(packages, model, "«(mut.newSource as OtherTypeSelection).type.name»", otherRef);
			«ELSEIF mut.newSource instanceof CompleteTypeSelection»
				«/*THE SAME AS RANDOM*/»
				RandomTypeSelection newSourceSelection = new RandomTypeSelection(packages, model, "«(mut.newSource as CompleteTypeSelection).type.name»");
			«ELSEIF mut.newSource instanceof SpecificObjectSelection»
				ObSelectionStrategy newSourceSelection = null;
				SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.newSource as SpecificObjectSelection).objSel.name» = hmObjects.get("«(mut.newSource as SpecificObjectSelection).objSel.name»");
				if (entry_«(mut.newSource as SpecificObjectSelection).objSel.name» != null) {
					newSourceSelection = new SpecificObjectSelection(entry_«(mut.newSource as SpecificObjectSelection).objSel.name».getValue().getValue(), entry_«(mut.newSource as SpecificObjectSelection).objSel.name».getValue().getKey(), entry_«(mut.newSource as SpecificObjectSelection).objSel.name».getKey());
				} else {
					return mutations;
				}
			«ELSE»
				ObSelectionStrategy newSourceSelection = new SpecificObjectSelection(packages, model, (EObject) null);
			«ENDIF»
			«IF mut.source instanceof CompleteTypeSelection»
				for (ObSelectionStrategy sourceSelection : listSourceSelection) {
					ModifySourceReferenceMutator mut = new ModifySourceReferenceMutator(sourceSelection.getModel(), sourceSelection.getMetaModel(), sourceSelection, newSourceSelection, "«mut.refType.name»");
				   	//INC COUNTER: «nMutation++»
		   			//INC COUNTER: «nRegistryMutation++»
				   	if (mut != null) {
				   		mut.setId("m«nMutation»");
						mutations.add(mut);
					}
				}
			«ELSE»
				ModifySourceReferenceMutator mut = new ModifySourceReferenceMutator(sourceSelection.getModel(), sourceSelection.getMetaModel(), sourceSelection, newSourceSelection, "«mut.refType.name»");
				//INC COUNTER: «nMutation++»
	   			//INC COUNTER: «nRegistryMutation++»
				if (mut != null) {
					mut.setId("m«nMutation»");
					mutations.add(mut);
				}
		«ENDIF»
			//END MODIFY SOURCE REFERENCE «methodName»
	'''
	
	def modifySourceReferenceMutatorExhaustive(ModifySourceReferenceMutator mut) '''
		//MODIFY SOURCE REFERENCE «methodName»
		//END MODIFY SOURCE REFERENCE «methodName»
	'''

	def modifyTargetReferenceMutator(ModifyTargetReferenceMutator mut) '''
		//MODIFY TARGET REFERENCE «methodName»
			«IF mut.source instanceof RandomTypeSelection»
				RandomTypeSelection sourceSelection = new RandomTypeSelection(packages, model, "«(mut.source as RandomTypeSelection).type.name»");			
			«ELSEIF mut.source instanceof CompleteTypeSelection»
				List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_«(mut.source as CompleteTypeSelection).type.name» = hmList.get("«(mut.source as CompleteTypeSelection).type.name»");
				List<EObject> objects = new ArrayList<EObject>();
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_«(mut.source as CompleteTypeSelection).type.name») {
					EObject obj = ent.getKey();
					objects.add(obj);
				}
				List<ObSelectionStrategy> listSourceSelection = new ArrayList<ObSelectionStrategy>();
				for (EObject obj : objects) {
					ObSelectionStrategy objectSelection = new SpecificObjectSelection(packages, model, obj);
					listSourceSelection.add(objectSelection);
				}
			«ELSEIF mut.source instanceof SpecificObjectSelection»
				ObSelectionStrategy sourceSelection = null;
				SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.source as SpecificObjectSelection).objSel.name» = hmObjects.get("«(mut.source as SpecificObjectSelection).objSel.name»");
				if (entry_«(mut.source as SpecificObjectSelection).objSel.name» != null) { 
					sourceSelection = new SpecificObjectSelection(entry_«(mut.source as SpecificObjectSelection).objSel.name».getValue().getValue(), entry_«(mut.source as SpecificObjectSelection).objSel.name».getValue().getKey(), entry_«(mut.source as SpecificObjectSelection).objSel.name».getKey());
				} else {
					return mutations;
				}
			«ELSE»
				ObSelectionStrategy sourceSelection = new SpecificObjectSelection(packages, model, (EObject) null);
			«ENDIF»
			«IF mut.newTarget instanceof RandomTypeSelection»
				RandomTypeSelection newTargetSelection = new RandomTypeSelection(packages, model, "«(mut.newTarget as RandomTypeSelection).type.name»");
			«ELSEIF mut.newTarget instanceof OtherTypeSelection»
				EObject otherSourceSelection = null; 
				«IF mut.source instanceof CompleteTypeSelection»
					otherSourceSelection = sourceSelection.get(0).getObject();
				«ELSE»
					otherSourceSelection = sourceSelection.getObject();
				«ENDIF»
				Object otherRef = null;
				if (otherSourceSelection != null) {
					for (EReference ref : otherSourceSelection.eClass().getEAllReferences()) {
						if (ref.getName().equals("«mut.refType.name»")) {
							otherRef = otherSourceSelection.eGet(ref);
							break;
						}
					}
				}
				OtherTypeSelection newTargetSelection = new OtherTypeSelection(packages, model, "«(mut.newTarget as OtherTypeSelection).type.name»", otherRef);
			«ELSEIF mut.newTarget instanceof CompleteTypeSelection»
				RandomTypeSelection newTargetSelection = new RandomTypeSelection(packages, model, "«(mut.newTarget as CompleteTypeSelection).type.name»");			
			«ELSEIF mut.newTarget instanceof SpecificObjectSelection»
				ObSelectionStrategy newTargetSelection = null;
				SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.newTarget as SpecificObjectSelection).objSel.name» = hmObjects.get("«(mut.newTarget as SpecificObjectSelection).objSel.name»");
				if (entry_«(mut.newTarget as SpecificObjectSelection).objSel.name» != null) {
					newTargetSelection = new SpecificObjectSelection(entry_«(mut.newTarget as SpecificObjectSelection).objSel.name».getValue().getValue(), entry_«(mut.newTarget as SpecificObjectSelection).objSel.name».getValue().getKey(), entry_«(mut.newTarget as SpecificObjectSelection).objSel.name».getKey());
				} else {
					return mutations;
				}
			«ELSE»
				ObSelectionStrategy newTargetSelection = new SpecificObjectSelection(packages, model, (EObject) null);
			«ENDIF»
			«IF mut.source instanceof CompleteTypeSelection»
				for (ObSelectionStrategy sourceSelection : listSourceSelection) {
					mutations.add(ModifyTargetReferenceMutator(sourceSelection.getModel(), sourceSelection.getMetaModel(), sourceSelection, newTargetSelection, "«mut.refType.name»"));
				}
   			«ELSE»
				ModifyTargetReferenceMutator mut = new ModifyTargetReferenceMutator(sourceSelection.getModel(), sourceSelection.getMetaModel(), sourceSelection, newTargetSelection, "«mut.refType.name»");
				//INC COUNTER: «nMutation++»
	   			//INC COUNTER: «nRegistryMutation++»
				if (mut != null) {
					mut.setId("m«nMutation»");
					mutations.add(mut);
				}
	«ENDIF»
	//END MODIFY TARGET REFERENCE «methodName»
	'''

	def modifyTargetReferenceMutatorExhaustive(ModifyTargetReferenceMutator mut) '''
		//MODIFY TARGET REFERENCE «methodName»
		//END MODIFY TARGET REFERENCE «methodName»
	'''
	
	def createReferenceMutator(CreateReferenceMutator mut) '''
		//CREATE REFERENCE «methodName»
			«IF mut.source instanceof RandomTypeSelection»
				RandomTypeSelection sourceSelection = new RandomTypeSelection(sourceSelection.getMetaModel(), sourceSelection.getModel(), "«(mut.source as RandomTypeSelection).type.name»");
			«ELSEIF mut.source instanceof CompleteTypeSelection»
				RandomTypeSelection sourceSelection = new RandomTypeSelection(sourceSelection.getMetaModel(), sourceSelection.getModel(), "«(mut.source as CompleteTypeSelection).type.name»");
			«ELSEIF mut.source instanceof SpecificObjectSelection»
				ObSelectionStrategy sourceSelection = null;
				SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.source as SpecificObjectSelection).objSel.name» = hmObjects.get("«(mut.source as SpecificObjectSelection).objSel.name»");
				if (entry_«(mut.source as SpecificObjectSelection).objSel.name» != null) {
					sourceSelection = new SpecificObjectSelection(entry_«(mut.source as SpecificObjectSelection).objSel.name».getValue().getValue(), entry_«(mut.source as SpecificObjectSelection).objSel.name».getValue().getKey(), entry_«(mut.source as SpecificObjectSelection).objSel.name».getKey());
				} else {
					return mutations;
				}
			«ELSE»
				ObSelectionStrategy sourceSelection = new SpecificObjectSelection(packages, model, (EObject) null);
			«ENDIF»
			«IF mut.target instanceof RandomTypeSelection»
				RandomTypeSelection targetSelection = new RandomTypeSelection(packages, model, "«(mut.target as RandomTypeSelection).type.name»");			
			«ELSEIF mut.target instanceof CompleteTypeSelection»
				RandomTypeSelection targetSelection = new RandomTypeSelection(packages, model, "«(mut.target as CompleteTypeSelection).type.name»");
			«ELSEIF mut.target instanceof SpecificObjectSelection»
				ObSelectionStrategy targetSelection = null;
				SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.target as SpecificObjectSelection).objSel.name» = hmObjects.get("«(mut.target as SpecificObjectSelection).objSel.name»");
				if (entry_«(mut.target as SpecificObjectSelection).objSel.name» != null) {
					targetSelection = new SpecificObjectSelection(entry_«(mut.target as SpecificObjectSelection).objSel.name».getValue().getValue(), entry_«(mut.target as SpecificObjectSelection).objSel.name».getValue().getKey(), entry_«(mut.target as SpecificObjectSelection).objSel.name».getKey());
				} else {
					return mutations;
				}
			«ELSE»
				ObSelectionStrategy targetSelection = new SpecificObjectSelection(packages, model, (EObject) null);
			«ENDIF»
			CreateReferenceMutator mut = new CreateReferenceMutator(sourceSelection.getModel(), sourceSelection.getMetaModel(), sourceSelection, targetSelection, "«mut.refType.name»");
		   	//INC COUNTER: «nMutation++»
   			//INC COUNTER: «nRegistryMutation++»
		   	if (mut != null) {
		   		mut.setId("m«nMutation»");
				mutations.add(mut);
			}
			//END CREATE REFERENCE «methodName»
	'''
	
	def createReferenceMutatorExhaustive(CreateReferenceMutator mut) '''
		//CREATE REFERENCE «methodName»
		//END CREATE REFERENCE «methodName»
	'''

	def removeObjectMutator(RemoveObjectMutator mut) '''
			// REMOVE OBJECT «methodName»
			ObSelectionStrategy containerSelection = null;
			SpecificReferenceSelection referenceSelection = null;
			List<String> mutTypes = new ArrayList<String>();
			«IF mut.object instanceof RandomTypeSelection»
			//«var RandomTypeSelection selection = mut.object as RandomTypeSelection»
			«IF selection.types !== null && selection.types.size > 0»
			«FOR EClass type : selection.types»
			mutTypes.add("«type.name»");
			«ENDFOR»
			«ELSEIF selection.type !== null»
			mutTypes.add("«selection.type.name»");
			«ENDIF»
			«ELSEIF mut.object instanceof CompleteTypeSelection»
			//«var CompleteTypeSelection selection = mut.object as CompleteTypeSelection»
			«IF selection.types !== null && selection.types.size > 0»
			«FOR EClass type : selection.types»
			mutTypes.add("«type.name»");
			«ENDFOR»
			«ELSEIF selection.type !== null»
			mutTypes.add("«selection.type.name»");
			«ENDIF»
			«ENDIF»
			//«var boolean rts = false»
			«IF mut.object instanceof RandomTypeSelection || mut.object instanceof CompleteTypeSelection»
				«IF mut.container === null»
				«IF mut.object instanceof RandomTypeSelection»
				//«rts = true»
				RandomTypeSelection rts = new RandomTypeSelection(packages, model, mutTypes, mutatedObjects);
				«ENDIF»
				«IF mut.object instanceof CompleteTypeSelection»
				//«rts = true»
				RandomTypeSelection rts = new RandomTypeSelection(packages, model, mutTypes, mutatedObjects);
				«ENDIF»
				«ELSE»
					«IF mut.container instanceof RandomTypeSelection»
						//«rts = true»
						RandomTypeSelection rts = new RandomTypeSelection(packages, model, "«(mut.container as RandomTypeSelection).type.name»");
						EObject container = rts.getObject();
						containerSelection = new SpecificObjectSelection(packages, model, container);
						«IF mut.container.refType !== null»
							referenceSelection = new SpecificReferenceSelection(packages, model, "«mut.container.refType.name»", containerSelection);
						«ELSE»
							referenceSelection = new SpecificReferenceSelection(packages, model, null, null);
						«ENDIF»
					«ELSEIF mut.container instanceof CompleteTypeSelection»
						«/* THE SAME AS RANDOM */»
						//«rts = true»
						RandomTypeSelection rts = new RandomTypeSelection(packages, model, "«(mut.container as CompleteTypeSelection).type.name»");
						EObject container = rts.getObject();
						containerSelection = new SpecificObjectSelection(packages, model, container);
						«IF mut.container.refType !== null»
							referenceSelection = new SpecificReferenceSelection(packages, model, "«mut.container.refType.name»", containerSelection);
						«ELSE»
							referenceSelection = new SpecificReferenceSelection(packages, model, null, null);
						«ENDIF»
					«ELSEIF mut.container instanceof SpecificObjectSelection»
						SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.container as SpecificObjectSelection).objSel.name» = hmObjects.get("«(mut.container as SpecificObjectSelection).objSel.name»");
						if (entry_«(mut.container as SpecificObjectSelection).objSel.name» != null) {
							containerSelection = new SpecificObjectSelection(entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getValue(), entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getKey(), entry_«(mut.container as SpecificObjectSelection).objSel.name».getKey());
						} else {
							return mutations;
						}
						«IF mut.container.refType !== null»
							if (entry_«(mut.container as SpecificObjectSelection).objSel.name» != null) {
								referenceSelection = new SpecificReferenceSelection(entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getValue(), entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getKey(), "«mut.container.refType.name»", entry_«(mut.container as SpecificObjectSelection).objSel.name».getKey());
							} else {
								return mutations;
							}
						«ELSE»
							referenceSelection = new SpecificReferenceSelection(packages, model, null, null);
						«ENDIF»
					«ENDIF»
					«IF rts == true»
					rts = new RandomTypeSelection(containerSelection.getMetaModel(), containerSelection.getModel(), mutTypes, referenceSelection, containerSelection);
					«ELSE»
					RandomTypeSelection rts = new RandomTypeSelection(containerSelection.getMetaModel(), containerSelection.getModel(), mutTypes, referenceSelection, containerSelection);
					«ENDIF»
					«IF ((mut.object.expression === null) && (mut.container.expression === null))»
						EObject object = rts.getObject();
					«ENDIF»	
				«ENDIF»
				«IF ((mut.object.expression === null) && (mut.container === null))»
				«IF mut.object instanceof RandomTypeSelection»
					EObject object = rts.getObject();
				«ENDIF»
				«IF mut.object instanceof CompleteTypeSelection»
					List<EObject> objects = rts.getObjects();
				«ENDIF»
				«ENDIF»
				«IF mut.object.refType !== null»
				Object o = object.eGet("«mut.object.refType»");
				if (o instanceof EObject) {
					object = (EObject) o;
				}
				if (o instanceof List<?>) {
					object = ((List<EObject) o).get(ModelManager.getRandomIndex((List<EObject) o));
				}
				«ENDIF»
				«IF mut.object.expression !== null»
					«IF mut.container === null»
					List<EObject> objects = rts.getObjects();
					//EXPRESSION LIST: «expressionList = new ArrayList<Integer>()»
					//EXPRESSION LEVEL: «nExpression = 0»
					//EXPRESSION LEVEL: «expressionList.add(0)»
					Expression exp«expressionList.get(0)» = new Expression();
   					«mut.object.expression.method(0)»
					List<EObject> selectedObjects = evaluate(objects, exp«expressionList.get(0)»);
					«IF mut.object instanceof RandomTypeSelection»
					EObject object = null;
					if (selectedObjects.size() > 0) {
						object = selectedObjects.get(ModelManager.getRandomIndex(selectedObjects));
					}
					«ENDIF»
					«IF mut.object instanceof CompleteTypeSelection»
					objects = selectedObjects;
					«ENDIF»
					«ELSEIF mut.container.expression === null»
					List<EObject> objects = rts.getObjects();
					//EXPRESSION LIST: «expressionList = new ArrayList<Integer>()»
					//EXPRESSION LEVEL: «nExpression = 0»
					//EXPRESSION LEVEL: «expressionList.add(0)»
					Expression exp«expressionList.get(0)» = new Expression();
					«mut.object.expression.method(0)»
					List<EObject> selectedObjects = evaluate(objects, exp«expressionList.get(0)»);
					«IF mut.object instanceof RandomTypeSelection»
					EObject object = null;
					if (selectedObjects.size() > 0) {
						object = selectedObjects.get(ModelManager.getRandomIndex(selectedObjects));
					}
					«ENDIF»
					«IF mut.object instanceof CompleteTypeSelection»
					objects = selectedObjects;
					«ENDIF»
					«ENDIF»
				«ENDIF»
				«IF (mut.object.expression === null)»
					«IF ((mut.container !== null) && (mut.container.expression !== null))»
					List<EObject> objects = rts.getObjects();
					//EXPRESSION LIST: «expressionList = new ArrayList<Integer>()»
					//EXPRESSION LEVEL: «nExpression = 0»
					//EXPRESSION LEVEL: «expressionList.add(0)»
					Expression exp«expressionList.get(0)» = new Expression();
					«mut.container.expression.method(0)»
					List<EObject> selectedObjects = evaluate(objects, exp«expressionList.get(0)»);
					«IF mut.object instanceof RandomTypeSelection»
					EObject object = null;
					if (selectedObjects.size() > 0) {
						object = selectedObjects.get(ModelManager.getRandomIndex(selectedObjects));
					}
					«ENDIF»
					«IF mut.object instanceof CompleteTypeSelection»
					objects = selectedObjects;
					«ENDIF»
					«ENDIF»
				«ENDIF»
				«IF mut.object instanceof RandomTypeSelection»
				ObSelectionStrategy objectSelection = null; 
				if (object != null) {
					objectSelection = new SpecificObjectSelection(packages, model, object);
				}
				«ENDIF»
				«ELSEIF mut.object instanceof SpecificObjectSelection»
				«IF mut.container === null»
				ObSelectionStrategy objectSelection = null;
				SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.object as SpecificObjectSelection).objSel.name» = hmObjects.get("«(mut.object as SpecificObjectSelection).objSel.name»");
				if (entry_«(mut.object as SpecificObjectSelection).objSel.name» != null) {
					objectSelection = new SpecificObjectSelection(entry_«(mut.object as SpecificObjectSelection).objSel.name».getValue().getValue(), entry_«(mut.object as SpecificObjectSelection).objSel.name».getValue().getKey(), entry_«(mut.object as SpecificObjectSelection).objSel.name».getKey());
				} else {
					return mutations;
				}
				«ELSE»
				«IF mut.container instanceof RandomTypeSelection»
					RandomTypeSelection rts = new RandomTypeSelection(packages, model, "«(mut.container as RandomTypeSelection).type.name»");
					EObject container = rts.getObject();
					containerSelection = new SpecificObjectSelection(packages, model, container);
				«IF mut.container.refType !== null»
					referenceSelection = new SpecificReferenceSelection(packages, model, "«mut.container.refType.name»", containerSelection);
				«ELSE»
					referenceSelection = new SpecificReferenceSelection(packages, model, null, null);
				«ENDIF»
				«ELSEIF mut.container instanceof CompleteTypeSelection»
					«/* THE SAME AS RANDOM */»
					RandomTypeSelection rts = new RandomTypeSelection(packages, model, "«(mut.container as CompleteTypeSelection).type.name»");
					EObject container = rts.getObject();
					containerSelection = new SpecificObjectSelection(packages, model, container);
				«IF mut.container.refType !== null»
					referenceSelection = new SpecificReferenceSelection(packages, model, "«mut.container.refType.name»", containerSelection);
				«ELSE»
					referenceSelection = new SpecificReferenceSelection(packages, model, null, null);
				«ENDIF»
				«ELSEIF mut.container instanceof SpecificObjectSelection»
					SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.container as SpecificObjectSelection).objSel.name» = hmObjects.get("«(mut.container as SpecificObjectSelection).objSel.name»");
					if (entry_«(mut.container as SpecificObjectSelection).objSel.name» != null) {
						containerSelection = new SpecificObjectSelection(entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getValue(), entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getKey(), entry_«(mut.container as SpecificObjectSelection).objSel.name».getKey());
					} else {
						return mutations;
					}
				«IF mut.container.refType !== null»
					SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.container as SpecificObjectSelection).objSel.name» = hmObjects.get("«(mut.container as SpecificObjectSelection).objSel.name»");
					if (entry_«(mut.container as SpecificObjectSelection).objSel.name» != null) {
						referenceSelection = new SpecificReferenceSelection(entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getValue(), entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getKey(), "«mut.container.refType.name»", entry_«(mut.container as SpecificObjectSelection).objSel.name».getKey());
					} else {
						return mutations;
					}
				«ELSE»
					referenceSelection = new SpecificReferenceSelection(packages, model, null, null);
				«ENDIF»
				«ELSEIF mut.container instanceof SpecificClosureSelection»
					SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.container as SpecificClosureSelection).objSel.name» = hmObjects.get("«(mut.container as SpecificClosureSelection).objSel.name»");
					if (entry_«(mut.container as SpecificClosureSelection).objSel.name» != null) {
						containerSelection = new SpecificClosureSelection(entry_«(mut.container as SpecificClosureSelection).objSel.name».getValue().getValue(), entry_«(mut.container as SpecificClosureSelection).objSel.name».getValue().getKey(), entry_«(mut.container as SpecificClosureSelection).objSel.name».getKey(), "«(mut.container as SpecificClosureSelection).refType.name»");
					} else {
						return mutations;
					}
				«IF mut.container.refType !== null»
					if (entry_«(mut.container as SpecificClosureSelection).objSel.name» != null) {
						referenceSelection = new SpecificReferenceSelection(entry_«(mut.container as SpecificClosureSelection).objSel.name».getValue().getValue(), entry_«(mut.container as SpecificClosureSelection).objSel.name».getValue().getKey(), "«mut.container.refType.name»", entry_«(mut.container as SpecificClosureSelection).objSel.name».getKey());
					} else {
						return mutations;
					}
				«ELSE»
					referenceSelection = new SpecificReferenceSelection(packages, model, null, null);
				«ENDIF»
				«ENDIF»
				ObSelectionStrategy objectSelection = null;
				SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.object as SpecificObjectSelection).objSel.name» = hmObjects.get("«(mut.object as SpecificObjectSelection).objSel.name»");
				if (entry_«(mut.object as SpecificObjectSelection).objSel.name» != null) {
					objectSelection = new SpecificObjectSelection(entry_«(mut.object as SpecificObjectSelection).objSel.name».getValue().getValue(), entry_«(mut.object as SpecificObjectSelection).objSel.name».getValue().getKey(), entry_«(mut.object as SpecificObjectSelection).objSel.name».getKey(), referenceSelection, containerSelection);
				} else {
					return mutations;
				}
				«ENDIF»
				«ELSEIF mut.object instanceof CompleteTypeSelection»
					«IF mut.object.expression === null»
						CompleteTypeSelection objectsSelection = new CompleteTypeSelection(packages, model, "«(mut.object as CompleteTypeSelection).type.name»");
						List<EObject> objects = objectsSelection.getObjects();
					«ELSE»
						List<EObject> objects = selectedObjects;
					«ENDIF»
				«ENDIF»
				«IF mut.object instanceof CompleteTypeSelection»
					if (objects != null) {
						for (EObject obj : objects) {
							if (mutatedObjects != null) {
								mutatedObjects.add(obj);
							}
							RemoveObjectMutator mut = new RemoveObjectMutator(model, packages, obj, referenceSelection, containerSelection);
					   		//INC COUNTER: «nMutation++»
				   			//INC COUNTER: «nRegistryMutation++»
					   		if (mut != null) {
					   			mut.setId("m«nMutation»");
								mutations.add(mut);
							}
						}
					}
				«ELSE»
					RemoveObjectMutator mut = null;
					if (objectSelection != null) {
						if (mutatedObjects != null) {
							mutatedObjects.add(objectSelection.getObject());
						}
						mut = new RemoveObjectMutator(objectSelection.getModel(), objectSelection.getMetaModel(), objectSelection, referenceSelection, containerSelection);
					}
					//INC COUNTER: «nMutation++»
		   			//INC COUNTER: «nRegistryMutation++»
					if (mut != null) {
				   		mut.setId("m«nMutation»");
						mutations.add(mut);
					}
			«ENDIF»
		//END REMOVE OBJECT «methodName»
	'''

	def removeObjectMutatorExhaustive(RemoveObjectMutator mut, MutatorEnvironment e, Block b, boolean last) '''
		// REMOVE OBJECT «methodName»
			ObSelectionStrategy containerSelection = null;
			SpecificReferenceSelection referenceSelection = null;
			//«var boolean rts = false»
			«IF mut.object instanceof RandomTypeSelection || mut.object instanceof CompleteTypeSelection»
				«IF mut.container === null»
				«IF mut.object instanceof RandomTypeSelection»
				//«rts = true»
				RandomTypeSelection rts = new RandomTypeSelection(packages, model, "«(mut.object as RandomTypeSelection).type.name»", mutatedObjects);
				«ENDIF»
				«IF mut.object instanceof CompleteTypeSelection»
				//«rts = true»
				RandomTypeSelection rts = new RandomTypeSelection(packages, model, "«(mut.object as CompleteTypeSelection).type.name»", mutatedObjects);
				«ENDIF»
				«ELSE»
					«IF mut.container instanceof RandomTypeSelection»
						//«rts = true»
						RandomTypeSelection rts = new RandomTypeSelection(packages, model, "«(mut.container as RandomTypeSelection).type.name»");
						EObject container = rts.getObject();
						containerSelection = new SpecificObjectSelection(packages, model, container);
						«IF mut.container.refType !== null»
							referenceSelection = new SpecificReferenceSelection(packages, model, "«mut.container.refType.name»", containerSelection);
						«ELSE»
							referenceSelection = new SpecificReferenceSelection(packages, model, null, null);
						«ENDIF»
					«ELSEIF mut.container instanceof CompleteTypeSelection»
						«/* THE SAME AS RANDOM */»
						//«rts = true»
						RandomTypeSelection rts = new RandomTypeSelection(packages, model, "«(mut.container as CompleteTypeSelection).type.name»");
						EObject container = rts.getObject();
						containerSelection = new SpecificObjectSelection(packages, model, container);
						«IF mut.container.refType !== null»
							referenceSelection = new SpecificReferenceSelection(packages, model, "«mut.container.refType.name»", containerSelection);
						«ELSE»
							referenceSelection = new SpecificReferenceSelection(packages, model, null, null);
						«ENDIF»
					«ELSEIF mut.container instanceof SpecificObjectSelection»
						SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.container as SpecificObjectSelection).objSel.name» = hmObjects.get("«(mut.container as SpecificObjectSelection).objSel.name»");
						if (entry_«(mut.container as SpecificObjectSelection).objSel.name» != null) {
							EObject recovered = ModelManager.getObject(model, entry_«(mut.container as SpecificObjectSelection).objSel.name».getKey());
							if (recovered == null) {
								recovered = entry_«(mut.container as SpecificObjectSelection).objSel.name».getKey();
							}
							containerSelection = new SpecificObjectSelection(packages, model, recovered);
						} else {
							return numMutantsGenerated;
						}
						«IF mut.container.refType !== null»
							if (entry_«(mut.container as SpecificObjectSelection).objSel.name» != null) {
								EObject recovered = ModelManager.getObject(model, entry_«(mut.container as SpecificObjectSelection).objSel.name».getKey());
								if (recovered == null) {
									recovered = entry_«(mut.container as SpecificObjectSelection).objSel.name».getKey();
								}
								referenceSelection = new SpecificReferenceSelection(packages, model, "«mut.container.refType.name»", recovered);
							} else {
								return numMutantsGenerated;
							}
						«ELSE»
							referenceSelection = new SpecificReferenceSelection(packages, model, null, null);
						«ENDIF»
					«ENDIF»
					«IF rts == true»
					rts = new RandomTypeSelection(containerSelection.getMetaModel(), containerSelection.getModel(), "«(mut.object as RandomTypeSelection).type.name»", referenceSelection, containerSelection);
					«ELSE»
					RandomTypeSelection rts = new RandomTypeSelection(containerSelection.getMetaModel(), containerSelection.getModel(), "«(mut.object as RandomTypeSelection).type.name»", referenceSelection, containerSelection);
					«ENDIF»
					«IF ((mut.object.expression === null) && (mut.container.expression === null))»
						List<EObject> objects = rts.getObjects();
					«ENDIF»
				«ENDIF»
				«IF ((mut.object.expression === null) && (mut.container === null))»
					List<EObject> objects = rts.getObjects();
				«ENDIF»
				«IF mut.object.expression !== null»
					«IF mut.container === null»
					List<EObject> objects = rts.getObjects();
					//EXPRESSION LIST: «expressionList = new ArrayList<Integer>()»
					//EXPRESSION LEVEL: «nExpression = 0»
					//EXPRESSION LEVEL: «expressionList.add(0)»
					Expression exp«expressionList.get(0)» = new Expression();
   					«mut.object.expression.method(0)»
					objects = evaluate(objects, exp«expressionList.get(0)»);
					«ELSEIF mut.container.expression === null»
					List<EObject> objects = rts.getObjects();
					//EXPRESSION LIST: «expressionList = new ArrayList<Integer>()»
					//EXPRESSION LEVEL: «nExpression = 0»
					//EXPRESSION LEVEL: «expressionList.add(0)»
					Expression exp«expressionList.get(0)» = new Expression();
					«mut.object.expression.method(0)»
					objects = evaluate(objects, exp«expressionList.get(0)»);
					«ENDIF»
				«ENDIF»
				«IF (mut.object.expression === null)»
					«IF ((mut.container !== null) && (mut.container.expression !== null))»
					List<EObject> objects = rts.getObjects();
					//EXPRESSION LIST: «expressionList = new ArrayList<Integer>()»
					//EXPRESSION LEVEL: «nExpression = 0»
					//EXPRESSION LEVEL: «expressionList.add(0)»
					Expression exp«expressionList.get(0)» = new Expression();
					«mut.container.expression.method(0)»
					objects = evaluate(objects, exp«expressionList.get(0)»);
					«ENDIF»
				«ENDIF»
				«ELSEIF mut.object instanceof SpecificObjectSelection»
				List<EObject> objects = new ArrayList<EObject>();
				«IF mut.container === null»
				ObSelectionStrategy objectSelection = null;
				SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.object as SpecificObjectSelection).objSel.name» = hmObjects.get("«(mut.object as SpecificObjectSelection).objSel.name»");
				if (entry_«(mut.object as SpecificObjectSelection).objSel.name» != null) {
					EObject recovered = ModelManager.getObject(model, entry_«(mut.object as SpecificObjectSelection).objSel.name».getKey());
					if (recovered == null) {
						recovered = entry_«(mut.object as SpecificObjectSelection).objSel.name».getKey();
					}
					objectSelection = new SpecificObjectSelection(packages, model, recovered);
					objects.add(objectSelection.getObject());
				} else {
					return numMutantsGenerated;
				}
				«ELSE»
				«IF mut.container instanceof RandomTypeSelection»
					RandomTypeSelection rts = new RandomTypeSelection(packages, model, "«(mut.container as RandomTypeSelection).type.name»");
					EObject container = rts.getObject();
					containerSelection = new SpecificObjectSelection(packages, model, container);
				«IF mut.container.refType !== null»
					referenceSelection = new SpecificReferenceSelection(packages, model, "«mut.container.refType.name»", containerSelection);
				«ELSE»
					referenceSelection = new SpecificReferenceSelection(packages, model, null, null);
				«ENDIF»
				«ELSEIF mut.container instanceof CompleteTypeSelection»
					«/* THE SAME AS RANDOM */»
					RandomTypeSelection rts = new RandomTypeSelection(packages, model, "«(mut.container as CompleteTypeSelection).type.name»");
					EObject container = rts.getObject();
					containerSelection = new SpecificObjectSelection(packages, model, container);
				«IF mut.container.refType !== null»
					referenceSelection = new SpecificReferenceSelection(packages, model, "«mut.container.refType.name»", containerSelection);
				«ELSE»
					referenceSelection = new SpecificReferenceSelection(packages, model, null, null);
				«ENDIF»
				«ELSEIF mut.container instanceof SpecificObjectSelection»
					SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.container as SpecificObjectSelection).objSel.name» = hmObjects.get("«(mut.container as SpecificObjectSelection).objSel.name»");
					if (entry_«(mut.container as SpecificObjectSelection).objSel.name» != null) {
						EObject recovered = ModelManager.getObject(model, entry_«(mut.container as SpecificObjectSelection).objSel.name».getKey());
						if (recovered == null) {
							recovered = entry_«(mut.container as SpecificObjectSelection).objSel.name».getKey();
						}
						containerSelection = new SpecificObjectSelection(packages, model, recovered);
					} else {
						return numMutantsGenerated;
					}
				«IF mut.container.refType !== null»
					SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.container as SpecificObjectSelection).objSel.name» = hmObjects.get("«(mut.container as SpecificObjectSelection).objSel.name»");
					if (entry_«(mut.container as SpecificObjectSelection).objSel.name» != null) {
						EObject recovered = ModelManager.getObject(model, entry_«(mut.container as SpecificObjectSelection).objSel.name».getKey());
						if (recovered == null) {
							recovered = entry_«(mut.container as SpecificObjectSelection).objSel.name».getKey();
						}
						referenceSelection = new SpecificReferenceSelection(packages, model, "«mut.container.refType.name»", recovered);
					} else {
						return numMutantsGenerated;
					}
				«ELSE»
					referenceSelection = new SpecificReferenceSelection(packages, model, null, null);
				«ENDIF»
				«ELSEIF mut.container instanceof SpecificClosureSelection»
					SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.container as SpecificClosureSelection).objSel.name» = hmObjects.get("«(mut.container as SpecificClosureSelection).objSel.name»");
					if (entry_«(mut.container as SpecificClosureSelection).objSel.name» != null) {
						EObject recovered = ModelManager.getObject(model, entry_«(mut.container as SpecificClosureSelection).objSel.name».getKey());
						if (recovered == null) {
							recovered = entry_«(mut.container as SpecificClosureSelection).objSel.name».getKey();
						}
						containerSelection = new SpecificClosureSelection(packages, model, recovered, "«(mut.container as SpecificClosureSelection).refType.name»");
					} else {
						return numMutantsGenerated;
					}
				«IF mut.container.refType !== null»
					if (entry_«(mut.container as SpecificClosureSelection).objSel.name» != null) {
						EObject recovered = ModelManager.getObject(model, entry_«(mut.container as SpecificClosureSelection).objSel.name».getKey());
						if (recovered == null) {
							recovered = entry_«(mut.container as SpecificClosureSelection).objSel.name».getKey();
						}
						referenceSelection = new SpecificReferenceSelection(packages, model, "«mut.container.refType.name»", recovered);
					} else {
						return numMutantsGenerated;
					}
				«ELSE»
					referenceSelection = new SpecificReferenceSelection(packages, model, null, null);
				«ENDIF»
				«ENDIF»
				ObSelectionStrategy objectSelection = null;
				SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.object as SpecificObjectSelection).objSel.name» = hmObjects.get("«(mut.object as SpecificObjectSelection).objSel.name»");
				if (entry_«(mut.object as SpecificObjectSelection).objSel.name» != null) {
					EObject recovered = ModelManager.getObject(model, entry_«(mut.container as SpecificObjectSelection).objSel.name».getKey());
					if (recovered == null) {
						recovered = entry_«(mut.container as SpecificObjectSelection).objSel.name».getKey();
					}
					objectSelection = new SpecificObjectSelection(packages, model, recovered, referenceSelection, containerSelection);
					objects.add(objectSelection.getObject());
				} else {
					return numMutantsGenerated;
				}
				«ENDIF»
			«ENDIF»
			for (EObject object : objects) {
				«IF standalone == false»
				String modelsFolder = ModelManager.getModelsFolder(this.getClass());
				«ELSE»
				String modelsFolder = ModelManager.getModelsFolder(«className».class);
				«ENDIF»
				String tempModelsFolder = modelsFolder.replace(modelsFolder.indexOf("/") > 0 ? modelsFolder.substring(modelsFolder.indexOf("/") + 1, modelsFolder.length()) : modelsFolder, "temp");
				modelsFolder = modelsFolder.replace("/", "\\"); 
				tempModelsFolder = tempModelsFolder.replace("/", "\\");
				Resource resource = ModelManager.cloneModel(model, model.getURI().toFileString().replace(modelsFolder + "\\", tempModelsFolder + "\\").replace(".model", ".«methodName»." + numMutantsGenerated +".model"));
				ObSelectionStrategy obSelection = null;
				«IF mut.object.refType !== null»
				List<EObject> o = ModelManager.getReferences("«mut.object.refType.name»", object);
				object = o.get(ModelManager.getRandomIndex(o));
				«ENDIF»
				object = ModelManager.getObjectByURIEnding(resource, EcoreUtil.getURI(object));
				if (object != null) {
					obSelection = new SpecificObjectSelection(packages, resource, object);
					
					RemoveObjectMutator mut = new RemoveObjectMutator(obSelection.getModel(), obSelection.getMetaModel(), object, referenceSelection, containerSelection);
					Mutator mutator = null;
					if (muts == null) {
						muts = AppliedMutationsFactory.eINSTANCE.createMutations();
					}
		//COUNTER: «nRegistryMutation = nRegistryMutation + 1»
		//COUNTER: «nRegistryMethodCall = nRegistryMethodCall + 1»
		//REGISTRY METHOD NAME:«registryMethodName = "registry" + nRegistryMethodCall.toString()»
		«IF executeMutation == true»
			if (mut != null) {
				Object mutated = mut.mutate();
					if (mutated != null) {
						AppMutation appMut = «registryMethodName»(mut, hmMutator, seed, mutPaths, packages);
						if (appMut != null) {
							muts.getMuts().add(appMut);
						}
					}
				}
				«ENDIF»
				mutator = mut;
				if (mutator != null) {
				//«nMethodCall = nMethodCall + 1»
				«IF last == false»
				«IF standalone == false»
				mutation«nMethodCall»(packages, obSelection.getModel(), hmObjects, hmList, hashmapModelFilenames,
									modelFilename, mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,
									registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, project, monitor, k, serialize, test, classes);
				«ELSE»
				mutation«nMethodCall»(packages, obSelection.getModel(), hmObjects, hmList, hashmapModelFilenames,
									modelFilename, mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,
									registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, monitor, k, serialize, test, classes);
				«ENDIF»
				numMutantsGenerated = k[0];
				}
				«ENDIF»
				«IF last == true»
				// MUTANT COMPLETION AND REGISTRY
				Map<String, List<String>> rules = new HashMap<String, List<String>>();
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
				«IF b === null»
				String mutFilename = hashmapModelFilenames.get(modelFilename) + "/" + "Output" + k[0] + ".model";
				«ELSE»
		   		«IF b.from.size == 0»
					String mutFilename = hashmapModelFilenames.get(modelFilename) + "/«b.name»/Output" + k[0] + ".model";
		   		«ELSE»
					String mutFilename = hashmapModelFilenames.get(modelFilename) + "/«b.name»/" + hashmapModelFolders.get(modelFilename) + "/Output" + k[0] + ".model";
		   		«ENDIF»
		   		«ENDIF»
		   		«IF b === null»
		   		«IF standalone == false»
		   			boolean isRepeated = registryMutant(ecoreURI, packages, registeredPackages, localRegisteredPackages, seed, mutator.getModel(), rules, muts, modelFilename, mutFilename, registry, hashsetMutantsBlock, hashmapModelFilenames, k, mutPaths, hashmapMutVersions, project, serialize, test, classes, this.getClass(), true, true);
		   		«ELSE»
		   			boolean isRepeated = registryMutantStandalone(ecoreURI, packages, registeredPackages, localRegisteredPackages, seed, mutator.getModel(), rules, muts, modelFilename, mutFilename, registry, hashsetMutantsBlock, hashmapModelFilenames, k, mutPaths, hashmapMutVersions, "«getProjectName»", serialize, test, classes, «className».class, true, true);
		   		«ENDIF»
		   		«ELSE»
		   		«IF standalone == false»
					boolean isRepeated = registryMutantWithBlocks(ecoreURI, packages, registeredPackages, localRegisteredPackages, seed, mutator.getModel(), rules, muts, modelFilename, mutFilename, registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "«b.name»", fromNames, k, mutPaths, hashmapMutVersions, project, serialize, test, classes, this.getClass(), true, false);
				«ELSE»
					boolean isRepeated = registryMutantWithBlocksStandalone(ecoreURI, packages, registeredPackages, localRegisteredPackages, seed, mutator.getModel(), rules, muts, modelFilename, mutFilename, registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "«b.name»", fromNames, k, mutPaths, hashmapMutVersions, "«getProjectName»", serialize, test, classes, «className».class, true, false);
				«ENDIF»
				«ENDIF»
					if (isRepeated == false) {
						numMutantsGenerated++;
						monitor.worked(1);
						k[0] = k[0] + 1;
					}
					muts = null;
				}
		«ENDIF»
				}
		}
		//END REMOVE OBJECT «methodName»
	'''
	
	def removeRandomReferenceMutator(RemoveRandomReferenceMutator mut) '''
		// REMOVE RANDOM REFERENCE «methodName»
			RandomTypeSelection containerSelection = new RandomTypeSelection(packages, model, "«mut.type.name»");			
			RemoveReferenceMutator mut = new RemoveReferenceMutator(model, packages, containerSelection, "«mut.refType.name»");
		  	//INC COUNTER: «nMutation++»
   			//INC COUNTER: «nRegistryMutation++»
		  	if (mut != null) {
		  		mut.setId("m«nMutation»");
				mutations.add(mut);
			}
		//END REMOVE RANDOM REFERENCE «methodName»
	'''

	def removeRandomReferenceMutatorExhaustive(RemoveRandomReferenceMutator mut) '''
		// REMOVE RANDOM REFERENCE «methodName»
		//END REMOVE RANDOM REFERENCE «methodName»
	'''
	
	def removeSpecificReferenceMutator(RemoveSpecificReferenceMutator mut) '''
		// REMOVE SPECIFIC REFERENCE «methodName»
			ObSelectionStrategy containerSelection = null;
			«IF mut.container instanceof RandomTypeSelection»
				containerSelection = new RandomTypeSelection(packages, model, "«(mut.container as RandomTypeSelection).type.name»");
			«ELSEIF mut.container instanceof SpecificObjectSelection»
				SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.container as SpecificObjectSelection).objSel.name» = hmObjects.get("«(mut.container as SpecificObjectSelection).objSel.name»");
				if (entry_«(mut.container as SpecificObjectSelection).objSel.name» != null) {
					containerSelection = new SpecificObjectSelection(entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getValue(), entry_«(mut.container as SpecificObjectSelection).objSel.name».getValue().getKey(), entry_«(mut.container as SpecificObjectSelection).objSel.name».getKey());
				} else {
					return mutations;
				}
			«ELSEIF mut.container instanceof CompleteTypeSelection»
				containerSelection = new CompleteTypeSelection(packages, model, "«(mut.container as CompleteTypeSelection).type.name»");
			«ENDIF»
			RemoveReferenceMutator mut = new RemoveReferenceMutator(model, packages, containerSelection, "«mut.refType.name»");
		   	//INC COUNTER: «nMutation++»
   			//INC COUNTER: «nRegistryMutation++»
		   	if (mut != null) {
		   		mut.setId("m«nMutation»");
				mutations.add(mut);
			}
		//END REMOVE SPECIFIC REFERENCE «methodName»
	'''

	def removeSpecificReferenceMutatorExhaustive(RemoveSpecificReferenceMutator mut) '''
		// REMOVE SPECIFIC REFERENCE «methodName»
		//END REMOVE SPECIFIC REFERENCE «methodName»
	'''
	
	def removeCompleteReferenceMutator(RemoveCompleteReferenceMutator mut) '''
		// REMOVE COMPLETE REFERENCE «methodName»
			CompleteTypeSelection containersSelection = new CompleteTypeSelection(packages, model, "«mut.type.name»");
			List<EObject> objects = containersSelection.getObjects();
			for (EObject obj : objects) {
				RemoveReferenceMutator mut = new RemoveReferenceMutator(model, packages, obj, "«mut.refType.name»");
			   	//INC COUNTER: «nMutation++»
	   			//INC COUNTER: «nRegistryMutation++»
			   	if (mut != null) {
			   		mut.setId("m«nMutation»");
					mutations.add(mut);
				}
			}
		//END REMOVE COMPLETE REFERENCE «methodName»
	'''
	
	def removeCompleteReferenceMutatorExhaustive(RemoveCompleteReferenceMutator mut) '''
		// REMOVE COMPLETE REFERENCE «methodName»
		//END REMOVE COMPLETE REFERENCE «methodName»
	'''

	def method(Mutator mut, boolean exhaustive, MutatorEnvironment e, Block b, boolean last) '''
		«IF exhaustive == false»
		«IF standalone == false»
		private List<Mutator> «methodName»(List<EPackage> packages, Resource model, Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects, Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList, boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes) throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException {
		«ELSE»
		private static List<Mutator> «methodName»(List<EPackage> packages, Resource model, Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects, Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList, boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes) throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException {
		«ENDIF»
			List<Mutator> mutations = new ArrayList<Mutator>();
		«IF mut instanceof ModifyInformationMutator»
			«(mut as ModifyInformationMutator).modifyInformationMutator»
		«ENDIF»
		«IF mut instanceof CreateObjectMutator»
			«(mut as CreateObjectMutator).createObjectMutator»
		«ENDIF»
		«IF mut instanceof SelectObjectMutator»
			«(mut as SelectObjectMutator).selectObjectMutator»
		«ENDIF»
		«IF mut instanceof SelectSampleMutator»
			«(mut as SelectSampleMutator).selectSampleMutator»
		«ENDIF»
		«IF mut instanceof CloneObjectMutator»
			«(mut as CloneObjectMutator).cloneObjectMutator»
		«ENDIF»
		«IF mut instanceof RetypeObjectMutator»
			«(mut as RetypeObjectMutator).retypeObjectMutator»
		«ENDIF»
		«IF mut instanceof ModifySourceReferenceMutator»
			«(mut as ModifySourceReferenceMutator).modifySourceReferenceMutator»
		«ENDIF»
		«IF mut instanceof ModifyTargetReferenceMutator»
			«(mut as ModifyTargetReferenceMutator).modifyTargetReferenceMutator»
		«ENDIF»
		«IF mut instanceof CreateReferenceMutator»
			«(mut as CreateReferenceMutator).createReferenceMutator»
		«ENDIF»
		«IF mut instanceof RemoveObjectMutator»
			«(mut as RemoveObjectMutator).removeObjectMutator»
		«ENDIF»
		«IF mut instanceof RemoveRandomReferenceMutator»
			«(mut as RemoveRandomReferenceMutator).removeRandomReferenceMutator»
		«ENDIF»
		«IF mut instanceof RemoveSpecificReferenceMutator»
			«(mut as RemoveSpecificReferenceMutator).removeSpecificReferenceMutator»
		«ENDIF»
		«IF mut instanceof RemoveCompleteReferenceMutator»
			«(mut as RemoveCompleteReferenceMutator).removeCompleteReferenceMutator»
		«ENDIF»
			return mutations;	
		}
		«ELSE»
		«IF standalone == false»
		private int «methodName»(List<EPackage> packages, Resource model,
					Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
					Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList,
					Map<String, String> hashmapModelFilenames, String modelFilename, List<String> mutPaths,
					Map<String, EObject> hmMutator, Resource seed, Map<String, EPackage> registeredPackages, Map<String, EPackage> localRegisteredPackages,
					Map<String, String> hashmapModelFolders, String ecoreURI, boolean registry,
					Set<String> hashsetMutantsBlock, List<String> fromNames, Map<String,
					List<String>> hashmapMutVersions, Mutations muts, IProject project, IProgressMonitor monitor, int[] k, boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
					throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException,
					ObjectNotContainedException, ObjectNoTargetableException, AbstractCreationException, WrongAttributeTypeException, IOException {
		«ELSE»
		private int «methodName»(List<EPackage> packages, Resource model,
					Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects,
					Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList,
					Map<String, String> hashmapModelFilenames, String modelFilename, List<String> mutPaths,
					Map<String, EObject> hmMutator, Resource seed, Map<String, EPackage> registeredPackages, Map<String, EPackage> localRegisteredPackages,
					Map<String, String> hashmapModelFolders, String ecoreURI, boolean registry,
					Set<String> hashsetMutantsBlock, List<String> fromNames, Map<String,
					List<String>> hashmapMutVersions, Mutations muts, IProgressMonitor monitor, int[] k, boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes)
					throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException,
					ObjectNotContainedException, ObjectNoTargetableException, AbstractCreationException, WrongAttributeTypeException, IOException {
		«ENDIF»
		int numMutantsGenerated = 0;
		«IF mut instanceof ModifyInformationMutator»
			«(mut as ModifyInformationMutator).modifyInformationMutatorExhaustive(e, b, last)»
		«ENDIF»
		«IF mut instanceof CreateObjectMutator»
			«(mut as CreateObjectMutator).createObjectMutatorExhaustive(e, b, last)»
		«ENDIF»
		«IF mut instanceof SelectObjectMutator»
			«(mut as SelectObjectMutator).selectObjectMutatorExhaustive(e, b, last)»
		«ENDIF»
		«IF mut instanceof SelectSampleMutator»
			«(mut as SelectSampleMutator).selectSampleMutatorExhaustive»
		«ENDIF»
		«IF mut instanceof CloneObjectMutator»
			«(mut as CloneObjectMutator).cloneObjectMutatorExhaustive(e, b, last)»
		«ENDIF»
		«IF mut instanceof RetypeObjectMutator»
			«(mut as RetypeObjectMutator).retypeObjectMutatorExhaustive(e, b, last)»
		«ENDIF»
		«IF mut instanceof ModifySourceReferenceMutator»
			«(mut as ModifySourceReferenceMutator).modifySourceReferenceMutatorExhaustive»
		«ENDIF»
		«IF mut instanceof ModifyTargetReferenceMutator»
			«(mut as ModifyTargetReferenceMutator).modifyTargetReferenceMutatorExhaustive»
		«ENDIF»
		«IF mut instanceof CreateReferenceMutator»
			«(mut as CreateReferenceMutator).createReferenceMutatorExhaustive»
		«ENDIF»
		«IF mut instanceof RemoveObjectMutator»
			«(mut as RemoveObjectMutator).removeObjectMutatorExhaustive(e, b, last)»
		«ENDIF»
		«IF mut instanceof RemoveRandomReferenceMutator»
			«(mut as RemoveRandomReferenceMutator).removeRandomReferenceMutatorExhaustive»
		«ENDIF»
		«IF mut instanceof RemoveSpecificReferenceMutator»
			«(mut as RemoveSpecificReferenceMutator).removeSpecificReferenceMutatorExhaustive»
		«ENDIF»
		«IF mut instanceof RemoveCompleteReferenceMutator»
			«(mut as RemoveCompleteReferenceMutator).removeCompleteReferenceMutatorExhaustive»
		«ENDIF»
		return numMutantsGenerated;
	}
		«ENDIF»
	'''
	
	def compositeMethod(CompositeMutator mut, boolean exhaustive)'''
		«IF mut.eContainer instanceof MutatorEnvironment»
		//INC COUNTER: «nMutation++»
		//INC COUNTER: «nRegistryMutation++»
		«ENDIF»
		«IF standalone == false»
		private List<Mutator> «compositeMethodName»(List<EPackage> packages, Resource model, Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects, Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList, boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes) throws ReferenceNonExistingException {
		«ELSE»
		private static List<Mutator> «compositeMethodName»(List<EPackage> packages, Resource model, Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects, Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList, boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes) throws ReferenceNonExistingException {
		«ENDIF»
			List<Mutator> mutations = new ArrayList<Mutator>();
			«var localNCompositeMethod = nCompositeMethod + 1»
			«var localNMethod = nMethod + 1»
			«FOR c : mut.commands»
			«IF c instanceof CompositeMutator»
				//COMMAND: «nCompositeCommands = nCompositeCommands + 1»
				«IF c.fixed == 0»
				«IF (c.max - c.min > 0)»
				int cmax«nCompositeCommands» = getRandom(«c.max - c.min») + «c.min»;
				«ENDIF»
				«IF (c.min == 0) && (c.max == 0)»
				int cmax«nCompositeCommands» = 1;
				«ELSEIF (c.min == c.max)»
				int cmax«nCompositeCommands» = «c.min»;
				«ENDIF»
				«ELSE»
				int cmax«nCompositeCommands» = «c.fixed»;
				«ENDIF»
				for (int j«nCompositeCommands» = 0; j«nCompositeCommands» < cmax«nCompositeCommands»; j«nCompositeCommands»++) {
					//COMPOSITE METHOD NAME:«compositeMethodName = "compositeMutation" + localNCompositeMethod.toString()»
					List<Mutator> l«compositeMethodName» = «compositeMethodName»(packages, model, hmObjects, hmList);
					//COMPOSITE METHOD INC: «localNCompositeMethod++»
					if (l«compositeMethodName» != null) {
						if (l«compositeMethodName».size() > 0) {
							mutations.addAll(l«compositeMethodName»);
						}
					}
				}
				//COMPOSITE METHOD INC: «localNCompositeMethod+= MutatorUtils.compositeMutatorSize(c) - 1»
			«ELSE»
			//COMMAND: «nCommands = nCommands + 1»
			«IF c.fixed == 0»
			«IF (c.max - c.min > 0)»
			int max«nCommands» = getRandom(«c.max - c.min») + «c.min»;
			«ENDIF»
			«IF (c.max == 0) && (c.min == 0)»
			int max«nCommands» = 1;
			«ELSEIF (c.min == c.max)»
			int max«nCommands» = «c.min»;
			«ENDIF»
			«ELSE»
			int max«nCommands» = «c.fixed»;
			«ENDIF»
			for (int j = 0; j < max«nCommands»; j++) {
				«IF c.name !== null»
				//NAME:«commandName = c.name + nCommands.toString()»
				«ELSE»
				//NAME:«commandName = nCommands.toString()»
				«ENDIF»
				//METHOD NAME:«methodName = "mutation" + localNMethod.toString()»
					
				List<Mutator> l«commandName» = «methodName»(packages, model, hmObjects, hmList, serialize, test, classes);
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
			//COUNTER COMPOSITE: «nCompositeMethod = nCompositeMethod + 1»
			//COMPOSITE METHOD NAME:«compositeMethodName = "compositeMutation" + nCompositeMethod.toString()»
			«IF compositeCommands === null»
			//CREATION ARRAYLIST NUM COMMANDS: «compositeCommands = new ArrayList<String>()»
			«ENDIF»
			//ADDING NUM COMMANDS: «compositeCommands.add(compositeMethodName)»
			«mut.compositeMethod(exhaustive)»
			«FOR c : mut.commands»
				«(c as Mutator).generateMethods(exhaustive, e, b, last)»
			«ENDFOR»
		«ELSE»
			//COUNTER: «nMethod = nMethod + 1»
			//METHOD CALL: «nMethodCall = nMethod»
			//METHOD NAME:«methodName = "mutation" + nMethod.toString()»
			«(mut as Mutator).method(exhaustive, e, b, last)»			
		«ENDIF»
	'''
	def registryMethod(Mutator mut, boolean exhaustive)'''
	«IF standalone == false»
	private AppMutation «registryMethodName»(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths, List<EPackage> packages) {
	«ELSE»
	private static AppMutation «registryMethodName»(Mutator mut, Map<String, EObject> hmMutator, Resource seed, List<String> mutPaths, List<EPackage> packages) {
	«ENDIF»
		AppMutation appMut = null;
	«IF mut instanceof CreateObjectMutator»
		ObjectCreated cMut = AppliedMutationsFactory.eINSTANCE.createObjectCreated();
		if ((mutPaths != null) && (packages != null)) {
			«IF standalone == false»
			try {
			«ENDIF»
				Resource mutant = null;
				EObject object = null;
				for (String mutatorPath : mutPaths) {
					«IF standalone == false»
					mutant = ModelManager.loadModel(packages, mutatorPath);
					«ELSE»
					mutant = ModelManager.loadModelNoException(packages, mutatorPath);
					«ENDIF»
					object = ModelManager.getObject(mutant, mut.getObject());
					if (object != null) {
						break;
					}
					//Reload input
					try {
						mutant.unload();
						mutant.load(null); 
					} catch (Exception e) {}
				}
				if (object != null) {
					cMut.getObject().add(object);
				}
				else {
					if (mut.getModel() != null) {
						mutant = mut.getModel();
					}
					else {
						mutant = mut.getModels().get(0);
					}
					cMut.getObject().add(mut.getObject());
				}
			«IF standalone == false»
			} catch (ModelNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			«ENDIF»
		}
		cMut.setDef(hmMutator.get("m«nRegistryMutation»"));
		appMut = cMut;
	«ENDIF»
	«IF mut instanceof CloneObjectMutator»
		ObjectCloned cMut = AppliedMutationsFactory.eINSTANCE.createObjectCloned();
		if (mut.getObject() != null) {
			cMut.getObject().add(mut.getObject());
		}
		cMut.setDef(hmMutator.get("m«nRegistryMutation»"));
		appMut = cMut;
	«ENDIF»
	«IF mut instanceof RetypeObjectMutator»
		ObjectRetyped rMut = AppliedMutationsFactory.eINSTANCE.createObjectRetyped();
		if (mut.getObject() != null) {
			rMut.getObject().add(mut.getObject());
		}
		EObject foundObject = findEObjectForRegistry(seed, mut.getRemovedObject(), mut.getObjectByID(), mut.getObjectByURI(), mutPaths, packages);
		if (foundObject != null) {
			rMut.getRemovedObject().add(foundObject);
		}
		rMut.setType(mut.getEType());
		rMut.setNewType(mut.getNewEType());
		rMut.setDef(hmMutator.get("m«nRegistryMutation»"));
		appMut = rMut;
	«ENDIF»
	«IF mut instanceof RemoveObjectMutator»
		ObjectRemoved rMut = AppliedMutationsFactory.eINSTANCE.createObjectRemoved();
		EObject foundObject = findEObjectForRegistry(seed, mut.getObject(), mut.getObjectByID(), mut.getObjectByURI(), mutPaths, packages);
		if (foundObject != null) {
			rMut.getObject().add(foundObject);
		}
		rMut.setType(mut.getEType());
		rMut.setDef(hmMutator.get("m«nRegistryMutation»"));
		appMut = rMut;
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
		rMut.setDef(hmMutator.get("m«nRegistryMutation»"));
		appMut = rMut;
	«ENDIF»
	«IF mut instanceof RemoveRandomReferenceMutator»
		ReferenceRemoved rMut = AppliedMutationsFactory.eINSTANCE.createReferenceRemoved();
		List<EObject> objects = new ArrayList<EObject>();
		objects.addAll(findEObjectsForRegistry(seed, mut, mutPaths, packages));
		rMut.getObject().addAll(objects);
		if (((RemoveReferenceMutator) mut).getReference() != null) {
			rMut.getRef().add(((RemoveReferenceMutator) mut).getReference());
			rMut.setRefName(((RemoveReferenceMutator) mut).getRefName());
		}
		rMut.setDef(hmMutator.get("m«nRegistryMutation»"));
		appMut = rMut;
	«ENDIF»
	«IF mut instanceof RemoveSpecificReferenceMutator»
		ReferenceRemoved rMut = AppliedMutationsFactory.eINSTANCE.createReferenceRemoved();
		List<EObject> objects = new ArrayList<EObject>();
		objects.addAll(findEObjectsForRegistry(seed, mut, mutPaths, packages));
		rMut.getObject().addAll(objects);
		if (((RemoveReferenceMutator) mut).getReference() != null) {
			rMut.getRef().add(((RemoveReferenceMutator) mut).getReference());
			rMut.setRefName(((RemoveReferenceMutator) mut).getRefName());
		}
		rMut.setDef(hmMutator.get("m«nRegistryMutation»"));
		appMut = rMut;
	«ENDIF»
	«IF mut instanceof RemoveCompleteReferenceMutator»
		ReferenceRemoved rMut = AppliedMutationsFactory.eINSTANCE.createReferenceRemoved();
		List<EObject> objects = new ArrayList<EObject>();
		objects.addAll(findEObjectsForRegistry(seed, mut, mutPaths, packages));
		rMut.getObject().addAll(objects);
		if (((RemoveReferenceMutator) mut).getReference() != null) {
			rMut.getRef().add(((RemoveReferenceMutator) mut).getReference());
			rMut.setRefName(((RemoveReferenceMutator) mut).getRefName());
		}
		rMut.setDef(hmMutator.get("m«nRegistryMutation»"));
		appMut = rMut;
	«ENDIF»
	«IF mut instanceof ModifyInformationMutator»
			InformationChanged icMut = AppliedMutationsFactory.eINSTANCE.createInformationChanged();
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
			attMut«attCounter».setFirstName("«eattfirst.name»");
			if (ModelManager.getObject(seed, ((ModifyInformationMutator) mut).getOtherObject()) != null) {
				attMut«attCounter».setAttObject(ModelManager.getObject(seed, ((ModifyInformationMutator) mut).getOtherObject()));
			}
			attMut«attCounter».setAttName("«eattsec.name»");
			«ENDIF»
			«IF att instanceof AttributeCopy»
			//«eattsec = att.attribute.get(1)»
			AttributeChanged attMut«attCounter» = null;
			attMut«attCounter» = AppliedMutationsFactory.eINSTANCE.createAttributeChanged();
			attMut«attCounter».setAttName("«eattsec.name»");
			«ENDIF»
			«IF att instanceof AttributeUnset»
			AttributeChanged attMut«attCounter» = null;
			attMut«attCounter» = AppliedMutationsFactory.eINSTANCE.createAttributeChanged();
			attMut«attCounter».setAttName("«eattsec.name»");
			«ENDIF»
			«IF att instanceof AttributeReverse»
			AttributeChanged attMut«attCounter» = null;
			attMut«attCounter» = AppliedMutationsFactory.eINSTANCE.createAttributeChanged();
			attMut«attCounter».setAttName("«eattsec.name»");
			«ENDIF»
			oldAttVal = ((ModifyInformationMutator) mut).getOldAttValue("«eattfirst.name»");
			newAttVal = ((ModifyInformationMutator) mut).getNewAttValue("«eattfirst.name»");
			if (oldAttVal != null) {
				attMut«attCounter».setOldVal(oldAttVal.toString());
			}
			if (newAttVal != null) {
				attMut«attCounter».setNewVal(newAttVal.toString());
			}
			attMut«attCounter».setDef(hmMutator.get("m«nRegistryMutation»"));
			attsMut.add(attMut«attCounter»);
			icMut.setDef(hmMutator.get("m«nRegistryMutation»"));
			//ATTRIBUTE COUNTER INC: «attCounter++»
		«ENDFOR»
		«ENDIF»
		«IF (mut as ModifyInformationMutator).references.size > 0»
			EList<ReferenceChanged> refsMut = icMut.getRefChanges();
			EObject previous = null;
			EObject next = null;
			//REFERENCE COUNTER: «var refCounter = 0»
		«FOR ReferenceSet ref : (mut as ModifyInformationMutator).references»
			«IF ref instanceof ReferenceInit || ref instanceof ReferenceAdd || ref instanceof ReferenceRemove»
			//«var EReference eref = ref.reference.get(0)»
			ReferenceChanged refMut«refCounter» = null;
			refMut«refCounter» = AppliedMutationsFactory.eINSTANCE.createReferenceChanged();
			refMut«refCounter».setRefName("«eref.name»");
			refMut«refCounter».getObject().add(((ModifyInformationMutator) mut).getObject());
			refMut«refCounter».getMutantObject().add(((ModifyInformationMutator) mut).getObject());
			«ENDIF»
			«IF ref instanceof ReferenceSwap»
			//«var ereffirst = ref.reference.get(0)»
			//«var erefsec = ref.reference.get(1)»
			appliedMutations.ReferenceSwap refMut«refCounter» = null;
			refMut«refCounter» = AppliedMutationsFactory.eINSTANCE.createReferenceSwap();
			refMut«refCounter».setFirstName("«ereffirst.name»");
			if (ModelManager.getObject(seed, ((ModifyInformationMutator) mut).getRefObject()) != null) {
				refMut«refCounter».setRefObject(ModelManager.getObject(seed, ((ModifyInformationMutator) mut).getRefObject()));
			}
			refMut«refCounter».setRefName("«erefsec.name»");
			refMut«refCounter».setOtherFrom(((ModifyInformationMutator) mut).getOtherSource("«ereffirst.name»"));
			refMut«refCounter».setOtherFromName(((ModifyInformationMutator) mut).getOtherSourceName("«ereffirst.name»"));
			refMut«refCounter».setOtherTo(((ModifyInformationMutator) mut).getOtherTarget("«ereffirst.name»"));
			refMut«refCounter».setOtherToName(((ModifyInformationMutator) mut).getOtherTargetName("«ereffirst.name»"));
			«ENDIF»
			«IF ref instanceof ReferenceAtt»
			//«var att = ref.attribute»
			appliedMutations.ReferenceAtt refMut«refCounter» = null;
			refMut«refCounter» = AppliedMutationsFactory.eINSTANCE.createReferenceAtt();
			refMut«refCounter».setAttName("«att.name»");
			if (ModelManager.getObject(seed, ((ModifyInformationMutator) mut).getRefAttObject()) != null) {
				refMut«refCounter».getObject().add(ModelManager.getObject(seed, ((ModifyInformationMutator) mut).getRefAttObject()));
			}
			refMut«refCounter».setRefName("«ref.reference.get(0).name»");
			Object oldRefAttVal«refCounter» = null;
			Object newRefAttVal«refCounter» = null;
			if (((ModifyInformationMutator) mut).getOldRefAttValue("«att.name»") != null) {
				oldRefAttVal«refCounter» = ((ModifyInformationMutator) mut).getOldRefAttValue("«att.name»");
			}
			if (((ModifyInformationMutator) mut).getNewRefAttValue("«att.name»") != null) {
				newRefAttVal«refCounter» = ((ModifyInformationMutator) mut).getNewRefAttValue("«att.name»");
			}
			if (oldRefAttVal«refCounter» != null) {
				refMut«refCounter».setOldVal(oldRefAttVal«refCounter».toString());
			}
			if (newRefAttVal«refCounter» != null) {
				refMut«refCounter».setNewVal(newRefAttVal«refCounter».toString());
			}
			refMut«refCounter».setDef(hmMutator.get("m«nRegistryMutation»"));
			«ENDIF»
			previous = ((ModifyInformationMutator) mut).getPrevious("«ref.reference.get(0).name»");
			next = ((ModifyInformationMutator) mut).getNext("«ref.reference.get(0).name»");
			if (previous != null) {
				refMut«refCounter».setFrom(previous);
				refMut«refCounter».setMutantFrom(previous);
			}
			if (next != null) {
				refMut«refCounter».setTo(next);
				refMut«refCounter».setMutantTo(next);
			}
			refMut«refCounter».setSrcRefName(((ModifyInformationMutator) mut).getSrcRefType());
			refMut«refCounter».setDef(hmMutator.get("m«nRegistryMutation»"));
			refsMut.add(refMut«refCounter»);
			icMut.setDef(hmMutator.get("m«nRegistryMutation»"));
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
			srcMut.setDef(hmMutator.get("m«nRegistryMutation»"));
			appMut = srcMut;
	«ENDIF»
	«IF mut instanceof ModifyTargetReferenceMutator»
			TargetReferenceChanged trcMut = AppliedMutationsFactory.eINSTANCE.createTargetReferenceChanged();
			trcMut.getObject().add(mut.getObject());
			trcMut.setFrom(((ModifyTargetReferenceMutator) mut).getSource());
			trcMut.setSrcRefName(((ModifyTargetReferenceMutator) mut).getSrcRefType());
			trcMut.setTo(((ModifyTargetReferenceMutator) mut).getNewTarget());
			trcMut.setOldTo(((ModifyTargetReferenceMutator) mut).getOldTarget());
			trcMut.setRefName(((ModifyTargetReferenceMutator) mut).getRefType());
			trcMut.setDef(hmMutator.get("m«nRegistryMutation»"));
			appMut = trcMut;
	«ENDIF»
	«IF mut instanceof SelectObjectMutator»
		appMut = AppliedMutationsFactory.eINSTANCE.createAppMutation();
		appMut.setDef(hmMutator.get("m«nRegistryMutation»"));
	«ENDIF»
	«IF mut instanceof SelectSampleMutator»
		appMut = AppliedMutationsFactory.eINSTANCE.createAppMutation();
		appMut.setDef(hmMutator.get("m«nRegistryMutation»"));
	«ENDIF»
		return appMut;
	}
   '''
   
   	def compositeRegistryMethod(CompositeMutator mut, boolean exhaustive)'''
   	«IF mut.eContainer instanceof MutatorEnvironment»
	//LOCAL COPY REGISTRY COUNTER: «var localNRegistryMutation = nRegistryMutation»
	«IF standalone == false»
	private AppMutation «compositeRegistryMethodName»(List<Mutator> muts, Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmMutator, Resource seed, boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes) {
	«ELSE»
	private static AppMutation «compositeRegistryMethodName»(List<Mutator> muts, Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmMutator, Resource seed, boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes) {
	«ENDIF»
		CompositeMutation appMut = AppliedMutationsFactory.eINSTANCE.createCompositeMutation();
		appMut.setSize(«MutatorUtils.mutatorSize(mut)»);
		List<AppMutation> appMuts = new ArrayList<AppMutation>();
		«var localNRegistryMethod = nRegistryMethod + 1»
		«var mutCounter = 0»
		«FOR c : mut.commands»
		//REGISTRY METHOD NAME:«registryMethodName = "registry" + localNRegistryMethod.toString()»
		//REGISTRY COUNTER INC: «localNRegistryMutation++»
		AppMutation appMut«mutCounter + 1» = «registryMethodName»(muts.get(«mutCounter»), hmMutator, seed, null, null);
		appMut«mutCounter + 1».setDef(hmMutator.get("m«localNRegistryMutation»"));
		appMuts.add(appMut«mutCounter + 1»);
		//REGISTRY METHOD INC: «localNRegistryMethod++»
		//COUNTER: «mutCounter++»
		«ENDFOR»
		appMut.getMuts().addAll(appMuts);
		appMut.setDef(hmMutator.get("m«nRegistryMutation»"));
		return appMut;
	}
	«ENDIF»
   '''
	def Object generateRegistryMethods(Mutator mut, boolean exhaustive) '''
		«IF mut instanceof CompositeMutator»
			//COUNTER COMPOSITE REGISTRY: «nCompositeRegistryMethod = nCompositeRegistryMethod + 1»
			//COMPOSITE REGISTRY METHOD NAME:«compositeRegistryMethodName = "compositeRegistry" + nCompositeRegistryMethod.toString()»
			«IF compositeRegistryCommands === null»
			//CREATION ARRAYLIST NUM REGISTRY COMMANDS: «compositeRegistryCommands = new ArrayList<String>()»
			«ENDIF»
			//ADDING NUM COMMANDS: «compositeRegistryCommands.add(compositeRegistryMethodName)»
			«mut.compositeRegistryMethod(exhaustive)»
			«FOR c : mut.commands»
				«c.generateRegistryMethods(exhaustive)»
			«ENDFOR»
			//COUNTER REGISTRY: «nRegistryMethod = nRegistryMethod + MutatorUtils.mutatorSize(mut)»
		«ELSE»
			//COUNTER: «nRegistryMethod = nRegistryMethod + 1»
			//METHOD NAME:«registryMethodName = "registry" + nRegistryMethod.toString()»
			«mut.registryMethod(exhaustive)»			
		«ENDIF»
	'''
	
	def generateBlock(Block b,
		boolean exhaustive
	) '''
		//SAVE COUNTER: «var localNMethod = nMethod»
		//SAVE COUNTER: «var localNCompositeMethod = nCompositeMethod»
		//SAVE COUNTER: «var localNMutation = nMutation»
		//SAVE COUNTER: «var localNRegistryMutation = nRegistryMutation»
		//SAVE COUNTER: «var localNRegistryMethod = nRegistryMethod»
		//SAVE COUNTER: «var localNRegistryMethodCall = nRegistryMethodCall»
		//SAVE COUNTER: «var localNCompositeRegistryMethod = nCompositeRegistryMethod»
		//SAVE COUNTER: «var localNCompositeCommands = nCompositeCommands»
		«FOR c : b.commands»
			«c.generateMethods(exhaustive, b.eContainer as MutatorEnvironment, b, EcoreUtil.equals(c, b.commands.get(b.commands.size() - 1)))»
			«c.generateRegistryMethods(exhaustive)»
		«ENDFOR»
		«IF standalone == false»
		public int block_«b.name»(int maxAttempts, int numMutants, boolean registry, List<EPackage> packages, Map<String, EPackage> registeredPackages, Map<String, EPackage> localRegisteredPackages, List<String> fromNames, Map<String, Set<String>> hashmapMutants, Map<String, List<String>> hashmapMutVersions, IProject project, IProgressMonitor monitor, int[] k, boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes) throws ReferenceNonExistingException, WrongAttributeTypeException, 
												  MaxSmallerThanMinException, AbstractCreationException, ObjectNoTargetableException, 
												  ObjectNotContainedException, MetaModelNotFoundException, ModelNotFoundException, IOException {
		«ELSE»
		public int block_«b.name»(int maxAttempts, int numMutants, boolean registry, List<EPackage> packages, Map<String, EPackage> registeredPackages, Map<String, EPackage> localRegisteredPackages, List<String> fromNames, Map<String, Set<String>> hashmapMutants, Map<String, List<String>> hashmapMutVersions, IProgressMonitor monitor, int[] k, boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes) throws ReferenceNonExistingException, WrongAttributeTypeException, 
												  MaxSmallerThanMinException, AbstractCreationException, ObjectNoTargetableException, 
												  ObjectNotContainedException, MetaModelNotFoundException, ModelNotFoundException, IOException {
		«ENDIF»
		int numMutantsGenerated = 0;
		if (maxAttempts <= 0) {
			maxAttempts = 1;
		}
		//TEMP COUNTER: «var tempNMethod = nMethod»
		//TEMP COUNTER: «var tempNCompositeMethod = nCompositeMethod»
		//TEMP COUNTER: «var tempNMutation = nMutation»
		//TEMP COUNTER: «var tempNRegistryMutation = nRegistryMutation»
		//TEMP COUNTER: «var tempNRegistryMethod = nRegistryMethod»
		//TEMP COUNTER: «var tempNRegistryMethodCall = nRegistryMethodCall»
		//TEMP COUNTER: «var tempNCompositeRegistryMethod = nCompositeRegistryMethod»
		//TEMP COUNTER: «var tempNCompositeCommands = nCompositeCommands»
		//RESET COUNTER: «nMethod = localNMethod»
		//RESET COUNTER: «nCompositeMethod = localNCompositeMethod»
		//RESET COUNTER: «nMutation = localNMutation»
		//RESET COUNTER: «nRegistryMutation = localNRegistryMutation»
		//RESET COUNTER: «nRegistryMethod = localNRegistryMethod»
		//RESET COUNTER: «nRegistryMethodCall = localNRegistryMethodCall»
		//RESET COUNTER: «nCompositeRegistryMethod = localNCompositeRegistryMethod»
		//RESET COUNTER: «nCompositeCommands = localNCompositeCommands»
		//«var e = b.eContainer as MutatorEnvironment»
		«IF e.definition instanceof Program»
		«e.multipleBlock(b)»
		«ENDIF»
		//RESTORE COUNTER: «nMethod = tempNMethod»
		//RESTORE COUNTER: «nCompositeMethod = tempNCompositeMethod»
		//RESTORE COUNTER: «nMutation = tempNMutation»
		//RESTORE COUNTER: «nRegistryMutation = tempNRegistryMutation»
		//RESTORE COUNTER: «nRegistryMethod = tempNRegistryMethod»
		//RESTORE COUNTER: «nRegistryMethodCall = tempNRegistryMethodCall»
		//RESTORE COUNTER: «nCompositeRegistryMethod = tempNCompositeRegistryMethod»
		//RESTORE COUNTER: «nCompositeCommands = tempNCompositeCommands»
		return numMutantsGenerated;
	}
	'''
	
	def compile(MutatorEnvironment e) ''' 

package mutator.«className»;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.AbstractMap.SimpleEntry;

import wodel.utils.manager.IWodelTest;
import wodel.utils.manager.ModelManager;
import wodel.utils.manager.MutatorMetricsGenerator;
import wodel.utils.manager.DebugMutatorMetricsGenerator;
import wodel.utils.manager.NetMutatorMetricsGenerator;

import org.eclipse.core.resources.IProject;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
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

import wodel.utils.manager.MutatorUtils;
import wodel.utils.manager.EMFCopier;

public class «className» extends MutatorUtils {
	
	«IF standalone == false»
	private Map<Integer, Mutator> overallMutators = new HashMap<Integer, Mutator>();
	«ELSE»
	private static Map<Integer, Mutator> overallMutators = new HashMap<Integer, Mutator>();
	«ENDIF» 

	«IF standalone == false»
	private List<EObject> mutatedObjects = null;
	«ELSE»
	private static List<EObject> mutatedObjects = null;
	«ENDIF»

	«IF e.definition instanceof Program»
	//RESET COUNTER: «nMethod = 0»
	//RESET COUNTER: «nCompositeMethod = 0»
	//RESET COUNTER: «nRegistryMethod = 0»
	//RESET COUNTER: «nRegistryMethodCall = 0»
	//RESET COUNTER: «nCompositeRegistryMethod = 0»
	//RESET COUNTER: «nMutation = 0»
	//RESET COUNTER: «nRegistryMutation = 0»
	//RESET COUNTER: «nCompositeCommands = 0»
   	«IF e.commands.length > 0»
	«FOR c : e.commands»
		«c.generateMethods(((e.definition) as Program).exhaustive, c.eContainer as MutatorEnvironment, null, EcoreUtil.equals(c, e.commands.get(e.commands.size() - 1)))»
		«c.generateRegistryMethods(((e.definition) as Program).exhaustive)»
	«ENDFOR»

	@Override
	«IF standalone == false»
	public MutationResults execute(int maxAttempts, int numMutants, boolean registry, boolean metrics, boolean debugMetrics, List<EPackage> packages, Map<String, EPackage> registeredPackages, Map<String, EPackage> localRegisteredPackages, String[] blockNames, IProject project, IProgressMonitor monitor, boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes) throws ReferenceNonExistingException, WrongAttributeTypeException, 
												  MaxSmallerThanMinException, AbstractCreationException, ObjectNoTargetableException, 
												  ObjectNotContainedException, MetaModelNotFoundException, ModelNotFoundException, IOException {
	«ELSE»
	public MutationResults execute(int maxAttempts, int numMutants, boolean registry, boolean metrics, boolean debugMetrics, List<EPackage> packages, Map<String, EPackage> registeredPackages, Map<String, EPackage> localRegisteredPackages, String[] blockNames, IProgressMonitor monitor, boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes) throws ReferenceNonExistingException, WrongAttributeTypeException, 
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
		//«nMut = (e.definition as Program).num»
	   	«IF nMut != 0»
	   	numMutants = «nMut»;
	   	«ENDIF»
	   	«ELSE»
	   	numMutants = -1;
	   	«ENDIF»

	   	int totalMutants = 0;
		Map<String, List<String>> hashmapMutVersions = new HashMap<String, List<String>>();

		//RESET COUNTER: «nMethod = 0»
		//RESET COUNTER: «nCompositeMethod = 0»
		//RESET COUNTER: «nMutation = 0»
		//RESET COUNTER: «nRegistryMutation = 0»
		//RESET COUNTER: «nRegistryMethod = 0»
		//RESET COUNTER: «nRegistryMethodCall = 0»
		//RESET COUNTER: «nCompositeRegistryMethod = 0»
		//RESET COUNTER: «nCompositeCommands = 0»
		«IF e.definition instanceof Program»
		«e.multiple»
		«ENDIF»

		//Generate metrics model
	   	String metricsecore = "«metricsURL/*FileLocator.resolve(metricsURL).getFile()*/»";

		MutatorMetricsGenerator metricsGenerator = null;
	   	if (metrics == true) {
	   		List<EPackage> metricspackages = ModelManager.loadMetaModel(metricsecore);
	   		monitor.subTask("Generating dynamic net metrics");
	   		«IF standalone == false»
	   		metricsGenerator = new NetMutatorMetricsGenerator(metricspackages, "«ModelManager.getWorkspaceAbsolutePath(e) + "/" + getProjectName + "/" + ((e as MutatorEnvironment).definition as Program).output»", "«((e as MutatorEnvironment).definition as Program).metamodel»", "«path+"/"+((e as MutatorEnvironment).definition as Program).source.path»", "«fileName»", hashmapMutVersions, this.getClass());
	   		«ELSE»
	   		metricsGenerator = new NetMutatorMetricsGenerator(metricspackages, "«ModelManager.getWorkspaceAbsolutePath(e) + "/" + getProjectName + "/" + ((e as MutatorEnvironment).definition as Program).output»", "«((e as MutatorEnvironment).definition as Program).metamodel»", "«path+"/"+((e as MutatorEnvironment).definition as Program).source.path»", "«fileName»", hashmapMutVersions, «className».class);
	   		«ENDIF»
	   		metricsGenerator.run();
	   		monitor.worked(1);
	   	}
	   	if (debugMetrics == true) {
			List<EPackage> metricspackages = ModelManager.loadMetaModel(metricsecore);
	   		monitor.subTask("Generating dynamic debug metrics");
	   		«IF standalone == true»
	   		metricsGenerator = new DebugMutatorMetricsGenerator(metricspackages, "«ModelManager.getWorkspaceAbsolutePath(e) + "/" + getProjectName + "/" + ((e as MutatorEnvironment).definition as Program).output»", "«((e as MutatorEnvironment).definition as Program).metamodel»", "«path+"/"+((e as MutatorEnvironment).definition as Program).source.path»", "«fileName»", hashmapMutVersions, this.getClass());
	   		«ELSE»
	   		metricsGenerator = new DebugMutatorMetricsGenerator(metricspackages, "«ModelManager.getWorkspaceAbsolutePath(e) + "/" + getProjectName + "/" + ((e as MutatorEnvironment).definition as Program).output»", "«((e as MutatorEnvironment).definition as Program).metamodel»", "«path+"/"+((e as MutatorEnvironment).definition as Program).source.path»", "«fileName»", hashmapMutVersions, «className».class);
	   		«ENDIF»
	   		metricsGenerator.run();
	   		monitor.worked(1);   			
	   	}
	   	mutationResults.numMutatorsApplied++;
	   	if (mutationResults.mutatorsApplied == null) {
	   		mutationResults.mutatorsApplied = new ArrayList<String>();
	   	}
	   	mutationResults.mutatorsApplied.add("");
	   	return mutationResults;
	}
}
	«ENDIF»
	«ENDIF»
	«IF e.blocks.size() > 0»
	//RESET COUNTER: «nMethod = 0»
	//RESET COUNTER: «nCompositeMethod = 0»
	//RESET COUNTER: «nMutation = 0»
	//RESET COUNTER: «nRegistryMutation = 0»
	//RESET COUNTER: «nRegistryMethod = 0»
	//RESET COUNTER: «nRegistryMethodCall = 0»
	//RESET COUNTER: «nCompositeRegistryMethod = 0»
	//RESET COUNTER: «nCompositeCommands = 0»
	«FOR b : e.blocks»
		«IF b.commands.size() > 0»
			«b.generateBlock((e.definition as Program).exhaustive)»
		«ENDIF»
	«ENDFOR»
	@Override
	«IF standalone == false»
	public MutationResults execute(int maxAttempts, int numMutants, boolean registry, boolean metrics, boolean debugMetrics, List<EPackage> packages, Map<String, EPackage> registeredPackages, Map<String, EPackage> localRegisteredPackages, String[] blockNames, IProject project, IProgressMonitor monitor, boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes) throws ReferenceNonExistingException, WrongAttributeTypeException, 
												  MaxSmallerThanMinException, AbstractCreationException, ObjectNoTargetableException, 
												  ObjectNotContainedException, MetaModelNotFoundException, ModelNotFoundException, IOException {
	«ELSE»
	public MutationResults execute(int maxAttempts, int numMutants, boolean registry, boolean metrics, boolean debugMetrics, List<EPackage> packages, Map<String, EPackage> registeredPackages, Map<String, EPackage> localRegisteredPackages, String[] blockNames, IProgressMonitor monitor, boolean serialize, IWodelTest test, TreeMap<String, List<String>> classes) throws ReferenceNonExistingException, WrongAttributeTypeException, 
												  MaxSmallerThanMinException, AbstractCreationException, ObjectNoTargetableException, 
												  ObjectNotContainedException, MetaModelNotFoundException, ModelNotFoundException, IOException {
	«ENDIF»

		MutationResults mutationResults = new MutationResults();

		if (maxAttempts <= 0) {
			maxAttempts = 1;
		}
		int totalTasks = «e.blocks.size»;
		if (metrics == true) {
			totalTasks++;
		}
		if (debugMetrics == true) {
			totalTasks++;
		}
		monitor.beginTask("Generating mutants", totalTasks);
		Map<String, Set<String>> hashmapMutants = new HashMap<String, Set<String>>();
		Map<String, List<String>> hashmapMutVersions = new HashMap<String, List<String>>();

		List<String> fromNames = null;
		//«var int i = 0»
		«FOR b : e.blocks»
		«IF b.commands.size() > 0»
		fromNames = new ArrayList<String>();
		«FOR from : b.from»
		fromNames.add("«from.name»");
		«ENDFOR»
		if (blockNames == null || (blockNames != null && Arrays.asList(blockNames).contains("«b.name»") == true)) {
			monitor.subTask("Generating mutants for block «b.name» («i+1»/«e.blocks.size»)");
			int[] k = new int[1];
			k[0] = 0;
			«IF standalone == false»
			int numMutantsGenerated = block_«b.name»(maxAttempts, numMutants, registry, packages, registeredPackages, localRegisteredPackages, fromNames, hashmapMutants, hashmapMutVersions, project, monitor, k, serialize, test, classes);
			«ELSE»
			int numMutantsGenerated = block_«b.name»(maxAttempts, numMutants, registry, packages, registeredPackages, localRegisteredPackages, fromNames, hashmapMutants, hashmapMutVersions, monitor, k, serialize, test, classes);
			«ENDIF»
			if (numMutantsGenerated > 0) {
				mutationResults.numMutatorsApplied++;
				if (mutationResults.mutatorsApplied == null) {
					mutationResults.mutatorsApplied = new ArrayList<String>();
				}
				mutationResults.mutatorsApplied.add("«b.name»");
				mutationResults.numMutantsGenerated += numMutantsGenerated;
			}
			monitor.worked(1);
		}
		//«i++»
		«ENDIF»
		«ENDFOR»
		
		//Generate metrics model
	   	String metricsecore = "«metricsURL/*FileLocator.resolve(metricsURL).getFile()*/»";

		MutatorMetricsGenerator metricsGenerator = null;
		if (metrics == true) {
			List<EPackage> metricspackages = ModelManager.loadMetaModel(metricsecore);
			monitor.subTask("Generating dynamic net metrics");
			«IF standalone == false»
			metricsGenerator = new NetMutatorMetricsGenerator(metricspackages, "«ModelManager.getWorkspaceAbsolutePath(e) + "/" + getProjectName + "/" + ((e as MutatorEnvironment).definition as Program).output»", "«((e as MutatorEnvironment).definition as Program).metamodel»", "«path+"/"+((e as MutatorEnvironment).definition as Program).source.path»", "«fileName»", hashmapMutVersions, this.getClass());
			«ELSE»
			metricsGenerator = new NetMutatorMetricsGenerator(metricspackages, "«ModelManager.getWorkspaceAbsolutePath(e) + "/" + getProjectName + "/" + ((e as MutatorEnvironment).definition as Program).output»", "«((e as MutatorEnvironment).definition as Program).metamodel»", "«path+"/"+((e as MutatorEnvironment).definition as Program).source.path»", "«fileName»", hashmapMutVersions, «className».class);
			«ENDIF»
	   		metricsGenerator.run();
	   		monitor.worked(1);
		}
		if (debugMetrics == true) {
			List<EPackage> metricspackages = ModelManager.loadMetaModel(metricsecore);
			monitor.subTask("Generating dynamic debug metrics");
			«IF standalone == false»
			metricsGenerator = new DebugMutatorMetricsGenerator(metricspackages, "«ModelManager.getWorkspaceAbsolutePath(e) + "/" + getProjectName + "/" + ((e as MutatorEnvironment).definition as Program).output»", "«((e as MutatorEnvironment).definition as Program).metamodel»", "«path+"/"+((e as MutatorEnvironment).definition as Program).source.path»", "«fileName»", hashmapMutVersions, this.getClass());
			«ELSE»
			metricsGenerator = new DebugMutatorMetricsGenerator(metricspackages, "«ModelManager.getWorkspaceAbsolutePath(e) + "/" + getProjectName + "/" + ((e as MutatorEnvironment).definition as Program).output»", "«((e as MutatorEnvironment).definition as Program).metamodel»", "«path+"/"+((e as MutatorEnvironment).definition as Program).source.path»", "«fileName»", hashmapMutVersions, «className».class);
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
		«IF e instanceof Program»
		String ecoreURI = "«e.metamodel»";
		«/*IF e.source.multiple == true*/»
		«var String modelPath = path+"/"+e.source.path»
		«var String outputPath = path+"/"+e.output» 
		String modelURI = "«modelPath»";
		String modelsURI = "«outputPath»";

		Map<String, String> hashmapModelFilenames = new HashMap<String, String>();
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
					hashmapModelFilenames.put(pathfile, modelsURI + files[i].getName().substring(0, files[i].getName().length() - ".model".length()));
				}
			}
		}
		«ENDIF»
		
		«IF e instanceof Program»
		//Load Model
		Set<String> modelFilenames = hashmapModelFilenames.keySet();
	   	if (numMutants > 0) {
	   		totalMutants = numMutants * «MutatorUtils.getNumberOfSeedModels(e.eContainer as MutatorEnvironment, path)»;
	   	}
		totalTasks += totalMutants;
		monitor.beginTask("Generating mutants", totalTasks);
		int count = 0;
		for (String modelFilename : modelFilenames) {
			Set<String> hashsetMutants = new HashSet<String>();
			hashsetMutants.add(modelFilename);

		«ENDIF»
   '''
   
	def multipleBlockCompile(Definition e, Block b) '''
		«IF e instanceof Program»
		String ecoreURI = "«e.metamodel»";
		«var String modelPath = path+"/"+e.source.path»
		«var String outputPath = path+"/"+e.output» 
		String modelURI = "«modelPath»";
		String modelsURI = "«outputPath»";
		
		Map<String, String> hashmapModelFilenames = new HashMap<String, String>();
		Map<String, String> hashmapModelFolders = new HashMap<String, String>();
		Map<String, String> seedModelFilenames = new HashMap<String, String>();
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
							hashmapModelFilenames.put(pathfile, modelsURI + files[i].getName().substring(0, files[i].getName().length() - ".model".length()));
							seedModelFilenames.put(pathfile, files[i].getPath());
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
											hashmapModelFilenames.put(pathfile, modelsURI + files[i].getName().substring(0, files[i].getName().length() - ".model".length()));
											hashmapModelFolders.put(pathfile, fromName + "/" + mutFiles[j].getName().substring(0, mutFiles[j].getName().length() - ".model".length()));
											seedModelFilenames.put(pathfile, files[i].getPath());
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
			hashsetMutantsBlock = new HashSet<String>();
			«ELSEIF b.repeat == Repeat.NO»
			if (seedModelFilename != null) {
				if (hashmapMutants.get(seedModelFilename) != null) {
					hashsetMutantsBlock = hashmapMutants.get(seedModelFilename);
				}
			}
			if (hashsetMutantsBlock == null) {
				hashsetMutantsBlock = new HashSet<String>();
			}
			«ENDIF»
			if (hashsetMutantsBlock.contains(seedModelFilename) == false) {
				hashsetMutantsBlock.add(seedModelFilename);
			}

		«ENDIF»
   '''

    def method(AttributeSet e, boolean flag, boolean isList, int counter, boolean exhaustive, String obSelectionVariableName) '''
   		«IF isList == true»
    	«IF e.attribute.get(0) !== null»
		«val EAttribute attribute = e.attribute.get(0)»
		«IF counter > 1»
		List<AttributeConfigurationStrategy> atts = null;
		if (attsList.get("«attributeName»") != null) {
			atts = attsList.get("«attributeName»");
		}
		else {
			atts = new ArrayList<AttributeConfigurationStrategy>();
		}
		«ELSE»
		List<AttributeConfigurationStrategy> atts = new ArrayList<AttributeConfigurationStrategy>();
		«ENDIF»
		//NAME:«attributeName = attribute.name»
		«ELSE»
		//NAME:«attributeName = ""»
		«ENDIF»
		«IF e instanceof AttributeScalar»
		atts.add(«e.value.method(flag, exhaustive, obSelectionVariableName)»);
   		«ENDIF»
   		«IF e instanceof AttributeUnset»
		atts.add(null);
   		«ENDIF»
   		«IF e instanceof AttributeReverse»
		atts.add(new ReverseBooleanConfigurationStrategy("«attributeName»"));
   		«ENDIF»
		«IF e instanceof AttributeCopy»
		«IF e.object instanceof RandomTypeSelection»
		atts.add(new CopyAttributeConfigurationStrategy((«obSelectionVariableName» != null ? «obSelectionVariableName».getObject() : null), "«(e.object as RandomTypeSelection).type.name»", "«attributeName»", "«e.getAttribute().get(1).name»"));
   		«ENDIF»
		«IF e.object instanceof SpecificObjectSelection»
		«IF exhaustive == false»
		atts.add(new CopyAttributeConfigurationStrategy((«obSelectionVariableName» != null ? «obSelectionVariableName».getObject() : null), hmObjects.get("«(e.object as SpecificObjectSelection).objSel.name»").getKey(), "«attributeName»", "«e.getAttribute().get(1).name»"));
		«ELSE»
		atts.add(new CopyAttributeConfigurationStrategy((«obSelectionVariableName» != null ? «obSelectionVariableName».getObject() : null), hmObjects.get("«(e.object as SpecificObjectSelection).objSel.name»").getKey(), "«attributeName»", "«e.getAttribute().get(1).name»"));
   		«ENDIF»
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
		atts.put("«attributeName»", «e.value.method(flag, exhaustive, obSelectionVariableName)»);
   		«ENDIF»
   		«IF e instanceof AttributeUnset»
   		atts.put("«attributeName»", null);
   		«ENDIF»
   		«IF e instanceof AttributeReverse»
   		atts.put("«attributeName»", new ReverseBooleanConfigurationStrategy("«attributeName»"));
   		«ENDIF»
		«IF e instanceof AttributeCopy»
		«IF e.object instanceof RandomTypeSelection»
		atts.put("«attributeName»", new CopyAttributeConfigurationStrategy((«obSelectionVariableName» != null ? «obSelectionVariableName».getObject() : null), "«(e.object as RandomTypeSelection).type.name»", "«attributeName»", "«e.getAttribute().get(1).name»"));
   		«ENDIF»
		«IF e.object instanceof SpecificObjectSelection»
		«IF exhaustive == false»
		atts.put("«attributeName»", new CopyAttributeConfigurationStrategy((«obSelectionVariableName» != null ? «obSelectionVariableName».getObject() : null), hmObjects.get("«(e.object as SpecificObjectSelection).objSel.name»").getKey(), "«attributeName»", "«e.getAttribute().get(1).name»"));
		«ELSE»
		atts.put("«attributeName»", new CopyAttributeConfigurationStrategy((«obSelectionVariableName» != null ? «obSelectionVariableName».getObject() : null), hmObjects.get("«(e.object as SpecificObjectSelection).objSel.name»").getKey(), "«attributeName»", "«e.getAttribute().get(1).name»"));
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
	def method(AttributeType e, boolean flag, boolean exhaustive, String obSelectionVariableName) '''
	«IF e instanceof StringType»
		«(e as StringType).method(exhaustive)»
	«ELSEIF e instanceof DoubleType»
		«(e as DoubleType).method(exhaustive)»
	«ELSEIF e instanceof BooleanType»
		«(e as BooleanType).method(exhaustive)»
	«ELSEIF e instanceof IntegerType»
		«(e as IntegerType).method(exhaustive)»
	«ELSEIF e instanceof ListStringType»
		«(e as ListStringType).method(flag, exhaustive, obSelectionVariableName)»
	«ELSEIF e instanceof ListType»
		«(e as ListType).method(flag, exhaustive, obSelectionVariableName)»
	«ELSEIF e instanceof RandomType»
		«(e as RandomType).method(flag, exhaustive, obSelectionVariableName)»
	«ELSEIF e instanceof MinValueType»
		«(e as MinValueType).method(exhaustive)»
	«ELSEIF e instanceof MaxValueType»
		«(e as MaxValueType).method(exhaustive)»
	«ELSEIF e instanceof RandomIntegerNumberType»
		«(e as RandomIntegerNumberType).method(exhaustive)»
	«ELSEIF e instanceof RandomDoubleNumberType»
		«(e as RandomDoubleNumberType).method(exhaustive)»
	«ENDIF»
	'''
	
	//********************
	//DATA TYPES COMPILES
	def method(StringType e, boolean exhaustive) ''' 
		«IF e instanceof SpecificStringType»
			new SpecificStringConfigurationStrategy("«(e as SpecificStringType).value»")
		«ELSEIF e instanceof RandomStringType»
		    «var RandomStringType r = (e as RandomStringType)»
			new RandomStringConfigurationStrategy(«r.min», «r.max», false)
		«ELSEIF e instanceof UpperStringType»
			«IF !attributeName.equals("")»
			new UpperStringConfigurationStrategy("«attributeName»")
			«ELSE»
			null
			«ENDIF»
		«ELSEIF e instanceof LowerStringType»
			«IF !attributeName.equals("")»
			new LowerStringConfigurationStrategy("«attributeName»")
			«ELSE»
			null
			«ENDIF»
		«ELSEIF e instanceof CatStartStringType»
			«IF !attributeName.equals("")»
			new CatStartStringConfigurationStrategy("«(e as CatStartStringType).value»", "«attributeName»")
			«ELSE»
			null
			«ENDIF»
		«ELSEIF e instanceof CatEndStringType»
			«IF !attributeName.equals("")»
			new CatEndStringConfigurationStrategy("«(e as CatEndStringType).value»", "«attributeName»")
			«ELSE»
			null
			«ENDIF»
		«ELSEIF e instanceof ReplaceStringType»
			«IF !attributeName.equals("")»
			new ReplaceStringConfigurationStrategy("«attributeName»", "«(e as ReplaceStringType).oldstring»", "«(e as ReplaceStringType).newstring»")
			«ELSE»
			null
			«ENDIF»
		«ELSEIF e instanceof RandomStringNumberType»
		    «var RandomStringNumberType r = (e as RandomStringNumberType)»
			new RandomStringNumberConfigurationStrategy(«r.min», «r.max», false)
		«ENDIF»
	'''
				
	def method(DoubleType e, boolean exhaustive) ''' 
		«IF e instanceof SpecificDoubleType»
			new SpecificDoubleConfigurationStrategy(«(e as SpecificDoubleType).value»)
		«ELSEIF e instanceof RandomDoubleType»
			«var RandomDoubleType r = (e as RandomDoubleType)»
			new RandomDoubleConfigurationStrategy(«r.min», «r.max», false)
		«ENDIF»
	'''	
	def method(BooleanType e, boolean exhaustive) ''' 
		«IF e instanceof SpecificBooleanType»
			new SpecificBooleanConfigurationStrategy(«(e as SpecificBooleanType).value»)
		«ELSEIF e instanceof RandomBooleanType»
			new RandomBooleanConfigurationStrategy()
		«ENDIF»
		'''	
	def method(IntegerType e, boolean exhaustive) '''
		«IF e instanceof SpecificIntegerType» 		
			new SpecificIntegerConfigurationStrategy(«(e as SpecificIntegerType).value»)
		«ELSEIF e instanceof RandomIntegerType»
			«var RandomIntegerType r = (e as RandomIntegerType)»
			new RandomIntegerConfigurationStrategy(«r.min», «r.max», false)		
		«ENDIF»
		'''
	def method(ListStringType e, boolean flag, boolean exhaustive, String obSelectionVariableName) '''
		«IF e instanceof ListStringType»
			«IF !attributeName.equals("")»
				«IF flag == false»
					new ListStringConfigurationStrategy((String) ModelManager.getAttribute("«attributeName»", («obSelectionVariableName» != null) ? «obSelectionVariableName».getObject() : null), "«(e as ListStringType).value»", "«attributeName»")
				«ELSE»
					new ListStringConfigurationStrategy((String) ModelManager.getAttribute("«attributeName»", refObjectSelected), "«(e as ListStringType).value»", "«attributeName»")
				«ENDIF»
			«ELSE»
				null
			«ENDIF»
		«ENDIF»
		'''
		
	def method(ListType e, boolean flag, boolean exhaustive, String obSelectionVariableName) '''
		«IF e instanceof ListType»
			«IF !attributeName.equals("")»
				«IF flag == false»
					new ListConfigurationStrategy((EObject) ModelManager.getAttribute("«attributeName»", («obSelectionVariableName» != null) ? «obSelectionVariableName».getObject() : null), "«(e as ListType).value»", "«attributeName»")
				«ELSE»
					new ListConfigurationStrategy((EObject) ModelManager.getAttribute("«attributeName»", refObjectSelected), "«(e as ListType).value»", "«attributeName»")
				«ENDIF»
			«ELSE»
				null
			«ENDIF»
		«ENDIF»
		'''
	def method(RandomType e, boolean flag, boolean exhaustive, String obSelectionVariableName) '''
		«IF e instanceof RandomType»
			«IF !attributeName.equals("")»
				«IF flag == false»
					new RandomConfigurationStrategy(ModelManager.getAttribute("«attributeName»", «obSelectionVariableName».getObject()), "«attributeName»")
				«ELSE»
					new RandomConfigurationStrategy(ModelManager.getAttribute("«attributeName»", refObjectSelected), "«attributeName»")
				«ENDIF»
			«ELSE»
				null
			«ENDIF»
		«ENDIF»
		'''
	def method(MinValueType e, boolean exhaustive) '''
		new MinValueConfigurationStrategy(packages, model, "«MutatorUtils.getTypeName(e)»", "«e.attribute.name»")
		'''
	def method(MaxValueType e, boolean exhaustive) '''
		new MaxValueConfigurationStrategy(packages, model, "«MutatorUtils.getTypeName(e)»", "«e.attribute.name»")
		'''
	def method(RandomIntegerNumberType e, boolean exhaustive) '''
		«IF e.object instanceof SpecificObjectSelection»
		//«var SpecificObjectSelection sel = e.object as SpecificObjectSelection»
		«IF exhaustive == false»
		new RandomIntegerConfigurationStrategy(«e.min», ModelManager.getIntAttribute("«e.max.name»", hmObjects.get("«sel.objSel.name»").getKey()), false)
		«ELSE»
		new RandomIntegerConfigurationStrategy(«e.min», ModelManager.getIntAttribute("«e.max.name»", hmObjects.get("«sel.objSel.name»").getKey()), false)
		«ENDIF»
		«ENDIF»
		'''
	def method(RandomDoubleNumberType e, boolean exhaustive) '''
		«IF e.object instanceof SpecificObjectSelection»
		//«var SpecificObjectSelection sel = e.object as SpecificObjectSelection»
		new RandomDoubleConfigurationStrategy(«e.min», ModelManager.getDoubleAttribute("«e.max.name»", hmObjects.get("«sel.objSel.name»").getKey()), false)
		«ENDIF»
	'''

	def add(AttributeOperation op, String obSelectionVariableName) '''
		atts.add(new AddOperationConfigurationStrategy(«obSelectionVariableName».getMetaModel(), «obSelectionVariableName».getModel(), "«MutatorUtils.getTypeName(op)»", "«attributeName»", «obSelectionVariableName».getObject(), value));
		attsList.put("«attributeName»", atts); 
	'''

	def subtract(AttributeOperation op, String obSelectionVariableName) '''
		atts.add(new SubtractOperationConfigurationStrategy(«obSelectionVariableName».getMetaModel(), «obSelectionVariableName».getModel(), "«MutatorUtils.getTypeName(op)»", "«attributeName»", «obSelectionVariableName».getObject(), value));
		attsList.put("«attributeName»", atts); 
	'''

	def multiply(AttributeOperation op, String obSelectionVariableName) '''
		atts.add(new MultiplyOperationConfigurationStrategy(«obSelectionVariableName».getMetaModel(), «obSelectionVariableName».getModel(), "«MutatorUtils.getTypeName(op)»", "«attributeName»", «obSelectionVariableName».getObject(), value));
		attsList.put("«attributeName»", atts); 
	'''

	def divide(AttributeOperation op, String obSelectionVariableName) '''
		atts.add(new DivideOperationConfigurationStrategy(«obSelectionVariableName».getMetaModel(), «obSelectionVariableName».getModel(), "«MutatorUtils.getTypeName(op)»", "«attributeName»", «obSelectionVariableName».getObject(), value));
		attsList.put("«attributeName»", atts); 
	'''

	def module(AttributeOperation op, String obSelectionVariableName) '''
		atts.add(new ModuleOperationConfigurationStrategy(«obSelectionVariableName».getMetaModel(), «obSelectionVariableName».getModel(), "«MutatorUtils.getTypeName(op)»", "«attributeName»", «obSelectionVariableName».getObject(), value));
		attsList.put("«attributeName»", atts); 
	'''
	//END DATA TYPES COMPILES
	//************************
	//********************
	//REFERENCES COMPILES
	def method(ObSelectionStrategy e, String referenceName, boolean exhaustive) '''
  		//REFERENCES COMPILES	«nReference=nReference+1»
		«IF e instanceof RandomTypeSelection»
			RandomTypeSelection refRts«nReference» = new RandomTypeSelection(packages, model, "«(e as RandomTypeSelection).type.name»");
			«IF e.expression !== null && expressionList !== null»
			List<EObject> refObjects«nReference» = refRts«nReference».getObjects();
			//INDEX EXPRESSION: « var indexExpression = expressionList.size() - 1»
			Expression exp«expressionList.get(indexExpression)» = new Expression();
	   		«e.expression.method(0)»
	   		List<EObject> refSelectedObjects«nReference» = evaluate(refObjects«nReference», exp«expressionList.get(indexExpression)»);
			EObject refObject«nReference» = null;
			if (refSelectedObjects«nReference».size() > 0) {
				refObject«nReference» = refSelectedObjects«nReference».get(ModelManager.getRandomIndex(refSelectedObjects«nReference»));
			}
			«ELSE»
			EObject refObject«nReference» = refRts«nReference».getObject();
			«ENDIF»
			ObSelectionStrategy refSelection«nReference» = null;
			if (refObject«nReference» != null) {
			refSelection«nReference» = 
				new SpecificObjectSelection(packages, model, refObject«nReference»);
			}
	    «ELSEIF e instanceof OtherTypeSelection»
			OtherTypeSelection refOts«nReference» = new OtherTypeSelection(packages, model, "«(e as OtherTypeSelection).type.name»", ModelManager.getReference("«referenceName»", objectSelection.getObject()));
			«IF e.expression !== null && expressionList !== null»
			List<EObject> refObjects«nReference» = refOts«nReference».getObjects();
			//INDEX EXPRESSION: « var indexExpression = expressionList.size() - 1»
			Expression exp«expressionList.get(indexExpression)» = new Expression();
	   		«e.expression.method(0)»
	   		List<EObject> refSelectedObjects«nReference» = evaluate(refObjects«nReference», exp«expressionList.get(indexExpression)»);
			EObject refObject«nReference» = null;
			if (refSelectedObjects«nReference».size() > 0) {
				refObject«nReference» = refSelectedObjects«nReference».get(ModelManager.getRandomIndex(refSelectedObjects«nReference»));
			}
			«ELSE»
			EObject refObject«nReference» = refOts«nReference».getObject();
			«ENDIF»
			ObSelectionStrategy refSelection«nReference» = null;
			if (refObject«nReference» != null) {
			refSelection«nReference» = new SpecificObjectSelection(packages, model, refObject«nReference»);
			}
	    
		«ELSEIF e instanceof CompleteTypeSelection»
			RandomTypeSelection refRts«nReference» = new RandomTypeSelection(packages, model, "«(e as CompleteTypeSelection).type.name»");
			EObject refObject«nReference» = refRts«nReference».getObject();
			ObSelectionStrategy refSelection«nReference» = new SpecificObjectSelection(packages, model,	refObject«nReference»);
		«ELSEIF e instanceof SpecificObjectSelection»
			ObSelectionStrategy refSelection«nReference» = null;
			«IF exhaustive == false»
			SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(e as SpecificObjectSelection).objSel.name»_«nReference» = hmObjects.get("«(e as SpecificObjectSelection).objSel.name»");
			«ELSE»
			SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(e as SpecificObjectSelection).objSel.name»_«nReference» = hmObjects.get("«(e as SpecificObjectSelection).objSel.name»");
			«ENDIF»
			if (entry_«(e as SpecificObjectSelection).objSel.name»_«nReference» != null) {
			«IF e.refType !== null»
				refSelection«nReference» = new SpecificObjectSelection(packages, model, entry_«(e as SpecificObjectSelection).objSel.name»_«nReference».getKey(), "«e.refType.name»");
			«ELSE»
				refSelection«nReference» = new SpecificObjectSelection(packages, model, entry_«(e as SpecificObjectSelection).objSel.name»_«nReference».getKey());
			«ENDIF»
			} else {
			«IF exhaustive == false»
				List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_«(e as SpecificObjectSelection).objSel.name»_«nReference» = hmList.get("«(e as SpecificObjectSelection).objSel.name»");
			«ELSE»
				List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_«(e as SpecificObjectSelection).objSel.name»_«nReference» = hmList.get("«(e as SpecificObjectSelection).objSel.name»");
			«ENDIF»
				if (listEntry_«(e as SpecificObjectSelection).objSel.name»_«nReference» != null) {
					List<EObject> objs = new ArrayList<EObject>();
					for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_«(e as SpecificObjectSelection).objSel.name»_«nReference») {
						EObject obj = ModelManager.getObject(model, ent.getKey());
						objs.add(obj);
					}
				«IF e.refType !== null»
					refSelection«nReference» = new SpecificObjectSelection(packages, model, objs, "«e.refType.name»");
				«ELSE»
					refSelection«nReference» = new SpecificObjectSelection(packages, model, objs);
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
   
   //*********
   // CLAUSES
   def Object method(Expression exp, int recursionIndexExpression) '''
  		//INDEX EXPRESSION: «val indexExpression = expressionList.size() - 1»
  		«IF exp.first instanceof AttributeEvaluation»
  		«IF (exp.first as AttributeEvaluation).value instanceof ObjectAttributeType»
  		exp«expressionList.get(indexExpression)».first = new AttributeEvaluation();
  		//ATTRIBUTE: «val attev = exp.first as AttributeEvaluation»
  		((AttributeEvaluation) exp«expressionList.get(indexExpression)».first).name = "«attev.name.name»";
  		((AttributeEvaluation) exp«expressionList.get(indexExpression)».first).operator = "«(attev.value as ObjectAttributeType).operator»";
  		((AttributeEvaluation) exp«expressionList.get(indexExpression)».first).values = new ArrayList<String>();
  		((AttributeEvaluation) exp«expressionList.get(indexExpression)».first).values.add(ModelManager.getStringAttribute("«(attev.value as ObjectAttributeType).attribute.name»", hmObjects.get("«(attev.value as ObjectAttributeType).objSel.name»").getKey()));
   		«ENDIF»
   		«IF (exp.first as AttributeEvaluation).value instanceof AttributeType»
		exp«expressionList.get(indexExpression)».first = new AttributeEvaluation();
		//ATTRIBUTE: «val attev = exp.first as AttributeEvaluation»
		((AttributeEvaluation) exp«expressionList.get(indexExpression)».first).name = "«attev.name.name»";
		((AttributeEvaluation) exp«expressionList.get(indexExpression)».first).operator = "«(attev.value as AttributeType).operator»";
		((AttributeEvaluation) exp«expressionList.get(indexExpression)».first).values = new ArrayList<String>();
   		«IF attev.value instanceof StringType»
   			((AttributeEvaluation) exp«expressionList.get(indexExpression)».first).values.add("«(attev.value as SpecificStringType).value»");
   			((AttributeEvaluation) exp«expressionList.get(indexExpression)».first).type = "String";
		«ENDIF»
		«IF attev.value instanceof DoubleType»
   			((AttributeEvaluation) exp«expressionList.get(indexExpression)».first).values.add("«(attev.value as SpecificDoubleType).value»");
   			((AttributeEvaluation) exp«expressionList.get(indexExpression)».first).type = "double";
		«ENDIF»
		«IF attev.value instanceof BooleanType»
   			((AttributeEvaluation) exp«expressionList.get(indexExpression)».first).values.add("«(attev.value as SpecificBooleanType).value»");
   			((AttributeEvaluation) exp«expressionList.get(indexExpression)».first).type = "Boolean";
		«ENDIF»
		«IF attev.value instanceof IntegerType»
   			((AttributeEvaluation) exp«expressionList.get(indexExpression)».first).values.add("«(attev.value as SpecificIntegerType).value»");
   			((AttributeEvaluation) exp«expressionList.get(indexExpression)».first).type = "int";
		«ENDIF»
		«IF attev.value instanceof MinValueType»
			MinValueConfigurationStrategy min«expressionList.get(indexExpression)» = new MinValueConfigurationStrategy(packages, model, "«MutatorUtils.getTypeName(attev.value as MinValueType)»", "«(attev.value as MinValueType).attribute.name»");
			((AttributeEvaluation) exp«expressionList.get(indexExpression)».first).values.add(min«expressionList.get(indexExpression)».getValue().toString());
   			«IF (attev.value as MinValueType).attribute.getEType.name.equals("EInt")»
			((AttributeEvaluation) exp«expressionList.get(indexExpression)».first).type = "int";
   			«ENDIF»
   			«IF (attev.value as MinValueType).attribute.getEType.name.equals("EDouble")»
			((AttributeEvaluation) exp«expressionList.get(indexExpression)».first).type = "double";
   			«ENDIF»
		«ENDIF»
		«IF attev.value instanceof MaxValueType»
			MaxValueConfigurationStrategy max«expressionList.get(indexExpression)» = new MaxValueConfigurationStrategy(packages, model, "«MutatorUtils.getTypeName(attev.value as MaxValueType)»", "«(attev.value as MaxValueType).attribute.name»");
			((AttributeEvaluation) exp«expressionList.get(indexExpression)».first).values.add(max«expressionList.get(indexExpression)».getValue().toString());
   			«IF (attev.value as MaxValueType).attribute.getEType.name.equals("EInt")»
			((AttributeEvaluation) exp«expressionList.get(indexExpression)».first).type = "int";
   			«ENDIF»
   			«IF (attev.value as MaxValueType).attribute.getEType.name.equals("EDouble")»
			((AttributeEvaluation) exp«expressionList.get(indexExpression)».first).type = "double";
   			«ENDIF»
		«ENDIF»
		«IF attev.value instanceof ListStringType»
			//«val list = attev.value as ListStringType»
			«FOR item : list.value»
			((AttributeEvaluation) exp«expressionList.get(indexExpression)».first).values.add("«item»");
   			«ENDFOR»
			((AttributeEvaluation) exp«expressionList.get(indexExpression)».first).type = "String";
		«ENDIF»
		«IF attev.value instanceof ListType»
			//«val list = attev.value as ListType»
			«FOR item : list.value»
			((AttributeEvaluation) exp«expressionList.get(indexExpression)».first).values.add("«item»");
   			«ENDFOR»
			((AttributeEvaluation) exp«expressionList.get(indexExpression)».first).type = "String";
		«ENDIF»
   		«ENDIF»
   		«ENDIF»
   		«IF exp.first instanceof ReferenceEvaluation»
		exp«expressionList.get(indexExpression)».first = new ReferenceEvaluation();
		//REFERENCE: «val refev = exp.first as ReferenceEvaluation»
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
   			«IF refev.attValue instanceof StringType || refev.attValue instanceof DoubleType || refev.attValue instanceof BooleanType || refev.attValue instanceof IntegerType»
   				((ReferenceEvaluation) exp«expressionList.get(indexExpression)».first).value = "«(refev.attValue as SpecificStringType).value»";
			«ENDIF»
			«IF refev.attValue instanceof MinValueType»
				MinValueConfigurationStrategy min«expressionList.get(indexExpression)» = new MinValueConfigurationStrategy(packages, model, "«MutatorUtils.getTypeName(refev.attValue as MinValueType)»", "«(refev.attValue as MinValueType).attribute.name»");
				((ReferenceEvaluation) exp«expressionList.get(indexExpression)».first).value = min«expressionList.get(indexExpression)».getValue().toString();
			«ENDIF»
			«IF refev.attValue instanceof MinValueType»
				MaxValueConfigurationStrategy max«expressionList.get(indexExpression)» = new MaxValueConfigurationStrategy(packages, model, "«MutatorUtils.getTypeName(refev.attValue as MaxValueType)»", "«(refev.attValue as MaxValueType).attribute.name»");
				((ReferenceEvaluation) exp«expressionList.get(indexExpression)».first).value = max«expressionList.get(indexExpression)».getValue().toString();
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
			//EXPRESSION LEVEL: «nExpression = nExpression + 1»
			//EXPRESSION LEVEL: «expressionList.add(nExpression)»
			//INDEX EXPRESSION: «val nestedIndexExpression = expressionList.size() - 1»
			RandomTypeSelection expRts«expressionList.get(nestedIndexExpression)» = new RandomTypeSelection(packages, model, "«(refev.value as RandomTypeSelection).type.name»");
			List<EObject> expObjects«expressionList.get(nestedIndexExpression)» = expRts«expressionList.get(nestedIndexExpression)».getObjects();
			Expression exp«expressionList.get(nestedIndexExpression)» = new Expression();
	   		«refev.value.expression.method(nestedIndexExpression)»
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
			//EXPRESSION LEVEL: «nExpression = nExpression + 1»
			//EXPRESSION LEVEL: «expressionList.add(nExpression)»
			//INDEX EXPRESSION: «val nestedIndexExpression = expressionList.size() - 1»
			TypedSelection expRts«expressionList.get(nestedIndexExpression)» = new TypedSelection(packages, model, "«(refev.value as TypedSelection).type.name»");
			List<EObject> expObjects«expressionList.get(nestedIndexExpression)» = expRts«expressionList.get(nestedIndexExpression)».getObjects();
			Expression exp«expressionList.get(nestedIndexExpression)» = new Expression();
			List<String> refNames«expressionList.get(nestedIndexExpression)» = new ArrayList<String>();
	   		«refev.value.expression.method(nestedIndexExpression)»
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
		//OPNAME: «var opName = 0»
   		«FOR op : exp.operator»
			Operator op«opName»_«expressionList.get(indexExpression)» = new Operator();
			op«opName»_«expressionList.get(indexExpression)».type = "«op.type»";
			exp«expressionList.get(indexExpression)».operator.add(op«opName»_«expressionList.get(indexExpression)»);
			//OPNAME + 1: « opName = opName + 1»
   		«ENDFOR»
		exp«expressionList.get(indexExpression)».second = new ArrayList<Evaluation>();
		//EVNAME: «var evName = 0»
   		«FOR ev : exp.second»
   			«IF ev instanceof AttributeEvaluation»
   			«IF (ev as AttributeEvaluation).value instanceof ObjectAttributeType»
			AttributeEvaluation ev«evName»_«expressionList.get(indexExpression)» = new AttributeEvaluation();
			ev«evName»_«expressionList.get(indexExpression)».name = "«ev.name.name»";
			ev«evName»_«expressionList.get(indexExpression)».operator = "«(ev.value as ObjectAttributeType).operator»";
			ev«evName»_«expressionList.get(indexExpression)».values = new ArrayList<String>();
   			«ENDIF»
   			«IF (ev as AttributeEvaluation).value instanceof AttributeType»
			AttributeEvaluation ev«evName»_«expressionList.get(indexExpression)» = new AttributeEvaluation();
			ev«evName»_«expressionList.get(indexExpression)».name = "«ev.name.name»";
			ev«evName»_«expressionList.get(indexExpression)».values = new ArrayList<String>();
   			«IF ev.value instanceof StringType»
				ev«evName»_«expressionList.get(indexExpression)».operator = "«(ev.value as SpecificStringType).operator»";
				ev«evName»_«expressionList.get(indexExpression)».values.add("«(ev.value as SpecificStringType).value»");;
				ev«evName»_«expressionList.get(indexExpression)».type = "String";
			«ENDIF»
			«IF ev.value instanceof DoubleType»
				ev«evName»_«expressionList.get(indexExpression)».operator = "«(ev.value as SpecificDoubleType).operator»";
				ev«evName»_«expressionList.get(indexExpression)».values.add("«(ev.value as SpecificDoubleType).value»");
				ev«evName»_«expressionList.get(indexExpression)».type = "double";
			«ENDIF»
			«IF ev.value instanceof BooleanType»
				ev«evName»_«expressionList.get(indexExpression)».operator = "«(ev.value as SpecificBooleanType).operator»";
				ev«evName»_«expressionList.get(indexExpression)».values.add("«(ev.value as SpecificBooleanType).value»");
				ev«evName»_«expressionList.get(indexExpression)».type = "Boolean";
			«ENDIF»
			«IF ev.value instanceof IntegerType»
				ev«evName»_«expressionList.get(indexExpression)».operator = "«(ev.value as SpecificIntegerType).operator»";
				ev«evName»_«expressionList.get(indexExpression)».values.add("«(ev.value as SpecificIntegerType).value»");
				ev«evName»_«expressionList.get(indexExpression)».type = "int";
			«ENDIF»
			«IF ev.value instanceof MinValueType»
			MinValueConfigurationStrategy min«evName»_«expressionList.get(indexExpression)» = new MinValueConfigurationStrategy(packages, model, "«MutatorUtils.getTypeName(ev.value as MinValueType)»", "«(ev.value as MinValueType).attribute.name»");
			((AttributeEvaluation) exp«evName»_«expressionList.get(indexExpression)».first).values.add(min«expressionList.get(indexExpression)».getValue().toString());
   			«IF (ev.value as MinValueType).attribute.getEType.name.equals("EInt")»
			((AttributeEvaluation) exp«evName»_«expressionList.get(indexExpression)».first).type = "int";
   			«ENDIF»
   			«IF (ev.value as MinValueType).attribute.getEType.name.equals("EDouble")»
			((AttributeEvaluation) exp«evName»_«expressionList.get(indexExpression)».first).type = "double";
   			«ENDIF»
			«ENDIF»
			«IF ev.value instanceof MaxValueType»
			MaxValueConfigurationStrategy max«evName»_«expressionList.get(indexExpression)» = new MaxValueConfigurationStrategy(packages, model, "«MutatorUtils.getTypeName(ev.value as MaxValueType)»", "«(ev.value as MinValueType).attribute.name»");
			((AttributeEvaluation) exp«evName»_«expressionList.get(indexExpression)».first).values.add(max«expressionList.get(indexExpression)».getValue().toString());
   			«IF (ev.value as MinValueType).attribute.getEType.name.equals("EInt")»
			((AttributeEvaluation) exp«evName»_«expressionList.get(indexExpression)».first).type = "int";
   			«ENDIF»
   			«IF (ev.value as MinValueType).attribute.getEType.name.equals("EDouble")»
			((AttributeEvaluation) exp«evName»_«expressionList.get(indexExpression)».first).type = "double";
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
				//EXPRESSION LEVEL: «nExpression = nExpression + 1»
				//EXPRESSION LEVEL: «expressionList.add(nExpression)»
				//INDEX EXPRESSION: «val nestedIndexExpression = expressionList.size() - 1»
				RandomTypeSelection expRts«expressionList.get(nestedIndexExpression)» = new RandomTypeSelection(packages, model, "«(ev.value as RandomTypeSelection).type.name»");
				List<EObject> expObjects«expressionList.get(nestedIndexExpression)» = expRts«expressionList.get(nestedIndexExpression)».getObjects();
				Expression exp«expressionList.get(nestedIndexExpression)» = new Expression();
				«ev.value.expression.method(nestedIndexExpression)»
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
				//EXPRESSION LEVEL: «nExpression = nExpression + 1»
				//EXPRESSION LEVEL: «expressionList.add(nExpression)»
				//INDEX EXPRESSION: «val nestedIndexExpression = expressionList.size() - 1»
				TypedSelection expRts«expressionList.get(nestedIndexExpression)» = new TypedSelection(packages, model, "«(ev.value as TypedSelection).type.name»");
				List<EObject> expObjects«expressionList.get(nestedIndexExpression)» = expRts«expressionList.get(nestedIndexExpression)».getObjects();
				Expression exp«expressionList.get(nestedIndexExpression)» = new Expression();
				List<String> refNames«expressionList.get(nestedIndexExpression)» = new ArrayList<String>();
	   			«ev.value.expression.method(nestedIndexExpression)»
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
  		«FOR ev : exp.second»
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
   		//Generate metrics model
		String mutatorecore = "«mutatorURL/*FileLocator.resolve(mutatorURL).getFile()*/»";
		
		//Load MetaModel
		List<EPackage> mutatorpackages = ModelManager.loadMetaModel(mutatorecore);
		«IF standalone == false»
		Resource mutatormodel = ModelManager.loadModel(mutatorpackages, URI.createURI("«xmiFileName»").toFileString());
		«ELSE»
		Resource mutatormodel = ModelManager.loadModelNoException(mutatorpackages, URI.createURI("«xmiFileName»").toFileString());
		«ENDIF»
		
		Map<String, EObject> hmMutator = getMutators(ModelManager.getObjects(mutatormodel));
		«IF (e.definition as Program).exhaustive == true»
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hashmapEObject = new HashMap<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>();
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hashmapList = new HashMap<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>>();
			monitor.subTask("Mutants generation");
			«IF standalone == false»
			Resource model = ModelManager.loadModel(packages, URI.createURI("file:/" + modelFilename).toFileString());
			«ELSE»
			Resource model = ModelManager.loadModelNoException(packages, URI.createURI("file:/" + modelFilename).toFileString());
			«ENDIF»
			«IF standalone == false»
			Resource seed = ModelManager.loadModel(packages, URI.createURI("file:/" + modelFilename).toFileString());
			«ELSE»
			Resource seed = ModelManager.loadModelNoException(packages, URI.createURI("file:/" + modelFilename).toFileString());
			«ENDIF»
			List<String> mutPaths = new ArrayList<String>();
			Mutations muts = AppliedMutationsFactory.eINSTANCE.createMutations();
		//COUNTER: «nMethod = nMethod + 1»
		//COMMAND: «nCommands = nCommands + 1»
		//REGISTRY COUNTER: «nRegistryMethod = nRegistryMethod + 1»
		//«var c = e.commands.get(0)»
		«IF c.name !== null»
			//NAME:«commandName = c.name + nCommands.toString()»
		«ELSE»
			//NAME:«commandName = nCommands.toString()»
		«ENDIF»
		//METHOD NAME:«methodName = "mutation" + nMethod.toString()»
		
		«IF standalone == false»
		mutationResults.numMutantsGenerated += «methodName»(packages, model, hashmapEObject, hashmapList, hashmapModelFilenames,
							modelFilename, mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages, null, ecoreURI,
							registry, hashsetMutants, null, hashmapMutVersions, muts, project, monitor, new int[] {0}, serialize, test, classes);
		«ELSE»
		mutationResults.numMutantsGenerated += «methodName»(packages, model, hashmapEObject, hashmapList, hashmapModelFilenames,
							modelFilename, mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages, null, ecoreURI,
							registry, hashsetMutants, null, hashmapMutVersions, muts, monitor, new int[] {0}, serialize, test, classes);
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
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hashmapEObject = new HashMap<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>();
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hashmapList = new HashMap<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>>();
			String mutFilename = hashmapModelFilenames.get(modelFilename) + "/" + "Output" + i + ".model";
			monitor.subTask("Mutant " + (count * numMutantsToGenerate + i + 1) + "/" + totalMutants + ": " + mutFilename);
			String mutPath = hashmapModelFilenames.get(modelFilename) + "/" + "Output" + i + "vs";
			boolean isRepeated = true;
			int attempts = 0;
			int max = 0;
			while ((isRepeated == true) && (attempts < maxAttempts)) {
				«IF standalone == false»
				Resource model = ModelManager.loadModel(packages, URI.createURI("file:/" + modelFilename).toFileString());
				«ELSE»
				Resource model = ModelManager.loadModelNoException(packages, URI.createURI("file:/" + modelFilename).toFileString());
				«ENDIF»
				«IF standalone == false»
				Resource seed = ModelManager.loadModel(packages, URI.createURI("file:/" + modelFilename).toFileString());
				«ELSE»
				Resource seed = ModelManager.loadModelNoException(packages, URI.createURI("file:/" + modelFilename).toFileString());
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
				Map<String, List<String>> rules = new HashMap<String, List<String>>();
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
				«IF standalone == false»
				isRepeated = registryMutant(ecoreURI, packages, registeredPackages, localRegisteredPackages, seed, model, rules, muts, modelFilename, mutFilename, registry, hashsetMutants, hashmapModelFilenames, mutantIndex, mutPaths, hashmapMutVersions, project, serialize, test, classes, this.getClass(), true);
				«ELSE»
				isRepeated = registryMutantStandalone(ecoreURI, packages, registeredPackages, localRegisteredPackages, seed, model, rules, muts, modelFilename, mutFilename, registry, hashsetMutants, hashmapModelFilenames, mutantIndex, mutPaths, hashmapMutVersions, "«getProjectName»", serialize, test, classes, «className».class, true);
				«ENDIF»
				if (isRepeated == false) {
					mutationResults.numMutantsGenerated++;
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
		//Generate metrics model
		String mutatorecore = "«mutatorURL/*FileLocator.resolve(mutatorURL).getFile()*/»";
		
		//Load MetaModel
		List<EPackage> mutatorpackages = ModelManager.loadMetaModel(mutatorecore);
		«IF standalone == false»
		Resource mutatormodel = ModelManager.loadModel(mutatorpackages, URI.createURI("«xmiFileName»").toFileString());
		«ELSE»
		Resource mutatormodel = ModelManager.loadModelNoException(mutatorpackages, URI.createURI("«xmiFileName»").toFileString());
		«ENDIF»
		
		Map<String, EObject> hmMutator = getMutators(ModelManager.getObjects(mutatormodel));
		
		«IF (e.definition as Program).exhaustive == true»
		Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hashmapEObject = new HashMap<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>();
		Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hashmapList = new HashMap<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>>();
		«IF standalone == false»
		Resource model = ModelManager.loadModel(packages, URI.createURI("file:/" + modelFilename).toFileString());
		«ELSE»
		Resource model = ModelManager.loadModelNoException(packages, URI.createURI("file:/" + modelFilename).toFileString());
		«ENDIF»
		«IF standalone == false»
		Resource seed = ModelManager.loadModel(packages, URI.createURI("file:/" + modelFilename).toFileString());
		«ELSE»
		Resource seed = ModelManager.loadModelNoException(packages, URI.createURI("file:/" + modelFilename).toFileString());
		«ENDIF»
		List<String> mutPaths = new ArrayList<String>();
		Mutations muts = AppliedMutationsFactory.eINSTANCE.createMutations();

		//COUNTER: «nMethod = nMethod + 1»	
		//COMMAND: «nCommands = nCommands + 1»
		//REGISTRY COUNTER: «nRegistryMethod = nRegistryMethod + 1»
		«IF b.commands.size() > 0»
		//«var c = b.commands.get(0)»
		«IF c.name !== null»
			//NAME:«commandName = c.name + nCommands.toString()»
		«ELSE»
			//NAME:«commandName = nCommands.toString()»
		«ENDIF»
		«ENDIF»
		//METHOD NAME:«methodName = "mutation" + nMethod.toString()»
		
		«IF standalone == false»
		«methodName»(packages, model, hashmapEObject, hashmapList, hashmapModelFilenames,
							modelFilename, mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,
							registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, project, monitor, k, serialize, test, classes);
		«ELSE»
		«methodName»(packages, model, hashmapEObject, hashmapList, hashmapModelFilenames,
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
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hashmapEObject = new HashMap<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>();
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hashmapList = new HashMap<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>>();
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
				Resource model = ModelManager.loadModelNoException(packages, URI.createURI("file:/" + modelFilename).toFileString());
				«ENDIF»
				«IF standalone == false»
				Resource seed = ModelManager.loadModel(packages, URI.createURI("file:/" + modelFilename).toFileString());
				«ELSE»
				Resource seed = ModelManager.loadModelNoException(packages, URI.createURI("file:/" + modelFilename).toFileString());
				«ENDIF»
				List<String> mutPaths = new ArrayList<String>();
				Mutations muts = AppliedMutationsFactory.eINSTANCE.createMutations();
				attempts++;
   	   			«FOR c : b.commands »
   	   				«IF c instanceof Mutator»
   	   				«c.compile»
   	   				«ENDIF»
				«ENDFOR»
				
				// MUTANT COMPLETION AND REGISTRY
				Map<String, List<String>> rules = new HashMap<String, List<String>>();
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
				«IF standalone == false»
				isRepeated = registryMutantWithBlocks(ecoreURI, packages, registeredPackages, localRegisteredPackages, seed, model, rules, muts, modelFilename, mutFilename, registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "«b.name»", fromNames, mutantIndex, mutPaths, hashmapMutVersions, project, serialize, test, classes, this.getClass(), true, false);
				«ELSE»
				isRepeated = registryMutantWithBlocksStandalone(ecoreURI, packages, registeredPackages, localRegisteredPackages, seed, model, rules, muts, modelFilename, mutFilename, registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "«b.name»", fromNames, mutantIndex, mutPaths, hashmapMutVersions, "«getProjectName»", serialize, test, classes, «className».class, true, false);
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
   		mutatedObjects = null;
	'''
	
	def compile(Mutator e)'''
	«IF e instanceof CompositeMutator»
		//COUNTER: «nMethod = nMethod + MutatorUtils.mutatorSize(e)»
		//COMPOSITE REGISTRY COUNTER: «nCompositeRegistryMethod = nCompositeRegistryMethod + 1»
		«IF (e.fixed == 0)»
		«IF (e.max - e.min > 0)»
		int max«nCompositeCommands» = getRandom(«e.max - e.min») + «e.min»;
		«ENDIF»
		«IF (e.min == 0) && (e.max == 0)»
		int max«nCompositeCommands» = 1;
		«ELSEIF (e.min == e.max)»
		int max«nCompositeCommands» = «e.min»;
		«ENDIF»
		«ELSE»
		int max«nCompositeCommands» = «e.fixed»;
		«ENDIF»
		for (int j«nCompositeCommands» = 0; j«nCompositeCommands» < max«nCompositeCommands»; j«nCompositeCommands»++) {
		«IF e.name !== null»
			//NAME:«compositeCommandName = e.name + nCompositeCommands.toString()»
		«ELSE»
			//NAME:«compositeCommandName = nCompositeCommands.toString()»
		«ENDIF»

		//COMPOSITE METHOD NAME:«compositeMethodName = compositeCommands.get(nCompositeCommands)»
		//COMMAND: «nCompositeCommands = nCompositeCommands + MutatorUtils.compositeMutatorSize(e)»
		List<Mutator> l«compositeCommandName» = «compositeMethodName»(packages, model, hashmapEObject, hashmapList, serialize, test, classes);
		//COUNTER: «nRegistryMutation = nRegistryMutation + 1»
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
		//COUNTER: «nRegistryMutation = nRegistryMutation + MutatorUtils.mutatorSize(e)»
	«ELSE»
		//COUNTER: «nMethod = nMethod + 1»	
		//COMMAND: «nCommands = nCommands + 1»
		//REGISTRY COUNTER: «nRegistryMethod = nRegistryMethod + 1»
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
		
		List<Mutator> l«commandName» = «methodName»(packages, model, hashmapEObject, hashmapList, serialize, test, classes);
		//COUNTER: «nRegistryMutation = nRegistryMutation + 1»
		//REGISTRY METHOD NAME:«registryMethodName = "registry" + nRegistryMethod.toString()»
		
		if (l«commandName» != null) {
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
		}
	«ENDIF»
    '''
	def compile(Mutator e, int index)'''
		//COUNTER: «nMethod = index»	
		//COMMAND: «nCommands = nCommands + 1»
		//REGISTRY COUNTER: «nRegistryMethod = index»
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
		
		List<Mutator> l«commandName» = «methodName»(packages, model, hashmapEObject, hashmapList, serialize, test, classes);
		//COUNTER: «nRegistryMutation = nRegistryMutation + 1»
		//REGISTRY METHOD NAME:«registryMethodName = "registry" + nRegistryMethod.toString()»
		
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
		}
		}
	'''
	
   //END COMMANDS
   //*************
}