package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import model.Employee;

public class EmployeeMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rss) {
		Employee user = new Employee();
		try {
			user.setId(rss.getInt("ID"));
			user.setUsername(rss.getString("Username"));
			user.setFullOfName(rss.getString("FullOfName"));
			user.setPassword(rss.getString("Password"));
			user.setPhoneNumber(rss.getString("PhoneNumber"));
			user.setDateOfBirth(rss.getString("DateOfBirth"));
			user.setAdmin(rss.getBoolean("isAdmin"));
			return user;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Lỗi khi map User : " + e.getMessage());
			return null;
		}
	
	}

}
