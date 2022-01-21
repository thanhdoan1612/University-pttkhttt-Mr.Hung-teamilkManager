package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import utils.ErrorPopup;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;

public class LoginView extends JFrame {

	private JPanel contentPane;
	private JTextField field_username;
	private JButton btn_exit;
	private JButton btn_login;
	private JPasswordField field_password;

	/**
	 * Create the frame.
	 */
	public LoginView() {
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Đăng nhập hệ thống");
		setFont(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 433, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(141, Short.MAX_VALUE))
		);
		
		JLabel label_username = new JLabel("Tài Khoản");
		label_username.setHorizontalAlignment(SwingConstants.CENTER);
		label_username.setFont(new Font("Arial", Font.PLAIN, 16));
		
		field_username = new JTextField();
		field_username.setText("Tên Đăng Nhập");
		field_username.setColumns(10);
		
		JLabel label_password = new JLabel("Mật Khẩu");
		label_password.setHorizontalAlignment(SwingConstants.CENTER);
		label_password.setFont(new Font("Arial", Font.PLAIN, 16));
		
		btn_login = new JButton("Đăng nhập");
		btn_login.setFont(new Font("Arial", Font.PLAIN, 16));
		
		btn_exit = new JButton("Thoát");
		btn_exit.setFont(new Font("Arial", Font.PLAIN, 16));
		
		field_password = new JPasswordField();
		field_password.setToolTipText("");
		field_password.setFont(new Font("Arial", Font.PLAIN, 16));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(48)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(30)
							.addComponent(btn_login, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE)
							.addGap(39)
							.addComponent(btn_exit, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(label_username, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_password, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE))
							.addGap(39)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
								.addComponent(field_password)
								.addComponent(field_username, GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE))))
					.addContainerGap(51, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(54)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(label_username, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
						.addComponent(field_username, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addComponent(field_password)
						.addComponent(label_password, GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btn_login, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn_exit, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(61, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}



	 public JTextField getField_username() {
		return field_username;
	}

	public void setField_username(JTextField field_username) {
		this.field_username = field_username;
	}



	public JPasswordField getField_password() {
		return field_password;
	}

	public void setField_password(JPasswordField field_password) {
		this.field_password = field_password;
	}

	public JButton getBtn_login() {
		return this.btn_login;
	}

	public void setBtn_login(JButton btn_login) {
		this.btn_login = btn_login;
	}

	public JButton getBtn_exit() {
		return btn_exit;
	}

	public void setBtn_exit(JButton btn_exit) {
		this.btn_exit = btn_exit;
	}

	public void showError(String message) {
	        ErrorPopup.show(new Exception(message));
	 }
}