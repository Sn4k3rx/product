package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Locale.setDefault(Locale.US);
		Scanner in = new Scanner(System.in);
		
		List<Product> product = new ArrayList<>();
		
		System.out.print("enter the number of products: ");
		int x = in.nextInt();
		
		for (int i = 1; i <= x; i++) {
			System.out.print("Commom, Used Or Imported (c/u/i)");
			char c = in.next().charAt(0);
			System.out.print("Name: ");
			in.nextLine();
			String name = in.nextLine();
			System.out.print("Price: ");
			double price = in.nextDouble();
			
			if (c == 'c') {
				Product p = new Product(name, price);
				product.add(p);
			}else if (c == 'u') {
				System.out.print("Manufacture Date (DD/MM/YYYY): ");
				Date manufactureDate = sdf.parse(in.next());
				Product p = new UsedProduct(name, price, manufactureDate);
				product.add(p);
			} else {
				System.out.print("customs fee: ");
				double customsFee = in.nextDouble();
				Product p = new ImportedProduct(name, price, customsFee);
				product.add(p);
			}
		}
		
		System.out.println();
		System.out.println("Price Tags: ");
		for (Product list : product) {
			System.out.println(list.priceTag());
		}
		in.close();
	}
}
