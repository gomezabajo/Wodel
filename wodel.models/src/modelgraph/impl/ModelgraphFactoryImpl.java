/**
 */
package modelgraph.impl;

import modelgraph.*;

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
public class ModelgraphFactoryImpl extends EFactoryImpl implements ModelgraphFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ModelgraphFactory init() {
		try {
			ModelgraphFactory theModelgraphFactory = (ModelgraphFactory)EPackage.Registry.INSTANCE.getEFactory(ModelgraphPackage.eNS_URI);
			if (theModelgraphFactory != null) {
				return theModelgraphFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ModelgraphFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelgraphFactoryImpl() {
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
			case ModelgraphPackage.MUTATOR_GRAPH: return createMutatorGraph();
			case ModelgraphPackage.BOOLEAN_ATTRIBUTE: return createBooleanAttribute();
			case ModelgraphPackage.NODE: return createNode();
			case ModelgraphPackage.EDGE: return createEdge();
			case ModelgraphPackage.LEVEL: return createLevel();
			case ModelgraphPackage.NODE_ENUMERATOR: return createNodeEnumerator();
			case ModelgraphPackage.ENUMERATOR: return createEnumerator();
			case ModelgraphPackage.INFORMATION: return createInformation();
			case ModelgraphPackage.CONTENT: return createContent();
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
			case ModelgraphPackage.GRAPH_TYPE:
				return createGraphTypeFromString(eDataType, initialValue);
			case ModelgraphPackage.NODE_TYPE:
				return createNodeTypeFromString(eDataType, initialValue);
			case ModelgraphPackage.NODE_SHAPE:
				return createNodeShapeFromString(eDataType, initialValue);
			case ModelgraphPackage.NODE_COLOR:
				return createNodeColorFromString(eDataType, initialValue);
			case ModelgraphPackage.DECORATION:
				return createDecorationFromString(eDataType, initialValue);
			case ModelgraphPackage.NODE_STYLE:
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
			case ModelgraphPackage.GRAPH_TYPE:
				return convertGraphTypeToString(eDataType, instanceValue);
			case ModelgraphPackage.NODE_TYPE:
				return convertNodeTypeToString(eDataType, instanceValue);
			case ModelgraphPackage.NODE_SHAPE:
				return convertNodeShapeToString(eDataType, instanceValue);
			case ModelgraphPackage.NODE_COLOR:
				return convertNodeColorToString(eDataType, instanceValue);
			case ModelgraphPackage.DECORATION:
				return convertDecorationToString(eDataType, instanceValue);
			case ModelgraphPackage.NODE_STYLE:
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
	public MutatorGraph createMutatorGraph() {
		MutatorGraphImpl mutatorGraph = new MutatorGraphImpl();
		return mutatorGraph;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BooleanAttribute createBooleanAttribute() {
		BooleanAttributeImpl booleanAttribute = new BooleanAttributeImpl();
		return booleanAttribute;
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
	public GraphType createGraphTypeFromString(EDataType eDataType, String initialValue) {
		GraphType result = GraphType.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertGraphTypeToString(EDataType eDataType, Object instanceValue) {
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
	public ModelgraphPackage getModelgraphPackage() {
		return (ModelgraphPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ModelgraphPackage getPackage() {
		return ModelgraphPackage.eINSTANCE;
	}

} //ModelgraphFactoryImpl
