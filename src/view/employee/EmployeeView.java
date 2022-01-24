package view.employee;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Window.Type;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JViewport;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

import utils.WindowUtil;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.ScrollPaneConstants;
import javax.swing.JScrollBar;
import javax.swing.JTextPane;
import javax.swing.JTextField;

public class EmployeeView extends JFrame {

	private JPanel contentPane,panel_menu;
	private final int WIDTH= (int) WindowUtil.WIDTH-100;
	private final int HEIGHT=(int) WindowUtil.HEIGHT-100;
	private JLabel label_employee_name;
	private JTable table_order;
	private JComboBox comboBox_category;
	private JButton[] btns_menu,btns_category;
	public JButton[] getBtns_category() {
		return btns_category;
	}

	public void setBtns_category(JButton[] btns_category) {
		this.btns_category = btns_category;
	}

	public JPanel getPanel_category() {
		return panel_category;
	}

	public void setPanel_category(JPanel panel_category) {
		this.panel_category = panel_category;
	}

	private JButton btn_exit;
	private JTextField field_search;
	private JPanel panel_category;
	private JButton btn_delete;
	private JComboBox comboBox_orderType;
	private JComboBox comboBox_discount;
	private JLabel label_discount;
	private JLabel label_total;
	private JTextField field_total;
	private JTextField field_receiveMoney;
	private JLabel label_moneyBack;
	private JTextField field_moneyBack;
	private JButton btn_accept;
	private JPanel panel_teamilk_order;
	private JButton btn_print;
	

	/**
	 * Create the frame.
	 */
	public EmployeeView() {
		setFont(new Font("Arial", Font.PLAIN, 16));
		setTitle("Hệ thống quản lý");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50,this.WIDTH,this.HEIGHT);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_menu_show = new JPanel();
		panel_menu_show.setBounds(0, 55, 766, 575);
		contentPane.add(panel_menu_show);
		JScrollPane scrollPane_menu = new JScrollPane();
		scrollPane_menu.setAutoscrolls(true);
		scrollPane_menu.setBounds(200, 0, 556, 564);
		
		scrollPane_menu.setPreferredSize(new Dimension(100, 200));
		panel_menu_show.setLayout(null);
		panel_menu_show.add(scrollPane_menu);
		
		panel_menu = new JPanel();
		panel_menu.setLayout(null);
		scrollPane_menu.setViewportView(panel_menu);
		
