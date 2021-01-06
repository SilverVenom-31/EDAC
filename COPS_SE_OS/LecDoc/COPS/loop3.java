package notes;

public class LoopDemo3 {

	public static void main(String[] args) {
		OUTER://label
		for (int i = 1; i <= 3; i++) {
			for (int j = 1; j <= 3; j++) {
				System.out.println(i + " " + j);
				if (i + j == 4)
					break OUTER;//break with label
					// it will break the outer label
			}
			System.out.println();
		}
		System.out.println("main ends");
	}

}
