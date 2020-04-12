package com.ancit.ecusimx.simulation.view;

import java.util.List;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import com.ancit.ecusimx.simulation.model.MessageData;
import com.ancit.ecusimx.simulation.model.MessageRowData;

public class CANIGBlockContentProvider implements ITreeContentProvider {

	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof MessageData) {
			MessageData message = (MessageData) parentElement;
			return message.getSignalData().toArray();
		}
		return null;
	}


	public boolean hasChildren(Object element) {
		if (element instanceof MessageData) {
			MessageData message = (MessageData) element;
			return message.getSignalData().size() > 0;
		} else if (element instanceof MessageRowData) {
			return false;
		}
		return false;
	}

	public Object[] getElements(Object inputElement) {
		if (inputElement instanceof List) {
			return ((List<?>)inputElement).toArray();
		}
		return null;
	}

	public void dispose() {
	}

	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		// shell.setText("Now browsing: " + newInput);
	}


	@Override
	public Object getParent(Object element) {
		// TODO Auto-generated method stub
		return null;
	}

}
