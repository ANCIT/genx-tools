/**
 */
package DiagonosticModel.impl;

import DiagonosticModel.CreationModeEnum;
import DiagonosticModel.DiagonosticModelPackage;
import DiagonosticModel.SignalType;
import DiagonosticModel.SignalTypeEnum;

import java.util.Collection;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Signal Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link DiagonosticModel.impl.SignalTypeImpl#getName <em>Name</em>}</li>
 *   <li>{@link DiagonosticModel.impl.SignalTypeImpl#getType <em>Type</em>}</li>
 *   <li>{@link DiagonosticModel.impl.SignalTypeImpl#getMessageName <em>Message Name</em>}</li>
 *   <li>{@link DiagonosticModel.impl.SignalTypeImpl#getNode <em>Node</em>}</li>
 *   <li>{@link DiagonosticModel.impl.SignalTypeImpl#getNamespace <em>Namespace</em>}</li>
 *   <li>{@link DiagonosticModel.impl.SignalTypeImpl#getCreationMode <em>Creation Mode</em>}</li>
 *   <li>{@link DiagonosticModel.impl.SignalTypeImpl#getLookupValues <em>Lookup Values</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SignalTypeImpl extends MinimalEObjectImpl.Container implements SignalType {
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
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected static final SignalTypeEnum TYPE_EDEFAULT = SignalTypeEnum.SIGNAL;

	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected SignalTypeEnum type = TYPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getMessageName() <em>Message Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessageName()
	 * @generated
	 * @ordered
	 */
	protected static final String MESSAGE_NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getMessageName() <em>Message Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMessageName()
	 * @generated
	 * @ordered
	 */
	protected String messageName = MESSAGE_NAME_EDEFAULT;

	/**
	 * The default value of the '{@link #getNode() <em>Node</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNode()
	 * @generated
	 * @ordered
	 */
	protected static final String NODE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNode() <em>Node</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNode()
	 * @generated
	 * @ordered
	 */
	protected String node = NODE_EDEFAULT;

	/**
	 * The default value of the '{@link #getNamespace() <em>Namespace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNamespace()
	 * @generated
	 * @ordered
	 */
	protected static final String NAMESPACE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNamespace() <em>Namespace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNamespace()
	 * @generated
	 * @ordered
	 */
	protected String namespace = NAMESPACE_EDEFAULT;

	/**
	 * The default value of the '{@link #getCreationMode() <em>Creation Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreationMode()
	 * @generated
	 * @ordered
	 */
	protected static final CreationModeEnum CREATION_MODE_EDEFAULT = CreationModeEnum.IMPORTED;

	/**
	 * The cached value of the '{@link #getCreationMode() <em>Creation Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCreationMode()
	 * @generated
	 * @ordered
	 */
	protected CreationModeEnum creationMode = CREATION_MODE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getLookupValues() <em>Lookup Values</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLookupValues()
	 * @generated
	 * @ordered
	 */
	protected EList<String> lookupValues;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SignalTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return DiagonosticModelPackage.Literals.SIGNAL_TYPE;
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
			eNotify(new ENotificationImpl(this, Notification.SET, DiagonosticModelPackage.SIGNAL_TYPE__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SignalTypeEnum getType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setType(SignalTypeEnum newType) {
		SignalTypeEnum oldType = type;
		type = newType == null ? TYPE_EDEFAULT : newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagonosticModelPackage.SIGNAL_TYPE__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getMessageName() {
		return messageName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMessageName(String newMessageName) {
		String oldMessageName = messageName;
		messageName = newMessageName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagonosticModelPackage.SIGNAL_TYPE__MESSAGE_NAME, oldMessageName, messageName));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getNode() {
		return node;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNode(String newNode) {
		String oldNode = node;
		node = newNode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagonosticModelPackage.SIGNAL_TYPE__NODE, oldNode, node));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getNamespace() {
		return namespace;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setNamespace(String newNamespace) {
		String oldNamespace = namespace;
		namespace = newNamespace;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagonosticModelPackage.SIGNAL_TYPE__NAMESPACE, oldNamespace, namespace));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public CreationModeEnum getCreationMode() {
		return creationMode;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCreationMode(CreationModeEnum newCreationMode) {
		CreationModeEnum oldCreationMode = creationMode;
		creationMode = newCreationMode == null ? CREATION_MODE_EDEFAULT : newCreationMode;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, DiagonosticModelPackage.SIGNAL_TYPE__CREATION_MODE, oldCreationMode, creationMode));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<String> getLookupValues() {
		if (lookupValues == null) {
			lookupValues = new EDataTypeUniqueEList<String>(String.class, this, DiagonosticModelPackage.SIGNAL_TYPE__LOOKUP_VALUES);
		}
		return lookupValues;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case DiagonosticModelPackage.SIGNAL_TYPE__NAME:
				return getName();
			case DiagonosticModelPackage.SIGNAL_TYPE__TYPE:
				return getType();
			case DiagonosticModelPackage.SIGNAL_TYPE__MESSAGE_NAME:
				return getMessageName();
			case DiagonosticModelPackage.SIGNAL_TYPE__NODE:
				return getNode();
			case DiagonosticModelPackage.SIGNAL_TYPE__NAMESPACE:
				return getNamespace();
			case DiagonosticModelPackage.SIGNAL_TYPE__CREATION_MODE:
				return getCreationMode();
			case DiagonosticModelPackage.SIGNAL_TYPE__LOOKUP_VALUES:
				return getLookupValues();
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
			case DiagonosticModelPackage.SIGNAL_TYPE__NAME:
				setName((String)newValue);
				return;
			case DiagonosticModelPackage.SIGNAL_TYPE__TYPE:
				setType((SignalTypeEnum)newValue);
				return;
			case DiagonosticModelPackage.SIGNAL_TYPE__MESSAGE_NAME:
				setMessageName((String)newValue);
				return;
			case DiagonosticModelPackage.SIGNAL_TYPE__NODE:
				setNode((String)newValue);
				return;
			case DiagonosticModelPackage.SIGNAL_TYPE__NAMESPACE:
				setNamespace((String)newValue);
				return;
			case DiagonosticModelPackage.SIGNAL_TYPE__CREATION_MODE:
				setCreationMode((CreationModeEnum)newValue);
				return;
			case DiagonosticModelPackage.SIGNAL_TYPE__LOOKUP_VALUES:
				getLookupValues().clear();
				getLookupValues().addAll((Collection<? extends String>)newValue);
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
			case DiagonosticModelPackage.SIGNAL_TYPE__NAME:
				setName(NAME_EDEFAULT);
				return;
			case DiagonosticModelPackage.SIGNAL_TYPE__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case DiagonosticModelPackage.SIGNAL_TYPE__MESSAGE_NAME:
				setMessageName(MESSAGE_NAME_EDEFAULT);
				return;
			case DiagonosticModelPackage.SIGNAL_TYPE__NODE:
				setNode(NODE_EDEFAULT);
				return;
			case DiagonosticModelPackage.SIGNAL_TYPE__NAMESPACE:
				setNamespace(NAMESPACE_EDEFAULT);
				return;
			case DiagonosticModelPackage.SIGNAL_TYPE__CREATION_MODE:
				setCreationMode(CREATION_MODE_EDEFAULT);
				return;
			case DiagonosticModelPackage.SIGNAL_TYPE__LOOKUP_VALUES:
				getLookupValues().clear();
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
			case DiagonosticModelPackage.SIGNAL_TYPE__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case DiagonosticModelPackage.SIGNAL_TYPE__TYPE:
				return type != TYPE_EDEFAULT;
			case DiagonosticModelPackage.SIGNAL_TYPE__MESSAGE_NAME:
				return MESSAGE_NAME_EDEFAULT == null ? messageName != null : !MESSAGE_NAME_EDEFAULT.equals(messageName);
			case DiagonosticModelPackage.SIGNAL_TYPE__NODE:
				return NODE_EDEFAULT == null ? node != null : !NODE_EDEFAULT.equals(node);
			case DiagonosticModelPackage.SIGNAL_TYPE__NAMESPACE:
				return NAMESPACE_EDEFAULT == null ? namespace != null : !NAMESPACE_EDEFAULT.equals(namespace);
			case DiagonosticModelPackage.SIGNAL_TYPE__CREATION_MODE:
				return creationMode != CREATION_MODE_EDEFAULT;
			case DiagonosticModelPackage.SIGNAL_TYPE__LOOKUP_VALUES:
				return lookupValues != null && !lookupValues.isEmpty();
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
		result.append(", type: ");
		result.append(type);
		result.append(", MessageName: ");
		result.append(messageName);
		result.append(", node: ");
		result.append(node);
		result.append(", namespace: ");
		result.append(namespace);
		result.append(", creationMode: ");
		result.append(creationMode);
		result.append(", lookupValues: ");
		result.append(lookupValues);
		result.append(')');
		return result.toString();
	}

} //SignalTypeImpl
