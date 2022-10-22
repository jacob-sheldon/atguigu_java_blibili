package dbutils;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.junit.jupiter.api.Test;

import bean.User;
import utils_v2.JDBCUtil;

public class QueryRunnerTest {
	@Test
	public void testInsert() {
		Connection conn = null;
		try {
			QueryRunner qr = new QueryRunner();
			conn = JDBCUtil.getConnectionDruid();
			String sql = "insert into `users` (name, email, birth) values (?, ?, ?)";
			int effectRows = qr.update(conn, sql, "jack", "jack@gmail.com", "1993-11-12");
			System.out.println("影响到了 " + effectRows + " 行");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeResource(conn);
		}
	}
	
	@Test
	public void testQuery() {
		Connection conn = null;
		try {
			QueryRunner qr = new QueryRunner();
			conn = JDBCUtil.getConnectionDruid();
			String sql = "select id, name, email, birth from users where id = ?";
			BeanHandler<User> beanHandler = new BeanHandler<>(User.class);
			User u = qr.query(conn, sql, beanHandler, 1);
			System.out.println(u);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeResource(conn);
		}
	}
	
	@Test
	public void testQueryList() {
		Connection conn = null;
		try {
			QueryRunner qr = new QueryRunner();
			conn = JDBCUtil.getConnection();
			String sql = "select id, name, email, birth from users where id < ?";
			BeanListHandler<User> beanListHandler = new BeanListHandler<>(User.class);
			List<User> users = qr.query(conn, sql, beanListHandler, 10);
			users.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeResource(conn);
		}
	}
	
	@Test
	public void testQueryMap() {
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
			String sql = "select id, name, email, birth from users where id = ?";
			MapHandler mapHandler = new MapHandler();
			QueryRunner qr = new QueryRunner();
			Map<String, Object> rest = qr.query(conn, sql, mapHandler, 3);
			System.out.println(rest);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeResource(conn);
		}
	}
	
	/**
	 * 自定义handler进行查询操作
	 */
	@Test
	public void testQueryCustomHandler() {
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
			String sql = "select id, name, email, birth from users where id = ?";
			// 匿名接口实现类
			ResultSetHandler<User> handler = new ResultSetHandler<User>() {
				@Override
				public User handle(ResultSet rs) throws SQLException {
					ResultSetMetaData metaData = rs.getMetaData();
					int columnCount = metaData.getColumnCount();
					if (rs.next()) {
						User u = new User();
						for (int i = 0; i < columnCount; i++) {
							String columnLabel = metaData.getColumnLabel(i + 1);
							Object columnValue = rs.getObject(i + 1);
							Field field;
							try {
								field = User.class.getDeclaredField(columnLabel);
								field.setAccessible(true);
								field.set(u, columnValue);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
						return u;
					}
					return null;
				}
			};
			QueryRunner qr = new QueryRunner();
			User u = qr.query(conn, sql, handler, 3);
			System.out.println(u);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeResource(conn);
		}
	}
}
