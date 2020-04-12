package com.ancit.testgenx.ui.page;

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

import DiagonosticModel.SignalType;
import DiagonosticModel.TestSpecification;

public class CAPLTestCaseDialog extends TitleAreaDialog {

	private TestSpecification testSpecification;
	private Text txtParameterName;
	private Text txtParameterType;
	private Text txtParameterValue;
	private SignalType signalType;
	private String paramaeterName;
	private String parameterType;
	private String paramaeterValue;

	public CAPLTestCaseDialog(Shell parentShell, TestSpecification testSpecification) {

		super(parentShell);
		this.testSpecification = testSpecification;

	}

	@Override
	public void create() {
		super.create();
		setTitle("CAPL Test Cases");
		setMessage("Add CaplTestCases Dialog", IMessageProvider.INFORMATION);
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

		Label lblParameterName = new Label(composite, SWT.NONE);
		lblParameterName.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		lblParameterName.setText("Name");

		txtParameterName = new Text(composite, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		txtParameterName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		txtParameterName.setText("");
		
		
		Label lblParameterType = new Label(composite, SWT.NONE);
		lblParameterType.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		lblParameterType.setText("Type");
		
		txtParameterType = new Text(composite, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		txtParameterType.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		txtParameterType.setText("");
		
		Label lblParameterValue = new Label(composite, SWT.NONE);
		lblParameterValue.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		lblParameterValue.setText("Value");
		
		txtParameterValue = new Text(composite, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		txtParameterValue.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		txtParameterValue.setText("");
		
		
		return container;
	}
	
	/**
	 * Create contents of the button bar.
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
	}

	
	@Override
	protected void okPressed() {

		paramaeterName = txtParameterName.getText();
		parameterType = txtParameterType.getText();
		paramaeterValue = txtParameterValue.getText();
		super.okPressed();
	}
	
	public String getparamaeterName() {
		return paramaeterName;

	}
	public String getparameterType() {
		return parameterType;

	}
	
	public String getparamaeterValue() {
		return paramaeterValue;
	}
	

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(450, 300);
	}
	
}
