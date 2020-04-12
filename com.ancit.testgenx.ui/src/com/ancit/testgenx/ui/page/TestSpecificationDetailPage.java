package com.ancit.testgenx.ui.page;

import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.IDetailsPage;
import org.eclipse.ui.forms.IFormPart;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.widgets.Section;

import com.ancit.testgenx.ui.celleditor.SignalTypeCellEditor;
import com.ancit.testgenx.ui.celleditor.VariantCellEditor;
import com.ancit.testgenx.ui.dialogs.NewSignalTypeDialog;
import com.ancit.testgenx.ui.dialogs.NewVariantDialog;
import com.ancit.testgenx.ui.dialogs.TestImportsLabelProvider;

import DiagonosticModel.SignalType;
import DiagonosticModel.SignalTypeEnum;
import DiagonosticModel.impl.ImportArtifactImpl;
import DiagonosticModel.impl.TestSpecificationImpl;

public class TestSpecificationDetailPage implements IDetailsPage {

	TestSpecificationImpl testSpecificationImpl;
	private Text txtName;
	private Text txtVersion;
	private Text txtDescription;
	private Text txtAuthor;
	private Text txtFunctionName;
	private Text txtFunctionVersion;
	private IManagedForm form;
	private Section sctnSignalSysvar;
	private Section sctnVariant;
	private Composite composite;
	private Table tblSignal;
	private TableViewer signalTblViewer;
	private Section sctnImports;
	private Composite importsComposite;
	private Table tblImports;
	private TableViewer tblViewerImports;
	private TableColumn tblclmnType_1;
	private TableColumn tblclmnImportPath;
	private Action deleteParametersAction;
	private Action addParametersAction;
	private TabFolder tabFolder;
	private TabItem tbtmSignals;
	private Composite signalComposite;
	private TabItem tbtmEnvironmentVariables;
	private Composite environComposite;
	private Table tblEnvVar;
	private TableViewer envVarTblViewer;
	private TabItem tbtmSystemVariables;
	private Composite sysVarComposite;
	private Composite variantComposite;
	private Table tblSysVar;
	private Table tblVariant;
	private TableViewer sysVarTblViewer;
	private TableViewer variantTblViewer;
	private Action addVariantAction;
	private Action deleteVariantAction;
	private Viewer activeViewer;
	private Action deleteImportPathAction;
	private ControlDecoration txtNameControlDecoration;

	private boolean errorOnPage;

