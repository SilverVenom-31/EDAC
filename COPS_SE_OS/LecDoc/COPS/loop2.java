package notes;

public class LoopDemo2 {

	public static void main(String[] args) {
		for (int i = 1; i <= 3; i++) {
			for (int j = 1; j <= 3; j++) {
				System.out.println(i + " " + j);
				if(i+j==4) break;
			}
			System.out.println();
		}
		System.out.println("main ends");
	}

}
