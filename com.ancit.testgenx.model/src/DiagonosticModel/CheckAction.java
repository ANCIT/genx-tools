/**
 */
package DiagonosticModel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Check Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link DiagonosticModel.CheckAction#getOperator <em>Operator</em>}</li>
 * </ul>
 *
 * @see DiagonosticModel.DiagonosticModelPackage#getCheckAction()
 * @model
 * @generated
 */
public interface CheckAction extends Action {
	/**
	 * Returns the value of the '<em><b>Operator</b></em>' attribute.
	 * The literals are from the enumeration {@link DiagonosticModel.OperatorTypeEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operator</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operator</em>' attribute.
	 * @see DiagonosticModel.OperatorTypeEnum
	 * @see #setOperator(OperatorTypeEnum)
	 * @see DiagonosticModel.DiagonosticModelPackage#getCheckAction_Operator()
	 * @model
	 * @generated
	 */
	OperatorTypeEnum getOperator();

	/**
	 * Sets the value of the '{@link DiagonosticModel.CheckAction#getOperator <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operator</em>' attribute.
	 * @see DiagonosticModel.OperatorTypeEnum
	 * @see #getOperator()
	 * @generated
	 */
	void setOperator(OperatorTypeEnum value);

} // CheckAction
