package com.example.demo.Service;

import java.util.ArrayList;

public class cityvalidation {

	public boolean ValidateCity(String city, ArrayList<String> cityList) {
		for(String e2:cityList)
			
			if(e2.equalsIgnoreCase(city))
			{
				return true;
			}
		// TODO Auto-generated method stub
		return false;
	}

}
