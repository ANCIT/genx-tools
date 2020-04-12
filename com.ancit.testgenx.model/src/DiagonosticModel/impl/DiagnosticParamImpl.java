/**
 */
package DiagonosticModel.impl;

import DiagonosticModel.DiagnosticParam;
import DiagonosticModel.DiagnosticParamValueType;
import DiagonosticModel.DiagonosticModelPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Diagnostic Param</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link DiagonosticModel.impl.DiagnosticParamImpl#getQualifier <em>Qualifier</em>}</li>
 *   <li>{@link DiagonosticModel.impl.DiagnosticParamImpl#getCopyToVar <em>Copy To Var</em>}</li>
 *   <li>{@link DiagonosticModel.impl.DiagnosticParamImpl#getValueTypes <em>Value Types</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DiagnosticParamImpl extends MinimalEObjectImpl.Container implements DiagnosticParam {
	/**
	 * The default value of the '{@link #getQualifier() <em>Qualifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQualifier()
	 * @generated
	 * @ordered
	 */
	protected static final String QUALIFIER_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getQualifier() <em>Qualifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getQualifier()
	 * @generated
	 * @ordered
	 */
	protected String qualifier = QUALIFIER_EDEFAULT;

	/**
	 * The default value of the '{@link #getCopyToVar() <em>Copy To Var</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCopyToVar()
	 * @generated
	 * @ordered
	 */
	protected static final String COPY_TO_VAR_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getCopyToVar() <em>Copy To Var</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCopyToVar()
	 * @generated
	 * @ordered
	 */
	protected String copyToVar = COPY_TO_VAR_EDEFAULT;

	/**
	 * The cached value of the '{@link #getValueTypes() <em>Value Types</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValueTypes()
	 * @generated
	 * @ordered
	 */
	protected DiagnosticParamValueType valueTypes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DiagnosticParamImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DiagonosticModelPackage.Literals.DIAGNOSTIC_PARAM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getQualifier() {
		return qualifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setQualifier(String newQualifier) {
		String oldQualifier = qualifier;
		qualifier = newQualifier;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagonosticModelPackage.DIAGNOSTIC_PARAM__QUALIFIER, oldQualifier, qualifier));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getCopyToVar() {
		return copyToVar;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCopyToVar(String newCopyToVar) {
		String oldCopyToVar = copyToVar;
		copyToVar = newCopyToVar;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagonosticModelPackage.DIAGNOSTIC_PARAM__COPY_TO_VAR, oldCopyToVar, copyToVar));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DiagnosticParamValueType getValueTypes() {
		return valueTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetValueTypes(DiagnosticParamValueType newValueTypes, NotificationChain msgs) {
		DiagnosticParamValueType oldValueTypes = valueTypes;
		valueTypes = newValueTypes;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DiagonosticModelPackage.DIAGNOSTIC_PARAM__VALUE_TYPES, oldValueTypes, newValueTypes);
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
	public void setValueTypes(DiagnosticParamValueType newValueTypes) {
		if (newValueTypes != valueTypes) {
			NotificationChain msgs = null;
			if (valueTypes != null)
				msgs = ((InternalEObject)valueTypes).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DiagonosticModelPackage.DIAGNOSTIC_PARAM__VALUE_TYPES, null, msgs);
			if (newValueTypes != null)
				msgs = ((InternalEObject)newValueTypes).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DiagonosticModelPackage.DIAGNOSTIC_PARAM__VALUE_TYPES, null, msgs);
			msgs = basicSetValueTypes(newValueTypes, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagonosticModelPackage.DIAGNOSTIC_PARAM__VALUE_TYPES, newValueTypes, newValueTypes));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DiagonosticModelPackage.DIAGNOSTIC_PARAM__VALUE_TYPES:
				return basicSetValueTypes(null, msgs);
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
			case DiagonosticModelPackage.DIAGNOSTIC_PARAM__QUALIFIER:
				return getQualifier();
			case DiagonosticModelPackage.DIAGNOSTIC_PARAM__COPY_TO_VAR:
				return getCopyToVar();
			case DiagonosticModelPackage.DIAGNOSTIC_PARAM__VALUE_TYPES:
				return getValueTypes();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case DiagonosticModelPackage.DIAGNOSTIC_PARAM__QUALIFIER:
				setQualifier((String)newValue);
				return;
			case DiagonosticModelPackage.DIAGNOSTIC_PARAM__COPY_TO_VAR:
				setCopyToVar((String)newValue);
				return;
			case DiagonosticModelPackage.DIAGNOSTIC_PARAM__VALUE_TYPES:
				setValueTypes((DiagnosticParamValueType)newValue);
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
			case DiagonosticModelPackage.DIAGNOSTIC_PARAM__QUALIFIER:
				setQualifier(QUALIFIER_EDEFAULT);
				return;
			case DiagonosticModelPackage.DIAGNOSTIC_PARAM__COPY_TO_VAR:
				setCopyToVar(COPY_TO_VAR_EDEFAULT);
				return;
			case DiagonosticModelPackage.DIAGNOSTIC_PARAM__VALUE_TYPES:
				setValueTypes((DiagnosticParamValueType)null);
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
			case DiagonosticModelPackage.DIAGNOSTIC_PARAM__QUALIFIER:
				return QUALIFIER_EDEFAULT == null ? qualifier != null : !QUALIFIER_EDEFAULT.equals(qualifier);
			case DiagonosticModelPackage.DIAGNOSTIC_PARAM__COPY_TO_VAR:
				return COPY_TO_VAR_EDEFAULT == null ? copyToVar != null : !COPY_TO_VAR_EDEFAULT.equals(copyToVar);
			case DiagonosticModelPackage.DIAGNOSTIC_PARAM__VALUE_TYPES:
				return valueTypes != null;
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
		result.append(" (qualifier: ");
		result.append(qualifier);
		result.append(", copyToVar: ");
		result.append(copyToVar);
		result.append(')');
		return result.toString();
	}

} //DiagnosticParamImpl
