package org.building.blocks.vo;

import java.io.Serializable;
import java.time.Instant;

public class Bricks implements Serializable {

	private static final long serialVersionUID = 1L;

	private String orderId;
	private String orderName;
	private Instant orderCreationDate;
	private Instant orderModifiedDate;
	private int orderAmount;
	private int blocksQuantity;

	public Bricks() {
		super();
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public Instant getOrderCreationDate() {
		return orderCreationDate;
	}

	public void setOrderCreationDate(Instant orderCreationDate) {
		this.orderCreationDate = orderCreationDate;
	}

	public Instant getOrderModifiedDate() {
		return orderModifiedDate;
	}

	public void setOrderModifiedDate(Instant orderModifiedDate) {
		this.orderModifiedDate = orderModifiedDate;
	}

	public int getOrderAmount() {
		return orderAmount;
	}

	public void setOrderAmount(int orderAmount) {
		this.orderAmount = orderAmount;
	}

	public int getBlocksQuantity() {
		return blocksQuantity;
	}

	public void setBlocksQuantity(int blocksQuantity) {
		this.blocksQuantity = blocksQuantity;
	}

	@Override
	public String toString() {
		return "Bricks [orderId=" + orderId + ", orderName=" + orderName + ", orderCreationDate=" + orderCreationDate
				+ ", orderModifiedDate=" + orderModifiedDate + ", orderAmount=" + orderAmount + ", blocksQuantity="
				+ blocksQuantity + "]";
	}

}
