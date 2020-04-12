package com.ancit.ecusimx.simulation.model;

import java.io.Serializable;
import java.util.ArrayList;

public class CanSimulationBlock implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CanInterface canInterface = new CanInterface();
	private ArrayList<CanMessage> messageData = new ArrayList<CanMessage>();
	private ArrayList<MessageRowData> messageRowData = new ArrayList<MessageRowData>();

	private String dbcPath;

	public ArrayList<MessageRowData> getMessageRowData() {
		return messageRowData;
	}

	public void setMessageRowData(ArrayList<MessageRowData> messageRowData) {
		this.messageRowData = messageRowData;
	}

	public void setDbcPath(String dbcPath) {
		this.dbcPath = dbcPath;
	}

	public String getDbcPath() {
		if (dbcPath == null) {
			return "";
		}
		return dbcPath;
	}

	public ArrayList<CanMessage> getMessageData() {
		return messageData;
	}

	public void setCanInterface(CanInterface canInterface) {
		this.canInterface = canInterface;
	}

	public CanInterface getCanInterface() {
		return canInterface;
	}

}
