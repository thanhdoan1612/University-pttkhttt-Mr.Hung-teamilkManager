package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.Order;

public class OrderMapper implements RowMapper<Order> {

	@Override
	public Order mapRow(ResultSet rss) {
		Order order = new Order();
		try {
			order.setId(rss.getInt("ID"));
			order.setEmployeeID(rss.getInt("EmployeeID"));
			order.setCreateDate(rss.getTimestamp("CreatedDate"));
			order.setTotal(rss.getDouble("Total"));
			return order;
		} catch (SQLException e) {
			System.out.println("Lỗi khi map Order :"+ e.getMessage());
			return null;
		}
		
	
	}

}
