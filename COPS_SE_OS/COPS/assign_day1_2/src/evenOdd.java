import java.util.Scanner;

class evenOdd {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter any number: ");
        int num = scan.nextInt();

        int number = num % 2;
        if (number != 0) {
            System.out.println("Number is Odd number");
        } else {
            System.out.println("Number is Even number");

        }

    }
}