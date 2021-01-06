

class average {
    public static void main(String args[]) {


        if (args.length < 3) {
            System.out.println("Please enter 3 numbers");

        } else if (args.length > 3) {
            System.out.println("Please enter only 3 numbers");
        } else {

            int num1 = Integer.parseInt(args[0]); // converting string to int
            int num2 = Integer.parseInt(args[1]);
            int num3 = Integer.parseInt(args[2]);

            System.out.println("Average=" + (num1 + num2 + num3) / 3);
            System.exit(0);
        }

    }
}
