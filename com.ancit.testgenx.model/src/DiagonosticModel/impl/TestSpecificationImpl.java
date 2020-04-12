/**
 */
package DiagonosticModel.impl;

import DiagonosticModel.CAPLTestCase;
import DiagonosticModel.DiagonosticModelPackage;
import DiagonosticModel.ImportArtifact;
import DiagonosticModel.SignalType;
import DiagonosticModel.TestGroup;
import DiagonosticModel.TestSpecification;

import DiagonosticModel.Variant;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
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
 * An implementation of the model object '<em><b>Test Specification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link DiagonosticModel.impl.TestSpecificationImpl#getName <em>Name</em>}</li>
 *   <li>{@link DiagonosticModel.impl.TestSpecificationImpl#getTestGroups <em>Test Groups</em>}</li>
 *   <li>{@link DiagonosticModel.impl.TestSpecificationImpl#getVersion <em>Version</em>}</li>
 *   <li>{@link DiagonosticModel.impl.TestSpecificationImpl#getDescription <em>Description</em>}</li>
 *   <li>{@link DiagonosticModel.impl.TestSpecificationImpl#getFunctionName <em>Function Name</em>}</li>
 *   <li>{@link DiagonosticModel.impl.TestSpecificationImpl#getFunctionVersion <em>Function Version</em>}</li>
 *   <li>{@link DiagonosticModel.impl.TestSpecificationImpl#getAuthor <em>Author</em>}</li>
 *   <li>{@link DiagonosticModel.impl.TestSpecificationImpl#getCapltestcases <em>Capltestcases</em>}</li>
 *   <li>{@link DiagonosticModel.impl.TestSpecificationImpl#getVariants <em>Variants</em>}</li>
 *   <li>{@link DiagonosticModel.impl.TestSpecificationImpl#getImportArtifacts <em>Import Artifacts</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TestSpecificationImpl extends MinimalEObjectImpl.Container implements TestSpecification {
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
	 * The cached value of the '{@link #getTestGroups() <em>Test Groups</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTestGroups()
	 * @generated
	 * @ordered
	 */
	protected EList<TestGroup> testGroups;

	/**
	 * The default value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String VERSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getVersion() <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVersion()
	 * @generated
	 * @ordered
	 */
	protected String version = VERSION_EDEFAULT;

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
	 * The default value of the '{@link #getFunctionName() <em>Function Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFunctionName()
	 * @generated
	 * @ordered
	 */
	protected static final String FUNCTION_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFunctionName() <em>Function Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFunctionName()
	 * @generated
	 * @ordered
	 */
	protected String functionName = FUNCTION_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getFunctionVersion() <em>Function Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFunctionVersion()
	 * @generated
	 * @ordered
	 */
	protected static final String FUNCTION_VERSION_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getFunctionVersion() <em>Function Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFunctionVersion()
	 * @generated
	 * @ordered
	 */
	protected String functionVersion = FUNCTION_VERSION_EDEFAULT;

	/**
	 * The default value of the '{@link #getAuthor() <em>Author</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAuthor()
	 * @generated
	 * @ordered
	 */
	protected static final String AUTHOR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getAuthor() <em>Author</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAuthor()
	 * @generated
	 * @ordered
	 */
	protected String author = AUTHOR_EDEFAULT;

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
	 * The cached value of the '{@link #getVariants() <em>Variants</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVariants()
	 * @generated
	 * @ordered
	 */
	protected EList<Variant> variants;

	/**
	 * The cached value of the '{@link #getImportArtifacts() <em>Import Artifacts</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImportArtifacts()
	 * @generated
	 * @ordered
	 */
	protected EList<ImportArtifact> importArtifacts;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TestSpecificationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DiagonosticModelPackage.Literals.TEST_SPECIFICATION;
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
			eNotify(new ENotificationImpl(this, Notification.SET, DiagonosticModelPackage.TEST_SPECIFICATION__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<TestGroup> getTestGroups() {
		if (testGroups == null) {
			testGroups = new EObjectContainmentEList<TestGroup>(TestGroup.class, this, DiagonosticModelPackage.TEST_SPECIFICATION__TEST_GROUPS);
		}
		return testGroups;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getVersion() {
		return version;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setVersion(String newVersion) {
		String oldVersion = version;
		version = newVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagonosticModelPackage.TEST_SPECIFICATION__VERSION, oldVersion, version));
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
			eNotify(new ENotificationImpl(this, Notification.SET, DiagonosticModelPackage.TEST_SPECIFICATION__DESCRIPTION, oldDescription, description));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getFunctionName() {
		return functionName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFunctionName(String newFunctionName) {
		String oldFunctionName = functionName;
		functionName = newFunctionName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagonosticModelPackage.TEST_SPECIFICATION__FUNCTION_NAME, oldFunctionName, functionName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getFunctionVersion() {
		return functionVersion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setFunctionVersion(String newFunctionVersion) {
		String oldFunctionVersion = functionVersion;
		functionVersion = newFunctionVersion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagonosticModelPackage.TEST_SPECIFICATION__FUNCTION_VERSION, oldFunctionVersion, functionVersion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getAuthor() {
		return author;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setAuthor(String newAuthor) {
		String oldAuthor = author;
		author = newAuthor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagonosticModelPackage.TEST_SPECIFICATION__AUTHOR, oldAuthor, author));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<CAPLTestCase> getCapltestcases() {
		if (capltestcases == null) {
			capltestcases = new EObjectContainmentEList<CAPLTestCase>(CAPLTestCase.class, this, DiagonosticModelPackage.TEST_SPECIFICATION__CAPLTESTCASES);
		}
		return capltestcases;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Variant> getVariants() {
		if (variants == null) {
			variants = new EObjectContainmentEList<Variant>(Variant.class, this, DiagonosticModelPackage.TEST_SPECIFICATION__VARIANTS);
		}
		return variants;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<ImportArtifact> getImportArtifacts() {
		if (importArtifacts == null) {
			importArtifacts = new EObjectContainmentEList<ImportArtifact>(ImportArtifact.class, this, DiagonosticModelPackage.TEST_SPECIFICATION__IMPORT_ARTIFACTS);
		}
		return importArtifacts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ArrayList<SignalType> getSignals() {
		ArrayList<SignalType> signals = new ArrayList<SignalType>();
				
				for (ImportArtifact importArtifact : getImportArtifacts()) {
					signals.addAll(importArtifact.getSignalType());
				}
				return signals;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DiagonosticModelPackage.TEST_SPECIFICATION__TEST_GROUPS:
				return ((InternalEList<?>)getTestGroups()).basicRemove(otherEnd, msgs);
			case DiagonosticModelPackage.TEST_SPECIFICATION__CAPLTESTCASES:
				return ((InternalEList<?>)getCapltestcases()).basicRemove(otherEnd, msgs);
			case DiagonosticModelPackage.TEST_SPECIFICATION__VARIANTS:
				return ((InternalEList<?>)getVariants()).basicRemove(otherEnd, msgs);
			case DiagonosticModelPackage.TEST_SPECIFICATION__IMPORT_ARTIFACTS:
				return ((InternalEList<?>)getImportArtifacts()).basicRemove(otherEnd, msgs);
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
			case DiagonosticModelPackage.TEST_SPECIFICATION__NAME:
				return getName();
			case DiagonosticModelPackage.TEST_SPECIFICATION__TEST_GROUPS:
				return getTestGroups();
			case DiagonosticModelPackage.TEST_SPECIFICATION__VERSION:
				return getVersion();
			case DiagonosticModelPackage.TEST_SPECIFICATION__DESCRIPTION:
				return getDescription();
			case DiagonosticModelPackage.TEST_SPECIFICATION__FUNCTION_NAME:
				return getFunctionName();
			case DiagonosticModelPackage.TEST_SPECIFICATION__FUNCTION_VERSION:
				return getFunctionVersion();
			case DiagonosticModelPackage.TEST_SPECIFICATION__AUTHOR:
				return getAuthor();
			case DiagonosticModelPackage.TEST_SPECIFICATION__CAPLTESTCASES:
				return getCapltestcases();
			case DiagonosticModelPackage.TEST_SPECIFICATION__VARIANTS:
				return getVariants();
			case DiagonosticModelPackage.TEST_SPECIFICATION__IMPORT_ARTIFACTS:
				return getImportArtifacts();
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
			case DiagonosticModelPackage.TEST_SPECIFICATION__NAME:
				setName((String)newValue);
				return;
			case DiagonosticModelPackage.TEST_SPECIFICATION__TEST_GROUPS:
				getTestGroups().clear();
				getTestGroups().addAll((Collection<? extends TestGroup>)newValue);
				return;
			case DiagonosticModelPackage.TEST_SPECIFICATION__VERSION:
				setVersion((String)newValue);
				return;
			case DiagonosticModelPackage.TEST_SPECIFICATION__DESCRIPTION:
				setDescription((String)newValue);
				return;
			case DiagonosticModelPackage.TEST_SPECIFICATION__FUNCTION_NAME:
				setFunctionName((String)newValue);
				return;
			case DiagonosticModelPackage.TEST_SPECIFICATION__FUNCTION_VERSION:
				setFunctionVersion((String)newValue);
				return;
			case DiagonosticModelPackage.TEST_SPECIFICATION__AUTHOR:
				setAuthor((String)newValue);
				return;
			case DiagonosticModelPackage.TEST_SPECIFICATION__CAPLTESTCASES:
				getCapltestcases().clear();
				getCapltestcases().addAll((Collection<? extends CAPLTestCase>)newValue);
				return;
			case DiagonosticModelPackage.TEST_SPECIFICATION__VARIANTS:
				getVariants().clear();
				getVariants().addAll((Collection<? extends Variant>)newValue);
				return;
			case DiagonosticModelPackage.TEST_SPECIFICATION__IMPORT_ARTIFACTS:
				getImportArtifacts().clear();
				getImportArtifacts().addAll((Collection<? extends ImportArtifact>)newValue);
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
			case DiagonosticModelPackage.TEST_SPECIFICATION__NAME:
				setName(NAME_EDEFAULT);
				return;
			case DiagonosticModelPackage.TEST_SPECIFICATION__TEST_GROUPS:
				getTestGroups().clear();
				return;
			case DiagonosticModelPackage.TEST_SPECIFICATION__VERSION:
				setVersion(VERSION_EDEFAULT);
				return;
			case DiagonosticModelPackage.TEST_SPECIFICATION__DESCRIPTION:
				setDescription(DESCRIPTION_EDEFAULT);
				return;
			case DiagonosticModelPackage.TEST_SPECIFICATION__FUNCTION_NAME:
				setFunctionName(FUNCTION_NAME_EDEFAULT);
				return;
			case DiagonosticModelPackage.TEST_SPECIFICATION__FUNCTION_VERSION:
				setFunctionVersion(FUNCTION_VERSION_EDEFAULT);
				return;
			case DiagonosticModelPackage.TEST_SPECIFICATION__AUTHOR:
				setAuthor(AUTHOR_EDEFAULT);
				return;
			case DiagonosticModelPackage.TEST_SPECIFICATION__CAPLTESTCASES:
				getCapltestcases().clear();
				return;
			case DiagonosticModelPackage.TEST_SPECIFICATION__VARIANTS:
				getVariants().clear();
				return;
			case DiagonosticModelPackage.TEST_SPECIFICATION__IMPORT_ARTIFACTS:
				getImportArtifacts().clear();
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
			case DiagonosticModelPackage.TEST_SPECIFICATION__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case DiagonosticModelPackage.TEST_SPECIFICATION__TEST_GROUPS:
				return testGroups != null && !testGroups.isEmpty();
			case DiagonosticModelPackage.TEST_SPECIFICATION__VERSION:
				return VERSION_EDEFAULT == null ? version != null : !VERSION_EDEFAULT.equals(version);
			case DiagonosticModelPackage.TEST_SPECIFICATION__DESCRIPTION:
				return DESCRIPTION_EDEFAULT == null ? description != null : !DESCRIPTION_EDEFAULT.equals(description);
			case DiagonosticModelPackage.TEST_SPECIFICATION__FUNCTION_NAME:
				return FUNCTION_NAME_EDEFAULT == null ? functionName != null : !FUNCTION_NAME_EDEFAULT.equals(functionName);
			case DiagonosticModelPackage.TEST_SPECIFICATION__FUNCTION_VERSION:
				return FUNCTION_VERSION_EDEFAULT == null ? functionVersion != null : !FUNCTION_VERSION_EDEFAULT.equals(functionVersion);
			case DiagonosticModelPackage.TEST_SPECIFICATION__AUTHOR:
				return AUTHOR_EDEFAULT == null ? author != null : !AUTHOR_EDEFAULT.equals(author);
			case DiagonosticModelPackage.TEST_SPECIFICATION__CAPLTESTCASES:
				return capltestcases != null && !capltestcases.isEmpty();
			case DiagonosticModelPackage.TEST_SPECIFICATION__VARIANTS:
				return variants != null && !variants.isEmpty();
			case DiagonosticModelPackage.TEST_SPECIFICATION__IMPORT_ARTIFACTS:
				return importArtifacts != null && !importArtifacts.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eInvoke(int operationID, EList<?> arguments) throws InvocationTargetException {
		switch (operationID) {
			case DiagonosticModelPackage.TEST_SPECIFICATION___GET_SIGNALS:
				return getSignals();
		}
		return super.eInvoke(operationID, arguments);
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
		result.append(", version: ");
		result.append(version);
		result.append(", description: ");
		result.append(description);
		result.append(", functionName: ");
		result.append(functionName);
		result.append(", functionVersion: ");
		result.append(functionVersion);
		result.append(", author: ");
		result.append(author);
		result.append(')');
		return result.toString();
	}

} //TestSpecificationImpl
