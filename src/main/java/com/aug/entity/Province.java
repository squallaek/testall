package com.aug.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PROVINCE")
public class Province {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Integer id;

	@Column(name = "PROVINCE_NAME", nullable = false, unique = true)
	private String provinceName;

	@OneToMany(mappedBy = "province")
	private List<District> district;

	public List<District> getDistrict() {
		return district;
	}

	public void setDistrict(List<District> district) {
		this.district = district;
	}

	public Integer getId() {
		return id;
	}

	public Province() {

	}

	@Override
	public String toString() {
		return "Province [id=" + id + ", provinceName=" + provinceName + ", district=" + district + "]";
	}

	public Province(String provinceName) {
		this.provinceName = provinceName;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProvinceName() {
		return provinceName;
	}

	public void setProvinceName(String provinceName) {
		this.provinceName = provinceName;
	}
}
