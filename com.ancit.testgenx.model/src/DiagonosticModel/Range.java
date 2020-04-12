/**
 */
package DiagonosticModel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Range</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link DiagonosticModel.Range#getFrom <em>From</em>}</li>
 *   <li>{@link DiagonosticModel.Range#getTo <em>To</em>}</li>
 * </ul>
 *
 * @see DiagonosticModel.DiagonosticModelPackage#getRange()
 * @model
 * @generated
 */
public interface Range extends DiagnosticParamValueType {
	/**
	 * Returns the value of the '<em><b>From</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>From</em>' attribute.
	 * @see #setFrom(int)
	 * @see DiagonosticModel.DiagonosticModelPackage#getRange_From()
	 * @model required="true"
	 * @generated
	 */
	int getFrom();

	/**
	 * Sets the value of the '{@link DiagonosticModel.Range#getFrom <em>From</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>From</em>' attribute.
	 * @see #getFrom()
	 * @generated
	 */
	void setFrom(int value);

	/**
	 * Returns the value of the '<em><b>To</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To</em>' attribute.
	 * @see #setTo(int)
	 * @see DiagonosticModel.DiagonosticModelPackage#getRange_To()
	 * @model required="true"
	 * @generated
	 */
	int getTo();

	/**
	 * Sets the value of the '{@link DiagonosticModel.Range#getTo <em>To</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To</em>' attribute.
	 * @see #getTo()
	 * @generated
	 */
	void setTo(int value);

} // Range
