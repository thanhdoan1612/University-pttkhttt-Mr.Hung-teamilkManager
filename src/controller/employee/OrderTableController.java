package controller.employee;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import model.Order;
import model.OrderDetail;
import model.TeaMilk;
import service.OrderDetailService;
import service.OrderService;
import service.TeaMilkService;
import utils.ConvertNumber;
import utils.Session;
import view.employee.EmployeeView;

public class OrderTableController {
	private OrderService orderService;
	private OrderDetailService orderDetailService;
	private TeaMilkService teaMilkService;
	private String[] header;
	private DefaultTableModel defaultTableModel;
	private Order order;
	private List<OrderDetail> list;
	private QuantityController quantityController;

	public OrderTableController() {
		this.orderService = new OrderService();
		orderDetailService = new OrderDetailService();
		this.teaMilkService = new TeaMilkService();
		this.defaultTableModel = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		this.order = new Order();
		this.list = new ArrayList<OrderDetail>();
		this.header = new String[] { "STT", "Tên món", "Số lượng", "Thành tiền"};

	}

	public DefaultTableModel getOrderTable() {
		defaultTableModel.setColumnIdentifiers(this.header);
		return defaultTableModel;
	}

	public void addRow(OrderDetail o) {
		int stt = getOrderTable().getRowCount() + 1;
		Object[] rowData = new Object[] { stt, o.getTeaMilk().getName(), o.getQuantity(), o.getTotal()};
		getOrderTable().addRow(rowData);
		getOrderTable().fireTableDataChanged();
	}

	public void updateRow(OrderDetail o) {
		int row = list.indexOf(o);
		int col = getOrderTable().findColumn(this.header[2]);
		getOrderTable().setValueAt(o.getQuantity(), row, col);
		getOrderTable().setValueAt(o.getTotal(), row, col + 1);
	}

	public void setOn(EmployeeView employeeView) {
		employeeView.setEnabled(false);
	}

	public void setOff(EmployeeView employeeView) {
		employeeView.setEnabled(true);
	}

	public void addTeamilk(TeaMilk t, EmployeeView employeeView) {
		setOn(employeeView);
		quantityController = new QuantityController();
		quantityController.init();
		quantityController.getQuantityView().getBtn_ok().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setOff(employeeView);
				OrderDetail orderDetail = isExist(t);
				int quantity = quantityController.getQuantity();
				if (isExist(t) != null) {
					list.get(list.indexOf(orderDetail)).setQuantity(orderDetail.getQuantity() + quantity);
					orderDetail.computeTotal();
					updateRow(orderDetail);
				} else {
					orderDetail = new OrderDetail();
					orderDetail.setTeaMilk(t);
					orderDetail.setTeaMilkID(t.getId());
					orderDetail.setQuantity(quantity);
					orderDetail.computeTotal();
					list.add(orderDetail);
					addRow(orderDetail);
				}
				quantityController.getQuantityView().dispose();
				String total = ConvertNumber.numberToPrice((int) getTotal());
				employeeView.getField_total().setText(total);
			}
		});
		quantityController.getQuantityView().getBtn_exit().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setOff(employeeView);
				quantityController.getQuantityView().dispose();
			}
		});
	}

	public OrderDetail isExist(TeaMilk t) {
		for (OrderDetail o : list) {
			if (o.getTeaMilkID() == (t.getId())) {

				return o;
			}
		}
		return null;
	}

	public double getTotal() {
		double rs = 0.0;
		for (OrderDetail t : list) {
			rs += t.getTotal();
		}
		return rs;
	}

	public boolean addOrder() {
		Order order = new Order();
		order.setEmployeeID(Session.USERLOGIN.getId());
		order.setListOrderDetail(list);
		order.setTotal(orderService.getTotal(order));
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		order.setCreateDate(timestamp);
		System.out.println(timestamp);
		order = orderService.save(order);
		if (order != null) {
			for (OrderDetail orderDetail : order.getListOrderDetail()) {
				orderDetail.setOrderID(order.getId());
				orderDetailService.add(orderDetail);
			}
			return true;
		} else {
			return false;
		}
	}

}
