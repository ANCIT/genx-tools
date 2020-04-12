package com.ancit.testgenx.ui.handlers;

import java.io.File;
import java.io.IOException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.FileDialog;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.ide.IDE;

import DiagonosticModel.DiagonosticModelFactory;
import DiagonosticModel.DiagonosticModelPackage;
import DiagonosticModel.ImportArtifact;
import DiagonosticModel.SignalType;
import DiagonosticModel.TestSpecification;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * 
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class NewTestSpecificationHandler extends AbstractHandler {

	public static SignalType signalType;
	public TestSpecification testSpecification;

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);

		FileDialog fileDialog = new FileDialog(window.getShell(), SWT.SAVE);
		String path = fileDialog.open();

		if (path == null || path.isEmpty()) {
			return null;
		}

		File absolute = new File(path);

		System.out.println("path =" + absolute);
		ResourceSet rSet = new ResourceSetImpl();
		rSet.getPackageRegistry().put(DiagonosticModelPackage.eNS_URI, DiagonosticModelPackage.eINSTANCE);
		rSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("tse", new XMIResourceFactoryImpl());

		Resource resource = rSet.createResource(URI.createFileURI(absolute.getAbsolutePath()));
		testSpecification = DiagonosticModelFactory.eINSTANCE.createTestSpecification();
		ImportArtifact importArtifact = DiagonosticModelFactory.eINSTANCE.createImportArtifact();
		importArtifact.setPath("USERDEFINED");
		testSpecification.getImportArtifacts().add(importArtifact);
		resource.getContents().add(testSpecification);

		

		try {
			resource.save(null);

			IFileStore fileOnLocalDisk = EFS.getLocalFileSystem().getStore(absolute.toURI());

			IWorkbenchPage page = window.getActivePage();

			IDE.openEditorOnFileStore(page, fileOnLocalDisk);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PartInitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}
