/**
 */
package DiagonosticModel.impl;

import DiagonosticModel.DiagonosticModelPackage;
import DiagonosticModel.OperatorTypeEnum;
import DiagonosticModel.WhileLoop;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>While Loop</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link DiagonosticModel.impl.WhileLoopImpl#getValue <em>Value</em>}</li>
 *   <li>{@link DiagonosticModel.impl.WhileLoopImpl#getValueTo <em>Value To</em>}</li>
 *   <li>{@link DiagonosticModel.impl.WhileLoopImpl#getOperator <em>Operator</em>}</li>
 * </ul>
 *
 * @generated
 */
public class WhileLoopImpl extends BlockActionImpl implements WhileLoop {
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
	 * The default value of the '{@link #getOperator() <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperator()
	 * @generated
	 * @ordered
	 */
	protected static final OperatorTypeEnum OPERATOR_EDEFAULT = OperatorTypeEnum.EQ;
	/**
	 * The cached value of the '{@link #getOperator() <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperator()
	 * @generated
	 * @ordered
	 */
	protected OperatorTypeEnum operator = OPERATOR_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected WhileLoopImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DiagonosticModelPackage.Literals.WHILE_LOOP;
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
			eNotify(new ENotificationImpl(this, Notification.SET, DiagonosticModelPackage.WHILE_LOOP__VALUE, oldValue, value));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DiagonosticModelPackage.WHILE_LOOP__VALUE_TO, oldValueTo, valueTo));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OperatorTypeEnum getOperator() {
		return operator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setOperator(OperatorTypeEnum newOperator) {
		OperatorTypeEnum oldOperator = operator;
		operator = newOperator == null ? OPERATOR_EDEFAULT : newOperator;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagonosticModelPackage.WHILE_LOOP__OPERATOR, oldOperator, operator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DiagonosticModelPackage.WHILE_LOOP__VALUE:
				return getValue();
			case DiagonosticModelPackage.WHILE_LOOP__VALUE_TO:
				return getValueTo();
			case DiagonosticModelPackage.WHILE_LOOP__OPERATOR:
				return getOperator();
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
			case DiagonosticModelPackage.WHILE_LOOP__VALUE:
				setValue((String)newValue);
				return;
			case DiagonosticModelPackage.WHILE_LOOP__VALUE_TO:
				setValueTo((String)newValue);
				return;
			case DiagonosticModelPackage.WHILE_LOOP__OPERATOR:
				setOperator((OperatorTypeEnum)newValue);
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
			case DiagonosticModelPackage.WHILE_LOOP__VALUE:
				setValue(VALUE_EDEFAULT);
				return;
			case DiagonosticModelPackage.WHILE_LOOP__VALUE_TO:
				setValueTo(VALUE_TO_EDEFAULT);
				return;
			case DiagonosticModelPackage.WHILE_LOOP__OPERATOR:
				setOperator(OPERATOR_EDEFAULT);
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
			case DiagonosticModelPackage.WHILE_LOOP__VALUE:
				return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
			case DiagonosticModelPackage.WHILE_LOOP__VALUE_TO:
				return VALUE_TO_EDEFAULT == null ? valueTo != null : !VALUE_TO_EDEFAULT.equals(valueTo);
			case DiagonosticModelPackage.WHILE_LOOP__OPERATOR:
				return operator != OPERATOR_EDEFAULT;
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
		result.append(", valueTo: ");
		result.append(valueTo);
		result.append(", operator: ");
		result.append(operator);
		result.append(')');
		return result.toString();
	}

} //WhileLoopImpl
