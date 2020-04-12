package com.ancit.testgenx.ui.dialogs;

import java.util.HashMap;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import com.ancit.testgenx.ui.extnpt.ITSEExport;

import DiagonosticModel.TestGroup;
import DiagonosticModel.TestSpecification;

public class TSEExportDialog extends TitleAreaDialog {

	HashMap<String, ITSEExport> tseExportMap = new HashMap<String, ITSEExport>();
	private Combo cmbExportFormat;
	private ITSEExport exporter;
	private Text descripriontxt;
	private TestSpecification testSpecification;

	/**
	 * Create the dialog.
	 * 
	 * @param parentShell
	 * @param testSpecification
	 */
	public TSEExportDialog(Shell parentShell, TestSpecification testSpecification) {
		super(parentShell);
		this.testSpecification = testSpecification;
	}

	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Export");
	}
	
	/**
	 * Create contents of the dialog.
	 * 
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		setMessage("Select the format to export Test Specification");
		setTitle("Export Test Specification");
		Composite area = (Composite) super.createDialogArea(parent);
		Composite container = new Composite(area, SWT.NONE);
		container.setLayout(new GridLayout(2, false));
		container.setLayoutData(new GridData(GridData.FILL_BOTH));

		Label lblExportFormat = new Label(container, SWT.NONE);
		lblExportFormat.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblExportFormat.setText("Export Format : ");

		cmbExportFormat = new Combo(container, SWT.NONE | SWT.READ_ONLY);
		cmbExportFormat.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));

		Label lblDescription = new Label(container, SWT.NONE);
		GridData gd_lblDescription = new GridData(SWT.LEFT, SWT.TOP, false, false, 1, 1);
		gd_lblDescription.heightHint = 23;
		lblDescription.setLayoutData(gd_lblDescription);
		lblDescription.setText("Description : ");

		descripriontxt = new Text(container, SWT.BORDER | SWT.MULTI | SWT.READ_ONLY);
		GridData gd_descripriontxt = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);
		gd_descripriontxt.heightHint = 112;
		descripriontxt.setLayoutData(gd_descripriontxt);

		IExtensionRegistry extensionRegistry = Platform.getExtensionRegistry();

		IConfigurationElement[] configurationElementsFor = extensionRegistry
				.getConfigurationElementsFor("com.ancit.diagnostictool.ui.exports");
		for (IConfigurationElement iConfigurationElement : configurationElementsFor) {
			String id = iConfigurationElement.getAttribute("id");
			String name = iConfigurationElement.getAttribute("name");
			String description = iConfigurationElement.getAttribute("description");
			try {
				ITSEExport tseExport = (ITSEExport) iConfigurationElement.createExecutableExtension("implementation");
				tseExportMap.put(name, tseExport);
				System.out.println("Desc :" + description);
			} catch (CoreException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// desObj.put(name, description);
			cmbExportFormat.add(name);
			cmbExportFormat.setData(name, description);
		}
		cmbExportFormat.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {
				descripriontxt.setText("");
				int idx = cmbExportFormat.getSelectionIndex();
				String selectedOrg = cmbExportFormat.getItem(idx);
				if (null != cmbExportFormat.getData(selectedOrg)) {
					String string = cmbExportFormat.getData(selectedOrg).toString();
					descripriontxt.setText(string);
				}
			}
		});

		return area;
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
		boolean foundCase = false;
		String txtExportType = cmbExportFormat.getText();
		exporter = tseExportMap.get(txtExportType);
		System.out.println("");
		EList<TestGroup> testGroups = testSpecification.getTestGroups();
		for (TestGroup testGroup : testGroups) {
			if (testGroup.getTestCases().size() > 0) {
				foundCase = true;
			}
		}
		if (txtExportType.equalsIgnoreCase("PyCAN") && !foundCase) {

			MessageDialog.openError(Display.getDefault().getActiveShell(), "Error - Generation",
					"Please add one testcase !");
			return;

		}
		super.okPressed();

	}

	public ITSEExport getExporter() {
		return exporter;
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(480, 355);
	}
}
