package com.ancit.ecusimx.simulation.view;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.dialogs.TitleAreaDialog;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

import com.ancit.genxtools.dbc.model.Bus;
import com.ancit.genxtools.dbc.model.Message;

public class LookupElementListSelectionDialog extends TitleAreaDialog {

	private class TableLabelProvider extends LabelProvider {
		@Override
		public String getText(Object element) {
			// TODO Auto-generated method stub

			if ((element instanceof Message)) {
				Message sidesType = (Message) element;
				return sidesType.getName();

			}
			return null;

		}
	}

	private List<Bus> buses;
	private Message messageObject;

	// NetworkDefinition network = reader.getNetwork();
	// List<Bus> bus = reader.getNetwork().getBus();
	/**
	 * Create the dialog.
	 * 
	 * @param parentShell
	 * @param spec
	 * @param spec
	 */
	public LookupElementListSelectionDialog(Shell parentShell, List<Bus> spec) {
		super(parentShell);
		this.buses = spec;
	}

	/**
	 * Create contents of the dialog.
	 * 
	 * @param parent
	 */
	@Override
	protected Control createDialogArea(Composite parent) {
		setMessage("Variable selection");
		setTitle("Please select variable.");
		Composite container = (Composite) super.createDialogArea(parent);

		Composite composite = new Composite(container, SWT.NONE);
		composite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
		composite.setLayout(new GridLayout(3, false));

		ListViewer listViewer = new ListViewer(composite, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL);
		org.eclipse.swt.widgets.List list = listViewer.getList();
		list.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 3, 1));

		listViewer.setLabelProvider(new TableLabelProvider());
		listViewer.setContentProvider(ArrayContentProvider.getInstance());
		ArrayList<Message> messages = new ArrayList<Message>();
		for (Bus bus : buses) {
			messages.addAll(bus.getMessage());
		}

		listViewer.setInput(messages); // collect the output and convert streams to a List

		listViewer.addSelectionChangedListener(new ISelectionChangedListener() {
			@Override
			public void selectionChanged(SelectionChangedEvent selectionEvent) {
				final IStructuredSelection selection = (IStructuredSelection) listViewer.getSelection();
				if (selection != null) {
					messageObject = (Message) selection.getFirstElement();

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

	public Message getMessageObject() {
		return messageObject;
	}

}
