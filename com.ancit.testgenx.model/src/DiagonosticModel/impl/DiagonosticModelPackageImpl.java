/**
 */
package DiagonosticModel.impl;

import DiagonosticModel.Action;
import DiagonosticModel.BlockAction;
import DiagonosticModel.CAPLParam;
import DiagonosticModel.CAPLTestCase;
import DiagonosticModel.CAPLTestStep;
import DiagonosticModel.CheckAction;
import DiagonosticModel.CreationModeEnum;
import DiagonosticModel.DiagnosticParam;
import DiagonosticModel.DiagnosticParamValueType;
import DiagonosticModel.DiagnosticRequest;
import DiagonosticModel.DiagnosticResponse;
import DiagonosticModel.DiagnosticService;
import DiagonosticModel.DiagonosticModelFactory;
import DiagonosticModel.DiagonosticModelPackage;
import DiagonosticModel.ExecutionStatueTypeEnum;
import DiagonosticModel.ExternalReference;
import DiagonosticModel.ForLoop;
import DiagonosticModel.ImportArtifact;
import DiagonosticModel.OneOf;
import DiagonosticModel.OperatorTypeEnum;
import DiagonosticModel.Range;
import DiagonosticModel.SetAction;
import DiagonosticModel.SignalType;
import DiagonosticModel.SignalTypeEnum;
import DiagonosticModel.TestCase;
import DiagonosticModel.TestGroup;
import DiagonosticModel.TestSpecification;
import DiagonosticModel.TestStep;
import DiagonosticModel.TraceabilityArtifactEnum;
import DiagonosticModel.TracebilityArtifact;
import DiagonosticModel.Var;
import DiagonosticModel.Variant;
import DiagonosticModel.WaitAction;

