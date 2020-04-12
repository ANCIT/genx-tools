package com.ancit.testgenx.ui.views;

import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.TableItem;

import DiagonosticModel.Action;
import DiagonosticModel.CheckAction;
import DiagonosticModel.DiagonosticModelFactory;
import DiagonosticModel.SignalType;
import DiagonosticModel.TestStep;
import DiagonosticModel.impl.SignalTypeImpl;

public class ActionCellModifier implements ICellModifier {

	TableViewer tableViewerAction;
	private SignalType signalKey;
	private SignalType signalType;

	public ActionCellModifier(TableViewer tableViewerAction) {
		this.tableViewerAction = tableViewerAction;
	}

	@Override
	public boolean canModify(Object element, String property) {
		if (!property.equalsIgnoreCase("parameter")) {
			
			return false;
		}
		return true;
	}

	@Override
	public Object getValue(Object element, String property) {

		if (element instanceof TestStep) {

			TestStep diagonasticAction = (TestStep) element;

			
			if (property.equalsIgnoreCase("parameter")) {

				System.out.println("key = "+diagonasticAction.getKey().getName());
				return diagonasticAction.getKey().getName();

			} else if (property.equalsIgnoreCase("value")) {
				return ((Action) diagonasticAction).getValue();
			}
		}
		return null;
	}
	
	
	


	@Override
	public void modify(Object element, String property, Object value) {
		// TODO Auto-generated method stub

		if (value == null) {
			return;
		}
		if (element instanceof TableItem) {

			TestStep diagonasticAction = (TestStep) ((TableItem) element).getData();

			if (property.equalsIgnoreCase("parameter")) {

				if(element instanceof CheckAction) {
					diagonasticAction = (CheckAction)value;
				}
			}

			else if (property.equalsIgnoreCase("value")) {
				if (value instanceof SignalType) {

					((SignalType) value).getName();
				}
				((Action) diagonasticAction).setValue(value.toString());
			}
		}
		tableViewerAction.refresh();
	}

}
