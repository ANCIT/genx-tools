/**
 */
package DiagonosticModel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Diagnostic Request</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link DiagonosticModel.DiagnosticRequest#getDiagparam <em>Diagparam</em>}</li>
 * </ul>
 *
 * @see DiagonosticModel.DiagonosticModelPackage#getDiagnosticRequest()
 * @model
 * @generated
 */
public interface DiagnosticRequest extends EObject {
	/**
	 * Returns the value of the '<em><b>Diagparam</b></em>' containment reference list.
	 * The list contents are of type {@link DiagonosticModel.DiagnosticParam}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Diagparam</em>' containment reference list.
	 * @see DiagonosticModel.DiagonosticModelPackage#getDiagnosticRequest_Diagparam()
	 * @model containment="true"
	 * @generated
	 */
	EList<DiagnosticParam> getDiagparam();

} // DiagnosticRequest
