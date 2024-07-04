package com.example.demo.Service;

public class Agevalidation {

	public boolean ispositive(String age) {
		// TODO Auto-generated method stub
	    int a=Integer.parseInt(age);
	    if(a>0&&a<110)
	    	return true;
		return false;
	}

}
