package wodel.dsls.generator.mutators.stochastic

import mutatorenvironment.ModifyInformationMutator
import mutatorenvironment.RandomTypeSelection
import java.util.ArrayList
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
import mutatorenvironment.ReferenceUnset
import mutatorenvironment.ReferenceInit
import mutatorenvironment.ReferenceAdd
import mutatorenvironment.ReferenceRemove
import mutatorenvironment.OtherTypeSelection
import mutatorenvironment.ReferenceAtt
import java.util.List
import mutatorenvironment.NullTypeSelection
import wodel.utils.manager.MutatorUtils
import mutatorenvironment.AttributeSet
import mutatorenvironment.ReferenceSet
import mutatorenvironment.Mutator
import mutatorenvironment.Program
import org.eclipse.core.resources.IProject

class WodelGeneratorModifyInformationMutator extends WodelGeneratorGenericOperatorStochasticMutator {
	
	override apply(Mutator mt, String methodName, int[] nMutation, int[] nRegistryMutation, Program program, IProject project, String className, boolean standalone) '''
		«IF mt instanceof ModifyInformationMutator»
		//«var ModifyInformationMutator mut = mt as ModifyInformationMutator»
		//MODIFY INFORMATION «methodName»
				Resource model = MutatorUtils.currentModel(models);
						if (model == null) {
							return mutations;
						}
		«IF mut.object instanceof RandomTypeSelection»
			RandomTypeSelection rts = new RandomTypeSelection(packages, model, "«(mut.object as RandomTypeSelection).type.name»", mutatedObjects);
			«IF mut.object.expression === null»
				EObject object = rts.getObject();
			«ELSE»
				List<EObject> objects = rts.getObjects();
				//EXPRESSION LIST: «var List<Integer> expressionList = new ArrayList<Integer>()»
				//EXPRESSION LIST: «expressionList.add(0)»
				//EXPRESSION LEVEL: «var int[] nExpression = newIntArrayOfSize(1)»
				//EXPRESSION LEVEL: «nExpression.set(0, 0)»
				Expression exp«expressionList.get(0)» = new Expression();
				//REFERENCE LIST: «var int[] nReference = newIntArrayOfSize(1)»
				//REFERENCE LIST: «nReference.set(0, 0)»
				//RECURSION EXPRESSION LIST: «var int[] recursionIndexExpression = newIntArrayOfSize(1)»»
				//REFERENCE LIST: «recursionIndexExpression.set(0, 0)»
		//«var boolean[] evaluation = newBooleanArrayOfSize(1)»
		//«{evaluation.set(0, false); ""}»
				«mut.object.expression.method(mut, nReference, expressionList, nExpression, recursionIndexExpression, false, false, false, evaluation)»
				«IF evaluation.get(0)»
				List<EObject> selectedObjects = auxObjects;
				«ELSE»
				List<EObject> selectedObjects = evaluate(objects, exp«expressionList.get(0)»);
				«ENDIF»
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
				//EXPRESSION LIST: «var List<Integer> expressionList = new ArrayList<Integer>()»
				//EXPRESSION LIST: «expressionList.add(0)»
				//EXPRESSION LEVEL: «var int[] nExpression = newIntArrayOfSize(1)»
				//EXPRESSION LEVEL: «nExpression.set(0, 0)»
				Expression exp«expressionList.get(0)» = new Expression();
				//REFERENCE LIST: «var int[] nReference = newIntArrayOfSize(1)»
				//REFERENCE LIST: «nReference.set(0, 0)»
				//RECURSION EXPRESSION LIST: «var int[] recursionIndexExpression = newIntArrayOfSize(1)»»
				//REFERENCE LIST: «recursionIndexExpression.set(0, 0)»
				//«var boolean[] evaluation = newBooleanArrayOfSize(1)»
				//«{evaluation.set(0, false); ""}»
				«mut.object.expression.method(mut, nReference, expressionList, nExpression, recursionIndexExpression, false, false, false, evaluation)»
				«IF !evaluation.get(0)»
				objects = evaluate(objects, exp«expressionList.get(0)»);
				«ELSE»
				objects = auxObjects;
				«ENDIF»
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
			//COUNTER:«var int[] counter = newIntArrayOfSize(1)»
			//COUNTER:«{counter.set(0, 0); ""}»
			//POSITION: «var int position = 0»
			«FOR AttributeSet c : mut.attributes»
			//COUNTER:«{counter.set(0, counter.get(0) + 1); ""}»
			//POSITION«{position++; ""}»
			//NAME:«var String attributeName = ""»
			«IF c.attribute.get(0) !== null»
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
	   				«attributeOperation.add(attributeName, "objectSelection", counter)»
	   			«ENDIF»
	   			«IF attributeOperation.operator == ArithmeticOperator.SUBTRACT»
	   				List<AttributeConfigurationStrategy> atts = null;
	   				if (attsList.get("«attributeName»") != null) {
	   					atts = attsList.get("«attributeName»");
	   				}
	   				else {
	   					atts = new ArrayList<AttributeConfigurationStrategy>();
	   				}
	   				«attributeOperation.subtract(attributeName, "objectSelection", counter)»
	   			«ENDIF»
	   			«IF attributeOperation.operator == ArithmeticOperator.MULTIPLY»
	   				List<AttributeConfigurationStrategy> atts = null;
					if (attsList.get("«attributeName»") != null) {
						atts = attsList.get("«attributeName»");
					}
					else {
						atts = new ArrayList<AttributeConfigurationStrategy>();
					}
	   				«attributeOperation.multiply(attributeName, "objectSelection", counter)»
	   			«ENDIF»
	   			«IF attributeOperation.operator == ArithmeticOperator.DIVIDE»
	   				List<AttributeConfigurationStrategy> atts = null;
	   				if (attsList.get("«attributeName»") != null) {
	   					atts = attsList.get("«attributeName»");
	   				}
	   				else {
	   					atts = new ArrayList<AttributeConfigurationStrategy>();
	   				}
	   			«attributeOperation.divide(attributeName, "objectSelection", counter)»
	   			«ENDIF»
	   			«IF attributeOperation.operator == ArithmeticOperator.MODULE»
	   				List<AttributeConfigurationStrategy> atts = null;
					if (attsList.get("«attributeName»") != null) {
						atts = attsList.get("«attributeName»");
					}
					else {
						atts = new ArrayList<AttributeConfigurationStrategy>();
					}
	   				«attributeOperation.module(attributeName, "objectSelection", counter)»
	   			«ENDIF»
	   			}
			«ELSE»
			«IF mut.object instanceof CompleteTypeSelection»
			for (ObSelectionStrategy objectSelection : listSelection) {
			«ENDIF»
			«IF position == 1»
			if (objectSelection == null) {
				return mutations;
			}
			List<AttributeConfigurationStrategy> atts = null;
			«ENDIF»
				«c.method(false, true, counter, position, false, "objectSelection")»
			«IF mut.object instanceof CompleteTypeSelection»
			}
			«ENDIF»
			«ENDIF»
   		«ENDFOR»
		Map<String, List<ReferenceConfigurationStrategy>> refsList = new LinkedHashMap<String, List<ReferenceConfigurationStrategy>>();
		Map<String, List<AttributeConfigurationStrategy>> attsRefList = new LinkedHashMap<String, List<AttributeConfigurationStrategy>>();
		List<EObject> objsAttRef = new ArrayList<EObject>();
		//COUNTER:«{counter.set(0, 0); ""}»
		//POSITION: «{position = 0; ""}»
		//NAME:«var String referenceName = ""»
		«FOR ReferenceSet c : mut.references »
			//COUNTER:«{counter.set(0, counter.get(0) + 1); ""}»
			//POSITION«{position++; ""}»
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
		  	«IF c instanceof ReferenceUnset»
	   			«val referenceUnset = c as ReferenceUnset»
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
					refs.add(new NullReferenceConfigurationStrategy(objectSelection.getObject(), "«c.getReference().get(0).name»"));
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
			//NAME:«var String attributeName = ""» 
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
					«IF position == 1»
					if (refObjectSelected == null) {
						return mutations;
					}
					«ENDIF»
						objsAttRef.add(refObjectSelected);
						List<AttributeConfigurationStrategy> attsRef = null;
						if (attsRefList.get("«attributeName»") != null) {
							attsRef = attsRefList.get("«attributeName»");
						}
						else {
							attsRef = new ArrayList<AttributeConfigurationStrategy>();
						}
						«referenceAtt.value.method(attributeName, true, counter, false, "objectSelection")»
						attsRef.add(attConfig);
						attsRefList.put("«attributeName»", attsRef);
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
	   			//INC COUNTER: «nMutation.set(0, nMutation.get(0) + 1)»
	   			//INC COUNTER: «nRegistryMutation.set(0, nRegistryMutation.get(0) + 1)»
	   			if (mut != null) {
	   				mut.setId("m«nMutation.get(0)»");
	   				mutations.add(mut);
	   			}
	   		}
	   	«ELSE»
	   		if (objectSelection != null) {
	   			if (mutatedObjects != null) {
					mutatedObjects.add(objectSelection.getObject());
				}
	   			ModifyInformationMutator mut = new ModifyInformationMutator(objectSelection.getModel(), objectSelection.getMetaModel(), objectSelection, attsList, refsList, objsAttRef, attsRefList);
	   			//INC COUNTER: «nMutation.set(0, nMutation.get(0) + 1)»
	   			//INC COUNTER: «nRegistryMutation.set(0, nRegistryMutation.get(0) + 1)»
	   			if (mut != null) {
	   				mut.setId("m«nMutation.get(0)»");
	   				mutations.add(mut);
	   			}
	   		}
		«ENDIF»
		//END MODIFY INFORMATION «methodName»
	«ENDIF»
	'''

}