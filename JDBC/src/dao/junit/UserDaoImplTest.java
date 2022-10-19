package dao.junit;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

import org.junit.jupiter.api.Test;

import bean.User;
import dao.UserDaoImpl;
import util.JDBCUtil;

class UserDaoImplTest {

	private UserDaoImpl ud = new UserDaoImpl();

	@Test
	void testInsert() {
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
			User u = new User(0, "BB", "bb@qq.com", new Date(234232234L));
			ud.insert(conn, u);
			System.out.println("添加成功");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeResource(conn, null);
		}
	}

	@Test
	void testDeleteById() {
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
			ud.deleteById(conn, 4);
			System.out.println("删除成功");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeResource(conn, null);
		}
	}

	@Test
	void testUpdateConnectionUser() {
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
			User u = new User(5, "AB", "ab@qq.com", new Date(2342432178L));
			ud.update(conn, u);
			System.out.println("更新成功");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeResource(conn, null);
		}
	}

	@Test
	void testGetUserById() {
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
			User u = ud.getUserById(conn, 5);
			System.out.println(u);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeResource(conn, null);
		}
	}

	@Test
	void testGetAll() {
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
			List<User> list = ud.getAll(conn);
			list.forEach(System.out::println);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeResource(conn, null);
		}
	}

	@Test
	void testGetCount() {
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
			Long count = ud.getCount(conn);
			System.out.println("user表总的数据条数为：" + count);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeResource(conn, null);
		}
	}

	@Test
	void testGetMaxBirth() {
		Connection conn = null;
		try {
			conn = JDBCUtil.getConnection();
			Date maxBirth = ud.getMaxBirth(conn);
			System.out.println("users表最大的生日为：" + maxBirth);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.closeResource(conn, null);
		}
	}

}
