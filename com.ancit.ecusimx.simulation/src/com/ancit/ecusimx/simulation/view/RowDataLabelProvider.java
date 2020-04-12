package com.ancit.ecusimx.simulation.view;

import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

import com.ancit.ecusimx.simulation.model.MessageRowData;

public class RowDataLabelProvider extends LabelProvider implements ITableLabelProvider {

	@Override
	public Image getColumnImage(Object element, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getColumnText(Object element, int columnIndex) {

		if (element instanceof MessageRowData) {
			MessageRowData messageobj = (MessageRowData) element;
			switch (columnIndex) {
			case 0:
				return messageobj.getMessage().getId();
			case 1:
				return String.valueOf(messageobj.getData());

			case 2:
				return String.valueOf(messageobj.getCycleTime());
			default:
				break;
			}
		}

		return null;
	}

}
