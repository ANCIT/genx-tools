/**
 */
package DiagonosticModel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>While Loop</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link DiagonosticModel.WhileLoop#getValue <em>Value</em>}</li>
 *   <li>{@link DiagonosticModel.WhileLoop#getValueTo <em>Value To</em>}</li>
 *   <li>{@link DiagonosticModel.WhileLoop#getOperator <em>Operator</em>}</li>
 * </ul>
 *
 * @see DiagonosticModel.DiagonosticModelPackage#getWhileLoop()
 * @model
 * @generated
 */
public interface WhileLoop extends BlockAction {

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see DiagonosticModel.DiagonosticModelPackage#getWhileLoop_Value()
	 * @model
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link DiagonosticModel.WhileLoop#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

	/**
	 * Returns the value of the '<em><b>Value To</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value To</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value To</em>' attribute.
	 * @see #setValueTo(String)
	 * @see DiagonosticModel.DiagonosticModelPackage#getWhileLoop_ValueTo()
	 * @model
	 * @generated
	 */
	String getValueTo();

	/**
	 * Sets the value of the '{@link DiagonosticModel.WhileLoop#getValueTo <em>Value To</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value To</em>' attribute.
	 * @see #getValueTo()
	 * @generated
	 */
	void setValueTo(String value);

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
	 * @see DiagonosticModel.DiagonosticModelPackage#getWhileLoop_Operator()
	 * @model
	 * @generated
	 */
	OperatorTypeEnum getOperator();

	/**
	 * Sets the value of the '{@link DiagonosticModel.WhileLoop#getOperator <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Operator</em>' attribute.
	 * @see DiagonosticModel.OperatorTypeEnum
	 * @see #getOperator()
	 * @generated
	 */
	void setOperator(OperatorTypeEnum value);
} // WhileLoop
