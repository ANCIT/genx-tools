package com.ancit.testgenx.ui.dialogs;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;

import DiagonosticModel.CheckAction;
import DiagonosticModel.DiagonosticModelFactory;
import DiagonosticModel.OperatorTypeEnum;
import DiagonosticModel.SignalType;
import DiagonosticModel.SignalTypeEnum;
import DiagonosticModel.TestSpecification;
import org.eclipse.wb.swt.SWTResourceManager;

public class TestStepCheckDialog extends TitleAreaDialog {

	private Button btnlookup;
	private Text txtName;
	private TestSpecification spec;

	private SignalType signalType;
	private Label lblOperator;
	private Combo waittimeCombo;
	private Combo opratorCombo;
	private Text txtValueFrom;
	private String opValue;
	private CheckAction action;
	private Text txtTitle;
	private Text txtWait;
	private String title;
	private String wait;
	private Text txtValueTo;
	private String fromValue;
	private String toValue;
	private Label lblValue2;
	private Label lblValue;
	private String txtNameValue;
	private Composite valueComposite;
	private Composite dbcValueComposite;
	private Composite dbcLookupComposite;
	private Label lblLookupValue;
	private Combo cmbDbcLookupValue;
	private boolean verification_flag;
	private ControlDecoration txtNameControlDecoration;

	/**
	 * Create the dialog.
	 * 
	 * @param parentShell
	 * @param spec2
	 */
	public TestStepCheckDialog(Shell parentShell, TestSpecification spec, CheckAction action) {
		super(parentShell);
		this.spec = spec;
		this.action = action;
	}

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Check Action");
	}
	
	@Override
	public void create() {
		super.create();
		setTitle("TestStep Check Action");
		setMessage("Fill required check action details", IMessageProvider.INFORMATION);
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

		Label lblWait = new Label(composite, SWT.NONE);
		lblWait.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		lblWait.setText("Wait");

		txtWait = new Text(composite, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		GridData gd_txtWait = new GridData(SWT.FILL, SWT.CENTER, true, false);
		gd_txtWait.widthHint = 304;
		txtWait.setLayoutData(gd_txtWait);
		txtWait.setText("0");
		
		Label lblWaitUnit = new Label(composite, SWT.NONE);
		lblWaitUnit.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		lblWaitUnit.setText("sec");
		
//		waittimeCombo = new Combo(composite, SWT.DROP_DOWN | SWT.READ_ONLY);
//		GridData gd_waittimeCombo = new GridData(SWT.BEGINNING, SWT.END, true, false);
//		gd_waittimeCombo.widthHint = 63;
//		waittimeCombo.setLayoutData(gd_waittimeCombo);
//		waittimeCombo.setItems(new String[] { "ms", "sec" });
//		waittimeCombo.setText("ms");

		Label lblName = new Label(composite, SWT.NONE);
		lblName.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		lblName.setText("Signal *");

		txtName = new Text(composite, SWT.SINGLE | SWT.LEAD | SWT.BORDER | SWT.READ_ONLY);
		txtName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		StackLayout stackLayout = new StackLayout();

		btnlookup = new Button(composite, SWT.PUSH);
		GridData gd_btnlookup = new GridData(SWT.BEGINNING, SWT.CENTER, false, false);
		gd_btnlookup.widthHint = 79;
		btnlookup.setLayoutData(gd_btnlookup);
		btnlookup.setText("Look Up");
		btnlookup.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				LookupElementListSelectionDialog viewObject = new LookupElementListSelectionDialog(
						Display.getDefault().getActiveShell(), spec, false);

				int open = viewObject.open();
				if (IDialogConstants.OK_ID == open) {
					// if (open == viewObject.OK) {
					if (null != viewObject.getSignalType()) {
						signalType = ((SignalType) viewObject.getSignalType());
						txtName.setText(signalType.getName());
						EList<String> lookupValues = signalType.getLookupValues();
						if (lookupValues.size() == 0) {
							stackLayout.topControl = dbcValueComposite;
							valueComposite.layout();

							if (!txtValueFrom.getText().isEmpty()) {
								txtNameControlDecoration.hide();
							} else {
								txtNameControlDecoration.show();
								txtNameControlDecoration.showHoverText("From value cannot be Empty");
							}

						} else {
							for (String lookupValue : lookupValues) {
								cmbDbcLookupValue.add(lookupValue);
							}
							stackLayout.topControl = dbcLookupComposite;
							valueComposite.layout();
						}
						action.setKey(signalType);
					} else {
						txtName.setText("");
					}
					// txtValue.setText(signalType.getType().getName());
				}
			}
		});

		lblOperator = new Label(composite, SWT.NONE);
		lblOperator.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		lblOperator.setText("Operator");

		String[] operatorValue = { "" + OperatorTypeEnum.EQ, "" + OperatorTypeEnum.GT, "" + OperatorTypeEnum.LT,
				"" + OperatorTypeEnum.NE };
		opratorCombo = new Combo(composite, SWT.DROP_DOWN | SWT.READ_ONLY);
		opratorCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		opratorCombo.setItems(operatorValue);
		opratorCombo.select(0);

		valueComposite = new Composite(composite, SWT.NONE);
		valueComposite.setLayout(stackLayout);
		GridData gd_valueComposite = new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1);
		gd_valueComposite.widthHint = 64;
		valueComposite.setLayoutData(gd_valueComposite);

		dbcValueComposite = new Composite(valueComposite, SWT.NONE);
		dbcValueComposite.setLayout(new GridLayout(2, false));

		lblValue = new Label(dbcValueComposite, SWT.NONE);
		lblValue.setText("Value           ");

		txtValueFrom = new Text(dbcValueComposite, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		txtValueFrom.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		txtNameControlDecoration = new ControlDecoration(txtValueFrom, SWT.LEFT | SWT.TOP);
		// txtNameControlDecoration.setDescriptionText("Test Group Name cannot be
		// Empty");
		txtNameControlDecoration
				.setImage(PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_DEC_FIELD_ERROR));
		txtNameControlDecoration.hide();

		txtValueFrom.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				if (!txtValueFrom.getText().isEmpty()) {
					txtNameControlDecoration.hide();
				} else {
					txtNameControlDecoration.show();
					txtNameControlDecoration.showHoverText("From value cannot be Empty");
				}
			}

			@Override
			public void focusGained(FocusEvent e) {

			}
		});
