package tester;

import static utils.HibernateUtils.getSf;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.VendorDaoImpl;
import pojos.AccountType;
import pojos.BankAccounts;
import pojos.Location;
import pojos.PaymentDetails;
import pojos.PaymentMode;
import pojos.Vendors;

public class RegisterVendorLocPaym {

	public static void main(String[] args) {

		try (SessionFactory factory = getSf(); Scanner sc = new Scanner(System.in)) {
			VendorDaoImpl vDao = new VendorDaoImpl();
			System.out.println("Enter vendor  name,  email,  password,  regAmount, regDate");
			Vendors v = new Vendors(sc.next(), sc.next(), sc.next(), sc.nextDouble(), LocalDate.parse(sc.next()));
			System.out.println("Enter 1st Account details: acc type and balance");
			BankAccounts b1 = new BankAccounts(AccountType.valueOf(sc.next().toUpperCase()), sc.nextDouble());
			System.out.println(b1);
			v.addAccount(b1);
			System.out.println("Enter 2nd Account details: acc type and balance");
			BankAccounts b2 = new BankAccounts(AccountType.valueOf(sc.next().toUpperCase()), sc.nextDouble());
			v.addAccount(b2);

			// accept location details
			System.out.println("enter location: city,state,country");
			Location l = new Location(sc.next(), sc.next(), sc.next());
			l.setCurrentVendor(v);

			// accept payment term/details
			System.out.println("Enter payment details: mode, date,amount");
			v.setPaymentDetails(new PaymentDetails(PaymentMode.valueOf(sc.next().toUpperCase()),
					LocalDate.parse(sc.next()), sc.nextDouble()));

			System.out.println(vDao.registerVendorWithLoc(l));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
