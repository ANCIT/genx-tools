/**
 */
package DiagonosticModel.impl;

import DiagonosticModel.Action;
import DiagonosticModel.DiagonosticModelPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link DiagonosticModel.impl.ActionImpl#getValue <em>Value</em>}</li>
 *   <li>{@link DiagonosticModel.impl.ActionImpl#getWait <em>Wait</em>}</li>
 *   <li>{@link DiagonosticModel.impl.ActionImpl#getValueTo <em>Value To</em>}</li>
 * </ul>
 *
 * @generated
 */
public abstract class ActionImpl extends TestStepImpl implements Action {
	/**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final String VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected String value = VALUE_EDEFAULT;

	/**
	 * The default value of the '{@link #getWait() <em>Wait</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWait()
	 * @generated
	 * @ordered
	 */
	protected static final float WAIT_EDEFAULT = 0.0F;

	/**
	 * The cached value of the '{@link #getWait() <em>Wait</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getWait()
	 * @generated
	 * @ordered
	 */
	protected float wait = WAIT_EDEFAULT;

	/**
	 * The default value of the '{@link #getValueTo() <em>Value To</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueTo()
	 * @generated
	 * @ordered
	 */
	protected static final String VALUE_TO_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getValueTo() <em>Value To</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueTo()
	 * @generated
	 * @ordered
	 */
	protected String valueTo = VALUE_TO_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DiagonosticModelPackage.Literals.ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setValue(String newValue) {
		String oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagonosticModelPackage.ACTION__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public float getWait() {
		return wait;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setWait(float newWait) {
		float oldWait = wait;
		wait = newWait;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagonosticModelPackage.ACTION__WAIT, oldWait, wait));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getValueTo() {
		return valueTo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setValueTo(String newValueTo) {
		String oldValueTo = valueTo;
		valueTo = newValueTo;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagonosticModelPackage.ACTION__VALUE_TO, oldValueTo, valueTo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DiagonosticModelPackage.ACTION__VALUE:
				return getValue();
			case DiagonosticModelPackage.ACTION__WAIT:
				return getWait();
			case DiagonosticModelPackage.ACTION__VALUE_TO:
				return getValueTo();
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
			case DiagonosticModelPackage.ACTION__VALUE:
				setValue((String)newValue);
				return;
			case DiagonosticModelPackage.ACTION__WAIT:
				setWait((Float)newValue);
				return;
			case DiagonosticModelPackage.ACTION__VALUE_TO:
				setValueTo((String)newValue);
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
			case DiagonosticModelPackage.ACTION__VALUE:
				setValue(VALUE_EDEFAULT);
				return;
			case DiagonosticModelPackage.ACTION__WAIT:
				setWait(WAIT_EDEFAULT);
				return;
			case DiagonosticModelPackage.ACTION__VALUE_TO:
				setValueTo(VALUE_TO_EDEFAULT);
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
			case DiagonosticModelPackage.ACTION__VALUE:
				return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
			case DiagonosticModelPackage.ACTION__WAIT:
				return wait != WAIT_EDEFAULT;
			case DiagonosticModelPackage.ACTION__VALUE_TO:
				return VALUE_TO_EDEFAULT == null ? valueTo != null : !VALUE_TO_EDEFAULT.equals(valueTo);
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
		result.append(" (value: ");
		result.append(value);
		result.append(", wait: ");
		result.append(wait);
		result.append(", valueTo: ");
		result.append(valueTo);
		result.append(')');
		return result.toString();
	}

} //ActionImpl
