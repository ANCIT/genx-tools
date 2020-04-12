package com.ancit.testgenx.ui.dialogs;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import DiagonosticModel.ForLoop;
import DiagonosticModel.SignalType;
import DiagonosticModel.TestSpecification;

public class TestStepForDialog extends TitleAreaDialog {

	private ForLoop action;
	private TestSpecification spec;
	private String title;
	private String loopvar;
	private int startValue = 0;
	private int stopValue = 0;
	private Text txtTitle;
	private Text txtName;
	private Text startValueText;
	private Text stopValueText;
	private Button btnlookup;

	public TestStepForDialog(Shell parentShell, TestSpecification spec, ForLoop action) {
		super(parentShell);
		this.action = action;
		this.spec =spec;
	}
	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("For Loop");
	}
	@Override
	public void create() {
		super.create();
		setTitle("TestSpecification For Action");
		setMessage("Add For loop and fill required details ", IMessageProvider.INFORMATION);
	}

	@Override
	protected Control createDialogArea(Composite parent) {

		Composite container = (Composite) super.createDialogArea(parent);

		Composite composite = new Composite(container, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		composite.setLayout(new GridLayout(4, false));

		Label lblTitle = new Label(composite, SWT.NONE);
		lblTitle.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		lblTitle.setText("Title *");

		txtTitle = new Text(composite, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		GridData gd_txtWait = new GridData(SWT.FILL, SWT.CENTER, true, false);
		gd_txtWait.horizontalSpan = 2;
		gd_txtWait.widthHint = 304;
		txtTitle.setLayoutData(gd_txtWait);

		// txtTitle.setText("0");
		new Label(composite, SWT.NONE);

		Label lblLoopVar = new Label(composite, SWT.NONE);
		lblLoopVar.setText("Loop Var");

		txtName = new Text(composite, SWT.BORDER);
		txtName.setEditable(false);
		GridData gd_txtName = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_txtName.widthHint = 268;
		txtName.setLayoutData(gd_txtName);

		btnlookup = new Button(composite, SWT.NONE);
		btnlookup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		btnlookup.setText("Look Up");
		new Label(composite, SWT.NONE);
		btnlookup.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				LookupElementListSelectionDialog viewObject = new LookupElementListSelectionDialog(
						Display.getDefault().getActiveShell(), spec,true);

				int open = viewObject.open();
				// int result = dialog.open();

				if (IDialogConstants.OK_ID == open) {
					// if (open == viewObject.OK) {
					if (null != viewObject.getSignalType()) {
						SignalType signalType = ((SignalType) viewObject.getSignalType());
						txtName.setText(signalType.getName());
					} else {
						txtName.setText("");
					}
					// txtValue.setText(signalType.getType().getName());
				}
			}
		});

		Label lblStartvalue = new Label(composite, SWT.NONE);
		lblStartvalue.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblStartvalue.setText("StartValue *");

		startValueText = new Text(composite, SWT.BORDER);
		startValueText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		new Label(composite, SWT.NONE);

		Label lblStopvalue = new Label(composite, SWT.NONE);
		lblStopvalue.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblStopvalue.setText("StopValue *");

		stopValueText = new Text(composite, SWT.BORDER);
		stopValueText.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		new Label(composite, SWT.NONE);

		// add listner to allow only integer value.
		startValueText.addVerifyListener(new VerifyListener() {

			@Override
			public void verifyText(VerifyEvent e) {

				Text text = (Text) e.getSource();

				// get old text and create new text by using the VerifyEvent.text
				final String oldS = text.getText();
				String newS = oldS.substring(0, e.start) + e.text + oldS.substring(e.end);

				try {
					Float.parseFloat(newS);
				} catch (NumberFormatException ex) {
					e.doit = false;
				}
			}
		});

		// add listner to allow only integer value.
		stopValueText.addVerifyListener(new VerifyListener() {

			@Override
			public void verifyText(VerifyEvent e) {

				Text text = (Text) e.getSource();

				// get old text and create new text by using the VerifyEvent.text
				final String oldS = text.getText();
				String newS = oldS.substring(0, e.start) + e.text + oldS.substring(e.end);

				try {
					Float.parseFloat(newS);
				} catch (NumberFormatException ex) {
					e.doit = false;
				}
			}
		});

		if (action != null) {
			txtTitle.setText(action.getTitle());
			txtName.setText(action.getLoopVar());
			startValueText.setText(String.valueOf(action.getStartValue()));
			stopValueText.setText(String.valueOf(action.getStopValue()));
		}
		return container;
	}

	@Override
	protected void okPressed() {
		title = txtTitle.getText();
		loopvar = txtName.getText();
		if (!startValueText.getText().trim().isEmpty()) {
			startValue = Integer.parseInt(startValueText.getText().trim());
		}
		if (!stopValueText.getText().trim().isEmpty()) {
			stopValue = Integer.parseInt(stopValueText.getText().trim());
		}
		if (title.isEmpty() || title == null || loopvar.isEmpty() || loopvar == null) {
			MessageDialog.openWarning(Display.getDefault().getActiveShell(), "Warning", "Please fill all details");
		} else {
			super.okPressed();
		}
	}

	public String getTitle() {
		return title;
	}

	public String getLoopvar() {
		return loopvar;
	}

	public int getStartValue() {
		return startValue;
	}

	public int getStopValue() {
		return stopValue;
	}

	@Override
	protected Point getInitialSize() {
		return new Point(490, 401);
	}

}
