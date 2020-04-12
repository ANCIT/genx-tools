package com.ancit.ecusimx.simulation.util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.ancit.ecusimx.simulation.model.CanMessage;
import com.ancit.ecusimx.simulation.model.CanSimulationBlock;
import com.ancit.ecusimx.simulation.model.MessageData;
import com.ancit.genxtools.dbc.model.Bus;
import com.ancit.genxtools.dbc.model.Message;
import com.ancit.genxtools.dbc.model.NetworkDefinition;

public class CommonUtils {
	public static String generateTempFolder(){
		File file = new File(System.getProperty("user.home") + File.separator +"TestGenx");
        if (!file.exists()) {
            if (file.mkdir()) {
            	System.out.println("Created");
            }
        }
        return file.getAbsoluteFile().toString();
	}
	
	public static boolean isNumeric(String strNum) {
	    if (strNum == null) {
	        return false;
	    }
	    try {
	        double d = Double.parseDouble(strNum);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
	
	public static List<Message> getUnusedMessages(NetworkDefinition network, CanSimulationBlock canSimulationBlock) {
		
		List<Message> usedMessages = getUsedMessages(canSimulationBlock);
		
		ArrayList<Message> allMessagesInDBC = getAllMessagesInDBC(network);
		
		List<Message> unUsedMessages = getUnusedMessages(allMessagesInDBC, usedMessages);
		
		return unUsedMessages;
	}

	public static ArrayList<Message> getAllMessagesInDBC(NetworkDefinition network) {
		ArrayList<Message> allMessagesInDBC = new ArrayList<Message>();
		if(network != null) {
			List<Bus> buses = network.getBus();
			for (Bus bus : buses) {
				allMessagesInDBC.addAll(bus.getMessage());
			}
		}
		return allMessagesInDBC;
	}
	
	private static List<Message> getUnusedMessages(ArrayList<Message> allMessagesInDBC, List<Message> usedMessages) {
		ArrayList<Message> unusedMessages = new ArrayList<Message>();
		
		for (Message message : allMessagesInDBC) {
			if(!usedMessages.contains(message)) {
				unusedMessages.add(message);
			}
		}
		
		return unusedMessages;
		
	}

	private static List<Message> getUsedMessages(CanSimulationBlock canSimulationBlock) {
		ArrayList<CanMessage> messageData = canSimulationBlock.getMessageData();
		ArrayList<Message> usedMessages = new ArrayList<Message>();
		for (CanMessage messageDatum : messageData) {
			if (messageDatum instanceof MessageData) {
				usedMessages.add(((MessageData)messageDatum).getMessage());
			}
		}
		return usedMessages;
	}
	
	
	
	

}
