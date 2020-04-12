package com.ancit.testgenx.ui.dialogs;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import DiagonosticModel.SignalType;
import DiagonosticModel.TestSpecification;
import DiagonosticModel.WaitAction;

public class TestStepWaitDialog extends TitleAreaDialog {

	private Text txtTime;
	private TestSpecification spec;
	private SignalType signalType;
	private String txtTimeVAlue;
	private WaitAction action;
	private Combo combo;
	private String times;
	private int time_converted;

	/**
	 * Create the dialog.
	 * 
	 * @param parentShell
	 * @param spec2
	 */
	public TestStepWaitDialog(Shell parentShell, TestSpecification spec2, WaitAction action) {
		super(parentShell);
		this.spec = spec2;
		this.action = action;
	}
	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Wait Action");
	}
	@Override
	public void create() {
		super.create();
		setTitle("TestSpecification Wait Action");
		setMessage("Create wait action and fill required details ", IMessageProvider.INFORMATION);
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
		lblName.setText("Time");

		txtTime = new Text(composite, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		GridData gd_txtTime = new GridData(SWT.FILL, SWT.CENTER, true, false);
		gd_txtTime.widthHint = 257;
		txtTime.setLayoutData(gd_txtTime);
		// txtTime.setText("");

		combo = new Combo(composite, SWT.DROP_DOWN | SWT.READ_ONLY);
		combo.setLayoutData(new GridData(SWT.FILL, SWT.END, true, false));
		combo.setItems(new String[] { "ms", "sec" });
		combo.setText("ms");

		if (action != null) {

			String data = action.getTitle();
			String[] splited = data.split("\\s+");
			System.out.println("Time  == " + splited[0]);

			txtTime.setText(splited[0]);
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

		times = combo.getText();
		txtTimeVAlue = String.valueOf(txtTime.getText());
//		System.out.println("set dialog text name =" + txtTime.getText());

//		if (signalType == null || !signalType.getName().equals(txtTime.getText())) {
//			signalType = DiagonosticModelFactory.eINSTANCE.createSignalType();
//			if (times.equalsIgnoreCase("sec")) {
//				signalType.setName(txtTimeVAlue + " " + times);
//			} else {
//				signalType.setName(txtTimeVAlue + " " + times);
//			}
//		}

		super.okPressed();
	}

	/*
	 * public String getTimes() { return times; }
	 */

	public SignalType getSignalType() {
		return signalType;
	}

	public String getTxtTime() {
		return txtTimeVAlue + " " + times;
	}
	/*
	 * public String getTxtTimeVAlue() { return txtTimeVAlue; }
	 */

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(450, 300);
	}

}
