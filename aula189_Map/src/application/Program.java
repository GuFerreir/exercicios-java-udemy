package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter file full path: ");
		String path = sc.nextLine();
		
		Map<String, Integer> urnas = new HashMap<>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			
			String line = br.readLine();
			while (line != null) {

				String[] infoLine = line.split(",");
				
				String name = infoLine[0];
				int votos = Integer.parseInt(infoLine[1]);	
				
				if(urnas.containsKey(name)){
					int votosPossuidos = urnas.get(name);
					votos = votos + votosPossuidos;
					urnas.put(name, votos);		
				}
				else {
					urnas.put(name, votos);
				}	
		
				
				//lendo a proxima linha
				line = br.readLine();				
			}			
		}
		catch (IOException e) {			
			System.out.println("Error: " + e.getMessage());			
		}
		
		for(String candidato : urnas.keySet()){
			System.out.println(candidato + ": " + urnas.get(candidato));
		}
		
		sc.close();
	}
}
