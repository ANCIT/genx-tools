/**
 */
package DiagonosticModel.impl;

import DiagonosticModel.DiagnosticParam;
import DiagonosticModel.DiagnosticResponse;
import DiagonosticModel.DiagonosticModelPackage;

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
 * An implementation of the model object '<em><b>Diagnostic Response</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link DiagonosticModel.impl.DiagnosticResponseImpl#getPrimitive <em>Primitive</em>}</li>
 *   <li>{@link DiagonosticModel.impl.DiagnosticResponseImpl#getDiagparam <em>Diagparam</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DiagnosticResponseImpl extends MinimalEObjectImpl.Container implements DiagnosticResponse {
	/**
	 * The default value of the '{@link #getPrimitive() <em>Primitive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimitive()
	 * @generated
	 * @ordered
	 */
	protected static final String PRIMITIVE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getPrimitive() <em>Primitive</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrimitive()
	 * @generated
	 * @ordered
	 */
	protected String primitive = PRIMITIVE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getDiagparam() <em>Diagparam</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDiagparam()
	 * @generated
	 * @ordered
	 */
	protected EList<DiagnosticParam> diagparam;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DiagnosticResponseImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DiagonosticModelPackage.Literals.DIAGNOSTIC_RESPONSE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getPrimitive() {
		return primitive;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPrimitive(String newPrimitive) {
		String oldPrimitive = primitive;
		primitive = newPrimitive;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagonosticModelPackage.DIAGNOSTIC_RESPONSE__PRIMITIVE, oldPrimitive, primitive));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<DiagnosticParam> getDiagparam() {
		if (diagparam == null) {
			diagparam = new EObjectContainmentEList<DiagnosticParam>(DiagnosticParam.class, this, DiagonosticModelPackage.DIAGNOSTIC_RESPONSE__DIAGPARAM);
		}
		return diagparam;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case DiagonosticModelPackage.DIAGNOSTIC_RESPONSE__DIAGPARAM:
				return ((InternalEList<?>)getDiagparam()).basicRemove(otherEnd, msgs);
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
			case DiagonosticModelPackage.DIAGNOSTIC_RESPONSE__PRIMITIVE:
				return getPrimitive();
			case DiagonosticModelPackage.DIAGNOSTIC_RESPONSE__DIAGPARAM:
				return getDiagparam();
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
			case DiagonosticModelPackage.DIAGNOSTIC_RESPONSE__PRIMITIVE:
				setPrimitive((String)newValue);
				return;
			case DiagonosticModelPackage.DIAGNOSTIC_RESPONSE__DIAGPARAM:
				getDiagparam().clear();
				getDiagparam().addAll((Collection<? extends DiagnosticParam>)newValue);
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
			case DiagonosticModelPackage.DIAGNOSTIC_RESPONSE__PRIMITIVE:
				setPrimitive(PRIMITIVE_EDEFAULT);
				return;
			case DiagonosticModelPackage.DIAGNOSTIC_RESPONSE__DIAGPARAM:
				getDiagparam().clear();
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
			case DiagonosticModelPackage.DIAGNOSTIC_RESPONSE__PRIMITIVE:
				return PRIMITIVE_EDEFAULT == null ? primitive != null : !PRIMITIVE_EDEFAULT.equals(primitive);
			case DiagonosticModelPackage.DIAGNOSTIC_RESPONSE__DIAGPARAM:
				return diagparam != null && !diagparam.isEmpty();
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
		result.append(" (primitive: ");
		result.append(primitive);
		result.append(')');
		return result.toString();
	}

} //DiagnosticResponseImpl
