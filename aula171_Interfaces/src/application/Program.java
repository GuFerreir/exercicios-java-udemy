package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Contract;
import services.ContractService;
import services.PaypalService;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		ContractService contractService = new ContractService();
		
		
		System.out.println("Enter contract data:");
		System.out.print("Number: ");
		int number = sc.nextInt();
		sc.nextLine();
		System.out.print("Date (dd/MM/yyyy): ");
		Date date = sdf.parse(sc.nextLine());
		System.out.print("Contract value: ");
		double totalValue = sc.nextDouble();
		System.out.print("Enter number of installments: ");
		int installments = sc.nextInt();
		
		Contract contract = new Contract(number, date, totalValue);
		contractService.processContract(contract, installments,  new PaypalService());
		
		System.out.println();
		System.out.println("Installments: ");
		contract.printInstallments();	
			
		sc.close();
	}
}
