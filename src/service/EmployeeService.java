package service;

import java.util.List;

import DAO.EmployeeDAO;
import mapper.EmployeeMapper;
import model.Employee;

public class EmployeeService implements IGenericService<Employee> {
	private EmployeeDAO employeeDAO;
	public EmployeeService(){
		this.employeeDAO=new EmployeeDAO();
	}
	public Employee login(String username,String password) {
		return employeeDAO.findEmployeeByUsernameAndPassword(username, password);
	}
	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return employeeDAO.findAll();
	}
	@Override
	public boolean add(Employee t) {
		// TODO Auto-generated method stub
		return employeeDAO.add(t);
	}
	public boolean delete(Employee t) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return employeeDAO.delete(id);
	}
	@Override
	public List<Employee> search(String nameSearch, String value) {
		// TODO Auto-generated method stub
		return employeeDAO.search(nameSearch, value);
	}
	
	public Employee findByID(int id) {
		return employeeDAO.findById(id);
	}
	@Override
	public boolean update(Employee t) {
		// TODO Auto-generated method stub
		return employeeDAO.update(t);
	}


}

