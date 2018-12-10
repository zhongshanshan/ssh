package lxz.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.orm.hibernate5.HibernateTemplate;

import lxz.dao.UserDao;
import lxz.entity.User;

@Transactional
public class UserDaoImpl implements UserDao {

	// static SessionFactory sessionFactory;
	// static Session session;
	static HibernateTemplate hibernateTemplate;
	static JdbcTemplate jdbcTemplate;
	static User user;
	private String sql;

	// public static void setSessionFactory(SessionFactory sf) {
	// sessionFactory = sf;
	// }

	public static void setJdbcTemplate(JdbcTemplate jt) {
		UserDaoImpl.jdbcTemplate = jt;
	}

	public static void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		UserDaoImpl.hibernateTemplate = hibernateTemplate;
	}

	public static void setUser(User u) {
		user = u;
	}

	static {
		String path = "applicationContext.xml";
		ApplicationContext atc = new ClassPathXmlApplicationContext(path);
		// sessionFactory = (SessionFactory) atc.getBean("sessionFactory");
		// session = sessionFactory.openSession();
		hibernateTemplate = (HibernateTemplate) atc.getBean("hibernateTemplate");
		jdbcTemplate = (JdbcTemplate) atc.getBean("jdbcTemplate");
		user = (User) atc.getBean("user");
	}

	/**
	 * 添加用户_dao：将从页面获得的user对象存到数据库
	 * 
	 * @return user对象
	 * @see org.lxz.dao.UserDao#addUser(org.lxz.entity.User)
	 */
	@Override
	public User addUser(User user) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(user);
		return user;
	}

	/**
	 * 查找用户_dao：通过user_phone查找user
	 * 
	 * @return user对象
	 */
	@Override
	public User findUserByUser_phone(String phone) {
		// TODO Auto-generated method stub
		sql = "select * from user where user_state = '0' and user_phone=?";
		try {
			user = jdbcTemplate.queryForObject(sql, new UserRowMapper(), phone);
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
		return user;
	}

	/**
	 * 比对唯一字段user_name_dao：通过user_name查找user
	 * 
	 * @return 若该user_name不存在则返回true；若已存在则返回true。
	 */
	@Override
	public boolean contrastUser_name(String name) {
		// TODO Auto-generated method stub
		sql = "select * from user where user_state = '1' and user_name=?";
		try {
			user = jdbcTemplate.queryForObject(sql, new UserRowMapper(), name);
		} catch (EmptyResultDataAccessException e) {
			return true;
		}
		return false;
	}

	/**
	 * 比对唯一字段user_phone_dao：通过user_phone查找user
	 * 
	 * @return 若该user_phone不存在则返回true；若已存在则返回true。
	 */
	@Override
	public boolean contrastUser_phone(String phone) {
		// TODO Auto-generated method stub
		sql = "select * from user where user_state = '1' and user_name=?";
		try {
			user = jdbcTemplate.queryForObject(sql, new UserRowMapper(), phone);
		} catch (EmptyResultDataAccessException e) {
			return true;
		}
		return false;
	}

	/**
	 * 比对唯一字段user_email_dao：通过user_email查找user
	 * 
	 * @return 若该user_name不存在则返回true；若已存在则返回true。
	 */
	// @Override
	public boolean contrastUser_email(String email) {
		// TODO Auto-generated method stub
		sql = "select * from user where user_state = '1' and user_email=?";
		try {
			user = jdbcTemplate.queryForObject(sql, new UserRowMapper(), email);
		} catch (EmptyResultDataAccessException e) {
			return true;
		}
		return false;
	}

	/**
	 * 删除用户_dao:将user_state的值设置成0
	 * 
	 * @return true:删除成功 false:删除失败
	 */
	@Override
	public boolean deleteUserByUser_id(String id) {
		// TODO Auto-generated method stub
		sql = "update user set user_state=0 where user_state = 1 and user_id=?";
		int row = jdbcTemplate.update(sql, id);
		if (row > 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 超级管理员调用 查找所有用户_dao：查询未被删除的用户
	 * 
	 * @return user对象
	 */
	@Override
	public List<User> findUser() {
		// TODO Auto-generated method stub
		sql = "select * from user where user_state = 1 ";
		List<User> userList = jdbcTemplate.query(sql, new UserRowMapper());
		return userList;
	}

	/**
	 * 超级管理员调用 修改权限_dao:通过user_id查询到用户，然后将user_type改成要改的值
	 * 
	 * @return true:修改成功 false:修改失败
	 */
	@Override
	public boolean changeType(String type, String id) {
		// TODO Auto-generated method stub
		sql = "update user set user_type=? where user_state = '1' and user_id=?";
		int row = jdbcTemplate.update(sql, type, id);
		if (row > 0) {
			return true;
		} else {
			return false;
		}
	}
}

/**
 * 将结果集封装成user对象
 */
class UserRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int num) throws SQLException {
		// TODO Auto-generated method stub
		String user_id = rs.getString(1);
		String user_birthday = rs.getString(2);
		String user_description = rs.getString(3);
		String user_email = rs.getString(4);
		String user_gender = rs.getString(5);
		String user_name = rs.getString(6);
		String user_password = rs.getString(7);
		String user_phone = rs.getString(8);
		String user_picpath = rs.getString(9);
		String user_state = rs.getString(10);
		String user_type = rs.getString(11);

		User user = new User();
		user.setUser_id(user_id);
		user.setUser_name(user_name);
		user.setUser_gender(user_gender);
		user.setUser_phone(user_phone);
		user.setUser_birthday(user_birthday);
		user.setUser_type(user_type);
		user.setUser_password(user_password);
		user.setUser_description(user_description);
		user.setUser_picpath(user_picpath);
		user.setUser_state(user_state);
		user.setUser_email(user_email);
		return user;
	}

}