package com.ancit.testgenx.ui.page;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.TreeItem;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ListSelectionDialog;
import org.eclipse.ui.forms.IDetailsPage;
import org.eclipse.ui.forms.IFormPart;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.wb.swt.ResourceManager;

import com.ancit.testgenx.ui.celleditor.TracebilityCellEditor;
import com.ancit.testgenx.ui.celleditor.VariantCellEditor;
import com.ancit.testgenx.ui.dialogs.TestStepCheckDialog;
import com.ancit.testgenx.ui.dialogs.TestStepDiagnosticDialog;
import com.ancit.testgenx.ui.dialogs.TestStepForDialog;
import com.ancit.testgenx.ui.dialogs.TestStepSetDialog;
import com.ancit.testgenx.ui.dialogs.TestStepWaitDialog;
import com.ancit.testgenx.ui.dialogs.TestStepWhileDialog;
import com.ancit.testgenx.ui.dialogs.VariantListDialog;
import com.ancit.testgenx.ui.provider.TracebilityLabelProvider;
import com.ancit.testgenx.ui.utils.Activator;
import com.ancit.testgenx.ui.utils.CAPLFileParser;

import DiagonosticModel.CAPLParam;
import DiagonosticModel.CAPLTestStep;
import DiagonosticModel.CheckAction;
import DiagonosticModel.DiagnosticService;
import DiagonosticModel.DiagonosticModelFactory;
import DiagonosticModel.ExecutionStatueTypeEnum;
import DiagonosticModel.ForLoop;
import DiagonosticModel.OperatorTypeEnum;
import DiagonosticModel.TestCase;
import DiagonosticModel.TestSpecification;
import DiagonosticModel.TestStep;
import DiagonosticModel.TraceabilityArtifactEnum;
import DiagonosticModel.TracebilityArtifact;
import DiagonosticModel.Variant;
import DiagonosticModel.WhileLoop;
import DiagonosticModel.impl.TestCaseImpl;

public class TestCaseDetailPage implements IDetailsPage {
	private static final String POST_CONDITION = "PostCondition";
	private static final String ACTION = "Action";
	private static final String PRE_CONDITION = "PreCondition";

	public TestCaseDetailPage() {
	}

	private Action addWaitAction;
	private Action addsetAction;
	private Action addCheckAction;
	private Action deleteAction;
	private Action whileAction;
	private Action addForAction;
	TestCase testCase;
	Text txtID;
	private Text txtTestName;
	List<String> al = new ArrayList<String>();
	private Text textvalue;
	private FormToolkit formToolkit;
	private Action caplFileImportAction;
	private TestActionsDetailsComposite testActionsDetailsComposite;
	private Text txtVariant;
	private Text txtRequirementID;
	private Label txtExecutionStatus;
	private TestSpecification testSpecification;
	private WhileLoop whileLoop;
	private ForLoop forLoop;
	private Action addDiagnosticAction;
	private ControlDecoration txtNameControlDecoration;
	private Text txtDescription;
	private TableViewer tracebilityTblViewer;

	@Override
	public void initialize(IManagedForm mform) {
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
		// TODO Auto-generated method stub

		update();
	}

	@Override
	public void selectionChanged(IFormPart part, ISelection selection) {

		ITreeSelection ssel = (ITreeSelection) selection;
		if (ssel.size() == 1) {
			testCase = (TestCaseImpl) ssel.getFirstElement();
			testCase.getVariants();
			update();
			EObject rootContainer = EcoreUtil.getRootContainer(testCase);
			if (rootContainer instanceof TestSpecification) {
				this.testSpecification = (TestSpecification) rootContainer;
				setVariantValue(testCase, this.testSpecification);
				if (testActionsDetailsComposite != null) {
					testActionsDetailsComposite.setTestSpecification(this.testSpecification);
				}
			}

		} else {
			testCase = null;
		}
	}

	private void setVariantValue(TestCase testCase, TestSpecification testSpecification) {
		EList<Variant> testSpecVariants = testSpecification.getVariants();
		StringBuilder variants = new StringBuilder();
		EList<Variant> variantList = testCase.getVariants();
		if (variantList != null && !variantList.isEmpty()) {
			for (Iterator<Variant> iterator = variantList.iterator(); iterator.hasNext();) {
				Variant variant = iterator.next();
				if (testSpecVariants.contains(variant)) {
					variants.append(variant.getName() + ",");
				} else {
					iterator.remove();
				}
			}

			if (!variants.toString().isEmpty()) {
				variants.deleteCharAt((variants.length() > 0) ? (variants.length() - 1) : 0);
				txtVariant.setText(variants.toString());
			}
		}
	}

