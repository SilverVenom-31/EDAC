import java.util.Scanner;

class simpleInterest {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter principal: ");
        double principal = scan.nextDouble();

        System.out.print("Enter rate: ");
        double rate = scan.nextDouble();

        System.out.print("Enter years: ");
        double years = scan.nextDouble();

        double SI = (principal * rate * years) / 100;
        System.out.println("Simple Interest= " + SI);

    }
}