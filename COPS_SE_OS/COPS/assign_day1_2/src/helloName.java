import java.util.Scanner;

class helloName {
    public static void main(String args[]) {

        Scanner scan = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scan.nextLine();              //scanning the input
        System.out.println("Hello " + name);

    }
}