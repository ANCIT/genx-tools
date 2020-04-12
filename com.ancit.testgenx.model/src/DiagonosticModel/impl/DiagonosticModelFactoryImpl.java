/**
 */
package DiagonosticModel.impl;

import DiagonosticModel.*;

import java.util.ArrayList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DiagonosticModelFactoryImpl extends EFactoryImpl implements DiagonosticModelFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static DiagonosticModelFactory init() {
		try {
			DiagonosticModelFactory theDiagonosticModelFactory = (DiagonosticModelFactory)EPackage.Registry.INSTANCE.getEFactory(DiagonosticModelPackage.eNS_URI);
			if (theDiagonosticModelFactory != null) {
				return theDiagonosticModelFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new DiagonosticModelFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DiagonosticModelFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case DiagonosticModelPackage.TEST_SPECIFICATION: return createTestSpecification();
			case DiagonosticModelPackage.TEST_GROUP: return createTestGroup();
			case DiagonosticModelPackage.TEST_CASE: return createTestCase();
			case DiagonosticModelPackage.WAIT_ACTION: return createWaitAction();
			case DiagonosticModelPackage.CHECK_ACTION: return createCheckAction();
			case DiagonosticModelPackage.SET_ACTION: return createSetAction();
			case DiagonosticModelPackage.SIGNAL_TYPE: return createSignalType();
			case DiagonosticModelPackage.DIAGNOSTIC_SERVICE: return createDiagnosticService();
			case DiagonosticModelPackage.EXTERNAL_REFERENCE: return createExternalReference();
			case DiagonosticModelPackage.CAPL_TEST_CASE: return createCAPLTestCase();
			case DiagonosticModelPackage.CAPL_PARAM: return createCAPLParam();
			case DiagonosticModelPackage.VARIANT: return createVariant();
			case DiagonosticModelPackage.CAPL_TEST_STEP: return createCAPLTestStep();
			case DiagonosticModelPackage.IMPORT_ARTIFACT: return createImportArtifact();
			case DiagonosticModelPackage.DIAGNOSTIC_REQUEST: return createDiagnosticRequest();
			case DiagonosticModelPackage.DIAGNOSTIC_RESPONSE: return createDiagnosticResponse();
			case DiagonosticModelPackage.DIAGNOSTIC_PARAM: return createDiagnosticParam();
			case DiagonosticModelPackage.BLOCK_ACTION: return createBlockAction();
			case DiagonosticModelPackage.FOR_LOOP: return createForLoop();
			case DiagonosticModelPackage.WHILE_LOOP: return createWhileLoop();
			case DiagonosticModelPackage.VAR: return createVar();
			case DiagonosticModelPackage.ONE_OF: return createOneOf();
			case DiagonosticModelPackage.RANGE: return createRange();
			case DiagonosticModelPackage.TRACEBILITY_ARTIFACT: return createTracebilityArtifact();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case DiagonosticModelPackage.OPERATOR_TYPE_ENUM:
				return createOperatorTypeEnumFromString(eDataType, initialValue);
			case DiagonosticModelPackage.SIGNAL_TYPE_ENUM:
				return createSignalTypeEnumFromString(eDataType, initialValue);
			case DiagonosticModelPackage.EXECUTION_STATUE_TYPE_ENUM:
				return createExecutionStatueTypeEnumFromString(eDataType, initialValue);
			case DiagonosticModelPackage.CREATION_MODE_ENUM:
				return createCreationModeEnumFromString(eDataType, initialValue);
			case DiagonosticModelPackage.TRACEABILITY_ARTIFACT_ENUM:
				return createTraceabilityArtifactEnumFromString(eDataType, initialValue);
			case DiagonosticModelPackage.ARRAY_LIST_DATA_TYPE:
				return createArrayListDataTypeFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case DiagonosticModelPackage.OPERATOR_TYPE_ENUM:
				return convertOperatorTypeEnumToString(eDataType, instanceValue);
			case DiagonosticModelPackage.SIGNAL_TYPE_ENUM:
				return convertSignalTypeEnumToString(eDataType, instanceValue);
			case DiagonosticModelPackage.EXECUTION_STATUE_TYPE_ENUM:
				return convertExecutionStatueTypeEnumToString(eDataType, instanceValue);
			case DiagonosticModelPackage.CREATION_MODE_ENUM:
				return convertCreationModeEnumToString(eDataType, instanceValue);
			case DiagonosticModelPackage.TRACEABILITY_ARTIFACT_ENUM:
				return convertTraceabilityArtifactEnumToString(eDataType, instanceValue);
			case DiagonosticModelPackage.ARRAY_LIST_DATA_TYPE:
				return convertArrayListDataTypeToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TestSpecification createTestSpecification() {
		TestSpecificationImpl testSpecification = new TestSpecificationImpl();
		return testSpecification;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TestGroup createTestGroup() {
		TestGroupImpl testGroup = new TestGroupImpl();
		return testGroup;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TestCase createTestCase() {
		TestCaseImpl testCase = new TestCaseImpl();
		return testCase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public WaitAction createWaitAction() {
		WaitActionImpl waitAction = new WaitActionImpl();
		return waitAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CheckAction createCheckAction() {
		CheckActionImpl checkAction = new CheckActionImpl();
		return checkAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SetAction createSetAction() {
		SetActionImpl setAction = new SetActionImpl();
		return setAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SignalType createSignalType() {
		SignalTypeImpl signalType = new SignalTypeImpl();
		return signalType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DiagnosticService createDiagnosticService() {
		DiagnosticServiceImpl diagnosticService = new DiagnosticServiceImpl();
		return diagnosticService;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ExternalReference createExternalReference() {
		ExternalReferenceImpl externalReference = new ExternalReferenceImpl();
		return externalReference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CAPLTestCase createCAPLTestCase() {
		CAPLTestCaseImpl caplTestCase = new CAPLTestCaseImpl();
		return caplTestCase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CAPLParam createCAPLParam() {
		CAPLParamImpl caplParam = new CAPLParamImpl();
		return caplParam;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Variant createVariant() {
		VariantImpl variant = new VariantImpl();
		return variant;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CAPLTestStep createCAPLTestStep() {
		CAPLTestStepImpl caplTestStep = new CAPLTestStepImpl();
		return caplTestStep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ImportArtifact createImportArtifact() {
		ImportArtifactImpl importArtifact = new ImportArtifactImpl();
		return importArtifact;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DiagnosticRequest createDiagnosticRequest() {
		DiagnosticRequestImpl diagnosticRequest = new DiagnosticRequestImpl();
		return diagnosticRequest;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DiagnosticResponse createDiagnosticResponse() {
		DiagnosticResponseImpl diagnosticResponse = new DiagnosticResponseImpl();
		return diagnosticResponse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DiagnosticParam createDiagnosticParam() {
		DiagnosticParamImpl diagnosticParam = new DiagnosticParamImpl();
		return diagnosticParam;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BlockAction createBlockAction() {
		BlockActionImpl blockAction = new BlockActionImpl();
		return blockAction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ForLoop createForLoop() {
		ForLoopImpl forLoop = new ForLoopImpl();
		return forLoop;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public WhileLoop createWhileLoop() {
		WhileLoopImpl whileLoop = new WhileLoopImpl();
		return whileLoop;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Var createVar() {
		VarImpl var = new VarImpl();
		return var;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public OneOf createOneOf() {
		OneOfImpl oneOf = new OneOfImpl();
		return oneOf;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Range createRange() {
		RangeImpl range = new RangeImpl();
		return range;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TracebilityArtifact createTracebilityArtifact() {
		TracebilityArtifactImpl tracebilityArtifact = new TracebilityArtifactImpl();
		return tracebilityArtifact;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public OperatorTypeEnum createOperatorTypeEnumFromString(EDataType eDataType, String initialValue) {
		OperatorTypeEnum result = OperatorTypeEnum.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertOperatorTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SignalTypeEnum createSignalTypeEnumFromString(EDataType eDataType, String initialValue) {
		SignalTypeEnum result = SignalTypeEnum.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertSignalTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionStatueTypeEnum createExecutionStatueTypeEnumFromString(EDataType eDataType, String initialValue) {
		ExecutionStatueTypeEnum result = ExecutionStatueTypeEnum.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertExecutionStatueTypeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CreationModeEnum createCreationModeEnumFromString(EDataType eDataType, String initialValue) {
		CreationModeEnum result = CreationModeEnum.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertCreationModeEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TraceabilityArtifactEnum createTraceabilityArtifactEnumFromString(EDataType eDataType, String initialValue) {
		TraceabilityArtifactEnum result = TraceabilityArtifactEnum.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertTraceabilityArtifactEnumToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<SignalType> createArrayListDataTypeFromString(EDataType eDataType, String initialValue) {
		return (ArrayList<SignalType>)super.createFromString(initialValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertArrayListDataTypeToString(EDataType eDataType, Object instanceValue) {
		return super.convertToString(instanceValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DiagonosticModelPackage getDiagonosticModelPackage() {
		return (DiagonosticModelPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static DiagonosticModelPackage getPackage() {
		return DiagonosticModelPackage.eINSTANCE;
	}

} //DiagonosticModelFactoryImpl
