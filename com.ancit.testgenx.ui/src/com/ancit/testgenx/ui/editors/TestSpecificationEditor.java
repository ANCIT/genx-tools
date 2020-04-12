package com.ancit.testgenx.ui.editors;

import java.io.File;
import java.io.IOException;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EContentAdapter;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.ide.FileStoreEditorInput;

import com.ancit.testgenx.ui.forms.DiagnosticFormPage;

import DiagonosticModel.DiagonosticModelPackage;
import DiagonosticModel.TestSpecification;

public class TestSpecificationEditor extends FormEditor {

	private TestSpecification testSpecification;
	private Resource resource;
	boolean dirty;
	public TestSpecificationEditor() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isDirty() {
		// TODO Auto-generated method stub
		return dirty;
	}

	@Override
	protected void addPages() {
		try {
			addPage(new DiagnosticFormPage(this, "Page1", "Test Specification", testSpecification));
		} catch (PartInitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void init(IEditorSite site, IEditorInput input) throws PartInitException {
		// TODO Auto-generated method stub
		super.init(site, input);
		IFile file = ((IFileEditorInput) input).getFile();

		ResourceSet rSet = new ResourceSetImpl();
		rSet.getPackageRegistry().put(DiagonosticModelPackage.eNS_URI, DiagonosticModelPackage.eINSTANCE);
		rSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("tcgx", new XMIResourceFactoryImpl());
		
		resource = rSet.getResource(URI.createFileURI(file.getLocation().toOSString()), true);
		testSpecification = (TestSpecification) resource.getContents().get(0);
		
		 
		testSpecification.eAdapters().add(new EContentAdapter() {
			@Override
			public void notifyChanged(Notification notification) {
				// TODO Auto-generated method stub
				super.notifyChanged(notification);
				dirty = true;

				editorDirtyStateChanged();
			}
		});
		setTitle(file.getName().replaceAll(".tcgx", ""));
		IActionBars bars = getEditorSite().getActionBars();
		String copyright = "\u00a9";
		bars.getStatusLineManager().setMessage(null, "Copyright " + copyright + " 2019 ANCiT. All rights reserved ");
	}

	@Override
	protected void setTitle(String title) {
		// TODO Auto-generated method stub
		super.setTitle(title);
	}
	@Override
	public void doSave(IProgressMonitor monitor) {

		try {
			resource.save(null);
			dirty = false;
			editorDirtyStateChanged();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override

	public void doSaveAs() {

	}

	@Override
	public boolean isSaveAsAllowed() {
		return true;
	}

}
