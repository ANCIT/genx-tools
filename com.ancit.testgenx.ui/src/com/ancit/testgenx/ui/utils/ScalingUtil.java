package com.ancit.testgenx.ui.utils;

import org.eclipse.swt.widgets.Display;

public class ScalingUtil {
	public static final int DPI_CURRENT = Display.getDefault().getDPI().x;
	public static final float DPI_DEFAULT = 96.0f;
	public static final float DPI_SCALE = DPI_CURRENT / DPI_DEFAULT;

	public static int getDPIScale(int scale) {
		return (int) DPI_SCALE * scale;

	}

}
