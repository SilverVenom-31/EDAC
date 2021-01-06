//Created by @AkhilD on 13/12/2020.
package com.app.fruits;


public class Cherry extends Fruits {

	public Cherry(String name) {
		// TODO Auto-generated constructor stub
		super(name);
		
	}
	
	@Override
	 public void taste() {
		System.out.println(super.getName()+" Cherry is sweet and sour in taste");
	}


}
