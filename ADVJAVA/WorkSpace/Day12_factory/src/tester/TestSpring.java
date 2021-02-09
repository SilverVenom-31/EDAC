package tester;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import dependent.ATMImpl;

public class TestSpring {

	public static void main(String[] args) {
		try (ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("bean-config.xml")) {

			System.out.println("SC started");
			// invoke B.L
			// 1. get dependent bean : which is already located, loaded and instantiated
			ATMImpl atmImpl = ctx.getBean("my_atm", ATMImpl.class); // tester requesting SC to get bean
			atmImpl.deposit(1000);
			ATMImpl atmImpl2 = ctx.getBean("my_atm", ATMImpl.class);
			System.out.println(atmImpl == atmImpl2);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
