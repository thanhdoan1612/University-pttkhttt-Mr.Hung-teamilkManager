package model;

import java.util.List;

public class OrderDetail {
	private int id;
	private TeaMilk teaMilk;
	private int orderID;
	private int teaMilkID;
	private int quantity;
	private double total;
	private List<OrderToppingDetail> listToppingDetails;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<OrderToppingDetail> getListToppingDetails() {
		return listToppingDetails;
	}

	public void setListToppingDetails(List<OrderToppingDetail> listToppingDetails) {
		this.listToppingDetails = listToppingDetails;
	}

	public TeaMilk getTeaMilk() {
		return teaMilk;
	}

	public OrderDetail() {
		super();
	}

	public int getOrderID() {
		return orderID;
	}

	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}

	public int getTeaMilkID() {
		return teaMilkID;
	}

	public void setTeaMilkID(int teaMilkID) {
		this.teaMilkID = teaMilkID;
	}

	public void setTeaMilk(TeaMilk teaMilk) {
		this.teaMilk = teaMilk;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public void computeTotal() {

		this.total = quantity * teaMilk.getPrice();

	}

}
