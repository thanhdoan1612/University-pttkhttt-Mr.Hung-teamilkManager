package DAO;

import java.util.List;

import mapper.CustomerMapper;
import model.Customer;

public class CustomerDAO extends AbstractDao implements IGenericDAO<Customer> {

	@Override
	public boolean update(Customer t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Customer> findAll() {
		String sql = "select * from customer";
		return query(sql, new CustomerMapper());
	}

	@Override
	public boolean delete(int id) {
		String sql = "delete from customer where id = ?";
		return update(sql, new CustomerMapper(), id);
	}

	@Override
	public Long save(Customer t) {
		String sql = "INSERT INTO `customer`( `Name`, `Address`, `PhoneNumber`) VALUES (?,?,?)";
		return add(sql, t.getName(), t.getAddress(), t.getPhoneNumber());
	}

}
