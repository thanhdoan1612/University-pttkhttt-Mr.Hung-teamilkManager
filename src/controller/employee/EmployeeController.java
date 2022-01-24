package controller.employee;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileOutputStream;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfTemplate;
import com.itextpdf.text.pdf.PdfWriter;

import controller.LoginController;
import model.Category;
import model.Employee;
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
		initMenuPanel(listTeaMilks);
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

	public void initMenuPanel(List<TeaMilk> list) {
		employeeView.getPanel_menu().removeAll();
		employeeView.setBtns_menu(getMenuBtns(list));
		for (JButton btn : getMenuBtns(list)) {
			employeeView.getPanel_menu().add(btn);
		}
		employeeView.getPanel_menu().setPreferredSize(new Dimension(500, 100 * getMenuBtns(list).length));
		employeeView.revalidate();
	}

	// Tạo một mảng các button các món ăn
	public JButton[] getMenuBtns(List<TeaMilk> list) {
		JButton[] rs = null;
		rs = new JButton[list.size()];
		int i = 0;
		int x = 0;
		int y = 0;
		for (TeaMilk t : list) {
			rs[i] = createTeamilkButton(t, x, y);
			x = rs[i].getWidth() + 3;

			rs[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					addTeamilk(t);
				}
			});
			if ((i + 1) % 2 == 0) {
				x = 0;
				y += rs[i].getHeight();
			}
			i++;

		}
		return rs;
	}

	/*
	 * Tạo 1 button chọn món tại vị trí x =x, y =y
	 */
	public JButton createTeamilkButton(TeaMilk teaMilk, int x, int y) {
		int width = 275;
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
		int height = 80;
		JButton rs = new JButton();
		rs.setText(category.getName());
		rs.setBounds(x, y, width, height);
		rs.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				listTeaMilks = teaMilkService.findByCategoryID(category.getID());
				initMenuPanel(listTeaMilks);
			}
		});
		return rs;
	}

	public JButton[] getCategoryBtns() {
		JButton[] rs = null;
		List<Category> list = categoryService.findAll();
		rs = new JButton[list.size()];
		int i = 0;
		int x = 20;
		int y = 0;
		for (Category c : list) {
			rs[i] = createCategoryButton(c, x, y);
			y += rs[i].getHeight();
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
		this.employeeView.getField_search().addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String name = employeeView.getField_search().getText();
				searchTeamilk(name);
			}
		});
		
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
		this.employeeView.getBtn_print().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				printOrderIntoPDF();
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
		QuantityController quantityController = new QuantityController(t, orderTableController, this);
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

	public void searchTeamilk(String name) {
		listTeaMilks = teaMilkService.search("Name", name);
		initMenuPanel(listTeaMilks);
	}

	public void printOrderIntoPDF() {
		JPanel panel = employeeView.getPanel_teamilk_order();
		Document document = new Document();
		try {
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("order\\test.pdf"));
			document.open();
			PdfContentByte contentByte = writer.getDirectContent();
			PdfTemplate template = contentByte.createTemplate(500, 500);
			Graphics2D g2 = template.createGraphics(500, 500);
			panel.print(g2);
			g2.dispose();
			contentByte.addTemplate(template, 30, 300);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (document.isOpen()) {
				document.close();
			}
		}
	}
}
