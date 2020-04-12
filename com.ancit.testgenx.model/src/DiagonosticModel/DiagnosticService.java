/**
 */
package DiagonosticModel;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Diagnostic Service</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link DiagonosticModel.DiagnosticService#getEcu <em>Ecu</em>}</li>
 *   <li>{@link DiagonosticModel.DiagnosticService#getService <em>Service</em>}</li>
 *   <li>{@link DiagonosticModel.DiagnosticService#getResult <em>Result</em>}</li>
 *   <li>{@link DiagonosticModel.DiagnosticService#getDiagrequest <em>Diagrequest</em>}</li>
 *   <li>{@link DiagonosticModel.DiagnosticService#getDiagresponse <em>Diagresponse</em>}</li>
 * </ul>
 *
 * @see DiagonosticModel.DiagonosticModelPackage#getDiagnosticService()
 * @model
 * @generated
 */
public interface DiagnosticService extends Action {
	/**
	 * Returns the value of the '<em><b>Ecu</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ecu</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ecu</em>' attribute.
	 * @see #setEcu(String)
	 * @see DiagonosticModel.DiagonosticModelPackage#getDiagnosticService_Ecu()
	 * @model
	 * @generated
	 */
	String getEcu();

	/**
	 * Sets the value of the '{@link DiagonosticModel.DiagnosticService#getEcu <em>Ecu</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ecu</em>' attribute.
	 * @see #getEcu()
	 * @generated
	 */
	void setEcu(String value);

	/**
	 * Returns the value of the '<em><b>Service</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Service</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Service</em>' attribute.
	 * @see #setService(String)
	 * @see DiagonosticModel.DiagonosticModelPackage#getDiagnosticService_Service()
	 * @model
	 * @generated
	 */
	String getService();

	/**
	 * Sets the value of the '{@link DiagonosticModel.DiagnosticService#getService <em>Service</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Service</em>' attribute.
	 * @see #getService()
	 * @generated
	 */
	void setService(String value);

	/**
	 * Returns the value of the '<em><b>Result</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Result</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Result</em>' attribute.
	 * @see #setResult(String)
	 * @see DiagonosticModel.DiagonosticModelPackage#getDiagnosticService_Result()
	 * @model
	 * @generated
	 */
	String getResult();

	/**
	 * Sets the value of the '{@link DiagonosticModel.DiagnosticService#getResult <em>Result</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Result</em>' attribute.
	 * @see #getResult()
	 * @generated
	 */
	void setResult(String value);

	/**
	 * Returns the value of the '<em><b>Diagrequest</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Diagrequest</em>' containment reference.
	 * @see #setDiagrequest(DiagnosticRequest)
	 * @see DiagonosticModel.DiagonosticModelPackage#getDiagnosticService_Diagrequest()
	 * @model containment="true" required="true"
	 * @generated
	 */
	DiagnosticRequest getDiagrequest();

	/**
	 * Sets the value of the '{@link DiagonosticModel.DiagnosticService#getDiagrequest <em>Diagrequest</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Diagrequest</em>' containment reference.
	 * @see #getDiagrequest()
	 * @generated
	 */
	void setDiagrequest(DiagnosticRequest value);

	/**
	 * Returns the value of the '<em><b>Diagresponse</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Diagresponse</em>' containment reference.
	 * @see #setDiagresponse(DiagnosticResponse)
	 * @see DiagonosticModel.DiagonosticModelPackage#getDiagnosticService_Diagresponse()
	 * @model containment="true" required="true"
	 * @generated
	 */
	DiagnosticResponse getDiagresponse();

	/**
	 * Sets the value of the '{@link DiagonosticModel.DiagnosticService#getDiagresponse <em>Diagresponse</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Diagresponse</em>' containment reference.
	 * @see #getDiagresponse()
	 * @generated
	 */
	void setDiagresponse(DiagnosticResponse value);

} // DiagnosticService
