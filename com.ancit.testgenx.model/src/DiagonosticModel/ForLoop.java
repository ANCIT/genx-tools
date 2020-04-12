/**
 */
package DiagonosticModel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>For Loop</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link DiagonosticModel.ForLoop#getLoopVar <em>Loop Var</em>}</li>
 *   <li>{@link DiagonosticModel.ForLoop#getStopValue <em>Stop Value</em>}</li>
 *   <li>{@link DiagonosticModel.ForLoop#getStartValue <em>Start Value</em>}</li>
 * </ul>
 *
 * @see DiagonosticModel.DiagonosticModelPackage#getForLoop()
 * @model
 * @generated
 */
public interface ForLoop extends BlockAction {
	/**
	 * Returns the value of the '<em><b>Loop Var</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Loop Var</em>' attribute.
	 * @see #setLoopVar(String)
	 * @see DiagonosticModel.DiagonosticModelPackage#getForLoop_LoopVar()
	 * @model
	 * @generated
	 */
	String getLoopVar();

	/**
	 * Sets the value of the '{@link DiagonosticModel.ForLoop#getLoopVar <em>Loop Var</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Loop Var</em>' attribute.
	 * @see #getLoopVar()
	 * @generated
	 */
	void setLoopVar(String value);

	/**
	 * Returns the value of the '<em><b>Stop Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stop Value</em>' attribute.
	 * @see #setStopValue(int)
	 * @see DiagonosticModel.DiagonosticModelPackage#getForLoop_StopValue()
	 * @model
	 * @generated
	 */
	int getStopValue();

	/**
	 * Sets the value of the '{@link DiagonosticModel.ForLoop#getStopValue <em>Stop Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stop Value</em>' attribute.
	 * @see #getStopValue()
	 * @generated
	 */
	void setStopValue(int value);

	/**
	 * Returns the value of the '<em><b>Start Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start Value</em>' attribute.
	 * @see #setStartValue(int)
	 * @see DiagonosticModel.DiagonosticModelPackage#getForLoop_StartValue()
	 * @model
	 * @generated
	 */
	int getStartValue();

	/**
	 * Sets the value of the '{@link DiagonosticModel.ForLoop#getStartValue <em>Start Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start Value</em>' attribute.
	 * @see #getStartValue()
	 * @generated
	 */
	void setStartValue(int value);

} // ForLoop
