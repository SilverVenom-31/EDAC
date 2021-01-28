package com.app.tester;

import java.util.Scanner;

import com.app.dao.AccountDaoImpl;

public class TestStoredProc {

	public static void main(String[] args) {
		
		try (Scanner sc = new Scanner(System.in)){
			AccountDaoImpl dao = new AccountDaoImpl();
			System.out.println("Enter src accno, dest accno. and amount");
			System.out.println(dao.transferFunds(sc.nextInt(), sc.nextInt(), sc.nextDouble()));
			dao.cleanUp();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
