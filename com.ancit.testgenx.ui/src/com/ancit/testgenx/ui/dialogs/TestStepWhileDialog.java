package com.ancit.testgenx.ui.dialogs;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
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

import DiagonosticModel.DiagonosticModelFactory;
import DiagonosticModel.OperatorTypeEnum;
import DiagonosticModel.SignalType;
import DiagonosticModel.SignalTypeEnum;
import DiagonosticModel.TestSpecification;
import DiagonosticModel.WhileLoop;

public class TestStepWhileDialog extends TitleAreaDialog {

	private WhileLoop whileAction;
	private Button btnlookup;
	private Text txtName;
	private TestSpecification spec;

	private SignalType signalType;
	private Label lblOperator;
	private Combo combo;
	private Text txtValueFrom;
	private String opValue;
	private Text whileLooptitletxt;
	private String signalName;
	private String whileLoopTitle;
	private Text txtValueTo;
	private String fromValue;
	private String toValue;
	private Label lblValue2;
	private Label lblValue;
	private Composite valueComposite;
	private Composite dbcValueComposite;
	private Composite dbcLookupComposite;
	private Label lblLookupValue;
	private Combo cmbDbcLookupValue;

	public TestStepWhileDialog(Shell parentShell, TestSpecification spec, WhileLoop whileAction) {
		super(parentShell);
		this.spec = spec;
		this.whileAction = whileAction;
	}
	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("While Loop");
	}
	@Override
	public void create() {
		super.create();
		setTitle("TestSpecification While Loop");
		setMessage("Create while loop and fill required Details", IMessageProvider.INFORMATION);
	}

	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);

		Composite composite = new Composite(container, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		composite.setLayout(new GridLayout(3, false));

		Label whileLooptitlelbl = new Label(composite, SWT.NONE);
		whileLooptitlelbl.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		whileLooptitlelbl.setText("Title");

		whileLooptitletxt = new Text(composite, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		GridData gd_whileLooptitletxt = new GridData(SWT.FILL, SWT.CENTER, true, false);
		gd_whileLooptitletxt.horizontalSpan = 2;
		gd_whileLooptitletxt.widthHint = 304;
		whileLooptitletxt.setLayoutData(gd_whileLooptitletxt);

		Label lblName = new Label(composite, SWT.NONE);
		lblName.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		lblName.setText("Signal");

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
						Display.getDefault().getActiveShell(), spec,false);

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
						} else {
							for (String lookupValue : lookupValues) {
								cmbDbcLookupValue.add(lookupValue);
							}
							stackLayout.topControl = dbcLookupComposite;
							valueComposite.layout();
						}
						whileAction.setKey(signalType);
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
				"" + OperatorTypeEnum.NE, "" + OperatorTypeEnum.BT };
		combo = new Combo(composite, SWT.DROP_DOWN | SWT.READ_ONLY);
		combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		combo.setItems(operatorValue);

		valueComposite = new Composite(composite, SWT.NONE);
		valueComposite.setLayout(stackLayout);
		GridData gd_valueComposite = new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1);
		gd_valueComposite.widthHint = 64;
		valueComposite.setLayoutData(gd_valueComposite);

		dbcValueComposite = new Composite(valueComposite, SWT.NONE);
		dbcValueComposite.setLayout(new GridLayout(2, false));

		lblValue = new Label(dbcValueComposite, SWT.NONE);
		lblValue.setText("Value             ");

		txtValueFrom = new Text(dbcValueComposite, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		txtValueFrom.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		lblValue2 = new Label(dbcValueComposite, SWT.NONE);
		lblValue2.setText("Value To");

		lblValue2.setEnabled(false);

		txtValueTo = new Text(dbcValueComposite, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		txtValueTo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		txtValueTo.setText("");
		txtValueTo.setEnabled(false);

		dbcLookupComposite = new Composite(valueComposite, SWT.NONE);
		dbcLookupComposite.setLayout(new GridLayout(2, false));

		lblLookupValue = new Label(dbcLookupComposite, SWT.NONE);
		lblLookupValue.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblLookupValue.setText("Lookup Value");

		cmbDbcLookupValue = new Combo(dbcLookupComposite, SWT.NONE);
		cmbDbcLookupValue.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		combo.addSelectionListener(new SelectionAdapter() {
			public void widgetSelected(SelectionEvent e) {

				if (combo.getText().equals("between")) {

					lblValue.setText("Value From");
					lblValue2.setEnabled(true);
					txtValueTo.setEnabled(true);

				} else {
					lblValue2.setEnabled(false);
					txtValueTo.setEnabled(false);
				}

			}
		});

		if (whileAction != null && null != whileAction.getKey()) {
			// txtTitle.setText(action.getTitle() != null ? action.getTitle() : "");
			whileLooptitletxt.setText(String.valueOf(whileAction.getTitle()));
			txtName.setText(whileAction.getKey().getName());

			signalType = whileAction.getKey();

			EList<String> lookupValues = whileAction.getKey().getLookupValues();
			if (null != whileAction.getKey() && lookupValues.size() == 0) {

				stackLayout.topControl = dbcValueComposite;
				txtValueFrom.setText(whileAction.getValue() != null ? whileAction.getValue() : "");
				txtValueTo.setText(whileAction.getValueTo() != null ? whileAction.getValueTo() : "");
				valueComposite.layout();

			} else {
				for (String lookupValue : lookupValues) {
					cmbDbcLookupValue.add(lookupValue);
				}
				cmbDbcLookupValue.setText(whileAction.getValue());
				stackLayout.topControl = dbcLookupComposite;
				valueComposite.layout();
			}
			combo.setText(whileAction.getOperator().getLiteral());
		} else {
			whileAction = DiagonosticModelFactory.eINSTANCE.createWhileLoop();
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

		opValue = combo.getText();
		if (null != whileAction.getKey() && whileAction.getKey().getLookupValues().size() == 0) {
			fromValue = txtValueFrom.getText();
			toValue = txtValueTo.getText();
		} else {
			fromValue = cmbDbcLookupValue.getText();
		}

		whileLoopTitle = whileLooptitletxt.getText();

		System.out.println("check dialog text name =" + txtName.getText());
		if (signalType == null || !signalType.getName().equals(txtName.getText())) {
			signalType = DiagonosticModelFactory.eINSTANCE.createSignalType();
			signalType.setName(txtName.getText());
			signalName = txtName.getText();
			signalType.setType(SignalTypeEnum.UNDEFINED);
		}
		super.okPressed();
	}

	public SignalType getSignalType() {
		return signalType;
	}

	/**
	 * Return the initial size of the dialog.
	 */

	public String getSignalName() {
		return signalName;
	}

	public String getWhileLoopTitle() {
		return whileLoopTitle;
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
}
