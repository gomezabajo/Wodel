/**
 */
package modeltext.impl;

import java.util.Collection;

import modeltext.Attribute;
import modeltext.Element;
import modeltext.ModeltextPackage;
import modeltext.Word;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Element</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link modeltext.impl.ElementImpl#getType <em>Type</em>}</li>
 *   <li>{@link modeltext.impl.ElementImpl#getRef <em>Ref</em>}</li>
 *   <li>{@link modeltext.impl.ElementImpl#getAtt <em>Att</em>}</li>
 *   <li>{@link modeltext.impl.ElementImpl#getWords <em>Words</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ElementImpl extends MinimalEObjectImpl.Container implements Element {
	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected EClass type;

	/**
	 * The cached value of the '{@link #getRef() <em>Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRef()
	 * @generated
	 * @ordered
	 */
	protected EReference ref;

	/**
	 * The cached value of the '{@link #getAtt() <em>Att</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAtt()
	 * @generated
	 * @ordered
	 */
	protected Attribute att;

	/**
	 * The cached value of the '{@link #getWords() <em>Words</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWords()
	 * @generated
	 * @ordered
	 */
	protected EList<Word> words;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ElementImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModeltextPackage.Literals.ELEMENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getType() {
		if (type != null && type.eIsProxy()) {
			InternalEObject oldType = (InternalEObject)type;
			type = (EClass)eResolveProxy(oldType);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModeltextPackage.ELEMENT__TYPE, oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass basicGetType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(EClass newType) {
		EClass oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModeltextPackage.ELEMENT__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRef() {
		if (ref != null && ref.eIsProxy()) {
			InternalEObject oldRef = (InternalEObject)ref;
			ref = (EReference)eResolveProxy(oldRef);
			if (ref != oldRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ModeltextPackage.ELEMENT__REF, oldRef, ref));
			}
		}
		return ref;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference basicGetRef() {
		return ref;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRef(EReference newRef) {
		EReference oldRef = ref;
		ref = newRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModeltextPackage.ELEMENT__REF, oldRef, ref));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Attribute getAtt() {
		return att;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAtt(Attribute newAtt, NotificationChain msgs) {
		Attribute oldAtt = att;
		att = newAtt;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ModeltextPackage.ELEMENT__ATT, oldAtt, newAtt);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAtt(Attribute newAtt) {
		if (newAtt != att) {
			NotificationChain msgs = null;
			if (att != null)
				msgs = ((InternalEObject)att).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ModeltextPackage.ELEMENT__ATT, null, msgs);
			if (newAtt != null)
				msgs = ((InternalEObject)newAtt).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ModeltextPackage.ELEMENT__ATT, null, msgs);
			msgs = basicSetAtt(newAtt, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModeltextPackage.ELEMENT__ATT, newAtt, newAtt));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Word> getWords() {
		if (words == null) {
			words = new EObjectContainmentEList<Word>(Word.class, this, ModeltextPackage.ELEMENT__WORDS);
		}
		return words;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModeltextPackage.ELEMENT__ATT:
				return basicSetAtt(null, msgs);
			case ModeltextPackage.ELEMENT__WORDS:
				return ((InternalEList<?>)getWords()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ModeltextPackage.ELEMENT__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case ModeltextPackage.ELEMENT__REF:
				if (resolve) return getRef();
				return basicGetRef();
			case ModeltextPackage.ELEMENT__ATT:
				return getAtt();
			case ModeltextPackage.ELEMENT__WORDS:
				return getWords();
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
			case ModeltextPackage.ELEMENT__TYPE:
				setType((EClass)newValue);
				return;
			case ModeltextPackage.ELEMENT__REF:
				setRef((EReference)newValue);
				return;
			case ModeltextPackage.ELEMENT__ATT:
				setAtt((Attribute)newValue);
				return;
			case ModeltextPackage.ELEMENT__WORDS:
				getWords().clear();
				getWords().addAll((Collection<? extends Word>)newValue);
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
			case ModeltextPackage.ELEMENT__TYPE:
				setType((EClass)null);
				return;
			case ModeltextPackage.ELEMENT__REF:
				setRef((EReference)null);
				return;
			case ModeltextPackage.ELEMENT__ATT:
				setAtt((Attribute)null);
				return;
			case ModeltextPackage.ELEMENT__WORDS:
				getWords().clear();
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
			case ModeltextPackage.ELEMENT__TYPE:
				return type != null;
			case ModeltextPackage.ELEMENT__REF:
				return ref != null;
			case ModeltextPackage.ELEMENT__ATT:
				return att != null;
			case ModeltextPackage.ELEMENT__WORDS:
				return words != null && !words.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ElementImpl