	public TestSpecificationDetailPage() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initialize(IManagedForm form) {
		this.form = form;

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isDirty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void commit(boolean onSave) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean setFormInput(Object input) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isStale() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void refresh() {
		update();
	}

	@Override
	public void selectionChanged(IFormPart part, ISelection selection) {

		ITreeSelection ssel = (ITreeSelection) selection;
		if (ssel.size() == 1) {
			testSpecificationImpl = (TestSpecificationImpl) ssel.getFirstElement();
			update();
			testSpecificationImpl.eAdapters().add(new EContentAdapter() {
				@Override
				public void notifyChanged(Notification notification) {
					super.notifyChanged(notification);
					signalTblViewer.refresh();
					envVarTblViewer.refresh();
					sysVarTblViewer.refresh();
					tblViewerImports.refresh();
					variantTblViewer.refresh();
				}
			});
		} else {
			testSpecificationImpl = null;
		}

	}

	// update values masterblock
	private void update() {
		// System.out.println("DBC Path =" + testSpecificationImpl.getDbcPath());
		txtName.setText(testSpecificationImpl.getName() != null && testSpecificationImpl.getName().length() > 0
				? testSpecificationImpl.getName()
				: "");
		txtVersion.setText(testSpecificationImpl.getVersion() != null ? testSpecificationImpl.getVersion() : "");
		txtDescription
				.setText(testSpecificationImpl.getDescription() != null ? testSpecificationImpl.getDescription() : "");
		txtAuthor.setText(testSpecificationImpl.getAuthor() != null ? testSpecificationImpl.getAuthor() : "");
		txtFunctionName.setText(
				testSpecificationImpl.getFunctionName() != null ? testSpecificationImpl.getFunctionName() : "");
		txtFunctionVersion.setText(
				testSpecificationImpl.getFunctionVersion() != null ? testSpecificationImpl.getFunctionVersion() : "");

		signalTblViewer.setInput(testSpecificationImpl.getSignals());
		tblViewerImports.setInput(testSpecificationImpl.getImportArtifacts());
		envVarTblViewer.setInput(testSpecificationImpl.getSignals());
		sysVarTblViewer.setInput(testSpecificationImpl.getSignals());
		variantTblViewer.setInput(testSpecificationImpl.getVariants());

	}

	@Override
	public void createContents(Composite parent) {

		parent.setLayout(new GridLayout(2, false));

		Label lblName = form.getToolkit().createLabel(parent, "Name:", SWT.NONE);
		lblName.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		lblName.setText("Name:");

		txtName = new Text(parent, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		txtName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		txtNameControlDecoration = new ControlDecoration(txtName, SWT.LEFT | SWT.TOP);
//		txtNameControlDecoration.setDescriptionText("Test Specification Name cannot be Empty");
		txtNameControlDecoration
				.setImage(PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_DEC_FIELD_ERROR));
		txtNameControlDecoration.hide();
		// txtName.setText("");
		txtName.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
			
			}

			@Override
			public void focusGained(FocusEvent e) {
				if (!txtName.getText().isEmpty()) {
					testSpecificationImpl.setName(txtName.getText());
					txtNameControlDecoration.hide();
				} else {
					testSpecificationImpl.setName("");
					txtNameControlDecoration.show();
					txtNameControlDecoration.showHoverText("Test Specification Name cannot be Empty");
				}
			}
		});

		txtName.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				if (!txtName.getText().isEmpty()) {
					testSpecificationImpl.setName(txtName.getText());
					Pattern pattern = Pattern.compile("\\p{javaJavaIdentifierStart}\\p{javaJavaIdentifierPart}*");
					boolean matches = pattern.matcher(((Text)e.widget).getText()).matches();
					if(!matches) {
						txtNameControlDecoration.show();
						txtNameControlDecoration.showHoverText("Test Specification Name is not well formed. Cannot start with Number.");
					} else {
						txtNameControlDecoration.hide();
					}
				} else {
					testSpecificationImpl.setName("");
					txtNameControlDecoration.show();
//					txtNameControlDecoration.showHoverText("Test Specification Name cannot be Empty");
				}

			}
		});

//		 text field validation

