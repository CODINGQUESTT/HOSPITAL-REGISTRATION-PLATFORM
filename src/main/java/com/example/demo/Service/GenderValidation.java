package com.example.demo.Service;

import java.util.ArrayList;

public class GenderValidation {

	public boolean validateGender(ArrayList<String> genderList, String gender) {
		// TODO Auto-generated method stub
		for(String eachdata: genderList) {
			if(eachdata.equalsIgnoreCase(gender)) {
				return true;
			}
		}
		return false;
	}

}
