//Created by @AkhilD on 24/02/2021
package com.app.core;

public interface StackInterface {
	
	// Push the number on stack.
	  public void push(int elem); 

	  // Return the topmost element and remove it from stack.
	  public int pop();

	  // Return the topmost element without removing it from stack.
	  public int top(); 
	  // Handle the scenario if this function is called when stack is empty. (2 Marks)

	  // Return true if stack is empty else false.
	  public boolean isEmpty(); 

	  // Return true if stack is full else false.
	  public boolean isFull(); 

}
