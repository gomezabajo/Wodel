/**
 */
package modeldraw.impl;

import java.util.Collection;
import modeldraw.Decoration;
import modeldraw.ModeldrawPackage;
import modeldraw.Relation;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Relation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link modeldraw.impl.RelationImpl#getReference <em>Reference</em>}</li>
 *   <li>{@link modeldraw.impl.RelationImpl#getRefType <em>Ref Type</em>}</li>
 *   <li>{@link modeldraw.impl.RelationImpl#getLabel <em>Label</em>}</li>
 *   <li>{@link modeldraw.impl.RelationImpl#getSrc_decoration <em>Src decoration</em>}</li>
 *   <li>{@link modeldraw.impl.RelationImpl#getSrc_label <em>Src label</em>}</li>
 *   <li>{@link modeldraw.impl.RelationImpl#getTar_decoration <em>Tar decoration</em>}</li>
 *   <li>{@link modeldraw.impl.RelationImpl#getTar_label <em>Tar label</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class RelationImpl extends NamedItemImpl implements Relation {
	/**
	 * The cached value of the '{@link #getReference() <em>Reference</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReference()
	 * @generated
	 * @ordered
	 */
	protected EList<EReference> reference;

	/**
	 * The cached value of the '{@link #getRefType() <em>Ref Type</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRefType()
	 * @generated
	 * @ordered
	 */
	protected EList<EReference> refType;

	/**
	 * The cached value of the '{@link #getLabel() <em>Label</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected EList<EAttribute> label;

	/**
	 * The default value of the '{@link #getSrc_decoration() <em>Src decoration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSrc_decoration()
	 * @generated
	 * @ordered
	 */
	protected static final Decoration SRC_DECORATION_EDEFAULT = Decoration.NONE;

	/**
	 * The cached value of the '{@link #getSrc_decoration() <em>Src decoration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSrc_decoration()
	 * @generated
	 * @ordered
	 */
	protected Decoration src_decoration = SRC_DECORATION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSrc_label() <em>Src label</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSrc_label()
	 * @generated
	 * @ordered
	 */
	protected EAttribute src_label;

	/**
	 * The default value of the '{@link #getTar_decoration() <em>Tar decoration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTar_decoration()
	 * @generated
	 * @ordered
	 */
	protected static final Decoration TAR_DECORATION_EDEFAULT = Decoration.NONE;

	/**
	 * The cached value of the '{@link #getTar_decoration() <em>Tar decoration</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTar_decoration()
	 * @generated
	 * @ordered
	 */
	protected Decoration tar_decoration = TAR_DECORATION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTar_label() <em>Tar label</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTar_label()
	 * @generated
	 * @ordered
	 */
	protected EAttribute tar_label;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RelationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModeldrawPackage.Literals.RELATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EReference> getReference() {
		if (reference == null) {
			reference = new EObjectResolvingEList<EReference>(EReference.class, this, ModeldrawPackage.RELATION__REFERENCE);
		}
		return reference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EReference> getRefType() {
		if (refType == null) {
			refType = new EObjectResolvingEList<EReference>(EReference.class, this, ModeldrawPackage.RELATION__REF_TYPE);
		}
		return refType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EAttribute> getLabel() {
		if (label == null) {
			label = new EObjectResolvingEList<EAttribute>(EAttribute.class, this, ModeldrawPackage.RELATION__LABEL);
		}
		return label;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Decoration getSrc_decoration() {
		return src_decoration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSrc_decoration(Decoration newSrc_decoration) {
		Decoration oldSrc_decoration = src_decoration;
		src_decoration = newSrc_decoration == null ? SRC_DECORATION_EDEFAULT : newSrc_decoration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModeldrawPackage.RELATION__SRC_DECORATION, oldSrc_decoration, src_decoration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getSrc_label() {
		if (src_label != null && src_label.eIsProxy()) {
			InternalEObject oldSrc_label = (InternalEObject)src_label;
			src_label = (EAttribute)eResolveProxy(oldSrc_label);
			if (src_label != oldSrc_label) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModeldrawPackage.RELATION__SRC_LABEL, oldSrc_label, src_label));
			}
		}
		return src_label;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute basicGetSrc_label() {
		return src_label;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSrc_label(EAttribute newSrc_label) {
		EAttribute oldSrc_label = src_label;
		src_label = newSrc_label;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModeldrawPackage.RELATION__SRC_LABEL, oldSrc_label, src_label));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Decoration getTar_decoration() {
		return tar_decoration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTar_decoration(Decoration newTar_decoration) {
		Decoration oldTar_decoration = tar_decoration;
		tar_decoration = newTar_decoration == null ? TAR_DECORATION_EDEFAULT : newTar_decoration;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModeldrawPackage.RELATION__TAR_DECORATION, oldTar_decoration, tar_decoration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getTar_label() {
		if (tar_label != null && tar_label.eIsProxy()) {
			InternalEObject oldTar_label = (InternalEObject)tar_label;
			tar_label = (EAttribute)eResolveProxy(oldTar_label);
			if (tar_label != oldTar_label) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModeldrawPackage.RELATION__TAR_LABEL, oldTar_label, tar_label));
			}
		}
		return tar_label;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute basicGetTar_label() {
		return tar_label;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTar_label(EAttribute newTar_label) {
		EAttribute oldTar_label = tar_label;
		tar_label = newTar_label;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModeldrawPackage.RELATION__TAR_LABEL, oldTar_label, tar_label));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModeldrawPackage.RELATION__REFERENCE:
				return getReference();
			case ModeldrawPackage.RELATION__REF_TYPE:
				return getRefType();
			case ModeldrawPackage.RELATION__LABEL:
				return getLabel();
			case ModeldrawPackage.RELATION__SRC_DECORATION:
				return getSrc_decoration();
			case ModeldrawPackage.RELATION__SRC_LABEL:
				if (resolve) return getSrc_label();
				return basicGetSrc_label();
			case ModeldrawPackage.RELATION__TAR_DECORATION:
				return getTar_decoration();
			case ModeldrawPackage.RELATION__TAR_LABEL:
				if (resolve) return getTar_label();
				return basicGetTar_label();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ModeldrawPackage.RELATION__REFERENCE:
				getReference().clear();
				getReference().addAll((Collection<? extends EReference>)newValue);
				return;
			case ModeldrawPackage.RELATION__REF_TYPE:
				getRefType().clear();
				getRefType().addAll((Collection<? extends EReference>)newValue);
				return;
			case ModeldrawPackage.RELATION__LABEL:
				getLabel().clear();
				getLabel().addAll((Collection<? extends EAttribute>)newValue);
				return;
			case ModeldrawPackage.RELATION__SRC_DECORATION:
				setSrc_decoration((Decoration)newValue);
				return;
			case ModeldrawPackage.RELATION__SRC_LABEL:
				setSrc_label((EAttribute)newValue);
				return;
			case ModeldrawPackage.RELATION__TAR_DECORATION:
				setTar_decoration((Decoration)newValue);
				return;
			case ModeldrawPackage.RELATION__TAR_LABEL:
				setTar_label((EAttribute)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ModeldrawPackage.RELATION__REFERENCE:
				getReference().clear();
				return;
			case ModeldrawPackage.RELATION__REF_TYPE:
				getRefType().clear();
				return;
			case ModeldrawPackage.RELATION__LABEL:
				getLabel().clear();
				return;
			case ModeldrawPackage.RELATION__SRC_DECORATION:
				setSrc_decoration(SRC_DECORATION_EDEFAULT);
				return;
			case ModeldrawPackage.RELATION__SRC_LABEL:
				setSrc_label((EAttribute)null);
				return;
			case ModeldrawPackage.RELATION__TAR_DECORATION:
				setTar_decoration(TAR_DECORATION_EDEFAULT);
				return;
			case ModeldrawPackage.RELATION__TAR_LABEL:
				setTar_label((EAttribute)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ModeldrawPackage.RELATION__REFERENCE:
				return reference != null && !reference.isEmpty();
			case ModeldrawPackage.RELATION__REF_TYPE:
				return refType != null && !refType.isEmpty();
			case ModeldrawPackage.RELATION__LABEL:
				return label != null && !label.isEmpty();
			case ModeldrawPackage.RELATION__SRC_DECORATION:
				return src_decoration != SRC_DECORATION_EDEFAULT;
			case ModeldrawPackage.RELATION__SRC_LABEL:
				return src_label != null;
			case ModeldrawPackage.RELATION__TAR_DECORATION:
				return tar_decoration != TAR_DECORATION_EDEFAULT;
			case ModeldrawPackage.RELATION__TAR_LABEL:
				return tar_label != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (src_decoration: ");
		result.append(src_decoration);
		result.append(", tar_decoration: ");
		result.append(tar_decoration);
		result.append(')');
		return result.toString();
	}

} //RelationImpl
