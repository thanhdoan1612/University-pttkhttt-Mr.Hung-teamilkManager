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
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.Dimension;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;

public class QuantityView extends JFrame {

	private JPanel contentPane;
	private JTextField field_number;
	private JButton btn_sub;
	private JButton btn_add;
	private JButton btn_ok;
	private JButton btn_exit;
	private JLabel label_nameFood;
	private JTextField field_topping;
	private JScrollPane scrollPane_topping;
	private JPanel panel_topping;
	private JCheckBox checkBox_choose;

	/**
	 * Create the frame.
	 */
	public QuantityView() {
		setUndecorated(true);
		setAlwaysOnTop(true);
		setTitle("Số lượng");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		setBounds(100, 100, 433, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		btn_add = new JButton("+");
		btn_add.setBounds(334, 78, 81, 45);
		btn_add.setFont(new Font("Arial", Font.PLAIN, 40));
		contentPane.add(btn_add);

		btn_sub = new JButton("-");
		btn_sub.setBounds(93, 78, 65, 45);
		btn_sub.setFont(new Font("Arial", Font.PLAIN, 40));
		contentPane.add(btn_sub);

		field_number = new JTextField();
		field_number.setBounds(168, 78, 156, 45);
		field_number.setText("0");
		field_number.setHorizontalAlignment(SwingConstants.CENTER);
		field_number.setFont(new Font("Arial", Font.PLAIN, 29));
		contentPane.add(field_number);
		
		btn_ok = new JButton("Chọn");
		btn_ok.setBounds(120, 444, 100, 45);
		contentPane.add(btn_ok);
		btn_ok.setFont(new Font("Arial", Font.PLAIN, 16));
		
		btn_exit = new JButton("Hủy");
		btn_exit.setBounds(271, 444, 109, 45);
		contentPane.add(btn_exit);
		btn_exit.setFont(new Font("Arial", Font.PLAIN, 16));
		
		label_nameFood = new JLabel("New label");
		label_nameFood.setHorizontalAlignment(SwingConstants.CENTER);
		label_nameFood.setFont(new Font("Arial", Font.PLAIN, 16));
		label_nameFood.setBounds(94, 11, 321, 58);
		contentPane.add(label_nameFood);
		
		JLabel label_topping = new JLabel("Topping:");
		label_topping.setFont(new Font("Arial", Font.PLAIN, 16));
		label_topping.setBounds(10, 147, 81, 58);
		contentPane.add(label_topping);
		
		JLabel label_quantity = new JLabel("Số lượng:");
		label_quantity.setFont(new Font("Arial", Font.PLAIN, 16));
		label_quantity.setBounds(10, 78, 81, 58);
		contentPane.add(label_quantity);
		
		JLabel label_name = new JLabel("Tên món:");
		label_name.setFont(new Font("Arial", Font.PLAIN, 16));
		label_name.setBounds(10, 11, 81, 58);
		contentPane.add(label_name);
		
		scrollPane_topping = new JScrollPane();
		scrollPane_topping.setBounds(93, 160, 322, 273);
		contentPane.add(scrollPane_topping);
		
		panel_topping = new JPanel();
		scrollPane_topping.setViewportView(panel_topping);
		panel_topping.setLayout(null);
		
		field_topping = new JTextField();
		field_topping.setVisible(false);
		field_topping.setFont(new Font("Arial", Font.PLAIN, 20));
		field_topping.setBounds(0, 0, 231, 49);
		panel_topping.add(field_topping);
		field_topping.setEditable(false);
		field_topping.setColumns(10);
		
		checkBox_choose = new JCheckBox("");
		checkBox_choose.setVisible(false);
		checkBox_choose.setFont(new Font("Arial", Font.PLAIN, 20));
		checkBox_choose.setHorizontalAlignment(SwingConstants.CENTER);
		checkBox_choose.setBounds(237, 0, 71, 49);
		panel_topping.add(checkBox_choose);
	}

	public JPanel getPanel_topping() {
		return panel_topping;
	}

	public void setPanel_topping(JPanel panel_topping) {
		this.panel_topping = panel_topping;
	}

	public JScrollPane getScrollPane_topping() {
		return scrollPane_topping;
	}

	public void setScrollPane_topping(JScrollPane scrollPane_topping) {
		this.scrollPane_topping = scrollPane_topping;
	}

	public JCheckBox getCheckBox_choose() {
		return checkBox_choose;
	}

	public void setCheckBox_choose(JCheckBox checkBox_choose) {
		this.checkBox_choose = checkBox_choose;
	}

	public JTextField getField_topping() {
		return field_topping;
	}


	public void setField_topping(JTextField field_topping) {
		this.field_topping = field_topping;
	}


	public JLabel getLabel_nameFood() {
		return label_nameFood;
	}

	public void setLabel_nameFood(JLabel label_nameFood) {
		this.label_nameFood = label_nameFood;
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
