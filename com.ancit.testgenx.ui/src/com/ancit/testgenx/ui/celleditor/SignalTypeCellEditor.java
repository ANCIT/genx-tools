package com.ancit.testgenx.ui.celleditor;

import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.TableItem;

import DiagonosticModel.CreationModeEnum;
import DiagonosticModel.SignalType;
import DiagonosticModel.SignalTypeEnum;

public class SignalTypeCellEditor implements ICellModifier {

	private TableViewer tblViewer;
	private String[] comboItems;

	public SignalTypeCellEditor(TableViewer envVarTblViewer, String[] comboItems) {
		this.tblViewer = envVarTblViewer;
		this.comboItems = comboItems;
	}

	@Override
	public boolean canModify(Object element, String property) {
		if (element instanceof SignalType) {
			SignalType signalType = (SignalType) element;

			if (signalType.getCreationMode().getLiteral().equals(CreationModeEnum.USER_DEFINED.getLiteral())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public Object getValue(Object element, String property) {
		if (element instanceof SignalType) {
			SignalType signalType = (SignalType) element;
			switch (property) {
			case "Param Name":
				return signalType.getName();

			case "Type":
				if(signalType.getType().getValue() > 0) {
				return signalType.getType().getValue() - 1;
				}else {
					return signalType.getType().getValue();
				}

			case "Namespace":
				return signalType.getNamespace();

			default:
				break;
			}

		}
		tblViewer.refresh();
		return null;
	}

	@Override
	public void modify(Object element, String property, Object value) {
		if (element instanceof TableItem) {
			SignalType signalType = (SignalType) ((TableItem) element).getData();
			switch (property) {
			case "Param Name":
				signalType.setName(value.toString());
				break;

			case "Type":
				signalType.setType(SignalTypeEnum.get(comboItems[(Integer) value]));
				break;

			case "Namespace":
				signalType.setNamespace(value.toString());

				break;
			default:
				break;
			}
		}
		tblViewer.refresh();

	}

}
