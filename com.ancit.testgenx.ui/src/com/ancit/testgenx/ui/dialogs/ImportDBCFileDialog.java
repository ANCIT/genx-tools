package com.ancit.testgenx.ui.dialogs;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.ancit.testgenx.ui.utils.CommonUtils;

public class ImportDBCFileDialog extends TitleAreaDialog {

	private Text dbcfiletxt;
	private Button dbcfilebrowsebtn;
	private String dbcFilePath;
	private SelectionListener selectionListener;
	private Button button;

	private String selectedDBCFile;
	private String mainImportFile;
	private String selectedXMLFile;

	/**
	 * Create the dialog.
	 * 
	 * @param parentShell
	 * @param spec
	 */
	public ImportDBCFileDialog(Shell parentShell) {
		super(parentShell);
	}
	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Import");
	}
	@Override
	public void create() {
		super.create();
		setTitle("Import database Files");
		setMessage("Check import database File (*.dbc) details ", IMessageProvider.INFORMATION);
	}

	@Override
	protected boolean isResizable() {
		return true;
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

		Group buttonGroup = new Group(composite, SWT.NONE);
		GridLayout gridLayout = new GridLayout();
		gridLayout.numColumns = 4;
		buttonGroup.setLayout(gridLayout);
		buttonGroup.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1));

		selectionListener = new SelectionAdapter() {

			public void widgetSelected(SelectionEvent event) {
				button = ((Button) event.widget);
			};
		};
		
				Button btnDBC = new Button(buttonGroup, SWT.RADIO);
				btnDBC.setText("DBC");
				btnDBC.addSelectionListener(selectionListener);

//		Button btnXML = new Button(compositeGroup, SWT.RADIO);
//		btnXML.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
//		btnXML.setText("SysVar");
//		btnXML.addSelectionListener(selectionListener);
//
//		Button btnA2L = new Button(compositeGroup, SWT.RADIO);
//		btnA2L.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
//		btnA2L.setText("A2L");
//		new Label(compositeGroup, SWT.NONE);
//		btnA2L.addSelectionListener(selectionListener);

//		Button btnArxml = new Button(compositeGroup, SWT.RADIO);
//		btnArxml.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
//		btnArxml.setText("ARXML");
//		btnArxml.addSelectionListener(selectionListener);

		Label lblName = new Label(buttonGroup, SWT.NONE);
		lblName.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		lblName.setText("File Path:");

		dbcfiletxt = new Text(buttonGroup, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		dbcfiletxt.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		dbcfiletxt.setText("");
		dbcfiletxt.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				File file = new File(dbcfiletxt.getText());
				if (file.exists()) {
					getButton(IDialogConstants.OK_ID).setEnabled(true);
				} else {
					getButton(IDialogConstants.OK_ID).setEnabled(false);
				}
			}
		});

		dbcfilebrowsebtn = new Button(buttonGroup, SWT.PUSH);
		dbcfilebrowsebtn.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		dbcfilebrowsebtn.setText("Browse");
		dbcfilebrowsebtn.addSelectionListener(new SelectionAdapter() {

			@Override
			public void widgetSelected(SelectionEvent e) {

				if (button.getText() == "DBC" && button.getSelection()) {

					FileDialog fd1 = new FileDialog(Display.getDefault().getActiveShell(), SWT.OPEN);
					fd1.setText("Import text");
					fd1.setFilterExtensions(new String[] { "*.dbc;*.DBC" });
					selectedDBCFile = fd1.open();
					if (selectedDBCFile != null) {

						dbcfiletxt.setText(selectedDBCFile);
					}
					setMainImportFile(null);
				} else if (button.getText() == "A2L" && button.getSelection()) {
					FileDialog fileXML = new FileDialog(Display.getDefault().getActiveShell(), SWT.SAVE);
					fileXML.setText("Import text");
					fileXML.setFilterExtensions(new String[] { "*.a2l" });
					selectedXMLFile = fileXML.open();
					if (selectedXMLFile != null) {

						dbcfiletxt.setText(selectedXMLFile);
					}
					setMainImportFile(null);
				} else if (button.getText() == "SysVar" && button.getSelection()) {

					FileDialog fileXML = new FileDialog(Display.getDefault().getActiveShell(), SWT.SAVE);
					fileXML.setText("Import text");
					fileXML.setFilterExtensions(new String[] { "*.xml;*.XML" });
					selectedXMLFile = fileXML.open();
					if (selectedXMLFile != null) {

						dbcfiletxt.setText(selectedXMLFile);
					}
					setMainImportFile(null);
				} else if (button.getText() == "ARXML" && button.getSelection()) {

					FileDialog fileXML = new FileDialog(Display.getDefault().getActiveShell(), SWT.SAVE);
					fileXML.setText("Import text");
					fileXML.setFilterExtensions(new String[] { "*.arxml" });

					selectedXMLFile = fileXML.open();
					if (selectedXMLFile != null) {

						try {
							File tmpDBCFile = new File(
									CommonUtils.generateTempFolder()  + File.separator + "tmpDBCFile.dbc");
							if (tmpDBCFile.exists()) {
								tmpDBCFile.delete();
							}
							convertIntoDBCFormat(selectedXMLFile, tmpDBCFile.getAbsolutePath());
							String path = tmpDBCFile.getAbsolutePath();
							path = path.replace(".dbc", "_CAN.dbc");
							dbcfiletxt.setText(selectedXMLFile);
							setMainImportFile(path);
						} catch (Exception e1) {
							// TODO: handle exception
							System.err.println("Error : " + e1.getMessage());
						}
					}

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

		if (null != dbcfiletxt.getText() && !dbcfiletxt.getText().trim().equalsIgnoreCase("")) {
				setDbcFilePath(dbcfiletxt.getText());
//				setMainImportFile(selectedXMLFile);
		}

		super.okPressed();
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(550, 370);
	}

	public void setTxtName(Text txtName) {
		this.dbcfiletxt = txtName;
	}

	public String getDbcFilePath() {
		return dbcFilePath;
	}

	public void setDbcFilePath(String dbcFilePath) {
		this.dbcFilePath = dbcFilePath;
	}

	private void convertIntoDBCFormat(String dbcSource, String dbcTarget) {

		ProcessBuilder processBuilder = new ProcessBuilder();

		// Run this on Windows, cmd, /c = terminate after this run
		processBuilder.command("cmd.exe", "/c",
				"python -m canmatrix.cli.convert \"" + dbcSource + "\" \"" + dbcTarget + "\"");

		try {

			Process process = processBuilder.start();

			// blocked :(
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}

			int exitCode = process.waitFor();
			System.out.println("\nExited with error code : " + exitCode);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public String getMainImportFile() {
		return mainImportFile;
	}

	public void setMainImportFile(String mainImportFile) {
		this.mainImportFile = mainImportFile;
	}

}
