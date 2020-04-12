package com.ancit.testgenx.ui.views;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.eclipse.emf.common.command.BasicCommandStack;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.edit.domain.AdapterFactoryEditingDomain;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.resource.ResourceItemProviderAdapterFactory;
import org.eclipse.emf.edit.ui.action.CreateChildAction;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IMenuListener;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.ListSelectionDialog;
import org.eclipse.ui.forms.DetailsPart;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.MasterDetailsBlock;
import org.eclipse.ui.forms.SectionPart;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.wb.swt.ResourceManager;

import com.ancit.testgenx.ui.page.CaplTestCaseDetailsPage;
import com.ancit.testgenx.ui.page.TestCaseDetailPage;
import com.ancit.testgenx.ui.page.TestGroupDetailPage;
import com.ancit.testgenx.ui.page.TestSpecificationDetailPage;
import com.ancit.testgenx.ui.utils.CAPLFileParser;

import DiagonosticModel.CAPLParam;
import DiagonosticModel.CAPLTestCase;
import DiagonosticModel.CAPLTestStep;
import DiagonosticModel.CheckAction;
import DiagonosticModel.DiagonosticModelFactory;
import DiagonosticModel.ExternalReference;
import DiagonosticModel.OperatorTypeEnum;
import DiagonosticModel.TestCase;
import DiagonosticModel.TestGroup;
import DiagonosticModel.TestSpecification;
import DiagonosticModel.TestStep;
import DiagonosticModel.Variant;
import DiagonosticModel.impl.CAPLTestCaseImpl;
import DiagonosticModel.impl.TestCaseImpl;
import DiagonosticModel.impl.TestGroupImpl;
import DiagonosticModel.impl.TestSpecificationImpl;
import DiagonosticModel.impl.VariantImpl;
import DiagonosticModel.provider.DiagonosticModelItemProviderAdapterFactory;

public class DiagnosticBlock extends MasterDetailsBlock {

	Tree tree;
	private TestSpecification testSpecification;
	private TreeViewer treeViewer;
	private ComposedAdapterFactory adapterFactory;
	private AdapterFactoryEditingDomain editingDomain;
	private BasicCommandStack commandStack;

	ISharedImages sharedimages = PlatformUI.getWorkbench().getSharedImages();
	private Action deleteAction;
	private Action duplicateAction;
	private Action generatenagativetestcase;
	private Action importCAPLfunction;
	private Action importXLSAction;
	private TestCaseDetailPage testCaseDetailPage;
	private TestSpecificationDetailPage testSpecificationDetailsPage;
	private TestGroupDetailPage testGroupDetailsPage;

	public DiagnosticBlock(TestSpecification testSpecification) {
		this.testSpecification = testSpecification;
		// TODO Auto-generated constructor stub

		adapterFactory = new ComposedAdapterFactory();
		adapterFactory.addAdapterFactory(new ResourceItemProviderAdapterFactory());
		adapterFactory.addAdapterFactory(new DiagonosticModelItemProviderAdapterFactory());
		commandStack = new BasicCommandStack();
		editingDomain = new AdapterFactoryEditingDomain(adapterFactory, commandStack);
	}

