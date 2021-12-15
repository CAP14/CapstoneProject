package com.gbs;

public class ClientApp {
	public static void main(String args[]) {
		UserClientApp.login(); //calls user microservice
		AccountClientApp.transferProcedure(); //calls the account microservice
		//update balance in users table
		UserClientApp.updateSenderBalance();
		UserClientApp.updateReceiverBalance();
		System.out.println("\n\t--END OF PROGRAM--");
	}
}
