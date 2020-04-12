package com.ancit.testgenx.ui.wizards;

import java.io.File;

import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import DiagonosticModel.TestSpecification;

public class NewTestSpecificationWizardPage extends WizardPage {

	Text txtTestSpecPath;
	Text txtDBCPath;
	Text txtTestSpecName;
	private String selectedFile;
	TestSpecification testSpecification;
	private Text txtName;
	private Text txtAuthor;
	private Text txtFunctionName;
	private Text txtDescription;
	private Combo combo;

	/**
	 * Create the wizard.
	 */
	public NewTestSpecificationWizardPage() {
		super("wizardPage");
		setTitle("New Test Specification");
		setDescription("Create a Model based Test Specification");
		setPageComplete(false);
	}

	
	/**
	 * Create contents of the wizard.
	 * 
	 * @param parent
	 */
	public void createControl(Composite parent) {
		// Composite container = new Composite(parent, SWT.NULL);

		// setPageComplete(true);
		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		composite.setLayout(new GridLayout(3, false));

		Label lblName = new Label(composite, SWT.NONE);
		lblName.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		lblName.setText("Name:");

		txtTestSpecName = new Text(composite, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		txtTestSpecName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		txtTestSpecName.setText("");
		ControlDecoration txtNameControlDecoration = new ControlDecoration(txtTestSpecName, SWT.LEFT | SWT.TOP);
		txtNameControlDecoration
				.setImage(PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_DEC_FIELD_ERROR));
		txtNameControlDecoration.hide();
		txtTestSpecName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				if (!txtTestSpecName.getText().isEmpty()) {
					txtNameControlDecoration.hide();
				} else {
					txtNameControlDecoration.show();
					txtNameControlDecoration.showHoverText("Test Specification Name cannot be Empty");

				}
			}
		});

		Label lblPath = new Label(composite, SWT.NONE);
		lblPath.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		lblPath.setText("Path");

		txtTestSpecPath = new Text(composite, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		txtTestSpecPath.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		
		String filePath = Platform.getInstallLocation().getURL().getPath() + "testspec";
		String installationPath = filePath.substring(1);
		File file = new File(installationPath);
		file.mkdir();
		txtTestSpecPath.setText(installationPath);
		selectedFile = installationPath;

		txtTestSpecPath.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				if (txtTestSpecPath.getText().trim().length() > 0) {

					File file = new File(txtTestSpecPath.getText());
					if (file.exists()) {
						setErrorMessage("Test Specification with the same name already present in the given Path.");
						setPageComplete(false);
					} else {
						setErrorMessage(null);
						setPageComplete(true);
					}

				} else {
					setPageComplete(false);
				}
			}
		});

		
		Button btnbrowsenew = new Button(composite, SWT.PUSH);
		btnbrowsenew.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		btnbrowsenew.setText("Browse");
		btnbrowsenew.setEnabled(false);
		btnbrowsenew.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				DirectoryDialog dialog = new DirectoryDialog(new Shell());
				dialog.setMessage("Select the export destination folder");
				dialog.setText("Export modules");
				String res = dialog.open();
				if (res != null) {

					String path = txtTestSpecName.getText();
					txtTestSpecPath.setText(res + "\\" + path + ".tse");
					selectedFile = txtTestSpecPath.getText();
				} else {
				}
			}
		});

		txtTestSpecName.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				if (!txtTestSpecName.getText().isEmpty()) {
					txtName.setText(txtTestSpecName.getText());
					String filePath = Platform.getInstallLocation().getURL().getPath() + "testspec" + "/"
							+ txtTestSpecName.getText() + ".tse";
					String installationPath = filePath.substring(1);
					selectedFile = installationPath;
					txtTestSpecPath.setText(installationPath);
					setPageComplete(true);
					btnbrowsenew.setEnabled(true);
				} else {
					String filePath = Platform.getInstallLocation().getURL().getPath() + "testspec" + "/"
							+ txtTestSpecName.getText() + ".tse";
					String installationPath = filePath.substring(1);
					selectedFile = installationPath;
					txtTestSpecPath.setText(installationPath);
					txtName.setText(txtTestSpecName.getText());
					btnbrowsenew.setEnabled(false);
					setPageComplete(false);
				}
			}
		});

		setControl(composite);

		Group grpOverview = new Group(composite, SWT.NONE);
		grpOverview.setText("Test Specification Overview");
		grpOverview.setLayout(new GridLayout(2, false));
		grpOverview.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 3, 1));

		Label lblSpecName = new Label(grpOverview, SWT.NONE);
		lblSpecName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblSpecName.setText("Name");

		txtName = new Text(grpOverview, SWT.BORDER);
		txtName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Label lblAuthor = new Label(grpOverview, SWT.NONE);
		lblAuthor.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblAuthor.setText("Author");

		txtAuthor = new Text(grpOverview, SWT.BORDER);
		txtAuthor.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1));
		txtAuthor.setText(System.getProperty("user.name"));

		Label lblDomain = new Label(grpOverview, SWT.NONE);
		lblDomain.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblDomain.setText("Domain");

		combo = new Combo(grpOverview, SWT.NONE | SWT.READ_ONLY);
		combo.setItems(new String[] { "PowerTrain", "Chassis", "Infotainment", "ADAS", "Body", "Airbag",
				"Instrument Cluster" });
		combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Label lblFunctionName = new Label(grpOverview, SWT.NONE);
		lblFunctionName.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblFunctionName.setText("Function Name");

		txtFunctionName = new Text(grpOverview, SWT.BORDER);
		txtFunctionName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Label lblDescription = new Label(grpOverview, SWT.NONE);
		lblDescription.setLayoutData(new GridData(SWT.RIGHT, SWT.TOP, false, false, 1, 1));
		lblDescription.setText("Description");

		txtDescription = new Text(grpOverview, SWT.BORDER | SWT.MULTI);
		GridData gd_txtDescription = new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1);
		gd_txtDescription.heightHint = 82;
		txtDescription.setLayoutData(gd_txtDescription);
		setPageComplete(false);
	}

	public String getSelectedFile() {
		return selectedFile;
	}

	public String getDescription() {
		return txtDescription.getText();
	}

	public String getFunctionName() {
		return combo.getText() + "_" + txtFunctionName.getText();
	}

	public String getAuthor() {
		return txtAuthor.getText();
	}

	public String getTestSpecificationName() {
		return txtTestSpecName.getText();
	}

}
