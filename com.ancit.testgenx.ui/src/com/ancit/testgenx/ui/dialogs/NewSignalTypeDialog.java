package com.ancit.testgenx.ui.dialogs;

import java.util.List;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import DiagonosticModel.CreationModeEnum;
import DiagonosticModel.DiagonosticModelFactory;
import DiagonosticModel.SignalType;
import DiagonosticModel.SignalTypeEnum;
import DiagonosticModel.TestSpecification;

public class NewSignalTypeDialog extends TitleAreaDialog {

	private Combo txtSignalType;
	private Text txtsignalName;
	private SignalType signalType;
	private String name;
	private String type;
	private Combo comboCrtMode;
	private Text txtsysVarNamespace;

	public NewSignalTypeDialog(Shell parentShell, TestSpecification testSpecification) {
		super(parentShell);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Signal");
	}
	@Override
	public void create() {
		super.create();
		setTitle("Create Signal ");
		setMessage("Create new signal and fill required details ", IMessageProvider.INFORMATION);
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

		Label lblsignalName = new Label(composite, SWT.NONE);
		lblsignalName.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		lblsignalName.setText("Signal Name");

		txtsignalName = new Text(composite, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		txtsignalName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		txtsignalName.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				Text signalName = (Text) e.getSource();
				if (!signalName.getText().isEmpty() && !txtSignalType.getText().isEmpty()) {
					getButton(IDialogConstants.OK_ID).setEnabled(true);
				} else {
					getButton(IDialogConstants.OK_ID).setEnabled(false);
				}

			}
		});

		Label lblSignalType = new Label(composite, SWT.NONE);
		lblSignalType.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		lblSignalType.setText("Type");

		txtSignalType = new Combo(composite, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		GridData gd_txtWait = new GridData(SWT.FILL, SWT.CENTER, true, false);
		txtSignalType.setLayoutData(gd_txtWait);
		List<SignalTypeEnum> values = SignalTypeEnum.VALUES;
		for (SignalTypeEnum signalTypeEnum : values) {
			if (!signalTypeEnum.equals(SignalTypeEnum.SIGNAL)) {
				txtSignalType.add(signalTypeEnum.getName());
			}
		}

		txtSignalType.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				if (!txtSignalType.getText().isEmpty() && !txtsignalName.getText().isEmpty()) {
					getButton(IDialogConstants.OK_ID).setEnabled(true);
				}
				if (txtSignalType.getText().equals(SignalTypeEnum.SYSTEM.getLiteral())) {
					txtsysVarNamespace.setEnabled(true);
				} else {
					txtsysVarNamespace.setEnabled(false);
				}
			}
		});

		Label lblCrtMode = new Label(composite, SWT.NONE);
		lblCrtMode.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		lblCrtMode.setText("Creation Mode");

		comboCrtMode = new Combo(composite, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		GridData gd_txtCrtMode = new GridData(SWT.FILL, SWT.CENTER, true, false);
		comboCrtMode.setLayoutData(gd_txtCrtMode);
		List<CreationModeEnum> crtModeValues = CreationModeEnum.VALUES;
		for (CreationModeEnum creationModeEnum : crtModeValues) {
			comboCrtMode.add(creationModeEnum.getName());
		}
		comboCrtMode.select(1);
		comboCrtMode.setEnabled(false);

		Label lblNamesapce = new Label(composite, SWT.NONE);
		lblNamesapce.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		lblNamesapce.setText("Namesapce");

		txtsysVarNamespace = new Text(composite, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		txtsysVarNamespace.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		txtsysVarNamespace.setEnabled(false);
		/*
		 * if (action != null) { txtsignalName.setText(action.getTitle() != null ?
		 * action.getTitle() : "");
		 * txtSignalType.setText(String.valueOf(action.getWait()));
		 * txtName.setText(action.getKey().getName());
		 * txtValue.setText(action.getValue() != null ? action.getValue() : "");
		 * combo.setText(action.getOperator().getLiteral()); }
		 */

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

		name = txtsignalName.getText();
		type = txtSignalType.getText();
		String creationMode = comboCrtMode.getText();

		if (signalType == null || !signalType.getName().equals(txtsignalName.getText())) {
			signalType = DiagonosticModelFactory.eINSTANCE.createSignalType();
			signalType.setName(txtsignalName.getText());
			signalType.setType(SignalTypeEnum.getByName(type));
			signalType.setCreationMode(CreationModeEnum.get(creationMode));
			if (!txtsysVarNamespace.getText().isEmpty()) {
				signalType.setNamespace(txtsysVarNamespace.getText());
			}
		}
		super.okPressed();
	}

	public SignalType getSignalType() {
		return signalType;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(450, 372);
	}

}
