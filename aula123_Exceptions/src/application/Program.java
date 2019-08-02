package application;

import java.util.Locale;
import java.util.Scanner;

import entities.Account;
import entities.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {

		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		try {
			System.out.println("Enter account data");
			System.out.print("Number: ");
			int num = sc.nextInt();
			sc.nextLine();
			System.out.print("Holder: ");
			String holder = sc.nextLine();
			System.out.print("Initial balance: ");
			double balance = sc.nextDouble();
			System.out.print("Withdraw Limit: ");
			double withdrawLimit = sc.nextDouble();
			
			Account account = new Account(num, holder, balance, withdrawLimit);
			
			System.out.println();
			System.out.print("Enter amount for withdraw: ");
			double amount = sc.nextDouble();
			account.withdraw(amount);	
			
			System.out.println("New balance: " + String.format("%.2f", account.getBalance()));
		}
		catch(DomainException e){
			System.out.println("Withdraw error: "+ e.getMessage());
		}
		sc.close();

	}

}
