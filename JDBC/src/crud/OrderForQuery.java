package crud;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import org.junit.jupiter.api.Test;

import bean.Order;
import util.JDBCUtil;

public class OrderForQuery {
	/**
	 * 对于表的字段名和类的属性名不相同的情况
	 * 1. 必须声明 sql 时，使用类的属性名来命名字段的别名
	 * 2. 使用 ResultSetMetaData时，需要使用 getColumnLabel() 来替换 getColumnName() 来获取列的别名。
	 * 说明：如果 sql 中没有给字段起别名，getColumnLabel() 获取的就是列名。
	 */
	@Test
	public void testQueryForOrder() {
		String sql = "select order_id orderId, order_name orderName, order_date orderDate from orders where order_id = ?";
		Order order = queryForOrder(sql, 1);
		System.out.println(order);
	}

	public Order queryForOrder(String sql, Object... args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtil.getConnection();
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				ps.setObject(i + 1, args[i]);
			}
			rs = ps.executeQuery();
			ResultSetMetaData metaData = rs.getMetaData();
			int columnCount = metaData.getColumnCount();
			if (rs.next()) {
				Order order = new Order();
				for (int i = 0; i < columnCount; i++) {
					String columnName = metaData.getColumnLabel(i + 1);
					Object columnValue = rs.getObject(i + 1);
					Field field = Order.class.getDeclaredField(columnName);
					field.setAccessible(true);
					field.set(order, columnValue);
				}
				return order;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeResource(conn, ps, rs);
		}

		return null;
	}

	@Test
	public void orderQuery1() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JDBCUtil.getConnection();
			String sql = "select * from orders where order_id = ?";
			ps = conn.prepareStatement(sql);
			ps.setObject(1, "1");
			rs = ps.executeQuery();
			if (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				Date date = rs.getDate(3);
				Order order = new Order(id, name, date);
				System.out.println(order);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		JDBCUtil.closeResource(conn, ps, rs);
	}
}
