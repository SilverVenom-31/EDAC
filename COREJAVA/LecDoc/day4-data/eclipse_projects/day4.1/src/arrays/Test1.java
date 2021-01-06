package arrays;

import java.util.Arrays;

public class Test1 {

	public static void main(String[] args) {
		double[] values=new double[10];
		//display array contents
		System.out.println("def array contents");
		for(double a : values)
			System.out.println(a);
		//init array contents : 1,2,3,...10
		int counter=1;
		for(double d : values) //d=values[0],d=values[1]....
			d=counter++;
		System.out.println("inited array contents ");
		for(double a : values) 
			System.out.println(a);
		for(int i=0;i<values.length;i++)
			values[i]=(i+1)*10;
		System.out.println("inited array contents again ");
		for(double a : values) 
			System.out.println(a);
		//display array contents using toString method of  java.util.Arrays class
		//API : public static String toString(double[] data)
		System.out.println("Array contents via Arrays.toString");
		
		System.out.println(Arrays.toString(values));
	
		

	}

}
