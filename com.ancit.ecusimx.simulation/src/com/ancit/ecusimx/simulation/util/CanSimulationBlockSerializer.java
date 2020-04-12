package com.ancit.ecusimx.simulation.util;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.ancit.ecusimx.simulation.model.CanSimulationBlock;

public class CanSimulationBlockSerializer {
	
	

    public static void save(CanSimulationBlock canSimulationBlock, String filePath) {

    	try {
			FileOutputStream f = new FileOutputStream(new File(filePath));
			ObjectOutputStream o = new ObjectOutputStream(f);
			
			o.writeObject(canSimulationBlock);
			
			o.close();
			f.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }

	public static CanSimulationBlock load(String filePath) {
		
		try {
			FileInputStream fi = new FileInputStream(new File(filePath));
			ObjectInputStream oi = new ObjectInputStream(fi);
			
			CanSimulationBlock canSimulationBlock = (CanSimulationBlock)oi.readObject();
			
			
			return canSimulationBlock;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}