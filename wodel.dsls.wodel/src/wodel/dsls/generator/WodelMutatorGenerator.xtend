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
import mutatorenvironment.BinaryOperator

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
	protected Program program
	protected Map<Mutator, Integer> mutIndexes = new LinkedHashMap<Mutator, Integer>()
	
	protected Bundle bundle

	def String getProjectName() {
		var String projectName = null
		if (ProjectUtils.project !== null) {
			projectName = ProjectUtils.project.name
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
							var mutatorFolderAndFile = file.path.indexOf("/") != - 1 ? file.path.substring(file.path.lastIndexOf("/" + getProjectName)).replace("\\", "/") : file.path.substring(file.path.lastIndexOf("\\" + getProjectName)).replace("\\", "/") 
							mutatorPath = "file:/" + ProjectUtils.getProject.getLocation.toFile.getPath+mutatorFolderAndFile
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
public class «getProjectName.replaceAll("[.]", "_")»DynamicLauncher implements IMutatorExecutor {
«ELSE»
public class «getProjectName.replaceAll("[.]", "_")»StandaloneLauncher implements IMutatorStandaloneExecutor {
«ENDIF»

	«IF standalone == false»
	public MutationResults execute(int maxAttempts, int numMutants, boolean registry, boolean metrics, boolean debugMetrics, String[] blockNames, IProject project, IProgressMonitor monitor, boolean serialize, Object testObject, Map<String, List<String>> classes, Map<String, EPackage> registeredPackages) throws ReferenceNonExistingException, WrongAttributeTypeException, 
												  MaxSmallerThanMinException, AbstractCreationException, ObjectNoTargetableException, 
												  ObjectNotContainedException, MetaModelNotFoundException, ModelNotFoundException, IOException {
	«ELSE»
	public MutationResults execute(int maxAttempts, int numMutants, boolean registry, boolean metrics, boolean debugMetrics, String[] blockNames, IProgressMonitor monitor, boolean serialize, Object testObject, Map<String, List<String>> classes, Map<String, EPackage> registeredPackages) throws ReferenceNonExistingException, WrongAttributeTypeException, 
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
				«mut.object.expression.method(0, false)»
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
				«mut.object.expression.method(0, false)»
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
			objectSelection = new SpecificObjectSelection(packages, model, object);
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
			objectSelection = new SpecificObjectSelection(packages, model, object);
			«ENDIF»
			«ENDIF»
		«ENDIF»
				
		Map<String, List<AttributeConfigurationStrategy>> attsList = new LinkedHashMap<String, List<AttributeConfigurationStrategy>>();
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
		Map<String, List<ReferenceConfigurationStrategy>> refsList = new LinkedHashMap<String, List<ReferenceConfigurationStrategy>>();
		Map<String, List<AttributeConfigurationStrategy>> attsRefList = new LinkedHashMap<String, List<AttributeConfigurationStrategy>>();
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
	   			«IF referenceInit.object instanceof RandomTypeSelection»
	   				if (obSelection != null && obSelection.getObject() != null) {
   						List<ReferenceConfigurationStrategy> refs = null;
   						if (refsList.get("«referenceName»") != null) {
   							refs = refsList.get("«referenceName»");
   						}
   						else {
   							refs = new ArrayList<ReferenceConfigurationStrategy>();
   						}
		   				refs.add(new RandomReferenceConfigurationStrategy(obSelection.getModel(), obSelection.getObject(), "«referenceInit.getReference().get(0).name»", "«(referenceInit.object as RandomTypeSelection).type.name»"));
   						refsList.put("«referenceName»", refs);
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
						AttributeConfigurationStrategy attConfig = null;
						«referenceAtt.value.method(true, false, "objectSelection")»
						attsRef.add(attConfig);
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
			«mut.object.expression.method(0, false)»
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
			«mut.object.expression.method(0, false)»
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
			objectSelection = new SpecificObjectSelection(packages, model, object);
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
			objectSelection = new SpecificObjectSelection(packages, model, object);
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
					Map<String, List<AttributeConfigurationStrategy>> attsList = new LinkedHashMap<String, List<AttributeConfigurationStrategy>>();
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
					«c.method(false, true, 1, true, "obSelection")»
				}
				«ENDFOR»
		Map<String, List<ReferenceConfigurationStrategy>> refsList = new LinkedHashMap<String, List<ReferenceConfigurationStrategy>>();
		Map<String, List<AttributeConfigurationStrategy>> attsRefList = new LinkedHashMap<String, List<AttributeConfigurationStrategy>>();
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
	   			«IF referenceInit.object instanceof RandomTypeSelection»
	   				if (obSelection != null && obSelection.getObject() != null) {
   						List<ReferenceConfigurationStrategy> refs = null;
   						if (refsList.get("«referenceName»") != null) {
   							refs = refsList.get("«referenceName»");
   						}
   						else {
   							refs = new ArrayList<ReferenceConfigurationStrategy>();
   						}
		   				refs.add(new RandomReferenceConfigurationStrategy(obSelection.getModel(), obSelection.getObject(), "«referenceInit.getReference().get(0).name»", "«(referenceInit.object as RandomTypeSelection).type.name»"));
   						refsList.put("«referenceName»", refs);
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
						AttributeConfigurationStrategy attConfig = null;
						«referenceAtt.value.method(true, true, "obSelection")»
						attsRef.add(attConfig);
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
					if (muts != null) {
						muts.getMuts().clear();
					}
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
		Map<String, AttributeConfigurationStrategy> atts = new LinkedHashMap<String, AttributeConfigurationStrategy>();
		ObSelectionStrategy objectSelection = null;
		//«var counter = 0»
		«FOR c : mut.attributes»
			//«counter++»
			«c.method(false, false, counter, false, "objectSelection")»
		«ENDFOR»
		Map<String, ObSelectionStrategy> refs = new LinkedHashMap<String, ObSelectionStrategy>();
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
		Map<String, AttributeConfigurationStrategy> atts = new LinkedHashMap<String, AttributeConfigurationStrategy>();
		ObSelectionStrategy objectSelection = null;
		//«var counter = 0»
		«FOR c : mut.attributes»
			//«counter++»
			«c.method(false, false, counter, true, "objectSelection")»
		«ENDFOR»
		Map<String, ObSelectionStrategy> refs = new LinkedHashMap<String, ObSelectionStrategy>();
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
					if (muts != null) {
						muts.getMuts().clear();
					}
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
		//«var int i = 0»
		//«var int j = 0»
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
			//«val String resourcePath = ProjectUtils.getProject.getLocation.toFile.getPath + "/" + source.path»
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
			String relativeMetamodelPath = "«metamodelPath.indexOf("/" + getProjectName + "/") != - 1 ? metamodelPath.substring(metamodelPath.lastIndexOf("/"  + getProjectName + "/") + ("/" + getProjectName + "/").length(), metamodelPath.length()) : metamodelPath»";
			relativeMetamodelPath = relativeMetamodelPath.startsWith("/") == true ? relativeMetamodelPath.substring(1, relativeMetamodelPath.length()) : relativeMetamodelPath; 
			String absoluteMetamodelPath = «className».class.getProtectionDomain().getCodeSource().getLocation().getPath().replace("/bin/", "/") + relativeMetamodelPath;
			«IF standalone == false»
			resourcePackages = ModelManager.loadMetaModel(absoluteMetamodelPath, this.getClass());
			«ELSE»
			resourcePackages = ModelManager.loadMetaModel(absoluteMetamodelPath, «className».class);
			«ENDIF»
			resources = new ArrayList<Resource>();
			«FOR resourceURI : resourceURIs»
				String relativeResourceURI_«i» = "«resourceURI.replace("\\", "/").indexOf("/" + getProjectName + "/") != - 1 ? resourceURI.replace("\\", "/").substring(resourceURI.replace("\\", "/").lastIndexOf("/" + getProjectName + "/") + ("/" + getProjectName + "/").length(), resourceURI.replace("\\", "/").length()) : resourceURI»";
				String absoluteResourceURI_«i» = «className».class.getProtectionDomain().getCodeSource().getLocation().getPath().replace("/bin/", "/") + relativeResourceURI_«i»;
				absoluteResourceURI_«i» = "file:/" + absoluteResourceURI_«i».substring(1, absoluteResourceURI_«i».length()); 
				«IF standalone == false»
				resources.add(ModelManager.loadModel(resourcePackages, URI.createURI(absoluteResourceURI_«i»).toFileString()));
				«ELSE»
				resources.add(ModelManager.loadModelNoException(resourcePackages, URI.createURI(absoluteResourceURI_«i»).toFileString()));
				«ENDIF»
				«{i++; ""}»
			«ENDFOR»
			«FOR ecoreURI : ecoreURIs»
				String relativeEcoreURI_«j» = "«ecoreURI.replace("\\", "/").substring(ecoreURI.replace("\\", "/").lastIndexOf("/" + getProjectName + "/") + ("/" + getProjectName + "/").length(), ecoreURI.replace("\\", "/").length())»";
				String absoluteEcoreURI_«j» = «className».class.getProtectionDomain().getCodeSource().getLocation().getPath().replace("/bin/", "/") + relativeEcoreURI_«j»;
				absoluteEcoreURI_«j» = "file:/" + absoluteEcoreURI_«j».substring(1, absoluteEcoreURI_«j».length()); 
				«IF standalone == false»
				resources.add(ModelManager.loadMetaModelAsResource(resourcePackages, URI.createURI(absoluteEcoreURI_«j»).toFileString()));
				«ELSE»
				resources.add(ModelManager.loadMetaModelAsResourceNoException(resourcePackages, URI.createURI(absoluteEcoreURI_«j»).toFileString()));
				«ENDIF»
				«{j++; ""}»
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
			List<EPackage> savedPackages = new ArrayList<EPackage>();
			savedPackages.addAll(packages);
			packages.clear();
			List<EPackage> objectPackages = null;
			resources = new ArrayList<Resource>();
			//«val Source source = resource.path»
			//«val String resourcePath = ProjectUtils.getProject.getLocation.toFile.getPath + "/" + source.path»
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
			«FOR resourceURI : resourceURIs»
				String relativeResourceURI_«i» = "«resourceURI.replace("\\", "/").indexOf("/" + getProjectName + "/") != - 1 ? resourceURI.replace("\\", "/").substring(resourceURI.replace("\\", "/").lastIndexOf("/" + getProjectName + "/") + ("/" + getProjectName + "/").length(), resourceURI.replace("\\", "/").length()) : resourceURI»";
				String absoluteResourceURI_«i» = «className».class.getProtectionDomain().getCodeSource().getLocation().getPath().replace("/bin/", "/") + relativeResourceURI_«i»;
				absoluteResourceURI_«i» = "file:/" + absoluteResourceURI_«i».substring(1, absoluteResourceURI_«i».length()); 
				«IF standalone == false»
				resources.add(ModelManager.loadModel(resourcePackages, URI.createURI(absoluteResourceURI_«i»).toFileString()));
				«ELSE»
				resources.add(ModelManager.loadModelNoException(resourcePackages, URI.createURI(absoluteResourceURI_«i»).toFileString()));
				«ENDIF»
				«{i++; ""}»
			«ENDFOR»
			«FOR ecoreURI : ecoreURIs»
				String relativeEcoreURI_«j» = "«ecoreURI.replace("\\", "/").substring(ecoreURI.replace("\\", "/").lastIndexOf("/" + getProjectName + "/") + ("/" + getProjectName + "/").length(), ecoreURI.replace("\\", "/").length())»";
				String absoluteEcoreURI_«j» = «className».class.getProtectionDomain().getCodeSource().getLocation().getPath().replace("/bin/", "/") + relativeEcoreURI_«j»;
				absoluteEcoreURI_«j» = "file:/" + absoluteEcoreURI_«j».substring(1, absoluteEcoreURI_«j».length()); 
				«IF standalone == false»
				resources.add(ModelManager.loadMetaModelAsResource(resourcePackages, URI.createURI(absoluteEcoreURI_«j»).toFileString()));
				«ELSE»
				resources.add(ModelManager.loadMetaModelAsResourceNoException(resourcePackages, URI.createURI(absoluteEcoreURI_«j»).toFileString()));
				«ENDIF»
				«{j++; ""}»
			«ENDFOR»
			//«val String metamodelPath = resource.metamodel.replace("\\", "/")»
			String relativeObjectMetamodelPath = "«metamodelPath.substring(metamodelPath.lastIndexOf("/"  + getProjectName + "/") + ("/" + getProjectName + "/").length(), metamodelPath.length())»";
			String absoluteObjectMetamodelPath = «className».class.getProtectionDomain().getCodeSource().getLocation().getPath().replace("/bin/", "/") + relativeObjectMetamodelPath;
			«IF standalone == false»
			objectPackages = ModelManager.loadMetaModel(absoluteObjectMetamodelPath, this.getClass());
			«ELSE»
			objectPackages = ModelManager.loadMetaModel(absoluteObjectMetamodelPath, «className».class);
			«ENDIF»
			packages.addAll(objectPackages);
			«ENDIF»
			«IF (mut.object.expression !== null)»
				«IF (mut.container === null)»
				List<EObject> objects = rts.getObjects();
				//EXPRESSION LIST: «expressionList = new ArrayList<Integer>()»
				//EXPRESSION LEVEL: «nExpression = 0»
				//EXPRESSION LEVEL: «expressionList.add(0)»
				Expression exp«expressionList.get(0)» = new Expression();
				«mut.object.expression.method(0, true)»
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
				«mut.object.expression.method(0, true)»
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
				«mut.container.expression.method(0, true)»
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
			«IF resource !== null»
			packages.clear();
			packages.addAll(savedPackages);
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
		//«var boolean rts = false»
		//«var int i = 0»
		//«var int j = 0»
		List<ObSelectionStrategy> containerSelectionList = new ArrayList<ObSelectionStrategy>();
		List<SpecificReferenceSelection> referenceSelectionList = new ArrayList<SpecificReferenceSelection>();
		List<EPackage> resourcePackages = new ArrayList<EPackage>();
		List<Resource> resources = new ArrayList<Resource>();
				//«val List<String> resourceURIs = new ArrayList<String>()»
							//«val List<String> ecoreURIs = new ArrayList<String>()»
							//«val String resourceName = mut.object.resource»
							//«var mutatorenvironment.Resource resource = null»
							«FOR res : program.resources»
								«IF res.name.equals(resourceName)»
									//«resource = res» 
								«ENDIF»
							«ENDFOR»
		«IF resource === null»
		resources.add(model);
		resourcePackages.addAll(packages);
		«ELSE»
			//«val Source source = resource.path»
			//«val String resourcePath = ProjectUtils.getProject.getLocation.toFile.getPath + "/" + source.path»
			«FOR resourceFile : (new File(resourcePath)).listFiles»
				«IF resourceFile.name.endsWith(".model")»
					//«resourceURIs.add(resourceFile.path)»
				«ENDIF»
				«IF resourceFile.name.endsWith(".ecore")»
					//«ecoreURIs.add(resourceFile.path)»
				«ENDIF»
			«ENDFOR»
			//«val String metamodelPath = resource.metamodel.replace("\\", "/")»
			String relativeMetamodelPath = "«metamodelPath.indexOf("/" + getProjectName + "/") != - 1 ? metamodelPath.substring(metamodelPath.lastIndexOf("/"  + getProjectName + "/") + ("/" + getProjectName + "/").length(), metamodelPath.length()) : metamodelPath»";
			relativeMetamodelPath = relativeMetamodelPath.startsWith("/") == true ? relativeMetamodelPath.substring(1, relativeMetamodelPath.length()) : relativeMetamodelPath; 
			String absoluteMetamodelPath = «className».class.getProtectionDomain().getCodeSource().getLocation().getPath().replace("/bin/", "/") + relativeMetamodelPath;
			«IF standalone == false»
			resourcePackages = ModelManager.loadMetaModel(absoluteMetamodelPath, this.getClass());
			«ELSE»
			resourcePackages = ModelManager.loadMetaModel(absoluteMetamodelPath, «className».class);
			«ENDIF»
			resources = new ArrayList<Resource>();
			«FOR resourceURI : resourceURIs»
				String relativeResourceURI_«i» = "«resourceURI.replace("\\", "/").indexOf("/" + getProjectName + "/") != - 1 ? resourceURI.replace("\\", "/").substring(resourceURI.replace("\\", "/").lastIndexOf("/" + getProjectName + "/") + ("/" + getProjectName + "/").length(), resourceURI.replace("\\", "/").length()) : resourceURI»";
				String absoluteResourceURI_«i» = «className».class.getProtectionDomain().getCodeSource().getLocation().getPath().replace("/bin/", "/") + relativeResourceURI_«i»;
				absoluteResourceURI_«i» = "file:/" + absoluteResourceURI_«i».substring(1, absoluteResourceURI_«i».length()); 
				«IF standalone == false»
				resources.add(ModelManager.loadModel(resourcePackages, URI.createURI(absoluteResourceURI_«i»).toFileString()));
				«ELSE»
				resources.add(ModelManager.loadModelNoException(resourcePackages, URI.createURI(absoluteResourceURI_«i»).toFileString()));
				«ENDIF»
				«{i++; ""}»
			«ENDFOR»
			«FOR ecoreURI : ecoreURIs»
				String relativeEcoreURI_«j» = "«ecoreURI.replace("\\", "/").substring(ecoreURI.replace("\\", "/").lastIndexOf("/" + getProjectName + "/") + ("/" + getProjectName + "/").length(), ecoreURI.replace("\\", "/").length())»";
				String absoluteEcoreURI_«j» = «className».class.getProtectionDomain().getCodeSource().getLocation().getPath().replace("/bin/", "/") + relativeEcoreURI_«j»;
				absoluteEcoreURI_«j» = "file:/" + absoluteEcoreURI_«j».substring(1, absoluteEcoreURI_«j».length()); 
				«IF standalone == false»
				resources.add(ModelManager.loadMetaModelAsResource(resourcePackages, URI.createURI(absoluteEcoreURI_«j»).toFileString()));
				«ELSE»
				resources.add(ModelManager.loadMetaModelAsResourceNoException(resourcePackages, URI.createURI(absoluteEcoreURI_«j»).toFileString()));
				«ENDIF»
				«{j++; ""}»
			«ENDFOR»
		«ENDIF»
		«IF mut.object instanceof RandomTypeSelection || mut.object instanceof CompleteTypeSelection»
		«IF mut.container === null»
			«IF mut.object instanceof RandomTypeSelection»
			//«rts = true»
			«IF mut.object.resource === null»
			RandomTypeSelection rts = new RandomTypeSelection(packages, model, "«(mut.object as RandomTypeSelection).type.name»");
			«ELSE»
			RandomTypeSelection rts = new RandomTypeSelection(resourcePackages, resources, "«(mut.object as RandomTypeSelection).type.name»");
			«ENDIF»
			«IF mut.object instanceof CompleteTypeSelection»
			//«rts = true»
			«IF mut.object.resource === null»
			RandomTypeSelection rts = new RandomTypeSelection(packages, model, "«(mut.object as CompleteTypeSelection).type.name»");
			«ELSE»
			RandomTypeSelection rts = new RandomTypeSelection(resourcePackages, resources, "«(mut.object as CompleteTypeSelection).type.name»");
			«ENDIF»
			«ENDIF»
			«ENDIF»
		«ENDIF»
		«IF mut.container !== null»
			«IF mut.container instanceof RandomTypeSelection»
				//«rts = true»
				«IF mut.container.resource === null»
				RandomTypeSelection rts = new RandomTypeSelection(packages, model, "«(mut.container as RandomTypeSelection).type.name»");
				«ELSE»
				RandomTypeSelection rts = new RandomTypeSelection(resourcePackages, resources, "«(mut.container as RandomTypeSelection).type.name»");
				«ENDIF»
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
					«IF mut.container.resource === null»
					ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, container);
					SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model, "«refName»", containerSelection);
					«ELSE»
					ObSelectionStrategy containerSelection = new SpecificObjectSelection(resourcePackages, resources, container);
					SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(resourcePackages, resources, "«refName»", containerSelection);
					«ENDIF»
					containerSelectionList.add(containerSelection);
					referenceSelectionList.add(referenceSelection);
				«ELSE»
					«IF mut.container.resource === null»
					ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, container);
					SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model, null, null);
					«ELSE»
					ObSelectionStrategy containerSelection = new SpecificObjectSelection(resourcePackages, resources, container);
					SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(resourcePackages, resources, null, null);
					«ENDIF»
					containerSelectionList.add(containerSelection);
					referenceSelectionList.add(referenceSelection);
				«ENDIF»
			«ELSEIF mut.container instanceof CompleteTypeSelection»
				//«rts = true»
				«IF mut.container.resource === null»
				RandomTypeSelection rts = new RandomTypeSelection(packages, model, "«(mut.container as CompleteTypeSelection).type.name»");
				«ELSE»
				RandomTypeSelection rts = new RandomTypeSelection(resourcePackages, resources, "«(mut.container as CompleteTypeSelection).type.name»");
				«ENDIF»
				EObject container = rts.getObject();
				«IF mut.container.resource === null»
				ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, container);
				«ELSE»
				ObSelectionStrategy containerSelection = new SpecificObjectSelection(resourcePackages, resources, container);
				«ENDIF»
				containerSelectionList.add(containerSelection);
				«IF mut.container.refType !== null»
				«IF mut.container.resource === null»
					SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model, "«mut.container.refType.name»", containerSelection);
				«ELSE»
					SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(resourcePackages, resources, "«mut.container.refType.name»", containerSelection);
				«ENDIF»
					referenceSelectionList.add(referenceSelection);
				«ELSE»
				«IF mut.container.resource === null»
					SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model, null, null);
				«ELSE»
					SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(resourcePackages, resources, null, null);
				«ENDIF»
					referenceSelectionList.add(referenceSelection);
				«ENDIF»
			«ELSEIF mut.container instanceof SpecificObjectSelection»
					SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.container as SpecificObjectSelection).objSel.name» = hmObjects.get("«(mut.container as SpecificObjectSelection).objSel.name»");
					if (entry_«(mut.container as SpecificObjectSelection).objSel.name» != null) {
						«IF mut.container.resource === null»
						EObject recovered = ModelManager.getObject(model, entry_«(mut.container as SpecificObjectSelection).objSel.name».getKey());
						«ELSE»
						EObject recovered = ModelManager.getObject(resources, entry_«(mut.container as SpecificObjectSelection).objSel.name».getKey());
						«ENDIF»
						if (recovered == null) {
							recovered = entry_«(mut.container as SpecificObjectSelection).objSel.name».getKey();
						}
						«IF mut.container.resource === null»
						resourcePackages = packages;
						resources = new ArrayList<Resource>();
						resources.add(model);
						ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
						«ELSE»
						ObSelectionStrategy containerSelection = new SpecificObjectSelection(resourcePackages, resources, recovered);
						«ENDIF»
						containerSelectionList.add(containerSelection);
					} else {
						List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_«(mut.container as SpecificObjectSelection).objSel.name» = hmList.get("«(mut.container as SpecificObjectSelection).objSel.name»");
						if (listEntry_«(mut.container as SpecificObjectSelection).objSel.name» != null) {
							List<EObject> objs = new ArrayList<EObject>();
						«IF mut.container.resource === null»
							resourcePackages = packages;
							resources = new ArrayList<Resource>();
							resources.add(model);
						«ENDIF»
							for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_«(mut.container as SpecificObjectSelection).objSel.name») {
								«IF mut.container.resource === null»
								EObject obj = ModelManager.getObject(model, ent.getKey());
								«ELSE»
								EObject obj = ModelManager.getObject(resources, ent.getKey());
								«ENDIF»
								if (obj == null) {
									obj = ent.getKey();
								}
								objs.add(obj);
							}
							«IF mut.container.resource === null»
							ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, objs);
							«ELSE»
							ObSelectionStrategy containerSelection = new SpecificObjectSelection(resourcePackages, resources, objs);
							«ENDIF»
							containerSelectionList.add(containerSelection);
						}
						else {
							return numMutantsGenerated;
						}
					}
					«IF mut.container.refType !== null»
						if (entry_«(mut.container as SpecificObjectSelection).objSel.name» != null) {
								«IF mut.container.resource === null»
							EObject obRecovered = ModelManager.getObject(model, entry_«(mut.container as SpecificObjectSelection).objSel.name».getKey());
								«ELSE»
							EObject obRecovered = ModelManager.getObject(resources, entry_«(mut.container as SpecificObjectSelection).objSel.name».getKey());
							«ENDIF»
							Object valueRecovered = obRecovered;
							Object valueRec = null;
							//«var refName = mut.container.refType.name»
							«IF mut.container.refRefType !== null»
							valueRec = ModelManager.getReferenced("«mut.container.refType.name»", (EObject) valueRecovered);
							if (valueRec instanceof EObject) {
								valueRecovered = (EObject) valueRec;
							}
							if (valueRec instanceof List<?>) {
								valueRecovered = (List<EObject>) valueRec;
							}
							//«refName = mut.container.refRefType.name»
							«ENDIF»
							«IF mut.container.refRefRefType !== null»
							if (valueRecovered instanceof EObject) {
								valueRec = ModelManager.getReferenced("«mut.container.refRefType.name»", (EObject) valueRecovered);
							}
							if (valueRecovered instanceof List<?>) {
								valueRec = ModelManager.getReferenced("«mut.container.refRefType.name»", (List<EObject>) valueRecovered);
							}
							if (valueRec instanceof EObject) {
								valueRecovered = (EObject) valueRec;
							}
							if (valueRec instanceof List<?>) {
								valueRecovered = (List<EObject>) valueRec;
							}
							//«refName = mut.container.refRefRefType.name»
							«ENDIF»
							if (valueRecovered == null) {
								obRecovered = entry_«(mut.container as SpecificObjectSelection).objSel.name».getKey();
								valueRecovered = obRecovered;
								valueRec = null;
								//«refName = mut.container.refType.name»
								«IF mut.container.refRefType !== null»
								valueRec = ModelManager.getReferenced("«mut.container.refType.name»", (EObject) valueRecovered);
								if (valueRec instanceof EObject) {
									valueRecovered = (EObject) valueRec;
								}
								if (valueRec instanceof List<?>) {
									valueRecovered = (List<EObject>) valueRec;
								}
								//«refName = mut.container.refRefType.name»
								«ENDIF»
								«IF mut.container.refRefRefType !== null»
								if (valueRecovered instanceof EObject) {
									valueRec = ModelManager.getReferenced("«mut.container.refRefType.name»", (EObject) valueRecovered);
								}
								if (valueRecovered instanceof List<?>) {
									valueRec = ModelManager.getReferenced("«mut.container.refRefType.name»", (List<EObject>) valueRecovered);
								}
								if (valueRec instanceof EObject) {
									valueRecovered = (EObject) valueRec;
								}
								if (valueRec instanceof List<?>) {
									valueRecovered = (List<EObject>) valueRec;
								}
								//«refName = mut.container.refRefRefType.name»
								«ENDIF»
							}
							if (valueRecovered instanceof EObject) {
								EObject recovered = (EObject) valueRecovered;
								«IF mut.container.resource === null»
								ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
								«ELSE»
								ObSelectionStrategy containerSelection = new SpecificObjectSelection(resourcePackages, resources, recovered);
								«ENDIF»
								containerSelectionList.clear();
								containerSelectionList.add(containerSelection);
								«IF mut.container.resource === null»
								resourcePackages = packages;
								resources = new ArrayList<Resource>();
								resources.add(model);
								«ENDIF»
								SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(resourcePackages, resources, "«refName»", recovered);
								referenceSelectionList.clear();
								referenceSelectionList.add(referenceSelection);
							}
							if (valueRecovered instanceof List<?>) {
								List<EObject> recoveredList = (List<EObject>) valueRecovered;
								containerSelectionList.clear();
								referenceSelectionList.clear();
								for (EObject recovered : recoveredList) {
								«IF mut.container.resource === null»
									ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
								«ELSE»
									ObSelectionStrategy containerSelection = new SpecificObjectSelection(resourcePackages, resources, recovered);
								«ENDIF»
									containerSelectionList.add(containerSelection);
									resourcePackages = packages;
									resources = new ArrayList<Resource>();
									resources.add(model);
									SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(resourcePackages, resources, "«refName»", recovered);
									referenceSelectionList.add(referenceSelection);
								}
							}
						} else {
							List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_«(mut.container as SpecificObjectSelection).objSel.name» = hmList.get("«(mut.container as SpecificObjectSelection).objSel.name»");
							if (listEntry_«(mut.container as SpecificObjectSelection).objSel.name» != null) {
								List<EObject> objs = new ArrayList<EObject>();
								«IF mut.container.resource === null»
								resourcePackages = packages;
								resources = new ArrayList<Resource>();
								resources.add(model);
								«ENDIF»
								EObject obRecovered = ModelManager.getObject(resources, listEntry_«(mut.container as SpecificObjectSelection).objSel.name».get(0).getKey());
								Object valueRec = null;
								if (obRecovered == null) {
									obRecovered = listEntry_«(mut.container as SpecificObjectSelection).objSel.name».get(0).getKey();
								}
								Object valueRecovered = obRecovered;
								//«refName = mut.container.refType.name»
								«IF mut.container.refRefType !== null»
								valueRec = ModelManager.getReferenced("«mut.container.refType.name»", (EObject) valueRecovered);
								if (valueRec instanceof EObject) {
									valueRecovered = (EObject) valueRec;
								}
								if (valueRec instanceof List<?>) {
									valueRecovered = (List<EObject>) valueRec;
								}
								//«refName = mut.container.refRefType.name»
								«IF mut.container.refRefRefType !== null»
								if (valueRecovered instanceof EObject) {
									valueRec = ModelManager.getReferenced("«mut.container.refRefType.name»", (EObject) valueRecovered);
								}
								if (valueRecovered instanceof List<?>) {
									valueRec = ModelManager.getReferenced("«mut.container.refRefType.name»", (List<EObject>) valueRecovered);
								}
								if (valueRec instanceof EObject) {
									valueRecovered = (EObject) valueRec;
								}
								if (valueRec instanceof List<?>) {
									valueRecovered = (List<EObject>) valueRec;
								}
								//«refName = mut.container.refRefRefType.name»
								«ENDIF»
								«ENDIF»
								if (valueRecovered instanceof EObject) {
									EObject recovered = (EObject) valueRecovered;
								«IF mut.container.resource === null»
									ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
								«ELSE»
									ObSelectionStrategy containerSelection = new SpecificObjectSelection(resourcePackages, resources, recovered);
								«ENDIF»
									containerSelectionList.clear();
									containerSelectionList.add(containerSelection);
								«IF mut.container.resource === null»
									SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model, "«refName»", recovered);
								«ELSE»
									SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(resourcePackages, resources, "«refName»", recovered);
								«ENDIF»
									referenceSelectionList.clear();
									referenceSelectionList.add(referenceSelection);
								}
								if (valueRecovered instanceof List<?>) {
									List<EObject> recoveredList = (List<EObject>) valueRecovered;
									containerSelectionList.clear();
									referenceSelectionList.clear();
									for (EObject recovered : recoveredList) {
								«IF mut.container.resource === null»
										ObSelectionStrategy containerSelection = new SpecificObjectSelection(packages, model, recovered);
										SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model, "«refName»", recovered);
								«ELSE»
										ObSelectionStrategy containerSelection = new SpecificObjectSelection(resourcePackages, resources, recovered);
										SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(resourcePackages, resources, "«refName»", recovered);
								«ENDIF»
										containerSelectionList.add(containerSelection);
										referenceSelectionList.add(referenceSelection);
									}
								}
							}
							else {
								return numMutantsGenerated;
							}
						}
					«ELSE»
						SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model, null, null);
						referenceSelectionList.add(referenceSelection);
					«ENDIF»
				«ELSEIF mut.container instanceof SpecificClosureSelection»
					SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.container as SpecificClosureSelection).objSel.name» = hmObjects.get("«(mut.container as SpecificClosureSelection).objSel.name»");
					if (entry_«(mut.container as SpecificClosureSelection).objSel.name» != null) {
						EObject recovered = ModelManager.getObject(model, entry_«(mut.container as SpecificClosureSelection).objSel.name».getKey());
						if (recovered == null) {
							recovered = entry_«(mut.container as SpecificClosureSelection).objSel.name».getKey();
						}
					«IF mut.container.resource === null»
						
						resourcePackages = packages;
						resources = new ArrayList<Resource>();
						resources.add(model);
					«ENDIF»
						ObSelectionStrategy containerSelection = new SpecificClosureSelection(resourcePackages, resources, recovered, "«(mut.container as SpecificClosureSelection).refType.name»");
						containerSelectionList.add(containerSelection);
					} else {
						List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_«(mut.container as SpecificClosureSelection).objSel.name» = hmList.get("«(mut.container as SpecificClosureSelection).objSel.name»");
						if (listEntry_«(mut.container as SpecificClosureSelection).objSel.name» != null) {
					«IF mut.container.resource === null»
							List<EObject> objs = new ArrayList<EObject>();
							resourcePackages = packages;
							resources = new ArrayList<Resource>();
							resources.add(model);
					«ENDIF»
							for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_«(mut.container as SpecificClosureSelection).objSel.name») {
								EObject obj = ModelManager.getObject(resources, ent.getKey());
								if (obj == null) {
									obj = ent.getKey();
								}
								objs.add(obj);
							}
							ObSelectionStrategy containerSelection = new SpecificClosureSelection(resourcePackages, resources, objs, "«(mut.container as SpecificClosureSelection).refType.name»");
							containerSelectionList.add(containerSelection);
						}
						else {
							return numMutantsGenerated;
						}
					}
					«IF mut.container.refType !== null»
						if (entry_«(mut.container as SpecificClosureSelection).objSel.name» != null) {
					«IF mut.container.resource === null»
							EObject recovered = ModelManager.getObject(model, entry_«(mut.container as SpecificClosureSelection).objSel.name».getKey());
					«ELSE»
							EObject recovered = ModelManager.getObject(resources, entry_«(mut.container as SpecificClosureSelection).objSel.name».getKey());
					«ENDIF»
							if (recovered == null) {
								recovered = entry_«(mut.container as SpecificClosureSelection).objSel.name».getKey();
							}
					«IF mut.container.resource === null»
							resourcePackages = packages;
							resources = new ArrayList<Resource>();
							resources.add(model);
					«ENDIF»
							SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(resourcePackages, resources, "«mut.container.refType.name»", recovered);
							referenceSelectionList.add(referenceSelection);
						} else {
							return numMutantsGenerated;
						}
					«ELSE»
					«IF mut.container.resource === null»
						SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(packages, model, null, null);
					«ELSE»
						SpecificReferenceSelection referenceSelection = new SpecificReferenceSelection(resourcePackages, resources, null, null);
					«ENDIF»
						referenceSelectionList.add(referenceSelection);
					«ENDIF»
			«ENDIF»
		«ENDIF»
		«IF mut.object instanceof RandomTypeSelection || mut.object instanceof CompleteTypeSelection»
		«IF mut.container !== null»
		for (int j = 0; j < containerSelectionList.size(); j++) {
		«ENDIF»
			«IF rts == true»
			«IF mut.container !== null»
			rts = new RandomTypeSelection(containerSelectionList.get(j).getMetaModel(), containerSelectionList.get(j).getModel(), "«mut.object.type.name»", referenceSelectionList.get(j), containerSelectionList.get(j));
			«ELSE»
			«IF mut.object.resource === null»
			rts = new RandomTypeSelection(packages, model, "«mut.object.type.name»");
			«ELSE»
			rts = new RandomTypeSelection(resourcePackages, resources, "«mut.object.type.name»");
			«ENDIF»
			«ENDIF»
			«ELSE»
			«IF mut.container !== null»
			RandomTypeSelection rts = new RandomTypeSelection(containerSelectionList.get(j).getMetaModel(), containerSelectionList.get(j).getModel(), "«mut.object.type.name»", referenceSelectionList.get(j), containerSelectionList.get(j));
			//«rts = true»
			«ELSE»
			«IF mut.object.resource === null»
			RandomTypeSelection rts = new RandomTypeSelection(packages, model, "«mut.object.type.name»");
			«ELSE»
			RandomTypeSelection rts = new RandomTypeSelection(resourcePackages, resources, "«mut.object.type.name»");
			«ENDIF»
			//«rts = true»
			«ENDIF»
			«ENDIF»
			«IF mut.container !== null»
				«IF ((mut.object.expression === null) && (mut.container.expression === null) && !(mut.object instanceof CompleteTypeSelection))»
					List<EObject> objects = rts.getObjects();
				«ENDIF»
			«ELSE»
			«IF ((mut.object.expression === null) && (mut.container === null) && !(mut.object instanceof CompleteTypeSelection))»
				List<EObject> objects = rts.getObjects();
			«ENDIF»
			«ENDIF»
			«IF mut.object.resource !== null»
			List<EPackage> savedPackages = new ArrayList<EPackage>();
			savedPackages.addAll(packages);
			packages.clear();
			packages.addAll(resourcePackages);
			«ENDIF»
			«IF (mut.object.expression !== null)»
				«IF (mut.container === null)»
				List<EObject> objects = rts.getObjects();
				//EXPRESSION LIST: «expressionList = new ArrayList<Integer>()»
				//EXPRESSION LEVEL: «nExpression = 0»
				//EXPRESSION LEVEL: «expressionList.add(0)»
				Expression exp«expressionList.get(0)» = new Expression();
				«IF mut.object.resource === null»
				«mut.object.expression.method(0, false)»
				«ELSE»
				«mut.object.expression.method(0, true)»
				«ENDIF»
				objects = evaluate(objects, exp«expressionList.get(0)»);
				«ELSEIF (mut.container.expression === null)»
				List<EObject> objects = rts.getObjects();
				//EXPRESSION LIST: «expressionList = new ArrayList<Integer>()»
				//EXPRESSION LEVEL: «nExpression = 0»
				//EXPRESSION LEVEL: «expressionList.add(0)»
				Expression exp«expressionList.get(0)» = new Expression();
				«IF mut.object.resource === null»
				«mut.object.expression.method(0, false)»
				«ELSE»
				«mut.object.expression.method(0, true)»
				«ENDIF»
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
				«IF mut.container.resource === null»
				«mut.container.expression.method(0, false)»
				«ELSE»
				«mut.container.expression.method(0, true)»
				«ENDIF»
				objects = evaluate(objects, exp«expressionList.get(0)»);
				«ENDIF»
				«IF ((mut.container !== null) && (mut.container.expression === null))»
				«IF mut.object instanceof CompleteTypeSelection»
				List<EObject> objects = rts.getObjects();
				«ENDIF»
				«ENDIF»
			«ENDIF»
			«IF mut.object.resource !== null»
			packages.clear();
			packages.addAll(savedPackages);
			«ENDIF»
			for (EObject object : objects) {
				ObSelectionStrategy objectSelection = null;
				«IF mut.object.refType !== null && mut.object.refType.many»
				List<EObject> o = ModelManager.getReferences("«mut.object.refType.name»", object);
				object = o.get(ModelManager.getRandomIndex(o));
				«ELSEIF mut.object.refType !== null && !mut.object.refType.many»
				object = (EObject) ModelManager.getReferenced("«mut.object.refType.name»", object);
				«ENDIF»
				Resource resource = ModelManager.cloneModel(model, model.getURI().toFileString());
				«IF mut.object.resource === null»
				object = ModelManager.getObject(resource, object);
				«ELSE»
				Resource readOnlyResource = ModelManager.findModel(resources, object);
				object = ModelManager.getObject(readOnlyResource, object);
				«ENDIF»
				if (object != null) {
				«IF mut.object.resource === null»
					objectSelection = new SpecificObjectSelection(packages, resource, object);
				«ELSE»
					objectSelection = new SpecificObjectSelection(resourcePackages, readOnlyResource, object);
				«ENDIF»
					«IF mut.container !== null»
					SelectObjectMutator mut = new SelectObjectMutator(objectSelection.getModel(), objectSelection.getMetaModel(), referenceSelectionList.get(j), containerSelectionList.get(j), objectSelection);
					«ELSE»
					SelectObjectMutator mut = new SelectObjectMutator(objectSelection.getModel(), objectSelection.getMetaModel(), null, null, objectSelection);
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
					if (muts != null) {
						muts.getMuts().clear();
					}
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
						ObSelectionStrategy obSelection = null;
						«IF mut.object.refType !== null && mut.object.refType.many»
						List<EObject> o = ModelManager.getReferences("«mut.object.refType.name»", object);
						object = o.get(ModelManager.getRandomIndex(o);
						«ELSEIF mut.object.refType !== null && !mut.object.refType.many»
						object = (EObject) ModelManager.getReferenced("«mut.object.refType.name»", object);
						«ENDIF»
						Resource resource = ModelManager.cloneModel(model, model.getURI().toFileString());
						«IF mut.object.resource === null»
						object = ModelManager.getObject(resource, object);
						«ELSE»
						Resource readOnlyResource = ModelManager.findModel(resources, object);
						object = ModelManager.getObject(readOnlyResource, object);
						«ENDIF»
						if (object != null) {
							«IF mut.object.resource === null»
							obSelection = new SpecificObjectSelection(packages, resource, object);
							«ELSE»
							obSelection = new SpecificObjectSelection(resourcePackages, readOnlyResource, object);
							«ENDIF»
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
							mutation«nMethodCall»(packages, resource, hmObjects, hmList, hashmapModelFilenames,
									modelFilename, mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,
									registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, project, monitor, k, serialize, test, classes);
							«ELSE»
							mutation«nMethodCall»(packages, resource, hmObjects, hmList, hashmapModelFilenames,
									modelFilename, mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,
									registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, monitor, k, serialize, test, classes);
							«ENDIF»
							«ENDIF»
							«IF last == true»
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
								if (muts != null) {
									muts.getMuts().clear();
								}
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
						if (muts != null) {
							muts.getMuts().clear();
						}
					}
		«ENDIF»
		«ENDIF»
			}
		}

	«IF mut.container !== null»
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
		//«var int i = 0»
		//«var int j = 0»
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
				«mut.object.expression.method(0, false)»
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
			//«val String resourcePath = ProjectUtils.getProject.getLocation.toFile.getPath + "/" + source.path»
			«FOR resourceFile : (new File(resourcePath)).listFiles»
				«IF resourceFile.name.endsWith(".model")»
					//«resourceURIs.add(resourceFile.path)»
				«ENDIF»
				«IF resourceFile.name.endsWith(".ecore")»
					//«ecoreURIs.add(resourceFile.path)»
				«ENDIF»
			«ENDFOR»
			//«val String metamodelPath = resource.metamodel.replace("\\", "/")»
			String relativeMetamodelPath = "«metamodelPath.indexOf("/" + getProjectName + "/") != - 1 ? metamodelPath.substring(metamodelPath.lastIndexOf("/"  + getProjectName + "/") + ("/" + getProjectName + "/").length(), metamodelPath.length()) : metamodelPath»";
			relativeMetamodelPath = relativeMetamodelPath.startsWith("/") == true ? relativeMetamodelPath.substring(1, relativeMetamodelPath.length()) : relativeMetamodelPath; 
			String absoluteMetamodelPath = «className».class.getProtectionDomain().getCodeSource().getLocation().getPath().replace("/bin/", "/") + relativeMetamodelPath;
			«IF standalone == false»
			List<Resource> resourcePackages = ModelManager.loadMetaModel(absoluteMetamodelPath, this.getClass());
			«ELSE»
			List<Resource> resourcePackages = ModelManager.loadMetaModel(absoluteMetamodelPath, «className».class);
			«ENDIF»
			List<Resource> resources = new ArrayList<Resource>();
			«FOR resourceURI : resourceURIs»
				String relativeResourceURI_«i» = "«resourceURI.replace("\\", "/").indexOf("/" + getProjectName + "/") != - 1 ? resourceURI.replace("\\", "/").substring(resourceURI.replace("\\", "/").lastIndexOf("/" + getProjectName + "/") + ("/" + getProjectName + "/").length(), resourceURI.replace("\\", "/").length()) : resourceURI»";
				String absoluteResourceURI_«i» = «className».class.getProtectionDomain().getCodeSource().getLocation().getPath().replace("/bin/", "/") + relativeResourceURI_«i»;
				absoluteResourceURI_«i» = "file:/" + absoluteResourceURI_«i».substring(1, absoluteResourceURI_«i».length()); 
				«IF standalone == false»
				resources.add(ModelManager.loadModel(resourcePackages, URI.createURI(absoluteResourceURI_«i»).toFileString()));
				«ELSE»
				resources.add(ModelManager.loadModelNoException(resourcePackages, URI.createURI(absoluteResourceURI_«i»).toFileString()));
				«ENDIF»
				«{i++; ""}»
			«ENDFOR»
			«FOR ecoreURI : ecoreURIs»
				String relativeEcoreURI_«j» = "«ecoreURI.replace("\\", "/").substring(ecoreURI.replace("\\", "/").lastIndexOf("/" + getProjectName + "/") + ("/" + getProjectName + "/").length(), ecoreURI.replace("\\", "/").length())»";
				String absoluteEcoreURI_«j» = «className».class.getProtectionDomain().getCodeSource().getLocation().getPath().replace("/bin/", "/") + relativeEcoreURI_«j»;
				absoluteEcoreURI_«j» = "file:/" + absoluteEcoreURI_«j».substring(1, absoluteEcoreURI_«j».length()); 
				«IF standalone == false»
				resources.add(ModelManager.loadMetaModelAsResource(resourcePackages, URI.createURI(absoluteEcoreURI_«j»).toFileString()));
				«ELSE»
				resources.add(ModelManager.loadMetaModelAsResourceNoException(resourcePackages, URI.createURI(absoluteEcoreURI_«j»).toFileString()));
				«ENDIF»
				«{j++; ""}»
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
				«mut.object.expression.method(0, false)»
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
	   				«mut.object.expression.method(0, false)»
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
			Map<String, AttributeConfigurationStrategy> atts = new LinkedHashMap<String, AttributeConfigurationStrategy>();
			//«var counter = 0»
			«FOR c : mut.attributes»
				//«counter ++»
				«c.method(false, false, counter, false, "objectSelection")»
			«ENDFOR»
			Map<String, ObSelectionStrategy> refs = new LinkedHashMap<String, ObSelectionStrategy>();
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
	   				«mut.object.expression.method(0, false)»
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
				«mut.object.expression.method(0, false)»
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
				List<EObject> o = ModelManager.getReferences("«mut.object.refType.name»", objects.get(0));
				EObject object = o.get(ModelManager.getRandomIndex(o));
				objectSelection = new SpecificObjectSelection(packages, model, object);
				objects.clear();
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
				objectSelection = new SpecificObjectSelection(packages, model, object);
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
		Map<String, AttributeConfigurationStrategy> atts = new LinkedHashMap<String, AttributeConfigurationStrategy>();
		//«var counter = 0»
		«FOR c : mut.attributes»
			//«counter++»
			«c.method(false, false, counter, true, "objectSelection")»
		«ENDFOR»
		Map<String, ObSelectionStrategy> refs = new LinkedHashMap<String, ObSelectionStrategy>();
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
				mutation«nMethodCall»(packages, m, hmObjects, hmList, hashmapModelFilenames,
									modelFilename, mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,
									registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, project, monitor, k, serialize, test, classes);
				«ELSE»
				mutation«nMethodCall»(packages, m, hmObjects, hmList, hashmapModelFilenames,
									modelFilename, mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,
									registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, monitor, k, serialize, test, classes);
				«ENDIF»
				numMutantsGenerated = k[0];
				}
				«ENDIF»
				«ENDIF»
				«IF last == true»
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
					if (muts != null) {
						muts.getMuts().clear();
					}
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
	   				«mut.object.expression.method(0, false)»
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
			Map<String, AttributeConfigurationStrategy> atts = new LinkedHashMap<String, AttributeConfigurationStrategy>();
			//«var counter = 0»
			«FOR c : mut.attributes»
				//«counter ++»
				«c.method(false, false, counter, false, "objectSelection")»
			«ENDFOR»
			Map<String, ObSelectionStrategy> refs = new LinkedHashMap<String, ObSelectionStrategy>();
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
		«mut.object.expression.method(0, false)»
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
				return numMutantsGenerated;
			}
		}
		«ELSEIF mut.object instanceof SpecificClosureSelection»
		ObSelectionStrategy objectSelection = null;
		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.object as SpecificClosureSelection).objSel.name» = hmObjects.get("«(mut.object as SpecificClosureSelection).objSel.name»");
		if (entry_«(mut.object as SpecificClosureSelection).objSel.name» != null) {
			objectSelection = new SpecificClosureSelection(entry_«(mut.object as SpecificClosureSelection).objSel.name».getValue().getValue(), entry_«(mut.object as SpecificClosureSelection).objSel.name».getValue().getKey(), entry_«(mut.object as SpecificClosureSelection).objSel.name».getKey(), "«(mut.object as SpecificClosureSelection).refType.name»");
		} else {
			return numMutantsGenerated;
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
				return numMutantsGenerated;
			}
			«ENDIF»
		«ENDIF»
		«IF mut.container instanceof SpecificClosureSelection»
			«IF mut.refType !== null»
			SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.container as SpecificClosureSelection).objSel.name» = hmObjects.get("«(mut.container as SpecificClosureSelection).objSel.name»");
			if (entry_«(mut.container as SpecificClosureSelection).objSel.name» != null) {
				containerSelection = new SpecificClosureSelection(entry_«(mut.container as SpecificClosureSelection).objSel.name».getValue().getValue(), entry_«(mut.container as SpecificClosureSelection).objSel.name».getValue().getKey(), entry_«(mut.container as SpecificClosureSelection).objSel.name».getKey(), "«(mut.container as SpecificClosureSelection).refType.name»");
			} else {
				return numMutantsGenerated;
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
			return numMutantsGenerated;
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
		«IF mut.object instanceof SpecificObjectSelection»
		List<EObject> objects =  null;
		if (objectSelection != null) {
			objects = objectSelection.getObjects();
			if (objects == null) {
				objects = new ArrayList<EObject>();
				objects.add(objectSelection.getObject());
			}
		}
		«ENDIF»
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
		Map<String, AttributeConfigurationStrategy> atts = new LinkedHashMap<String, AttributeConfigurationStrategy>();
		//«var counter = 0»
		«FOR c : mut.attributes»
			//«counter++»
			«c.method(false, false, counter, true, "obSelection")»
		«ENDFOR»
		Map<String, ObSelectionStrategy> refs = new LinkedHashMap<String, ObSelectionStrategy>();
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
					if (muts != null) {
						muts.getMuts().clear();
					}
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
				RandomTypeSelection sourceSelection = new RandomTypeSelection(packages, model, "«(mut.source as RandomTypeSelection).type.name»");			
				List<EObject> objects = new ArrayList<EObject>();
				for (EObject sourceSelection.getObjects()) {
					EObject obj = ent.getKey();
					objects.add(obj);
				}
			«ELSEIF mut.source instanceof SpecificObjectSelection»
				SpecificObjectSelection sourceSelection = null;
				SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.source as SpecificObjectSelection).objSel.name» = hmObjects.get("«(mut.source as SpecificObjectSelection).objSel.name»");
				if (entry_«(mut.source as SpecificObjectSelection).objSel.name» != null) {
					sourceSelection = new SpecificObjectSelection(entry_«(mut.source as SpecificObjectSelection).objSel.name».getValue().getValue(), entry_«(mut.source as SpecificObjectSelection).objSel.name».getValue().getKey(), entry_«(mut.source as SpecificObjectSelection).objSel.name».getKey());
				} else {
					return mutations;
				}			
				List<EObject> objects = new ArrayList<EObject>();
				objects.add(sourceSelection.getObject());
			«ELSE»
				ObSelectionStrategy sourceSelection = new SpecificObjectSelection(packages, model, (EObject) null);
			«ENDIF»
			«IF mut.newTarget instanceof RandomTypeSelection»
				RandomTypeSelection newTargetSelection = new RandomTypeSelection(packages, model, "«(mut.newTarget as RandomTypeSelection).type.name»");
			«ELSEIF mut.newTarget instanceof OtherTypeSelection»
				EObject otherSourceSelection = null; 
				«IF mut.source instanceof CompleteTypeSelection»
					otherSourceSelection = sourceSelection.getObject();
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
				SpecificObjectSelection newTargetSelection = null;
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
					if (sourceSelection != null && newTargetSelection != null) {
					EObject source = sourceSelection.getObject();
					EObject target = newTargetSelection.getObject();
					// We avoid cycles
					if (source != null && target != null) {
					EObject previous = source.eContainer();
					while (previous != null && !EcoreUtil.equals(previous, target)) {
						previous = previous.eContainer();
					}
					if (EcoreUtil.equals(previous, target)) {
						continue;
					}
					mutations.add(ModifyTargetReferenceMutator(sourceSelection.getModel(), sourceSelection.getMetaModel(), sourceSelection, newTargetSelection, "«mut.refType.name»"));
					}
					}
				}
   			«ELSE»
				if (sourceSelection == null) {
					return mutations;
				}
				EObject source = sourceSelection.getObject();
				if (source == null) {
					return mutations;
				}
				if (newTargetSelection == null) {
					return mutations;
				}
				EObject target = newTargetSelection.getObject();
				if (target == null) {
					return mutations;
				}
				// We avoid cycles
				EObject previous = source.eContainer();
				while (previous != null && !EcoreUtil.equals(previous, target)) {
					previous = previous.eContainer();
				}
				if (!EcoreUtil.equals(previous, target)) {
				ModifyTargetReferenceMutator mut = new ModifyTargetReferenceMutator(sourceSelection.getModel(), sourceSelection.getMetaModel(), sourceSelection, newTargetSelection, "«mut.refType.name»");
				//INC COUNTER: «nMutation++»
	   			//INC COUNTER: «nRegistryMutation++»
				if (mut != null) {
					mut.setId("m«nMutation»");
					mutations.add(mut);
				}
				}
	«ENDIF»
	//END MODIFY TARGET REFERENCE «methodName»
	'''

	def modifyTargetReferenceMutatorExhaustive(ModifyTargetReferenceMutator mut, MutatorEnvironment e, Block b, boolean last) '''
		//MODIFY TARGET REFERENCE «methodName»
			ObSelectionStrategy containerSelection = null;
			SpecificReferenceSelection referenceSelection = null;
			List<EObject> listSources = new ArrayList<EObject>();
			«IF mut.source instanceof RandomTypeSelection»
				RandomTypeSelection sourceSelection = new RandomTypeSelection(packages, model, "«(mut.source as RandomTypeSelection).type.name»");
				listSources.addAll(sourceSelection.getObjects());
			«ELSEIF mut.source instanceof CompleteTypeSelection»
				RandomTypeSelection sourceSelection = new RandomTypeSelection(packages, model, "«(mut.source as CompleteTypeSelection).type.name»");
				listSources.addAll(sourceSelection.getObjects());
			«ELSEIF mut.source instanceof SpecificObjectSelection»
				SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.source as SpecificObjectSelection).objSel.name» = hmObjects.get("«(mut.source as SpecificObjectSelection).objSel.name»");
				SpecificObjectSelection sourceSelection = null;
				if (entry_«(mut.source as SpecificObjectSelection).objSel.name» != null) {
					sourceSelection = new SpecificObjectSelection(entry_«(mut.source as SpecificObjectSelection).objSel.name».getValue().getValue(), entry_«(mut.source as SpecificObjectSelection).objSel.name».getValue().getKey(), entry_«(mut.source as SpecificObjectSelection).objSel.name».getKey());
					listSources.add(sourceSelection.getObject());
				} else {
					return numMutantsGenerated;
				}
			«ELSE»
				ObSelectionStrategy sourceSelection = new SpecificObjectSelection(packages, model, (EObject) null);
				listSources.addAll(sourceSelection.getObjects());
			«ENDIF»
			Mutator mutator = null;
			«IF standalone == false»
			String modelsFolder = ModelManager.getModelsFolder(this.getClass());
			«ELSE»
			String modelsFolder = ModelManager.getModelsFolder(«className».class);
			«ENDIF»
			String tempModelsFolder = modelsFolder.replace(modelsFolder.indexOf("/") > 0 ? modelsFolder.substring(modelsFolder.indexOf("/") + 1, modelsFolder.length()) : modelsFolder, "temp");
			modelsFolder = modelsFolder.replace("/", "\\"); 
			tempModelsFolder = tempModelsFolder.replace("/", "\\");
			for (EObject sourceObject : listSources) {
				ObSelectionStrategy srcSelection = new SpecificObjectSelection(packages, model, sourceObject);
				List<EObject> listTargets = new ArrayList<EObject>();
			«IF mut.newTarget instanceof RandomTypeSelection»
				RandomTypeSelection newTargetSelection = new RandomTypeSelection(packages, model, "«(mut.newTarget as RandomTypeSelection).type.name»");
				listTargets.addAll(newTargetSelection.getObjects());
			«ELSEIF mut.newTarget instanceof OtherTypeSelection»
				Object otherRef = null;
				if (sourceObject != null) {
					for (EReference ref : sourceObject.eClass().getEAllReferences()) {
						if (ref.getName().equals("«mut.refType.name»")) {
							otherRef = sourceObject.eGet(ref);
							break;
						}
					}
					OtherTypeSelection newTargetSelection = new OtherTypeSelection(packages, model, "«(mut.newTarget as OtherTypeSelection).type.name»", otherRef);
					listTargets.addAll(newTargetSelection.getObjects());
				}
			«ELSEIF mut.newTarget instanceof CompleteTypeSelection»
				RandomTypeSelection newTargetSelection = new RandomTypeSelection(packages, model, "«(mut.newTarget as CompleteTypeSelection).type.name»");			
				listTargets.addAll(newTargetSelection.getObjects());
			«ELSEIF mut.newTarget instanceof SpecificObjectSelection»
				SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.newTarget as SpecificObjectSelection).objSel.name» = hmObjects.get("«(mut.newTarget as SpecificObjectSelection).objSel.name»");
				SpecificObjectSelection newTargetSelection = null;
				if (entry_«(mut.newTarget as SpecificObjectSelection).objSel.name» != null) {
					newTargetSelection = new SpecificObjectSelection(entry_«(mut.newTarget as SpecificObjectSelection).objSel.name».getValue().getValue(), entry_«(mut.newTarget as SpecificObjectSelection).objSel.name».getValue().getKey(), entry_«(mut.newTarget as SpecificObjectSelection).objSel.name».getKey());
					listTargets.add(newTargetSelection.getObject());
				} else {
					return numMutantsGenerated;
				}
			«ELSE»
				SpecificObjectSelection newTargetSelection = new SpecificObjectSelection(packages, model, (EObject) null);
				listTargets.add(newTargetSelection.getObject());
			«ENDIF»
				for (EObject targetObject : listTargets) {
					Resource m = ModelManager.cloneModel(model, model.getURI().toFileString().replace(modelsFolder + "\\", tempModelsFolder + "\\").replace(".model", ".«methodName»." + numMutantsGenerated +".model"));
					EObject source = ModelManager.getObject(m, sourceObject);
					if (source == null) {
						continue;
					}
					ObSelectionStrategy srcSelection2 = new SpecificObjectSelection(packages, m, source);
					EObject target = ModelManager.getObject(m, targetObject);
					if (target == null) {
						continue;
					}
					// We avoid cycles
					EObject previous = source.eContainer();
					while (previous != null && !EcoreUtil.equals(previous, target)) {
						previous = previous.eContainer();
					}
					if (EcoreUtil.equals(previous, target)) {
						continue;
					}
					ObSelectionStrategy tarSelection = new SpecificObjectSelection(packages, m, target);
					ModifyTargetReferenceMutator mut = new ModifyTargetReferenceMutator(srcSelection2.getModel(), srcSelection2.getMetaModel(), srcSelection2, tarSelection, "«mut.refType.name»");
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
				mutator = mut;
			«ENDIF»
			if (mutator != null) {
			//«nMethodCall = nMethodCall + 1»
			«IF last == false»
			«IF standalone == false»
			mutation«nMethodCall»(packages, srcSelection.getModel(), hmObjects, hmList, hashmapModelFilenames,
								modelFilename, mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,
								registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, project, monitor, k, serialize, test, classes);
			«ELSE»
			mutation«nMethodCall»(packages, srcSelection.getModel(), hmObjects, hmList, hashmapModelFilenames,
								modelFilename, mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,
								registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, monitor, k, serialize, test, classes);
			«ENDIF»
			numMutantsGenerated = k[0];
			}
			«ENDIF»
			«IF last == true»
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
				if (muts != null) {
					muts.getMuts().clear();
				}
			}
				//Unload tmp model
				try {
					m.unload();
				} catch (Exception e) {}
				}
			}
		«ENDIF»
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
   					«mut.object.expression.method(0, false)»
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
					«mut.object.expression.method(0, false)»
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
					«mut.container.expression.method(0, false)»
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
				«ENDIF»
				«IF mut.object instanceof CompleteTypeSelection»
					«IF mut.object.expression === null»
					«IF mut.container === null»
						CompleteTypeSelection objectsSelection = new CompleteTypeSelection(packages, model, "«(mut.object as CompleteTypeSelection).type.name»");
						objects = objectsSelection.getObjects();
					«ENDIF»
					«ELSE»
						objects = selectedObjects;
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
						«IF mut.container.resource === null»
						containerSelection = new SpecificObjectSelection(packages, seed, container);
						«ELSE»
						«ENDIF»
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
						«IF mut.container.resource === null»
							referenceSelection = new SpecificReferenceSelection(packages, model, "«mut.container.refType.name»", containerSelection);
						«ELSE»
							referenceSelection = new SpecificReferenceSelection(packages, seed, "«mut.container.refType.name»", containerSelection);
						«ENDIF»
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
						«IF mut.container.resource === null»
							containerSelection = new SpecificObjectSelection(packages, model, recovered);
						«ELSE»
							containerSelection = new SpecificObjectSelection(packages, seed, recovered);
						«ENDIF»
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
					«IF mut.object instanceof RandomTypeSelection»
					rts = new RandomTypeSelection(containerSelection.getMetaModel(), containerSelection.getModel(), "«(mut.object as RandomTypeSelection).type.name»", referenceSelection, containerSelection);
					«ELSEIF mut.object instanceof CompleteTypeSelection»
					rts = new RandomTypeSelection(containerSelection.getMetaModel(), containerSelection.getModel(), "«(mut.object as CompleteTypeSelection).type.name»", referenceSelection, containerSelection);
					«ELSEIF mut.object instanceof SpecificObjectSelection»
					rts = new RandomTypeSelection(containerSelection.getMetaModel(), containerSelection.getModel(), "«(mut.object as SpecificObjectSelection).type.name»", referenceSelection, containerSelection);
					«ENDIF»
					«ELSE»
					«IF mut.object instanceof RandomTypeSelection»
					RandomTypeSelection rts = new RandomTypeSelection(containerSelection.getMetaModel(), containerSelection.getModel(), "«(mut.object as RandomTypeSelection).type.name»", referenceSelection, containerSelection);
					«ELSEIF mut.object instanceof CompleteTypeSelection»
					RandomTypeSelection rts = new RandomTypeSelection(containerSelection.getMetaModel(), containerSelection.getModel(), "«(mut.object as CompleteTypeSelection).type.name»", referenceSelection, containerSelection);
					«ELSEIF mut.object instanceof SpecificObjectSelection»
					RandomTypeSelection rts = new RandomTypeSelection(containerSelection.getMetaModel(), containerSelection.getModel(), "«(mut.object as SpecificObjectSelection).type.name»", referenceSelection, containerSelection);
					«ENDIF»
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
   					«mut.object.expression.method(0, false)»
					objects = evaluate(objects, exp«expressionList.get(0)»);
					«ELSEIF mut.container.expression === null»
					List<EObject> objects = rts.getObjects();
					//EXPRESSION LIST: «expressionList = new ArrayList<Integer>()»
					//EXPRESSION LEVEL: «nExpression = 0»
					//EXPRESSION LEVEL: «expressionList.add(0)»
					Expression exp«expressionList.get(0)» = new Expression();
					«mut.object.expression.method(0, false)»
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
					«mut.container.expression.method(0, false)»
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
			«IF mut.object instanceof RandomTypeSelection || mut.object instanceof SpecificObjectSelection»
			ObSelectionStrategy obSelection = null;
			Mutator mutator = null;
			«IF standalone == false»
			String modelsFolder = ModelManager.getModelsFolder(this.getClass());
			«ELSE»
			String modelsFolder = ModelManager.getModelsFolder(«className».class);
			«ENDIF»
			String tempModelsFolder = modelsFolder.replace(modelsFolder.indexOf("/") > 0 ? modelsFolder.substring(modelsFolder.indexOf("/") + 1, modelsFolder.length()) : modelsFolder, "temp");
			modelsFolder = modelsFolder.replace("/", "\\"); 
			tempModelsFolder = tempModelsFolder.replace("/", "\\");
			if (objects != null) {
				for (EObject ob : objects) {
					Resource m = ModelManager.cloneModel(model, model.getURI().toFileString().replace(modelsFolder + "\\", tempModelsFolder + "\\").replace(".model", ".«methodName»." + numMutantsGenerated +".model"));
					EObject obToMutate = ModelManager.getObject(m, ob);
					obSelection = new SpecificObjectSelection(packages, m, obToMutate);
					EObject containerToMutate = null;
					if (containerSelection != null && containerSelection.getObject() != null) {
						containerToMutate = ModelManager.getObject(m, containerSelection.getObject());
					}
					ObSelectionStrategy containerToMutateSelection = new SpecificObjectSelection(packages, m, containerToMutate);
					«IF mut.container !== null && mut.container.refType !== null && mut.container.refType.name !== null»
					SpecificReferenceSelection referenceToMutateSelection = new SpecificReferenceSelection(packages, model, "«mut.container.refType.name»", containerToMutateSelection.getObject());
					«ELSE»
					SpecificReferenceSelection referenceToMutateSelection = referenceSelection;
					«ENDIF»
					RemoveObjectMutator mut = new RemoveObjectMutator(obSelection.getModel(), obSelection.getMetaModel(), obToMutate, referenceToMutateSelection, containerToMutateSelection);
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
				mutator = mut;
			«ENDIF»
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
			}
			«ENDIF»
			«IF last == true»
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
				if (muts != null) {
					muts.getMuts().clear();
				}
			}
			}
		«ENDIF»
		«ENDIF»
		«IF mut.object instanceof CompleteTypeSelection»
			ObSelectionStrategy obSelection = null;
			Mutator mutator = null;
			if (objects != null) {
				obSelection = new SpecificObjectSelection(packages, model, objects);
				RemoveObjectMutator mut = new RemoveObjectMutator(obSelection.getModel(), obSelection.getMetaModel(), objects, referenceSelection, containerSelection);
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
				mutator = mut;
			}
			«ENDIF»
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
				if (muts != null) {
					muts.getMuts().clear();
				}
			}
		«ENDIF»
		«ENDIF»
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
		private List<Mutator> «methodName»(List<EPackage> packages, Resource model, Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects, Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList, boolean serialize, IWodelTest test, Map<String, List<String>> classes) throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException {
		«ELSE»
		private static List<Mutator> «methodName»(List<EPackage> packages, Resource model, Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects, Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList, boolean serialize, IWodelTest test, Map<String, List<String>> classes) throws ReferenceNonExistingException, MetaModelNotFoundException, ModelNotFoundException {
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
					List<String>> hashmapMutVersions, Mutations muts, IProject project, IProgressMonitor monitor, int[] k, boolean serialize, IWodelTest test, Map<String, List<String>> classes)
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
					List<String>> hashmapMutVersions, Mutations muts, IProgressMonitor monitor, int[] k, boolean serialize, IWodelTest test, Map<String, List<String>> classes)
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
			«(mut as ModifyTargetReferenceMutator).modifyTargetReferenceMutatorExhaustive(e, b, last)»
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
		private List<Mutator> «compositeMethodName»(List<EPackage> packages, Resource model, Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects, Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList, boolean serialize, IWodelTest test, Map<String, List<String>> classes) throws ReferenceNonExistingException {
		«ELSE»
		private static List<Mutator> «compositeMethodName»(List<EPackage> packages, Resource model, Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmObjects, Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hmList, boolean serialize, IWodelTest test, Map<String, List<String>> classes) throws ReferenceNonExistingException {
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
		if (hmMutator.get("m«nRegistryMutation»") != null) {
			cMut.setDef(hmMutator.get("m«nRegistryMutation»"));
			appMut = cMut;
		}
	«ENDIF»
	«IF mut instanceof CloneObjectMutator»
		ObjectCloned cMut = AppliedMutationsFactory.eINSTANCE.createObjectCloned();
		if (mut.getObject() != null) {
			cMut.getObject().add(mut.getObject());
		}
		if (hmMutator.get("m«nRegistryMutation»") != null) {
			cMut.setDef(hmMutator.get("m«nRegistryMutation»"));
			appMut = cMut;
		}
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
		if (hmMutator.get("m«nRegistryMutation»") != null) {
			rMut.setDef(hmMutator.get("m«nRegistryMutation»"));
			appMut = rMut;
		}
	«ENDIF»
	«IF mut instanceof RemoveObjectMutator»
		ObjectRemoved rMut = AppliedMutationsFactory.eINSTANCE.createObjectRemoved();
		EObject foundObject = findEObjectForRegistry(seed, mut.getObject(), mut.getObjectByID(), mut.getObjectByURI(), mutPaths, packages);
		if (foundObject != null) {
			rMut.getObject().add(foundObject);
		}
		rMut.setType(mut.getEType());
		if (hmMutator.get("m«nRegistryMutation»") != null) {
			rMut.setDef(hmMutator.get("m«nRegistryMutation»"));
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
		if (hmMutator.get("m«nRegistryMutation»") != null) {
			rMut.setDef(hmMutator.get("m«nRegistryMutation»"));
			appMut = rMut;
		}
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
		if (hmMutator.get("m«nRegistryMutation»") != null) {
			rMut.setDef(hmMutator.get("m«nRegistryMutation»"));
			appMut = rMut;
		}
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
		if (hmMutator.get("m«nRegistryMutation»") != null) {
			rMut.setDef(hmMutator.get("m«nRegistryMutation»"));
			appMut = rMut;
		}
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
		if (hmMutator.get("m«nRegistryMutation»") != null) {
			rMut.setDef(hmMutator.get("m«nRegistryMutation»"));
			appMut = rMut;
		}
	«ENDIF»
	«IF mut instanceof ModifyInformationMutator»
			InformationChanged icMut = AppliedMutationsFactory.eINSTANCE.createInformationChanged();
			ModifyInformationMutator mutator = (ModifyInformationMutator) mut;
			Resource mutant = mutator.getModel();
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
			oldAttVal = mutator.getOldAttValue("«eattfirst.name»");
			newAttVal = mutator.getNewAttValue("«eattfirst.name»");
			if (oldAttVal != null) {
				attMut«attCounter».setOldVal(oldAttVal.toString());
			}
			if (newAttVal != null) {
				attMut«attCounter».setNewVal(newAttVal.toString());
			}
			if (hmMutator.get("m«nRegistryMutation»") != null) {
				attMut«attCounter».setDef(hmMutator.get("m«nRegistryMutation»"));
				attsMut.add(attMut«attCounter»);
				icMut.setDef(hmMutator.get("m«nRegistryMutation»"));
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
			«IF ref instanceof ReferenceInit || ref instanceof ReferenceAdd || ref instanceof ReferenceRemove»
			//«var EReference eref = ref.reference.get(0)»
			ReferenceChanged refMut«refCounter» = null;
			refMut«refCounter» = AppliedMutationsFactory.eINSTANCE.createReferenceChanged();
			refMut«refCounter».setRefName("«eref.name»");
			refMut«refCounter».getObject().add(mutator.getObject());
			refMut«refCounter».getMutantObject().add(mutator.getObject());
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
			if (hmMutator.get("m«nRegistryMutation»") != null) {
				refMut«refCounter».setDef(hmMutator.get("m«nRegistryMutation»"));
			}
			«ENDIF»
			if (hmMutator.get("m«nRegistryMutation»") != null) {
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
				refMut«refCounter».setDef(hmMutator.get("m«nRegistryMutation»"));
				refsMut.add(refMut«refCounter»);
				icMut.setDef(hmMutator.get("m«nRegistryMutation»"));
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
			if (hmMutator.get("m«nRegistryMutation»") != null) {
				srcMut.setDef(hmMutator.get("m«nRegistryMutation»"));
				appMut = srcMut;
			}
	«ENDIF»
	«IF mut instanceof ModifyTargetReferenceMutator»
			TargetReferenceChanged trcMut = AppliedMutationsFactory.eINSTANCE.createTargetReferenceChanged();
			ModifyTargetReferenceMutator mutator = (ModifyTargetReferenceMutator) mut;
			Resource mutant = mutator.getModel();
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
			if (hmMutator.get("m«nRegistryMutation»") != null) {
				trcMut.setDef(hmMutator.get("m«nRegistryMutation»"));
				appMut = trcMut;
			}
	«ENDIF»
	«IF mut instanceof SelectObjectMutator»
		if (hmMutator.get("m«nRegistryMutation»") != null) {
			appMut = AppliedMutationsFactory.eINSTANCE.createAppMutation();
			appMut.setDef(hmMutator.get("m«nRegistryMutation»"));
		}
	«ENDIF»
	«IF mut instanceof SelectSampleMutator»
		if (hmMutator.get("m«nRegistryMutation»") != null) {
			appMut = AppliedMutationsFactory.eINSTANCE.createAppMutation();
			appMut.setDef(hmMutator.get("m«nRegistryMutation»"));
		}
	«ENDIF»
		return appMut;
	}
   '''
   
   	def compositeRegistryMethod(CompositeMutator mut, boolean exhaustive)'''
   	«IF mut.eContainer instanceof MutatorEnvironment»
	//LOCAL COPY REGISTRY COUNTER: «var localNRegistryMutation = nRegistryMutation»
	«IF standalone == false»
	private AppMutation «compositeRegistryMethodName»(List<Mutator> muts, Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmMutator, Resource seed, boolean serialize, IWodelTest test, Map<String, List<String>> classes) {
	«ELSE»
	private static AppMutation «compositeRegistryMethodName»(List<Mutator> muts, Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hmMutator, Resource seed, boolean serialize, IWodelTest test, Map<String, List<String>> classes) {
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
		if (hmMutator.get("m«nRegistryMutation»") != null) {
			appMut«mutCounter + 1».setDef(hmMutator.get("m«localNRegistryMutation»"));
			appMuts.add(appMut«mutCounter + 1»);
			//REGISTRY METHOD INC: «localNRegistryMethod++»
			//COUNTER: «mutCounter++»
		}
		«ENDFOR»
		if (hmMutator.get("m«nRegistryMutation»") != null) {
			appMut.getMuts().addAll(appMuts);
			appMut.setDef(hmMutator.get("m«nRegistryMutation»"));
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
		public int block_«b.name»(int maxAttempts, int numMutants, boolean registry, List<EPackage> packages, Map<String, EPackage> registeredPackages, Map<String, EPackage> localRegisteredPackages, List<String> fromNames, Map<String, Set<String>> hashmapMutants, Map<String, List<String>> hashmapMutVersions, IProject project, IProgressMonitor monitor, int[] k, boolean serialize, IWodelTest test, Map<String, List<String>> classes) throws ReferenceNonExistingException, WrongAttributeTypeException, 
												  MaxSmallerThanMinException, AbstractCreationException, ObjectNoTargetableException, 
												  ObjectNotContainedException, MetaModelNotFoundException, ModelNotFoundException, IOException {
		«ELSE»
		public int block_«b.name»(int maxAttempts, int numMutants, boolean registry, List<EPackage> packages, Map<String, EPackage> registeredPackages, Map<String, EPackage> localRegisteredPackages, List<String> fromNames, Map<String, Set<String>> hashmapMutants, Map<String, List<String>> hashmapMutVersions, IProgressMonitor monitor, int[] k, boolean serialize, IWodelTest test, Map<String, List<String>> classes) throws ReferenceNonExistingException, WrongAttributeTypeException, 
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
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;
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

import mutatorenvironment.MutatorenvironmentPackage;
import mutatormetrics.MutatormetricsPackage;

public class «className» extends MutatorUtils {
	
	«IF standalone == false»
	private Map<Integer, Mutator> overallMutators = new LinkedHashMap<Integer, Mutator>();
	«ELSE»
	private static Map<Integer, Mutator> overallMutators = new LinkedHashMap<Integer, Mutator>();
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
	public MutationResults execute(int maxAttempts, int numMutants, boolean registry, boolean metrics, boolean debugMetrics, List<EPackage> packages, Map<String, EPackage> registeredPackages, Map<String, EPackage> localRegisteredPackages, String[] blockNames, IProject project, IProgressMonitor monitor, boolean serialize, IWodelTest test, Map<String, List<String>> classes) throws ReferenceNonExistingException, WrongAttributeTypeException, 
												  MaxSmallerThanMinException, AbstractCreationException, ObjectNoTargetableException, 
												  ObjectNotContainedException, MetaModelNotFoundException, ModelNotFoundException, IOException {
	«ELSE»
	public MutationResults execute(int maxAttempts, int numMutants, boolean registry, boolean metrics, boolean debugMetrics, List<EPackage> packages, Map<String, EPackage> registeredPackages, Map<String, EPackage> localRegisteredPackages, String[] blockNames, IProgressMonitor monitor, boolean serialize, IWodelTest test, Map<String, List<String>> classes) throws ReferenceNonExistingException, WrongAttributeTypeException, 
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
		Map<String, List<String>> hashmapMutVersions = new LinkedHashMap<String, List<String>>();

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
	   	String metricsecore = MutatormetricsPackage.class.getProtectionDomain().getCodeSource().getLocation().getPath().replace("/bin/", "/") + "model/MutatorMetrics.ecore";
	   	metricsecore = metricsecore.substring(1, metricsecore.length());

		MutatorMetricsGenerator metricsGenerator = null;
	   	if (metrics == true) {
	   		List<EPackage> metricspackages = ModelManager.loadMetaModel(metricsecore);
	   		monitor.subTask("Generating dynamic net metrics");
	   		«IF standalone == false»
	   		metricsGenerator = new NetMutatorMetricsGenerator(metricspackages, «className».class.getProtectionDomain().getCodeSource().getLocation().getPath().replace("/bin/", "/")+ "«((e as MutatorEnvironment).definition as Program).output»", "«((e as MutatorEnvironment).definition as Program).metamodel»", «className».class.getProtectionDomain().getCodeSource().getLocation().getPath().replace("/bin/", "/")+ "«((e as MutatorEnvironment).definition as Program).source.path»", "«fileName»", hashmapMutVersions, this.getClass());
	   		«ELSE»
	   		metricsGenerator = new NetMutatorMetricsGenerator(metricspackages, «className».class.getProtectionDomain().getCodeSource().getLocation().getPath().replace("/bin/", "/")+ "«((e as MutatorEnvironment).definition as Program).output»", "«((e as MutatorEnvironment).definition as Program).metamodel»", «className».class.getProtectionDomain().getCodeSource().getLocation().getPath().replace("/bin/", "/")+ "«((e as MutatorEnvironment).definition as Program).source.path»", "«fileName»", hashmapMutVersions, «className».class);
	   		«ENDIF»
	   		metricsGenerator.run();
	   		monitor.worked(1);
	   	}
	   	if (debugMetrics == true) {
			List<EPackage> metricspackages = ModelManager.loadMetaModel(metricsecore);
	   		monitor.subTask("Generating dynamic debug metrics");
	   		«IF standalone == true»
	   		metricsGenerator = new DebugMutatorMetricsGenerator(metricspackages, «className».class.getProtectionDomain().getCodeSource().getLocation().getPath().replace("/bin/", "/")+ "«((e as MutatorEnvironment).definition as Program).output»", "«((e as MutatorEnvironment).definition as Program).metamodel»", «className».class.getProtectionDomain().getCodeSource().getLocation().getPath().replace("/bin/", "/")+ "«((e as MutatorEnvironment).definition as Program).source.path»", "«fileName»", hashmapMutVersions, this.getClass());
	   		«ELSE»
	   		metricsGenerator = new DebugMutatorMetricsGenerator(metricspackages, «className».class.getProtectionDomain().getCodeSource().getLocation().getPath().replace("/bin/", "/")+ "«((e as MutatorEnvironment).definition as Program).output»", "«((e as MutatorEnvironment).definition as Program).metamodel»", «className».class.getProtectionDomain().getCodeSource().getLocation().getPath().replace("/bin/", "/")+ "«((e as MutatorEnvironment).definition as Program).source.path»", "«fileName»", hashmapMutVersions, «className».class);
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
	public MutationResults execute(int maxAttempts, int numMutants, boolean registry, boolean metrics, boolean debugMetrics, List<EPackage> packages, Map<String, EPackage> registeredPackages, Map<String, EPackage> localRegisteredPackages, String[] blockNames, IProject project, IProgressMonitor monitor, boolean serialize, IWodelTest test, Map<String, List<String>> classes) throws ReferenceNonExistingException, WrongAttributeTypeException, 
												  MaxSmallerThanMinException, AbstractCreationException, ObjectNoTargetableException, 
												  ObjectNotContainedException, MetaModelNotFoundException, ModelNotFoundException, IOException {
	«ELSE»
	public MutationResults execute(int maxAttempts, int numMutants, boolean registry, boolean metrics, boolean debugMetrics, List<EPackage> packages, Map<String, EPackage> registeredPackages, Map<String, EPackage> localRegisteredPackages, String[] blockNames, IProgressMonitor monitor, boolean serialize, IWodelTest test, Map<String, List<String>> classes) throws ReferenceNonExistingException, WrongAttributeTypeException, 
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
		Map<String, Set<String>> hashmapMutants = new LinkedHashMap<String, Set<String>>();
		Map<String, List<String>> hashmapMutVersions = new LinkedHashMap<String, List<String>>();

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
	   	String metricsecore = MutatormetricsPackage.class.getProtectionDomain().getCodeSource().getLocation().getPath().replace("/bin/", "/") + "model/MutatorMetrics.ecore";
	   	metricsecore = metricsecore.substring(1, metricsecore.length());

		MutatorMetricsGenerator metricsGenerator = null;
		if (metrics == true) {
			List<EPackage> metricspackages = ModelManager.loadMetaModel(metricsecore);
			monitor.subTask("Generating dynamic net metrics");
			«IF standalone == false»
			metricsGenerator = new NetMutatorMetricsGenerator(metricspackages, «className».class.getProtectionDomain().getCodeSource().getLocation().getPath().replace("/bin/", "/")+ "«((e as MutatorEnvironment).definition as Program).output»", "«((e as MutatorEnvironment).definition as Program).metamodel»", «className».class.getProtectionDomain().getCodeSource().getLocation().getPath().replace("/bin/", "/")+ "«projectName»/«((e as MutatorEnvironment).definition as Program).source.path»", "«fileName»", hashmapMutVersions, this.getClass());
			«ELSE»
			metricsGenerator = new NetMutatorMetricsGenerator(metricspackages, «className».class.getProtectionDomain().getCodeSource().getLocation().getPath().replace("/bin/", "/")+ "«((e as MutatorEnvironment).definition as Program).output»", "«((e as MutatorEnvironment).definition as Program).metamodel»", «className».class.getProtectionDomain().getCodeSource().getLocation().getPath().replace("/bin/", "/")+ "«projectName»/«((e as MutatorEnvironment).definition as Program).source.path»", "«fileName»", hashmapMutVersions, «className».class);
			«ENDIF»
	   		metricsGenerator.run();
	   		monitor.worked(1);
		}
		if (debugMetrics == true) {
			List<EPackage> metricspackages = ModelManager.loadMetaModel(metricsecore);
			monitor.subTask("Generating dynamic debug metrics");
			«IF standalone == false»
			metricsGenerator = new DebugMutatorMetricsGenerator(metricspackages, «className».class.getProtectionDomain().getCodeSource().getLocation().getPath().replace("/bin/", "/")+ "«((e as MutatorEnvironment).definition as Program).output»", "«((e as MutatorEnvironment).definition as Program).metamodel»", «className».class.getProtectionDomain().getCodeSource().getLocation().getPath().replace("/bin/", "/")+ "«projectName»/«((e as MutatorEnvironment).definition as Program).source.path»", "«fileName»", hashmapMutVersions, this.getClass());
			«ELSE»
			metricsGenerator = new DebugMutatorMetricsGenerator(metricspackages, «className».class.getProtectionDomain().getCodeSource().getLocation().getPath().replace("/bin/", "/")+ "«((e as MutatorEnvironment).definition as Program).output»", "«((e as MutatorEnvironment).definition as Program).metamodel»", «className».class.getProtectionDomain().getCodeSource().getLocation().getPath().replace("/bin/", "/")+ "«projectName»/«((e as MutatorEnvironment).definition as Program).source.path»", "«fileName»", hashmapMutVersions, «className».class);
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
		String modelURI = «className».class.getProtectionDomain().getCodeSource().getLocation().getPath().replace("/bin/", "/") + "«e.source.path»";
		String modelsURI = «className».class.getProtectionDomain().getCodeSource().getLocation().getPath().replace("/bin/", "/") + "«e.output»";

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
					hashmapModelFilenames.put(pathfile, modelsURI + files[i].getName().substring(0, files[i].getName().length() - ".model".length()));
				}
			}
		}
		«ENDIF»
		
		«IF e instanceof Program»
		//Load Model
		Set<String> modelFilenames = hashmapModelFilenames.keySet();
	   	if (numMutants > 0) {
	   		totalMutants = numMutants * «MutatorUtils.getNumberOfSeedModels(e.eContainer as MutatorEnvironment, className + ".class.getProtectionDomain().getCodeSource().getLocation().getPath().replace(\"/bin/\", \"/\")" + projectName + "/")»;
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
		«IF e instanceof Program»
		String ecoreURI = "«e.metamodel»";
		String modelURI = «className».class.getProtectionDomain().getCodeSource().getLocation().getPath().replace("/bin/", "/") + "«e.source.path»";
		String modelsURI = «className».class.getProtectionDomain().getCodeSource().getLocation().getPath().replace("/bin/", "/") + "«e.output»";
		
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

    def method(AttributeSet e, boolean flag, boolean isList, int counter, boolean exhaustive, String obSelectionVariableName) '''
    	«IF counter == 1»
		AttributeConfigurationStrategy attConfig = null;
		«ENDIF»
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
		«e.value.method(flag, exhaustive, obSelectionVariableName)»
		atts.add(attConfig);
   		«ENDIF»
   		«IF e instanceof AttributeUnset»
		atts.add(attConfig);
   		«ENDIF»
   		«IF e instanceof AttributeReverse»
   		attConfig = new ReverseBooleanConfigurationStrategy("«attributeName»"); 
		atts.add(attConfig);
   		«ENDIF»
		«IF e instanceof AttributeCopy»
		«IF e.object instanceof RandomTypeSelection»
		attConfig = new CopyAttributeConfigurationStrategy((«obSelectionVariableName» != null ? «obSelectionVariableName».getObject() : null), "«(e.object as RandomTypeSelection).type.name»", "«attributeName»", "«e.getAttribute().get(1).name»"); 
		atts.add(attConfig);
   		«ENDIF»
		«IF e.object instanceof SpecificObjectSelection»
		«IF exhaustive == false»
		attConfig = new CopyAttributeConfigurationStrategy((«obSelectionVariableName» != null ? «obSelectionVariableName».getObject() : null), hmObjects.get("«(e.object as SpecificObjectSelection).objSel.name»").getKey(), "«attributeName»", "«e.getAttribute().get(1).name»"); 
		«ELSE»
		attConfig = new CopyAttributeConfigurationStrategy((«obSelectionVariableName» != null ? «obSelectionVariableName».getObject() : null), hmObjects.get("«(e.object as SpecificObjectSelection).objSel.name»").getKey(), "«attributeName»", "«e.getAttribute().get(1).name»");
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
		«e.value.method(flag, exhaustive, obSelectionVariableName)»;
		atts.put("«attributeName»", attConfig);
   		«ENDIF»
   		«IF e instanceof AttributeUnset»
   		atts.put("«attributeName»", attConfig);
   		«ENDIF»
   		«IF e instanceof AttributeReverse»
   		attConfig = new ReverseBooleanConfigurationStrategy("«attributeName»");
   		atts.put("«attributeName»", attConfig);
   		«ENDIF»
		«IF e instanceof AttributeCopy»
		«IF e.object instanceof RandomTypeSelection»
		attConfig = new CopyAttributeConfigurationStrategy((«obSelectionVariableName» != null ? «obSelectionVariableName».getObject() : null), "«(e.object as RandomTypeSelection).type.name»", "«attributeName»", "«e.getAttribute().get(1).name»");
		atts.put("«attributeName»", attConfig);
   		«ENDIF»
		«IF e.object instanceof SpecificObjectSelection»
		«IF exhaustive == false»
		attConfig = new CopyAttributeConfigurationStrategy((«obSelectionVariableName» != null ? «obSelectionVariableName».getObject() : null), hmObjects.get("«(e.object as SpecificObjectSelection).objSel.name»").getKey(), "«attributeName»", "«e.getAttribute().get(1).name»");
		atts.put("«attributeName»", attConfig);
		«ELSE»
		attConfig = new CopyAttributeConfigurationStrategy((«obSelectionVariableName» != null ? «obSelectionVariableName».getObject() : null), hmObjects.get("«(e.object as SpecificObjectSelection).objSel.name»").getKey(), "«attributeName»", "«e.getAttribute().get(1).name»");
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
				
	def method(DoubleType e, boolean exhaustive) ''' 
		«IF e instanceof SpecificDoubleType»
			attConfig = new SpecificDoubleConfigurationStrategy(«(e as SpecificDoubleType).value»);
		«ELSEIF e instanceof RandomDoubleType»
			«var RandomDoubleType r = (e as RandomDoubleType)»
			attConfig = new RandomDoubleConfigurationStrategy(«r.min», «r.max», false);
		«ENDIF»
	'''	
	def method(BooleanType e, boolean exhaustive) ''' 
		«IF e instanceof SpecificBooleanType»
			attConfig = new SpecificBooleanConfigurationStrategy(«(e as SpecificBooleanType).value»);
		«ELSEIF e instanceof RandomBooleanType»
			attConfig = new RandomBooleanConfigurationStrategy();
		«ENDIF»
		'''	
	def method(IntegerType e, boolean exhaustive) '''
		«IF e instanceof SpecificIntegerType» 		
			attConfig = new SpecificIntegerConfigurationStrategy(«(e as SpecificIntegerType).value»);
		«ELSEIF e instanceof RandomIntegerType»
			«var RandomIntegerType r = (e as RandomIntegerType)»
			attConfig = new RandomIntegerConfigurationStrategy(«r.min», «r.max», false);		
		«ENDIF»
		'''
	def method(ListStringType e, boolean flag, boolean exhaustive, String obSelectionVariableName) '''
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
		
	def method(ListType e, boolean flag, boolean exhaustive, String obSelectionVariableName) '''
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
	def method(RandomType e, boolean flag, boolean exhaustive, String obSelectionVariableName) '''
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
	def method(MinValueType e, boolean exhaustive) '''
		attConfig = new MinValueConfigurationStrategy(packages, model, "«MutatorUtils.getTypeName(e)»", "«e.attribute.name»");
		'''
	def method(MaxValueType e, boolean exhaustive) '''
		attConfig = new MaxValueConfigurationStrategy(packages, model, "«MutatorUtils.getTypeName(e)»", "«e.attribute.name»");
		'''
	def method(RandomIntegerNumberType e, boolean exhaustive) '''
		«IF e.object instanceof SpecificObjectSelection»
		//«var SpecificObjectSelection sel = e.object as SpecificObjectSelection»
		«IF exhaustive == false»
		attConfig = new RandomIntegerConfigurationStrategy(«e.min», ModelManager.getIntAttribute("«e.max.name»", hmObjects.get("«sel.objSel.name»").getKey()), false);
		«ELSE»
		attConfig = new RandomIntegerConfigurationStrategy(«e.min», ModelManager.getIntAttribute("«e.max.name»", hmObjects.get("«sel.objSel.name»").getKey()), false);
		«ENDIF»
		«ENDIF»
		'''
	def method(RandomDoubleNumberType e, boolean exhaustive) '''
		«IF e.object instanceof SpecificObjectSelection»
		//«var SpecificObjectSelection sel = e.object as SpecificObjectSelection»
		attConfig = new RandomDoubleConfigurationStrategy(«e.min», ModelManager.getDoubleAttribute("«e.max.name»", hmObjects.get("«sel.objSel.name»").getKey()), false);
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
	   		«e.expression.method(0, false)»
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
	   		«e.expression.method(0, false)»
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
  		//INDEX EXPRESSION: «val indexExpression = expressionList.size() - 1»
  		«IF exp.first instanceof AttributeEvaluation»
  		«IF (exp.first as AttributeEvaluation).value instanceof ObjectAttributeType»
  		exp«expressionList.get(indexExpression)».first = new AttributeEvaluation();
  		//ATTRIBUTE: «val attev = exp.first as AttributeEvaluation»
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
		//ATTRIBUTE: «val attev = exp.first as AttributeEvaluation»
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
			//«var expressionPosition = 0»
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
			//«var expressionPosition = 0»
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
			//«var expressionPosition = 0»
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
			//EXPRESSION LEVEL: «nExpression = nExpression + 1»
			//EXPRESSION LEVEL: «expressionList.add(nExpression)»
			//INDEX EXPRESSION: «val nestedIndexExpression = expressionList.size() - 1»
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
			//EXPRESSION LEVEL: «nExpression = nExpression + 1»
			//EXPRESSION LEVEL: «expressionList.add(nExpression)»
			//INDEX EXPRESSION: «val nestedIndexExpression = expressionList.size() - 1»
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
   		«FOR ev : exp.second»
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
				//EXPRESSION LEVEL: «nExpression = nExpression + 1»
				//EXPRESSION LEVEL: «expressionList.add(nExpression)»
				//INDEX EXPRESSION: «val nestedIndexExpression = expressionList.size() - 1»
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
				//EXPRESSION LEVEL: «nExpression = nExpression + 1»
				//EXPRESSION LEVEL: «expressionList.add(nExpression)»
				//INDEX EXPRESSION: «val nestedIndexExpression = expressionList.size() - 1»
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
   		«var String fileName = e.eResource.URI.lastSegment»
		String xmiFilename = «className».class.getProtectionDomain().getCodeSource().getLocation().getPath().replace("/bin/", "/")+ "«program.output + fileName.replaceAll(".mutator", ".model")»";
		xmiFilename = "file:/" + xmiFilename.substring(1, xmiFilename.length());
   		//Generate metrics model
		String mutatorecore = MutatorenvironmentPackage.class.getProtectionDomain().getCodeSource().getLocation().getPath().replace("/bin/", "/")+ "model/MutatorEnvironment.ecore";
		mutatorecore = mutatorecore.substring(1, mutatorecore.length()); 
		
		//Load MetaModel
		List<EPackage> mutatorpackages = ModelManager.loadMetaModel(mutatorecore);
		«IF standalone == false»
		Resource mutatormodel = ModelManager.loadModel(mutatorpackages, URI.createURI(xmiFilename).toFileString());
		«ELSE»
		Resource mutatormodel = ModelManager.loadModelNoException(mutatorpackages, URI.createURI(xmiFilename).toFileString());
		«ENDIF»
		
		Map<String, EObject> hmMutator = getMutators(ModelManager.getObjects(mutatormodel));
		«IF (e.definition as Program).exhaustive == true»
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hashmapEObject = new LinkedHashMap<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>();
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hashmapList = new LinkedHashMap<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>>();
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
			Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hashmapEObject = new LinkedHashMap<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>();
			Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hashmapList = new LinkedHashMap<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>>();
			String mutFilename = hashmapModelFilenames.get(modelFilename) + "/" + "Output" + i + ".model";
			String mutFilenameRelativePath = mutFilename.indexOf("/«ProjectUtils.getProject.getName»/") != -1 ? mutFilename.substring(mutFilename.lastIndexOf("/«ProjectUtils.getProject.getName»/"), mutFilename.length()) : mutFilename;
			monitor.subTask("Mutant " + (count * numMutantsToGenerate + i + 1) + "/" + totalMutants + ": " + mutFilenameRelativePath);
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
   		«var String fileName = e.eResource.URI.lastSegment»
		String xmiFilename = «className».class.getProtectionDomain().getCodeSource().getLocation().getPath().replace("/bin/", "/")+ "«program.output + fileName.replaceAll(".mutator", ".model")»";
		xmiFilename = "file:/" + xmiFilename.substring(1, xmiFilename.length());
		//Generate metrics model
		String mutatorecore = MutatorenvironmentPackage.class.getProtectionDomain().getCodeSource().getLocation().getPath().replace("/bin/", "/")+ "model/MutatorEnvironment.ecore";
		mutatorecore = mutatorecore.substring(1, mutatorecore.length()); 
		
		//Load MetaModel
		List<EPackage> mutatorpackages = ModelManager.loadMetaModel(mutatorecore);
		«IF standalone == false»
		Resource mutatormodel = ModelManager.loadModel(mutatorpackages, URI.createURI(xmiFilename).toFileString());
		«ELSE»
		Resource mutatormodel = ModelManager.loadModelNoException(mutatorpackages, URI.createURI(xmiFilename).toFileString());
		«ENDIF»
		
		Map<String, EObject> hmMutator = getMutators(ModelManager.getObjects(mutatormodel));
		
		«IF (e.definition as Program).exhaustive == true»
		Map<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> hashmapEObject = new LinkedHashMap<String, SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>();
		Map<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>> hashmapList = new LinkedHashMap<String, List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>>>();
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
   		«IF (e.definition as Program).exhaustive == true»
		//Frees memory
		try {
			model.unload();
			seed.unload();
		} catch (Exception e) {}
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