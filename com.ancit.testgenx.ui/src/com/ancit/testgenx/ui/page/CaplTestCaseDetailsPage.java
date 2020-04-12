package com.ancit.testgenx.ui.page;

import java.util.Iterator;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnPixelData;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.jface.viewers.TextCellEditor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.KeyListener;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.IDetailsPage;
import org.eclipse.ui.forms.IFormPart;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;

import com.ancit.testgenx.ui.views.CAPLTestCaseCellModifier;
import com.ancit.testgenx.ui.views.CaplTestCaseLabelProvider;

import DiagonosticModel.CAPLParam;
import DiagonosticModel.CAPLTestCase;
import DiagonosticModel.DiagonosticModelFactory;
import DiagonosticModel.TestSpecification;

public class CaplTestCaseDetailsPage implements IDetailsPage {
	public CaplTestCaseDetailsPage() {
	}

	private CAPLTestCase CAPLTestCaseImpl;
	private Text txtName;
	private FormToolkit formToolkit;
	private TableViewer tableViewerParameter;
	private Table tableviewparametertable;
	private TestSpecification testSpecification;

	@Override
	public void initialize(IManagedForm form) {
		// TODO Auto-generated method stub

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

	}

	@Override
	public void selectionChanged(IFormPart part, ISelection selection) {
		// TODO Auto-generated method stub

		ITreeSelection ssel = (ITreeSelection) selection;
		if (ssel.size() == 1) {
			System.out.println("Capl Test Case Data =" + ssel.getFirstElement());
			CAPLTestCaseImpl = (CAPLTestCase) ssel.getFirstElement();
			update();
		} else {
			CAPLTestCaseImpl = null;
		}
	}

	// update values masterblock
	private void update() {

			txtName.setText(CAPLTestCaseImpl.getName() != null && CAPLTestCaseImpl.getName().length() > 0 ? CAPLTestCaseImpl.getName() : "");
			tableViewerParameter.setInput(CAPLTestCaseImpl.getParameters());
	}

