package com.ancit.testgenx.ui.page;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.DoubleClickEvent;
import org.eclipse.jface.viewers.IDoubleClickListener;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.DragSource;
import org.eclipse.swt.dnd.DragSourceAdapter;
import org.eclipse.swt.dnd.DragSourceEvent;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.events.DisposeEvent;
import org.eclipse.swt.events.DisposeListener;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.zest.core.viewers.GraphViewer;
import org.eclipse.zest.core.widgets.ZestStyles;
import org.eclipse.zest.layouts.LayoutAlgorithm;
import org.eclipse.zest.layouts.LayoutStyles;
import org.eclipse.zest.layouts.algorithms.TreeLayoutAlgorithm;

import com.ancit.testgenx.ui.dialogs.TestStepCAPLParamDialog;
import com.ancit.testgenx.ui.dialogs.TestStepCheckDialog;
import com.ancit.testgenx.ui.dialogs.TestStepDiagnosticDialog;
import com.ancit.testgenx.ui.dialogs.TestStepForDialog;
import com.ancit.testgenx.ui.dialogs.TestStepSetDialog;
import com.ancit.testgenx.ui.dialogs.TestStepWaitDialog;
import com.ancit.testgenx.ui.dialogs.TestStepWhileDialog;
import com.ancit.testgenx.ui.dialogs.TestSteppDiagReqResDialog;
import com.ancit.testgenx.ui.dnd.TestStepDropListener;
import com.ancit.testgenx.ui.provider.TestStepContentProvider;
import com.ancit.testgenx.ui.provider.TestStepLabelProvider;
import com.ancit.testgenx.ui.syntaxstyling.TextLineStyler;
import com.ancit.testgenx.ui.utils.CAPLSourceGeneratorUtil;
import com.ancit.testgenx.ui.utils.PythonSourceGeneratorUtil;
import com.ancit.testgenx.ui.zest.ZestLabelProvider;
import com.ancit.testgenx.ui.zest.ZestNodeContentProvider;
import com.ancit.testgenx.ui.zest.ZestPreConditionNodeContentProvider;

import DiagonosticModel.CAPLParam;
import DiagonosticModel.CheckAction;
import DiagonosticModel.DiagnosticRequest;
import DiagonosticModel.DiagnosticResponse;
import DiagonosticModel.DiagnosticService;
import DiagonosticModel.ForLoop;
import DiagonosticModel.OperatorTypeEnum;
import DiagonosticModel.SetAction;
import DiagonosticModel.SignalType;
import DiagonosticModel.TestCase;
import DiagonosticModel.TestSpecification;
import DiagonosticModel.TestStep;
import DiagonosticModel.WaitAction;
import DiagonosticModel.WhileLoop;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Combo;

public class TestActionsDetailsComposite extends Composite {

	private static final String STEP_OUT = "StepOut";
	private static final String STEP_IN = "StepIn";
	private static final String SOURCE = "Source";
	private static final String TABULAR = "Tabular";
	private static final String GRAPHICAL = "Graphical";
	private static final String TAB = "TAB";
	private static final String POST_CONDITION = "PostCondition";
	private static final String PRE_CONDITION = "PreCondition";
	private static final String ACTION = "Action";

	private final FormToolkit toolkit = new FormToolkit(Display.getCurrent());

	private TreeViewer treeViewerAction;
	private TreeViewer preCondtTreeViewer;
	private TreeViewer postCondtTreeViewer;
	private Viewer activeViewer;

	private Tree preConditionTreeTable;
	private Tree postConditionTree;
	private Tree actionTree;

	private GraphViewer actionGraphicalviewer;
	private GraphViewer preConditionGraphicalviewer;
	private GraphViewer postConditionGraphicalviewer;

	private TabItem tabPreconditiontabular;
	private TabItem tabPostconditiontabular;
	private TabItem tabActionTabular;

	private TabFolder tabularPreCondition;
	private TabFolder tabular;

	private LayoutAlgorithm preConditionlayout;
	private LayoutAlgorithm layout;
	private LayoutAlgorithm postlayout;

	private TestCase testCase;
	private TestSpecification testSpecification;
	private TestCaseDetailPage testCaseDetailPage;
	private Text txtActionSourceTab;
	private StyledText txtCaplsource;
	private StyledText txtpythonsource;
	private String[] pcanList = new String[] { "pcan", "vector" };
	private String[] baudrateList = new String[] { "1 MBit/sec", "800 kBit/sec", "500 kBit/sec", "250 kBit/sec",
			"125 kBit/sec", "100 kBit/sec", "95238 kBit/sec", "20000 kBit/sec", "83333 kBit/sec", "50 kBit/sec" };
	private String[] canappNamelList = new String[] { "CANalyzer", "CANoe" };
	private String[] pcanChannelList = new String[] { "PCAN_USBBUS1", "PCAN_USBBUS2", "PCAN_USBBUS3", "PCAN_USBBUS4",
			"PCAN_USBBUS5", "PCAN_USBBUS6", "PCAN_USBBUS7", "PCAN_USBBUS8", "PCAN_USBBUS9", "PCAN_USBBUS10",
			"PCAN_USBBUS11", "PCAN_USBBUS12", "PCAN_USBBUS13", "PCAN_USBBUS14", "PCAN_USBBUS15", "PCAN_USBBUS16" };
	private String[] canChannelList = new String[] { "CAN-0", "CAN-1" };
	private Combo hardwarecombo;
	private Combo channelcombo;
	private Combo baudratecombo;
	private Combo appnamecombo;

	public void setTestSpecification(TestSpecification testSpecification) {
		this.testSpecification = testSpecification;

	}

	/**
	 * Create the composite.
	 * 
	 * @param parent
	 * @param style
	 * @param testCaseDetailPage
	 * @param testCase
	 */

