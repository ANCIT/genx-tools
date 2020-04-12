/**
 */
package DiagonosticModel;

import java.util.ArrayList;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Test Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link DiagonosticModel.TestSpecification#getName <em>Name</em>}</li>
 *   <li>{@link DiagonosticModel.TestSpecification#getTestGroups <em>Test Groups</em>}</li>
 *   <li>{@link DiagonosticModel.TestSpecification#getVersion <em>Version</em>}</li>
 *   <li>{@link DiagonosticModel.TestSpecification#getDescription <em>Description</em>}</li>
 *   <li>{@link DiagonosticModel.TestSpecification#getFunctionName <em>Function Name</em>}</li>
 *   <li>{@link DiagonosticModel.TestSpecification#getFunctionVersion <em>Function Version</em>}</li>
 *   <li>{@link DiagonosticModel.TestSpecification#getAuthor <em>Author</em>}</li>
 *   <li>{@link DiagonosticModel.TestSpecification#getCapltestcases <em>Capltestcases</em>}</li>
 *   <li>{@link DiagonosticModel.TestSpecification#getVariants <em>Variants</em>}</li>
 *   <li>{@link DiagonosticModel.TestSpecification#getImportArtifacts <em>Import Artifacts</em>}</li>
 * </ul>
 *
 * @see DiagonosticModel.DiagonosticModelPackage#getTestSpecification()
 * @model
 * @generated
 */
public interface TestSpecification extends EObject {
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
	 * @see DiagonosticModel.DiagonosticModelPackage#getTestSpecification_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link DiagonosticModel.TestSpecification#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Test Groups</b></em>' containment reference list.
	 * The list contents are of type {@link DiagonosticModel.TestGroup}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Test Groups</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Test Groups</em>' containment reference list.
	 * @see DiagonosticModel.DiagonosticModelPackage#getTestSpecification_TestGroups()
	 * @model containment="true"
	 * @generated
	 */
	EList<TestGroup> getTestGroups();

	/**
	 * Returns the value of the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version</em>' attribute.
	 * @see #setVersion(String)
	 * @see DiagonosticModel.DiagonosticModelPackage#getTestSpecification_Version()
	 * @model
	 * @generated
	 */
	String getVersion();

	/**
	 * Sets the value of the '{@link DiagonosticModel.TestSpecification#getVersion <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version</em>' attribute.
	 * @see #getVersion()
	 * @generated
	 */
	void setVersion(String value);

	/**
	 * Returns the value of the '<em><b>Description</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Description</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Description</em>' attribute.
	 * @see #setDescription(String)
	 * @see DiagonosticModel.DiagonosticModelPackage#getTestSpecification_Description()
	 * @model
	 * @generated
	 */
	String getDescription();

	/**
	 * Sets the value of the '{@link DiagonosticModel.TestSpecification#getDescription <em>Description</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Description</em>' attribute.
	 * @see #getDescription()
	 * @generated
	 */
	void setDescription(String value);

	/**
	 * Returns the value of the '<em><b>Function Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Function Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Function Name</em>' attribute.
	 * @see #setFunctionName(String)
	 * @see DiagonosticModel.DiagonosticModelPackage#getTestSpecification_FunctionName()
	 * @model
	 * @generated
	 */
	String getFunctionName();

	/**
	 * Sets the value of the '{@link DiagonosticModel.TestSpecification#getFunctionName <em>Function Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Function Name</em>' attribute.
	 * @see #getFunctionName()
	 * @generated
	 */
	void setFunctionName(String value);

	/**
	 * Returns the value of the '<em><b>Function Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Function Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Function Version</em>' attribute.
	 * @see #setFunctionVersion(String)
	 * @see DiagonosticModel.DiagonosticModelPackage#getTestSpecification_FunctionVersion()
	 * @model
	 * @generated
	 */
	String getFunctionVersion();

	/**
	 * Sets the value of the '{@link DiagonosticModel.TestSpecification#getFunctionVersion <em>Function Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Function Version</em>' attribute.
	 * @see #getFunctionVersion()
	 * @generated
	 */
	void setFunctionVersion(String value);

	/**
	 * Returns the value of the '<em><b>Author</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Author</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Author</em>' attribute.
	 * @see #setAuthor(String)
	 * @see DiagonosticModel.DiagonosticModelPackage#getTestSpecification_Author()
	 * @model
	 * @generated
	 */
	String getAuthor();

	/**
	 * Sets the value of the '{@link DiagonosticModel.TestSpecification#getAuthor <em>Author</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Author</em>' attribute.
	 * @see #getAuthor()
	 * @generated
	 */
	void setAuthor(String value);

	/**
	 * Returns the value of the '<em><b>Capltestcases</b></em>' containment reference list.
	 * The list contents are of type {@link DiagonosticModel.CAPLTestCase}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Capltestcases</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Capltestcases</em>' containment reference list.
	 * @see DiagonosticModel.DiagonosticModelPackage#getTestSpecification_Capltestcases()
	 * @model containment="true"
	 * @generated
	 */
	EList<CAPLTestCase> getCapltestcases();

	/**
	 * Returns the value of the '<em><b>Variants</b></em>' containment reference list.
	 * The list contents are of type {@link DiagonosticModel.Variant}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variants</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variants</em>' containment reference list.
	 * @see DiagonosticModel.DiagonosticModelPackage#getTestSpecification_Variants()
	 * @model containment="true"
	 * @generated
	 */
	EList<Variant> getVariants();

	/**
	 * Returns the value of the '<em><b>Import Artifacts</b></em>' containment reference list.
	 * The list contents are of type {@link DiagonosticModel.ImportArtifact}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Import Artifacts</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Import Artifacts</em>' containment reference list.
	 * @see DiagonosticModel.DiagonosticModelPackage#getTestSpecification_ImportArtifacts()
	 * @model containment="true"
	 * @generated
	 */
	EList<ImportArtifact> getImportArtifacts();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" dataType="DiagonosticModel.ArrayListDataType"
	 *        annotation="http://www.eclipse.org/emf/2002/GenModel body='ArrayList&lt;SignalType&gt; signals = new ArrayList&lt;SignalType&gt;();\n\t\t\n\t\tfor (ImportArtifact importArtifact : getImportArtifacts()) {\n\t\t\tsignals.addAll(importArtifact.getSignalType());\n\t\t}\n\t\treturn signals;'"
	 * @generated
	 */
	ArrayList<SignalType> getSignals();

} // TestSpecification
