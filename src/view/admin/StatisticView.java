package view.admin;

import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class StatisticView extends JPanel {
	private JDateChooser dateChoose_from;
	private JTable table;
	private JDateChooser dateChoose_to;
	private JTextField field_dateFrom;
	private JTextField field_dateTo;
	private JLabel label_total;
	private JTextField field_totalOrder;
	private JTextField field_total;
	private JButton btn_filter;
	private JButton btn_statisticByEmployee;
	private JButton btn_statisticByOrder;
	private JButton btn_statisticByProduct;

	/**
	 * Create the panel.
	 */
	public StatisticView() {
		setBorder(new LineBorder(new Color(0, 0, 0), 1, true));

		setBounds(264, 64, 977, 565);
		setLayout(null);
		dateChoose_from = new JDateChooser();
		dateChoose_from.setBounds(260, 11, 98, 41);
		dateChoose_from.getCalendarButton().setBounds(0, 0, 98, 41);
		dateChoose_from.setDateFormatString("dd/MM/yyyy");
		add(dateChoose_from);
		dateChoose_from.setLayout(null);

		dateChoose_to = new JDateChooser();
		dateChoose_to.setLayout(null);
		dateChoose_to.getCalendarButton().setBounds(0, 0, 98, 41);
		dateChoose_to.setBounds(625, 11, 98, 41);
		add(dateChoose_to);

		JLabel label_dateFrom = new JLabel("Từ ngày");
		label_dateFrom.setFont(new Font("Arial", Font.PLAIN, 16));
		label_dateFrom.setBounds(10, 11, 73, 41);
		add(label_dateFrom);

		JLabel label_dateTo = new JLabel("đến");
		label_dateTo.setHorizontalAlignment(SwingConstants.CENTER);
		label_dateTo.setFont(new Font("Arial", Font.PLAIN, 16));
		label_dateTo.setBounds(368, 11, 73, 41);
		add(label_dateTo);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(23, 116, 719, 323);
		add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		
		field_dateFrom = new JTextField();
		field_dateFrom.setBounds(93, 11, 157, 41);
		add(field_dateFrom);
		field_dateFrom.setColumns(10);
		
		field_dateTo = new JTextField();
		field_dateTo.setColumns(10);
		field_dateTo.setBounds(451, 11, 157, 41);
		add(field_dateTo);
		
		JLabel lblTngSHa = new JLabel("Tổng số hóa đơn:");
		lblTngSHa.setHorizontalAlignment(SwingConstants.LEFT);
		lblTngSHa.setFont(new Font("Arial", Font.PLAIN, 16));
		lblTngSHa.setBounds(385, 450, 143, 41);
		add(lblTngSHa);
		
		label_total = new JLabel("Tổng doanh thu :");
		label_total.setHorizontalAlignment(SwingConstants.LEFT);
		label_total.setFont(new Font("Arial", Font.PLAIN, 16));
		label_total.setBounds(385, 502, 143, 41);
		add(label_total);
		
		field_totalOrder = new JTextField();
		field_totalOrder.setHorizontalAlignment(SwingConstants.RIGHT);
		field_totalOrder.setFont(new Font("Arial", Font.PLAIN, 16));
		field_totalOrder.setColumns(10);
		field_totalOrder.setBounds(650, 450, 92, 41);
		add(field_totalOrder);
		
		field_total = new JTextField();
		field_total.setHorizontalAlignment(SwingConstants.RIGHT);
		field_total.setFont(new Font("Arial", Font.PLAIN, 16));
		field_total.setColumns(10);
		field_total.setBounds(566, 502, 176, 41);
		add(field_total);
		
		btn_filter = new JButton("Lọc");
		btn_filter.setFont(new Font("Arial", Font.PLAIN, 16));
		btn_filter.setBounds(748, 11, 117, 41);
		btn_filter.setIcon(new ImageIcon("imgs/filter.png"));
		add(btn_filter);
		
		btn_statisticByEmployee = new JButton("Nhân viên");
		btn_statisticByEmployee.setFont(new Font("Arial", Font.PLAIN, 16));
		btn_statisticByEmployee.setIcon(new ImageIcon("imgs/employee.png"));
		btn_statisticByEmployee.setBounds(801, 174, 143, 41);
		add(btn_statisticByEmployee);
		
		btn_statisticByProduct = new JButton("Sản phẩm");
		btn_statisticByProduct.setFont(new Font("Arial", Font.PLAIN, 16));
		btn_statisticByProduct.setBounds(801, 237, 143, 41);
		btn_statisticByProduct.setIcon(new ImageIcon("imgs/product.png"));
		add(btn_statisticByProduct);
		
		btn_statisticByOrder = new JButton("Hóa đơn");
		btn_statisticByOrder.setFont(new Font("Arial", Font.PLAIN, 16));
		btn_statisticByOrder.setBounds(801, 301, 143, 41);
		btn_statisticByOrder.setIcon(new ImageIcon("imgs/bill.png"));
		add(btn_statisticByOrder);
		
		JLabel label_dateTo_1 = new JLabel("Thống kê theo");
		label_dateTo_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_dateTo_1.setFont(new Font("Arial", Font.PLAIN, 16));
		label_dateTo_1.setBounds(801, 117, 143, 41);
		add(label_dateTo_1);

	}

	public JButton getBtn_statisticByOrder() {
		return btn_statisticByOrder;
	}

	public void setBtn_statisticByOrder(JButton btn_statisticByOrder) {
		this.btn_statisticByOrder = btn_statisticByOrder;
	}

	public JButton getBtn_statisticByEmployee() {
		return btn_statisticByEmployee;
	}

	public void setBtn_statisticByEmployee(JButton btn_statisticByEmployee) {
		this.btn_statisticByEmployee = btn_statisticByEmployee;
	}

	public JButton getBtn_statisticByProduct() {
		return btn_statisticByProduct;
	}

	public void setBtn_statisticByProduct(JButton btn_statisticByProduct) {
		this.btn_statisticByProduct = btn_statisticByProduct;
	}

	public JButton getBtn_filter() {
		return btn_filter;
	}

	public void setBtn_filter(JButton btn_filter) {
		this.btn_filter = btn_filter;
	}

	public JTextField getField_totalOrder() {
		return field_totalOrder;
	}

	public void setField_totalOrder(JTextField field_totalOrder) {
		this.field_totalOrder = field_totalOrder;
	}

	public JTextField getField_total() {
		return field_total;
	}

	public void setField_total(JTextField field_total) {
		this.field_total = field_total;
	}

	public JTextField getField_dateFrom() {
		return field_dateFrom;
	}

	public void setField_dateFrom(JTextField field_dateFrom) {
		this.field_dateFrom = field_dateFrom;
	}

	public JTextField getField_dateTo() {
		return field_dateTo;
	}

	public void setField_dateTo(JTextField field_dateTo) {
		this.field_dateTo = field_dateTo;
	}

	public JDateChooser getDateChoose_from() {
		return dateChoose_from;
	}

	public void setDateChoose_from(JDateChooser dateChoose_from) {
		this.dateChoose_from = dateChoose_from;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JDateChooser getDateChoose_to() {
		return dateChoose_to;
	}

	public void setDateChoose_to(JDateChooser dateChoose_to) {
		this.dateChoose_to = dateChoose_to;
	}
}
