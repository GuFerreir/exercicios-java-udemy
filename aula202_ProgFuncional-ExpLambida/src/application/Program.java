package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Employee;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Employee> list = new ArrayList<>();

		System.out.print("Enter the full file path: ");
		String path = sc.nextLine();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			
			String line = br.readLine();
			
			while (line != null) {
				// separar os dados da linha por virgula
				String[] infoLine = line.split(",");

				// instanciando produto e adicionando a lista
				list.add(new Employee(infoLine[0], infoLine[1], Double.parseDouble(infoLine[2])));

				// lendo a proxima linha
				line = br.readLine();
			}

			System.out.print("Enter the salary: ");
			double testSalary = sc.nextDouble();

			System.out.println("E-mail of people whose salary is more than " + String.format("%.2f", testSalary) + ":");

			Comparator<String> comp = (e1, e2) -> e1.toUpperCase().compareTo(e2.toUpperCase());

			List<String> emails = list.stream().filter(e -> e.getSalary() > testSalary).map(e -> e.getEmail())
					.sorted(comp).collect(Collectors.toList());

			emails.forEach(System.out::println);

			List<Double> salarys = list.stream().filter(e -> e.getName().charAt(0) == 'M').map(e -> e.getSalary())
					.collect(Collectors.toList());

			double sum = salarys.stream().reduce(0.0, (x, y) -> x + y);

			System.out.println("Sum of salary of people whose name starts with 'M': " + String.format("%.2f", sum));

		} 
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		} 
		finally {
			sc.close();
		}
	}
}
