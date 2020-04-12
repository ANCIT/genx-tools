package com.ancit.testgenx.ui.dialogs;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.zest.core.viewers.GraphViewer;
import org.eclipse.zest.layouts.LayoutAlgorithm;
import org.eclipse.zest.layouts.LayoutStyles;
import org.eclipse.zest.layouts.algorithms.TreeLayoutAlgorithm;

import com.ancit.testgenx.ui.zest.ZestLabelProvider;
import com.ancit.testgenx.ui.zest.ZestNodeContentProvider;

import DiagonosticModel.impl.TestCaseImpl;

public class NewTestStepDialog extends TitleAreaDialog {

	public static final String ID = "de.vogella.zest.jface.view";
    private GraphViewer viewer;
	private TestCaseImpl caseImpl;


	
	public NewTestStepDialog(Shell parentShell, TestCaseImpl caseImpl) {
		super(parentShell);
		this.caseImpl = caseImpl;
		setShellStyle(getShellStyle() | SWT.RESIZE | SWT.DIALOG_TRIM); 
	}

	@Override
    public void create() {
        super.create();
        setTitle("TestStep Check Action");
        setMessage("Fill required check action details ", IMessageProvider.INFORMATION);
    }
	
	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Check Action");
	}
	
	
	@Override
	protected Control createDialogArea(Composite parent) {


		Composite composite = new Composite(parent, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		composite.setLayout(new FillLayout());
		
        viewer = new GraphViewer(composite, SWT.BORDER);
        viewer.setContentProvider(new ZestNodeContentProvider());
        viewer.setLabelProvider(new ZestLabelProvider());
       
        
        viewer.setInput(caseImpl.getTestSteps());
        LayoutAlgorithm layout = setLayout();
        viewer.setLayoutAlgorithm(layout, true);
        viewer.applyLayout();
		return composite;
    }

    private LayoutAlgorithm setLayout() {
        LayoutAlgorithm layout;
        // layout = new
        // SpringLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING);
           layout = new TreeLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING);
        // layout = new
        // GridLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING);
        // layout = new
        // HorizontalTreeLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING);
        // layout = new
        // RadialLayoutAlgorithm(LayoutStyles.NO_LAYOUT_NODE_RESIZING);
        return layout;
		
		
	}


	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
	}

	@Override
	protected void okPressed() {

/*		txtNameValue = txtName.getText();
		opValue = combo.getText();
		textValue = txtValue.getText();

		/// spec = (TestSpecification) caseImpl.eContainer().eContainer();

		if (signalType == null || !signalType.getName().equals(txtName.getText())) {
			signalType = DiagonosticModelFactory.eINSTANCE.createSignalType();
			signalType.setName(checkAction.getName());
			signalType.setType(SignalTypeEnum.UNDEFINED);
		}
*/		super.okPressed();
	}

	

}
