import java.util.Scanner;

class factorial {
    public static void main(String args[]) {

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter any number: ");
        int num = scan.nextInt();
        int fact = 1;

        for (int i = 1; i <= num; i++) {
            fact = fact * i;
        }
        System.out.println("Factorial is: " + fact);
    }
}