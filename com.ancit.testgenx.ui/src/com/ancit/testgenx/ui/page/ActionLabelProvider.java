package com.ancit.testgenx.ui.page;

import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

import com.ancit.testgenx.ui.utils.Activator;

import DiagonosticModel.CheckAction;
import DiagonosticModel.DiagnosticService;
import DiagonosticModel.OperatorTypeEnum;
import DiagonosticModel.SetAction;
import DiagonosticModel.TestStep;
import DiagonosticModel.WaitAction;

public class ActionLabelProvider extends LabelProvider implements IBaseLabelProvider, ITableLabelProvider {

	@Override
	public Image getColumnImage(Object element, int columnIndex) {
		TestStep action = (TestStep) element;
		Image image = null;
		switch (columnIndex) {
		case 0:
			if (action instanceof SetAction) {
				image = JFaceResources.getImageRegistry().get("SetAction");
				if (image == null) {
					image = Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "icons/SetAction.gif")
							.createImage();
					JFaceResources.getImageRegistry().put("SetAction", image);
				}
			} else if (action instanceof CheckAction) {
				image = JFaceResources.getImageRegistry().get("CheckAction");
				if (image == null) {
					image = Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "icons/CheckAction.gif")
							.createImage();
					JFaceResources.getImageRegistry().put("CheckAction", image);
				}
			} else if (action instanceof WaitAction) {
				image = JFaceResources.getImageRegistry().get("WaitAction");
				if (image == null) {
					image = Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "icons/WaitAction.gif")
							.createImage();
					JFaceResources.getImageRegistry().put("WaitAction", image);
				}
			} else if (action instanceof DiagnosticService) {
				image = JFaceResources.getImageRegistry().get("Diagnostic");
				if (image == null) {
					image = Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "icons/diagnostick16.png")
							.createImage();
					JFaceResources.getImageRegistry().put("Diagnostic", image);
				}
			}

		default:
		}
		return image;
	}

	@Override
	public String getColumnText(Object element, int columnIndex) {

		TestStep action = (TestStep) element;
		switch (columnIndex) {
		case 0:
			
			if (action instanceof SetAction) {
				/*if (action.getValueTo() !=null) {
					return "CHECK ";
				}*/
				return "SET ";
			} else if (action instanceof CheckAction) {
				return "CHECK ";
			} else if (action instanceof WaitAction) {
				return "WAIT ";
			} else if (action instanceof DiagnosticService) {
				return "DIAGNOSTIC ";
			}
		case 1:
			if (action instanceof SetAction) {
				SetAction setAction = (SetAction) action;
				if (setAction.getKey() == null) {
					return "";
				}
				// if(setAction.getKey().getName()!="") {
				return setAction.getKey().getName();
				// return setAction.getTitle();
				// }
			} else if (action instanceof CheckAction) {
				CheckAction checkAction = (CheckAction) action;
				return checkAction.getKey().getName();

			} else if (action instanceof WaitAction) {

				WaitAction waitAction = (WaitAction) action;
				if (waitAction.getKey() == null) {
					return "";
				}

				// if(waitAction.getKey().getName()!=null ||waitAction.getTitle()!=null) {
				// System.out.println(waitAction.getKey().getName());
				String waitData = waitAction.getKey().getName();
				String[] splited = waitData.split("\\s+");
				return splited[1];
				// }

				// return "ms";///waitAction.getKey().getName() ;
			} else if (action instanceof DiagnosticService) {
				DiagnosticService diagnosticService = (DiagnosticService) action;
				return diagnosticService.getResult();
			}
		case 2:
			if (action instanceof SetAction) {
				return "=";
			} else if (action instanceof CheckAction) {
				CheckAction checkAction = (CheckAction) action;
				return checkAction.getOperator().getLiteral();
			} else if (action instanceof WaitAction) {
				WaitAction waitAction = (WaitAction) action;
				return "=";
			} else if (action instanceof DiagnosticService) {
				DiagnosticService diagnosticService = (DiagnosticService) action;
				return diagnosticService.getEcu();
			}
		case 3:
			if (action instanceof SetAction) {
				SetAction setAction = (SetAction) action;
				if (setAction.getValueTo() !=null && !setAction.getValueTo().isEmpty()) {

					return setAction.getValue() + ":" + setAction.getValueTo();
				} else {
					if(setAction.getValue()!=null)
					return setAction.getValue().trim();
				}
			} else if (action instanceof CheckAction) {
				CheckAction checkAction = (CheckAction) action;
				if (checkAction.getValueTo() != null && !checkAction.getValueTo().isEmpty()) {
					return checkAction.getValue() + ":" + checkAction.getValueTo();
				} else {
					return checkAction.getValue().trim();
				}
			} else if (action instanceof WaitAction) {

				WaitAction waitAction = (WaitAction) action;
				if (waitAction.getKey() == null) {
					return "";
				}

				String data = waitAction.getKey().getName();
				String[] splited = data.split("\\s+");
				return splited[0];// waitAction.getKey().getName() ;
			} else if (action instanceof DiagnosticService) {
				DiagnosticService diagnosticService = (DiagnosticService) action;
				return diagnosticService.getService();
			}
		default:
			break;
		}
		return null;
	}
}