	@Override
	protected void createMasterPart(IManagedForm managedForm, Composite parent) {
		// TODO Auto-generated method stub

		/*
		 * FormToolkit formToolkit= managedForm.getToolkit();
		 * 
		 * Section section = formToolkit.createSection(parent, Section.TWISTIE |
		 * Section.TITLE_BAR); section.setLayoutData(new GridData(SWT.FILL, SWT.FILL,
		 * true, true, 1, 1)); section.setDescription("Model Detail");
		 * section.marginWidth =10; section.marginHeight =5;
		 * 
		 * formToolkit.paintBordersFor(section);
		 */

		FormToolkit formToolkit = new FormToolkit(parent.getDisplay());

		/*
		 * IManagedForm mform =TestSpecificationDetailPage.getManagedForm();
		 * IToolBarManager toolbar = mform.getForm().getToolBarManager();
		 */

		Composite composite = formToolkit.createComposite(parent, SWT.NONE);
		formToolkit.paintBordersFor(composite);
		composite.setLayout(new GridLayout(1, false));

		Section section = formToolkit.createSection(composite, Section.TWISTIE | Section.TITLE_BAR);
		section.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		formToolkit.paintBordersFor(section);

		section.setText("Test Specification Section");
		section.setExpanded(true);

		Composite composite1 = formToolkit.createComposite(section, SWT.NONE);
		composite1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		composite1.setLayout(new GridLayout(1, false));
		section.setClient(composite1);

		// section.setClient(composite1);
		final SectionPart spart = new SectionPart(section);
		spart.getSection();
		managedForm.addPart(spart);

		// FilteredTree tree = new FilteredTree(composite1, SWT.BORDER |
		// SWT.FULL_SELECTION, new PatternFilter());

		treeViewer = new TreeViewer(composite1, SWT.BORDER | SWT.FULL_SELECTION);
		tree = treeViewer.getTree();

		GridData gd_tree = new GridData(SWT.FILL, SWT.FILL, true, true);
		gd_tree.heightHint = 466;
		tree.setLayoutData(gd_tree);
		// tree.setLinesVisible(true);
		// tree.setHeaderVisible(true);
		treeViewer.setContentProvider(new AdapterFactoryContentProvider(adapterFactory));
		treeViewer.setLabelProvider(new AdapterFactoryLabelProvider(adapterFactory));
		treeViewer.setInput(testSpecification.eResource());
		treeViewer.expandAll();
		treeViewer.setSelection(new StructuredSelection(testSpecification));

		treeViewer.addSelectionChangedListener(new ISelectionChangedListener() {

			@Override
			public void selectionChanged(SelectionChangedEvent event) {

				managedForm.fireSelectionChanged(spart, event.getSelection());
				IStructuredSelection sSelection = event.getStructuredSelection();
				Object object = sSelection.getFirstElement();
				if (object instanceof TestSpecification) {
					deleteAction.setEnabled(false);
					duplicateAction.setEnabled(false);
					generatenagativetestcase.setEnabled(false);
				} else {
					deleteAction.setEnabled(true);
					duplicateAction.setEnabled(true);
					generatenagativetestcase.setEnabled(true);
				}
			}
		});
		treeViewer.getControl().addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.keyCode == SWT.DEL) {
					deleteTreeNode();
				}
			}
		});

		hookContextMenu();

		ToolBarManager toolBarManager = new ToolBarManager(SWT.FLAT);
		ToolBar toolbar = toolBarManager.createControl(section);
		toolbar.setCursor(Display.getDefault().getSystemCursor(SWT.CURSOR_HAND));

		deleteAction = new Action("Delete") {
			@Override
			public void run() {

				deleteTreeNode();
				super.run();
			}

		};

		deleteAction.setImageDescriptor(
				PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_TOOL_DELETE));
		deleteAction.setEnabled(false);
		toolBarManager.add(deleteAction);
		toolBarManager.update(true);

		duplicateAction = new Action("Duplicate") {

			@Override
			public void run() {
				duplicataction();
			}
		};
		duplicateAction.setImageDescriptor(
				PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_TOOL_UNDO_HOVER));
		duplicateAction.setEnabled(false);
		toolBarManager.add(duplicateAction);
		toolBarManager.update(true);

		generatenagativetestcase = new Action("Generate -ve Test Cases") {

			@Override
			public void run() {
				generateNegativeTestCases();
			}

		};
		generatenagativetestcase.setImageDescriptor(
				PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_TOOL_UP_HOVER));
		generatenagativetestcase.setEnabled(false);
		// toolBarManager.add(generatenagativetestcase);
		toolBarManager.update(true);

		importCAPLfunction = new Action("Import CAPL Function") {

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
							Object firstElement = treeViewer.getStructuredSelection().getFirstElement();
							if (firstElement instanceof TestSpecification) {
								TestSpecification testGroup = (TestSpecification) treeViewer.getStructuredSelection()
										.getFirstElement();
								for (Object object : selectedFunctions) {
									String functionDetails = (String) object;

									CAPLTestCase caplTestCase = DiagonosticModelFactory.eINSTANCE.createCAPLTestCase();

									String name = functionDetails.substring(0, functionDetails.indexOf("("));
									String function = functionDetails.substring(functionDetails.indexOf("(") + 1,
											functionDetails.indexOf(")"));

									caplTestCase.setName(name);
									String[] split = function.split(",");
									for (String parameter : split) {
										String[] ParamDetails = parameter.trim().split(" ");
										CAPLParam caplParameter = DiagonosticModelFactory.eINSTANCE.createCAPLParam();
										if (ParamDetails[0].trim().equalsIgnoreCase("char")
												&& ParamDetails[1].contains("[]")) {
											caplParameter.setName(ParamDetails[1].replace("[]", ""));
											caplParameter.setType(ParamDetails[0].replace("char", "String"));
										} else {
											caplParameter.setName(ParamDetails[1]);
											caplParameter.setType(ParamDetails[0]);
										}

										caplTestCase.getParameters().add(caplParameter);
									}

									testGroup.getCapltestcases().add(caplTestCase);
								}
							} else if (firstElement instanceof TestGroup) {
								TestGroup testGroup = (TestGroup) treeViewer.getStructuredSelection().getFirstElement();
								for (Object object : selectedFunctions) {
									String functionDetails = (String) object;

									CAPLTestCase caplTestCase = DiagonosticModelFactory.eINSTANCE.createCAPLTestCase();

									String name = functionDetails.substring(0, functionDetails.indexOf("("));
									String function = functionDetails.substring(functionDetails.indexOf("(") + 1,
											functionDetails.indexOf(")"));

									caplTestCase.setName(name);
									String[] split = function.split(",");
									for (String parameter : split) {
										String[] ParamDetails = parameter.trim().split(" ");
										CAPLParam caplParameter = DiagonosticModelFactory.eINSTANCE.createCAPLParam();
										if (ParamDetails[0].trim().equalsIgnoreCase("char")
												&& ParamDetails[1].contains("[]")) {
											caplParameter.setName(ParamDetails[1].replace("[]", ""));
											caplParameter.setType(ParamDetails[0].replace("char", "String"));
										} else {
											caplParameter.setName(ParamDetails[1]);
											caplParameter.setType(ParamDetails[0]);
										}

										caplTestCase.getParameters().add(caplParameter);
									}

									testGroup.getCapltestcases().add(caplTestCase);
								}
							} else if (firstElement instanceof TestCase) {
								TestCase testCase = (TestCase) treeViewer.getStructuredSelection().getFirstElement();
								for (Object object : selectedFunctions) {
									String functionDetails = (String) object;

									CAPLTestStep caplTestStep = DiagonosticModelFactory.eINSTANCE.createCAPLTestStep();

									String name = functionDetails.substring(0, functionDetails.indexOf("("));
									String function = functionDetails.substring(functionDetails.indexOf("(") + 1,
											functionDetails.indexOf(")"));

									caplTestStep.setTitle(name);
									String[] split = function.split(",");
									for (String parameter : split) {
										String[] ParamDetails = parameter.trim().split(" ");
										CAPLParam caplParameter = DiagonosticModelFactory.eINSTANCE.createCAPLParam();
										if (ParamDetails[0].trim().equalsIgnoreCase("char")
												&& ParamDetails[1].contains("[]")) {
											caplParameter.setName(ParamDetails[1].replace("[]", ""));
											caplParameter.setType(ParamDetails[0].replace("char", "String"));
										} else {
											caplParameter.setName(ParamDetails[1]);
											caplParameter.setType(ParamDetails[0]);
										}

										caplTestStep.getParameters().add(caplParameter);
									}

									testCase.getTestSteps().add(caplTestStep);
								}

								Viewer viewerPrecont = testCaseDetailPage.getTestActionsDetailsComposite()
										.getActiveViewer();
								if (viewerPrecont != null) {
									viewerPrecont.setInput(testCase.getTestSteps());
									viewerPrecont.refresh();
								}
							}

						}

					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}

		};
		importCAPLfunction.setImageDescriptor(
				ResourceManager.getPluginImageDescriptor("com.ancit.diagnostictool.ui", "icons/Gear.png"));
		// toolBarManager.add(importCAPLfunction);

		toolBarManager.update(true);
		section.setTextClient(toolbar);

	}

	protected void loadCAPLFunction() {
		// TODO Auto-generated method stub

	}

	private void hookContextMenu() {
		MenuManager contextMenu = new MenuManager();
		contextMenu.setRemoveAllWhenShown(true);
		contextMenu.addMenuListener(new IMenuListener() {

			@Override
			public void menuAboutToShow(IMenuManager manager) {
				Object firstElement = treeViewer.getStructuredSelection().getFirstElement();

				MenuManager newMenuManager = new MenuManager("New");
				manager.add(newMenuManager);
				// manager.add(importXLSAction);
				if (firstElement instanceof TestGroup) {
					Collection<?> newChildDescriptors = editingDomain.getNewChildDescriptors(firstElement, null);
					for (Object object : newChildDescriptors) {
						CreateChildAction action = new CreateChildAction(editingDomain, treeViewer.getSelection(),
								object);
						if (!action.getText().toString().trim().equalsIgnoreCase("CAPL Test Case")) {
							newMenuManager.add(action);
						}
					}

					manager.add(new Separator());
					manager.add(deleteAction);
					manager.add(duplicateAction);
					// manager.add(generatenagativetestcase);
					// manager.add(importCAPLfunction);

				}

				if (firstElement instanceof ExternalReference) {
					manager.add(deleteAction);
				}

				if (firstElement instanceof TestCase) {
					manager.add(deleteAction);
					manager.add(duplicateAction);
				}

				if (firstElement instanceof CAPLTestCase) {
					manager.add(deleteAction);
					manager.add(duplicateAction);
				} else if (firstElement instanceof TestSpecification) {
					Collection<?> newChildDescriptors = editingDomain.getNewChildDescriptors(firstElement, null);
					for (Object object : newChildDescriptors) {
						CreateChildAction action = new CreateChildAction(editingDomain, treeViewer.getSelection(),
								object);
						if (!action.getText().toString().trim().equalsIgnoreCase("CAPL Test Case")) {
							newMenuManager.add(action);
						}
					}
				}
			}
		});

		Menu menu = contextMenu.createContextMenu(tree);
		tree.setMenu(menu);
	}

	@Override
	protected void createToolBarActions(IManagedForm managedForm) {
		// TODO Auto-generated method stub
	}

	@Override
	protected void registerPages(DetailsPart detailsPart) {

		testGroupDetailsPage = new TestGroupDetailPage();
		detailsPart.registerPage(TestGroupImpl.class, testGroupDetailsPage);
		testCaseDetailPage = new TestCaseDetailPage();
		detailsPart.registerPage(TestCaseImpl.class, testCaseDetailPage);
		testSpecificationDetailsPage = new TestSpecificationDetailPage();
		detailsPart.registerPage(TestSpecificationImpl.class, testSpecificationDetailsPage);
		detailsPart.registerPage(CAPLTestCaseImpl.class, new CaplTestCaseDetailsPage());

	}

	public void duplicataction() {

		boolean confirm = MessageDialog.openConfirm(Display.getDefault().getActiveShell(), "Confirm Duplicate",
				"Do You want to Duplicate ?");

		if (confirm) {
			ISelection selection = treeViewer.getSelection();
			if (!selection.isEmpty()) {

				Iterator iterator = ((IStructuredSelection) selection).iterator();
				while (iterator.hasNext()) {
					Object object = iterator.next();

					if (object instanceof TestGroupImpl) {
						TestGroup parent = ((TestGroup) object);
						TestGroup createTestgroup = EcoreUtil.copy(parent);
						createTestgroup.setName(parent.getName() + "_Copy");
						TestSpecification testspec = (TestSpecification) parent.eContainer();
						testspec.getTestGroups().add(createTestgroup);
					} else if (object instanceof TestCaseImpl) {

						TestCase parent = ((TestCase) object);

						TestCase createTestcase = EcoreUtil.copy(parent);
						createTestcase.setName(parent.getName() + "_Copy");

						TestGroup testGroup = (TestGroup) parent.eContainer();
						testGroup.getTestCases().add(createTestcase);

					} else if (object instanceof CAPLTestCaseImpl) {
						CAPLTestCase parent = (CAPLTestCase) object;

						CAPLTestCase caplTestCase = EcoreUtil.copy(parent);
						caplTestCase.setName(parent.getName() + "_copy");

						TestGroup testGroup = (TestGroup) parent.eContainer();
						testGroup.getCapltestcases().add(caplTestCase);

					} else if (object instanceof TestStep) {
						TestStep parent = (TestStep) object;
						TestStep testStep = EcoreUtil.copy(parent);
						testStep.setTitle(parent.getTitle() + "_copy");

						TestCase testGroup = (TestCase) parent.eContainer();
						testGroup.getTestSteps().add(testStep);

					}
				}

				treeViewer.refresh();
			}
		}
	}

	public void generateNegativeTestCases() {

		testSpecification.getTestGroups();
		testSpecification.getTestGroups().get(0).getTestCases();

		boolean confirm = MessageDialog.openConfirm(Display.getDefault().getActiveShell(), "Confirm Generate Duplicate",
				"Do You want to Nagative TestCases ?");

		if (confirm) {

			ISelection selection = treeViewer.getSelection();
			if (!selection.isEmpty()) {

				Iterator iterator = ((IStructuredSelection) selection).iterator();
				while (iterator.hasNext()) {
					Object object = iterator.next();
					if (object instanceof TestGroupImpl) {
						TestGroup parent = ((TestGroup) object);
						TestGroup createTestgroup = EcoreUtil.copy(parent);
						createTestgroup.setName(parent.getName() + "Nagative Genetrated Test_Case");
						EList<TestCase> testCases = createTestgroup.getTestCases();

						for (TestCase testCase : testCases) {
							EList<TestStep> postConditions = testCase.getPostConditions();
							EList<TestStep> preConditions = testCase.getPreConditions();
							EList<TestStep> testSteps = testCase.getTestSteps();
							for (TestStep testStep : testSteps) {
								if (testStep instanceof CheckAction) {
									switch (((CheckAction) testStep).getOperator()) {
									case EQ:
										((CheckAction) testStep).setOperator(OperatorTypeEnum.NE);
										break;
									case NE:
										((CheckAction) testStep).setOperator(OperatorTypeEnum.EQ);
										break;
									case GT:
										((CheckAction) testStep).setOperator(OperatorTypeEnum.LT);
										break;
									case LT:
										((CheckAction) testStep).setOperator(OperatorTypeEnum.GT);
										break;
									default:
										break;
									}
								}
							}

							for (TestStep postCond : postConditions) {
								if (postCond instanceof CheckAction) {
									switch (((CheckAction) postCond).getOperator()) {
									case EQ:
										((CheckAction) postCond).setOperator(OperatorTypeEnum.NE);
										break;
									case NE:
										((CheckAction) postCond).setOperator(OperatorTypeEnum.EQ);
										break;
									case GT:
										((CheckAction) postCond).setOperator(OperatorTypeEnum.LT);
										break;
									case LT:
										((CheckAction) postCond).setOperator(OperatorTypeEnum.GT);
										break;
									default:
										break;
									}
								}
							}

							for (TestStep preCond : preConditions) {
								if (preCond instanceof CheckAction) {
									switch (((CheckAction) preCond).getOperator()) {
									case EQ:
										((CheckAction) preCond).setOperator(OperatorTypeEnum.NE);
										break;
									case NE:
										((CheckAction) preCond).setOperator(OperatorTypeEnum.EQ);
										break;
									case GT:
										((CheckAction) preCond).setOperator(OperatorTypeEnum.LT);
										break;
									case LT:
										((CheckAction) preCond).setOperator(OperatorTypeEnum.GT);
										break;
									default:
										break;
									}
								}
							}
						}
						TestSpecification testspec = (TestSpecification) parent.eContainer();
						testspec.getTestGroups().add(createTestgroup);
					}
				}
			}
			treeViewer.refresh();
		}
	}

	private void deleteTreeNode() {
		ISelection selection = treeViewer.getSelection();
		if (!selection.isEmpty()) {

			Iterator iterator = ((IStructuredSelection) selection).iterator();
			while (iterator.hasNext()) {
				Object object = iterator.next();

				if (object instanceof TestGroupImpl) {
					Object parent = ((TestGroup) object).eContainer();
					if (parent instanceof TestSpecification) {
						int response = confirmMessageBox();
						if (response == SWT.YES) {
							testSpecification.getTestGroups().remove(object);
						}

					} else {
						int response = confirmMessageBox();
						if (response == SWT.YES) {
							((TestGroup) parent).getTestGroups().remove(object);
						}
					}
				} else if (object instanceof ExternalReference) {
					TestGroup parent = (TestGroup) ((ExternalReference) object).eContainer();
					int response = confirmMessageBox();
					if (response == SWT.YES) {
						parent.setExternalreference(null);
					}
				} else if (object instanceof TestCaseImpl) {
					TestGroup parent = (TestGroup) ((TestCase) object).eContainer();
					int response = confirmMessageBox();
					if (response == SWT.YES) {
						parent.getTestCases().remove(object);
					}
				} else if (object instanceof CAPLTestCaseImpl) {
					EObject eContainer = ((CAPLTestCase) object).eContainer();
					if (eContainer instanceof TestSpecification) {
						TestSpecification testSpec = (TestSpecification) eContainer;
						int response = confirmMessageBox();
						if (response == SWT.YES) {
							testSpec.getCapltestcases().remove(object);
						}
					} else if (eContainer instanceof TestGroup) {
						TestGroup parent = (TestGroup) ((CAPLTestCase) object).eContainer();
						int response = confirmMessageBox();
						if (response == SWT.YES) {
							parent.getCapltestcases().remove(object);
						}
					}
				} else if (object instanceof VariantImpl) {
					TestSpecification parent = (TestSpecification) ((Variant) object).eContainer();
					int response = confirmMessageBox();
					if (response == SWT.YES) {
						parent.getVariants().remove(object);
					}
				}
			}

			treeViewer.refresh();
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
	
	public TestCaseDetailPage getTestCaseDetailPage() {
		return testCaseDetailPage;
	}
	
	public TestGroupDetailPage getTestGroupDetailsPage() {
		return testGroupDetailsPage;
	}
	
	public TestSpecificationDetailPage getTestSpecificationDetailsPage() {
		return testSpecificationDetailsPage;
	}
}
