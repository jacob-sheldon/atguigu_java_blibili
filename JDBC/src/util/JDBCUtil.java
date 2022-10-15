package util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import connection.ConnectionTest;

/**
 * 
 * @Description 操作数据库的工具类
 * @author shizhiang
 * @version
 * @date
 *
 */
public class JDBCUtil {
	/**
	 * 获取数据库链接
	 * 
	 * @return
	 * @throws Exception
	 */
	public static Connection getConnection() throws Exception {
		// 读取配置文件中的信息
		InputStream resourceAsStream = ClassLoader.getSystemClassLoader().getResourceAsStream("jdbc.properties");
		Properties properties = new Properties();
		properties.load(resourceAsStream);
		String user = properties.getProperty("user");
		String url = properties.getProperty("url");
		String driverClass = properties.getProperty("driverClass");

		// 加载驱动
		Class.forName(driverClass);

		Connection connection = DriverManager.getConnection(url, user, "");
		return connection;
	}

	/**
	 * 关闭链接和Statement
	 * 
	 * @param conn
	 * @param ps
	 */
	public static void closeResource(Connection conn, Statement ps) {
		try {
			if (ps != null)
				ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 关闭资源，Connection Statement ResultSet
	 * 
	 * @param conn
	 * @param ps
	 * @param rs
	 */
	public static void closeResource(Connection conn, Statement ps, ResultSet rs) {
		try {
			if (ps != null)
				ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		try {
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
