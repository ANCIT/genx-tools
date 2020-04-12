package com.ancit.testgenx.ui.editors;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

public class SignalKeyDialog extends Dialog {

	public SignalKeyDialog(Shell parentShell) {
		super(parentShell);
		// TODO Auto-generated constructor stub
	}
	


	private String txtKeyValue;
	private Text textvalue;
	protected Control createContents(Composite parent) {

		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		composite.setLayout(new GridLayout(2, false));

		Label label = new Label(composite, SWT.NONE);
		label.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		label.setText("Key");

		textvalue = new Text(composite, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		textvalue.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		textvalue.setText("");
		
		Label label2 = new Label(composite, SWT.NONE);
		label2.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		label2.setText("Value");
		
		Text text = new Text(composite, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		text.setText("");
		
		
		
		return super.createContents(parent);
	}
	protected void okPressed() {
		
		txtKeyValue = textvalue.getText();
		super.okPressed();
	};
	public String getTxtKeyValue() {
		return txtKeyValue;
	}
	


}
