package transaction;

import java.sql.Connection;

import org.junit.jupiter.api.Test;

import util.JDBCUtil;

public class ConnectionTest {
	@Test
	public void testConnection() throws Exception {
		Connection conn = JDBCUtil.getConnection();
		System.out.println(conn);
	}
}
