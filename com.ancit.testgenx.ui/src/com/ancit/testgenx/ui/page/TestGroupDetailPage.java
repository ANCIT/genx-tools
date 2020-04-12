package com.ancit.testgenx.ui.page;

import java.util.regex.Pattern;

import org.eclipse.jface.fieldassist.ControlDecoration;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CheckboxTableViewer;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.FocusListener;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.events.VerifyEvent;
import org.eclipse.swt.events.VerifyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.TabFolder;
import org.eclipse.swt.widgets.TabItem;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.IDetailsPage;
import org.eclipse.ui.forms.IFormPart;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.widgets.Section;

import com.ancit.testgenx.ui.provider.TestCaseLabelProvider;

import DiagonosticModel.ExternalReference;
import DiagonosticModel.TestCase;
import DiagonosticModel.impl.TestGroupImpl;

public class TestGroupDetailPage implements IDetailsPage {

	TestGroupImpl groupImpl;
	Text txtTestGroupName;
	private Text txtDescription;

	TableViewer tableViewer;
	Table table;
	private IManagedForm form;
	// private FormToolkit formToolkit;
	private Text titeltxt;
	private Text typetxt;
	private Text doctxt;
	private ExternalReference externalreference;
	private Table testcasetable;
	private CheckboxTableViewer testcasetableviewer;
	
	private boolean errorOnPage;
	private ControlDecoration txtNameControlDecoration;

	public TestGroupDetailPage() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