		panel_category = new JPanel();
		panel_category.setBounds(10, 0, 191, 564);
		panel_menu_show.add(panel_category);
		panel_category.setLayout(null);
		panel_category.setAutoscrolls(true);

		
		panel_teamilk_order = new JPanel();
		panel_teamilk_order.setBounds(776, 55, 464, 575);
		contentPane.add(panel_teamilk_order);
		panel_teamilk_order.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 0, 444, 343);
		panel_teamilk_order.add(scrollPane);
		
		table_order = new JTable();
		table_order.setFont(new Font("Arial", Font.PLAIN, 12));
		table_order.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table_order.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
		scrollPane.setViewportView(table_order);
		
		btn_delete = new JButton("Xóa");
		btn_delete.setFont(new Font("Arial", Font.PLAIN, 14));
		btn_delete.setBounds(289, 354, 122, 45);
		panel_teamilk_order.add(btn_delete);
		
		JLabel label_orderType = new JLabel("Loại đơn :");
		label_orderType.setHorizontalAlignment(SwingConstants.LEFT);
		label_orderType.setFont(new Font("Arial", Font.PLAIN, 14));
		label_orderType.setBounds(10, 354, 82, 29);
		panel_teamilk_order.add(label_orderType);
		
		comboBox_orderType = new JComboBox();
		comboBox_orderType.setBounds(102, 354, 154, 29);
		panel_teamilk_order.add(comboBox_orderType);
		
		comboBox_discount = new JComboBox();
		comboBox_discount.setBounds(102, 394, 154, 29);
		panel_teamilk_order.add(comboBox_discount);
		
		label_discount = new JLabel("Giảm giá :");
		label_discount.setHorizontalAlignment(SwingConstants.LEFT);
		label_discount.setFont(new Font("Arial", Font.PLAIN, 14));
		label_discount.setBounds(10, 394, 82, 29);
		panel_teamilk_order.add(label_discount);
		
		label_total = new JLabel("Tổng :");
		label_total.setHorizontalAlignment(SwingConstants.LEFT);
		label_total.setFont(new Font("Arial", Font.PLAIN, 14));
		label_total.setBounds(10, 439, 82, 29);
		panel_teamilk_order.add(label_total);
		
		field_total = new JTextField();
		field_total.setFont(new Font("Arial", Font.PLAIN, 14));
		field_total.setEditable(false);
		field_total.setBounds(102, 434, 154, 35);
		panel_teamilk_order.add(field_total);
		field_total.setColumns(10);
		
		JLabel label_moneyReceive = new JLabel("Tiền nhận :");
		label_moneyReceive.setHorizontalAlignment(SwingConstants.LEFT);
		label_moneyReceive.setFont(new Font("Arial", Font.PLAIN, 14));
		label_moneyReceive.setBounds(10, 479, 82, 29);
		panel_teamilk_order.add(label_moneyReceive);
		
		field_receiveMoney = new JTextField();
		field_receiveMoney.setFont(new Font("Arial", Font.PLAIN, 14));
		field_receiveMoney.setColumns(10);
		field_receiveMoney.setBounds(102, 473, 154, 35);
		panel_teamilk_order.add(field_receiveMoney);
		
		btn_print = new JButton("In hóa đơn");
		btn_print.setFont(new Font("Arial", Font.PLAIN, 14));
		btn_print.setBounds(289, 431, 122, 45);
		panel_teamilk_order.add(btn_print);
		
		btn_accept = new JButton("Xác nhận");
		btn_accept.setFont(new Font("Arial", Font.PLAIN, 14));
		btn_accept.setBounds(289, 506, 122, 45);
		panel_teamilk_order.add(btn_accept);
		
		label_moneyBack = new JLabel("Tiền thối :");
		label_moneyBack.setHorizontalAlignment(SwingConstants.LEFT);
		label_moneyBack.setFont(new Font("Arial", Font.PLAIN, 14));
		label_moneyBack.setBounds(10, 522, 82, 29);
		panel_teamilk_order.add(label_moneyBack);
		
		field_moneyBack = new JTextField();
		field_moneyBack.setEditable(false);
		field_moneyBack.setFont(new Font("Arial", Font.PLAIN, 14));
		field_moneyBack.setColumns(10);
		field_moneyBack.setBounds(102, 516, 154, 35);
		panel_teamilk_order.add(field_moneyBack);
		
		JPanel panel_header = new JPanel();
		panel_header.setBounds(0, 0, 1240, 55);
		contentPane.add(panel_header);
		
		JLabel label_hello = new JLabel("Xin chào");
		label_hello.setHorizontalAlignment(SwingConstants.CENTER);
		label_hello.setFont(new Font("Arial", Font.PLAIN, 16));
		
		btn_exit = new JButton("Thoát");
		btn_exit.setFont(new Font("Arial", Font.PLAIN, 12));
		
		label_employee_name = new JLabel("New label");
		label_employee_name.setFont(new Font("Arial", Font.PLAIN, 16));
		
		JLabel lblTmKim = new JLabel("Tìm kiếm");
		lblTmKim.setHorizontalAlignment(SwingConstants.CENTER);
		lblTmKim.setFont(new Font("Arial", Font.PLAIN, 16));
		
		field_search = new JTextField();
		field_search.setColumns(10);
		
		comboBox_category = new JComboBox();
		GroupLayout gl_panel_header = new GroupLayout(panel_header);
		gl_panel_header.setHorizontalGroup(
			gl_panel_header.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_header.createSequentialGroup()
					.addGap(203)
					.addComponent(lblTmKim, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(field_search, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addComponent(comboBox_category, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
					.addGap(208)
					.addComponent(label_hello, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(label_employee_name, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(btn_exit, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
		);
		gl_panel_header.setVerticalGroup(
			gl_panel_header.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_header.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_header.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panel_header.createParallelGroup(Alignment.LEADING)
							.addComponent(lblTmKim, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
							.addComponent(field_search, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
							.addComponent(comboBox_category, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_header.createParallelGroup(Alignment.LEADING)
							.addComponent(label_hello, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
							.addComponent(label_employee_name, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
							.addComponent(btn_exit, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE))))
		);
		panel_header.setLayout(gl_panel_header);
	}

	

	public JButton getBtn_print() {
		return btn_print;
	}

	public void setBtn_print(JButton btn_print) {
		this.btn_print = btn_print;
	}

	public JPanel getPanel_teamilk_order() {
		return panel_teamilk_order;
	}

	public void setPanel_teamilk_order(JPanel panel_teamilk_order) {
		this.panel_teamilk_order = panel_teamilk_order;
	}

	public JTextField getField_moneyBack() {
		return field_moneyBack;
	}

	public void setField_moneyBack(JTextField field_moneyBack) {
		this.field_moneyBack = field_moneyBack;
	}

	public JButton getBtn_accept() {
		return btn_accept;
	}

	public void setBtn_accept(JButton btn_accept) {
		this.btn_accept = btn_accept;
	}

	public JTextField getField_search() {
		return field_search;
	}

	public void setField_search(JTextField field_search) {
		this.field_search = field_search;
	}

	public JTextField getField_total() {
		return field_total;
	}

	public void setField_total(JTextField field_total) {
		this.field_total = field_total;
	}

	public JTextField getField_receiveMoney() {
		return field_receiveMoney;
	}

	public void setField_receiveMoney(JTextField field_receiveMoney) {
		this.field_receiveMoney = field_receiveMoney;
	}

	public JComboBox getComboBox_discount() {
		return comboBox_discount;
	}

	public void setComboBox_discount(JComboBox comboBox_discount) {
		this.comboBox_discount = comboBox_discount;
	}

	public JButton getBtn_delete() {
		return btn_delete;
	}

	public void setBtn_delete(JButton btn_delete) {
		this.btn_delete = btn_delete;
	}

	public JComboBox getComboBox_orderType() {
		return comboBox_orderType;
	}

	public void setComboBox_orderType(JComboBox comboBox_orderType) {
		this.comboBox_orderType = comboBox_orderType;
	}

	public JLabel getLabel_employee_name() {
		return label_employee_name;
	}

	public void setLabel_employee_name(JLabel label_employee_name) {
		this.label_employee_name = label_employee_name;
	}

	public JTable getTable() {
		return table_order;
	}

	public void setTable(JTable table) {
		this.table_order = table;
	}

	public JComboBox getComboBox_category() {
		return comboBox_category;
	}

	public void setComboBox_category(JComboBox comboBox_category) {
		this.comboBox_category = comboBox_category;
	}

	public JPanel getPanel_menu() {
		return panel_menu;
	}

	public void setPanel_menu(JPanel panel_menu) {
		this.panel_menu = panel_menu;
	}

	public JButton[] getBtns_menu() {
		return btns_menu;
	}

	public void setBtns_menu(JButton[] btns_menu) {
		this.btns_menu = btns_menu;
	}

	public JButton getBtn_exit() {
		return btn_exit;
	}

	public JTable getTable_order() {
		return table_order;
	}

	public void setTable_order(JTable table_order) {
		this.table_order = table_order;
	}

	public void setBtn_exit(JButton btn_exit) {
		this.btn_exit = btn_exit;
	}
}
