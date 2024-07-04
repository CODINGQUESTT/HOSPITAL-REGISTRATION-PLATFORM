package com.example.demo.Service;

import java.util.ArrayList;

public class anydiagnosisvalidation {

	public boolean validatedig(ArrayList<String> dignosedwith, String anydiagnosis) {
		// TODO Auto-generated method stub
		for(String e3:dignosedwith) {
			if(e3.equalsIgnoreCase(anydiagnosis)) {
				return true;
			}
			
		}
		return false;
	}

}
