package com.ancit.testgenx.ui.zest;

import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.zest.core.viewers.EntityConnectionData;

import com.ancit.testgenx.ui.utils.Activator;

import DiagonosticModel.CAPLTestStep;
import DiagonosticModel.CheckAction;
import DiagonosticModel.DiagnosticService;
import DiagonosticModel.ForLoop;
import DiagonosticModel.SetAction;
import DiagonosticModel.SignalType;
import DiagonosticModel.TestStep;
import DiagonosticModel.WaitAction;
import DiagonosticModel.WhileLoop;

public class ZestLabelProvider extends LabelProvider {
	@Override
	public String getText(Object element) {

		if (element instanceof TestStep) {
			TestStep action = (TestStep) element; 
			if (action instanceof SetAction) {
				SetAction setAction = (SetAction) action;
				return "SET " + setAction.getKey().getName() + "=" + setAction.getValue();
			} else if (action instanceof CheckAction) {
				CheckAction checkAction = (CheckAction) action;
				return "CHECK " + checkAction.getKey().getName() + checkAction.getOperator().getLiteral()
						+ checkAction.getValue();
			} else if (action instanceof WaitAction) {
				WaitAction waitAction = (WaitAction) action; 
				return "WAIT for " + waitAction.getTitle();
			} else if (action instanceof DiagnosticService) {
				DiagnosticService diagnosticService = (DiagnosticService) action;
				return "DIAGNOSTIC " + diagnosticService.getService() + "=" + diagnosticService.getResult();
			} else if (action instanceof CAPLTestStep) {
				CAPLTestStep caplTestStep = (CAPLTestStep) action;
				return "CAPLTESTSTEP " + caplTestStep.getTitle();
			} 
			//
			else if (action instanceof ForLoop) {
				ForLoop forLoop = (ForLoop) action;
				return "FORLOOP " + forLoop.getTitle();
			}
			//
			else if (action instanceof WhileLoop) {
				WhileLoop whileLoop = (WhileLoop) action;
				return "WHILELOOP " + whileLoop.getTitle();
			}
			return ((SignalType) action.getKey()).getName();
		} else if (element instanceof EntityConnectionData) {
			return "";
		}
		return "";
	}

	@Override
	public Image getImage(Object element) {
		Image image = null;
		if (element instanceof SetAction) {
			image = JFaceResources.getImageRegistry().get("SetAction");
			if (image == null) {
				image = Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "icons/SetAction.gif").createImage();
				JFaceResources.getImageRegistry().put("SetAction", image);
			}
		} else if (element instanceof CheckAction) {
			image = JFaceResources.getImageRegistry().get("CheckAction");
			if (image == null) {
				image = Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "icons/CheckAction.gif").createImage();
				JFaceResources.getImageRegistry().put("CheckAction", image);
			}
		} else if (element instanceof WaitAction) {
			image = JFaceResources.getImageRegistry().get("WaitAction");
			if (image == null) {
				image = Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "icons/WaitAction.gif").createImage();
				JFaceResources.getImageRegistry().put("WaitAction", image);
			}
		}else if (element instanceof CAPLTestStep) {
			image = JFaceResources.getImageRegistry().get("CAPLTestStep");
			if (image == null) {
				image = Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "icons/class_obj.png").createImage();
				JFaceResources.getImageRegistry().put("CAPLTestStep", image);
			}
		} else if (element instanceof ForLoop) {
			//ForLoop obj = (ForLoop) element;
			image = JFaceResources.getImageRegistry().get("ForLoop");
			if (image == null) {
				image = Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "icons/ForLoop.png").createImage();
				JFaceResources.getImageRegistry().put("ForLoop", image);
			}
		}
		else if (element instanceof WhileLoop) {
			image = JFaceResources.getImageRegistry().get("WhileLoop");
			if (image == null) {
				image = Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "icons/WhileLoop.png").createImage();
				JFaceResources.getImageRegistry().put("WhileLoop", image);
			}
		}
		return image;
	}

}