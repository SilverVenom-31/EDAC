//Created by Akhil Darge on 1/10/20.

import java.util.Scanner;


public class tempConv {

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Choose the option");
        System.out.println("1 : calculate celsius");
        System.out.println("2 : calculate the fehranite");
        int option = scan.nextInt();

        System.out.println("Enter the value you want to convert");
        double input = scan.nextDouble();
        tempConv param = new tempConv();
        param.handleConversion(option, input);

        scan.close();
    }


    public double handleConversion(int option, double input) {
        double result = 0.0;
        if (option == 1) {

            calculateCelcius(input);
        } else if (option == 2) {
            calculateFeranite(input);
        } else {
            System.out.println("Selected option is invalid");
            System.exit(0);
        }
        return result;
    }


    private void calculateFeranite(double input) {
        double fahrenheit = (input * 9 / 5) + 32;
        System.out.println("Fahrenheit= " + fahrenheit);
    }

    private void calculateCelcius(double input) {
        double celcius = ((input - 32) * 5) / 9;
        System.out.println("Celcius= " + celcius);

    }

}
