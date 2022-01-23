package DAO;

import java.util.List;

import mapper.OrderDetailMapper;
import model.OrderDetail;

public class OrderDetailDAO extends AbstractDao implements IGenericDAO<OrderDetail> {


	public boolean add(OrderDetail t) {
		String sql = "INSERT INTO `orderdetail`(`OrderID`,`TeamilkID`, `Quantity`, `Total`) VALUES (?,?,?,?)";
		return update(sql, t.getOrderID(), t.getTeaMilk().getId(), t.getQuantity(), t.getTotal());
	}

	@Override
	public boolean update(OrderDetail t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<OrderDetail> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<OrderDetail> findByOrderId(int id) {
		String sql = "select * from orderdetail where id =?";
		return query(sql, new OrderDetailMapper(), id);
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Long save(OrderDetail t) {
		// TODO Auto-generated method stub
		return null;
	}

}
