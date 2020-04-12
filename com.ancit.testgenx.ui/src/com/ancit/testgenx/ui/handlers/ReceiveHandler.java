package com.ancit.testgenx.ui.handlers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.MessageConsole;
import org.eclipse.ui.console.MessageConsoleStream;

import com.ancit.testgenx.ui.utils.CommonUtils;

public class ReceiveHandler extends AbstractHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		// TODO Auto-generated method stub

		// =============================================================
		File tmpPython = new File(CommonUtils.generateTempFolder() + File.separator + "tmpPython.py");
		if (tmpPython.exists()) {
			tmpPython.delete();
		}

		try {
			BufferedWriter bwr = new BufferedWriter(new FileWriter(new File(tmpPython.getAbsolutePath())));
			System.out.println(getPythoncode());
			bwr.write(getPythoncode());
			// flush the stream
			bwr.flush();

			// close the stream
			bwr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		ProcessBuilder processBuilder = new ProcessBuilder();

		processBuilder.command("cmd.exe", "/c", tmpPython.getAbsolutePath());

		try {

			Process process = processBuilder.start();

			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			BufferedReader errorReader = new BufferedReader(new InputStreamReader(process.getErrorStream()));

			String line;
			MessageConsole myConsole = findConsole("DBCViewer Console");
			MessageConsoleStream out = myConsole.newMessageStream();
			while ((line = reader.readLine()) != null) {

				out.println(line);
			}

			while ((line = errorReader.readLine()) != null) {

				out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	private MessageConsole findConsole(String name) {
		ConsolePlugin plugin = ConsolePlugin.getDefault();
		IConsoleManager conMan = plugin.getConsoleManager();
		IConsole[] existing = conMan.getConsoles();
		for (int i = 0; i < existing.length; i++)
			if (name.equals(existing[i].getName()))
				return (MessageConsole) existing[i];
		// no console found, so create a new one
		MessageConsole myConsole = new MessageConsole(name, null);
		conMan.addConsoles(new IConsole[] { myConsole });
		return myConsole;
	}

	private String getPythoncode() {
		StringBuffer sb = new StringBuffer();

		sb.append("\n");
		sb.append("import can");
		sb.append("\n");
		sb.append("from can.bus import BusState");
		sb.append("\n");
		sb.append("def receive_all():");
		sb.append("\n\twith can.interface.Bus(bustype=\"pcan\", channel=\"PCAN_USBBUS1\", bitrate=250000" + ") as bus:");
		sb.append("\n\t\tbus.state = BusState.PASSIVE");
		sb.append("\n\t\ttry:");
		sb.append("\n\t\t\twhile True:");
		sb.append("\n\t\t\t\tmsg = bus.recv(1)");
		sb.append("\n\t\t\t\tif msg is not None:");
		sb.append("\n\t\t\t\t\tprint(msg)");
		sb.append("\n\t\texcept KeyboardInterrupt:");
		sb.append("\n\t\t\tpass  # exit normally");
		sb.append("\n");
		sb.append("\nif __name__ == \"__main__\":");
		sb.append("\n\treceive_all()");
		return sb.toString();
	}
}
