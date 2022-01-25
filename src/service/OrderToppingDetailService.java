package service;

import java.util.List;

import DAO.OrderToppingDAO;
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

}
