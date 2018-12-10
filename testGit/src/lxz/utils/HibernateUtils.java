package lxz.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

	private static final SessionFactory SESSIONFACTORY;
	private static final Configuration CONFIG;

	// 通过静态代码块构建SessionFactory
	static {
		CONFIG = new Configuration().configure();
		SESSIONFACTORY = CONFIG.buildSessionFactory();
	}

	public static Session getSession() {
		return SESSIONFACTORY.openSession();
	}
}
