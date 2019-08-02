package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Contribuintes;
import entities.PessoaFisica;
import entities.PessoaJuridica;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Contribuintes> list = new ArrayList<>();

		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();
		sc.nextLine();

		for (int i = 1; i <= n; i++) {
			System.out.println("Tax payer #" + i + " data:");
			System.out.print("Individual or Company (i/c)? ");
			char type = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Name: ");
			String name = sc.nextLine();
			System.out.print("Anual income: ");
			double anualTax = sc.nextDouble();
			if (type == 'i') {
				System.out.print("Health expenditures: ");
				double healthExpenditures = sc.nextDouble();

				list.add(new PessoaFisica(name, anualTax, healthExpenditures));
			} else {
				System.out.print("Number of employees: ");
				int numFuncionarios = sc.nextInt();

				list.add(new PessoaJuridica(name, anualTax, numFuncionarios));
			}

		}
		
		System.out.println();
		System.out.println("TAXES PAID:");
		
		double sum = 0.0;
		for(Contribuintes cont : list){
			sum += cont.calcImpostos();
			System.out.println(cont.getName() + ": $ " + String.format("%.2f", cont.calcImpostos()));
		}

		System.out.println();
		System.out.print("TOTAL TAXES: $ "+ String.format("%.2f", sum));
		
		sc.close();
	}

}
