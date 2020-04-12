package com.ancit.testgenx.ui.views;

import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.TableItem;

import DiagonosticModel.CAPLParam;

public class CAPLTestCaseCellModifier implements ICellModifier {

	private TableViewer tableViewerParameter;

	public CAPLTestCaseCellModifier(TableViewer tableViewerParameter) {
		this.tableViewerParameter = tableViewerParameter;
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canModify(Object element, String property) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Object getValue(Object element, String property) {

		if (element instanceof CAPLParam) {

			CAPLParam caplParam = (CAPLParam) element;

			if (property.equalsIgnoreCase("name")) {

				return caplParam.getName();

			} else if (property.equalsIgnoreCase("type")) {
				return caplParam.getType();
			}

			else if (property.equalsIgnoreCase("value")) {
				return caplParam.getValue();
			}
		}
		return null;
	}

	@Override
	public void modify(Object element, String property, Object value) {

		if (value == null) {
			return;
		}
		if (element instanceof TableItem) {

			CAPLParam caplParam = (CAPLParam) ((TableItem) element).getData();

			if (property.equalsIgnoreCase("name")) {

				caplParam.setName(value.toString());
			}

			else if (property.equalsIgnoreCase("type")) {
				caplParam.setType(value.toString());
			} else if (property.equalsIgnoreCase("value")) {
				caplParam.setValue(value.toString());
			}
		}
		tableViewerParameter.refresh();
	}

}
