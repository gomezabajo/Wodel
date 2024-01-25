/**
 */
package mutatorenvironment.impl;

import mutatorenvironment.ArithmeticOperator;
import mutatorenvironment.AttributeCopy;
import mutatorenvironment.AttributeEvaluation;
import mutatorenvironment.AttributeEvaluationType;
import mutatorenvironment.AttributeOperation;
import mutatorenvironment.AttributeReverse;
import mutatorenvironment.AttributeScalar;
import mutatorenvironment.AttributeSet;
import mutatorenvironment.AttributeSwap;
import mutatorenvironment.AttributeType;
import mutatorenvironment.AttributeUnset;
import mutatorenvironment.BinaryOperator;
import mutatorenvironment.Block;
import mutatorenvironment.BooleanType;
import mutatorenvironment.CatEndStringType;
import mutatorenvironment.CatStartStringType;
import mutatorenvironment.CloneObjectMutator;
import mutatorenvironment.CompleteSelection;
import mutatorenvironment.CompleteTypeSelection;
import mutatorenvironment.CompositeMutator;
import mutatorenvironment.Constraint;
import mutatorenvironment.CreateObjectMutator;
import mutatorenvironment.CreateReferenceMutator;
import mutatorenvironment.Definition;
import mutatorenvironment.DoubleType;
import mutatorenvironment.Evaluation;
import mutatorenvironment.Expression;
import mutatorenvironment.IntegerType;
import mutatorenvironment.Library;
import mutatorenvironment.ListStringType;
import mutatorenvironment.ListType;
import mutatorenvironment.Load;
import mutatorenvironment.LogicOperator;
import mutatorenvironment.LowerStringType;
import mutatorenvironment.MaxValueType;
import mutatorenvironment.MinValueType;
import mutatorenvironment.ModifyInformationMutator;
import mutatorenvironment.ModifySourceReferenceMutator;
import mutatorenvironment.ModifyTargetReferenceMutator;
import mutatorenvironment.Mutator;
import mutatorenvironment.MutatorEnvironment;
import mutatorenvironment.MutatorenvironmentFactory;
import mutatorenvironment.MutatorenvironmentPackage;
import mutatorenvironment.NumberType;
import mutatorenvironment.ObSelectionStrategy;
import mutatorenvironment.ObjectAttributeType;
import mutatorenvironment.ObjectEmitter;
import mutatorenvironment.Operator;
import mutatorenvironment.OtherSelection;
import mutatorenvironment.OtherTypeSelection;
import mutatorenvironment.Program;
import mutatorenvironment.RandomBooleanType;
import mutatorenvironment.RandomDoubleNumberType;
import mutatorenvironment.RandomDoubleType;
import mutatorenvironment.RandomIntegerNumberType;
import mutatorenvironment.RandomIntegerType;
import mutatorenvironment.RandomNumberType;
import mutatorenvironment.RandomSelection;
import mutatorenvironment.RandomStringNumberType;
import mutatorenvironment.RandomStringType;
import mutatorenvironment.RandomType;
import mutatorenvironment.RandomTypeSelection;
import mutatorenvironment.ReferenceAdd;
import mutatorenvironment.ReferenceAtt;
import mutatorenvironment.ReferenceEvaluation;
import mutatorenvironment.ReferenceInit;
import mutatorenvironment.ReferenceRemove;
import mutatorenvironment.ReferenceSet;
import mutatorenvironment.ReferenceSwap;
import mutatorenvironment.RemoveCompleteReferenceMutator;
import mutatorenvironment.RemoveObjectMutator;
import mutatorenvironment.RemoveRandomReferenceMutator;
import mutatorenvironment.RemoveReferenceMutator;
import mutatorenvironment.RemoveSpecificReferenceMutator;
import mutatorenvironment.Repeat;
import mutatorenvironment.ReplaceStringType;
import mutatorenvironment.Resource;
import mutatorenvironment.RetypeObjectMutator;
import mutatorenvironment.SampleClause;
import mutatorenvironment.SelectObjectMutator;
import mutatorenvironment.SelectSampleMutator;
import mutatorenvironment.Source;
import mutatorenvironment.SpecificBooleanType;
import mutatorenvironment.SpecificClosureSelection;
import mutatorenvironment.SpecificDoubleType;
import mutatorenvironment.SpecificIntegerType;
import mutatorenvironment.SpecificObjectSelection;
import mutatorenvironment.SpecificReferenceSelection;
import mutatorenvironment.SpecificSelection;
import mutatorenvironment.SpecificStringType;
import mutatorenvironment.StringType;
import mutatorenvironment.TypedSelection;
import mutatorenvironment.UpperStringType;

import mutatorenvironment.miniOCL.MiniOCLPackage;

