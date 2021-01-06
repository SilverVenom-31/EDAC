package p1;

class A {
	private int i;// instance var : heap : inited to def value =0

	public static void main(String[] args) {
		int data = 100;// method local var stack : def : un inited
		// javac DOES NOT allow accessing any un inited vars
		// System.out.println(data);
		// display value of i
		A a1 = new A();
		System.out.println(a1.i);
		if (data == 100)
			System.out.println("yes");
		else
			System.out.println("no");
		char ch = 'A';
		System.out.println(ch);
		ch = 66;
		System.out.println(ch);
		// print range of bytes
		System.out.println("byte ranges from " + Byte.MIN_VALUE + "----" + Byte.MAX_VALUE);
		// print range of ints
		System.out.println("int ranges from " + Integer.MIN_VALUE + "----" + Integer.MAX_VALUE);

		System.out.println("in A's main");
	}
}

public class B {
	public static void main(String[] args) {
		System.out.println("in B's main");
	}
}

class C {
	public static void main(String[] args) {
		System.out.println("in C's main");
	}

}
