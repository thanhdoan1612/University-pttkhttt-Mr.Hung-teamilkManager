package view.employee;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class QuantityView extends JFrame {

	private JPanel contentPane;
	private JTextField field_number;
	private JButton btn_sub;
	private JButton btn_add;
	private JPanel panel;
	private JButton btn_ok;
	private JButton btn_exit;

	/**
	 * Create the frame.
	 */
	public QuantityView() {
		setUndecorated(true);
		setAlwaysOnTop(true);
		setResizable(false);
		setTitle("Số lượng");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 350, 256);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 7, true));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		btn_add = new JButton("Thêm");
		btn_add.setFont(new Font("Arial", Font.PLAIN, 14));
		contentPane.add(btn_add, BorderLayout.EAST);

		btn_sub = new JButton("Giảm");
		btn_sub.setFont(new Font("Arial", Font.PLAIN, 14));
		contentPane.add(btn_sub, BorderLayout.WEST);

		field_number = new JTextField();
		field_number.setText("0");
		field_number.setHorizontalAlignment(SwingConstants.CENTER);
		field_number.setFont(new Font("Arial", Font.PLAIN, 29));
		contentPane.add(field_number, BorderLayout.CENTER);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btn_ok = new JButton("Chọn");
		btn_ok.setFont(new Font("Arial", Font.PLAIN, 21));
		panel.add(btn_ok);
		
		btn_exit = new JButton("Hủy");
		btn_exit.setFont(new Font("Arial", Font.PLAIN, 21));
		panel.add(btn_exit);
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