import DiagonosticModel.WhileLoop;
import java.util.ArrayList;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DiagonosticModelPackageImpl extends EPackageImpl implements DiagonosticModelPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass testSpecificationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass testGroupEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass testCaseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass testStepEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass waitActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass checkActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass setActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass signalTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass diagnosticServiceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass externalReferenceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass caplTestCaseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass caplParamEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass variantEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass caplTestStepEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass importArtifactEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass diagnosticRequestEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass diagnosticResponseEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass diagnosticParamEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass actionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass blockActionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass forLoopEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass whileLoopEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass diagnosticParamValueTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass varEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass oneOfEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass rangeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass tracebilityArtifactEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum operatorTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum signalTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum executionStatueTypeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum creationModeEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum traceabilityArtifactEnumEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EDataType arrayListDataTypeEDataType = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see DiagonosticModel.DiagonosticModelPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private DiagonosticModelPackageImpl() {
		super(eNS_URI, DiagonosticModelFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link DiagonosticModelPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static DiagonosticModelPackage init() {
		if (isInited) return (DiagonosticModelPackage)EPackage.Registry.INSTANCE.getEPackage(DiagonosticModelPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredDiagonosticModelPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		DiagonosticModelPackageImpl theDiagonosticModelPackage = registeredDiagonosticModelPackage instanceof DiagonosticModelPackageImpl ? (DiagonosticModelPackageImpl)registeredDiagonosticModelPackage : new DiagonosticModelPackageImpl();

		isInited = true;

		// Create package meta-data objects
		theDiagonosticModelPackage.createPackageContents();

		// Initialize created meta-data
		theDiagonosticModelPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theDiagonosticModelPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(DiagonosticModelPackage.eNS_URI, theDiagonosticModelPackage);
		return theDiagonosticModelPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTestSpecification() {
		return testSpecificationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTestSpecification_Name() {
		return (EAttribute)testSpecificationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTestSpecification_TestGroups() {
		return (EReference)testSpecificationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTestSpecification_Version() {
		return (EAttribute)testSpecificationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTestSpecification_Description() {
		return (EAttribute)testSpecificationEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTestSpecification_FunctionName() {
		return (EAttribute)testSpecificationEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTestSpecification_FunctionVersion() {
		return (EAttribute)testSpecificationEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTestSpecification_Author() {
		return (EAttribute)testSpecificationEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTestSpecification_Capltestcases() {
		return (EReference)testSpecificationEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTestSpecification_Variants() {
		return (EReference)testSpecificationEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTestSpecification_ImportArtifacts() {
		return (EReference)testSpecificationEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EOperation getTestSpecification__GetSignals() {
		return testSpecificationEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTestGroup() {
		return testGroupEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTestGroup_Name() {
		return (EAttribute)testGroupEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTestGroup_TestCases() {
		return (EReference)testGroupEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTestGroup_Description() {
		return (EAttribute)testGroupEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTestGroup_Externalreference() {
		return (EReference)testGroupEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTestGroup_TestGroups() {
		return (EReference)testGroupEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTestGroup_Capltestcases() {
		return (EReference)testGroupEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTestCase() {
		return testCaseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTestCase_Name() {
		return (EAttribute)testCaseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTestCase_TestSteps() {
		return (EReference)testCaseEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTestCase_Id() {
		return (EAttribute)testCaseEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTestCase_Description() {
		return (EAttribute)testCaseEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTestCase_Variants() {
		return (EReference)testCaseEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTestCase_PreConditions() {
		return (EReference)testCaseEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTestCase_PostConditions() {
		return (EReference)testCaseEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTestCase_RequirementID() {
		return (EAttribute)testCaseEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTestCase_ExecutionStatus() {
		return (EAttribute)testCaseEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTestCase_Externalreference() {
		return (EReference)testCaseEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTestCase_Skip() {
		return (EAttribute)testCaseEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTestCase_TraceabilityArtifacts() {
		return (EReference)testCaseEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTestStep() {
		return testStepEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTestStep_Key() {
		return (EReference)testStepEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTestStep_Title() {
		return (EAttribute)testStepEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getTestStep_NextStep() {
		return (EReference)testStepEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getWaitAction() {
		return waitActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCheckAction() {
		return checkActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCheckAction_Operator() {
		return (EAttribute)checkActionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSetAction() {
		return setActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getSignalType() {
		return signalTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSignalType_Name() {
		return (EAttribute)signalTypeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSignalType_Type() {
		return (EAttribute)signalTypeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSignalType_MessageName() {
		return (EAttribute)signalTypeEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSignalType_Node() {
		return (EAttribute)signalTypeEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSignalType_Namespace() {
		return (EAttribute)signalTypeEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSignalType_CreationMode() {
		return (EAttribute)signalTypeEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getSignalType_LookupValues() {
		return (EAttribute)signalTypeEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDiagnosticService() {
		return diagnosticServiceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDiagnosticService_Ecu() {
		return (EAttribute)diagnosticServiceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDiagnosticService_Service() {
		return (EAttribute)diagnosticServiceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDiagnosticService_Result() {
		return (EAttribute)diagnosticServiceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDiagnosticService_Diagrequest() {
		return (EReference)diagnosticServiceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDiagnosticService_Diagresponse() {
		return (EReference)diagnosticServiceEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getExternalReference() {
		return externalReferenceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getExternalReference_Title() {
		return (EAttribute)externalReferenceEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getExternalReference_Url() {
		return (EAttribute)externalReferenceEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getExternalReference_Owner() {
		return (EAttribute)externalReferenceEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getExternalReference_Type() {
		return (EAttribute)externalReferenceEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCAPLTestCase() {
		return caplTestCaseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCAPLTestCase_Name() {
		return (EAttribute)caplTestCaseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCAPLTestCase_Parameters() {
		return (EReference)caplTestCaseEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCAPLParam() {
		return caplParamEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCAPLParam_Name() {
		return (EAttribute)caplParamEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCAPLParam_Type() {
		return (EAttribute)caplParamEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getCAPLParam_Value() {
		return (EAttribute)caplParamEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getVariant() {
		return variantEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getVariant_Name() {
		return (EAttribute)variantEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getVariant_Description() {
		return (EAttribute)variantEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getCAPLTestStep() {
		return caplTestStepEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getCAPLTestStep_Parameters() {
		return (EReference)caplTestStepEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getImportArtifact() {
		return importArtifactEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getImportArtifact_Path() {
		return (EAttribute)importArtifactEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getImportArtifact_SignalType() {
		return (EReference)importArtifactEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDiagnosticRequest() {
		return diagnosticRequestEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDiagnosticRequest_Diagparam() {
		return (EReference)diagnosticRequestEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDiagnosticResponse() {
		return diagnosticResponseEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDiagnosticResponse_Primitive() {
		return (EAttribute)diagnosticResponseEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDiagnosticResponse_Diagparam() {
		return (EReference)diagnosticResponseEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDiagnosticParam() {
		return diagnosticParamEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDiagnosticParam_Qualifier() {
		return (EAttribute)diagnosticParamEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getDiagnosticParam_CopyToVar() {
		return (EAttribute)diagnosticParamEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getDiagnosticParam_ValueTypes() {
		return (EReference)diagnosticParamEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getAction() {
		return actionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAction_Value() {
		return (EAttribute)actionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAction_Wait() {
		return (EAttribute)actionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getAction_ValueTo() {
		return (EAttribute)actionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getBlockAction() {
		return blockActionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EReference getBlockAction_TestSteps() {
		return (EReference)blockActionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getForLoop() {
		return forLoopEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getForLoop_LoopVar() {
		return (EAttribute)forLoopEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getForLoop_StopValue() {
		return (EAttribute)forLoopEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getForLoop_StartValue() {
		return (EAttribute)forLoopEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getWhileLoop() {
		return whileLoopEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getWhileLoop_Value() {
		return (EAttribute)whileLoopEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getWhileLoop_ValueTo() {
		return (EAttribute)whileLoopEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getWhileLoop_Operator() {
		return (EAttribute)whileLoopEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getDiagnosticParamValueType() {
		return diagnosticParamValueTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getVar() {
		return varEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getVar_Name() {
		return (EAttribute)varEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getOneOf() {
		return oneOfEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getOneOf_Values() {
		return (EAttribute)oneOfEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getRange() {
		return rangeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRange_From() {
		return (EAttribute)rangeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getRange_To() {
		return (EAttribute)rangeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EClass getTracebilityArtifact() {
		return tracebilityArtifactEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTracebilityArtifact_Type() {
		return (EAttribute)tracebilityArtifactEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EAttribute getTracebilityArtifact_Url() {
		return (EAttribute)tracebilityArtifactEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getOperatorTypeEnum() {
		return operatorTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getSignalTypeEnum() {
		return signalTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getExecutionStatueTypeEnum() {
		return executionStatueTypeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getCreationModeEnum() {
		return creationModeEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EEnum getTraceabilityArtifactEnum() {
		return traceabilityArtifactEnumEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EDataType getArrayListDataType() {
		return arrayListDataTypeEDataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DiagonosticModelFactory getDiagonosticModelFactory() {
		return (DiagonosticModelFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		testSpecificationEClass = createEClass(TEST_SPECIFICATION);
		createEAttribute(testSpecificationEClass, TEST_SPECIFICATION__NAME);
		createEReference(testSpecificationEClass, TEST_SPECIFICATION__TEST_GROUPS);
		createEAttribute(testSpecificationEClass, TEST_SPECIFICATION__VERSION);
		createEAttribute(testSpecificationEClass, TEST_SPECIFICATION__DESCRIPTION);
		createEAttribute(testSpecificationEClass, TEST_SPECIFICATION__FUNCTION_NAME);
		createEAttribute(testSpecificationEClass, TEST_SPECIFICATION__FUNCTION_VERSION);
		createEAttribute(testSpecificationEClass, TEST_SPECIFICATION__AUTHOR);
		createEReference(testSpecificationEClass, TEST_SPECIFICATION__CAPLTESTCASES);
		createEReference(testSpecificationEClass, TEST_SPECIFICATION__VARIANTS);
		createEReference(testSpecificationEClass, TEST_SPECIFICATION__IMPORT_ARTIFACTS);
		createEOperation(testSpecificationEClass, TEST_SPECIFICATION___GET_SIGNALS);

		testGroupEClass = createEClass(TEST_GROUP);
		createEAttribute(testGroupEClass, TEST_GROUP__NAME);
		createEReference(testGroupEClass, TEST_GROUP__TEST_CASES);
		createEAttribute(testGroupEClass, TEST_GROUP__DESCRIPTION);
		createEReference(testGroupEClass, TEST_GROUP__EXTERNALREFERENCE);
		createEReference(testGroupEClass, TEST_GROUP__TEST_GROUPS);
		createEReference(testGroupEClass, TEST_GROUP__CAPLTESTCASES);

		testCaseEClass = createEClass(TEST_CASE);
		createEAttribute(testCaseEClass, TEST_CASE__NAME);
		createEReference(testCaseEClass, TEST_CASE__TEST_STEPS);
		createEAttribute(testCaseEClass, TEST_CASE__ID);
		createEAttribute(testCaseEClass, TEST_CASE__DESCRIPTION);
		createEReference(testCaseEClass, TEST_CASE__VARIANTS);
		createEReference(testCaseEClass, TEST_CASE__PRE_CONDITIONS);
		createEReference(testCaseEClass, TEST_CASE__POST_CONDITIONS);
		createEAttribute(testCaseEClass, TEST_CASE__REQUIREMENT_ID);
		createEAttribute(testCaseEClass, TEST_CASE__EXECUTION_STATUS);
		createEReference(testCaseEClass, TEST_CASE__EXTERNALREFERENCE);
		createEAttribute(testCaseEClass, TEST_CASE__SKIP);
		createEReference(testCaseEClass, TEST_CASE__TRACEABILITY_ARTIFACTS);

		testStepEClass = createEClass(TEST_STEP);
		createEAttribute(testStepEClass, TEST_STEP__TITLE);
		createEReference(testStepEClass, TEST_STEP__NEXT_STEP);
		createEReference(testStepEClass, TEST_STEP__KEY);

		waitActionEClass = createEClass(WAIT_ACTION);

		checkActionEClass = createEClass(CHECK_ACTION);
		createEAttribute(checkActionEClass, CHECK_ACTION__OPERATOR);

		setActionEClass = createEClass(SET_ACTION);

		signalTypeEClass = createEClass(SIGNAL_TYPE);
		createEAttribute(signalTypeEClass, SIGNAL_TYPE__NAME);
		createEAttribute(signalTypeEClass, SIGNAL_TYPE__TYPE);
		createEAttribute(signalTypeEClass, SIGNAL_TYPE__MESSAGE_NAME);
		createEAttribute(signalTypeEClass, SIGNAL_TYPE__NODE);
		createEAttribute(signalTypeEClass, SIGNAL_TYPE__NAMESPACE);
		createEAttribute(signalTypeEClass, SIGNAL_TYPE__CREATION_MODE);
		createEAttribute(signalTypeEClass, SIGNAL_TYPE__LOOKUP_VALUES);

		diagnosticServiceEClass = createEClass(DIAGNOSTIC_SERVICE);
		createEAttribute(diagnosticServiceEClass, DIAGNOSTIC_SERVICE__ECU);
		createEAttribute(diagnosticServiceEClass, DIAGNOSTIC_SERVICE__SERVICE);
		createEAttribute(diagnosticServiceEClass, DIAGNOSTIC_SERVICE__RESULT);
		createEReference(diagnosticServiceEClass, DIAGNOSTIC_SERVICE__DIAGREQUEST);
		createEReference(diagnosticServiceEClass, DIAGNOSTIC_SERVICE__DIAGRESPONSE);

		externalReferenceEClass = createEClass(EXTERNAL_REFERENCE);
		createEAttribute(externalReferenceEClass, EXTERNAL_REFERENCE__TITLE);
		createEAttribute(externalReferenceEClass, EXTERNAL_REFERENCE__URL);
		createEAttribute(externalReferenceEClass, EXTERNAL_REFERENCE__OWNER);
		createEAttribute(externalReferenceEClass, EXTERNAL_REFERENCE__TYPE);

		caplTestCaseEClass = createEClass(CAPL_TEST_CASE);
		createEAttribute(caplTestCaseEClass, CAPL_TEST_CASE__NAME);
		createEReference(caplTestCaseEClass, CAPL_TEST_CASE__PARAMETERS);

		caplParamEClass = createEClass(CAPL_PARAM);
		createEAttribute(caplParamEClass, CAPL_PARAM__NAME);
		createEAttribute(caplParamEClass, CAPL_PARAM__TYPE);
		createEAttribute(caplParamEClass, CAPL_PARAM__VALUE);

		variantEClass = createEClass(VARIANT);
		createEAttribute(variantEClass, VARIANT__NAME);
		createEAttribute(variantEClass, VARIANT__DESCRIPTION);

		caplTestStepEClass = createEClass(CAPL_TEST_STEP);
		createEReference(caplTestStepEClass, CAPL_TEST_STEP__PARAMETERS);

		importArtifactEClass = createEClass(IMPORT_ARTIFACT);
		createEAttribute(importArtifactEClass, IMPORT_ARTIFACT__PATH);
		createEReference(importArtifactEClass, IMPORT_ARTIFACT__SIGNAL_TYPE);

		diagnosticRequestEClass = createEClass(DIAGNOSTIC_REQUEST);
		createEReference(diagnosticRequestEClass, DIAGNOSTIC_REQUEST__DIAGPARAM);

		diagnosticResponseEClass = createEClass(DIAGNOSTIC_RESPONSE);
		createEAttribute(diagnosticResponseEClass, DIAGNOSTIC_RESPONSE__PRIMITIVE);
		createEReference(diagnosticResponseEClass, DIAGNOSTIC_RESPONSE__DIAGPARAM);

		diagnosticParamEClass = createEClass(DIAGNOSTIC_PARAM);
		createEAttribute(diagnosticParamEClass, DIAGNOSTIC_PARAM__QUALIFIER);
		createEAttribute(diagnosticParamEClass, DIAGNOSTIC_PARAM__COPY_TO_VAR);
		createEReference(diagnosticParamEClass, DIAGNOSTIC_PARAM__VALUE_TYPES);

		actionEClass = createEClass(ACTION);
		createEAttribute(actionEClass, ACTION__VALUE);
		createEAttribute(actionEClass, ACTION__WAIT);
		createEAttribute(actionEClass, ACTION__VALUE_TO);

		blockActionEClass = createEClass(BLOCK_ACTION);
		createEReference(blockActionEClass, BLOCK_ACTION__TEST_STEPS);

		forLoopEClass = createEClass(FOR_LOOP);
		createEAttribute(forLoopEClass, FOR_LOOP__LOOP_VAR);
		createEAttribute(forLoopEClass, FOR_LOOP__STOP_VALUE);
		createEAttribute(forLoopEClass, FOR_LOOP__START_VALUE);

		whileLoopEClass = createEClass(WHILE_LOOP);
		createEAttribute(whileLoopEClass, WHILE_LOOP__VALUE);
		createEAttribute(whileLoopEClass, WHILE_LOOP__VALUE_TO);
		createEAttribute(whileLoopEClass, WHILE_LOOP__OPERATOR);

		diagnosticParamValueTypeEClass = createEClass(DIAGNOSTIC_PARAM_VALUE_TYPE);

		varEClass = createEClass(VAR);
		createEAttribute(varEClass, VAR__NAME);

		oneOfEClass = createEClass(ONE_OF);
		createEAttribute(oneOfEClass, ONE_OF__VALUES);

		rangeEClass = createEClass(RANGE);
		createEAttribute(rangeEClass, RANGE__FROM);
		createEAttribute(rangeEClass, RANGE__TO);

		tracebilityArtifactEClass = createEClass(TRACEBILITY_ARTIFACT);
		createEAttribute(tracebilityArtifactEClass, TRACEBILITY_ARTIFACT__TYPE);
		createEAttribute(tracebilityArtifactEClass, TRACEBILITY_ARTIFACT__URL);

		// Create enums
		operatorTypeEnumEEnum = createEEnum(OPERATOR_TYPE_ENUM);
		signalTypeEnumEEnum = createEEnum(SIGNAL_TYPE_ENUM);
		executionStatueTypeEnumEEnum = createEEnum(EXECUTION_STATUE_TYPE_ENUM);
		creationModeEnumEEnum = createEEnum(CREATION_MODE_ENUM);
		traceabilityArtifactEnumEEnum = createEEnum(TRACEABILITY_ARTIFACT_ENUM);

		// Create data types
		arrayListDataTypeEDataType = createEDataType(ARRAY_LIST_DATA_TYPE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		waitActionEClass.getESuperTypes().add(this.getAction());
		checkActionEClass.getESuperTypes().add(this.getAction());
		setActionEClass.getESuperTypes().add(this.getAction());
		diagnosticServiceEClass.getESuperTypes().add(this.getAction());
		caplTestStepEClass.getESuperTypes().add(this.getAction());
		actionEClass.getESuperTypes().add(this.getTestStep());
		blockActionEClass.getESuperTypes().add(this.getTestStep());
		forLoopEClass.getESuperTypes().add(this.getBlockAction());
		whileLoopEClass.getESuperTypes().add(this.getBlockAction());
		varEClass.getESuperTypes().add(this.getDiagnosticParamValueType());
		oneOfEClass.getESuperTypes().add(this.getDiagnosticParamValueType());
		rangeEClass.getESuperTypes().add(this.getDiagnosticParamValueType());

		// Initialize classes, features, and operations; add parameters
		initEClass(testSpecificationEClass, TestSpecification.class, "TestSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTestSpecification_Name(), ecorePackage.getEString(), "name", null, 1, 1, TestSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTestSpecification_TestGroups(), this.getTestGroup(), null, "testGroups", null, 0, -1, TestSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestSpecification_Version(), ecorePackage.getEString(), "version", null, 0, 1, TestSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestSpecification_Description(), ecorePackage.getEString(), "description", null, 0, 1, TestSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestSpecification_FunctionName(), ecorePackage.getEString(), "functionName", null, 0, 1, TestSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestSpecification_FunctionVersion(), ecorePackage.getEString(), "functionVersion", null, 0, 1, TestSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestSpecification_Author(), ecorePackage.getEString(), "author", null, 0, 1, TestSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTestSpecification_Capltestcases(), this.getCAPLTestCase(), null, "capltestcases", null, 0, -1, TestSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTestSpecification_Variants(), this.getVariant(), null, "variants", null, 0, -1, TestSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTestSpecification_ImportArtifacts(), this.getImportArtifact(), null, "importArtifacts", null, 0, -1, TestSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEOperation(getTestSpecification__GetSignals(), this.getArrayListDataType(), "getSignals", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(testGroupEClass, TestGroup.class, "TestGroup", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTestGroup_Name(), ecorePackage.getEString(), "name", null, 1, 1, TestGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTestGroup_TestCases(), this.getTestCase(), null, "testCases", null, 0, -1, TestGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestGroup_Description(), ecorePackage.getEString(), "description", null, 0, 1, TestGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTestGroup_Externalreference(), this.getExternalReference(), null, "externalreference", null, 0, 1, TestGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTestGroup_TestGroups(), this.getTestGroup(), null, "testGroups", null, 0, -1, TestGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTestGroup_Capltestcases(), this.getCAPLTestCase(), null, "capltestcases", null, 0, -1, TestGroup.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(testCaseEClass, TestCase.class, "TestCase", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTestCase_Name(), ecorePackage.getEString(), "name", null, 1, 1, TestCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTestCase_TestSteps(), this.getTestStep(), null, "testSteps", null, 0, -1, TestCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestCase_Id(), ecorePackage.getEString(), "id", null, 0, 1, TestCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestCase_Description(), ecorePackage.getEString(), "description", null, 0, 1, TestCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTestCase_Variants(), this.getVariant(), null, "variants", null, 0, -1, TestCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTestCase_PreConditions(), this.getTestStep(), null, "preConditions", null, 0, -1, TestCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTestCase_PostConditions(), this.getTestStep(), null, "postConditions", null, 0, -1, TestCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestCase_RequirementID(), ecorePackage.getEString(), "requirementID", null, 0, 1, TestCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestCase_ExecutionStatus(), this.getExecutionStatueTypeEnum(), "executionStatus", null, 0, 1, TestCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTestCase_Externalreference(), this.getExternalReference(), null, "externalreference", null, 0, 1, TestCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTestCase_Skip(), ecorePackage.getEBoolean(), "skip", null, 0, 1, TestCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTestCase_TraceabilityArtifacts(), this.getTracebilityArtifact(), null, "traceabilityArtifacts", null, 0, -1, TestCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(testStepEClass, TestStep.class, "TestStep", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTestStep_Title(), ecorePackage.getEString(), "title", null, 0, 1, TestStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTestStep_NextStep(), this.getTestStep(), null, "nextStep", null, 0, 1, TestStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getTestStep_Key(), this.getSignalType(), null, "key", null, 0, 1, TestStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(waitActionEClass, WaitAction.class, "WaitAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(checkActionEClass, CheckAction.class, "CheckAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCheckAction_Operator(), this.getOperatorTypeEnum(), "operator", null, 0, 1, CheckAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(setActionEClass, SetAction.class, "SetAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(signalTypeEClass, SignalType.class, "SignalType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getSignalType_Name(), ecorePackage.getEString(), "name", null, 0, 1, SignalType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSignalType_Type(), this.getSignalTypeEnum(), "type", null, 0, 1, SignalType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSignalType_MessageName(), ecorePackage.getEString(), "MessageName", null, 0, 1, SignalType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSignalType_Node(), ecorePackage.getEString(), "node", null, 0, 1, SignalType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSignalType_Namespace(), ecorePackage.getEString(), "namespace", null, 0, 1, SignalType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSignalType_CreationMode(), this.getCreationModeEnum(), "creationMode", null, 0, 1, SignalType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getSignalType_LookupValues(), ecorePackage.getEString(), "lookupValues", null, 0, -1, SignalType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(diagnosticServiceEClass, DiagnosticService.class, "DiagnosticService", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDiagnosticService_Ecu(), ecorePackage.getEString(), "ecu", null, 0, 1, DiagnosticService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDiagnosticService_Service(), ecorePackage.getEString(), "service", null, 0, 1, DiagnosticService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDiagnosticService_Result(), ecorePackage.getEString(), "result", null, 0, 1, DiagnosticService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDiagnosticService_Diagrequest(), this.getDiagnosticRequest(), null, "diagrequest", null, 1, 1, DiagnosticService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDiagnosticService_Diagresponse(), this.getDiagnosticResponse(), null, "diagresponse", null, 1, 1, DiagnosticService.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(externalReferenceEClass, ExternalReference.class, "ExternalReference", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getExternalReference_Title(), ecorePackage.getEString(), "title", null, 0, 1, ExternalReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExternalReference_Url(), ecorePackage.getEString(), "url", null, 0, 1, ExternalReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExternalReference_Owner(), ecorePackage.getEString(), "owner", null, 0, 1, ExternalReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getExternalReference_Type(), ecorePackage.getEString(), "type", null, 0, 1, ExternalReference.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(caplTestCaseEClass, CAPLTestCase.class, "CAPLTestCase", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCAPLTestCase_Name(), ecorePackage.getEString(), "name", null, 1, 1, CAPLTestCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getCAPLTestCase_Parameters(), this.getCAPLParam(), null, "parameters", null, 0, -1, CAPLTestCase.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(caplParamEClass, CAPLParam.class, "CAPLParam", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCAPLParam_Name(), ecorePackage.getEString(), "name", null, 0, 1, CAPLParam.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCAPLParam_Type(), ecorePackage.getEString(), "type", null, 0, 1, CAPLParam.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCAPLParam_Value(), ecorePackage.getEString(), "value", null, 0, 1, CAPLParam.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(variantEClass, Variant.class, "Variant", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVariant_Name(), ecorePackage.getEString(), "name", null, 1, 1, Variant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVariant_Description(), ecorePackage.getEString(), "description", null, 0, 1, Variant.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(caplTestStepEClass, CAPLTestStep.class, "CAPLTestStep", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getCAPLTestStep_Parameters(), this.getCAPLParam(), null, "parameters", null, 0, -1, CAPLTestStep.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(importArtifactEClass, ImportArtifact.class, "ImportArtifact", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getImportArtifact_Path(), ecorePackage.getEString(), "path", null, 0, 1, ImportArtifact.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getImportArtifact_SignalType(), this.getSignalType(), null, "signalType", null, 0, -1, ImportArtifact.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(diagnosticRequestEClass, DiagnosticRequest.class, "DiagnosticRequest", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDiagnosticRequest_Diagparam(), this.getDiagnosticParam(), null, "diagparam", null, 0, -1, DiagnosticRequest.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(diagnosticResponseEClass, DiagnosticResponse.class, "DiagnosticResponse", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDiagnosticResponse_Primitive(), ecorePackage.getEString(), "primitive", null, 0, 1, DiagnosticResponse.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDiagnosticResponse_Diagparam(), this.getDiagnosticParam(), null, "diagparam", null, 0, -1, DiagnosticResponse.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(diagnosticParamEClass, DiagnosticParam.class, "DiagnosticParam", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getDiagnosticParam_Qualifier(), ecorePackage.getEString(), "qualifier", null, 0, 1, DiagnosticParam.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDiagnosticParam_CopyToVar(), ecorePackage.getEString(), "copyToVar", null, 0, 1, DiagnosticParam.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDiagnosticParam_ValueTypes(), this.getDiagnosticParamValueType(), null, "valueTypes", null, 1, 1, DiagnosticParam.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(actionEClass, Action.class, "Action", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getAction_Value(), ecorePackage.getEString(), "value", null, 0, 1, Action.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAction_Wait(), ecorePackage.getEFloat(), "wait", null, 0, 1, Action.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getAction_ValueTo(), ecorePackage.getEString(), "valueTo", null, 0, 1, Action.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(blockActionEClass, BlockAction.class, "BlockAction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getBlockAction_TestSteps(), this.getTestStep(), null, "testSteps", null, 1, -1, BlockAction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(forLoopEClass, ForLoop.class, "ForLoop", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getForLoop_LoopVar(), ecorePackage.getEString(), "loopVar", null, 0, 1, ForLoop.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getForLoop_StopValue(), ecorePackage.getEInt(), "stopValue", null, 0, 1, ForLoop.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getForLoop_StartValue(), ecorePackage.getEInt(), "startValue", null, 0, 1, ForLoop.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(whileLoopEClass, WhileLoop.class, "WhileLoop", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getWhileLoop_Value(), ecorePackage.getEString(), "value", null, 0, 1, WhileLoop.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWhileLoop_ValueTo(), ecorePackage.getEString(), "valueTo", null, 0, 1, WhileLoop.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getWhileLoop_Operator(), this.getOperatorTypeEnum(), "operator", null, 0, 1, WhileLoop.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(diagnosticParamValueTypeEClass, DiagnosticParamValueType.class, "DiagnosticParamValueType", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(varEClass, Var.class, "Var", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVar_Name(), ecorePackage.getEString(), "name", null, 1, 1, Var.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(oneOfEClass, OneOf.class, "OneOf", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getOneOf_Values(), ecorePackage.getEString(), "values", null, 1, -1, OneOf.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(rangeEClass, Range.class, "Range", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRange_From(), ecorePackage.getEInt(), "from", null, 1, 1, Range.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getRange_To(), ecorePackage.getEInt(), "to", null, 1, 1, Range.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(tracebilityArtifactEClass, TracebilityArtifact.class, "TracebilityArtifact", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getTracebilityArtifact_Type(), this.getTraceabilityArtifactEnum(), "type", null, 0, 1, TracebilityArtifact.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getTracebilityArtifact_Url(), ecorePackage.getEString(), "url", null, 0, 1, TracebilityArtifact.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Initialize enums and add enum literals
		initEEnum(operatorTypeEnumEEnum, OperatorTypeEnum.class, "OperatorTypeEnum");
		addEEnumLiteral(operatorTypeEnumEEnum, OperatorTypeEnum.EQ);
		addEEnumLiteral(operatorTypeEnumEEnum, OperatorTypeEnum.NE);
		addEEnumLiteral(operatorTypeEnumEEnum, OperatorTypeEnum.GT);
		addEEnumLiteral(operatorTypeEnumEEnum, OperatorTypeEnum.LT);
		addEEnumLiteral(operatorTypeEnumEEnum, OperatorTypeEnum.BT);

		initEEnum(signalTypeEnumEEnum, SignalTypeEnum.class, "SignalTypeEnum");
		addEEnumLiteral(signalTypeEnumEEnum, SignalTypeEnum.SIGNAL);
		addEEnumLiteral(signalTypeEnumEEnum, SignalTypeEnum.ENVIRONMENT);
		addEEnumLiteral(signalTypeEnumEEnum, SignalTypeEnum.SYSTEM);
		addEEnumLiteral(signalTypeEnumEEnum, SignalTypeEnum.UNDEFINED);

		initEEnum(executionStatueTypeEnumEEnum, ExecutionStatueTypeEnum.class, "ExecutionStatueTypeEnum");
		addEEnumLiteral(executionStatueTypeEnumEEnum, ExecutionStatueTypeEnum.NOT_EXECUTED);
		addEEnumLiteral(executionStatueTypeEnumEEnum, ExecutionStatueTypeEnum.PASS);
		addEEnumLiteral(executionStatueTypeEnumEEnum, ExecutionStatueTypeEnum.FAIL);

		initEEnum(creationModeEnumEEnum, CreationModeEnum.class, "CreationModeEnum");
		addEEnumLiteral(creationModeEnumEEnum, CreationModeEnum.IMPORTED);
		addEEnumLiteral(creationModeEnumEEnum, CreationModeEnum.USER_DEFINED);

		initEEnum(traceabilityArtifactEnumEEnum, TraceabilityArtifactEnum.class, "TraceabilityArtifactEnum");
		addEEnumLiteral(traceabilityArtifactEnumEEnum, TraceabilityArtifactEnum.REQUIREMENT);
		addEEnumLiteral(traceabilityArtifactEnumEEnum, TraceabilityArtifactEnum.TEST);
		addEEnumLiteral(traceabilityArtifactEnumEEnum, TraceabilityArtifactEnum.BUG);
		addEEnumLiteral(traceabilityArtifactEnumEEnum, TraceabilityArtifactEnum.OTHERS);

		// Initialize data types
		initEDataType(arrayListDataTypeEDataType, ArrayList.class, "ArrayListDataType", IS_SERIALIZABLE, !IS_GENERATED_INSTANCE_CLASS, "java.util.ArrayList<DiagonosticModel.SignalType>");

		// Create resource
		createResource(eNS_URI);
	}

} //DiagonosticModelPackageImpl
