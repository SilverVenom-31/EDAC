package notes;

//final is a keyword in java
//once final variable is initialized, it cannot be modified
//Method can also me final... and final Method cannot be overriden
//Class can also be final... it cannot be inherited
//it cannot have child class


public class FinalKeywordDemo {

	public static void main(String[] args) {
		int x = 10;
		x = x + 1;
		System.out.println(x);

		final int y;
		y = 100;
		// y++;//CE
	}

}
