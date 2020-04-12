package com.ancit.testgenx.ui.dialogs;

import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;

import DiagonosticModel.ImportArtifact;

public class TestImportsLabelProvider extends LabelProvider implements ITableLabelProvider {

	@Override
	public Image getColumnImage(Object element, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getColumnText(Object element, int columnIndex) {
		// TODO Auto-generated method stub


			String string = ((ImportArtifact) element).getPath();
			String extension = "USERDEFINED";
			if(!string.equals("USERDEFINED")) {
				extension = string.substring(string.lastIndexOf("."), string.length());
			}

			switch (columnIndex) {
			case 0:
				return extension;
			case 1:

				return string;

			}
		
		return null;
	}

}
