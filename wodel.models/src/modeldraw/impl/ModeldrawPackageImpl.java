/**
 */
package modeldraw.impl;

import modeldraw.Content;
import modeldraw.Decoration;
import modeldraw.DrawType;
import modeldraw.Edge;
import modeldraw.Enumerator;
import modeldraw.Information;
import modeldraw.Item;
import modeldraw.Level;
import modeldraw.ModeldrawFactory;
import modeldraw.ModeldrawPackage;
import modeldraw.MutatorDraw;
import modeldraw.NamedItem;
import modeldraw.Node;
import modeldraw.NodeColor;
import modeldraw.NodeEnumerator;
import modeldraw.NodeShape;
import modeldraw.NodeStyle;
import modeldraw.NodeType;
import modeldraw.Relation;
import modeldraw.ValuedFeature;

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
public class ModeldrawPackageImpl extends EPackageImpl implements ModeldrawPackage {
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
	private EClass mutatorDrawEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass namedItemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass valuedFeatureEClass = null;

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
	private EClass relationEClass = null;

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
	private EClass levelEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nodeEnumeratorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass enumeratorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass informationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass contentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum drawTypeEEnum = null;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum nodeColorEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum decorationEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum nodeStyleEEnum = null;

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
	 * @see modeldraw.ModeldrawPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ModeldrawPackageImpl() {
		super(eNS_URI, ModeldrawFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link ModeldrawPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ModeldrawPackage init() {
		if (isInited) return (ModeldrawPackage)EPackage.Registry.INSTANCE.getEPackage(ModeldrawPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredModeldrawPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		ModeldrawPackageImpl theModeldrawPackage = registeredModeldrawPackage instanceof ModeldrawPackageImpl ? (ModeldrawPackageImpl)registeredModeldrawPackage : new ModeldrawPackageImpl();

		isInited = true;

		// Create package meta-data objects
		theModeldrawPackage.createPackageContents();

		// Initialize created meta-data
		theModeldrawPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theModeldrawPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ModeldrawPackage.eNS_URI, theModeldrawPackage);
		return theModeldrawPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getItem() {
		return itemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getItem_Name() {
		return (EReference)itemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getMutatorDraw() {
		return mutatorDrawEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMutatorDraw_Type() {
		return (EAttribute)mutatorDrawEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMutatorDraw_Nodes() {
		return (EReference)mutatorDrawEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMutatorDraw_Relations() {
		return (EReference)mutatorDrawEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getMutatorDraw_Contents() {
		return (EReference)mutatorDrawEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getMutatorDraw_Metamodel() {
		return (EAttribute)mutatorDrawEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getNamedItem() {
		return namedItemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNamedItem_AttName() {
		return (EReference)namedItemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getValuedFeature() {
		return valuedFeatureEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getValuedFeature_Negation() {
		return (EAttribute)valuedFeatureEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getValuedFeature_Feat() {
		return (EReference)valuedFeatureEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getValuedFeature_RefFeature() {
		return (EReference)valuedFeatureEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getValuedFeature_Value() {
		return (EAttribute)valuedFeatureEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getNode() {
		return nodeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNode_Feature() {
		return (EReference)nodeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNode_Reference() {
		return (EReference)nodeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getNode_Type() {
		return (EAttribute)nodeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getNode_Shape() {
		return (EAttribute)nodeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getNode_Color() {
		return (EAttribute)nodeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getNode_Style() {
		return (EAttribute)nodeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getNode_PathShape() {
		return (EAttribute)nodeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNode_TargetNode() {
		return (EReference)nodeEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNode_TargetFeature() {
		return (EReference)nodeEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRelation() {
		return relationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelation_Reference() {
		return (EReference)relationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelation_RefType() {
		return (EReference)relationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelation_Label() {
		return (EReference)relationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRelation_Src_decoration() {
		return (EAttribute)relationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelation_Src_label() {
		return (EReference)relationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRelation_Tar_decoration() {
		return (EAttribute)relationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelation_Tar_label() {
		return (EReference)relationEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelation_Feature() {
		return (EReference)relationEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelation_TargetNode() {
		return (EReference)relationEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getRelation_TargetFeature() {
		return (EReference)relationEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEdge() {
		return edgeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEdge_Source() {
		return (EReference)edgeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEdge_Target() {
		return (EReference)edgeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getLevel() {
		return levelEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getLevel_Upper() {
		return (EReference)levelEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getNodeEnumerator() {
		return nodeEnumeratorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNodeEnumerator_Att() {
		return (EReference)nodeEnumeratorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getNodeEnumerator_Enumerator() {
		return (EReference)nodeEnumeratorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getEnumerator() {
		return enumeratorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getEnumerator_Literal() {
		return (EReference)enumeratorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getEnumerator_Value() {
		return (EAttribute)enumeratorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getInformation() {
		return informationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getInformation_Type() {
		return (EReference)informationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getInformation_Att() {
		return (EReference)informationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getContent() {
		return contentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getContent_Nodenum() {
		return (EReference)contentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getContent_Info() {
		return (EReference)contentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getContent_Symbol() {
		return (EAttribute)contentEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getDrawType() {
		return drawTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getNodeType() {
		return nodeTypeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getNodeShape() {
		return nodeShapeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getNodeColor() {
		return nodeColorEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getDecoration() {
		return decorationEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getNodeStyle() {
		return nodeStyleEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ModeldrawFactory getModeldrawFactory() {
		return (ModeldrawFactory)getEFactoryInstance();
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

		mutatorDrawEClass = createEClass(MUTATOR_DRAW);
		createEAttribute(mutatorDrawEClass, MUTATOR_DRAW__TYPE);
		createEReference(mutatorDrawEClass, MUTATOR_DRAW__NODES);
		createEReference(mutatorDrawEClass, MUTATOR_DRAW__RELATIONS);
		createEReference(mutatorDrawEClass, MUTATOR_DRAW__CONTENTS);
		createEAttribute(mutatorDrawEClass, MUTATOR_DRAW__METAMODEL);

		namedItemEClass = createEClass(NAMED_ITEM);
		createEReference(namedItemEClass, NAMED_ITEM__ATT_NAME);

		valuedFeatureEClass = createEClass(VALUED_FEATURE);
		createEAttribute(valuedFeatureEClass, VALUED_FEATURE__NEGATION);
		createEReference(valuedFeatureEClass, VALUED_FEATURE__FEAT);
		createEReference(valuedFeatureEClass, VALUED_FEATURE__REF_FEATURE);
		createEAttribute(valuedFeatureEClass, VALUED_FEATURE__VALUE);

		nodeEClass = createEClass(NODE);
		createEReference(nodeEClass, NODE__FEATURE);
		createEReference(nodeEClass, NODE__REFERENCE);
		createEAttribute(nodeEClass, NODE__TYPE);
		createEAttribute(nodeEClass, NODE__SHAPE);
		createEAttribute(nodeEClass, NODE__COLOR);
		createEAttribute(nodeEClass, NODE__STYLE);
		createEAttribute(nodeEClass, NODE__PATH_SHAPE);
		createEReference(nodeEClass, NODE__TARGET_NODE);
		createEReference(nodeEClass, NODE__TARGET_FEATURE);

		relationEClass = createEClass(RELATION);
		createEReference(relationEClass, RELATION__REFERENCE);
		createEReference(relationEClass, RELATION__REF_TYPE);
		createEReference(relationEClass, RELATION__LABEL);
		createEAttribute(relationEClass, RELATION__SRC_DECORATION);
		createEReference(relationEClass, RELATION__SRC_LABEL);
		createEAttribute(relationEClass, RELATION__TAR_DECORATION);
		createEReference(relationEClass, RELATION__TAR_LABEL);
		createEReference(relationEClass, RELATION__FEATURE);
		createEReference(relationEClass, RELATION__TARGET_NODE);
		createEReference(relationEClass, RELATION__TARGET_FEATURE);

		edgeEClass = createEClass(EDGE);
		createEReference(edgeEClass, EDGE__SOURCE);
		createEReference(edgeEClass, EDGE__TARGET);

		levelEClass = createEClass(LEVEL);
		createEReference(levelEClass, LEVEL__UPPER);

		nodeEnumeratorEClass = createEClass(NODE_ENUMERATOR);
		createEReference(nodeEnumeratorEClass, NODE_ENUMERATOR__ATT);
		createEReference(nodeEnumeratorEClass, NODE_ENUMERATOR__ENUMERATOR);

		enumeratorEClass = createEClass(ENUMERATOR);
		createEReference(enumeratorEClass, ENUMERATOR__LITERAL);
		createEAttribute(enumeratorEClass, ENUMERATOR__VALUE);

		informationEClass = createEClass(INFORMATION);
		createEReference(informationEClass, INFORMATION__TYPE);
		createEReference(informationEClass, INFORMATION__ATT);

		contentEClass = createEClass(CONTENT);
		createEReference(contentEClass, CONTENT__NODENUM);
		createEReference(contentEClass, CONTENT__INFO);
		createEAttribute(contentEClass, CONTENT__SYMBOL);

		// Create enums
		drawTypeEEnum = createEEnum(DRAW_TYPE);
		nodeTypeEEnum = createEEnum(NODE_TYPE);
		nodeShapeEEnum = createEEnum(NODE_SHAPE);
		nodeColorEEnum = createEEnum(NODE_COLOR);
		decorationEEnum = createEEnum(DECORATION);
		nodeStyleEEnum = createEEnum(NODE_STYLE);
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
		mutatorDrawEClass.getESuperTypes().add(this.getItem());
		namedItemEClass.getESuperTypes().add(this.getItem());
		valuedFeatureEClass.getESuperTypes().add(this.getItem());
		nodeEClass.getESuperTypes().add(this.getNamedItem());
		relationEClass.getESuperTypes().add(this.getNamedItem());
		edgeEClass.getESuperTypes().add(this.getRelation());
		levelEClass.getESuperTypes().add(this.getRelation());
		nodeEnumeratorEClass.getESuperTypes().add(this.getItem());
		informationEClass.getESuperTypes().add(this.getItem());
		contentEClass.getESuperTypes().add(this.getNamedItem());

		// Initialize classes, features, and operations; add parameters
		initEClass(itemEClass, Item.class, "Item", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getItem_Name(), ecorePackage.getEClass(), null, "name", null, 0, 1, Item.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(mutatorDrawEClass, MutatorDraw.class, "MutatorDraw", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getMutatorDraw_Type(), this.getDrawType(), "type", null, 1, 1, MutatorDraw.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMutatorDraw_Nodes(), this.getNode(), null, "nodes", null, 0, -1, MutatorDraw.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMutatorDraw_Relations(), this.getRelation(), null, "relations", null, 0, -1, MutatorDraw.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getMutatorDraw_Contents(), this.getContent(), null, "contents", null, 0, -1, MutatorDraw.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getMutatorDraw_Metamodel(), ecorePackage.getEString(), "metamodel", null, 0, 1, MutatorDraw.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(namedItemEClass, NamedItem.class, "NamedItem", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNamedItem_AttName(), ecorePackage.getEAttribute(), null, "attName", null, 0, 1, NamedItem.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(valuedFeatureEClass, ValuedFeature.class, "ValuedFeature", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getValuedFeature_Negation(), ecorePackage.getEBoolean(), "negation", "false", 0, 1, ValuedFeature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getValuedFeature_Feat(), ecorePackage.getEStructuralFeature(), null, "feat", null, 1, 1, ValuedFeature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getValuedFeature_RefFeature(), ecorePackage.getEStructuralFeature(), null, "refFeature", null, 0, 1, ValuedFeature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getValuedFeature_Value(), ecorePackage.getEString(), "value", null, 0, 1, ValuedFeature.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(nodeEClass, Node.class, "Node", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNode_Feature(), this.getValuedFeature(), null, "feature", null, 0, -1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNode_Reference(), ecorePackage.getEReference(), null, "reference", null, 0, -1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNode_Type(), this.getNodeType(), "type", null, 1, 1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNode_Shape(), this.getNodeShape(), "shape", null, 0, 1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNode_Color(), this.getNodeColor(), "color", null, 0, 1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNode_Style(), this.getNodeStyle(), "style", null, 0, 1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getNode_PathShape(), ecorePackage.getEString(), "pathShape", null, 0, 1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNode_TargetNode(), ecorePackage.getEClass(), null, "targetNode", null, 0, 1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNode_TargetFeature(), this.getValuedFeature(), null, "targetFeature", null, 0, -1, Node.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(relationEClass, Relation.class, "Relation", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getRelation_Reference(), ecorePackage.getEReference(), null, "reference", null, 0, -1, Relation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelation_RefType(), ecorePackage.getEReference(), null, "refType", null, 0, -1, Relation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelation_Label(), ecorePackage.getEAttribute(), null, "label", null, 0, -1, Relation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRelation_Src_decoration(), this.getDecoration(), "src_decoration", null, 0, 1, Relation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelation_Src_label(), ecorePackage.getEAttribute(), null, "src_label", null, 0, 1, Relation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRelation_Tar_decoration(), this.getDecoration(), "tar_decoration", null, 0, 1, Relation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelation_Tar_label(), ecorePackage.getEAttribute(), null, "tar_label", null, 0, 1, Relation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelation_Feature(), this.getValuedFeature(), null, "feature", null, 0, -1, Relation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelation_TargetNode(), ecorePackage.getEClass(), null, "targetNode", null, 0, 1, Relation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRelation_TargetFeature(), this.getValuedFeature(), null, "targetFeature", null, 0, -1, Relation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(edgeEClass, Edge.class, "Edge", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEdge_Source(), ecorePackage.getEReference(), null, "source", null, 0, 1, Edge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getEdge_Target(), ecorePackage.getEReference(), null, "target", null, 0, 1, Edge.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(levelEClass, Level.class, "Level", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getLevel_Upper(), ecorePackage.getEReference(), null, "upper", null, 0, 1, Level.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(nodeEnumeratorEClass, NodeEnumerator.class, "NodeEnumerator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNodeEnumerator_Att(), ecorePackage.getEAttribute(), null, "att", null, 1, 1, NodeEnumerator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getNodeEnumerator_Enumerator(), this.getEnumerator(), null, "enumerator", null, 0, -1, NodeEnumerator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(enumeratorEClass, Enumerator.class, "Enumerator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getEnumerator_Literal(), ecorePackage.getEEnumLiteral(), null, "literal", null, 1, 1, Enumerator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getEnumerator_Value(), ecorePackage.getEString(), "value", null, 0, 1, Enumerator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(informationEClass, Information.class, "Information", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getInformation_Type(), ecorePackage.getEReference(), null, "type", null, 1, 1, Information.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getInformation_Att(), ecorePackage.getEAttribute(), null, "att", null, 0, 1, Information.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(contentEClass, Content.class, "Content", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getContent_Nodenum(), this.getNodeEnumerator(), null, "nodenum", null, 0, -1, Content.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getContent_Info(), this.getInformation(), null, "info", null, 0, -1, Content.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getContent_Symbol(), ecorePackage.getEString(), "symbol", null, 0, 1, Content.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(drawTypeEEnum, DrawType.class, "DrawType");
		addEEnumLiteral(drawTypeEEnum, DrawType.DIAGRAM);

		initEEnum(nodeTypeEEnum, NodeType.class, "NodeType");
		addEEnumLiteral(nodeTypeEEnum, NodeType.NODE);
		addEEnumLiteral(nodeTypeEEnum, NodeType.MARKEDNODE);

		initEEnum(nodeShapeEEnum, NodeShape.class, "NodeShape");
		addEEnumLiteral(nodeShapeEEnum, NodeShape.CIRCLE);
		addEEnumLiteral(nodeShapeEEnum, NodeShape.DOUBLECIRCLE);
		addEEnumLiteral(nodeShapeEEnum, NodeShape.RECORD);
		addEEnumLiteral(nodeShapeEEnum, NodeShape.LOAD);
		addEEnumLiteral(nodeShapeEEnum, NodeShape.LOGIC);

		initEEnum(nodeColorEEnum, NodeColor.class, "NodeColor");
		addEEnumLiteral(nodeColorEEnum, NodeColor.GRAY95);

		initEEnum(decorationEEnum, Decoration.class, "Decoration");
		addEEnumLiteral(decorationEEnum, Decoration.NONE);
		addEEnumLiteral(decorationEEnum, Decoration.TRIANGLE);
		addEEnumLiteral(decorationEEnum, Decoration.DIAMOND);
		addEEnumLiteral(decorationEEnum, Decoration.ODIAMOND);
		addEEnumLiteral(decorationEEnum, Decoration.OPEN);
		addEEnumLiteral(decorationEEnum, Decoration.EMPTY);

		initEEnum(nodeStyleEEnum, NodeStyle.class, "NodeStyle");
		addEEnumLiteral(nodeStyleEEnum, NodeStyle.NONE);
		addEEnumLiteral(nodeStyleEEnum, NodeStyle.ITALIC);
		addEEnumLiteral(nodeStyleEEnum, NodeStyle.UNDERLINE);

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

} //ModeldrawPackageImpl
