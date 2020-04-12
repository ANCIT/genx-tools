package com.ancit.testgenx.ui.dialogs;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import DiagonosticModel.CAPLParam;
import DiagonosticModel.SignalType;

public class TestStepCAPLParamDialog extends TitleAreaDialog {

	private Text txtName;
	private SignalType signalType;
	private Label lblOperator;
	private Text txtValue;
	private String opValue;
	private String title;
	private String paramValue;
	private Label lblValue;
	private CAPLParam caplParam;
	private Text txtType;

	/**
	 * Create the dialog.
	 * 
	 * @param parentShell
	 * @param spec2
	 */
	public TestStepCAPLParamDialog(Shell parentShell, CAPLParam caplParam) {
		super(parentShell);
		this.caplParam = caplParam;
	}

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("CAPL");
	}
	
	@Override
	public void create() {
		super.create();
		setTitle("TestStep CAPL Parameter");
		setMessage("Create new CAPL Parameter and fill required details ", IMessageProvider.INFORMATION);
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

		Label lblName = new Label(composite, SWT.NONE);
		lblName.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		lblName.setText("Name");

		txtName = new Text(composite, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		txtName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		txtName.setText(caplParam.getName());
		txtName.setEnabled(false);
		
		lblOperator = new Label(composite, SWT.NONE);
		lblOperator.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		lblOperator.setText("Operator");

		txtType = new Text(composite, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		txtType.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		String value = caplParam.getType();
		if (value != null) {
			txtType.setText(value);
		}
		txtType.setEnabled(false);

		lblValue = new Label(composite, SWT.NONE);
		lblValue.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		lblValue.setText("Value");

		txtValue = new Text(composite, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		txtValue.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		String type = caplParam.getValue();
		if (type != null) {
			txtValue.setText(type);
		}
		txtValue.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				if (!txtValue.getText().isEmpty() && !txtName.getText().isEmpty()) {
					getButton(IDialogConstants.OK_ID).setEnabled(true);
				} else {
					getButton(IDialogConstants.OK_ID).setEnabled(false);
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
		getButton(IDialogConstants.OK_ID).setEnabled(false);
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
	}

	@Override
	protected void okPressed() {

		title = txtName.getText();
		opValue = txtType.getText();
		paramValue = txtValue.getText();
		super.okPressed();
	}

	public SignalType getSignalType() {
		return signalType;
	}

	/**
	 * Return the initial size of the dialog.
	 */

	public String getTitle() {
		return title;
	}

	public String getOpValue() {
		return opValue;
	}

	public String getParamValue() {
		return paramValue;
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(490, 401);
	}

}
