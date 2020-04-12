package com.ancit.testgenx.ui.dnd;

import org.eclipse.emf.common.util.EList;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.jface.viewers.ViewerDropAdapter;
import org.eclipse.swt.dnd.DropTargetEvent;
import org.eclipse.swt.dnd.TransferData;

import DiagonosticModel.TestStep;

public class TestStepDropListener extends ViewerDropAdapter {

	private int location;
	private TestStep determineTarget;
	private Viewer viewer;

	public TestStepDropListener(Viewer viewer) {
		super(viewer);
		// TODO Auto-generated constructor stub
		this.viewer = viewer;
	}

	@Override
	public void drop(DropTargetEvent event) {
		location = this.determineLocation(event);
		determineTarget = (TestStep) determineTarget(event);
		super.drop(event);
	}

	@Override
	public boolean performDrop(Object data) {
		IStructuredSelection sSelection = (IStructuredSelection) viewer.getSelection();
		TestStep testStep = (TestStep) sSelection.getFirstElement();
		EList<TestStep> testSteps = (EList<TestStep>) viewer.getInput();

		testSteps.remove(testStep);
		testSteps.add(testSteps.indexOf(determineTarget) + 1, testStep);
		reassignNextStep(testSteps);
		
		viewer.refresh();
		System.out.println("");
		return true;
	}

	@Override
	public boolean validateDrop(Object target, int operation, TransferData transferType) {
		// TODO Auto-generated method stub
		return true;
	}
	
	private void reassignNextStep(EList<TestStep> testSteps) {
		for (int i = 0; i < testSteps.size(); i++) {
			TestStep testStep = testSteps.get(i);
			
			if(testSteps.size() == i+1) {
				testStep.setNextStep(null);
				continue;
			}
			testSteps.get(i).setNextStep(testSteps.get(i+1));
			
		}
	}
	

}
