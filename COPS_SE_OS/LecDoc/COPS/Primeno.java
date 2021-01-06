import java.util.Scanner;


// Display prime numbers between 1 and 100 or 1 and n
public class PrimeNumber {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter number to which prime number need to be checked");
		int n = scan.nextInt();
		
		System.out.println("Prime numbers between 1 and "+ n +" is : ");
		
		long start = System.currentTimeMillis();
		
		for(int i=1; i<=n;i++){
			if(isPrime(i)){
				System.out.print(i+",");
			}
		}
		
		long end = System.currentTimeMillis();
		System.out.println("\nTime elapsed(ms)=" + (end-start));
		
		scan.close();
		
	}
	
	// 17 = 2,3,4,5,6,7,8,9,10,11,12,13,14,15,16
	
	public static boolean isPrime(int num){
		// logic to check if given number is prime or not
		// if num is divided by any number from 2 to num-1,its not PRIME
		// else it is prime
		
		if(num == 1){
			return false;
		}
		
		for(int i=2;i<Math.sqrt(num);i++){
			if(num % i == 0){
				return false;
			}
		}
		
		return true;
	}

}











