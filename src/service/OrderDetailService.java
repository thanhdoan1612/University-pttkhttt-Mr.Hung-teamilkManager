package service;

import java.util.List;

import DAO.OrderDetailDAO;
import mapper.OrderDetailMapper;
import model.OrderDetail;

public class OrderDetailService {
	private OrderDetailDAO orderDetailDAO;

	public OrderDetailService() {
		orderDetailDAO = new OrderDetailDAO();
	}

	public boolean add(OrderDetail o) {
		return orderDetailDAO.add(o);
	}

	public List<OrderDetail> findByOrderID(int id) {
		return orderDetailDAO.findByOrderId(id);
	}
	public List<OrderDetail> findByTeamilkID(int id) {
		return orderDetailDAO.findByTeamilkID(id);
	}
	public List<OrderDetail> findByGroupTeamilkID(){
		return orderDetailDAO.findByGroupTeamilkID();
	}


}
