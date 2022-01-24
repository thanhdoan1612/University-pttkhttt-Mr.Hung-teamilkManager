package service;

import java.util.HashMap;
import java.util.List;

import DAO.OrderDAO;
import model.Employee;
import model.Order;
import model.OrderDetail;

public class OrderService implements IGenericService<Order> {
	private OrderDAO orderDAO;

	public OrderService() {
		this.orderDAO = new OrderDAO();
	}

	@Override
	public List<Order> findAll() {
		// TODO Auto-generated method stub
		return orderDAO.findAll();
	}

	@Override
	public boolean add(Order t) {
		// TODO Auto-generated method stub
		return false;
	}

	public Order save(Order t) {
		Long id = orderDAO.save(t);
		if (id != null)
			t.setId(id.intValue());
		return id != null ? t : null;
	}

	public boolean delete(Order t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Order> search(String nameSearch, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	public double getTotal(Order o) {
		double rs = 0.0;
		for (OrderDetail oDetail : o.getListOrderDetail()) {
			rs += oDetail.getTotal();
		}
		return rs;
	}

	public int getCountOrder() {
		return findAll().size();
	}

	public double getAllTotal() {
		double rs = 0.0;
		for (Order o : findAll())
			rs += o.getTotal();
		return rs;
	}

	public double getAllTotal(List<Order> list) {
		double rs = 0.0;
		for (Order o : list)
			rs += o.getTotal();
		return rs;
	}

	public HashMap<Integer, Double> statisticByEmployee() {
		HashMap<Integer, Double> rs = new HashMap<Integer, Double>();
		for (Order o : findAll()) {
			int key = o.getEmployeeID();
			if (rs.containsKey(key)) {
				Double value = rs.get(key);
				value += o.getTotal();
				rs.put(key, value);
			} else {
				rs.put(key, o.getTotal());
			}
		}
		return rs;
	}
	public HashMap<Integer, Double> statisticByTeamilk() {
		HashMap<Integer, Double> rs = new HashMap<Integer, Double>();
		for (Order o : findAll()) {
			int key = o.getEmployeeID();
			if (rs.containsKey(key)) {
				Double value = rs.get(key);
				value += o.getTotal();
				rs.put(key, value);
			} else {
				rs.put(key, o.getTotal());
			}
		}
		return rs;
	}

	@Override
	public Order findByID(int id) {
		// TODO Auto-generated method stub
		return orderDAO.findByID(id);
	}

	@Override
	public boolean update(Order t) {
		// TODO Auto-generated method stub
		return false;
	}

}
