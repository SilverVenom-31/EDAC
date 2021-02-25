package com.app.ui;

import com.app.core.StackImpLinkedList;

public class StackImplTester {

	public static void main(String[] args) {
		String str = "([{}])"; //  for not balanced "([}])"
		
		if(parenthesisBalance(str)) {
			System.out.println("Balanced");
		}else {
			System.out.println("Not balanced!!");
		}
			
	}
		
		

	public static boolean parenthesisBalance(String str) {
		StackImpLinkedList s = new StackImpLinkedList(str.length());

		for (int i = 0; i < str.length(); i++) {
			
			char c = str.charAt(i);
			if(c == '(' || c == '{' || c == '[') {
				s.push(c);
				continue;
			}
			
			if(s.isEmpty()) {
				System.out.println("Stack is Empty!!");
			}
			
			switch (c) { 
            case ')': 
                c = (char) s.pop(); 
                if (c == '{' || c == '[') 
                    return false; 
                break; 
  
            case '}': 
                c = (char) s.pop(); 
                if (c == '(' || c == '[') 
                    return false; 
                break; 
  
            case ']': 
                c = (char) s.pop(); 
                if (c == '(' || c == '{') 
                    return false; 
                break; 
            } 
        } 
  
        return (s.isEmpty()); 
		}
}


