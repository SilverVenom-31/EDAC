//Created by Akhil Darge on 3/10/20.
public class Employee {
    String name;
    int yearOfJoining;
    double salary;
    String address;

    int detailsFillup(String name, int yearOfJoining, double salary, String address) {
        this.name = name;
        this.yearOfJoining = yearOfJoining;
        this.salary = salary;
        this.address = address;
        return 0;
    }

}
