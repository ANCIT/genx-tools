/**
 */
package DiagonosticModel.util;

import DiagonosticModel.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see DiagonosticModel.DiagonosticModelPackage
 * @generated
 */
public class DiagonosticModelAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static DiagonosticModelPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DiagonosticModelAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = DiagonosticModelPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DiagonosticModelSwitch<Adapter> modelSwitch =
		new DiagonosticModelSwitch<Adapter>() {
			@Override
			public Adapter caseTestSpecification(TestSpecification object) {
				return createTestSpecificationAdapter();
			}
			@Override
			public Adapter caseTestGroup(TestGroup object) {
				return createTestGroupAdapter();
			}
			@Override
			public Adapter caseTestCase(TestCase object) {
				return createTestCaseAdapter();
			}
			@Override
			public Adapter caseTestStep(TestStep object) {
				return createTestStepAdapter();
			}
			@Override
			public Adapter caseWaitAction(WaitAction object) {
				return createWaitActionAdapter();
			}
			@Override
			public Adapter caseCheckAction(CheckAction object) {
				return createCheckActionAdapter();
			}
			@Override
			public Adapter caseSetAction(SetAction object) {
				return createSetActionAdapter();
			}
			@Override
			public Adapter caseSignalType(SignalType object) {
				return createSignalTypeAdapter();
			}
			@Override
			public Adapter caseDiagnosticService(DiagnosticService object) {
				return createDiagnosticServiceAdapter();
			}
			@Override
			public Adapter caseExternalReference(ExternalReference object) {
				return createExternalReferenceAdapter();
			}
			@Override
			public Adapter caseCAPLTestCase(CAPLTestCase object) {
				return createCAPLTestCaseAdapter();
			}
			@Override
			public Adapter caseCAPLParam(CAPLParam object) {
				return createCAPLParamAdapter();
			}
			@Override
			public Adapter caseVariant(Variant object) {
				return createVariantAdapter();
			}
			@Override
			public Adapter caseCAPLTestStep(CAPLTestStep object) {
				return createCAPLTestStepAdapter();
			}
			@Override
			public Adapter caseImportArtifact(ImportArtifact object) {
				return createImportArtifactAdapter();
			}
			@Override
			public Adapter caseDiagnosticRequest(DiagnosticRequest object) {
				return createDiagnosticRequestAdapter();
			}
			@Override
			public Adapter caseDiagnosticResponse(DiagnosticResponse object) {
				return createDiagnosticResponseAdapter();
			}
			@Override
			public Adapter caseDiagnosticParam(DiagnosticParam object) {
				return createDiagnosticParamAdapter();
			}
			@Override
			public Adapter caseAction(Action object) {
				return createActionAdapter();
			}
			@Override
			public Adapter caseBlockAction(BlockAction object) {
				return createBlockActionAdapter();
			}
			@Override
			public Adapter caseForLoop(ForLoop object) {
				return createForLoopAdapter();
			}
			@Override
			public Adapter caseWhileLoop(WhileLoop object) {
				return createWhileLoopAdapter();
			}
			@Override
			public Adapter caseDiagnosticParamValueType(DiagnosticParamValueType object) {
				return createDiagnosticParamValueTypeAdapter();
			}
			@Override
			public Adapter caseVar(Var object) {
				return createVarAdapter();
			}
			@Override
			public Adapter caseOneOf(OneOf object) {
				return createOneOfAdapter();
			}
			@Override
			public Adapter caseRange(Range object) {
				return createRangeAdapter();
			}
			@Override
			public Adapter caseTracebilityArtifact(TracebilityArtifact object) {
				return createTracebilityArtifactAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link DiagonosticModel.TestSpecification <em>Test Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see DiagonosticModel.TestSpecification
	 * @generated
	 */
	public Adapter createTestSpecificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link DiagonosticModel.TestGroup <em>Test Group</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see DiagonosticModel.TestGroup
	 * @generated
	 */
	public Adapter createTestGroupAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link DiagonosticModel.TestCase <em>Test Case</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see DiagonosticModel.TestCase
	 * @generated
	 */
	public Adapter createTestCaseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link DiagonosticModel.TestStep <em>Test Step</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see DiagonosticModel.TestStep
	 * @generated
	 */
	public Adapter createTestStepAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link DiagonosticModel.WaitAction <em>Wait Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see DiagonosticModel.WaitAction
	 * @generated
	 */
	public Adapter createWaitActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link DiagonosticModel.CheckAction <em>Check Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see DiagonosticModel.CheckAction
	 * @generated
	 */
	public Adapter createCheckActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link DiagonosticModel.SetAction <em>Set Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see DiagonosticModel.SetAction
	 * @generated
	 */
	public Adapter createSetActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link DiagonosticModel.SignalType <em>Signal Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see DiagonosticModel.SignalType
	 * @generated
	 */
	public Adapter createSignalTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link DiagonosticModel.DiagnosticService <em>Diagnostic Service</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see DiagonosticModel.DiagnosticService
	 * @generated
	 */
	public Adapter createDiagnosticServiceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link DiagonosticModel.ExternalReference <em>External Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see DiagonosticModel.ExternalReference
	 * @generated
	 */
	public Adapter createExternalReferenceAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link DiagonosticModel.CAPLTestCase <em>CAPL Test Case</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see DiagonosticModel.CAPLTestCase
	 * @generated
	 */
	public Adapter createCAPLTestCaseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link DiagonosticModel.CAPLParam <em>CAPL Param</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see DiagonosticModel.CAPLParam
	 * @generated
	 */
	public Adapter createCAPLParamAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link DiagonosticModel.Variant <em>Variant</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see DiagonosticModel.Variant
	 * @generated
	 */
	public Adapter createVariantAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link DiagonosticModel.CAPLTestStep <em>CAPL Test Step</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see DiagonosticModel.CAPLTestStep
	 * @generated
	 */
	public Adapter createCAPLTestStepAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link DiagonosticModel.ImportArtifact <em>Import Artifact</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see DiagonosticModel.ImportArtifact
	 * @generated
	 */
	public Adapter createImportArtifactAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link DiagonosticModel.DiagnosticRequest <em>Diagnostic Request</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see DiagonosticModel.DiagnosticRequest
	 * @generated
	 */
	public Adapter createDiagnosticRequestAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link DiagonosticModel.DiagnosticResponse <em>Diagnostic Response</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see DiagonosticModel.DiagnosticResponse
	 * @generated
	 */
	public Adapter createDiagnosticResponseAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link DiagonosticModel.DiagnosticParam <em>Diagnostic Param</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see DiagonosticModel.DiagnosticParam
	 * @generated
	 */
	public Adapter createDiagnosticParamAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link DiagonosticModel.Action <em>Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see DiagonosticModel.Action
	 * @generated
	 */
	public Adapter createActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link DiagonosticModel.BlockAction <em>Block Action</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see DiagonosticModel.BlockAction
	 * @generated
	 */
	public Adapter createBlockActionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link DiagonosticModel.ForLoop <em>For Loop</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see DiagonosticModel.ForLoop
	 * @generated
	 */
	public Adapter createForLoopAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link DiagonosticModel.WhileLoop <em>While Loop</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see DiagonosticModel.WhileLoop
	 * @generated
	 */
	public Adapter createWhileLoopAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link DiagonosticModel.DiagnosticParamValueType <em>Diagnostic Param Value Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see DiagonosticModel.DiagnosticParamValueType
	 * @generated
	 */
	public Adapter createDiagnosticParamValueTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link DiagonosticModel.Var <em>Var</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see DiagonosticModel.Var
	 * @generated
	 */
	public Adapter createVarAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link DiagonosticModel.OneOf <em>One Of</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see DiagonosticModel.OneOf
	 * @generated
	 */
	public Adapter createOneOfAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link DiagonosticModel.Range <em>Range</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see DiagonosticModel.Range
	 * @generated
	 */
	public Adapter createRangeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link DiagonosticModel.TracebilityArtifact <em>Tracebility Artifact</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see DiagonosticModel.TracebilityArtifact
	 * @generated
	 */
	public Adapter createTracebilityArtifactAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //DiagonosticModelAdapterFactory
