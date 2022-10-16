package crud;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import bean.Order;
import bean.User;
import util.JDBCUtil;

public class PreparedStatementQueryTest {
	
	@Test
	public void testForList() {
		String sql = "select id, name, email from `users` where id < ?";
		List<User> users = getForList(User.class, sql, 3);
		users.forEach(System.out::println);
		
		String sql1 = "select order_id orderId, order_name orderName from `orders`";
		List<Order> orders = getForList(Order.class, sql1);
		orders.forEach(System.out::println);
	}
	
	public <T> List<T> getForList(Class<T> clazz, String sql, Object...args) {
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
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			ArrayList<T> list = new ArrayList<>();
			while (rs.next()) {
				T obj = clazz.newInstance();
				for (int i = 0; i < columnCount; i++) {
					String columnLabel = rsmd.getColumnLabel(i+1);
					Object columnValue = rs.getObject(i+1);
					Field field = clazz.getDeclaredField(columnLabel);
					field.setAccessible(true);
					field.set(obj, columnValue);
				}
				list.add(obj);
			}
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeResource(conn, ps, rs);
		}
		
		return null;
	}
	
	@Test
	public void testGetInstance() {
		String sql = "select order_id orderId, order_name orderName, order_date orderDate from `orders` where order_id = ?";
		Order order = getInstance(Order.class, sql, 1);
		System.out.println(order);
		
		String sql1 = "select id, name, email from `users` where id = ?";
		User u = getInstance(User.class, sql1, 1);
		System.out.println(u);
	}
	
	/**
	 * 针对不同表的通用查询操作，返回表中的一条记录
	 * @param <T> 要查询的表对应的 Java 类
	 * @param clazz 要查询的表对应的 Java 类
	 * @param sql 要执行的 sql 语句
	 * @param args sql 语句中要被替换的占位符
	 * @return 查询出的一条记录对应类的实例
	 */
	public <T> T getInstance(Class<T> clazz, String sql, Object... args) {
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
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			if (rs.next()) {
				T obj = clazz.newInstance();
				for (int i = 0; i < columnCount; i++) {
					String columnLabel = rsmd.getColumnLabel(i+1);
					Object columnValue = rs.getObject(i+1);
					Field field = clazz.getDeclaredField(columnLabel);
					field.setAccessible(true);
					field.set(obj, columnValue);
				}
				return obj;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeResource(conn, ps, rs);
		}
		
		return null;
	}
}
