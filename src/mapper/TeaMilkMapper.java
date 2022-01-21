package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.TeaMilk;

public class TeaMilkMapper implements RowMapper<TeaMilk> {

	@Override
	public TeaMilk mapRow(ResultSet rss) {
		TeaMilk teaMilk = new TeaMilk();
		try {

			teaMilk.setId(rss.getInt("ID"));
			teaMilk.setName(rss.getString("Name"));
			teaMilk.setPrice(rss.getDouble("Price"));
			teaMilk.setUnit(rss.getString("Unit"));
			teaMilk.setCategoryId(rss.getInt("CategoryID"));
			teaMilk.setQuantity(rss.getInt("Quantity"));
			return teaMilk;
		} catch (SQLException e) {
			System.out.println("Lỗi khi map TeaMilk : " + e.getMessage());
			return null;
		}

	}

}
