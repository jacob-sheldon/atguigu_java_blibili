package connectionPool;

import java.beans.PropertyVetoException;
import java.sql.Connection;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Test {
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
}
