package com.ancit.ecusimx.simulation.model;

import java.io.Serializable;

import com.ancit.genxtools.dbc.model.Message;

public class MessageRowData extends CanMessage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String data;
	private Message message;
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
	public Message getMessage() {
		return message;
	}

	public void setMessage(Message messageID) {
		this.message = messageID;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getData() {
		return data;
	}

	public float getCycleTime() {
		return cycleTime;
	}

	public void setCycleTime(float cycleTime) {
		this.cycleTime = cycleTime;
	}

	public float getSleepTime() {
		return sleepTime;
	}

	public void setSleepTime(float sleepTime) {
		this.sleepTime = sleepTime;
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

}
