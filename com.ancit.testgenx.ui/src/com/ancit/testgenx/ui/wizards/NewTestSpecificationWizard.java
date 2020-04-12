package com.ancit.testgenx.ui.wizards;

import java.io.File;

import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.filesystem.IFileStore;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.wizard.Wizard;
import org.eclipse.ui.INewWizard;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.ide.IDE;

import DiagonosticModel.DiagonosticModelFactory;
import DiagonosticModel.DiagonosticModelPackage;
import DiagonosticModel.ImportArtifact;
import DiagonosticModel.SignalType;
import DiagonosticModel.TestSpecification;

public class NewTestSpecificationWizard extends Wizard implements INewWizard {

	IWorkbenchWindow window;
	private NewTestSpecificationWizardPage dbcWiard;
	private SignalType signalType;

	public NewTestSpecificationWizard() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(IWorkbench workbench, IStructuredSelection selection) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addPages() {

		dbcWiard = new NewTestSpecificationWizardPage();
		addPage(dbcWiard);

		super.addPages();
	}

	@Override
	public boolean performFinish() {

		try {
			String selectedFile = dbcWiard.getSelectedFile();
			if (selectedFile != null) {

				System.out.println("Finish clicked " + selectedFile);

				File absolute = new File(selectedFile);

				ResourceSet rSet = new ResourceSetImpl();
				rSet.getPackageRegistry().put(DiagonosticModelPackage.eNS_URI, DiagonosticModelPackage.eINSTANCE);
				rSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("tse", new XMIResourceFactoryImpl());

				Resource resource = rSet.createResource(URI.createFileURI(absolute.getAbsolutePath()));
				TestSpecification testSpecification = DiagonosticModelFactory.eINSTANCE.createTestSpecification();
				testSpecification.setAuthor(dbcWiard.getAuthor());
				testSpecification.setDescription(dbcWiard.getDescription());
				testSpecification.setFunctionName(dbcWiard.getFunctionName());
				testSpecification.setVersion("1.0.0");
				testSpecification.setFunctionVersion("1.0.0");
				testSpecification.setName(dbcWiard.getTestSpecificationName());
				
				ImportArtifact importArtifact = DiagonosticModelFactory.eINSTANCE.createImportArtifact();
				importArtifact.setPath("USERDEFINED");
				testSpecification.getImportArtifacts().add(importArtifact);
				
				resource.getContents().add(testSpecification);

				System.out.println("tse file created successfully");

				resource.save(null);

				IFileStore fileOnLocalDisk = EFS.getLocalFileSystem().getStore(absolute.toURI());
				IWorkbenchWindow activeWorkbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
				IWorkbenchPage page = activeWorkbenchWindow.getActivePage();

				
				PlatformUI.getWorkbench().showPerspective("com.ancit.diagnostic_tool.perspective.Diagnostic_Perspective", activeWorkbenchWindow);
				IDE.openEditorOnFileStore(page, fileOnLocalDisk);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return true;
	}

}
