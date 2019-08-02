package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import entities.Product;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		//local do arquivo de entrada
		String path = "sumary.csv";
		//local do arquivo de saida
		String pathSave = "out\\sumary.csv";
		
		File test = new File("out");
		if(test != null){
			//criar o diretorio para saida
			@SuppressWarnings("unused")
			boolean success = new File("out").mkdir();
		}		
		
		//instancia de produtos para lista-los
		Product product;
		//instancia da lista de produtos para guarda-los e usar o metodo
		List<Product> productsList = new ArrayList<>();
		
		//tenta ler ae
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {			
			String line = br.readLine();
			while (line != null) {
				//separar os dados da linha por virgula
				String[] infoLine = line.split(",");
				
				String name = infoLine[0];
				double price = Double.parseDouble(infoLine[1]);
				int quantity = Integer.parseInt(infoLine[2]);
				
				//instanciando produto
				product = new Product(name, price, quantity);
				//adicionando a lista
				productsList.add(product);
				
				//lendo a proxima linha
				line = br.readLine();				
			}
			System.out.println("Arquivo lido!");
			
		}
		catch (IOException e) {			
			System.out.println("Error: " + e.getMessage());			
		}

		//tenta escrever ae
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(pathSave))) {

			
			for (Product prod : productsList) {
				bw.write(prod.getName() + "," + String.format("%.2f", prod.totalPrice()));
				bw.newLine();
			}
			System.out.println("Arquivo salvo!");
			
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
