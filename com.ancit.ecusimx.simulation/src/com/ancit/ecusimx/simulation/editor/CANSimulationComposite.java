package com.ancit.ecusimx.simulation.editor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CCombo;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;
import org.eclipse.ui.dialogs.ElementListSelectionDialog;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;

import com.ancit.ecusimx.simulation.Activator;
import com.ancit.ecusimx.simulation.model.CanInterface;
import com.ancit.ecusimx.simulation.model.CanSimulationBlock;
import com.ancit.ecusimx.simulation.model.MessageData;
import com.ancit.ecusimx.simulation.model.MessageRowData;
import com.ancit.ecusimx.simulation.model.SignalData;
import com.ancit.ecusimx.simulation.textstyle.TextLineStyler;
import com.ancit.ecusimx.simulation.util.CanSimulationBlockSerializer;
import com.ancit.ecusimx.simulation.util.CommonUtils;
import com.ancit.ecusimx.simulation.view.CANIGBlockContentProvider;
import com.ancit.ecusimx.simulation.view.CANIGBlockLabelProvider;
import com.ancit.ecusimx.simulation.view.EditingSupportForMessageInfoTreeViewer;
import com.ancit.genxtools.dbc.model.BasicLabelType;
import com.ancit.genxtools.dbc.model.Message;
import com.ancit.genxtools.dbc.model.NetworkDefinition;
import com.ancit.genxtools.dbc.model.Signal;
import com.ancit.genxtools.dbc.parser.DbcReader;

public class CANSimulationComposite extends Composite {

	CanSimulationBlock canSimulationModelBlock;
	// private StyledText txtCaplsource;
	StringBuffer pythonContent = new StringBuffer();
	private TreeViewer messageInfoTblViewer;
	private NetworkDefinition dbcNetwork = null;
	private File netwrkfile;

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());

	private String[] pcanList = new String[] { "socketcan", "pcan", "vector" };
	private String[] baudrateList = new String[] { "1 MBit/sec", "800 kBit/sec", "500 kBit/sec", "250 kBit/sec",
			"125 kBit/sec", "100 kBit/sec", "50 kBit/sec" };
	private String[] canappNamelList = new String[] { "CANalyzer", "CANoe" };
	private String[] pcanChannelList = new String[] { "PCAN_USBBUS1", "PCAN_USBBUS2", "PCAN_USBBUS3", "PCAN_USBBUS4",
			"PCAN_USBBUS5", "PCAN_USBBUS6", "PCAN_USBBUS7", "PCAN_USBBUS8", "PCAN_USBBUS9", "PCAN_USBBUS10",
			"PCAN_USBBUS11", "PCAN_USBBUS12", "PCAN_USBBUS13", "PCAN_USBBUS14", "PCAN_USBBUS15", "PCAN_USBBUS16" };
	private String[] vectorCanChannelList = new String[] { "CAN-0", "CAN-1" };
	private String[] socketCanChannelList = new String[] { "can0", "can1", "vcan0", "vcan1" };
	private CCombo hardwarecombo;
	private CCombo channelcombo;
	private CCombo baudratecombo;
	private CCombo appnamecombo;
	private StyledText txtCaplsource;

	private Action addMessageAction, addMessageRowDataAction;

	private Action deleteMessageAction;
	private Action generateCodeAction;
	private TableViewer rowDataTableViewer;
	private Action executePythonCode;
	private Text txtDBCPath;
	private Text txtPythonExportPath;
	private Text txtPythonFileName;
	private TabFolder tabFolder;
	private Composite composite1;
	private CANSimulationEditor editor;
	IFile file;
	public CANSimulationComposite(FormEditor editor, CanSimulationBlock canSimulationModelBlock, Composite parent,
			int style, IFile file) {
		super(parent, style);
		this.editor = (CANSimulationEditor) editor;
		this.canSimulationModelBlock = canSimulationModelBlock;
		this.file =file;
		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				toolkit.dispose();
			}
		});
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
		setLayout(new GridLayout(1, false));
		setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));

		createMasterPart(parent);
	}

	protected void createMasterPart(Composite parent) {
		//
		Section sctnNewSection = toolkit.createSection(this, Section.TWISTIE | Section.TITLE_BAR);
		sctnNewSection.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		toolkit.paintBordersFor(sctnNewSection);
		sctnNewSection.setText("ECU Simulation Block");

		composite1 = toolkit.createComposite(sctnNewSection, SWT.NONE);
		composite1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		composite1.setLayout(new GridLayout(1, false));

		createInterfaceSection(composite1);

		createDBCSection(composite1);

		getMessageSection(composite1, parent); // Message sent tabs

		getActionUtils(); // add,delete and Python action

		sctnNewSection.setClient(composite1);

	}

	private void createDBCSection(Composite composite) {
		Composite settingcomposite = new Composite(composite, SWT.NONE);
		settingcomposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		settingcomposite.setLayout(new GridLayout(4, false));

		Label lblDBCPath = new Label(settingcomposite, SWT.NONE);
		lblDBCPath.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		lblDBCPath.setText("DBC Path");

		txtDBCPath = new Text(settingcomposite, SWT.SINGLE | SWT.LEAD | SWT.BORDER | SWT.READ_ONLY);
		txtDBCPath.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		txtDBCPath.setText(canSimulationModelBlock.getDbcPath());
		txtDBCPath.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				canSimulationModelBlock.setDbcPath(txtDBCPath.getText());
				if (txtDBCPath.getText().isEmpty()) {
					addMessageAction.setEnabled(false);
					executePythonCode.setEnabled(false);
				} else {
					addMessageAction.setEnabled(true);
					executePythonCode.setEnabled(true);
				}

				editor.setDirty(true);

			}
		});

		Button btnBrowse = new Button(settingcomposite, SWT.PUSH);
		btnBrowse.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		btnBrowse.setText("...");
		btnBrowse.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				FileDialog fileDialog = new FileDialog(Display.getDefault().getActiveShell(), SWT.OPEN);
				fileDialog.setFilterExtensions(new String[] { "*.dbc" });
				String dbcPath = fileDialog.open();
				if (dbcPath != null) {
					txtDBCPath.setText(dbcPath);
					netwrkfile = new File(dbcPath);
					if (netwrkfile.isFile()) {
						if (netwrkfile.canRead()) {
							try {
								File file = new File(
										CommonUtils.generateTempFolder() + File.separator + "dbcviewer.log");
								DbcReader readerObj = new DbcReader();

								readerObj.parseFile(netwrkfile, new FileOutputStream(file));
								dbcNetwork = readerObj.getNetwork();
								addMessageAction.setEnabled(true);

							} catch (IOException exception) {
								exception.printStackTrace();
							}
						}

					}
				}

			}
		});

		Button btnDBCDissociate = new Button(settingcomposite, SWT.PUSH);
		btnDBCDissociate.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		btnDBCDissociate.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				dbcNetwork = null;
				txtDBCPath.setText("");
				editor.setDirty(true);
			}
		});
		btnDBCDissociate.setImage(PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_ETOOL_DELETE));

	}

	private void createInterfaceSection(Composite composite) {

		Composite settingcomposite = new Composite(composite, SWT.NONE);
		settingcomposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		settingcomposite.setLayout(new GridLayout(8, false));
		toolkit.adapt(settingcomposite);
		toolkit.paintBordersFor(settingcomposite);

		Label lblHardwareType = toolkit.createLabel(settingcomposite, "Hardware Type :");
		lblHardwareType.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		toolkit.adapt(lblHardwareType, true, true);
		lblHardwareType.setText("Hardware Type :");

		hardwarecombo = new CCombo(settingcomposite, SWT.BORDER | SWT.READ_ONLY);
		toolkit.adapt(hardwarecombo);
		toolkit.paintBordersFor(hardwarecombo);

		hardwarecombo.setItems(pcanList);
		hardwarecombo.select(0);
		hardwarecombo.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {

				String selectedItem = hardwarecombo.getItem(hardwarecombo.getSelectionIndex());
				if (selectedItem.equalsIgnoreCase("pcan")) {
					channelcombo.setItems(pcanChannelList);
					channelcombo.select(0);
					appnamecombo.setText("");
					appnamecombo.setEnabled(false);
				} else if (selectedItem.equalsIgnoreCase("Vector")) {
					channelcombo.setItems(vectorCanChannelList);
					channelcombo.select(0);
					appnamecombo.setEnabled(true);
					appnamecombo.setItems(canappNamelList);
					appnamecombo.select(0);
				} else if (selectedItem.equalsIgnoreCase("socketcan")) {
					channelcombo.setItems(socketCanChannelList);
					channelcombo.select(0);
					appnamecombo.setEnabled(false);
					appnamecombo.setText("");
				}

				editor.setDirty(true);
			}
		});

		Label lblAppName = new Label(settingcomposite, SWT.NONE);
		lblAppName.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		toolkit.adapt(lblAppName, true, true);
		lblAppName.setText("App Name :");

		appnamecombo = new CCombo(settingcomposite, SWT.BORDER | SWT.READ_ONLY);
		GridData gridData = new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1);
		gridData.widthHint = 100;
		appnamecombo.setLayoutData(gridData);
		toolkit.adapt(appnamecombo);
		toolkit.paintBordersFor(appnamecombo);
		appnamecombo.setEnabled(false);

		Label lblBitRate = new Label(settingcomposite, SWT.NONE);
		lblBitRate.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false, 1, 1));
		toolkit.adapt(lblBitRate, true, true);
		lblBitRate.setText("Bitrate :");

		baudratecombo = new CCombo(settingcomposite, SWT.BORDER | SWT.READ_ONLY);
		toolkit.adapt(baudratecombo);
		toolkit.paintBordersFor(baudratecombo);
		baudratecombo.setItems(baudrateList);
		baudratecombo.select(0);

		Label lblChannel = new Label(settingcomposite, SWT.NONE);
		toolkit.adapt(lblChannel, true, true);
		lblChannel.setText("Channel :");

		channelcombo = new CCombo(settingcomposite, SWT.BORDER | SWT.READ_ONLY);
		toolkit.adapt(channelcombo);
		toolkit.paintBordersFor(channelcombo);
		channelcombo.setItems(socketCanChannelList);
		channelcombo.select(0);
		channelcombo.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {
				// TODO Auto-generated method stub
				// setMessageDataWithPython(messageDetailsObj, setDataValues());
				editor.setDirty(true);
			}
		});
	}

	private void getMessageSection(Composite composite, Composite parent) {
		Section sctnMessageSend = toolkit.createSection(composite, Section.TWISTIE | Section.TITLE_BAR);
		sctnMessageSend.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		toolkit.paintBordersFor(sctnMessageSend);
		sctnMessageSend.setText("Message Send");
		sctnMessageSend.setExpanded(true);

		makeToolBarActions(composite, sctnMessageSend);

		tabFolder = new TabFolder(sctnMessageSend, SWT.NONE);
		sctnMessageSend.setClient(tabFolder);

		createMessageBlockTab(tabFolder);
		// createMessageRowDataTab(tabFolder);
		createPythonSourceTab(parent, tabFolder);

	}

	private void createPythonSourceTab(Composite parent, TabFolder tabFolder) {
		TabItem pythontabItem = new TabItem(tabFolder, SWT.NONE);
		pythontabItem.setText("Python Source");

		Composite compositePythonBlock = new Composite(tabFolder, SWT.NONE);
		compositePythonBlock.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		compositePythonBlock.setLayout(new GridLayout(3, false));

		pythontabItem.setControl(compositePythonBlock);

		pythontabItem.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {
				// TODO Auto-generated method stub
				setMessageDataWithPython();
			}
		});

		Label lblPythonExportPath = new Label(compositePythonBlock, SWT.NONE);
		lblPythonExportPath.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		lblPythonExportPath.setText("Folder Path");

		txtPythonExportPath = new Text(compositePythonBlock, SWT.SINGLE | SWT.LEAD | SWT.BORDER | SWT.READ_ONLY);
		txtPythonExportPath.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		String fileLocal = file.getLocation().toOSString().substring(0, file.getLocation().toOSString().lastIndexOf('\\'));
		txtPythonExportPath.setText(fileLocal);

