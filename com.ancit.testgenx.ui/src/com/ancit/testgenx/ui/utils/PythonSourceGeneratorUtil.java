package com.ancit.testgenx.ui.utils;

import org.eclipse.emf.common.util.EList;

import DiagonosticModel.CheckAction;
import DiagonosticModel.SetAction;
import DiagonosticModel.TestCase;
import DiagonosticModel.TestStep;

public class PythonSourceGeneratorUtil {

	public String generatePython(TestCase testCase) {

		StringBuffer pyTesterContent = new StringBuffer();
		pyTesterContent.append("import os");
		pyTesterContent.append("\n");
		pyTesterContent.append("import cantools");
		pyTesterContent.append("\n");
		pyTesterContent.append("import can");
		pyTesterContent.append("\n");

		pyTesterContent.append("DBC_PATH = 'comfort.dbc'" + "\n");

		pyTesterContent.append("can.rc['interface'] = 'socketcan'" + "\n");
		pyTesterContent.append("can.rc['channel'] = 'vcan0'" + "\n");

		pyTesterContent.append("can_bus = can.interface.Bus()" + "\n");
		pyTesterContent.append("database = cantools.db.load_file(DBC_PATH)" + "\n");
		pyTesterContent.append("tester = cantools.tester.Tester('Motor',database,can_bus,'MainBus')" + "\n");

		pyTesterContent.append("tester.start()" + "\n");

		// EList<TestGroup> testGroups = testSpecification.getTestGroups();
		// for (TestGroup testGroup : testGroups) {

		// pyTesterContent.append("# Test Group " + testGroup.getName() + "\n");
		// pyTesterContent.append("# " + testGroup.getDescription() + "\n");
		//
		// EList<TestCase> testCases = testGroup.getTestCases();

		// for (TestCase testCase : testCases) {
		// TestCase testCase =
		pyTesterContent.append("# Test Case :" + testCase.getId() + " >> " + testCase.getName() + "\n");
		pyTesterContent.append("# " + testCase.getDescription() + "\n");

		EList<TestStep> testSteps = testCase.getPreConditions();

		pyTesterContent.append("# Pre Condition Block");

		generateTesterScript(pyTesterContent, testSteps);

		pyTesterContent.append("# Action Block");

		testSteps = testCase.getTestSteps();

		generateTesterScript(pyTesterContent, testSteps);

		pyTesterContent.append("# Post Condition Block");

		testSteps = testCase.getPostConditions();

		generateTesterScript(pyTesterContent, testSteps);
		// }

		// }

		return pyTesterContent.toString();

	}

	private void generateTesterScript(StringBuffer pyTesterContent, EList<TestStep> testSteps) {
		for (TestStep testStep : testSteps) {
			if (testStep instanceof SetAction) {
				SetAction setAction = (SetAction) testStep;
				String msgName = "'" + setAction.getKey().getMessageName() + "'";
				String signalName = "'" + setAction.getKey().getName() + "'";
				String signalValue = setAction.getValue();
				pyTesterContent.append("\ntester.send(" + msgName + ", {" + signalName + ": " + signalValue + "})");

			} else if (testStep instanceof CheckAction) {
				CheckAction checkAction = (CheckAction) testStep;
				String msgName = "'" + checkAction.getKey().getMessageName() + "'";
				String signalName = "'" + checkAction.getKey().getName() + "'";
				String signalValue = checkAction.getValue();

				pyTesterContent.append(
						"\nstatus = tester.expect(" + msgName + ", {" + signalName + ": " + signalValue + "})" + "\n");

			}
		}
	}

}
