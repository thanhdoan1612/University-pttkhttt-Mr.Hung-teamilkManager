package view.employee;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class OrderPanelView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	private JLabel label_stt, label_employeeName, label_quantity, label_total, label_nameMilkTea, label_createDate;
	private JPanel main_panel, panel_orderDetail;
	private JTextField field_total, field_receivedMoney, field_backMoney;
	private JPanel panel_1;
	private JLabel label_stt_1;
	private JLabel label_nameMilkTea_1;
	private JLabel label_quantity_1;
	private JLabel label_total_1;

	/**
	 * Create the frame.
	 */
	public OrderPanelView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 641, 491);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		main_panel = new JPanel();
		main_panel.setBackground(Color.LIGHT_GRAY);
		main_panel.setForeground(Color.WHITE);
		main_panel.setBounds(0, 0, 620, 442);
		contentPane.add(main_panel);
		main_panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("DoDuTea");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		lblNewLabel.setBounds(194, 11, 147, 31);
		main_panel.add(lblNewLabel);

		JLabel lblTenNhanVien = new JLabel("Ten nhan vien:");
		lblTenNhanVien.setHorizontalAlignment(SwingConstants.CENTER);
		lblTenNhanVien.setFont(new Font("Arial", Font.PLAIN, 14));
		lblTenNhanVien.setBounds(30, 53, 128, 31);
		main_panel.add(lblTenNhanVien);

		label_employeeName = new JLabel("Ten nhan vien:");
		label_employeeName.setHorizontalAlignment(SwingConstants.CENTER);
		label_employeeName.setFont(new Font("Arial", Font.PLAIN, 14));
		label_employeeName.setBounds(175, 53, 147, 31);
		main_panel.add(label_employeeName);

		label_stt = new JLabel("STT");
		label_stt.setHorizontalAlignment(SwingConstants.LEFT);
		label_stt.setFont(new Font("Arial", Font.PLAIN, 14));
		label_stt.setBounds(10, 95, 64, 31);
		main_panel.add(label_stt);

		label_nameMilkTea = new JLabel("Ten mon");
		label_nameMilkTea.setHorizontalAlignment(SwingConstants.LEFT);
		label_nameMilkTea.setFont(new Font("Arial", Font.PLAIN, 14));
		label_nameMilkTea.setBounds(84, 95, 305, 31);
		main_panel.add(label_nameMilkTea);

		label_quantity = new JLabel("So luong");
		label_quantity.setHorizontalAlignment(SwingConstants.LEFT);
		label_quantity.setFont(new Font("Arial", Font.PLAIN, 14));
		label_quantity.setBounds(399, 95, 90, 31);
		main_panel.add(label_quantity);

		label_total = new JLabel("Thanh tien");
		label_total.setHorizontalAlignment(SwingConstants.LEFT);
		label_total.setFont(new Font("Arial", Font.PLAIN, 14));
		label_total.setBounds(511, 95, 99, 31);
		main_panel.add(label_total);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 254, 600, 5);
		main_panel.add(panel);

		label_createDate = new JLabel("thoi gian");
		label_createDate.setHorizontalAlignment(SwingConstants.CENTER);
		label_createDate.setFont(new Font("Arial", Font.PLAIN, 14));
		label_createDate.setBounds(353, 53, 179, 31);
		main_panel.add(label_createDate);

		JPanel panel_bot = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(30, 254, 580, 5);
		main_panel.add(panel);

		JLabel lblTongTien = new JLabel("Tong tien:");
		lblTongTien.setHorizontalAlignment(SwingConstants.LEFT);
		lblTongTien.setFont(new Font("Arial", Font.PLAIN, 14));
		lblTongTien.setBounds(271, 270, 128, 31);
		main_panel.add(lblTongTien);

		JLabel lblTienNhan = new JLabel("Tien nhan:");
		lblTienNhan.setHorizontalAlignment(SwingConstants.LEFT);
		lblTienNhan.setFont(new Font("Arial", Font.PLAIN, 14));
		lblTienNhan.setBounds(271, 312, 128, 31);
		main_panel.add(lblTienNhan);

		JLabel lblTienThoi = new JLabel("Tien thoi:");
		lblTienThoi.setHorizontalAlignment(SwingConstants.LEFT);
		lblTienThoi.setFont(new Font("Arial", Font.PLAIN, 14));
		lblTienThoi.setBounds(271, 354, 128, 31);
		main_panel.add(lblTienThoi);

		field_total = new JTextField();
		field_total.setEditable(false);
		field_total.setHorizontalAlignment(SwingConstants.RIGHT);
		field_total.setColumns(10);
		field_total.setBounds(409, 271, 179, 31);
		main_panel.add(field_total);

		field_receivedMoney = new JTextField();
		field_receivedMoney.setEditable(false);
		field_receivedMoney.setHorizontalAlignment(SwingConstants.RIGHT);
		field_receivedMoney.setColumns(10);
		field_receivedMoney.setBounds(409, 313, 179, 31);
		main_panel.add(field_receivedMoney);

		field_backMoney = new JTextField();
		field_backMoney.setEditable(false);
		field_backMoney.setHorizontalAlignment(SwingConstants.RIGHT);
		field_backMoney.setColumns(10);
		field_backMoney.setBounds(409, 357, 179, 31);
		main_panel.add(field_backMoney);

		JLabel lblChucQuyKhac = new JLabel("CHUC QUY KHACH CO MOT NGAY VUI VE!!");
		lblChucQuyKhac.setHorizontalAlignment(SwingConstants.CENTER);
		lblChucQuyKhac.setFont(new Font("Arial", Font.PLAIN, 16));
		lblChucQuyKhac.setBounds(100, 410, 359, 31);
		main_panel.add(lblChucQuyKhac);

		panel_orderDetail = new JPanel();
		panel_orderDetail.setLayout(null);
		panel_orderDetail.setForeground(Color.WHITE);
		panel_orderDetail.setBounds(0, 137, 620, 106);
		main_panel.add(panel_orderDetail);
		
		label_stt_1 = new JLabel("STT");
		label_stt_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_stt_1.setFont(new Font("Arial", Font.PLAIN, 14));
		label_stt_1.setBounds(10, 11, 64, 31);
		panel_orderDetail.add(label_stt_1);
		
		label_nameMilkTea_1 = new JLabel("Ten mon");
		label_nameMilkTea_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_nameMilkTea_1.setFont(new Font("Arial", Font.PLAIN, 14));
		label_nameMilkTea_1.setBounds(84, 11, 303, 31);
		panel_orderDetail.add(label_nameMilkTea_1);
		
		label_quantity_1 = new JLabel("So luong");
		label_quantity_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_quantity_1.setFont(new Font("Arial", Font.PLAIN, 14));
		label_quantity_1.setBounds(397, 11, 90, 31);
		panel_orderDetail.add(label_quantity_1);
		
		label_total_1 = new JLabel("Thanh tien");
		label_total_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_total_1.setFont(new Font("Arial", Font.PLAIN, 14));
		label_total_1.setBounds(508, 11, 102, 31);
		panel_orderDetail.add(label_total_1);

		panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBounds(10, 79, 600, 5);
		main_panel.add(panel_1);

		setContentPane(contentPane);

	}

	public JLabel getLabel_stt_1() {
		return label_stt_1;
	}

	public void setLabel_stt_1(JLabel label_stt_1) {
		this.label_stt_1 = label_stt_1;
	}

	public JLabel getLabel_nameMilkTea_1() {
		return label_nameMilkTea_1;
	}

	public void setLabel_nameMilkTea_1(JLabel label_nameMilkTea_1) {
		this.label_nameMilkTea_1 = label_nameMilkTea_1;
	}

	public JLabel getLabel_quantity_1() {
		return label_quantity_1;
	}

	public void setLabel_quantity_1(JLabel label_quantity_1) {
		this.label_quantity_1 = label_quantity_1;
	}

	public JLabel getLabel_total_1() {
		return label_total_1;
	}

	public void setLabel_total_1(JLabel label_total_1) {
		this.label_total_1 = label_total_1;
	}

	public JLabel getLabel_stt() {
		return label_stt;
	}

	public void setLabel_stt(JLabel label_stt) {
		this.label_stt = label_stt;
	}

	public JLabel getLabel_employeeName() {
		return label_employeeName;
	}

	public void setLabel_employeeName(JLabel label_employeeName) {
		this.label_employeeName = label_employeeName;
	}

	public JLabel getLabel_quantity() {
		return label_quantity;
	}

	public void setLabel_quantity(JLabel label_quantity) {
		this.label_quantity = label_quantity;
	}

	public JLabel getLabel_total() {
		return label_total;
	}

	public void setLabel_total(JLabel label_total) {
		this.label_total = label_total;
	}

	public JLabel getLabel_nameMilkTea() {
		return label_nameMilkTea;
	}

	public void setLabel_nameMilkTea(JLabel label_nameMilkTea) {
		this.label_nameMilkTea = label_nameMilkTea;
	}

	public JLabel getLabel_createDate() {
		return label_createDate;
	}

	public void setLabel_createDate(JLabel label_createDate) {
		this.label_createDate = label_createDate;
	}

	public JPanel getMain_panel() {
		return main_panel;
	}

	public void setMain_panel(JPanel main_panel) {
		this.main_panel = main_panel;
	}

	public JPanel getPanel_orderDetail() {
		return panel_orderDetail;
	}

	public void setPanel_orderDetail(JPanel panel_orderDetail) {
		this.panel_orderDetail = panel_orderDetail;
	}

	public JTextField getField_total() {
		return field_total;
	}

	public void setField_total(JTextField field_total) {
		this.field_total = field_total;
	}

	public JTextField getField_receivedMoney() {
		return field_receivedMoney;
	}

	public void setField_receivedMoney(JTextField field_receivedMoney) {
		this.field_receivedMoney = field_receivedMoney;
	}

	public JTextField getField_backMoney() {
		return field_backMoney;
	}

	public void setField_backMoney(JTextField field_backMoney) {
		this.field_backMoney = field_backMoney;
	}

}
