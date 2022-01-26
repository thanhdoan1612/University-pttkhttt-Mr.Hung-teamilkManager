package utils;

import java.awt.Dimension;
import java.awt.Toolkit;

public class WindowUtil {
	final static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	public final static double WIDTH = screenSize.getWidth();
//	public final static double WIDTH = 1366;
	public final static double HEIGHT = screenSize.getHeight();
//	public final static double HEIGHT = 768;
}
