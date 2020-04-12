/**
 */
package DiagonosticModel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Test Group</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link DiagonosticModel.TestGroup#getName <em>Name</em>}</li>
 *   <li>{@link DiagonosticModel.TestGroup#getTestCases <em>Test Cases</em>}</li>
 *   <li>{@link DiagonosticModel.TestGroup#getDescription <em>Description</em>}</li>
 *   <li>{@link DiagonosticModel.TestGroup#getExternalreference <em>Externalreference</em>}</li>
 *   <li>{@link DiagonosticModel.TestGroup#getTestGroups <em>Test Groups</em>}</li>
 *   <li>{@link DiagonosticModel.TestGroup#getCapltestcases <em>Capltestcases</em>}</li>
 * </ul>
 *
 * @see DiagonosticModel.DiagonosticModelPackage#getTestGroup()
 * @model
 * @generated
 */
public interface TestGroup extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see DiagonosticModel.DiagonosticModelPackage#getTestGroup_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link DiagonosticModel.TestGroup#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Test Cases</b></em>' containment reference list.
	 * The list contents are of type {@link DiagonosticModel.TestCase}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Test Cases</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Test Cases</em>' containment reference list.
	 * @see DiagonosticModel.DiagonosticModelPackage#getTestGroup_TestCases()
	 * @model containment="true"
	 * @generated
	 */
	EList<TestCase> getTestCases();

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see DiagonosticModel.DiagonosticModelPackage#getTestGroup_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link DiagonosticModel.TestGroup#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Externalreference</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Externalreference</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Externalreference</em>' containment reference.
	 * @see #setExternalreference(ExternalReference)
	 * @see DiagonosticModel.DiagonosticModelPackage#getTestGroup_Externalreference()
	 * @model containment="true"
	 * @generated
	 */
	ExternalReference getExternalreference();

	/**
	 * Sets the value of the '{@link DiagonosticModel.TestGroup#getExternalreference <em>Externalreference</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Externalreference</em>' containment reference.
	 * @see #getExternalreference()
	 * @generated
	 */
	void setExternalreference(ExternalReference value);

	/**
	 * Returns the value of the '<em><b>Test Groups</b></em>' containment reference list.
	 * The list contents are of type {@link DiagonosticModel.TestGroup}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Test Groups</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Test Groups</em>' containment reference list.
	 * @see DiagonosticModel.DiagonosticModelPackage#getTestGroup_TestGroups()
	 * @model containment="true"
	 * @generated
	 */
	EList<TestGroup> getTestGroups();

	/**
	 * Returns the value of the '<em><b>Capltestcases</b></em>' containment reference list.
	 * The list contents are of type {@link DiagonosticModel.CAPLTestCase}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capltestcases</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capltestcases</em>' containment reference list.
	 * @see DiagonosticModel.DiagonosticModelPackage#getTestGroup_Capltestcases()
	 * @model containment="true"
	 * @generated
	 */
	EList<CAPLTestCase> getCapltestcases();

} // TestGroup
