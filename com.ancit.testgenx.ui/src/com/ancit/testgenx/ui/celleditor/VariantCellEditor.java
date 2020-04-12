package com.ancit.testgenx.ui.celleditor;

import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.TableItem;

import DiagonosticModel.Variant;

public class VariantCellEditor implements ICellModifier {

	private TableViewer variableTblViewer;

	public VariantCellEditor(TableViewer variableTblViewer) {
		this.variableTblViewer = variableTblViewer;
	}

	@Override
	public boolean canModify(Object element, String property) {
		return true;
	}

	@Override
	public Object getValue(Object element, String property) {
		if (element instanceof Variant) {
			Variant variant = (Variant) element;
			switch (property) {
			case "Name":
				return variant.getName();

			case "Description":
				return variant.getDescription();

			default:
				break;
			}

		}
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
