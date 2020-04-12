/**
 */
package DiagonosticModel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Test Case</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link DiagonosticModel.TestCase#getName <em>Name</em>}</li>
 *   <li>{@link DiagonosticModel.TestCase#getTestSteps <em>Test Steps</em>}</li>
 *   <li>{@link DiagonosticModel.TestCase#getId <em>Id</em>}</li>
 *   <li>{@link DiagonosticModel.TestCase#getDescription <em>Description</em>}</li>
 *   <li>{@link DiagonosticModel.TestCase#getVariants <em>Variants</em>}</li>
 *   <li>{@link DiagonosticModel.TestCase#getPreConditions <em>Pre Conditions</em>}</li>
 *   <li>{@link DiagonosticModel.TestCase#getPostConditions <em>Post Conditions</em>}</li>
 *   <li>{@link DiagonosticModel.TestCase#getRequirementID <em>Requirement ID</em>}</li>
 *   <li>{@link DiagonosticModel.TestCase#getExecutionStatus <em>Execution Status</em>}</li>
 *   <li>{@link DiagonosticModel.TestCase#getExternalreference <em>Externalreference</em>}</li>
 *   <li>{@link DiagonosticModel.TestCase#isSkip <em>Skip</em>}</li>
 *   <li>{@link DiagonosticModel.TestCase#getTraceabilityArtifacts <em>Traceability Artifacts</em>}</li>
 * </ul>
 *
 * @see DiagonosticModel.DiagonosticModelPackage#getTestCase()
 * @model
 * @generated
 */
public interface TestCase extends EObject {
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
	 * @see DiagonosticModel.DiagonosticModelPackage#getTestCase_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link DiagonosticModel.TestCase#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Test Steps</b></em>' containment reference list.
	 * The list contents are of type {@link DiagonosticModel.TestStep}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Test Steps</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Test Steps</em>' containment reference list.
	 * @see DiagonosticModel.DiagonosticModelPackage#getTestCase_TestSteps()
	 * @model containment="true"
	 * @generated
	 */
	EList<TestStep> getTestSteps();

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(String)
	 * @see DiagonosticModel.DiagonosticModelPackage#getTestCase_Id()
	 * @model
	 * @generated
	 */
	String getId();

	/**
	 * Sets the value of the '{@link DiagonosticModel.TestCase#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(String value);

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
	 * @see DiagonosticModel.DiagonosticModelPackage#getTestCase_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link DiagonosticModel.TestCase#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Variants</b></em>' reference list.
	 * The list contents are of type {@link DiagonosticModel.Variant}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variants</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variants</em>' reference list.
	 * @see DiagonosticModel.DiagonosticModelPackage#getTestCase_Variants()
	 * @model
	 * @generated
	 */
	EList<Variant> getVariants();

	/**
	 * Returns the value of the '<em><b>Pre Conditions</b></em>' containment reference list.
	 * The list contents are of type {@link DiagonosticModel.TestStep}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Pre Conditions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Pre Conditions</em>' containment reference list.
	 * @see DiagonosticModel.DiagonosticModelPackage#getTestCase_PreConditions()
	 * @model containment="true"
	 * @generated
	 */
	EList<TestStep> getPreConditions();

	/**
	 * Returns the value of the '<em><b>Post Conditions</b></em>' containment reference list.
	 * The list contents are of type {@link DiagonosticModel.TestStep}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Post Conditions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Post Conditions</em>' containment reference list.
	 * @see DiagonosticModel.DiagonosticModelPackage#getTestCase_PostConditions()
	 * @model containment="true"
	 * @generated
	 */
	EList<TestStep> getPostConditions();

	/**
	 * Returns the value of the '<em><b>Requirement ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Requirement ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Requirement ID</em>' attribute.
	 * @see #setRequirementID(String)
	 * @see DiagonosticModel.DiagonosticModelPackage#getTestCase_RequirementID()
	 * @model
	 * @generated
	 */
	String getRequirementID();

	/**
	 * Sets the value of the '{@link DiagonosticModel.TestCase#getRequirementID <em>Requirement ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Requirement ID</em>' attribute.
	 * @see #getRequirementID()
	 * @generated
	 */
	void setRequirementID(String value);

	/**
	 * Returns the value of the '<em><b>Execution Status</b></em>' attribute.
	 * The literals are from the enumeration {@link DiagonosticModel.ExecutionStatueTypeEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Execution Status</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Execution Status</em>' attribute.
	 * @see DiagonosticModel.ExecutionStatueTypeEnum
	 * @see #setExecutionStatus(ExecutionStatueTypeEnum)
	 * @see DiagonosticModel.DiagonosticModelPackage#getTestCase_ExecutionStatus()
	 * @model
	 * @generated
	 */
	ExecutionStatueTypeEnum getExecutionStatus();

	/**
	 * Sets the value of the '{@link DiagonosticModel.TestCase#getExecutionStatus <em>Execution Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Execution Status</em>' attribute.
	 * @see DiagonosticModel.ExecutionStatueTypeEnum
	 * @see #getExecutionStatus()
	 * @generated
	 */
	void setExecutionStatus(ExecutionStatueTypeEnum value);

	/**
	 * Returns the value of the '<em><b>Externalreference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Externalreference</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Externalreference</em>' reference.
	 * @see #setExternalreference(ExternalReference)
	 * @see DiagonosticModel.DiagonosticModelPackage#getTestCase_Externalreference()
	 * @model
	 * @generated
	 */
	ExternalReference getExternalreference();

	/**
	 * Sets the value of the '{@link DiagonosticModel.TestCase#getExternalreference <em>Externalreference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Externalreference</em>' reference.
	 * @see #getExternalreference()
	 * @generated
	 */
	void setExternalreference(ExternalReference value);

	/**
	 * Returns the value of the '<em><b>Skip</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Skip</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Skip</em>' attribute.
	 * @see #setSkip(boolean)
	 * @see DiagonosticModel.DiagonosticModelPackage#getTestCase_Skip()
	 * @model
	 * @generated
	 */
	boolean isSkip();

	/**
	 * Sets the value of the '{@link DiagonosticModel.TestCase#isSkip <em>Skip</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Skip</em>' attribute.
	 * @see #isSkip()
	 * @generated
	 */
	void setSkip(boolean value);

	/**
	 * Returns the value of the '<em><b>Traceability Artifacts</b></em>' containment reference list.
	 * The list contents are of type {@link DiagonosticModel.TracebilityArtifact}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Traceability Artifacts</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Traceability Artifacts</em>' containment reference list.
	 * @see DiagonosticModel.DiagonosticModelPackage#getTestCase_TraceabilityArtifacts()
	 * @model containment="true"
	 * @generated
	 */
	EList<TracebilityArtifact> getTraceabilityArtifacts();

} // TestCase
