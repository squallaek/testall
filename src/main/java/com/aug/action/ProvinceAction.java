package com.aug.action;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;

import com.aug.entity.District;
import com.aug.entity.Province;

public class ProvinceAction {

	Session session;
	Province province;

	public ProvinceAction() {
		province = new Province();
		SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Province.class)
				.addAnnotatedClass(District.class).buildSessionFactory();
		session = sessionFactory.openSession();
	}

	public static void main(String[] args) {
		ProvinceAction provinceAction = new ProvinceAction();

		// provinceAction.province.setProvinceName("wasdf");
		// provinceAction.addProvince(provinceAction.province);
		// provinceAction.updateProvince(provinceAction.province);
		// provinceAction.deleteProvince(provinceAction.province);
		// provinceAction.findProvincefromId(provinceAction.province);

		provinceAction.findAllProvince(provinceAction.province);
		provinceAction.session.close();
	}

	public void addProvince(Province province) {
		session.beginTransaction();
		// province.setProvinceName("asdf");
		session.save(province);
		session.getTransaction().commit();
	}

	public void updateProvince(Province province) {
		session.beginTransaction();
		province = (Province) session.get(Province.class, 1);
		province.setProvinceName("kornkodgayyyyy");
		session.update(province);
		session.getTransaction().commit();
	}

	public void deleteProvince(Province province) {
		session.beginTransaction();
		province = (Province) session.get(Province.class, 4);
		session.delete(province);
		session.getTransaction().commit();
	}

	public void findProvincefromId(Province province) {
		session.beginTransaction();
		List<Province> provinces = session.createCriteria(Province.class).list();
		System.out.println(provinces.get(1).getProvinceName());
	}

	public void findAllProvince(Province province) {
		List<Province> provinces = session.createQuery("from Province").list();

		for (Province dataKeep : provinces) {
			System.out.println(dataKeep.getProvinceName());
		}
	}

	public void display() {

	}

	// provinceAction.addProvince(new Province("wwwwwwaaaaa"));
	// provinceAction.addProvince(new Province("a;sldjkf"));
	// province = (Province) provinceAction.session.get(Province.class, 1);

}
