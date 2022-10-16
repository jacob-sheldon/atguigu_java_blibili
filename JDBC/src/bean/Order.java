package bean;

import java.sql.Date;

/**
 * ORM 编程思想（Object Relationship Mapping）
 * 一个数据表对应一个 Java 类
 * 表中的一条记录对应 java 类的一个对象
 * 表中的一个字段对应 java 类中的一个属性
 * @author shizhiang
 *
 */
public class Order {
	private int orderId;
	private String orderName;
	private Date orderDate;

	public Order() {
		super();
	}

	public Order(int orderId, String orderName, Date orderDate) {
		super();
		this.orderId = orderId;
		this.orderName = orderName;
		this.orderDate = orderDate;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderName=" + orderName + ", orderDate=" + orderDate + "]";
	}

}
