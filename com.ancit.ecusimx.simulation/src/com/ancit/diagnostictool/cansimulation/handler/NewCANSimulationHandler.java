package com.ancit.diagnostictool.cansimulation.handler;

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
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.WorkbenchException;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.ide.IDE;

public class NewCANSimulationHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		// TODO Auto-generated method stub
		File absolute = new File("C:\\Users\\LENOVO\\Desktop\\Working_Scrept\\test.cansim");

		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);

//		FileDialog fileDialog = new FileDialog(window.getShell(), SWT.OPEN);
//		fileDialog.setFilterExtensions(new String[] {"*.tse"});
//		String path = fileDialog.open();
//
//		if (path == null || path.isEmpty()) {
//			return null;
//		}
//
//		File absolute = new File(path);
		try {

			IFileStore fileOnLocalDisk = EFS.getLocalFileSystem().getStore(absolute.toURI());

			IWorkbenchPage page = window.getActivePage();
			PlatformUI.getWorkbench().showPerspective("com.ancit.diagnostictool.cansimulation.cansimulationperspectiveid", window);
			IDE.openEditorOnFileStore(page, fileOnLocalDisk);

		} catch (PartInitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (WorkbenchException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}
