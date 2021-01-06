import java.util.Scanner;

class salary {

    public static void main(String args[]) {

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter your basic salary: ");
        double basic = scan.nextInt();

        double hra = (40 * basic) / 100;
        double pf = (12 * basic) / 100;
        double salary = basic + hra + 1200 + 800 - 300 - pf;
        System.out.println("Monthly salary = " + salary);

    }
}
