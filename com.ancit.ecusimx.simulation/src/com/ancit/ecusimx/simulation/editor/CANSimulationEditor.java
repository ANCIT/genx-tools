package com.ancit.ecusimx.simulation.editor;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.forms.editor.FormEditor;

import com.ancit.ecusimx.simulation.model.CanSimulationBlock;
import com.ancit.ecusimx.simulation.util.CanSimulationBlockSerializer;

public class CANSimulationEditor extends FormEditor {

	private CanSimulationBlock canSimulationModelBlock;
	boolean dirty;
	private IFile file;

	public CANSimulationEditor() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean isDirty() {
		// TODO Auto-generated method stub
		return dirty;
	}
	
	public void setDirty(boolean dirty) {
		this.dirty = dirty;
		this.editorDirtyStateChanged();
	}

	@Override
	protected void addPages() {
		try {
			addPage(new CANSimulationFormPage(this, "Page1", "CAN Simulation", canSimulationModelBlock,file));
		} catch (PartInitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		// TODO Auto-generated method stub
		super.init(site, input);
		file = ((IFileEditorInput)input).getFile();
		canSimulationModelBlock = CanSimulationBlockSerializer.load(file.getLocation().toOSString());

	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		CanSimulationBlockSerializer.save(canSimulationModelBlock, file.getLocation().toOSString());
		setDirty(false);
	}

	@Override
	public void doSaveAs() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isSaveAsAllowed() {
		// TODO Auto-generated method stub
		return false;
	}

}
