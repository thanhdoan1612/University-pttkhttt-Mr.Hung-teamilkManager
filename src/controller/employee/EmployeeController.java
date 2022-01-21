package controller.employee;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import controller.LoginController;
import model.Category;
import model.Employee;
import model.OrderDetail;
import model.OrderType;
import model.TeaMilk;
import service.CategoryService;
import service.TeaMilkService;
import utils.ConvertNumber;
import utils.MessagePopup;
import utils.Session;
import view.employee.EmployeeView;

public class EmployeeController {

	private EmployeeView employeeView;
	private TeaMilkService teaMilkService;
	private CategoryService categoryService;
	private OrderTableController orderTableController;
	private QuantityController quantityController;
	private List<TeaMilk> listTeaMilks;

	public EmployeeController() {
		this.employeeView = new EmployeeView();
		this.teaMilkService = new TeaMilkService();
		this.categoryService = new CategoryService();
		this.orderTableController = new OrderTableController();
		
		this.employeeView.setVisible(true);

	}

	public void init(Employee employee) {
		listTeaMilks = teaMilkService.findAll();
		setEmployeeName(employee.getFullOfName());
		initMenuPanel();
		initCategoryPanel();
		initOrderTable();
		initComboBoxOrderType();
		initAction();
	}

	public EmployeeView getEmployeeView() {
		return employeeView;
	}

	public void initComboBoxOrderType() {
		DefaultComboBoxModel<String> defaultComboBoxModel = new DefaultComboBoxModel<String>();
		for (OrderType o : OrderType.values()) {
			defaultComboBoxModel.addElement(o.getType());
		}
		employeeView.getComboBox_orderType().setModel(defaultComboBoxModel);
	}

	public void setEmployeeName(String name) {
		employeeView.getLabel_employee_name().setText(name);
	}

	public void initOrderTable() {
		employeeView.getTable_order().setModel(orderTableController.getOrderTable());
	}

	public void initMenuPanel() {
		employeeView.getPanel_menu().removeAll();
		employeeView.setBtns_menu(getMenuBtns());
		for (JButton btn : employeeView.getBtns_menu()) {
			employeeView.getPanel_menu().add(btn);
		}
		employeeView.getPanel_menu().setPreferredSize(new Dimension(500, 100 * getMenuBtns().length));
		employeeView.revalidate();
	}

	// Tạo một mảng các button các món ăn
	public JButton[] getMenuBtns() {
		JButton[] rs = null;
		rs = new JButton[listTeaMilks.size()];
		int i = 0;
		int x = 0;
		int y = 0;
		for (TeaMilk t : listTeaMilks) {
			rs[i] = createTeamilkButton(t, x, y);
			y += rs[i].getHeight();
			rs[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					addTeamilk(t);
				}
			});
			i++;
		}
		return rs;
	}

	/*
	 * Tạo 1 button chọn món tại vị trí x =x, y =y
	 */
	public JButton createTeamilkButton(TeaMilk teaMilk, int x, int y) {
		int width = 400;
		int height = 100;
		JButton rs = new JButton();
		rs.setText(teaMilk.getName());
		rs.setBounds(x, y, width, height);
		rs.setPreferredSize(new Dimension(width, height));
		return rs;

	}

	// Tạo 1 button chọn danh mục món tại vị trí x,y
	public JButton createCategoryButton(Category category, int x, int y) {
		int width = 150;
		int height = 100;
		JButton rs = new JButton();
		rs.setText(category.getName());
		rs.setBounds(x, y, width, height);
		rs.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				listTeaMilks = teaMilkService.findByCategoryID(category.getID());
				initMenuPanel();
			}
		});
		return rs;
	}

	public JButton[] getCategoryBtns() {
		JButton[] rs = null;
		List<Category> list = categoryService.findAll();
		rs = new JButton[list.size()];
		int i = 0;
		int x = 0;
		int y = 0;
		for (Category c : list) {
			rs[i] = createCategoryButton(c, x, y);
			x += rs[i].getWidth();
			i++;
		}
		return rs;
	}

	public void initCategoryPanel() {

		this.employeeView.setBtns_category(getCategoryBtns());
		for (JButton btn : employeeView.getBtns_category()) {
			this.employeeView.getPanel_category().add(btn);
		}
		this.employeeView.getPanel_category().setPreferredSize(new Dimension(200 * getCategoryBtns().length, 125));
	}

	public void initAction() {
		this.employeeView.getBtn_accept().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String price = employeeView.getField_receiveMoney().getText();
				int moneyReceive = ConvertNumber.priceToNumber(price);
				if (moneyReceive > 0) {
					int total = ConvertNumber.priceToNumber(employeeView.getField_total().getText());
					String moneyBack = ConvertNumber.numberToPrice(moneyReceive - total);
					employeeView.getField_moneyBack().setText(moneyBack);
					if (addOrder()) {
						MessagePopup.showSuccessMessage("Bạn đã thêm đơn thành công");
					} else {
						MessagePopup.showMessage("Có lỗi khi thêm đơn hàng");
					}
				}
			}
		});

		this.employeeView.getBtn_exit().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (MessagePopup.showExitWarning()) {
					if (Session.USERLOGIN.isAdmin()) {
						employeeView.dispose();
					} else {
						Session.USERLOGIN = null;
						System.exit(1);
						LoginController loginController = new LoginController();

					}
				}
			}
		});
		this.employeeView.getBtn_delete().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = employeeView.getTable_order().getSelectedRow();
				DefaultTableModel model = (DefaultTableModel) employeeView.getTable_order().getModel();
				if (row != -1) {
					model.removeRow(row);
					model.fireTableDataChanged();
				}
			}
		});

		this.employeeView.getField_receiveMoney().addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String price = employeeView.getField_receiveMoney().getText();
				int number = ConvertNumber.priceToNumber(price);
				price = ConvertNumber.numberToPrice(number);
				employeeView.getField_receiveMoney().setText(price);
			}
		});
	}

	public void clear() {
		employeeView.getTable_order().removeAll();
		employeeView.getField_moneyBack().setText("");
		employeeView.getField_receiveMoney().setText("");
		employeeView.getField_total().setText("");
		orderTableController.getOrderTable().setRowCount(0);
		employeeView.getTable_order().setModel(orderTableController.getOrderTable());
	}

	public void addTeamilk(TeaMilk t) {
		setOff();
		QuantityController quantityController =new QuantityController(t,orderTableController,this);
		quantityController.init();
		
	}
	public void setOff() {
		employeeView.setEnabled(false);
	}

	public void setOn() {
		employeeView.setEnabled(true);
	}
	public boolean addOrder() {
		return orderTableController.addOrder();
	}
}
