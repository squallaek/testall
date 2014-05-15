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
	District district;

	public ProvinceAction() {
		province = new Province();
		district = new District();
		SessionFactory sessionFactory = new Configuration().configure().addAnnotatedClass(Province.class)
				.addAnnotatedClass(District.class).buildSessionFactory();
		session = sessionFactory.openSession();
	}

	public static void main(String[] args) {
		ProvinceAction provinceAction = new ProvinceAction();

		// provinceAction.province.setProvinceName("wasdf");
		// provinceAction.addProvince(new Province(), "aaaabbbsssss");
		// provinceAction.updateProvince(provinceAction.province);
		// provinceAction.deleteProvince(provinceAction.province);
		// provinceAction.findProvincefromId(provinceAction.province);

		// Province province1 = (Province)
		// provinceAction.session.get(Province.class, 10);
		// System.out.println(province1);

		provinceAction.showDistrictOfProvince(provinceAction.province);

		// provinceAction.addDistrictAndProvinceId(provinceAction.district);
		//
		// provinceAction.findAllProvince(provinceAction.province);
		provinceAction.session.close();
	}

	public void showDistrictOfProvince(Province province) {
		Province provinces = (Province) session.get(Province.class, 10);
		List<District> districts = provinces.getDistrict();

		System.out.println("Province :" + provinces.getProvinceName());
		for (District keepDistrict : districts) {
			System.out.println("District : " + keepDistrict.getDistrictName());
		}
	}

	public void addDistrictAndProvinceId(District district) {
		session.beginTransaction();
		district.setDistrictName("Hyodyod4");
		district.setProvince((Province) session.get(Province.class, 10));
		session.save(district);
		session.getTransaction().commit();
	}

	public void addProvince(Province province, String name) {
		session.beginTransaction();
		province.setProvinceName(name);
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
