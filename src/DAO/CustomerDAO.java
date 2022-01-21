package DAO;

import java.util.List;

import mapper.CustomerMapper;
import model.Customer;

public class CustomerDAO extends AbstractDao implements IGenericDAO<Customer> {

	@Override
	public boolean add(Customer t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Customer t) {
		// TODO Auto-generated method stub
		return false;
	}

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
		// TODO Auto-generated method stub
		return false;
	}

}
