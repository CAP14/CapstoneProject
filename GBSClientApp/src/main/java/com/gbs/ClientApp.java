package com.gbs;

import com.gbs.service.AccountClientApp;
import com.gbs.service.UserClientApp;

public class ClientApp {
	public static void main(String args[]) {
		UserClientApp.login(); // calls user microservice
		if (UserClientApp.correctLogin == true) {
			AccountClientApp.transferProcedure(); // calls the account microservice
			// update balance in users table
			UserClientApp.updateSenderBalance();
			UserClientApp.updateReceiverBalance();
		}else {
			System.out.println("\n\tIncorrect Credentials!");
		}
		System.out.println("\n\t--END OF PROGRAM--");
	}
}
