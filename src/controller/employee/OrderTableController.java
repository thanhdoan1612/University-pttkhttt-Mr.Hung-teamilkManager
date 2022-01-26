package controller.employee;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import model.Order;
import model.OrderDetail;
import model.OrderToppingDetail;
import model.TeaMilk;
import service.OrderDetailService;
import service.OrderService;
import service.OrderToppingDetailService;
import service.TeaMilkService;
import utils.Session;

public class OrderTableController {
	private OrderService orderService;
	private OrderDetailService orderDetailService;
	private String[] header;
	private DefaultTableModel defaultTableModel;
	private Order order;
	private List<OrderDetail> list;
	private OrderToppingDetailService orderToppingDetailService;

	public OrderTableController() {
		this.orderService = new OrderService();
		this.orderDetailService = new OrderDetailService();
		this.defaultTableModel = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		this.orderToppingDetailService = new OrderToppingDetailService();

		this.order = new Order();
		this.list = new ArrayList<OrderDetail>();
		this.header = new String[] { "STT", "Tên món", "Số lượng", "Thành tiền" };

	}

	public DefaultTableModel getOrderTable() {
		defaultTableModel.setColumnIdentifiers(this.header);
		return defaultTableModel;
	}

	public void addRow(OrderDetail o) {
		int stt = getOrderTable().getRowCount() + 1;
		Object[] rowData = new Object[] { stt, o.getTeaMilk().getName(), o.getQuantity(), o.getTotal() };
		getOrderTable().addRow(rowData);
		getOrderTable().fireTableDataChanged();
	}

	public void updateRow(OrderDetail o) {
		int row = list.indexOf(o);
		int col = getOrderTable().findColumn(this.header[2]);
		getOrderTable().setValueAt(o.getQuantity(), row, col);
		getOrderTable().setValueAt(o.getTotal(), row, col + 1);
	}

	public void addOrderDetail(OrderDetail orderDetail) {
		int quantity = orderDetail.getQuantity();
		OrderDetail oldOrderDetail = isExist(orderDetail);
		if (isExist(orderDetail) != null) {
			list.get(list.indexOf(oldOrderDetail)).setQuantity(oldOrderDetail.getQuantity() + quantity);
			oldOrderDetail.setTotal(orderDetailService.getTotal(oldOrderDetail));
			updateRow(oldOrderDetail);
		} else {
			list.add(orderDetail);
			addRow(orderDetail);
		}
	}

	public OrderDetail isExist(OrderDetail orderDetail) {
		for (OrderDetail o : list) {
			if (o.getTeaMilk().getName().equals(orderDetail.getTeaMilk().getName())) {
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
		order = orderService.save(order);
		if (order != null) {
			addOrderDetail(order);
			return true;
		} else {
			return false;
		}
	}

	public void addOrderDetail(Order order) {
		for (OrderDetail orderDetail : order.getListOrderDetail()) {
			orderDetail.setOrderID(order.getId());
			Long id = orderDetailService.save(orderDetail);
			if (id != null) {
				orderDetail.setId(id.intValue());
				addOrderDetail(orderDetail);
			}
		}
	}

	public void addOrderToppingDetail(OrderDetail orderDetail) {
		for (OrderToppingDetail orderToppingDetail : orderDetail.getListToppingDetails()) {
			orderToppingDetail.setOrderDetailId(orderDetail.getId());
			orderToppingDetailService.add(orderToppingDetail);
		}
	}

}
