package com.aug.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.aug.entity.Province;

public class ProvinceAction {

	public static void main(String args[]) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();

		session.beginTransaction();

		Province province = new Province("Trang");
		// session.save(province);

		session.get(Province.class, 1);

		session.getTransaction().commit();

		session.close();
	}

}