	// update values masterblock
	private void update() {
		txtID.setText(testCase.getId() != null ? testCase.getId() : "");
		txtTestName.setText(testCase.getName() != null && testCase.getName().length() > 0 ? testCase.getName() : "");
		txtRequirementID.setText(testCase.getRequirementID() != null ? testCase.getRequirementID() : "");
		txtDescription.setText(testCase.getDescription() != null ? testCase.getDescription() : "");
		if (testActionsDetailsComposite != null) {
			testActionsDetailsComposite.update(testCase);
		}
		txtExecutionStatus.setText(testCase.getExecutionStatus().getLiteral());
		if (testCase.getExecutionStatus().equals(ExecutionStatueTypeEnum.NOT_EXECUTED)) {
			txtExecutionStatus.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_YELLOW));
		} else if (testCase.getExecutionStatus().equals(ExecutionStatueTypeEnum.PASS)) {
			txtExecutionStatus.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_GREEN));
		} else if (testCase.getExecutionStatus().equals(ExecutionStatueTypeEnum.FAIL)) {
			txtExecutionStatus.setBackground(Display.getDefault().getSystemColor(SWT.COLOR_RED));
		}
		
		tracebilityTblViewer.setInput(testCase.getTraceabilityArtifacts());

	}

	@Override
	public void createContents(Composite parent) {

		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		composite.setLayout(new GridLayout(5, false));

		parent.setLayout(new GridLayout(1, false));

		Label lblTestKey = new Label(composite, SWT.NONE);
		lblTestKey.setText("TestCase Name: ");

		txtTestName = new Text(composite, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		txtTestName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		txtNameControlDecoration = new ControlDecoration(txtTestName, SWT.LEFT | SWT.TOP);
		// txtNameControlDecoration.setDescriptionText("Test Case Name cannot be
		// Empty");
		txtNameControlDecoration
				.setImage(PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_DEC_FIELD_ERROR));
		txtNameControlDecoration.hide();
		// txtName.setText("");

		txtTestName.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {

			}

			@Override
			public void focusGained(FocusEvent e) {
				if (!txtTestName.getText().isEmpty()) {
					testCase.setName(txtTestName.getText());
					txtNameControlDecoration.hide();
				} else {
					testCase.setName("");
					txtNameControlDecoration.show();
					txtNameControlDecoration.showHoverText("Test Case Name cannot be Empty");
				}

			}
		});
		txtTestName.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				if (!txtTestName.getText().isEmpty()) {
					testCase.setName(txtTestName.getText());
					Pattern pattern = Pattern.compile("\\p{javaJavaIdentifierStart}\\p{javaJavaIdentifierPart}*");
					boolean matches = pattern.matcher(((Text) e.widget).getText()).matches();
					if (!matches) {
						txtNameControlDecoration.show();
						txtNameControlDecoration
								.showHoverText("Test Case Name is not well formed. Cannot start with Number.");
					} else {
						txtNameControlDecoration.hide();
					}
				} else {
					testCase.setName("");
					txtNameControlDecoration.show();
					// txtNameControlDecoration.showHoverText("Test Case Name cannot be Empty");
				}

			}
		});

		txtTestName.addVerifyListener(new VerifyListener() {

			@Override
			public void verifyText(VerifyEvent e) {
				for (int i = 0; i < e.text.length(); i++) {
					if (Character.isWhitespace(e.text.charAt(i))) {
						e.doit = false;
						return;
					}
				}
			}
		});
		Label lblTestID = new Label(composite, SWT.NONE);
		lblTestID.setText("TestCase ID:");

		txtID = new Text(composite, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		txtID.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		txtID.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				testCase.setId(txtID.getText());
			}
		});
		new Label(composite, SWT.NONE);
		Label lblRequirementID = new Label(composite, SWT.NONE);
		lblRequirementID.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		lblRequirementID.setText("Requirement ID:");

		txtRequirementID = new Text(composite, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		txtRequirementID.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		// txtRequirementID.setText("");

		txtRequirementID.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				testCase.setRequirementID(txtRequirementID.getText());
			}
		});

		Label lblVariantLink = new Label(composite, SWT.NONE);
		lblVariantLink.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		lblVariantLink.setText("Variant:");

		txtVariant = new Text(composite, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		txtVariant.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		txtVariant.setEnabled(false);

		Button browseVariant = new Button(composite, SWT.NONE);
		browseVariant.setText("Browse");
		browseVariant.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, false, false));

		browseVariant.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				VariantListDialog dialog = new VariantListDialog(Display.getDefault().getActiveShell(),
						testSpecification);
				int result = dialog.open();
				StringBuilder variantString = new StringBuilder();
				if (IDialogConstants.OK_ID == result) {
					List<Variant> variantList = dialog.getVariantList();
					if (!variantList.isEmpty()) {
						variantString.append("");
						testCase.getVariants().clear();
					}
					for (Variant variant : variantList) {
						variantString.append(variant.getName() + ",");
					}
					testCase.getVariants().addAll(variantList);
				}
				if (!variantString.toString().isEmpty()) {
					variantString.deleteCharAt(
							variantString.length() > 0 ? variantString.length() - 1 : variantString.length());
					txtVariant.setText(variantString.toString());
				}
			}
		});

		Label lblTestCaseDescription = new Label(composite, SWT.NONE);
		lblTestCaseDescription.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		lblTestCaseDescription.setText("Description");

		txtDescription = new Text(composite, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		txtDescription.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 4, 1));
		txtDescription.setText("");

		txtDescription.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				testCase.setDescription(txtDescription.getText());
			}
		});

		txtExecutionStatus = new Label(composite, SWT.READ_ONLY | SWT.CENTER | SWT.BORDER);
		txtExecutionStatus.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false, 5, 1));

		// ActionComposite(parent);

		formToolkit = new FormToolkit(parent.getDisplay());

		formToolkit.paintBordersFor(parent);
		createTestStepSection(parent);
		createTracebilitySection(parent);

	}

	private void createTracebilitySection(Composite parent) {
		Section section = formToolkit.createSection(parent, Section.TWISTIE | Section.TITLE_BAR);
		section.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		formToolkit.paintBordersFor(section);

		section.setText("Tracebility");
		section.setExpanded(true);

		Composite composite = new Composite(section, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		composite.setLayout(new GridLayout(1, false));

		tracebilityTblViewer = new TableViewer(composite, SWT.BORDER | SWT.FULL_SELECTION);
		Table tblVariant = tracebilityTblViewer.getTable();
		tblVariant.setLinesVisible(true);
		tblVariant.setHeaderVisible(true);
		tblVariant.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		formToolkit.paintBordersFor(tblVariant);

		TableColumn tblclmnTracebilityType = new TableColumn(tblVariant, SWT.NONE);
		tblclmnTracebilityType.setWidth(100);
		tblclmnTracebilityType.setText("Type");

		TableColumn tblclmTracebilityArtifactID = new TableColumn(tblVariant, SWT.NONE);
		tblclmTracebilityArtifactID.setWidth(400);
		tblclmTracebilityArtifactID.setText("Tracebility Artifact ID");

		tracebilityTblViewer.setContentProvider(ArrayContentProvider.getInstance());
		tracebilityTblViewer.setLabelProvider(new TracebilityLabelProvider());

		TableColumn[] columns = tblVariant.getColumns();
		CellEditor[] cellEditor = new CellEditor[columns.length];
		for (int i = 0; i < cellEditor.length; i++) {
			if(i==1) {
			TextCellEditor text = new TextCellEditor(tblVariant);
			cellEditor[i] = text;
			} else {
				
				List<TraceabilityArtifactEnum> values = TraceabilityArtifactEnum.VALUES;
				String[] artifactType = new String[values.size()];
				
				for (int j = 0; j < values.size(); j++) {
					TraceabilityArtifactEnum traceabilityArtifactEnum = values.get(j);
					artifactType[j] = traceabilityArtifactEnum.getName();
				}
				
				ComboBoxCellEditor text = new ComboBoxCellEditor(tblVariant,  artifactType);
				cellEditor[i] = text;
			}
		}

		String[] columnString = new String[] { "Type", "Tracebility Artifact ID" };
		tracebilityTblViewer.setCellEditors(cellEditor);
		tracebilityTblViewer.setCellModifier(new TracebilityCellEditor(tracebilityTblViewer));
		tracebilityTblViewer.setColumnProperties(columnString);

		formToolkit.adapt(composite);
		formToolkit.paintBordersFor(composite);

		section.setClient(composite);

		tracebilityToolBarActions(parent, section);
		
		enableEditingForTracebilityTable();
		// TableViewer tableViewer = new TableViewer(table);
	}

	private void createTestStepSection(Composite parent) {
		Section section = formToolkit.createSection(parent, Section.TWISTIE | Section.TITLE_BAR);
		section.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		formToolkit.paintBordersFor(section);

		section.setText("Test Steps");
		section.setExpanded(true);

		/*
		 * testStepsDetailsComposite = new TestStepsDetailsComposite(section, SWT.NONE);
		 * testStepsDetailsComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL,
		 * true, true)); section.setClient(testStepsDetailsComposite);
		 * makeToolBarActions(parent, section);
		 */

		testActionsDetailsComposite = new TestActionsDetailsComposite(section, SWT.NONE, this);
		testActionsDetailsComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		section.setClient(testActionsDetailsComposite);
		KeyAdapter keyListener = new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.keyCode == SWT.DEL) {
					deleteTestStep();
				}
			}
		};
		testActionsDetailsComposite.getActionGraphicalviewer().getControl().addKeyListener(keyListener);
		testActionsDetailsComposite.getPreConditionGraphicalviewer().getControl().addKeyListener(keyListener);
		testActionsDetailsComposite.getPostConditionGraphicalviewer().getControl().addKeyListener(keyListener);
		testActionsDetailsComposite.getActionViewer().getControl().addKeyListener(keyListener);
		testActionsDetailsComposite.getPreCondtViewer().getControl().addKeyListener(keyListener);
		testActionsDetailsComposite.getPostCondtViewer().getControl().addKeyListener(keyListener);

		// section.setLayoutData(testActionsDetailsComposite);
		testStepToolBarActions(parent, section);

		testActionsDetailsComposite.getTabular().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				whileAction = null;
				forLoop = null;
			}
		});

		ISelectionChangedListener selectionListener = new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				getTreeTableViewerSelection(event);
			}

		};
		testActionsDetailsComposite.getPreCondtViewer().addSelectionChangedListener(selectionListener);
		testActionsDetailsComposite.getActionViewer().addSelectionChangedListener(selectionListener);
		testActionsDetailsComposite.getPostCondtViewer().addSelectionChangedListener(selectionListener);
		testActionsDetailsComposite.getPreConditionGraphicalviewer().addSelectionChangedListener(selectionListener);
		testActionsDetailsComposite.getActionGraphicalviewer().addSelectionChangedListener(selectionListener);
		testActionsDetailsComposite.getPostConditionGraphicalviewer().addSelectionChangedListener(selectionListener);
	}

	private void getTreeTableViewerSelection(SelectionChangedEvent event) {
		IStructuredSelection selection = (IStructuredSelection) event.getSelection();
		Object firstElement = selection.getFirstElement();
		if (firstElement instanceof WhileLoop) {
			whileLoop = (WhileLoop) firstElement;
		} else if (firstElement instanceof ForLoop) {
			whileLoop = null;
			forLoop = (ForLoop) firstElement;
		} else {
			whileLoop = null;
			forLoop = null;
		}
	}

	private void testStepToolBarActions(Composite parent, Section section) {
		Composite compactionAdd = new Composite(parent, SWT.NONE);
		compactionAdd.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		compactionAdd.setLayout(new GridLayout(2, false));

		ToolBarManager toolBarManager = new ToolBarManager(SWT.FLAT);
		ToolBar toolbar = toolBarManager.createControl(section);
		toolbar.setCursor(Display.getDefault().getSystemCursor(SWT.CURSOR_HAND));

		// check Action
		addCheckAction = new Action("Check") {
			@Override
			public void run() {

				TestStepCheckDialog dialog = new TestStepCheckDialog(Display.getDefault().getActiveShell(),
						testSpecification, null);
				int result = dialog.open();

				if (IDialogConstants.OK_ID == result) {

					CheckAction checkAction = DiagonosticModelFactory.eINSTANCE.createCheckAction();
					checkAction.setTitle(dialog.getTitle());
					checkAction.setWait(Float.parseFloat(dialog.getWait()));
					checkAction.setKey(dialog.getSignalType());
					checkAction.setValue(dialog.getTxtValueFrom());
					// checkAction.setValueTo(dialog.getTxtValueTo());
					checkAction.setOperator(OperatorTypeEnum.get(dialog.getCombo()));

					if (testActionsDetailsComposite.getTabular().getSelection()[0].getText()
							.equalsIgnoreCase(PRE_CONDITION)) {
						if (whileLoop != null) {
							linkTestStepWhile(checkAction);
						} else if (forLoop != null) {
							linkTestStepFor(checkAction);
						} else {

							if (!testCase.getPreConditions().isEmpty()) {
								testCase.getPreConditions()
										.get(testCase.getPreConditions().size() > 0
												? testCase.getPreConditions().size() - 1
												: testCase.getPreConditions().size())
										.setNextStep(checkAction);
							}
							testCase.getPreConditions().add(checkAction);
						}
					}

					else if (testActionsDetailsComposite.getTabular().getSelection()[0].getText()
							.equalsIgnoreCase(ACTION)) {
						if (whileLoop != null) {
							linkTestStepWhile(checkAction);
						} else if (forLoop != null) {
							linkTestStepFor(checkAction);
						} else {
							if (!testCase.getTestSteps().isEmpty()) {
								testCase.getTestSteps()
										.get(testCase.getTestSteps().size() > 0 ? testCase.getTestSteps().size() - 1
												: testCase.getTestSteps().size())
										.setNextStep(checkAction);
							}
							testCase.getTestSteps().add(checkAction);
						}
					}

					else if (testActionsDetailsComposite.getTabular().getSelection()[0].getText()
							.equalsIgnoreCase(POST_CONDITION)) {
						if (whileLoop != null) {
							linkTestStepWhile(checkAction);
						} else if (forLoop != null) {
							linkTestStepFor(checkAction);
						} else {
							if (!testCase.getPostConditions().isEmpty()) {
								testCase.getPostConditions()
										.get(testCase.getPostConditions().size() > 0
												? testCase.getPostConditions().size() - 1
												: testCase.getPostConditions().size())
										.setNextStep(checkAction);
							}
							testCase.getPostConditions().add(checkAction);
						}

					}
					testActionsDetailsComposite.refresh();
				}

				super.run();
			}
		};

		addCheckAction.setImageDescriptor(
				ResourceManager.getPluginImageDescriptor(Activator.PLUGIN_ID, "icons/CheckAction.gif"));

		// set check Action
		addsetAction = new Action("Set") {

			@Override
			public void run() {
				boolean loopFlag = forLoop != null ? true : false;
				TestStepSetDialog dialog = new TestStepSetDialog(Display.getDefault().getActiveShell(),
						testSpecification, forLoop, loopFlag);
				int result = dialog.open();
				if (IDialogConstants.OK_ID == result) {

					DiagonosticModel.Action actionSet = DiagonosticModelFactory.eINSTANCE.createSetAction();
					actionSet.setTitle(dialog.getTitle());
					// actionSet.setWait(Float.parseFloat(dialog.getWait()));
					actionSet.setKey(dialog.getSignalType());
					// actionSet.setValue(dialog.getTxtSetValue());
					if (loopFlag) {
						actionSet.setValue(dialog.getValueFrom());
					} else {
						actionSet.setValue(dialog.getValueFrom());

					}

					// actionSet.setValueTo(dialog.getValueTo());

					if (testActionsDetailsComposite.getTabular().getSelection()[0].getText()
							.equalsIgnoreCase(PRE_CONDITION)) {

						if (whileLoop != null) {
							linkTestStepWhile(actionSet);
						} else if (forLoop != null) {
							linkTestStepFor(actionSet);
						} else {

							if (!testCase.getPreConditions().isEmpty()) {
								testCase.getPreConditions()
										.get(testCase.getPreConditions().size() > 0
												? testCase.getPreConditions().size() - 1
												: testCase.getPreConditions().size())
										.setNextStep(actionSet);
							}
							testCase.getPreConditions().add(actionSet);
						}
					}

					else if (testActionsDetailsComposite.getTabular().getSelection()[0].getText()
							.equalsIgnoreCase(ACTION)) {
						if (whileLoop != null) {
							linkTestStepWhile(actionSet);
						} else if (forLoop != null) {
							linkTestStepFor(actionSet);
						} else {
							if (!testCase.getTestSteps().isEmpty()) {
								testCase.getTestSteps()
										.get(testCase.getTestSteps().size() > 0 ? testCase.getTestSteps().size() - 1
												: testCase.getTestSteps().size())
										.setNextStep(actionSet);
							}
							testCase.getTestSteps().add(actionSet);
						}
					}

					else if (testActionsDetailsComposite.getTabular().getSelection()[0].getText()
							.equalsIgnoreCase(POST_CONDITION)) {
						if (whileLoop != null) {
							linkTestStepWhile(actionSet);
						} else if (forLoop != null) {
							linkTestStepFor(actionSet);
						} else {
							if (!testCase.getPostConditions().isEmpty()) {
								testCase.getPostConditions()
										.get(testCase.getPostConditions().size() > 0
												? testCase.getPostConditions().size() - 1
												: testCase.getPostConditions().size())
										.setNextStep(actionSet);
							}
							testCase.getPostConditions().add(actionSet);
						}
					}
					testActionsDetailsComposite.refresh();

				}

				super.run();
			}
		};

		addsetAction.setImageDescriptor(
				ResourceManager.getPluginImageDescriptor(Activator.PLUGIN_ID, "icons/SetAction.gif"));

		// Start For Action

		// changes for for loop

		addForAction = new Action("ForLoop") {
			@Override
			public void run() {

				TestStepForDialog testStepForDialog = new TestStepForDialog(Display.getDefault().getActiveShell(),
						testSpecification, null);
				int result = testStepForDialog.open();

				if (IDialogConstants.OK_ID == result) {

					ForLoop forLoopAction = DiagonosticModelFactory.eINSTANCE.createForLoop();

					forLoopAction.setTitle(testStepForDialog.getTitle());
					forLoopAction.setLoopVar(testStepForDialog.getLoopvar());
					forLoopAction.setStartValue(testStepForDialog.getStartValue());
					forLoopAction.setStopValue(testStepForDialog.getStopValue());

					if (testActionsDetailsComposite.getTabular().getSelection()[0].getText()
							.equalsIgnoreCase(PRE_CONDITION)) {

						if (whileLoop != null) {
							linkTestStepWhile(forLoopAction);
						} else if (forLoop != null) {
							linkTestStepFor(forLoopAction);
						} else {

							if (!testCase.getPreConditions().isEmpty()) {
								testCase.getPreConditions()
										.get(testCase.getPreConditions().size() > 0
												? testCase.getPreConditions().size() - 1
												: testCase.getPreConditions().size())
										.setNextStep(forLoopAction);
							}
							testCase.getPreConditions().add(forLoopAction);
						}
					}

					else if (testActionsDetailsComposite.getTabular().getSelection()[0].getText()
							.equalsIgnoreCase(ACTION)) {
						if (whileLoop != null) {
							linkTestStepWhile(forLoopAction);
						} else if (forLoop != null) {
							linkTestStepFor(forLoopAction);
						} else {
							if (!testCase.getTestSteps().isEmpty()) {
								testCase.getTestSteps()
										.get(testCase.getTestSteps().size() > 0 ? testCase.getTestSteps().size() - 1
												: testCase.getTestSteps().size())
										.setNextStep(forLoopAction);
							}
							testCase.getTestSteps().add(forLoopAction);
						}
					}

					else if (testActionsDetailsComposite.getTabular().getSelection()[0].getText()
							.equalsIgnoreCase(POST_CONDITION)) {
						if (whileLoop != null) {
							linkTestStepWhile(forLoopAction);
						} else if (forLoop != null) {
							linkTestStepFor(forLoopAction);
						} else {
							if (!testCase.getPostConditions().isEmpty()) {
								testCase.getPostConditions()
										.get(testCase.getPostConditions().size() > 0
												? testCase.getPostConditions().size() - 1
												: testCase.getPostConditions().size())
										.setNextStep(forLoopAction);
							}
							testCase.getPostConditions().add(forLoopAction);
						}
					}
					testActionsDetailsComposite.refresh();
				}
				super.run();
			}
		};

		addForAction
				.setImageDescriptor(ResourceManager.getPluginImageDescriptor(Activator.PLUGIN_ID, "icons/ForLoop.png"));

		// End forAction

		// set wait Action
		addWaitAction = new Action("Wait") {
			@Override
			public void run() {

				TestStepWaitDialog dialog = new TestStepWaitDialog(Display.getDefault().getActiveShell(),
						testSpecification, null);
				int result = dialog.open();

				if (IDialogConstants.OK_ID == result) {

					DiagonosticModel.TestStep waitaction = DiagonosticModelFactory.eINSTANCE.createWaitAction();
					waitaction.setTitle(dialog.getTxtTime());

					if (testActionsDetailsComposite.getTabular().getSelection()[0].getText()
							.equalsIgnoreCase(PRE_CONDITION)) {

						if (whileLoop != null) {
							linkTestStepWhile(waitaction);
						} else if (forLoop != null) {
							linkTestStepFor(waitaction);
						} else {

							if (!testCase.getPreConditions().isEmpty()) {
								testCase.getPreConditions()
										.get(testCase.getPreConditions().size() > 0
												? testCase.getPreConditions().size() - 1
												: testCase.getPreConditions().size())
										.setNextStep(waitaction);
							}
							testCase.getPreConditions().add(waitaction);
						}

					}

					else if (testActionsDetailsComposite.getTabular().getSelection()[0].getText()
							.equalsIgnoreCase(ACTION)) {
						if (whileLoop != null) {
							linkTestStepWhile(waitaction);
						} else if (forLoop != null) {
							linkTestStepFor(waitaction);
						} else {
							if (!testCase.getTestSteps().isEmpty()) {
								testCase.getTestSteps()
										.get(testCase.getTestSteps().size() > 0 ? testCase.getTestSteps().size() - 1
												: testCase.getTestSteps().size())
										.setNextStep(waitaction);
							}
							testCase.getTestSteps().add(waitaction);
						}
					} else if (testActionsDetailsComposite.getTabular().getSelection()[0].getText()
							.equalsIgnoreCase(POST_CONDITION)) {
						if (whileLoop != null) {
							linkTestStepWhile(waitaction);
						} else if (forLoop != null) {
							linkTestStepFor(waitaction);
						} else {
							if (!testCase.getPostConditions().isEmpty()) {
								testCase.getPostConditions()
										.get(testCase.getPostConditions().size() > 0
												? testCase.getPostConditions().size() - 1
												: testCase.getPostConditions().size())
										.setNextStep(waitaction);
							}
							testCase.getPostConditions().add(waitaction);
						}

					}

					testActionsDetailsComposite.refresh();

				}

				super.run();
			}
		};

		addWaitAction.setImageDescriptor(
				ResourceManager.getPluginImageDescriptor(Activator.PLUGIN_ID, "icons/WaitAction.gif"));

		/* set Diagnstic Action */
		addDiagnosticAction = new Action("Diagnostic") {
			@Override
			public void run() {

				TestStepDiagnosticDialog dialog = new TestStepDiagnosticDialog(Display.getDefault().getActiveShell(),
						testSpecification, null);
				int result = dialog.open();

				if (IDialogConstants.OK_ID == result) {

					System.out.println("Add Diagnostic Action Method Called()");

					DiagnosticService diagnostic = DiagonosticModelFactory.eINSTANCE.createDiagnosticService();

					System.out.println(dialog.getEcu() + " = " + dialog.getService() + " = " + dialog.getResult());

					diagnostic.setEcu(dialog.getEcu());
					diagnostic.setService(dialog.getService());
					diagnostic.setResult(dialog.getResult());
					diagnostic.setDiagrequest(DiagonosticModelFactory.eINSTANCE.createDiagnosticRequest());
					diagnostic.setDiagresponse(DiagonosticModelFactory.eINSTANCE.createDiagnosticResponse());

					if (testActionsDetailsComposite.getTabular().getSelection()[0].getText()
							.equalsIgnoreCase("PreCondition")) {

						if (!testCase.getPreConditions().isEmpty()) {
							testCase.getPreConditions()
									.get(testCase.getPreConditions().size() > 0 ? testCase.getPreConditions().size() - 1
											: testCase.getPreConditions().size())
									.setNextStep(diagnostic);
						}

						testCase.getPreConditions().add(diagnostic);
					}

					else if (testActionsDetailsComposite.getTabular().getSelection()[0].getText()
							.equalsIgnoreCase("Action")) {
						if (!testCase.getTestSteps().isEmpty()) {
							testCase.getTestSteps()
									.get(testCase.getTestSteps().size() > 0 ? testCase.getTestSteps().size() - 1
											: testCase.getTestSteps().size())
									.setNextStep(diagnostic);
						}
						testCase.getTestSteps().add(diagnostic);
					} else if (testActionsDetailsComposite.getTabular().getSelection()[0].getText()
							.equalsIgnoreCase("PostCondition")) {
						if (!testCase.getPostConditions().isEmpty()) {
							testCase.getPostConditions()
									.get(testCase.getPostConditions().size() > 0
											? testCase.getPostConditions().size() - 1
											: testCase.getPostConditions().size())
									.setNextStep(diagnostic);
						}

						testCase.getPostConditions().add(diagnostic);

					}

					if (!testSpecification.getSignals().contains(diagnostic.getKey())) {
						testSpecification.getSignals().add(diagnostic.getKey());
					}

					testActionsDetailsComposite.refresh();

				}

				super.run();
			}
		};

		addDiagnosticAction.setImageDescriptor(
				ResourceManager.getPluginImageDescriptor(Activator.PLUGIN_ID, "icons/diagnostick16.png"));
		//
		////////////////////////////////////////////////////////////

		// caplTest File Import

		caplFileImportAction = new Action("Import CAPL File") {
			@Override
			public void run() {

				FileDialog fileDialog = new FileDialog(Display.getDefault().getActiveShell(), SWT.OPEN);
				fileDialog.setFilterExtensions(new String[] { "*.can" });
				String filePath = fileDialog.open();

				if (filePath != null) {
					CAPLFileParser parser = new CAPLFileParser();
					try {
						ArrayList<String> caplFunctions = parser.getCaplFunctions(filePath);

						ListSelectionDialog dlg = new ListSelectionDialog(Display.getDefault().getActiveShell(),
								caplFunctions, ArrayContentProvider.getInstance(), new LabelProvider(),
								"Select CAPL Functions for which you want to generate Test Cases");
						dlg.setTitle("CAPL Functions Selection");
						int dialogResult = dlg.open();

						if (IDialogConstants.OK_ID == dialogResult) {
							Object[] selectedFunctions = dlg.getResult();
							for (Object object : selectedFunctions) {
								String functionDetails = (String) object;

								CAPLTestStep caplTestStep = DiagonosticModelFactory.eINSTANCE.createCAPLTestStep();

								String name = functionDetails.substring(0, functionDetails.indexOf("("));
								String function = functionDetails.substring(functionDetails.indexOf("(") + 1,
										functionDetails.indexOf(")"));

								caplTestStep.setTitle(name);
								if (!function.isEmpty()) {
									String[] split = function.split(",");
									for (String parameter : split) {
										String[] ParamDetails = parameter.trim().split(" ");
										CAPLParam caplParameter = DiagonosticModelFactory.eINSTANCE.createCAPLParam();
										if (ParamDetails.length > 0 && !ParamDetails[0].isEmpty()) {
											if (ParamDetails[0].trim().equalsIgnoreCase("char")
													&& ParamDetails[1].contains("[]")) {
												caplParameter.setName(ParamDetails[1].replace("[]", ""));
												caplParameter.setType(ParamDetails[0].replace("char", "String"));
											} else {
												caplParameter.setName(ParamDetails[1]);
												caplParameter.setType(ParamDetails[0]);
											}
										}
										caplTestStep.getParameters().add(caplParameter);
									}
								}
								if (testActionsDetailsComposite.getTabular().getSelection()[0].getText()
										.equalsIgnoreCase(PRE_CONDITION)) {
									if (whileLoop != null) {
										linkTestStepWhile(caplTestStep);
									} else if (forLoop != null) {
										linkTestStepFor(caplTestStep);
									} else {
										if (!testCase.getPreConditions().isEmpty()) {
											testCase.getPreConditions()
													.get(testCase.getPreConditions().size() > 0
															? testCase.getPreConditions().size() - 1
															: testCase.getPreConditions().size())
													.setNextStep(caplTestStep);
										}
										testCase.getPreConditions().add(caplTestStep);
									}
								} else if (testActionsDetailsComposite.getTabular().getSelection()[0].getText()
										.equalsIgnoreCase(ACTION)) {
									if (whileLoop != null) {
										linkTestStepWhile(caplTestStep);
									} else if (forLoop != null) {
										linkTestStepFor(caplTestStep);
									} else {
										if (!testCase.getTestSteps().isEmpty()) {
											testCase.getTestSteps()
													.get(testCase.getTestSteps().size() > 0
															? testCase.getTestSteps().size() - 1
															: testCase.getTestSteps().size())
													.setNextStep(caplTestStep);
										}
										testCase.getTestSteps().add(caplTestStep);
									}
								} else if (testActionsDetailsComposite.getTabular().getSelection()[0].getText()
										.equalsIgnoreCase(POST_CONDITION)) {
									if (whileLoop != null) {
										linkTestStepWhile(caplTestStep);
									} else if (forLoop != null) {
										linkTestStepFor(caplTestStep);
									} else {
										if (!testCase.getPostConditions().isEmpty()) {
											testCase.getPostConditions()
													.get(testCase.getPostConditions().size() > 0
															? testCase.getPostConditions().size() - 1
															: testCase.getPostConditions().size())
													.setNextStep(caplTestStep);
										}
										testCase.getPostConditions().add(caplTestStep);
									}
								}
								testActionsDetailsComposite.refresh();
							}
						}
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		};
		caplFileImportAction
				.setImageDescriptor(ResourceManager.getPluginImageDescriptor(Activator.PLUGIN_ID, "icons/Gear.png"));

		/* Delete Action */
		deleteAction = new Action("Delete") {

			@Override
			public void run() {
				deleteTestStep();
				super.run();
			}

		};

		deleteAction.setImageDescriptor(
				PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_TOOL_DELETE));

		/* While Action */
		whileAction = new Action("WhileLoop") {

			@Override
			public void run() {

				// MessageDialog.openInformation(Display.getDefault().getActiveShell(), "Hi",
				// "Bye");
				TestStepWhileDialog whiledialog = new TestStepWhileDialog(Display.getDefault().getActiveShell(),
						testSpecification, null);
				int result = whiledialog.open();

				if (IDialogConstants.OK_ID == result) {
					WhileLoop whileLoopTestStep = DiagonosticModelFactory.eINSTANCE.createWhileLoop();
					whileLoopTestStep.setTitle(whiledialog.getWhileLoopTitle());
					// whileLoopTestStep.setTitle(whiledialog.getTitle());
					whileLoopTestStep.setKey(whiledialog.getSignalType());
					whileLoopTestStep.setValue(whiledialog.getTxtValueFrom());
					whileLoopTestStep.setValueTo(whiledialog.getTxtValueTo());
					whileLoopTestStep.setOperator(OperatorTypeEnum.get(whiledialog.getCombo()));
					if (testActionsDetailsComposite.getTabular().getSelection()[0].getText()
							.equalsIgnoreCase(PRE_CONDITION)) {

						if (whileLoop != null) {
							linkTestStepWhile(whileLoopTestStep);
						} else if (forLoop != null) {
							linkTestStepFor(whileLoopTestStep);
						} else {
							if (!testCase.getPreConditions().isEmpty()) {
								testCase.getPreConditions()
										.get(testCase.getPreConditions().size() > 0
												? testCase.getPreConditions().size() - 1
												: testCase.getPreConditions().size())
										.setNextStep(whileLoopTestStep);
							}
							testCase.getPreConditions().add(whileLoopTestStep);
						}
					} else if (testActionsDetailsComposite.getTabular().getSelection()[0].getText()
							.equalsIgnoreCase(ACTION)) {
						if (whileLoop != null) {
							linkTestStepWhile(whileLoopTestStep);
						} else if (forLoop != null) {
							linkTestStepFor(whileLoopTestStep);
						} else {
							if (!testCase.getTestSteps().isEmpty()) {
								testCase.getTestSteps()
										.get(testCase.getTestSteps().size() > 0 ? testCase.getTestSteps().size() - 1
												: testCase.getTestSteps().size())
										.setNextStep(whileLoopTestStep);
							}
							testCase.getTestSteps().add(whileLoopTestStep);
						}
					} else if (testActionsDetailsComposite.getTabular().getSelection()[0].getText()
							.equalsIgnoreCase(POST_CONDITION)) {
						if (whileLoop != null) {
							linkTestStepWhile(whileLoopTestStep);
						} else if (forLoop != null) {
							linkTestStepFor(whileLoopTestStep);
						} else {
							if (!testCase.getPostConditions().isEmpty()) {
								testCase.getPostConditions()
										.get(testCase.getPostConditions().size() > 0
												? testCase.getPostConditions().size() - 1
												: testCase.getPostConditions().size())
										.setNextStep(whileLoopTestStep);
							}
							testCase.getPostConditions().add(whileLoopTestStep);
						}
					}

					testActionsDetailsComposite.refresh();
				}
				// testActionsDetailsComposite.refresh();
				super.run();
			}
		};
		whileAction.setImageDescriptor(
				ResourceManager.getPluginImageDescriptor(Activator.PLUGIN_ID, "icons/WhileLoop.png"));

		toolBarManager.add(addsetAction);
		toolBarManager.add(addCheckAction);
		// toolBarManager.add(addWaitAction);
		// toolBarManager.add(addDiagnosticAction);
		// toolBarManager.add(caplFileImportAction);
		toolBarManager.add(addForAction);
		// toolBarManager.add(whileAction);
		toolBarManager.add(deleteAction);

		toolBarManager.update(true);

		section.setTextClient(toolbar);

	}

	private void tracebilityToolBarActions(Composite parent, Section section) {
		Composite compactionAdd = new Composite(parent, SWT.NONE);
		compactionAdd.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
		compactionAdd.setLayout(new GridLayout(2, false));

		ToolBarManager toolBarManager = new ToolBarManager(SWT.FLAT);
		ToolBar toolbar = toolBarManager.createControl(section);
		toolbar.setCursor(Display.getDefault().getSystemCursor(SWT.CURSOR_HAND));

		// Add Tracebility Action
		Action addTracebilityAction = new Action("Add Tracebility") {
			@Override
			public void run() {
				TracebilityArtifact artifact = DiagonosticModelFactory.eINSTANCE.createTracebilityArtifact();
				artifact.setType(TraceabilityArtifactEnum.REQUIREMENT);
				artifact.setUrl("");
				
				testCase.getTraceabilityArtifacts().add(artifact);
				tracebilityTblViewer.refresh();
			}
		};

		addTracebilityAction.setImageDescriptor(
				PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_OBJ_ADD));
		// Delete Tracebility Action
		Action deleteTracebilityAction = new Action("Delete Tracebility") {
			@Override
			public void run() {
				Object firstElement = tracebilityTblViewer.getStructuredSelection().getFirstElement();
				testCase.getTraceabilityArtifacts().remove(firstElement);
				tracebilityTblViewer.refresh();
			}
		};

		deleteTracebilityAction.setImageDescriptor(
				PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_TOOL_DELETE));

		toolBarManager.add(addTracebilityAction);
		toolBarManager.add(deleteTracebilityAction);

		toolBarManager.update(true);

		section.setTextClient(toolbar);

	}

	private void linkTestStepWhile(TestStep testStep) {
		if (!whileLoop.getTestSteps().isEmpty()) {
			whileLoop.getTestSteps().get(whileLoop.getTestSteps().size() > 0 ? whileLoop.getTestSteps().size() - 1
					: whileLoop.getTestSteps().size()).setNextStep(testStep);
		}
		whileLoop.getTestSteps().add(testStep);
	}

	private void linkTestStepFor(TestStep testStep) {
		if (!forLoop.getTestSteps().isEmpty()) {
			forLoop.getTestSteps().get(forLoop.getTestSteps().size() > 0 ? forLoop.getTestSteps().size() - 1
					: forLoop.getTestSteps().size()).setNextStep(testStep);
		}
		forLoop.getTestSteps().add(testStep);
	}

	protected void updateContents(Object value) {
		if (textvalue == null) {
			return;
		}
		String text = "";
		if (value != null) {
			text = value.toString();
		}
		textvalue.setText(text);

	}

	public TestActionsDetailsComposite getTestActionsDetailsComposite() {
		return testActionsDetailsComposite;
	}

	public void removeGraphicalNode(List<TestStep> testStepList, List<TestStep> previousNode,
			EList<TestStep> testSteps) {
		for (TestStep object : testStepList) {
			if (testSteps.indexOf(object) > 0)
				previousNode.add(testSteps.get(
						testSteps.indexOf(object) > 0 ? testSteps.indexOf(object) - 1 : testSteps.indexOf(object)));
		}
		testSteps.removeAll(testStepList);
		for (TestStep testStep : previousNode) {
			int indexOf = testSteps.indexOf(testStep) + 1;
			if (indexOf < testSteps.size()) {
				testStep.setNextStep(testSteps.get(indexOf));
			} else {
				testStep.setNextStep(null);
			}
		}
	}

	private void deleteTestStep() {
		ISelection selection;
		if (testActionsDetailsComposite.getTabular().getSelection()[0].getText().equalsIgnoreCase(PRE_CONDITION)) {
			selection = testActionsDetailsComposite.getActiveViewer().getSelection();
			if (!selection.isEmpty()) {
				IStructuredSelection slc = ((IStructuredSelection) selection);
				List<TestStep> testStepList = slc.toList();
				List<TestStep> indexOf = new ArrayList<TestStep>();
				int response = confirmMessageBox();
				if (response == SWT.YES) {
					EList<TestStep> preConditions = testCase.getPreConditions();
					removeGraphicalNode(testStepList, indexOf, preConditions);
				}
			}
		} else if (testActionsDetailsComposite.getTabular().getSelection()[0].getText()
				.equalsIgnoreCase(POST_CONDITION)) {
			selection = testActionsDetailsComposite.getActiveViewer().getSelection();
			if (!selection.isEmpty()) {
				IStructuredSelection slc = ((IStructuredSelection) selection);
				List<TestStep> testStepList = slc.toList();
				List<TestStep> indexOf = new ArrayList<TestStep>();
				int response = confirmMessageBox();
				if (response == SWT.YES) {
					EList<TestStep> postConditions = testCase.getPostConditions();
					removeGraphicalNode(testStepList, indexOf, postConditions);
				}
			}
		} else if (testActionsDetailsComposite.getTabular().getSelection()[0].getText().equalsIgnoreCase(ACTION)) {
			selection = testActionsDetailsComposite.getActiveViewer().getSelection();
			if (!selection.isEmpty()) {
				IStructuredSelection slc = ((IStructuredSelection) selection);
				List<TestStep> testStepList = slc.toList();
				List<TestStep> indexOf = new ArrayList<TestStep>();
				int response = confirmMessageBox();
				if (response == SWT.YES) {
					EList<TestStep> testSteps = testCase.getTestSteps();
					removeGraphicalNode(testStepList, indexOf, testSteps);
				}
			}
		}
		testActionsDetailsComposite.refresh();
	}

	public int confirmMessageBox() {
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

	private void enableEditingForTracebilityTable() {
		// You have to create identifier for tree columns
		tracebilityTblViewer.setColumnProperties(new String[] { "Type", "Tracebility Artifact ID" });
		tracebilityTblViewer.setCellModifier(new ICellModifier() {

			@Override
			public void modify(Object element, String property, Object value) {
				if (property.equalsIgnoreCase("Type")) {
					if (element instanceof TableItem) {
						// update element and tree model
						TableItem treeItem = (TableItem) element;
						TracebilityArtifact artifact = (TracebilityArtifact) treeItem.getData();
						artifact.setType(TraceabilityArtifactEnum.get(Integer.parseInt(value.toString())));
					}
				} else if (property.equalsIgnoreCase("Tracebility Artifact ID")) {
					if (element instanceof TableItem) {
						// update element and tree model
						TableItem treeItem = (TableItem) element;
						TracebilityArtifact artifact = (TracebilityArtifact) treeItem.getData();
						artifact.setUrl(value.toString());
					}
				}
				
				tracebilityTblViewer.refresh();
			}

			@Override
			public Object getValue(Object element, String property) {
				if (property.equalsIgnoreCase("Type")) {
					return ((TracebilityArtifact)element).getType().getValue();
				} else if (property.equalsIgnoreCase("Tracebility Artifact ID")) {
					return ((TracebilityArtifact)element).getUrl();
				} else {
					return null;
				}
			}

			@Override
			public boolean canModify(Object element, String property) {
				return true;
			}
		});

	}

}
