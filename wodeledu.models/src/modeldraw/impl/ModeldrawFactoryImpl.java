/**
 */
package modeldraw.impl;

import modeldraw.*;

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
public class ModeldrawFactoryImpl extends EFactoryImpl implements ModeldrawFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ModeldrawFactory init() {
		try {
			ModeldrawFactory theModeldrawFactory = (ModeldrawFactory)EPackage.Registry.INSTANCE.getEFactory(ModeldrawPackage.eNS_URI);
			if (theModeldrawFactory != null) {
				return theModeldrawFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ModeldrawFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModeldrawFactoryImpl() {
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
			case ModeldrawPackage.MUTATOR_DRAW: return createMutatorDraw();
			case ModeldrawPackage.MUTATOR_INSTANCE: return createMutatorInstance();
			case ModeldrawPackage.VALUED_FEATURE: return createValuedFeature();
			case ModeldrawPackage.NODE: return createNode();
			case ModeldrawPackage.EDGE: return createEdge();
			case ModeldrawPackage.LEVEL: return createLevel();
			case ModeldrawPackage.NODE_ENUMERATOR: return createNodeEnumerator();
			case ModeldrawPackage.ENUMERATOR: return createEnumerator();
			case ModeldrawPackage.INFORMATION: return createInformation();
			case ModeldrawPackage.CONTENT: return createContent();
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
			case ModeldrawPackage.DRAW_TYPE:
				return createDrawTypeFromString(eDataType, initialValue);
			case ModeldrawPackage.NODE_TYPE:
				return createNodeTypeFromString(eDataType, initialValue);
			case ModeldrawPackage.NODE_SHAPE:
				return createNodeShapeFromString(eDataType, initialValue);
			case ModeldrawPackage.NODE_COLOR:
				return createNodeColorFromString(eDataType, initialValue);
			case ModeldrawPackage.DECORATION:
				return createDecorationFromString(eDataType, initialValue);
			case ModeldrawPackage.NODE_STYLE:
				return createNodeStyleFromString(eDataType, initialValue);
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
			case ModeldrawPackage.DRAW_TYPE:
				return convertDrawTypeToString(eDataType, instanceValue);
			case ModeldrawPackage.NODE_TYPE:
				return convertNodeTypeToString(eDataType, instanceValue);
			case ModeldrawPackage.NODE_SHAPE:
				return convertNodeShapeToString(eDataType, instanceValue);
			case ModeldrawPackage.NODE_COLOR:
				return convertNodeColorToString(eDataType, instanceValue);
			case ModeldrawPackage.DECORATION:
				return convertDecorationToString(eDataType, instanceValue);
			case ModeldrawPackage.NODE_STYLE:
				return convertNodeStyleToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MutatorDraw createMutatorDraw() {
		MutatorDrawImpl mutatorDraw = new MutatorDrawImpl();
		return mutatorDraw;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MutatorInstance createMutatorInstance() {
		MutatorInstanceImpl mutatorInstance = new MutatorInstanceImpl();
		return mutatorInstance;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ValuedFeature createValuedFeature() {
		ValuedFeatureImpl valuedFeature = new ValuedFeatureImpl();
		return valuedFeature;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Node createNode() {
		NodeImpl node = new NodeImpl();
		return node;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Edge createEdge() {
		EdgeImpl edge = new EdgeImpl();
		return edge;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Level createLevel() {
		LevelImpl level = new LevelImpl();
		return level;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NodeEnumerator createNodeEnumerator() {
		NodeEnumeratorImpl nodeEnumerator = new NodeEnumeratorImpl();
		return nodeEnumerator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Enumerator createEnumerator() {
		EnumeratorImpl enumerator = new EnumeratorImpl();
		return enumerator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Information createInformation() {
		InformationImpl information = new InformationImpl();
		return information;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Content createContent() {
		ContentImpl content = new ContentImpl();
		return content;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DrawType createDrawTypeFromString(EDataType eDataType, String initialValue) {
		DrawType result = DrawType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDrawTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NodeType createNodeTypeFromString(EDataType eDataType, String initialValue) {
		NodeType result = NodeType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertNodeTypeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NodeShape createNodeShapeFromString(EDataType eDataType, String initialValue) {
		NodeShape result = NodeShape.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertNodeShapeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NodeColor createNodeColorFromString(EDataType eDataType, String initialValue) {
		NodeColor result = NodeColor.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertNodeColorToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Decoration createDecorationFromString(EDataType eDataType, String initialValue) {
		Decoration result = Decoration.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertDecorationToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NodeStyle createNodeStyleFromString(EDataType eDataType, String initialValue) {
		NodeStyle result = NodeStyle.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertNodeStyleToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModeldrawPackage getModeldrawPackage() {
		return (ModeldrawPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ModeldrawPackage getPackage() {
		return ModeldrawPackage.eINSTANCE;
	}

} //ModeldrawFactoryImpl
