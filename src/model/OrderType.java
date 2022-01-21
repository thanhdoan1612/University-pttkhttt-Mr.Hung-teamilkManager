package model;

public enum OrderType {
	LOCAL("local","Tại chỗ"),
//	ONLINE("online","Đặt hàng online"),
	BRINGAWAY("bringaway","Mang về");
	private String id;
	private String type;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	private OrderType(String id, String type) {
		this.id = id;
		this.type = type;
	}
	public static OrderType findByID(String id) {
		for(OrderType o: values()) {
			if(o.getId().equals(id)) return o;
		}
		return null;
	}
}