//		lblValue2 = new Label(dbcValueComposite, SWT.NONE);
//		lblValue2.setText("Value To");
//
//		lblValue2.setEnabled(false);
//
//		txtValueTo = new Text(dbcValueComposite, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
//		txtValueTo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
//		txtValueTo.setText("");
//		txtValueTo.setEnabled(false);

		dbcLookupComposite = new Composite(valueComposite, SWT.NONE);
		dbcLookupComposite.setLayout(new GridLayout(2, false));

		lblLookupValue = new Label(dbcLookupComposite, SWT.NONE);
		lblLookupValue.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblLookupValue.setText("Lookup Value");

		cmbDbcLookupValue = new Combo(dbcLookupComposite, SWT.NONE | SWT.READ_ONLY);
		cmbDbcLookupValue.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		opratorCombo.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {

				if (null != opratorCombo && null != opratorCombo.getText() && opratorCombo.getText().toString().equals("between")) {

					lblValue.setText("Value From");
					lblValue2.setEnabled(true);
					txtValueTo.setEnabled(true);

				} else {
					lblValue2.setEnabled(false);
					txtValueTo.setEnabled(false);
				}

			}
		});

		if (action != null) {
			// txtTitle.setText(action.getTitle() != null ? action.getTitle() : "");
			txtWait.setText(String.valueOf(action.getWait()));
			txtName.setText(action.getKey().getName());

			signalType = action.getKey();

			EList<String> lookupValues = action.getKey().getLookupValues();
			if (lookupValues.size() == 0) {
				stackLayout.topControl = dbcValueComposite;
				txtValueFrom.setText(action.getValue() != null ? action.getValue() : "");
//				txtValueTo.setText(action.getValueTo() != null ? action.getValueTo() : "");
				valueComposite.layout();

			} else {
				for (String lookupValue : lookupValues) {
					cmbDbcLookupValue.add(lookupValue);
				}
				cmbDbcLookupValue.setText(action.getValue());
				stackLayout.topControl = dbcLookupComposite;
				valueComposite.layout();
			}

			opratorCombo.setText(action.getOperator().getLiteral());
		} else {
			action = DiagonosticModelFactory.eINSTANCE.createCheckAction();
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
		verification_flag = false;

		if (null != action.getKey() && null != action.getKey().getLookupValues()
				&& action.getKey().getLookupValues().size() == 0 && null != txtValueFrom.getText()
				&& !txtValueFrom.getText().toString().trim().equalsIgnoreCase("")) {
			fromValue = txtValueFrom.getText();
//			toValue = txtValueTo.getText();
			opValue = opratorCombo.getText();
			wait = txtWait.getText();
			verification_flag = true;
		} else if (null != cmbDbcLookupValue.getText()
				&& !cmbDbcLookupValue.getText().toString().trim().equalsIgnoreCase("")) {
			fromValue = cmbDbcLookupValue.getText();
			opValue = opratorCombo.getText();
			wait = txtWait.getText();
			verification_flag = true;
		}

		if (null != txtName.getText() && !txtName.getText().toString().trim().equalsIgnoreCase("")
				&& (signalType == null || !signalType.getName().equals(txtName.getText()))) {
			signalType = DiagonosticModelFactory.eINSTANCE.createSignalType();
			signalType.setName(txtName.getText());
			title = txtName.getText();
			signalType.setType(SignalTypeEnum.UNDEFINED);
		}

		if (verification_flag) {
			super.okPressed();
		} else {

			MessageDialog.openWarning(Display.getDefault().getActiveShell(), "Warning",
					"Please fill all required fields");

		}
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

	public String getWait() {
		return wait;
	}

	public String getCombo() {
		return opValue;
	}

	public String getTxtValueFrom() {
		return fromValue;
	}

	public String getTxtValueTo() {
		return toValue;
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(490, 401);
	}

	@Override
	protected boolean isResizable() {
		// TODO Auto-generated method stub
		return true;
	}

}
