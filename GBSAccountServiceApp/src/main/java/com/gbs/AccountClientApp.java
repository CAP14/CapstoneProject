package com.gbs;

import java.util.List;
import java.util.Scanner;

import org.springframework.web.client.RestTemplate;

import com.gbs.entity.*;

public class AccountClientApp {
//	String senderString, receiverString;
//	float newSenderBal, newReceiverBal;
	
	
	public static void main(String args[]) {
		transferProcedure();
	}
	//input details for transfer
	public static void transferProcedure() {
		Scanner scan = new Scanner(System.in);
		System.out.println("##############################################");
		System.out.println("\tGBS Money Transfer Service");
		System.out.println("Enter the amount to transfer:\t");
		float amount = Float.parseFloat(scan.nextLine());
		System.out.println("Receiver account number:\t");
		String toAccString = scan.nextLine();
		System.out.println("\nSender account number:\t");
		String fromAccString = scan.nextLine();
		System.out.println("##############################################\n");
		//calls the processDetails method
		processDetails(fromAccString, toAccString, amount);
		scan.close();
		}
		
	//method for getting account numbers of sender and receiver and update their current balance
	public static void processDetails(String fromAccString, String toAccString, float amount) {
		RestTemplate processRestTemplate = new RestTemplate();
		final String restApiUrlString = "http://localhost:9091/ecz/accounts/all";
		AccountsResponse accountsResponse = processRestTemplate.getForObject(restApiUrlString, AccountsResponse.class);
		List<Accounts> accountsList = accountsResponse.getUserAccount();
		float senderBalance, receiverBalance;
		boolean transferSuccess = false;
		for (Accounts a : accountsList) {
			String senderFoundString = a.getUserAccNumber().toString();
			if (senderFoundString.equals(fromAccString)) {
				if (a.getAccBalance() > amount) {
					senderBalance = a.getAccBalance() - amount;
					transferSuccess = true;
					senderUpdate(fromAccString, senderBalance);
					System.out.println("\n\n##############################################\n");
					System.out.println("Successfully transfered Php " + amount + " to Account: " + toAccString + "!");
					System.out.println("\n##############################################\n\n");
				} else {
					System.out.println("\n\n##############################################\n");
					System.out.println("You have insufficient funds!");
					transferSuccess = false;
					System.out.println("\n##############################################\n\n");
				}
			}
		}//updates the balance of receiver once transaction is successful for sender
		if (transferSuccess) {
			for (Accounts b : accountsList) {
				String receiverFoundString = b.getUserAccNumber().toString();
				if (receiverFoundString.equals(toAccString)) {
					receiverBalance = b.getAccBalance() + amount;
					receiverUpdate(toAccString, receiverBalance);
				}
			}
			transfer(fromAccString, toAccString, amount);
		}
	}
	//method for updating the current balance of the sender
	public static void senderUpdate(String fromAccString, float senderBalance) {
		RestTemplate senderRestTemplate = new RestTemplate();
		Accounts updateBal = new Accounts();
		updateBal.setAccBalance(senderBalance);
		final String restApiUrlString = "http://localhost:9091/ecz/accounts/update/" + fromAccString;
		senderRestTemplate.put(restApiUrlString, updateBal);
		UserClientApp.updateSenderBalance(senderBalance);
		UserClientApp.getSenderAccount(fromAccString);
	}
	//method for updating the current balance of the receiver
	public static void receiverUpdate(String toAccString, float receiverBalance) {
		RestTemplate receiverRestTemplate = new RestTemplate();
		Accounts updateBal = new Accounts();
		updateBal.setAccBalance(receiverBalance);
		final String restApiUrlString = "http://localhost:9091/ecz/accounts/update/" + toAccString;
		receiverRestTemplate.put(restApiUrlString, updateBal);
		UserClientApp.updateReceiverBalance(receiverBalance);
		UserClientApp.getReceiverAccount(toAccString);
	}
	//method for recording a transaction
	public static void transfer(String fromAccString, String toAccString, float amount) {
		RestTemplate transactionRestTemplate = new RestTemplate();
		final String restApiUrlString = "http://localhost:9091/ecz/transactions/transfer";
		Transactions transaction = new Transactions();
		transaction.setFromAcc(fromAccString);
		transaction.setToAcc(toAccString);
		transaction.setAmount(amount);
		transactionRestTemplate.postForObject(restApiUrlString, transaction, Transactions.class);
	}
		
}