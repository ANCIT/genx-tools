package com.ancit.testgenx.ui.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.handlers.HandlerUtil;

import com.ancit.testgenx.ui.wizards.NewTestSpecificationWizard;

public class ImportDBCHandler extends AbstractHandler{

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		
		Shell activeShell = HandlerUtil.getActiveShell(event);

		WizardDialog dialog = new WizardDialog(activeShell, new NewTestSpecificationWizard());
		dialog.open();
		
		return null;
	}

}
