package com.ancit.testgenx.ui.celleditor;

import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.TableItem;

import DiagonosticModel.Variant;

public class TracebilityCellEditor implements ICellModifier {

	private TableViewer variableTblViewer;

	public TracebilityCellEditor(TableViewer variableTblViewer) {
		this.variableTblViewer = variableTblViewer;
	}

	@Override
	public boolean canModify(Object element, String property) {
		return true;
	}

	@Override
	public Object getValue(Object element, String property) {
//		if (element instanceof MyObject) {
//			switch (property) {
//			case "Type":
//				return element.getName();
//
//			case "Tracebility Artifact ID":
//				return element.getDescription();
//
//			default:
//				break;
//			}

//		}
		variableTblViewer.refresh();
		return null;
	}

	@Override
	public void modify(Object element, String property, Object value) {
		if (element instanceof TableItem) {
			Variant variant = (Variant) ((TableItem) element).getData();
			switch (property) {
			case "Name":
				variant.setName(value.toString());
				break;

			case "Description":
				variant.setDescription(value.toString());
			default:
				break;
			}
		}
		variableTblViewer.refresh();

	}

}
