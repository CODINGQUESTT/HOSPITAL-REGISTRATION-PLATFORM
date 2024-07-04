package com.example.demo.Service;

import java.util.List;

import com.example.demo.obj.Personaldata;

public class PidValidation {

	public boolean validate(String pid, List<Personaldata> alldata) {
		// TODO Auto-generated method stub
		for(Personaldata i : alldata) {
			if(i.getPid().equals(pid)) {
				return true;
			}
		}
		return false;
	}

}
