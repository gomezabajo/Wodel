/**
 */
package mutatorenvironment.impl;

import java.util.Collection;

import mutatorenvironment.MutatorenvironmentPackage;
import mutatorenvironment.Program;
import mutatorenvironment.Resource;
import mutatorenvironment.Source;

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
 * An implementation of the model object '<em><b>Program</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link mutatorenvironment.impl.ProgramImpl#getOutput <em>Output</em>}</li>
 *   <li>{@link mutatorenvironment.impl.ProgramImpl#getNum <em>Num</em>}</li>
 *   <li>{@link mutatorenvironment.impl.ProgramImpl#getSource <em>Source</em>}</li>
 *   <li>{@link mutatorenvironment.impl.ProgramImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link mutatorenvironment.impl.ProgramImpl#isExhaustive <em>Exhaustive</em>}</li>
 *   <li>{@link mutatorenvironment.impl.ProgramImpl#getResources <em>Resources</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ProgramImpl extends DefinitionImpl implements Program {
	/**
	 * The default value of the '{@link #getOutput() <em>Output</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutput()
	 * @generated
	 * @ordered
	 */
	protected static final String OUTPUT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getOutput() <em>Output</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOutput()
	 * @generated
	 * @ordered
	 */
	protected String output = OUTPUT_EDEFAULT;

	/**
	 * The default value of the '{@link #getNum() <em>Num</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNum()
	 * @generated
	 * @ordered
	 */
	protected static final int NUM_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getNum() <em>Num</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNum()
	 * @generated
	 * @ordered
	 */
	protected int num = NUM_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected Source source;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The default value of the '{@link #isExhaustive() <em>Exhaustive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExhaustive()
	 * @generated
	 * @ordered
	 */
	protected static final boolean EXHAUSTIVE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isExhaustive() <em>Exhaustive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isExhaustive()
	 * @generated
	 * @ordered
	 */
	protected boolean exhaustive = EXHAUSTIVE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getResources() <em>Resources</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResources()
	 * @generated
	 * @ordered
	 */
	protected EList<Resource> resources;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProgramImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MutatorenvironmentPackage.Literals.PROGRAM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getOutput() {
		return output;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOutput(String newOutput) {
		String oldOutput = output;
		output = newOutput;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MutatorenvironmentPackage.PROGRAM__OUTPUT, oldOutput,
					output));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getNum() {
		return num;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNum(int newNum) {
		int oldNum = num;
		num = newNum;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MutatorenvironmentPackage.PROGRAM__NUM, oldNum, num));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Source getSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetSource(Source newSource, NotificationChain msgs) {
		Source oldSource = source;
		source = newSource;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET,
					MutatorenvironmentPackage.PROGRAM__SOURCE, oldSource, newSource);
			if (msgs == null)
				msgs = notification;
			else
				msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(Source newSource) {
		if (newSource != source) {
			NotificationChain msgs = null;
			if (source != null)
				msgs = ((InternalEObject) source).eInverseRemove(this,
						EOPPOSITE_FEATURE_BASE - MutatorenvironmentPackage.PROGRAM__SOURCE, null, msgs);
			if (newSource != null)
				msgs = ((InternalEObject) newSource).eInverseAdd(this,
						EOPPOSITE_FEATURE_BASE - MutatorenvironmentPackage.PROGRAM__SOURCE, null, msgs);
			msgs = basicSetSource(newSource, msgs);
			if (msgs != null)
				msgs.dispatch();
		} else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MutatorenvironmentPackage.PROGRAM__SOURCE, newSource,
					newSource));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MutatorenvironmentPackage.PROGRAM__DESCRIPTION,
					oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isExhaustive() {
		return exhaustive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExhaustive(boolean newExhaustive) {
		boolean oldExhaustive = exhaustive;
		exhaustive = newExhaustive;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MutatorenvironmentPackage.PROGRAM__EXHAUSTIVE,
					oldExhaustive, exhaustive));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Resource> getResources() {
		if (resources == null) {
			resources = new EObjectContainmentEList<Resource>(Resource.class, this,
					MutatorenvironmentPackage.PROGRAM__RESOURCES);
		}
		return resources;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case MutatorenvironmentPackage.PROGRAM__SOURCE:
			return basicSetSource(null, msgs);
		case MutatorenvironmentPackage.PROGRAM__RESOURCES:
			return ((InternalEList<?>) getResources()).basicRemove(otherEnd, msgs);
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
		case MutatorenvironmentPackage.PROGRAM__OUTPUT:
			return getOutput();
		case MutatorenvironmentPackage.PROGRAM__NUM:
			return getNum();
		case MutatorenvironmentPackage.PROGRAM__SOURCE:
			return getSource();
		case MutatorenvironmentPackage.PROGRAM__DESCRIPTION:
			return getDescription();
		case MutatorenvironmentPackage.PROGRAM__EXHAUSTIVE:
			return isExhaustive();
		case MutatorenvironmentPackage.PROGRAM__RESOURCES:
			return getResources();
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
		case MutatorenvironmentPackage.PROGRAM__OUTPUT:
			setOutput((String) newValue);
			return;
		case MutatorenvironmentPackage.PROGRAM__NUM:
			setNum((Integer) newValue);
			return;
		case MutatorenvironmentPackage.PROGRAM__SOURCE:
			setSource((Source) newValue);
			return;
		case MutatorenvironmentPackage.PROGRAM__DESCRIPTION:
			setDescription((String) newValue);
			return;
		case MutatorenvironmentPackage.PROGRAM__EXHAUSTIVE:
			setExhaustive((Boolean) newValue);
			return;
		case MutatorenvironmentPackage.PROGRAM__RESOURCES:
			getResources().clear();
			getResources().addAll((Collection<? extends Resource>) newValue);
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
		case MutatorenvironmentPackage.PROGRAM__OUTPUT:
			setOutput(OUTPUT_EDEFAULT);
			return;
		case MutatorenvironmentPackage.PROGRAM__NUM:
			setNum(NUM_EDEFAULT);
			return;
		case MutatorenvironmentPackage.PROGRAM__SOURCE:
			setSource((Source) null);
			return;
		case MutatorenvironmentPackage.PROGRAM__DESCRIPTION:
			setDescription(DESCRIPTION_EDEFAULT);
			return;
		case MutatorenvironmentPackage.PROGRAM__EXHAUSTIVE:
			setExhaustive(EXHAUSTIVE_EDEFAULT);
			return;
		case MutatorenvironmentPackage.PROGRAM__RESOURCES:
			getResources().clear();
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
		case MutatorenvironmentPackage.PROGRAM__OUTPUT:
			return OUTPUT_EDEFAULT == null ? output != null : !OUTPUT_EDEFAULT.equals(output);
		case MutatorenvironmentPackage.PROGRAM__NUM:
			return num != NUM_EDEFAULT;
		case MutatorenvironmentPackage.PROGRAM__SOURCE:
			return source != null;
		case MutatorenvironmentPackage.PROGRAM__DESCRIPTION:
			return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
		case MutatorenvironmentPackage.PROGRAM__EXHAUSTIVE:
			return exhaustive != EXHAUSTIVE_EDEFAULT;
		case MutatorenvironmentPackage.PROGRAM__RESOURCES:
			return resources != null && !resources.isEmpty();
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
		if (eIsProxy())
			return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (output: ");
		result.append(output);
		result.append(", num: ");
		result.append(num);
		result.append(", description: ");
		result.append(description);
		result.append(", exhaustive: ");
		result.append(exhaustive);
		result.append(')');
		return result.toString();
	}

} //ProgramImpl
