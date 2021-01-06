package utils;

import java.util.HashMap;

import com.app.core.BankAccount;
import static java.time.LocalDate.parse;

import java.time.LocalDate;

import custom_exception.AccountHandlingException;

public class BankValidationRules {
	public static double MIN_BALANCE;
	static {
		MIN_BALANCE = 1000;
	}

	// add a static method for validating balance
	public static double validateBalance(double balance) throws AccountHandlingException {
		if (balance < MIN_BALANCE)
			throw new AccountHandlingException("A/C Overdrawn!!!!!!");
		return balance;
	}

	public static void statusCheck(HashMap<Integer, BankAccount> hashMap)  {

		for (BankAccount s : hashMap.values()) {

			if (s.gettDate().isBefore(LocalDate.now().minusMonths(6))) {
				s.setStatus("INACTIVE");
			} else {
				s.setStatus("ACTIVE");
			}

		}

	}

}
