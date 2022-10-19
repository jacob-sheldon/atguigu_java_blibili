package dao;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

import bean.User;

public interface UserDao {
	/**
	 * 插入一个新用户
	 * @param conn
	 * @param user
	 */
	void insert(Connection conn, User user);
	
	/**
	 * 删除指定id的用户
	 * @param conn
	 * @param uid
	 */
	void deleteById(Connection conn, int uid);
	
	/**
	 * 根据user.id更新用户信息
	 * @param conn
	 * @param user
	 */
	void update(Connection conn, User user);
	
	/**
	 * 根据用户id获取用户信息
	 * @param conn 
	 * @param uid
	 * @return
	 */
	User getUserById(Connection conn, int uid);
	
	/**
	 * 返回用户表中所有内容
	 * @param conn
	 * @return
	 */
	List<User> getAll(Connection conn);
	
	/**
	 * 返回用户表条数
	 * @param conn
	 * @return
	 */
	Long getCount(Connection conn);
	
	/**
	 * 返回用户表中最大的birth
	 * @return
	 */
	Date getMaxBirth(Connection conn);
}
