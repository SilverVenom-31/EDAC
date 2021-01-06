//Created by @AkhilD on 14/12/2020.
package com.app.tester;

import java.util.Scanner;
import com.app.bank.BankAccount;
import com.app.bank.CurrentAccount;
import com.app.bank.LoanAccount;
import com.app.bank.SavingAccount;

public class BankAccTester {
//TODO: Exception handling in process.
	/* Note: Application is not user friendly, strictly binded with protocols. */
	// Warning: Do not try to run this application in absence of its creator.
	// Help: Incase stuck immediately contact its creator.

	static {
		BankAccount.id = 1;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		BankAccount[] arr = new BankAccount[100];
		int index = 0, id = 0;
		boolean status = false;
		while (true) {

			System.out.println(
					"\n1.Open Account\n2.Fetch Account Details\n3.Compute Income Tax\n4.Withdraw Amount\n5.Deposit Amount\n6.Display all Customers\n7.Apply Interest\n8.Display Loan Details\n9.Exit\n\nChoose any one option: ");

			switch (sc.nextInt()) {
			case 1:
				while (!status) {
					System.out.println(
							"\n1.Saving Account\n2.Current Account\n3.Loan Account\n4.Go back to Main options\n\nChoose any one option");
					switch (sc.nextInt()) {
					case 1:
						System.out.println("Enter Customer Name and current balance");
						arr[index] = new SavingAccount(sc.next(), sc.nextDouble());
						index++;

						break;
					case 2:
						System.out.println("Enter Customer Name and current balance");
						arr[index] = new CurrentAccount(sc.next(), sc.nextDouble());
						index++;

						break;
					case 3:
						System.out.println("Enter Customer Name and current balance and installments and EMI");
						arr[index] = new LoanAccount(sc.next(), sc.nextDouble(), sc.nextInt(), sc.nextDouble());
						index++;

						break;
					case 4:
						System.out.println("\nTaking you back to main options");
						status = true;
						break;

					default:
						System.out.println("Invalid Option: Please choose again");
						break;
					}
				}

				continue;
			case 2:
				System.out.println("Enter Account Number");
				id = sc.nextInt();
				for (int i = 0; i < arr.length; i++) {
					if (arr[i] != null) {
						if (arr[i].getAccNo() == id) {
							System.out.println(arr[i].toString());
						}
					}
				}

				continue;
			case 3: // while applying compute interest on saving SI is calculated with setting
					// default years to 1 if not initiated;
				System.out.println("Enter Account Number");
				id = sc.nextInt();
				for (int i = 0; i < arr.length; i++) {
					if (arr[i] != null) {
						if (arr[i].getAccNo() == id) {
							System.out.println("Account number: " + arr[i].getAccNo() + " Income Tax: "
									+ arr[i].computeIncomeTax());
						}
					}
				}

				continue;
			case 4:
				System.out.println("Enter Account Number and withdrawal amount");
				id = sc.nextInt();
				double amt = sc.nextDouble();
				for (int i = 0; i < arr.length; i++) {
					if (arr[i] != null) {
						if (arr[i].getAccNo() == id) {
							if (arr[i].getBalance() > amt) {
								((BankAccount) arr[i]).withdraw(amt);
								System.out.println(((BankAccount) arr[i]).toString());
							} else {
								System.out.println("Sorry not enough balance");
							}
						}
					}
				}

				continue;
			case 5:
				System.out.println("Enter Account Number and Deposit amount");
				id = sc.nextInt();
				for (int i = 0; i < arr.length; i++) {
					if (arr[i] != null) {
						if (arr[i].getAccNo() == id) {
							((BankAccount) arr[i]).deposit(sc.nextDouble());
							System.out.println(((BankAccount) arr[i]).toString());
						}
					}
				}
				continue;
			case 6:
				for (int i = 0; i < arr.length; i++) {
					if (arr[i] != null) {
						System.out.println(arr[i].toString());
					}
				}
				continue;
			case 7:
				System.out.println("Enter Account Number and years to apply Interest");
				int years = sc.nextInt();
				for (int i = 0; i < arr.length; i++) {
					if (arr[i] != null) {

						if (arr[i] instanceof SavingAccount) {
							((SavingAccount) arr[i]).applyInterest(years);

							System.out.println(((SavingAccount) arr[i]).toString("Savings"));
						}

					}
				}
				break;
			case 8:
				System.out.println("Enter Account Number");
				id = sc.nextInt();
				for (int i = 0; i < arr.length; i++) {
					if (arr[i] != null) {
						if (arr[i].getAccNo() == id) {
							if (arr[i] instanceof LoanAccount) {

								System.out.println(((LoanAccount) arr[i]).displayLoanDetails());
							}
						}
					}
				}
				break;
			case 9:
				System.out.println("Good Bye!!!");
				sc.close();
				System.exit(0);
				break;

			default:
				System.out.println("Option invalid: Please choose again");
				continue;
			}

		}

	}

}
