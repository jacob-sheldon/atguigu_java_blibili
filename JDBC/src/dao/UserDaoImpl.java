package dao;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

import bean.User;

public class UserDaoImpl extends BaseDAO<User> implements UserDao {

	@Override
	public void insert(Connection conn, User user) {
		String sql = "insert into users (name, email, birth) values (?, ?, ?)";
		update(conn, sql, user.getName(), user.getEmail(), user.getBirth());
	}

	@Override
	public void deleteById(Connection conn, int uid) {
		String sql = "delete from users where id = ?";
		update(conn, sql, uid);
	}

	@Override
	public void update(Connection conn, User user) {
		String sql = "update users set name = ?, birth = ?, email = ? where id = ?";
		update(conn, sql, user.getName(), user.getBirth(), user.getEmail(), user.getId());
	}

	@Override
	public User getUserById(Connection conn, int uid) {
		String sql = "select id, name, email, birth from users where id = ?";
		return query(conn, sql, uid);
	}

	@Override
	public List<User> getAll(Connection conn) {
		String sql = "select id, name, email, birth from users";
		return queryForList(conn, sql);
	}

	@Override
	public Long getCount(Connection conn) {
		String sql = "select count(*) from users";
		return (Long) queryAny(conn, sql);
	}

	@Override
	public Date getMaxBirth(Connection conn) {
		String sql = "select max(birth) from users";
		return (Date) queryAny(conn, sql);
	}

}
