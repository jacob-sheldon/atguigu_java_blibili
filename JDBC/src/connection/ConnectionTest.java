package connection;

import org.junit.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionTest {
	@Test
	public void testConnection1() throws SQLException {
		// 使用 mysql 驱动初始化JDBC驱动器
		Driver driver = new com.mysql.cj.jdbc.Driver();

		String url = "jdbc:mysql://localhost:3306/test";
		Properties info = new Properties();
		info.setProperty("user", "root");
		Connection conn = driver.connect(url, info);
		System.out.println(conn);
	}

	@Test
	public void testConnection2() throws Exception {
		// 使用 mysql 驱动初始化JDBC驱动器
		@SuppressWarnings("rawtypes")
		Class clazz = Class.forName("com.mysql.cj.jdbc.Driver");
		Driver driver = (Driver) clazz.newInstance();

		String url = "jdbc:mysql://localhost:3306/test";
		Properties info = new Properties();
		info.setProperty("user", "root");
		Connection conn = driver.connect(url, info);
		System.out.println(conn);
	}

	@Test
	public void testConnection3() throws Exception {
		// 提供连接信息
		String url = "jdbc:mysql://localhost:3306/test";
		String user = "root";
		String password = null;

		// 加载Driver
		// Driver 类中的static 代码块会在类加载时自动加载Driver
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection(url, user, password);
		System.out.println(conn);
	}

	@Test
	public void testConnection4() throws Exception {
		// 读取配置文件中的信息
		InputStream resourceAsStream = ConnectionTest.class.getClassLoader().getResourceAsStream("jdbc.properties");
		Properties properties = new Properties();
		properties.load(resourceAsStream);
		String user = properties.getProperty("user");
		String url = properties.getProperty("url");
		String driverClass = properties.getProperty("driverClass");
		
		// 加载驱动
		Class.forName(driverClass);
		
		// 获取链接
		Connection connection = DriverManager.getConnection(url, user, "");
		System.out.println(connection);
	}
}
