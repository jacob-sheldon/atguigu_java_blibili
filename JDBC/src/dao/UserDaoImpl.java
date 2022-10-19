package dao;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

import bean.User;

public class UserDaoImpl extends BaseDAO implements UserDao {

	@Override
	public void insert(Connection conn, User user) {
		String sql = "insert into users (name,birth) values (?, ?)";
		update(conn, sql, user.getId(), user.getBirth());
	}

	@Override
	public void deleteById(Connection conn, int uid) {
		String sql = "delete from users where id = ?";
		update(conn, sql, uid);
	}

	@Override
	public void update(Connection conn, User user) {
		String sql = "update customers set name = ?, birth = ? where id = ?";
		update(conn, sql, user.getName(), user.getBirth(), user.getId());
	}

	@Override
	public User getUserById(Connection conn, int uid) {
		String sql = "select id, name, birth from users where id = ?";
		return query(conn, User.class, sql, uid);
	}

	@Override
	public List<User> getAll(Connection conn) {
		String sql = "select id, name, birth from ";
		return queryForList(conn, User.class, sql);
	}

	@Override
	public Long getCount(Connection conn) {
		String sql = "select count(*) from users";
		return queryAny(conn, sql);
	}

	@Override
	public Date getMaxBirth(Connection conn) {
		String sql = "select max(birth) from users";
		return queryAny(conn, sql);
	}

}
