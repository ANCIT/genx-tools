package com.ancit.testgenx.ui.wizards;

import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;

import DiagonosticModel.TestSpecification;

public class ConvertToXMLWizardPage extends WizardPage {

	Text txtSourcePath;
	Text txtDBCPath;
	private String selectedFile, destinationFile;
	TestSpecification testSpecification;
	private Text textDestinationPath;

	/**
	 * Create the wizard.
	 */
	public ConvertToXMLWizardPage() {
		super("wizardPage");
		setTitle("Convert To XML File");
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

		Label lblPath = new Label(composite, SWT.NONE);
		lblPath.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		lblPath.setText("Source File Path");

		txtSourcePath = new Text(composite, SWT.SINGLE | SWT.LEAD | SWT.BORDER  | SWT.READ_ONLY);
		txtSourcePath.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		txtSourcePath.setText("");

		txtSourcePath.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				// TODO Auto-generated method stub
				if (txtSourcePath.getText().trim().length() > 0) {
					setPageComplete(true);
				} else {
					setPageComplete(false);
				}
			}
		});
		Button btnbrowsenew = new Button(composite, SWT.PUSH);
		btnbrowsenew.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		btnbrowsenew.setText("Browse");
		btnbrowsenew.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {

				FileDialog fl = new FileDialog(Display.getCurrent().getActiveShell(), SWT.OPEN);
				fl.setOverwrite(true);
				fl.setText("Open XML File");
				String res = fl.open();
				if (res != null) {
					System.out.println(res);
					txtSourcePath.setText(res);
					selectedFile = txtSourcePath.getText();
					setPageComplete(true);
				} else {
					setPageComplete(false);
				}
			
			}
		});

		setControl(composite);

		Label lblDestinationPath = new Label(composite, SWT.NONE);
		lblDestinationPath.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblDestinationPath.setText("Destination Path");

		textDestinationPath = new Text(composite, SWT.BORDER | SWT.READ_ONLY);
		textDestinationPath.setText("");
		textDestinationPath.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		Button button = new Button(composite, SWT.NONE);
		button.setText("Browse");
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				FileDialog fl = new FileDialog(Display.getCurrent().getActiveShell(), SWT.SAVE);
				fl.setOverwrite(true);
//				fl.setFilterExtensions( new String[] { ".xml" } );
//				DirectoryDialog dialog = new DirectoryDialog(new Shell());
//				fl.setMessage("Select the destination folder");
				fl.setText("Save XML File");
				String res = fl.open();
				if (res != null) {
					if (res.endsWith(".xml")) {
						res = res.replace(".xml", "");
					}
					textDestinationPath.setText(res+".xml");
					// String path = txtTestSpecName.getText();
					// txtTestSpecPath.setText(res + "\\" + path + ".tse");
					destinationFile = textDestinationPath.getText();
					setPageComplete(true);
				} else {
					setPageComplete(false);
				}
			}
		});
	}

	public String getSourceFile() {
		return selectedFile;
	}

	public String getDestinationFile() {
		return destinationFile;
	}

}
