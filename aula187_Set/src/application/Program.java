package application;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Set<Integer> alunos = new HashSet<>();
		
		System.out.print("How many students for course A? ");
		int qtdA = sc.nextInt();
		
		for(int i = 0; i < qtdA; i++){
			int aux = sc.nextInt();
			alunos.add(aux);
		}		
		
		System.out.println();
		System.out.print("How many students for course B? ");
		int qtdB = sc.nextInt();
		
		for(int i = 0; i < qtdB; i++){
			int aux = sc.nextInt();
			alunos.add(aux);
		}		
		
		System.out.println();
		System.out.print("How many students for course C? ");
		int qtdC = sc.nextInt();
		
		for(int i = 0; i < qtdC; i++){
			int aux = sc.nextInt();
			alunos.add(aux);
		}
		
		System.out.println();
		System.out.println("Total Students: " + alunos.size());
		
		
		sc.close();
	}
}
