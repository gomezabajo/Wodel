/**
 */
package modeldraw;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Relation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link modeldraw.Relation#getReference <em>Reference</em>}</li>
 *   <li>{@link modeldraw.Relation#getRefType <em>Ref Type</em>}</li>
 *   <li>{@link modeldraw.Relation#getLabel <em>Label</em>}</li>
 *   <li>{@link modeldraw.Relation#getSrc_decoration <em>Src decoration</em>}</li>
 *   <li>{@link modeldraw.Relation#getSrc_label <em>Src label</em>}</li>
 *   <li>{@link modeldraw.Relation#getTar_decoration <em>Tar decoration</em>}</li>
 *   <li>{@link modeldraw.Relation#getTar_label <em>Tar label</em>}</li>
 *   <li>{@link modeldraw.Relation#getFeature <em>Feature</em>}</li>
 *   <li>{@link modeldraw.Relation#getTargetNode <em>Target Node</em>}</li>
 *   <li>{@link modeldraw.Relation#getTargetFeature <em>Target Feature</em>}</li>
 * </ul>
 *
 * @see modeldraw.ModeldrawPackage#getRelation()
 * @model abstract="true"
 * @generated
 */
public interface Relation extends NamedItem {
	/**
	 * Returns the value of the '<em><b>Reference</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EReference}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reference</em>' reference list.
	 * @see modeldraw.ModeldrawPackage#getRelation_Reference()
	 * @model
	 * @generated
	 */
	EList<EReference> getReference();

	/**
	 * Returns the value of the '<em><b>Ref Type</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EReference}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ref Type</em>' reference list.
	 * @see modeldraw.ModeldrawPackage#getRelation_RefType()
	 * @model
	 * @generated
	 */
	EList<EReference> getRefType();

	/**
	 * Returns the value of the '<em><b>Label</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EAttribute}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Label</em>' reference list.
	 * @see modeldraw.ModeldrawPackage#getRelation_Label()
	 * @model
	 * @generated
	 */
	EList<EAttribute> getLabel();

	/**
	 * Returns the value of the '<em><b>Src decoration</b></em>' attribute.
	 * The literals are from the enumeration {@link modeldraw.Decoration}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Src decoration</em>' attribute.
	 * @see modeldraw.Decoration
	 * @see #setSrc_decoration(Decoration)
	 * @see modeldraw.ModeldrawPackage#getRelation_Src_decoration()
	 * @model
	 * @generated
	 */
	Decoration getSrc_decoration();

	/**
	 * Sets the value of the '{@link modeldraw.Relation#getSrc_decoration <em>Src decoration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Src decoration</em>' attribute.
	 * @see modeldraw.Decoration
	 * @see #getSrc_decoration()
	 * @generated
	 */
	void setSrc_decoration(Decoration value);

	/**
	 * Returns the value of the '<em><b>Src label</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Src label</em>' reference.
	 * @see #setSrc_label(EAttribute)
	 * @see modeldraw.ModeldrawPackage#getRelation_Src_label()
	 * @model
	 * @generated
	 */
	EAttribute getSrc_label();

	/**
	 * Sets the value of the '{@link modeldraw.Relation#getSrc_label <em>Src label</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Src label</em>' reference.
	 * @see #getSrc_label()
	 * @generated
	 */
	void setSrc_label(EAttribute value);

	/**
	 * Returns the value of the '<em><b>Tar decoration</b></em>' attribute.
	 * The literals are from the enumeration {@link modeldraw.Decoration}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tar decoration</em>' attribute.
	 * @see modeldraw.Decoration
	 * @see #setTar_decoration(Decoration)
	 * @see modeldraw.ModeldrawPackage#getRelation_Tar_decoration()
	 * @model
	 * @generated
	 */
	Decoration getTar_decoration();

	/**
	 * Sets the value of the '{@link modeldraw.Relation#getTar_decoration <em>Tar decoration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tar decoration</em>' attribute.
	 * @see modeldraw.Decoration
	 * @see #getTar_decoration()
	 * @generated
	 */
	void setTar_decoration(Decoration value);

	/**
	 * Returns the value of the '<em><b>Tar label</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Tar label</em>' reference.
	 * @see #setTar_label(EAttribute)
	 * @see modeldraw.ModeldrawPackage#getRelation_Tar_label()
	 * @model
	 * @generated
	 */
	EAttribute getTar_label();

	/**
	 * Sets the value of the '{@link modeldraw.Relation#getTar_label <em>Tar label</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Tar label</em>' reference.
	 * @see #getTar_label()
	 * @generated
	 */
	void setTar_label(EAttribute value);

	/**
	 * Returns the value of the '<em><b>Feature</b></em>' containment reference list.
	 * The list contents are of type {@link modeldraw.ValuedFeature}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature</em>' containment reference list.
	 * @see modeldraw.ModeldrawPackage#getRelation_Feature()
	 * @model containment="true"
	 * @generated
	 */
	EList<ValuedFeature> getFeature();

	/**
	 * Returns the value of the '<em><b>Target Node</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Node</em>' reference.
	 * @see #setTargetNode(EClass)
	 * @see modeldraw.ModeldrawPackage#getRelation_TargetNode()
	 * @model
	 * @generated
	 */
	EClass getTargetNode();

	/**
	 * Sets the value of the '{@link modeldraw.Relation#getTargetNode <em>Target Node</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target Node</em>' reference.
	 * @see #getTargetNode()
	 * @generated
	 */
	void setTargetNode(EClass value);

	/**
	 * Returns the value of the '<em><b>Target Feature</b></em>' containment reference list.
	 * The list contents are of type {@link modeldraw.ValuedFeature}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target Feature</em>' containment reference list.
	 * @see modeldraw.ModeldrawPackage#getRelation_TargetFeature()
	 * @model containment="true"
	 * @generated
	 */
	EList<ValuedFeature> getTargetFeature();

} // Relation
