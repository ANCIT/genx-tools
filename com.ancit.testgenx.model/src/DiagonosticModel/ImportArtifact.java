/**
 */
package DiagonosticModel;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Import Artifact</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link DiagonosticModel.ImportArtifact#getPath <em>Path</em>}</li>
 *   <li>{@link DiagonosticModel.ImportArtifact#getSignalType <em>Signal Type</em>}</li>
 * </ul>
 *
 * @see DiagonosticModel.DiagonosticModelPackage#getImportArtifact()
 * @model
 * @generated
 */
public interface ImportArtifact extends EObject {
	/**
	 * Returns the value of the '<em><b>Path</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Path</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Path</em>' attribute.
	 * @see #setPath(String)
	 * @see DiagonosticModel.DiagonosticModelPackage#getImportArtifact_Path()
	 * @model
	 * @generated
	 */
	String getPath();

	/**
	 * Sets the value of the '{@link DiagonosticModel.ImportArtifact#getPath <em>Path</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Path</em>' attribute.
	 * @see #getPath()
	 * @generated
	 */
	void setPath(String value);

	/**
	 * Returns the value of the '<em><b>Signal Type</b></em>' containment reference list.
	 * The list contents are of type {@link DiagonosticModel.SignalType}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Signal Type</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Signal Type</em>' containment reference list.
	 * @see DiagonosticModel.DiagonosticModelPackage#getImportArtifact_SignalType()
	 * @model containment="true"
	 * @generated
	 */
	EList<SignalType> getSignalType();

} // ImportArtifact
