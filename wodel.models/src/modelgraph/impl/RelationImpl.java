/**
 */
package modelgraph.impl;

import modelgraph.Decoration;
import modelgraph.ModelgraphPackage;
import modelgraph.Relation;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Relation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link modelgraph.impl.RelationImpl#getReference <em>Reference</em>}</li>
 *   <li>{@link modelgraph.impl.RelationImpl#getLabel <em>Label</em>}</li>
 *   <li>{@link modelgraph.impl.RelationImpl#getSrc_decoration <em>Src decoration</em>}</li>
 *   <li>{@link modelgraph.impl.RelationImpl#getSrc_label <em>Src label</em>}</li>
 *   <li>{@link modelgraph.impl.RelationImpl#getTar_decoration <em>Tar decoration</em>}</li>
 *   <li>{@link modelgraph.impl.RelationImpl#getTar_label <em>Tar label</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class RelationImpl extends NamedItemImpl implements Relation {
	/**
	 * The cached value of the '{@link #getReference() <em>Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReference()
	 * @generated
	 * @ordered
	 */
	protected EReference reference;

	/**
	 * The cached value of the '{@link #getLabel() <em>Label</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLabel()
	 * @generated
	 * @ordered
	 */
	protected EAttribute label;

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
		return ModelgraphPackage.Literals.RELATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReference() {
		if (reference != null && reference.eIsProxy()) {
			InternalEObject oldReference = (InternalEObject)reference;
			reference = (EReference)eResolveProxy(oldReference);
			if (reference != oldReference) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelgraphPackage.RELATION__REFERENCE, oldReference, reference));
			}
		}
		return reference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference basicGetReference() {
		return reference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReference(EReference newReference) {
		EReference oldReference = reference;
		reference = newReference;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelgraphPackage.RELATION__REFERENCE, oldReference, reference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getLabel() {
		if (label != null && label.eIsProxy()) {
			InternalEObject oldLabel = (InternalEObject)label;
			label = (EAttribute)eResolveProxy(oldLabel);
			if (label != oldLabel) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelgraphPackage.RELATION__LABEL, oldLabel, label));
			}
		}
		return label;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute basicGetLabel() {
		return label;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLabel(EAttribute newLabel) {
		EAttribute oldLabel = label;
		label = newLabel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelgraphPackage.RELATION__LABEL, oldLabel, label));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelgraphPackage.RELATION__SRC_DECORATION, oldSrc_decoration, src_decoration));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelgraphPackage.RELATION__SRC_LABEL, oldSrc_label, src_label));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelgraphPackage.RELATION__SRC_LABEL, oldSrc_label, src_label));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelgraphPackage.RELATION__TAR_DECORATION, oldTar_decoration, tar_decoration));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModelgraphPackage.RELATION__TAR_LABEL, oldTar_label, tar_label));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ModelgraphPackage.RELATION__TAR_LABEL, oldTar_label, tar_label));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModelgraphPackage.RELATION__REFERENCE:
				if (resolve) return getReference();
				return basicGetReference();
			case ModelgraphPackage.RELATION__LABEL:
				if (resolve) return getLabel();
				return basicGetLabel();
			case ModelgraphPackage.RELATION__SRC_DECORATION:
				return getSrc_decoration();
			case ModelgraphPackage.RELATION__SRC_LABEL:
				if (resolve) return getSrc_label();
				return basicGetSrc_label();
			case ModelgraphPackage.RELATION__TAR_DECORATION:
				return getTar_decoration();
			case ModelgraphPackage.RELATION__TAR_LABEL:
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
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ModelgraphPackage.RELATION__REFERENCE:
				setReference((EReference)newValue);
				return;
			case ModelgraphPackage.RELATION__LABEL:
				setLabel((EAttribute)newValue);
				return;
			case ModelgraphPackage.RELATION__SRC_DECORATION:
				setSrc_decoration((Decoration)newValue);
				return;
			case ModelgraphPackage.RELATION__SRC_LABEL:
				setSrc_label((EAttribute)newValue);
				return;
			case ModelgraphPackage.RELATION__TAR_DECORATION:
				setTar_decoration((Decoration)newValue);
				return;
			case ModelgraphPackage.RELATION__TAR_LABEL:
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
			case ModelgraphPackage.RELATION__REFERENCE:
				setReference((EReference)null);
				return;
			case ModelgraphPackage.RELATION__LABEL:
				setLabel((EAttribute)null);
				return;
			case ModelgraphPackage.RELATION__SRC_DECORATION:
				setSrc_decoration(SRC_DECORATION_EDEFAULT);
				return;
			case ModelgraphPackage.RELATION__SRC_LABEL:
				setSrc_label((EAttribute)null);
				return;
			case ModelgraphPackage.RELATION__TAR_DECORATION:
				setTar_decoration(TAR_DECORATION_EDEFAULT);
				return;
			case ModelgraphPackage.RELATION__TAR_LABEL:
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
			case ModelgraphPackage.RELATION__REFERENCE:
				return reference != null;
			case ModelgraphPackage.RELATION__LABEL:
				return label != null;
			case ModelgraphPackage.RELATION__SRC_DECORATION:
				return src_decoration != SRC_DECORATION_EDEFAULT;
			case ModelgraphPackage.RELATION__SRC_LABEL:
				return src_label != null;
			case ModelgraphPackage.RELATION__TAR_DECORATION:
				return tar_decoration != TAR_DECORATION_EDEFAULT;
			case ModelgraphPackage.RELATION__TAR_LABEL:
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

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (src_decoration: ");
		result.append(src_decoration);
		result.append(", tar_decoration: ");
		result.append(tar_decoration);
		result.append(')');
		return result.toString();
	}

} //RelationImpl
