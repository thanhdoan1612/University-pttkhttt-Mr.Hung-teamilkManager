package view.admin;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import utils.WindowUtil;

public class AdminView extends JFrame {

	private JPanel contentPane;
	private JButton btn_teamilk_manager;
	private JButton btn_table_manager;
	private JButton btn_user_manager;
	private JButton btn_statistic;
	private JButton btn_add;
	private JButton btn_edit;
	private JButton btn_delete;
	private JTable table_view;
	private JTextField field_search;
	private JComboBox comboBox_search;
	private JLabel label_name;
	private JButton btn_switch;
	private JPanel view_panel;


	public JButton getBtn_teamilk_manager() {
		return btn_teamilk_manager;
	}

	public void setBtn_teamilk_manager(JButton btn_teamilk_manager) {
		this.btn_teamilk_manager = btn_teamilk_manager;
	}

	public JButton getBtn_table_manager() {
		return btn_table_manager;
	}

	public void setBtn_table_manager(JButton btn_table_manager) {
		this.btn_table_manager = btn_table_manager;
	}

	public JButton getBtn_user_manager() {
		return btn_user_manager;
	}

	public void setBtn_user_manager(JButton btn_user_manager) {
		this.btn_user_manager = btn_user_manager;
	}

	public JButton getBtn_statistic() {
		return btn_statistic;
	}

	public void setBtn_statistic(JButton btn_statistic) {
		this.btn_statistic = btn_statistic;
	}

	public JButton getBtn_add() {
		return btn_add;
	}

	public void setBtn_add(JButton btn_add) {
		this.btn_add = btn_add;
	}

	public JButton getBtn_edit() {
		return btn_edit;
	}

	public void setBtn_edit(JButton btn_edit) {
		this.btn_edit = btn_edit;
	}

	public JButton getBtn_delete() {
		return btn_delete;
	}

	public void setBtn_delete(JButton btn_delete) {
		this.btn_delete = btn_delete;
	}

	public JTable getTable_view() {
		return table_view;
	}

	public void setTable_view(JTable table_view) {
		this.table_view = table_view;
	}

	public JTextField getField_search() {
		return field_search;
	}

	public void setField_search(JTextField field_search) {
		this.field_search = field_search;
	}


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminView frame = new AdminView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AdminView() {
		setTitle("Màn hình quản lý");
		setFont(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(50, 50,(int) WindowUtil.WIDTH-100,(int) WindowUtil.HEIGHT-100);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel manger_panel = new JPanel();
		manger_panel.setBounds(5, 64, 253, 565);
		manger_panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));

