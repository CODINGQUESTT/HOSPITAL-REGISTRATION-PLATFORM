package com.example.demo.obj;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="MEDICALHISTORY")
public class Medicalhistorydata {
	@Id
	@GeneratedValue
	private int id;
	
	private String anydiagnosis;
	private String doctorname;
	private String pid;
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getAnydiagnosis() {
		return anydiagnosis;
	}
	public void setAnydiagnosis(String anydiagnosis) {
		this.anydiagnosis = anydiagnosis;
	}
	public String getDoctorname() {
		return doctorname;
	}
	public void setDoctorname(String doctorname) {
		this.doctorname = doctorname;
	}

}
