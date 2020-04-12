package com.ancit.testgenx.ui.provider;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jface.viewers.ITreeContentProvider;

import DiagonosticModel.CAPLTestStep;
import DiagonosticModel.DiagnosticService;
import DiagonosticModel.ForLoop;
import DiagonosticModel.WhileLoop;

public class TestStepContentProvider implements ITreeContentProvider {

	@Override
	public Object[] getElements(Object inputElement) {
		// TODO Auto-generated method stub
		return getChildren(inputElement);
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof List)
			return ((List<?>) parentElement).toArray();
		if (parentElement instanceof CAPLTestStep)
			return ((CAPLTestStep) parentElement).getParameters().toArray();
		if (parentElement instanceof WhileLoop)
			return ((WhileLoop) parentElement).getTestSteps().toArray();
		if (parentElement instanceof ForLoop)
			return ((ForLoop) parentElement).getTestSteps().toArray();
		if (parentElement instanceof DiagnosticService) {
			ArrayList<Object> arrayList = new ArrayList<Object>();
			arrayList.add(((DiagnosticService) parentElement).getDiagrequest());
			arrayList.add(((DiagnosticService) parentElement).getDiagresponse());
			return arrayList.toArray();
			}


		return null;
	}

	@Override
	public Object getParent(Object element) {
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		if (element instanceof List)
			return ((List<?>) element).size() > 0;
		if (element instanceof CAPLTestStep)
			return ((CAPLTestStep) element).getParameters().size() > 0;
		if (element instanceof WhileLoop)
			return ((WhileLoop) element).getTestSteps().size() > 0;
		if (element instanceof ForLoop)
			return ((ForLoop) element).getTestSteps().size() > 0;
		if (element instanceof DiagnosticService)
				return true;
			
		return false;
	}

}
