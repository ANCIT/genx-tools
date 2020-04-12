/**
 */
package DiagonosticModel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link DiagonosticModel.Action#getValue <em>Value</em>}</li>
 *   <li>{@link DiagonosticModel.Action#getWait <em>Wait</em>}</li>
 *   <li>{@link DiagonosticModel.Action#getValueTo <em>Value To</em>}</li>
 * </ul>
 *
 * @see DiagonosticModel.DiagonosticModelPackage#getAction()
 * @model abstract="true"
 * @generated
 */
public interface Action extends TestStep {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see DiagonosticModel.DiagonosticModelPackage#getAction_Value()
	 * @model
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link DiagonosticModel.Action#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

	/**
	 * Returns the value of the '<em><b>Wait</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Wait</em>' attribute.
	 * @see #setWait(float)
	 * @see DiagonosticModel.DiagonosticModelPackage#getAction_Wait()
	 * @model
	 * @generated
	 */
	float getWait();

	/**
	 * Sets the value of the '{@link DiagonosticModel.Action#getWait <em>Wait</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Wait</em>' attribute.
	 * @see #getWait()
	 * @generated
	 */
	void setWait(float value);

	/**
	 * Returns the value of the '<em><b>Value To</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value To</em>' attribute.
	 * @see #setValueTo(String)
	 * @see DiagonosticModel.DiagonosticModelPackage#getAction_ValueTo()
	 * @model
	 * @generated
	 */
	String getValueTo();

	/**
	 * Sets the value of the '{@link DiagonosticModel.Action#getValueTo <em>Value To</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value To</em>' attribute.
	 * @see #getValueTo()
	 * @generated
	 */
	void setValueTo(String value);

} // Action
