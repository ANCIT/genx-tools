package com.ancit.testgenx.ui.dialogs;

import java.util.ArrayList;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.IMessageProvider;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.viewers.TreeViewerColumn;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Combo;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.TreeColumn;
import org.eclipse.ui.dialogs.FilteredTree;
import org.eclipse.ui.dialogs.PatternFilter;

import DiagonosticModel.SignalType;
import DiagonosticModel.SignalTypeEnum;
import DiagonosticModel.TestSpecification;

public class LookupElementListSelectionDialog extends TitleAreaDialog {

	private class TableLabelProvider extends LabelProvider implements ITableLabelProvider {
		public Image getColumnImage(Object element, int columnIndex) {
			return null;
		}

		public String getColumnText(Object element, int columnIndex) {
			if ((element instanceof SignalType)) {
				SignalType sidesType = (SignalType) element;
				switch (columnIndex) {
				case 0:
					if (null != sidesType.getMessageName() && sidesType.getName()!=null) {
						return sidesType.getName() + " (" + sidesType.getMessageName() + ")";
					} else {
						return sidesType.getName();

					}

				}
			}
			return null;
		}
	}

	private TestSpecification spec;
	private TreeViewer tableViewer;
	private SignalType signalType;
	private String tmpSelectedItems = null, searchObj = null;
	private Combo variableSelectionCombo;
	private String comboelements;
	private boolean loopFlag= false;
	
	@Override
	protected void configureShell(Shell newShell) {
		super.configureShell(newShell);
		newShell.setText("Look Up");
	}
	/**
	 * Create the dialog.
	 * 
	 * @param parentShell
	 * @param spec
	 * @param spec
	 */
	public LookupElementListSelectionDialog(Shell parentShell, TestSpecification spec,boolean loopFlag) {
		super(parentShell);
		this.spec = spec;
		this.loopFlag= loopFlag;
	}

	/**
	 * Create contents of the dialog.
	 * 
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		setMessage("Select any one variable(signal) ", IMessageProvider.INFORMATION);
		setTitle("select variable.");
		Composite container = (Composite) super.createDialogArea(parent);

		variableSelectionCombo = new Combo(container, SWT.NONE | SWT.READ_ONLY);
		variableSelectionCombo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		if(loopFlag) {
			variableSelectionCombo.add(SignalTypeEnum.SYSTEM.getLiteral());
			
			variableSelectionCombo.select(0);
			tmpSelectedItems = SignalTypeEnum.SYSTEM.getLiteral();
		}else {
			variableSelectionCombo.add(SignalTypeEnum.SIGNAL.getLiteral());
			variableSelectionCombo.add(SignalTypeEnum.ENVIRONMENT.getLiteral());
			variableSelectionCombo.add(SignalTypeEnum.SYSTEM.getLiteral());
			variableSelectionCombo.add(SignalTypeEnum.UNDEFINED.getLiteral());
			
			variableSelectionCombo.select(0);
			tmpSelectedItems = SignalTypeEnum.SIGNAL.getLiteral();
		}
	

		Composite composite = new Composite(container, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		composite.setLayout(new GridLayout(3, false));

		variableSelectionCombo.addListener(SWT.Selection, new Listener() {

			@Override
			public void handleEvent(Event event) {
				// TODO Auto-generated method stub
				int idx = variableSelectionCombo.getSelectionIndex();
				String selectedVariableName = variableSelectionCombo.getItem(idx);
				tmpSelectedItems = selectedVariableName;

				tableViewer.refresh();
			}
		});
		
		PatternFilter filter = new PatternFilter();
		FilteredTree tree = new FilteredTree(composite, SWT.MULTI | SWT.H_SCROLL
				| SWT.V_SCROLL, filter, true);
		
		
		tableViewer = tree.getViewer();
//		table = tableViewer.getTree();
//		table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1));

		TreeViewerColumn tableViewerColumn = new TreeViewerColumn(tableViewer, SWT.NONE);
		TreeColumn tblclmnNewColumn = tableViewerColumn.getColumn();
		tblclmnNewColumn.setWidth(400);
		tableViewer.setLabelProvider(new TableLabelProvider());
		tableViewer.setContentProvider(new ITreeContentProvider() {

			@Override
			public Object[] getElements(Object inputElement) {
				if (inputElement instanceof TestSpecification) {
					TestSpecification testSpecification = (TestSpecification) inputElement;
					return testSpecification.getSignals().toArray();
				}
				return new ArrayList().toArray();
			}

			@Override
			public Object[] getChildren(Object parentElement) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Object getParent(Object element) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public boolean hasChildren(Object element) {
				// TODO Auto-generated method stub
				return false;
			}
			
		});
		tableViewer.setInput(spec);              // collect the output and convert streams to a List

		ViewerFilter viewerFilter = new ViewerFilter() {

			@Override
			public boolean select(Viewer viewer, Object parentElement, Object element) {
				SignalType signalType = (SignalType) element;

				if (null != searchObj && !searchObj.trim().equalsIgnoreCase("")
						&& searchObj.trim().contains(signalType.getName())) {
					return true;
				}

				if (null != tmpSelectedItems && tmpSelectedItems.equalsIgnoreCase(signalType.getType().getLiteral())) {
					return true;
				}

				return false;
			}
		};
		tableViewer.addFilter(viewerFilter);

		tableViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent selectionEvent) {
				final IStructuredSelection selection = (IStructuredSelection) tableViewer.getSelection();
				if (selection != null) {
					signalType = (SignalType) selection.getFirstElement();

				}
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
		createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
	}

	@Override
	protected void okPressed() {

		super.okPressed();
	}

	/**
	 * Return the initial size of the dialog.
	 */
	@Override
	protected Point getInitialSize() {
		return new Point(530, 414);
	}

	public SignalType getSignalType() {
		return signalType;
	}

	public String getComboelements() {
		return comboelements;
	}

}
