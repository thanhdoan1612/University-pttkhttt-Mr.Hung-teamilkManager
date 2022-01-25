package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.OrderToppingDetail;

public class OrderToppingDetailMapper implements RowMapper<OrderToppingDetail> {

	@Override
	public OrderToppingDetail mapRow(ResultSet rss) {
		OrderToppingDetail orderToppingDetail = new OrderToppingDetail();
		try {
			orderToppingDetail.setOrderDetailId(rss.getInt("OrderDetailID"));
			orderToppingDetail.setToppingId(rss.getInt("ToppingID"));

			return orderToppingDetail;
		} catch (SQLException e) {
			return null;
		}

	}

}
