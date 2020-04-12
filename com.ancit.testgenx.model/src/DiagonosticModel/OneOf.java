/**
 */
package DiagonosticModel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>One Of</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link DiagonosticModel.OneOf#getValues <em>Values</em>}</li>
 * </ul>
 *
 * @see DiagonosticModel.DiagonosticModelPackage#getOneOf()
 * @model
 * @generated
 */
public interface OneOf extends DiagnosticParamValueType {
	/**
	 * Returns the value of the '<em><b>Values</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Values</em>' attribute list.
	 * @see DiagonosticModel.DiagonosticModelPackage#getOneOf_Values()
	 * @model required="true"
	 * @generated
	 */
	EList<String> getValues();

} // OneOf
