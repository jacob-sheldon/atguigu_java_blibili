package crud;

import java.io.File;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Iterator;

import org.junit.jupiter.api.Test;

import bean.User;
import util.JDBCUtil;

public class UserForQuery {
	
	@Test
	public void testQueryForUsers() {
		String sql = "select * from users where id = ?";
		User user = queryForUsers(sql, 1);
		System.out.println(user);
		
		String sql2 = "select * from users where name = ?";
		User user2 = queryForUsers(sql2, "Mob");
		System.out.println(user2);
	}
	
	public User queryForUsers(String sql, Object...args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet eq = null;
		try {
			// 建立连接
			conn = JDBCUtil.getConnection();
			// 预编译 sql
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				ps.setObject(i + 1, args[i]);
			}
			// 执行查询
			eq = ps.executeQuery();
			// ResultSetMetaData 是 ResultSet 的元数据
			// 使用 ResultSetMetaData 可以获取到关于查询结果的元信息，比如列数、列名
			ResultSetMetaData metaData = eq.getMetaData();
			int columnCount = metaData.getColumnCount();
			if (eq.next()) {
				User user = new User();
				for (int i = 0; i < columnCount; i++) {
					// 获取列值
					Object columnValue = eq.getObject(i + 1);
					// 获取列名
					String columnName = metaData.getColumnName(i + 1);
					// 使用反射来给对象赋值
					Field field = User.class.getDeclaredField(columnName);
					field.setAccessible(true);
					field.set(user, columnValue);
				}
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeResource(conn, ps, eq);
		}
		
		return null;
	}
	
	@Test
	public void testQuery1() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet res = null;
		try {
			conn = JDBCUtil.getConnection();
			String sql = "select * from users where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setObject(1, 1);
			res = ps.executeQuery();
			if (res.next()) {
				int id = res.getInt(1);
				String name = res.getString(2);
				String email = res.getString(3);
				Date birth = res.getDate(4);
				User user = new User(name, email, birth);
				System.out.println(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeResource(conn, ps, res);
		}
		
	}
}
