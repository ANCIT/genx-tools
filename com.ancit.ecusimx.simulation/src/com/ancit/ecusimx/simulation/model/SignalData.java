package com.ancit.ecusimx.simulation.model;

import java.io.Serializable;

import com.ancit.genxtools.dbc.model.Signal;

public class SignalData implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String data;
	Signal signal;
	
	public void setSignal(Signal signal) {
		this.signal = signal;
	}
	
	public Signal getSignal() {
		return signal;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	public String getData() {
		return data;
	}

}
