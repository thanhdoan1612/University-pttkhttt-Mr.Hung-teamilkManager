package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import DAO.TeaMilkDAO;
import model.OrderDetail;
import model.TeaMilk;

public class OrderDetailMapper implements RowMapper<OrderDetail> {

	@Override
	public OrderDetail mapRow(ResultSet rss) {
		OrderDetail orderDetail = new OrderDetail();
		try {
			orderDetail.setOrderID(rss.getInt("OrderID"));
			orderDetail.setTeaMilkID(rss.getInt("TeamilkID"));
			orderDetail.setQuantity(rss.getInt("Quantity"));
			orderDetail.setTotal(rss.getDouble("Total"));
			return orderDetail;
		} catch (SQLException e) {
			System.out.println("Lỗi khi map OrderDetail : " + e.getMessage());
			return null;
		}

	}

}
