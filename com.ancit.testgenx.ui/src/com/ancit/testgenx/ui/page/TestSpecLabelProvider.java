package com.ancit.testgenx.ui.page;

import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

import com.ancit.testgenx.ui.utils.Activator;

import DiagonosticModel.CreationModeEnum;
import DiagonosticModel.SignalType;
import DiagonosticModel.SignalTypeEnum;
import DiagonosticModel.TestSpecification;
import DiagonosticModel.Variant;

public class TestSpecLabelProvider extends LabelProvider implements ITableLabelProvider {

	TestSpecification specification;

	@Override
	public Image getColumnImage(Object element, int columnIndex) {
		Image image = null;
		if (element instanceof SignalType) {
			SignalType signal = (SignalType) element;
			if(columnIndex == 2) {
				image = JFaceResources.getImage(signal.getCreationMode().getLiteral());
				if (image == null) {
					if (signal.getCreationMode().equals(CreationModeEnum.IMPORTED)) {
						image = Activator.getDefault().imageDescriptorFromPlugin(Activator.PLUGIN_ID,
								"icons/signaltypes/EParameter.gif").createImage();
						

					} else {
						image = Activator.getDefault().imageDescriptorFromPlugin(Activator.PLUGIN_ID,
										"icons/signaltypes/User.gif").createImage();
					}
					
					JFaceResources.getImageRegistry().put(signal.getCreationMode().getLiteral(),
							image);
				}
			} else if(columnIndex == 0) {
				image = JFaceResources.getImage(signal.getType().getLiteral());
				if (image == null) {
					if (signal.getType().equals(SignalTypeEnum.SIGNAL)) {
						image = Activator.getDefault().imageDescriptorFromPlugin(Activator.PLUGIN_ID,
								"icons/signaltypes/signal.gif").createImage();
						

					} else if(signal.getType().equals(SignalTypeEnum.ENVIRONMENT)){
						image = Activator.getDefault().imageDescriptorFromPlugin(Activator.PLUGIN_ID,
										"icons/signaltypes/environment.gif").createImage();
					} else if(signal.getType().equals(SignalTypeEnum.SYSTEM)){
						image = Activator.getDefault().imageDescriptorFromPlugin(Activator.PLUGIN_ID,
								"icons/signaltypes/system.gif").createImage();
					}
					
					JFaceResources.getImageRegistry().put(signal.getType().getLiteral(),
							image);
				}
			}
		} else if (element instanceof Variant) {
			if(columnIndex == 0) {
				image = JFaceResources.getImage("VARIANT");
				if(image == null) {
					image = Activator.getDefault().imageDescriptorFromPlugin(Activator.PLUGIN_ID,
							"icons/variants/variant.gif").createImage();
					JFaceResources.getImageRegistry().put("VARIANT",
							image);
				}
			}
		}
		return image;
	}

	@Override
	public String getColumnText(Object element, int columnIndex) {

		if (element instanceof SignalType) {
			SignalType signals = (SignalType) element;

			switch (columnIndex) {

			case 0:
				return signals.getName();
			case 1:
				return signals.getType().getLiteral();
//			case 2:
//				return signals.getCreationMode().getLiteral();
				
			case 3:
				return signals.getNamespace();


			}
		} else if (element instanceof Variant) {
			Variant variant = (Variant) element;

			switch (columnIndex) {

			case 0:
				return variant.getName();
			case 1:
				return variant.getDescription();

			}
		}

		return null;
	}

}
