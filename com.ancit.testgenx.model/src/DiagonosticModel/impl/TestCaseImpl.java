/**
 */
package DiagonosticModel.impl;

import DiagonosticModel.DiagonosticModelPackage;
import DiagonosticModel.ExecutionStatueTypeEnum;
import DiagonosticModel.ExternalReference;
import DiagonosticModel.TestCase;
import DiagonosticModel.TestStep;

import DiagonosticModel.TracebilityArtifact;
import DiagonosticModel.Variant;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Test Case</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link DiagonosticModel.impl.TestCaseImpl#getName <em>Name</em>}</li>
 *   <li>{@link DiagonosticModel.impl.TestCaseImpl#getTestSteps <em>Test Steps</em>}</li>
 *   <li>{@link DiagonosticModel.impl.TestCaseImpl#getId <em>Id</em>}</li>
 *   <li>{@link DiagonosticModel.impl.TestCaseImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link DiagonosticModel.impl.TestCaseImpl#getVariants <em>Variants</em>}</li>
 *   <li>{@link DiagonosticModel.impl.TestCaseImpl#getPreConditions <em>Pre Conditions</em>}</li>
 *   <li>{@link DiagonosticModel.impl.TestCaseImpl#getPostConditions <em>Post Conditions</em>}</li>
 *   <li>{@link DiagonosticModel.impl.TestCaseImpl#getRequirementID <em>Requirement ID</em>}</li>
 *   <li>{@link DiagonosticModel.impl.TestCaseImpl#getExecutionStatus <em>Execution Status</em>}</li>
 *   <li>{@link DiagonosticModel.impl.TestCaseImpl#getExternalreference <em>Externalreference</em>}</li>
 *   <li>{@link DiagonosticModel.impl.TestCaseImpl#isSkip <em>Skip</em>}</li>
 *   <li>{@link DiagonosticModel.impl.TestCaseImpl#getTraceabilityArtifacts <em>Traceability Artifacts</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TestCaseImpl extends MinimalEObjectImpl.Container implements TestCase {
	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTestSteps() <em>Test Steps</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTestSteps()
	 * @generated
	 * @ordered
	 */
	protected EList<TestStep> testSteps;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected String id = ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected static final String DESCRIPTION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getDescription() <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDescription()
	 * @generated
	 * @ordered
	 */
	protected String description = DESCRIPTION_EDEFAULT;

	/**
	 * The cached value of the '{@link #getVariants() <em>Variants</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariants()
	 * @generated
	 * @ordered
	 */
	protected EList<Variant> variants;

	/**
	 * The cached value of the '{@link #getPreConditions() <em>Pre Conditions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPreConditions()
	 * @generated
	 * @ordered
	 */
	protected EList<TestStep> preConditions;

	/**
	 * The cached value of the '{@link #getPostConditions() <em>Post Conditions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPostConditions()
	 * @generated
	 * @ordered
	 */
	protected EList<TestStep> postConditions;

	/**
	 * The default value of the '{@link #getRequirementID() <em>Requirement ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequirementID()
	 * @generated
	 * @ordered
	 */
	protected static final String REQUIREMENT_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getRequirementID() <em>Requirement ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequirementID()
	 * @generated
	 * @ordered
	 */
	protected String requirementID = REQUIREMENT_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getExecutionStatus() <em>Execution Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExecutionStatus()
	 * @generated
	 * @ordered
	 */
	protected static final ExecutionStatueTypeEnum EXECUTION_STATUS_EDEFAULT = ExecutionStatueTypeEnum.NOT_EXECUTED;

	/**
	 * The cached value of the '{@link #getExecutionStatus() <em>Execution Status</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExecutionStatus()
	 * @generated
	 * @ordered
	 */
	protected ExecutionStatueTypeEnum executionStatus = EXECUTION_STATUS_EDEFAULT;

	/**
	 * The cached value of the '{@link #getExternalreference() <em>Externalreference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExternalreference()
	 * @generated
	 * @ordered
	 */
	protected ExternalReference externalreference;

	/**
	 * The default value of the '{@link #isSkip() <em>Skip</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSkip()
	 * @generated
	 * @ordered
	 */
	protected static final boolean SKIP_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isSkip() <em>Skip</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSkip()
	 * @generated
	 * @ordered
	 */
	protected boolean skip = SKIP_EDEFAULT;

	/**
	 * The cached value of the '{@link #getTraceabilityArtifacts() <em>Traceability Artifacts</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTraceabilityArtifacts()
	 * @generated
	 * @ordered
	 */
	protected EList<TracebilityArtifact> traceabilityArtifacts;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TestCaseImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DiagonosticModelPackage.Literals.TEST_CASE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagonosticModelPackage.TEST_CASE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<TestStep> getTestSteps() {
		if (testSteps == null) {
			testSteps = new EObjectContainmentEList<TestStep>(TestStep.class, this, DiagonosticModelPackage.TEST_CASE__TEST_STEPS);
		}
		return testSteps;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getId() {
		return id;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setId(String newId) {
		String oldId = id;
		id = newId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagonosticModelPackage.TEST_CASE__ID, oldId, id));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getDescription() {
		return description;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setDescription(String newDescription) {
		String oldDescription = description;
		description = newDescription;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagonosticModelPackage.TEST_CASE__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Variant> getVariants() {
		if (variants == null) {
			variants = new EObjectResolvingEList<Variant>(Variant.class, this, DiagonosticModelPackage.TEST_CASE__VARIANTS);
		}
		return variants;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<TestStep> getPreConditions() {
		if (preConditions == null) {
			preConditions = new EObjectContainmentEList<TestStep>(TestStep.class, this, DiagonosticModelPackage.TEST_CASE__PRE_CONDITIONS);
		}
		return preConditions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<TestStep> getPostConditions() {
		if (postConditions == null) {
			postConditions = new EObjectContainmentEList<TestStep>(TestStep.class, this, DiagonosticModelPackage.TEST_CASE__POST_CONDITIONS);
		}
		return postConditions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getRequirementID() {
		return requirementID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setRequirementID(String newRequirementID) {
		String oldRequirementID = requirementID;
		requirementID = newRequirementID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagonosticModelPackage.TEST_CASE__REQUIREMENT_ID, oldRequirementID, requirementID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ExecutionStatueTypeEnum getExecutionStatus() {
		return executionStatus;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setExecutionStatus(ExecutionStatueTypeEnum newExecutionStatus) {
		ExecutionStatueTypeEnum oldExecutionStatus = executionStatus;
		executionStatus = newExecutionStatus == null ? EXECUTION_STATUS_EDEFAULT : newExecutionStatus;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagonosticModelPackage.TEST_CASE__EXECUTION_STATUS, oldExecutionStatus, executionStatus));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ExternalReference getExternalreference() {
		if (externalreference != null && externalreference.eIsProxy()) {
			InternalEObject oldExternalreference = (InternalEObject)externalreference;
			externalreference = (ExternalReference)eResolveProxy(oldExternalreference);
			if (externalreference != oldExternalreference) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, DiagonosticModelPackage.TEST_CASE__EXTERNALREFERENCE, oldExternalreference, externalreference));
			}
		}
		return externalreference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExternalReference basicGetExternalreference() {
		return externalreference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setExternalreference(ExternalReference newExternalreference) {
		ExternalReference oldExternalreference = externalreference;
		externalreference = newExternalreference;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagonosticModelPackage.TEST_CASE__EXTERNALREFERENCE, oldExternalreference, externalreference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSkip() {
		return skip;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSkip(boolean newSkip) {
		boolean oldSkip = skip;
		skip = newSkip;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagonosticModelPackage.TEST_CASE__SKIP, oldSkip, skip));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<TracebilityArtifact> getTraceabilityArtifacts() {
		if (traceabilityArtifacts == null) {
			traceabilityArtifacts = new EObjectContainmentEList<TracebilityArtifact>(TracebilityArtifact.class, this, DiagonosticModelPackage.TEST_CASE__TRACEABILITY_ARTIFACTS);
		}
		return traceabilityArtifacts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DiagonosticModelPackage.TEST_CASE__TEST_STEPS:
				return ((InternalEList<?>)getTestSteps()).basicRemove(otherEnd, msgs);
			case DiagonosticModelPackage.TEST_CASE__PRE_CONDITIONS:
				return ((InternalEList<?>)getPreConditions()).basicRemove(otherEnd, msgs);
			case DiagonosticModelPackage.TEST_CASE__POST_CONDITIONS:
				return ((InternalEList<?>)getPostConditions()).basicRemove(otherEnd, msgs);
			case DiagonosticModelPackage.TEST_CASE__TRACEABILITY_ARTIFACTS:
				return ((InternalEList<?>)getTraceabilityArtifacts()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DiagonosticModelPackage.TEST_CASE__NAME:
				return getName();
			case DiagonosticModelPackage.TEST_CASE__TEST_STEPS:
				return getTestSteps();
			case DiagonosticModelPackage.TEST_CASE__ID:
				return getId();
			case DiagonosticModelPackage.TEST_CASE__DESCRIPTION:
				return getDescription();
			case DiagonosticModelPackage.TEST_CASE__VARIANTS:
				return getVariants();
			case DiagonosticModelPackage.TEST_CASE__PRE_CONDITIONS:
				return getPreConditions();
			case DiagonosticModelPackage.TEST_CASE__POST_CONDITIONS:
				return getPostConditions();
			case DiagonosticModelPackage.TEST_CASE__REQUIREMENT_ID:
				return getRequirementID();
			case DiagonosticModelPackage.TEST_CASE__EXECUTION_STATUS:
				return getExecutionStatus();
			case DiagonosticModelPackage.TEST_CASE__EXTERNALREFERENCE:
				if (resolve) return getExternalreference();
				return basicGetExternalreference();
			case DiagonosticModelPackage.TEST_CASE__SKIP:
				return isSkip();
			case DiagonosticModelPackage.TEST_CASE__TRACEABILITY_ARTIFACTS:
				return getTraceabilityArtifacts();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DiagonosticModelPackage.TEST_CASE__NAME:
				setName((String)newValue);
				return;
			case DiagonosticModelPackage.TEST_CASE__TEST_STEPS:
				getTestSteps().clear();
				getTestSteps().addAll((Collection<? extends TestStep>)newValue);
				return;
			case DiagonosticModelPackage.TEST_CASE__ID:
				setId((String)newValue);
				return;
			case DiagonosticModelPackage.TEST_CASE__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case DiagonosticModelPackage.TEST_CASE__VARIANTS:
				getVariants().clear();
				getVariants().addAll((Collection<? extends Variant>)newValue);
				return;
			case DiagonosticModelPackage.TEST_CASE__PRE_CONDITIONS:
				getPreConditions().clear();
				getPreConditions().addAll((Collection<? extends TestStep>)newValue);
				return;
			case DiagonosticModelPackage.TEST_CASE__POST_CONDITIONS:
				getPostConditions().clear();
				getPostConditions().addAll((Collection<? extends TestStep>)newValue);
				return;
			case DiagonosticModelPackage.TEST_CASE__REQUIREMENT_ID:
				setRequirementID((String)newValue);
				return;
			case DiagonosticModelPackage.TEST_CASE__EXECUTION_STATUS:
				setExecutionStatus((ExecutionStatueTypeEnum)newValue);
				return;
			case DiagonosticModelPackage.TEST_CASE__EXTERNALREFERENCE:
				setExternalreference((ExternalReference)newValue);
				return;
			case DiagonosticModelPackage.TEST_CASE__SKIP:
				setSkip((Boolean)newValue);
				return;
			case DiagonosticModelPackage.TEST_CASE__TRACEABILITY_ARTIFACTS:
				getTraceabilityArtifacts().clear();
				getTraceabilityArtifacts().addAll((Collection<? extends TracebilityArtifact>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case DiagonosticModelPackage.TEST_CASE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case DiagonosticModelPackage.TEST_CASE__TEST_STEPS:
				getTestSteps().clear();
				return;
			case DiagonosticModelPackage.TEST_CASE__ID:
				setId(ID_EDEFAULT);
				return;
			case DiagonosticModelPackage.TEST_CASE__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case DiagonosticModelPackage.TEST_CASE__VARIANTS:
				getVariants().clear();
				return;
			case DiagonosticModelPackage.TEST_CASE__PRE_CONDITIONS:
				getPreConditions().clear();
				return;
			case DiagonosticModelPackage.TEST_CASE__POST_CONDITIONS:
				getPostConditions().clear();
				return;
			case DiagonosticModelPackage.TEST_CASE__REQUIREMENT_ID:
				setRequirementID(REQUIREMENT_ID_EDEFAULT);
				return;
			case DiagonosticModelPackage.TEST_CASE__EXECUTION_STATUS:
				setExecutionStatus(EXECUTION_STATUS_EDEFAULT);
				return;
			case DiagonosticModelPackage.TEST_CASE__EXTERNALREFERENCE:
				setExternalreference((ExternalReference)null);
				return;
			case DiagonosticModelPackage.TEST_CASE__SKIP:
				setSkip(SKIP_EDEFAULT);
				return;
			case DiagonosticModelPackage.TEST_CASE__TRACEABILITY_ARTIFACTS:
				getTraceabilityArtifacts().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case DiagonosticModelPackage.TEST_CASE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case DiagonosticModelPackage.TEST_CASE__TEST_STEPS:
				return testSteps != null && !testSteps.isEmpty();
			case DiagonosticModelPackage.TEST_CASE__ID:
				return ID_EDEFAULT == null ? id != null : !ID_EDEFAULT.equals(id);
			case DiagonosticModelPackage.TEST_CASE__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case DiagonosticModelPackage.TEST_CASE__VARIANTS:
				return variants != null && !variants.isEmpty();
			case DiagonosticModelPackage.TEST_CASE__PRE_CONDITIONS:
				return preConditions != null && !preConditions.isEmpty();
			case DiagonosticModelPackage.TEST_CASE__POST_CONDITIONS:
				return postConditions != null && !postConditions.isEmpty();
			case DiagonosticModelPackage.TEST_CASE__REQUIREMENT_ID:
				return REQUIREMENT_ID_EDEFAULT == null ? requirementID != null : !REQUIREMENT_ID_EDEFAULT.equals(requirementID);
			case DiagonosticModelPackage.TEST_CASE__EXECUTION_STATUS:
				return executionStatus != EXECUTION_STATUS_EDEFAULT;
			case DiagonosticModelPackage.TEST_CASE__EXTERNALREFERENCE:
				return externalreference != null;
			case DiagonosticModelPackage.TEST_CASE__SKIP:
				return skip != SKIP_EDEFAULT;
			case DiagonosticModelPackage.TEST_CASE__TRACEABILITY_ARTIFACTS:
				return traceabilityArtifacts != null && !traceabilityArtifacts.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(", id: ");
		result.append(id);
		result.append(", description: ");
		result.append(description);
		result.append(", requirementID: ");
		result.append(requirementID);
		result.append(", executionStatus: ");
		result.append(executionStatus);
		result.append(", skip: ");
		result.append(skip);
		result.append(')');
		return result.toString();
	}

} //TestCaseImpl
