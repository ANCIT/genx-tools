package com.ancit.testgenx.ui.utils;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;

import DiagonosticModel.CheckAction;
import DiagonosticModel.ForLoop;
import DiagonosticModel.SetAction;
import DiagonosticModel.SignalTypeEnum;
import DiagonosticModel.TestCase;
import DiagonosticModel.TestStep;
import DiagonosticModel.WaitAction;
import DiagonosticModel.WhileLoop;

public class CAPLSourceGeneratorUtil {
	
	public String generateCAPL(TestCase testCase) {
		StringBuffer caplContent = new StringBuffer();
		
		caplContent.append("//TestCase ID"+testCase.getId()+"\n");
		caplContent.append("//TestCase Description"+testCase.getDescription()+"\n");
		caplContent.append("testfunction TF_"+testCase.getName().replace(" ", "_")+"()"+"\n");
		caplContent.append("{"+"\n");
		
		ArrayList<TestStep> allTestSteps = new ArrayList<TestStep>();
		allTestSteps.addAll(testCase.getPreConditions());
		allTestSteps.addAll(testCase.getTestSteps());
		allTestSteps.addAll(testCase.getPostConditions());
		
		caplContent.append("//PreCondition Block"+"\n");
		generateCaplFromTestSteps(caplContent, testCase.getPreConditions());
		caplContent.append("//Action Block"+"\n");
		generateCaplFromTestSteps(caplContent, testCase.getTestSteps());
		caplContent.append("//PostCondition Block"+"\n");
		generateCaplFromTestSteps(caplContent, testCase.getPostConditions());
		
		caplContent.append("}"+"\n");		
		return caplContent.toString();
	}

	private void generateCaplFromTestSteps(StringBuffer caplContent, List<TestStep> testSteps) {
		for (TestStep testStep : testSteps) {
			if (testStep instanceof SetAction) {
				SetAction setAction = (SetAction) testStep;
				caplContent.append("\n\t"+generateSetCaplCode(setAction));
			} else if (testStep instanceof WaitAction) {
				WaitAction waitAction = (WaitAction) testStep;
				caplContent.append("\n\t"+generateWaitCaplCode(waitAction));
			} else if (testStep instanceof CheckAction) {
				CheckAction checkAction = (CheckAction) testStep;
				caplContent.append("\n\t"+generateCheckCaplCode(checkAction));
			}else if (testStep instanceof WhileLoop ) {

				WhileLoop whileLoop = (WhileLoop) testStep;
				caplContent.append("\twhile(true){\n\t");
				
				EList<TestStep> testSteps2 = whileLoop.getTestSteps();
				generateCaplFromTestSteps(caplContent, testSteps2);

				caplContent.append("\t}\n");
			
			}else if (testStep instanceof ForLoop ) {


				ForLoop forLoop = (ForLoop) testStep;
				
				caplContent.append("\tfor(int "+forLoop.getLoopVar()+" ="+forLoop.getStartValue()+"; "+forLoop.getLoopVar()+"  < "+forLoop.getStopValue()+";"+forLoop.getLoopVar()+"++){\n\t");
				
				EList<TestStep> testSteps2 = forLoop.getTestSteps();
				generateCaplFromTestSteps(caplContent, testSteps2);

				caplContent.append("\t}\n");
			
			
			}
		}
	}
	
	public String generateSetCaplCode(SetAction setAction) {
		StringBuffer setCaplCodeContent = new StringBuffer();
		setCaplCodeContent.append("\tsetSignal(");
		setCaplCodeContent.append(setAction.getKey().getName());
		setCaplCodeContent.append(",");
		setCaplCodeContent.append( setAction.getValue());
		setCaplCodeContent.append(");");
		setCaplCodeContent.append("\n");
		return setCaplCodeContent.toString();
	}
	
	public String generateWaitCaplCode(WaitAction waitAction) {
		StringBuffer waitCaplCodeContent = new StringBuffer();
		waitCaplCodeContent.append("result = TestWaitForTimeout(");
		waitCaplCodeContent.append(waitAction.getWait());
		waitCaplCodeContent.append(");"+"\n");
		waitCaplCodeContent.append("\tif (result == 0)"+"\n"+"\t{"+"\n");
		waitCaplCodeContent.append("\t\tTestStepFail(\"Timeout occured\");"+"\n");
		waitCaplCodeContent.append("\t}"+"\n");
		return waitCaplCodeContent.toString();
	}
	
	public String generateCheckCaplCode(CheckAction checkAction) {
		StringBuffer checkCaplCodeContent = new StringBuffer();
		checkCaplCodeContent.append("result = CheckSignalMatch(");
		if(checkAction.getKey().getType().equals(SignalTypeEnum.SIGNAL)) {
		checkCaplCodeContent.append(checkAction.getKey().getNode()+"::");
		}
		checkCaplCodeContent.append(checkAction.getKey().getName());
		checkCaplCodeContent.append(",");
		checkCaplCodeContent.append(checkAction.getValue());
		checkCaplCodeContent.append(");"+"\n");
		checkCaplCodeContent.append("\tif (result == 1)"+"\n"+"\t{");
		checkCaplCodeContent.append("\t\tTestStepFail(\"Value of signal matches not the value\");"+"\n");
		checkCaplCodeContent.append("\t}"+"\n");
		
		return checkCaplCodeContent.toString();
	}

}
