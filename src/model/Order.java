package model;

import java.sql.Timestamp;
import java.util.List;

public class Order extends Model {
	private int id;
	private int employeeID;
	private List<OrderDetail> listOrderDetail;
	private double total;
	private Timestamp createDate;
	private Employee employee;
	


	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	
	@Override
	public String toString() {
		return "Order [id=" + id + ", employeeID=" + employeeID + ", listOrderDetail=" + listOrderDetail + ", total="
				+ total + "]";
	}
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	public List<OrderDetail> getListOrderDetail() {
		return listOrderDetail;
	}
	public void setListOrderDetail(List<OrderDetail> listOrderDetail) {
		this.listOrderDetail = listOrderDetail;
	}
	public Order() {}
	@Override
	public Object[] toRowTable() {
		// TODO Auto-generated method stub
		return new Object[] {this.getId(),this.getEmployee().getFullOfName(),this.getTotal(),this.getCreateDate()};
	}


}
