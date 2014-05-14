package com.aug.action;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.aug.entity.District;
import com.aug.entity.Province;

public class DistrictAction {

	District district;
	Session session;

	public DistrictAction() {
		district = new District();
		SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(District.class)
				.addAnnotatedClass(Province.class).buildSessionFactory();
		session = sessionFactory.openSession();
	}

	public static void main(String[] args) {
		DistrictAction districtAction = new DistrictAction();

		// districtAction.addDistrict(districtAction.district);
		districtAction.findDistrict(districtAction.district);

		districtAction.session.close();
	}

	public void addDistrict(District district) {
		session.beginTransaction();

		district.setDistrictName("qwer");
		district.setProvince((Province) session.get(Province.class, 1));

		session.save(district);
		session.getTransaction().commit();
	}

	public void findDistrict(District district) {
		District asdf = (District) session.get(District.class, 1);
		System.out.println(asdf.getProvince().getProvinceName());
	}

}
