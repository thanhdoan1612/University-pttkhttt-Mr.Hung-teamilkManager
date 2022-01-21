package model;

import java.sql.Date;

public class Employee extends Model {
	private int id;
	private String username;
	private String password;
	private String fullOfName;
	private String dateOfBirth;
	private String phoneNumber;
	private boolean isAdmin;
	public Employee() {
	
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Employee(String username, String password, String fullOfName, String dateOfBirth, String phoneNumber,
			boolean isAdmin) {
		super();
		this.username = username;
		this.password = password;
		this.fullOfName = fullOfName;
		this.dateOfBirth = dateOfBirth;
		this.phoneNumber = phoneNumber;
		this.isAdmin = isAdmin;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullOfName() {
		return fullOfName;
	}
	public void setFullOfName(String fullOfName) {
		this.fullOfName = fullOfName;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", username=" + username + ", password=" + password + ", fullOfName=" + fullOfName
				+ ", dateOfBirth=" + dateOfBirth + ", phoneNumber=" + phoneNumber + ", isAdmin=" + isAdmin + "]";
	}

	@Override
	public Object[] toRowTable() {
		// TODO Auto-generated method stub
		return new Object[] {this.getId(),this.getFullOfName(),this.getUsername(),this.getPassword(),this.getDateOfBirth(),this.getPhoneNumber()};
	}
	
}
