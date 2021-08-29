package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.List;

import models.entities.Product;
import models.services.CalculationService;

public class Program {

	public static void main(String[] args) {
		
		List<Product> list = new ArrayList<Product>();
		CalculationService<Product> calc = new CalculationService<Product>();
		String path = "C:\\temp\\products.txt";
		
		try(
			BufferedReader br = new BufferedReader(new FileReader(path));
		){
			
			String line = br.readLine();
			
			while(line != null) {	
				String[] informations = line.split(",");
				
				String name = informations[0];
				Double price = Double.valueOf(informations[1]);
				list.add(new Product(name, price));

				line = br.readLine();
			}
			
			System.out.println(calc.max(list).toString());
			
		}catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
			
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
		
	}

}
