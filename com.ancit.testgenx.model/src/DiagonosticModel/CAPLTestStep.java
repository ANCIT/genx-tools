/**
 */
package DiagonosticModel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CAPL Test Step</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link DiagonosticModel.CAPLTestStep#getParameters <em>Parameters</em>}</li>
 * </ul>
 *
 * @see DiagonosticModel.DiagonosticModelPackage#getCAPLTestStep()
 * @model
 * @generated
 */
public interface CAPLTestStep extends Action {
	/**
	 * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
	 * The list contents are of type {@link DiagonosticModel.CAPLParam}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parameters</em>' containment reference list.
	 * @see DiagonosticModel.DiagonosticModelPackage#getCAPLTestStep_Parameters()
	 * @model containment="true"
	 * @generated
	 */
	EList<CAPLParam> getParameters();

} // CAPLTestStep
