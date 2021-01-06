import java.util.Scanner;

public class Maximum {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        System.out.print("How many numbers you want to enter:");
       int n = s.nextInt();
        int a[] = new int[n];
        System.out.println("Enter " + n + " numbers: ");
        for (int i = 0; i < n; i++) {
            a[i] = s.nextInt();
        }
        System.out.println("Maximum number is : "+MaxNum.getMax(a));

    }

}
