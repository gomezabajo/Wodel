/**
 */
package modeldraw;

import org.eclipse.emf.ecore.EAttribute;
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
 *   <li>{@link modeldraw.Relation#getLabel <em>Label</em>}</li>
 *   <li>{@link modeldraw.Relation#getSrc_decoration <em>Src decoration</em>}</li>
 *   <li>{@link modeldraw.Relation#getSrc_label <em>Src label</em>}</li>
 *   <li>{@link modeldraw.Relation#getTar_decoration <em>Tar decoration</em>}</li>
 *   <li>{@link modeldraw.Relation#getTar_label <em>Tar label</em>}</li>
 * </ul>
 *
 * @see modeldraw.ModeldrawPackage#getRelation()
 * @model abstract="true"
 * @generated
 */
public interface Relation extends NamedItem {
	/**
	 * Returns the value of the '<em><b>Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reference</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reference</em>' reference.
	 * @see #setReference(EReference)
	 * @see modeldraw.ModeldrawPackage#getRelation_Reference()
	 * @model
	 * @generated
	 */
	EReference getReference();

	/**
	 * Sets the value of the '{@link modeldraw.Relation#getReference <em>Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reference</em>' reference.
	 * @see #getReference()
	 * @generated
	 */
	void setReference(EReference value);

	/**
	 * Returns the value of the '<em><b>Label</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Label</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Label</em>' reference.
	 * @see #setLabel(EAttribute)
	 * @see modeldraw.ModeldrawPackage#getRelation_Label()
	 * @model
	 * @generated
	 */
	EAttribute getLabel();

	/**
	 * Sets the value of the '{@link modeldraw.Relation#getLabel <em>Label</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Label</em>' reference.
	 * @see #getLabel()
	 * @generated
	 */
	void setLabel(EAttribute value);

	/**
	 * Returns the value of the '<em><b>Src decoration</b></em>' attribute.
	 * The literals are from the enumeration {@link modeldraw.Decoration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Src decoration</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
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
	 * <p>
	 * If the meaning of the '<em>Src label</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
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
	 * <p>
	 * If the meaning of the '<em>Tar decoration</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
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
	 * <p>
	 * If the meaning of the '<em>Tar label</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
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

} // Relation
