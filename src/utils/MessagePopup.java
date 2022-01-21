package utils;

import javax.swing.JOptionPane;

public class MessagePopup {
	public static boolean showExitWarning() {
		int value =JOptionPane.showConfirmDialog(null, "Bạn muốn thoát thật chứ?","Nhắc nhở", JOptionPane.YES_NO_OPTION,JOptionPane.WARNING_MESSAGE);
		if(value == JOptionPane.YES_OPTION) return true;
		return false;
		
	}
	public static void showMessage(String message) {
		JOptionPane.showMessageDialog(null, message, "Thông Báo", JOptionPane.OK_OPTION);
	}
	public static void showSuccessMessage(String message) {
		JOptionPane.showMessageDialog(null, message, "Thông Báo",JOptionPane.INFORMATION_MESSAGE);
	}
}
