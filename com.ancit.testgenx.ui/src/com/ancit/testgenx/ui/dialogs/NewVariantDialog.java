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

import DiagonosticModel.DiagonosticModelFactory;
import DiagonosticModel.Variant;

public class NewVariantDialog extends TitleAreaDialog {

	private Text txtName;
	private Text txtDesc;
	private Variant variant;

	public NewVariantDialog(Shell parentShell) {
		super(parentShell);

		// TODO Auto-generated constructor stub
	}

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Variants");
	}
	
	@Override
	public void create() {
		super.create();
		setTitle("New variant");
		setMessage("Create new variant and fill required Details", IMessageProvider.INFORMATION);
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

		Label lblsignalName = new Label(composite, SWT.NONE);
		lblsignalName.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		lblsignalName.setText("Name");

		ModifyListener listener = new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				Text txt = (Text) e.getSource();
				if (!txt.getText().isEmpty()) {
					getButton(IDialogConstants.OK_ID).setEnabled(true);
				} else {
					getButton(IDialogConstants.OK_ID).setEnabled(false);
				}

			}
		};

		txtName = new Text(composite, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		txtName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));
		txtName.addModifyListener(listener);

		Label lblSignalType = new Label(composite, SWT.NONE);
		lblSignalType.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		lblSignalType.setText("Description");

		txtDesc = new Text(composite, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		txtDesc.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 2, 1));

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

		String name = txtName.getText();
		String desc = txtDesc.getText();

		if (name != null || desc != null) {
			variant = DiagonosticModelFactory.eINSTANCE.createVariant();
			variant.setName(name);
			variant.setDescription(desc);
		}
		super.okPressed();
	}

	public Variant getVariant() {
		return variant;
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(450, 372);
	}

}
