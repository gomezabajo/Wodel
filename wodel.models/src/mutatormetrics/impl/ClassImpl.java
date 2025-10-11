/**
 */
package mutatormetrics.impl;

import java.util.Collection;

import mutatormetrics.Attribute;
import mutatormetrics.MutatormetricsPackage;
import mutatormetrics.Reference;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Class</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link mutatormetrics.impl.ClassImpl#getAttributes <em>Attributes</em>}</li>
 *   <li>{@link mutatormetrics.impl.ClassImpl#getReferences <em>References</em>}</li>
 *   <li>{@link mutatormetrics.impl.ClassImpl#getCcreated <em>Ccreated</em>}</li>
 *   <li>{@link mutatormetrics.impl.ClassImpl#getCmodified <em>Cmodified</em>}</li>
 *   <li>{@link mutatormetrics.impl.ClassImpl#getCremoved <em>Cremoved</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ClassImpl extends ObjectImpl implements mutatormetrics.Class {
	/**
	 * The cached value of the '{@link #getAttributes() <em>Attributes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttributes()
	 * @generated
	 * @ordered
	 */
	protected EList<Attribute> attributes;

	/**
	 * The cached value of the '{@link #getReferences() <em>References</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReferences()
	 * @generated
	 * @ordered
	 */
	protected EList<Reference> references;

	/**
	 * The default value of the '{@link #getCcreated() <em>Ccreated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCcreated()
	 * @generated
	 * @ordered
	 */
	protected static final int CCREATED_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getCcreated() <em>Ccreated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCcreated()
	 * @generated
	 * @ordered
	 */
	protected int ccreated = CCREATED_EDEFAULT;

	/**
	 * The default value of the '{@link #getCmodified() <em>Cmodified</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCmodified()
	 * @generated
	 * @ordered
	 */
	protected static final int CMODIFIED_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getCmodified() <em>Cmodified</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCmodified()
	 * @generated
	 * @ordered
	 */
	protected int cmodified = CMODIFIED_EDEFAULT;

	/**
	 * The default value of the '{@link #getCremoved() <em>Cremoved</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCremoved()
	 * @generated
	 * @ordered
	 */
	protected static final int CREMOVED_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getCremoved() <em>Cremoved</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCremoved()
	 * @generated
	 * @ordered
	 */
	protected int cremoved = CREMOVED_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ClassImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MutatormetricsPackage.Literals.CLASS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Attribute> getAttributes() {
		if (attributes == null) {
			attributes = new EObjectContainmentEList<Attribute>(Attribute.class, this, MutatormetricsPackage.CLASS__ATTRIBUTES);
		}
		return attributes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Reference> getReferences() {
		if (references == null) {
			references = new EObjectContainmentEList<Reference>(Reference.class, this, MutatormetricsPackage.CLASS__REFERENCES);
		}
		return references;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getCcreated() {
		return ccreated;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCcreated(int newCcreated) {
		int oldCcreated = ccreated;
		ccreated = newCcreated;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MutatormetricsPackage.CLASS__CCREATED, oldCcreated, ccreated));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getCmodified() {
		return cmodified;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCmodified(int newCmodified) {
		int oldCmodified = cmodified;
		cmodified = newCmodified;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MutatormetricsPackage.CLASS__CMODIFIED, oldCmodified, cmodified));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getCremoved() {
		return cremoved;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCremoved(int newCremoved) {
		int oldCremoved = cremoved;
		cremoved = newCremoved;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MutatormetricsPackage.CLASS__CREMOVED, oldCremoved, cremoved));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case MutatormetricsPackage.CLASS__ATTRIBUTES:
				return ((InternalEList<?>)getAttributes()).basicRemove(otherEnd, msgs);
			case MutatormetricsPackage.CLASS__REFERENCES:
				return ((InternalEList<?>)getReferences()).basicRemove(otherEnd, msgs);
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
			case MutatormetricsPackage.CLASS__ATTRIBUTES:
				return getAttributes();
			case MutatormetricsPackage.CLASS__REFERENCES:
				return getReferences();
			case MutatormetricsPackage.CLASS__CCREATED:
				return getCcreated();
			case MutatormetricsPackage.CLASS__CMODIFIED:
				return getCmodified();
			case MutatormetricsPackage.CLASS__CREMOVED:
				return getCremoved();
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
			case MutatormetricsPackage.CLASS__ATTRIBUTES:
				getAttributes().clear();
				getAttributes().addAll((Collection<? extends Attribute>)newValue);
				return;
			case MutatormetricsPackage.CLASS__REFERENCES:
				getReferences().clear();
				getReferences().addAll((Collection<? extends Reference>)newValue);
				return;
			case MutatormetricsPackage.CLASS__CCREATED:
				setCcreated((Integer)newValue);
				return;
			case MutatormetricsPackage.CLASS__CMODIFIED:
				setCmodified((Integer)newValue);
				return;
			case MutatormetricsPackage.CLASS__CREMOVED:
				setCremoved((Integer)newValue);
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
			case MutatormetricsPackage.CLASS__ATTRIBUTES:
				getAttributes().clear();
				return;
			case MutatormetricsPackage.CLASS__REFERENCES:
				getReferences().clear();
				return;
			case MutatormetricsPackage.CLASS__CCREATED:
				setCcreated(CCREATED_EDEFAULT);
				return;
			case MutatormetricsPackage.CLASS__CMODIFIED:
				setCmodified(CMODIFIED_EDEFAULT);
				return;
			case MutatormetricsPackage.CLASS__CREMOVED:
				setCremoved(CREMOVED_EDEFAULT);
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
			case MutatormetricsPackage.CLASS__ATTRIBUTES:
				return attributes != null && !attributes.isEmpty();
			case MutatormetricsPackage.CLASS__REFERENCES:
				return references != null && !references.isEmpty();
			case MutatormetricsPackage.CLASS__CCREATED:
				return ccreated != CCREATED_EDEFAULT;
			case MutatormetricsPackage.CLASS__CMODIFIED:
				return cmodified != CMODIFIED_EDEFAULT;
			case MutatormetricsPackage.CLASS__CREMOVED:
				return cremoved != CREMOVED_EDEFAULT;
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
		result.append(" (ccreated: ");
		result.append(ccreated);
		result.append(", cmodified: ");
		result.append(cmodified);
		result.append(", cremoved: ");
		result.append(cremoved);
		result.append(')');
		return result.toString();
	}

} //ClassImpl
