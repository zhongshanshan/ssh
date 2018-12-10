package lxz.dao.impl;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate5.HibernateTemplate;

import lxz.dao.WorksDao;
import lxz.entity.User;
import lxz.entity.Works;

public class WorksDaopImpl implements WorksDao {

	static HibernateTemplate hibernateTemplate;
	static JdbcTemplate jdbcTemplate;
	static User user;
	private String sql;

	static {
		String path = "applicationContext.xml";
		ApplicationContext atc = new ClassPathXmlApplicationContext(path);
		// sessionFactory = (SessionFactory) atc.getBean("sessionFactory");
		// session = sessionFactory.openSession();
		hibernateTemplate = (HibernateTemplate) atc.getBean("hibernateTemplate");
		jdbcTemplate = (JdbcTemplate) atc.getBean("jdbcTemplate");
		user = (User) atc.getBean("user");
	}

	public static void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		WorksDaopImpl.hibernateTemplate = hibernateTemplate;
	}

	public static void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		WorksDaopImpl.jdbcTemplate = jdbcTemplate;
	}

	/**
	 * 添加作品：将从页面获得的works对象存到数据库
	 */
	@Override
	public Works addWorksByUser_id(Works works, String user_id) {
		// TODO Auto-generated method stub

		return null;
	}

	@Override
	public boolean deleteUserWorksByUser_idAndWorks_id(String user_id, String works_id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Works> findWorksListByUser_id(String user_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Works findWorksByWorks_id(String work_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Works updateWorksByUser_idAndWorks_id(Works works, String user_id, String works_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Works> findUnauditedWorksList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Works> findKeyWorksList(String key) {
		// TODO Auto-generated method stub
		return null;
	}

}
