package com.ancit.testgenx.ui.dialogs;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import DiagonosticModel.TestSpecification;

public class TestStepCAPLFileDialog extends TitleAreaDialog{

	

	private Text txtcanFile;
	private Button btncanBrowse;
	private String dbcFilePath;
	private TestSpecification testSpecification;
	private Object object;


	/**
	 * Create the dialog.
	 * 
	 * @param parentShell
	 * @param  
	 * @param testSpecification 
	 * @param object 
	 * @param spec
	 */
	public TestStepCAPLFileDialog(Shell parentShell, TestSpecification testSpecification, Object object) {
		super(parentShell);
		this.testSpecification = testSpecification;
		this.object = object;
	}
	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Import");
	}
	@Override
	public void create() {
		super.create();
		setTitle("Import CAN Files");
		setMessage("Import CAN Files ", IMessageProvider.INFORMATION);
	}

	/**
	 * Create contents of the dialog.
	 * 
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);

		Composite composite = new Composite(container, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		composite.setLayout(new GridLayout(3, false));

		
		Label lblName = new Label(composite, SWT.NONE);
		lblName.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		lblName.setText("File Path:");

		txtcanFile = new Text(composite, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		txtcanFile.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		txtcanFile.setText("");

		btncanBrowse = new Button(composite, SWT.PUSH);
		btncanBrowse.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		btncanBrowse.setText("Browse");
		btncanBrowse.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {


					FileDialog fd1 = new FileDialog(Display.getDefault().getActiveShell(), SWT.SAVE);
					fd1.setText("Import text");
					fd1.setFilterExtensions(new String[] { "*.can;*.*" });
					String selectedDBCFile = fd1.open();
					if (selectedDBCFile != null) {

						txtcanFile.setText(selectedDBCFile);
					}
				
			}
		});

		return container;
	}

	/**
	 * Create contents of the button bar.
	 * 
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
	}

	@Override
	protected void okPressed() {

		if (null != txtcanFile.getText() && !txtcanFile.getText().trim().equalsIgnoreCase("")) {
			setDbcFilePath(txtcanFile.getText());
		}

		super.okPressed();
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(450, 300);
	}

	public void setTxtName(Text txtName) {
		this.txtcanFile = txtName;
	}

	public String getDbcFilePath() {
		return dbcFilePath;
	}

	public void setDbcFilePath(String dbcFilePath) {
		this.dbcFilePath = dbcFilePath;
	}

}
