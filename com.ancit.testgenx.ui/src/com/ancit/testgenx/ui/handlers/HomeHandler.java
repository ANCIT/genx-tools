package com.ancit.testgenx.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IPerspectiveDescriptor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.WorkbenchException;

public class HomeHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbench wb = PlatformUI.getWorkbench();

		IWorkbenchWindow activeWorkbenchWindow = wb.getActiveWorkbenchWindow();

		try {
			PlatformUI.getWorkbench().showPerspective("com.ancit.diagnostictool.appln.perspective",
					activeWorkbenchWindow);
		} catch (WorkbenchException e) {
			e.printStackTrace();
		}

		return null;
	}

}
