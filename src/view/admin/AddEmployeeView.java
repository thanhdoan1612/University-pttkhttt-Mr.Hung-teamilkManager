package view.admin;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class AddEmployeeView extends JFrame {

	private JPanel contentPane;
	private JTextField field_fullname;
	private JTextField field_username;
	private JTextField field_dateOfBirth;
	private JTextField field_phoneNumber;
	private JPasswordField field_password;
	private JComboBox<String> comboBox_isAdmin;
	private JButton btn_add;
	private JButton btn_cancel;

	/**
	 * Create the frame.
	 */
	public AddEmployeeView() {
		setTitle("Thêm nhân viên");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 512, 408);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblHVTn = new JLabel("Họ và tên:");
		lblHVTn.setBounds(15, 16, 130, 37);
		lblHVTn.setFont(new Font("Arial", Font.PLAIN, 16));

		field_fullname = new JTextField();
		field_fullname.setBounds(169, 19, 270, 31);
		field_fullname.setFont(new Font("Arial", Font.PLAIN, 16));
		field_fullname.setColumns(10);

		JLabel label_username = new JLabel("Tên đăng nhập");
		label_username.setBounds(15, 65, 130, 37);
		label_username.setFont(new Font("Arial", Font.PLAIN, 16));

		field_username = new JTextField();
		field_username.setBounds(169, 68, 270, 31);
		field_username.setFont(new Font("Arial", Font.PLAIN, 16));
		field_username.setColumns(10);
		contentPane.setLayout(null);
		contentPane.add(lblHVTn);
		contentPane.add(field_fullname);
		contentPane.add(label_username);
		contentPane.add(field_username);

		JLabel label_password = new JLabel("Mật khẩu");
		label_password.setFont(new Font("Arial", Font.PLAIN, 16));
		label_password.setBounds(15, 113, 130, 37);
		contentPane.add(label_password);

		JLabel label_dateOfBirth = new JLabel("Ngày sinh");
		label_dateOfBirth.setFont(new Font("Arial", Font.PLAIN, 16));
		label_dateOfBirth.setBounds(15, 161, 130, 37);
		contentPane.add(label_dateOfBirth);

		field_dateOfBirth = new JTextField();
		field_dateOfBirth.setFont(new Font("Arial", Font.PLAIN, 16));
		field_dateOfBirth.setColumns(10);
		field_dateOfBirth.setBounds(169, 164, 270, 31);
		contentPane.add(field_dateOfBirth);

		JLabel label_phoneNumber = new JLabel("Số điện thoại");
		label_phoneNumber.setFont(new Font("Arial", Font.PLAIN, 16));
		label_phoneNumber.setBounds(15, 209, 130, 37);
		contentPane.add(label_phoneNumber);

		field_phoneNumber = new JTextField();
		field_phoneNumber.setFont(new Font("Arial", Font.PLAIN, 16));
		field_phoneNumber.setColumns(10);
		field_phoneNumber.setBounds(169, 212, 270, 31);
		contentPane.add(field_phoneNumber);

		btn_add = new JButton("Thêm");
		btn_add.setFont(new Font("Arial", Font.PLAIN, 16));
		btn_add.setBounds(84, 315, 117, 44);
		contentPane.add(btn_add);

		btn_cancel = new JButton("Hủy");
		btn_cancel.setFont(new Font("Arial", Font.PLAIN, 16));
		btn_cancel.setBounds(257, 315, 112, 44);
		contentPane.add(btn_cancel);

		JButton btn_showPass = new JButton("New button");
		btn_showPass.setBounds(449, 113, 37, 23);
		contentPane.add(btn_showPass);

		field_password = new JPasswordField();
		field_password.setFont(new Font("Arial", Font.PLAIN, 16));
		field_password.setBounds(169, 110, 270, 31);
		contentPane.add(field_password);

		JLabel label_isAdmin = new JLabel("Quyền");
		label_isAdmin.setFont(new Font("Arial", Font.PLAIN, 16));
		label_isAdmin.setBounds(15, 257, 130, 37);
		contentPane.add(label_isAdmin);

		comboBox_isAdmin = new JComboBox();
		comboBox_isAdmin.setBounds(169, 261, 166, 31);
		contentPane.add(comboBox_isAdmin);
	}

	public JButton getBtn_add() {
		return btn_add;
	}

	public void setBtn_add(JButton btn_add) {
		this.btn_add = btn_add;
	}

	public JButton getBtn_cancel() {
		return btn_cancel;
	}

	public void setBtn_cancel(JButton btn_cancel) {
		this.btn_cancel = btn_cancel;
	}

	public JComboBox<String> getComboBox_isAdmin() {
		return comboBox_isAdmin;
	}

	public void setComboBox_isAdmin(JComboBox<String> comboBox_isAdmin) {
		this.comboBox_isAdmin = comboBox_isAdmin;
	}

	public JPasswordField getField_password() {
		return field_password;
	}

	public void setField_password(JPasswordField field_password) {
		this.field_password = field_password;
	}

	public JTextField getField_fullname() {
		return field_fullname;
	}

	public void setField_fullname(JTextField field_fullname) {
		this.field_fullname = field_fullname;
	}

	public JTextField getField_username() {
		return field_username;
	}

	public void setField_username(JTextField field_username) {
		this.field_username = field_username;
	}

	public JTextField getField_dateOfBirth() {
		return field_dateOfBirth;
	}

	public void setField_dateOfBirth(JTextField field_dateOfBirth) {
		this.field_dateOfBirth = field_dateOfBirth;
	}

	public JTextField getField_phoneNumber() {
		return field_phoneNumber;
	}

	public void setField_phoneNumber(JTextField field_phoneNumber) {
		this.field_phoneNumber = field_phoneNumber;
	}
}
