import java.util.Arrays;


// A top level class can be either public or default(no access specifier)
// A class name should start with upper case , followed by camel casing(recommended)
// If class is public, name of file should exactly match with class name
// In one file, we can not have more than one public class
// In one file, we can have multiple non public class
// instance variables, static variables, local variables
//Encapsulation : don't allow direct access to instance variable, instead provide public methods
public class Student {
	// instance variables(state)
	private int roll;
	private String name;
	private int marks[] = null;
	
	public Student(){
	}
	
	public Student(int roll, String name){
		this.roll = roll;
		this.name = name;
	}
	
	// instance methods(behaviours)
	public void setDetails(int roll, String name){
		this.roll = roll;
		this.name = name;
	}
	
	public void displayDetails(){
		System.out.println(roll +" "+ name +" "+ Arrays.toString(marks));
	}
	
	// Getters(accessors)
	public String getName(){
		return name;
	}
	
	public int getRoll(){
		return roll;
	}
	
	public int[] getMarks(){
		return marks;
	}
	
	// Setters(Mutators)
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setRoll(int roll){
		this.roll = roll;
	}
	
	public void setMarks(int[]  marks){
		this.marks = marks;
	}
	
	
}


