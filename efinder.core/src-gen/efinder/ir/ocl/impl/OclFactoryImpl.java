/**
 */
package efinder.ir.ocl.impl;

import efinder.ir.ocl.*;

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
public class OclFactoryImpl extends EFactoryImpl implements OclFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static OclFactory init() {
		try {
			OclFactory theOclFactory = (OclFactory)EPackage.Registry.INSTANCE.getEFactory(OclPackage.eNS_URI);
			if (theOclFactory != null) {
				return theOclFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new OclFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OclFactoryImpl() {
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
			case OclPackage.OCL_INVARIANT: return createOclInvariant();
			case OclPackage.OCL_DERIVED_PROPERTY: return createOclDerivedProperty();
			case OclPackage.OCL_OPERATION: return createOclOperation();
			case OclPackage.MODEL_ELEMENT: return createModelElement();
			case OclPackage.OPERATION_CALL_EXP: return createOperationCallExp();
			case OclPackage.PROPERTY_CALL_EXP: return createPropertyCallExp();
			case OclPackage.COLLECTION_CALL_EXP: return createCollectionCallExp();
			case OclPackage.ITERATOR_EXP: return createIteratorExp();
			case OclPackage.ITERATE_EXP: return createIterateExp();
			case OclPackage.ITERATOR: return createIterator();
			case OclPackage.IF_EXP: return createIfExp();
			case OclPackage.LET_EXP: return createLetExp();
			case OclPackage.OPERATOR_CALL_EXP: return createOperatorCallExp();
			case OclPackage.VAR_EXP: return createVarExp();
			case OclPackage.BOOLEAN_LITERAL_EXP: return createBooleanLiteralExp();
			case OclPackage.STRING_LITERAL_EXP: return createStringLiteralExp();
			case OclPackage.INTEGER_LITERAL_EXP: return createIntegerLiteralExp();
			case OclPackage.REAL_LITERAL_EXP: return createRealLiteralExp();
			case OclPackage.OCL_UNDEFINED: return createOclUndefined();
			case OclPackage.OCL_INVALID: return createOclInvalid();
			case OclPackage.TUPLE_LITERAL_EXP: return createTupleLiteralExp();
			case OclPackage.TUPLE_PART: return createTuplePart();
			case OclPackage.ENUM_LITERAL_EXP: return createEnumLiteralExp();
			case OclPackage.SET_LITERAL_EXP: return createSetLiteralExp();
			case OclPackage.ORDERED_SET_LITERAL_EXP: return createOrderedSetLiteralExp();
			case OclPackage.SEQUENCE_LITERAL_EXP: return createSequenceLiteralExp();
			case OclPackage.BAG_LITERAL_EXP: return createBagLiteralExp();
			case OclPackage.UNSUPPORTED_EXP: return createUnsupportedExp();
			case OclPackage.OCL_ANY_LIB_ELEMENT: return createOclAnyLibElement();
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
			case OclPackage.OPERATOR_KIND:
				return createOperatorKindFromString(eDataType, initialValue);
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
			case OclPackage.OPERATOR_KIND:
				return convertOperatorKindToString(eDataType, instanceValue);
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
	public OclInvariant createOclInvariant() {
		OclInvariantImpl oclInvariant = new OclInvariantImpl();
		return oclInvariant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OclDerivedProperty createOclDerivedProperty() {
		OclDerivedPropertyImpl oclDerivedProperty = new OclDerivedPropertyImpl();
		return oclDerivedProperty;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OclOperation createOclOperation() {
		OclOperationImpl oclOperation = new OclOperationImpl();
		return oclOperation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ModelElement createModelElement() {
		ModelElementImpl modelElement = new ModelElementImpl();
		return modelElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OperationCallExp createOperationCallExp() {
		OperationCallExpImpl operationCallExp = new OperationCallExpImpl();
		return operationCallExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PropertyCallExp createPropertyCallExp() {
		PropertyCallExpImpl propertyCallExp = new PropertyCallExpImpl();
		return propertyCallExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CollectionCallExp createCollectionCallExp() {
		CollectionCallExpImpl collectionCallExp = new CollectionCallExpImpl();
		return collectionCallExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IteratorExp createIteratorExp() {
		IteratorExpImpl iteratorExp = new IteratorExpImpl();
		return iteratorExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IterateExp createIterateExp() {
		IterateExpImpl iterateExp = new IterateExpImpl();
		return iterateExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Iterator createIterator() {
		IteratorImpl iterator = new IteratorImpl();
		return iterator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfExp createIfExp() {
		IfExpImpl ifExp = new IfExpImpl();
		return ifExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LetExp createLetExp() {
		LetExpImpl letExp = new LetExpImpl();
		return letExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OperatorCallExp createOperatorCallExp() {
		OperatorCallExpImpl operatorCallExp = new OperatorCallExpImpl();
		return operatorCallExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public VarExp createVarExp() {
		VarExpImpl varExp = new VarExpImpl();
		return varExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BooleanLiteralExp createBooleanLiteralExp() {
		BooleanLiteralExpImpl booleanLiteralExp = new BooleanLiteralExpImpl();
		return booleanLiteralExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public StringLiteralExp createStringLiteralExp() {
		StringLiteralExpImpl stringLiteralExp = new StringLiteralExpImpl();
		return stringLiteralExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IntegerLiteralExp createIntegerLiteralExp() {
		IntegerLiteralExpImpl integerLiteralExp = new IntegerLiteralExpImpl();
		return integerLiteralExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public RealLiteralExp createRealLiteralExp() {
		RealLiteralExpImpl realLiteralExp = new RealLiteralExpImpl();
		return realLiteralExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OclUndefined createOclUndefined() {
		OclUndefinedImpl oclUndefined = new OclUndefinedImpl();
		return oclUndefined;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OclInvalid createOclInvalid() {
		OclInvalidImpl oclInvalid = new OclInvalidImpl();
		return oclInvalid;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TupleLiteralExp createTupleLiteralExp() {
		TupleLiteralExpImpl tupleLiteralExp = new TupleLiteralExpImpl();
		return tupleLiteralExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TuplePart createTuplePart() {
		TuplePartImpl tuplePart = new TuplePartImpl();
		return tuplePart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EnumLiteralExp createEnumLiteralExp() {
		EnumLiteralExpImpl enumLiteralExp = new EnumLiteralExpImpl();
		return enumLiteralExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SetLiteralExp createSetLiteralExp() {
		SetLiteralExpImpl setLiteralExp = new SetLiteralExpImpl();
		return setLiteralExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OrderedSetLiteralExp createOrderedSetLiteralExp() {
		OrderedSetLiteralExpImpl orderedSetLiteralExp = new OrderedSetLiteralExpImpl();
		return orderedSetLiteralExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SequenceLiteralExp createSequenceLiteralExp() {
		SequenceLiteralExpImpl sequenceLiteralExp = new SequenceLiteralExpImpl();
		return sequenceLiteralExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BagLiteralExp createBagLiteralExp() {
		BagLiteralExpImpl bagLiteralExp = new BagLiteralExpImpl();
		return bagLiteralExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public UnsupportedExp createUnsupportedExp() {
		UnsupportedExpImpl unsupportedExp = new UnsupportedExpImpl();
		return unsupportedExp;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OclAnyLibElement createOclAnyLibElement() {
		OclAnyLibElementImpl oclAnyLibElement = new OclAnyLibElementImpl();
		return oclAnyLibElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperatorKind createOperatorKindFromString(EDataType eDataType, String initialValue) {
		OperatorKind result = OperatorKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertOperatorKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OclPackage getOclPackage() {
		return (OclPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static OclPackage getPackage() {
		return OclPackage.eINSTANCE;
	}

} //OclFactoryImpl
