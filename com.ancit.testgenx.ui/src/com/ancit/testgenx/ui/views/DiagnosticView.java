package com.ancit.testgenx.ui.views;

import org.eclipse.emf.edit.ui.provider.AdapterFactoryContentProvider;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.part.ViewPart;

import DiagonosticModel.CAPLTestCase;
import DiagonosticModel.DiagonosticModelFactory;
import DiagonosticModel.TestCase;
import DiagonosticModel.TestGroup;
import DiagonosticModel.TestSpecification;
import DiagonosticModel.provider.DiagonosticModelItemProviderAdapterFactory;

public class DiagnosticView extends ViewPart {

	Tree tree;

	public DiagnosticView() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createPartControl(Composite parent) {

		FormToolkit formToolkit = new FormToolkit(parent.getDisplay());

		Composite composite = formToolkit.createComposite(parent, SWT.NONE);
		formToolkit.paintBordersFor(composite);
		composite.setLayout(new GridLayout(1, false));

		Section section = formToolkit.createSection(composite, Section.TWISTIE | Section.TITLE_BAR);
		section.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
		formToolkit.paintBordersFor(section);

		section.setText("Sction1");
		section.setExpanded(true);

		Composite composite1 = formToolkit.createComposite(section, SWT.NONE);
		composite1.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		composite1.setLayout(new GridLayout(1, false));
		section.setClient(composite1);

		TestSpecification testSpecification = DiagonosticModelFactory.eINSTANCE.createTestSpecification();
		testSpecification.setName("Test Specification");

		TestGroup testGroup = DiagonosticModelFactory.eINSTANCE.createTestGroup();
		testGroup.setName("Test Group");
		testSpecification.getTestGroups().add(testGroup);

		TestCase testCase = DiagonosticModelFactory.eINSTANCE.createTestCase();
		testCase.setName("Test Cases");
		testGroup.getTestCases().add(testCase);

		CAPLTestCase caplTestCase = DiagonosticModelFactory.eINSTANCE.createCAPLTestCase();
		caplTestCase.setName("CAPLTestCase");
		testGroup.getCapltestcases().add(caplTestCase);

		TreeViewer treeViewer = new TreeViewer(composite1, SWT.BORDER | SWT.FULL_SELECTION);
		tree = treeViewer.getTree();
		GridData gd_tree = new GridData(SWT.FILL, SWT.FILL, true, true);
		gd_tree.heightHint = 466;
		tree.setLayoutData(gd_tree);
		tree.setLinesVisible(true);
		tree.setHeaderVisible(true);
		treeViewer.setContentProvider(
				new AdapterFactoryContentProvider(new DiagonosticModelItemProviderAdapterFactory()));
		treeViewer.setLabelProvider(new AdapterFactoryLabelProvider(new DiagonosticModelItemProviderAdapterFactory()));
		treeViewer.setInput(testSpecification);

		Composite composite2 = new Composite(parent, SWT.NONE);
		composite2.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		composite2.setLayout(new GridLayout(2, false));

		Label lblTestId = new Label(composite2, SWT.NONE);
		lblTestId.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		lblTestId.setText("Test ID :");

		Text txtTestID = new Text(composite2, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		txtTestID.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		txtTestID.setText("");

		Label lblKeyID = new Label(composite2, SWT.NONE);
		lblKeyID.setLayoutData(new GridData(SWT.BEGINNING, SWT.CENTER, false, false));
		lblKeyID.setText("Key ID:");

		Text text = new Text(composite2, SWT.SINGLE | SWT.LEAD | SWT.BORDER);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		text.setText("");

	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
