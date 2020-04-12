package com.ancit.genxtools.dbc.model;

import java.util.ArrayList;
import java.util.List;

public class Nodes {
	private String name;
	private List<Node> nodelist;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Node> getNodelist() {
        if (nodelist == null) {
        	nodelist = new ArrayList<Node>();
        }
        return this.nodelist;
    }
	public void setNodelist(List<Node> nodelist) {
		this.nodelist = nodelist;
	}
}
