package wodel.dsls.generator.mutators

import java.util.ArrayList
import java.util.List
import mutatorenvironment.AttributeCopy
import mutatorenvironment.AttributeEvaluation
import mutatorenvironment.AttributeOperation
import mutatorenvironment.AttributeReverse
import mutatorenvironment.AttributeScalar
import mutatorenvironment.AttributeSet
import mutatorenvironment.AttributeType
import mutatorenvironment.AttributeUnset
import mutatorenvironment.BooleanType
import mutatorenvironment.CatEndStringType
import mutatorenvironment.CatStartStringType
import mutatorenvironment.CompleteTypeSelection
import mutatorenvironment.DoubleType
import mutatorenvironment.Expression
import mutatorenvironment.IntegerType
import mutatorenvironment.ListStringType
import mutatorenvironment.ListType
import mutatorenvironment.LowerStringType
import mutatorenvironment.MaxValueType
import mutatorenvironment.MinValueType
import mutatorenvironment.NullTypeSelection
import mutatorenvironment.ObSelectionStrategy
import mutatorenvironment.ObjectAttributeType
import mutatorenvironment.OtherTypeSelection
import mutatorenvironment.RandomBooleanType
import mutatorenvironment.RandomDoubleNumberType
import mutatorenvironment.RandomDoubleType
import mutatorenvironment.RandomIntegerNumberType
import mutatorenvironment.RandomIntegerType
import mutatorenvironment.RandomStringNumberType
import mutatorenvironment.RandomStringType
import mutatorenvironment.RandomType
import mutatorenvironment.RandomTypeSelection
import mutatorenvironment.ReferenceAdd
import mutatorenvironment.ReferenceEvaluation
import mutatorenvironment.ReferenceInit
import mutatorenvironment.ReferenceRemove
import mutatorenvironment.ReferenceSet
import mutatorenvironment.ReplaceStringType
import mutatorenvironment.SpecificBooleanType
import mutatorenvironment.SpecificDoubleType
import mutatorenvironment.SpecificIntegerType
import mutatorenvironment.SpecificObjectSelection
import mutatorenvironment.SpecificStringType
import mutatorenvironment.StringType
import mutatorenvironment.TypedSelection
import mutatorenvironment.UpperStringType
import org.eclipse.emf.ecore.EAttribute
import org.eclipse.emf.ecore.EReference
import wodel.utils.manager.MutatorUtils
import mutatorenvironment.BinaryOperator
import mutatorenvironment.Evaluation
import mutatorenvironment.Mutator
import mutatorenvironment.SelectObjectMutator
import mutatorenvironment.RemoveObjectMutator
import mutatorenvironment.ModifyInformationMutator
import mutatorenvironment.CreateObjectMutator
import mutatorenvironment.SelectSampleMutator
import mutatorenvironment.CloneObjectMutator

abstract class WodelGeneratorGenericOperatorMutator {
	
	def method(AttributeSet e, boolean flag, boolean isList, int[] counter, int position, boolean exhaustive, String obSelectionVariableName) '''
		//NAME:«var String attributeName = ""»
    	«IF isList == true»
    	«IF e.attribute.get(0) !== null»
		«val EAttribute attribute = e.attribute.get(0)»
		//NAME:«attributeName = attribute.name»
		«IF counter.get(0) == 1»
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
		«e.value.method(attributeName, flag, counter, exhaustive, obSelectionVariableName)»
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
		«e.value.method(attributeName, flag, counter, exhaustive, obSelectionVariableName)»;
		atts.put("«attributeName»", attConfig);
   		«ENDIF»
   		«IF e instanceof AttributeUnset»
    		atts.put("«attributeName»", null);
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
	
	//REFERENCES COMPILES
	def method(ObSelectionStrategy e, Mutator mut, String referenceName, int[] nReference, List<Integer> expressionList, int[] nExpression, int[] recursionIndexExpression, boolean exhaustive, boolean resources, boolean insideLoop, boolean[] evaluation) '''
  		//REFERENCES COMPILES	«nReference.set(0, nReference.get(0) + 1)»
		«IF e instanceof RandomTypeSelection»
			RandomTypeSelection refRts«nReference.get(0)» = new RandomTypeSelection(packages, model, "«(e as RandomTypeSelection).type.name»");
			«IF e.expression !== null && expressionList !== null»
			List<EObject> refObjects«nReference.get(0)» = refRts«nReference.get(0)».getObjects();
			//INDEX EXPRESSION: « var indexExpression = expressionList.size() - 1»
			Expression exp«expressionList.get(indexExpression)» = new Expression();
	   		«e.expression.method(mut,nReference, expressionList, nExpression, recursionIndexExpression, false, resources, insideLoop, evaluation)»
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
			//INDEX EXPRESSION: « var indexExpression = expressionList.size() - 1»
			Expression exp«expressionList.get(indexExpression)» = new Expression();
	   		«e.expression.method(mut, nReference, expressionList, nExpression, recursionIndexExpression, false, resources, insideLoop, evaluation)»
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
			//INDEX EXPRESSION: « var indexExpression = expressionList.size() - 1»
			Expression exp«expressionList.get(indexExpression)» = new Expression();
	   		«e.expression.method(mut, nReference, expressionList, nExpression, recursionIndexExpression, false, resources, insideLoop, evaluation)»
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
				EObject localT =
				        MutatorUtils.recoverLocalObject(
				            model,
				            entry_«(e as SpecificObjectSelection).objSel.name»_«nReference.get(0)».getKey());
				
				    if (localT == null) {
				        localT =
				            ModelManager.getObject(
				                model,
				                entry_«(e as SpecificObjectSelection).objSel.name»_«nReference.get(0)».getKey());
				    }
				
				    if (localT == null) {
   									«IF insideLoop == false»
   									«IF exhaustive == true»
   									return numMutantsGenerated;
   									«ELSE»
   									return mutations;
   									«ENDIF»
   									«ELSE»
   									continue;
   									«ENDIF»
				    }
			«IF e.refType !== null»
				refSelection«nReference.get(0)» = new SpecificObjectSelection(packages, model, localT, "«e.refType.name»");
			«ELSE»
				refSelection«nReference.get(0)» = new SpecificObjectSelection(packages, model, localT);
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
						EObject obj =
						        MutatorUtils.recoverLocalObject(
						            model,
						            ent.getKey());
						
						    if (obj == null) {
						        obj =
						            ModelManager.getObject(
						                model,
						                ent.getKey());
						    }
						
