package DAO;

import java.util.List;

import mapper.OrderMapper;
import model.Order;

public class OrderDAO extends AbstractDao implements IGenericDAO<Order> {

	public Long save(Order t) {
		String sql = "Insert into `orders`(`EmployeeID`,`CreatedDate`, `Total`) values (?,?,?) ";
		return add(sql, t.getEmployeeID(),t.getCreateDate().toString(), t.getTotal());
	}

	@Override
	public boolean add(Order t) {
		String sql = "Insert into orders values (?,?) ";
		return update(sql, t.getEmployeeID(), t.getTotal());
	}

	@Override
	public boolean delete(Order t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Order t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Order> findAll() {
		String sql = "select * from orders";
		return query(sql, new OrderMapper());
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	} 

}