//		txtName.addVerifyListener(new VerifyListener() {
//
//			@Override
//			public void verifyText(VerifyEvent e) {
//				
//				if(((Text)e.widget).getText().isEmpty()) {
//					e.doit  = true;
//				}
//				
//				char charAt = ((Text)e.widget).getText().charAt(0);
//				if(Character.isDigit(charAt)) {
//					e.doit = false;
//				} else {
//					e.doit = true;
//				}
//			}
//		});

		Label lblVersion = form.getToolkit().createLabel(parent, "Version:", SWT.NONE);
		lblVersion.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		lblVersion.setText("Version:");

		txtVersion = new Text(parent, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		txtVersion.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		txtVersion.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				if (!txtVersion.getText().isEmpty()) {
					testSpecificationImpl.setVersion(txtVersion.getText());
				}

			}
		});

		Label lblDescription = form.getToolkit().createLabel(parent, "Description:", SWT.NONE);
		lblDescription.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		lblDescription.setText("Description:");

		txtDescription = new Text(parent, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		txtDescription.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		txtDescription.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {

				if (!txtDescription.getText().isEmpty()) {
					testSpecificationImpl.setDescription(txtDescription.getText());

				}
			}
		});

		Label lblAuthor = form.getToolkit().createLabel(parent, "Author:", SWT.NONE);
		lblAuthor.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		lblAuthor.setText("Author:");

		txtAuthor = new Text(parent, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		txtAuthor.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		txtAuthor.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				if (!txtAuthor.getText().isEmpty()) {
					testSpecificationImpl.setAuthor(txtAuthor.getText());
				}

			}
		});

		/*
		 * txtAuthor.addVerifyListener(new VerifyListener() {
		 * 
		 * @Override public void verifyText(VerifyEvent e) { for (int i = 0; i <
		 * e.text.length(); i++) { if (!Character.isAlphabetic(e.text.charAt(i))) {
		 * e.doit = false; txtAuthor.setMessage("please enter charcter only"); } return;
		 * } } });
		 */

		Label lblFunctionName = form.getToolkit().createLabel(parent, "Function Name:", SWT.NONE);
		lblFunctionName.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		lblFunctionName.setText("Function Name:");

		txtFunctionName = new Text(parent, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		txtFunctionName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		txtFunctionName.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				if (!txtFunctionName.getText().isEmpty()) {
					testSpecificationImpl.setFunctionName(txtFunctionName.getText());

				}
			}
		});

		Label lblFunctionVersion = form.getToolkit().createLabel(parent, "Function Version:", SWT.NONE);
		lblFunctionVersion.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		lblFunctionVersion.setText("Function Version:");

		txtFunctionVersion = new Text(parent, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		txtFunctionVersion.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		txtFunctionVersion.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				if (!txtFunctionName.getText().isEmpty()) {

					testSpecificationImpl.setFunctionVersion(txtFunctionVersion.getText());
				}

			}
		});

		createImports(parent);

		createParametersSection(parent);

		createVariantSection(parent);
	}

	private void createParametersSection(Composite parent) {

		sctnSignalSysvar = form.getToolkit().createSection(parent,
				Section.EXPANDED | Section.TWISTIE | Section.TITLE_BAR);
		GridData gd_sctnSignalSysvar = new GridData(SWT.FILL, SWT.TOP, true, false);
		gd_sctnSignalSysvar.horizontalSpan = 2;
		sctnSignalSysvar.setLayoutData(gd_sctnSignalSysvar);
		form.getToolkit().paintBordersFor(sctnSignalSysvar);
		sctnSignalSysvar.setText("Signal / SysVar / Environment Var");

		composite = form.getToolkit().createComposite(sctnSignalSysvar, SWT.NONE);
		form.getToolkit().paintBordersFor(composite);
		sctnSignalSysvar.setClient(composite);
		composite.setLayout(new GridLayout(1, false));

		createSectionToolBar();

		tabFolder = new TabFolder(composite, SWT.NONE);
		tabFolder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1));
		form.getToolkit().adapt(tabFolder);
		form.getToolkit().paintBordersFor(tabFolder);

		createSignalTab();

		createEnvVariableTab();

		createSystemVariableTab();

	}

	private void createSignalTab() {
		tbtmSignals = new TabItem(tabFolder, SWT.NONE);
		tbtmSignals.setText("Signals");

		signalComposite = form.getToolkit().createComposite(tabFolder, SWT.NONE);
		tbtmSignals.setControl(signalComposite);
		form.getToolkit().paintBordersFor(signalComposite);
		signalComposite.setLayout(new GridLayout(1, false));

		signalTblViewer = new TableViewer(signalComposite, SWT.BORDER | SWT.FULL_SELECTION | SWT.MULTI);
		tblSignal = signalTblViewer.getTable();
		tblSignal.setLinesVisible(true);
		tblSignal.setHeaderVisible(true);
		GridData gd_table = new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1);
		gd_table.heightHint = 176;
		tblSignal.setLayoutData(gd_table);
		form.getToolkit().paintBordersFor(tblSignal);

		TableColumn tblclmnParamName = new TableColumn(tblSignal, SWT.NONE);
		tblclmnParamName.setWidth(100);
		tblclmnParamName.setText("Param Name");

		TableColumn tblclmnType = new TableColumn(tblSignal, SWT.NONE);
		tblclmnType.setWidth(100);
		tblclmnType.setText("Type");

		TableColumn tblclmnCrtMode = new TableColumn(tblSignal, SWT.NONE);
		tblclmnCrtMode.setWidth(25);

		// tableViewer.setCellModifier(new ActionCellModifier(tableViewer));
		String[] actionValue = new String[] { "Param Name", "Type", "Creation Mode" };
		signalTblViewer.setColumnProperties(actionValue);

		signalTblViewer.setContentProvider(new ArrayContentProvider());
		signalTblViewer.setLabelProvider(new TestSpecLabelProvider());

		signalTblViewer.addFilter(new ViewerFilter() {

			@Override
			public boolean select(Viewer viewer, Object parentElement, Object element) {
				if (element instanceof SignalType) {
					SignalType signalType = (SignalType) element;
					if (signalType.getType().equals(SignalTypeEnum.SIGNAL)) {
						return true;
					}
				}
				return false;
			}
		});

		tblSignal.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				setActiveViewer(signalTblViewer);
			}
		});

		TableColumn[] columns = tblSignal.getColumns();

		CellEditor[] cellEditor = new CellEditor[columns.length > 0 ? columns.length - 1 : columns.length];

		TextCellEditor text = new TextCellEditor(tblSignal);
		cellEditor[0] = text;

		ComboBoxCellEditor comBoxCellEditor = new ComboBoxCellEditor(tblSignal, getComboItems());
		cellEditor[1] = comBoxCellEditor;

		String[] columnString = new String[] { "Param Name", "Type" };
		signalTblViewer.setCellEditors(cellEditor);
		signalTblViewer.setCellModifier(new SignalTypeCellEditor(signalTblViewer, getComboItems()));
		signalTblViewer.setColumnProperties(columnString);
		signalTblViewer.getControl().addKeyListener(deleteKeyListener);

	}

	private void createSystemVariableTab() {
		tbtmSystemVariables = new TabItem(tabFolder, SWT.NONE);
		tbtmSystemVariables.setText("System Variables");

		sysVarComposite = form.getToolkit().createComposite(tabFolder, SWT.NONE);
		tbtmSystemVariables.setControl(sysVarComposite);
		form.getToolkit().paintBordersFor(sysVarComposite);
		sysVarComposite.setLayout(new GridLayout(1, false));

		sysVarTblViewer = new TableViewer(sysVarComposite, SWT.BORDER | SWT.FULL_SELECTION | SWT.MULTI);
		tblSysVar = sysVarTblViewer.getTable();
		tblSysVar.setLinesVisible(true);
		tblSysVar.setHeaderVisible(true);
		tblSysVar.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		form.getToolkit().paintBordersFor(tblSysVar);

		TableColumn tblclmnParamName = new TableColumn(tblSysVar, SWT.NONE);
		tblclmnParamName.setWidth(100);
		tblclmnParamName.setText("Param Name");

		TableColumn tblclmnType = new TableColumn(tblSysVar, SWT.NONE);
		tblclmnType.setWidth(100);
		tblclmnType.setText("Type");

		TableColumn tblclmnCrtMode = new TableColumn(tblSysVar, SWT.NONE);
		tblclmnCrtMode.setWidth(25);

		TableColumn tblclmnNamespace = new TableColumn(tblSysVar, SWT.NONE);
		tblclmnNamespace.setWidth(150);
		tblclmnNamespace.setText("Namespace");

		sysVarTblViewer.setContentProvider(ArrayContentProvider.getInstance());
		sysVarTblViewer.setLabelProvider(new TestSpecLabelProvider());

		sysVarTblViewer.addFilter(new ViewerFilter() {

			@Override
			public boolean select(Viewer viewer, Object parentElement, Object element) {
				if (element instanceof SignalType) {
					SignalType signalType = (SignalType) element;
					if (signalType.getType().equals(SignalTypeEnum.SYSTEM)) {
						return true;
					}
				}
				return false;
			}
		});

		tblSysVar.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				setActiveViewer(sysVarTblViewer);
			}
		});

		TableColumn[] columns = tblSysVar.getColumns();

		CellEditor[] cellEditor = new CellEditor[columns.length];

		TextCellEditor text = new TextCellEditor(tblSysVar);
		cellEditor[0] = text;

		ComboBoxCellEditor comBoxCellEditor = new ComboBoxCellEditor(tblSysVar, getComboItems());
		cellEditor[1] = comBoxCellEditor;

		cellEditor[3] = text;

		String[] columnString = new String[] { "Param Name", "Type", "Creation Mode", "Namespace" };
		sysVarTblViewer.setCellEditors(cellEditor);
		sysVarTblViewer.setCellModifier(new SignalTypeCellEditor(signalTblViewer, getComboItems()));
		sysVarTblViewer.setColumnProperties(columnString);
		sysVarTblViewer.getControl().addKeyListener(deleteKeyListener);
	}

	private void createEnvVariableTab() {
		tbtmEnvironmentVariables = new TabItem(tabFolder, SWT.NONE);
		tbtmEnvironmentVariables.setText("Environment Variables");

		environComposite = form.getToolkit().createComposite(tabFolder, SWT.NONE);
		tbtmEnvironmentVariables.setControl(environComposite);
		form.getToolkit().paintBordersFor(environComposite);
		environComposite.setLayout(new GridLayout(1, false));

		envVarTblViewer = new TableViewer(environComposite, SWT.BORDER | SWT.FULL_SELECTION | SWT.MULTI);
		tblEnvVar = envVarTblViewer.getTable();
		tblEnvVar.setLinesVisible(true);
		tblEnvVar.setHeaderVisible(true);
		tblEnvVar.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		form.getToolkit().paintBordersFor(tblEnvVar);

		TableColumn tblclmnParamName = new TableColumn(tblEnvVar, SWT.NONE);
		tblclmnParamName.setWidth(100);
		tblclmnParamName.setText("Param Name");

		TableColumn tblclmnType = new TableColumn(tblEnvVar, SWT.NONE);
		tblclmnType.setWidth(100);
		tblclmnType.setText("Type");

		TableColumn tblClmnCrtMode = new TableColumn(tblEnvVar, SWT.NONE);
		tblClmnCrtMode.setWidth(25);

		envVarTblViewer.setContentProvider(ArrayContentProvider.getInstance());
		envVarTblViewer.setLabelProvider(new TestSpecLabelProvider());

		envVarTblViewer.addFilter(new ViewerFilter() {

			@Override
			public boolean select(Viewer viewer, Object parentElement, Object element) {
				if (element instanceof SignalType) {
					SignalType signalType = (SignalType) element;
					if (signalType.getType().equals(SignalTypeEnum.ENVIRONMENT)) {
						return true;
					}
				}
				return false;
			}
		});

		tblEnvVar.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				setActiveViewer(envVarTblViewer);
			}
		});

		TableColumn[] columns = tblEnvVar.getColumns();

		CellEditor[] cellEditor = new CellEditor[columns.length > 0 ? columns.length - 1 : columns.length];

		TextCellEditor text = new TextCellEditor(tblEnvVar);
		cellEditor[0] = text;

		ComboBoxCellEditor comBoxCellEditor = new ComboBoxCellEditor(tblEnvVar, getComboItems());
		cellEditor[1] = comBoxCellEditor;

		String[] columnString = new String[] { "Param Name", "Type" };
		envVarTblViewer.setCellEditors(cellEditor);
		envVarTblViewer.setCellModifier(new SignalTypeCellEditor(envVarTblViewer, getComboItems()));
		envVarTblViewer.setColumnProperties(columnString);
		envVarTblViewer.getControl().addKeyListener(deleteKeyListener);
	}

	private String[] getComboItems() {
		List<String> enumNames = Stream.of(SignalTypeEnum.values()).map(SignalTypeEnum::name)
				.collect(Collectors.toList());
		enumNames.remove(0);
		String[] strings = enumNames.stream().toArray(String[]::new);
		return strings;
	}

	private void createVariantSection(Composite parent) {

		sctnVariant = form.getToolkit().createSection(parent, Section.EXPANDED | Section.TWISTIE | Section.TITLE_BAR);
		GridData gd_sctnSignalSysvar = new GridData(SWT.FILL, SWT.FILL, true, true);
		gd_sctnSignalSysvar.horizontalSpan = 2;
		sctnVariant.setLayoutData(gd_sctnSignalSysvar);
		form.getToolkit().paintBordersFor(sctnVariant);
		sctnVariant.setText("Variants");

		composite = form.getToolkit().createComposite(sctnVariant, SWT.NONE);
		form.getToolkit().paintBordersFor(composite);
		sctnVariant.setClient(composite);
		composite.setLayout(new GridLayout(1, false));

		createVariantSectionToolBar();

		tabFolder = new TabFolder(composite, SWT.NONE);
		tabFolder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		form.getToolkit().adapt(tabFolder);
		form.getToolkit().paintBordersFor(tabFolder);

		createVariantTab();
	}

	private void createVariantTab() {
		tbtmSystemVariables = new TabItem(tabFolder, SWT.NONE);
		tbtmSystemVariables.setText("Variant Variables");

		variantComposite = form.getToolkit().createComposite(tabFolder, SWT.NONE);
		tbtmSystemVariables.setControl(variantComposite);
		form.getToolkit().paintBordersFor(variantComposite);
		variantComposite.setLayout(new GridLayout(1, false));

		variantTblViewer = new TableViewer(variantComposite, SWT.BORDER | SWT.FULL_SELECTION);
		tblVariant = variantTblViewer.getTable();
		tblVariant.setLinesVisible(true);
		tblVariant.setHeaderVisible(true);
		tblVariant.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		form.getToolkit().paintBordersFor(tblVariant);

		TableColumn tblclmnParamName = new TableColumn(tblVariant, SWT.NONE);
		tblclmnParamName.setWidth(100);
		tblclmnParamName.setText("Name");

		TableColumn tblclmnType = new TableColumn(tblVariant, SWT.NONE);
		tblclmnType.setWidth(400);
		tblclmnType.setText("Description");

		variantTblViewer.setContentProvider(ArrayContentProvider.getInstance());
		variantTblViewer.setLabelProvider(new TestSpecLabelProvider());

		TableColumn[] columns = tblVariant.getColumns();
		CellEditor[] cellEditor = new CellEditor[columns.length];
		for (int i = 0; i < cellEditor.length; i++) {
			TextCellEditor text = new TextCellEditor(tblVariant);
			cellEditor[i] = text;
		}

		String[] columnString = new String[] { "Name", "Description" };
		variantTblViewer.setCellEditors(cellEditor);
		variantTblViewer.setCellModifier(new VariantCellEditor(variantTblViewer));
		variantTblViewer.setColumnProperties(columnString);
		variantTblViewer.getControl().addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.keyCode == SWT.DEL) {
					deleteVariants();
				}
			}
		});

	}

	private void createSectionToolBar() {
		ToolBarManager toolBarManager = new ToolBarManager(SWT.FLAT);
		ToolBar toolbar = toolBarManager.createControl(sctnSignalSysvar);
		toolbar.setCursor(Display.getDefault().getSystemCursor(SWT.CURSOR_HAND));

		addParametersAction = new Action("Add") {
			@Override
			public void run() {

				// TestSpecification testSpecification = (TestSpecification)
				// caseImpl.eContainer().eContainer();

				NewSignalTypeDialog dialog = new NewSignalTypeDialog(Display.getDefault().getActiveShell(),
						testSpecificationImpl);
				int result = dialog.open();

				if (IDialogConstants.OK_ID == result) {

					testSpecificationImpl.getImportArtifacts().get(0).getSignalType().add(dialog.getSignalType());
					update();
					signalTblViewer.refresh();
					envVarTblViewer.refresh();
					sysVarTblViewer.refresh();
				}

			}
		};

		ISharedImages sharedImages = PlatformUI.getWorkbench().getSharedImages();
		ImageDescriptor imageDescriptor = sharedImages.getImageDescriptor(ISharedImages.IMG_OBJ_ADD);
		addParametersAction.setImageDescriptor(imageDescriptor);

		deleteParametersAction = new Action("Delete") {
			@Override
			public void run() {
				deleteParameters();
				super.run();
			}
		};

		imageDescriptor = sharedImages.getImageDescriptor(ISharedImages.IMG_ETOOL_DELETE);
		deleteParametersAction.setImageDescriptor(imageDescriptor);

		toolBarManager.add(addParametersAction);
		toolBarManager.add(deleteParametersAction);
		sctnSignalSysvar.setTextClient(toolbar);
		toolBarManager.update(true);
	}

	private void createVariantSectionToolBar() {
		ToolBarManager toolBarManager = new ToolBarManager(SWT.FLAT);
		ToolBar toolbar = toolBarManager.createControl(sctnVariant);
		toolbar.setCursor(Display.getDefault().getSystemCursor(SWT.CURSOR_HAND));

		addVariantAction = new Action("Add") {
			@Override
			public void run() {

				NewVariantDialog dialog = new NewVariantDialog(Display.getDefault().getActiveShell());
				int result = dialog.open();

				if (IDialogConstants.OK_ID == result) {
					testSpecificationImpl.getVariants().add(dialog.getVariant());
					variantTblViewer.refresh();
				}

			}
		};

		ISharedImages sharedImages = PlatformUI.getWorkbench().getSharedImages();
		ImageDescriptor imageDescriptor = sharedImages.getImageDescriptor(ISharedImages.IMG_OBJ_ADD);
		addVariantAction.setImageDescriptor(imageDescriptor);

		deleteVariantAction = new Action("Delete") {
			@Override
			public void run() {
				deleteVariants();
				super.run();
			}
		};

		imageDescriptor = sharedImages.getImageDescriptor(ISharedImages.IMG_ETOOL_DELETE);
		deleteVariantAction.setImageDescriptor(imageDescriptor);

		toolBarManager.add(addVariantAction);
		toolBarManager.add(deleteVariantAction);
		sctnVariant.setTextClient(toolbar);
		toolBarManager.update(true);
	}

	private void createImports(Composite parent) {
		sctnImports = form.getToolkit().createSection(parent, Section.EXPANDED | Section.TWISTIE | Section.TITLE_BAR);
		sctnImports.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 2, 1));
		form.getToolkit().paintBordersFor(sctnImports);
		sctnImports.setText("Imports");

		importsComposite = form.getToolkit().createComposite(sctnImports, SWT.NONE);
		form.getToolkit().paintBordersFor(importsComposite);
		sctnImports.setClient(importsComposite);
		importsComposite.setLayout(new GridLayout(1, false));

		deleteFromImportFilePathToolBar();

		tblViewerImports = new TableViewer(importsComposite, SWT.BORDER | SWT.FULL_SELECTION);
		tblImports = tblViewerImports.getTable();
		tblImports.setHeaderVisible(true);
		tblImports.setLinesVisible(true);
		GridData gd_tblImports = new GridData(SWT.FILL, SWT.FILL, true, false, 1, 1);
		gd_tblImports.heightHint = 109;
		tblImports.setLayoutData(gd_tblImports);
		form.getToolkit().paintBordersFor(tblImports);

		tblclmnType_1 = new TableColumn(tblImports, SWT.NONE);
		tblclmnType_1.setWidth(100);
		tblclmnType_1.setText("Type");

		tblclmnImportPath = new TableColumn(tblImports, SWT.NONE);
		tblclmnImportPath.setWidth(400);
		tblclmnImportPath.setText("Import Path");

		String[] actionValue = new String[] { "Type", "Import Path" };
		tblViewerImports.setColumnProperties(actionValue);

		// TestSpecification specification =
		// DiagonosticModelFactory.eINSTANCE.createTestSpecification();
		// specification.getSignalType();

		tblViewerImports.setContentProvider(ArrayContentProvider.getInstance());
		tblViewerImports.setLabelProvider(new TestImportsLabelProvider());
		tblViewerImports.addFilter(new ViewerFilter() {

			@Override
			public boolean select(Viewer viewer, Object parentElement, Object element) {
				// TODO Auto-generated method stub
				ImportArtifactImpl firstElement = (ImportArtifactImpl) element;
				if (!firstElement.getPath().equals("USERDEFINED")) {
					return true;
				}
				return false;
			}
		});

		tblViewerImports.getControl().addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.keyCode == SWT.DEL) {
					deleteImportArtifacts();
				}
			}
		});

	}

	private void deleteFromImportFilePathToolBar() {
		ToolBarManager toolBarManager = new ToolBarManager(SWT.FLAT);
		ToolBar toolbar = toolBarManager.createControl(sctnImports);
		toolbar.setCursor(Display.getDefault().getSystemCursor(SWT.CURSOR_HAND));

		deleteImportPathAction = new Action("Delete") {
			@Override
			public void run() {
				deleteImportArtifacts();
				super.run();
			}
		};
		ISharedImages sharedImages = PlatformUI.getWorkbench().getSharedImages();
		ImageDescriptor imageDescriptor = sharedImages.getImageDescriptor(ISharedImages.IMG_ETOOL_DELETE);
		deleteImportPathAction.setImageDescriptor(imageDescriptor);
		ImageDescriptor disableDeleteimg = sharedImages.getImageDescriptor(ISharedImages.IMG_ETOOL_DELETE_DISABLED);
		deleteImportPathAction.setDisabledImageDescriptor(disableDeleteimg);
		toolBarManager.add(deleteImportPathAction);
		sctnImports.setTextClient(toolbar);
		toolBarManager.update(true);
	}

	public void setActiveViewer(Viewer activeViewer) {
		this.activeViewer = activeViewer;
	}

	public Viewer getActiveViewer() {
		return activeViewer;
	}

	private void deleteParameters() {
		IStructuredSelection slc = (IStructuredSelection) getActiveViewer().getSelection();
		List<?> signalTypeList = slc.toList();

		if (!signalTypeList.isEmpty()) {

			int response = confirmMessageBox();
			if (response == SWT.YES) {
				testSpecificationImpl.getImportArtifacts().get(0).getSignalType().removeAll(signalTypeList);
				getActiveViewer().refresh();
			}
		}
	}

	private void deleteVariants() {
		ISelection selection = variantTblViewer.getSelection();
		if (!selection.isEmpty()) {
			Iterator<?> iterator = ((IStructuredSelection) selection).iterator();
			while (iterator.hasNext()) {
				Object object = iterator.next();
				int response = confirmMessageBox();
				if (response == SWT.YES) {
					testSpecificationImpl.getVariants().remove(object);
					variantTblViewer.refresh();
				}
			}
		}
	}

	KeyAdapter deleteKeyListener = new KeyAdapter() {
		@Override
		public void keyPressed(KeyEvent e) {
			if (e.keyCode == SWT.DEL) {
				deleteParameters();
			}
		}
	};

	private void deleteImportArtifacts() {
		IStructuredSelection slc = (IStructuredSelection) tblViewerImports.getSelection();
		if (slc.isEmpty()) {
			return;
		}
		ImportArtifactImpl firstElement = (ImportArtifactImpl) slc.getFirstElement();
		if (!firstElement.getPath().equals("USERDEFINED")) {
			List<?> signalTypeList = slc.toList();

			if (!signalTypeList.isEmpty()) {

				int response = confirmMessageBox();
				if (response == SWT.YES) {
					testSpecificationImpl.getImportArtifacts().removeAll(signalTypeList);
					signalTblViewer.refresh();
					envVarTblViewer.refresh();
					sysVarTblViewer.refresh();
				}
			}
		} else {
			deleteImportPathAction.setEnabled(false);
		}
	}

	private int confirmMessageBox() {
		MessageBox messageBox = new MessageBox(Display.getDefault().getActiveShell(),
				SWT.ICON_QUESTION | SWT.YES | SWT.NO);
		messageBox.setMessage("Are You Sure Delete?");
		messageBox.setText("Delete ");
		int response = messageBox.open();
		return response;
	}

	public boolean isErrorOnPage() {
		if (txtNameControlDecoration != null) {
			return txtNameControlDecoration.isVisible();
		} else {
			return false;
		}
	}
}
