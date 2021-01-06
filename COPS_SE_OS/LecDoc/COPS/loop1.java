package notes;

//break : come out from the loop/switch from the inner loop(incase of nested)
//continue : skip the remaining statement and start inner/ loop again
//both break and continue can be used be labels in java

public class LoopDemo {

	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++) {
			// 1------- print till 5
			//System.out.println(i);
			// if (i == 5)
			// break;
			
			// 2------ 
			if (i % 2 == 0)//if even continue
				continue;//(will print odd numbers and skip even)
			System.out.println(i);
		}
		System.out.println("Outside the loop");
	}

}
