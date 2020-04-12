/**
 */
package DiagonosticModel.impl;

import DiagonosticModel.DiagnosticRequest;
import DiagonosticModel.DiagnosticResponse;
import DiagonosticModel.DiagnosticService;
import DiagonosticModel.DiagonosticModelPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Diagnostic Service</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link DiagonosticModel.impl.DiagnosticServiceImpl#getEcu <em>Ecu</em>}</li>
 *   <li>{@link DiagonosticModel.impl.DiagnosticServiceImpl#getService <em>Service</em>}</li>
 *   <li>{@link DiagonosticModel.impl.DiagnosticServiceImpl#getResult <em>Result</em>}</li>
 *   <li>{@link DiagonosticModel.impl.DiagnosticServiceImpl#getDiagrequest <em>Diagrequest</em>}</li>
 *   <li>{@link DiagonosticModel.impl.DiagnosticServiceImpl#getDiagresponse <em>Diagresponse</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DiagnosticServiceImpl extends ActionImpl implements DiagnosticService {
	/**
	 * The default value of the '{@link #getEcu() <em>Ecu</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEcu()
	 * @generated
	 * @ordered
	 */
	protected static final String ECU_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getEcu() <em>Ecu</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEcu()
	 * @generated
	 * @ordered
	 */
	protected String ecu = ECU_EDEFAULT;

	/**
	 * The default value of the '{@link #getService() <em>Service</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getService()
	 * @generated
	 * @ordered
	 */
	protected static final String SERVICE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getService() <em>Service</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getService()
	 * @generated
	 * @ordered
	 */
	protected String service = SERVICE_EDEFAULT;

	/**
	 * The default value of the '{@link #getResult() <em>Result</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResult()
	 * @generated
	 * @ordered
	 */
	protected static final String RESULT_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getResult() <em>Result</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResult()
	 * @generated
	 * @ordered
	 */
	protected String result = RESULT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDiagrequest() <em>Diagrequest</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDiagrequest()
	 * @generated
	 * @ordered
	 */
	protected DiagnosticRequest diagrequest;

	/**
	 * The cached value of the '{@link #getDiagresponse() <em>Diagresponse</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDiagresponse()
	 * @generated
	 * @ordered
	 */
	protected DiagnosticResponse diagresponse;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DiagnosticServiceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DiagonosticModelPackage.Literals.DIAGNOSTIC_SERVICE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getEcu() {
		return ecu;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setEcu(String newEcu) {
		String oldEcu = ecu;
		ecu = newEcu;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagonosticModelPackage.DIAGNOSTIC_SERVICE__ECU, oldEcu, ecu));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getService() {
		return service;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setService(String newService) {
		String oldService = service;
		service = newService;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagonosticModelPackage.DIAGNOSTIC_SERVICE__SERVICE, oldService, service));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getResult() {
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setResult(String newResult) {
		String oldResult = result;
		result = newResult;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagonosticModelPackage.DIAGNOSTIC_SERVICE__RESULT, oldResult, result));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DiagnosticRequest getDiagrequest() {
		return diagrequest;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDiagrequest(DiagnosticRequest newDiagrequest, NotificationChain msgs) {
		DiagnosticRequest oldDiagrequest = diagrequest;
		diagrequest = newDiagrequest;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DiagonosticModelPackage.DIAGNOSTIC_SERVICE__DIAGREQUEST, oldDiagrequest, newDiagrequest);
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
	public void setDiagrequest(DiagnosticRequest newDiagrequest) {
		if (newDiagrequest != diagrequest) {
			NotificationChain msgs = null;
			if (diagrequest != null)
				msgs = ((InternalEObject)diagrequest).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DiagonosticModelPackage.DIAGNOSTIC_SERVICE__DIAGREQUEST, null, msgs);
			if (newDiagrequest != null)
				msgs = ((InternalEObject)newDiagrequest).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DiagonosticModelPackage.DIAGNOSTIC_SERVICE__DIAGREQUEST, null, msgs);
			msgs = basicSetDiagrequest(newDiagrequest, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagonosticModelPackage.DIAGNOSTIC_SERVICE__DIAGREQUEST, newDiagrequest, newDiagrequest));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DiagnosticResponse getDiagresponse() {
		return diagresponse;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDiagresponse(DiagnosticResponse newDiagresponse, NotificationChain msgs) {
		DiagnosticResponse oldDiagresponse = diagresponse;
		diagresponse = newDiagresponse;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DiagonosticModelPackage.DIAGNOSTIC_SERVICE__DIAGRESPONSE, oldDiagresponse, newDiagresponse);
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
	public void setDiagresponse(DiagnosticResponse newDiagresponse) {
		if (newDiagresponse != diagresponse) {
			NotificationChain msgs = null;
			if (diagresponse != null)
				msgs = ((InternalEObject)diagresponse).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DiagonosticModelPackage.DIAGNOSTIC_SERVICE__DIAGRESPONSE, null, msgs);
			if (newDiagresponse != null)
				msgs = ((InternalEObject)newDiagresponse).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DiagonosticModelPackage.DIAGNOSTIC_SERVICE__DIAGRESPONSE, null, msgs);
			msgs = basicSetDiagresponse(newDiagresponse, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagonosticModelPackage.DIAGNOSTIC_SERVICE__DIAGRESPONSE, newDiagresponse, newDiagresponse));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DiagonosticModelPackage.DIAGNOSTIC_SERVICE__DIAGREQUEST:
				return basicSetDiagrequest(null, msgs);
			case DiagonosticModelPackage.DIAGNOSTIC_SERVICE__DIAGRESPONSE:
				return basicSetDiagresponse(null, msgs);
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
			case DiagonosticModelPackage.DIAGNOSTIC_SERVICE__ECU:
				return getEcu();
			case DiagonosticModelPackage.DIAGNOSTIC_SERVICE__SERVICE:
				return getService();
			case DiagonosticModelPackage.DIAGNOSTIC_SERVICE__RESULT:
				return getResult();
			case DiagonosticModelPackage.DIAGNOSTIC_SERVICE__DIAGREQUEST:
				return getDiagrequest();
			case DiagonosticModelPackage.DIAGNOSTIC_SERVICE__DIAGRESPONSE:
				return getDiagresponse();
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
			case DiagonosticModelPackage.DIAGNOSTIC_SERVICE__ECU:
				setEcu((String)newValue);
				return;
			case DiagonosticModelPackage.DIAGNOSTIC_SERVICE__SERVICE:
				setService((String)newValue);
				return;
			case DiagonosticModelPackage.DIAGNOSTIC_SERVICE__RESULT:
				setResult((String)newValue);
				return;
			case DiagonosticModelPackage.DIAGNOSTIC_SERVICE__DIAGREQUEST:
				setDiagrequest((DiagnosticRequest)newValue);
				return;
			case DiagonosticModelPackage.DIAGNOSTIC_SERVICE__DIAGRESPONSE:
				setDiagresponse((DiagnosticResponse)newValue);
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
			case DiagonosticModelPackage.DIAGNOSTIC_SERVICE__ECU:
				setEcu(ECU_EDEFAULT);
				return;
			case DiagonosticModelPackage.DIAGNOSTIC_SERVICE__SERVICE:
				setService(SERVICE_EDEFAULT);
				return;
			case DiagonosticModelPackage.DIAGNOSTIC_SERVICE__RESULT:
				setResult(RESULT_EDEFAULT);
				return;
			case DiagonosticModelPackage.DIAGNOSTIC_SERVICE__DIAGREQUEST:
				setDiagrequest((DiagnosticRequest)null);
				return;
			case DiagonosticModelPackage.DIAGNOSTIC_SERVICE__DIAGRESPONSE:
				setDiagresponse((DiagnosticResponse)null);
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
			case DiagonosticModelPackage.DIAGNOSTIC_SERVICE__ECU:
				return ECU_EDEFAULT == null ? ecu != null : !ECU_EDEFAULT.equals(ecu);
			case DiagonosticModelPackage.DIAGNOSTIC_SERVICE__SERVICE:
				return SERVICE_EDEFAULT == null ? service != null : !SERVICE_EDEFAULT.equals(service);
			case DiagonosticModelPackage.DIAGNOSTIC_SERVICE__RESULT:
				return RESULT_EDEFAULT == null ? result != null : !RESULT_EDEFAULT.equals(result);
			case DiagonosticModelPackage.DIAGNOSTIC_SERVICE__DIAGREQUEST:
				return diagrequest != null;
			case DiagonosticModelPackage.DIAGNOSTIC_SERVICE__DIAGRESPONSE:
				return diagresponse != null;
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
		result.append(" (ecu: ");
		result.append(ecu);
		result.append(", service: ");
		result.append(service);
		result.append(", result: ");
		result.append(result);
		result.append(')');
		return result.toString();
	}

} //DiagnosticServiceImpl
