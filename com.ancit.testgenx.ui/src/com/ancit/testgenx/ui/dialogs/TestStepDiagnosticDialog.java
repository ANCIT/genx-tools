package com.ancit.testgenx.ui.dialogs;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import DiagonosticModel.DiagnosticService;
import DiagonosticModel.TestSpecification;

public class TestStepDiagnosticDialog extends TitleAreaDialog {

	private Text txtResult;
	private Label lblResult;
	private Text txtService;
	private Label lblService;
	private Text txtECU;
	private Label lblECU;
	private String ecu;
	private String service;
	private String result;
	private DiagnosticService diagnosticService;

	/**
	 * Create the dialog.
	 * 
	 * @param parentShell
	 * @param spec
	 */
	public TestStepDiagnosticDialog(Shell parentShell, TestSpecification spec, DiagnosticService diagnosticService) {
		super(parentShell);
		this.diagnosticService = diagnosticService;
	}

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Service Action");
	}
	
	@Override
	public void create() {

		super.create();
		setTitle("TestSpecification Diagnostic Service Action");
		setMessage("Add Diagnostic Service action Dialog", IMessageProvider.INFORMATION);

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
		composite.setLayout(new GridLayout(2, false));

		lblECU = new Label(composite, SWT.NONE);
		lblECU.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		lblECU.setText("ECU");

		txtECU = new Text(composite, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		txtECU.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		// txtWaitKey.setText("");

		lblService = new Label(composite, SWT.NONE);
		lblService.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		lblService.setText("Service");

		txtService = new Text(composite, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		txtService.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		// txtWaitService.setText("");

		lblResult = new Label(composite, SWT.NONE);
		lblResult.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		lblResult.setText("Response");

		txtResult = new Text(composite, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		txtResult.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		// txtWaitResult.setText("");

		if (diagnosticService != null) {
			System.out.println("DATA " + diagnosticService);
			txtResult.setText(diagnosticService.getResult());
			txtECU.setText(diagnosticService.getEcu());
			txtService.setText(diagnosticService.getService());

		}

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

		ecu = txtECU.getText();
		service = txtService.getText();
		result = txtResult.getText();
		super.okPressed();
	}

	public String getEcu() {
		return ecu;
	}

	public String getService() {
		return service;
	}

	public String getResult() {
		return result;
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(450, 300);
	}

	@Override
	protected boolean isResizable() {
		return true;
	}

}
