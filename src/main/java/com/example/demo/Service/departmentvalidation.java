package com.example.demo.Service;

import java.util.ArrayList;

public class departmentvalidation {
	

	public boolean validatedig(ArrayList<String> departmentList, String departmentname) {
		// TODO Auto-generated method stub
		for(String e4:departmentList) {
			if(e4.equalsIgnoreCase(departmentname)) {
				return true;
			}
		}
		return false;
	}

}
