/**
 */
package DiagonosticModel.impl;

import DiagonosticModel.DiagonosticModelPackage;
import DiagonosticModel.ForLoop;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>For Loop</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link DiagonosticModel.impl.ForLoopImpl#getLoopVar <em>Loop Var</em>}</li>
 *   <li>{@link DiagonosticModel.impl.ForLoopImpl#getStopValue <em>Stop Value</em>}</li>
 *   <li>{@link DiagonosticModel.impl.ForLoopImpl#getStartValue <em>Start Value</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ForLoopImpl extends BlockActionImpl implements ForLoop {
	/**
	 * The default value of the '{@link #getLoopVar() <em>Loop Var</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLoopVar()
	 * @generated
	 * @ordered
	 */
	protected static final String LOOP_VAR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getLoopVar() <em>Loop Var</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLoopVar()
	 * @generated
	 * @ordered
	 */
	protected String loopVar = LOOP_VAR_EDEFAULT;

	/**
	 * The default value of the '{@link #getStopValue() <em>Stop Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStopValue()
	 * @generated
	 * @ordered
	 */
	protected static final int STOP_VALUE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getStopValue() <em>Stop Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStopValue()
	 * @generated
	 * @ordered
	 */
	protected int stopValue = STOP_VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getStartValue() <em>Start Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartValue()
	 * @generated
	 * @ordered
	 */
	protected static final int START_VALUE_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getStartValue() <em>Start Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStartValue()
	 * @generated
	 * @ordered
	 */
	protected int startValue = START_VALUE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ForLoopImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DiagonosticModelPackage.Literals.FOR_LOOP;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLoopVar() {
		return loopVar;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setLoopVar(String newLoopVar) {
		String oldLoopVar = loopVar;
		loopVar = newLoopVar;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagonosticModelPackage.FOR_LOOP__LOOP_VAR, oldLoopVar, loopVar));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getStopValue() {
		return stopValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStopValue(int newStopValue) {
		int oldStopValue = stopValue;
		stopValue = newStopValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagonosticModelPackage.FOR_LOOP__STOP_VALUE, oldStopValue, stopValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getStartValue() {
		return startValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setStartValue(int newStartValue) {
		int oldStartValue = startValue;
		startValue = newStartValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagonosticModelPackage.FOR_LOOP__START_VALUE, oldStartValue, startValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DiagonosticModelPackage.FOR_LOOP__LOOP_VAR:
				return getLoopVar();
			case DiagonosticModelPackage.FOR_LOOP__STOP_VALUE:
				return getStopValue();
			case DiagonosticModelPackage.FOR_LOOP__START_VALUE:
				return getStartValue();
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
			case DiagonosticModelPackage.FOR_LOOP__LOOP_VAR:
				setLoopVar((String)newValue);
				return;
			case DiagonosticModelPackage.FOR_LOOP__STOP_VALUE:
				setStopValue((Integer)newValue);
				return;
			case DiagonosticModelPackage.FOR_LOOP__START_VALUE:
				setStartValue((Integer)newValue);
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
			case DiagonosticModelPackage.FOR_LOOP__LOOP_VAR:
				setLoopVar(LOOP_VAR_EDEFAULT);
				return;
			case DiagonosticModelPackage.FOR_LOOP__STOP_VALUE:
				setStopValue(STOP_VALUE_EDEFAULT);
				return;
			case DiagonosticModelPackage.FOR_LOOP__START_VALUE:
				setStartValue(START_VALUE_EDEFAULT);
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
			case DiagonosticModelPackage.FOR_LOOP__LOOP_VAR:
				return LOOP_VAR_EDEFAULT == null ? loopVar != null : !LOOP_VAR_EDEFAULT.equals(loopVar);
			case DiagonosticModelPackage.FOR_LOOP__STOP_VALUE:
				return stopValue != STOP_VALUE_EDEFAULT;
			case DiagonosticModelPackage.FOR_LOOP__START_VALUE:
				return startValue != START_VALUE_EDEFAULT;
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
		result.append(" (loopVar: ");
		result.append(loopVar);
		result.append(", stopValue: ");
		result.append(stopValue);
		result.append(", startValue: ");
		result.append(startValue);
		result.append(')');
		return result.toString();
	}

} //ForLoopImpl
