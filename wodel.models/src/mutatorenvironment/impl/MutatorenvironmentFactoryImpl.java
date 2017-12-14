/**
 */
package mutatorenvironment.impl;

import mutatorenvironment.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MutatorenvironmentFactoryImpl extends EFactoryImpl implements MutatorenvironmentFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static MutatorenvironmentFactory init() {
		try {
			MutatorenvironmentFactory theMutatorenvironmentFactory = (MutatorenvironmentFactory)EPackage.Registry.INSTANCE.getEFactory(MutatorenvironmentPackage.eNS_URI);
			if (theMutatorenvironmentFactory != null) {
				return theMutatorenvironmentFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new MutatorenvironmentFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MutatorenvironmentFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case MutatorenvironmentPackage.MUTATOR_ENVIRONMENT: return createMutatorEnvironment();
			case MutatorenvironmentPackage.LIBRARY: return createLibrary();
			case MutatorenvironmentPackage.PROGRAM: return createProgram();
			case MutatorenvironmentPackage.COMPOSITE_MUTATOR: return createCompositeMutator();
			case MutatorenvironmentPackage.LOAD: return createLoad();
			case MutatorenvironmentPackage.CREATE_OBJECT_MUTATOR: return createCreateObjectMutator();
			case MutatorenvironmentPackage.RANDOM_TYPE_SELECTION: return createRandomTypeSelection();
			case MutatorenvironmentPackage.SPECIFIC_OBJECT_SELECTION: return createSpecificObjectSelection();
			case MutatorenvironmentPackage.ATTRIBUTE_SCALAR: return createAttributeScalar();
			case MutatorenvironmentPackage.SPECIFIC_BOOLEAN_TYPE: return createSpecificBooleanType();
			case MutatorenvironmentPackage.RANDOM_BOOLEAN_TYPE: return createRandomBooleanType();
			case MutatorenvironmentPackage.SPECIFIC_STRING_TYPE: return createSpecificStringType();
			case MutatorenvironmentPackage.RANDOM_STRING_TYPE: return createRandomStringType();
			case MutatorenvironmentPackage.SPECIFIC_INTEGER_TYPE: return createSpecificIntegerType();
			case MutatorenvironmentPackage.RANDOM_INTEGER_TYPE: return createRandomIntegerType();
			case MutatorenvironmentPackage.SPECIFIC_DOUBLE_TYPE: return createSpecificDoubleType();
			case MutatorenvironmentPackage.RANDOM_DOUBLE_TYPE: return createRandomDoubleType();
			case MutatorenvironmentPackage.MODIFY_SOURCE_REFERENCE_MUTATOR: return createModifySourceReferenceMutator();
			case MutatorenvironmentPackage.SPECIFIC_REFERENCE_SELECTION: return createSpecificReferenceSelection();
			case MutatorenvironmentPackage.MODIFY_TARGET_REFERENCE_MUTATOR: return createModifyTargetReferenceMutator();
			case MutatorenvironmentPackage.CREATE_REFERENCE_MUTATOR: return createCreateReferenceMutator();
			case MutatorenvironmentPackage.REMOVE_OBJECT_MUTATOR: return createRemoveObjectMutator();
			case MutatorenvironmentPackage.MODIFY_INFORMATION_MUTATOR: return createModifyInformationMutator();
			case MutatorenvironmentPackage.UPPER_STRING_TYPE: return createUpperStringType();
			case MutatorenvironmentPackage.LOWER_STRING_TYPE: return createLowerStringType();
			case MutatorenvironmentPackage.LIST_STRING_TYPE: return createListStringType();
			case MutatorenvironmentPackage.CAT_START_STRING_TYPE: return createCatStartStringType();
			case MutatorenvironmentPackage.CAT_END_STRING_TYPE: return createCatEndStringType();
			case MutatorenvironmentPackage.ATTRIBUTE_UNSET: return createAttributeUnset();
			case MutatorenvironmentPackage.ATTRIBUTE_SET: return createAttributeSet();
			case MutatorenvironmentPackage.ATTRIBUTE_SWAP: return createAttributeSwap();
			case MutatorenvironmentPackage.REPLACE_STRING_TYPE: return createReplaceStringType();
			case MutatorenvironmentPackage.ATTRIBUTE_COPY: return createAttributeCopy();
			case MutatorenvironmentPackage.REMOVE_RANDOM_REFERENCE_MUTATOR: return createRemoveRandomReferenceMutator();
			case MutatorenvironmentPackage.REMOVE_SPECIFIC_REFERENCE_MUTATOR: return createRemoveSpecificReferenceMutator();
			case MutatorenvironmentPackage.COMPLETE_SELECTION: return createCompleteSelection();
			case MutatorenvironmentPackage.COMPLETE_TYPE_SELECTION: return createCompleteTypeSelection();
			case MutatorenvironmentPackage.REMOVE_COMPLETE_REFERENCE_MUTATOR: return createRemoveCompleteReferenceMutator();
			case MutatorenvironmentPackage.SOURCE: return createSource();
			case MutatorenvironmentPackage.OTHER_SELECTION: return createOtherSelection();
			case MutatorenvironmentPackage.OTHER_TYPE_SELECTION: return createOtherTypeSelection();
			case MutatorenvironmentPackage.SELECT_OBJECT_MUTATOR: return createSelectObjectMutator();
			case MutatorenvironmentPackage.ATTRIBUTE_EVALUATION: return createAttributeEvaluation();
			case MutatorenvironmentPackage.ATTRIBUTE_REVERSE: return createAttributeReverse();
			case MutatorenvironmentPackage.REFERENCE_SET: return createReferenceSet();
			case MutatorenvironmentPackage.REFERENCE_INIT: return createReferenceInit();
			case MutatorenvironmentPackage.REFERENCE_ATT: return createReferenceAtt();
			case MutatorenvironmentPackage.REFERENCE_EVALUATION: return createReferenceEvaluation();
			case MutatorenvironmentPackage.EXPRESSION: return createExpression();
			case MutatorenvironmentPackage.REFERENCE_SWAP: return createReferenceSwap();
			case MutatorenvironmentPackage.BINARY_OPERATOR: return createBinaryOperator();
			case MutatorenvironmentPackage.BLOCK: return createBlock();
			case MutatorenvironmentPackage.CONSTRAINT: return createConstraint();
			case MutatorenvironmentPackage.RANDOM_TYPE: return createRandomType();
			case MutatorenvironmentPackage.CLONE_OBJECT_MUTATOR: return createCloneObjectMutator();
			case MutatorenvironmentPackage.LIST_TYPE: return createListType();
			case MutatorenvironmentPackage.OBJECT_ATTRIBUTE_TYPE: return createObjectAttributeType();
			case MutatorenvironmentPackage.MIN_VALUE_TYPE: return createMinValueType();
			case MutatorenvironmentPackage.MAX_VALUE_TYPE: return createMaxValueType();
			case MutatorenvironmentPackage.ATTRIBUTE_OPERATION: return createAttributeOperation();
			case MutatorenvironmentPackage.RANDOM_DOUBLE_NUMBER_TYPE: return createRandomDoubleNumberType();
			case MutatorenvironmentPackage.RANDOM_INTEGER_NUMBER_TYPE: return createRandomIntegerNumberType();
			case MutatorenvironmentPackage.SPECIFIC_CLOSURE_SELECTION: return createSpecificClosureSelection();
			case MutatorenvironmentPackage.SELECT_SAMPLE_MUTATOR: return createSelectSampleMutator();
			case MutatorenvironmentPackage.REFERENCE_ADD: return createReferenceAdd();
			case MutatorenvironmentPackage.REFERENCE_REMOVE: return createReferenceRemove();
			case MutatorenvironmentPackage.RETYPE_OBJECT_MUTATOR: return createRetypeObjectMutator();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case MutatorenvironmentPackage.LOGIC_OPERATOR:
				return createLogicOperatorFromString(eDataType, initialValue);
			case MutatorenvironmentPackage.OPERATOR:
				return createOperatorFromString(eDataType, initialValue);
			case MutatorenvironmentPackage.REPEAT:
				return createRepeatFromString(eDataType, initialValue);
			case MutatorenvironmentPackage.ARITHMETIC_OPERATOR:
				return createArithmeticOperatorFromString(eDataType, initialValue);
			case MutatorenvironmentPackage.SAMPLE_CLAUSE:
				return createSampleClauseFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case MutatorenvironmentPackage.LOGIC_OPERATOR:
				return convertLogicOperatorToString(eDataType, instanceValue);
			case MutatorenvironmentPackage.OPERATOR:
				return convertOperatorToString(eDataType, instanceValue);
			case MutatorenvironmentPackage.REPEAT:
				return convertRepeatToString(eDataType, instanceValue);
			case MutatorenvironmentPackage.ARITHMETIC_OPERATOR:
				return convertArithmeticOperatorToString(eDataType, instanceValue);
			case MutatorenvironmentPackage.SAMPLE_CLAUSE:
				return convertSampleClauseToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MutatorEnvironment createMutatorEnvironment() {
		MutatorEnvironmentImpl mutatorEnvironment = new MutatorEnvironmentImpl();
		return mutatorEnvironment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Library createLibrary() {
		LibraryImpl library = new LibraryImpl();
		return library;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Program createProgram() {
		ProgramImpl program = new ProgramImpl();
		return program;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompositeMutator createCompositeMutator() {
		CompositeMutatorImpl compositeMutator = new CompositeMutatorImpl();
		return compositeMutator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Load createLoad() {
		LoadImpl load = new LoadImpl();
		return load;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CreateObjectMutator createCreateObjectMutator() {
		CreateObjectMutatorImpl createObjectMutator = new CreateObjectMutatorImpl();
		return createObjectMutator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RandomTypeSelection createRandomTypeSelection() {
		RandomTypeSelectionImpl randomTypeSelection = new RandomTypeSelectionImpl();
		return randomTypeSelection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpecificObjectSelection createSpecificObjectSelection() {
		SpecificObjectSelectionImpl specificObjectSelection = new SpecificObjectSelectionImpl();
		return specificObjectSelection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttributeScalar createAttributeScalar() {
		AttributeScalarImpl attributeScalar = new AttributeScalarImpl();
		return attributeScalar;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpecificBooleanType createSpecificBooleanType() {
		SpecificBooleanTypeImpl specificBooleanType = new SpecificBooleanTypeImpl();
		return specificBooleanType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RandomBooleanType createRandomBooleanType() {
		RandomBooleanTypeImpl randomBooleanType = new RandomBooleanTypeImpl();
		return randomBooleanType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpecificStringType createSpecificStringType() {
		SpecificStringTypeImpl specificStringType = new SpecificStringTypeImpl();
		return specificStringType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RandomStringType createRandomStringType() {
		RandomStringTypeImpl randomStringType = new RandomStringTypeImpl();
		return randomStringType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpecificIntegerType createSpecificIntegerType() {
		SpecificIntegerTypeImpl specificIntegerType = new SpecificIntegerTypeImpl();
		return specificIntegerType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RandomIntegerType createRandomIntegerType() {
		RandomIntegerTypeImpl randomIntegerType = new RandomIntegerTypeImpl();
		return randomIntegerType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpecificDoubleType createSpecificDoubleType() {
		SpecificDoubleTypeImpl specificDoubleType = new SpecificDoubleTypeImpl();
		return specificDoubleType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RandomDoubleType createRandomDoubleType() {
		RandomDoubleTypeImpl randomDoubleType = new RandomDoubleTypeImpl();
		return randomDoubleType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModifySourceReferenceMutator createModifySourceReferenceMutator() {
		ModifySourceReferenceMutatorImpl modifySourceReferenceMutator = new ModifySourceReferenceMutatorImpl();
		return modifySourceReferenceMutator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpecificReferenceSelection createSpecificReferenceSelection() {
		SpecificReferenceSelectionImpl specificReferenceSelection = new SpecificReferenceSelectionImpl();
		return specificReferenceSelection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModifyTargetReferenceMutator createModifyTargetReferenceMutator() {
		ModifyTargetReferenceMutatorImpl modifyTargetReferenceMutator = new ModifyTargetReferenceMutatorImpl();
		return modifyTargetReferenceMutator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CreateReferenceMutator createCreateReferenceMutator() {
		CreateReferenceMutatorImpl createReferenceMutator = new CreateReferenceMutatorImpl();
		return createReferenceMutator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RemoveObjectMutator createRemoveObjectMutator() {
		RemoveObjectMutatorImpl removeObjectMutator = new RemoveObjectMutatorImpl();
		return removeObjectMutator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModifyInformationMutator createModifyInformationMutator() {
		ModifyInformationMutatorImpl modifyInformationMutator = new ModifyInformationMutatorImpl();
		return modifyInformationMutator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UpperStringType createUpperStringType() {
		UpperStringTypeImpl upperStringType = new UpperStringTypeImpl();
		return upperStringType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LowerStringType createLowerStringType() {
		LowerStringTypeImpl lowerStringType = new LowerStringTypeImpl();
		return lowerStringType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ListStringType createListStringType() {
		ListStringTypeImpl listStringType = new ListStringTypeImpl();
		return listStringType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CatStartStringType createCatStartStringType() {
		CatStartStringTypeImpl catStartStringType = new CatStartStringTypeImpl();
		return catStartStringType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CatEndStringType createCatEndStringType() {
		CatEndStringTypeImpl catEndStringType = new CatEndStringTypeImpl();
		return catEndStringType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttributeUnset createAttributeUnset() {
		AttributeUnsetImpl attributeUnset = new AttributeUnsetImpl();
		return attributeUnset;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttributeSet createAttributeSet() {
		AttributeSetImpl attributeSet = new AttributeSetImpl();
		return attributeSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttributeSwap createAttributeSwap() {
		AttributeSwapImpl attributeSwap = new AttributeSwapImpl();
		return attributeSwap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReplaceStringType createReplaceStringType() {
		ReplaceStringTypeImpl replaceStringType = new ReplaceStringTypeImpl();
		return replaceStringType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttributeCopy createAttributeCopy() {
		AttributeCopyImpl attributeCopy = new AttributeCopyImpl();
		return attributeCopy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RemoveRandomReferenceMutator createRemoveRandomReferenceMutator() {
		RemoveRandomReferenceMutatorImpl removeRandomReferenceMutator = new RemoveRandomReferenceMutatorImpl();
		return removeRandomReferenceMutator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RemoveSpecificReferenceMutator createRemoveSpecificReferenceMutator() {
		RemoveSpecificReferenceMutatorImpl removeSpecificReferenceMutator = new RemoveSpecificReferenceMutatorImpl();
		return removeSpecificReferenceMutator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompleteSelection createCompleteSelection() {
		CompleteSelectionImpl completeSelection = new CompleteSelectionImpl();
		return completeSelection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CompleteTypeSelection createCompleteTypeSelection() {
		CompleteTypeSelectionImpl completeTypeSelection = new CompleteTypeSelectionImpl();
		return completeTypeSelection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RemoveCompleteReferenceMutator createRemoveCompleteReferenceMutator() {
		RemoveCompleteReferenceMutatorImpl removeCompleteReferenceMutator = new RemoveCompleteReferenceMutatorImpl();
		return removeCompleteReferenceMutator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Source createSource() {
		SourceImpl source = new SourceImpl();
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OtherSelection createOtherSelection() {
		OtherSelectionImpl otherSelection = new OtherSelectionImpl();
		return otherSelection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OtherTypeSelection createOtherTypeSelection() {
		OtherTypeSelectionImpl otherTypeSelection = new OtherTypeSelectionImpl();
		return otherTypeSelection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SelectObjectMutator createSelectObjectMutator() {
		SelectObjectMutatorImpl selectObjectMutator = new SelectObjectMutatorImpl();
		return selectObjectMutator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttributeEvaluation createAttributeEvaluation() {
		AttributeEvaluationImpl attributeEvaluation = new AttributeEvaluationImpl();
		return attributeEvaluation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttributeReverse createAttributeReverse() {
		AttributeReverseImpl attributeReverse = new AttributeReverseImpl();
		return attributeReverse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReferenceSet createReferenceSet() {
		ReferenceSetImpl referenceSet = new ReferenceSetImpl();
		return referenceSet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReferenceInit createReferenceInit() {
		ReferenceInitImpl referenceInit = new ReferenceInitImpl();
		return referenceInit;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReferenceAtt createReferenceAtt() {
		ReferenceAttImpl referenceAtt = new ReferenceAttImpl();
		return referenceAtt;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReferenceEvaluation createReferenceEvaluation() {
		ReferenceEvaluationImpl referenceEvaluation = new ReferenceEvaluationImpl();
		return referenceEvaluation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression createExpression() {
		ExpressionImpl expression = new ExpressionImpl();
		return expression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReferenceSwap createReferenceSwap() {
		ReferenceSwapImpl referenceSwap = new ReferenceSwapImpl();
		return referenceSwap;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BinaryOperator createBinaryOperator() {
		BinaryOperatorImpl binaryOperator = new BinaryOperatorImpl();
		return binaryOperator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Block createBlock() {
		BlockImpl block = new BlockImpl();
		return block;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Constraint createConstraint() {
		ConstraintImpl constraint = new ConstraintImpl();
		return constraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RandomType createRandomType() {
		RandomTypeImpl randomType = new RandomTypeImpl();
		return randomType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CloneObjectMutator createCloneObjectMutator() {
		CloneObjectMutatorImpl cloneObjectMutator = new CloneObjectMutatorImpl();
		return cloneObjectMutator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ListType createListType() {
		ListTypeImpl listType = new ListTypeImpl();
		return listType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ObjectAttributeType createObjectAttributeType() {
		ObjectAttributeTypeImpl objectAttributeType = new ObjectAttributeTypeImpl();
		return objectAttributeType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MinValueType createMinValueType() {
		MinValueTypeImpl minValueType = new MinValueTypeImpl();
		return minValueType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MaxValueType createMaxValueType() {
		MaxValueTypeImpl maxValueType = new MaxValueTypeImpl();
		return maxValueType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttributeOperation createAttributeOperation() {
		AttributeOperationImpl attributeOperation = new AttributeOperationImpl();
		return attributeOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RandomDoubleNumberType createRandomDoubleNumberType() {
		RandomDoubleNumberTypeImpl randomDoubleNumberType = new RandomDoubleNumberTypeImpl();
		return randomDoubleNumberType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RandomIntegerNumberType createRandomIntegerNumberType() {
		RandomIntegerNumberTypeImpl randomIntegerNumberType = new RandomIntegerNumberTypeImpl();
		return randomIntegerNumberType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SpecificClosureSelection createSpecificClosureSelection() {
		SpecificClosureSelectionImpl specificClosureSelection = new SpecificClosureSelectionImpl();
		return specificClosureSelection;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SelectSampleMutator createSelectSampleMutator() {
		SelectSampleMutatorImpl selectSampleMutator = new SelectSampleMutatorImpl();
		return selectSampleMutator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReferenceAdd createReferenceAdd() {
		ReferenceAddImpl referenceAdd = new ReferenceAddImpl();
		return referenceAdd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReferenceRemove createReferenceRemove() {
		ReferenceRemoveImpl referenceRemove = new ReferenceRemoveImpl();
		return referenceRemove;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RetypeObjectMutator createRetypeObjectMutator() {
		RetypeObjectMutatorImpl retypeObjectMutator = new RetypeObjectMutatorImpl();
		return retypeObjectMutator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LogicOperator createLogicOperatorFromString(EDataType eDataType, String initialValue) {
		LogicOperator result = LogicOperator.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLogicOperatorToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Operator createOperatorFromString(EDataType eDataType, String initialValue) {
		Operator result = Operator.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertOperatorToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Repeat createRepeatFromString(EDataType eDataType, String initialValue) {
		Repeat result = Repeat.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertRepeatToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArithmeticOperator createArithmeticOperatorFromString(EDataType eDataType, String initialValue) {
		ArithmeticOperator result = ArithmeticOperator.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertArithmeticOperatorToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SampleClause createSampleClauseFromString(EDataType eDataType, String initialValue) {
		SampleClause result = SampleClause.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSampleClauseToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MutatorenvironmentPackage getMutatorenvironmentPackage() {
		return (MutatorenvironmentPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static MutatorenvironmentPackage getPackage() {
		return MutatorenvironmentPackage.eINSTANCE;
	}

} //MutatorenvironmentFactoryImpl
