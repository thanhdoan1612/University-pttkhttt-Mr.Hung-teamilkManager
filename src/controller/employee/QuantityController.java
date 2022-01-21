package controller.employee;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import model.OrderDetail;
import model.TeaMilk;
import utils.ConvertNumber;
import view.employee.EmployeeView;
import view.employee.QuantityView;

public class QuantityController {
	private QuantityView quantityView;
	private TeaMilk teamilk;
	private int quantity;
	private OrderDetail orderDetail;
	private OrderTableController orderTableController;
	private EmployeeController employeeController;

	public QuantityController(TeaMilk teamilk, OrderTableController orderTableController,
			EmployeeController employeeController) {
		this.quantityView = new QuantityView();
		this.orderDetail = new OrderDetail();
		this.orderTableController = orderTableController;
		this.employeeController = employeeController;
		this.teamilk = teamilk;
		initAction();

	}

	public void init() {
		this.quantityView.getLabel_nameFood().setText(teamilk.getName());
		this.quantity = 0;
		this.quantityView.setVisible(true);
		this.quantityView.getField_number().setText(quantity + "");

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
				quantityView.dispose();
				employeeController.setOn();
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
