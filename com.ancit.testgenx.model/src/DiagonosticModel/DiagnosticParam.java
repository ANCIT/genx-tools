/**
 */
package DiagonosticModel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Diagnostic Param</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link DiagonosticModel.DiagnosticParam#getQualifier <em>Qualifier</em>}</li>
 *   <li>{@link DiagonosticModel.DiagnosticParam#getCopyToVar <em>Copy To Var</em>}</li>
 *   <li>{@link DiagonosticModel.DiagnosticParam#getValueTypes <em>Value Types</em>}</li>
 * </ul>
 *
 * @see DiagonosticModel.DiagonosticModelPackage#getDiagnosticParam()
 * @model
 * @generated
 */
public interface DiagnosticParam extends EObject {
	/**
	 * Returns the value of the '<em><b>Qualifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Qualifier</em>' attribute.
	 * @see #setQualifier(String)
	 * @see DiagonosticModel.DiagonosticModelPackage#getDiagnosticParam_Qualifier()
	 * @model
	 * @generated
	 */
	String getQualifier();

	/**
	 * Sets the value of the '{@link DiagonosticModel.DiagnosticParam#getQualifier <em>Qualifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Qualifier</em>' attribute.
	 * @see #getQualifier()
	 * @generated
	 */
	void setQualifier(String value);

	/**
	 * Returns the value of the '<em><b>Copy To Var</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Copy To Var</em>' attribute.
	 * @see #setCopyToVar(String)
	 * @see DiagonosticModel.DiagonosticModelPackage#getDiagnosticParam_CopyToVar()
	 * @model
	 * @generated
	 */
	String getCopyToVar();

	/**
	 * Sets the value of the '{@link DiagonosticModel.DiagnosticParam#getCopyToVar <em>Copy To Var</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Copy To Var</em>' attribute.
	 * @see #getCopyToVar()
	 * @generated
	 */
	void setCopyToVar(String value);

	/**
	 * Returns the value of the '<em><b>Value Types</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value Types</em>' containment reference.
	 * @see #setValueTypes(DiagnosticParamValueType)
	 * @see DiagonosticModel.DiagonosticModelPackage#getDiagnosticParam_ValueTypes()
	 * @model containment="true" required="true"
	 * @generated
	 */
	DiagnosticParamValueType getValueTypes();

	/**
	 * Sets the value of the '{@link DiagonosticModel.DiagnosticParam#getValueTypes <em>Value Types</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value Types</em>' containment reference.
	 * @see #getValueTypes()
	 * @generated
	 */
	void setValueTypes(DiagnosticParamValueType value);

} // DiagnosticParam
