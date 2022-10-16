package transaction;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import util.JDBCUtil;

/**
 * 1. 什么叫数据库事务？
 * 事务：一组逻辑操作单元，是数据从一种状态变换到另一种状态。
 * 		> 一组逻辑操作单元：一个或多个DML操作
 * 
 * 2. 事务处理的原则：保证所有事务都作为一个工作单元来执行，即时出现了故障，都不能改变这种执行方式。
 * 	当在一个事务中执行多个操作时，要么所有操作都被提交（commit），那么这些修改就被永久地保存了。
 * 	要么数据库事务管理系统将放弃所做的所有修改，整个事务回滚（rollback）到最初状态。
 * 
 * 3. 数据一旦提交，就不可回滚。
 * 
 * 4. 哪些操作会导致数据的自动提交？
 * 		> DDL操作一旦执行，都会被自动提交。
 * 			> set autocommit = false 对 DDL 操作无效
 * 		> DML 默认情况下，一旦执行，就会自动提交。
 * 			> 可以通过 set autocommit = false 的方式取消 DML 操作的自动提交。
 * 		> 默认在关闭连接时，会自动提交操作。
 * @author shizhiang
 *
 */
public class TransactionTest {

	@Test
	public void testUpdateData() {
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
			conn.setAutoCommit(false);
			String sql = "update `user_bank` set balance=? where id=?";
			updateData(conn, sql, 900, 1);
			
			String sql2 = "update `user_bank` set balance=? where id=?";
			updateData(conn, sql2, 1100, 2);

			conn.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeResource(conn, null);
		}
	}

	public void updateData(Connection conn, String sql, Object... args) {
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				ps.setObject(i + 1, args[i]);
			}
			ps.execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeResource(null, ps);
		}
	}
}
