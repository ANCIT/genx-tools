package com.ancit.testgenx.ui.wizards;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchWindow;

public class ConvertToXMLWizard extends Wizard implements INewWizard {

	IWorkbenchWindow window;
	private ConvertToXMLWizardPage dbcWiard;

	public ConvertToXMLWizard() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addPages() {

		dbcWiard = new ConvertToXMLWizardPage();
		addPage(dbcWiard);

		super.addPages();
	}

	@Override
	public boolean performFinish() {

		try {
			String selectedFile = dbcWiard.getSourceFile();
			if (selectedFile != null) {

				File file = new File(selectedFile);
				FileWriter writer = new FileWriter(dbcWiard.getDestinationFile(), true);
				BufferedReader br = new BufferedReader(new FileReader(file));

				String st;
				while ((st = br.readLine()) != null) {

					if (st.trim().equalsIgnoreCase("[Results]")) {
						st = st.replace("[Results]", "");
						if (!st.trim().equalsIgnoreCase("")) {
							writer.write("\n");
							writer.write(st);
						}

					} else if (!st.trim().equalsIgnoreCase("")) { 
						st = st.replace(st.substring(0, st.indexOf("=") > 0 ? st.indexOf("=") + 1 : 0), "");						
						writer.write(st);
						writer.write("\n");
					}
				}
				writer.close();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return true;
	}

}