		view_panel = new JPanel();
		view_panel.setBounds(264, 64, 977, 565);
		view_panel.setPreferredSize(new Dimension(500, 500));
		view_panel.setBackground(Color.WHITE);
		view_panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 1363, 53);
		
		JLabel label_hello = new JLabel("Xin chào");
		label_hello.setHorizontalAlignment(SwingConstants.CENTER);
		label_hello.setFont(new Font("Arial", Font.PLAIN, 16));
		
		label_name = new JLabel("New label");
		label_name.setFont(new Font("Arial", Font.PLAIN, 16));
		
		btn_switch = new JButton("Màn hình nhân viên");
		btn_switch.setFont(new Font("Arial", Font.PLAIN, 16));
		btn_switch.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btn_switch.setBackground(SystemColor.menu);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(label_hello, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(label_name, GroupLayout.PREFERRED_SIZE, 267, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btn_switch, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(767, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(label_hello, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
								.addComponent(label_name, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)))
						.addComponent(btn_switch, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);

		JLabel lblTmKim = new JLabel("Tìm kiếm");
		lblTmKim.setHorizontalAlignment(SwingConstants.CENTER);
		lblTmKim.setFont(new Font("Arial", lblTmKim.getFont().getStyle(), lblTmKim.getFont().getSize() + 6));

		field_search = new JTextField();
		field_search.setHorizontalAlignment(SwingConstants.LEFT);
		field_search.setColumns(10);

		table_view = new JTable();
		table_view.setOpaque(false);
		table_view.setAutoCreateRowSorter(true);
		table_view.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table_view.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		JScrollPane table_scroll =new JScrollPane(table_view);
		table_scroll.setAutoscrolls(true);
		btn_add = new JButton("Thêm");
		btn_add.setFont(new Font("Arial", Font.PLAIN, 16));

		btn_edit = new JButton("Sửa");
		btn_edit.setFont(new Font("Arial", Font.PLAIN, 16));

		btn_delete = new JButton("Xóa");
		btn_delete.setFont(new Font("Arial", Font.PLAIN, 16));
		
		comboBox_search = new JComboBox();
		comboBox_search.setMaximumRowCount(50);
		
		GroupLayout gl_view_panel = new GroupLayout(view_panel);
		gl_view_panel.setHorizontalGroup(
			gl_view_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_view_panel.createSequentialGroup()
					.addGroup(gl_view_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_view_panel.createSequentialGroup()
							.addGap(68)
							.addComponent(lblTmKim, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(field_search, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
							.addGap(39)
							.addComponent(comboBox_search, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_view_panel.createSequentialGroup()
							.addGap(21)
							.addComponent(table_scroll, GroupLayout.PREFERRED_SIZE, 798, GroupLayout.PREFERRED_SIZE)
							.addGap(32)
							.addGroup(gl_view_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(btn_edit, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
								.addComponent(btn_delete, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
								.addComponent(btn_add, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE))))
					.addGap(108))
		);
		gl_view_panel.setVerticalGroup(
			gl_view_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_view_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_view_panel.createParallelGroup(Alignment.BASELINE, false)
						.addComponent(lblTmKim, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(field_search, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
						.addComponent(comboBox_search, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(table_scroll, GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE)
					.addGap(3))
				.addGroup(gl_view_panel.createSequentialGroup()
					.addGap(142)
					.addComponent(btn_add, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btn_edit, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btn_delete, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(308, Short.MAX_VALUE))
		);
		view_panel.setLayout(gl_view_panel);
		btn_table_manager = new JButton("Quản lý bàn");
		btn_table_manager.setBackground(UIManager.getColor("Button.background"));
		btn_table_manager.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btn_table_manager.setFont(new Font("Arial", Font.PLAIN, 16));

		btn_teamilk_manager = new JButton("Quản lý thực đơn");
		btn_teamilk_manager.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btn_teamilk_manager.setFont(new Font("Arial", Font.PLAIN, 16));

		btn_user_manager = new JButton("Quản lý tài khoản");
		btn_user_manager.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btn_user_manager.setFont(new Font("Arial", Font.PLAIN, 16));

		btn_statistic = new JButton("Thống kê");
		btn_statistic.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btn_statistic.setFont(new Font("Arial", Font.PLAIN, 16));
		GroupLayout gl_manger_panel = new GroupLayout(manger_panel);
		gl_manger_panel.setHorizontalGroup(
			gl_manger_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_manger_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_manger_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(btn_statistic, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn_user_manager, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn_teamilk_manager, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
						.addComponent(btn_table_manager, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(27, Short.MAX_VALUE))
		);
		gl_manger_panel.setVerticalGroup(
			gl_manger_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_manger_panel.createSequentialGroup()
					.addGap(164)
					.addComponent(btn_table_manager, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btn_teamilk_manager, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
					.addGap(26)
					.addComponent(btn_user_manager, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
					.addGap(28)
					.addComponent(btn_statistic, GroupLayout.PREFERRED_SIZE, 58, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(142, Short.MAX_VALUE))
		);
		manger_panel.setLayout(gl_manger_panel);
		contentPane.setLayout(null);
		contentPane.add(panel);
		contentPane.add(manger_panel);
		contentPane.add(view_panel);
	}

	public JPanel getView_panel() {
		return view_panel;
	}

	public void setView_panel(JPanel view_panel) {
		this.view_panel = view_panel;
	}

	public JComboBox getComboBox_search() {
		return comboBox_search;
	}

	public JLabel getLabel_name() {
		return label_name;
	}

	public void setLabel_name(JLabel label_name) {
		this.label_name = label_name;
	}

	public JButton getBtn_switch() {
		return btn_switch;
	}

	public void setBtn_switch(JButton btn_switch) {
		this.btn_switch = btn_switch;
	}

	public void setComboBox_search(JComboBox comboBox_search) {
		this.comboBox_search = comboBox_search;
	}
}
