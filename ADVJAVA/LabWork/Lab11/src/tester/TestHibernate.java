package tester;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import static utils.HibernateUtils.getSf;
public class TestHibernate {

	public static void main(String[] args) {
		
		try(SessionFactory factory = getSf()){
			System.out.println("Hibernate Up and running: Created Tables "+factory);
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
