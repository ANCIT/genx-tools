package com.ancit.testgenx.ui.provider;

import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

import DiagonosticModel.DiagnosticParam;
import DiagonosticModel.DiagnosticParamValueType;
import DiagonosticModel.OneOf;
import DiagonosticModel.Range;
import DiagonosticModel.Var;

public class DiagnosticTableLabelProvider extends LabelProvider implements ITableLabelProvider {

	@Override
	public Image getColumnImage(Object element, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getColumnText(Object element, int columnIndex) {
		// TODO Auto-generated method stub
		if (element instanceof DiagnosticParam) {
			DiagnosticParam diagnosticRequest = (DiagnosticParam) element;
			switch (columnIndex) {
			case 0:
				return diagnosticRequest.getQualifier();

			case 1:
				if (null != diagnosticRequest.getCopyToVar()) {
					return diagnosticRequest.getCopyToVar().toString();
				} else {
					return "";
				}
			case 2:
				if (null != diagnosticRequest.getValueTypes()) {

					if (diagnosticRequest.getValueTypes() instanceof OneOf) {
						OneOf valueTypes = (OneOf)diagnosticRequest.getValueTypes();						
						return "OneOf  "+valueTypes.getValues()+" ";
					} else if (diagnosticRequest.getValueTypes() instanceof Var) {
						Var valueTypes = (Var)diagnosticRequest.getValueTypes();
						return "Var [ "+valueTypes.getName()+" ]";
					} else if (diagnosticRequest.getValueTypes() instanceof Range) {
						Range valueTypes = (Range)diagnosticRequest.getValueTypes();
						return "Range [ "+valueTypes.getFrom()+" : "+valueTypes.getTo()+" ]";
					}
				} else {
					return "";
				}
			default:
				break;
			}
		}
		return null;
	}

}
