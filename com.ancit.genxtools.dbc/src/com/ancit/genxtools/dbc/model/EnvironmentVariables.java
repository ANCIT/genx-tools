package com.ancit.genxtools.dbc.model;

import java.util.ArrayList;
import java.util.List;

public class EnvironmentVariables {

	private String name;
	List<EnvironmentVariable> EnvirementVariable;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<EnvironmentVariable> getEnvirementVariable() {
		if (EnvirementVariable == null) {
			EnvirementVariable = new ArrayList<EnvironmentVariable>();
		}
		return this.EnvirementVariable;
	}

	public void setEnvirementVariable(List<EnvironmentVariable> envirementVariable) {
		EnvirementVariable = envirementVariable;
	}
}
