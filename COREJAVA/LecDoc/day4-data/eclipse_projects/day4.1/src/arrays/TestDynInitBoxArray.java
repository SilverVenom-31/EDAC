package arrays;

import com.app.cdac.Box;

public class TestDynInitBoxArray {

	public static void main(String[] args) {
		Box[] sample= {new Box(1,2,3),new Box(8, 9, 10)};//1 + 2
		for(Box b : sample)
			System.out.println(b.getBoxDetails());
	//	System.out.println(this); : javac error
		

	}

}
