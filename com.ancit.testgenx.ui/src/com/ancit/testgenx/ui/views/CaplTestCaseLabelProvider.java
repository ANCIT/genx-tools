package com.ancit.testgenx.ui.views;

import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

import com.ancit.testgenx.ui.utils.Activator;

import DiagonosticModel.CAPLParam;
import DiagonosticModel.SetAction;

public class CaplTestCaseLabelProvider extends LabelProvider implements IBaseLabelProvider, ITableLabelProvider {

	@Override
	public Image getColumnImage(Object element, int columnIndex) {
		Image image = null;

		if (columnIndex == 0) {
			if (element instanceof CAPLParam) {
				image = JFaceResources.getImageRegistry().get("CaplParam");
				if (image == null) {
					image = Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "icons/caplparam_obj.gif")
							.createImage();
					JFaceResources.getImageRegistry().put("CaplParam", image);
				}
			}
		}
		return image;
	}

	@Override
	public String getColumnText(Object element, int columnIndex) {

		if (element instanceof CAPLParam) {
			CAPLParam caplParam = (CAPLParam) element;

			switch (columnIndex) {
			case 0:
				return caplParam.getName();
			case 1:
				return caplParam.getType();
			case 2:
				return caplParam.getValue();

			default:
				break;
			}
		}

		return null;
	}

}
