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
		String sql = "select * from orderdetail where OrderID =?";
		return query(sql, new OrderDetailMapper(), id);
	}

	public OrderDetail findById(int id) {
		String sql = "select * from orderdetail where ID =?";
		return query(sql, new OrderDetailMapper(), id).isEmpty() ? null
				: query(sql, new OrderDetailMapper(), id).get(0);
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Long save(OrderDetail t) {
		String sql = "INSERT INTO `orderdetail`(`OrderID`,`TeamilkID`, `Quantity`, `Total`) VALUES (?,?,?,?)";
		return add(sql, t.getOrderID(), t.getTeaMilk().getId(), t.getQuantity(), t.getTotal());
	}

	public List<OrderDetail> findByTeamilkID(int id) {
		String sql = "select * from orderdetail where TeamilkID=?";
		return query(sql, new OrderDetailMapper(), id);
	}

	public List<OrderDetail> findByGroupTeamilkID() {
		String sql = "select * from orderdetail group by TeamilkID";
		return query(sql, new OrderDetailMapper());
	}

}
