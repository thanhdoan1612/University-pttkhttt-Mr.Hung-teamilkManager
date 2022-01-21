package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.Category;

public class CategoryMapper implements RowMapper<Category> {

	@Override
	public Category mapRow(ResultSet rss) {
		Category category = new Category();
		try {
			category.setID(rss.getInt("ID"));
			category.setName(rss.getString("Name"));
			return category;
		} catch (SQLException e) {
			System.out.println("Lỗi khi map category :" +e.getMessage());
			return null;
		}
		
	}

}
