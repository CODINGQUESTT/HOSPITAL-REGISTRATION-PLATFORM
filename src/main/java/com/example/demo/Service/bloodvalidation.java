package com.example.demo.Service;

import java.util.ArrayList;

public class bloodvalidation {

	public boolean validatebloodgroup(ArrayList<String> bloodList, String bg) {
		
		// TODO Auto-generated method stub
		for(String eachdata:bloodList) {
			if(eachdata.equalsIgnoreCase(bg)) {
				return true;
			}
		}
		return false;
	}

}
