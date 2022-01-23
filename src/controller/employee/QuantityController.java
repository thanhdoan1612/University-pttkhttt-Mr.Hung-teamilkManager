package controller.employee;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import model.Category;
import model.OrderDetail;
import model.TeaMilk;
import service.CategoryService;
import service.TeaMilkService;
import utils.ConvertNumber;
import view.employee.QuantityView;

public class QuantityController {
	private QuantityView quantityView;
	private TeaMilk teamilk;
	private int quantity;
	private OrderDetail orderDetail;
	private OrderTableController orderTableController;
	private EmployeeController employeeController;
	private CategoryService categoryService;
	private TeaMilkService teaMilkService;
	private JTextField[] fields;
	private JCheckBox[] checkBoxs;

	public QuantityController(TeaMilk teamilk, OrderTableController orderTableController,
			EmployeeController employeeController) {
		this.quantityView = new QuantityView();
		this.orderDetail = new OrderDetail();
		this.orderTableController = orderTableController;
		this.employeeController = employeeController;
		this.teamilk = teamilk;
		this.categoryService = new CategoryService();
		this.teaMilkService = new TeaMilkService();
		initAction();

	}

	public void init() {
		this.quantityView.getLabel_nameFood().setText(teamilk.getName());
		this.quantity = 0;
		this.quantityView.setVisible(true);
		this.quantityView.getField_number().setText(quantity + "");
		initTopping();

	}

	public void initTopping() {
		int xField = this.quantityView.getField_topping().getX();
		int widthField = this.quantityView.getField_topping().getWidth();
		int heightField = this.quantityView.getField_topping().getHeight();
		int xCbox = this.quantityView.getCheckBox_choose().getX();
		int widthCbox = this.quantityView.getCheckBox_choose().getWidth();
		int heightCbox = this.quantityView.getCheckBox_choose().getHeight();
		Category category = categoryService.findByCode("topping");
		List<TeaMilk> listTeaMilks = teaMilkService.findByCategoryID(category.getID());
		fields = new JTextField[listTeaMilks.size()];
		checkBoxs = new JCheckBox[listTeaMilks.size()];

		for (int i = 0; i < fields.length; i++) {
			fields[i] = new JTextField(listTeaMilks.get(i).getName());
			fields[i].setBounds(xField, heightField * i, widthField, heightField);
			fields[i].setEnabled(false);
			fields[i].setDisabledTextColor(Color.BLACK);
			checkBoxs[i] = new JCheckBox();
			checkBoxs[i].setHorizontalAlignment(SwingConstants.CENTER);
			checkBoxs[i].setActionCommand(listTeaMilks.get(i).getId() + "");
			checkBoxs[i].setBounds(xCbox, heightCbox * i, widthCbox, heightCbox);
			checkBoxs[i].setVisible(true);
			this.quantityView.getPanel_topping().add(fields[i]);
			this.quantityView.getPanel_topping().add(checkBoxs[i]);

		}
		this.quantityView.getPanel_topping()
				.setPreferredSize(new Dimension(widthField + widthCbox, heightField * fields.length));
	}

	public boolean isOn() {
		return this.quantityView.isVisible();
	}

	public void initAction() {
		this.quantityView.getField_number().addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				quantity = getQuantityFromField();
				System.out.println(quantity);
			}
		});
		this.quantityView.getBtn_add().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				quantity = getQuantityFromField() + 1;
				quantityView.getField_number().setText(quantity + "");

			}
		});
		this.quantityView.getBtn_sub().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				quantity = getQuantityFromField();
				quantity = quantity == 0 ? 0 : quantity - 1;
				quantityView.getField_number().setText(quantity + "");

			}
		});
		this.quantityView.getBtn_exit().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				employeeController.setOn();
				quantityView.dispose();
			}
		});
		this.quantityView.getBtn_ok().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				createOrderDetail();
				employeeController.setOn();
				quantityView.dispose();

				int total = (int) orderTableController.getTotal();
				String totalPrice = ConvertNumber.numberToPrice(total);
				employeeController.getEmployeeView().getField_total().setText(totalPrice);

			}
		});

	}

	public void createOrderDetail() {
		orderDetail.setTeaMilk(teamilk);
		orderDetail.setTeaMilkID(teamilk.getId());
		orderDetail.setQuantity(quantity);
		orderDetail.computeTotal();
		orderTableController.addOrderDetail(orderDetail);
	}

	public int getQuantityFromField() {
		return Integer.parseInt(quantityView.getField_number().getText());
	}

	public int getQuantity() {
		return quantity;
	}

	public OrderDetail getOrderDetail() {
		return orderDetail;
	}

	public void setOrderDetail(OrderDetail orderDetail) {
		this.orderDetail = orderDetail;
	}

	public QuantityView getQuantityView() {
		return quantityView;
	}

}
