package com.ancit.testgenx.ui.utils;

import java.io.*;
import java.util.ArrayList;

public class CAPLFileParser {
	public static void main(String[] args) throws Exception {
		
		CAPLFileParser parser = new CAPLFileParser();
		ArrayList<String> caplFunctions = parser.getCaplFunctions("C:\\Users\\LENOVO\\Desktop\\DATA\\CAPLlib.can");
		for (String functionDetails : caplFunctions) {
			String name = functionDetails.substring(0, functionDetails.indexOf("("));
			String function = functionDetails.substring(functionDetails.indexOf("(")+1, functionDetails.indexOf(")"));
			System.out.println(name +" :: "+function);
			String[] split = function.split(",");
			for (String parameter : split) {
				String[] ParamDetails = parameter.trim().split(" ");
				if(ParamDetails[1].contains("[]")) {
					System.out.println(ParamDetails[0].replace("char", "String")+" ::: "+ParamDetails[1].replace("[]",""));
				}else {
					System.out.println(ParamDetails[0]+" ::: "+ParamDetails[1]);
				}
				
			}
			System.out.println();
		}
		
		
	}

	public ArrayList<String> getCaplFunctions(String filePath) throws FileNotFoundException, IOException {
		File file = new File(filePath);
		BufferedReader br = new BufferedReader(new FileReader(file));
		ArrayList<String> functionStorage = new ArrayList<String>();
		String st;
		while ((st = br.readLine()) != null) {
			if(st.contains("testfunction")) {
				functionStorage.add(st.replace("testfunction", "").trim());
				
			}
		}
		return functionStorage;
	}
	
	
}