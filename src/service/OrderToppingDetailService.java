package service;

import java.util.HashMap;
import java.util.List;

import DAO.OrderToppingDAO;
import model.Order;
import model.OrderDetail;
import model.OrderToppingDetail;

public class OrderToppingDetailService implements IGenericService<OrderToppingDetail> {
	private OrderToppingDAO orderToppingDAO;

	public OrderToppingDetailService() {
		this.orderToppingDAO = new OrderToppingDAO();
	}

	@Override
	public List<OrderToppingDetail> findAll() {
		// TODO Auto-generated method stub
		return orderToppingDAO.findAll();
	}

	@Override
	public boolean add(OrderToppingDetail t) {
		// TODO Auto-generated method stub
		return orderToppingDAO.add(t);
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<OrderToppingDetail> search(String nameSearch, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<OrderToppingDetail> findByOrderDetailID(int id) {
		// TODO Auto-generated method stub
		return orderToppingDAO.findByOrderDetailID(id);
	}

	@Override
	public boolean update(OrderToppingDetail t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public OrderToppingDetail findByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public HashMap<Integer, Integer> getStatisticToppingFromOrderDetail(OrderDetail orderDetail) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		List<OrderToppingDetail> orderToppingDetails = findByOrderDetailID(orderDetail.getId());
		for (OrderToppingDetail otd : orderToppingDetails) {
			if (map.containsKey(otd.getToppingId())) {
				int value = map.get(otd.getToppingId()) + 1;
				map.put(otd.getToppingId(), value);
			} else {
				map.put(otd.getToppingId(), 1);
			}
		}
		return map;
	}

}