	@Override
	public void initialize(IManagedForm form) {
		// TODO Auto-generated method stub
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
			groupImpl = (TestGroupImpl) ssel.getFirstElement();
			update();
		} else {
			groupImpl = null;
			// update();
		}
		if (null != testcasetable && testcasetable.getItems().length > 0) {
			TableItem[] items = testcasetable.getItems();
			for (TableItem tableItem : items) {
				if (tableItem.getData() instanceof TestCase) {
					TestCase testcaseObjtmp = (TestCase) tableItem.getData();
					if (testcaseObjtmp.isSkip()) {
						tableItem.setChecked(true);
					} else {
						tableItem.setChecked(false);
					}

				}
			}
		}

	}

	private void update() {

		txtTestGroupName
				.setText(groupImpl.getName() != null && groupImpl.getName().length() > 0 ? groupImpl.getName() : "");
		txtDescription.setText(groupImpl.getDescription() != null ? groupImpl.getDescription() : "");
		externalreference = (ExternalReference) groupImpl.getExternalreference();
		// if (null != externalreference) {
		// titeltxt.setText(null != externalreference.getTitle() ?
		// externalreference.getTitle() : "");
		// typetxt.setText(null != externalreference.getType() ?
		// externalreference.getType() : "");
		// doctxt.setText(null != externalreference.getUrl() ?
		// externalreference.getUrl() : "");
		// } else {
		// titeltxt.setText("");
		// typetxt.setText("");
		// doctxt.setText("");
		// }
		testcasetableviewer.setInput(groupImpl.getTestCases());
	}

	@Override
	public void createContents(Composite parent) {

		/*
		 * Composite composite = new Composite(parent, SWT.NONE);
		 * composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		 * composite.setLayout(new GridLayout(2, false));
		 */

		GridLayout gridLayout = new GridLayout(2, false);
		parent.setLayout(gridLayout);

		Label lblTestID = new Label(parent, SWT.NONE);
		lblTestID.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		lblTestID.setText("Title:       ");

		txtTestGroupName = new Text(parent, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		txtTestGroupName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		txtNameControlDecoration = new ControlDecoration(txtTestGroupName, SWT.LEFT | SWT.TOP);
		// txtNameControlDecoration.setDescriptionText("Test Group Name cannot be
		// Empty");
		txtNameControlDecoration
				.setImage(PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_DEC_FIELD_ERROR));
		txtNameControlDecoration.hide();
		// txtName.setText("");

		txtTestGroupName.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				
			}

			@Override
			public void focusGained(FocusEvent e) {
				if (!txtTestGroupName.getText().isEmpty()) {
					groupImpl.setName(txtTestGroupName.getText());
					txtNameControlDecoration.hide();
				} else {
					groupImpl.setName("");
					txtNameControlDecoration.show();
					txtNameControlDecoration.showHoverText("Test Group Name cannot be Empty");
				}

			}
		});
		txtTestGroupName.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				if (!txtTestGroupName.getText().isEmpty()) {
					groupImpl.setName(txtTestGroupName.getText());
					Pattern pattern = Pattern.compile("\\p{javaJavaIdentifierStart}\\p{javaJavaIdentifierPart}*");
					boolean matches = pattern.matcher(((Text)e.widget).getText()).matches();
					if(!matches) {
						txtNameControlDecoration.show();
						txtNameControlDecoration.showHoverText("Test Specification Name is not well formed. Cannot start with Number.");
					} else {
						txtNameControlDecoration.hide();
					}
				} else {
					groupImpl.setName("");
					txtNameControlDecoration.show();
					// txtNameControlDecoration.showHoverText("Test Group Name cannot be Empty");
				}

			}
		});
		
		Label lblTestKey = new Label(parent, SWT.NONE);
		lblTestKey.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		lblTestKey.setText("Description:");

		txtDescription = new Text(parent, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		txtDescription.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

		Section sctnNewSection = form.getToolkit().createSection(parent,
				Section.EXPANDED | Section.TWISTIE | Section.TITLE_BAR);
		sctnNewSection.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true, 2, 1));
		form.getToolkit().paintBordersFor(sctnNewSection);
		sctnNewSection.setText("TestGroup Details");

		Composite composite = form.getToolkit().createComposite(sctnNewSection, SWT.NONE);
		form.getToolkit().paintBordersFor(composite);
		sctnNewSection.setClient(composite);
		composite.setLayout(new GridLayout(1, false));

		TabFolder tabFolder = new TabFolder(composite, SWT.NONE);
		tabFolder.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		form.getToolkit().adapt(tabFolder);
		form.getToolkit().paintBordersFor(tabFolder);

		TabItem tbtmTestcases = new TabItem(tabFolder, 0);
		tbtmTestcases.setText("TestCases");

		Composite testcaseComposite = new Composite(tabFolder, SWT.NONE);
		tbtmTestcases.setControl(testcaseComposite);
		form.getToolkit().paintBordersFor(testcaseComposite);
		testcaseComposite.setLayout(new GridLayout(1, false));

		// CheckboxTableViewer tableViewer_1 = new
		// CheckboxTableViewer.newCheckList(testcaseComposite, SWT.BORDER |
		// SWT.FULL_SELECTION);

		testcasetableviewer = CheckboxTableViewer.newCheckList(testcaseComposite, SWT.BORDER);
		testcasetableviewer.getTable().setLayoutData(new GridData(GridData.FILL_BOTH));
		// ctv.setContentProvider(new BackupFilesContentProvider());
		// ctv.setLabelProvider(new BackupFilesLabelProvider())

		testcasetableviewer.setColumnProperties(new String[] { "Name", "Description" });
		testcasetable = testcasetableviewer.getTable();
		testcasetable.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		testcasetable.setLinesVisible(true);
		testcasetable.setHeaderVisible(true);
		form.getToolkit().paintBordersFor(testcasetable);

		TableColumn tableColumn = new TableColumn(testcasetable, SWT.NONE);
		tableColumn.setWidth(530);
		tableColumn.setText("Name");

		Composite descriptioncomposite = new Composite(sctnNewSection, SWT.NONE);
		form.getToolkit().adapt(descriptioncomposite);
		form.getToolkit().paintBordersFor(descriptioncomposite);
		sctnNewSection.setDescriptionControl(descriptioncomposite);
		descriptioncomposite.setLayout(new GridLayout(1, false));

		Label lblNewLabel = new Label(descriptioncomposite, SWT.NONE);
		lblNewLabel.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		lblNewLabel.setBounds(0, 0, 70, 20);
		form.getToolkit().adapt(lblNewLabel, true, true);
		lblNewLabel.setText("Select TestCases to Execute.");

		testcasetableviewer.setContentProvider(ArrayContentProvider.getInstance());
		testcasetableviewer.setLabelProvider(new TestCaseLabelProvider());

		// testcasetableviewer.addSelectionChangedListener(new
		// ISelectionChangedListener() {
		//
		// @Override
		// public void selectionChanged(SelectionChangedEvent event) {
		// // TODO Auto-generated method stub
		// System.out.println("event : "+event);
		// }
		// });

		testcasetable.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetSelected(SelectionEvent event) {
				// TODO Auto-generated method stub
				// testcasetableviewer.getCheckedElements();
				// Object[] checkedElements = testcasetableviewer.getCheckedElements();
				// for (Object testcaseObj : checkedElements) {
				// if (testcaseObj instanceof TestCase) {
				// TestCase testcaseObjtmp = (TestCase) testcaseObj;
				// testcaseObjtmp.setSkip(true);
				// }
				//
				//
				// }
				TableItem[] items = testcasetable.getItems();
				for (TableItem tableItem : items) {
					if (tableItem.getData() instanceof TestCase) {
						TestCase testcaseObjtmp = (TestCase) tableItem.getData();
						if (tableItem.getChecked()) {
							testcaseObjtmp.setSkip(true);
						} else {
							testcaseObjtmp.setSkip(false);
						}

					}
				}

			}

			@Override
			public void widgetDefaultSelected(SelectionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		// TableColumn[] columns = testcasetable.getColumns();
		// CellEditor[] cellEditor = new CellEditor[columns.length];
		// for (int i = 0; i < cellEditor.length; i++) {
		// TextCellEditor text = new TextCellEditor(testcasetable);
		// cellEditor[i] = text;
		// }
		//
		// String[] columnString = new String[] { "Name"};
		// testcasetableviewer.setCellEditors(cellEditor);
		// testcasetableviewer.setCellModifier(new
		// VariantCellEditor(testcasetableviewer));
		// testcasetableviewer.setColumnProperties(columnString);
		// testcasetableviewer.getControl().addKeyListener(new KeyAdapter() {
		// @Override
		// public void keyPressed(KeyEvent e) {
		// if (e.keyCode == SWT.DEL) {
		// // deleteVariants();
		// }
		// }
		// });

		// Label titlelb = form.getToolkit().createLabel(composite, "Title : ",
		// SWT.NONE);
		// GridData gd_titlelb = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		// gd_titlelb.heightHint = 23;
		// gd_titlelb.widthHint = 51;
		// titlelb.setLayoutData(gd_titlelb);
		//
		// titeltxt = form.getToolkit().createText(composite, "New Text", SWT.NONE);
		// titeltxt.setText("");
		// titeltxt.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1,
		// 1));
		//
		// Label lblType = form.getToolkit().createLabel(composite, "Type : ",
		// SWT.NONE);
		// GridData gd_lblType = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1, 1);
		// gd_lblType.heightHint = 24;
		// lblType.setLayoutData(gd_lblType);
		//
		// typetxt = form.getToolkit().createText(composite, "New Text", SWT.NONE);
		// typetxt.setText("");
		// typetxt.setLayoutData(new GridData(SWT.FILL, SWT.TOP, true, false, 1, 1));
		//
		// Label lblDocument = form.getToolkit().createLabel(composite, "Url : ",
		// SWT.NONE);
		// GridData gd_lblDocument = new GridData(SWT.LEFT, SWT.CENTER, false, false, 1,
		// 1);
		// gd_lblDocument.heightHint = 26;
		// lblDocument.setLayoutData(gd_lblDocument);
		//
		// doctxt = form.getToolkit().createText(composite, "New Text", SWT.NONE);
		// doctxt.setText("");
		// doctxt.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		//
		// txtTestGroupName.addModifyListener(new ModifyListener() {
		//
		// @Override
		// public void modifyText(ModifyEvent e) {
		//
		// groupImpl.setName(txtTestGroupName.getText());
		// }
		// });

		txtTestGroupName.addKeyListener(new KeyListener() {

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				if (!txtTestGroupName.getText().isEmpty()) {
					groupImpl.setName(txtTestGroupName.getText());
				} else {
					groupImpl.setName("");
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});

		txtDescription.addModifyListener(new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {

				groupImpl.setDescription(txtDescription.getText());

			}

		});
		


		// titeltxt.addModifyListener(new ModifyListener() {
		//
		// @Override
		// public void modifyText(ModifyEvent e) {
		// // TODO Auto-generated method stub
		// if (null != externalreference) {
		// ((ExternalReference)
		// groupImpl.getExternalreference()).setTitle(titeltxt.getText());
		//
		// } else {
		//
		// // externalreference =
		// // DiagonosticModelFactory.eINSTANCE.createExternalReference();
		// // externalreference.setTitle(titeltxt.getText());
		// /// ((Object) groupImpl).setExternalreference(externalreference);
		//
		// }
		//
		// }
		// });

		// typetxt.addModifyListener(new ModifyListener() {
		//
		// @Override
		// public void modifyText(ModifyEvent e) {
		// // TODO Auto-generated method stub
		// if (null != externalreference) {
		// groupImpl.getExternalreference().setType(typetxt.getText());
		//
		// } else {
		// externalreference =
		// DiagonosticModelFactory.eINSTANCE.createExternalReference();
		// externalreference.setType(typetxt.getText());
		// groupImpl.setExternalreference(externalreference);
		// }
		//
		// }
		// });

		// doctxt.addModifyListener(new ModifyListener() {
		//
		// @Override
		// public void modifyText(ModifyEvent e) {
		// // TODO Auto-generated method stub
		// if (null != externalreference) {
		// groupImpl.getExternalreference().setUrl(doctxt.getText());
		//
		// } else {
		// externalreference =
		// DiagonosticModelFactory.eINSTANCE.createExternalReference();
		// externalreference.setUrl(doctxt.getText());
		// groupImpl.setExternalreference(externalreference);
		// }
		//
		// }
		// });
	}
	
	public boolean isErrorOnPage() {
		if(txtNameControlDecoration != null) {
		return txtNameControlDecoration.isVisible();
		} else {
			return false;
		}
	}
}
