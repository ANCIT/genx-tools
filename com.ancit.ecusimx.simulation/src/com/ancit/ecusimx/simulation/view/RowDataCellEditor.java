package com.ancit.ecusimx.simulation.view;

import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.TableItem;

import com.ancit.ecusimx.simulation.model.MessageRowData;

public class RowDataCellEditor implements ICellModifier {

	private TableViewer rowDataTblViewer;

	public RowDataCellEditor(TableViewer rowDataTblViewer) {
		this.rowDataTblViewer = rowDataTblViewer;
	}

	@Override
	public boolean canModify(Object element, String property) {
		return true;
	}

	@Override
	public Object getValue(Object element, String property) {
		if (element instanceof MessageRowData) {

			MessageRowData msgObj = (MessageRowData) element;
			switch (property) {
			case "Message ID":
				return msgObj.getMessage().getId();

			case "Data":
				return msgObj.getData();

			case "Cycle":
				return msgObj.getCycleTime();

			default:
				break;
			}

		}
		this.rowDataTblViewer.refresh();
		return null;
	}

	@Override
	public void modify(Object element, String property, Object value) {
		if (element instanceof TableItem) {
			MessageRowData rowdataObj = (MessageRowData) ((TableItem) element).getData();
			switch (property) {
			case "Message ID":
				rowdataObj.getMessage().setId(String.valueOf(value));
				break;

			case "Data":
				if (!value.toString().isEmpty()) {
					rowdataObj.setData(value.toString());
				}
				break;

			case "Cycle":
				if (!value.toString().isEmpty()) {
					rowdataObj.setCycleTime(Float.valueOf(value.toString()));
				}
				break;
			default:
				break;
			}
		}
		this.rowDataTblViewer.refresh();
	}

}