//		Button btnBrowseExportPath = new Button(compositePythonBlock, SWT.PUSH);
//		btnBrowseExportPath.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
//		btnBrowseExportPath.setText("...");
//		btnBrowseExportPath.addSelectionListener(new SelectionAdapter() {
//			@Override
//			public void widgetSelected(SelectionEvent e) {
//				DirectoryDialog directoryDialog = new DirectoryDialog(Display.getDefault().getActiveShell(), SWT.SAVE);
//				String folderPath = directoryDialog.open();
//				txtPythonExportPath.setText(folderPath);
//				editor.setDirty(true);
//			}
//		});
		new Label(compositePythonBlock, SWT.NONE);
		Label lblPythonFileName = new Label(compositePythonBlock, SWT.NONE);
		lblPythonFileName.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		lblPythonFileName.setText("File Name");

		txtPythonFileName = new Text(compositePythonBlock, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		txtPythonFileName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		txtCaplsource = new StyledText(compositePythonBlock, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL | SWT.H_SCROLL);
		txtCaplsource.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1));
		TextLineStyler lineStyler = new TextLineStyler();
		txtCaplsource.addLineStyleListener(lineStyler);
		txtCaplsource.setEditable(true);

		new Label(parent, SWT.NONE);
		tabFolder.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
				org.eclipse.swt.widgets.TabItem item = (org.eclipse.swt.widgets.TabItem) e.item;
				if (item.getText().toString().equalsIgnoreCase("Row Data")) {
					addMessageAction.setEnabled(true);
					deleteMessageAction.setEnabled(false);
					generateCodeAction.setEnabled(false);
				} else if (item.getText().toString().equalsIgnoreCase("Message Info")) {
					if (!canSimulationModelBlock.getDbcPath().isEmpty()) {
						addMessageAction.setEnabled(true);
					} else {
						addMessageAction.setEnabled(false);
					}

					ITreeSelection structuredSelection = messageInfoTblViewer.getStructuredSelection();
					if (structuredSelection.size() == 1) {
						deleteMessageAction.setEnabled(true);
					} else {
						deleteMessageAction.setEnabled(false);
					}

					generateCodeAction.setEnabled(false);
				} else if (item.getText().toString().equalsIgnoreCase("Python Source")) {

					setMessageDataWithPython();

					if (!canSimulationModelBlock.getDbcPath().isEmpty()) {
						addMessageAction.setEnabled(false);
						deleteMessageAction.setEnabled(false);
						// generateCodeAction.setEnabled(true);
					} else {
						addMessageAction.setEnabled(false);
						deleteMessageAction.setEnabled(false);
						// generateCodeAction.setEnabled(false);
					}
					generateCodeAction.setEnabled(true);
				}
			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub
			}
		});
	}

	private void createMessageBlockTab(TabFolder tabFolder) {
		TabItem messageinfotabItem = new TabItem(tabFolder, SWT.NONE);
		messageinfotabItem.setText("Message Info");

		Composite messagecompositePrecondition = new Composite(tabFolder, SWT.NONE);
		messagecompositePrecondition.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		messagecompositePrecondition.setLayout(new FillLayout());

		messageinfotabItem.setControl(messagecompositePrecondition);

		messageInfoTblViewer = new TreeViewer(messagecompositePrecondition,
				SWT.BORDER | SWT.FULL_SELECTION | SWT.MULTI | SWT.V_SCROLL | SWT.H_SCROLL);
		Tree tabletreeViewer = messageInfoTblViewer.getTree();
		tabletreeViewer.setBounds(100, 100, 572, 214);
		tabletreeViewer.setLinesVisible(true);
		tabletreeViewer.setHeaderVisible(true);
		messageInfoTblViewer.expandAll();
		toolkit.paintBordersFor(tabletreeViewer);

		TreeViewerColumn treeViewerMessageData = new TreeViewerColumn(messageInfoTblViewer, SWT.CENTER);
		TreeColumn trclmnMessageName = treeViewerMessageData.getColumn();
		trclmnMessageName.setWidth(113);
		trclmnMessageName.setText("Signal Name");

		treeViewerMessageData.setEditingSupport(new EditingSupport(messageInfoTblViewer) {

			@Override
			protected void setValue(Object element, Object value) {
				if (element instanceof MessageRowData) {
					if (value != null) {
						((MessageRowData) element).getMessage().setId(value.toString());
						editor.setDirty(true);
					}
				}
				messageInfoTblViewer.refresh();
			}

			@Override
			protected Object getValue(Object element) {
				if (element instanceof MessageRowData) {
					if (((MessageRowData) element).getMessage().getId() != null) {
						return ((MessageRowData) element).getMessage().getId();
					}
				}
				return null;
			}

			@Override
			protected CellEditor getCellEditor(Object element) {
				if (element instanceof MessageRowData) {
					return new TextCellEditor(messageInfoTblViewer.getTree());
				}
				return new TextCellEditor(messageInfoTblViewer.getTree());
			}

			@Override
			protected boolean canEdit(Object element) {
				// TODO Auto-generated method stub
				return true;
			}
		});

		TreeColumn startbitColumn = new TreeColumn(tabletreeViewer, SWT.CENTER);
		startbitColumn.setAlignment(SWT.LEFT);
		startbitColumn.setText("Startbit");
		startbitColumn.setWidth(85);

		TreeColumn legthbitcolumn = new TreeColumn(tabletreeViewer, SWT.CENTER);
		legthbitcolumn.setAlignment(SWT.LEFT);
		legthbitcolumn.setText("Length [Bit]");
		legthbitcolumn.setWidth(106);

		TreeViewerColumn treeViewerDataColumn = new TreeViewerColumn(messageInfoTblViewer, SWT.CENTER);
		TreeColumn trclmnData = treeViewerDataColumn.getColumn();
		trclmnData.setWidth(113);
		trclmnData.setText("Data");

		treeViewerDataColumn.setEditingSupport(new EditingSupport(messageInfoTblViewer) {

			@Override
			protected void setValue(Object element, Object value) {

				if (element instanceof SignalData) {
					SignalData signalData = (SignalData) element;
					signalData.setData(value.toString());
					editor.setDirty(true);
				} else if (element instanceof MessageRowData) {
					MessageRowData msgRowData = (MessageRowData) element;
					if (value != null && !value.toString().isEmpty()) {
						msgRowData.setData(value.toString());
						editor.setDirty(true);
					}
				}

				messageInfoTblViewer.refresh();
			}

			@Override
			protected Object getValue(Object element) {
				if (element instanceof SignalData) {
					if (((SignalData) element).getSignal().getLabelSet() != null) {
						return ((SignalData) element).getSignal().getLabelSet();
					} else {
						return "";
					}
				} else if (element instanceof MessageRowData) {
					if (((MessageRowData) element).getData() != null) {
						return ((MessageRowData) element).getData();
					} else {
						return "";
					}
				}
				return null;
			}

			@Override
			protected CellEditor getCellEditor(Object element) {
				if (element instanceof SignalData) {
					SignalData signal = (SignalData) element;
					if (signal.getSignal().getLabelSet() != null) {
						List<BasicLabelType> signalValues = signal.getSignal().getLabelSet().getLabelOrLabelGroup();
						String[] items = new String[signalValues.size()];

						for (int i = 0; i < items.length; i++) {
							items[i] = ((BasicLabelType) signalValues.get(i)).getName();
						}

						ComboBoxCellEditor cellEditor = new ComboBoxCellEditor(messageInfoTblViewer.getTree(),
								new String[] {});
						cellEditor.setItems(items);
						return cellEditor;
					}
				} else if (element instanceof MessageRowData) {
					return new TextCellEditor(messageInfoTblViewer.getTree());
				}
				return new TextCellEditor(messageInfoTblViewer.getTree());
			}

			@Override
			protected boolean canEdit(Object element) {
				// TODO Auto-generated method stub
				return true;
			}
		});

		TreeColumn trclmnCycletime = new TreeColumn(tabletreeViewer, SWT.CENTER);
		trclmnCycletime.setWidth(113);
		trclmnCycletime.setText("Cycle");

		TreeColumn trclmnSleeptime = new TreeColumn(tabletreeViewer, SWT.CENTER);
		trclmnSleeptime.setWidth(113);
		trclmnSleeptime.setText("Sleep");

		TreeViewerColumn treeViewerOnMessageColumn = new TreeViewerColumn(messageInfoTblViewer, SWT.CENTER);
		TreeColumn trclmnOnMessage = treeViewerOnMessageColumn.getColumn();
		trclmnOnMessage.setWidth(113);
		trclmnOnMessage.setText("On Message");

		TreeViewerColumn treeViewerOnKeyColumn = new TreeViewerColumn(messageInfoTblViewer, SWT.CENTER);
		TreeColumn trclmnOnKey = treeViewerOnKeyColumn.getColumn();
		trclmnOnKey.setWidth(113);
		trclmnOnKey.setText("On Key");

		messageInfoTblViewer.setContentProvider(new CANIGBlockContentProvider());
		messageInfoTblViewer.setLabelProvider(new CANIGBlockLabelProvider());
		messageInfoTblViewer.setInput(canSimulationModelBlock.getMessageData());

		messageInfoTblViewer.setCellEditors(new CellEditor[] { null, null, null,
				new TextCellEditor(messageInfoTblViewer.getTree()), new TextCellEditor(messageInfoTblViewer.getTree()),
				new TextCellEditor(messageInfoTblViewer.getTree()), new TextCellEditor(messageInfoTblViewer.getTree()),
				new TextCellEditor(messageInfoTblViewer.getTree()) });

		EditingSupportForMessageInfoTreeViewer.enableEditingForDataColumn(messageInfoTblViewer,editor);
		messageInfoTblViewer.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				// TODO Auto-generated method stub

				IStructuredSelection structuredSelection = event.getStructuredSelection();
				if (structuredSelection.size() == 1) {
					deleteMessageAction.setEnabled(true);

				} else {
					deleteMessageAction.setEnabled(false);
				}
			}
		});

	}

	private void getActionUtils() {

		executePythonCode = new Action("Start", Action.AS_PUSH_BUTTON) {

			@Override
			public void run() {

				String[] linuxArgs = new String[] { "/bin/bash", "-c", "candump", channelcombo.getText(), "|",
						"cantools", "decode", "--single-line", txtDBCPath.getText() };
				String[] windowsArgs = new String[] { "cmd.exe", "/C", "start", "candump", channelcombo.getText(), "|",
						"cantools", "decode", "--single-line", txtDBCPath.getText() };

				String[] args = null;
				if (System.getProperty("os.name").contains("Win")) {
					args = windowsArgs;
				} else {
					args = linuxArgs;
				}

				try {
					Process proc = new ProcessBuilder(args).start();

					try {

						BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));

						BufferedReader errorReader = new BufferedReader(new InputStreamReader(proc.getErrorStream()));

						String line;
						MessageConsole myConsole = findConsole("CAN Simulation Console");
						MessageConsoleStream out = myConsole.newMessageStream();
						while ((line = reader.readLine()) != null) {
							out.setColor(new Color(Display.getCurrent(), 51, 51, 255));
							out.println(line);
							System.out.println(line);
						}

						while ((line = errorReader.readLine()) != null) {
							out.setColor(new Color(Display.getCurrent(), 255, 0, 0));
							out.println(line);
							System.out.println(line);
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};

		Action saveSimulationBlock = new Action("Save") {
			@Override
			public void run() {

				FileDialog fileDialog = new FileDialog(Display.getDefault().getActiveShell(), SWT.SAVE);
				fileDialog.setFilterExtensions(new String[] { "*.ecux" });
				String filePath = fileDialog.open();
				if (filePath != null) {
					CanSimulationBlock simulationBlock = canSimulationModelBlock;

					CanInterface canInterface = new CanInterface();
					canInterface.setAppName(appnamecombo.getText());
					canInterface.setBusType(hardwarecombo.getText());
					canInterface.setBitRate(baudratecombo.getText());
					canInterface.setChannel(channelcombo.getText());
					simulationBlock.setCanInterface(canInterface);

					CanSimulationBlockSerializer.save(simulationBlock, filePath);
				}

			}
		};

		Action loadSimulationBlock = new Action("Load") {
			@Override
			public void run() {
				FileDialog fileDialog = new FileDialog(Display.getDefault().getActiveShell(), SWT.OPEN);
				fileDialog.setFilterExtensions(new String[] { "*.cansim" });
				String filePath = fileDialog.open();
				if (filePath != null) {
					canSimulationModelBlock = CanSimulationBlockSerializer.load(filePath);
					System.out.println(canSimulationModelBlock);

					File file = new File(CommonUtils.generateTempFolder() + File.separator + "dbcviewer.log");
					DbcReader readerObj = new DbcReader();

					String dbcPath = canSimulationModelBlock.getDbcPath();
					txtDBCPath.setText(dbcPath);

					try {
						boolean loadResult = readerObj.parseFile(new File(dbcPath), new FileOutputStream(file));
						if (loadResult) {
							dbcNetwork = readerObj.getNetwork();
						}
					} catch (FileNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					// importartifacttableViewer.setInput(canSimulationBlock.getImportArtifacts());
					messageInfoTblViewer.setInput(canSimulationModelBlock.getMessageData());

					hardwarecombo.setText(canSimulationModelBlock.getCanInterface().getBusType());
					appnamecombo.setText(canSimulationModelBlock.getCanInterface().getAppName());
					baudratecombo.setText(canSimulationModelBlock.getCanInterface().getBitRate());
					channelcombo.setText(canSimulationModelBlock.getCanInterface().getChannel());

				}
			}
		};

		ISharedImages sharedImages = PlatformUI.getWorkbench().getSharedImages();
		saveSimulationBlock.setImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_ETOOL_SAVE_EDIT));

		loadSimulationBlock.setImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_OBJ_FOLDER));

		executePythonCode
				.setImageDescriptor(Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "icons/energy.png"));
		executePythonCode.setEnabled(false);

	}

	private StringBuffer generatePythonCodeMessageWithRowData() {

		StringBuffer rowDatapythonContent = new StringBuffer();
		// #Code Generated by TestGenx v.0.1
		// #ANCIT CONSULTING
		rowDatapythonContent.append("#Code Generated by TestGenx v.1.0");
		rowDatapythonContent.append("\n");
		rowDatapythonContent.append("#ANCIT CONSULTING");
		rowDatapythonContent.append("\n");
		rowDatapythonContent.append("#Date : " + new Date());
		rowDatapythonContent.append("\n");
		String username = System.getProperty("user.name");
		rowDatapythonContent.append("#Author : " + username);
		rowDatapythonContent.append("\n");
		rowDatapythonContent.append("\n");
		rowDatapythonContent.append("from __future__ import print_function");
		rowDatapythonContent.append("\n");
		rowDatapythonContent.append("import can");
		rowDatapythonContent.append("\n");
		rowDatapythonContent.append("import time");
		rowDatapythonContent.append("\n");
		rowDatapythonContent.append("import cantools");

		rowDatapythonContent.append("\n");
		rowDatapythonContent.append("def send_rowdata():");

		rowDatapythonContent.append("\n\tcan_bus = can.interface.Bus()");
		rowDatapythonContent.append("\n");

		// --------Start loop --------
		getDataValuesFromRowDataTable(rowDatapythonContent);
		// --------- End loop ---------
		rowDatapythonContent.append("\n");
		rowDatapythonContent.append("if __name__ == '__main__':");
		rowDatapythonContent.append("\n");
		rowDatapythonContent.append("\tsend_rowdata()");

		return rowDatapythonContent;
		// txtCaplsource.setText(rowDatapythonContent.toString());

	}

	private void setMessageDataWithPython() {

		pythonContent = new StringBuffer();
		// #Code Generated by TestGenx v.0.1
		// #ANCIT CONSULTING
		pythonContent.append("#Code Generated by TestGenx v.1.0");
		pythonContent.append("\n");
		pythonContent.append("#ANCIT CONSULTING");
		pythonContent.append("\n");
		pythonContent.append("#Date : " + new Date());
		pythonContent.append("\n");
		String username = System.getProperty("user.name");
		pythonContent.append("#Author : " + username);
		pythonContent.append("\n");
		pythonContent.append("\n");
		pythonContent.append("from __future__ import print_function");
		pythonContent.append("\n");
		pythonContent.append("import can");
		pythonContent.append("\n");
		pythonContent.append("import time");
		pythonContent.append("\n");
		pythonContent.append("import cantools");
		pythonContent.append("\n");
		pythonContent.append("from pynput import keyboard");
		pythonContent.append("\n");
		pythonContent.append("import threading");

		pythonContent.append("\n");

		if (!canSimulationModelBlock.getDbcPath().isEmpty()) {
			String replaceAll = canSimulationModelBlock.getDbcPath().replace("\\", "/");

			pythonContent.append("\ndb = cantools.database.load_file('" + replaceAll + "')");
		}
		pythonContent.append("\ncan_bus = can.interface.Bus(" + getSendMessageLine() + ")");

		pythonContent.append("\n\ndef on_Message():");
		// --------On Message --------//
		generateOnMessagePythonCode(pythonContent);

		// getDataValuesFromTable();

		pythonContent.append("\ndef on_press(key):");
		pythonContent.append("\nprint(\"Key Event Identified\")");
		// --------On Key --------//
		generateOnKeyPythonCode(pythonContent);

		pythonContent.append("\n\ndef on_Key():");
		pythonContent.append("\n\tkeyboard.Listener(on_press=on_press).start()");

		pythonContent.append("\n\ndef sendMessage():");
		// --------On sendMessage --------//
		generateSendMessagePythonCode(pythonContent);

		pythonContent.append("\n");
		pythonContent.append("if __name__ == '__main__':");
		pythonContent.append("\n");
		pythonContent.append("\n\tsendMessage()");
		pythonContent.append("\n\ton_Key()");
		pythonContent.append("\n\tthreading.Thread(on_Message()).start()");

		txtCaplsource.setText(pythonContent.toString());

	}

	private void generateSendMessagePythonCode(StringBuffer sendMessagepythonContent) {
		// TODO Auto-generated method stub
		TreeItem[] items = messageInfoTblViewer.getTree().getItems();
		StringBuffer strbuff = new StringBuffer();
		int datavalue = 0;
		int itemslenght = items.length;
		if (itemslenght > 0) {

			for (int i = 0; i < items.length; i++) {
				strbuff = new StringBuffer();
				if ((null == items[i].getText(6) || items[i].getText(6).toString().trim().isEmpty())
						&& (null == items[i].getText(7) || items[i].getText(7).toString().trim().isEmpty())) {

					if (items[i].getData() instanceof MessageData) {
						MessageData messageObj = (MessageData) items[i].getData();
						getMessageFromDatabase(messageObj, datavalue, strbuff, items[i].getText(4).toString(),
								items[i].getText(5).toString(), sendMessagepythonContent);

					} else if (items[i].getData() instanceof MessageRowData) {
						MessageRowData messageObj = (MessageRowData) items[i].getData();
						getMessageFromRowData(messageObj, items[i].getText(4).toString(), sendMessagepythonContent);
					}
				}

			}
		}

	}

	private void generateOnKeyPythonCode(StringBuffer pythonContent2) {
		// TODO Auto-generated method stub
		TreeItem[] items = messageInfoTblViewer.getTree().getItems();
		StringBuffer strbuff = new StringBuffer();
		int datavalue = 0;
		int itemslenght = items.length;
		if (itemslenght > 0) {

			for (int i = 0; i < items.length; i++) {
				strbuff = new StringBuffer();
				if (items[i].getData() instanceof MessageData && null != items[i].getText(7)
						&& !items[i].getText(7).toString().trim().isEmpty()) {
					MessageData messageObj = (MessageData) items[i].getData();
					pythonContent2.append("\n\tif key.char == '" + messageObj.getOnKey()
							+ "': # handles if key press is " + messageObj.getOnKey());
					getMessageFromDatabase(messageObj, datavalue, strbuff, items[i].getText(4).toString(),
							items[i].getText(5).toString(), pythonContent2);

				} else if (items[i].getData() instanceof MessageRowData && null != items[i].getText(7)
						&& !items[i].getText(7).toString().trim().isEmpty()) {
					MessageRowData messageObj = (MessageRowData) items[i].getData();
					pythonContent2.append("\n\tif key.char == '" + messageObj.getOnKey()
							+ "': # handles if key press is " + messageObj.getOnKey());
					getMessageFromRowData(messageObj, items[i].getText(4).toString(), pythonContent2);
				}
			}
		}

	}

	private StringBuffer generateOnMessagePythonCode(StringBuffer onMessagePythonContent) {
		// TODO Auto-generated method stub
		// while True:

		TreeItem[] items = messageInfoTblViewer.getTree().getItems();
		StringBuffer strbuff = new StringBuffer();
		int datavalue = 0;
		int itemslenght = items.length;
		if (itemslenght > 0) {
			onMessagePythonContent.append("\n\twhile True:");
			onMessagePythonContent.append("\n\t\tresponse = can_bus.recv()");

			for (int i = 0; i < items.length; i++) {
				strbuff = new StringBuffer();
				if (items[i].getData() instanceof MessageData && null != items[i].getText(6)
						&& !items[i].getText(6).toString().trim().isEmpty()) {
					MessageData messageObj = (MessageData) items[i].getData();
					onMessagePythonContent
							.append("\n\t\tif response.arbitration_id == " + messageObj.getOnMessage() + ":");
					getMessageFromDatabase(messageObj, datavalue, strbuff, items[i].getText(4).toString(),
							items[i].getText(5).toString(), onMessagePythonContent);

				} else if (items[i].getData() instanceof MessageRowData && null != items[i].getText(6)
						&& !items[i].getText(6).toString().trim().isEmpty()) {
					MessageRowData messageObj = (MessageRowData) items[i].getData();
					onMessagePythonContent
							.append("\n\t\tif response.arbitration_id == " + messageObj.getOnMessage() + ":");
					getMessageFromRowData(messageObj, items[i].getText(4).toString(), onMessagePythonContent);
				}
			}
		}
		return onMessagePythonContent;
	}

	private StringBuffer getMessageFromRowData(MessageRowData messageObj, String cycleTime,
			StringBuffer rowDatapythonContent) {

		rowDatapythonContent.append("\n\t\t\t# Message ID : " + messageObj.getMessage().getId());
		rowDatapythonContent.append("\n\t\t\tmessage = can.Message(arbitration_id=" + messageObj.getMessage().getId()
				+ ", data=[" + messageObj.getData() + "], is_extended_id=False)");

		rowDatapythonContent.append("\n\t\t\ttry:");

		if (messageObj.getCycleTime() != 0) {

			rowDatapythonContent
					.append("\n\t\t\t\ttask = can_bus.send_periodic(message," + cycleTime + ") # cycle time");

		} else {
			rowDatapythonContent.append("\n\t\t\t\tcan_bus.send(message)");
		}

		// rowDatapythonContent.append("\n\t\t\t\tcan_bus.send(message)");

		rowDatapythonContent.append("\n\t\t\t\tprint(\" " + messageObj.getMessage().getId()
				+ " Message sent on {}\".format(can_bus.channel_info))");
		rowDatapythonContent.append("\n\t\t\texcept can.CanError:");
		rowDatapythonContent.append("\n\t\t\t\tprint(\"Message NOT sent\")");

		rowDatapythonContent.append("\n");
		return rowDatapythonContent;
	}

	private void getMessageFromDatabase(MessageData messageObj, int datavalue, StringBuffer strbuff, String CycleTime,
			String sleepTime, StringBuffer onMessagePythonContent) {

		ArrayList<SignalData> signals = messageObj.getSignalData();
		for (SignalData signalData : signals) {
			datavalue = getIntegerValue(signalData.getData());
			if (signals.indexOf(signalData) == 0) {
				strbuff.append("'" + signalData.getSignal().getName() + "':"
						+ (0 != datavalue ? String.valueOf(datavalue) : "0"));
			} else {
				strbuff.append(",'" + signalData.getSignal().getName() + "':"
						+ (0 != datavalue ? String.valueOf(datavalue) : "0"));
			}
		}

		onMessagePythonContent.append("\n\t\t\t# Message : " + messageObj.getMessage().getName());
		onMessagePythonContent.append(
				"\n\t\t\texample_message = db.get_message_by_name('" + messageObj.getMessage().getName() + "')");
		onMessagePythonContent.append("\n\t\t\tdata = example_message.encode({" + strbuff.toString() + "})");
		onMessagePythonContent.append(
				"\n\t\t\tmessage = can.Message(arbitration_id=example_message.frame_id, data=data, is_extended_id="
						+ (messageObj.getMessage().isFd() ? "True" : "False") + ")");

		onMessagePythonContent.append("\n\t\t\ttry:");

		if (messageObj.getCycleTime() != 0) {

			onMessagePythonContent
					.append("\n\t\t\t\ttask = can_bus.send_periodic(message," + CycleTime + ") # cycle time");

		} else {
			onMessagePythonContent.append("\n\t\t\t\tcan_bus.send(message)");
		}

		onMessagePythonContent.append("\n\t\t\t\tprint(\" " + messageObj.getMessage().getName()
				+ " Message sent on {}\".format(can_bus.channel_info))");
		onMessagePythonContent.append("\n\t\t\texcept can.CanError:");
		onMessagePythonContent.append("\n\t\t\t\tprint(\"Message NOT sent\")");

		if (messageObj.getSleepTime() != 0) {

			onMessagePythonContent.append("\n\t\t\ttime.sleep(" + sleepTime + ") # Sleep time " + sleepTime + "");

			onMessagePythonContent.append("\n\t\t\ttask.stop()");
			onMessagePythonContent.append("\n");

		}
		onMessagePythonContent.append("\n");

	}

	private void getDataValuesFromRowDataTable(StringBuffer rowDatapythonContent) {

		TableItem[] items = rowDataTableViewer.getTable().getItems();
		int itemslenght = items.length;
		if (itemslenght > 0) {

			for (int i = 0; i < items.length; i++) {
				MessageRowData messageObj = (MessageRowData) items[i].getData();

				rowDatapythonContent.append("\n\t\t\t\t\t# Message ID : " + messageObj.getMessage().getId());
				rowDatapythonContent
						.append("\n\t\t\tmessage = can.Message(arbitration_id=" + messageObj.getMessage().getId()
								+ ", data=[" + messageObj.getData() + "], is_extended_id=False)");

				rowDatapythonContent.append("\n\t\t\ttry:");

				if (messageObj.getCycleTime() != 0) {

					pythonContent.append("\n\t\t\t\ttask = can_bus.send_periodic(message,"
							+ items[i].getText(4).toString() + ") # cycle time");

				} else {
					pythonContent.append("\n\t\t\t\tcan_bus.send(message)");
				}

				rowDatapythonContent.append("\n\t\t\t\tcan_bus.send(message)");

				rowDatapythonContent.append("\n\t\t\t\tprint(\" " + messageObj.getMessage().getId()
						+ " Message sent on {}\".format(can_bus.channel_info))");
				rowDatapythonContent.append("\n\t\t\texcept can.CanError:");
				rowDatapythonContent.append("\n\t\t\t\tprint(\"Message NOT sent\")");

				rowDatapythonContent.append("\n");
			}
		}

	}

	private HashMap<String, ArrayList<Object>> getSaparetListForOnkeyOnMsg() {
		ArrayList<Object> onMessageList = new ArrayList<Object>();
		ArrayList<Object> onKeyList = new ArrayList<Object>();
		ArrayList<Object> sendMessageList = new ArrayList<Object>();

		HashMap<String, ArrayList<Object>> messageList = new HashMap<String, ArrayList<Object>>();

		TreeItem[] items = messageInfoTblViewer.getTree().getItems();
		int itemslenght = items.length;
		if (itemslenght > 0) {

			for (int i = 0; i < items.length; i++) {

				if (null != items[i].getText(6) && !items[i].getText(6).toString().trim().isEmpty()) {
					System.out.println("1--> " + items[i].getText(6) + " :: " + items[i].getText(7));
					onMessageList.add(items[i].getData());
				} else if (null != items[i].getText(7) && !items[i].getText(7).toString().trim().isEmpty()) {
					onKeyList.add(items[i].getData());
					System.out.println("2--> " + items[i].getText(6) + " :: " + items[i].getText(7));
				} else {
					System.out.println("3--> " + items[i].getText(6) + " :: " + items[i].getText(7));
					sendMessageList.add(items[i].getData());
				}
			}
			if (!onMessageList.isEmpty()) {
				messageList.put("onmessage", onMessageList);
			}
			if (!onKeyList.isEmpty()) {
				messageList.put("onkey", onMessageList);
			}
			if (!sendMessageList.isEmpty()) {
				messageList.put("sendmessage", onMessageList);
			}
			System.out.println(messageList);
		}
		return messageList;
	}

	private void getDataValuesFromTable() {
		TreeItem[] items = messageInfoTblViewer.getTree().getItems();
		StringBuffer strbuff = new StringBuffer();
		int datavalue = 0;
		int itemslenght = items.length;
		if (itemslenght > 0) {

			for (int i = 0; i < items.length; i++) {
				strbuff = new StringBuffer();
				if (items[i].getData() instanceof MessageData) {
					MessageData messageObj = (MessageData) items[i].getData();

					ArrayList<SignalData> signals = messageObj.getSignalData();
					for (SignalData signalData : signals) {
						datavalue = getIntegerValue(signalData.getData());
						if (signals.indexOf(signalData) == 0) {
							strbuff.append("'" + signalData.getSignal().getName() + "':"
									+ (0 != datavalue ? String.valueOf(datavalue) : "0"));
						} else {
							strbuff.append(",'" + signalData.getSignal().getName() + "':"
									+ (0 != datavalue ? String.valueOf(datavalue) : "0"));
						}
					}

					pythonContent.append("\n\t# Message : " + messageObj.getMessage().getName());
					pythonContent.append("\n");
					pythonContent.append("\n\texample_message = db.get_message_by_name('"
							+ messageObj.getMessage().getName() + "')");
					pythonContent.append("\n\tdata = example_message.encode({" + strbuff.toString() + "})");
					pythonContent.append(
							"\n\tmessage = can.Message(arbitration_id=example_message.frame_id, data=data, is_extended_id="
									+ (messageObj.getMessage().isFd() ? "True" : "False") + ")");

					pythonContent.append("\n\ttry:");

					if (messageObj.getCycleTime() != 0) {

						pythonContent.append("\n\t\ttask = can_bus.send_periodic(message,"
								+ items[i].getText(4).toString() + ") # cycle time");

					} else {
						pythonContent.append("\n\t\tcan_bus.send(message)");
					}

					pythonContent.append("\n\t\tprint(\" " + messageObj.getMessage().getName()
							+ " Message sent on {}\".format(can_bus.channel_info))");
					pythonContent.append("\n\texcept can.CanError:");
					pythonContent.append("\n\t\tprint(\"Message NOT sent\")");

					if (messageObj.getSleepTime() != 0) {

						pythonContent.append("\n\ttime.sleep(" + items[i].getText(5).toString() + ") # Sleep time "
								+ items[i].getText(5).toString() + "");

						pythonContent.append("\n\ttask.stop()");
						pythonContent.append("\n");

					}
					pythonContent.append("\n");
				}

			}
		}

	}

	private int getIntegerValue(String itemData) {
		// TODO Auto-generated method stub
		try {
			return Integer.parseInt(itemData);
		} catch (Exception e) {
			// TODO: handle exception
			return 0;
		}

	}

	protected void restrictInput(VerifyEvent event) {
		String allowedCharacters = "0123456789.,eE+-";
		String text = event.text;
		for (int index = 0; index < text.length(); index++) {
			char character = text.charAt(index);
			boolean isAllowed = allowedCharacters.indexOf(character) > -1;
			if (!isAllowed) {
				event.doit = false;
				return;
			}
		}
	}

	protected void validateValueOnChange(String text) {
		try {
			Integer.parseInt(text);
			// valueErrorDecorator.hide();
		} catch (NumberFormatException exception) {
			// expressions like "5e-" are allowed while typing
		}
	}

	protected void validateValueOnFocusLoss(String value) {
		try {
			Integer.parseInt(value);
			// valueErrorDecorator.hide();
		} catch (NumberFormatException exception) {
			// valueErrorDecorator.show();
		}
	}

	public String getExtensionOfFile(File file) {
		String fileExtension = "";
		// Get file Name first
		String fileName = file.getName();

		// If fileName do not contain "." or starts with "." then it is not a valid file
		if (fileName.contains(".") && fileName.lastIndexOf(".") != 0) {
			fileExtension = fileName.substring(fileName.lastIndexOf(".") + 1);
		}

		return fileExtension;
	}

	private MessageConsole findConsole(String name) {
		ConsolePlugin plugin = ConsolePlugin.getDefault();
		IConsoleManager conMan = plugin.getConsoleManager();
		IConsole[] existing = conMan.getConsoles();
		for (int i = 0; i < existing.length; i++)
			if (name.equals(existing[i].getName()))
				return (MessageConsole) existing[i];
		// no console found, so create a new one
		MessageConsole myConsole = new MessageConsole(name, null);
		conMan.addConsoles(new IConsole[] { myConsole });
		return myConsole;
	}

	private String getSendMessageLine() {
		StringBuffer comboStringBuffer = new StringBuffer();
		if (hardwarecombo.getItems().length > 0 && hardwarecombo.getSelectionIndex() >= 0
				&& null != hardwarecombo.getItem(hardwarecombo.getSelectionIndex())) {

			comboStringBuffer.append("bustype='" + hardwarecombo.getItem(hardwarecombo.getSelectionIndex()) + "',");
		} else {
			comboStringBuffer.append("bustype='',");
		}

		if (appnamecombo.isEnabled()) {
			if (appnamecombo.getItems().length > 0 && appnamecombo.getSelectionIndex() >= 0
					&& null != appnamecombo.getItem(appnamecombo.getSelectionIndex())) {
				comboStringBuffer.append("app_name='" + appnamecombo.getItem(appnamecombo.getSelectionIndex()) + "',");
			} else {
				comboStringBuffer.append("app_name='',");
			}
		}

		if (channelcombo.getItems().length > 0 && channelcombo.getSelectionIndex() >= 0
				&& null != channelcombo.getItem(channelcombo.getSelectionIndex())) {
			if (channelcombo.getItem(channelcombo.getSelectionIndex()).equalsIgnoreCase("CAN-0")) {
				comboStringBuffer.append("channel='0',");

			} else if (channelcombo.getItem(channelcombo.getSelectionIndex()).equalsIgnoreCase("CAN-1")) {
				comboStringBuffer.append("channel='1',");

			} else if (channelcombo.getItem(channelcombo.getSelectionIndex()).equalsIgnoreCase("CAN-2")) {
				comboStringBuffer.append("channel='2',");

			} else if (channelcombo.getItem(channelcombo.getSelectionIndex()).equalsIgnoreCase("CAN-3")) {
				comboStringBuffer.append("channel='3',");

			} else {
				comboStringBuffer.append("channel='" + channelcombo.getItem(channelcombo.getSelectionIndex()) + "',");
			}

		} else {
			comboStringBuffer.append("channel='',");
		}

		if (baudratecombo.getItems().length > 0 && baudratecombo.getSelectionIndex() >= 0
				&& null != baudratecombo.getItem(baudratecombo.getSelectionIndex())) {

			String item = baudratecombo.getItem(baudratecombo.getSelectionIndex());
			if (item.contains("kBit")) {
				comboStringBuffer.append("bitrate=" + item.substring(0, item.indexOf(" ")) + "000");
			} else if (item.contains("MBit")) {
				comboStringBuffer.append("bitrate=" + item.substring(0, item.indexOf(" ")) + "000000");
			}

		} else {
			comboStringBuffer.append("bitrate=");
		}
		return comboStringBuffer.toString();
	}

	private void makeToolBarActions(Composite parent, Section section) {
		Composite compactionAdd = new Composite(parent, SWT.NONE);
		compactionAdd.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		compactionAdd.setLayout(new GridLayout(2, false));

		ToolBarManager toolBarManager = new ToolBarManager(SWT.FLAT);
		ToolBar toolbar = toolBarManager.createControl(section);
		toolbar.setCursor(Display.getDefault().getSystemCursor(SWT.CURSOR_HAND));

		addMessageAction = new Action("Add Message") {
			@Override
			public void run() {

				List<Message> unusedMessages = CommonUtils.getAllMessagesInDBC(dbcNetwork);
				ElementListSelectionDialog messageSelectionDialog = new ElementListSelectionDialog(
						Display.getDefault().getActiveShell(), new LabelProvider() {
							@Override
							public String getText(Object element) {
								if ((element instanceof Message)) {
									Message sidesType = (Message) element;
									return sidesType.getName();

								}
								return super.getText(element);
							}
						});
				messageSelectionDialog.setElements(unusedMessages.toArray());
				int open = messageSelectionDialog.open();
				if (IDialogConstants.OK_ID == open) {
					Object[] selectedMessages = messageSelectionDialog.getResult();
					for (Object object : selectedMessages) {
						Message selectedMessage = (Message) object;
						if (null != selectedMessage) {

							MessageData messageData = new MessageData();
							messageData.setMessage(selectedMessage);

							List<Signal> signals = selectedMessage.getSignal();

							for (Signal signal : signals) {
								SignalData signalData = new SignalData();
								signalData.setSignal(signal);
								messageData.getSignalData().add(signalData);
							}
							messageData.setOnKey("");
							messageData.setOnMessage("");
							messageData.setRowData(false);
							editor.setDirty(true);
							canSimulationModelBlock.getMessageData().add(messageData);
							messageInfoTblViewer.refresh();
						}
					}
				}
				// }

				super.run();
			}
		};
		ISharedImages sharedImages = PlatformUI.getWorkbench().getSharedImages();
		ImageDescriptor addMessageImageDesc = sharedImages.getImageDescriptor(ISharedImages.IMG_OBJ_ADD);
		addMessageAction
				.setImageDescriptor(addMessageImageDesc);
		addMessageAction.setEnabled(false);

		addMessageRowDataAction = new Action("Add RowData") {
			@Override
			public void run() {
				Message msgObj = new Message();
				MessageRowData mrdObj = new MessageRowData();
				mrdObj.setMessage(msgObj);
				mrdObj.getMessage().setId("0x0" + (messageInfoTblViewer.getTree().getItemCount() + 1));
				mrdObj.setData("");
				mrdObj.setCycleTime(0);
				mrdObj.setOnMessage("");
				mrdObj.setOnKey("");
				mrdObj.setRowData(true);
				editor.setDirty(true);
				canSimulationModelBlock.getMessageData().add(mrdObj);
				messageInfoTblViewer.refresh();
				super.run();
			}
		};

		addMessageRowDataAction
				.setImageDescriptor(Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "icons/add_icon.png"));

		deleteMessageAction = new Action("Delete") {

			@Override
			public void run() {
				String selectedTabName = tabFolder.getItem(tabFolder.getSelectionIndex()).getText().toString();
				if (selectedTabName.equalsIgnoreCase("Row Data")) {

					IStructuredSelection structuredSelection = rowDataTableViewer.getStructuredSelection();
					if (structuredSelection.size() == 1) {

						Object element = structuredSelection.getFirstElement();
						if (element instanceof MessageRowData) {

							MessageRowData message = (MessageRowData) element;
							canSimulationModelBlock.getMessageRowData().remove(message);
							rowDataTableViewer.refresh();

						}
					}

				} else {

					ITreeSelection structuredSelection = messageInfoTblViewer.getStructuredSelection();
					if (structuredSelection.size() == 1) {

						Object element = structuredSelection.getFirstElement();
						if (element instanceof MessageData) {
							MessageData message = (MessageData) element;
							canSimulationModelBlock.getMessageData().remove(message);
							editor.setDirty(true);
							messageInfoTblViewer.refresh();
						}else if (element instanceof MessageRowData) {
							MessageRowData message = (MessageRowData) element;
							canSimulationModelBlock.getMessageData().remove(message);
							editor.setDirty(true);
							messageInfoTblViewer.refresh();
						}
					}

				}
				if (messageInfoTblViewer.getTree().getItems().length == 0) {
					// executePythonCode.setEnabled(false);
				}

				super.run();
			}
		};
		deleteMessageAction.setEnabled(false);
		deleteMessageAction
				.setImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_ETOOL_DELETE));

		generateCodeAction = new Action("Generate Code") {

			@Override
			public void run() {

				String filePath = new String();
				// String rowdataFile = new String();

				if (txtPythonExportPath.getText().isEmpty() || txtPythonFileName.getText().isEmpty()) {
					MessageDialog.openError(Display.getDefault().getActiveShell(), "Error - Generation Path",
							"Generation Path is Empty or File Empty. Please fill in the desired location before generating the Path or missing file name.");
				} else {
					filePath = txtPythonExportPath.getText() + File.separator + txtPythonFileName.getText().toString()
							+ ".py";
					// rowdataFile = txtPythonExportPath.getText() + File.separator
					// + txtPythonFileName.getText().toString();
				}

				if (!filePath.isEmpty()) {
					// StringBuffer rowDataContent = generatePythonCodeMessageWithRowData();
					writeToFile(new File(filePath + ".py"), pythonContent);
				}
				super.run();
			}
		};
		generateCodeAction.setImageDescriptor(
				Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "icons/icons8-python-24.png"));
		generateCodeAction.setEnabled(false);

		toolBarManager.add(generateCodeAction);
		toolBarManager.add(addMessageAction);
		toolBarManager.add(addMessageRowDataAction);
		toolBarManager.add(deleteMessageAction);

		toolBarManager.update(true);
		section.setTextClient(toolbar);

	}

	private File writeToFile(File generalFile, StringBuffer content) {
		try {

			FileWriter generalFW = new FileWriter(generalFile);
			generalFW.write(content.toString());
			generalFW.flush();
			generalFW.close();
			System.out.println("File written Succesfully");

			MessageDialog.openInformation(Display.getDefault().getActiveShell(), "File Generated",
					"File Generated successfully!");
			return generalFile;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
