package com.ancit.ecusimx.simulation.model;

import java.io.Serializable;
import java.util.ArrayList;

import com.ancit.genxtools.dbc.model.Message;

public class MessageData extends CanMessage implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Message message;
	private ArrayList<SignalData> signalData = new ArrayList<SignalData>();
	private float cycleTime;
	private float sleepTime;
	private String onMessage,onKey;
	private boolean isRowData;
	public boolean isRowData() {
		return isRowData;
	}

	public void setRowData(boolean isRowData) {
		this.isRowData = isRowData;
	}

	public String getOnMessage() {
		return onMessage;
	}

	public void setOnMessage(String onMessage) {
		this.onMessage = onMessage;
	}

	public String getOnKey() {
		return onKey;
	}

	public void setOnKey(String onKey) {
		this.onKey = onKey;
	}

	public void setMessage(Message message) {
		this.message = message;
	}
	
	public Message getMessage() {
		return message;
	}
	
	public ArrayList<SignalData> getSignalData() {
		return signalData;
	}
	
	public void setCycleTime(float cycleTime) {
		this.cycleTime = cycleTime;
	}
	
	public float getCycleTime() {
		return cycleTime;
	}

	public float getSleepTime() {
		return sleepTime;
	}

	public void setSleepTime(float sleepTime) {
		this.sleepTime = sleepTime;
	}

	

}
