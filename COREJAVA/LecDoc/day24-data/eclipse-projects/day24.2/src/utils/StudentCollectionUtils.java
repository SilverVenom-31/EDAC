package utils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.time.LocalDate.*;
import static com.app.core.Subject.*;

import com.app.core.Address;
import com.app.core.Student;

public class StudentCollectionUtils {
	private static int index=0;
	public static List<Student> populateList() {
		 List<Student> students = Arrays.asList(
				new Student("dbda-001", "ravi",parse("1990-12-13"), DBT, 7),
				new Student("dbda-009", "riya",parse("1992-12-13"), ML, 6.9),
				new Student("dbda-004", "shekhar",parse("1991-12-13"), DBT, 8.9),
				new Student("dbda-002", "priya",parse("1990-02-23"), JAVA, 4),
				new Student("dbda-007", "kiran",parse("1993-02-13"), R, 4.1),
				new Student("dbda-003", "meeta",parse("1993-12-13"), R, 5.9),
				new Student("dbda-008", "sameer",parse("1991-12-06"), DBT, 5)
				);
		 List<Address> adrs=Arrays.asList(new Address("pune", "MH", "452446"),
				 new Address("pune", "MH", "652446"),
				 new Address("nagpur", "MH", "852446"),
				 new Address("indore", "MP", "752446"),
				 new Address("mumbai", "MH", "672446"),
				 new Address("pune", "MH", "692446"),
				 new Address("chennai", "TN", "862446"));
		
		 //ano inner class or lambda expression CAN NOT access non final method local variables
		 //BUT they can access non final : static or instance vars
		 students.forEach(s->s.assignAddress(adrs.get(index++)));
		 return students;//method rets populated list of students , linked with adr , to the caller
	}
	//add a static method to populate details in a map
	public static Map<String,Student> populateMap(List<Student> students)
	{
		HashMap<String,Student> map=new HashMap<>();
		students.forEach(s->map.put(s.getRollNo(), s));
		//for testing display the map
		map.forEach((k,v) -> System.out.println(v));
		return map;
	}
}
