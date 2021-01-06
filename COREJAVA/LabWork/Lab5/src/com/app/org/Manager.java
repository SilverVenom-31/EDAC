//Created by @AkhilD on 11/12/2020.
package com.app.org;


public class Manager extends Employee {

	//---id,name,basic,deptId , perfBonus
	
	
	private double perfBonus;
	
	
	public Manager( int id, String  name, double basic, int deptId, double perfBonus) {
		super( id, name, deptId, basic);
		
		this.perfBonus = perfBonus;
		
		
	}

	public String toString () {
		return ("Manager Details: \n"+super.toString()+" Performance Bonus: "+perfBonus  ); 
	}
	
	public double computeNetSalary() {
		return super.getBasic()+perfBonus ;
	}

	
	public double getPerfBonus() {
		return perfBonus;
	}

	
	
}
