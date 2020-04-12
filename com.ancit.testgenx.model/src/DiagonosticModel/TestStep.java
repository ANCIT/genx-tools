/**
 */
package DiagonosticModel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Test Step</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link DiagonosticModel.TestStep#getTitle <em>Title</em>}</li>
 *   <li>{@link DiagonosticModel.TestStep#getNextStep <em>Next Step</em>}</li>
 *   <li>{@link DiagonosticModel.TestStep#getKey <em>Key</em>}</li>
 * </ul>
 *
 * @see DiagonosticModel.DiagonosticModelPackage#getTestStep()
 * @model abstract="true"
 * @generated
 */
public interface TestStep extends EObject {
	/**
	 * Returns the value of the '<em><b>Key</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Key</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Key</em>' reference.
	 * @see #setKey(SignalType)
	 * @see DiagonosticModel.DiagonosticModelPackage#getTestStep_Key()
	 * @model
	 * @generated
	 */
	SignalType getKey();

	/**
	 * Sets the value of the '{@link DiagonosticModel.TestStep#getKey <em>Key</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Key</em>' reference.
	 * @see #getKey()
	 * @generated
	 */
	void setKey(SignalType value);

	/**
	 * Returns the value of the '<em><b>Title</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Title</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Title</em>' attribute.
	 * @see #setTitle(String)
	 * @see DiagonosticModel.DiagonosticModelPackage#getTestStep_Title()
	 * @model
	 * @generated
	 */
	String getTitle();

	/**
	 * Sets the value of the '{@link DiagonosticModel.TestStep#getTitle <em>Title</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Title</em>' attribute.
	 * @see #getTitle()
	 * @generated
	 */
	void setTitle(String value);

	/**
	 * Returns the value of the '<em><b>Next Step</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Next Step</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Next Step</em>' reference.
	 * @see #setNextStep(TestStep)
	 * @see DiagonosticModel.DiagonosticModelPackage#getTestStep_NextStep()
	 * @model
	 * @generated
	 */
	TestStep getNextStep();

	/**
	 * Sets the value of the '{@link DiagonosticModel.TestStep#getNextStep <em>Next Step</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Next Step</em>' reference.
	 * @see #getNextStep()
	 * @generated
	 */
	void setNextStep(TestStep value);

} // TestStep
