package com.ancit.ecusimx.simulation.view;

import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

import com.ancit.ecusimx.simulation.Activator;
import com.ancit.ecusimx.simulation.model.MessageData;
import com.ancit.ecusimx.simulation.model.MessageRowData;
import com.ancit.ecusimx.simulation.model.SignalData;

public class CANIGBlockLabelProvider extends LabelProvider implements ITableLabelProvider {

	@Override
	public Image getColumnImage(Object element, int columnIndex) {
		if (columnIndex == 0) {
			if (element instanceof MessageData || element instanceof MessageRowData) {
				Image image = JFaceResources.getImage("MSG");
				if (image == null) {
					image = Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "icons/msg_small.png")
							.createImage();
					JFaceResources.getImageRegistry().put("MSG", image);
				}
				return image;
			} else if (element instanceof SignalData) {
				Image image = JFaceResources.getImage("SIGNAL");
				if (image == null) {
					image = Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "icons/signal_small.png")
							.createImage();
					JFaceResources.getImageRegistry().put("SIGNAL", image);
				}
				return image;
			}
		}
		return null;
	}

	@Override
	public String getColumnText(Object element, int columnIndex) {

		if (element instanceof MessageData) {
			MessageData messageobj = (MessageData) element;
			switch (columnIndex) {
			case 0:
				return messageobj.getMessage().getName();
			case 4:
				return Float.toString(messageobj.getCycleTime());
			case 5:
				return Float.toString(messageobj.getSleepTime());
			case 6:
				return messageobj.getOnMessage();
			case 7:
				return messageobj.getOnKey();
				
			default:
				break;
			}
		} else if (element instanceof SignalData) {
			SignalData caplParam = (SignalData) element;

			switch (columnIndex) {
			case 0:
				return caplParam.getSignal().getName();
			case 1:
				return String.valueOf(caplParam.getSignal().getOffset());
			case 2:
				return String.valueOf(caplParam.getSignal().getLength());
			case 3:
				return caplParam.getData();

			default:
				break;
			}
		} else if (element instanceof MessageRowData) {
			MessageRowData msgRowData = (MessageRowData) element;

			switch (columnIndex) {
			case 0:
				return msgRowData.getMessage().getId();
			case 3:
				return String.valueOf(msgRowData.getData());
			case 4:
				return String.valueOf(msgRowData.getCycleTime());
			case 5:
				return String.valueOf(msgRowData.getSleepTime());
			case 6:
				return msgRowData.getOnMessage();
			case 7:
				return msgRowData.getOnKey();

			default:
				break;
			}
		}

		return null;
	}

}
