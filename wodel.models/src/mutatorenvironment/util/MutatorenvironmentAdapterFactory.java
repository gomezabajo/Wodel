/**
 */
package mutatorenvironment.util;

import mutatorenvironment.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see mutatorenvironment.MutatorenvironmentPackage
 * @generated
 */
public class MutatorenvironmentAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static MutatorenvironmentPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MutatorenvironmentAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = MutatorenvironmentPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MutatorenvironmentSwitch<Adapter> modelSwitch =
		new MutatorenvironmentSwitch<Adapter>() {
			@Override
			public Adapter caseMutatorEnvironment(MutatorEnvironment object) {
				return createMutatorEnvironmentAdapter();
			}
			@Override
			public Adapter caseDefinition(Definition object) {
				return createDefinitionAdapter();
			}
			@Override
			public Adapter caseLibrary(Library object) {
				return createLibraryAdapter();
			}
			@Override
			public Adapter caseProgram(Program object) {
				return createProgramAdapter();
			}
			@Override
			public Adapter caseObjectEmitter(ObjectEmitter object) {
				return createObjectEmitterAdapter();
			}
			@Override
			public Adapter caseMutator(Mutator object) {
				return createMutatorAdapter();
			}
			@Override
			public Adapter caseCompositeMutator(CompositeMutator object) {
				return createCompositeMutatorAdapter();
			}
			@Override
			public Adapter caseLoad(Load object) {
				return createLoadAdapter();
			}
			@Override
			public Adapter caseCreateObjectMutator(CreateObjectMutator object) {
				return createCreateObjectMutatorAdapter();
			}
			@Override
			public Adapter caseObSelectionStrategy(ObSelectionStrategy object) {
				return createObSelectionStrategyAdapter();
			}
			@Override
			public Adapter caseRandomSelection(RandomSelection object) {
				return createRandomSelectionAdapter();
			}
			@Override
			public Adapter caseRandomTypeSelection(RandomTypeSelection object) {
				return createRandomTypeSelectionAdapter();
			}
			@Override
			public Adapter caseSpecificObjectSelection(SpecificObjectSelection object) {
				return createSpecificObjectSelectionAdapter();
			}
			@Override
			public Adapter caseAttributeInit(AttributeInit object) {
				return createAttributeInitAdapter();
			}
			@Override
			public Adapter caseAttributeType(AttributeType object) {
				return createAttributeTypeAdapter();
			}
			@Override
			public Adapter caseBooleanType(BooleanType object) {
				return createBooleanTypeAdapter();
			}
			@Override
			public Adapter caseSpecificBooleanType(SpecificBooleanType object) {
				return createSpecificBooleanTypeAdapter();
			}
			@Override
			public Adapter caseRandomBooleanType(RandomBooleanType object) {
				return createRandomBooleanTypeAdapter();
			}
			@Override
			public Adapter caseStringType(StringType object) {
				return createStringTypeAdapter();
			}
			@Override
			public Adapter caseSpecificStringType(SpecificStringType object) {
				return createSpecificStringTypeAdapter();
			}
			@Override
			public Adapter caseRandomStringType(RandomStringType object) {
				return createRandomStringTypeAdapter();
			}
			@Override
			public Adapter caseIntegerType(IntegerType object) {
				return createIntegerTypeAdapter();
			}
			@Override
			public Adapter caseSpecificIntegerType(SpecificIntegerType object) {
				return createSpecificIntegerTypeAdapter();
			}
			@Override
			public Adapter caseRandomIntegerType(RandomIntegerType object) {
				return createRandomIntegerTypeAdapter();
			}
			@Override
			public Adapter caseDoubleType(DoubleType object) {
				return createDoubleTypeAdapter();
			}
			@Override
			public Adapter caseSpecificDoubleType(SpecificDoubleType object) {
				return createSpecificDoubleTypeAdapter();
			}
			@Override
			public Adapter caseRandomDoubleType(RandomDoubleType object) {
				return createRandomDoubleTypeAdapter();
			}
			@Override
			public Adapter caseModifySourceReferenceMutator(ModifySourceReferenceMutator object) {
				return createModifySourceReferenceMutatorAdapter();
			}
			@Override
			public Adapter caseSpecificSelection(SpecificSelection object) {
				return createSpecificSelectionAdapter();
			}
			@Override
			public Adapter caseSpecificReferenceSelection(SpecificReferenceSelection object) {
				return createSpecificReferenceSelectionAdapter();
			}
			@Override
			public Adapter caseModifyTargetReferenceMutator(ModifyTargetReferenceMutator object) {
				return createModifyTargetReferenceMutatorAdapter();
			}
			@Override
			public Adapter caseCreateReferenceMutator(CreateReferenceMutator object) {
				return createCreateReferenceMutatorAdapter();
			}
			@Override
			public Adapter caseRemoveObjectMutator(RemoveObjectMutator object) {
				return createRemoveObjectMutatorAdapter();
			}
			@Override
			public Adapter caseRemoveReferenceMutator(RemoveReferenceMutator object) {
				return createRemoveReferenceMutatorAdapter();
			}
			@Override
			public Adapter caseModifyInformationMutator(ModifyInformationMutator object) {
				return createModifyInformationMutatorAdapter();
			}
			@Override
			public Adapter caseUpperStringType(UpperStringType object) {
				return createUpperStringTypeAdapter();
			}
			@Override
			public Adapter caseLowerStringType(LowerStringType object) {
				return createLowerStringTypeAdapter();
			}
			@Override
			public Adapter caseListStringType(ListStringType object) {
				return createListStringTypeAdapter();
			}
			@Override
			public Adapter caseCatStartStringType(CatStartStringType object) {
				return createCatStartStringTypeAdapter();
			}
			@Override
			public Adapter caseCatEndStringType(CatEndStringType object) {
				return createCatEndStringTypeAdapter();
			}
			@Override
			public Adapter caseAttributeUnset(AttributeUnset object) {
				return createAttributeUnsetAdapter();
			}
			@Override
			public Adapter caseAttributeSet(AttributeSet object) {
				return createAttributeSetAdapter();
			}
			@Override
			public Adapter caseAttributeSwap(AttributeSwap object) {
				return createAttributeSwapAdapter();
			}
			@Override
			public Adapter caseReplaceStringType(ReplaceStringType object) {
				return createReplaceStringTypeAdapter();
			}
			@Override
			public Adapter caseAttributeCopy(AttributeCopy object) {
				return createAttributeCopyAdapter();
			}
			@Override
			public Adapter caseRemoveRandomReferenceMutator(RemoveRandomReferenceMutator object) {
				return createRemoveRandomReferenceMutatorAdapter();
			}
			@Override
			public Adapter caseRemoveSpecificReferenceMutator(RemoveSpecificReferenceMutator object) {
				return createRemoveSpecificReferenceMutatorAdapter();
			}
			@Override
			public Adapter caseCompleteSelection(CompleteSelection object) {
				return createCompleteSelectionAdapter();
			}
			@Override
			public Adapter caseCompleteTypeSelection(CompleteTypeSelection object) {
				return createCompleteTypeSelectionAdapter();
			}
			@Override
			public Adapter caseRemoveCompleteReferenceMutator(RemoveCompleteReferenceMutator object) {
				return createRemoveCompleteReferenceMutatorAdapter();
			}
			@Override
			public Adapter caseSource(Source object) {
				return createSourceAdapter();
			}
			@Override
			public Adapter caseOtherSelection(OtherSelection object) {
				return createOtherSelectionAdapter();
			}
			@Override
			public Adapter caseOtherTypeSelection(OtherTypeSelection object) {
				return createOtherTypeSelectionAdapter();
			}
			@Override
			public Adapter caseSelectObjectMutator(SelectObjectMutator object) {
				return createSelectObjectMutatorAdapter();
			}
			@Override
			public Adapter caseAttributeEvaluation(AttributeEvaluation object) {
				return createAttributeEvaluationAdapter();
			}
			@Override
			public Adapter caseAttributeReverse(AttributeReverse object) {
				return createAttributeReverseAdapter();
			}
			@Override
			public Adapter caseReferenceSet(ReferenceSet object) {
				return createReferenceSetAdapter();
			}
			@Override
			public Adapter caseReferenceInit(ReferenceInit object) {
				return createReferenceInitAdapter();
			}
			@Override
			public Adapter caseReferenceEvaluation(ReferenceEvaluation object) {
				return createReferenceEvaluationAdapter();
			}
			@Override
			public Adapter caseExpression(Expression object) {
				return createExpressionAdapter();
			}
			@Override
			public Adapter caseReferenceSwap(ReferenceSwap object) {
				return createReferenceSwapAdapter();
			}
			@Override
			public Adapter caseEvaluation(Evaluation object) {
				return createEvaluationAdapter();
			}
			@Override
			public Adapter caseBinaryOperator(BinaryOperator object) {
				return createBinaryOperatorAdapter();
			}
			@Override
			public Adapter caseBlock(Block object) {
				return createBlockAdapter();
			}
			@Override
			public Adapter caseConstraint(Constraint object) {
				return createConstraintAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.MutatorEnvironment <em>Mutator Environment</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.MutatorEnvironment
	 * @generated
	 */
	public Adapter createMutatorEnvironmentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.Definition <em>Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.Definition
	 * @generated
	 */
	public Adapter createDefinitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.Library <em>Library</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.Library
	 * @generated
	 */
	public Adapter createLibraryAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.Program <em>Program</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.Program
	 * @generated
	 */
	public Adapter createProgramAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.ObjectEmitter <em>Object Emitter</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.ObjectEmitter
	 * @generated
	 */
	public Adapter createObjectEmitterAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.Mutator <em>Mutator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.Mutator
	 * @generated
	 */
	public Adapter createMutatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.CompositeMutator <em>Composite Mutator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.CompositeMutator
	 * @generated
	 */
	public Adapter createCompositeMutatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.Load <em>Load</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.Load
	 * @generated
	 */
	public Adapter createLoadAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.CreateObjectMutator <em>Create Object Mutator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.CreateObjectMutator
	 * @generated
	 */
	public Adapter createCreateObjectMutatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.ObSelectionStrategy <em>Ob Selection Strategy</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.ObSelectionStrategy
	 * @generated
	 */
	public Adapter createObSelectionStrategyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.RandomSelection <em>Random Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.RandomSelection
	 * @generated
	 */
	public Adapter createRandomSelectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.RandomTypeSelection <em>Random Type Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.RandomTypeSelection
	 * @generated
	 */
	public Adapter createRandomTypeSelectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.SpecificObjectSelection <em>Specific Object Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.SpecificObjectSelection
	 * @generated
	 */
	public Adapter createSpecificObjectSelectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.AttributeInit <em>Attribute Init</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.AttributeInit
	 * @generated
	 */
	public Adapter createAttributeInitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.AttributeType <em>Attribute Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.AttributeType
	 * @generated
	 */
	public Adapter createAttributeTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.BooleanType <em>Boolean Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.BooleanType
	 * @generated
	 */
	public Adapter createBooleanTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.SpecificBooleanType <em>Specific Boolean Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.SpecificBooleanType
	 * @generated
	 */
	public Adapter createSpecificBooleanTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.RandomBooleanType <em>Random Boolean Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.RandomBooleanType
	 * @generated
	 */
	public Adapter createRandomBooleanTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.StringType <em>String Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.StringType
	 * @generated
	 */
	public Adapter createStringTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.SpecificStringType <em>Specific String Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.SpecificStringType
	 * @generated
	 */
	public Adapter createSpecificStringTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.RandomStringType <em>Random String Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.RandomStringType
	 * @generated
	 */
	public Adapter createRandomStringTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.IntegerType <em>Integer Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.IntegerType
	 * @generated
	 */
	public Adapter createIntegerTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.SpecificIntegerType <em>Specific Integer Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.SpecificIntegerType
	 * @generated
	 */
	public Adapter createSpecificIntegerTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.RandomIntegerType <em>Random Integer Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.RandomIntegerType
	 * @generated
	 */
	public Adapter createRandomIntegerTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.DoubleType <em>Double Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.DoubleType
	 * @generated
	 */
	public Adapter createDoubleTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.SpecificDoubleType <em>Specific Double Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.SpecificDoubleType
	 * @generated
	 */
	public Adapter createSpecificDoubleTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.RandomDoubleType <em>Random Double Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.RandomDoubleType
	 * @generated
	 */
	public Adapter createRandomDoubleTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.ModifySourceReferenceMutator <em>Modify Source Reference Mutator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.ModifySourceReferenceMutator
	 * @generated
	 */
	public Adapter createModifySourceReferenceMutatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.SpecificSelection <em>Specific Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.SpecificSelection
	 * @generated
	 */
	public Adapter createSpecificSelectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.SpecificReferenceSelection <em>Specific Reference Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.SpecificReferenceSelection
	 * @generated
	 */
	public Adapter createSpecificReferenceSelectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.ModifyTargetReferenceMutator <em>Modify Target Reference Mutator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.ModifyTargetReferenceMutator
	 * @generated
	 */
	public Adapter createModifyTargetReferenceMutatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.CreateReferenceMutator <em>Create Reference Mutator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.CreateReferenceMutator
	 * @generated
	 */
	public Adapter createCreateReferenceMutatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.RemoveObjectMutator <em>Remove Object Mutator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.RemoveObjectMutator
	 * @generated
	 */
	public Adapter createRemoveObjectMutatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.RemoveReferenceMutator <em>Remove Reference Mutator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.RemoveReferenceMutator
	 * @generated
	 */
	public Adapter createRemoveReferenceMutatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.ModifyInformationMutator <em>Modify Information Mutator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.ModifyInformationMutator
	 * @generated
	 */
	public Adapter createModifyInformationMutatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.UpperStringType <em>Upper String Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.UpperStringType
	 * @generated
	 */
	public Adapter createUpperStringTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.LowerStringType <em>Lower String Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.LowerStringType
	 * @generated
	 */
	public Adapter createLowerStringTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.ListStringType <em>List String Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.ListStringType
	 * @generated
	 */
	public Adapter createListStringTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.CatStartStringType <em>Cat Start String Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.CatStartStringType
	 * @generated
	 */
	public Adapter createCatStartStringTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.CatEndStringType <em>Cat End String Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.CatEndStringType
	 * @generated
	 */
	public Adapter createCatEndStringTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.AttributeUnset <em>Attribute Unset</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.AttributeUnset
	 * @generated
	 */
	public Adapter createAttributeUnsetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.AttributeSet <em>Attribute Set</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.AttributeSet
	 * @generated
	 */
	public Adapter createAttributeSetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.AttributeSwap <em>Attribute Swap</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.AttributeSwap
	 * @generated
	 */
	public Adapter createAttributeSwapAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.ReplaceStringType <em>Replace String Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.ReplaceStringType
	 * @generated
	 */
	public Adapter createReplaceStringTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.AttributeCopy <em>Attribute Copy</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.AttributeCopy
	 * @generated
	 */
	public Adapter createAttributeCopyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.RemoveRandomReferenceMutator <em>Remove Random Reference Mutator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.RemoveRandomReferenceMutator
	 * @generated
	 */
	public Adapter createRemoveRandomReferenceMutatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.RemoveSpecificReferenceMutator <em>Remove Specific Reference Mutator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.RemoveSpecificReferenceMutator
	 * @generated
	 */
	public Adapter createRemoveSpecificReferenceMutatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.CompleteSelection <em>Complete Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.CompleteSelection
	 * @generated
	 */
	public Adapter createCompleteSelectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.CompleteTypeSelection <em>Complete Type Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.CompleteTypeSelection
	 * @generated
	 */
	public Adapter createCompleteTypeSelectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.RemoveCompleteReferenceMutator <em>Remove Complete Reference Mutator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.RemoveCompleteReferenceMutator
	 * @generated
	 */
	public Adapter createRemoveCompleteReferenceMutatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.Source <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.Source
	 * @generated
	 */
	public Adapter createSourceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.OtherSelection <em>Other Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.OtherSelection
	 * @generated
	 */
	public Adapter createOtherSelectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.OtherTypeSelection <em>Other Type Selection</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.OtherTypeSelection
	 * @generated
	 */
	public Adapter createOtherTypeSelectionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.SelectObjectMutator <em>Select Object Mutator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.SelectObjectMutator
	 * @generated
	 */
	public Adapter createSelectObjectMutatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.AttributeEvaluation <em>Attribute Evaluation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.AttributeEvaluation
	 * @generated
	 */
	public Adapter createAttributeEvaluationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.AttributeReverse <em>Attribute Reverse</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.AttributeReverse
	 * @generated
	 */
	public Adapter createAttributeReverseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.ReferenceSet <em>Reference Set</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.ReferenceSet
	 * @generated
	 */
	public Adapter createReferenceSetAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.ReferenceInit <em>Reference Init</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.ReferenceInit
	 * @generated
	 */
	public Adapter createReferenceInitAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.ReferenceEvaluation <em>Reference Evaluation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.ReferenceEvaluation
	 * @generated
	 */
	public Adapter createReferenceEvaluationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.Expression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.Expression
	 * @generated
	 */
	public Adapter createExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.ReferenceSwap <em>Reference Swap</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.ReferenceSwap
	 * @generated
	 */
	public Adapter createReferenceSwapAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.Evaluation <em>Evaluation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.Evaluation
	 * @generated
	 */
	public Adapter createEvaluationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.BinaryOperator <em>Binary Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.BinaryOperator
	 * @generated
	 */
	public Adapter createBinaryOperatorAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.Block <em>Block</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.Block
	 * @generated
	 */
	public Adapter createBlockAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link mutatorenvironment.Constraint <em>Constraint</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see mutatorenvironment.Constraint
	 * @generated
	 */
	public Adapter createConstraintAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //MutatorenvironmentAdapterFactory
