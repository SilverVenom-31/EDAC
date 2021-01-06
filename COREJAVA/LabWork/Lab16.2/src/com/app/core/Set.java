//Created by @AkhilD on 24/12/2020.
package com.app.core;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.TreeSet;

public class Set {

	public static void main(String[] args) {
		
		
		String [] arr = {"Rama","Kiran","Shubham","Kaustubh","Sameer","Riya","Anish","Rama","Riya","Priya","Anuja"};
List<String > list = Arrays.asList(arr);

ListIterator<String> lIterator = list.listIterator();
System.out.println("Displaying using List Iterator: ");
 while(lIterator.hasNext()) {
	 System.out.print(lIterator.next()+" ");
 }

 HashSet<String> hashSet = new HashSet<>();
 
 hashSet.addAll(list);
 
 Iterator<String > itr = hashSet.iterator();
 System.out.println("\n\nDisplaying HashSet using Iterator");
 while(itr.hasNext()) {
	 System.out.print(itr.next()+ " ");
 }
 

 LinkedHashSet<String> LhashSet = new LinkedHashSet<>();
 
 LhashSet.addAll(list);
 
 Iterator<String > itr1 = LhashSet.iterator();
 System.out.println("\n\nDisplaying LinkedHashSet using Iterator");
 while(itr1.hasNext()) {
	 System.out.print(itr1.next()+ " ");
 }
 

 TreeSet<String> ThashSet = new TreeSet<>();
 
 ThashSet.addAll(list);
 
 Iterator<String > itr2 = ThashSet.iterator();
 System.out.println("\n\nDisplaying TreeSet using Iterator");
 while(itr2.hasNext()) {
	 System.out.print(itr2.next()+ " ");
 }
 
	}

}
