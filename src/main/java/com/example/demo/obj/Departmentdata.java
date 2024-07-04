package com.example.demo.obj;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Department")

public class Departmentdata {
	@Id
	@GeneratedValue
	private int id;
	
	private String departmentname;
	private String specialdoctor;
	private String pid;
	public String getPid() {
		return pid;
	}
	public String getDepartmentname() {
		return departmentname;
	}
	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}
	public String getSpecialdoctor() {
		return specialdoctor;
	}
	public void setSpecialdoctor(String specialdoctor) {
		this.specialdoctor = specialdoctor;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}

	}