						    if (obj != null) {
						        objs.add(obj);
						    }
					}
					if (objs.isEmpty()) {
   									«IF insideLoop == false»
   									«IF exhaustive == true»
   									return numMutantsGenerated;
   									«ELSE»
   									return mutations;
   									«ENDIF»
   									«ELSE»
   									continue;
   									«ENDIF»
						}
				«IF e.refType !== null»
					refSelection«nReference.get(0)» = new SpecificObjectSelection(packages, model, objs, "«e.refType.name»");
				«ELSE»
					refSelection«nReference.get(0)» = new SpecificObjectSelection(packages, model, objs);
				«ENDIF»
				}
				else {
   									«IF insideLoop == false»
   									«IF exhaustive == true»
   									return numMutantsGenerated;
   									«ELSE»
   									return mutations;
   									«ENDIF»
   									«ELSE»
   									continue;
   									«ENDIF»
				}
			}
		«ENDIF»
	'''
	//END REFERENCES COMPILES
	//************************
	
	def method(ReferenceSet e, Mutator mut, int[] nReference, List<Integer> expressionList, int[] nExpression, int[] recursionIndexExpression, boolean exhaustive, boolean resources, boolean insideLoop, boolean[] evaluation) '''
		//NAME:«var String referenceName = ""»
		«IF e.reference.get(0) !== null»
		«val EReference reference = e.reference.get(0)»
		//NAME:«referenceName = reference.name»
		«ELSE»
		//NAME:«referenceName = ""»
		«ENDIF»
		«IF e instanceof ReferenceInit»
		«(e as ReferenceInit).object.method(mut, referenceName, nReference, expressionList, nExpression, recursionIndexExpression, exhaustive, resources, insideLoop, evaluation)»
		«ENDIF»
		«IF e instanceof ReferenceRemove»
		«(e as ReferenceRemove).object.method(mut, referenceName, nReference, expressionList, nExpression, recursionIndexExpression, exhaustive, resources, insideLoop, evaluation)»
		«ENDIF»
		«IF e instanceof ReferenceAdd»
		«(e as ReferenceAdd).object.method(mut, referenceName, nReference, expressionList, nExpression, recursionIndexExpression, exhaustive, resources, insideLoop, evaluation)»
		«ENDIF»
   		refs.put("«referenceName»", refSelection«nReference.get(0)»);
	'''	
	def method(AttributeType e, String attributeName, boolean flag, int[] counter, boolean exhaustive, String obSelectionVariableName) '''
	«IF attributeName !== null»
	«IF e instanceof StringType»
		«(e as StringType).method(attributeName, exhaustive, counter)»
	«ELSEIF e instanceof DoubleType»
		«(e as DoubleType).method(exhaustive, counter)»
	«ELSEIF e instanceof BooleanType»
		«(e as BooleanType).method(exhaustive, counter)»
	«ELSEIF e instanceof IntegerType»
		«(e as IntegerType).method(exhaustive, counter)»
	«ELSEIF e instanceof ListStringType»
		«(e as ListStringType).method(attributeName, flag, exhaustive, counter, obSelectionVariableName)»
	«ELSEIF e instanceof ListType»
		«(e as ListType).method(attributeName, flag, exhaustive, counter, obSelectionVariableName)»
	«ELSEIF e instanceof RandomType»
		«(e as RandomType).method(attributeName, flag, exhaustive, counter, obSelectionVariableName)»
	«ELSEIF e instanceof MinValueType»
		«(e as MinValueType).method(exhaustive, counter)»
	«ELSEIF e instanceof MaxValueType»
		«(e as MaxValueType).method(exhaustive, counter)»
	«ELSEIF e instanceof RandomIntegerNumberType»
		«(e as RandomIntegerNumberType).method(exhaustive, counter)»
	«ELSEIF e instanceof RandomDoubleNumberType»
		«(e as RandomDoubleNumberType).method(exhaustive, counter)»
	«ENDIF»
	«ENDIF»
	'''
	
	//********************
	//DATA TYPES COMPILES
	def method(StringType e, String attributeName, boolean exhaustive, int[] counter) ''' 
	«IF attributeName !== null»
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
		«ENDIF»
	'''
				
	def method(DoubleType e, boolean exhaustive, int[] counter) ''' 
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
	def method(BooleanType e, boolean exhaustive, int[] counter) ''' 
		«IF counter.get(0) == 1»
		AttributeConfigurationStrategy attConfig = null;
		«ENDIF»
		«IF e instanceof SpecificBooleanType»
			attConfig = new SpecificBooleanConfigurationStrategy(«(e as SpecificBooleanType).value»);
		«ELSEIF e instanceof RandomBooleanType»
			attConfig = new RandomBooleanConfigurationStrategy();
		«ENDIF»
		'''	
	def method(IntegerType e, boolean exhaustive, int[] counter) '''
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
	def method(ListStringType e, String attributeName, boolean flag, boolean exhaustive, int[] counter, String obSelectionVariableName) '''
	«IF attributeName !== null»
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
	«ENDIF»
		'''
		
	def method(ListType e, String attributeName, boolean flag, boolean exhaustive, int[] counter, String obSelectionVariableName) '''
	«IF attributeName !== null»
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
	«ENDIF»
		'''
	def method(RandomType e, String attributeName, boolean flag, boolean exhaustive, int[] counter, String obSelectionVariableName) '''
	«IF attributeName !== null»
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
	«ENDIF»
		'''
	def method(MinValueType e, boolean exhaustive, int[] counter) '''
		«IF counter.get(0) == 1»
		AttributeConfigurationStrategy attConfig = null;
		«ENDIF»
		attConfig = new MinValueConfigurationStrategy(packages, model, "«MutatorUtils.getTypeName(e)»", "«e.attribute.name»");
		'''
	def method(MaxValueType e, boolean exhaustive, int[] counter) '''
		«IF counter.get(0) == 1»
		AttributeConfigurationStrategy attConfig = null;
		«ENDIF»
		attConfig = new MaxValueConfigurationStrategy(packages, model, "«MutatorUtils.getTypeName(e)»", "«e.attribute.name»");
		'''
	def method(RandomIntegerNumberType e, boolean exhaustive, int[] counter) '''
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
	def method(RandomDoubleNumberType e, boolean exhaustive, int[] counter) '''
		«IF counter.get(0) == 1»
		AttributeConfigurationStrategy attConfig = null;
		«ENDIF»
		«IF e.object instanceof SpecificObjectSelection»
		//«var SpecificObjectSelection sel = e.object as SpecificObjectSelection»
		attConfig = new RandomDoubleConfigurationStrategy(«e.min», ModelManager.getDoubleAttribute("«e.max.name»", (hmObjects.get("«sel.objSel.name»") != null ? hmObjects.get("«sel.objSel.name»").getKey() : null)), false);
		«ENDIF»
	'''

	def add(AttributeOperation op, String attributeName, String obSelectionVariableName, int[] counter) '''
	«IF attributeName !== null»
		atts.add(new AddOperationConfigurationStrategy(«obSelectionVariableName».getMetaModel(), «obSelectionVariableName».getModel(), "«MutatorUtils.getTypeName(op)»", "«attributeName»", «obSelectionVariableName».getObject(), value));
		attsList.put("«attributeName»", atts);
	«ENDIF» 
	'''

	def subtract(AttributeOperation op, String attributeName, String obSelectionVariableName, int[] counter) '''
	«IF attributeName !== null»
		atts.add(new SubtractOperationConfigurationStrategy(«obSelectionVariableName».getMetaModel(), «obSelectionVariableName».getModel(), "«MutatorUtils.getTypeName(op)»", "«attributeName»", «obSelectionVariableName».getObject(), value));
		attsList.put("«attributeName»", atts); 
	«ENDIF» 
	'''

	def multiply(AttributeOperation op, String attributeName, String obSelectionVariableName, int[] counter) '''
	«IF attributeName !== null»
		atts.add(new MultiplyOperationConfigurationStrategy(«obSelectionVariableName».getMetaModel(), «obSelectionVariableName».getModel(), "«MutatorUtils.getTypeName(op)»", "«attributeName»", «obSelectionVariableName».getObject(), value));
		attsList.put("«attributeName»", atts); 
	«ENDIF» 
	'''

	def divide(AttributeOperation op, String attributeName, String obSelectionVariableName, int[] counter) '''
	«IF attributeName !== null»
		atts.add(new DivideOperationConfigurationStrategy(«obSelectionVariableName».getMetaModel(), «obSelectionVariableName».getModel(), "«MutatorUtils.getTypeName(op)»", "«attributeName»", «obSelectionVariableName».getObject(), value));
		attsList.put("«attributeName»", atts); 
	«ENDIF» 
	'''

	def module(AttributeOperation op, String attributeName, String obSelectionVariableName, int[] counter) '''
	«IF attributeName !== null»
		atts.add(new ModuleOperationConfigurationStrategy(«obSelectionVariableName».getMetaModel(), «obSelectionVariableName».getModel(), "«MutatorUtils.getTypeName(op)»", "«attributeName»", «obSelectionVariableName».getObject(), value));
		attsList.put("«attributeName»", atts); 
	«ENDIF» 
	'''
	//END DATA TYPES COMPILES
	//************************
	//********************
	//REFERENCES COMPILES
	def method(ObSelectionStrategy e, Mutator mut, String referenceName, boolean exhaustive, List<Integer> expressionList, int[] nReference, boolean resources, boolean insideLoop, boolean[] evaluation) '''
  		//REFERENCES COMPILES	«nReference.set(0, nReference.get(0) + 1)»
		«IF e instanceof RandomTypeSelection»
			RandomTypeSelection refRts«nReference.get(0)» = new RandomTypeSelection(packages, model, "«(e as RandomTypeSelection).type.name»");
			«IF e.expression !== null && expressionList !== null»
			List<EObject> refObjects«nReference.get(0)» = refRts«nReference.get(0)».getObjects();
			//INDEX EXPRESSION: «var int indexExpression = expressionList.size() - 1»
			Expression exp«expressionList.get(indexExpression)» = new Expression();
			//INDEX EXPRESSION: «var int[] nExpression = newIntArrayOfSize(1)»
			//INDEX EXPRESSION: «nExpression.set(0, 0)»
			//RECURSION INDEX EXPRESSION: «var int[] recursionIndexExpression = newIntArrayOfSize(1)»
			//RECURSION INDEX EXPRESSION: «recursionIndexExpression.set(0, 0)»
			«e.expression.method(mut, nReference, expressionList, nExpression, recursionIndexExpression, false,resources, insideLoop, evaluation)»
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
			//INDEX EXPRESSION: « var indexExpression = expressionList.size() - 1»
			Expression exp«expressionList.get(indexExpression)» = new Expression();
			//INDEX EXPRESSION: «var int[] nExpression = newIntArrayOfSize(1)»
			//INDEX EXPRESSION: «nExpression.set(0, 0)»
			//RECURSION INDEX EXPRESSION: «var int[] recursionIndexExpression = newIntArrayOfSize(1)»
			//RECURSION INDEX EXPRESSION: «recursionIndexExpression.set(0, 0)»
			«e.expression.method(mut, nReference, expressionList, nExpression, recursionIndexExpression, false, resources, insideLoop, evaluation)»
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
			//INDEX EXPRESSION: « var indexExpression = expressionList.size() - 1»
			Expression exp«expressionList.get(indexExpression)» = new Expression();
			//INDEX EXPRESSION: «var int[] nExpression = newIntArrayOfSize(1)»
			//INDEX EXPRESSION: «nExpression.set(0, 0)»
			//RECURSION INDEX EXPRESSION: «var int[] recursionIndexExpression = newIntArrayOfSize(1)»
			//RECURSION INDEX EXPRESSION: «recursionIndexExpression.set(0, 0)»
			«e.expression.method(mut, nReference, expressionList, nExpression, recursionIndexExpression, false, resources, insideLoop, evaluation)»
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
   									«IF insideLoop == false»
   									«IF exhaustive == true»
   									return numMutantsGenerated;
   									«ELSE»
   									return mutations;
   									«ENDIF»
   									«ELSE»
   									continue;
   									«ENDIF»
				}
			}
		«ENDIF»
	'''
	//END REFERENCES COMPILES
	//************************
   
	def compileAuxiliarExpression(int expressionPosition, List<Integer> expressionList) {
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
   def Object method(Expression exp, Mutator mut, int[] nReference, List<Integer> expressionList, int[] nExpression, int[] recursionIndexExpression, boolean exhaustive, boolean resources, boolean insideLoop, boolean[] evaluation) '''
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
			//«var expressionPosition = 0»
			«IF resources == false»
			«IF expressionPosition == 0»
			MinValueConfigurationStrategy min«expressionList.get(indexExpression)» = new MinValueConfigurationStrategy(packages, model, "«MutatorUtils.getTypeName(attev.value as MinValueType)»", "«(attev.value as MinValueType).attribute.name»");
			«ELSE»
			«compileAuxiliarExpression(expressionPosition, expressionList)»
			MinValueConfigurationStrategy min«expressionList.get(indexExpression)» = new MinValueConfigurationStrategy(packages, model, "«MutatorUtils.getTypeName(attev.value as MinValueType)»", sameValue, "«(attev.value as MinValueType).attribute.name»");
			«ENDIF»
			((AttributeEvaluation) exp«expressionList.get(indexExpression)».first).values.add(min«expressionList.get(indexExpression)».getValue());
			«{evaluation.set(0, true); ""}»
			«ELSE»
			«IF expressionPosition == 0»
			MinValueConfigurationStrategy min«expressionList.get(indexExpression)» = new MinValueConfigurationStrategy(resourcePackages, resources, "«MutatorUtils.getTypeName(attev.value as MinValueType)»", "«(attev.value as MinValueType).attribute.name»");
			«ELSE»
			«compileAuxiliarExpression(expressionPosition, expressionList)»
			MinValueConfigurationStrategy min«expressionList.get(indexExpression)» = new MinValueConfigurationStrategy(resourcePackages, model, "«MutatorUtils.getTypeName(attev.value as MinValueType)»", sameValue, "«(attev.value as MinValueType).attribute.name»");
			«{evaluation.set(0, true); ""}»
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
			«{evaluation.set(0, true); ""}»
		«ENDIF»
		«IF attev.value instanceof MaxValueType»
			//«var expressionPosition = 0»
			«IF resources == false»
			«IF expressionPosition == 0»
			MaxValueConfigurationStrategy max«expressionList.get(indexExpression)» = new MaxValueConfigurationStrategy(packages, model, "«MutatorUtils.getTypeName(attev.value as MaxValueType)»", "«(attev.value as MaxValueType).attribute.name»");
			«ELSE»
			«compileAuxiliarExpression(expressionPosition, expressionList)»
			MaxValueConfigurationStrategy max«expressionList.get(indexExpression)» = new MaxValueConfigurationStrategy(packages, model, "«MutatorUtils.getTypeName(attev.value as MaxValueType)»", sameValue, "«(attev.value as MaxValueType).attribute.name»");
			«ENDIF»
			((AttributeEvaluation) exp«expressionList.get(indexExpression)».first).values.add(max«expressionList.get(indexExpression)».getValue());
			«{evaluation.set(0, true); ""}»
			«ELSE»
			«IF expressionPosition == 0»
			MaxValueConfigurationStrategy max«expressionList.get(indexExpression)» = new MaxValueConfigurationStrategy(resourcePackages, resources, "«MutatorUtils.getTypeName(attev.value as MaxValueType)»", "«(attev.value as MaxValueType).attribute.name»");
			«ELSE»
			«compileAuxiliarExpression(expressionPosition, expressionList)»
			MaxValueConfigurationStrategy max«expressionList.get(indexExpression)» = new MaxValueConfigurationStrategy(resourcePackages, model, "«MutatorUtils.getTypeName(attev.value as MaxValueType)»", sameValue, "«(attev.value as MaxValueType).attribute.name»");
			«{evaluation.set(0, true); ""}»
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
			«{evaluation.set(0, true); ""}»
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
		//REFERENCE: «val ReferenceEvaluation refev = exp.first as ReferenceEvaluation»
	   	«IF refev.name !== null»
			((ReferenceEvaluation) exp«expressionList.get(indexExpression)».first).name = "«refev.name.name»";
			«IF refev.value instanceof TypedSelection && recursionIndexExpression.get(0) != 0»
			refNames«expressionList.get(recursionIndexExpression.get(0))».add("«refev.name.name»");
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
  			((ReferenceEvaluation) exp«expressionList.get(indexExpression)».first).value = ModelManager.getStringAttribute("«(refev.attValue as ObjectAttributeType).attribute.name»", (hmObjects.get("«(refev.attValue as ObjectAttributeType).objSel.name»") != null ? hmObjects.get("«(refev.attValue as ObjectAttributeType).objSel.name»").getKey() : null));
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
				«compileAuxiliarExpression(indexExpression, expressionList)»
				MinValueConfigurationStrategy min«expressionList.get(indexExpression)» = new MinValueConfigurationStrategy(packages, model, "«MutatorUtils.getTypeName(refev.attValue as MinValueType)»", sameValue, "«(refev.attValue as MinValueType).attribute.name»");
			«ENDIF»
				((ReferenceEvaluation) exp«expressionList.get(indexExpression)».first).value = min«expressionList.get(indexExpression)».getValue();
			«{evaluation.set(0, true); ""}»
			«ELSE»
			«IF indexExpression == 0»
				MinValueConfigurationStrategy min«expressionList.get(indexExpression)» = new MinValueConfigurationStrategy(resourcePackages, resources, "«MutatorUtils.getTypeName(refev.attValue as MinValueType)»", "«(refev.attValue as MinValueType).attribute.name»");
			«ELSE»
				«compileAuxiliarExpression(indexExpression, expressionList)»
				MinValueConfigurationStrategy min«expressionList.get(indexExpression)» = new MinValueConfigurationStrategy(resourcePackages, resources, "«MutatorUtils.getTypeName(refev.attValue as MinValueType)»", sameValue, "«(refev.attValue as MinValueType).attribute.name»");
			«ENDIF»
				((ReferenceEvaluation) exp«expressionList.get(indexExpression)».first).value = min«expressionList.get(indexExpression)».getValue();
			«{evaluation.set(0, true); ""}»
			«ENDIF»
			«IF refev.attValue instanceof MaxValueType»
			//«var expressionPosition = 0»
			«IF resources == false»
			«IF expressionPosition == 0»
				MaxValueConfigurationStrategy max«expressionList.get(indexExpression)» = new MaxValueConfigurationStrategy(packages, model, "«MutatorUtils.getTypeName(refev.attValue as MaxValueType)»", "«(refev.attValue as MaxValueType).attribute.name»");
			«ELSE»
				«compileAuxiliarExpression(expressionPosition, expressionList)»
				MaxValueConfigurationStrategy max«expressionList.get(indexExpression)» = new MaxValueConfigurationStrategy(packages, model, "«MutatorUtils.getTypeName(refev.attValue as MaxValueType)»", sameValue, "«(refev.attValue as MaxValueType).attribute.name»");
			«ENDIF»
				((ReferenceEvaluation) exp«expressionList.get(indexExpression)».first).value = max«expressionList.get(indexExpression)».getValue();
			«{evaluation.set(0, true); ""}»
			«ELSE»
			«IF expressionPosition == 0»
				MaxValueConfigurationStrategy max«expressionList.get(indexExpression)» = new MaxValueConfigurationStrategy(resourcePackages, resources, "«MutatorUtils.getTypeName(refev.attValue as MaxValueType)»", "«(refev.attValue as MaxValueType).attribute.name»");
			«ELSE»
				«compileAuxiliarExpression(expressionPosition, expressionList)»
				MaxValueConfigurationStrategy max«expressionList.get(indexExpression)» = new MaxValueConfigurationStrategy(resourcePackages, model, "«MutatorUtils.getTypeName(refev.attValue as MaxValueType)»", sameValue, "«(refev.attValue as MaxValueType).attribute.name»");
			«ENDIF»
				((ReferenceEvaluation) exp«expressionList.get(indexExpression)».first).value = max«expressionList.get(indexExpression)».getValue();
			«{evaluation.set(0, true); ""}»
			«ENDIF»
			«ENDIF»
			«ENDIF»
			«ENDIF»
			«ENDIF»
   		«ELSEIF refev.value instanceof SpecificObjectSelection»
   			«IF refev.refType === null && refev.value.refType === null»
            «IF mut instanceof ModifyInformationMutator || mut instanceof CreateObjectMutator || mut instanceof SelectObjectMutator || mut instanceof RemoveObjectMutator || mut instanceof SelectSampleMutator || mut instanceof CloneObjectMutator»
            //«var boolean hasAdditionalResources = false»
            «IF mut instanceof ModifyInformationMutator»
            //«var ModifyInformationMutator modMut = mut as ModifyInformationMutator»
            //«hasAdditionalResources = MutatorUtils.closureHasAdditionalResources(modMut.object)»
            «ENDIF»
            «IF mut instanceof CreateObjectMutator»
            //«var CreateObjectMutator crMut = mut as CreateObjectMutator»
            //«hasAdditionalResources = MutatorUtils.closureHasAdditionalResources(crMut.container)»
            «ENDIF»
            «IF mut instanceof SelectObjectMutator»
            //«var SelectObjectMutator selMut = mut as SelectObjectMutator»
            //«hasAdditionalResources = MutatorUtils.closureHasAdditionalResources(selMut.object)»
            «ENDIF»
            «IF mut instanceof RemoveObjectMutator»
            //«var RemoveObjectMutator delMut = mut as RemoveObjectMutator»
            //«hasAdditionalResources = MutatorUtils.closureHasAdditionalResources(delMut.object)»
            «ENDIF»
            «IF mut instanceof SelectSampleMutator»
            //«var SelectSampleMutator samMut = mut as SelectSampleMutator»
            //«hasAdditionalResources = MutatorUtils.closureHasAdditionalResources(samMut.object)»
            «ENDIF»
            «IF mut instanceof CloneObjectMutator»
            //«var CloneObjectMutator clnMut = mut as CloneObjectMutator»
            //«hasAdditionalResources = MutatorUtils.closureHasAdditionalResources(clnMut.object)»
            «ENDIF»
            «IF hasAdditionalResources»
            List<EObject> sameValue = new ArrayList<EObject>();
            List<EObject> referenceValues = new ArrayList<EObject>();
   			SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«expressionList.get(indexExpression)» = hmObjects.get("«(refev.value as SpecificObjectSelection).objSel.name»");
   			if (entry_«expressionList.get(indexExpression)» != null) {
   				
   				EObject localV1 =
   				   				                    MutatorUtils.recoverLocalObject(
   				   				                        model,
   				   				                        entry_«expressionList.get(indexExpression)».getKey());
   				   				
   				   				                if (localV1 == null) {
   				   				                    localV1 =
   				   				                        ModelManager.getObject(
   				   				                            model,
   				   				                            entry_«expressionList.get(indexExpression)».getKey());
   				   				                }
   				   								if (localV1 == null) {
   				   									«IF insideLoop == false»
   				   									«IF exhaustive == true»
   				   									return numMutantsGenerated;
   				   									«ELSE»
   				   									return mutations;
   				   									«ENDIF»
   				   									«ELSE»
   				   									continue;
   				   									«ENDIF»
   				   								}
   				
   				   				
								for (EObject candidate : objects) {
									 EStructuralFeature feature =
									        candidate.eClass()
									                 .getEStructuralFeature("«refev.name.name»");
									
									    if (!(feature instanceof EReference)) {
									        continue;
									    }
									
									    Object refValue =
									        candidate.eGet(feature);
									
									    if (!(refValue instanceof EObject)) {
									        continue;
									    }
									    EObject referencedValue =
									            (EObject) refValue;
									        EObject localRefValue =
									            MutatorUtils.recoverLocalObject(
									                model,
									                referencedValue);
									
									if (localRefValue == null) {
									        localRefValue =
									            ModelManager.getObject(
									                model,
									                referencedValue);
									    }
									
									    if (localRefValue != null
									            && EcoreUtil.equals(
									                localRefValue,
									                localV1)) {
									                	
									if (!referenceValues.contains(referencedValue)) {
									    referenceValues.add(referencedValue);
									}
									sameValue.add(candidate);
									
								}
					}
					if (sameValue.isEmpty()) {
					    «IF insideLoop == false»
					       				   									«IF exhaustive == true»
					       				   									return numMutantsGenerated;
					       				   									«ELSE»
					       				   									return mutations;
					       				   									«ENDIF»
					       				   									«ELSE»
					       				   									continue;
					       				   									«ENDIF»
					}
   				//EObject recovered = MutatorUtils.recoverLocalObject(model, entry_«expressionList.get(indexExpression)».getKey());
                //((ReferenceEvaluation) exp«expressionList.get(indexExpression)».first).value = sameValue;
                
	                /*
                     * Set the RHS of:
                     *
                     *     candidate.refValue = refValue
                     *
                     * using the current values returned by
                     * candidate.intent1 in the annotation ResourceSet.
                     */
                    if (referenceValues.size() == 1) {
                
                        ((ReferenceEvaluation) exp«expressionList.get(indexExpression)».first).value =
                            referenceValues.get(0);
                
                    } else {
                
                        ((ReferenceEvaluation) exp«expressionList.get(indexExpression)».first).value =
                            referenceValues;
                    }
   				
				//}
   				

   				
				//((ReferenceEvaluation) exp«expressionList.get(indexExpression)».first).value = new SpecificObjectSelection(packages, model, recovered).getObject();
   				            //}
   				            //break;
   				            //}
   				            //}
   				            «ENDIF»
   				            «IF !hasAdditionalResources»
   			SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«expressionList.get(indexExpression)» = hmObjects.get("«(refev.value as SpecificObjectSelection).objSel.name»");
   			if (entry_«expressionList.get(indexExpression)» != null) {
   				
   				                EObject localValue =
   				                    MutatorUtils.recoverLocalObject(
   				                        model,
   				                        entry_«expressionList.get(indexExpression)».getKey());
   				
   				                if (localValue == null) {
   				                    localValue =
   				                        ModelManager.getObject(
   				                            model,
   				                            entry_«expressionList.get(indexExpression)».getKey());
   				                }
   								if (localValue == null) {
   									«IF insideLoop == false»
   									«IF exhaustive == true»
   									return numMutantsGenerated;
   									«ELSE»
   									return mutations;
   									«ENDIF»
   									«ELSE»
   									continue;
   									«ENDIF»
   								}

   				
                ((ReferenceEvaluation) exp«expressionList.get(indexExpression)».first).value = localValue;
   				            «ENDIF»
   				            «ENDIF»
			}
			else {
				List<SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>>> listEntry_«expressionList.get(indexExpression)» = hmList.get("«(refev.value as SpecificObjectSelection).objSel.name»");
				if (listEntry_«expressionList.get(indexExpression)» != null) {
				List<EObject> objs = new ArrayList<EObject>();
				for (SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> ent : listEntry_«expressionList.get(indexExpression)») {
				«IF resources == false»
				EObject obj = MutatorUtils.recoverLocalObject(model, ent.getKey());
				«ELSE»
				EObject obj = MutatorUtils.recoverLocalObject(selection, ent.getKey());
				«ENDIF»
				if (obj == null) {
				«IF resources == false»
					obj = ModelManager.getObject(model, ent.getKey());
				«ELSE»
					obj = ModelManager.getObject(selection, ent.getKey());
				«ENDIF»
				}
				if (obj != null) {
					objs.add(obj);
				}
				}
				((ReferenceEvaluation) exp«expressionList.get(indexExpression)».first).value = objs;
			}
			else {
   									«IF insideLoop == false»
   									«IF exhaustive == true»
   									return numMutantsGenerated;
   									«ELSE»
   									return mutations;
   									«ENDIF»
   									«ELSE»
   									continue;
   									«ENDIF»
			}
			}
	   		«ELSE»
	   		«IF refev.refType !== null»
	   		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«expressionList.get(indexExpression)» = hmObjects.get("«(refev.value as SpecificObjectSelection).objSel.name»");
	   		if (entry_«expressionList.get(indexExpression)» != null) {
	   		   				
	   		   				EObject srcObjExp =
	   		   				        entry_«expressionList.get(indexExpression)».getKey();
	   		   				
	   		   				EStructuralFeature feature =
	   		   				    srcObjExp.eClass()
	   		   				               .getEStructuralFeature(
	   		   				                   "«refev.refType.name»");
	   		   				                   
	   		   				                   
	   		   			if (!(feature instanceof EReference)) {
	   		   			    «IF insideLoop == false»
	   		   			       									«IF exhaustive == true»
	   		   			       									return numMutantsGenerated;
	   		   			       									«ELSE»
	   		   			       									return mutations;
	   		   			       									«ENDIF»
	   		   			       									«ELSE»
	   		   			       									continue;
	   		   			       									«ENDIF»
	   		   			}
	   		   			
	   		   			Object value =
	   		   			    srcObjExp.eGet(feature);
	   		   			
	   		   			if (!(value instanceof EObject)) {
	   		   			    «IF insideLoop == false»
	   		   			    	   		   			       									«IF exhaustive == true»
	   		   			    	   		   			       									return numMutantsGenerated;
	   		   			    	   		   			       									«ELSE»
	   		   			    	   		   			       									return mutations;
	   		   			    	   		   			       									«ENDIF»
	   		   			    	   		   			       									«ELSE»
	   		   			    	   		   			       									continue;
	   		   			    	   		   			       									«ENDIF»
	   		   			}
	   		   			
	   		   			EObject external =
	   		   			    (EObject) value;
	   		   			
	   		   			EObject external2Local =
	   		   			    MutatorUtils.recoverLocalObject(
	   		   			        model,
	   		   			        external);
	   		   			
	   		   			if (external2Local == null) {
	   		   			    external2Local =
	   		   			        ModelManager.getObject(
	   		   			            model,
	   		   			            external);
	   		   			}
	   		   			
	   		   			if (external2Local == null) {
«IF insideLoop == false»
	   		   			       									«IF exhaustive == true»
	   		   			       									return numMutantsGenerated;
	   		   			       									«ELSE»
	   		   			       									return mutations;
	   		   			       									«ENDIF»
	   		   			       									«ELSE»
	   		   			       									continue;
	   		   			       									«ENDIF»
	   		   			       									
	   		   			       				}
	   		   			 ((ReferenceEvaluation) exp«expressionList.get(indexExpression)».first).value = external2Local;      				
	   		   		
	   		   				      }
			«ENDIF»
	   		«IF refev.value.refType !== null»
	   		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«expressionList.get(indexExpression)» = hmObjects.get("«(refev.value as SpecificObjectSelection).objSel.name»");
	   		if (entry_«expressionList.get(indexExpression)» != null) {
	   		   				
	   		   				EObject srcObjExp =
	   		   				        entry_«expressionList.get(indexExpression)».getKey();
	   		   				
	   		   				EStructuralFeature feature =
	   		   				    srcObjExp.eClass()
	   		   				             .getEStructuralFeature("«refev.value.refType.name»");
	   		   				if (feature != null) {
		   						Object value =  srcObjExp.eGet(feature);
	   		                if (value instanceof EObject) {
	   		   				
	   		   				                EObject referenced =
	   		   				                    (EObject) value;
	   		   				
	   		   				                EObject localValue =
	   		   				                    MutatorUtils.recoverLocalObject(
	   		   				                        model,
	   		   				                        referenced);
	   		   				
	   		   				                if (localValue == null) {
	   		   				                    localValue =
	   		   				                        ModelManager.getObject(
	   		   				                            model,
	   		   				                            referenced);
	   		   				                }
	   		   				
	   		   				
	   		
	   		   				
	   		   				//EObject recovered = MutatorUtils.recoverLocalObject(model, entry_«expressionList.get(indexExpression)».getKey());
	   		                ((ReferenceEvaluation) exp«expressionList.get(indexExpression)».first).value =
	   		                    localValue != null
	   		                    ? localValue
	   		                    : referenced;
	   		   				
	   						//((ReferenceEvaluation) exp«expressionList.get(indexExpression)».first).value = new SpecificObjectSelection(packages, model, recovered).getObject();
	   		   				            }
	   		   				            if (value instanceof List<?>) {
	   		   				            	   		   				            	List<EObject> localValues =
	   		   				            	   		   				            	            new ArrayList<EObject>();
	   		   				            	   		   				            	
	   		   				            	   		   				            	        for (Object element :
	   		   				            	   		   				            	                (List<?>) value) {
	   		   				            	   		   				            	
	   		   				            	   		   				            	            if (!(element instanceof EObject)) {
	   		   				            	   		   				            	                continue;
	   		   				            	   		   				            	            }
	   		   				            	   		   				            	
	   		   				            	   		   				            	            EObject referenced =
	   		   				            	   		   				            	                (EObject) element;
	   		   				            	   		   				            	
	   		   				            	   		   				            	            EObject localValue =
	   		   				            	   		   				            	                MutatorUtils.recoverLocalObject(
	   		   				            	   		   				            	                    model,
	   		   				            	   		   				            	                    referenced);
	   		   				            	   		   				            	
	   		   				            	   		   				            	            if (localValue == null) {
	   		   				            	   		   				            	                localValue =
	   		   				            	   		   				            	                    ModelManager.getObject(
	   		   				            	   		   				            	                        model,
	   		   				            	   		   				            	                        referenced);
	   		   				            	   		   				            	            }
	   		   				            	   		   				            	
	   		   				            	   		   				            	            if (localValue != null) {
	   		   				            	   		   				            	                localValues.add(localValue);
	   		   				            	   		   				            	            }
	   		   				            	   		   				            	        }
	   		   				            	   		   				            	
	   		   				            	   		   				            	        ((ReferenceEvaluation) exp«expressionList.get(indexExpression)».first).value =
	   		   				            	   		   				            	            localValues;
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
			//INDEX EXPRESSION: «val int[] nestedIndexExpression = newIntArrayOfSize(1)»
			//INDEX EXPRESSION: «nestedIndexExpression.set(0, expressionList.size() - 1)»
			RandomTypeSelection expRts«expressionList.get(nestedIndexExpression.get(0))» = new RandomTypeSelection(packages, model, "«(refev.value as RandomTypeSelection).type.name»");
			List<EObject> expObjects«expressionList.get(nestedIndexExpression.get(0))» = expRts«expressionList.get(nestedIndexExpression.get(0))».getObjects();
			Expression exp«expressionList.get(nestedIndexExpression.get(0))» = new Expression();
	   		«refev.value.expression.method(mut, nReference, nestedIndexExpression, nExpression, recursionIndexExpression, exhaustive, resources, insideLoop, evaluation)»
			List<EObject> selectedObjects«expressionList.get(nestedIndexExpression.get(0))» = evaluate(expObjects«expressionList.get(nestedIndexExpression.get(0))», exp«expressionList.get(nestedIndexExpression.get(0))»);
			EObject object«expressionList.get(nestedIndexExpression.get(0))» = null;
			if (selectedObjects«expressionList.get(nestedIndexExpression.get(0))».size() > 0) {
				object«expressionList.get(nestedIndexExpression.get(0))» = selectedObjects«expressionList.get(nestedIndexExpression.get(0))».get(ModelManager.getRandomIndex(selectedObjects«expressionList.get(nestedIndexExpression.get(0))»));
			}
			((ReferenceEvaluation) exp«expressionList.get(indexExpression)».first).value = new SpecificObjectSelection(packages, model, object«expressionList.get(nestedIndexExpression.get(0))»).getObject();
		«ELSE»
		((ReferenceEvaluation) exp«expressionList.get(indexExpression)».first).value = new RandomTypeSelection(packages, model, "«(refev.value as RandomTypeSelection).type.name»").getObject();
		«ENDIF»
		«ELSE»
		«IF refev.value instanceof TypedSelection»
		«IF refev.value.expression instanceof Expression»
			//EXPRESSION LEVEL: «nExpression.set(0, nExpression.get(0) + 1)»
			//EXPRESSION LEVEL: «expressionList.add(nExpression.get(0))»
			//INDEX EXPRESSION: «val int[] nestedIndexExpression = newIntArrayOfSize(1)»
			//INDEX EXPRESSION: «nestedIndexExpression.set(0, expressionList.size() - 1)»
			TypedSelection expRts«expressionList.get(nestedIndexExpression.get(0))» = new TypedSelection(packages, model, "«(refev.value as TypedSelection).type.name»");
			List<EObject> expObjects«expressionList.get(nestedIndexExpression.get(0))» = expRts«expressionList.get(nestedIndexExpression.get(0))».getObjects();
			Expression exp«expressionList.get(nestedIndexExpression.get(0))» = new Expression();
			List<String> refNames«expressionList.get(nestedIndexExpression.get(0))» = new ArrayList<String>();
	   		«refev.value.expression.method(mut, nReference, nestedIndexExpression, nExpression, recursionIndexExpression, exhaustive, resources, insideLoop, evaluation)»
			List<EObject> selectedObjects«expressionList.get(nestedIndexExpression.get(0))» = evaluate(expObjects«expressionList.get(nestedIndexExpression.get(0))», exp«expressionList.get(nestedIndexExpression.get(0))»);
			refNames«expressionList.get(nestedIndexExpression.get(0))».add("«refev.name.name»");
			Collections.reverse(refNames«expressionList.get(nestedIndexExpression.get(0))»);
			selectedObjects«expressionList.get(nestedIndexExpression.get(0))» = ModelManager.getReferredObjects(refNames«expressionList.get(nestedIndexExpression.get(0))», objects, selectedObjects1);
			EObject object«expressionList.get(nestedIndexExpression.get(0))» = null;
			if (selectedObjects«expressionList.get(nestedIndexExpression.get(0))».size() > 0) {
				object«expressionList.get(nestedIndexExpression.get(0))» = selectedObjects«expressionList.get(nestedIndexExpression.get(0))».get(ModelManager.getRandomIndex(selectedObjects«expressionList.get(nestedIndexExpression.get(0))»));
			}
			((ReferenceEvaluation) exp«expressionList.get(indexExpression)».first).value = new SpecificObjectSelection(packages, model, object«expressionList.get(nestedIndexExpression.get(0))»).getObject();
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
			«IF exhaustive == false»
			«IF expressionPosition == 0»
			MinValueConfigurationStrategy min«evName»_«expressionList.get(indexExpression)» = new MinValueConfigurationStrategy(packages, model, "«MutatorUtils.getTypeName(ev.value as MinValueType)»", "«(ev.value as MinValueType).attribute.name»");
			«ELSE»
			«compileAuxiliarExpression(expressionPosition, expressionList)»
			MinValueConfigurationStrategy min«evName»_«expressionList.get(indexExpression)» = new MinValueConfigurationStrategy(packages, model, "«MutatorUtils.getTypeName(ev.value as MinValueType)»", sameValue, "«(ev.value as MinValueType).attribute.name»");
			«ENDIF»
			((AttributeEvaluation) ev«evName»_«expressionList.get(indexExpression)»).values.add(min«evName»_«expressionList.get(indexExpression)».getValue());
			«{evaluation.set(0, true); ""}»
			«ELSE»
			«IF expressionPosition == 0»
			MinValueConfigurationStrategy min«evName»_«expressionList.get(indexExpression)» = new MinValueConfigurationStrategy(packages, resources, "«MutatorUtils.getTypeName(ev.value as MinValueType)»", "«(ev.value as MinValueType).attribute.name»");
			«ELSE»
			«compileAuxiliarExpression(expressionPosition, expressionList)»
			MinValueConfigurationStrategy min«evName»_«expressionList.get(indexExpression)» = new MinValueConfigurationStrategy(resourcePackages, resources, "«MutatorUtils.getTypeName(ev.value as MinValueType)»", sameValue, "«(ev.value as MinValueType).attribute.name»");
			«ENDIF»
			((AttributeEvaluation) ev«evName»_«expressionList.get(indexExpression)»).values.add(min«evName»_«expressionList.get(indexExpression)».getValue());
			«{evaluation.set(0, true); ""}»
			«ENDIF»
   			«IF (ev.value as MinValueType).attribute.getEType.name.equals("EInt")»
			((AttributeEvaluation) ev«evName»_«expressionList.get(indexExpression)»).type = "int";
			«{evaluation.set(0, true); ""}»
   			«ENDIF»
   			«IF (ev.value as MinValueType).attribute.getEType.name.equals("EFloat")»
			((AttributeEvaluation) ev«evName»_«expressionList.get(indexExpression)»).type = "float";
			«{evaluation.set(0, true); ""}»
   			«ENDIF»
   			«IF (ev.value as MinValueType).attribute.getEType.name.equals("EDouble")»
			((AttributeEvaluation) ev«evName»_«expressionList.get(indexExpression)»).type = "double";
			«{evaluation.set(0, true); ""}»
   			«ENDIF»
			«ENDIF»
			«IF ev.value instanceof MaxValueType»
			«IF exhaustive == false»
			«IF expressionPosition == 0»
			MaxValueConfigurationStrategy max«evName»_«expressionList.get(indexExpression)» = new MaxValueConfigurationStrategy(packages, model, "«MutatorUtils.getTypeName(ev.value as MaxValueType)»", "«(ev.value as MaxValueType).attribute.name»");
			«ELSE»
			«compileAuxiliarExpression(expressionPosition, expressionList)»
			MaxValueConfigurationStrategy max«evName»_«expressionList.get(indexExpression)» = new MaxValueConfigurationStrategy(packages, model, "«MutatorUtils.getTypeName(ev.value as MaxValueType)»", sameValue, "«(ev.value as MaxValueType).attribute.name»");
			«ENDIF»
			((AttributeEvaluation) ev«evName»_«expressionList.get(indexExpression)»).values.add(max«evName»_«expressionList.get(indexExpression)».getValue());
			«{evaluation.set(0, true); ""}»
			«ELSE»
			«IF expressionPosition == 0»
			MaxValueConfigurationStrategy max«evName»_«expressionList.get(indexExpression)» = new MaxValueConfigurationStrategy(packages, resources, "«MutatorUtils.getTypeName(ev.value as MaxValueType)»", "«(ev.value as MaxValueType).attribute.name»");
			«ELSE»
			«compileAuxiliarExpression(expressionPosition, expressionList)»
			MaxValueConfigurationStrategy max«evName»_«expressionList.get(indexExpression)» = new MaxValueConfigurationStrategy(resourcePackages, resources, "«MutatorUtils.getTypeName(ev.value as MaxValueType)»", sameValue, "«(ev.value as MaxValueType).attribute.name»");
			«ENDIF»
			((AttributeEvaluation) ev«evName»_«expressionList.get(indexExpression)»).values.add(max«evName»_«expressionList.get(indexExpression)».getValue());
			«{evaluation.set(0, true); ""}»
			«ENDIF»
   			«IF (ev.value as MaxValueType).attribute.getEType.name.equals("EInt")»
			((AttributeEvaluation) ev«evName»_«expressionList.get(indexExpression)»).type = "int";
			«{evaluation.set(0, true); ""}»
   			«ENDIF»
   			«IF (ev.value as MaxValueType).attribute.getEType.name.equals("EInt")»
			((AttributeEvaluation) ev«evName»_«expressionList.get(indexExpression)»).type = "float";
			«{evaluation.set(0, true); ""}»
   			«ENDIF»
   			«IF (ev.value as MaxValueType).attribute.getEType.name.equals("EDouble")»
			((AttributeEvaluation) ev«evName»_«expressionList.get(indexExpression)»).type = "double";
			«{evaluation.set(0, true); ""}»
   			«ENDIF»
			«ENDIF»
   			«ENDIF»
   			«ENDIF»
   			«IF ev instanceof ReferenceEvaluation»
   			ReferenceEvaluation ev«evName»_«expressionList.get(indexExpression)» = new ReferenceEvaluation();
	   		«IF ev.name !== null»
   			   	ev«evName»_«expressionList.get(indexExpression)».name = "«ev.name.name»";
				«IF ev.value instanceof TypedSelection && recursionIndexExpression.get(0) != 0»
				refNames«expressionList.get(recursionIndexExpression.get(0))».add("«ev.name.name»");
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
   				ev«evName»_«expressionList.get(indexExpression)».value = ModelManager.getStringAttribute("«(ev.attValue as ObjectAttributeType).attribute.name»", (hmObjects.get("«(ev.attValue as ObjectAttributeType).objSel.name»") != null ? hmObjects.get("«(ev.attValue as ObjectAttributeType).objSel.name»").getKey() : null));
   				«ENDIF»
   				«IF ev.attValue instanceof AttributeType»
	   			«IF ev.attValue instanceof StringType || ev.attValue instanceof DoubleType || ev.attValue instanceof BooleanType || ev.attValue instanceof IntegerType»
   					ev«evName»_«expressionList.get(indexExpression)».value = "«(ev.attValue as SpecificStringType).value»";
				«ENDIF»
				«IF ev.attValue instanceof MinValueType»
					MinValueConfigurationStrategy min_ev«evName»_«expressionList.get(indexExpression)» = new MinValueConfigurationStrategy(packages, model, "«MutatorUtils.getTypeName(ev.attValue as MinValueType)»", "«(ev.attValue as MinValueType).attribute.name»");
					ev«evName»_«expressionList.get(indexExpression)».value = min_ev«evName»_«expressionList.get(indexExpression)».getValue().toString();
				«ENDIF»
				«IF ev.attValue instanceof MaxValueType»
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
						EObject srcObjExp =
							   		   				        entry«evName»_«expressionList.get(indexExpression)».getKey();
							   		   				
							   		   				EStructuralFeature feature =
							   		   				    srcObjExp.eClass()
							   		   				               .getEStructuralFeature(
							   		   				                   "«ev.refType.name»");
							   		   				                   
							   		   				                   
							   		   			if (!(feature instanceof EReference)) {
							   		   			    «IF insideLoop == false»
							   		   			       									«IF exhaustive == true»
							   		   			       									return numMutantsGenerated;
							   		   			       									«ELSE»
							   		   			       									return mutations;
							   		   			       									«ENDIF»
							   		   			       									«ELSE»
							   		   			       									continue;
							   		   			       									«ENDIF»
							   		   			}
							   		   			
							   		   			Object value =
							   		   			    srcObjExp.eGet(feature);
							   		   			
							   		   			if (!(value instanceof EObject)) {
							   		   			    «IF insideLoop == false»
							   		   			    	   		   			       									«IF exhaustive == true»
							   		   			    	   		   			       									return numMutantsGenerated;
							   		   			    	   		   			       									«ELSE»
							   		   			    	   		   			       									return mutations;
							   		   			    	   		   			       									«ENDIF»
							   		   			    	   		   			       									«ELSE»
							   		   			    	   		   			       									continue;
							   		   			    	   		   			       									«ENDIF»
							   		   			}
							   		   			
							   		   			EObject external =
							   		   			    (EObject) value;
							   		   			
							   		   			EObject external2Local =
							   		   			    MutatorUtils.recoverLocalObject(
							   		   			        model,
							   		   			        external);
							   		   			
							   		   			if (external2Local == null) {
							   		   			    external2Local =
							   		   			        ModelManager.getObject(
							   		   			            model,
							   		   			            external);
							   		   			}
							   		   			
							   		   			if (external2Local == null) {
						«IF insideLoop == false»
							   		   			       									«IF exhaustive == true»
							   		   			       									return numMutantsGenerated;
							   		   			       									«ELSE»
							   		   			       									return mutations;
							   		   			       									«ENDIF»
							   		   			       									«ELSE»
							   		   			       									continue;
							   		   			       									«ENDIF»
							   		   			       									
							   		   			       				}
							   		   			 ev«evName»_«expressionList.get(indexExpression)».value = external2Local;
//	   					EObject srcObjExp«evName»_«expressionList.get(indexExpression)» = entry«evName»_«expressionList.get(indexExpression)».getKey();
//   						for (EReference ref : srcObjExp«evName»_«expressionList.get(indexExpression)».eClass().getEAllReferences()) {
//   							if (ref.getName().equals("«ev.refType.name»")) {
//   								ev«evName»_«expressionList.get(indexExpression)».value = srcObjExp«evName»_«expressionList.get(indexExpression)».eGet(ref);		
//   							}
//	   					}
	   				}
	   			«ENDIF»
	   			«IF ev.value.refType !== null»
					SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry«evName»_«expressionList.get(indexExpression)» = hmObjects.get("«(ev.value as SpecificObjectSelection).objSel.name»");
					if (entry«evName»_«expressionList.get(indexExpression)» != null) {
						EObject srcObjExp =
							   		   				        entry«evName»_«expressionList.get(indexExpression)».getKey();
							   		   				
							   		   				EStructuralFeature feature =
							   		   				    srcObjExp.eClass()
							   		   				               .getEStructuralFeature(
							   		   				                   "«ev.value.refType.name»");
							   		   				                   
							   		   				                   
							   		   			if (!(feature instanceof EReference)) {
							   		   			    «IF insideLoop == false»
							   		   			       									«IF exhaustive == true»
							   		   			       									return numMutantsGenerated;
							   		   			       									«ELSE»
							   		   			       									return mutations;
							   		   			       									«ENDIF»
							   		   			       									«ELSE»
							   		   			       									continue;
							   		   			       									«ENDIF»
							   		   			}
							   		   			
							   		   			Object value =
							   		   			    srcObjExp.eGet(feature);
							   		   			
							   		   			if (!(value instanceof EObject)) {
							   		   			    «IF insideLoop == false»
							   		   			    	   		   			       									«IF exhaustive == true»
							   		   			    	   		   			       									return numMutantsGenerated;
							   		   			    	   		   			       									«ELSE»
							   		   			    	   		   			       									return mutations;
							   		   			    	   		   			       									«ENDIF»
							   		   			    	   		   			       									«ELSE»
							   		   			    	   		   			       									continue;
							   		   			    	   		   			       									«ENDIF»
							   		   			}
							   		   			
							   		   			EObject external =
							   		   			    (EObject) value;
							   		   			
							   		   			EObject external2Local =
							   		   			    MutatorUtils.recoverLocalObject(
							   		   			        model,
							   		   			        external);
							   		   			
							   		   			if (external2Local == null) {
							   		   			    external2Local =
							   		   			        ModelManager.getObject(
							   		   			            model,
							   		   			            external);
							   		   			}
							   		   			
							   		   			if (external2Local == null) {
						«IF insideLoop == false»
							   		   			       									«IF exhaustive == true»
							   		   			       									return numMutantsGenerated;
							   		   			       									«ELSE»
							   		   			       									return mutations;
							   		   			       									«ENDIF»
							   		   			       									«ELSE»
							   		   			       									continue;
							   		   			       									«ENDIF»
							   		   			       									
							   		   			       				}
							   		   			 ev«evName»_«expressionList.get(indexExpression)».value = external2Local;
//		   				EObject srcObjExp«evName»_«expressionList.get(indexExpression)» = entry«evName»_«expressionList.get(indexExpression)».getKey();
//		   				for (EReference ref : srcObjExp«evName»_«expressionList.get(indexExpression)».eClass().getEAllReferences()) {
//	   						if (ref.getName().equals("«ev.value.refType.name»")) {
//	   							ev«evName»_«expressionList.get(indexExpression)».value = srcObjExp«evName»_«expressionList.get(indexExpression)».eGet(ref);		
//	   						}
//	   					}
	   				}
	   			«ENDIF»
	   			«ENDIF»
			«ELSE»
			«IF ev.value instanceof RandomTypeSelection»
			«IF ev.value.expression instanceof Expression»
				//EXPRESSION LEVEL: «nExpression.set(0, nExpression.get(0) + 1)»
				//EXPRESSION LEVEL: «expressionList.add(nExpression.get(0))»
				//INDEX EXPRESSION: «val int[] nestedIndexExpression = newIntArrayOfSize(1)»
				//INDEX EXPRESSION: «nestedIndexExpression.set(0, expressionList.size() - 1)»
				RandomTypeSelection expRts«expressionList.get(nestedIndexExpression.get(0))» = new RandomTypeSelection(packages, model, "«(ev.value as RandomTypeSelection).type.name»");
				List<EObject> expObjects«expressionList.get(nestedIndexExpression.get(0))» = expRts«expressionList.get(nestedIndexExpression.get(0))».getObjects();
				Expression exp«expressionList.get(nestedIndexExpression.get(0))» = new Expression();
				«ev.value.expression.method(mut, nReference, nestedIndexExpression, nExpression, recursionIndexExpression, exhaustive, resources, insideLoop, evaluation)»
				List<EObject> selectedObjects«evName»_«expressionList.get(nestedIndexExpression.get(0))» = evaluate(expObjects«expressionList.get(nestedIndexExpression.get(0))», exp«expressionList.get(nestedIndexExpression.get(0))»);
				EObject object«evName»_«expressionList.get(nestedIndexExpression.get(0))» = null;
				if (selectedObjects«evName»_«expressionList.get(nestedIndexExpression.get(0))».size() > 0) {
					object«evName»_«expressionList.get(nestedIndexExpression.get(0))» = selectedObjects«evName»_«expressionList.get(nestedIndexExpression.get(0))».get(ModelManager.getRandomIndex(selectedObjects«evName»_«expressionList.get(nestedIndexExpression.get(0))»));
				}
				ev«evName»_«expressionList.get(indexExpression)».value = new SpecificObjectSelection(packages, model, object«evName»_«expressionList.get(nestedIndexExpression.get(0))»).getObject();
			«ELSE»
			ev«evName»_«expressionList.get(indexExpression)».value = new RandomTypeSelection(packages, model, "«(ev.value as RandomTypeSelection).type.name»").getObject();
			«ENDIF»
			«ELSE»
			«IF ev.value instanceof TypedSelection»
			«IF ev.value.expression instanceof Expression»
				//EXPRESSION LEVEL: «nExpression.set(0, nExpression.get(0) + 1)»
				//EXPRESSION LEVEL: «expressionList.add(nExpression.get(0))»
				//INDEX EXPRESSION: «val int[] nestedIndexExpression = newIntArrayOfSize(1)»
				//INDEX EXPRESSION: «nestedIndexExpression.set(0, expressionList.size() - 1)»
				TypedSelection expRts«expressionList.get(nestedIndexExpression.get(0))» = new TypedSelection(packages, model, "«(ev.value as TypedSelection).type.name»");
				List<EObject> expObjects«expressionList.get(nestedIndexExpression.get(0))» = expRts«expressionList.get(nestedIndexExpression.get(0))».getObjects();
				Expression exp«expressionList.get(nestedIndexExpression.get(0))» = new Expression();
				List<String> refNames«expressionList.get(nestedIndexExpression.get(0))» = new ArrayList<String>();
				«ev.value.expression.method(mut, nReference, nestedIndexExpression, nExpression, recursionIndexExpression, exhaustive, resources, insideLoop, evaluation)»
				List<EObject> selectedObjects«evName»_«expressionList.get(nestedIndexExpression.get(0))» = evaluate(expObjects«expressionList.get(nestedIndexExpression.get(0))», exp«expressionList.get(nestedIndexExpression.get(0))»);
				refNames«expressionList.get(nestedIndexExpression.get(0))».add("«ev.name.name»");
				Collections.reverse(refNames«expressionList.get(nestedIndexExpression.get(0))»);
				selectedObjects«evName»_«expressionList.get(nestedIndexExpression.get(0))» = ModelManager.getReferredObjects(refNames«expressionList.get(nestedIndexExpression.get(0))», objects, selectedObjects1);
				EObject object«evName»_«expressionList.get(nestedIndexExpression.get(0))» = null;
				if (selectedObjects«evName»_«expressionList.get(nestedIndexExpression.get(0))».size() > 0) {
					object«evName»_«expressionList.get(nestedIndexExpression.get(0))» = selectedObjects«evName»_«expressionList.get(nestedIndexExpression.get(0))».get(ModelManager.getRandomIndex(selectedObjects«evName»_«expressionList.get(nestedIndexExpression.get(0))»));
				}
				ev«evName»_«expressionList.get(indexExpression)».value = new SpecificObjectSelection(packages, model, object«evName»_«expressionList.get(nestedIndexExpression.get(0))»).getObject();
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
   		«IF evaluation.get(0)»
			List<EObject> auxObjects = evaluate(objects, exp«expressionList.get(indexExpression)»);
		«ENDIF»
   '''
   //END CLAUSES

   //*********
   // EACH CLAUSES
   def each(Expression exp, List<Integer> expressionList) '''
  		//INDEX EXPRESSION: «val int indexExpression = expressionList.size() - 1»
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
   
   def addResources(Expression exp, Mutator mut) '''
            «IF mut instanceof SelectObjectMutator»
            «IF exp.first instanceof ReferenceEvaluation»
            //«var ReferenceEvaluation refev = exp.first as ReferenceEvaluation»
            «IF refev.value instanceof SpecificObjectSelection»
            //«var SpecificObjectSelection sel = refev.value as SpecificObjectSelection»
            //«var Mutator selMut = MutatorUtils.getMutator(sel)»
            «IF selMut instanceof SelectObjectMutator»
            //«var SelectObjectMutator selMutator = selMut as SelectObjectMutator»
            «IF selMutator.object.resource !== null || selMutator.container?.resource !== null»
   		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«sel.objSel.name» = hmObjects.get("«sel.objSel.name»");
   		if (entry_«sel.objSel.name» == null) {
   			return numMutantsGenerated;
   		}
   		selectionPackages = entry_«sel.objSel.name».getValue().getValue();
   		selection.add(entry_«sel.objSel.name».getValue().getKey());
   		«ENDIF»
   		«ENDIF»
   		«FOR Evaluation ev : exp.second»
   			«IF ev instanceof ReferenceEvaluation»
            //«sel = ev.value as SpecificObjectSelection»
            «IF MutatorUtils.selectionOriginatesFromAdditionalResources(MutatorUtils.getMutator(sel))»
            //«selMut = MutatorUtils.getMutator(sel)»
            «IF selMut instanceof SelectObjectMutator»
            //«var SelectObjectMutator selMutator = selMut as SelectObjectMutator»
            «IF selMutator.object.resource !== null || selMutator.container?.resource !== null»
   		SimpleEntry<EObject, SimpleEntry<Resource, List<EPackage>>> entry_«sel.objSel.name» = hmObjects.get("«sel.objSel.name»");
   		if (entry_«sel.objSel.name» == null) {
   			return numMutantsGenerated;
   		}
   		selectionPackages = entry_«sel.objSel.name».getValue().getValue();
   		selection.add(entry_«sel.objSel.name».getValue().getKey());
   		«ENDIF»
«ENDIF»
«ENDIF»
«ENDIF»
   		«ENDFOR»
            
            «ENDIF»
            «ENDIF»
            «ENDIF»
   '''
   //END CLAUSES
   //COMMANDS
   
   
	
}