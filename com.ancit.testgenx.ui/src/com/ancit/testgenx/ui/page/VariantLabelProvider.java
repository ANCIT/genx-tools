package com.ancit.testgenx.ui.page;

import org.eclipse.jface.viewers.LabelProvider;

import DiagonosticModel.Variant;

public class VariantLabelProvider extends LabelProvider {

	@Override
	public String getText(Object element) {
		if (element instanceof Variant) {
			Variant variant = (Variant) element;
			return variant.getName();
		}
		return super.getText(element);
	}

}
