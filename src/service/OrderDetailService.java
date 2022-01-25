package service;

import java.util.List;

import DAO.OrderDetailDAO;
import mapper.OrderDetailMapper;
import model.OrderDetail;
import model.OrderToppingDetail;
import model.TeaMilk;

public class OrderDetailService {
	private OrderDetailDAO orderDetailDAO;
	private TeaMilkService teaMilkService;

	public OrderDetailService() {
		orderDetailDAO = new OrderDetailDAO();
		teaMilkService = new TeaMilkService();
	}

	public OrderDetail save(OrderDetail o) {
		Long id = orderDetailDAO.save(o);
		if (id != null) {
			o.setId(id.intValue());
			return o;
		}
		return null;

	}

	public OrderDetail findByID(int id) {
		return orderDetailDAO.findById(id);
	}

	public List<OrderDetail> findByOrderID(int id) {
		return orderDetailDAO.findByOrderId(id);
	}

	public List<OrderDetail> findByTeamilkID(int id) {
		return orderDetailDAO.findByTeamilkID(id);
	}

	public List<OrderDetail> findByGroupTeamilkID() {
		return orderDetailDAO.findByGroupTeamilkID();
	}

	public double getTotal(OrderDetail orderDetail) {
		double rs = orderDetail.getQuantity() * orderDetail.getTeaMilk().getPrice();
		for (OrderToppingDetail orderToppingDetail : orderDetail.getListToppingDetails()) {
			TeaMilk topping = teaMilkService.findByID(orderToppingDetail.getToppingId());
			rs += topping.getPrice()*orderDetail.getQuantity();
		}
		return rs;
	}
}
