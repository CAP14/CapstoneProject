package com.gbs;

import java.util.List;
import java.util.Scanner;

import org.springframework.web.client.RestTemplate;

import com.gbs.models.UserLogin;
import com.gbs.stub.UserLoginResponse;


public class UserClientApp {
	static String senderAccInfo, receiverAccInfo;
	static float senderNewBal;
	static float receiverNewBal;
	public static boolean correctLogin = false;
	
	public static void main(String args[]) {
//		login();
	}
	//method for login
	public  void login() {
		
		RestTemplate userLoginRestTemplate = new RestTemplate();
		final String restApiUrlString = "http://localhost:8081/ecz/user/userLoginResponse";
		UserLoginResponse userLoginResponse = userLoginRestTemplate.getForObject(restApiUrlString,
				UserLoginResponse.class);

		char option = '\0';
		Scanner scanner = new Scanner(System.in);
		System.out.println("\n\n##############################################");
		System.out.println("Welcome to BNK Global Banking Solutions!");
		System.out.println("\n");
		System.out.println("[L] : LOGIN");
		System.out.println("[X] : Exit The System");


		System.out.println("Enter Your Option:\t");
		option = scanner.nextLine().charAt(0);
		option = Character.toUpperCase(option);
		System.out.println("##############################################\n\n");
		switch (option) {

		case 'L':
			System.out.print("\n\tLOGIN to BNK Global Banking Solutions");
			System.out.print("\nUsername:\t");
			String userName = scanner.nextLine();
			System.out.print("Password:\t");
			String userPassword = scanner.nextLine();
			System.out.println("\nLogging in . . .");
			List<UserLogin> userLoginList = userLoginResponse.getUserLogin();
			for (UserLogin u : userLoginList) {

				String userNameFoundString = u.getUserName().toString();

				if (userNameFoundString.equals(userName)) {
					String passwordFoundString = u.getUserPassword().toString();
					if (passwordFoundString.equals(userPassword)) {

						System.out.println("Welcome " + u.getUserName() + "!");
						correctLogin = true;
						loginCredentials(correctLogin);
						break;

					} else {
						System.out.println("Incorrect Credentials!");
						correctLogin = false;
						loginCredentials(correctLogin);
					}
				}
			}
			break;

		case 'X':
			break;

		default:
			System.out.println("Invalid Option!! Please Enter Correct Opton...");
			break;
		}
		System.out.println("##############################################\n");
//		scanner.close();
//		AccountClientApp.transferProcedure();
//		String senderAccountNumber = AccountClientApp.getSenderAccount(senderString);
	}
	
	public static void updateBalance(String theAccString, float newBalance) {
		RestTemplate updateBalRestTemplate = new RestTemplate();
		UserLogin updateBal = new UserLogin();
		updateBal.setTotalBalance(newBalance);
		final String restApiUrlString = "http://localhost:8081/ecz/user/update/" + theAccString;
		updateBalRestTemplate.put(restApiUrlString, updateBal);
	}
	
	public static float updateSenderBalance(float updateAmount) {
		float newSenderBal = updateAmount;
		senderNewBal = newSenderBal;
		return senderNewBal;
	}
	public static float updateReceiverBalance(float updateAmount) {
		float newReceiverBal = updateAmount;
		receiverNewBal = newReceiverBal;
		return receiverNewBal;
	}
	public static String getSenderAccount(String getSender) {
		String senderString = getSender;
		senderAccInfo = senderString;
		return senderAccInfo;
	}
	public static String getReceiverAccount(String getReceiver) {
		String receiverString = getReceiver;
		receiverAccInfo = receiverString;
		return receiverAccInfo;
	}
	
	public static void updateSenderBalance() {
		updateBalance(senderAccInfo, senderNewBal);
	}
	public static void updateReceiverBalance() {
		updateBalance(receiverAccInfo, receiverNewBal);
	}
	public static boolean loginCredentials(boolean correctCredentials) {
		return correctCredentials;
	}
}
