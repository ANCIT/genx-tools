package com.ancit.testgenx.exports.pycan;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
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
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import DiagonosticModel.ImportArtifact;
import DiagonosticModel.SignalType;
import DiagonosticModel.TestSpecification;
import DiagonosticModel.WaitAction;
import org.eclipse.swt.widgets.Button;

public class HardwareSelectionForPythonCodeDialog extends TitleAreaDialog {
	private String[] pcanList = new String[] { "socketcan","pcan", "vector" };
	private String[] baudrateList = new String[] { "1 MBit/sec", "800 kBit/sec", "500 kBit/sec", "250 kBit/sec",
			"125 kBit/sec", "100 kBit/sec", "95238 kBit/sec", "20000 kBit/sec", "83333 kBit/sec", "50 kBit/sec" };
	private String[] canappNamelList = new String[] { "CANalyzer", "CANoe" };
	private String[] pcanChannelList = new String[] { "PCAN_USBBUS1", "PCAN_USBBUS2", "PCAN_USBBUS3", "PCAN_USBBUS4",
			"PCAN_USBBUS5", "PCAN_USBBUS6", "PCAN_USBBUS7", "PCAN_USBBUS8", "PCAN_USBBUS9", "PCAN_USBBUS10",
			"PCAN_USBBUS11", "PCAN_USBBUS12", "PCAN_USBBUS13", "PCAN_USBBUS14", "PCAN_USBBUS15", "PCAN_USBBUS16" };
	private String[] vectorCanChannelList = new String[] { "CAN-0", "CAN-1" };
	private String[] socketCanChannelList = new String[] { "can0", "can1" };
	private Combo appnamecombo;
	private Combo baudratecombo;
	private Combo channelcombo;
	private TestSpecification spec;
	private SignalType signalType;
	private String txtTimeVAlue;
	private Combo hardwarecombo;
	private String times;
	private Text reportlocationtxt;
	private String hardwareConfigration;
	private Button btnHtmlReport;
	private String locationPath;
	private boolean xmlFlag;
	private boolean htmlFlag;
	private String fileName;
	private Set<String> nodes_Set = new HashSet<String>();
	private Combo nodescombo;
	private String selectedNode;
	private Label lblNode;
	private Button btnRunOnPython;
	private boolean runPython;

	/**
	 * Create the dialog.
	 * 
	 * @param parentShell
	 * @param spec2
	 */
	public HardwareSelectionForPythonCodeDialog(Shell parentShell, TestSpecification spec2, WaitAction action) {
		super(parentShell);
		this.spec = spec2;
	}

	@Override
	public void create() {
		super.create();
		setTitle("Hardware setting for generate python script for generate report.");
		setMessage("Configure Hardware setting", IMessageProvider.INFORMATION);
	}

