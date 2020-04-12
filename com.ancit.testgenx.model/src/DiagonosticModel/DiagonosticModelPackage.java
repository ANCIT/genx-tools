/**
 */
package DiagonosticModel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see DiagonosticModel.DiagonosticModelFactory
 * @model kind="package"
 * @generated
 */
public interface DiagonosticModelPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "DiagonosticModel";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.ancit.com";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "DiagonosticModel";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	DiagonosticModelPackage eINSTANCE = DiagonosticModel.impl.DiagonosticModelPackageImpl.init();

	/**
	 * The meta object id for the '{@link DiagonosticModel.impl.TestSpecificationImpl <em>Test Specification</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DiagonosticModel.impl.TestSpecificationImpl
	 * @see DiagonosticModel.impl.DiagonosticModelPackageImpl#getTestSpecification()
	 * @generated
	 */
	int TEST_SPECIFICATION = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_SPECIFICATION__NAME = 0;

	/**
	 * The feature id for the '<em><b>Test Groups</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_SPECIFICATION__TEST_GROUPS = 1;

	/**
	 * The feature id for the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_SPECIFICATION__VERSION = 2;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_SPECIFICATION__DESCRIPTION = 3;

	/**
	 * The feature id for the '<em><b>Function Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_SPECIFICATION__FUNCTION_NAME = 4;

	/**
	 * The feature id for the '<em><b>Function Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_SPECIFICATION__FUNCTION_VERSION = 5;

	/**
	 * The feature id for the '<em><b>Author</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_SPECIFICATION__AUTHOR = 6;

	/**
	 * The feature id for the '<em><b>Capltestcases</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_SPECIFICATION__CAPLTESTCASES = 7;

	/**
	 * The feature id for the '<em><b>Variants</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_SPECIFICATION__VARIANTS = 8;

	/**
	 * The feature id for the '<em><b>Import Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_SPECIFICATION__IMPORT_ARTIFACTS = 9;

	/**
	 * The number of structural features of the '<em>Test Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_SPECIFICATION_FEATURE_COUNT = 10;

	/**
	 * The operation id for the '<em>Get Signals</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_SPECIFICATION___GET_SIGNALS = 0;

	/**
	 * The number of operations of the '<em>Test Specification</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_SPECIFICATION_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link DiagonosticModel.impl.TestGroupImpl <em>Test Group</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DiagonosticModel.impl.TestGroupImpl
	 * @see DiagonosticModel.impl.DiagonosticModelPackageImpl#getTestGroup()
	 * @generated
	 */
	int TEST_GROUP = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_GROUP__NAME = 0;

	/**
	 * The feature id for the '<em><b>Test Cases</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_GROUP__TEST_CASES = 1;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_GROUP__DESCRIPTION = 2;

	/**
	 * The feature id for the '<em><b>Externalreference</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_GROUP__EXTERNALREFERENCE = 3;

	/**
	 * The feature id for the '<em><b>Test Groups</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_GROUP__TEST_GROUPS = 4;

	/**
	 * The feature id for the '<em><b>Capltestcases</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_GROUP__CAPLTESTCASES = 5;

	/**
	 * The number of structural features of the '<em>Test Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_GROUP_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>Test Group</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_GROUP_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link DiagonosticModel.impl.TestCaseImpl <em>Test Case</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DiagonosticModel.impl.TestCaseImpl
	 * @see DiagonosticModel.impl.DiagonosticModelPackageImpl#getTestCase()
	 * @generated
	 */
	int TEST_CASE = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_CASE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Test Steps</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_CASE__TEST_STEPS = 1;

	/**
	 * The feature id for the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_CASE__ID = 2;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_CASE__DESCRIPTION = 3;

	/**
	 * The feature id for the '<em><b>Variants</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_CASE__VARIANTS = 4;

	/**
	 * The feature id for the '<em><b>Pre Conditions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_CASE__PRE_CONDITIONS = 5;

	/**
	 * The feature id for the '<em><b>Post Conditions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_CASE__POST_CONDITIONS = 6;

	/**
	 * The feature id for the '<em><b>Requirement ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_CASE__REQUIREMENT_ID = 7;

	/**
	 * The feature id for the '<em><b>Execution Status</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_CASE__EXECUTION_STATUS = 8;

	/**
	 * The feature id for the '<em><b>Externalreference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_CASE__EXTERNALREFERENCE = 9;

	/**
	 * The feature id for the '<em><b>Skip</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_CASE__SKIP = 10;

	/**
	 * The feature id for the '<em><b>Traceability Artifacts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_CASE__TRACEABILITY_ARTIFACTS = 11;

	/**
	 * The number of structural features of the '<em>Test Case</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_CASE_FEATURE_COUNT = 12;

	/**
	 * The number of operations of the '<em>Test Case</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_CASE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link DiagonosticModel.impl.TestStepImpl <em>Test Step</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DiagonosticModel.impl.TestStepImpl
	 * @see DiagonosticModel.impl.DiagonosticModelPackageImpl#getTestStep()
	 * @generated
	 */
	int TEST_STEP = 3;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_STEP__TITLE = 0;

	/**
	 * The feature id for the '<em><b>Next Step</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_STEP__NEXT_STEP = 1;

	/**
	 * The feature id for the '<em><b>Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_STEP__KEY = 2;

	/**
	 * The number of structural features of the '<em>Test Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_STEP_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Test Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEST_STEP_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link DiagonosticModel.impl.ActionImpl <em>Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DiagonosticModel.impl.ActionImpl
	 * @see DiagonosticModel.impl.DiagonosticModelPackageImpl#getAction()
	 * @generated
	 */
	int ACTION = 18;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__TITLE = TEST_STEP__TITLE;

	/**
	 * The feature id for the '<em><b>Next Step</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__NEXT_STEP = TEST_STEP__NEXT_STEP;

	/**
	 * The feature id for the '<em><b>Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__KEY = TEST_STEP__KEY;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__VALUE = TEST_STEP_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Wait</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__WAIT = TEST_STEP_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Value To</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION__VALUE_TO = TEST_STEP_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_FEATURE_COUNT = TEST_STEP_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTION_OPERATION_COUNT = TEST_STEP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link DiagonosticModel.impl.WaitActionImpl <em>Wait Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DiagonosticModel.impl.WaitActionImpl
	 * @see DiagonosticModel.impl.DiagonosticModelPackageImpl#getWaitAction()
	 * @generated
	 */
	int WAIT_ACTION = 4;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_ACTION__TITLE = ACTION__TITLE;

	/**
	 * The feature id for the '<em><b>Next Step</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_ACTION__NEXT_STEP = ACTION__NEXT_STEP;

	/**
	 * The feature id for the '<em><b>Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_ACTION__KEY = ACTION__KEY;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_ACTION__VALUE = ACTION__VALUE;

	/**
	 * The feature id for the '<em><b>Wait</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_ACTION__WAIT = ACTION__WAIT;

	/**
	 * The feature id for the '<em><b>Value To</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_ACTION__VALUE_TO = ACTION__VALUE_TO;

	/**
	 * The number of structural features of the '<em>Wait Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_ACTION_FEATURE_COUNT = ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Wait Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WAIT_ACTION_OPERATION_COUNT = ACTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link DiagonosticModel.impl.CheckActionImpl <em>Check Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DiagonosticModel.impl.CheckActionImpl
	 * @see DiagonosticModel.impl.DiagonosticModelPackageImpl#getCheckAction()
	 * @generated
	 */
	int CHECK_ACTION = 5;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK_ACTION__TITLE = ACTION__TITLE;

	/**
	 * The feature id for the '<em><b>Next Step</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK_ACTION__NEXT_STEP = ACTION__NEXT_STEP;

	/**
	 * The feature id for the '<em><b>Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK_ACTION__KEY = ACTION__KEY;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK_ACTION__VALUE = ACTION__VALUE;

	/**
	 * The feature id for the '<em><b>Wait</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK_ACTION__WAIT = ACTION__WAIT;

	/**
	 * The feature id for the '<em><b>Value To</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK_ACTION__VALUE_TO = ACTION__VALUE_TO;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK_ACTION__OPERATOR = ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Check Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK_ACTION_FEATURE_COUNT = ACTION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Check Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK_ACTION_OPERATION_COUNT = ACTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link DiagonosticModel.impl.SetActionImpl <em>Set Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DiagonosticModel.impl.SetActionImpl
	 * @see DiagonosticModel.impl.DiagonosticModelPackageImpl#getSetAction()
	 * @generated
	 */
	int SET_ACTION = 6;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_ACTION__TITLE = ACTION__TITLE;

	/**
	 * The feature id for the '<em><b>Next Step</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_ACTION__NEXT_STEP = ACTION__NEXT_STEP;

	/**
	 * The feature id for the '<em><b>Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_ACTION__KEY = ACTION__KEY;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_ACTION__VALUE = ACTION__VALUE;

	/**
	 * The feature id for the '<em><b>Wait</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_ACTION__WAIT = ACTION__WAIT;

	/**
	 * The feature id for the '<em><b>Value To</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_ACTION__VALUE_TO = ACTION__VALUE_TO;

	/**
	 * The number of structural features of the '<em>Set Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_ACTION_FEATURE_COUNT = ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Set Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SET_ACTION_OPERATION_COUNT = ACTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link DiagonosticModel.impl.SignalTypeImpl <em>Signal Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DiagonosticModel.impl.SignalTypeImpl
	 * @see DiagonosticModel.impl.DiagonosticModelPackageImpl#getSignalType()
	 * @generated
	 */
	int SIGNAL_TYPE = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGNAL_TYPE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGNAL_TYPE__TYPE = 1;

	/**
	 * The feature id for the '<em><b>Message Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGNAL_TYPE__MESSAGE_NAME = 2;

	/**
	 * The feature id for the '<em><b>Node</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGNAL_TYPE__NODE = 3;

	/**
	 * The feature id for the '<em><b>Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGNAL_TYPE__NAMESPACE = 4;

	/**
	 * The feature id for the '<em><b>Creation Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGNAL_TYPE__CREATION_MODE = 5;

	/**
	 * The feature id for the '<em><b>Lookup Values</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGNAL_TYPE__LOOKUP_VALUES = 6;

	/**
	 * The number of structural features of the '<em>Signal Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGNAL_TYPE_FEATURE_COUNT = 7;

	/**
	 * The number of operations of the '<em>Signal Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SIGNAL_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link DiagonosticModel.impl.DiagnosticServiceImpl <em>Diagnostic Service</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DiagonosticModel.impl.DiagnosticServiceImpl
	 * @see DiagonosticModel.impl.DiagonosticModelPackageImpl#getDiagnosticService()
	 * @generated
	 */
	int DIAGNOSTIC_SERVICE = 8;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGNOSTIC_SERVICE__TITLE = ACTION__TITLE;

	/**
	 * The feature id for the '<em><b>Next Step</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGNOSTIC_SERVICE__NEXT_STEP = ACTION__NEXT_STEP;

	/**
	 * The feature id for the '<em><b>Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGNOSTIC_SERVICE__KEY = ACTION__KEY;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGNOSTIC_SERVICE__VALUE = ACTION__VALUE;

	/**
	 * The feature id for the '<em><b>Wait</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGNOSTIC_SERVICE__WAIT = ACTION__WAIT;

	/**
	 * The feature id for the '<em><b>Value To</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGNOSTIC_SERVICE__VALUE_TO = ACTION__VALUE_TO;

	/**
	 * The feature id for the '<em><b>Ecu</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGNOSTIC_SERVICE__ECU = ACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Service</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGNOSTIC_SERVICE__SERVICE = ACTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Result</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGNOSTIC_SERVICE__RESULT = ACTION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Diagrequest</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGNOSTIC_SERVICE__DIAGREQUEST = ACTION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Diagresponse</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGNOSTIC_SERVICE__DIAGRESPONSE = ACTION_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>Diagnostic Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGNOSTIC_SERVICE_FEATURE_COUNT = ACTION_FEATURE_COUNT + 5;

	/**
	 * The number of operations of the '<em>Diagnostic Service</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGNOSTIC_SERVICE_OPERATION_COUNT = ACTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link DiagonosticModel.impl.ExternalReferenceImpl <em>External Reference</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DiagonosticModel.impl.ExternalReferenceImpl
	 * @see DiagonosticModel.impl.DiagonosticModelPackageImpl#getExternalReference()
	 * @generated
	 */
	int EXTERNAL_REFERENCE = 9;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_REFERENCE__TITLE = 0;

	/**
	 * The feature id for the '<em><b>Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_REFERENCE__URL = 1;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_REFERENCE__OWNER = 2;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_REFERENCE__TYPE = 3;

	/**
	 * The number of structural features of the '<em>External Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_REFERENCE_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>External Reference</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXTERNAL_REFERENCE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link DiagonosticModel.impl.CAPLTestCaseImpl <em>CAPL Test Case</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DiagonosticModel.impl.CAPLTestCaseImpl
	 * @see DiagonosticModel.impl.DiagonosticModelPackageImpl#getCAPLTestCase()
	 * @generated
	 */
	int CAPL_TEST_CASE = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPL_TEST_CASE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPL_TEST_CASE__PARAMETERS = 1;

	/**
	 * The number of structural features of the '<em>CAPL Test Case</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPL_TEST_CASE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>CAPL Test Case</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPL_TEST_CASE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link DiagonosticModel.impl.CAPLParamImpl <em>CAPL Param</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DiagonosticModel.impl.CAPLParamImpl
	 * @see DiagonosticModel.impl.DiagonosticModelPackageImpl#getCAPLParam()
	 * @generated
	 */
	int CAPL_PARAM = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPL_PARAM__NAME = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPL_PARAM__TYPE = 1;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPL_PARAM__VALUE = 2;

	/**
	 * The number of structural features of the '<em>CAPL Param</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPL_PARAM_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>CAPL Param</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPL_PARAM_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link DiagonosticModel.impl.VariantImpl <em>Variant</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DiagonosticModel.impl.VariantImpl
	 * @see DiagonosticModel.impl.DiagonosticModelPackageImpl#getVariant()
	 * @generated
	 */
	int VARIANT = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT__NAME = 0;

	/**
	 * The feature id for the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT__DESCRIPTION = 1;

	/**
	 * The number of structural features of the '<em>Variant</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Variant</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIANT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link DiagonosticModel.impl.CAPLTestStepImpl <em>CAPL Test Step</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DiagonosticModel.impl.CAPLTestStepImpl
	 * @see DiagonosticModel.impl.DiagonosticModelPackageImpl#getCAPLTestStep()
	 * @generated
	 */
	int CAPL_TEST_STEP = 13;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPL_TEST_STEP__TITLE = ACTION__TITLE;

	/**
	 * The feature id for the '<em><b>Next Step</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPL_TEST_STEP__NEXT_STEP = ACTION__NEXT_STEP;

	/**
	 * The feature id for the '<em><b>Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPL_TEST_STEP__KEY = ACTION__KEY;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPL_TEST_STEP__VALUE = ACTION__VALUE;

	/**
	 * The feature id for the '<em><b>Wait</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPL_TEST_STEP__WAIT = ACTION__WAIT;

	/**
	 * The feature id for the '<em><b>Value To</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPL_TEST_STEP__VALUE_TO = ACTION__VALUE_TO;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPL_TEST_STEP__PARAMETERS = ACTION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>CAPL Test Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPL_TEST_STEP_FEATURE_COUNT = ACTION_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>CAPL Test Step</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CAPL_TEST_STEP_OPERATION_COUNT = ACTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link DiagonosticModel.impl.ImportArtifactImpl <em>Import Artifact</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DiagonosticModel.impl.ImportArtifactImpl
	 * @see DiagonosticModel.impl.DiagonosticModelPackageImpl#getImportArtifact()
	 * @generated
	 */
	int IMPORT_ARTIFACT = 14;

	/**
	 * The feature id for the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT_ARTIFACT__PATH = 0;

	/**
	 * The feature id for the '<em><b>Signal Type</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT_ARTIFACT__SIGNAL_TYPE = 1;

	/**
	 * The number of structural features of the '<em>Import Artifact</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT_ARTIFACT_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Import Artifact</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT_ARTIFACT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link DiagonosticModel.impl.DiagnosticRequestImpl <em>Diagnostic Request</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DiagonosticModel.impl.DiagnosticRequestImpl
	 * @see DiagonosticModel.impl.DiagonosticModelPackageImpl#getDiagnosticRequest()
	 * @generated
	 */
	int DIAGNOSTIC_REQUEST = 15;

	/**
	 * The feature id for the '<em><b>Diagparam</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGNOSTIC_REQUEST__DIAGPARAM = 0;

	/**
	 * The number of structural features of the '<em>Diagnostic Request</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGNOSTIC_REQUEST_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Diagnostic Request</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGNOSTIC_REQUEST_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link DiagonosticModel.impl.DiagnosticResponseImpl <em>Diagnostic Response</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DiagonosticModel.impl.DiagnosticResponseImpl
	 * @see DiagonosticModel.impl.DiagonosticModelPackageImpl#getDiagnosticResponse()
	 * @generated
	 */
	int DIAGNOSTIC_RESPONSE = 16;

	/**
	 * The feature id for the '<em><b>Primitive</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGNOSTIC_RESPONSE__PRIMITIVE = 0;

	/**
	 * The feature id for the '<em><b>Diagparam</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGNOSTIC_RESPONSE__DIAGPARAM = 1;

	/**
	 * The number of structural features of the '<em>Diagnostic Response</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGNOSTIC_RESPONSE_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Diagnostic Response</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGNOSTIC_RESPONSE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link DiagonosticModel.impl.DiagnosticParamImpl <em>Diagnostic Param</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DiagonosticModel.impl.DiagnosticParamImpl
	 * @see DiagonosticModel.impl.DiagonosticModelPackageImpl#getDiagnosticParam()
	 * @generated
	 */
	int DIAGNOSTIC_PARAM = 17;

	/**
	 * The feature id for the '<em><b>Qualifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGNOSTIC_PARAM__QUALIFIER = 0;

	/**
	 * The feature id for the '<em><b>Copy To Var</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGNOSTIC_PARAM__COPY_TO_VAR = 1;

	/**
	 * The feature id for the '<em><b>Value Types</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGNOSTIC_PARAM__VALUE_TYPES = 2;

	/**
	 * The number of structural features of the '<em>Diagnostic Param</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGNOSTIC_PARAM_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Diagnostic Param</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGNOSTIC_PARAM_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link DiagonosticModel.impl.BlockActionImpl <em>Block Action</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DiagonosticModel.impl.BlockActionImpl
	 * @see DiagonosticModel.impl.DiagonosticModelPackageImpl#getBlockAction()
	 * @generated
	 */
	int BLOCK_ACTION = 19;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_ACTION__TITLE = TEST_STEP__TITLE;

	/**
	 * The feature id for the '<em><b>Next Step</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_ACTION__NEXT_STEP = TEST_STEP__NEXT_STEP;

	/**
	 * The feature id for the '<em><b>Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_ACTION__KEY = TEST_STEP__KEY;

	/**
	 * The feature id for the '<em><b>Test Steps</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_ACTION__TEST_STEPS = TEST_STEP_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Block Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_ACTION_FEATURE_COUNT = TEST_STEP_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Block Action</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BLOCK_ACTION_OPERATION_COUNT = TEST_STEP_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link DiagonosticModel.impl.ForLoopImpl <em>For Loop</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DiagonosticModel.impl.ForLoopImpl
	 * @see DiagonosticModel.impl.DiagonosticModelPackageImpl#getForLoop()
	 * @generated
	 */
	int FOR_LOOP = 20;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_LOOP__TITLE = BLOCK_ACTION__TITLE;

	/**
	 * The feature id for the '<em><b>Next Step</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_LOOP__NEXT_STEP = BLOCK_ACTION__NEXT_STEP;

	/**
	 * The feature id for the '<em><b>Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_LOOP__KEY = BLOCK_ACTION__KEY;

	/**
	 * The feature id for the '<em><b>Test Steps</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_LOOP__TEST_STEPS = BLOCK_ACTION__TEST_STEPS;

	/**
	 * The feature id for the '<em><b>Loop Var</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_LOOP__LOOP_VAR = BLOCK_ACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Stop Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_LOOP__STOP_VALUE = BLOCK_ACTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Start Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_LOOP__START_VALUE = BLOCK_ACTION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>For Loop</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_LOOP_FEATURE_COUNT = BLOCK_ACTION_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>For Loop</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_LOOP_OPERATION_COUNT = BLOCK_ACTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link DiagonosticModel.impl.WhileLoopImpl <em>While Loop</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DiagonosticModel.impl.WhileLoopImpl
	 * @see DiagonosticModel.impl.DiagonosticModelPackageImpl#getWhileLoop()
	 * @generated
	 */
	int WHILE_LOOP = 21;

	/**
	 * The feature id for the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_LOOP__TITLE = BLOCK_ACTION__TITLE;

	/**
	 * The feature id for the '<em><b>Next Step</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_LOOP__NEXT_STEP = BLOCK_ACTION__NEXT_STEP;

	/**
	 * The feature id for the '<em><b>Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_LOOP__KEY = BLOCK_ACTION__KEY;

	/**
	 * The feature id for the '<em><b>Test Steps</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_LOOP__TEST_STEPS = BLOCK_ACTION__TEST_STEPS;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_LOOP__VALUE = BLOCK_ACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value To</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_LOOP__VALUE_TO = BLOCK_ACTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_LOOP__OPERATOR = BLOCK_ACTION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>While Loop</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_LOOP_FEATURE_COUNT = BLOCK_ACTION_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>While Loop</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_LOOP_OPERATION_COUNT = BLOCK_ACTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link DiagonosticModel.impl.DiagnosticParamValueTypeImpl <em>Diagnostic Param Value Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DiagonosticModel.impl.DiagnosticParamValueTypeImpl
	 * @see DiagonosticModel.impl.DiagonosticModelPackageImpl#getDiagnosticParamValueType()
	 * @generated
	 */
	int DIAGNOSTIC_PARAM_VALUE_TYPE = 22;

	/**
	 * The number of structural features of the '<em>Diagnostic Param Value Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGNOSTIC_PARAM_VALUE_TYPE_FEATURE_COUNT = 0;

	/**
	 * The number of operations of the '<em>Diagnostic Param Value Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DIAGNOSTIC_PARAM_VALUE_TYPE_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link DiagonosticModel.impl.VarImpl <em>Var</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DiagonosticModel.impl.VarImpl
	 * @see DiagonosticModel.impl.DiagonosticModelPackageImpl#getVar()
	 * @generated
	 */
	int VAR = 23;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR__NAME = DIAGNOSTIC_PARAM_VALUE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Var</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_FEATURE_COUNT = DIAGNOSTIC_PARAM_VALUE_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Var</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VAR_OPERATION_COUNT = DIAGNOSTIC_PARAM_VALUE_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link DiagonosticModel.impl.OneOfImpl <em>One Of</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DiagonosticModel.impl.OneOfImpl
	 * @see DiagonosticModel.impl.DiagonosticModelPackageImpl#getOneOf()
	 * @generated
	 */
	int ONE_OF = 24;

	/**
	 * The feature id for the '<em><b>Values</b></em>' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ONE_OF__VALUES = DIAGNOSTIC_PARAM_VALUE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>One Of</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ONE_OF_FEATURE_COUNT = DIAGNOSTIC_PARAM_VALUE_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>One Of</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ONE_OF_OPERATION_COUNT = DIAGNOSTIC_PARAM_VALUE_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link DiagonosticModel.impl.RangeImpl <em>Range</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DiagonosticModel.impl.RangeImpl
	 * @see DiagonosticModel.impl.DiagonosticModelPackageImpl#getRange()
	 * @generated
	 */
	int RANGE = 25;

	/**
	 * The feature id for the '<em><b>From</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANGE__FROM = DIAGNOSTIC_PARAM_VALUE_TYPE_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>To</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANGE__TO = DIAGNOSTIC_PARAM_VALUE_TYPE_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Range</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANGE_FEATURE_COUNT = DIAGNOSTIC_PARAM_VALUE_TYPE_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Range</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANGE_OPERATION_COUNT = DIAGNOSTIC_PARAM_VALUE_TYPE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link DiagonosticModel.impl.TracebilityArtifactImpl <em>Tracebility Artifact</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DiagonosticModel.impl.TracebilityArtifactImpl
	 * @see DiagonosticModel.impl.DiagonosticModelPackageImpl#getTracebilityArtifact()
	 * @generated
	 */
	int TRACEBILITY_ARTIFACT = 26;

	/**
	 * The feature id for the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACEBILITY_ARTIFACT__TYPE = 0;

	/**
	 * The feature id for the '<em><b>Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACEBILITY_ARTIFACT__URL = 1;

	/**
	 * The number of structural features of the '<em>Tracebility Artifact</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACEBILITY_ARTIFACT_FEATURE_COUNT = 2;

	/**
	 * The number of operations of the '<em>Tracebility Artifact</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACEBILITY_ARTIFACT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link DiagonosticModel.OperatorTypeEnum <em>Operator Type Enum</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DiagonosticModel.OperatorTypeEnum
	 * @see DiagonosticModel.impl.DiagonosticModelPackageImpl#getOperatorTypeEnum()
	 * @generated
	 */
	int OPERATOR_TYPE_ENUM = 27;

	/**
	 * The meta object id for the '{@link DiagonosticModel.SignalTypeEnum <em>Signal Type Enum</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DiagonosticModel.SignalTypeEnum
	 * @see DiagonosticModel.impl.DiagonosticModelPackageImpl#getSignalTypeEnum()
	 * @generated
	 */
	int SIGNAL_TYPE_ENUM = 28;


	/**
	 * The meta object id for the '{@link DiagonosticModel.ExecutionStatueTypeEnum <em>Execution Statue Type Enum</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DiagonosticModel.ExecutionStatueTypeEnum
	 * @see DiagonosticModel.impl.DiagonosticModelPackageImpl#getExecutionStatueTypeEnum()
	 * @generated
	 */
	int EXECUTION_STATUE_TYPE_ENUM = 29;


	/**
	 * The meta object id for the '{@link DiagonosticModel.CreationModeEnum <em>Creation Mode Enum</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DiagonosticModel.CreationModeEnum
	 * @see DiagonosticModel.impl.DiagonosticModelPackageImpl#getCreationModeEnum()
	 * @generated
	 */
	int CREATION_MODE_ENUM = 30;


	/**
	 * The meta object id for the '{@link DiagonosticModel.TraceabilityArtifactEnum <em>Traceability Artifact Enum</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see DiagonosticModel.TraceabilityArtifactEnum
	 * @see DiagonosticModel.impl.DiagonosticModelPackageImpl#getTraceabilityArtifactEnum()
	 * @generated
	 */
	int TRACEABILITY_ARTIFACT_ENUM = 31;

	/**
	 * The meta object id for the '<em>Array List Data Type</em>' data type.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see java.util.ArrayList
	 * @see DiagonosticModel.impl.DiagonosticModelPackageImpl#getArrayListDataType()
	 * @generated
	 */
	int ARRAY_LIST_DATA_TYPE = 32;


	/**
	 * Returns the meta object for class '{@link DiagonosticModel.TestSpecification <em>Test Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Test Specification</em>'.
	 * @see DiagonosticModel.TestSpecification
	 * @generated
	 */
	EClass getTestSpecification();

	/**
	 * Returns the meta object for the attribute '{@link DiagonosticModel.TestSpecification#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see DiagonosticModel.TestSpecification#getName()
	 * @see #getTestSpecification()
	 * @generated
	 */
	EAttribute getTestSpecification_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link DiagonosticModel.TestSpecification#getTestGroups <em>Test Groups</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Test Groups</em>'.
	 * @see DiagonosticModel.TestSpecification#getTestGroups()
	 * @see #getTestSpecification()
	 * @generated
	 */
	EReference getTestSpecification_TestGroups();

	/**
	 * Returns the meta object for the attribute '{@link DiagonosticModel.TestSpecification#getVersion <em>Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Version</em>'.
	 * @see DiagonosticModel.TestSpecification#getVersion()
	 * @see #getTestSpecification()
	 * @generated
	 */
	EAttribute getTestSpecification_Version();

	/**
	 * Returns the meta object for the attribute '{@link DiagonosticModel.TestSpecification#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see DiagonosticModel.TestSpecification#getDescription()
	 * @see #getTestSpecification()
	 * @generated
	 */
	EAttribute getTestSpecification_Description();

	/**
	 * Returns the meta object for the attribute '{@link DiagonosticModel.TestSpecification#getFunctionName <em>Function Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Function Name</em>'.
	 * @see DiagonosticModel.TestSpecification#getFunctionName()
	 * @see #getTestSpecification()
	 * @generated
	 */
	EAttribute getTestSpecification_FunctionName();

	/**
	 * Returns the meta object for the attribute '{@link DiagonosticModel.TestSpecification#getFunctionVersion <em>Function Version</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Function Version</em>'.
	 * @see DiagonosticModel.TestSpecification#getFunctionVersion()
	 * @see #getTestSpecification()
	 * @generated
	 */
	EAttribute getTestSpecification_FunctionVersion();

	/**
	 * Returns the meta object for the attribute '{@link DiagonosticModel.TestSpecification#getAuthor <em>Author</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Author</em>'.
	 * @see DiagonosticModel.TestSpecification#getAuthor()
	 * @see #getTestSpecification()
	 * @generated
	 */
	EAttribute getTestSpecification_Author();

	/**
	 * Returns the meta object for the containment reference list '{@link DiagonosticModel.TestSpecification#getCapltestcases <em>Capltestcases</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Capltestcases</em>'.
	 * @see DiagonosticModel.TestSpecification#getCapltestcases()
	 * @see #getTestSpecification()
	 * @generated
	 */
	EReference getTestSpecification_Capltestcases();

	/**
	 * Returns the meta object for the containment reference list '{@link DiagonosticModel.TestSpecification#getVariants <em>Variants</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Variants</em>'.
	 * @see DiagonosticModel.TestSpecification#getVariants()
	 * @see #getTestSpecification()
	 * @generated
	 */
	EReference getTestSpecification_Variants();

	/**
	 * Returns the meta object for the containment reference list '{@link DiagonosticModel.TestSpecification#getImportArtifacts <em>Import Artifacts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Import Artifacts</em>'.
	 * @see DiagonosticModel.TestSpecification#getImportArtifacts()
	 * @see #getTestSpecification()
	 * @generated
	 */
	EReference getTestSpecification_ImportArtifacts();

	/**
	 * Returns the meta object for the '{@link DiagonosticModel.TestSpecification#getSignals() <em>Get Signals</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Get Signals</em>' operation.
	 * @see DiagonosticModel.TestSpecification#getSignals()
	 * @generated
	 */
	EOperation getTestSpecification__GetSignals();

	/**
	 * Returns the meta object for class '{@link DiagonosticModel.TestGroup <em>Test Group</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Test Group</em>'.
	 * @see DiagonosticModel.TestGroup
	 * @generated
	 */
	EClass getTestGroup();

	/**
	 * Returns the meta object for the attribute '{@link DiagonosticModel.TestGroup#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see DiagonosticModel.TestGroup#getName()
	 * @see #getTestGroup()
	 * @generated
	 */
	EAttribute getTestGroup_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link DiagonosticModel.TestGroup#getTestCases <em>Test Cases</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Test Cases</em>'.
	 * @see DiagonosticModel.TestGroup#getTestCases()
	 * @see #getTestGroup()
	 * @generated
	 */
	EReference getTestGroup_TestCases();

	/**
	 * Returns the meta object for the attribute '{@link DiagonosticModel.TestGroup#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see DiagonosticModel.TestGroup#getDescription()
	 * @see #getTestGroup()
	 * @generated
	 */
	EAttribute getTestGroup_Description();

	/**
	 * Returns the meta object for the containment reference '{@link DiagonosticModel.TestGroup#getExternalreference <em>Externalreference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Externalreference</em>'.
	 * @see DiagonosticModel.TestGroup#getExternalreference()
	 * @see #getTestGroup()
	 * @generated
	 */
	EReference getTestGroup_Externalreference();

	/**
	 * Returns the meta object for the containment reference list '{@link DiagonosticModel.TestGroup#getTestGroups <em>Test Groups</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Test Groups</em>'.
	 * @see DiagonosticModel.TestGroup#getTestGroups()
	 * @see #getTestGroup()
	 * @generated
	 */
	EReference getTestGroup_TestGroups();

	/**
	 * Returns the meta object for the containment reference list '{@link DiagonosticModel.TestGroup#getCapltestcases <em>Capltestcases</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Capltestcases</em>'.
	 * @see DiagonosticModel.TestGroup#getCapltestcases()
	 * @see #getTestGroup()
	 * @generated
	 */
	EReference getTestGroup_Capltestcases();

	/**
	 * Returns the meta object for class '{@link DiagonosticModel.TestCase <em>Test Case</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Test Case</em>'.
	 * @see DiagonosticModel.TestCase
	 * @generated
	 */
	EClass getTestCase();

	/**
	 * Returns the meta object for the attribute '{@link DiagonosticModel.TestCase#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see DiagonosticModel.TestCase#getName()
	 * @see #getTestCase()
	 * @generated
	 */
	EAttribute getTestCase_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link DiagonosticModel.TestCase#getTestSteps <em>Test Steps</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Test Steps</em>'.
	 * @see DiagonosticModel.TestCase#getTestSteps()
	 * @see #getTestCase()
	 * @generated
	 */
	EReference getTestCase_TestSteps();

	/**
	 * Returns the meta object for the attribute '{@link DiagonosticModel.TestCase#getId <em>Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Id</em>'.
	 * @see DiagonosticModel.TestCase#getId()
	 * @see #getTestCase()
	 * @generated
	 */
	EAttribute getTestCase_Id();

	/**
	 * Returns the meta object for the attribute '{@link DiagonosticModel.TestCase#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see DiagonosticModel.TestCase#getDescription()
	 * @see #getTestCase()
	 * @generated
	 */
	EAttribute getTestCase_Description();

	/**
	 * Returns the meta object for the reference list '{@link DiagonosticModel.TestCase#getVariants <em>Variants</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Variants</em>'.
	 * @see DiagonosticModel.TestCase#getVariants()
	 * @see #getTestCase()
	 * @generated
	 */
	EReference getTestCase_Variants();

	/**
	 * Returns the meta object for the containment reference list '{@link DiagonosticModel.TestCase#getPreConditions <em>Pre Conditions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Pre Conditions</em>'.
	 * @see DiagonosticModel.TestCase#getPreConditions()
	 * @see #getTestCase()
	 * @generated
	 */
	EReference getTestCase_PreConditions();

	/**
	 * Returns the meta object for the containment reference list '{@link DiagonosticModel.TestCase#getPostConditions <em>Post Conditions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Post Conditions</em>'.
	 * @see DiagonosticModel.TestCase#getPostConditions()
	 * @see #getTestCase()
	 * @generated
	 */
	EReference getTestCase_PostConditions();

	/**
	 * Returns the meta object for the attribute '{@link DiagonosticModel.TestCase#getRequirementID <em>Requirement ID</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Requirement ID</em>'.
	 * @see DiagonosticModel.TestCase#getRequirementID()
	 * @see #getTestCase()
	 * @generated
	 */
	EAttribute getTestCase_RequirementID();

	/**
	 * Returns the meta object for the attribute '{@link DiagonosticModel.TestCase#getExecutionStatus <em>Execution Status</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Execution Status</em>'.
	 * @see DiagonosticModel.TestCase#getExecutionStatus()
	 * @see #getTestCase()
	 * @generated
	 */
	EAttribute getTestCase_ExecutionStatus();

	/**
	 * Returns the meta object for the reference '{@link DiagonosticModel.TestCase#getExternalreference <em>Externalreference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Externalreference</em>'.
	 * @see DiagonosticModel.TestCase#getExternalreference()
	 * @see #getTestCase()
	 * @generated
	 */
	EReference getTestCase_Externalreference();

	/**
	 * Returns the meta object for the attribute '{@link DiagonosticModel.TestCase#isSkip <em>Skip</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Skip</em>'.
	 * @see DiagonosticModel.TestCase#isSkip()
	 * @see #getTestCase()
	 * @generated
	 */
	EAttribute getTestCase_Skip();

	/**
	 * Returns the meta object for the containment reference list '{@link DiagonosticModel.TestCase#getTraceabilityArtifacts <em>Traceability Artifacts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Traceability Artifacts</em>'.
	 * @see DiagonosticModel.TestCase#getTraceabilityArtifacts()
	 * @see #getTestCase()
	 * @generated
	 */
	EReference getTestCase_TraceabilityArtifacts();

	/**
	 * Returns the meta object for class '{@link DiagonosticModel.TestStep <em>Test Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Test Step</em>'.
	 * @see DiagonosticModel.TestStep
	 * @generated
	 */
	EClass getTestStep();

	/**
	 * Returns the meta object for the reference '{@link DiagonosticModel.TestStep#getKey <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Key</em>'.
	 * @see DiagonosticModel.TestStep#getKey()
	 * @see #getTestStep()
	 * @generated
	 */
	EReference getTestStep_Key();

	/**
	 * Returns the meta object for the attribute '{@link DiagonosticModel.TestStep#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Title</em>'.
	 * @see DiagonosticModel.TestStep#getTitle()
	 * @see #getTestStep()
	 * @generated
	 */
	EAttribute getTestStep_Title();

	/**
	 * Returns the meta object for the reference '{@link DiagonosticModel.TestStep#getNextStep <em>Next Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Next Step</em>'.
	 * @see DiagonosticModel.TestStep#getNextStep()
	 * @see #getTestStep()
	 * @generated
	 */
	EReference getTestStep_NextStep();

	/**
	 * Returns the meta object for class '{@link DiagonosticModel.WaitAction <em>Wait Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Wait Action</em>'.
	 * @see DiagonosticModel.WaitAction
	 * @generated
	 */
	EClass getWaitAction();

	/**
	 * Returns the meta object for class '{@link DiagonosticModel.CheckAction <em>Check Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Check Action</em>'.
	 * @see DiagonosticModel.CheckAction
	 * @generated
	 */
	EClass getCheckAction();

	/**
	 * Returns the meta object for the attribute '{@link DiagonosticModel.CheckAction#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator</em>'.
	 * @see DiagonosticModel.CheckAction#getOperator()
	 * @see #getCheckAction()
	 * @generated
	 */
	EAttribute getCheckAction_Operator();

	/**
	 * Returns the meta object for class '{@link DiagonosticModel.SetAction <em>Set Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Set Action</em>'.
	 * @see DiagonosticModel.SetAction
	 * @generated
	 */
	EClass getSetAction();

	/**
	 * Returns the meta object for class '{@link DiagonosticModel.SignalType <em>Signal Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Signal Type</em>'.
	 * @see DiagonosticModel.SignalType
	 * @generated
	 */
	EClass getSignalType();

	/**
	 * Returns the meta object for the attribute '{@link DiagonosticModel.SignalType#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see DiagonosticModel.SignalType#getName()
	 * @see #getSignalType()
	 * @generated
	 */
	EAttribute getSignalType_Name();

	/**
	 * Returns the meta object for the attribute '{@link DiagonosticModel.SignalType#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see DiagonosticModel.SignalType#getType()
	 * @see #getSignalType()
	 * @generated
	 */
	EAttribute getSignalType_Type();

	/**
	 * Returns the meta object for the attribute '{@link DiagonosticModel.SignalType#getMessageName <em>Message Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Message Name</em>'.
	 * @see DiagonosticModel.SignalType#getMessageName()
	 * @see #getSignalType()
	 * @generated
	 */
	EAttribute getSignalType_MessageName();

	/**
	 * Returns the meta object for the attribute '{@link DiagonosticModel.SignalType#getNode <em>Node</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Node</em>'.
	 * @see DiagonosticModel.SignalType#getNode()
	 * @see #getSignalType()
	 * @generated
	 */
	EAttribute getSignalType_Node();

	/**
	 * Returns the meta object for the attribute '{@link DiagonosticModel.SignalType#getNamespace <em>Namespace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Namespace</em>'.
	 * @see DiagonosticModel.SignalType#getNamespace()
	 * @see #getSignalType()
	 * @generated
	 */
	EAttribute getSignalType_Namespace();

	/**
	 * Returns the meta object for the attribute '{@link DiagonosticModel.SignalType#getCreationMode <em>Creation Mode</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Creation Mode</em>'.
	 * @see DiagonosticModel.SignalType#getCreationMode()
	 * @see #getSignalType()
	 * @generated
	 */
	EAttribute getSignalType_CreationMode();

	/**
	 * Returns the meta object for the attribute list '{@link DiagonosticModel.SignalType#getLookupValues <em>Lookup Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Lookup Values</em>'.
	 * @see DiagonosticModel.SignalType#getLookupValues()
	 * @see #getSignalType()
	 * @generated
	 */
	EAttribute getSignalType_LookupValues();

	/**
	 * Returns the meta object for class '{@link DiagonosticModel.DiagnosticService <em>Diagnostic Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Diagnostic Service</em>'.
	 * @see DiagonosticModel.DiagnosticService
	 * @generated
	 */
	EClass getDiagnosticService();

	/**
	 * Returns the meta object for the attribute '{@link DiagonosticModel.DiagnosticService#getEcu <em>Ecu</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Ecu</em>'.
	 * @see DiagonosticModel.DiagnosticService#getEcu()
	 * @see #getDiagnosticService()
	 * @generated
	 */
	EAttribute getDiagnosticService_Ecu();

	/**
	 * Returns the meta object for the attribute '{@link DiagonosticModel.DiagnosticService#getService <em>Service</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Service</em>'.
	 * @see DiagonosticModel.DiagnosticService#getService()
	 * @see #getDiagnosticService()
	 * @generated
	 */
	EAttribute getDiagnosticService_Service();

	/**
	 * Returns the meta object for the attribute '{@link DiagonosticModel.DiagnosticService#getResult <em>Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Result</em>'.
	 * @see DiagonosticModel.DiagnosticService#getResult()
	 * @see #getDiagnosticService()
	 * @generated
	 */
	EAttribute getDiagnosticService_Result();

	/**
	 * Returns the meta object for the containment reference '{@link DiagonosticModel.DiagnosticService#getDiagrequest <em>Diagrequest</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Diagrequest</em>'.
	 * @see DiagonosticModel.DiagnosticService#getDiagrequest()
	 * @see #getDiagnosticService()
	 * @generated
	 */
	EReference getDiagnosticService_Diagrequest();

	/**
	 * Returns the meta object for the containment reference '{@link DiagonosticModel.DiagnosticService#getDiagresponse <em>Diagresponse</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Diagresponse</em>'.
	 * @see DiagonosticModel.DiagnosticService#getDiagresponse()
	 * @see #getDiagnosticService()
	 * @generated
	 */
	EReference getDiagnosticService_Diagresponse();

	/**
	 * Returns the meta object for class '{@link DiagonosticModel.ExternalReference <em>External Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>External Reference</em>'.
	 * @see DiagonosticModel.ExternalReference
	 * @generated
	 */
	EClass getExternalReference();

	/**
	 * Returns the meta object for the attribute '{@link DiagonosticModel.ExternalReference#getTitle <em>Title</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Title</em>'.
	 * @see DiagonosticModel.ExternalReference#getTitle()
	 * @see #getExternalReference()
	 * @generated
	 */
	EAttribute getExternalReference_Title();

	/**
	 * Returns the meta object for the attribute '{@link DiagonosticModel.ExternalReference#getUrl <em>Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Url</em>'.
	 * @see DiagonosticModel.ExternalReference#getUrl()
	 * @see #getExternalReference()
	 * @generated
	 */
	EAttribute getExternalReference_Url();

	/**
	 * Returns the meta object for the attribute '{@link DiagonosticModel.ExternalReference#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Owner</em>'.
	 * @see DiagonosticModel.ExternalReference#getOwner()
	 * @see #getExternalReference()
	 * @generated
	 */
	EAttribute getExternalReference_Owner();

	/**
	 * Returns the meta object for the attribute '{@link DiagonosticModel.ExternalReference#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see DiagonosticModel.ExternalReference#getType()
	 * @see #getExternalReference()
	 * @generated
	 */
	EAttribute getExternalReference_Type();

	/**
	 * Returns the meta object for class '{@link DiagonosticModel.CAPLTestCase <em>CAPL Test Case</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CAPL Test Case</em>'.
	 * @see DiagonosticModel.CAPLTestCase
	 * @generated
	 */
	EClass getCAPLTestCase();

	/**
	 * Returns the meta object for the attribute '{@link DiagonosticModel.CAPLTestCase#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see DiagonosticModel.CAPLTestCase#getName()
	 * @see #getCAPLTestCase()
	 * @generated
	 */
	EAttribute getCAPLTestCase_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link DiagonosticModel.CAPLTestCase#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see DiagonosticModel.CAPLTestCase#getParameters()
	 * @see #getCAPLTestCase()
	 * @generated
	 */
	EReference getCAPLTestCase_Parameters();

	/**
	 * Returns the meta object for class '{@link DiagonosticModel.CAPLParam <em>CAPL Param</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CAPL Param</em>'.
	 * @see DiagonosticModel.CAPLParam
	 * @generated
	 */
	EClass getCAPLParam();

	/**
	 * Returns the meta object for the attribute '{@link DiagonosticModel.CAPLParam#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see DiagonosticModel.CAPLParam#getName()
	 * @see #getCAPLParam()
	 * @generated
	 */
	EAttribute getCAPLParam_Name();

	/**
	 * Returns the meta object for the attribute '{@link DiagonosticModel.CAPLParam#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see DiagonosticModel.CAPLParam#getType()
	 * @see #getCAPLParam()
	 * @generated
	 */
	EAttribute getCAPLParam_Type();

	/**
	 * Returns the meta object for the attribute '{@link DiagonosticModel.CAPLParam#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see DiagonosticModel.CAPLParam#getValue()
	 * @see #getCAPLParam()
	 * @generated
	 */
	EAttribute getCAPLParam_Value();

	/**
	 * Returns the meta object for class '{@link DiagonosticModel.Variant <em>Variant</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variant</em>'.
	 * @see DiagonosticModel.Variant
	 * @generated
	 */
	EClass getVariant();

	/**
	 * Returns the meta object for the attribute '{@link DiagonosticModel.Variant#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see DiagonosticModel.Variant#getName()
	 * @see #getVariant()
	 * @generated
	 */
	EAttribute getVariant_Name();

	/**
	 * Returns the meta object for the attribute '{@link DiagonosticModel.Variant#getDescription <em>Description</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Description</em>'.
	 * @see DiagonosticModel.Variant#getDescription()
	 * @see #getVariant()
	 * @generated
	 */
	EAttribute getVariant_Description();

	/**
	 * Returns the meta object for class '{@link DiagonosticModel.CAPLTestStep <em>CAPL Test Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CAPL Test Step</em>'.
	 * @see DiagonosticModel.CAPLTestStep
	 * @generated
	 */
	EClass getCAPLTestStep();

	/**
	 * Returns the meta object for the containment reference list '{@link DiagonosticModel.CAPLTestStep#getParameters <em>Parameters</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parameters</em>'.
	 * @see DiagonosticModel.CAPLTestStep#getParameters()
	 * @see #getCAPLTestStep()
	 * @generated
	 */
	EReference getCAPLTestStep_Parameters();

	/**
	 * Returns the meta object for class '{@link DiagonosticModel.ImportArtifact <em>Import Artifact</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Import Artifact</em>'.
	 * @see DiagonosticModel.ImportArtifact
	 * @generated
	 */
	EClass getImportArtifact();

	/**
	 * Returns the meta object for the attribute '{@link DiagonosticModel.ImportArtifact#getPath <em>Path</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Path</em>'.
	 * @see DiagonosticModel.ImportArtifact#getPath()
	 * @see #getImportArtifact()
	 * @generated
	 */
	EAttribute getImportArtifact_Path();

	/**
	 * Returns the meta object for the containment reference list '{@link DiagonosticModel.ImportArtifact#getSignalType <em>Signal Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Signal Type</em>'.
	 * @see DiagonosticModel.ImportArtifact#getSignalType()
	 * @see #getImportArtifact()
	 * @generated
	 */
	EReference getImportArtifact_SignalType();

	/**
	 * Returns the meta object for class '{@link DiagonosticModel.DiagnosticRequest <em>Diagnostic Request</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Diagnostic Request</em>'.
	 * @see DiagonosticModel.DiagnosticRequest
	 * @generated
	 */
	EClass getDiagnosticRequest();

	/**
	 * Returns the meta object for the containment reference list '{@link DiagonosticModel.DiagnosticRequest#getDiagparam <em>Diagparam</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Diagparam</em>'.
	 * @see DiagonosticModel.DiagnosticRequest#getDiagparam()
	 * @see #getDiagnosticRequest()
	 * @generated
	 */
	EReference getDiagnosticRequest_Diagparam();

	/**
	 * Returns the meta object for class '{@link DiagonosticModel.DiagnosticResponse <em>Diagnostic Response</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Diagnostic Response</em>'.
	 * @see DiagonosticModel.DiagnosticResponse
	 * @generated
	 */
	EClass getDiagnosticResponse();

	/**
	 * Returns the meta object for the attribute '{@link DiagonosticModel.DiagnosticResponse#getPrimitive <em>Primitive</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Primitive</em>'.
	 * @see DiagonosticModel.DiagnosticResponse#getPrimitive()
	 * @see #getDiagnosticResponse()
	 * @generated
	 */
	EAttribute getDiagnosticResponse_Primitive();

	/**
	 * Returns the meta object for the containment reference list '{@link DiagonosticModel.DiagnosticResponse#getDiagparam <em>Diagparam</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Diagparam</em>'.
	 * @see DiagonosticModel.DiagnosticResponse#getDiagparam()
	 * @see #getDiagnosticResponse()
	 * @generated
	 */
	EReference getDiagnosticResponse_Diagparam();

	/**
	 * Returns the meta object for class '{@link DiagonosticModel.DiagnosticParam <em>Diagnostic Param</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Diagnostic Param</em>'.
	 * @see DiagonosticModel.DiagnosticParam
	 * @generated
	 */
	EClass getDiagnosticParam();

	/**
	 * Returns the meta object for the attribute '{@link DiagonosticModel.DiagnosticParam#getQualifier <em>Qualifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Qualifier</em>'.
	 * @see DiagonosticModel.DiagnosticParam#getQualifier()
	 * @see #getDiagnosticParam()
	 * @generated
	 */
	EAttribute getDiagnosticParam_Qualifier();

	/**
	 * Returns the meta object for the attribute '{@link DiagonosticModel.DiagnosticParam#getCopyToVar <em>Copy To Var</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Copy To Var</em>'.
	 * @see DiagonosticModel.DiagnosticParam#getCopyToVar()
	 * @see #getDiagnosticParam()
	 * @generated
	 */
	EAttribute getDiagnosticParam_CopyToVar();

	/**
	 * Returns the meta object for the containment reference '{@link DiagonosticModel.DiagnosticParam#getValueTypes <em>Value Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value Types</em>'.
	 * @see DiagonosticModel.DiagnosticParam#getValueTypes()
	 * @see #getDiagnosticParam()
	 * @generated
	 */
	EReference getDiagnosticParam_ValueTypes();

	/**
	 * Returns the meta object for class '{@link DiagonosticModel.Action <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Action</em>'.
	 * @see DiagonosticModel.Action
	 * @generated
	 */
	EClass getAction();

	/**
	 * Returns the meta object for the attribute '{@link DiagonosticModel.Action#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see DiagonosticModel.Action#getValue()
	 * @see #getAction()
	 * @generated
	 */
	EAttribute getAction_Value();

	/**
	 * Returns the meta object for the attribute '{@link DiagonosticModel.Action#getWait <em>Wait</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Wait</em>'.
	 * @see DiagonosticModel.Action#getWait()
	 * @see #getAction()
	 * @generated
	 */
	EAttribute getAction_Wait();

	/**
	 * Returns the meta object for the attribute '{@link DiagonosticModel.Action#getValueTo <em>Value To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value To</em>'.
	 * @see DiagonosticModel.Action#getValueTo()
	 * @see #getAction()
	 * @generated
	 */
	EAttribute getAction_ValueTo();

	/**
	 * Returns the meta object for class '{@link DiagonosticModel.BlockAction <em>Block Action</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Block Action</em>'.
	 * @see DiagonosticModel.BlockAction
	 * @generated
	 */
	EClass getBlockAction();

	/**
	 * Returns the meta object for the containment reference list '{@link DiagonosticModel.BlockAction#getTestSteps <em>Test Steps</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Test Steps</em>'.
	 * @see DiagonosticModel.BlockAction#getTestSteps()
	 * @see #getBlockAction()
	 * @generated
	 */
	EReference getBlockAction_TestSteps();

	/**
	 * Returns the meta object for class '{@link DiagonosticModel.ForLoop <em>For Loop</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>For Loop</em>'.
	 * @see DiagonosticModel.ForLoop
	 * @generated
	 */
	EClass getForLoop();

	/**
	 * Returns the meta object for the attribute '{@link DiagonosticModel.ForLoop#getLoopVar <em>Loop Var</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Loop Var</em>'.
	 * @see DiagonosticModel.ForLoop#getLoopVar()
	 * @see #getForLoop()
	 * @generated
	 */
	EAttribute getForLoop_LoopVar();

	/**
	 * Returns the meta object for the attribute '{@link DiagonosticModel.ForLoop#getStopValue <em>Stop Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Stop Value</em>'.
	 * @see DiagonosticModel.ForLoop#getStopValue()
	 * @see #getForLoop()
	 * @generated
	 */
	EAttribute getForLoop_StopValue();

	/**
	 * Returns the meta object for the attribute '{@link DiagonosticModel.ForLoop#getStartValue <em>Start Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Start Value</em>'.
	 * @see DiagonosticModel.ForLoop#getStartValue()
	 * @see #getForLoop()
	 * @generated
	 */
	EAttribute getForLoop_StartValue();

	/**
	 * Returns the meta object for class '{@link DiagonosticModel.WhileLoop <em>While Loop</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>While Loop</em>'.
	 * @see DiagonosticModel.WhileLoop
	 * @generated
	 */
	EClass getWhileLoop();

	/**
	 * Returns the meta object for the attribute '{@link DiagonosticModel.WhileLoop#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see DiagonosticModel.WhileLoop#getValue()
	 * @see #getWhileLoop()
	 * @generated
	 */
	EAttribute getWhileLoop_Value();

	/**
	 * Returns the meta object for the attribute '{@link DiagonosticModel.WhileLoop#getValueTo <em>Value To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value To</em>'.
	 * @see DiagonosticModel.WhileLoop#getValueTo()
	 * @see #getWhileLoop()
	 * @generated
	 */
	EAttribute getWhileLoop_ValueTo();

	/**
	 * Returns the meta object for the attribute '{@link DiagonosticModel.WhileLoop#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator</em>'.
	 * @see DiagonosticModel.WhileLoop#getOperator()
	 * @see #getWhileLoop()
	 * @generated
	 */
	EAttribute getWhileLoop_Operator();

	/**
	 * Returns the meta object for class '{@link DiagonosticModel.DiagnosticParamValueType <em>Diagnostic Param Value Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Diagnostic Param Value Type</em>'.
	 * @see DiagonosticModel.DiagnosticParamValueType
	 * @generated
	 */
	EClass getDiagnosticParamValueType();

	/**
	 * Returns the meta object for class '{@link DiagonosticModel.Var <em>Var</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Var</em>'.
	 * @see DiagonosticModel.Var
	 * @generated
	 */
	EClass getVar();

	/**
	 * Returns the meta object for the attribute '{@link DiagonosticModel.Var#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see DiagonosticModel.Var#getName()
	 * @see #getVar()
	 * @generated
	 */
	EAttribute getVar_Name();

	/**
	 * Returns the meta object for class '{@link DiagonosticModel.OneOf <em>One Of</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>One Of</em>'.
	 * @see DiagonosticModel.OneOf
	 * @generated
	 */
	EClass getOneOf();

	/**
	 * Returns the meta object for the attribute list '{@link DiagonosticModel.OneOf#getValues <em>Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute list '<em>Values</em>'.
	 * @see DiagonosticModel.OneOf#getValues()
	 * @see #getOneOf()
	 * @generated
	 */
	EAttribute getOneOf_Values();

	/**
	 * Returns the meta object for class '{@link DiagonosticModel.Range <em>Range</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Range</em>'.
	 * @see DiagonosticModel.Range
	 * @generated
	 */
	EClass getRange();

	/**
	 * Returns the meta object for the attribute '{@link DiagonosticModel.Range#getFrom <em>From</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>From</em>'.
	 * @see DiagonosticModel.Range#getFrom()
	 * @see #getRange()
	 * @generated
	 */
	EAttribute getRange_From();

	/**
	 * Returns the meta object for the attribute '{@link DiagonosticModel.Range#getTo <em>To</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>To</em>'.
	 * @see DiagonosticModel.Range#getTo()
	 * @see #getRange()
	 * @generated
	 */
	EAttribute getRange_To();

	/**
	 * Returns the meta object for class '{@link DiagonosticModel.TracebilityArtifact <em>Tracebility Artifact</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tracebility Artifact</em>'.
	 * @see DiagonosticModel.TracebilityArtifact
	 * @generated
	 */
	EClass getTracebilityArtifact();

	/**
	 * Returns the meta object for the attribute '{@link DiagonosticModel.TracebilityArtifact#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Type</em>'.
	 * @see DiagonosticModel.TracebilityArtifact#getType()
	 * @see #getTracebilityArtifact()
	 * @generated
	 */
	EAttribute getTracebilityArtifact_Type();

	/**
	 * Returns the meta object for the attribute '{@link DiagonosticModel.TracebilityArtifact#getUrl <em>Url</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Url</em>'.
	 * @see DiagonosticModel.TracebilityArtifact#getUrl()
	 * @see #getTracebilityArtifact()
	 * @generated
	 */
	EAttribute getTracebilityArtifact_Url();

	/**
	 * Returns the meta object for enum '{@link DiagonosticModel.OperatorTypeEnum <em>Operator Type Enum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Operator Type Enum</em>'.
	 * @see DiagonosticModel.OperatorTypeEnum
	 * @generated
	 */
	EEnum getOperatorTypeEnum();

	/**
	 * Returns the meta object for enum '{@link DiagonosticModel.SignalTypeEnum <em>Signal Type Enum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Signal Type Enum</em>'.
	 * @see DiagonosticModel.SignalTypeEnum
	 * @generated
	 */
	EEnum getSignalTypeEnum();

	/**
	 * Returns the meta object for enum '{@link DiagonosticModel.ExecutionStatueTypeEnum <em>Execution Statue Type Enum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Execution Statue Type Enum</em>'.
	 * @see DiagonosticModel.ExecutionStatueTypeEnum
	 * @generated
	 */
	EEnum getExecutionStatueTypeEnum();

	/**
	 * Returns the meta object for enum '{@link DiagonosticModel.CreationModeEnum <em>Creation Mode Enum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Creation Mode Enum</em>'.
	 * @see DiagonosticModel.CreationModeEnum
	 * @generated
	 */
	EEnum getCreationModeEnum();

	/**
	 * Returns the meta object for enum '{@link DiagonosticModel.TraceabilityArtifactEnum <em>Traceability Artifact Enum</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Traceability Artifact Enum</em>'.
	 * @see DiagonosticModel.TraceabilityArtifactEnum
	 * @generated
	 */
	EEnum getTraceabilityArtifactEnum();

	/**
	 * Returns the meta object for data type '{@link java.util.ArrayList <em>Array List Data Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for data type '<em>Array List Data Type</em>'.
	 * @see java.util.ArrayList
	 * @model instanceClass="java.util.ArrayList&lt;DiagonosticModel.SignalType&gt;"
	 * @generated
	 */
	EDataType getArrayListDataType();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	DiagonosticModelFactory getDiagonosticModelFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link DiagonosticModel.impl.TestSpecificationImpl <em>Test Specification</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DiagonosticModel.impl.TestSpecificationImpl
		 * @see DiagonosticModel.impl.DiagonosticModelPackageImpl#getTestSpecification()
		 * @generated
		 */
		EClass TEST_SPECIFICATION = eINSTANCE.getTestSpecification();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEST_SPECIFICATION__NAME = eINSTANCE.getTestSpecification_Name();

		/**
		 * The meta object literal for the '<em><b>Test Groups</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEST_SPECIFICATION__TEST_GROUPS = eINSTANCE.getTestSpecification_TestGroups();

		/**
		 * The meta object literal for the '<em><b>Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEST_SPECIFICATION__VERSION = eINSTANCE.getTestSpecification_Version();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEST_SPECIFICATION__DESCRIPTION = eINSTANCE.getTestSpecification_Description();

		/**
		 * The meta object literal for the '<em><b>Function Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEST_SPECIFICATION__FUNCTION_NAME = eINSTANCE.getTestSpecification_FunctionName();

		/**
		 * The meta object literal for the '<em><b>Function Version</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEST_SPECIFICATION__FUNCTION_VERSION = eINSTANCE.getTestSpecification_FunctionVersion();

		/**
		 * The meta object literal for the '<em><b>Author</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEST_SPECIFICATION__AUTHOR = eINSTANCE.getTestSpecification_Author();

		/**
		 * The meta object literal for the '<em><b>Capltestcases</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEST_SPECIFICATION__CAPLTESTCASES = eINSTANCE.getTestSpecification_Capltestcases();

		/**
		 * The meta object literal for the '<em><b>Variants</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEST_SPECIFICATION__VARIANTS = eINSTANCE.getTestSpecification_Variants();

		/**
		 * The meta object literal for the '<em><b>Import Artifacts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEST_SPECIFICATION__IMPORT_ARTIFACTS = eINSTANCE.getTestSpecification_ImportArtifacts();

		/**
		 * The meta object literal for the '<em><b>Get Signals</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation TEST_SPECIFICATION___GET_SIGNALS = eINSTANCE.getTestSpecification__GetSignals();

		/**
		 * The meta object literal for the '{@link DiagonosticModel.impl.TestGroupImpl <em>Test Group</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DiagonosticModel.impl.TestGroupImpl
		 * @see DiagonosticModel.impl.DiagonosticModelPackageImpl#getTestGroup()
		 * @generated
		 */
		EClass TEST_GROUP = eINSTANCE.getTestGroup();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEST_GROUP__NAME = eINSTANCE.getTestGroup_Name();

		/**
		 * The meta object literal for the '<em><b>Test Cases</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEST_GROUP__TEST_CASES = eINSTANCE.getTestGroup_TestCases();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEST_GROUP__DESCRIPTION = eINSTANCE.getTestGroup_Description();

		/**
		 * The meta object literal for the '<em><b>Externalreference</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEST_GROUP__EXTERNALREFERENCE = eINSTANCE.getTestGroup_Externalreference();

		/**
		 * The meta object literal for the '<em><b>Test Groups</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEST_GROUP__TEST_GROUPS = eINSTANCE.getTestGroup_TestGroups();

		/**
		 * The meta object literal for the '<em><b>Capltestcases</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEST_GROUP__CAPLTESTCASES = eINSTANCE.getTestGroup_Capltestcases();

		/**
		 * The meta object literal for the '{@link DiagonosticModel.impl.TestCaseImpl <em>Test Case</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DiagonosticModel.impl.TestCaseImpl
		 * @see DiagonosticModel.impl.DiagonosticModelPackageImpl#getTestCase()
		 * @generated
		 */
		EClass TEST_CASE = eINSTANCE.getTestCase();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEST_CASE__NAME = eINSTANCE.getTestCase_Name();

		/**
		 * The meta object literal for the '<em><b>Test Steps</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEST_CASE__TEST_STEPS = eINSTANCE.getTestCase_TestSteps();

		/**
		 * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEST_CASE__ID = eINSTANCE.getTestCase_Id();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEST_CASE__DESCRIPTION = eINSTANCE.getTestCase_Description();

		/**
		 * The meta object literal for the '<em><b>Variants</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEST_CASE__VARIANTS = eINSTANCE.getTestCase_Variants();

		/**
		 * The meta object literal for the '<em><b>Pre Conditions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEST_CASE__PRE_CONDITIONS = eINSTANCE.getTestCase_PreConditions();

		/**
		 * The meta object literal for the '<em><b>Post Conditions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEST_CASE__POST_CONDITIONS = eINSTANCE.getTestCase_PostConditions();

		/**
		 * The meta object literal for the '<em><b>Requirement ID</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEST_CASE__REQUIREMENT_ID = eINSTANCE.getTestCase_RequirementID();

		/**
		 * The meta object literal for the '<em><b>Execution Status</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEST_CASE__EXECUTION_STATUS = eINSTANCE.getTestCase_ExecutionStatus();

		/**
		 * The meta object literal for the '<em><b>Externalreference</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEST_CASE__EXTERNALREFERENCE = eINSTANCE.getTestCase_Externalreference();

		/**
		 * The meta object literal for the '<em><b>Skip</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEST_CASE__SKIP = eINSTANCE.getTestCase_Skip();

		/**
		 * The meta object literal for the '<em><b>Traceability Artifacts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEST_CASE__TRACEABILITY_ARTIFACTS = eINSTANCE.getTestCase_TraceabilityArtifacts();

		/**
		 * The meta object literal for the '{@link DiagonosticModel.impl.TestStepImpl <em>Test Step</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DiagonosticModel.impl.TestStepImpl
		 * @see DiagonosticModel.impl.DiagonosticModelPackageImpl#getTestStep()
		 * @generated
		 */
		EClass TEST_STEP = eINSTANCE.getTestStep();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEST_STEP__KEY = eINSTANCE.getTestStep_Key();

		/**
		 * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TEST_STEP__TITLE = eINSTANCE.getTestStep_Title();

		/**
		 * The meta object literal for the '<em><b>Next Step</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TEST_STEP__NEXT_STEP = eINSTANCE.getTestStep_NextStep();

		/**
		 * The meta object literal for the '{@link DiagonosticModel.impl.WaitActionImpl <em>Wait Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DiagonosticModel.impl.WaitActionImpl
		 * @see DiagonosticModel.impl.DiagonosticModelPackageImpl#getWaitAction()
		 * @generated
		 */
		EClass WAIT_ACTION = eINSTANCE.getWaitAction();

		/**
		 * The meta object literal for the '{@link DiagonosticModel.impl.CheckActionImpl <em>Check Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DiagonosticModel.impl.CheckActionImpl
		 * @see DiagonosticModel.impl.DiagonosticModelPackageImpl#getCheckAction()
		 * @generated
		 */
		EClass CHECK_ACTION = eINSTANCE.getCheckAction();

		/**
		 * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CHECK_ACTION__OPERATOR = eINSTANCE.getCheckAction_Operator();

		/**
		 * The meta object literal for the '{@link DiagonosticModel.impl.SetActionImpl <em>Set Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DiagonosticModel.impl.SetActionImpl
		 * @see DiagonosticModel.impl.DiagonosticModelPackageImpl#getSetAction()
		 * @generated
		 */
		EClass SET_ACTION = eINSTANCE.getSetAction();

		/**
		 * The meta object literal for the '{@link DiagonosticModel.impl.SignalTypeImpl <em>Signal Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DiagonosticModel.impl.SignalTypeImpl
		 * @see DiagonosticModel.impl.DiagonosticModelPackageImpl#getSignalType()
		 * @generated
		 */
		EClass SIGNAL_TYPE = eINSTANCE.getSignalType();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIGNAL_TYPE__NAME = eINSTANCE.getSignalType_Name();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIGNAL_TYPE__TYPE = eINSTANCE.getSignalType_Type();

		/**
		 * The meta object literal for the '<em><b>Message Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIGNAL_TYPE__MESSAGE_NAME = eINSTANCE.getSignalType_MessageName();

		/**
		 * The meta object literal for the '<em><b>Node</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIGNAL_TYPE__NODE = eINSTANCE.getSignalType_Node();

		/**
		 * The meta object literal for the '<em><b>Namespace</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIGNAL_TYPE__NAMESPACE = eINSTANCE.getSignalType_Namespace();

		/**
		 * The meta object literal for the '<em><b>Creation Mode</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIGNAL_TYPE__CREATION_MODE = eINSTANCE.getSignalType_CreationMode();

		/**
		 * The meta object literal for the '<em><b>Lookup Values</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SIGNAL_TYPE__LOOKUP_VALUES = eINSTANCE.getSignalType_LookupValues();

		/**
		 * The meta object literal for the '{@link DiagonosticModel.impl.DiagnosticServiceImpl <em>Diagnostic Service</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DiagonosticModel.impl.DiagnosticServiceImpl
		 * @see DiagonosticModel.impl.DiagonosticModelPackageImpl#getDiagnosticService()
		 * @generated
		 */
		EClass DIAGNOSTIC_SERVICE = eINSTANCE.getDiagnosticService();

		/**
		 * The meta object literal for the '<em><b>Ecu</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIAGNOSTIC_SERVICE__ECU = eINSTANCE.getDiagnosticService_Ecu();

		/**
		 * The meta object literal for the '<em><b>Service</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIAGNOSTIC_SERVICE__SERVICE = eINSTANCE.getDiagnosticService_Service();

		/**
		 * The meta object literal for the '<em><b>Result</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIAGNOSTIC_SERVICE__RESULT = eINSTANCE.getDiagnosticService_Result();

		/**
		 * The meta object literal for the '<em><b>Diagrequest</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIAGNOSTIC_SERVICE__DIAGREQUEST = eINSTANCE.getDiagnosticService_Diagrequest();

		/**
		 * The meta object literal for the '<em><b>Diagresponse</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIAGNOSTIC_SERVICE__DIAGRESPONSE = eINSTANCE.getDiagnosticService_Diagresponse();

		/**
		 * The meta object literal for the '{@link DiagonosticModel.impl.ExternalReferenceImpl <em>External Reference</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DiagonosticModel.impl.ExternalReferenceImpl
		 * @see DiagonosticModel.impl.DiagonosticModelPackageImpl#getExternalReference()
		 * @generated
		 */
		EClass EXTERNAL_REFERENCE = eINSTANCE.getExternalReference();

		/**
		 * The meta object literal for the '<em><b>Title</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTERNAL_REFERENCE__TITLE = eINSTANCE.getExternalReference_Title();

		/**
		 * The meta object literal for the '<em><b>Url</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTERNAL_REFERENCE__URL = eINSTANCE.getExternalReference_Url();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTERNAL_REFERENCE__OWNER = eINSTANCE.getExternalReference_Owner();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EXTERNAL_REFERENCE__TYPE = eINSTANCE.getExternalReference_Type();

		/**
		 * The meta object literal for the '{@link DiagonosticModel.impl.CAPLTestCaseImpl <em>CAPL Test Case</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DiagonosticModel.impl.CAPLTestCaseImpl
		 * @see DiagonosticModel.impl.DiagonosticModelPackageImpl#getCAPLTestCase()
		 * @generated
		 */
		EClass CAPL_TEST_CASE = eINSTANCE.getCAPLTestCase();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CAPL_TEST_CASE__NAME = eINSTANCE.getCAPLTestCase_Name();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CAPL_TEST_CASE__PARAMETERS = eINSTANCE.getCAPLTestCase_Parameters();

		/**
		 * The meta object literal for the '{@link DiagonosticModel.impl.CAPLParamImpl <em>CAPL Param</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DiagonosticModel.impl.CAPLParamImpl
		 * @see DiagonosticModel.impl.DiagonosticModelPackageImpl#getCAPLParam()
		 * @generated
		 */
		EClass CAPL_PARAM = eINSTANCE.getCAPLParam();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CAPL_PARAM__NAME = eINSTANCE.getCAPLParam_Name();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CAPL_PARAM__TYPE = eINSTANCE.getCAPLParam_Type();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CAPL_PARAM__VALUE = eINSTANCE.getCAPLParam_Value();

		/**
		 * The meta object literal for the '{@link DiagonosticModel.impl.VariantImpl <em>Variant</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DiagonosticModel.impl.VariantImpl
		 * @see DiagonosticModel.impl.DiagonosticModelPackageImpl#getVariant()
		 * @generated
		 */
		EClass VARIANT = eINSTANCE.getVariant();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIANT__NAME = eINSTANCE.getVariant_Name();

		/**
		 * The meta object literal for the '<em><b>Description</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIANT__DESCRIPTION = eINSTANCE.getVariant_Description();

		/**
		 * The meta object literal for the '{@link DiagonosticModel.impl.CAPLTestStepImpl <em>CAPL Test Step</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DiagonosticModel.impl.CAPLTestStepImpl
		 * @see DiagonosticModel.impl.DiagonosticModelPackageImpl#getCAPLTestStep()
		 * @generated
		 */
		EClass CAPL_TEST_STEP = eINSTANCE.getCAPLTestStep();

		/**
		 * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CAPL_TEST_STEP__PARAMETERS = eINSTANCE.getCAPLTestStep_Parameters();

		/**
		 * The meta object literal for the '{@link DiagonosticModel.impl.ImportArtifactImpl <em>Import Artifact</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DiagonosticModel.impl.ImportArtifactImpl
		 * @see DiagonosticModel.impl.DiagonosticModelPackageImpl#getImportArtifact()
		 * @generated
		 */
		EClass IMPORT_ARTIFACT = eINSTANCE.getImportArtifact();

		/**
		 * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMPORT_ARTIFACT__PATH = eINSTANCE.getImportArtifact_Path();

		/**
		 * The meta object literal for the '<em><b>Signal Type</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPORT_ARTIFACT__SIGNAL_TYPE = eINSTANCE.getImportArtifact_SignalType();

		/**
		 * The meta object literal for the '{@link DiagonosticModel.impl.DiagnosticRequestImpl <em>Diagnostic Request</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DiagonosticModel.impl.DiagnosticRequestImpl
		 * @see DiagonosticModel.impl.DiagonosticModelPackageImpl#getDiagnosticRequest()
		 * @generated
		 */
		EClass DIAGNOSTIC_REQUEST = eINSTANCE.getDiagnosticRequest();

		/**
		 * The meta object literal for the '<em><b>Diagparam</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIAGNOSTIC_REQUEST__DIAGPARAM = eINSTANCE.getDiagnosticRequest_Diagparam();

		/**
		 * The meta object literal for the '{@link DiagonosticModel.impl.DiagnosticResponseImpl <em>Diagnostic Response</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DiagonosticModel.impl.DiagnosticResponseImpl
		 * @see DiagonosticModel.impl.DiagonosticModelPackageImpl#getDiagnosticResponse()
		 * @generated
		 */
		EClass DIAGNOSTIC_RESPONSE = eINSTANCE.getDiagnosticResponse();

		/**
		 * The meta object literal for the '<em><b>Primitive</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIAGNOSTIC_RESPONSE__PRIMITIVE = eINSTANCE.getDiagnosticResponse_Primitive();

		/**
		 * The meta object literal for the '<em><b>Diagparam</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIAGNOSTIC_RESPONSE__DIAGPARAM = eINSTANCE.getDiagnosticResponse_Diagparam();

		/**
		 * The meta object literal for the '{@link DiagonosticModel.impl.DiagnosticParamImpl <em>Diagnostic Param</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DiagonosticModel.impl.DiagnosticParamImpl
		 * @see DiagonosticModel.impl.DiagonosticModelPackageImpl#getDiagnosticParam()
		 * @generated
		 */
		EClass DIAGNOSTIC_PARAM = eINSTANCE.getDiagnosticParam();

		/**
		 * The meta object literal for the '<em><b>Qualifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIAGNOSTIC_PARAM__QUALIFIER = eINSTANCE.getDiagnosticParam_Qualifier();

		/**
		 * The meta object literal for the '<em><b>Copy To Var</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DIAGNOSTIC_PARAM__COPY_TO_VAR = eINSTANCE.getDiagnosticParam_CopyToVar();

		/**
		 * The meta object literal for the '<em><b>Value Types</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DIAGNOSTIC_PARAM__VALUE_TYPES = eINSTANCE.getDiagnosticParam_ValueTypes();

		/**
		 * The meta object literal for the '{@link DiagonosticModel.impl.ActionImpl <em>Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DiagonosticModel.impl.ActionImpl
		 * @see DiagonosticModel.impl.DiagonosticModelPackageImpl#getAction()
		 * @generated
		 */
		EClass ACTION = eINSTANCE.getAction();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION__VALUE = eINSTANCE.getAction_Value();

		/**
		 * The meta object literal for the '<em><b>Wait</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION__WAIT = eINSTANCE.getAction_Wait();

		/**
		 * The meta object literal for the '<em><b>Value To</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ACTION__VALUE_TO = eINSTANCE.getAction_ValueTo();

		/**
		 * The meta object literal for the '{@link DiagonosticModel.impl.BlockActionImpl <em>Block Action</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DiagonosticModel.impl.BlockActionImpl
		 * @see DiagonosticModel.impl.DiagonosticModelPackageImpl#getBlockAction()
		 * @generated
		 */
		EClass BLOCK_ACTION = eINSTANCE.getBlockAction();

		/**
		 * The meta object literal for the '<em><b>Test Steps</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BLOCK_ACTION__TEST_STEPS = eINSTANCE.getBlockAction_TestSteps();

		/**
		 * The meta object literal for the '{@link DiagonosticModel.impl.ForLoopImpl <em>For Loop</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DiagonosticModel.impl.ForLoopImpl
		 * @see DiagonosticModel.impl.DiagonosticModelPackageImpl#getForLoop()
		 * @generated
		 */
		EClass FOR_LOOP = eINSTANCE.getForLoop();

		/**
		 * The meta object literal for the '<em><b>Loop Var</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FOR_LOOP__LOOP_VAR = eINSTANCE.getForLoop_LoopVar();

		/**
		 * The meta object literal for the '<em><b>Stop Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FOR_LOOP__STOP_VALUE = eINSTANCE.getForLoop_StopValue();

		/**
		 * The meta object literal for the '<em><b>Start Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FOR_LOOP__START_VALUE = eINSTANCE.getForLoop_StartValue();

		/**
		 * The meta object literal for the '{@link DiagonosticModel.impl.WhileLoopImpl <em>While Loop</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DiagonosticModel.impl.WhileLoopImpl
		 * @see DiagonosticModel.impl.DiagonosticModelPackageImpl#getWhileLoop()
		 * @generated
		 */
		EClass WHILE_LOOP = eINSTANCE.getWhileLoop();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WHILE_LOOP__VALUE = eINSTANCE.getWhileLoop_Value();

		/**
		 * The meta object literal for the '<em><b>Value To</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WHILE_LOOP__VALUE_TO = eINSTANCE.getWhileLoop_ValueTo();

		/**
		 * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute WHILE_LOOP__OPERATOR = eINSTANCE.getWhileLoop_Operator();

		/**
		 * The meta object literal for the '{@link DiagonosticModel.impl.DiagnosticParamValueTypeImpl <em>Diagnostic Param Value Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DiagonosticModel.impl.DiagnosticParamValueTypeImpl
		 * @see DiagonosticModel.impl.DiagonosticModelPackageImpl#getDiagnosticParamValueType()
		 * @generated
		 */
		EClass DIAGNOSTIC_PARAM_VALUE_TYPE = eINSTANCE.getDiagnosticParamValueType();

		/**
		 * The meta object literal for the '{@link DiagonosticModel.impl.VarImpl <em>Var</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DiagonosticModel.impl.VarImpl
		 * @see DiagonosticModel.impl.DiagonosticModelPackageImpl#getVar()
		 * @generated
		 */
		EClass VAR = eINSTANCE.getVar();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VAR__NAME = eINSTANCE.getVar_Name();

		/**
		 * The meta object literal for the '{@link DiagonosticModel.impl.OneOfImpl <em>One Of</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DiagonosticModel.impl.OneOfImpl
		 * @see DiagonosticModel.impl.DiagonosticModelPackageImpl#getOneOf()
		 * @generated
		 */
		EClass ONE_OF = eINSTANCE.getOneOf();

		/**
		 * The meta object literal for the '<em><b>Values</b></em>' attribute list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ONE_OF__VALUES = eINSTANCE.getOneOf_Values();

		/**
		 * The meta object literal for the '{@link DiagonosticModel.impl.RangeImpl <em>Range</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DiagonosticModel.impl.RangeImpl
		 * @see DiagonosticModel.impl.DiagonosticModelPackageImpl#getRange()
		 * @generated
		 */
		EClass RANGE = eINSTANCE.getRange();

		/**
		 * The meta object literal for the '<em><b>From</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RANGE__FROM = eINSTANCE.getRange_From();

		/**
		 * The meta object literal for the '<em><b>To</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RANGE__TO = eINSTANCE.getRange_To();

		/**
		 * The meta object literal for the '{@link DiagonosticModel.impl.TracebilityArtifactImpl <em>Tracebility Artifact</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DiagonosticModel.impl.TracebilityArtifactImpl
		 * @see DiagonosticModel.impl.DiagonosticModelPackageImpl#getTracebilityArtifact()
		 * @generated
		 */
		EClass TRACEBILITY_ARTIFACT = eINSTANCE.getTracebilityArtifact();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRACEBILITY_ARTIFACT__TYPE = eINSTANCE.getTracebilityArtifact_Type();

		/**
		 * The meta object literal for the '<em><b>Url</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute TRACEBILITY_ARTIFACT__URL = eINSTANCE.getTracebilityArtifact_Url();

		/**
		 * The meta object literal for the '{@link DiagonosticModel.OperatorTypeEnum <em>Operator Type Enum</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DiagonosticModel.OperatorTypeEnum
		 * @see DiagonosticModel.impl.DiagonosticModelPackageImpl#getOperatorTypeEnum()
		 * @generated
		 */
		EEnum OPERATOR_TYPE_ENUM = eINSTANCE.getOperatorTypeEnum();

		/**
		 * The meta object literal for the '{@link DiagonosticModel.SignalTypeEnum <em>Signal Type Enum</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DiagonosticModel.SignalTypeEnum
		 * @see DiagonosticModel.impl.DiagonosticModelPackageImpl#getSignalTypeEnum()
		 * @generated
		 */
		EEnum SIGNAL_TYPE_ENUM = eINSTANCE.getSignalTypeEnum();

		/**
		 * The meta object literal for the '{@link DiagonosticModel.ExecutionStatueTypeEnum <em>Execution Statue Type Enum</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DiagonosticModel.ExecutionStatueTypeEnum
		 * @see DiagonosticModel.impl.DiagonosticModelPackageImpl#getExecutionStatueTypeEnum()
		 * @generated
		 */
		EEnum EXECUTION_STATUE_TYPE_ENUM = eINSTANCE.getExecutionStatueTypeEnum();

		/**
		 * The meta object literal for the '{@link DiagonosticModel.CreationModeEnum <em>Creation Mode Enum</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DiagonosticModel.CreationModeEnum
		 * @see DiagonosticModel.impl.DiagonosticModelPackageImpl#getCreationModeEnum()
		 * @generated
		 */
		EEnum CREATION_MODE_ENUM = eINSTANCE.getCreationModeEnum();

		/**
		 * The meta object literal for the '{@link DiagonosticModel.TraceabilityArtifactEnum <em>Traceability Artifact Enum</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see DiagonosticModel.TraceabilityArtifactEnum
		 * @see DiagonosticModel.impl.DiagonosticModelPackageImpl#getTraceabilityArtifactEnum()
		 * @generated
		 */
		EEnum TRACEABILITY_ARTIFACT_ENUM = eINSTANCE.getTraceabilityArtifactEnum();

		/**
		 * The meta object literal for the '<em>Array List Data Type</em>' data type.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see java.util.ArrayList
		 * @see DiagonosticModel.impl.DiagonosticModelPackageImpl#getArrayListDataType()
		 * @generated
		 */
		EDataType ARRAY_LIST_DATA_TYPE = eINSTANCE.getArrayListDataType();

	}

} //DiagonosticModelPackage
