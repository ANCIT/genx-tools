package com.ancit.ecusimx.simulation.view;

import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.TreeItem;

import com.ancit.ecusimx.simulation.editor.CANSimulationEditor;
import com.ancit.ecusimx.simulation.model.MessageData;
import com.ancit.ecusimx.simulation.model.MessageRowData;
import com.ancit.ecusimx.simulation.model.SignalData;
import com.ancit.ecusimx.simulation.util.CommonUtils;

public class EditingSupportForMessageInfoTreeViewer {

	public EditingSupportForMessageInfoTreeViewer() {
		// TODO Auto-generated constructor stub
	}

	public static void enableEditingForDataColumn(TreeViewer treeViewer, CANSimulationEditor editor) {
		// You have to create identifier for tree columns
		treeViewer.setColumnProperties(new String[] { "Signal Name", "Startbit", "Length [Bit]", "Data", "Cycle",
				"Sleep", "On Message", "On Key" });
		treeViewer.setCellModifier(new ICellModifier() {

			@Override
			public void modify(Object element, String property, Object value) {
				if (property.equalsIgnoreCase("data")) {
					if (element instanceof TreeItem) {
						// update element and tree model
						TreeItem treeItem = (TreeItem) element;
						Object data = treeItem.getData();
						if (data instanceof SignalData) {
							SignalData signalData = (SignalData) data;
							signalData.setData(value.toString());
							editor.setDirty(true);
						} else if (data instanceof MessageRowData) {
							MessageRowData signalData = (MessageRowData) data;
							signalData.setData(value.toString());
							editor.setDirty(true);
						}
					}
				} else if (property.equalsIgnoreCase("cycle")) {
					if (element instanceof TreeItem) {
						// update element and tree model
						TreeItem treeItem = (TreeItem) element;
						Object data = treeItem.getData();
						if (data instanceof MessageData) {
							MessageData messageData = (MessageData) data;
							if (null != value.toString() && !value.toString().trim().isEmpty()) {
								if (CommonUtils.isNumeric(value.toString())) {
									messageData.setCycleTime(Float.parseFloat(value.toString()));
								}
							}else {
								messageData.setCycleTime(0);
							}
							editor.setDirty(true);
						} else if (data instanceof MessageRowData) {
							MessageRowData messageData = (MessageRowData) data;
							if (null != value.toString() && !value.toString().trim().isEmpty()) {
								if (CommonUtils.isNumeric(value.toString())) {
									messageData.setCycleTime(Float.parseFloat(value.toString()));
								}
							}else {
								messageData.setCycleTime(0);
							}
							editor.setDirty(true);
						}

					}
				} else if (property.equalsIgnoreCase("sleep")) {
					if (element instanceof TreeItem) {
						// update element and tree model
						TreeItem treeItem = (TreeItem) element;
						Object data = treeItem.getData();
						if (data instanceof MessageData) {
							MessageData messageData = (MessageData) data;
							if (null != value.toString() && !value.toString().trim().isEmpty()) {
								messageData.setSleepTime(Float.parseFloat(value.toString()));
								
							}else {
								messageData.setSleepTime(0);
							}
							editor.setDirty(true);
						} else if (data instanceof MessageRowData) {
							MessageRowData messageData = (MessageRowData) data;
							if (null != value.toString() && !value.toString().trim().isEmpty()) {
								messageData.setSleepTime(Float.parseFloat(value.toString()));
								
							}else {
								messageData.setSleepTime(0);
							}
							editor.setDirty(true);
						}

					}
				} else if (property.equalsIgnoreCase("On Message")) {
					if (element instanceof TreeItem) {
						// update element and tree model
						TreeItem treeItem = (TreeItem) element;
						Object data = treeItem.getData();
						if (data instanceof MessageData) {
							MessageData messageData = (MessageData) data;
							if (null != value.toString() && !value.toString().trim().isEmpty()) {
								messageData.setOnMessage(value.toString());
							}else {
								messageData.setOnMessage("");								
							}
							editor.setDirty(true);
						} else if (data instanceof MessageRowData) {
							MessageRowData messageData = (MessageRowData) data;
							if (null != value.toString() && !value.toString().trim().isEmpty()) {
								messageData.setOnMessage(value.toString());
								
							}else {
								messageData.setOnMessage("");
							}
							editor.setDirty(true);
						}

					}
				} else if (property.equalsIgnoreCase("On Key")) {
					if (element instanceof TreeItem) {
						// update element and tree model
						TreeItem treeItem = (TreeItem) element;
						Object data = treeItem.getData();
						if (data instanceof MessageData) {
							MessageData messageData = (MessageData) data;
							if (null != value.toString() && !value.toString().trim().isEmpty()) {
								messageData.setOnKey(value.toString());
							} else {
								messageData.setOnKey("");
							}
							editor.setDirty(true);
						} else if (data instanceof MessageRowData) {
							MessageRowData messageData = (MessageRowData) data;
							if (null != value.toString() && !value.toString().trim().isEmpty()) {
								messageData.setOnKey(value.toString());
							}else {
								messageData.setOnKey("");								
							}
							editor.setDirty(true);
						}

					}
				}
				treeViewer.refresh();
			}

			@Override
			public Object getValue(Object element, String property) {
				if (property.equalsIgnoreCase("data")) {
					if (element instanceof SignalData) {
						SignalData messageData = (SignalData) element;
						return messageData.getData();
					} else if (element instanceof MessageRowData) {
						MessageRowData messageData = (MessageRowData) element;
						return messageData.getData();
					} 
				} else if (property.equalsIgnoreCase("cycle")) {

					if (element instanceof MessageData) {
						MessageData messageData = (MessageData) element;
						return Float.toString(messageData.getCycleTime());
					} else if (element instanceof MessageRowData) {
						MessageRowData messageData = (MessageRowData) element;
						return Float.toString(messageData.getCycleTime());
					}

				} else if (property.equalsIgnoreCase("sleep")) {
					if (element instanceof MessageData) {
						MessageData messageData = (MessageData) element;
						return Float.toString(messageData.getSleepTime());
					} else if (element instanceof MessageRowData) {
						MessageRowData messageData = (MessageRowData) element;
						return Float.toString(messageData.getSleepTime());
					}

				} else if (property.equalsIgnoreCase("On Message")) {
					if (element instanceof MessageData) {
						MessageData messageData = (MessageData) element;
						return messageData.getOnMessage();
					} else if (element instanceof MessageRowData) {
						MessageRowData messageData = (MessageRowData) element;
						return messageData.getOnMessage();
					}
				} else if (property.equalsIgnoreCase("On Key")) {
					if (element instanceof MessageData) {
						MessageData messageData = (MessageData) element;
						return messageData.getOnKey();
					} else if (element instanceof MessageRowData) {
						MessageRowData messageData = (MessageRowData) element;
						return messageData.getOnKey();
					}
				}
				return null;

			}

			@Override
			public boolean canModify(Object element, String property) {

				if ((element instanceof SignalData || element instanceof MessageRowData ) && property.equalsIgnoreCase("data")) {
					return true;
				}
				if (element instanceof MessageData
						|| element instanceof MessageRowData && property.equalsIgnoreCase("cycle")) {
					return true;
				}
				if ((element instanceof MessageData || element instanceof MessageRowData)
						&& property.equalsIgnoreCase("sleep")) {
					return true;
				}
				if ((element instanceof MessageData || element instanceof MessageRowData)
						&& property.equalsIgnoreCase("On Message")) {
					return true;
				}
				if ((element instanceof MessageData || element instanceof MessageRowData)
						&& property.equalsIgnoreCase("On Key")) {
					return true;
				}
				return false;
			}
		});

	}
}
