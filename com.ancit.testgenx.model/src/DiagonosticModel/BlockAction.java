/**
 */
package DiagonosticModel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Block Action</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link DiagonosticModel.BlockAction#getTestSteps <em>Test Steps</em>}</li>
 * </ul>
 *
 * @see DiagonosticModel.DiagonosticModelPackage#getBlockAction()
 * @model
 * @generated
 */
public interface BlockAction extends TestStep {
	/**
	 * Returns the value of the '<em><b>Test Steps</b></em>' containment reference list.
	 * The list contents are of type {@link DiagonosticModel.TestStep}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Test Steps</em>' containment reference list.
	 * @see DiagonosticModel.DiagonosticModelPackage#getBlockAction_TestSteps()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<TestStep> getTestSteps();

} // BlockAction
