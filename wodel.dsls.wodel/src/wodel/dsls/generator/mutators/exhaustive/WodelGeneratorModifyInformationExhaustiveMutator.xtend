package wodel.dsls.generator.mutators.exhaustive

import mutatorenvironment.ModifyInformationMutator
import mutatorenvironment.MutatorEnvironment
import mutatorenvironment.Block
import mutatorenvironment.RandomTypeSelection
import java.util.ArrayList
import mutatorenvironment.CompleteTypeSelection
import mutatorenvironment.SpecificObjectSelection
import mutatorenvironment.SpecificClosureSelection
import org.eclipse.emf.ecore.EAttribute
import java.util.List
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
import mutatorenvironment.ReferenceUnset
import mutatorenvironment.ReferenceInit
import mutatorenvironment.OtherTypeSelection
import mutatorenvironment.NullTypeSelection
import mutatorenvironment.ReferenceAdd
import mutatorenvironment.ReferenceRemove
import mutatorenvironment.ReferenceAtt
import wodel.utils.manager.MutatorUtils
import mutatorenvironment.ReferenceSwap
import org.eclipse.emf.common.util.URI
import org.eclipse.core.resources.IProject
import mutatorenvironment.Mutator
import mutatorenvironment.Program
import wodel.dsls.runner.WodelUtils

class WodelGeneratorModifyInformationExhaustiveMutator extends WodelGeneratorGenericOperatorExhaustiveMutator {

