package com.ancit.testgenx.ui.provider;

import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

import DiagonosticModel.TracebilityArtifact;

public class TracebilityLabelProvider extends LabelProvider implements ITableLabelProvider {

	@Override
	public Image getColumnImage(Object element, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getColumnText(Object element, int columnIndex) {
		String result = new String();
		if (element instanceof TracebilityArtifact) {
			TracebilityArtifact artifact = (TracebilityArtifact) element;

			switch (columnIndex) {
			case 0:
				result = artifact.getType().getName();
				break;
			case 1:
				result = artifact.getUrl();
				break;

			default:
				break;
			}
		}

		return result;
	}

}
