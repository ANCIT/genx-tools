/**
 */
package DiagonosticModel;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Signal Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link DiagonosticModel.SignalType#getName <em>Name</em>}</li>
 *   <li>{@link DiagonosticModel.SignalType#getType <em>Type</em>}</li>
 *   <li>{@link DiagonosticModel.SignalType#getMessageName <em>Message Name</em>}</li>
 *   <li>{@link DiagonosticModel.SignalType#getNode <em>Node</em>}</li>
 *   <li>{@link DiagonosticModel.SignalType#getNamespace <em>Namespace</em>}</li>
 *   <li>{@link DiagonosticModel.SignalType#getCreationMode <em>Creation Mode</em>}</li>
 *   <li>{@link DiagonosticModel.SignalType#getLookupValues <em>Lookup Values</em>}</li>
 * </ul>
 *
 * @see DiagonosticModel.DiagonosticModelPackage#getSignalType()
 * @model
 * @generated
 */
public interface SignalType extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see DiagonosticModel.DiagonosticModelPackage#getSignalType_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link DiagonosticModel.SignalType#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link DiagonosticModel.SignalTypeEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see DiagonosticModel.SignalTypeEnum
	 * @see #setType(SignalTypeEnum)
	 * @see DiagonosticModel.DiagonosticModelPackage#getSignalType_Type()
	 * @model
	 * @generated
	 */
	SignalTypeEnum getType();

	/**
	 * Sets the value of the '{@link DiagonosticModel.SignalType#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see DiagonosticModel.SignalTypeEnum
	 * @see #getType()
	 * @generated
	 */
	void setType(SignalTypeEnum value);

	/**
	 * Returns the value of the '<em><b>Message Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Message Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Message Name</em>' attribute.
	 * @see #setMessageName(String)
	 * @see DiagonosticModel.DiagonosticModelPackage#getSignalType_MessageName()
	 * @model
	 * @generated
	 */
	String getMessageName();

	/**
	 * Sets the value of the '{@link DiagonosticModel.SignalType#getMessageName <em>Message Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Message Name</em>' attribute.
	 * @see #getMessageName()
	 * @generated
	 */
	void setMessageName(String value);

	/**
	 * Returns the value of the '<em><b>Node</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Node</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Node</em>' attribute.
	 * @see #setNode(String)
	 * @see DiagonosticModel.DiagonosticModelPackage#getSignalType_Node()
	 * @model
	 * @generated
	 */
	String getNode();

	/**
	 * Sets the value of the '{@link DiagonosticModel.SignalType#getNode <em>Node</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Node</em>' attribute.
	 * @see #getNode()
	 * @generated
	 */
	void setNode(String value);

	/**
	 * Returns the value of the '<em><b>Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Namespace</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Namespace</em>' attribute.
	 * @see #setNamespace(String)
	 * @see DiagonosticModel.DiagonosticModelPackage#getSignalType_Namespace()
	 * @model
	 * @generated
	 */
	String getNamespace();

	/**
	 * Sets the value of the '{@link DiagonosticModel.SignalType#getNamespace <em>Namespace</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Namespace</em>' attribute.
	 * @see #getNamespace()
	 * @generated
	 */
	void setNamespace(String value);

	/**
	 * Returns the value of the '<em><b>Creation Mode</b></em>' attribute.
	 * The literals are from the enumeration {@link DiagonosticModel.CreationModeEnum}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Creation Mode</em>' attribute.
	 * @see DiagonosticModel.CreationModeEnum
	 * @see #setCreationMode(CreationModeEnum)
	 * @see DiagonosticModel.DiagonosticModelPackage#getSignalType_CreationMode()
	 * @model
	 * @generated
	 */
	CreationModeEnum getCreationMode();

	/**
	 * Sets the value of the '{@link DiagonosticModel.SignalType#getCreationMode <em>Creation Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Creation Mode</em>' attribute.
	 * @see DiagonosticModel.CreationModeEnum
	 * @see #getCreationMode()
	 * @generated
	 */
	void setCreationMode(CreationModeEnum value);

	/**
	 * Returns the value of the '<em><b>Lookup Values</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lookup Values</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lookup Values</em>' attribute list.
	 * @see DiagonosticModel.DiagonosticModelPackage#getSignalType_LookupValues()
	 * @model
	 * @generated
	 */
	EList<String> getLookupValues();

} // SignalType
