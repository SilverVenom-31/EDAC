package tester;

import static utils.HibernateUtils.getSf;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.StudentDaoImpl;
import pojos.AadharCard;
import pojos.EducationType;
import pojos.EducationalQual;
import pojos.Student;

public class AdmissionWithAadhar {

	public static void main(String[] args) {

		try (SessionFactory factory = getSf(); Scanner sc = new Scanner(System.in)) {
//and educational Qual:  type,year, grade and course id
			StudentDaoImpl sDao = new StudentDaoImpl();
			System.out.println("Enter student name,email,aadhar card no,creation date ");
			Student s = new Student(sc.next(), sc.next());
			s.setAadharCard(new AadharCard(sc.next(), LocalDate.parse(sc.next())));
			boolean exit = false;
			while (!exit) {
				System.out.println("1.Educational\n2.exit");
				switch (sc.nextInt()) {
				case 1:
					System.out.println("\nEnter Educational Qual:type,year, grade ");
					s.getEducationalQuals().add(new EducationalQual(EducationType.valueOf(sc.next().toUpperCase()),
							sc.next(), sc.nextDouble()));
					break;
				case 2:
					exit = true;
					break;
				default:
					System.out.println("Try again");
					break;
				}
			}
			System.out.println("enter course ID");
			System.out.println(sDao.admitStudentWithAC(s, sc.nextInt()));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
