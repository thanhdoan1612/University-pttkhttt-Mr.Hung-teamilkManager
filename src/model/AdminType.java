package model;

public enum AdminType {
	ADMIN(true, "Quản trị"), EMPLOYEE(false, "Nhân viên");

	private boolean isAdmin;
	private String type;

	private AdminType(boolean isAdmin, String type) {
		this.isAdmin = isAdmin;
		this.type = type;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public static AdminType findByType(String type) {
		for (AdminType aType : AdminType.values()) {
			if (aType.getType().equals(type))
				return aType;
		}
		return null;
	}

	public static AdminType findByIsAdmin(boolean isAdmin) {
		if (isAdmin)
			return ADMIN;
		return EMPLOYEE;
	}
}
