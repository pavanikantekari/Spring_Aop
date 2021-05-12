package com.ojas.app.bussinesslogic;

import org.springframework.stereotype.Component;

@Component
public class BussinessLogic {
	 
	public void saveEmployee() {
		System.out.println("Employee Save");
		//Arthimetic Exception
		int num = 10/0;
	}

}
