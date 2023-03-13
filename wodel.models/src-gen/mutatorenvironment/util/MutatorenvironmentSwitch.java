/**
 */
package mutatorenvironment.util;

import mutatorenvironment.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see mutatorenvironment.MutatorenvironmentPackage
 * @generated
 */
public class MutatorenvironmentSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static MutatorenvironmentPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MutatorenvironmentSwitch() {
		if (modelPackage == null) {
			modelPackage = MutatorenvironmentPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
		case MutatorenvironmentPackage.MUTATOR_ENVIRONMENT: {
			MutatorEnvironment mutatorEnvironment = (MutatorEnvironment) theEObject;
			T result = caseMutatorEnvironment(mutatorEnvironment);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MutatorenvironmentPackage.DEFINITION: {
			Definition definition = (Definition) theEObject;
			T result = caseDefinition(definition);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MutatorenvironmentPackage.LIBRARY: {
			Library library = (Library) theEObject;
			T result = caseLibrary(library);
			if (result == null)
				result = caseDefinition(library);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MutatorenvironmentPackage.PROGRAM: {
			Program program = (Program) theEObject;
			T result = caseProgram(program);
			if (result == null)
				result = caseDefinition(program);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MutatorenvironmentPackage.OBJECT_EMITTER: {
			ObjectEmitter objectEmitter = (ObjectEmitter) theEObject;
			T result = caseObjectEmitter(objectEmitter);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MutatorenvironmentPackage.MUTATOR: {
			Mutator mutator = (Mutator) theEObject;
			T result = caseMutator(mutator);
			if (result == null)
				result = caseObjectEmitter(mutator);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MutatorenvironmentPackage.COMPOSITE_MUTATOR: {
			CompositeMutator compositeMutator = (CompositeMutator) theEObject;
			T result = caseCompositeMutator(compositeMutator);
			if (result == null)
				result = caseMutator(compositeMutator);
			if (result == null)
				result = caseObjectEmitter(compositeMutator);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MutatorenvironmentPackage.LOAD: {
			Load load = (Load) theEObject;
			T result = caseLoad(load);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MutatorenvironmentPackage.CREATE_OBJECT_MUTATOR: {
			CreateObjectMutator createObjectMutator = (CreateObjectMutator) theEObject;
			T result = caseCreateObjectMutator(createObjectMutator);
			if (result == null)
				result = caseMutator(createObjectMutator);
			if (result == null)
				result = caseObjectEmitter(createObjectMutator);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MutatorenvironmentPackage.OB_SELECTION_STRATEGY: {
			ObSelectionStrategy obSelectionStrategy = (ObSelectionStrategy) theEObject;
			T result = caseObSelectionStrategy(obSelectionStrategy);
			if (result == null)
				result = caseObjectEmitter(obSelectionStrategy);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MutatorenvironmentPackage.RANDOM_SELECTION: {
			RandomSelection randomSelection = (RandomSelection) theEObject;
			T result = caseRandomSelection(randomSelection);
			if (result == null)
				result = caseObSelectionStrategy(randomSelection);
			if (result == null)
				result = caseObjectEmitter(randomSelection);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MutatorenvironmentPackage.RANDOM_TYPE_SELECTION: {
			RandomTypeSelection randomTypeSelection = (RandomTypeSelection) theEObject;
			T result = caseRandomTypeSelection(randomTypeSelection);
			if (result == null)
				result = caseRandomSelection(randomTypeSelection);
			if (result == null)
				result = caseObSelectionStrategy(randomTypeSelection);
			if (result == null)
				result = caseObjectEmitter(randomTypeSelection);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MutatorenvironmentPackage.SPECIFIC_OBJECT_SELECTION: {
			SpecificObjectSelection specificObjectSelection = (SpecificObjectSelection) theEObject;
			T result = caseSpecificObjectSelection(specificObjectSelection);
			if (result == null)
				result = caseSpecificSelection(specificObjectSelection);
			if (result == null)
				result = caseObSelectionStrategy(specificObjectSelection);
			if (result == null)
				result = caseObjectEmitter(specificObjectSelection);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MutatorenvironmentPackage.ATTRIBUTE_SCALAR: {
			AttributeScalar attributeScalar = (AttributeScalar) theEObject;
			T result = caseAttributeScalar(attributeScalar);
			if (result == null)
				result = caseAttributeSet(attributeScalar);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MutatorenvironmentPackage.ATTRIBUTE_TYPE: {
			AttributeType attributeType = (AttributeType) theEObject;
			T result = caseAttributeType(attributeType);
			if (result == null)
				result = caseAttributeEvaluationType(attributeType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MutatorenvironmentPackage.BOOLEAN_TYPE: {
			BooleanType booleanType = (BooleanType) theEObject;
			T result = caseBooleanType(booleanType);
			if (result == null)
				result = caseAttributeType(booleanType);
			if (result == null)
				result = caseAttributeEvaluationType(booleanType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MutatorenvironmentPackage.SPECIFIC_BOOLEAN_TYPE: {
			SpecificBooleanType specificBooleanType = (SpecificBooleanType) theEObject;
			T result = caseSpecificBooleanType(specificBooleanType);
			if (result == null)
				result = caseBooleanType(specificBooleanType);
			if (result == null)
				result = caseAttributeType(specificBooleanType);
			if (result == null)
				result = caseAttributeEvaluationType(specificBooleanType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MutatorenvironmentPackage.RANDOM_BOOLEAN_TYPE: {
			RandomBooleanType randomBooleanType = (RandomBooleanType) theEObject;
			T result = caseRandomBooleanType(randomBooleanType);
			if (result == null)
				result = caseBooleanType(randomBooleanType);
			if (result == null)
				result = caseAttributeType(randomBooleanType);
			if (result == null)
				result = caseAttributeEvaluationType(randomBooleanType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MutatorenvironmentPackage.STRING_TYPE: {
			StringType stringType = (StringType) theEObject;
			T result = caseStringType(stringType);
			if (result == null)
				result = caseAttributeType(stringType);
			if (result == null)
				result = caseAttributeEvaluationType(stringType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MutatorenvironmentPackage.SPECIFIC_STRING_TYPE: {
			SpecificStringType specificStringType = (SpecificStringType) theEObject;
			T result = caseSpecificStringType(specificStringType);
			if (result == null)
				result = caseStringType(specificStringType);
			if (result == null)
				result = caseAttributeType(specificStringType);
			if (result == null)
				result = caseAttributeEvaluationType(specificStringType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MutatorenvironmentPackage.RANDOM_STRING_TYPE: {
			RandomStringType randomStringType = (RandomStringType) theEObject;
			T result = caseRandomStringType(randomStringType);
			if (result == null)
				result = caseStringType(randomStringType);
			if (result == null)
				result = caseAttributeType(randomStringType);
			if (result == null)
				result = caseAttributeEvaluationType(randomStringType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MutatorenvironmentPackage.INTEGER_TYPE: {
			IntegerType integerType = (IntegerType) theEObject;
			T result = caseIntegerType(integerType);
			if (result == null)
				result = caseNumberType(integerType);
			if (result == null)
				result = caseAttributeType(integerType);
			if (result == null)
				result = caseAttributeEvaluationType(integerType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MutatorenvironmentPackage.SPECIFIC_INTEGER_TYPE: {
			SpecificIntegerType specificIntegerType = (SpecificIntegerType) theEObject;
			T result = caseSpecificIntegerType(specificIntegerType);
			if (result == null)
				result = caseIntegerType(specificIntegerType);
			if (result == null)
				result = caseNumberType(specificIntegerType);
			if (result == null)
				result = caseAttributeType(specificIntegerType);
			if (result == null)
				result = caseAttributeEvaluationType(specificIntegerType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MutatorenvironmentPackage.RANDOM_INTEGER_TYPE: {
			RandomIntegerType randomIntegerType = (RandomIntegerType) theEObject;
			T result = caseRandomIntegerType(randomIntegerType);
			if (result == null)
				result = caseIntegerType(randomIntegerType);
			if (result == null)
				result = caseNumberType(randomIntegerType);
			if (result == null)
				result = caseAttributeType(randomIntegerType);
			if (result == null)
				result = caseAttributeEvaluationType(randomIntegerType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MutatorenvironmentPackage.DOUBLE_TYPE: {
			DoubleType doubleType = (DoubleType) theEObject;
			T result = caseDoubleType(doubleType);
			if (result == null)
				result = caseNumberType(doubleType);
			if (result == null)
				result = caseAttributeType(doubleType);
			if (result == null)
				result = caseAttributeEvaluationType(doubleType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MutatorenvironmentPackage.SPECIFIC_DOUBLE_TYPE: {
			SpecificDoubleType specificDoubleType = (SpecificDoubleType) theEObject;
			T result = caseSpecificDoubleType(specificDoubleType);
			if (result == null)
				result = caseDoubleType(specificDoubleType);
			if (result == null)
				result = caseNumberType(specificDoubleType);
			if (result == null)
				result = caseAttributeType(specificDoubleType);
			if (result == null)
				result = caseAttributeEvaluationType(specificDoubleType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MutatorenvironmentPackage.RANDOM_DOUBLE_TYPE: {
			RandomDoubleType randomDoubleType = (RandomDoubleType) theEObject;
			T result = caseRandomDoubleType(randomDoubleType);
			if (result == null)
				result = caseDoubleType(randomDoubleType);
			if (result == null)
				result = caseNumberType(randomDoubleType);
			if (result == null)
				result = caseAttributeType(randomDoubleType);
			if (result == null)
				result = caseAttributeEvaluationType(randomDoubleType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MutatorenvironmentPackage.MODIFY_SOURCE_REFERENCE_MUTATOR: {
			ModifySourceReferenceMutator modifySourceReferenceMutator = (ModifySourceReferenceMutator) theEObject;
			T result = caseModifySourceReferenceMutator(modifySourceReferenceMutator);
			if (result == null)
				result = caseMutator(modifySourceReferenceMutator);
			if (result == null)
				result = caseObjectEmitter(modifySourceReferenceMutator);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MutatorenvironmentPackage.SPECIFIC_SELECTION: {
			SpecificSelection specificSelection = (SpecificSelection) theEObject;
			T result = caseSpecificSelection(specificSelection);
			if (result == null)
				result = caseObSelectionStrategy(specificSelection);
			if (result == null)
				result = caseObjectEmitter(specificSelection);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MutatorenvironmentPackage.SPECIFIC_REFERENCE_SELECTION: {
			SpecificReferenceSelection specificReferenceSelection = (SpecificReferenceSelection) theEObject;
			T result = caseSpecificReferenceSelection(specificReferenceSelection);
			if (result == null)
				result = caseSpecificSelection(specificReferenceSelection);
			if (result == null)
				result = caseObSelectionStrategy(specificReferenceSelection);
			if (result == null)
				result = caseObjectEmitter(specificReferenceSelection);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MutatorenvironmentPackage.MODIFY_TARGET_REFERENCE_MUTATOR: {
			ModifyTargetReferenceMutator modifyTargetReferenceMutator = (ModifyTargetReferenceMutator) theEObject;
			T result = caseModifyTargetReferenceMutator(modifyTargetReferenceMutator);
			if (result == null)
				result = caseMutator(modifyTargetReferenceMutator);
			if (result == null)
				result = caseObjectEmitter(modifyTargetReferenceMutator);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MutatorenvironmentPackage.CREATE_REFERENCE_MUTATOR: {
			CreateReferenceMutator createReferenceMutator = (CreateReferenceMutator) theEObject;
			T result = caseCreateReferenceMutator(createReferenceMutator);
			if (result == null)
				result = caseMutator(createReferenceMutator);
			if (result == null)
				result = caseObjectEmitter(createReferenceMutator);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MutatorenvironmentPackage.REMOVE_OBJECT_MUTATOR: {
			RemoveObjectMutator removeObjectMutator = (RemoveObjectMutator) theEObject;
			T result = caseRemoveObjectMutator(removeObjectMutator);
			if (result == null)
				result = caseMutator(removeObjectMutator);
			if (result == null)
				result = caseObjectEmitter(removeObjectMutator);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MutatorenvironmentPackage.REMOVE_REFERENCE_MUTATOR: {
			RemoveReferenceMutator removeReferenceMutator = (RemoveReferenceMutator) theEObject;
			T result = caseRemoveReferenceMutator(removeReferenceMutator);
			if (result == null)
				result = caseMutator(removeReferenceMutator);
			if (result == null)
				result = caseObjectEmitter(removeReferenceMutator);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MutatorenvironmentPackage.MODIFY_INFORMATION_MUTATOR: {
			ModifyInformationMutator modifyInformationMutator = (ModifyInformationMutator) theEObject;
			T result = caseModifyInformationMutator(modifyInformationMutator);
			if (result == null)
				result = caseMutator(modifyInformationMutator);
			if (result == null)
				result = caseObjectEmitter(modifyInformationMutator);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MutatorenvironmentPackage.UPPER_STRING_TYPE: {
			UpperStringType upperStringType = (UpperStringType) theEObject;
			T result = caseUpperStringType(upperStringType);
			if (result == null)
				result = caseStringType(upperStringType);
			if (result == null)
				result = caseAttributeType(upperStringType);
			if (result == null)
				result = caseAttributeEvaluationType(upperStringType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MutatorenvironmentPackage.LOWER_STRING_TYPE: {
			LowerStringType lowerStringType = (LowerStringType) theEObject;
			T result = caseLowerStringType(lowerStringType);
			if (result == null)
				result = caseStringType(lowerStringType);
			if (result == null)
				result = caseAttributeType(lowerStringType);
			if (result == null)
				result = caseAttributeEvaluationType(lowerStringType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MutatorenvironmentPackage.LIST_STRING_TYPE: {
			ListStringType listStringType = (ListStringType) theEObject;
			T result = caseListStringType(listStringType);
			if (result == null)
				result = caseAttributeType(listStringType);
			if (result == null)
				result = caseAttributeEvaluationType(listStringType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MutatorenvironmentPackage.CAT_START_STRING_TYPE: {
			CatStartStringType catStartStringType = (CatStartStringType) theEObject;
			T result = caseCatStartStringType(catStartStringType);
			if (result == null)
				result = caseStringType(catStartStringType);
			if (result == null)
				result = caseAttributeType(catStartStringType);
			if (result == null)
				result = caseAttributeEvaluationType(catStartStringType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MutatorenvironmentPackage.CAT_END_STRING_TYPE: {
			CatEndStringType catEndStringType = (CatEndStringType) theEObject;
			T result = caseCatEndStringType(catEndStringType);
			if (result == null)
				result = caseStringType(catEndStringType);
			if (result == null)
				result = caseAttributeType(catEndStringType);
			if (result == null)
				result = caseAttributeEvaluationType(catEndStringType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MutatorenvironmentPackage.ATTRIBUTE_UNSET: {
			AttributeUnset attributeUnset = (AttributeUnset) theEObject;
			T result = caseAttributeUnset(attributeUnset);
			if (result == null)
				result = caseAttributeSet(attributeUnset);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MutatorenvironmentPackage.ATTRIBUTE_SET: {
			AttributeSet attributeSet = (AttributeSet) theEObject;
			T result = caseAttributeSet(attributeSet);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MutatorenvironmentPackage.ATTRIBUTE_SWAP: {
			AttributeSwap attributeSwap = (AttributeSwap) theEObject;
			T result = caseAttributeSwap(attributeSwap);
			if (result == null)
				result = caseAttributeSet(attributeSwap);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MutatorenvironmentPackage.REPLACE_STRING_TYPE: {
			ReplaceStringType replaceStringType = (ReplaceStringType) theEObject;
			T result = caseReplaceStringType(replaceStringType);
			if (result == null)
				result = caseStringType(replaceStringType);
			if (result == null)
				result = caseAttributeType(replaceStringType);
			if (result == null)
				result = caseAttributeEvaluationType(replaceStringType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MutatorenvironmentPackage.ATTRIBUTE_COPY: {
			AttributeCopy attributeCopy = (AttributeCopy) theEObject;
			T result = caseAttributeCopy(attributeCopy);
			if (result == null)
				result = caseAttributeSet(attributeCopy);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MutatorenvironmentPackage.REMOVE_RANDOM_REFERENCE_MUTATOR: {
			RemoveRandomReferenceMutator removeRandomReferenceMutator = (RemoveRandomReferenceMutator) theEObject;
			T result = caseRemoveRandomReferenceMutator(removeRandomReferenceMutator);
			if (result == null)
				result = caseRemoveReferenceMutator(removeRandomReferenceMutator);
			if (result == null)
				result = caseMutator(removeRandomReferenceMutator);
			if (result == null)
				result = caseObjectEmitter(removeRandomReferenceMutator);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MutatorenvironmentPackage.REMOVE_SPECIFIC_REFERENCE_MUTATOR: {
			RemoveSpecificReferenceMutator removeSpecificReferenceMutator = (RemoveSpecificReferenceMutator) theEObject;
			T result = caseRemoveSpecificReferenceMutator(removeSpecificReferenceMutator);
			if (result == null)
				result = caseRemoveReferenceMutator(removeSpecificReferenceMutator);
			if (result == null)
				result = caseMutator(removeSpecificReferenceMutator);
			if (result == null)
				result = caseObjectEmitter(removeSpecificReferenceMutator);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MutatorenvironmentPackage.COMPLETE_SELECTION: {
			CompleteSelection completeSelection = (CompleteSelection) theEObject;
			T result = caseCompleteSelection(completeSelection);
			if (result == null)
				result = caseObSelectionStrategy(completeSelection);
			if (result == null)
				result = caseObjectEmitter(completeSelection);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MutatorenvironmentPackage.COMPLETE_TYPE_SELECTION: {
			CompleteTypeSelection completeTypeSelection = (CompleteTypeSelection) theEObject;
			T result = caseCompleteTypeSelection(completeTypeSelection);
			if (result == null)
				result = caseCompleteSelection(completeTypeSelection);
			if (result == null)
				result = caseObSelectionStrategy(completeTypeSelection);
			if (result == null)
				result = caseObjectEmitter(completeTypeSelection);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MutatorenvironmentPackage.REMOVE_COMPLETE_REFERENCE_MUTATOR: {
			RemoveCompleteReferenceMutator removeCompleteReferenceMutator = (RemoveCompleteReferenceMutator) theEObject;
			T result = caseRemoveCompleteReferenceMutator(removeCompleteReferenceMutator);
			if (result == null)
				result = caseRemoveReferenceMutator(removeCompleteReferenceMutator);
			if (result == null)
				result = caseMutator(removeCompleteReferenceMutator);
			if (result == null)
				result = caseObjectEmitter(removeCompleteReferenceMutator);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MutatorenvironmentPackage.SOURCE: {
			Source source = (Source) theEObject;
			T result = caseSource(source);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MutatorenvironmentPackage.OTHER_SELECTION: {
			OtherSelection otherSelection = (OtherSelection) theEObject;
			T result = caseOtherSelection(otherSelection);
			if (result == null)
				result = caseObSelectionStrategy(otherSelection);
			if (result == null)
				result = caseObjectEmitter(otherSelection);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MutatorenvironmentPackage.OTHER_TYPE_SELECTION: {
			OtherTypeSelection otherTypeSelection = (OtherTypeSelection) theEObject;
			T result = caseOtherTypeSelection(otherTypeSelection);
			if (result == null)
				result = caseOtherSelection(otherTypeSelection);
			if (result == null)
				result = caseObSelectionStrategy(otherTypeSelection);
			if (result == null)
				result = caseObjectEmitter(otherTypeSelection);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MutatorenvironmentPackage.SELECT_OBJECT_MUTATOR: {
			SelectObjectMutator selectObjectMutator = (SelectObjectMutator) theEObject;
			T result = caseSelectObjectMutator(selectObjectMutator);
			if (result == null)
				result = caseMutator(selectObjectMutator);
			if (result == null)
				result = caseObjectEmitter(selectObjectMutator);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MutatorenvironmentPackage.ATTRIBUTE_EVALUATION: {
			AttributeEvaluation attributeEvaluation = (AttributeEvaluation) theEObject;
			T result = caseAttributeEvaluation(attributeEvaluation);
			if (result == null)
				result = caseEvaluation(attributeEvaluation);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MutatorenvironmentPackage.ATTRIBUTE_REVERSE: {
			AttributeReverse attributeReverse = (AttributeReverse) theEObject;
			T result = caseAttributeReverse(attributeReverse);
			if (result == null)
				result = caseAttributeSet(attributeReverse);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MutatorenvironmentPackage.REFERENCE_SET: {
			ReferenceSet referenceSet = (ReferenceSet) theEObject;
			T result = caseReferenceSet(referenceSet);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MutatorenvironmentPackage.REFERENCE_INIT: {
			ReferenceInit referenceInit = (ReferenceInit) theEObject;
			T result = caseReferenceInit(referenceInit);
			if (result == null)
				result = caseReferenceSet(referenceInit);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MutatorenvironmentPackage.REFERENCE_ATT: {
			ReferenceAtt referenceAtt = (ReferenceAtt) theEObject;
			T result = caseReferenceAtt(referenceAtt);
			if (result == null)
				result = caseReferenceSet(referenceAtt);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MutatorenvironmentPackage.REFERENCE_EVALUATION: {
			ReferenceEvaluation referenceEvaluation = (ReferenceEvaluation) theEObject;
			T result = caseReferenceEvaluation(referenceEvaluation);
			if (result == null)
				result = caseEvaluation(referenceEvaluation);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MutatorenvironmentPackage.EXPRESSION: {
			Expression expression = (Expression) theEObject;
			T result = caseExpression(expression);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MutatorenvironmentPackage.REFERENCE_SWAP: {
			ReferenceSwap referenceSwap = (ReferenceSwap) theEObject;
			T result = caseReferenceSwap(referenceSwap);
			if (result == null)
				result = caseReferenceSet(referenceSwap);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MutatorenvironmentPackage.EVALUATION: {
			Evaluation evaluation = (Evaluation) theEObject;
			T result = caseEvaluation(evaluation);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MutatorenvironmentPackage.BINARY_OPERATOR: {
			BinaryOperator binaryOperator = (BinaryOperator) theEObject;
			T result = caseBinaryOperator(binaryOperator);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MutatorenvironmentPackage.BLOCK: {
			Block block = (Block) theEObject;
			T result = caseBlock(block);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MutatorenvironmentPackage.CONSTRAINT: {
			Constraint constraint = (Constraint) theEObject;
			T result = caseConstraint(constraint);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MutatorenvironmentPackage.RANDOM_TYPE: {
			RandomType randomType = (RandomType) theEObject;
			T result = caseRandomType(randomType);
			if (result == null)
				result = caseAttributeType(randomType);
			if (result == null)
				result = caseAttributeEvaluationType(randomType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MutatorenvironmentPackage.CLONE_OBJECT_MUTATOR: {
			CloneObjectMutator cloneObjectMutator = (CloneObjectMutator) theEObject;
			T result = caseCloneObjectMutator(cloneObjectMutator);
			if (result == null)
				result = caseMutator(cloneObjectMutator);
			if (result == null)
				result = caseObjectEmitter(cloneObjectMutator);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MutatorenvironmentPackage.LIST_TYPE: {
			ListType listType = (ListType) theEObject;
			T result = caseListType(listType);
			if (result == null)
				result = caseAttributeType(listType);
			if (result == null)
				result = caseAttributeEvaluationType(listType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MutatorenvironmentPackage.OBJECT_ATTRIBUTE_TYPE: {
			ObjectAttributeType objectAttributeType = (ObjectAttributeType) theEObject;
			T result = caseObjectAttributeType(objectAttributeType);
			if (result == null)
				result = caseAttributeEvaluationType(objectAttributeType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MutatorenvironmentPackage.ATTRIBUTE_EVALUATION_TYPE: {
			AttributeEvaluationType attributeEvaluationType = (AttributeEvaluationType) theEObject;
			T result = caseAttributeEvaluationType(attributeEvaluationType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MutatorenvironmentPackage.MIN_VALUE_TYPE: {
			MinValueType minValueType = (MinValueType) theEObject;
			T result = caseMinValueType(minValueType);
			if (result == null)
				result = caseNumberType(minValueType);
			if (result == null)
				result = caseAttributeType(minValueType);
			if (result == null)
				result = caseAttributeEvaluationType(minValueType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MutatorenvironmentPackage.MAX_VALUE_TYPE: {
			MaxValueType maxValueType = (MaxValueType) theEObject;
			T result = caseMaxValueType(maxValueType);
			if (result == null)
				result = caseNumberType(maxValueType);
			if (result == null)
				result = caseAttributeType(maxValueType);
			if (result == null)
				result = caseAttributeEvaluationType(maxValueType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MutatorenvironmentPackage.NUMBER_TYPE: {
			NumberType numberType = (NumberType) theEObject;
			T result = caseNumberType(numberType);
			if (result == null)
				result = caseAttributeType(numberType);
			if (result == null)
				result = caseAttributeEvaluationType(numberType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MutatorenvironmentPackage.ATTRIBUTE_OPERATION: {
			AttributeOperation attributeOperation = (AttributeOperation) theEObject;
			T result = caseAttributeOperation(attributeOperation);
			if (result == null)
				result = caseAttributeSet(attributeOperation);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MutatorenvironmentPackage.RANDOM_NUMBER_TYPE: {
			RandomNumberType randomNumberType = (RandomNumberType) theEObject;
			T result = caseRandomNumberType(randomNumberType);
			if (result == null)
				result = caseNumberType(randomNumberType);
			if (result == null)
				result = caseAttributeType(randomNumberType);
			if (result == null)
				result = caseAttributeEvaluationType(randomNumberType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MutatorenvironmentPackage.RANDOM_DOUBLE_NUMBER_TYPE: {
			RandomDoubleNumberType randomDoubleNumberType = (RandomDoubleNumberType) theEObject;
			T result = caseRandomDoubleNumberType(randomDoubleNumberType);
			if (result == null)
				result = caseRandomNumberType(randomDoubleNumberType);
			if (result == null)
				result = caseNumberType(randomDoubleNumberType);
			if (result == null)
				result = caseAttributeType(randomDoubleNumberType);
			if (result == null)
				result = caseAttributeEvaluationType(randomDoubleNumberType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MutatorenvironmentPackage.RANDOM_INTEGER_NUMBER_TYPE: {
			RandomIntegerNumberType randomIntegerNumberType = (RandomIntegerNumberType) theEObject;
			T result = caseRandomIntegerNumberType(randomIntegerNumberType);
			if (result == null)
				result = caseRandomNumberType(randomIntegerNumberType);
			if (result == null)
				result = caseNumberType(randomIntegerNumberType);
			if (result == null)
				result = caseAttributeType(randomIntegerNumberType);
			if (result == null)
				result = caseAttributeEvaluationType(randomIntegerNumberType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MutatorenvironmentPackage.SPECIFIC_CLOSURE_SELECTION: {
			SpecificClosureSelection specificClosureSelection = (SpecificClosureSelection) theEObject;
			T result = caseSpecificClosureSelection(specificClosureSelection);
			if (result == null)
				result = caseSpecificSelection(specificClosureSelection);
			if (result == null)
				result = caseObSelectionStrategy(specificClosureSelection);
			if (result == null)
				result = caseObjectEmitter(specificClosureSelection);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MutatorenvironmentPackage.SELECT_SAMPLE_MUTATOR: {
			SelectSampleMutator selectSampleMutator = (SelectSampleMutator) theEObject;
			T result = caseSelectSampleMutator(selectSampleMutator);
			if (result == null)
				result = caseMutator(selectSampleMutator);
			if (result == null)
				result = caseObjectEmitter(selectSampleMutator);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MutatorenvironmentPackage.REFERENCE_ADD: {
			ReferenceAdd referenceAdd = (ReferenceAdd) theEObject;
			T result = caseReferenceAdd(referenceAdd);
			if (result == null)
				result = caseReferenceSet(referenceAdd);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MutatorenvironmentPackage.REFERENCE_REMOVE: {
			ReferenceRemove referenceRemove = (ReferenceRemove) theEObject;
			T result = caseReferenceRemove(referenceRemove);
			if (result == null)
				result = caseReferenceSet(referenceRemove);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MutatorenvironmentPackage.RETYPE_OBJECT_MUTATOR: {
			RetypeObjectMutator retypeObjectMutator = (RetypeObjectMutator) theEObject;
			T result = caseRetypeObjectMutator(retypeObjectMutator);
			if (result == null)
				result = caseMutator(retypeObjectMutator);
			if (result == null)
				result = caseObjectEmitter(retypeObjectMutator);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MutatorenvironmentPackage.TYPED_SELECTION: {
			TypedSelection typedSelection = (TypedSelection) theEObject;
			T result = caseTypedSelection(typedSelection);
			if (result == null)
				result = caseObSelectionStrategy(typedSelection);
			if (result == null)
				result = caseObjectEmitter(typedSelection);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MutatorenvironmentPackage.RANDOM_STRING_NUMBER_TYPE: {
			RandomStringNumberType randomStringNumberType = (RandomStringNumberType) theEObject;
			T result = caseRandomStringNumberType(randomStringNumberType);
			if (result == null)
				result = caseStringType(randomStringNumberType);
			if (result == null)
				result = caseAttributeType(randomStringNumberType);
			if (result == null)
				result = caseAttributeEvaluationType(randomStringNumberType);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		case MutatorenvironmentPackage.RESOURCE: {
			Resource resource = (Resource) theEObject;
			T result = caseResource(resource);
			if (result == null)
				result = caseDefinition(resource);
			if (result == null)
				result = defaultCase(theEObject);
			return result;
		}
		default:
			return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mutator Environment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mutator Environment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMutatorEnvironment(MutatorEnvironment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDefinition(Definition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Library</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Library</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLibrary(Library object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Program</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Program</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProgram(Program object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Object Emitter</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Object Emitter</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseObjectEmitter(ObjectEmitter object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Mutator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Mutator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMutator(Mutator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Composite Mutator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Composite Mutator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompositeMutator(CompositeMutator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Load</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Load</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLoad(Load object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Create Object Mutator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Create Object Mutator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCreateObjectMutator(CreateObjectMutator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Ob Selection Strategy</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Ob Selection Strategy</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseObSelectionStrategy(ObSelectionStrategy object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Random Selection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Random Selection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRandomSelection(RandomSelection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Random Type Selection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Random Type Selection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRandomTypeSelection(RandomTypeSelection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Specific Object Selection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Specific Object Selection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSpecificObjectSelection(SpecificObjectSelection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute Scalar</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute Scalar</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttributeScalar(AttributeScalar object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttributeType(AttributeType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Boolean Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Boolean Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBooleanType(BooleanType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Specific Boolean Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Specific Boolean Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSpecificBooleanType(SpecificBooleanType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Random Boolean Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Random Boolean Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRandomBooleanType(RandomBooleanType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>String Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>String Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStringType(StringType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Specific String Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Specific String Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSpecificStringType(SpecificStringType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Random String Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Random String Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRandomStringType(RandomStringType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Integer Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Integer Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseIntegerType(IntegerType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Specific Integer Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Specific Integer Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSpecificIntegerType(SpecificIntegerType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Random Integer Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Random Integer Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRandomIntegerType(RandomIntegerType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Double Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Double Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDoubleType(DoubleType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Specific Double Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Specific Double Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSpecificDoubleType(SpecificDoubleType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Random Double Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Random Double Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRandomDoubleType(RandomDoubleType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Modify Source Reference Mutator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Modify Source Reference Mutator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModifySourceReferenceMutator(ModifySourceReferenceMutator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Specific Selection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Specific Selection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSpecificSelection(SpecificSelection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Specific Reference Selection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Specific Reference Selection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSpecificReferenceSelection(SpecificReferenceSelection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Modify Target Reference Mutator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Modify Target Reference Mutator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModifyTargetReferenceMutator(ModifyTargetReferenceMutator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Create Reference Mutator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Create Reference Mutator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCreateReferenceMutator(CreateReferenceMutator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Remove Object Mutator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Remove Object Mutator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRemoveObjectMutator(RemoveObjectMutator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Remove Reference Mutator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Remove Reference Mutator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRemoveReferenceMutator(RemoveReferenceMutator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Modify Information Mutator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Modify Information Mutator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModifyInformationMutator(ModifyInformationMutator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Upper String Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Upper String Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUpperStringType(UpperStringType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Lower String Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Lower String Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLowerStringType(LowerStringType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>List String Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>List String Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseListStringType(ListStringType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Cat Start String Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cat Start String Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCatStartStringType(CatStartStringType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Cat End String Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Cat End String Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCatEndStringType(CatEndStringType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute Unset</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute Unset</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttributeUnset(AttributeUnset object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute Set</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute Set</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttributeSet(AttributeSet object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute Swap</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute Swap</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttributeSwap(AttributeSwap object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Replace String Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Replace String Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReplaceStringType(ReplaceStringType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute Copy</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute Copy</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttributeCopy(AttributeCopy object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Remove Random Reference Mutator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Remove Random Reference Mutator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRemoveRandomReferenceMutator(RemoveRandomReferenceMutator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Remove Specific Reference Mutator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Remove Specific Reference Mutator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRemoveSpecificReferenceMutator(RemoveSpecificReferenceMutator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Complete Selection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Complete Selection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompleteSelection(CompleteSelection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Complete Type Selection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Complete Type Selection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCompleteTypeSelection(CompleteTypeSelection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Remove Complete Reference Mutator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Remove Complete Reference Mutator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRemoveCompleteReferenceMutator(RemoveCompleteReferenceMutator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Source</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Source</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSource(Source object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Other Selection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Other Selection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOtherSelection(OtherSelection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Other Type Selection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Other Type Selection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOtherTypeSelection(OtherTypeSelection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Select Object Mutator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Select Object Mutator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSelectObjectMutator(SelectObjectMutator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute Evaluation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute Evaluation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttributeEvaluation(AttributeEvaluation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute Reverse</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute Reverse</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttributeReverse(AttributeReverse object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reference Set</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reference Set</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReferenceSet(ReferenceSet object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reference Init</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reference Init</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReferenceInit(ReferenceInit object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reference Att</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reference Att</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReferenceAtt(ReferenceAtt object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reference Evaluation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reference Evaluation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReferenceEvaluation(ReferenceEvaluation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpression(Expression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reference Swap</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reference Swap</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReferenceSwap(ReferenceSwap object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Evaluation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Evaluation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEvaluation(Evaluation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Binary Operator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Binary Operator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBinaryOperator(BinaryOperator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Block</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Block</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBlock(Block object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Constraint</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Constraint</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConstraint(Constraint object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Random Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Random Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRandomType(RandomType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Clone Object Mutator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Clone Object Mutator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCloneObjectMutator(CloneObjectMutator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>List Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>List Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseListType(ListType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Object Attribute Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Object Attribute Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseObjectAttributeType(ObjectAttributeType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute Evaluation Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute Evaluation Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttributeEvaluationType(AttributeEvaluationType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Min Value Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Min Value Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMinValueType(MinValueType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Max Value Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Max Value Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseMaxValueType(MaxValueType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Number Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Number Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNumberType(NumberType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Attribute Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Attribute Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAttributeOperation(AttributeOperation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Random Number Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Random Number Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRandomNumberType(RandomNumberType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Random Double Number Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Random Double Number Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRandomDoubleNumberType(RandomDoubleNumberType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Random Integer Number Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Random Integer Number Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRandomIntegerNumberType(RandomIntegerNumberType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Specific Closure Selection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Specific Closure Selection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSpecificClosureSelection(SpecificClosureSelection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Select Sample Mutator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Select Sample Mutator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSelectSampleMutator(SelectSampleMutator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reference Add</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reference Add</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReferenceAdd(ReferenceAdd object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reference Remove</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reference Remove</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReferenceRemove(ReferenceRemove object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Retype Object Mutator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Retype Object Mutator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRetypeObjectMutator(RetypeObjectMutator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Typed Selection</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Typed Selection</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypedSelection(TypedSelection object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Random String Number Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Random String Number Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRandomStringNumberType(RandomStringNumberType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Resource</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Resource</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseResource(Resource object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //MutatorenvironmentSwitch
