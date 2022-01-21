package model;

public class TeaMilk extends Model {
	private int id;
	private String name;
	private double price;
	private int categoryId;
	private String unit;
	private int quantity;
	public TeaMilk(String name, double price, String unit) {
		super();
		this.name = name;
		this.price = price;
		this.unit = unit;
	}
	public String getName() {
		return name;
	}
	public TeaMilk() {
		super();
	}
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	@Override
	public Object[] toRowTable() {
		// TODO Auto-generated method stub
		return new Object[] {this.getId(),this.getName(),this.getPrice(),this.getCategoryId(),this.getUnit(),this.getQuantity()};
	}
}
