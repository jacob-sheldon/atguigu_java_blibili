package connectionPool;

import java.sql.Connection;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Test {
	// 方式一：硬编码
	@Test
	public void testGetConnection() throws Exception {
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		cpds.setDriverClass( "com.mysql.jdbc.Driver" ); //loads the jdbc driver            
		cpds.setJdbcUrl( "jdbc:mysql://localhost/test" );
		cpds.setUser("root");       
		
		cpds.setInitialPoolSize(20);
		
		Connection conn1 = cpds.getConnection();
		System.out.println(conn1);
	}
	// 方式二：使用配置文件
	@Test
	public void testGetConnectionWithProperties() throws Exception {
		ComboPooledDataSource cpds = new ComboPooledDataSource("helloc3p0");
		Connection conn = cpds.getConnection();
		System.out.println(conn);
	}
}
