package com.pojo;

public class Order {
	private Integer id;
	private Integer buserstable_id;
	private double amount;
	private Integer status;
	private String orderdate;
	@Override
	public String toString() {
		return "Order [id=" + id + ", buserstable_id=" + buserstable_id + ", amount=" + amount + ", status=" + status
				+ ", orderdate=" + orderdate + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getBuserstable_id() {
		return buserstable_id;
	}
	public void setBuserstable_id(Integer buserstable_id) {
		this.buserstable_id = buserstable_id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}
	
}
