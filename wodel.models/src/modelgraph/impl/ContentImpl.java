/**
 */
package modelgraph.impl;

import java.util.Collection;

import modelgraph.Content;
import modelgraph.Information;
import modelgraph.ModelgraphPackage;
import modelgraph.NodeEnumerator;

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
 * An implementation of the model object '<em><b>Content</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link modelgraph.impl.ContentImpl#getNodenum <em>Nodenum</em>}</li>
 *   <li>{@link modelgraph.impl.ContentImpl#getInfo <em>Info</em>}</li>
 *   <li>{@link modelgraph.impl.ContentImpl#getSymbol <em>Symbol</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ContentImpl extends NamedItemImpl implements Content {
	/**
	 * The cached value of the '{@link #getNodenum() <em>Nodenum</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNodenum()
	 * @generated
	 * @ordered
	 */
	protected EList<NodeEnumerator> nodenum;

	/**
	 * The cached value of the '{@link #getInfo() <em>Info</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInfo()
	 * @generated
	 * @ordered
	 */
	protected EList<Information> info;

	/**
	 * The default value of the '{@link #getSymbol() <em>Symbol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSymbol()
	 * @generated
	 * @ordered
	 */
	protected static final String SYMBOL_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getSymbol() <em>Symbol</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSymbol()
	 * @generated
	 * @ordered
	 */
	protected String symbol = SYMBOL_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ContentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ModelgraphPackage.Literals.CONTENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NodeEnumerator> getNodenum() {
		if (nodenum == null) {
			nodenum = new EObjectContainmentEList<NodeEnumerator>(NodeEnumerator.class, this, ModelgraphPackage.CONTENT__NODENUM);
		}
		return nodenum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Information> getInfo() {
		if (info == null) {
			info = new EObjectContainmentEList<Information>(Information.class, this, ModelgraphPackage.CONTENT__INFO);
		}
		return info;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getSymbol() {
		return symbol;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSymbol(String newSymbol) {
		String oldSymbol = symbol;
		symbol = newSymbol;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ModelgraphPackage.CONTENT__SYMBOL, oldSymbol, symbol));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ModelgraphPackage.CONTENT__NODENUM:
				return ((InternalEList<?>)getNodenum()).basicRemove(otherEnd, msgs);
			case ModelgraphPackage.CONTENT__INFO:
				return ((InternalEList<?>)getInfo()).basicRemove(otherEnd, msgs);
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
			case ModelgraphPackage.CONTENT__NODENUM:
				return getNodenum();
			case ModelgraphPackage.CONTENT__INFO:
				return getInfo();
			case ModelgraphPackage.CONTENT__SYMBOL:
				return getSymbol();
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
			case ModelgraphPackage.CONTENT__NODENUM:
				getNodenum().clear();
				getNodenum().addAll((Collection<? extends NodeEnumerator>)newValue);
				return;
			case ModelgraphPackage.CONTENT__INFO:
				getInfo().clear();
				getInfo().addAll((Collection<? extends Information>)newValue);
				return;
			case ModelgraphPackage.CONTENT__SYMBOL:
				setSymbol((String)newValue);
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
			case ModelgraphPackage.CONTENT__NODENUM:
				getNodenum().clear();
				return;
			case ModelgraphPackage.CONTENT__INFO:
				getInfo().clear();
				return;
			case ModelgraphPackage.CONTENT__SYMBOL:
				setSymbol(SYMBOL_EDEFAULT);
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
			case ModelgraphPackage.CONTENT__NODENUM:
				return nodenum != null && !nodenum.isEmpty();
			case ModelgraphPackage.CONTENT__INFO:
				return info != null && !info.isEmpty();
			case ModelgraphPackage.CONTENT__SYMBOL:
				return SYMBOL_EDEFAULT == null ? symbol != null : !SYMBOL_EDEFAULT.equals(symbol);
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
		result.append(" (symbol: ");
		result.append(symbol);
		result.append(')');
		return result.toString();
	}

} //ContentImpl
