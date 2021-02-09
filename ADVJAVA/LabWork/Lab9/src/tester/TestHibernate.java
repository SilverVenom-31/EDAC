package tester;

import static utils.HibernateUtils.getSf;

import org.hibernate.SessionFactory;

public class TestHibernate {

	public static void main(String[] args) {
		
		try(SessionFactory factory = getSf()){
			System.out.println("hibernate Up: "+factory);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

}
