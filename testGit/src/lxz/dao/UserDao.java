package lxz.dao;

import java.util.List;

import lxz.entity.User;

public interface UserDao {

	/**
	 * 添加用户：将从页面获得的user对象存到数据库
	 */
	public User addUser(User user);

	/**
	 * 查找用户_dao：通过user_phone查找user
	 */
	public User findUserByUser_phone(String user_phone);

	/**
	 * 删除用户_dao:将user_state的值设置成0
	 */
	public boolean deleteUserByUser_id(String user_phone);

	/**
	 * 超级管理员调用 查找所有用户_dao：查询未被删除的用户
	 */
	public List<User> findUser();

	/**
	 * 超级管理员调用 修改权限_dao:通过user_id查询到用户，然后将user_type改成要改的值
	 */
	public boolean changeType(String state, String user_id);

	/**
	 * 比对唯一字段user_name_dao：通过user_name查找user
	 * 
	 * @return 若该user_name不存在则返回true；若已存在则返回true。
	 */
	public boolean contrastUser_name(String user_name);

	/**
	 * 比对唯一字段user_email_dao：通过user_email查找user
	 * 
	 * @return 若该user_name不存在则返回true；若已存在则返回true。
	 */
	public boolean contrastUser_email(String user_email);

	/**
	 * 比对唯一字段user_phone_dao：通过user_phone查找user
	 * 
	 * @return 若该user_phone不存在则返回true；若已存在则返回true。
	 */
	public boolean contrastUser_phone(String user_phone);
}
