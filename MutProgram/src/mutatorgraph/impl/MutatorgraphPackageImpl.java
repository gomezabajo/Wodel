/**
 */
package mutatorgraph.impl;

import mutatorgraph.Edge;
import mutatorgraph.GraphType;
import mutatorgraph.Item;
import mutatorgraph.MutatorGraph;
import mutatorgraph.MutatorgraphFactory;
import mutatorgraph.MutatorgraphPackage;
import mutatorgraph.Negation;
import mutatorgraph.Node;
import mutatorgraph.NodeShape;
import mutatorgraph.NodeType;

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
public class MutatorgraphPackageImpl extends EPackageImpl implements MutatorgraphPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass itemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass mutatorGraphEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nodeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass edgeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum negationEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum graphTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum nodeTypeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum nodeShapeEEnum = null;

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
	 * @see mutatorgraph.MutatorgraphPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private MutatorgraphPackageImpl() {
		super(eNS_URI, MutatorgraphFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link MutatorgraphPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static MutatorgraphPackage init() {
		if (isInited) return (MutatorgraphPackage)EPackage.Registry.INSTANCE.getEPackage(MutatorgraphPackage.eNS_URI);

		// Obtain or create and register package
		MutatorgraphPackageImpl theMutatorgraphPackage = (MutatorgraphPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof MutatorgraphPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new MutatorgraphPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theMutatorgraphPackage.createPackageContents();

		// Initialize created meta-data
		theMutatorgraphPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theMutatorgraphPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(MutatorgraphPackage.eNS_URI, theMutatorgraphPackage);
		return theMutatorgraphPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getItem() {
		return itemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getItem_Name() {
		return (EReference)itemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getMutatorGraph() {
		return mutatorGraphEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMutatorGraph_Type() {
		return (EAttribute)mutatorGraphEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMutatorGraph_Nodes() {
		return (EReference)mutatorGraphEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getMutatorGraph_Edges() {
		return (EReference)mutatorGraphEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getMutatorGraph_Metamodel() {
		return (EAttribute)mutatorGraphEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNode() {
		return nodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNode_Negation() {
		return (EAttribute)nodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNode_Attribute() {
		return (EReference)nodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNode_Type() {
		return (EAttribute)nodeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getNode_Shape() {
		return (EAttribute)nodeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEdge() {
		return edgeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEdge_Source() {
		return (EReference)edgeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEdge_Target() {
		return (EReference)edgeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getEdge_Label() {
		return (EReference)edgeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getNegation() {
		return negationEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getGraphType() {
		return graphTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getNodeType() {
		return nodeTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getNodeShape() {
		return nodeShapeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MutatorgraphFactory getMutatorgraphFactory() {
		return (MutatorgraphFactory)getEFactoryInstance();
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
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		itemEClass = createEClass(ITEM);
		createEReference(itemEClass, ITEM__NAME);

		mutatorGraphEClass = createEClass(MUTATOR_GRAPH);
		createEAttribute(mutatorGraphEClass, MUTATOR_GRAPH__TYPE);
		createEReference(mutatorGraphEClass, MUTATOR_GRAPH__NODES);
		createEReference(mutatorGraphEClass, MUTATOR_GRAPH__EDGES);
		createEAttribute(mutatorGraphEClass, MUTATOR_GRAPH__METAMODEL);

		nodeEClass = createEClass(NODE);
		createEAttribute(nodeEClass, NODE__NEGATION);
		createEReference(nodeEClass, NODE__ATTRIBUTE);
		createEAttribute(nodeEClass, NODE__TYPE);
		createEAttribute(nodeEClass, NODE__SHAPE);

		edgeEClass = createEClass(EDGE);
		createEReference(edgeEClass, EDGE__SOURCE);
		createEReference(edgeEClass, EDGE__TARGET);
		createEReference(edgeEClass, EDGE__LABEL);

		// Create enums
		negationEEnum = createEEnum(NEGATION);
		graphTypeEEnum = createEEnum(GRAPH_TYPE);
		nodeTypeEEnum = createEEnum(NODE_TYPE);
		nodeShapeEEnum = createEEnum(NODE_SHAPE);
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
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		mutatorGraphEClass.getESuperTypes().add(this.getItem());
		nodeEClass.getESuperTypes().add(this.getItem());
		edgeEClass.getESuperTypes().add(this.getItem());

		// Initialize classes, features, and operations; add parameters
		initEClass(itemEClass, Item.class, "Item", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getItem_Name(), ecorePackage.getEClass(), null, "name", null, 0, 1, Item.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mutatorGraphEClass, MutatorGraph.class, "MutatorGraph", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMutatorGraph_Type(), this.getGraphType(), "type", null, 1, 1, MutatorGraph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMutatorGraph_Nodes(), this.getNode(), null, "nodes", null, 0, -1, MutatorGraph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMutatorGraph_Edges(), this.getEdge(), null, "edges", null, 0, -1, MutatorGraph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMutatorGraph_Metamodel(), ecorePackage.getEString(), "metamodel", null, 0, 1, MutatorGraph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(nodeEClass, Node.class, "Node", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getNode_Negation(), this.getNegation(), "negation", "yes", 0, 1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNode_Attribute(), ecorePackage.getEAttribute(), null, "attribute", null, 0, 1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNode_Type(), this.getNodeType(), "type", null, 1, 1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNode_Shape(), this.getNodeShape(), "shape", null, 0, 1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(edgeEClass, Edge.class, "Edge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEdge_Source(), ecorePackage.getEReference(), null, "source", null, 0, 1, Edge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEdge_Target(), ecorePackage.getEReference(), null, "target", null, 0, 1, Edge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEdge_Label(), ecorePackage.getEReference(), null, "label", null, 0, 1, Edge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(negationEEnum, Negation.class, "Negation");
		addEEnumLiteral(negationEEnum, Negation.NOT);
		addEEnumLiteral(negationEEnum, Negation.YES);

		initEEnum(graphTypeEEnum, GraphType.class, "GraphType");
		addEEnumLiteral(graphTypeEEnum, GraphType.DIAGRAM);

		initEEnum(nodeTypeEEnum, NodeType.class, "NodeType");
		addEEnumLiteral(nodeTypeEEnum, NodeType.NODE);
		addEEnumLiteral(nodeTypeEEnum, NodeType.MARKEDNODE);

		initEEnum(nodeShapeEEnum, NodeShape.class, "NodeShape");
		addEEnumLiteral(nodeShapeEEnum, NodeShape.CIRCLE);
		addEEnumLiteral(nodeShapeEEnum, NodeShape.DOUBLECIRCLE);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/OCL/Import
		createImportAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/OCL/Import</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createImportAnnotations() {
		String source = "http://www.eclipse.org/OCL/Import";	
		addAnnotation
		  (this, 
		   source, 
		   new String[] {
			 "ecore", "http://www.eclipse.org/emf/2002/Ecore"
		   });
	}

} //MutatorgraphPackageImpl
