package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.*;

public class SetConstantValue {

	public void setGender(ArrayList<String> genderList) {
		// TODO Auto-generated method stub
		genderList.add("MALE");
		genderList.add("FEMALE");
		genderList.add("OTHER");
			
	}

	public void setbloodgroup(ArrayList<String> bloodList) {
		// TODO Auto-generated method stub
		bloodList.add("o+ve");
		bloodList.add("ab-ve");
		bloodList.add("b+ve");
		bloodList.add("ab+ve");
		
	}

	public void setpincode(ArrayList<String> pincodeList, Object pincode1) {
		// TODO Auto-generated method stub
		String jsonStr = pincode1.toString();
	      ObjectMapper objectMapper = new ObjectMapper();
	      try {
	         List<String> countries = objectMapper.readValue(jsonStr, List.class);
	         for(String i : countries) {
	        	 pincodeList.add(i);
	         }
	      } catch(Exception e) {
	         e.printStackTrace();
	      }
		
	         
		
		
	}

	public void setcity(ArrayList<String> cityList, Object cityname) {
		// TODO Auto-generated method stub
		
		String jsonStr = cityname.toString();
	      ObjectMapper objectMapper = new ObjectMapper();
	      try {
	         List<String> countries = objectMapper.readValue(jsonStr, List.class);
	         for(String i : countries) {
	        	 cityList.add(i);
	         }
	      } catch(Exception e) {
	         e.printStackTrace();
	      }
		
	         
		
	}

	public void setdiagnosedwith(ArrayList<String> dignosedwith, Object diagnosedwith_json) {
		// TODO Auto-generated method stub
		String jsonStr = diagnosedwith_json.toString();
	      ObjectMapper objectMapper = new ObjectMapper();
	      try {
	         List<String> diag = objectMapper.readValue(jsonStr, List.class);
	         for(String i : diag) {
	        	 dignosedwith.add(i);
	         }
	      } catch(Exception e) {
	         e.printStackTrace();
	      }
		
	}

	public void setdepartmentname(ArrayList<String> departmentList, Object department_json) {
		// TODO Auto-generated method stub
		String jsonStr = department_json.toString();
	      ObjectMapper objectMapper = new ObjectMapper();
	      try {
	         List<String> dept = objectMapper.readValue(jsonStr, List.class);
	         for(String i : dept) {
	        	 departmentList.add(i);
	         }
	      } catch(Exception e) {
	         e.printStackTrace();
		
	       }	
}
}


