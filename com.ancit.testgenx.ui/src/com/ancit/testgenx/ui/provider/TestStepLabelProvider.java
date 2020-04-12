package com.ancit.testgenx.ui.provider;

import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.graphics.Image;

import com.ancit.testgenx.ui.utils.Activator;

import DiagonosticModel.CAPLParam;
import DiagonosticModel.CAPLTestStep;
import DiagonosticModel.CheckAction;
import DiagonosticModel.DiagnosticRequest;
import DiagonosticModel.DiagnosticResponse;
import DiagonosticModel.DiagnosticService;
import DiagonosticModel.ForLoop;
import DiagonosticModel.SetAction;
import DiagonosticModel.TestStep;
import DiagonosticModel.WaitAction;
import DiagonosticModel.WhileLoop;

public class TestStepLabelProvider implements ITableLabelProvider {

	@Override
	public void addListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isLabelProperty(Object element, String property) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub

	}

	@Override
	public Image getColumnImage(Object element, int columnIndex) {
		TestStep action = null;
		if (element instanceof TestStep) {
			action = (TestStep) element;
		}
		Image image = null;
		switch (columnIndex) {
		case 0:
			if (action != null) {
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
				} else if (element instanceof CAPLTestStep) {
					image = JFaceResources.getImageRegistry().get("CAPLTestStep");
					if (image == null) {
						image = Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "icons/class_obj.png")
								.createImage();
						JFaceResources.getImageRegistry().put("CAPLTestStep", image);
					}
				} else if (element instanceof ForLoop) {
					image = JFaceResources.getImageRegistry().get("ForLoop");
					if (image == null) {
						image = Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "icons/ForLoop.png")
								.createImage();
						JFaceResources.getImageRegistry().put("ForLoop", image);
					}
				} else if (element instanceof WhileLoop) {
					image = JFaceResources.getImageRegistry().get("WhileLoop");
					if (image == null) {
						image = Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "icons/WhileLoop.png")
								.createImage();
						JFaceResources.getImageRegistry().put("WhileLoop", image);
					}
				}
			}

		default:
		}
		return image;
	}

	@Override
	public String getColumnText(Object element, int columnIndex) {
		Object action = null;
		if (element instanceof TestStep) {
			action = (TestStep) element;
		}else if (element instanceof DiagnosticRequest) {
			action=element;
		}else if (element instanceof DiagnosticResponse) {
			action=element;
		}
		switch (columnIndex) {
		case 0:
			if (action != null) {
				if (action instanceof SetAction) {
					return "SET ";
				} else if (action instanceof CheckAction) {
					return "CHECK ";
				} else if (action instanceof WaitAction) {
					return "WAIT ";
				} else if (action instanceof DiagnosticService) {
					return "DIAGNOSTIC ";
				} else if (action instanceof CAPLTestStep) {
					return "CAPLTESTSTEP ";
				} else if (action instanceof ForLoop) {
					return "FORLOOP ";
				} else if (action instanceof WhileLoop) {
					return "WHILELOOP ";
				}else if (element instanceof DiagnosticRequest) {
					return "DIAGNOSTIC REQUEST";
				}
				else if (element instanceof DiagnosticResponse) {
					return "DIAGNOSTIC RESPONSE";
				}
			} else {
				return "";
			}
		case 1:
			if (element instanceof CAPLParam)
				return ((CAPLParam) element).getName();
			else if (action instanceof CAPLTestStep) {
				return ((CAPLTestStep) element).getTitle();
			} else if (action instanceof SetAction) {
				SetAction setAction = (SetAction) action;
				if (setAction.getKey() == null) {
					return "";
				}
				System.out.println("setAction.getTitle() =" + setAction.getTitle());
				System.out.println("setAction.getKey().getName(); " + setAction.getKey().getName());
				return setAction.getKey().getName();

			} else if (action instanceof CheckAction) {
				CheckAction checkAction = (CheckAction) action;
				return checkAction.getKey().getName();

			} else if (action instanceof WaitAction) {
				WaitAction waitAction = (WaitAction) action;
//				if (waitAction.getKey() == null) {
//					return "";
//				}
				String waitData = waitAction.getTitle();
				String splited = waitData.replace("ms","");
				return "";
			} else if (action instanceof DiagnosticService) {
				DiagnosticService diagnosticService = (DiagnosticService) action;
				return diagnosticService.getResult();
			} else if (action instanceof ForLoop) {
				ForLoop forLoopAction = (ForLoop) action;
				return forLoopAction.getTitle();
			} else if (action instanceof WhileLoop) {
				WhileLoop WhileLoopService = (WhileLoop) action;
				return WhileLoopService.getTitle();
			}

		case 2:
			if (element instanceof CAPLParam) {
				CAPLParam checkParam = (CAPLParam) element;
				return checkParam.getType();
			} else if (action instanceof SetAction) {
				return "=";
			} else if (action instanceof CheckAction) {
				CheckAction checkAction = (CheckAction) action;
				return checkAction.getOperator().getLiteral();
			} else if (action instanceof WaitAction) {
				return "=";
			} else if (action instanceof DiagnosticService) {
				DiagnosticService diagnosticService = (DiagnosticService) action;
				return diagnosticService.getEcu();
			}
		case 3:
			if (element instanceof CAPLParam)
				return ((CAPLParam) element).getValue();
			else if (action instanceof SetAction) {
				SetAction setAction = (SetAction) action;
				if (setAction.getValueTo() != null && !setAction.getValueTo().isEmpty()) {

					return setAction.getValue() + ":" + setAction.getValueTo();
				} else {
					if (setAction.getValue() != null)
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
//				if (waitAction.getKey() == null) {
//					return "";
//				}

				String data = waitAction.getTitle();
				String[] splited = data.split("\\s+");
				return splited[0];// waitAction.getKey().getName() ;
			} else if (action instanceof DiagnosticService) {
				DiagnosticService diagnosticService = (DiagnosticService) action;
				return diagnosticService.getService();
			}
		}
		return null;
	}

}
