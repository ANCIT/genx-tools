/**
 */
package DiagonosticModel;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see DiagonosticModel.DiagonosticModelPackage
 * @generated
 */
public interface DiagonosticModelFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DiagonosticModelFactory eINSTANCE = DiagonosticModel.impl.DiagonosticModelFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Test Specification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Test Specification</em>'.
	 * @generated
	 */
	TestSpecification createTestSpecification();

	/**
	 * Returns a new object of class '<em>Test Group</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Test Group</em>'.
	 * @generated
	 */
	TestGroup createTestGroup();

	/**
	 * Returns a new object of class '<em>Test Case</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Test Case</em>'.
	 * @generated
	 */
	TestCase createTestCase();

	/**
	 * Returns a new object of class '<em>Wait Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Wait Action</em>'.
	 * @generated
	 */
	WaitAction createWaitAction();

	/**
	 * Returns a new object of class '<em>Check Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Check Action</em>'.
	 * @generated
	 */
	CheckAction createCheckAction();

	/**
	 * Returns a new object of class '<em>Set Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Set Action</em>'.
	 * @generated
	 */
	SetAction createSetAction();

	/**
	 * Returns a new object of class '<em>Signal Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Signal Type</em>'.
	 * @generated
	 */
	SignalType createSignalType();

	/**
	 * Returns a new object of class '<em>Diagnostic Service</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Diagnostic Service</em>'.
	 * @generated
	 */
	DiagnosticService createDiagnosticService();

	/**
	 * Returns a new object of class '<em>External Reference</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>External Reference</em>'.
	 * @generated
	 */
	ExternalReference createExternalReference();

	/**
	 * Returns a new object of class '<em>CAPL Test Case</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CAPL Test Case</em>'.
	 * @generated
	 */
	CAPLTestCase createCAPLTestCase();

	/**
	 * Returns a new object of class '<em>CAPL Param</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CAPL Param</em>'.
	 * @generated
	 */
	CAPLParam createCAPLParam();

	/**
	 * Returns a new object of class '<em>Variant</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Variant</em>'.
	 * @generated
	 */
	Variant createVariant();

	/**
	 * Returns a new object of class '<em>CAPL Test Step</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CAPL Test Step</em>'.
	 * @generated
	 */
	CAPLTestStep createCAPLTestStep();

	/**
	 * Returns a new object of class '<em>Import Artifact</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Import Artifact</em>'.
	 * @generated
	 */
	ImportArtifact createImportArtifact();

	/**
	 * Returns a new object of class '<em>Diagnostic Request</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Diagnostic Request</em>'.
	 * @generated
	 */
	DiagnosticRequest createDiagnosticRequest();

	/**
	 * Returns a new object of class '<em>Diagnostic Response</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Diagnostic Response</em>'.
	 * @generated
	 */
	DiagnosticResponse createDiagnosticResponse();

	/**
	 * Returns a new object of class '<em>Diagnostic Param</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Diagnostic Param</em>'.
	 * @generated
	 */
	DiagnosticParam createDiagnosticParam();

	/**
	 * Returns a new object of class '<em>Block Action</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Block Action</em>'.
	 * @generated
	 */
	BlockAction createBlockAction();

	/**
	 * Returns a new object of class '<em>For Loop</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>For Loop</em>'.
	 * @generated
	 */
	ForLoop createForLoop();

	/**
	 * Returns a new object of class '<em>While Loop</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>While Loop</em>'.
	 * @generated
	 */
	WhileLoop createWhileLoop();

	/**
	 * Returns a new object of class '<em>Var</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Var</em>'.
	 * @generated
	 */
	Var createVar();

	/**
	 * Returns a new object of class '<em>One Of</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>One Of</em>'.
	 * @generated
	 */
	OneOf createOneOf();

	/**
	 * Returns a new object of class '<em>Range</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Range</em>'.
	 * @generated
	 */
	Range createRange();

	/**
	 * Returns a new object of class '<em>Tracebility Artifact</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tracebility Artifact</em>'.
	 * @generated
	 */
	TracebilityArtifact createTracebilityArtifact();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	DiagonosticModelPackage getDiagonosticModelPackage();

} //DiagonosticModelFactory
