package com.ancit.testgenx.ui.dialogs;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StackLayout;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
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

import DiagonosticModel.DiagonosticModelFactory;
import DiagonosticModel.ForLoop;
import DiagonosticModel.SetAction;
import DiagonosticModel.SignalType;
import DiagonosticModel.TestSpecification;
import org.eclipse.wb.swt.SWTResourceManager;

public class TestStepSetDialog extends TitleAreaDialog {

	private Text txtName;
	private Button btnlookup;
	private TestSpecification spec;
	private SignalType signalType;
	private String txtSetValue;
	private SetAction setActionObj;
	private Text txtWait;
	private Text txtTitle;
	private String title;
	private String wait;
	private Combo waitTimeCombo;
	private Button btnRange;
	private Label lblValueTo;
	private Label lblValueFrom;
	private Text txtValueTo;
	private Text txtValueFrom;
	private String valueFrom;
	private String valueTo;
	private Composite contentComposite;
	private Composite dbcValueComposite;
	private Composite dbcLookUpComposite;
	private Label lblLookUpValue;
	private Combo cmbLookUpValue;
	private Button button_Ok;
	private ControlDecoration txtNameControlDecoration;
	private Button btnforloopSysVar;
	private boolean loopFlag;
	private String tmpLoopVar;
	private boolean sysFromloop = false;

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Set Action");
	}

	/**
	 * Create the dialog.
	 * 
	 * @param parentShell
	 * @param loopFlag
	 * @param spec2
	 */

	public TestStepSetDialog(Shell parentShell, TestSpecification spec, Object action, boolean loopFlag) {
		super(parentShell);
		this.spec = spec;
		if (action instanceof SetAction) {
			SetAction tmpActinobj = (SetAction) action;
			this.setActionObj = tmpActinobj;
			if (null != action && null != this.setActionObj.eContainer()) {
				EObject eContainer = this.setActionObj.eContainer();
				if (eContainer instanceof ForLoop) {
					ForLoop loopvar = (ForLoop) eContainer;
					tmpLoopVar = loopvar.getLoopVar();
				}
			}
		} else if (action instanceof ForLoop) {
			ForLoop tmpObj = (ForLoop) action;
			tmpLoopVar = tmpObj.getLoopVar();
		}
		this.loopFlag = loopFlag;

	}

	@Override
	public void create() {
		super.create();
		setTitle("TestStep Set Action");
		setMessage("Fill required set action details", IMessageProvider.INFORMATION);
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

		// Label lblTitle = new Label(composite, SWT.NONE);
		// lblTitle.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false,
		// false));
		// lblTitle.setText("Title");
		//
		// txtTitle = new Text(composite, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		// txtTitle.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2,
		// 1));
		// txtTitle.setText("");

		// Label lblWait = new Label(composite, SWT.NONE);
		// lblWait.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		// lblWait.setText("Wait");
		//
		// txtWait = new Text(composite, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		// GridData gd_txtWait = new GridData(SWT.FILL, SWT.CENTER, true, false);
		// gd_txtWait.widthHint = 313;
		// txtWait.setLayoutData(gd_txtWait);
		// txtWait.setText("0");
		//
		// waitTimeCombo = new Combo(composite, SWT.DROP_DOWN | SWT.READ_ONLY);
		// GridData gd_waitTimeCombo = new GridData(SWT.BEGINNING, SWT.END, true,
		// false);
		// gd_waitTimeCombo.widthHint = 63;
		// waitTimeCombo.setLayoutData(gd_waitTimeCombo);
		// waitTimeCombo.setItems(new String[] { "ms", "sec" });
		// waitTimeCombo.setText("ms");

		Label lblName = new Label(composite, SWT.NONE);
		lblName.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		lblName.setText("Signal *");

		txtName = new Text(composite, SWT.SINGLE | SWT.LEAD | SWT.BORDER | SWT.READ_ONLY);
		txtName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		txtName.setText("");

		StackLayout stackLayout = new StackLayout();

		btnlookup = new Button(composite, SWT.PUSH);
		btnlookup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false));
		btnlookup.setText("Look Up");
		btnlookup.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				LookupElementListSelectionDialog viewObject = new LookupElementListSelectionDialog(
						Display.getDefault().getActiveShell(), spec, false);

				int open = viewObject.open();

				if (IDialogConstants.OK_ID == open) {
					if (null != viewObject.getSignalType()) {
						signalType = ((SignalType) viewObject.getSignalType());
						txtName.setText(signalType.getName());
						EList<String> lookupValues = signalType.getLookupValues();
						if (lookupValues.size() == 0) {
							stackLayout.topControl = dbcValueComposite;
							contentComposite.layout();
							if (!txtValueFrom.getText().isEmpty()) {
								txtNameControlDecoration.hide();
							} else {
								txtNameControlDecoration.show();
								// txtNameControlDecoration.showHoverText("From value cannot be Empty");
							}
						} else {
							for (String lookupValue : lookupValues) {
								cmbLookUpValue.add(lookupValue);
							}
							stackLayout.topControl = dbcLookUpComposite;
							contentComposite.layout();
						}
						setActionObj.setKey(signalType);
					} else {
						txtName.setText("");
					}
				}
			}
		});
		new Label(composite, SWT.NONE);
		if (loopFlag) {
			btnforloopSysVar = new Button(composite, SWT.CHECK);
			btnforloopSysVar.setText("Use Forloop System Variable");
			new Label(composite, SWT.NONE);
		}
		contentComposite = new Composite(composite, SWT.NONE);
		contentComposite.setLayout(stackLayout);
		contentComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1));

		dbcValueComposite = new Composite(contentComposite, SWT.NONE);
		dbcValueComposite.setLayout(new GridLayout(2, false));

		// Label lblRange = new Label(dbcValueComposite, SWT.NONE);
		// lblRange.setText("Range");
		//
		// btnRange = new Button(dbcValueComposite, SWT.CHECK);
		// btnRange.setText("");

		lblValueFrom = new Label(dbcValueComposite, SWT.NONE);
		lblValueFrom.setText("Value                        ");

		txtValueFrom = new Text(dbcValueComposite, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		txtValueFrom.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		if (null != btnforloopSysVar && loopFlag) {
			btnforloopSysVar.addSelectionListener(new SelectionAdapter() {

				@Override
				public void widgetSelected(SelectionEvent event) {
					Button btn = (Button) event.getSource();
					if (btn.getSelection() && null != tmpLoopVar) {
						txtValueFrom.setEnabled(false);
						txtValueFrom.setText(tmpLoopVar);
						sysFromloop = true;
					} else {
						txtValueFrom.setEnabled(true);
						txtValueFrom.setText("");
						sysFromloop = false;
					}
				}
			});
		}

		txtNameControlDecoration = new ControlDecoration(txtValueFrom, SWT.LEFT | SWT.TOP);
		// txtNameControlDecoration.setDescriptionText("Test Group Name cannot be
		// Empty");
		txtNameControlDecoration
				.setImage(PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_DEC_FIELD_ERROR));
		txtNameControlDecoration.hide();

		txtValueFrom.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void focusGained(FocusEvent e) {

				if (!txtValueFrom.getText().isEmpty()) {
					setActionObj.setValue(txtValueFrom.getText());
					txtNameControlDecoration.hide();
				} else {
					setActionObj.setValue("");
					txtNameControlDecoration.show();
					txtNameControlDecoration.showHoverText("From value cannot be Empty");
				}

			}
		});

		txtValueFrom.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				if (!txtValueFrom.getText().isEmpty()) {
					setActionObj.setValue(txtValueFrom.getText());
					txtNameControlDecoration.hide();
				} else {
					setActionObj.setValue("");
					txtNameControlDecoration.show();
					txtNameControlDecoration.showHoverText("From value cannot be Empty");
				}

			}
		});

		// lblValueTo = new Label(dbcValueComposite, SWT.NONE);
		// lblValueTo.setText("Value To");
		// lblValueTo.setEnabled(false);
		//
		// txtValueTo = new Text(dbcValueComposite, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		// txtValueTo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1,
		// 1));
		// txtValueTo.setText("");
		// txtValueTo.setEnabled(false);
		//
		// btnRange.addSelectionListener(new SelectionAdapter() {
		// @Override
		// public void widgetSelected(SelectionEvent e) {
		//
		// if (btnRange.getSelection()) {
		//
		// lblValueFrom.setText("Value From");
		// lblValueTo.setEnabled(true);
		// txtValueTo.setEnabled(true);
		//
		// } else {
		// lblValueTo.setEnabled(false);
		// txtValueTo.setEnabled(false);
		// }
		// }
		// });

		dbcLookUpComposite = new Composite(contentComposite, SWT.NONE);
		dbcLookUpComposite.setLayout(new GridLayout(2, false));

		lblLookUpValue = new Label(dbcLookUpComposite, SWT.NONE);
		lblLookUpValue.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblLookUpValue.setText("Look Up Value");

		cmbLookUpValue = new Combo(dbcLookUpComposite, SWT.NONE | SWT.READ_ONLY);
		cmbLookUpValue.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		if (setActionObj != null) {

			// txtTitle.setText(action.getTitle() != null ? action.getTitle() : "");
			// txtWait.setText(String.valueOf(setActionObj.getWait()));
			txtName.setText(setActionObj.getKey().getName() != null ? setActionObj.getKey().getName() : "");
			signalType = setActionObj.getKey();

			EList<String> lookupValues = setActionObj.getKey().getLookupValues();
			if (lookupValues.size() == 0) {
				stackLayout.topControl = dbcValueComposite;
				txtValueFrom.setText(setActionObj.getValue() != null ? setActionObj.getValue() : "");
				// txtValueTo.setText(setActionObj.getValueTo() != null ?
				// setActionObj.getValueTo() : "");
				contentComposite.layout();

			} else {
				for (String lookupValue : lookupValues) {
					cmbLookUpValue.add(lookupValue);
				}
				cmbLookUpValue.setText(setActionObj.getValue());
				cmbLookUpValue.select(0);
				stackLayout.topControl = dbcLookUpComposite;
				contentComposite.layout();
			}

		} else {
			setActionObj = DiagonosticModelFactory.eINSTANCE.createSetAction();
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
		button_Ok = createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		// button_Ok.setEnabled(false);
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
	}

	@Override
	protected void okPressed() {
		boolean flag = false;
		if (null != setActionObj.getKey() && null != setActionObj.getKey().getLookupValues()
				&& setActionObj.getKey().getLookupValues().size() == 0 && null != txtValueFrom.getText()
				&& !txtValueFrom.getText().toString().trim().equalsIgnoreCase("")) {
			valueFrom = txtValueFrom.getText();
			// if (null != txtValueTo.getText()) {
			// valueTo = txtValueTo.getText();
			// }
			flag = true;
			// wait = txtWait.getText();
		} else if (null != cmbLookUpValue.getText() && !cmbLookUpValue.getText().trim().equalsIgnoreCase("")) {
			// && null != txtWait.getText() &&
			// !txtWait.getText().toString().trim().equalsIgnoreCase("")) {
			if (sysFromloop) {
				valueFrom = tmpLoopVar;
			} else {
				valueFrom = cmbLookUpValue.getText();
			}

			flag = true;
			// wait = txtWait.getText();
		}

		if (flag) {
			super.okPressed();
		} else {

			MessageDialog.openWarning(Display.getDefault().getActiveShell(), "Warning",
					"Please fill all required fields");

		}
	}

	public String getTitle() {
		return title;
	}

	public String getWait() {
		return wait;
	}

	public SignalType getSignalType() {
		return signalType;
	}

	public String getTxtSetValue() {
		return txtSetValue;
	}

	public String getValueFrom() {
		return valueFrom;
	}

	public String getValueTo() {
		return valueTo;
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(479, 396);
	}

	@Override
	protected boolean isResizable() {
		// TODO Auto-generated method stub
		return true;
	}

}
