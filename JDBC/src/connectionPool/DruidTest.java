package connectionPool;

import java.io.InputStream;
import java.util.Properties;

import org.junit.Test;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.DruidPooledConnection;

public class DruidTest {
	@Test
	public void getConnection() throws Exception {
		Properties pros = new Properties();
		
		InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("druid.properties");
		pros.load(is);
		
		DruidDataSource source = (DruidDataSource) DruidDataSourceFactory.createDataSource(pros);
		DruidPooledConnection conn = source.getConnection();
		System.out.println(conn);
		source.close();
	}
	
}