	override apply(Mutator mt, MutatorEnvironment e, Block b, String methodName, int[] nMutation, int[] nMethodCall, int[] nRegistryMutation, int[] nRegistryMethodCall, boolean executeMutation, boolean last, String className, URI fileURI, Program program, IProject project, boolean standalone) '''
	
		«IF mt instanceof ModifyInformationMutator»
		//«var ModifyInformationMutator mut = mt as ModifyInformationMutator»
		//MODIFY INFORMATION «methodName»

		Resource model = MutatorUtils.currentModel(models);
						if (model == null) {
							return numMutantsGenerated;
						}
		«IF mut.object instanceof RandomTypeSelection»
		RandomTypeSelection rts = new RandomTypeSelection(packages, model, "«(mut.object as RandomTypeSelection).type.name»", mutatedObjects);
		«IF mut.object.expression === null»
			List<EObject> objects = rts.getObjects();
		«ELSE»
			List<EObject> objects = rts.getObjects();
			//EXPRESSION LIST: «var List<Integer> expressionList = new ArrayList<Integer>()»
			//EXPRESSION LEVEL: «expressionList.add(0)»
			//INDEX EXPRESSION: «var int[] nExpression = newIntArrayOfSize(1)»
			//INDEX EXPRESSION: «nExpression.set(0, 0)»
			//RECURSION INDEX EXPRESSION: «var int[] recursionIndexExpression = newIntArrayOfSize(1)»
			//RECURSION INDEX EXPRESSION: «recursionIndexExpression.set(0, 0)»
			Expression exp«expressionList.get(0)» = new Expression();
			//«var int[] nReference = newIntArrayOfSize(1)»
			//«nReference.set(0, 0)»
					//«var boolean[] evaluation = newBooleanArrayOfSize(1)»
					//«{evaluation.set(0, false); ""}»
			«mut.object.expression.method(mut, nReference, expressionList, nExpression, recursionIndexExpression, true, false, false, evaluation)»
«IF evaluation.get(0) == false»
			objects = evaluate(objects, exp«expressionList.get(0)»);
					«ELSE»
					objects = auxObjects;
«ENDIF»
		«ENDIF»
		«ELSEIF mut.object instanceof CompleteTypeSelection»
			CompleteTypeSelection cts = new CompleteTypeSelection(packages, model, "«(mut.object as CompleteTypeSelection).type.name»", mutatedObjects);
			List<EObject> objects = cts.getObjects();
		«IF mut.object.expression !== null»
			//EXPRESSION LIST: «var List<Integer> expressionList = new ArrayList<Integer>()»
			//EXPRESSION LEVEL: «expressionList.add(0)»
			//INDEX EXPRESSION: «var int[] nExpression = newIntArrayOfSize(1)»
			//INDEX EXPRESSION: «nExpression.set(0, 0)»
			//RECURSION INDEX EXPRESSION: «var int[] recursionIndexExpression = newIntArrayOfSize(1)»
			//RECURSION INDEX EXPRESSION: «recursionIndexExpression.set(0, 0)»
			Expression exp«expressionList.get(0)» = new Expression();
			//«var int[] nReference = newIntArrayOfSize(1)»
			//«nReference.set(0, 0)»
					//«var boolean[] evaluation = newBooleanArrayOfSize(1)»
					//«{evaluation.set(0, false); ""}»
			«mut.object.expression.method(mut, nReference, expressionList, nExpression, recursionIndexExpression, true, false, false, evaluation)»
«IF evaluation.get(0) == false»
			objects = evaluate(objects, exp«expressionList.get(0)»);
					«ELSE»
					objects = auxObjects;
«ENDIF»
		«ENDIF»
		«ELSEIF mut.object instanceof SpecificObjectSelection»
			List<EObject> objects = new ArrayList<EObject>();
			ObSelectionStrategy objectSelection = null;
			if (hmObjects.get("«(mut.object as SpecificObjectSelection).objSel.name»") != null) {
				SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(mut.object as SpecificObjectSelection).objSel.name» = hmObjects.get("«(mut.object as SpecificObjectSelection).objSel.name»");
				EObject recovered = MutatorUtils.recoverLocalObject(model, entry_«(mut.object as SpecificObjectSelection).objSel.name».getKey());
				if (recovered == null) {
					recovered = ModelManager.getObject(model, entry_«(mut.object as SpecificObjectSelection).objSel.name».getKey());
				}
				if (recovered == null) {
					return numMutantsGenerated;
				}
				objectSelection = new SpecificObjectSelection(packages, model, recovered);
			} else {
				if (hmList.get("«(mut.object as SpecificObjectSelection).objSel.name»") != null) {
					List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_«(mut.object as SpecificObjectSelection).objSel.name» = hmList.get("«(mut.object as SpecificObjectSelection).objSel.name»");
					List<EObject> objs = new ArrayList<EObject>();
					for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_«(mut.object as SpecificObjectSelection).objSel.name») {
						EObject recovered = MutatorUtils.recoverLocalObject(model, ent.getKey());
				if (recovered == null) {
					recovered = ModelManager.getObject(model, ent.getKey());
				}
				if (recovered == null) {
											continue;
										}
										objs.add(recovered);
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
				EObject recovered = MutatorUtils.recoverLocalObject(model, entry_«(mut.object as SpecificClosureSelection).objSel.name».getKey());
				if (recovered == null) {
									recovered = ModelManager.getObject(model, entry_«(mut.object as SpecificClosureSelection).objSel.name».getKey());
								}
								
				if (recovered == null) {
					return numMutantsGenerated;
				}
				objectSelection = new SpecificObjectSelection(packages, model, recovered);
			}
			else {
				if (hmList.get("«(mut.object as SpecificClosureSelection).objSel.name»") != null) {
					List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_«(mut.object as SpecificClosureSelection).objSel.name» = hmList.get("«(mut.object as SpecificClosureSelection).objSel.name»");
					List<EObject> objs = new ArrayList<EObject>();
					for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_«(mut.object as SpecificClosureSelection).objSel.name») {
						EObject recovered = MutatorUtils.recoverLocalObject(model, ent.getKey());
				if (recovered == null) {
									recovered = ModelManager.getObject(model, ent.getKey());
								}
										if (recovered == null) {
											continue;
										}
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
		//«var boolean hasAdditionalResources = MutatorUtils.closureHasAdditionalResources(mut.object)»
		if (objects == null || objects.isEmpty()) {
							return numMutantsGenerated;
						}
						String tempModel =
																			    WodelTempModelContext.nextModelPath(
																			        model,
																			        "«methodName»");
			for (EObject object : objects) {
		try (OwnedResourceScope owned = new OwnedResourceScope()) {
						Resource resource = owned.own(
						                    ModelManager.cloneModel(
						                        model,
						                        tempModel));
				models.add(resource);
				try {
				ObSelectionStrategy obSelection = null;
				«IF mut.object.refType !== null»
				List<EObject> o = ModelManager.getReferences("«mut.object.refType.name»", object);
				object = o.get(ModelManager.getRandomIndex(o));
				«ENDIF»
				EObject localObject = ModelManager.getObject(resource, object);
				if (localObject == null) {
					continue;
				}
					obSelection = new SpecificObjectSelection(packages, resource, localObject);
					Map<String, List<AttributeConfigurationStrategy>> attsList = new LinkedHashMap<String, List<AttributeConfigurationStrategy>>();
		//COUNTER:«var List<Integer> counter = new ArrayList<Integer>()»
		//COUNTER:«{counter.add(0); ""}»
		//POSITION:«var int position = 0»
		«FOR c : mut.attributes »
			//COUNTER:«{counter.set(0, counter.get(0) + 1); ""}»
			//POSITION«{position++; ""}»
			//ATTRIBUTE NAME: «var String attributeName = ""»
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
			   			«IF mut.object.resource === null && !hasAdditionalResources»
			   			EObject recovered = MutatorUtils.recoverLocalObject(resource, entry_«(attributeSwap.object as RandomTypeSelection).name».getKey());
					if (recovered == null) {
						recovered = ModelManager.getObject(resource, entry_«(attributeSwap.object as RandomTypeSelection).name».getKey());
					}
					if (recovered == null) {
						recovered = MutatorUtils.recoverLocalObject(entry_«(attributeSwap.object as RandomTypeSelection).name».getValue().getKey(), entry_«(attributeSwap.object as RandomTypeSelection).name».getKey());
					}
					if (recovered == null) {
						recovered = ModelManager.getObject(entry_«(attributeSwap.object as RandomTypeSelection).name».getValue().getKey(), entry_«(attributeSwap.object as RandomTypeSelection).name».getKey());
					}
					if (recovered == null) {
						continue;
					}
			   			atts.add(new SwapAttributeConfigurationStrategy(recovered, "«(attributeSwap.object as RandomTypeSelection).type.name»", "«c.getAttribute().get(0).name»", "«c.getAttribute().get(1).name»", resource));
			   			attsList.put("«attributeName»", atts);
			   											«ELSE»
			   											if (entry_«(attributeSwap.object as SpecificObjectSelection).objSel.name» == null
			   											        || entry_«(attributeSwap.object as SpecificObjectSelection).objSel.name».getValue() == null
			   											        || entry_«(attributeSwap.object as SpecificObjectSelection).objSel.name».getValue().getKey() == null) {
			   											    continue;
			   											}
			   											
			   											Resource «(attributeSwap.object as SpecificObjectSelection).objSel.name»Resource =
			   											    entry_«(attributeSwap.object as SpecificObjectSelection).objSel.name».getValue().getKey();
			   											
			   											List<EPackage> «(attributeSwap.object as SpecificObjectSelection).objSel.name»Packages =
			   											    entry_«(attributeSwap.object as SpecificObjectSelection).objSel.name».getValue().getValue();
			   											
			   											EObject recovered«(attributeSwap.object as SpecificObjectSelection).objSel.name» =
			   											    MutatorUtils.recoverLocalObject(
			   											        «(attributeSwap.object as SpecificObjectSelection).objSel.name»Resource,
			   											        entry_«(attributeSwap.object as SpecificObjectSelection).objSel.name».getKey());
			   											
			   											if (recovered«(attributeSwap.object as SpecificObjectSelection).objSel.name» == null) {
			   											    recovered«(attributeSwap.object as SpecificObjectSelection).objSel.name» =
			   											        ModelManager.getObject(
			   											            «(attributeSwap.object as SpecificObjectSelection).objSel.name»Resource,
			   											            entry_«(attributeSwap.object as SpecificObjectSelection).objSel.name».getKey());
			   											}
			   											
			   											if (recovered«(attributeSwap.object as SpecificObjectSelection).objSel.name» == null) {
			   											    continue;
			   											}
			   																			atts.add(
			   																											    new SwapAttributeConfigurationStrategy(
			   																											        obSelection.getObject(),
			   																											        recovered«(attributeSwap.object as SpecificObjectSelection).objSel.name»,
			   																											        "«c.getAttribute().get(0).name»", "«c.getAttribute().get(1).name»"
			   																											        «(attributeSwap.object as SpecificObjectSelection).objSel.name»Resource));
			   																											
			   																											attsList.put(
			   																											    "«attributeName»",
			   																											    atts);
			   						   				«ENDIF»
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
				   			«IF mut.object.resource === null && !hasAdditionalResources»
			   				EObject recovered = MutatorUtils.recoverLocalObject(resource, entry_«(attributeSwap.object as SpecificObjectSelection).objSel.name».getKey());
					if (recovered == null) {
						recovered = ModelManager.getObject(resource, entry_«(attributeSwap.object as RandomTypeSelection).name».getKey());
					}
					if (recovered == null) {
						recovered = MutatorUtils.recoverLocalObject(entry_«(attributeSwap.object as RandomTypeSelection).name».getValue().getKey(), entry_«(attributeSwap.object as RandomTypeSelection).name».getKey());
					}
					if (recovered == null) {
						recovered = ModelManager.getObject(entry_«(attributeSwap.object as RandomTypeSelection).name».getValue().getKey(), entry_«(attributeSwap.object as RandomTypeSelection).name».getKey());
					}
					if (recovered == null) {
						continue;
					}
			   				atts.add(new SwapAttributeConfigurationStrategy(obSelection.getObject(), recovered, "«c.getAttribute().get(0).name»", "«c.getAttribute().get(1).name»"));
			   				attsList.put("«attributeName»", atts);
								«ELSE»
								if (entry_«(attributeSwap.object as SpecificObjectSelection).objSel.name» == null
								        || entry_«(attributeSwap.object as SpecificObjectSelection).objSel.name».getValue() == null
								        || entry_«(attributeSwap.object as SpecificObjectSelection).objSel.name».getValue().getKey() == null) {
								    continue;
								}
								
								Resource «(attributeSwap.object as SpecificObjectSelection).objSel.name»Resource =
								    entry_«(attributeSwap.object as SpecificObjectSelection).objSel.name».getValue().getKey();
								
								List<EPackage> «(attributeSwap.object as SpecificObjectSelection).objSel.name»Packages =
								    entry_«(attributeSwap.object as SpecificObjectSelection).objSel.name».getValue().getValue();
								
								EObject recovered«(attributeSwap.object as SpecificObjectSelection).objSel.name» =
								    MutatorUtils.recoverLocalObject(
								        «(attributeSwap.object as SpecificObjectSelection).objSel.name»Resource,
								        entry_«(attributeSwap.object as SpecificObjectSelection).objSel.name».getKey());
								
								if (recovered«(attributeSwap.object as SpecificObjectSelection).objSel.name» == null) {
								    recovered«(attributeSwap.object as SpecificObjectSelection).objSel.name» =
								        ModelManager.getObject(
								            «(attributeSwap.object as SpecificObjectSelection).objSel.name»Resource,
								            entry_«(attributeSwap.object as SpecificObjectSelection).objSel.name».getKey());
								}
								
								if (recovered«(attributeSwap.object as SpecificObjectSelection).objSel.name» == null) {
								    continue;
								}
																atts.add(
																								    new SwapAttributeConfigurationStrategy(
																								        obSelection.getObject(),
																								        recovered«(attributeSwap.object as SpecificObjectSelection).objSel.name»,
																								        "«c.getAttribute().get(0).name»", "«c.getAttribute().get(1).name»"
																								        «(attributeSwap.object as SpecificObjectSelection).objSel.name»Resource));
																								
																								attsList.put(
																								    "«attributeName»",
																								    atts);
			   				«ENDIF»
			   			} else {
			   				continue;
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
					   			«IF mut.object.resource === null && !hasAdditionalResources»
					   			EObject recovered = MutatorUtils.recoverLocalObject(resource, entry_«(attributeCopy.object as SpecificObjectSelection).objSel.name».getKey());
					if (recovered == null) {
						recovered = ModelManager.getObject(resource, entry_«(attributeCopy.object as SpecificObjectSelection).objSel.name».getKey());
					}
					if (recovered == null) {
						recovered = MutatorUtils.recoverLocalObject(entry_«(attributeCopy.object as SpecificObjectSelection).objSel.name».getValue().getKey(), entry_«(attributeCopy.object as SpecificObjectSelection).objSel.name».getKey());
					}
					if (recovered == null) {
						recovered = ModelManager.getObject(entry_«(attributeCopy.object as SpecificObjectSelection).objSel.name».getValue().getKey(), entry_«(attributeCopy.object as SpecificObjectSelection).objSel.name».getKey());
					}
					if (recovered == null) {
						continue;
					}
								«ELSE»
								if (entry_«(attributeCopy.object as SpecificObjectSelection).objSel.name» == null
								        || entry_«(attributeCopy.object as SpecificObjectSelection).objSel.name».getValue() == null
								        || entry_«(attributeCopy.object as SpecificObjectSelection).objSel.name».getValue().getKey() == null) {
								   continue;
								}
								
								Resource «(attributeCopy.object as SpecificObjectSelection).objSel.name»Resource =
								    entry_«(attributeCopy.object as SpecificObjectSelection).objSel.name».getValue().getKey();
								
								List<EPackage> «(attributeCopy.object as SpecificObjectSelection).objSel.name»Packages =
								    entry_«(attributeCopy.object as SpecificObjectSelection).objSel.name».getValue().getValue();
								
								EObject recovered«(attributeCopy.object as SpecificObjectSelection).objSel.name» =
								    MutatorUtils.recoverLocalObject(
								        «(attributeCopy.object as SpecificObjectSelection).objSel.name»Resource,
								        entry_«(attributeCopy.object as SpecificObjectSelection).objSel.name».getKey());
								
								if (recovered«(attributeCopy.object as SpecificObjectSelection).objSel.name» == null) {
								    recovered«(attributeCopy.object as SpecificObjectSelection).objSel.name» =
								        ModelManager.getObject(
								            «(attributeCopy.object as SpecificObjectSelection).objSel.name»Resource,
								            entry_«(attributeCopy.object as SpecificObjectSelection).objSel.name».getKey());
								}
								
								if (recovered«(attributeCopy.object as SpecificObjectSelection).objSel.name» == null) {
								    continue;
								}
								
								«ENDIF»
								«IF mut.object.resource === null && !hasAdditionalResources»
								atts.add(new CopyAttributeConfigurationStrategy(obSelection.getObject(), recovered, "«c.getAttribute().get(0).name»", "«c.getAttribute().get(1).name»"));
								attsList.put("«attributeName»", atts);
								«ELSE»
																atts.add(
																    new CopyAttributeConfigurationStrategy(
																        obSelection.getObject(),
																        recovered«(attributeCopy.object as SpecificObjectSelection).objSel.name»,
																        "«c.getAttribute().get(0).name»", "«c.getAttribute().get(1).name»"));
																
																attsList.put(
																    "«(attributeCopy.object as SpecificObjectSelection).objSel.name»",
																    atts);
								
								«ENDIF»
							} else {
								continue;
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
					   			«IF mut.object.resource === null && !hasAdditionalResources»
						atts.add(new CopyAttributeConfigurationStrategy(obSelection.getObject(), "«c.getAttribute().get(0).name»", "«c.getAttribute().get(1).name»"));
						attsList.put("«attributeName»", atts);
								«ELSE»
								if (entry_«(attributeCopy.object as SpecificObjectSelection).objSel.name» == null
								        || entry_«(attributeCopy.object as SpecificObjectSelection).objSel.name».getValue() == null
								        || entry_«(attributeCopy.object as SpecificObjectSelection).objSel.name».getValue().getKey() == null) {
								    continue;
								}
								
								Resource «(attributeCopy.object as SpecificObjectSelection).objSel.name»Resource =
								    entry_«(attributeCopy.object as SpecificObjectSelection).objSel.name».getValue().getKey();
								
								List<EPackage> «(attributeCopy.object as SpecificObjectSelection).objSel.name»Packages =
								    entry_«(attributeCopy.object as SpecificObjectSelection).objSel.name».getValue().getValue();
								
								EObject recovered«(attributeCopy.object as SpecificObjectSelection).objSel.name» =
								    MutatorUtils.recoverLocalObject(
								        «(attributeCopy.object as SpecificObjectSelection).objSel.name»Resource,
								        entry_«(attributeCopy.object as SpecificObjectSelection).objSel.name».getKey());
								
								if (recovered«(attributeCopy.object as SpecificObjectSelection).objSel.name» == null) {
								    recovered«(attributeCopy.object as SpecificObjectSelection).objSel.name» =
								        ModelManager.getObject(
								            «(attributeCopy.object as SpecificObjectSelection).objSel.name»Resource,
								            entry_«(attributeCopy.object as SpecificObjectSelection).objSel.name».getKey());
								}
								
								if (recovered«(attributeCopy.object as SpecificObjectSelection).objSel.name» == null) {
								    continue;
								}
								
																atts.add(
																    new CopyAttributeConfigurationStrategy(
																        obSelection.getObject(),
																        recovered«(attributeCopy.object as SpecificObjectSelection).objSel.name»,
																        "«c.getAttribute().get(0).name»", "«c.getAttribute().get(1).name»"));
																
																attsList.put(
																    "«(attributeCopy.object as SpecificObjectSelection).objSel.name»",
																    atts);
								
								«ENDIF»
					}
	   			«ENDIF»
	   		«ELSEIF c instanceof AttributeOperation»
	   			«val attributeOperation = c as AttributeOperation»
	   			if (obSelection != null && obSelection.getObject() != null) {
	   			«IF attributeOperation.value instanceof ObjectAttributeType»
	   				//«val ObjectAttributeType objectAtt = attributeOperation.value as ObjectAttributeType»
		   			SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«objectAtt.objSel.name» = hmObjects.get("«objectAtt.objSel.name»");
		   			EObject recovered = MutatorUtils.recoverLocalObject(resource, entry_«objectAtt.objSel.name».getKey());
					if (recovered == null) {
						recovered = ModelManager.getObject(model, entry_«objectAtt.objSel.name».getKey());
					}
					if (recovered == null) {
						recovered = MutatorUtils.recoverLocalObject(entry_«objectAtt.objSel.name».getValue().getKey(), entry_«objectAtt.objSel.name».getKey());
					}
					if (recovered == null) {
						recovered = ModelManager.getObject(entry_«objectAtt.objSel.name».getValue().getKey(), entry_«objectAtt.objSel.name».getKey());
					}
					if (recovered == null) {
						continue;
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
		   			EObject recovered = MutatorUtils.recoverLocalObject(resource, entry_«sel.objSel.name».getKey());
				if (recovered == null) {
					continue;
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
		   			EObject recovered = MutatorUtils.recoverLocalObject(resource, entry_«sel.objSel.name».getKey());
				if (recovered == null) {
					continue;
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
	   				«attributeOperation.add(attributeName, "obSelection", counter)»
	   			«ENDIF»
	   			«IF attributeOperation.operator == ArithmeticOperator.SUBTRACT»
	   				List<AttributeConfigurationStrategy> atts = null;
	   				if (attsList.get("«attributeName»") != null) {
	   					atts = attsList.get("«attributeName»");
	   				}
	   				else {
	   					atts = new ArrayList<AttributeConfigurationStrategy>();
	   				}
	   				«attributeOperation.subtract(attributeName, "obSelection", counter)»
	   			«ENDIF»
	   			«IF attributeOperation.operator == ArithmeticOperator.MULTIPLY»
	   				List<AttributeConfigurationStrategy> atts = null;
					if (attsList.get("«attributeName»") != null) {
						atts = attsList.get("«attributeName»");
					}
					else {
						atts = new ArrayList<AttributeConfigurationStrategy>();
					}
	   				«attributeOperation.multiply(attributeName, "obSelection", counter)»
	   			«ENDIF»
	   			«IF attributeOperation.operator == ArithmeticOperator.DIVIDE»
	   				List<AttributeConfigurationStrategy> atts = null;
	   				if (attsList.get("«attributeName»") != null) {
	   					atts = attsList.get("«attributeName»");
	   				}
	   				else {
	   					atts = new ArrayList<AttributeConfigurationStrategy>();
	   				}
	   			«attributeOperation.divide(attributeName, "obSelection", counter)»
	   			«ENDIF»
	   			«IF attributeOperation.operator == ArithmeticOperator.MODULE»
	   				List<AttributeConfigurationStrategy> atts = null;
					if (attsList.get("«attributeName»") != null) {
						atts = attsList.get("«attributeName»");
					}
					else {
						atts = new ArrayList<AttributeConfigurationStrategy>();
					}
	   				«attributeOperation.module(attributeName, "obSelection", counter)»
	   			«ENDIF»
				«ELSE»
				if (obSelection == null) {
					continue;
				}
				«ENDIF»
				«IF !(c instanceof AttributeSwap) && !(c instanceof AttributeCopy)»
				«IF counter.get(0) == 1»
					List<AttributeConfigurationStrategy> atts = null;
				«ENDIF»
					«c.method(false, true, counter, position, true, "obSelection")»
				«ENDIF»
				«ENDFOR»
		Map<String, List<ReferenceConfigurationStrategy>> refsList = new LinkedHashMap<String, List<ReferenceConfigurationStrategy>>();
		Map<String, List<AttributeConfigurationStrategy>> attsRefList = new LinkedHashMap<String, List<AttributeConfigurationStrategy>>();
		List<EObject> objsAttRef = new ArrayList<EObject>();
		//COUNTER:«{counter.set(0, 0); ""}»
		//POSITION:«{position = 0; ""}»
		«FOR c : mut.references »
			//COUNTER:«{counter.set(0, counter.get(0) + 1); ""}»
			//POSITION«{position++; ""}»
			//REFERENCE NAME: «var String referenceName = ""»
			«IF c.reference.get(0) !==null»
				«val EReference reference = c.reference.get(0)»
				//NAME:«referenceName = reference.name»
			«ELSE»
				//NAME:«referenceName = ""»
			«ENDIF»
		  	«IF c instanceof ReferenceSwap»
	   			«val ReferenceSwap referenceSwap = c as ReferenceSwap»
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
			   			EObject recovered = MutatorUtils.recoverLocalObject(resource, entry_«(referenceSwap.object as RandomTypeSelection).name».getKey());
				if (recovered == null) {
					continue;
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
				   			EObject recovered = MutatorUtils.recoverLocalObject(resource, entry_«(referenceSwap.object as SpecificObjectSelection).objSel.name».getKey());
				if (recovered == null) {
					continue;
				}
							refs.add(new SwapReferenceConfigurationStrategy(obSelection.getObject(), recovered, "«c.getReference().get(0).name»", "«c.getReference().get(1).name»"));
							refsList.put("«referenceName»", refs);
						} else {
							continue;
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
		  	«IF c instanceof ReferenceUnset»
	   			«val ReferenceUnset referenceUnset = c as ReferenceUnset»
	   			«IF referenceUnset.object !== null»
					«IF referenceUnset.object instanceof RandomTypeSelection»
					if (hmObjects.get("«(referenceUnset.object as RandomTypeSelection).name»") != null) {
						List<ReferenceConfigurationStrategy> refs = null;
						if (refsList.get("«referenceName»") != null) {
							refs = refsList.get("«referenceName»");
						}
						else {
							refs = new ArrayList<ReferenceConfigurationStrategy>();
						}
						SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(referenceUnset.object as RandomTypeSelection).name» = hmObjects.get("«(referenceUnset.object as RandomTypeSelection).name»");
						refs.add(new NullReferenceConfigurationStrategy(entry_«(referenceUnset.object as RandomTypeSelection).name».getKey(), "«(referenceUnset.object as RandomTypeSelection).type.name»", "«c.getReference().get(0).name»", entry_«(referenceUnset.object as RandomTypeSelection).name».getValue().getKey()));
						refsList.put("«referenceName», refs);
					}
	   				«ELSEIF referenceUnset.object instanceof SpecificObjectSelection»
					if (objectSelection != null && objectSelection.getObject() != null) {
						if (hmObjects.get("«(referenceUnset.object as SpecificObjectSelection).objSel.name»") != null) {
							List<ReferenceConfigurationStrategy> refs = null;
							if (refsList.get("«referenceName»") != null) {
								refs = refsList.get("«referenceName»");
							}
					   		else {
								refs = new ArrayList<ReferenceConfigurationStrategy>();
					   		}
							SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«(referenceUnset.object as SpecificObjectSelection).objSel.name» = hmObjects.get("«(referenceUnset.object as SpecificObjectSelection).objSel.name»");
							refs.add(new NullReferenceConfigurationStrategy(objectSelection.getObject(), entry_«(referenceUnset.object as SpecificObjectSelection).objSel.name».getKey(), "«c.getReference().get(0).name»"));
							refsList.put("«referenceName»", refs);
						} else {
							continue;
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
					refs.add(new NullReferenceConfigurationStrategy(objectSelection.getObject(), "«c.getReference().get(0).name»"));
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
				   			EObject recovered = MutatorUtils.recoverLocalObject(resource, entry_«(referenceInit.object as SpecificObjectSelection).objSel.name».getKey());
				if (recovered == null) {
					continue;
				}
	   						refs.add(new SpecificReferenceConfigurationStrategy(obSelection.getModel(), obSelection.getObject(), recovered, "«referenceInit.getReference().get(0).name»"));
	   						refsList.put("«referenceName»", refs);
	   					} else {
	   						continue;
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
	   			«IF referenceInit.object instanceof NullTypeSelection»
	   			if (objectSelection != null && objectSelection.getObject() != null) {
	   				List<ReferenceConfigurationStrategy> refs = null;
	   				if (refsList.get("«referenceName»") != null) {
	   					refs = refsList.get("«referenceName»");
	   				}
	   				else {
	   					refs = new ArrayList<ReferenceConfigurationStrategy>();
	   				}
	   				refs.add(new NullReferenceConfigurationStrategy(objectSelection.getModel(), objectSelection.getObject(), "«referenceInit.getReference().get(0).name»"));
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
				   			EObject recovered = MutatorUtils.recoverLocalObject(resource, entry_«(referenceAdd.object as SpecificObjectSelection).objSel.name».getKey());
				if (recovered == null) {
					continue;
				}
	   						refs.add(new SpecificReferenceConfigurationStrategy(obSelection.getModel(), obSelection.getObject(), recovered, "«referenceAdd.getReference().get(0).name»", false));
	   						refsList.put("«referenceName»", refs);
	   					} else {
	   						continue;
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
				   			EObject recovered = MutatorUtils.recoverLocalObject(resource, entry_«(referenceRemove.object as SpecificObjectSelection).objSel.name».getKey());
				if (recovered == null) {
					continue;
				}
	   						refs.add(new SpecificReferenceConfigurationStrategy(obSelection.getModel(), obSelection.getObject(), recovered, "«referenceRemove.getReference().get(0).name»", true));
	   						refsList.put("«referenceName»", refs);
	   					} else {
	   						continue;
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
	   			«IF referenceRemove.object instanceof NullTypeSelection»
	   			if (objectSelection != null && objectSelection.getObject() != null) {
	   				List<ReferenceConfigurationStrategy> refs = null;
	   				if (refsList.get("«referenceName»") != null) {
	   					refs = refsList.get("«referenceName»");
	   				}
	   				else {
	   					refs = new ArrayList<ReferenceConfigurationStrategy>();
	   				}
	   				refs.add(new NullReferenceConfigurationStrategy(objectSelection.getModel(), objectSelection.getObject(), "«referenceRemove.getReference().get(0).name»"));
	   				refsList.put("«referenceName»", refs);
	   			}
	   			«ENDIF»
			«ENDIF»
			«IF c instanceof ReferenceAtt»
				//ATTRIBUTE NAME: «var String attributeName = ""»
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
					   			refObjectSelected = MutatorUtils.recoverObject(resource, entry_«((referenceAtt.eContainer as ModifyInformationMutator).object as SpecificObjectSelection).objSel.name».getKey());
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
					if (refObjectSelected == null) {
						continue;
					}
						objsAttRef.add(refObjectSelected);
						List<AttributeConfigurationStrategy> attsRef = null;
						if (attsRefList.get("«attributeName»") != null) {
							attsRef = attsRefList.get("«attributeName»");
						}
						else {
							attsRef = new ArrayList<AttributeConfigurationStrategy>();
						}
						«referenceAtt.value.method(referenceName, true, counter, true, "obSelection")»
						attsRef.add(attConfig);
						attsRefList.put("«attributeName»", attsRef);
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

		//COUNTER: «nRegistryMutation.set(0, nRegistryMutation.get(0) + 1)»
		//COUNTER: «nRegistryMethodCall.set(0, nRegistryMethodCall.get(0) + 1)»
		//REGISTRY METHOD NAME:«var String registryMethodName = "registry" + nRegistryMethodCall.get(0).toString()»
   		int mutsMark = mutationMark(muts);
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
				            obSelection.getModel(),
				            obSelection.getObject(),
				            null,
				            null,
				            mutPaths,
				            packages);
				Object mutated = mut.mutate();
					if (mutated != null) {
					«IF mut.name !== null»
					SimpleEntry<Resource, List<EPackage>> resourceEntry = new SimpleEntry(mut.getModel(), mut.getMetaModel());
					SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry = new SimpleEntry(mut.getObject(), resourceEntry);
						«IF !(mut.object instanceof CompleteTypeSelection)»
						hmObjects.put("«mut.name»", entry);
						«ELSE»
						hmObjects.remove("«mut.name»");
						hmList.put("«mut.name»", entries);
						«ENDIF»
					«ENDIF»
						AppMutation appMut = «registryMethodName»(mut, hmMutator, seed, obSelection.getModel(), clue, mutPaths, packages);
						if (appMut != null) {
							muts.getMuts().add(appMut);
						}
					}
				}
				«ENDIF»
				mutator = mut;
				try {
				if (mutator != null) {
				//COUNTER: «nMethodCall.set(0, nMethodCall.get(0) + 1)»
				//MUTATION METHOD NAME:«var String nMethodName = "mutation" + nMethodCall.get(0).toString()»
				«IF last == false»
				«IF standalone == false»
				«nMethodName»(packages, models, hmObjects, hmList, hashmapModelFilenames,
									modelFilename, mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,
									registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, project, monitor, k, serialize, test, classes);
				«ELSE»
				«nMethodName»(packages, models, hmObjects, hmList, hashmapModelFilenames,
									modelFilename, mutPaths, hmMutator, seed, registeredPackages, localRegisteredPackages, hashmapModelFolders, ecoreURI,
									registry, hashsetMutantsBlock, fromNames, hashmapMutVersions, muts, monitor, k, serialize, test, classes);
				«ENDIF»
				numMutantsGenerated = k[0];
				}
				} finally {
									     MutatorUtils.rollbackMutations(
									        muts,
									        mutsMark);
									}
									
						} finally {
															models.remove(resource);
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
					newrules.add("«WodelUtils.getConstraintText(fileURI.lastSegment, expression)»");
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
				Mutations registryMuts = MutatorUtils.copyMutationsForRegistry(muts);
		   		«IF b === null»
		   		«IF standalone == false»
		   		//System.out.println("ecoreURI: " + ecoreURI);
		   			boolean isRepeated = registryMutant(ecoreURI, packages, registeredPackages, localRegisteredPackages, seed, mutator.getModel(), rules, registryMuts, modelFilename, mutFilename, registry, hashsetMutantsBlock, hashmapModelFilenames, k, mutPaths, hashmapMutVersions, project, serialize, test, classes, this.getClass(), true);
		   		«ELSE»
		   		//System.out.println("ecoreURI: " + ecoreURI);
		   			boolean isRepeated = registryMutantStandalone(ecoreURI, packages, registeredPackages, localRegisteredPackages, seed, mutator.getModel(), rules, registryMuts, modelFilename, mutFilename, registry, hashsetMutantsBlock, hashmapModelFilenames, k, mutPaths, hashmapMutVersions, "«project.name»", serialize, test, classes, «className».class, true);
		   		«ENDIF»
		   		«ELSE»
		   		«IF standalone == false»
		   		//System.out.println("ecoreURI: " + ecoreURI);
					boolean isRepeated = registryMutantWithBlocks(ecoreURI, packages, registeredPackages, localRegisteredPackages, seed, mutator.getModel(), rules, registryMuts, modelFilename, mutFilename, registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "«b.name»", fromNames, k, mutPaths, hashmapMutVersions, project, serialize, test, classes, this.getClass(), true, false);
				«ELSE»
				//System.out.println("ecoreURI: " + ecoreURI);
					boolean isRepeated = registryMutantWithBlocksStandalone(ecoreURI, packages, registeredPackages, localRegisteredPackages, seed, mutator.getModel(), rules, registryMuts, modelFilename, mutFilename, registry, hashsetMutantsBlock, hashmapModelFilenames, hashmapModelFolders, "«b.name»", fromNames, k, mutPaths, hashmapMutVersions, "«project.name»", serialize, test, classes, «className».class, true, false);
				«ENDIF»
				«ENDIF»
					if (isRepeated == false) {
						numMutantsGenerated++;
						monitor.worked(1);
						k[0] = k[0] + 1;
					}
					//if (muts != null) {
					//	muts.getMuts().clear();
					//}
					}
				} finally {
					     MutatorUtils.rollbackMutations(
					        muts,
					        mutsMark);
					}
									
				} finally {
													models.remove(resource);
													}
				}
		«ENDIF»
				}
		//END MODIFY INFORMATION «methodName»
	«ENDIF»
	'''
	
}