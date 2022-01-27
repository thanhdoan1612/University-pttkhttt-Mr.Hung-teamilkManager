package view.admin;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class AddFoodView extends JFrame {

	private JPanel contentPane;
	private JTextField field_name;
	private JTextField field_price;
	private JLabel label_category;
	private JTextField field_quanity;
	private JTextField field_unit;
	private JLabel label_name;
	private JComboBox<String> comboBox_category;
	private JButton btn_ok;
	private JButton btn_cancel;

	/**
	 * Create the frame.
	 */
	public AddFoodView() {
		setTitle("Thêm sản phẩm");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 470, 353);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 434, 303);
		contentPane.add(panel);
		panel.setLayout(null);

		field_name = new JTextField();
		field_name.setFont(new Font("Arial", Font.PLAIN, 16));
		field_name.setColumns(10);
		field_name.setBounds(131, 11, 281, 31);
		panel.add(field_name);

		label_name = new JLabel("Tên");
		label_name.setFont(new Font("Arial", Font.PLAIN, 16));
		label_name.setBounds(10, 11, 89, 31);
		panel.add(label_name);

		field_price = new JTextField();
		field_price.setFont(new Font("Arial", Font.PLAIN, 16));
		field_price.setColumns(10);
		field_price.setBounds(131, 53, 281, 31);
		panel.add(field_price);

		JLabel label_price = new JLabel("Giá");
		label_price.setFont(new Font("Arial", Font.PLAIN, 16));
		label_price.setBounds(10, 53, 89, 31);
		panel.add(label_price);

		label_category = new JLabel("Nhóm");
		label_category.setFont(new Font("Arial", Font.PLAIN, 16));
		label_category.setBounds(10, 138, 89, 31);
		panel.add(label_category);

		btn_ok = new JButton("Xác nhận");
		btn_ok.setFont(new Font("Arial", Font.PLAIN, 16));
		btn_ok.setIcon(new ImageIcon("imgs/tick.png"));
		btn_ok.setBounds(74, 222, 145, 50);
		panel.add(btn_ok);

		btn_cancel = new JButton("Hủy");
		btn_cancel.setFont(new Font("Arial", Font.PLAIN, 16));
		btn_cancel.setBounds(246, 222, 145, 50);
		btn_cancel.setIcon(new ImageIcon("imgs/exit.png"));
		panel.add(btn_cancel);

		JLabel label_quantity = new JLabel("Số lượng");
		label_quantity.setFont(new Font("Arial", Font.PLAIN, 16));
		label_quantity.setBounds(10, 180, 89, 31);
		panel.add(label_quantity);

		field_quanity = new JTextField();
		field_quanity.setFont(new Font("Arial", Font.PLAIN, 16));
		field_quanity.setColumns(10);
		field_quanity.setBounds(131, 180, 281, 31);
		panel.add(field_quanity);

		comboBox_category = new JComboBox();
		comboBox_category.setBounds(129, 138, 182, 31);
		panel.add(comboBox_category);

		field_unit = new JTextField();
		field_unit.setFont(new Font("Arial", Font.PLAIN, 16));
		field_unit.setColumns(10);
		field_unit.setBounds(131, 95, 281, 31);
		panel.add(field_unit);

		JLabel label_unit = new JLabel("Đơn vị tính");
		label_unit.setFont(new Font("Arial", Font.PLAIN, 16));
		label_unit.setBounds(10, 95, 89, 31);
		panel.add(label_unit);
	}

	public JButton getBtn_ok() {
		return btn_ok;
	}

	public void setBtn_ok(JButton btn_ok) {
		this.btn_ok = btn_ok;
	}

	public JButton getBtn_cancel() {
		return btn_cancel;
	}

	public void setBtn_cancel(JButton btn_cancel) {
		this.btn_cancel = btn_cancel;
	}

	public JComboBox<String> getComboBox_category() {
		return comboBox_category;
	}

	public void setComboBox_category(JComboBox<String> comboBox_category) {
		this.comboBox_category = comboBox_category;
	}

	public JTextField getField_unit() {
		return field_unit;
	}

	public void setField_unit(JTextField field_unit) {
		this.field_unit = field_unit;
	}

	public JTextField getField_name() {
		return field_name;
	}

	public void setField_name(JTextField field_name) {
		this.field_name = field_name;
	}

	public JTextField getField_price() {
		return field_price;
	}

	public void setField_price(JTextField field_price) {
		this.field_price = field_price;
	}

	public JTextField getField_quanity() {
		return field_quanity;
	}

	public void setField_quanity(JTextField field_quanity) {
		this.field_quanity = field_quanity;
	}
}
