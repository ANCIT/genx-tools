/**
 */
package DiagonosticModel.impl;

import DiagonosticModel.BlockAction;
import DiagonosticModel.DiagonosticModelPackage;
import DiagonosticModel.TestStep;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Block Action</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link DiagonosticModel.impl.BlockActionImpl#getTestSteps <em>Test Steps</em>}</li>
 * </ul>
 *
 * @generated
 */
public class BlockActionImpl extends TestStepImpl implements BlockAction {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BlockActionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DiagonosticModelPackage.Literals.BLOCK_ACTION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<TestStep> getTestSteps() {
		if (testSteps == null) {
			testSteps = new EObjectContainmentEList<TestStep>(TestStep.class, this, DiagonosticModelPackage.BLOCK_ACTION__TEST_STEPS);
		}
		return testSteps;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DiagonosticModelPackage.BLOCK_ACTION__TEST_STEPS:
				return ((InternalEList<?>)getTestSteps()).basicRemove(otherEnd, msgs);
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
			case DiagonosticModelPackage.BLOCK_ACTION__TEST_STEPS:
				return getTestSteps();
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
			case DiagonosticModelPackage.BLOCK_ACTION__TEST_STEPS:
				getTestSteps().clear();
				getTestSteps().addAll((Collection<? extends TestStep>)newValue);
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
			case DiagonosticModelPackage.BLOCK_ACTION__TEST_STEPS:
				getTestSteps().clear();
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
			case DiagonosticModelPackage.BLOCK_ACTION__TEST_STEPS:
				return testSteps != null && !testSteps.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //BlockActionImpl
