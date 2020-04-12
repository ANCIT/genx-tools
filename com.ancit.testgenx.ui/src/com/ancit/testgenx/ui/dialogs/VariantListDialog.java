package com.ancit.testgenx.ui.dialogs;

import java.util.List;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

import com.ancit.testgenx.ui.page.VariantLabelProvider;

import DiagonosticModel.TestSpecification;
import DiagonosticModel.Variant;

public class VariantListDialog extends TitleAreaDialog {

	private TestSpecification testSpecification;
	private ListViewer viewer;
	private List<Variant> variantList;
	public VariantListDialog(Shell parentShell, TestSpecification testSpecification) {
		super(parentShell);
		this.testSpecification = testSpecification;

		// TODO Auto-generated constructor stub
	}
	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Variants");
	}
	
	@Override
	public void create() {
		super.create();
		setTitle("Variants");
		setMessage("List of variant", IMessageProvider.INFORMATION);
	}

	/**
	 * Create contents of the dialog.
	 * 
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		Composite container = (Composite) super.createDialogArea(parent);

		Composite composite = new Composite(container, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		composite.setLayout(new GridLayout(3, false));

		viewer = new ListViewer(composite);
		viewer.getList().setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		viewer.setContentProvider(ArrayContentProvider.getInstance());
		viewer.setLabelProvider(new VariantLabelProvider());
		viewer.setInput(testSpecification.getVariants());
		viewer.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent event) {
				IStructuredSelection selection = (IStructuredSelection) event.getSelection();
				variantList = selection.toList();
				if (!variantList.isEmpty())
					getButton(IDialogConstants.OK_ID).setEnabled(true);
			}
		});

		return container;
	}

	/**
	 * Create contents of the button bar.
	 * 
	 * @param parent
	 */
	@Override
	protected void createButtonsForButtonBar(Composite parent) {
		createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
		getButton(IDialogConstants.OK_ID).setEnabled(false);
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
	}

	@Override
	protected void okPressed() {

		super.okPressed();
	}

	public List<Variant> getVariantList() {
		return variantList;
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(450, 372);
	}

}
