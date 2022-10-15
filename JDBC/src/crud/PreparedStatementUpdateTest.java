package crud;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Properties;

import org.junit.jupiter.api.Test;

import connection.ConnectionTest;
import util.JDBCUtil;

public class PreparedStatementUpdateTest {
	@Test
	public void testCommenUpdate() {
		String sql = "delete from users where id = ?";
		update(sql, 2);
	}

	public void update(String sql, Object... args) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JDBCUtil.getConnection();
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				ps.setObject(i + 1, args[i]);
			}
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeResource(conn, ps);
		}
	}

	@Test
	public void testUpdate() {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JDBCUtil.getConnection();
			String sql = "update users set name = ? where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setObject(1, "Mob");
			ps.setObject(2, 1);
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeResource(conn, ps);
		}
	}

	@Test
	public void testInsert() {
		// 获取链接
		Connection connection = null;
		PreparedStatement ps = null;
		try {
			// 读取配置文件中的信息
			InputStream resourceAsStream = ConnectionTest.class.getClassLoader().getResourceAsStream("jdbc.properties");
			Properties properties = new Properties();
			properties.load(resourceAsStream);
			String user = properties.getProperty("user");
			String url = properties.getProperty("url");
			String driverClass = properties.getProperty("driverClass");

			// 加载驱动
			Class.forName(driverClass);

			connection = DriverManager.getConnection(url, user, "");

			// 预编译 sql 语句，返回 PreparedStatement 的实例
			String sql = "insert into users(name, email, birth)values(?,?,?)";
			ps = connection.prepareStatement(sql);
			ps.setString(1, "Anna");
			ps.setString(2, "anna@gamil.com");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			java.util.Date parse = sdf.parse("1001-01-01");
			ps.setDate(3, new java.sql.Date(parse.getTime()));

			// 执行操作
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