import mutatorenvironment.miniOCL.impl.MiniOCLPackageImpl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class MutatorenvironmentPackageImpl extends EPackageImpl implements MutatorenvironmentPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mutatorEnvironmentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass definitionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass libraryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass programEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass objectEmitterEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mutatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass compositeMutatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass loadEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass createObjectMutatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass obSelectionStrategyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass randomSelectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass randomTypeSelectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass specificObjectSelectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeScalarEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass booleanTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass specificBooleanTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass randomBooleanTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass stringTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass specificStringTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass randomStringTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass integerTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass specificIntegerTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass randomIntegerTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass doubleTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass specificDoubleTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass randomDoubleTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modifySourceReferenceMutatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass specificSelectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass specificReferenceSelectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modifyTargetReferenceMutatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass createReferenceMutatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass removeObjectMutatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass removeReferenceMutatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass modifyInformationMutatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass upperStringTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass lowerStringTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass listStringTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass catStartStringTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass catEndStringTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeUnsetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeSetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeSwapEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass replaceStringTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeCopyEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass removeRandomReferenceMutatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass removeSpecificReferenceMutatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass completeSelectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass completeTypeSelectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass removeCompleteReferenceMutatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass sourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass otherSelectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass otherTypeSelectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass selectObjectMutatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeEvaluationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeReverseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass referenceSetEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass referenceInitEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass referenceAttEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass referenceEvaluationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass expressionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass referenceSwapEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass evaluationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass binaryOperatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass blockEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass constraintEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass randomTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cloneObjectMutatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass listTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass objectAttributeTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeEvaluationTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass minValueTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass maxValueTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass numberTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass attributeOperationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass randomNumberTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass randomDoubleNumberTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass randomIntegerNumberTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass specificClosureSelectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass selectSampleMutatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass referenceAddEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass referenceRemoveEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass retypeObjectMutatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass typedSelectionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass randomStringNumberTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass resourceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum logicOperatorEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum operatorEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum repeatEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum arithmeticOperatorEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum sampleClauseEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see mutatorenvironment.MutatorenvironmentPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private MutatorenvironmentPackageImpl() {
		super(eNS_URI, MutatorenvironmentFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link MutatorenvironmentPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static MutatorenvironmentPackage init() {
		if (isInited)
			return (MutatorenvironmentPackage) EPackage.Registry.INSTANCE
					.getEPackage(MutatorenvironmentPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredMutatorenvironmentPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		MutatorenvironmentPackageImpl theMutatorenvironmentPackage = registeredMutatorenvironmentPackage instanceof MutatorenvironmentPackageImpl
				? (MutatorenvironmentPackageImpl) registeredMutatorenvironmentPackage
				: new MutatorenvironmentPackageImpl();

		isInited = true;

		// Obtain or create and register interdependencies
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(MiniOCLPackage.eNS_URI);
		MiniOCLPackageImpl theMiniOCLPackage = (MiniOCLPackageImpl) (registeredPackage instanceof MiniOCLPackageImpl
				? registeredPackage
				: MiniOCLPackage.eINSTANCE);

		// Create package meta-data objects
		theMutatorenvironmentPackage.createPackageContents();
		theMiniOCLPackage.createPackageContents();

		// Initialize created meta-data
		theMutatorenvironmentPackage.initializePackageContents();
		theMiniOCLPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theMutatorenvironmentPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(MutatorenvironmentPackage.eNS_URI, theMutatorenvironmentPackage);
		return theMutatorenvironmentPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMutatorEnvironment() {
		return mutatorEnvironmentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMutatorEnvironment_Definition() {
		return (EReference) mutatorEnvironmentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMutatorEnvironment_Commands() {
		return (EReference) mutatorEnvironmentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMutatorEnvironment_Load() {
		return (EReference) mutatorEnvironmentEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMutatorEnvironment_Blocks() {
		return (EReference) mutatorEnvironmentEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMutatorEnvironment_Constraints() {
		return (EReference) mutatorEnvironmentEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDefinition() {
		return definitionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDefinition_Metamodel() {
		return (EAttribute) definitionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLibrary() {
		return libraryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getProgram() {
		return programEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProgram_Output() {
		return (EAttribute) programEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProgram_Num() {
		return (EAttribute) programEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProgram_Source() {
		return (EReference) programEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProgram_Description() {
		return (EAttribute) programEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getProgram_Exhaustive() {
		return (EAttribute) programEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getProgram_Resources() {
		return (EReference) programEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getObjectEmitter() {
		return objectEmitterEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getObjectEmitter_Type() {
		return (EReference) objectEmitterEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getObjectEmitter_Name() {
		return (EAttribute) objectEmitterEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getObjectEmitter_Types() {
		return (EReference) objectEmitterEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMutator() {
		return mutatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMutator_Min() {
		return (EAttribute) mutatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMutator_Max() {
		return (EAttribute) mutatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMutator_Fixed() {
		return (EAttribute) mutatorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompositeMutator() {
		return compositeMutatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCompositeMutator_Commands() {
		return (EReference) compositeMutatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLoad() {
		return loadEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLoad_File() {
		return (EAttribute) loadEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCreateObjectMutator() {
		return createObjectMutatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCreateObjectMutator_Container() {
		return (EReference) createObjectMutatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCreateObjectMutator_Attributes() {
		return (EReference) createObjectMutatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCreateObjectMutator_References() {
		return (EReference) createObjectMutatorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getObSelectionStrategy() {
		return obSelectionStrategyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getObSelectionStrategy_RefType() {
		return (EReference) obSelectionStrategyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getObSelectionStrategy_Expression() {
		return (EReference) obSelectionStrategyEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getObSelectionStrategy_Resource() {
		return (EAttribute) obSelectionStrategyEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getObSelectionStrategy_RefRefType() {
		return (EReference) obSelectionStrategyEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getObSelectionStrategy_RefRefRefType() {
		return (EReference) obSelectionStrategyEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRandomSelection() {
		return randomSelectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRandomTypeSelection() {
		return randomTypeSelectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSpecificObjectSelection() {
		return specificObjectSelectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSpecificObjectSelection_ObjSel() {
		return (EReference) specificObjectSelectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttributeScalar() {
		return attributeScalarEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAttributeScalar_Value() {
		return (EReference) attributeScalarEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttributeType() {
		return attributeTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttributeType_Operator() {
		return (EAttribute) attributeTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBooleanType() {
		return booleanTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSpecificBooleanType() {
		return specificBooleanTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSpecificBooleanType_Value() {
		return (EAttribute) specificBooleanTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRandomBooleanType() {
		return randomBooleanTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRandomBooleanType_AllowsNull() {
		return (EAttribute) randomBooleanTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStringType() {
		return stringTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSpecificStringType() {
		return specificStringTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSpecificStringType_Value() {
		return (EAttribute) specificStringTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRandomStringType() {
		return randomStringTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRandomStringType_Min() {
		return (EAttribute) randomStringTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRandomStringType_Max() {
		return (EAttribute) randomStringTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRandomStringType_AllowsNull() {
		return (EAttribute) randomStringTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getIntegerType() {
		return integerTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSpecificIntegerType() {
		return specificIntegerTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSpecificIntegerType_Value() {
		return (EAttribute) specificIntegerTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRandomIntegerType() {
		return randomIntegerTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRandomIntegerType_Min() {
		return (EAttribute) randomIntegerTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRandomIntegerType_Max() {
		return (EAttribute) randomIntegerTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRandomIntegerType_AllowsNull() {
		return (EAttribute) randomIntegerTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDoubleType() {
		return doubleTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSpecificDoubleType() {
		return specificDoubleTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSpecificDoubleType_Value() {
		return (EAttribute) specificDoubleTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRandomDoubleType() {
		return randomDoubleTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRandomDoubleType_Min() {
		return (EAttribute) randomDoubleTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRandomDoubleType_Max() {
		return (EAttribute) randomDoubleTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRandomDoubleType_AllowsNull() {
		return (EAttribute) randomDoubleTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModifySourceReferenceMutator() {
		return modifySourceReferenceMutatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModifySourceReferenceMutator_RefType() {
		return (EReference) modifySourceReferenceMutatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModifySourceReferenceMutator_Source() {
		return (EReference) modifySourceReferenceMutatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModifySourceReferenceMutator_NewSource() {
		return (EReference) modifySourceReferenceMutatorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSpecificSelection() {
		return specificSelectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSpecificReferenceSelection() {
		return specificReferenceSelectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSpecificReferenceSelection_ObjSel() {
		return (EReference) specificReferenceSelectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModifyTargetReferenceMutator() {
		return modifyTargetReferenceMutatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModifyTargetReferenceMutator_RefType() {
		return (EReference) modifyTargetReferenceMutatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModifyTargetReferenceMutator_Source() {
		return (EReference) modifyTargetReferenceMutatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModifyTargetReferenceMutator_NewTarget() {
		return (EReference) modifyTargetReferenceMutatorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCreateReferenceMutator() {
		return createReferenceMutatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCreateReferenceMutator_Source() {
		return (EReference) createReferenceMutatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCreateReferenceMutator_Target() {
		return (EReference) createReferenceMutatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCreateReferenceMutator_RefType() {
		return (EReference) createReferenceMutatorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRemoveObjectMutator() {
		return removeObjectMutatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRemoveObjectMutator_Object() {
		return (EReference) removeObjectMutatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRemoveObjectMutator_Container() {
		return (EReference) removeObjectMutatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRemoveReferenceMutator() {
		return removeReferenceMutatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModifyInformationMutator() {
		return modifyInformationMutatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModifyInformationMutator_Object() {
		return (EReference) modifyInformationMutatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModifyInformationMutator_Attributes() {
		return (EReference) modifyInformationMutatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getModifyInformationMutator_References() {
		return (EReference) modifyInformationMutatorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUpperStringType() {
		return upperStringTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getUpperStringType_Value() {
		return (EAttribute) upperStringTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLowerStringType() {
		return lowerStringTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLowerStringType_Value() {
		return (EAttribute) lowerStringTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getListStringType() {
		return listStringTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getListStringType_Value() {
		return (EAttribute) listStringTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCatStartStringType() {
		return catStartStringTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCatStartStringType_Value() {
		return (EAttribute) catStartStringTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCatEndStringType() {
		return catEndStringTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCatEndStringType_Value() {
		return (EAttribute) catEndStringTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttributeUnset() {
		return attributeUnsetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttributeSet() {
		return attributeSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAttributeSet_Attribute() {
		return (EReference) attributeSetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttributeSwap() {
		return attributeSwapEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAttributeSwap_Object() {
		return (EReference) attributeSwapEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReplaceStringType() {
		return replaceStringTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReplaceStringType_Oldstring() {
		return (EAttribute) replaceStringTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReplaceStringType_Newstring() {
		return (EAttribute) replaceStringTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttributeCopy() {
		return attributeCopyEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAttributeCopy_Object() {
		return (EReference) attributeCopyEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRemoveRandomReferenceMutator() {
		return removeRandomReferenceMutatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRemoveRandomReferenceMutator_RefType() {
		return (EReference) removeRandomReferenceMutatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRemoveSpecificReferenceMutator() {
		return removeSpecificReferenceMutatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRemoveSpecificReferenceMutator_RefType() {
		return (EReference) removeSpecificReferenceMutatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRemoveSpecificReferenceMutator_Container() {
		return (EReference) removeSpecificReferenceMutatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompleteSelection() {
		return completeSelectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCompleteTypeSelection() {
		return completeTypeSelectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRemoveCompleteReferenceMutator() {
		return removeCompleteReferenceMutatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRemoveCompleteReferenceMutator_RefType() {
		return (EReference) removeCompleteReferenceMutatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSource() {
		return sourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSource_Path() {
		return (EAttribute) sourceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOtherSelection() {
		return otherSelectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getOtherTypeSelection() {
		return otherTypeSelectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSelectObjectMutator() {
		return selectObjectMutatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSelectObjectMutator_Container() {
		return (EReference) selectObjectMutatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSelectObjectMutator_Object() {
		return (EReference) selectObjectMutatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttributeEvaluation() {
		return attributeEvaluationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAttributeEvaluation_Name() {
		return (EReference) attributeEvaluationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAttributeEvaluation_Value() {
		return (EReference) attributeEvaluationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttributeReverse() {
		return attributeReverseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReferenceSet() {
		return referenceSetEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReferenceSet_Reference() {
		return (EReference) referenceSetEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReferenceSet_Object() {
		return (EReference) referenceSetEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReferenceInit() {
		return referenceInitEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReferenceAtt() {
		return referenceAttEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReferenceAtt_Attribute() {
		return (EReference) referenceAttEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReferenceAtt_Value() {
		return (EReference) referenceAttEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReferenceEvaluation() {
		return referenceEvaluationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReferenceEvaluation_Name() {
		return (EReference) referenceEvaluationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReferenceEvaluation_RefName() {
		return (EReference) referenceEvaluationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReferenceEvaluation_RefRefName() {
		return (EReference) referenceEvaluationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReferenceEvaluation_Operator() {
		return (EAttribute) referenceEvaluationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReferenceEvaluation_Value() {
		return (EReference) referenceEvaluationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReferenceEvaluation_RefType() {
		return (EReference) referenceEvaluationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReferenceEvaluation_AttName() {
		return (EReference) referenceEvaluationEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReferenceEvaluation_AttValue() {
		return (EReference) referenceEvaluationEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReferenceEvaluation_Container() {
		return (EAttribute) referenceEvaluationEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReferenceEvaluation_Self() {
		return (EAttribute) referenceEvaluationEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExpression() {
		return expressionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExpression_First() {
		return (EReference) expressionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExpression_Operator() {
		return (EReference) expressionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getExpression_Second() {
		return (EReference) expressionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReferenceSwap() {
		return referenceSwapEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEvaluation() {
		return evaluationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBinaryOperator() {
		return binaryOperatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBinaryOperator_Type() {
		return (EAttribute) binaryOperatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getBlock() {
		return blockEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBlock_Name() {
		return (EAttribute) blockEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBlock_Commands() {
		return (EReference) blockEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getBlock_From() {
		return (EReference) blockEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBlock_Repeat() {
		return (EAttribute) blockEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBlock_Min() {
		return (EAttribute) blockEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBlock_Max() {
		return (EAttribute) blockEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBlock_Fixed() {
		return (EAttribute) blockEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getBlock_Description() {
		return (EAttribute) blockEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConstraint() {
		return constraintEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConstraint_Id() {
		return (EAttribute) constraintEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConstraint_Type() {
		return (EReference) constraintEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConstraint_Expressions() {
		return (EReference) constraintEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConstraint_Rules() {
		return (EAttribute) constraintEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRandomType() {
		return randomTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCloneObjectMutator() {
		return cloneObjectMutatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCloneObjectMutator_Contents() {
		return (EAttribute) cloneObjectMutatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCloneObjectMutator_Object() {
		return (EReference) cloneObjectMutatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCloneObjectMutator_Container() {
		return (EReference) cloneObjectMutatorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCloneObjectMutator_RefType() {
		return (EReference) cloneObjectMutatorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCloneObjectMutator_Attributes() {
		return (EReference) cloneObjectMutatorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getCloneObjectMutator_References() {
		return (EReference) cloneObjectMutatorEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getListType() {
		return listTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getListType_Value() {
		return (EReference) listTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getObjectAttributeType() {
		return objectAttributeTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getObjectAttributeType_ObjSel() {
		return (EReference) objectAttributeTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getObjectAttributeType_Attribute() {
		return (EReference) objectAttributeTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getObjectAttributeType_Operator() {
		return (EAttribute) objectAttributeTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttributeEvaluationType() {
		return attributeEvaluationTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMinValueType() {
		return minValueTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMinValueType_Attribute() {
		return (EReference) minValueTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMaxValueType() {
		return maxValueTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMaxValueType_Attribute() {
		return (EReference) maxValueTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNumberType() {
		return numberTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAttributeOperation() {
		return attributeOperationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getAttributeOperation_Operator() {
		return (EAttribute) attributeOperationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getAttributeOperation_Value() {
		return (EReference) attributeOperationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRandomNumberType() {
		return randomNumberTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRandomNumberType_Object() {
		return (EReference) randomNumberTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRandomNumberType_Max() {
		return (EReference) randomNumberTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRandomDoubleNumberType() {
		return randomDoubleNumberTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRandomDoubleNumberType_Min() {
		return (EAttribute) randomDoubleNumberTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRandomIntegerNumberType() {
		return randomIntegerNumberTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRandomIntegerNumberType_Min() {
		return (EAttribute) randomIntegerNumberTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSpecificClosureSelection() {
		return specificClosureSelectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSpecificClosureSelection_ObjSel() {
		return (EReference) specificClosureSelectionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSelectSampleMutator() {
		return selectSampleMutatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSelectSampleMutator_Object() {
		return (EReference) selectSampleMutatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSelectSampleMutator_Clause() {
		return (EAttribute) selectSampleMutatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSelectSampleMutator_Features() {
		return (EReference) selectSampleMutatorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReferenceAdd() {
		return referenceAddEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReferenceRemove() {
		return referenceRemoveEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRetypeObjectMutator() {
		return retypeObjectMutatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRetypeObjectMutator_Object() {
		return (EReference) retypeObjectMutatorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRetypeObjectMutator_Container() {
		return (EReference) retypeObjectMutatorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRetypeObjectMutator_RefType() {
		return (EReference) retypeObjectMutatorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRetypeObjectMutator_Attributes() {
		return (EReference) retypeObjectMutatorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRetypeObjectMutator_References() {
		return (EReference) retypeObjectMutatorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTypedSelection() {
		return typedSelectionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRandomStringNumberType() {
		return randomStringNumberTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRandomStringNumberType_Min() {
		return (EAttribute) randomStringNumberTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRandomStringNumberType_Max() {
		return (EAttribute) randomStringNumberTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRandomStringNumberType_AllowsNull() {
		return (EAttribute) randomStringNumberTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getResource() {
		return resourceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getResource_Name() {
		return (EAttribute) resourceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getResource_Path() {
		return (EReference) resourceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getLogicOperator() {
		return logicOperatorEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getOperator() {
		return operatorEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getRepeat() {
		return repeatEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getArithmeticOperator() {
		return arithmeticOperatorEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getSampleClause() {
		return sampleClauseEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MutatorenvironmentFactory getMutatorenvironmentFactory() {
		return (MutatorenvironmentFactory) getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated)
			return;
		isCreated = true;

		// Create classes and their features
		mutatorEnvironmentEClass = createEClass(MUTATOR_ENVIRONMENT);
		createEReference(mutatorEnvironmentEClass, MUTATOR_ENVIRONMENT__DEFINITION);
		createEReference(mutatorEnvironmentEClass, MUTATOR_ENVIRONMENT__COMMANDS);
		createEReference(mutatorEnvironmentEClass, MUTATOR_ENVIRONMENT__LOAD);
		createEReference(mutatorEnvironmentEClass, MUTATOR_ENVIRONMENT__BLOCKS);
		createEReference(mutatorEnvironmentEClass, MUTATOR_ENVIRONMENT__CONSTRAINTS);

		definitionEClass = createEClass(DEFINITION);
		createEAttribute(definitionEClass, DEFINITION__METAMODEL);

		libraryEClass = createEClass(LIBRARY);

		programEClass = createEClass(PROGRAM);
		createEAttribute(programEClass, PROGRAM__OUTPUT);
		createEAttribute(programEClass, PROGRAM__NUM);
		createEReference(programEClass, PROGRAM__SOURCE);
		createEAttribute(programEClass, PROGRAM__DESCRIPTION);
		createEAttribute(programEClass, PROGRAM__EXHAUSTIVE);
		createEReference(programEClass, PROGRAM__RESOURCES);

		objectEmitterEClass = createEClass(OBJECT_EMITTER);
		createEReference(objectEmitterEClass, OBJECT_EMITTER__TYPE);
		createEAttribute(objectEmitterEClass, OBJECT_EMITTER__NAME);
		createEReference(objectEmitterEClass, OBJECT_EMITTER__TYPES);

		mutatorEClass = createEClass(MUTATOR);
		createEAttribute(mutatorEClass, MUTATOR__MIN);
		createEAttribute(mutatorEClass, MUTATOR__MAX);
		createEAttribute(mutatorEClass, MUTATOR__FIXED);

		compositeMutatorEClass = createEClass(COMPOSITE_MUTATOR);
		createEReference(compositeMutatorEClass, COMPOSITE_MUTATOR__COMMANDS);

		loadEClass = createEClass(LOAD);
		createEAttribute(loadEClass, LOAD__FILE);

		createObjectMutatorEClass = createEClass(CREATE_OBJECT_MUTATOR);
		createEReference(createObjectMutatorEClass, CREATE_OBJECT_MUTATOR__CONTAINER);
		createEReference(createObjectMutatorEClass, CREATE_OBJECT_MUTATOR__ATTRIBUTES);
		createEReference(createObjectMutatorEClass, CREATE_OBJECT_MUTATOR__REFERENCES);

		obSelectionStrategyEClass = createEClass(OB_SELECTION_STRATEGY);
		createEReference(obSelectionStrategyEClass, OB_SELECTION_STRATEGY__REF_TYPE);
		createEReference(obSelectionStrategyEClass, OB_SELECTION_STRATEGY__EXPRESSION);
		createEAttribute(obSelectionStrategyEClass, OB_SELECTION_STRATEGY__RESOURCE);
		createEReference(obSelectionStrategyEClass, OB_SELECTION_STRATEGY__REF_REF_TYPE);
		createEReference(obSelectionStrategyEClass, OB_SELECTION_STRATEGY__REF_REF_REF_TYPE);

		randomSelectionEClass = createEClass(RANDOM_SELECTION);

		randomTypeSelectionEClass = createEClass(RANDOM_TYPE_SELECTION);

		specificObjectSelectionEClass = createEClass(SPECIFIC_OBJECT_SELECTION);
		createEReference(specificObjectSelectionEClass, SPECIFIC_OBJECT_SELECTION__OBJ_SEL);

		attributeScalarEClass = createEClass(ATTRIBUTE_SCALAR);
		createEReference(attributeScalarEClass, ATTRIBUTE_SCALAR__VALUE);

		attributeTypeEClass = createEClass(ATTRIBUTE_TYPE);
		createEAttribute(attributeTypeEClass, ATTRIBUTE_TYPE__OPERATOR);

		booleanTypeEClass = createEClass(BOOLEAN_TYPE);

		specificBooleanTypeEClass = createEClass(SPECIFIC_BOOLEAN_TYPE);
		createEAttribute(specificBooleanTypeEClass, SPECIFIC_BOOLEAN_TYPE__VALUE);

		randomBooleanTypeEClass = createEClass(RANDOM_BOOLEAN_TYPE);
		createEAttribute(randomBooleanTypeEClass, RANDOM_BOOLEAN_TYPE__ALLOWS_NULL);

		stringTypeEClass = createEClass(STRING_TYPE);

		specificStringTypeEClass = createEClass(SPECIFIC_STRING_TYPE);
		createEAttribute(specificStringTypeEClass, SPECIFIC_STRING_TYPE__VALUE);

		randomStringTypeEClass = createEClass(RANDOM_STRING_TYPE);
		createEAttribute(randomStringTypeEClass, RANDOM_STRING_TYPE__MIN);
		createEAttribute(randomStringTypeEClass, RANDOM_STRING_TYPE__MAX);
		createEAttribute(randomStringTypeEClass, RANDOM_STRING_TYPE__ALLOWS_NULL);

		integerTypeEClass = createEClass(INTEGER_TYPE);

		specificIntegerTypeEClass = createEClass(SPECIFIC_INTEGER_TYPE);
		createEAttribute(specificIntegerTypeEClass, SPECIFIC_INTEGER_TYPE__VALUE);

		randomIntegerTypeEClass = createEClass(RANDOM_INTEGER_TYPE);
		createEAttribute(randomIntegerTypeEClass, RANDOM_INTEGER_TYPE__MIN);
		createEAttribute(randomIntegerTypeEClass, RANDOM_INTEGER_TYPE__MAX);
		createEAttribute(randomIntegerTypeEClass, RANDOM_INTEGER_TYPE__ALLOWS_NULL);

		doubleTypeEClass = createEClass(DOUBLE_TYPE);

		specificDoubleTypeEClass = createEClass(SPECIFIC_DOUBLE_TYPE);
		createEAttribute(specificDoubleTypeEClass, SPECIFIC_DOUBLE_TYPE__VALUE);

		randomDoubleTypeEClass = createEClass(RANDOM_DOUBLE_TYPE);
		createEAttribute(randomDoubleTypeEClass, RANDOM_DOUBLE_TYPE__MIN);
		createEAttribute(randomDoubleTypeEClass, RANDOM_DOUBLE_TYPE__MAX);
		createEAttribute(randomDoubleTypeEClass, RANDOM_DOUBLE_TYPE__ALLOWS_NULL);

		modifySourceReferenceMutatorEClass = createEClass(MODIFY_SOURCE_REFERENCE_MUTATOR);
		createEReference(modifySourceReferenceMutatorEClass, MODIFY_SOURCE_REFERENCE_MUTATOR__REF_TYPE);
		createEReference(modifySourceReferenceMutatorEClass, MODIFY_SOURCE_REFERENCE_MUTATOR__SOURCE);
		createEReference(modifySourceReferenceMutatorEClass, MODIFY_SOURCE_REFERENCE_MUTATOR__NEW_SOURCE);

		specificSelectionEClass = createEClass(SPECIFIC_SELECTION);

		specificReferenceSelectionEClass = createEClass(SPECIFIC_REFERENCE_SELECTION);
		createEReference(specificReferenceSelectionEClass, SPECIFIC_REFERENCE_SELECTION__OBJ_SEL);

		modifyTargetReferenceMutatorEClass = createEClass(MODIFY_TARGET_REFERENCE_MUTATOR);
		createEReference(modifyTargetReferenceMutatorEClass, MODIFY_TARGET_REFERENCE_MUTATOR__REF_TYPE);
		createEReference(modifyTargetReferenceMutatorEClass, MODIFY_TARGET_REFERENCE_MUTATOR__SOURCE);
		createEReference(modifyTargetReferenceMutatorEClass, MODIFY_TARGET_REFERENCE_MUTATOR__NEW_TARGET);

		createReferenceMutatorEClass = createEClass(CREATE_REFERENCE_MUTATOR);
		createEReference(createReferenceMutatorEClass, CREATE_REFERENCE_MUTATOR__SOURCE);
		createEReference(createReferenceMutatorEClass, CREATE_REFERENCE_MUTATOR__TARGET);
		createEReference(createReferenceMutatorEClass, CREATE_REFERENCE_MUTATOR__REF_TYPE);

		removeObjectMutatorEClass = createEClass(REMOVE_OBJECT_MUTATOR);
		createEReference(removeObjectMutatorEClass, REMOVE_OBJECT_MUTATOR__OBJECT);
		createEReference(removeObjectMutatorEClass, REMOVE_OBJECT_MUTATOR__CONTAINER);

		removeReferenceMutatorEClass = createEClass(REMOVE_REFERENCE_MUTATOR);

		modifyInformationMutatorEClass = createEClass(MODIFY_INFORMATION_MUTATOR);
		createEReference(modifyInformationMutatorEClass, MODIFY_INFORMATION_MUTATOR__OBJECT);
		createEReference(modifyInformationMutatorEClass, MODIFY_INFORMATION_MUTATOR__ATTRIBUTES);
		createEReference(modifyInformationMutatorEClass, MODIFY_INFORMATION_MUTATOR__REFERENCES);

		upperStringTypeEClass = createEClass(UPPER_STRING_TYPE);
		createEAttribute(upperStringTypeEClass, UPPER_STRING_TYPE__VALUE);

		lowerStringTypeEClass = createEClass(LOWER_STRING_TYPE);
		createEAttribute(lowerStringTypeEClass, LOWER_STRING_TYPE__VALUE);

		listStringTypeEClass = createEClass(LIST_STRING_TYPE);
		createEAttribute(listStringTypeEClass, LIST_STRING_TYPE__VALUE);

		catStartStringTypeEClass = createEClass(CAT_START_STRING_TYPE);
		createEAttribute(catStartStringTypeEClass, CAT_START_STRING_TYPE__VALUE);

		catEndStringTypeEClass = createEClass(CAT_END_STRING_TYPE);
		createEAttribute(catEndStringTypeEClass, CAT_END_STRING_TYPE__VALUE);

		attributeUnsetEClass = createEClass(ATTRIBUTE_UNSET);

		attributeSetEClass = createEClass(ATTRIBUTE_SET);
		createEReference(attributeSetEClass, ATTRIBUTE_SET__ATTRIBUTE);

		attributeSwapEClass = createEClass(ATTRIBUTE_SWAP);
		createEReference(attributeSwapEClass, ATTRIBUTE_SWAP__OBJECT);

		replaceStringTypeEClass = createEClass(REPLACE_STRING_TYPE);
		createEAttribute(replaceStringTypeEClass, REPLACE_STRING_TYPE__OLDSTRING);
		createEAttribute(replaceStringTypeEClass, REPLACE_STRING_TYPE__NEWSTRING);

		attributeCopyEClass = createEClass(ATTRIBUTE_COPY);
		createEReference(attributeCopyEClass, ATTRIBUTE_COPY__OBJECT);

		removeRandomReferenceMutatorEClass = createEClass(REMOVE_RANDOM_REFERENCE_MUTATOR);
		createEReference(removeRandomReferenceMutatorEClass, REMOVE_RANDOM_REFERENCE_MUTATOR__REF_TYPE);

		removeSpecificReferenceMutatorEClass = createEClass(REMOVE_SPECIFIC_REFERENCE_MUTATOR);
		createEReference(removeSpecificReferenceMutatorEClass, REMOVE_SPECIFIC_REFERENCE_MUTATOR__REF_TYPE);
		createEReference(removeSpecificReferenceMutatorEClass, REMOVE_SPECIFIC_REFERENCE_MUTATOR__CONTAINER);

		completeSelectionEClass = createEClass(COMPLETE_SELECTION);

		completeTypeSelectionEClass = createEClass(COMPLETE_TYPE_SELECTION);

		removeCompleteReferenceMutatorEClass = createEClass(REMOVE_COMPLETE_REFERENCE_MUTATOR);
		createEReference(removeCompleteReferenceMutatorEClass, REMOVE_COMPLETE_REFERENCE_MUTATOR__REF_TYPE);

		sourceEClass = createEClass(SOURCE);
		createEAttribute(sourceEClass, SOURCE__PATH);

		otherSelectionEClass = createEClass(OTHER_SELECTION);

		otherTypeSelectionEClass = createEClass(OTHER_TYPE_SELECTION);

		selectObjectMutatorEClass = createEClass(SELECT_OBJECT_MUTATOR);
		createEReference(selectObjectMutatorEClass, SELECT_OBJECT_MUTATOR__CONTAINER);
		createEReference(selectObjectMutatorEClass, SELECT_OBJECT_MUTATOR__OBJECT);

		attributeEvaluationEClass = createEClass(ATTRIBUTE_EVALUATION);
		createEReference(attributeEvaluationEClass, ATTRIBUTE_EVALUATION__NAME);
		createEReference(attributeEvaluationEClass, ATTRIBUTE_EVALUATION__VALUE);

		attributeReverseEClass = createEClass(ATTRIBUTE_REVERSE);

		referenceSetEClass = createEClass(REFERENCE_SET);
		createEReference(referenceSetEClass, REFERENCE_SET__REFERENCE);
		createEReference(referenceSetEClass, REFERENCE_SET__OBJECT);

		referenceInitEClass = createEClass(REFERENCE_INIT);

		referenceAttEClass = createEClass(REFERENCE_ATT);
		createEReference(referenceAttEClass, REFERENCE_ATT__ATTRIBUTE);
		createEReference(referenceAttEClass, REFERENCE_ATT__VALUE);

		referenceEvaluationEClass = createEClass(REFERENCE_EVALUATION);
		createEReference(referenceEvaluationEClass, REFERENCE_EVALUATION__NAME);
		createEReference(referenceEvaluationEClass, REFERENCE_EVALUATION__REF_NAME);
		createEReference(referenceEvaluationEClass, REFERENCE_EVALUATION__REF_REF_NAME);
		createEAttribute(referenceEvaluationEClass, REFERENCE_EVALUATION__OPERATOR);
		createEReference(referenceEvaluationEClass, REFERENCE_EVALUATION__VALUE);
		createEReference(referenceEvaluationEClass, REFERENCE_EVALUATION__REF_TYPE);
		createEReference(referenceEvaluationEClass, REFERENCE_EVALUATION__ATT_NAME);
		createEReference(referenceEvaluationEClass, REFERENCE_EVALUATION__ATT_VALUE);
		createEAttribute(referenceEvaluationEClass, REFERENCE_EVALUATION__CONTAINER);
		createEAttribute(referenceEvaluationEClass, REFERENCE_EVALUATION__SELF);

		expressionEClass = createEClass(EXPRESSION);
		createEReference(expressionEClass, EXPRESSION__FIRST);
		createEReference(expressionEClass, EXPRESSION__OPERATOR);
		createEReference(expressionEClass, EXPRESSION__SECOND);

		referenceSwapEClass = createEClass(REFERENCE_SWAP);

		evaluationEClass = createEClass(EVALUATION);

		binaryOperatorEClass = createEClass(BINARY_OPERATOR);
		createEAttribute(binaryOperatorEClass, BINARY_OPERATOR__TYPE);

		blockEClass = createEClass(BLOCK);
		createEAttribute(blockEClass, BLOCK__NAME);
		createEReference(blockEClass, BLOCK__COMMANDS);
		createEReference(blockEClass, BLOCK__FROM);
		createEAttribute(blockEClass, BLOCK__REPEAT);
		createEAttribute(blockEClass, BLOCK__MIN);
		createEAttribute(blockEClass, BLOCK__MAX);
		createEAttribute(blockEClass, BLOCK__FIXED);
		createEAttribute(blockEClass, BLOCK__DESCRIPTION);

		constraintEClass = createEClass(CONSTRAINT);
		createEAttribute(constraintEClass, CONSTRAINT__ID);
		createEReference(constraintEClass, CONSTRAINT__TYPE);
		createEReference(constraintEClass, CONSTRAINT__EXPRESSIONS);
		createEAttribute(constraintEClass, CONSTRAINT__RULES);

		randomTypeEClass = createEClass(RANDOM_TYPE);

		cloneObjectMutatorEClass = createEClass(CLONE_OBJECT_MUTATOR);
		createEAttribute(cloneObjectMutatorEClass, CLONE_OBJECT_MUTATOR__CONTENTS);
		createEReference(cloneObjectMutatorEClass, CLONE_OBJECT_MUTATOR__OBJECT);
		createEReference(cloneObjectMutatorEClass, CLONE_OBJECT_MUTATOR__CONTAINER);
		createEReference(cloneObjectMutatorEClass, CLONE_OBJECT_MUTATOR__REF_TYPE);
		createEReference(cloneObjectMutatorEClass, CLONE_OBJECT_MUTATOR__ATTRIBUTES);
		createEReference(cloneObjectMutatorEClass, CLONE_OBJECT_MUTATOR__REFERENCES);

		listTypeEClass = createEClass(LIST_TYPE);
		createEReference(listTypeEClass, LIST_TYPE__VALUE);

		objectAttributeTypeEClass = createEClass(OBJECT_ATTRIBUTE_TYPE);
		createEReference(objectAttributeTypeEClass, OBJECT_ATTRIBUTE_TYPE__OBJ_SEL);
		createEReference(objectAttributeTypeEClass, OBJECT_ATTRIBUTE_TYPE__ATTRIBUTE);
		createEAttribute(objectAttributeTypeEClass, OBJECT_ATTRIBUTE_TYPE__OPERATOR);

		attributeEvaluationTypeEClass = createEClass(ATTRIBUTE_EVALUATION_TYPE);

		minValueTypeEClass = createEClass(MIN_VALUE_TYPE);
		createEReference(minValueTypeEClass, MIN_VALUE_TYPE__ATTRIBUTE);

		maxValueTypeEClass = createEClass(MAX_VALUE_TYPE);
		createEReference(maxValueTypeEClass, MAX_VALUE_TYPE__ATTRIBUTE);

		numberTypeEClass = createEClass(NUMBER_TYPE);

		attributeOperationEClass = createEClass(ATTRIBUTE_OPERATION);
		createEAttribute(attributeOperationEClass, ATTRIBUTE_OPERATION__OPERATOR);
		createEReference(attributeOperationEClass, ATTRIBUTE_OPERATION__VALUE);

		randomNumberTypeEClass = createEClass(RANDOM_NUMBER_TYPE);
		createEReference(randomNumberTypeEClass, RANDOM_NUMBER_TYPE__OBJECT);
		createEReference(randomNumberTypeEClass, RANDOM_NUMBER_TYPE__MAX);

		randomDoubleNumberTypeEClass = createEClass(RANDOM_DOUBLE_NUMBER_TYPE);
		createEAttribute(randomDoubleNumberTypeEClass, RANDOM_DOUBLE_NUMBER_TYPE__MIN);

		randomIntegerNumberTypeEClass = createEClass(RANDOM_INTEGER_NUMBER_TYPE);
		createEAttribute(randomIntegerNumberTypeEClass, RANDOM_INTEGER_NUMBER_TYPE__MIN);

		specificClosureSelectionEClass = createEClass(SPECIFIC_CLOSURE_SELECTION);
		createEReference(specificClosureSelectionEClass, SPECIFIC_CLOSURE_SELECTION__OBJ_SEL);

		selectSampleMutatorEClass = createEClass(SELECT_SAMPLE_MUTATOR);
		createEReference(selectSampleMutatorEClass, SELECT_SAMPLE_MUTATOR__OBJECT);
		createEAttribute(selectSampleMutatorEClass, SELECT_SAMPLE_MUTATOR__CLAUSE);
		createEReference(selectSampleMutatorEClass, SELECT_SAMPLE_MUTATOR__FEATURES);

		referenceAddEClass = createEClass(REFERENCE_ADD);

		referenceRemoveEClass = createEClass(REFERENCE_REMOVE);

		retypeObjectMutatorEClass = createEClass(RETYPE_OBJECT_MUTATOR);
		createEReference(retypeObjectMutatorEClass, RETYPE_OBJECT_MUTATOR__OBJECT);
		createEReference(retypeObjectMutatorEClass, RETYPE_OBJECT_MUTATOR__CONTAINER);
		createEReference(retypeObjectMutatorEClass, RETYPE_OBJECT_MUTATOR__REF_TYPE);
		createEReference(retypeObjectMutatorEClass, RETYPE_OBJECT_MUTATOR__ATTRIBUTES);
		createEReference(retypeObjectMutatorEClass, RETYPE_OBJECT_MUTATOR__REFERENCES);

		typedSelectionEClass = createEClass(TYPED_SELECTION);

		randomStringNumberTypeEClass = createEClass(RANDOM_STRING_NUMBER_TYPE);
		createEAttribute(randomStringNumberTypeEClass, RANDOM_STRING_NUMBER_TYPE__MIN);
		createEAttribute(randomStringNumberTypeEClass, RANDOM_STRING_NUMBER_TYPE__MAX);
		createEAttribute(randomStringNumberTypeEClass, RANDOM_STRING_NUMBER_TYPE__ALLOWS_NULL);

		resourceEClass = createEClass(RESOURCE);
		createEAttribute(resourceEClass, RESOURCE__NAME);
		createEReference(resourceEClass, RESOURCE__PATH);

		// Create enums
		logicOperatorEEnum = createEEnum(LOGIC_OPERATOR);
		operatorEEnum = createEEnum(OPERATOR);
		repeatEEnum = createEEnum(REPEAT);
		arithmeticOperatorEEnum = createEEnum(ARITHMETIC_OPERATOR);
		sampleClauseEEnum = createEEnum(SAMPLE_CLAUSE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized)
			return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		MiniOCLPackage theMiniOCLPackage = (MiniOCLPackage) EPackage.Registry.INSTANCE
				.getEPackage(MiniOCLPackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theMiniOCLPackage);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		libraryEClass.getESuperTypes().add(this.getDefinition());
		programEClass.getESuperTypes().add(this.getDefinition());
		mutatorEClass.getESuperTypes().add(this.getObjectEmitter());
		compositeMutatorEClass.getESuperTypes().add(this.getMutator());
		createObjectMutatorEClass.getESuperTypes().add(this.getMutator());
		obSelectionStrategyEClass.getESuperTypes().add(this.getObjectEmitter());
		randomSelectionEClass.getESuperTypes().add(this.getObSelectionStrategy());
		randomTypeSelectionEClass.getESuperTypes().add(this.getRandomSelection());
		specificObjectSelectionEClass.getESuperTypes().add(this.getSpecificSelection());
		attributeScalarEClass.getESuperTypes().add(this.getAttributeSet());
		attributeTypeEClass.getESuperTypes().add(this.getAttributeEvaluationType());
		booleanTypeEClass.getESuperTypes().add(this.getAttributeType());
		specificBooleanTypeEClass.getESuperTypes().add(this.getBooleanType());
		randomBooleanTypeEClass.getESuperTypes().add(this.getBooleanType());
		stringTypeEClass.getESuperTypes().add(this.getAttributeType());
		specificStringTypeEClass.getESuperTypes().add(this.getStringType());
		randomStringTypeEClass.getESuperTypes().add(this.getStringType());
		integerTypeEClass.getESuperTypes().add(this.getNumberType());
		specificIntegerTypeEClass.getESuperTypes().add(this.getIntegerType());
		randomIntegerTypeEClass.getESuperTypes().add(this.getIntegerType());
		doubleTypeEClass.getESuperTypes().add(this.getNumberType());
		specificDoubleTypeEClass.getESuperTypes().add(this.getDoubleType());
		randomDoubleTypeEClass.getESuperTypes().add(this.getDoubleType());
		modifySourceReferenceMutatorEClass.getESuperTypes().add(this.getMutator());
		specificSelectionEClass.getESuperTypes().add(this.getObSelectionStrategy());
		specificReferenceSelectionEClass.getESuperTypes().add(this.getSpecificSelection());
		modifyTargetReferenceMutatorEClass.getESuperTypes().add(this.getMutator());
		createReferenceMutatorEClass.getESuperTypes().add(this.getMutator());
		removeObjectMutatorEClass.getESuperTypes().add(this.getMutator());
		removeReferenceMutatorEClass.getESuperTypes().add(this.getMutator());
		modifyInformationMutatorEClass.getESuperTypes().add(this.getMutator());
		upperStringTypeEClass.getESuperTypes().add(this.getStringType());
		lowerStringTypeEClass.getESuperTypes().add(this.getStringType());
		listStringTypeEClass.getESuperTypes().add(this.getAttributeType());
		catStartStringTypeEClass.getESuperTypes().add(this.getStringType());
		catEndStringTypeEClass.getESuperTypes().add(this.getStringType());
		attributeUnsetEClass.getESuperTypes().add(this.getAttributeSet());
		attributeSwapEClass.getESuperTypes().add(this.getAttributeSet());
		replaceStringTypeEClass.getESuperTypes().add(this.getStringType());
		attributeCopyEClass.getESuperTypes().add(this.getAttributeSet());
		removeRandomReferenceMutatorEClass.getESuperTypes().add(this.getRemoveReferenceMutator());
		removeSpecificReferenceMutatorEClass.getESuperTypes().add(this.getRemoveReferenceMutator());
		completeSelectionEClass.getESuperTypes().add(this.getObSelectionStrategy());
		completeTypeSelectionEClass.getESuperTypes().add(this.getCompleteSelection());
		removeCompleteReferenceMutatorEClass.getESuperTypes().add(this.getRemoveReferenceMutator());
		otherSelectionEClass.getESuperTypes().add(this.getObSelectionStrategy());
		otherTypeSelectionEClass.getESuperTypes().add(this.getOtherSelection());
		selectObjectMutatorEClass.getESuperTypes().add(this.getMutator());
		attributeEvaluationEClass.getESuperTypes().add(this.getEvaluation());
		attributeReverseEClass.getESuperTypes().add(this.getAttributeSet());
		referenceInitEClass.getESuperTypes().add(this.getReferenceSet());
		referenceAttEClass.getESuperTypes().add(this.getReferenceSet());
		referenceEvaluationEClass.getESuperTypes().add(this.getEvaluation());
		referenceSwapEClass.getESuperTypes().add(this.getReferenceSet());
		randomTypeEClass.getESuperTypes().add(this.getAttributeType());
		cloneObjectMutatorEClass.getESuperTypes().add(this.getMutator());
		listTypeEClass.getESuperTypes().add(this.getAttributeType());
		objectAttributeTypeEClass.getESuperTypes().add(this.getAttributeEvaluationType());
		minValueTypeEClass.getESuperTypes().add(this.getNumberType());
		maxValueTypeEClass.getESuperTypes().add(this.getNumberType());
		numberTypeEClass.getESuperTypes().add(this.getAttributeType());
		attributeOperationEClass.getESuperTypes().add(this.getAttributeSet());
		randomNumberTypeEClass.getESuperTypes().add(this.getNumberType());
		randomDoubleNumberTypeEClass.getESuperTypes().add(this.getRandomNumberType());
		randomIntegerNumberTypeEClass.getESuperTypes().add(this.getRandomNumberType());
		specificClosureSelectionEClass.getESuperTypes().add(this.getSpecificSelection());
		selectSampleMutatorEClass.getESuperTypes().add(this.getMutator());
		referenceAddEClass.getESuperTypes().add(this.getReferenceSet());
		referenceRemoveEClass.getESuperTypes().add(this.getReferenceSet());
		retypeObjectMutatorEClass.getESuperTypes().add(this.getMutator());
		typedSelectionEClass.getESuperTypes().add(this.getObSelectionStrategy());
		randomStringNumberTypeEClass.getESuperTypes().add(this.getStringType());
		resourceEClass.getESuperTypes().add(this.getDefinition());

		// Initialize classes, features, and operations; add parameters
		initEClass(mutatorEnvironmentEClass, MutatorEnvironment.class, "MutatorEnvironment", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMutatorEnvironment_Definition(), this.getDefinition(), null, "definition", null, 0, 1,
				MutatorEnvironment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMutatorEnvironment_Commands(), this.getMutator(), null, "commands", null, 0, -1,
				MutatorEnvironment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMutatorEnvironment_Load(), this.getLoad(), null, "load", null, 0, -1,
				MutatorEnvironment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMutatorEnvironment_Blocks(), this.getBlock(), null, "blocks", null, 0, -1,
				MutatorEnvironment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMutatorEnvironment_Constraints(), this.getConstraint(), null, "constraints", null, 0, -1,
				MutatorEnvironment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(definitionEClass, Definition.class, "Definition", IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDefinition_Metamodel(), ecorePackage.getEString(), "metamodel", null, 0, 1, Definition.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(libraryEClass, Library.class, "Library", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(programEClass, Program.class, "Program", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getProgram_Output(), ecorePackage.getEString(), "output", null, 0, 1, Program.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProgram_Num(), ecorePackage.getEInt(), "num", null, 1, 1, Program.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProgram_Source(), this.getSource(), null, "source", null, 1, 1, Program.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEAttribute(getProgram_Description(), ecorePackage.getEString(), "description", null, 0, 1, Program.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getProgram_Exhaustive(), ecorePackage.getEBoolean(), "exhaustive", "false", 1, 1, Program.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getProgram_Resources(), this.getResource(), null, "resources", null, 0, -1, Program.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(objectEmitterEClass, ObjectEmitter.class, "ObjectEmitter", IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getObjectEmitter_Type(), ecorePackage.getEClass(), null, "type", null, 0, 1, ObjectEmitter.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getObjectEmitter_Name(), ecorePackage.getEString(), "name", null, 0, 1, ObjectEmitter.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getObjectEmitter_Types(), ecorePackage.getEClass(), null, "types", null, 0, -1,
				ObjectEmitter.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mutatorEClass, Mutator.class, "Mutator", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMutator_Min(), ecorePackage.getEInt(), "min", null, 1, 1, Mutator.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMutator_Max(), ecorePackage.getEInt(), "max", null, 1, 1, Mutator.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMutator_Fixed(), ecorePackage.getEInt(), "fixed", null, 1, 1, Mutator.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(compositeMutatorEClass, CompositeMutator.class, "CompositeMutator", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCompositeMutator_Commands(), this.getMutator(), null, "commands", null, 0, -1,
				CompositeMutator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);

		initEClass(loadEClass, Load.class, "Load", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLoad_File(), ecorePackage.getEString(), "file", null, 0, 1, Load.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(createObjectMutatorEClass, CreateObjectMutator.class, "CreateObjectMutator", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCreateObjectMutator_Container(), this.getObSelectionStrategy(), null, "container", null, 0, 1,
				CreateObjectMutator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCreateObjectMutator_Attributes(), this.getAttributeSet(), null, "attributes", null, 0, -1,
				CreateObjectMutator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCreateObjectMutator_References(), this.getReferenceSet(), null, "references", null, 0, -1,
				CreateObjectMutator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(obSelectionStrategyEClass, ObSelectionStrategy.class, "ObSelectionStrategy", IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getObSelectionStrategy_RefType(), ecorePackage.getEReference(), null, "refType", null, 0, 1,
				ObSelectionStrategy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getObSelectionStrategy_Expression(), this.getExpression(), null, "expression", null, 0, 1,
				ObSelectionStrategy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getObSelectionStrategy_Resource(), ecorePackage.getEString(), "resource", null, 0, 1,
				ObSelectionStrategy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getObSelectionStrategy_RefRefType(), ecorePackage.getEReference(), null, "refRefType", null, 0,
				1, ObSelectionStrategy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getObSelectionStrategy_RefRefRefType(), ecorePackage.getEReference(), null, "refRefRefType",
				null, 0, 1, ObSelectionStrategy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(randomSelectionEClass, RandomSelection.class, "RandomSelection", IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(randomTypeSelectionEClass, RandomTypeSelection.class, "RandomTypeSelection", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(specificObjectSelectionEClass, SpecificObjectSelection.class, "SpecificObjectSelection",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSpecificObjectSelection_ObjSel(), this.getObjectEmitter(), null, "objSel", null, 1, 1,
				SpecificObjectSelection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(attributeScalarEClass, AttributeScalar.class, "AttributeScalar", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAttributeScalar_Value(), this.getAttributeType(), null, "value", null, 1, 1,
				AttributeScalar.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(attributeTypeEClass, AttributeType.class, "AttributeType", IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAttributeType_Operator(), this.getOperator(), "operator", null, 1, 1, AttributeType.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(booleanTypeEClass, BooleanType.class, "BooleanType", IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(specificBooleanTypeEClass, SpecificBooleanType.class, "SpecificBooleanType", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSpecificBooleanType_Value(), ecorePackage.getEBoolean(), "value", null, 1, 1,
				SpecificBooleanType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(randomBooleanTypeEClass, RandomBooleanType.class, "RandomBooleanType", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRandomBooleanType_AllowsNull(), ecorePackage.getEBoolean(), "allowsNull", null, 1, 1,
				RandomBooleanType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(stringTypeEClass, StringType.class, "StringType", IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(specificStringTypeEClass, SpecificStringType.class, "SpecificStringType", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSpecificStringType_Value(), ecorePackage.getEString(), "value", null, 0, 1,
				SpecificStringType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(randomStringTypeEClass, RandomStringType.class, "RandomStringType", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRandomStringType_Min(), ecorePackage.getEInt(), "min", null, 1, 1, RandomStringType.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRandomStringType_Max(), ecorePackage.getEInt(), "max", null, 1, 1, RandomStringType.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRandomStringType_AllowsNull(), ecorePackage.getEBoolean(), "allowsNull", null, 1, 1,
				RandomStringType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(integerTypeEClass, IntegerType.class, "IntegerType", IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(specificIntegerTypeEClass, SpecificIntegerType.class, "SpecificIntegerType", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSpecificIntegerType_Value(), ecorePackage.getEInt(), "value", null, 1, 1,
				SpecificIntegerType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(randomIntegerTypeEClass, RandomIntegerType.class, "RandomIntegerType", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRandomIntegerType_Min(), ecorePackage.getEInt(), "min", null, 1, 1, RandomIntegerType.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRandomIntegerType_Max(), ecorePackage.getEInt(), "max", null, 1, 1, RandomIntegerType.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRandomIntegerType_AllowsNull(), ecorePackage.getEBoolean(), "allowsNull", null, 1, 1,
				RandomIntegerType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(doubleTypeEClass, DoubleType.class, "DoubleType", IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(specificDoubleTypeEClass, SpecificDoubleType.class, "SpecificDoubleType", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSpecificDoubleType_Value(), ecorePackage.getEDouble(), "value", null, 1, 1,
				SpecificDoubleType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(randomDoubleTypeEClass, RandomDoubleType.class, "RandomDoubleType", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRandomDoubleType_Min(), ecorePackage.getEDouble(), "min", null, 1, 1, RandomDoubleType.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRandomDoubleType_Max(), ecorePackage.getEDouble(), "max", null, 1, 1, RandomDoubleType.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRandomDoubleType_AllowsNull(), ecorePackage.getEBoolean(), "allowsNull", null, 1, 1,
				RandomDoubleType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(modifySourceReferenceMutatorEClass, ModifySourceReferenceMutator.class,
				"ModifySourceReferenceMutator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getModifySourceReferenceMutator_RefType(), ecorePackage.getEReference(), null, "refType", null,
				0, 1, ModifySourceReferenceMutator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModifySourceReferenceMutator_Source(), this.getObSelectionStrategy(), null, "source", null, 0,
				1, ModifySourceReferenceMutator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModifySourceReferenceMutator_NewSource(), this.getObSelectionStrategy(), null, "newSource",
				null, 0, 1, ModifySourceReferenceMutator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(specificSelectionEClass, SpecificSelection.class, "SpecificSelection", IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(specificReferenceSelectionEClass, SpecificReferenceSelection.class, "SpecificReferenceSelection",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSpecificReferenceSelection_ObjSel(), this.getObjectEmitter(), null, "objSel", null, 1, 1,
				SpecificReferenceSelection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(modifyTargetReferenceMutatorEClass, ModifyTargetReferenceMutator.class,
				"ModifyTargetReferenceMutator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getModifyTargetReferenceMutator_RefType(), ecorePackage.getEReference(), null, "refType", null,
				0, 1, ModifyTargetReferenceMutator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModifyTargetReferenceMutator_Source(), this.getObSelectionStrategy(), null, "source", null, 0,
				1, ModifyTargetReferenceMutator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModifyTargetReferenceMutator_NewTarget(), this.getObSelectionStrategy(), null, "newTarget",
				null, 0, 1, ModifyTargetReferenceMutator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(createReferenceMutatorEClass, CreateReferenceMutator.class, "CreateReferenceMutator", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCreateReferenceMutator_Source(), this.getObSelectionStrategy(), null, "source", null, 0, 1,
				CreateReferenceMutator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCreateReferenceMutator_Target(), this.getObSelectionStrategy(), null, "target", null, 0, 1,
				CreateReferenceMutator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCreateReferenceMutator_RefType(), ecorePackage.getEReference(), null, "refType", null, 0, 1,
				CreateReferenceMutator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(removeObjectMutatorEClass, RemoveObjectMutator.class, "RemoveObjectMutator", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRemoveObjectMutator_Object(), this.getObSelectionStrategy(), null, "object", null, 0, 1,
				RemoveObjectMutator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRemoveObjectMutator_Container(), this.getObSelectionStrategy(), null, "container", null, 0, 1,
				RemoveObjectMutator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(removeReferenceMutatorEClass, RemoveReferenceMutator.class, "RemoveReferenceMutator", IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(modifyInformationMutatorEClass, ModifyInformationMutator.class, "ModifyInformationMutator",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getModifyInformationMutator_Object(), this.getObSelectionStrategy(), null, "object", null, 0, 1,
				ModifyInformationMutator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModifyInformationMutator_Attributes(), this.getAttributeSet(), null, "attributes", null, 0,
				-1, ModifyInformationMutator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getModifyInformationMutator_References(), this.getReferenceSet(), null, "references", null, 0,
				-1, ModifyInformationMutator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(upperStringTypeEClass, UpperStringType.class, "UpperStringType", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getUpperStringType_Value(), ecorePackage.getEString(), "value", null, 0, 1,
				UpperStringType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(lowerStringTypeEClass, LowerStringType.class, "LowerStringType", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getLowerStringType_Value(), ecorePackage.getEString(), "value", null, 0, 1,
				LowerStringType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(listStringTypeEClass, ListStringType.class, "ListStringType", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getListStringType_Value(), ecorePackage.getEString(), "value", null, 0, -1, ListStringType.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(catStartStringTypeEClass, CatStartStringType.class, "CatStartStringType", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCatStartStringType_Value(), ecorePackage.getEString(), "value", null, 0, 1,
				CatStartStringType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(catEndStringTypeEClass, CatEndStringType.class, "CatEndStringType", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCatEndStringType_Value(), ecorePackage.getEString(), "value", null, 0, 1,
				CatEndStringType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(attributeUnsetEClass, AttributeUnset.class, "AttributeUnset", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(attributeSetEClass, AttributeSet.class, "AttributeSet", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAttributeSet_Attribute(), ecorePackage.getEAttribute(), null, "attribute", null, 0, -1,
				AttributeSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(attributeSwapEClass, AttributeSwap.class, "AttributeSwap", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAttributeSwap_Object(), this.getObSelectionStrategy(), null, "object", null, 0, 1,
				AttributeSwap.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(replaceStringTypeEClass, ReplaceStringType.class, "ReplaceStringType", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getReplaceStringType_Oldstring(), ecorePackage.getEString(), "oldstring", null, 0, 1,
				ReplaceStringType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEAttribute(getReplaceStringType_Newstring(), ecorePackage.getEString(), "newstring", null, 0, 1,
				ReplaceStringType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);

		initEClass(attributeCopyEClass, AttributeCopy.class, "AttributeCopy", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAttributeCopy_Object(), this.getObSelectionStrategy(), null, "object", null, 0, 1,
				AttributeCopy.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(removeRandomReferenceMutatorEClass, RemoveRandomReferenceMutator.class,
				"RemoveRandomReferenceMutator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRemoveRandomReferenceMutator_RefType(), ecorePackage.getEReference(), null, "refType", null,
				0, 1, RemoveRandomReferenceMutator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(removeSpecificReferenceMutatorEClass, RemoveSpecificReferenceMutator.class,
				"RemoveSpecificReferenceMutator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRemoveSpecificReferenceMutator_RefType(), ecorePackage.getEReference(), null, "refType", null,
				0, 1, RemoveSpecificReferenceMutator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRemoveSpecificReferenceMutator_Container(), this.getObSelectionStrategy(), null, "container",
				null, 0, 1, RemoveSpecificReferenceMutator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE,
				IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(completeSelectionEClass, CompleteSelection.class, "CompleteSelection", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(completeTypeSelectionEClass, CompleteTypeSelection.class, "CompleteTypeSelection", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(removeCompleteReferenceMutatorEClass, RemoveCompleteReferenceMutator.class,
				"RemoveCompleteReferenceMutator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRemoveCompleteReferenceMutator_RefType(), ecorePackage.getEReference(), null, "refType", null,
				0, 1, RemoveCompleteReferenceMutator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(sourceEClass, Source.class, "Source", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSource_Path(), ecorePackage.getEString(), "path", null, 1, 1, Source.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(otherSelectionEClass, OtherSelection.class, "OtherSelection", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(otherTypeSelectionEClass, OtherTypeSelection.class, "OtherTypeSelection", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(selectObjectMutatorEClass, SelectObjectMutator.class, "SelectObjectMutator", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSelectObjectMutator_Container(), this.getObSelectionStrategy(), null, "container", null, 0, 1,
				SelectObjectMutator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSelectObjectMutator_Object(), this.getObSelectionStrategy(), null, "object", null, 0, 1,
				SelectObjectMutator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(attributeEvaluationEClass, AttributeEvaluation.class, "AttributeEvaluation", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getAttributeEvaluation_Name(), ecorePackage.getEAttribute(), null, "name", null, 1, 1,
				AttributeEvaluation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getAttributeEvaluation_Value(), this.getAttributeEvaluationType(), null, "value", null, 1, 1,
				AttributeEvaluation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(attributeReverseEClass, AttributeReverse.class, "AttributeReverse", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(referenceSetEClass, ReferenceSet.class, "ReferenceSet", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReferenceSet_Reference(), ecorePackage.getEReference(), null, "reference", null, 0, -1,
				ReferenceSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getReferenceSet_Object(), this.getObSelectionStrategy(), null, "object", null, 0, 1,
				ReferenceSet.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(referenceInitEClass, ReferenceInit.class, "ReferenceInit", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(referenceAttEClass, ReferenceAtt.class, "ReferenceAtt", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReferenceAtt_Attribute(), ecorePackage.getEAttribute(), null, "attribute", null, 1, 1,
				ReferenceAtt.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getReferenceAtt_Value(), this.getAttributeType(), null, "value", null, 1, 1, ReferenceAtt.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(referenceEvaluationEClass, ReferenceEvaluation.class, "ReferenceEvaluation", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReferenceEvaluation_Name(), ecorePackage.getEReference(), null, "name", null, 0, 1,
				ReferenceEvaluation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getReferenceEvaluation_RefName(), ecorePackage.getEReference(), null, "refName", null, 0, 1,
				ReferenceEvaluation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getReferenceEvaluation_RefRefName(), ecorePackage.getEReference(), null, "refRefName", null, 0,
				1, ReferenceEvaluation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getReferenceEvaluation_Operator(), this.getOperator(), "operator", null, 0, 1,
				ReferenceEvaluation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getReferenceEvaluation_Value(), this.getObSelectionStrategy(), null, "value", null, 0, 1,
				ReferenceEvaluation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getReferenceEvaluation_RefType(), ecorePackage.getEReference(), null, "refType", null, 0, 1,
				ReferenceEvaluation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getReferenceEvaluation_AttName(), ecorePackage.getEAttribute(), null, "attName", null, 0, 1,
				ReferenceEvaluation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getReferenceEvaluation_AttValue(), this.getAttributeEvaluationType(), null, "attValue", null, 0,
				1, ReferenceEvaluation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getReferenceEvaluation_Container(), ecorePackage.getEBoolean(), "container", "false", 1, 1,
				ReferenceEvaluation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getReferenceEvaluation_Self(), ecorePackage.getEBoolean(), "self", "false", 1, 1,
				ReferenceEvaluation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(expressionEClass, Expression.class, "Expression", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getExpression_First(), this.getEvaluation(), null, "first", null, 1, 1, Expression.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExpression_Operator(), this.getBinaryOperator(), null, "operator", null, 0, -1,
				Expression.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getExpression_Second(), this.getEvaluation(), null, "second", null, 0, -1, Expression.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(referenceSwapEClass, ReferenceSwap.class, "ReferenceSwap", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(evaluationEClass, Evaluation.class, "Evaluation", IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(binaryOperatorEClass, BinaryOperator.class, "BinaryOperator", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBinaryOperator_Type(), this.getLogicOperator(), "type", null, 1, 1, BinaryOperator.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(blockEClass, Block.class, "Block", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getBlock_Name(), ecorePackage.getEString(), "name", null, 0, 1, Block.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBlock_Commands(), this.getMutator(), null, "commands", null, 0, -1, Block.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getBlock_From(), this.getBlock(), null, "from", null, 0, -1, Block.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);
		initEAttribute(getBlock_Repeat(), this.getRepeat(), "repeat", null, 1, 1, Block.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBlock_Min(), ecorePackage.getEInt(), "min", null, 1, 1, Block.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBlock_Max(), ecorePackage.getEInt(), "max", null, 1, 1, Block.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBlock_Fixed(), ecorePackage.getEInt(), "fixed", null, 1, 1, Block.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getBlock_Description(), ecorePackage.getEString(), "description", null, 0, 1, Block.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(constraintEClass, Constraint.class, "Constraint", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConstraint_Id(), ecorePackage.getEString(), "id", null, 1, 1, Constraint.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConstraint_Type(), ecorePackage.getEClass(), null, "type", null, 1, 1, Constraint.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConstraint_Expressions(), theMiniOCLPackage.getInvariantCS(), null, "expressions", null, 0,
				-1, Constraint.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, !IS_ORDERED);
		initEAttribute(getConstraint_Rules(), ecorePackage.getEString(), "rules", null, 0, -1, Constraint.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(randomTypeEClass, RandomType.class, "RandomType", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(cloneObjectMutatorEClass, CloneObjectMutator.class, "CloneObjectMutator", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCloneObjectMutator_Contents(), ecorePackage.getEBoolean(), "contents", "false", 1, 1,
				CloneObjectMutator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEReference(getCloneObjectMutator_Object(), this.getObSelectionStrategy(), null, "object", null, 0, 1,
				CloneObjectMutator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCloneObjectMutator_Container(), this.getObSelectionStrategy(), null, "container", null, 0, 1,
				CloneObjectMutator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCloneObjectMutator_RefType(), ecorePackage.getEReference(), null, "refType", null, 0, 1,
				CloneObjectMutator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCloneObjectMutator_Attributes(), this.getAttributeSet(), null, "attributes", null, 0, -1,
				CloneObjectMutator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCloneObjectMutator_References(), this.getReferenceSet(), null, "references", null, 0, -1,
				CloneObjectMutator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(listTypeEClass, ListType.class, "ListType", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getListType_Value(), ecorePackage.getEObject(), null, "value", null, 0, -1, ListType.class,
				!IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(objectAttributeTypeEClass, ObjectAttributeType.class, "ObjectAttributeType", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getObjectAttributeType_ObjSel(), this.getObjectEmitter(), null, "objSel", null, 1, 1,
				ObjectAttributeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getObjectAttributeType_Attribute(), ecorePackage.getEAttribute(), null, "attribute", null, 1, 1,
				ObjectAttributeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getObjectAttributeType_Operator(), this.getOperator(), "operator", null, 1, 1,
				ObjectAttributeType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(attributeEvaluationTypeEClass, AttributeEvaluationType.class, "AttributeEvaluationType", IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(minValueTypeEClass, MinValueType.class, "MinValueType", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMinValueType_Attribute(), ecorePackage.getEAttribute(), null, "attribute", null, 1, 1,
				MinValueType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(maxValueTypeEClass, MaxValueType.class, "MaxValueType", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getMaxValueType_Attribute(), ecorePackage.getEAttribute(), null, "attribute", null, 1, 1,
				MaxValueType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(numberTypeEClass, NumberType.class, "NumberType", IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(attributeOperationEClass, AttributeOperation.class, "AttributeOperation", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAttributeOperation_Operator(), this.getArithmeticOperator(), "operator", null, 1, 1,
				AttributeOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE,
				!IS_DERIVED, IS_ORDERED);
		initEReference(getAttributeOperation_Value(), this.getAttributeEvaluationType(), null, "value", null, 1, 1,
				AttributeOperation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(randomNumberTypeEClass, RandomNumberType.class, "RandomNumberType", IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRandomNumberType_Object(), this.getObSelectionStrategy(), null, "object", null, 0, 1,
				RandomNumberType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRandomNumberType_Max(), ecorePackage.getEAttribute(), null, "max", null, 1, 1,
				RandomNumberType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES,
				!IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(randomDoubleNumberTypeEClass, RandomDoubleNumberType.class, "RandomDoubleNumberType", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRandomDoubleNumberType_Min(), ecorePackage.getEDouble(), "min", null, 1, 1,
				RandomDoubleNumberType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(randomIntegerNumberTypeEClass, RandomIntegerNumberType.class, "RandomIntegerNumberType",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRandomIntegerNumberType_Min(), ecorePackage.getEInt(), "min", null, 1, 1,
				RandomIntegerNumberType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(specificClosureSelectionEClass, SpecificClosureSelection.class, "SpecificClosureSelection",
				!IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSpecificClosureSelection_ObjSel(), this.getObjectEmitter(), null, "objSel", null, 1, 1,
				SpecificClosureSelection.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(selectSampleMutatorEClass, SelectSampleMutator.class, "SelectSampleMutator", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSelectSampleMutator_Object(), this.getObSelectionStrategy(), null, "object", null, 1, 1,
				SelectSampleMutator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSelectSampleMutator_Clause(), this.getSampleClause(), "clause", null, 0, 1,
				SelectSampleMutator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSelectSampleMutator_Features(), ecorePackage.getEStructuralFeature(), null, "features", null,
				0, -1, SelectSampleMutator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(referenceAddEClass, ReferenceAdd.class, "ReferenceAdd", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(referenceRemoveEClass, ReferenceRemove.class, "ReferenceRemove", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(retypeObjectMutatorEClass, RetypeObjectMutator.class, "RetypeObjectMutator", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRetypeObjectMutator_Object(), this.getObSelectionStrategy(), null, "object", null, 0, 1,
				RetypeObjectMutator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRetypeObjectMutator_Container(), this.getObSelectionStrategy(), null, "container", null, 0, 1,
				RetypeObjectMutator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRetypeObjectMutator_RefType(), ecorePackage.getEReference(), null, "refType", null, 0, 1,
				RetypeObjectMutator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE,
				IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRetypeObjectMutator_Attributes(), this.getAttributeSet(), null, "attributes", null, 0, -1,
				RetypeObjectMutator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRetypeObjectMutator_References(), this.getReferenceSet(), null, "references", null, 0, -1,
				RetypeObjectMutator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE,
				!IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(typedSelectionEClass, TypedSelection.class, "TypedSelection", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);

		initEClass(randomStringNumberTypeEClass, RandomStringNumberType.class, "RandomStringNumberType", !IS_ABSTRACT,
				!IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRandomStringNumberType_Min(), ecorePackage.getEInt(), "min", null, 1, 1,
				RandomStringNumberType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRandomStringNumberType_Max(), ecorePackage.getEInt(), "max", null, 1, 1,
				RandomStringNumberType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRandomStringNumberType_AllowsNull(), ecorePackage.getEBoolean(), "allowsNull", null, 1, 1,
				RandomStringNumberType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID,
				IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(resourceEClass, Resource.class, "Resource", !IS_ABSTRACT, !IS_INTERFACE,
				IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getResource_Name(), ecorePackage.getEString(), "name", null, 0, 1, Resource.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getResource_Path(), this.getSource(), null, "path", null, 0, 1, Resource.class, !IS_TRANSIENT,
				!IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED,
				IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(logicOperatorEEnum, LogicOperator.class, "LogicOperator");
		addEEnumLiteral(logicOperatorEEnum, LogicOperator.AND);
		addEEnumLiteral(logicOperatorEEnum, LogicOperator.OR);

		initEEnum(operatorEEnum, Operator.class, "Operator");
		addEEnumLiteral(operatorEEnum, Operator.EQUALS);
		addEEnumLiteral(operatorEEnum, Operator.DIFFERENT);
		addEEnumLiteral(operatorEEnum, Operator.IN);
		addEEnumLiteral(operatorEEnum, Operator.IS);
		addEEnumLiteral(operatorEEnum, Operator.NOT);
		addEEnumLiteral(operatorEEnum, Operator.GT);
		addEEnumLiteral(operatorEEnum, Operator.GTE);
		addEEnumLiteral(operatorEEnum, Operator.LT);
		addEEnumLiteral(operatorEEnum, Operator.LTE);

		initEEnum(repeatEEnum, Repeat.class, "Repeat");
		addEEnumLiteral(repeatEEnum, Repeat.YES);
		addEEnumLiteral(repeatEEnum, Repeat.NO);

		initEEnum(arithmeticOperatorEEnum, ArithmeticOperator.class, "ArithmeticOperator");
		addEEnumLiteral(arithmeticOperatorEEnum, ArithmeticOperator.ADD);
		addEEnumLiteral(arithmeticOperatorEEnum, ArithmeticOperator.SUBTRACT);
		addEEnumLiteral(arithmeticOperatorEEnum, ArithmeticOperator.MULTIPLY);
		addEEnumLiteral(arithmeticOperatorEEnum, ArithmeticOperator.DIVIDE);
		addEEnumLiteral(arithmeticOperatorEEnum, ArithmeticOperator.MODULE);

		initEEnum(sampleClauseEEnum, SampleClause.class, "SampleClause");
		addEEnumLiteral(sampleClauseEEnum, SampleClause.EQUALS);
		addEEnumLiteral(sampleClauseEEnum, SampleClause.DISTINCT);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/OCL/Import
		createImportAnnotations();
		// http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName
		createEmofAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/OCL/Import</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createImportAnnotations() {
		String source = "http://www.eclipse.org/OCL/Import";
		addAnnotation(this, source, new String[] { "ecore", "http://www.eclipse.org/emf/2002/Ecore" });
	}

	/**
	 * Initializes the annotations for <b>http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createEmofAnnotations() {
		String source = "http://schema.omg.org/spec/MOF/2.0/emof.xml#Property.oppositeRoleName";
		addAnnotation(getCloneObjectMutator_Contents(), source,
				new String[] { "body", "ListType", "unique", "false", "upper", "*" });
		addAnnotation(getRandomIntegerNumberType_Min(), source,
				new String[] { "body", "SpecificClosureSelection", "unique", "false", "upper", "*" });
	}

} //MutatorenvironmentPackageImpl