	/**
	 * Create contents of the dialog.
	 * 
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		EList<ImportArtifact> importArtifacts = spec.getImportArtifacts();
		for (ImportArtifact importArtifact : importArtifacts) {
			if (!importArtifact.getPath().equals("USERDEFINED") && importArtifact.getPath().endsWith(".dbc")) {
				for (SignalType signalObj : importArtifact.getSignalType()) {
					if (signalObj.getNode() != null) {
						nodes_Set.add(signalObj.getNode());
					}
				}
			}
		}
		System.out.println(spec.getImportArtifacts().get(0).getSignalType());
		Composite container = (Composite) super.createDialogArea(parent);

		Composite composite = new Composite(container, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		composite.setLayout(new GridLayout(5, false));
		new Label(composite, SWT.NONE);

		Label lblName = new Label(composite, SWT.NONE);
		GridData gd_lblName = new GridData(SWT.LEFT, SWT.CENTER, false, false);
		gd_lblName.widthHint = 73;
		lblName.setLayoutData(gd_lblName);
		lblName.setText("Bus Type :");

		Label lblappname = new Label(composite, SWT.NONE);
		lblappname.setText("App Name :");

		Label lblNewLabel = new Label(composite, SWT.NONE);
		lblNewLabel.setText("Bitrate :");

		Label lblNewLabel_1 = new Label(composite, SWT.NONE);
		lblNewLabel_1.setText("Channel :");
		new Label(composite, SWT.NONE);
		// txtTime.setText("");

		hardwarecombo = new Combo(composite, SWT.DROP_DOWN | SWT.READ_ONLY);
		GridData gd_hardwarecombo = new GridData(SWT.FILL, SWT.END, false, false);
		gd_hardwarecombo.widthHint = 99;
		hardwarecombo.setLayoutData(gd_hardwarecombo);
		hardwarecombo.setItems(pcanList);
		hardwarecombo.select(0);
		hardwarecombo.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {

				String selectedItem = hardwarecombo.getItem(hardwarecombo.getSelectionIndex());
				if (selectedItem.equalsIgnoreCase("Pcan")) {
					channelcombo.setItems(pcanChannelList);
					channelcombo.select(0);
					appnamecombo.setEnabled(false);
				} else if (selectedItem.equalsIgnoreCase("Vector")) {
					channelcombo.setItems(vectorCanChannelList);
					channelcombo.select(0);
					appnamecombo.setEnabled(true);
					appnamecombo.setItems(canappNamelList);
					appnamecombo.select(0);
				} else if (selectedItem.equalsIgnoreCase("SocketCan")) {
					channelcombo.setItems(socketCanChannelList);
					channelcombo.select(0);
					appnamecombo.setEnabled(false);
				}
			}
		});

		appnamecombo = new Combo(composite, SWT.NONE | SWT.READ_ONLY);
		GridData gd_appnamecombo = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_appnamecombo.widthHint = 129;
		appnamecombo.setLayoutData(gd_appnamecombo);
		appnamecombo.setEnabled(false);

		baudratecombo = new Combo(composite, SWT.NONE | SWT.READ_ONLY);
		GridData gd_baudratecombo = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_baudratecombo.widthHint = 241;
		baudratecombo.setLayoutData(gd_baudratecombo);
		baudratecombo.setItems(baudrateList);
		baudratecombo.select(0);

		channelcombo = new Combo(composite, SWT.NONE | SWT.READ_ONLY);
		GridData gd_combo = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_combo.widthHint = 160;
		channelcombo.setLayoutData(gd_combo);
		channelcombo.setItems(socketCanChannelList);
		channelcombo.select(0);

		String[] nodesList = Arrays.copyOf(nodes_Set.toArray(), nodes_Set.size(), String[].class);
		new Label(composite, SWT.NONE);

		lblNode = new Label(composite, SWT.NONE);
		lblNode.setText("Node : ");
		btnHtmlReport = new Button(composite, SWT.CHECK);
		btnHtmlReport.setText("HTML Report");
		btnHtmlReport.setSelection(true);

		Label lblReportLocation = new Label(composite, SWT.NONE);
		lblReportLocation.setText("File Location :");
		new Label(composite, SWT.NONE);
		new Label(composite, SWT.NONE);

		nodescombo = new Combo(composite, SWT.NONE | SWT.READ_ONLY);
		GridData gd_nodescombo = new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1);
		gd_nodescombo.widthHint = 148;
		nodescombo.setLayoutData(gd_nodescombo);
		nodescombo.setItems(nodesList);
		nodescombo.select(0);
		
		btnRunOnPython = new Button(composite, SWT.CHECK);
		btnRunOnPython.setText("Run on Python Shell");

		reportlocationtxt = new Text(composite, SWT.BORDER | SWT.READ_ONLY);
		GridData gd_reportlocationtxt = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
		gd_reportlocationtxt.widthHint = 275;
		reportlocationtxt.setLayoutData(gd_reportlocationtxt);

		Button btnBrowse = new Button(composite, SWT.NONE);
		GridData gd_btnBrowse = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		gd_btnBrowse.widthHint = 95;
		btnBrowse.setLayoutData(gd_btnBrowse);
		btnBrowse.setText("Browse");

		btnBrowse.addListener(SWT.Selection, new Listener() {

			private String reportfilePath;

			@Override
			public void handleEvent(Event event) {
				// TODO Auto-generated method stub
				DirectoryDialog fileDialog = new DirectoryDialog(Display.getDefault().getActiveShell());
//				fileDialog.setFilterExtensions(new String[] { "*.*" });
//				fileDialog.setOverwrite(true);
				reportfilePath = fileDialog.open();
				if (reportfilePath != null) {
					String version = spec.getVersion() == null ? "" : spec.getVersion();
					fileName = spec.getName()+"_"+version;
					reportlocationtxt.setText(reportfilePath);
					validation();
				}
			}
		});

		return container;
	}

	private String getHardwareConfigration() {
		StringBuffer comboContent = new StringBuffer();

		if (hardwarecombo.getItems().length > 0 && hardwarecombo.getSelectionIndex() >= 0
				&& null != hardwarecombo.getItem(hardwarecombo.getSelectionIndex())) {

			comboContent.append("bustype='" + hardwarecombo.getItem(hardwarecombo.getSelectionIndex()) + "',");
		} else {
			comboContent.append("bustype='',");
		}

		if (appnamecombo.isEnabled()) {
			if (appnamecombo.getItems().length > 0 && appnamecombo.getSelectionIndex() >= 0
					&& null != appnamecombo.getItem(appnamecombo.getSelectionIndex())) {
				comboContent.append("app_name='" + appnamecombo.getItem(appnamecombo.getSelectionIndex()) + "',");
			} else {
				comboContent.append("app_name='',");
			}
		}

		if (channelcombo.getItems().length > 0 && channelcombo.getSelectionIndex() >= 0
				&& null != channelcombo.getItem(channelcombo.getSelectionIndex())) {
			if (channelcombo.getItem(channelcombo.getSelectionIndex()).equalsIgnoreCase("CAN-0")) {
				comboContent.append("channel='0',");

			} else if (channelcombo.getItem(channelcombo.getSelectionIndex()).equalsIgnoreCase("CAN-1")) {
				comboContent.append("channel='1',");

			} else if (channelcombo.getItem(channelcombo.getSelectionIndex()).equalsIgnoreCase("CAN-2")) {
				comboContent.append("channel='2',");

			} else if (channelcombo.getItem(channelcombo.getSelectionIndex()).equalsIgnoreCase("CAN-3")) {
				comboContent.append("channel='3',");

			} else {
				comboContent.append("channel='" + channelcombo.getItem(channelcombo.getSelectionIndex()) + "',");
			}

		} else {
			comboContent.append("channel='',");
		}

		if (baudratecombo.getItems().length > 0 && baudratecombo.getSelectionIndex() >= 0
				&& null != baudratecombo.getItem(baudratecombo.getSelectionIndex())) {

			String item = baudratecombo.getItem(baudratecombo.getSelectionIndex());
			if(item.contains("kBit")) {
				comboContent.append("bitrate=" + item.substring(0, item.indexOf(" ")) + "000");
			} else if(item.contains("MBit")) {
				comboContent.append("bitrate=" + item.substring(0, item.indexOf(" ")) + "000000");
			}
		} else {
			comboContent.append("bitrate=");
		}

		return comboContent.toString();
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
		getOKButton().setEnabled(false);
	}

	@Override
	protected void okPressed() {

		hardwareConfigration = getHardwareConfigration();
		htmlFlag = btnHtmlReport.getSelection();
		locationPath = reportlocationtxt.getText().toString();
		runPython = btnRunOnPython.getSelection();
		if (nodescombo.getItems().length > 0 && nodescombo.getSelectionIndex() >= 0
				&& null != nodescombo.getItem(nodescombo.getSelectionIndex())) {

			selectedNode = nodescombo.getItem(nodescombo.getSelectionIndex());
		}
		super.okPressed();
	}

	public String getNode() {
		return selectedNode;
	}

	public boolean getHTMLReport() {
		return htmlFlag;
	}

	public String getLocation() {
		return locationPath;
	}
	
	public boolean isRunPython() {
		return runPython;
	}

	public String getConfigration() {
		return hardwareConfigration;
	}

	public String getFileName() {
		return fileName;
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
		return new Point(901, 331);
	}

	private void validation() {
		getOKButton().setEnabled(true);
	}

	@Override
	protected boolean isResizable() {
		// TODO Auto-generated method stub
		return true;
	}
}
