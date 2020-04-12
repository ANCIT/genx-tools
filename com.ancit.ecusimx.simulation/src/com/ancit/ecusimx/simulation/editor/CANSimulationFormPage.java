package com.ancit.ecusimx.simulation.editor;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;

import com.ancit.ecusimx.simulation.model.CanSimulationBlock;

public class CANSimulationFormPage extends FormPage {

	private Action saveAction;
	private CANSimulationComposite block;
	private FormEditor editor;
	private CanSimulationBlock canSimulationModelBlock;
	IFile file;
	/**
	 * Create the form page.
	 * 
	 * @param id
	 * @param title
	 */
	public CANSimulationFormPage(String id, String title, TableViewer tableViewerAction) {
		super(id, title);
	}

	public CANSimulationFormPage(FormEditor editor, String id, String title, CanSimulationBlock canSimulationModelBlock, IFile file) {
		super(editor, id, title);
		this.editor = editor;
		this.canSimulationModelBlock = canSimulationModelBlock;
		this.file = file;
	}

	/**
	 * Create contents of the form.
	 * 
	 * @param managedForm
	 */
	@Override
	protected void createFormContent(IManagedForm managedForm) {
		FormToolkit toolkit = managedForm.getToolkit();
		ScrolledForm form = managedForm.getForm();
		form.setText("CAN Simulation");
		Composite body = form.getBody();
		body.setLayout(new GridLayout(1,false));
		
		block = new CANSimulationComposite(editor, canSimulationModelBlock, body, SWT.NONE,file);
		
		toolkit.decorateFormHeading(form.getForm());
		toolkit.paintBordersFor(body);

		createActions(managedForm.getForm());

		
		
	}

	private void createActions(final ScrolledForm scrolledForm) {
//		this.saveAction = new Action("Save", IAction.AS_PUSH_BUTTON) {
//
//			@Override
//			public void run() {
//				
//			}
//		};
//		this.saveAction.setImageDescriptor(
//				PlatformUI.getWorkbench().getSharedImages().getImageDescriptor(ISharedImages.IMG_ETOOL_SAVE_EDIT));
//
//		
//		scrolledForm.getToolBarManager().add(this.saveAction);
//		scrolledForm.updateToolBar();
	}




}
