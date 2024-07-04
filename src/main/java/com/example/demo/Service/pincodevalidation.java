package com.example.demo.Service;

import java.util.ArrayList;

public class pincodevalidation {

	public boolean iscorrect(String pincode, ArrayList<String> pincodeList) {
		// TODO Auto-generated method stub
	    int b=Integer.parseInt(pincode);
	    if(b>0&&pincode.length()==5)
	    	for(String e1:pincodeList) {
	    		if(e1.equals(pincode))
	    		{
	    			return true;
	    		}
	    	}
	    	
		return false;
	}

}
