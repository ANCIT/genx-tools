package com.ancit.diagnostictool.cansimulation.handler;

import java.io.IOException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.Platform;
import org.eclipse.osgi.service.datalocation.Location;

public class CANSimulationHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		Location installLocation = Platform.getInstallLocation();
		String path = installLocation.getURL().getPath() + "documents/videos/cansimulator_tutorial.mp4";
		ProcessBuilder processBuilder = new ProcessBuilder();

		if (System.getProperty("os.name").contains("Win")) {
			String fullPath = "start " + path.replace("/", "\\").substring(1);
			processBuilder.command("cmd.exe", "/c", fullPath);
		} else {
			processBuilder.command("bash", "-c", path);
		}

		try {
			processBuilder.start();
		} catch (IOException e) {
			e.printStackTrace();
			// ILog log = DataManager.getInstance().getLog();
			// log.log(new Status(IStatus.ERROR, Activator.PLUGIN_ID, e.getMessage()));
		}
		return null;
	}

}
