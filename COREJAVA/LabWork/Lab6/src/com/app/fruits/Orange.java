//Created by @AkhilD on 13/12/2020.
package com.app.fruits;


public class Orange extends Fruits {

	public Orange(String name) {
		// TODO Auto-generated constructor stub
		super(name);
		
	}
	
	@Override
	 public void taste() {
		System.out.println(super.getName()+" Orange is sour in taste");
	}


}
