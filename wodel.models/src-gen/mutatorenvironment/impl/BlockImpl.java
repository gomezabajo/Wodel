/**
 */
package mutatorenvironment.impl;

import java.util.Collection;

import mutatorenvironment.Block;
import mutatorenvironment.Mutator;
import mutatorenvironment.MutatorenvironmentPackage;
import mutatorenvironment.Repeat;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Block</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link mutatorenvironment.impl.BlockImpl#getName <em>Name</em>}</li>
 *   <li>{@link mutatorenvironment.impl.BlockImpl#getCommands <em>Commands</em>}</li>
 *   <li>{@link mutatorenvironment.impl.BlockImpl#getFrom <em>From</em>}</li>
 *   <li>{@link mutatorenvironment.impl.BlockImpl#getRepeat <em>Repeat</em>}</li>
 *   <li>{@link mutatorenvironment.impl.BlockImpl#getMin <em>Min</em>}</li>
 *   <li>{@link mutatorenvironment.impl.BlockImpl#getMax <em>Max</em>}</li>
 *   <li>{@link mutatorenvironment.impl.BlockImpl#getFixed <em>Fixed</em>}</li>
 *   <li>{@link mutatorenvironment.impl.BlockImpl#getDescription <em>Description</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BlockImpl extends MinimalEObjectImpl.Container implements Block {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getCommands() <em>Commands</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCommands()
	 * @generated
	 * @ordered
	 */
	protected EList<Mutator> commands;

	/**
	 * The cached value of the '{@link #getFrom() <em>From</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFrom()
	 * @generated
	 * @ordered
	 */
	protected EList<Block> from;

	/**
	 * The default value of the '{@link #getRepeat() <em>Repeat</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepeat()
	 * @generated
	 * @ordered
	 */
	protected static final Repeat REPEAT_EDEFAULT = Repeat.YES;

	/**
	 * The cached value of the '{@link #getRepeat() <em>Repeat</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRepeat()
	 * @generated
	 * @ordered
	 */
	protected Repeat repeat = REPEAT_EDEFAULT;

	/**
	 * The default value of the '{@link #getMin() <em>Min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMin()
	 * @generated
	 * @ordered
	 */
	protected static final int MIN_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMin() <em>Min</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMin()
	 * @generated
	 * @ordered
	 */
	protected int min = MIN_EDEFAULT;

	/**
	 * The default value of the '{@link #getMax() <em>Max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMax()
	 * @generated
	 * @ordered
	 */
	protected static final int MAX_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getMax() <em>Max</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMax()
	 * @generated
	 * @ordered
	 */
	protected int max = MAX_EDEFAULT;

	/**
	 * The default value of the '{@link #getFixed() <em>Fixed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFixed()
	 * @generated
	 * @ordered
	 */
	protected static final int FIXED_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getFixed() <em>Fixed</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFixed()
	 * @generated
	 * @ordered
	 */
	protected int fixed = FIXED_EDEFAULT;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BlockImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return MutatorenvironmentPackage.Literals.BLOCK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MutatorenvironmentPackage.BLOCK__NAME, oldName,
					name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Mutator> getCommands() {
		if (commands == null) {
			commands = new EObjectContainmentEList<Mutator>(Mutator.class, this,
					MutatorenvironmentPackage.BLOCK__COMMANDS);
		}
		return commands;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Block> getFrom() {
		if (from == null) {
			from = new EObjectResolvingEList<Block>(Block.class, this, MutatorenvironmentPackage.BLOCK__FROM);
		}
		return from;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Repeat getRepeat() {
		return repeat;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRepeat(Repeat newRepeat) {
		Repeat oldRepeat = repeat;
		repeat = newRepeat == null ? REPEAT_EDEFAULT : newRepeat;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MutatorenvironmentPackage.BLOCK__REPEAT, oldRepeat,
					repeat));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMin() {
		return min;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMin(int newMin) {
		int oldMin = min;
		min = newMin;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MutatorenvironmentPackage.BLOCK__MIN, oldMin, min));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getMax() {
		return max;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMax(int newMax) {
		int oldMax = max;
		max = newMax;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MutatorenvironmentPackage.BLOCK__MAX, oldMax, max));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getFixed() {
		return fixed;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFixed(int newFixed) {
		int oldFixed = fixed;
		fixed = newFixed;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, MutatorenvironmentPackage.BLOCK__FIXED, oldFixed,
					fixed));
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
			eNotify(new ENotificationImpl(this, Notification.SET, MutatorenvironmentPackage.BLOCK__DESCRIPTION,
					oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
		case MutatorenvironmentPackage.BLOCK__COMMANDS:
			return ((InternalEList<?>) getCommands()).basicRemove(otherEnd, msgs);
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
		case MutatorenvironmentPackage.BLOCK__NAME:
			return getName();
		case MutatorenvironmentPackage.BLOCK__COMMANDS:
			return getCommands();
		case MutatorenvironmentPackage.BLOCK__FROM:
			return getFrom();
		case MutatorenvironmentPackage.BLOCK__REPEAT:
			return getRepeat();
		case MutatorenvironmentPackage.BLOCK__MIN:
			return getMin();
		case MutatorenvironmentPackage.BLOCK__MAX:
			return getMax();
		case MutatorenvironmentPackage.BLOCK__FIXED:
			return getFixed();
		case MutatorenvironmentPackage.BLOCK__DESCRIPTION:
			return getDescription();
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
		case MutatorenvironmentPackage.BLOCK__NAME:
			setName((String) newValue);
			return;
		case MutatorenvironmentPackage.BLOCK__COMMANDS:
			getCommands().clear();
			getCommands().addAll((Collection<? extends Mutator>) newValue);
			return;
		case MutatorenvironmentPackage.BLOCK__FROM:
			getFrom().clear();
			getFrom().addAll((Collection<? extends Block>) newValue);
			return;
		case MutatorenvironmentPackage.BLOCK__REPEAT:
			setRepeat((Repeat) newValue);
			return;
		case MutatorenvironmentPackage.BLOCK__MIN:
			setMin((Integer) newValue);
			return;
		case MutatorenvironmentPackage.BLOCK__MAX:
			setMax((Integer) newValue);
			return;
		case MutatorenvironmentPackage.BLOCK__FIXED:
			setFixed((Integer) newValue);
			return;
		case MutatorenvironmentPackage.BLOCK__DESCRIPTION:
			setDescription((String) newValue);
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
		case MutatorenvironmentPackage.BLOCK__NAME:
			setName(NAME_EDEFAULT);
			return;
		case MutatorenvironmentPackage.BLOCK__COMMANDS:
			getCommands().clear();
			return;
		case MutatorenvironmentPackage.BLOCK__FROM:
			getFrom().clear();
			return;
		case MutatorenvironmentPackage.BLOCK__REPEAT:
			setRepeat(REPEAT_EDEFAULT);
			return;
		case MutatorenvironmentPackage.BLOCK__MIN:
			setMin(MIN_EDEFAULT);
			return;
		case MutatorenvironmentPackage.BLOCK__MAX:
			setMax(MAX_EDEFAULT);
			return;
		case MutatorenvironmentPackage.BLOCK__FIXED:
			setFixed(FIXED_EDEFAULT);
			return;
		case MutatorenvironmentPackage.BLOCK__DESCRIPTION:
			setDescription(DESCRIPTION_EDEFAULT);
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
		case MutatorenvironmentPackage.BLOCK__NAME:
			return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
		case MutatorenvironmentPackage.BLOCK__COMMANDS:
			return commands != null && !commands.isEmpty();
		case MutatorenvironmentPackage.BLOCK__FROM:
			return from != null && !from.isEmpty();
		case MutatorenvironmentPackage.BLOCK__REPEAT:
			return repeat != REPEAT_EDEFAULT;
		case MutatorenvironmentPackage.BLOCK__MIN:
			return min != MIN_EDEFAULT;
		case MutatorenvironmentPackage.BLOCK__MAX:
			return max != MAX_EDEFAULT;
		case MutatorenvironmentPackage.BLOCK__FIXED:
			return fixed != FIXED_EDEFAULT;
		case MutatorenvironmentPackage.BLOCK__DESCRIPTION:
			return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
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
		result.append(" (name: ");
		result.append(name);
		result.append(", repeat: ");
		result.append(repeat);
		result.append(", min: ");
		result.append(min);
		result.append(", max: ");
		result.append(max);
		result.append(", fixed: ");
		result.append(fixed);
		result.append(", description: ");
		result.append(description);
		result.append(')');
		return result.toString();
	}

} //BlockImpl