	public TestActionsDetailsComposite(Composite parent, int style, TestCaseDetailPage testCaseDetailPage) {
		super(parent, style);
		this.testCaseDetailPage = testCaseDetailPage;

		addDisposeListener(new DisposeListener() {
			public void widgetDisposed(DisposeEvent e) {
				toolkit.dispose();
			}
		});
		toolkit.adapt(this);
		toolkit.paintBordersFor(this);
		setLayout(new FillLayout(SWT.HORIZONTAL));

		tabular = new TabFolder(this, SWT.NONE);
		parent.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		/**** PreCondition ****/
		// TabItem tbtmPreCondition = new TabItem(tabular, SWT.NONE);
		// tbtmPreCondition.setText(PRE_CONDITION);

		Composite compositePrecondition = new Composite(tabular, SWT.NONE);
		compositePrecondition.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		compositePrecondition.setLayout(new FillLayout());

		// tbtmPreCondition.setControl(compositePrecondition);

		tabularPreCondition = new TabFolder(compositePrecondition, SWT.BOTTOM);
		toolkit.adapt(tabularPreCondition);
		toolkit.paintBordersFor(tabularPreCondition);

		TabItem tabPreconditiongraphical = new TabItem(tabularPreCondition, SWT.NONE);
		tabPreconditiongraphical.setText(GRAPHICAL);

		Composite compopreconditiongraphicalsite = new Composite(tabularPreCondition, SWT.NONE);
		tabPreconditiongraphical.setControl(compopreconditiongraphicalsite);
		compopreconditiongraphicalsite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		compopreconditiongraphicalsite.setLayout(new FillLayout());

		preConditionGraphicalviewer = new GraphViewer(compopreconditiongraphicalsite,
				SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
		preConditionGraphicalviewer.setConnectionStyle(ZestStyles.CONNECTIONS_DIRECTED | ZestStyles.CONNECTIONS_DASH);
		preConditionGraphicalviewer.setContentProvider(new ZestPreConditionNodeContentProvider());
		preConditionGraphicalviewer.setLabelProvider(new ZestLabelProvider());
		preConditionGraphicalviewer.setLayoutAlgorithm(preConditionlayout, true);
		preConditionGraphicalviewer.applyLayout();
		preConditionGraphicalviewer.setData(TAB, PRE_CONDITION);

		tabPreconditiontabular = new TabItem(tabularPreCondition, SWT.NONE);
		tabPreconditiontabular.setText(TABULAR);

		/* Precondition table */

		preConditionlayout = setLayout();

		createPreConditionTabular(tabularPreCondition);

		/**********************************************/
		// Tabs Listener
		tabular.addSelectionListener(new SelectionAdapter() {

			public void widgetSelected(org.eclipse.swt.events.SelectionEvent event) {
				tabular.getSelection()[0].getText();
			}
		});

		/****************** Action table ********************/
		TabItem tbtmActionCondition = new TabItem(tabular, SWT.NONE);
		tbtmActionCondition.setText(ACTION);

		Composite compositeAction = new Composite(tabular, SWT.NONE);
		compositeAction.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		compositeAction.setLayout(new FillLayout());

		tbtmActionCondition.setControl(compositeAction);

		TabFolder TabularActioncondition = new TabFolder(compositeAction, SWT.BOTTOM);
		toolkit.adapt(TabularActioncondition);
		toolkit.paintBordersFor(TabularActioncondition);

		createActionConditionGraphicalView(TabularActioncondition);

		createActionConditionTabular(TabularActioncondition);

		// createActionConditionSourceView(TabularActioncondition);

		/***************************************************/

		/*********************** post condition ***************/
		// TabItem tbtmPostCondition = new TabItem(tabular, SWT.NONE);
		// tbtmPostCondition.setText(POST_CONDITION);

		Composite composite = new Composite(tabular, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		composite.setLayout(new FillLayout());

		// tbtmPostCondition.setControl(composite);

		TabFolder TabularPostcondition = new TabFolder(composite, SWT.BOTTOM);
		toolkit.adapt(TabularPostcondition);
		toolkit.paintBordersFor(TabularPostcondition);

		TabItem tbtmPostGraphical = new TabItem(TabularPostcondition, SWT.NONE);
		tbtmPostGraphical.setText(GRAPHICAL);

		Composite compographicalsitePost = new Composite(TabularPostcondition, SWT.NONE);
		tbtmPostGraphical.setControl(compographicalsitePost);
		compographicalsitePost.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		compographicalsitePost.setLayout(new FillLayout());

		postConditionGraphicalviewer = new GraphViewer(compographicalsitePost,
				SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
		postConditionGraphicalviewer.setConnectionStyle(ZestStyles.CONNECTIONS_DIRECTED | ZestStyles.CONNECTIONS_DASH);
		postConditionGraphicalviewer.setContentProvider(new ZestNodeContentProvider());
		postConditionGraphicalviewer.setLabelProvider(new ZestLabelProvider());
		postConditionGraphicalviewer.setLayoutAlgorithm(postlayout, true);
		postConditionGraphicalviewer.applyLayout();
		postConditionGraphicalviewer.setData(TAB, POST_CONDITION);

		tabPostconditiontabular = new TabItem(TabularPostcondition, SWT.NONE);
		tabPostconditiontabular.setText(TABULAR);

		postlayout = setLayout();
		createPostConditionTabular(TabularPostcondition);

		/********************** CAPL Source ************************/

		// getCAPLSourceTab();// Python source TAB

		/********************** Python Source ************************/

		// getPythonSourceTab();// Python source TAB

		refresh();
	}

	private void getCAPLSourceTab() {
		TabItem tbtmCaplSource = new TabItem(tabular, SWT.NONE);
		tbtmCaplSource.setText("CAPL Source");

		Composite caplContainerComposite = new Composite(tabular, SWT.NONE);
		tbtmCaplSource.setControl(caplContainerComposite);
		toolkit.paintBordersFor(caplContainerComposite);
		caplContainerComposite.setLayout(new FillLayout(SWT.HORIZONTAL));

		txtCaplsource = new StyledText(caplContainerComposite, SWT.BORDER | SWT.MULTI | SWT.V_SCROLL | SWT.H_SCROLL);
		toolkit.adapt(txtCaplsource, true, true);
		TextLineStyler lineStyler = new TextLineStyler();
		txtCaplsource.addLineStyleListener(lineStyler);
		txtCaplsource.setEditable(false);
	}

	private void getPythonSourceTab() {
		TabItem tbtmpythonSource = new TabItem(tabular, SWT.NONE);
		tbtmpythonSource.setText("Python Source");

		Composite pythonContainerComposite = new Composite(tabular, SWT.NONE);
		tbtmpythonSource.setControl(pythonContainerComposite);
		toolkit.paintBordersFor(pythonContainerComposite);
		pythonContainerComposite.setLayout(new GridLayout(1, false));

		Composite settingcomposite = new Composite(pythonContainerComposite, SWT.NONE);
		settingcomposite.setLayout(new GridLayout(4, false));
		GridData gd_settingcomposite = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);
		gd_settingcomposite.heightHint = 72;
		settingcomposite.setLayoutData(gd_settingcomposite);
		toolkit.adapt(settingcomposite);
		toolkit.paintBordersFor(settingcomposite);

		Label lblNewLabel = new Label(settingcomposite, SWT.NONE);
		toolkit.adapt(lblNewLabel, true, true);
		lblNewLabel.setText("Bus Type :");

		Label lblNewLabel_1 = new Label(settingcomposite, SWT.NONE);
		toolkit.adapt(lblNewLabel_1, true, true);
		lblNewLabel_1.setText("App Name :");

		Label lblNewLabel_2 = new Label(settingcomposite, SWT.NONE);
		toolkit.adapt(lblNewLabel_2, true, true);
		lblNewLabel_2.setText("Bitrate :");

		Label lblNewLabel_3 = new Label(settingcomposite, SWT.NONE);
		toolkit.adapt(lblNewLabel_3, true, true);
		lblNewLabel_3.setText("Channel :");

		hardwarecombo = new Combo(settingcomposite, SWT.NONE);
		GridData gd_hardwarecombo = new GridData(SWT.LEFT, SWT.FILL, false, false, 1, 1);
		gd_hardwarecombo.widthHint = 81;
		hardwarecombo.setLayoutData(gd_hardwarecombo);
		toolkit.adapt(hardwarecombo);
		toolkit.paintBordersFor(hardwarecombo);
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
					channelcombo.setItems(canChannelList);
					channelcombo.select(0);
					appnamecombo.setEnabled(true);
					appnamecombo.setItems(canappNamelList);
					appnamecombo.select(0);
				}
			}
		});

		appnamecombo = new Combo(settingcomposite, SWT.NONE);
		appnamecombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		toolkit.adapt(appnamecombo);
		toolkit.paintBordersFor(appnamecombo);
		appnamecombo.setEnabled(false);

		appnamecombo.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {
				// TODO Auto-generated method stub
				// setMessageDataWithPython(messageDetailsObj, setDataValues());
			}
		});

		baudratecombo = new Combo(settingcomposite, SWT.NONE);
		baudratecombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		toolkit.adapt(baudratecombo);
		toolkit.paintBordersFor(baudratecombo);

		channelcombo = new Combo(settingcomposite, SWT.NONE);
		channelcombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1));
		toolkit.adapt(channelcombo);
		toolkit.paintBordersFor(channelcombo);

		txtpythonsource = new StyledText(pythonContainerComposite,
				SWT.BORDER | SWT.MULTI | SWT.V_SCROLL | SWT.H_SCROLL);
		txtpythonsource.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		toolkit.adapt(txtpythonsource, true, true);
		TextLineStyler pythonlineStyler = new TextLineStyler();
		txtpythonsource.addLineStyleListener(pythonlineStyler);
		txtpythonsource.setEditable(false);
	}

	private void refreshCaplCode(TestCase testCase) {
		String generateCAPL = new CAPLSourceGeneratorUtil().generateCAPL(testCase);
		txtCaplsource.setText(generateCAPL);
	}

	private void createActionConditionSourceView(TabFolder tabFolder) {
		TabItem tabActionConditionSourceView = new TabItem(tabFolder, SWT.NONE);
		tabActionConditionSourceView.setText(SOURCE);

		Composite compositeActionCondition = new Composite(tabFolder, SWT.NONE);
		tabActionConditionSourceView.setControl(compositeActionCondition);
		toolkit.paintBordersFor(compositeActionCondition);
		compositeActionCondition.setLayout(new FillLayout(SWT.HORIZONTAL));

		txtActionSourceTab = new Text(compositeActionCondition, SWT.MULTI | SWT.LEAD | SWT.BORDER);

	}

	private void createActionConditionGraphicalView(TabFolder TabularActioncondition) {
		TabItem tbtmActionGraphical = new TabItem(TabularActioncondition, SWT.NONE);
		tbtmActionGraphical.setText(GRAPHICAL);

		Composite compographicalsite = new Composite(TabularActioncondition, SWT.NONE);
		tbtmActionGraphical.setControl(compographicalsite);
		compographicalsite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		compographicalsite.setLayout(new FillLayout());

		actionGraphicalviewer = new GraphViewer(compographicalsite, SWT.BORDER | SWT.V_SCROLL | SWT.H_SCROLL);
		actionGraphicalviewer.setConnectionStyle(ZestStyles.CONNECTIONS_DIRECTED | ZestStyles.CONNECTIONS_DASH);

		actionGraphicalviewer.setContentProvider(new ZestNodeContentProvider());
		actionGraphicalviewer.setLabelProvider(new ZestLabelProvider());
		actionGraphicalviewer.setLayoutAlgorithm(layout, true);
		actionGraphicalviewer.applyLayout();
		actionGraphicalviewer.setData(TAB, ACTION);

		layout = setLayout();
	}

	private void createPreConditionTabular(TabFolder tabFolder) {

		Composite compositePreCondition = new Composite(tabFolder, SWT.NONE);
		tabPreconditiontabular.setControl(compositePreCondition);
		toolkit.paintBordersFor(compositePreCondition);
		compositePreCondition.setLayout(new FillLayout(SWT.HORIZONTAL));

		preCondtTreeViewer = new TreeViewer(compositePreCondition,
				SWT.BORDER | SWT.FULL_SELECTION | SWT.MULTI | SWT.V_SCROLL | SWT.H_SCROLL);
		preConditionTreeTable = preCondtTreeViewer.getTree();
		preConditionTreeTable.setBounds(100, 100, 572, 214);
		preConditionTreeTable.setLinesVisible(true);
		preConditionTreeTable.setHeaderVisible(true);
		preCondtTreeViewer.expandAll();
		preCondtTreeViewer.setData(TAB, PRE_CONDITION);

		toolkit.paintBordersFor(preConditionTreeTable);

		TreeColumn column1 = new TreeColumn(preConditionTreeTable, SWT.LEFT);
		column1.setAlignment(SWT.LEFT);
		column1.setText(ACTION);
		column1.setWidth(200);

		TreeColumn column2 = new TreeColumn(preConditionTreeTable, SWT.RIGHT);
		column2.setAlignment(SWT.LEFT);
		column2.setText("Parameter");
		column2.setWidth(100);

		TreeColumn column3 = new TreeColumn(preConditionTreeTable, SWT.RIGHT);
		column3.setAlignment(SWT.LEFT);
		column3.setText("Type");
		column3.setWidth(100);

		TreeColumn column4 = new TreeColumn(preConditionTreeTable, SWT.RIGHT);
		column4.setAlignment(SWT.LEFT);
		column4.setText("Value");
		column4.setWidth(100);

		PreconditionTableRowUpandDown();

		PreconditionRowClickListener();

		preCondtTreeViewer.setContentProvider(new TestStepContentProvider());
		preCondtTreeViewer.setLabelProvider(new TestStepLabelProvider());
		String[] preconditionValue = new String[] { "action", "parameter", "operator", "value" };
		preCondtTreeViewer.setColumnProperties(preconditionValue);

		GraphicalPreCondtionViewListener();

		preConditionTreeTable.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				setActiveViewer(preCondtTreeViewer);
			}
		});

		createViewerContextMenu(preCondtTreeViewer);

	}

	private void PreconditionRowClickListener() {
		// tabular tableViewerPreconditionTabular Double Clicked
		preCondtTreeViewer.addDoubleClickListener(new IDoubleClickListener() {
			@Override
			public void doubleClick(DoubleClickEvent event) {

				Object oldValue = preCondtTreeViewer.getStructuredSelection().getFirstElement();
				editTestStepValues(oldValue);
				preCondtTreeViewer.refresh();
				refreshPreConditionGraphicalViewer();
			}
		});

	}

	private void PreconditionTableRowUpandDown() {
		// row up and down
		Transfer[] types = new Transfer[] { TextTransfer.getInstance() };
		DragSource source = new DragSource(preConditionTreeTable, DND.DROP_MOVE);
		source.setTransfer(types);

		source.addDragListener(new DragSourceAdapter() {
			public void dragSetData(DragSourceEvent event) {
				// Get the selected items in the drag source
				DragSource ds = (DragSource) event.widget;
				preConditionTreeTable = (Tree) ds.getControl();
				TreeItem[] selection = preConditionTreeTable.getSelection();

				StringBuffer buff = new StringBuffer();
				for (int i = 0, n = selection.length; i < n; i++) {
					buff.append(selection[i].getText());
				}

				event.data = buff.toString();
			}

		});

		int operations = DND.DROP_COPY | DND.DROP_MOVE;
		Transfer[] transferTypes = new Transfer[] { TextTransfer.getInstance() };
		preCondtTreeViewer.addDropSupport(operations, transferTypes, new TestStepDropListener(preCondtTreeViewer));
	}

	private void GraphicalPreCondtionViewListener() {

		createViewerContextMenu(preConditionGraphicalviewer);
		// Graphical preConditionGraphicalviewer double click on nodes
		preConditionGraphicalviewer.getGraphControl().addMouseListener(new MouseAdapter() {

			@Override
			public void mouseDoubleClick(MouseEvent e) {

				Object oldValue = preConditionGraphicalviewer.getStructuredSelection().getFirstElement();
				editTestStepValues(oldValue);
				preConditionGraphicalviewer.refresh();
				preCondtTreeViewer.refresh();
			}
		});

		preConditionGraphicalviewer.getControl().addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				setActiveViewer(preConditionGraphicalviewer);
			}
		});
	}

	/* action tab */
	private void createActionConditionTabular(TabFolder tabFolder) {

		tabActionTabular = new TabItem(tabFolder, SWT.NONE);
		tabActionTabular.setText(TABULAR);

		Composite compositeActionCondition = new Composite(tabFolder, SWT.NONE);
		tabActionTabular.setControl(compositeActionCondition);
		toolkit.paintBordersFor(compositeActionCondition);
		compositeActionCondition.setLayout(new FillLayout(SWT.HORIZONTAL));

		treeViewerAction = new TreeViewer(compositeActionCondition,
				SWT.BORDER | SWT.FULL_SELECTION | SWT.MULTI | SWT.V_SCROLL | SWT.H_SCROLL);
		actionTree = treeViewerAction.getTree();
		actionTree.setBounds(100, 100, 572, 214);
		actionTree.setLinesVisible(true);
		actionTree.setHeaderVisible(true);
		treeViewerAction.setData(TAB, ACTION);

		toolkit.paintBordersFor(actionTree);

		TreeColumn column1 = new TreeColumn(actionTree, SWT.LEFT);
		column1.setAlignment(SWT.LEFT);
		column1.setText(ACTION);
		column1.setWidth(200);

		TreeColumn column2 = new TreeColumn(actionTree, SWT.RIGHT);
		column2.setAlignment(SWT.LEFT);
		column2.setText("Parameter");
		column2.setWidth(100);

		TreeColumn column3 = new TreeColumn(actionTree, SWT.RIGHT);
		column3.setAlignment(SWT.LEFT);
		column3.setText("Type");
		column3.setWidth(100);

		TreeColumn column4 = new TreeColumn(actionTree, SWT.RIGHT);
		column4.setAlignment(SWT.LEFT);
		column4.setText("Value");
		column4.setWidth(100);
		/*
		 * TableViewer tableViewePrecondtion = new TableViewer(compositePreCondition,
		 * SWT.BORDER | SWT.FULL_SELECTION);
		 * 
		 */
		// protected Object openDialogBox(Control cellEditorWindow) {

		actionTree.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				setActiveViewer(treeViewerAction);
			}
		});

		createViewerContextMenu(treeViewerAction);

		ActionTableRowUpandDown();

		GraphicalActionViewListener();

		ActionTableRowClickListener();

	}

	private void ActionTableRowClickListener() {
		treeViewerAction.addDoubleClickListener(new IDoubleClickListener() {
			@Override
			public void doubleClick(DoubleClickEvent event) {

				Object oldValue = treeViewerAction.getStructuredSelection().getFirstElement();
				editTestStepValues(oldValue);
				treeViewerAction.refresh();
				refreshActionViewer();
			}
		});

		// GraphicalPostConditionListener();

		treeViewerAction.setContentProvider(new TestStepContentProvider());
		treeViewerAction.setLabelProvider(new TestStepLabelProvider());
		String[] actionValue = new String[] { "action", "parameter", "operator", "value" };
		treeViewerAction.setColumnProperties(actionValue);
	}

	private void ActionTableRowUpandDown() {
		// row up and down
		Transfer[] types = new Transfer[] { TextTransfer.getInstance() };
		DragSource source = new DragSource(actionTree, DND.DROP_MOVE);
		source.setTransfer(types);

		source.addDragListener(new DragSourceAdapter() {
			public void dragSetData(DragSourceEvent event) {
				// Get the selected items in the drag source
				DragSource ds = (DragSource) event.widget;
				actionTree = (Tree) ds.getControl();
				TreeItem[] selection = actionTree.getSelection();

				StringBuffer buff = new StringBuffer();
				for (int i = 0, n = selection.length; i < n; i++) {
					buff.append(selection[i].getText());
				}

				event.data = buff.toString();
			}

		});

		int operations = DND.DROP_COPY | DND.DROP_MOVE;
		Transfer[] transferTypes = new Transfer[] { TextTransfer.getInstance() };
		treeViewerAction.addDropSupport(operations, transferTypes, new TestStepDropListener(treeViewerAction));
	}

	/**********/
	// postconditon tab

	private void createPostConditionTabular(TabFolder tabFolder) {

		Composite compositePostCondition = new Composite(tabFolder, SWT.NONE);
		tabPostconditiontabular.setControl(compositePostCondition);
		toolkit.paintBordersFor(compositePostCondition);
		compositePostCondition.setLayout(new FillLayout(SWT.HORIZONTAL));

		postCondtTreeViewer = new TreeViewer(compositePostCondition,
				SWT.BORDER | SWT.FULL_SELECTION | SWT.MULTI | SWT.V_SCROLL | SWT.H_SCROLL);
		postConditionTree = postCondtTreeViewer.getTree();
		postConditionTree.setBounds(100, 100, 572, 214);
		postConditionTree.setLinesVisible(true);
		postConditionTree.setHeaderVisible(true);
		postCondtTreeViewer.setData(TAB, POST_CONDITION);

		toolkit.paintBordersFor(postConditionTree);

		TreeColumn column1 = new TreeColumn(postConditionTree, SWT.LEFT);
		column1.setAlignment(SWT.LEFT);
		column1.setText(ACTION);
		column1.setWidth(200);

		TreeColumn column2 = new TreeColumn(postConditionTree, SWT.RIGHT);
		column2.setAlignment(SWT.LEFT);
		column2.setText("Parameter");
		column2.setWidth(100);

		TreeColumn column3 = new TreeColumn(postConditionTree, SWT.RIGHT);
		column3.setAlignment(SWT.LEFT);
		column3.setText("Type");
		column3.setWidth(100);

		TreeColumn column4 = new TreeColumn(postConditionTree, SWT.RIGHT);
		column4.setAlignment(SWT.LEFT);
		column4.setText("Value");
		column4.setWidth(100);

		GraphicalPostConditionListener();

		PostConditionTableRowUpandDown();

		PostConditionTableRowClickListener();

		postConditionTree.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				setActiveViewer(postCondtTreeViewer);
			}
		});

		createViewerContextMenu(postCondtTreeViewer);

	}

	private void createViewerContextMenu(Viewer viewer) {
		String tabKey = (String) viewer.getData(TAB);
		Action preAction = new Action(PRE_CONDITION) {
			@Override
			public void run() {
				IStructuredSelection structSelection = (IStructuredSelection) viewer.getSelection();
				Iterator<?> iterator = structSelection.iterator();
				removedSelectedNode(tabKey, structSelection);
				addTestStepToPreCondt(iterator, false);
				refresh();
			}
		};

		Action action = new Action(ACTION) {
			@Override
			public void run() {
				IStructuredSelection structSelection = (IStructuredSelection) viewer.getSelection();
				Iterator<?> iterator = structSelection.iterator();
				removedSelectedNode(tabKey, structSelection);
				addTestStepToAction(iterator, false);
				refresh();
			}
		};

		Action postAction = new Action(POST_CONDITION) {
			@Override
			public void run() {
				IStructuredSelection structSelection = (IStructuredSelection) viewer.getSelection();
				Iterator<?> iterator = structSelection.iterator();
				removedSelectedNode(tabKey, structSelection);
				addTestStepToPostCondt(iterator, false);
				refresh();
			}
		};

		Action copyPreAction = new Action(PRE_CONDITION) {
			@Override
			public void run() {
				IStructuredSelection structSelection = (IStructuredSelection) viewer.getSelection();
				Iterator<?> iterator = structSelection.iterator();
				addTestStepToPreCondt(iterator, true);
				refresh();
			}
		};

		Action copyAction = new Action(ACTION) {
			@Override
			public void run() {
				IStructuredSelection structSelection = (IStructuredSelection) viewer.getSelection();
				Iterator<?> iterator = structSelection.iterator();
				addTestStepToAction(iterator, true);
				refresh();
			}
		};

		Action copyPostAction = new Action(POST_CONDITION) {
			@Override
			public void run() {
				IStructuredSelection structSelection = (IStructuredSelection) viewer.getSelection();
				Iterator<?> iterator = structSelection.iterator();
				addTestStepToPostCondt(iterator, true);
				refresh();
			}
		};

		Action stepIn = new Action(STEP_IN) {
			@Override
			public void run() {
				IStructuredSelection structSelection = (IStructuredSelection) viewer.getSelection();
				Object firstElement = structSelection.getFirstElement();
				if (firstElement instanceof WhileLoop) {
					WhileLoop whileLoop = (WhileLoop) firstElement;
					if (viewer instanceof GraphViewer) {
						GraphViewer graphViewer = (GraphViewer) viewer;
						graphViewer.setInput(whileLoop.getTestSteps());
						graphViewer.refresh();
					}
				} else if (firstElement instanceof ForLoop) {
					ForLoop forLoop = (ForLoop) firstElement;
					if (viewer instanceof GraphViewer) {
						GraphViewer graphViewer = (GraphViewer) viewer;
						graphViewer.setInput(forLoop.getTestSteps());
						graphViewer.refresh();
					}
				}
			}
		};

		Action stepOut = new Action(STEP_OUT) {
			@Override
			public void run() {
				IStructuredSelection structSelection = (IStructuredSelection) viewer.getSelection();
				Object firstElement = structSelection.getFirstElement();
				if (firstElement instanceof TestStep) {
					TestStep testStep = (TestStep) firstElement;
					if (viewer instanceof GraphViewer) {
						GraphViewer graphViewer = (GraphViewer) viewer;
						EObject eContainer = testStep.eContainer().eContainer();
						if (eContainer instanceof WhileLoop) {
							WhileLoop whileLoop = (WhileLoop) eContainer;
							graphViewer.setInput(whileLoop.getTestSteps());
							graphViewer.refresh();
						} else if (eContainer instanceof ForLoop) {
							ForLoop forLoop = (ForLoop) eContainer;
							graphViewer.setInput(forLoop.getTestSteps());
							graphViewer.refresh();
						} else if (eContainer instanceof TestCase) {
							testCaseStepOut(graphViewer, eContainer);
						}
					}
				}
			}
		};

		MenuManager manager = new MenuManager();
		manager.setRemoveAllWhenShown(true);
		manager.addMenuListener(new IMenuListener() {

			@Override
			public void menuAboutToShow(IMenuManager manager) {

				MenuManager subMenu = new MenuManager("Move To", null);
				// Actions for the sub menu
				if (PRE_CONDITION.equals(tabKey)) {
					subMenu.add(action);
					subMenu.add(postAction);
				} else if (ACTION.equals(tabKey)) {
					subMenu.add(preAction);
					subMenu.add(postAction);
				} else if (POST_CONDITION.equals(tabKey)) {
					subMenu.add(preAction);
					subMenu.add(action);
				}

				// add the action to the submenu
				manager.add(subMenu);

				MenuManager copyToMenu = new MenuManager("Copy To", null);
				// Actions for the sub menu
				if (PRE_CONDITION.equals(tabKey)) {
					copyToMenu.add(copyAction);
					copyToMenu.add(copyPostAction);
				} else if (ACTION.equals(tabKey)) {
					copyToMenu.add(copyPreAction);
					copyToMenu.add(copyPostAction);
				} else if (POST_CONDITION.equals(tabKey)) {
					copyToMenu.add(copyPreAction);
					copyToMenu.add(copyAction);
				}

				// add the action to the submenu
				manager.add(copyToMenu);
				manager.add(stepIn);
				manager.add(stepOut);
			}
		});

		Menu menu = manager.createContextMenu(viewer.getControl());
		viewer.getControl().setMenu(menu);
	}

	private void testCaseStepOut(GraphViewer graphViewer, EObject eContainer) {
		TestCase testCase = (TestCase) eContainer;
		if (getTabular().getSelection()[0].getText().equalsIgnoreCase(PRE_CONDITION)) {
			graphViewer.setInput(testCase.getPreConditions());
		} else if (getTabular().getSelection()[0].getText().equalsIgnoreCase(ACTION)) {
			graphViewer.setInput(testCase.getTestSteps());
		} else if (getTabular().getSelection()[0].getText().equalsIgnoreCase(POST_CONDITION)) {
			graphViewer.setInput(testCase.getPostConditions());
		}
		graphViewer.refresh();
	}

	private void addTestStepToPreCondt(Iterator<?> iterator, boolean isCopy) {
		while (iterator.hasNext()) {
			TestStep testStep;
			if (isCopy) {
				testStep = EcoreUtil.copy((TestStep) iterator.next());
				testStep.setNextStep(null);
			} else {
				testStep = (TestStep) iterator.next();
				testStep.setNextStep(null);
			}
			if (!testCase.getPreConditions().isEmpty()) {
				testCase.getPreConditions()
						.get(testCase.getPreConditions().size() > 0 ? testCase.getPreConditions().size() - 1
								: testCase.getPreConditions().size())
						.setNextStep(testStep);
			}
			testCase.getPreConditions().add(testStep);
		}
	}

	private void addTestStepToAction(Iterator<?> iterator, boolean isCopy) {
		while (iterator.hasNext()) {
			TestStep testStep;
			if (isCopy) {
				testStep = EcoreUtil.copy((TestStep) iterator.next());
				testStep.setNextStep(null);
			} else {
				testStep = (TestStep) iterator.next();
				testStep.setNextStep(null);
			}
			if (!testCase.getTestSteps().isEmpty()) {
				testCase.getTestSteps().get(testCase.getTestSteps().size() > 0 ? testCase.getTestSteps().size() - 1
						: testCase.getTestSteps().size()).setNextStep(testStep);
			}
			testCase.getTestSteps().add(testStep);
		}
	}

	private void addTestStepToPostCondt(Iterator<?> iterator, boolean isCopy) {
		while (iterator.hasNext()) {
			TestStep testStep;
			if (isCopy) {
				testStep = EcoreUtil.copy((TestStep) iterator.next());
				testStep.setNextStep(null);
			} else {
				testStep = (TestStep) iterator.next();
				testStep.setNextStep(null);
			}
			if (!testCase.getPostConditions().isEmpty()) {
				testCase.getPostConditions()
						.get(testCase.getPostConditions().size() > 0 ? testCase.getPostConditions().size() - 1
								: testCase.getPostConditions().size())
						.setNextStep(testStep);
			}
			testCase.getPostConditions().add(testStep);
		}
	}

	private void removedSelectedNode(String tabKey, IStructuredSelection structSelection) {
		List<TestStep> testStepList = structSelection.toList();
		if (PRE_CONDITION.equals(tabKey)) {
			List<TestStep> indexOf = new ArrayList<TestStep>();
			EList<TestStep> preConditions = testCase.getPreConditions();
			testCaseDetailPage.removeGraphicalNode(testStepList, indexOf, preConditions);
		} else if (ACTION.equals(tabKey)) {
			List<TestStep> indexOf = new ArrayList<TestStep>();
			EList<TestStep> actions = testCase.getTestSteps();
			testCaseDetailPage.removeGraphicalNode(testStepList, indexOf, actions);
		} else if (POST_CONDITION.equals(tabKey)) {
			List<TestStep> indexOf = new ArrayList<TestStep>();
			EList<TestStep> postConditions = testCase.getPostConditions();
			testCaseDetailPage.removeGraphicalNode(testStepList, indexOf, postConditions);
		}
	}

	private void PostConditionTableRowClickListener() {
		postCondtTreeViewer.addDoubleClickListener(new IDoubleClickListener() {
			@Override
			public void doubleClick(DoubleClickEvent event) {

				Object oldValue = postCondtTreeViewer.getStructuredSelection().getFirstElement();

				editTestStepValues(oldValue);
				postCondtTreeViewer.refresh();
				refreshPostConditionGraphicalViewers();
			}
		});

		// GraphicalActionViewListener();

		postCondtTreeViewer.setContentProvider(new TestStepContentProvider());
		postCondtTreeViewer.setLabelProvider(new TestStepLabelProvider());

		String[] postconditionValue = new String[] { "action", "parameter", "operator", "value" };
		postCondtTreeViewer.setColumnProperties(postconditionValue);
	}

	private void PostConditionTableRowUpandDown() {
		// row up and down
		Transfer[] types = new Transfer[] { TextTransfer.getInstance() };
		DragSource source = new DragSource(postConditionTree, DND.DROP_MOVE);
		source.setTransfer(types);

		source.addDragListener(new DragSourceAdapter() {
			public void dragSetData(DragSourceEvent event) {
				// Get the selected items in the drag source
				DragSource ds = (DragSource) event.widget;
				postConditionTree = (Tree) ds.getControl();
				TreeItem[] selection = postConditionTree.getSelection();

				StringBuffer buff = new StringBuffer();
				for (int i = 0, n = selection.length; i < n; i++) {
					buff.append(selection[i].getText());
				}

				event.data = buff.toString();
			}

		});

		int operations = DND.DROP_COPY | DND.DROP_MOVE;
		Transfer[] transferTypes = new Transfer[] { TextTransfer.getInstance() };
		postCondtTreeViewer.addDropSupport(operations, transferTypes, new TestStepDropListener(postCondtTreeViewer));

	}

	public void update(TestCase testCase) {
		this.testCase = testCase;

		refreshActionViewer();

		refreshPreConditionGraphicalViewer();

		refreshPostConditionGraphicalViewers();

		// refreshCaplCode(testCase);

		// refreshPythonCode(testCase);

	}

	private void refreshPythonCode(TestCase testSpecification) {
		String generateCAPL = new PythonSourceGeneratorUtil().generatePython(testSpecification);
		txtpythonsource.setText(generateCAPL);
	}

	private void refreshActionViewer() {
		treeViewerAction.setInput(testCase.getTestSteps());
		actionGraphicalviewer.setInput(testCase.getTestSteps());
		actionGraphicalviewer.setLayoutAlgorithm(layout, true);
		actionGraphicalviewer.applyLayout();
		// txtActionSourceTab.setText(new
		// CAPLSourceGeneratorUtil().generateCAPL(testCase));
	}

	private void refreshPostConditionGraphicalViewers() {
		postCondtTreeViewer.setInput(testCase.getPostConditions());
		postConditionGraphicalviewer.setInput(testCase.getPostConditions());
		postConditionGraphicalviewer.setLayoutAlgorithm(postlayout, true);
		postConditionGraphicalviewer.applyLayout();
	}

	private void refreshPreConditionGraphicalViewer() {
		preCondtTreeViewer.setInput(testCase.getPreConditions());
		preConditionGraphicalviewer.setInput(testCase.getPreConditions());
		preConditionGraphicalviewer.setLayoutAlgorithm(preConditionlayout, true);
		preConditionGraphicalviewer.applyLayout();
	}

	public void refresh() {

		treeViewerAction.refresh();
		actionGraphicalviewer.refresh();
		actionGraphicalviewer.applyLayout();

		preCondtTreeViewer.refresh();
		preConditionGraphicalviewer.refresh();
		preConditionGraphicalviewer.applyLayout();

		postCondtTreeViewer.refresh();
		postConditionGraphicalviewer.refresh();
		postConditionGraphicalviewer.applyLayout();
	}

	public TreeViewer getActionViewer() {
		return treeViewerAction;
	}

	public TreeViewer getPreCondtViewer() {
		return preCondtTreeViewer;
	}

	public TreeViewer getPostCondtViewer() {
		return postCondtTreeViewer;
	}

	public GraphViewer getActionGraphicalviewer() {
		return actionGraphicalviewer;
	}

	public GraphViewer getPreConditionGraphicalviewer() {
		return preConditionGraphicalviewer;
	}

	public GraphViewer getPostConditionGraphicalviewer() {
		return postConditionGraphicalviewer;
	}

	private LayoutAlgorithm setLayout() {
		LayoutAlgorithm layout;
		layout = new TreeLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING);
		return layout;

	}

	public TabFolder getTabular() {
		return tabular;
	}

	private void GraphicalActionViewListener() {

		createViewerContextMenu(actionGraphicalviewer);

		// Graphical preConditionGraphicalviewer double click on nodes
		if (actionGraphicalviewer != null) {
			actionGraphicalviewer.getGraphControl().addMouseListener(new MouseAdapter() {

				@Override
				public void mouseDoubleClick(MouseEvent e) {

					Object oldValue = actionGraphicalviewer.getStructuredSelection().getFirstElement();

					editTestStepValues(oldValue);
					actionGraphicalviewer.refresh();
					treeViewerAction.refresh();
				}
			});

			actionGraphicalviewer.getControl().addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					setActiveViewer(actionGraphicalviewer);
				}
			});
		}
	}

	// postcondition

	private void GraphicalPostConditionListener() {

		createViewerContextMenu(postConditionGraphicalviewer);

		// Graphical preConditionGraphicalviewer double click on nodes
		if (postConditionGraphicalviewer != null) {

			postConditionGraphicalviewer.getGraphControl().addMouseListener(new MouseAdapter() {

				@Override
				public void mouseDoubleClick(MouseEvent e) {
					Object oldValue = postConditionGraphicalviewer.getStructuredSelection().getFirstElement();
					editTestStepValues(oldValue);
					postConditionGraphicalviewer.refresh();
					postCondtTreeViewer.refresh();

				}
			});

			postConditionGraphicalviewer.getControl().addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent e) {
					setActiveViewer(postConditionGraphicalviewer);
				}
			});
		}
	}

	private void setSignalType(TestStep testStep) {
		EList<SignalType> signalType = testSpecification.getImportArtifacts().get(0).getSignalType();
		if (!signalType.contains(testStep.getKey())) {
			signalType.add(testStep.getKey());
		}
	}

	private void editTestStepValues(Object oldValue) {
		if (oldValue instanceof CheckAction) {
			CheckAction checkAction = (CheckAction) oldValue;
			TestStepCheckDialog dialog = new TestStepCheckDialog(Display.getDefault().getActiveShell(),
					testSpecification, checkAction);
			int result = dialog.open();
			if (IDialogConstants.OK_ID == result) {

				checkAction.setTitle(dialog.getTitle());
				// checkAction.setWait(Float.parseFloat(dialog.getWait()));
				checkAction.setKey(dialog.getSignalType());
				checkAction.setOperator(OperatorTypeEnum.get(dialog.getCombo()));
				checkAction.setValue(dialog.getTxtValueFrom());
				// checkAction.setValueTo(dialog.getTxtValueTo());
				setSignalType(checkAction);
			}
		} else if (oldValue instanceof SetAction) {

			SetAction setAction = (SetAction) oldValue;
			EObject eContainer = setAction.eContainer();
			boolean loopflag = false;
			if (eContainer instanceof ForLoop) {
				loopflag = true;
			}
			TestStepSetDialog dialog = new TestStepSetDialog(Display.getDefault().getActiveShell(), testSpecification,
					setAction, loopflag);
			int result = dialog.open();

			if (IDialogConstants.OK_ID == result) {

				setAction.setTitle(dialog.getTitle());
				// setAction.setWait(Float.parseFloat(dialog.getWait()));
				setAction.setKey(dialog.getSignalType());
				if (loopflag) {
					ForLoop loopvar = (ForLoop)eContainer;
					setAction.setValue(loopvar.getLoopVar());
				}else {
					setAction.setValue(dialog.getValueFrom());
				
				}
				// setAction.setValueTo(dialog.getValueTo());
				setSignalType(setAction);
			}
		} else if (oldValue instanceof WaitAction) {

			WaitAction waitAction = (WaitAction) oldValue;
			TestStepWaitDialog dialog = new TestStepWaitDialog(Display.getDefault().getActiveShell(), testSpecification,
					waitAction);
			int result = dialog.open();

			if (IDialogConstants.OK_ID == result) {
				waitAction.setTitle(dialog.getTxtTime());
			}
		} else if (oldValue instanceof DiagnosticService) {

			DiagnosticService diagnosticService = (DiagnosticService) oldValue;
			TestStepDiagnosticDialog dialog = new TestStepDiagnosticDialog(Display.getDefault().getActiveShell(),
					testSpecification, diagnosticService);
			int result = dialog.open();

			if (IDialogConstants.OK_ID == result) {

				diagnosticService.setEcu(dialog.getEcu());
				diagnosticService.setService(dialog.getService());
				diagnosticService.setResult(dialog.getResult());
				setSignalType(diagnosticService);
			}
		} else if (oldValue instanceof DiagnosticRequest) {

			DiagnosticRequest diagnosticService = (DiagnosticRequest) oldValue;
			TestSteppDiagReqResDialog dialog = new TestSteppDiagReqResDialog(Display.getDefault().getActiveShell(),
					testSpecification, diagnosticService);
			int result = dialog.open();

			if (IDialogConstants.OK_ID == result) {

			}
		} else if (oldValue instanceof DiagnosticResponse) {

			DiagnosticResponse diagnosticService = (DiagnosticResponse) oldValue;
			TestSteppDiagReqResDialog dialog = new TestSteppDiagReqResDialog(Display.getDefault().getActiveShell(),
					testSpecification, diagnosticService);
			int result = dialog.open();

			if (IDialogConstants.OK_ID == result) {

			}
		} else if (oldValue instanceof CAPLParam) {
			CAPLParam caplParam = (CAPLParam) oldValue;
			TestStepCAPLParamDialog dialog = new TestStepCAPLParamDialog(Display.getDefault().getActiveShell(),
					caplParam);
			int result = dialog.open();

			if (IDialogConstants.OK_ID == result) {
				caplParam.setName(dialog.getTitle());
				caplParam.setType(dialog.getOpValue());
				caplParam.setValue(dialog.getParamValue());
			}
			// This is for WhileLoop
		} else if (oldValue instanceof WhileLoop) {
			WhileLoop whileParam = (WhileLoop) oldValue;

			TestStepWhileDialog dialog = new TestStepWhileDialog(Display.getDefault().getActiveShell(),
					testSpecification, whileParam);
			int result = dialog.open();

			if (IDialogConstants.OK_ID == result) {
				whileParam.setTitle(dialog.getWhileLoopTitle());
				whileParam.setKey(dialog.getSignalType());

			}
		}
		// This is for ForLoop
		else if (oldValue instanceof ForLoop) {
			ForLoop forAction = (ForLoop) oldValue;
			TestStepForDialog dialog = new TestStepForDialog(Display.getDefault().getActiveShell(), testSpecification,
					forAction);
			int result = dialog.open();
			if (IDialogConstants.OK_ID == result) {
				forAction.setTitle(dialog.getTitle());
				forAction.setLoopVar(dialog.getLoopvar());
				forAction.setStartValue(dialog.getStartValue());
				forAction.setStopValue(dialog.getStopValue());
			}
		}
	}

	public Viewer getActiveViewer() {
		return activeViewer;
	}

	public void setActiveViewer(Viewer activeViewer) {
		this.activeViewer = activeViewer;
	}
}