package DAO;

import java.util.List;

import mapper.OrderMapper;
import model.Order;

public class OrderDAO extends AbstractDao implements IGenericDAO<Order> {

	public Long save(Order t) {
		String sql = "Insert into `orders`(`EmployeeID`,`CreatedDate`, `Total`) values (?,?,?) ";
		return add(sql, t.getEmployeeID(), t.getCreateDate().toString(), t.getTotal());
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

	public Order findByID(int id) {
		String sql = "select * from orders where id =?";
		return query(sql, new OrderMapper(), id).isEmpty() ? null : query(sql, new OrderMapper(), id).get(0);
	}


}
