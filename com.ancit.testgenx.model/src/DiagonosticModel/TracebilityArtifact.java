/**
 */
package DiagonosticModel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Tracebility Artifact</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link DiagonosticModel.TracebilityArtifact#getType <em>Type</em>}</li>
 *   <li>{@link DiagonosticModel.TracebilityArtifact#getUrl <em>Url</em>}</li>
 * </ul>
 *
 * @see DiagonosticModel.DiagonosticModelPackage#getTracebilityArtifact()
 * @model
 * @generated
 */
public interface TracebilityArtifact extends EObject {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * The literals are from the enumeration {@link DiagonosticModel.TraceabilityArtifactEnum}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see DiagonosticModel.TraceabilityArtifactEnum
	 * @see #setType(TraceabilityArtifactEnum)
	 * @see DiagonosticModel.DiagonosticModelPackage#getTracebilityArtifact_Type()
	 * @model
	 * @generated
	 */
	TraceabilityArtifactEnum getType();

	/**
	 * Sets the value of the '{@link DiagonosticModel.TracebilityArtifact#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see DiagonosticModel.TraceabilityArtifactEnum
	 * @see #getType()
	 * @generated
	 */
	void setType(TraceabilityArtifactEnum value);

	/**
	 * Returns the value of the '<em><b>Url</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Url</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Url</em>' attribute.
	 * @see #setUrl(String)
	 * @see DiagonosticModel.DiagonosticModelPackage#getTracebilityArtifact_Url()
	 * @model
	 * @generated
	 */
	String getUrl();

	/**
	 * Sets the value of the '{@link DiagonosticModel.TracebilityArtifact#getUrl <em>Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Url</em>' attribute.
	 * @see #getUrl()
	 * @generated
	 */
	void setUrl(String value);

} // TracebilityArtifact
