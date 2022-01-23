package DAO;

import java.util.List;

import mapper.EmployeeMapper;
import mapper.TeaMilkMapper;
import model.Employee;
import model.TeaMilk;

public class EmployeeDAO extends AbstractDao implements IGenericDAO<Employee> {

	
	public boolean add(Employee t) {
		String sql = "INSERT INTO `employee`(`FullOfName`, `Username`, `Password`, `PhoneNumber`, `DateOfBirth`, `isAdmin`)"
				+ " VALUES (?,?,?,?,?,?)";
		return update(sql, t.getFullOfName(), t.getUsername(), t.getPassword(), t.getPhoneNumber(), t.getDateOfBirth(),
				t.isAdmin());
	}

	@Override
	public boolean update(Employee t) {
		String sql = "UPDATE `employee` SET `FullOfName`=?,`Username`=?,`Password`=?,`PhoneNumber`=?,`DateOfBirth`=?,`isAdmin`=? WHERE ID = ?";
		return update(sql, t.getFullOfName(), t.getUsername(), t.getPassword(), t.getPhoneNumber(), t.getDateOfBirth(),
				t.isAdmin(),t.getId());
	}

	public Employee findEmployeeByUsernameAndPassword(String username, String password) {
		String sql = "Select * from employee where Username = ? and Password =? ";
		return query(sql, new EmployeeMapper(), username, password).size() > 0
				? query(sql, new EmployeeMapper(), username, password).get(0)
				: null;
	}

	public List<Employee> search(String nameSearch, String value) {
		String sql = "Select * from employee where " + nameSearch + " LIKE '%" + value + "%'";
		;
		return query(sql, new EmployeeMapper());
	}

	@Override
	public List<Employee> findAll() {
		String sql = "select * from employee  where isDeleted = 0";
		return query(sql, new EmployeeMapper());
	}

	public Employee findById(int id) {
		String sql = "select * from employee  where ID = " + id;
		return query(sql, new EmployeeMapper()).isEmpty() ? null : query(sql, new EmployeeMapper()).get(0);
	}

	@Override
	public boolean delete(int id) {
		String sql = "Update employee set `isDeleted` = 1 where `ID` = ?";
		return update(sql, id);
	}

	@Override
	public Long save(Employee t) {
		String sql = "INSERT INTO `employee`(`FullOfName`, `Username`, `Password`, `PhoneNumber`, `DateOfBirth`, `isAdmin`)"
				+ " VALUES (?,?,?,?,?,?)";
		return add(sql, t.getFullOfName(), t.getUsername(), t.getPassword(), t.getPhoneNumber(), t.getDateOfBirth(),
				t.isAdmin());
	}

}
