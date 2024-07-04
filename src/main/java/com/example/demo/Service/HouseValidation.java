package com.example.demo.Service;

import java.util.ArrayList;

public class HouseValidation {

	public boolean ValidateHouseno( String houseno) {
		// TODO Auto-generated method stub
		//int c=Integer.parseInt(houseno);
		if(0 < houseno.length()&& houseno.length()<6) {
			return true;
		}
		return false;
	}

}
