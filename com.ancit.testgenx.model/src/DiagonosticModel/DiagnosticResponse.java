/**
 */
package DiagonosticModel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Diagnostic Response</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link DiagonosticModel.DiagnosticResponse#getPrimitive <em>Primitive</em>}</li>
 *   <li>{@link DiagonosticModel.DiagnosticResponse#getDiagparam <em>Diagparam</em>}</li>
 * </ul>
 *
 * @see DiagonosticModel.DiagonosticModelPackage#getDiagnosticResponse()
 * @model
 * @generated
 */
public interface DiagnosticResponse extends EObject {
	/**
	 * Returns the value of the '<em><b>Primitive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Primitive</em>' attribute.
	 * @see #setPrimitive(String)
	 * @see DiagonosticModel.DiagonosticModelPackage#getDiagnosticResponse_Primitive()
	 * @model
	 * @generated
	 */
	String getPrimitive();

	/**
	 * Sets the value of the '{@link DiagonosticModel.DiagnosticResponse#getPrimitive <em>Primitive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Primitive</em>' attribute.
	 * @see #getPrimitive()
	 * @generated
	 */
	void setPrimitive(String value);

	/**
	 * Returns the value of the '<em><b>Diagparam</b></em>' containment reference list.
	 * The list contents are of type {@link DiagonosticModel.DiagnosticParam}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Diagparam</em>' containment reference list.
	 * @see DiagonosticModel.DiagonosticModelPackage#getDiagnosticResponse_Diagparam()
	 * @model containment="true"
	 * @generated
	 */
	EList<DiagnosticParam> getDiagparam();

} // DiagnosticResponse
