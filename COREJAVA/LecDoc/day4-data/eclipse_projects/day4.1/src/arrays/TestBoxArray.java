package arrays;

import java.util.Arrays;
import java.util.Scanner;

import com.app.cdac.Box;

public class TestBoxArray {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter no of boxes to make");
		Box[] boxes=new Box[sc.nextInt()];//10 : 1single array object will be created : inited with null refs.
	    System.out.println(Arrays.toString(boxes));
	    System.out.println("Name of the loaded class "+boxes);
		for(int i=0;i<boxes.length;i++)
		{
			System.out.println("Enter Box dims");
			boxes[i]=new Box(sc.nextDouble(), sc.nextDouble(), sc.nextDouble());
		}//how many objs : 1(array) + 10(box)
		//display details n volume
		
		
		for (Box s :boxes) {
			
			if (s.computeVolume() >100) {
			
				s.setWidth(s.getWidth()*2);		
			}
		}
		
		
		
		
		for(Box b : boxes) { //b=boxes[0],b=boxes[1]......b=boxes[boxes.length-1]
			System.out.println(b.getBoxDetails());
			System.out.println("Volume "+b.computeVolume());
		}
		//Arrays.toString
		System.out.println(Arrays.toString(boxes));
		sc.close();

	}

}
