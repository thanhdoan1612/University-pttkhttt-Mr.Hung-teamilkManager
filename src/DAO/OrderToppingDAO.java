package DAO;

import java.util.List;

import mapper.OrderToppingDetailMapper;
import model.OrderToppingDetail;

public class OrderToppingDAO extends AbstractDao implements IGenericDAO<OrderToppingDetail> {

	@Override
	public Long save(OrderToppingDetail t) {
		return null;
	}

	public boolean add(OrderToppingDetail t) {
		String sql = "INSERT INTO `ordertoppingdetail`(`OrderDetailID`, `ToppingID`) VALUES (?,?) ";
		return update(sql, t.getOrderDetailId(), t.getToppingId());
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(OrderToppingDetail t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<OrderToppingDetail> findAll() {
		String sql = "select * from ordertoppingdetail";
		return query(sql, new OrderToppingDetailMapper());
	}

	public List<OrderToppingDetail> findByOrderDetailID(int id) {
		String sql = "select * from ordertoppingdetail where OrderDetailID = " + id;
		return query(sql, new OrderToppingDetailMapper());
	}

}
