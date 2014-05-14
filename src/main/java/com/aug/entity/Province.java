package com.aug.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
// tell a hibernate, this class is a table
@Table(name = "PROVINCE")
// Name to display in database
public class Province {

	@Id
	// private Integer id is a id and primary key
	@GeneratedValue
	// read in database and increasement it
	@Column(name = "ID")
	// set a column name in a database
	private Integer id;

	@Column(name = "PROVINCE_NAME", nullable = false, unique = true)
	private String provinceName;

	public Integer getId() {
		return id;
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
