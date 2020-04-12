/**
 */
package DiagonosticModel.impl;

import DiagonosticModel.CAPLTestCase;
import DiagonosticModel.DiagonosticModelPackage;
import DiagonosticModel.ExternalReference;
import DiagonosticModel.TestCase;
import DiagonosticModel.TestGroup;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Test Group</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link DiagonosticModel.impl.TestGroupImpl#getName <em>Name</em>}</li>
 *   <li>{@link DiagonosticModel.impl.TestGroupImpl#getTestCases <em>Test Cases</em>}</li>
 *   <li>{@link DiagonosticModel.impl.TestGroupImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link DiagonosticModel.impl.TestGroupImpl#getExternalreference <em>Externalreference</em>}</li>
 *   <li>{@link DiagonosticModel.impl.TestGroupImpl#getTestGroups <em>Test Groups</em>}</li>
 *   <li>{@link DiagonosticModel.impl.TestGroupImpl#getCapltestcases <em>Capltestcases</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TestGroupImpl extends MinimalEObjectImpl.Container implements TestGroup {
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
	 * The cached value of the '{@link #getTestCases() <em>Test Cases</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTestCases()
	 * @generated
	 * @ordered
	 */
	protected EList<TestCase> testCases;

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
	 * The cached value of the '{@link #getExternalreference() <em>Externalreference</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExternalreference()
	 * @generated
	 * @ordered
	 */
	protected ExternalReference externalreference;

	/**
	 * The cached value of the '{@link #getTestGroups() <em>Test Groups</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTestGroups()
	 * @generated
	 * @ordered
	 */
	protected EList<TestGroup> testGroups;

	/**
	 * The cached value of the '{@link #getCapltestcases() <em>Capltestcases</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCapltestcases()
	 * @generated
	 * @ordered
	 */
	protected EList<CAPLTestCase> capltestcases;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TestGroupImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DiagonosticModelPackage.Literals.TEST_GROUP;
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
			eNotify(new ENotificationImpl(this, Notification.SET, DiagonosticModelPackage.TEST_GROUP__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<TestCase> getTestCases() {
		if (testCases == null) {
			testCases = new EObjectContainmentEList<TestCase>(TestCase.class, this, DiagonosticModelPackage.TEST_GROUP__TEST_CASES);
		}
		return testCases;
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
			eNotify(new ENotificationImpl(this, Notification.SET, DiagonosticModelPackage.TEST_GROUP__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ExternalReference getExternalreference() {
		return externalreference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExternalreference(ExternalReference newExternalreference, NotificationChain msgs) {
		ExternalReference oldExternalreference = externalreference;
		externalreference = newExternalreference;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DiagonosticModelPackage.TEST_GROUP__EXTERNALREFERENCE, oldExternalreference, newExternalreference);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setExternalreference(ExternalReference newExternalreference) {
		if (newExternalreference != externalreference) {
			NotificationChain msgs = null;
			if (externalreference != null)
				msgs = ((InternalEObject)externalreference).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DiagonosticModelPackage.TEST_GROUP__EXTERNALREFERENCE, null, msgs);
			if (newExternalreference != null)
				msgs = ((InternalEObject)newExternalreference).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DiagonosticModelPackage.TEST_GROUP__EXTERNALREFERENCE, null, msgs);
			msgs = basicSetExternalreference(newExternalreference, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagonosticModelPackage.TEST_GROUP__EXTERNALREFERENCE, newExternalreference, newExternalreference));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<TestGroup> getTestGroups() {
		if (testGroups == null) {
			testGroups = new EObjectContainmentEList<TestGroup>(TestGroup.class, this, DiagonosticModelPackage.TEST_GROUP__TEST_GROUPS);
		}
		return testGroups;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<CAPLTestCase> getCapltestcases() {
		if (capltestcases == null) {
			capltestcases = new EObjectContainmentEList<CAPLTestCase>(CAPLTestCase.class, this, DiagonosticModelPackage.TEST_GROUP__CAPLTESTCASES);
		}
		return capltestcases;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DiagonosticModelPackage.TEST_GROUP__TEST_CASES:
				return ((InternalEList<?>)getTestCases()).basicRemove(otherEnd, msgs);
			case DiagonosticModelPackage.TEST_GROUP__EXTERNALREFERENCE:
				return basicSetExternalreference(null, msgs);
			case DiagonosticModelPackage.TEST_GROUP__TEST_GROUPS:
				return ((InternalEList<?>)getTestGroups()).basicRemove(otherEnd, msgs);
			case DiagonosticModelPackage.TEST_GROUP__CAPLTESTCASES:
				return ((InternalEList<?>)getCapltestcases()).basicRemove(otherEnd, msgs);
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
			case DiagonosticModelPackage.TEST_GROUP__NAME:
				return getName();
			case DiagonosticModelPackage.TEST_GROUP__TEST_CASES:
				return getTestCases();
			case DiagonosticModelPackage.TEST_GROUP__DESCRIPTION:
				return getDescription();
			case DiagonosticModelPackage.TEST_GROUP__EXTERNALREFERENCE:
				return getExternalreference();
			case DiagonosticModelPackage.TEST_GROUP__TEST_GROUPS:
				return getTestGroups();
			case DiagonosticModelPackage.TEST_GROUP__CAPLTESTCASES:
				return getCapltestcases();
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
			case DiagonosticModelPackage.TEST_GROUP__NAME:
				setName((String)newValue);
				return;
			case DiagonosticModelPackage.TEST_GROUP__TEST_CASES:
				getTestCases().clear();
				getTestCases().addAll((Collection<? extends TestCase>)newValue);
				return;
			case DiagonosticModelPackage.TEST_GROUP__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case DiagonosticModelPackage.TEST_GROUP__EXTERNALREFERENCE:
				setExternalreference((ExternalReference)newValue);
				return;
			case DiagonosticModelPackage.TEST_GROUP__TEST_GROUPS:
				getTestGroups().clear();
				getTestGroups().addAll((Collection<? extends TestGroup>)newValue);
				return;
			case DiagonosticModelPackage.TEST_GROUP__CAPLTESTCASES:
				getCapltestcases().clear();
				getCapltestcases().addAll((Collection<? extends CAPLTestCase>)newValue);
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
			case DiagonosticModelPackage.TEST_GROUP__NAME:
				setName(NAME_EDEFAULT);
				return;
			case DiagonosticModelPackage.TEST_GROUP__TEST_CASES:
				getTestCases().clear();
				return;
			case DiagonosticModelPackage.TEST_GROUP__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case DiagonosticModelPackage.TEST_GROUP__EXTERNALREFERENCE:
				setExternalreference((ExternalReference)null);
				return;
			case DiagonosticModelPackage.TEST_GROUP__TEST_GROUPS:
				getTestGroups().clear();
				return;
			case DiagonosticModelPackage.TEST_GROUP__CAPLTESTCASES:
				getCapltestcases().clear();
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
			case DiagonosticModelPackage.TEST_GROUP__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case DiagonosticModelPackage.TEST_GROUP__TEST_CASES:
				return testCases != null && !testCases.isEmpty();
			case DiagonosticModelPackage.TEST_GROUP__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case DiagonosticModelPackage.TEST_GROUP__EXTERNALREFERENCE:
				return externalreference != null;
			case DiagonosticModelPackage.TEST_GROUP__TEST_GROUPS:
				return testGroups != null && !testGroups.isEmpty();
			case DiagonosticModelPackage.TEST_GROUP__CAPLTESTCASES:
				return capltestcases != null && !capltestcases.isEmpty();
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
		result.append(", description: ");
		result.append(description);
		result.append(')');
		return result.toString();
	}

} //TestGroupImpl
