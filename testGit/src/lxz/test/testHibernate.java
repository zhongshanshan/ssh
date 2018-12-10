package lxz.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import lxz.dao.UserDao;
import lxz.entity.User;

@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class testHibernate {
	@Autowired
	private UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Test
	public void testAdd() {
		User user = new User();
		// user.setUser_id("2234567891234567");
		user.setUser_name("tom");
		user.setUser_gender("女");
		user.setUser_phone("17307970133");
		user.setUser_birthday("1998-10-27");
		user.setUser_type("0");
		user.setUser_password("123456");
		user.setUser_description("hhh");
		user.setUser_picpath("");
		user.setUser_state("1");
		user.setUser_email("123");
		if (userDao.addUser(user) != null) {
			System.out.println("tests");
		} else {
			System.out.println("testf");
		}
	}

	@Test
	public void testfindUserByUser_phone() {
		System.out.println(userDao.findUserByUser_phone("17307970133"));
	}

	@Test
	public void testdeleteUserByUser_id() {
		System.out.println(userDao.deleteUserByUser_id("4028f8816787263b0167872645b40000"));
	}

	@Test
	public void testfindUser() {
		System.out.println(userDao.findUser());
	}

	@Test
	public void testchangeType() {
		System.out.println(userDao.changeType("1", "4028f8816787263b0167872645b40000"));
	}

	@Test
	public void testcontrastUser_name() {
		System.out.println(userDao.contrastUser_name("carry"));
	}
}
