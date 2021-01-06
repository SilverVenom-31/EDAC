//Created by Akhil Darge on 3/10/20.

public class EmployeeInfo {
    public static void main(String args[]) {

        Employee emp1 = new Employee();
        emp1.detailsFillup("Robert", 1994, 20000, "64C-WallStreet");
        Employee emp2 = new Employee();
        emp2.detailsFillup("Sam", 2000, 22000, "68D-WallStreet");
        Employee emp3 = new Employee();
        emp3.detailsFillup("John", 1999, 25000, "26B-WallStreet");
        
        System.out.println("Name" + "     " + "Year of Joining" + "     " + "Address" + "        " + "Salary");
        System.out.printf("%s %10d %22s %10s", emp1.name, emp1.yearOfJoining, emp1.address, emp1.salary);
        System.out.printf("\n%s %13d %22s %10s", emp2.name, emp2.yearOfJoining, emp2.address, emp2.salary);
        System.out.printf("\n%s %12d %22s %10s", emp3.name, emp3.yearOfJoining, emp3.address, emp3.salary);

    }
}

