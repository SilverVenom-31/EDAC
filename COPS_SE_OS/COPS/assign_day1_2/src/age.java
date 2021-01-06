import java.util.Scanner;

class age {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter your age: ");
        int age = scan.nextInt();
        if (age < 18) {
            System.out.println("You are not eligible for voting");
        } else {
            System.out.println("You are eligible for voting");

        }
    }
}