	@Override
	public void createContents(Composite parent) {

		parent.setLayout(new GridLayout(1, false));

		Label label = new Label(parent, SWT.NONE);
		label.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		label.setText("Name:");

		txtName = new Text(parent, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		txtName.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		//txtName.setText("");
		
		txtName.addKeyListener(new KeyListener() {

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				if (!txtName.getText().isEmpty()) {
					CAPLTestCaseImpl.setName(txtName.getText());
				} else {
					CAPLTestCaseImpl.setName("");
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});
//		txtName.addModifyListener(new ModifyListener() {
//
//			@Override
//			public void modifyText(ModifyEvent e) {
//				CAPLTestCaseImpl.setName(txtName.getText());
//			}
//		});
		
//		txtName.addVerifyListener(new VerifyListener() {
//
//			@Override
//			public void verifyText(VerifyEvent e) {
//				for (int i = 0; i < e.text.length(); i++) {
//					if (!Character.isAlphabetic(e.text.charAt(i))) {
//						e.doit = false;
//						txtName.setMessage("please enter charcter only");
//					} 
//					return;
//				}
//			}
//		});

		
		formToolkit = new FormToolkit(parent.getDisplay());

//		formToolkit.paintBordersFor(parent);
//		Section section = formToolkit.createSection(parent, Section.TWISTIE | Section.TITLE_BAR);
//		section.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, false));
//		formToolkit.paintBordersFor(section);
//		section.setText("Parameters");
//		section.setExpanded(true);

		
		Section sctnNewSection = formToolkit.createSection(parent,
				Section.EXPANDED | Section.TWISTIE | Section.TITLE_BAR);
		sctnNewSection.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true, 2, 1));
		formToolkit.paintBordersFor(sctnNewSection);
		sctnNewSection.setText("Parameters");
		
		
		Composite compositeAction = formToolkit.createComposite(sctnNewSection, SWT.NONE);
		compositeAction.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		compositeAction.setLayout(new GridLayout(1, false));
		sctnNewSection.setClient(compositeAction);
		
		TableColumnLayout columnLayout1 = new TableColumnLayout();
		compositeAction.setLayout(columnLayout1);

		tableViewerParameter = new TableViewer(compositeAction, SWT.BORDER | SWT.FULL_SELECTION);

		tableviewparametertable = tableViewerParameter.getTable();
		tableviewparametertable.setLinesVisible(true);
		tableviewparametertable.setHeaderVisible(true);
		tableviewparametertable.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));

		TableViewerColumn keyColumn1 = new TableViewerColumn(tableViewerParameter, SWT.NONE);
		TableColumn column1 = keyColumn1.getColumn();
		columnLayout1.setColumnData(column1, new ColumnPixelData(150, true, true));
		column1.setText("Parameter Name");

		TableViewerColumn keyColumn2 = new TableViewerColumn(tableViewerParameter, SWT.NONE);
		TableColumn column2 = keyColumn2.getColumn();
		columnLayout1.setColumnData(column2, new ColumnPixelData(100, true, true));
		column2.setText("Parameter Type");

		TableViewerColumn keyColumn3 = new TableViewerColumn(tableViewerParameter, SWT.NONE);
		TableColumn column3 = keyColumn3.getColumn();
		columnLayout1.setColumnData(column3, new ColumnPixelData(300, true, true));
		column3.setText("Parameter Value");

		
		// Table modify the column text
		TableColumn[] columns = tableviewparametertable.getColumns();
		CellEditor[] editors = new CellEditor[columns.length];
		for (int i = 0; i < editors.length; i++) {

			TextCellEditor cellEditor2 = new TextCellEditor(tableviewparametertable);
			Text text = (Text) cellEditor2.getControl();
			editors[i] = cellEditor2;

		}

		tableViewerParameter.setCellEditors(editors);
		tableViewerParameter.setCellModifier(new CAPLTestCaseCellModifier(tableViewerParameter));
		String[] strings = new String[] { "name", "type", "value" };
		tableViewerParameter.setColumnProperties(strings);

		tableViewerParameter.setContentProvider(new ArrayContentProvider());
		tableViewerParameter.setLabelProvider(new CaplTestCaseLabelProvider());

		ToolBarManager toolBarManager = new ToolBarManager(SWT.FLAT);
		ToolBar toolbar = toolBarManager.createControl(sctnNewSection);
		toolbar.setCursor(Display.getDefault().getSystemCursor(SWT.CURSOR_HAND));

		
		Action addParameterAction = new Action("Add ") {

			@Override
			public void run() {

				testSpecification = (TestSpecification) CAPLTestCaseImpl.eContainer().eContainer();

				CAPLTestCaseDialog dialog = new CAPLTestCaseDialog(Display.getDefault().getActiveShell(),
						testSpecification);
				int result = dialog.open();

				if (IDialogConstants.OK_ID == result) {

					CAPLParam caplImpl = DiagonosticModelFactory.eINSTANCE.createCAPLParam();
					caplImpl.setName(dialog.getparamaeterName());
					caplImpl.setType(dialog.getparameterType());
					caplImpl.setValue(dialog.getparamaeterValue());

					CAPLTestCaseImpl.getParameters().add(caplImpl);

					tableViewerParameter.refresh();

					super.run();
				}
			}
		};
		ISharedImages sharedImages = PlatformUI.getWorkbench().getSharedImages();
		addParameterAction.setImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_OBJ_ADD));
		toolBarManager.add(addParameterAction);

		Action deleteParameterAction = new Action("Delete ") {
			@Override
			public void run() {

				ISelection selection = tableViewerParameter.getSelection();
				if (!selection.isEmpty()) {
					Iterator iterator = ((IStructuredSelection) selection).iterator();

					while (iterator.hasNext()) {
						Object object = iterator.next();
						CAPLTestCaseImpl.getParameters().remove(object);
					}
					tableViewerParameter.refresh();
				}

				super.run();
			}
		};
		deleteParameterAction.setImageDescriptor(sharedImages.getImageDescriptor(ISharedImages.IMG_TOOL_DELETE));
		toolBarManager.add(deleteParameterAction);
		toolBarManager.update(true);

		sctnNewSection.setTextClient(toolbar);
	}

}
