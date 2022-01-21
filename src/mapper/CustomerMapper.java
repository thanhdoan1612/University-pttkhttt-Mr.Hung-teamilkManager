package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.Customer;

public class CustomerMapper implements RowMapper<Customer>{

	@Override
	public Customer mapRow(ResultSet rss) {
		Customer customer = new Customer();
		try {
			customer.setId(rss.getInt("ID"));
			customer.setName(rss.getString("Name"));
			customer.setPhoneNumber(rss.getString("PhoneNumber"));
			customer.setAddress(rss.getString("Address"));
			return customer;
		} catch (SQLException e) {
			System.out.println("Lỗi khi map Customer : "+ e.getMessage());
			return null;
			}
	
	}

}
