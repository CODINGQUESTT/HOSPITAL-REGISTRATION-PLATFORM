package com.example.demo.Service;

public class ParentValidation {

	public boolean validateparent(String gname) {
		// TODO Auto-generated method stub
		 char[] ch = gname.toCharArray();
		 for(char i : ch) {
			 if(Character.isDigit(i))
				 return false;
		 }
		
		return true;
	}
	

}
