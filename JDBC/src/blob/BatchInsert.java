package blob;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import util.JDBCUtil;

/**
 * 使用 PrepareStatement 实现批量数据的操作
 * 
 * update/delete 本身就具有批量操作的效果 此时的批量操作，主要指的是批量插入。
 * 
 * 批量插入方式一：使用 Statement 每次插入都要执行一次 sql并进行磁盘IO，效率非常低
 * 
 * @author shizhiang
 *
 */
public class BatchInsert {
	// 批量插入方式二：使用 PrepareStatment，利用它预处理sql语句的能力
	@Test
	public void testBatchInsert1() {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			long startTime = System.currentTimeMillis();
			conn = JDBCUtil.getConnection();
			String sql = "insert into `goods` (name) value (?)";
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < 10000; i++) {
				ps.setObject(1, "name_" + i);
				ps.execute();
			}
			long endTime = System.currentTimeMillis();
			System.out.println("花费的时间为：" + (endTime - startTime)); // 4206
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeResource(conn, ps);
		}
	}

	/**
	 * 批量插入数据方式3: 
	 * 利用 MySQL 批处理 addBatch() executeBatch() clearBatch()
	 * 减少磁盘io次数
	 */
	@Test
	public void testBatchInsert2() {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			long startTime = System.currentTimeMillis();
			conn = JDBCUtil.getConnection();
			String sql = "insert into `goods` (name) value (?)";
			ps = conn.prepareStatement(sql);
			for (int i = 1; i <= 10000; i++) {
				ps.setObject(1, "name_" + i);
				
				// 攒 sql
				ps.addBatch();
				
				if (i % 500 == 0) {
					ps.executeBatch();
					ps.clearBatch();
				}
			}
			long endTime = System.currentTimeMillis();
			System.out.println("花费的时间为：" + (endTime - startTime)); // 3494
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeResource(conn, ps);
		}
	}
	
	/**
	 * 批量插入方式4: 不允许自动提交数据，减少磁盘io次数
	 */
	@Test
	public void testBatchInsert3() {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			long startTime = System.currentTimeMillis();
			conn = JDBCUtil.getConnection();
			conn.setAutoCommit(false);
			String sql = "insert into `goods` (name) value (?)";
			ps = conn.prepareStatement(sql);
			for (int i = 1; i <= 10000; i++) {
				ps.setObject(1, "name_" + i);
				
				// 攒 sql
				ps.addBatch();
				
				if (i % 500 == 0) {
					ps.executeBatch();
					ps.clearBatch();
				}
			}
			conn.commit();
			long endTime = System.currentTimeMillis();
			System.out.println("花费的时间为：" + (endTime - startTime)); // 1760
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeResource(conn, ps);
		}
	}
}
