package view.employee;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class QuantityView extends JFrame {

	private JPanel contentPane;
	private JTextField field_number;
	private JButton btn_sub;
	private JButton btn_add;
	private JButton btn_ok;
	private JButton btn_exit;
	private JLabel label_nameFood;
	private JComboBox comboBox_topping;

	/**
	 * Create the frame.
	 */
	public QuantityView() {
		setUndecorated(true);
		setAlwaysOnTop(true);
		setTitle("Số lượng");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 423, 329);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btn_add = new JButton("Thêm");
		btn_add.setBounds(322, 78, 69, 101);
		btn_add.setFont(new Font("Arial", Font.PLAIN, 14));
		contentPane.add(btn_add);

		btn_sub = new JButton("Giảm");
		btn_sub.setBounds(93, 78, 65, 101);
		btn_sub.setFont(new Font("Arial", Font.PLAIN, 14));
		contentPane.add(btn_sub);

		field_number = new JTextField();
		field_number.setBounds(168, 78, 133, 101);
		field_number.setText("0");
		field_number.setHorizontalAlignment(SwingConstants.CENTER);
		field_number.setFont(new Font("Arial", Font.PLAIN, 29));
		contentPane.add(field_number);
		
		btn_ok = new JButton("Chọn");
		btn_ok.setBounds(80, 273, 100, 45);
		contentPane.add(btn_ok);
		btn_ok.setFont(new Font("Arial", Font.PLAIN, 16));
		
		btn_exit = new JButton("Hủy");
		btn_exit.setBounds(234, 273, 109, 45);
		contentPane.add(btn_exit);
		btn_exit.setFont(new Font("Arial", Font.PLAIN, 16));
		
		label_nameFood = new JLabel("New label");
		label_nameFood.setHorizontalAlignment(SwingConstants.CENTER);
		label_nameFood.setFont(new Font("Arial", Font.PLAIN, 16));
		label_nameFood.setBounds(94, 11, 283, 58);
		contentPane.add(label_nameFood);
		
		JLabel label_topping = new JLabel("Topping:");
		label_topping.setFont(new Font("Arial", Font.PLAIN, 16));
		label_topping.setBounds(10, 192, 81, 58);
		contentPane.add(label_topping);
		
		comboBox_topping = new JComboBox();
		comboBox_topping.setFont(new Font("Arial", Font.PLAIN, 16));
		comboBox_topping.setBounds(93, 190, 298, 63);
		contentPane.add(comboBox_topping);
		
		JLabel label_quantity = new JLabel("Số lượng:");
		label_quantity.setFont(new Font("Arial", Font.PLAIN, 16));
		label_quantity.setBounds(10, 100, 81, 58);
		contentPane.add(label_quantity);
		
		JLabel label_name = new JLabel("Tên món:");
		label_name.setFont(new Font("Arial", Font.PLAIN, 16));
		label_name.setBounds(10, 11, 81, 58);
		contentPane.add(label_name);
	}

	public JLabel getLabel_nameFood() {
		return label_nameFood;
	}

	public void setLabel_nameFood(JLabel label_nameFood) {
		this.label_nameFood = label_nameFood;
	}

	public JComboBox getComboBox_topping() {
		return comboBox_topping;
	}

	public void setComboBox_topping(JComboBox comboBox_topping) {
		this.comboBox_topping = comboBox_topping;
	}

	public JButton getBtn_ok() {
		return btn_ok;
	}

	public void setBtn_ok(JButton btn_ok) {
		this.btn_ok = btn_ok;
	}

	public JButton getBtn_sub() {
		return btn_sub;
	}

	public JButton getBtn_exit() {
		return btn_exit;
	}

	public void setBtn_exit(JButton btn_exit) {
		this.btn_exit = btn_exit;
	}

	public void setBtn_sub(JButton btn_sub) {
		this.btn_sub = btn_sub;
	}

	public JButton getBtn_add() {
		return btn_add;
	}

	public void setBtn_add(JButton btn_add) {
		this.btn_add = btn_add;
	}

	public JTextField getField_number() {
		return field_number;
	}

	public void setField_number(JTextField field_number) {
		this.field_number = field_number;
	}
}
