package utils_v2;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JDBCUtil {
	private static ComboPooledDataSource cpds = new ComboPooledDataSource("helloc3p0");

	public static Connection getConnection() throws Exception {
		Connection conn = cpds.getConnection();
		return conn;
	}

	public static Connection getConnectionDruid() throws Exception {
		Properties pros = new Properties();

		InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("druid.properties");
		pros.load(is);

		DruidDataSource source = (DruidDataSource) DruidDataSourceFactory.createDataSource(pros);
		DruidPooledConnection conn = source.getConnection();
		return conn;
	}
	
	public static void closeResource(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
