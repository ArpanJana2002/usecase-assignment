package day1_assignment;

import java.util.Scanner;

public class EcommerceProducts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("-----Enter E-commerce products details-----");
		System.out.println("Enter product name: ");
		String productName = scanner.nextLine();

		System.out.println("Enter product price: ");
		double productPrice = scanner.nextDouble();

		System.out.println("Enter product Quantity: ");
		int productQuantity = scanner.nextInt();

		System.out.println("Is the product is available in the inventry?: ");
		boolean isAvailable = scanner.nextBoolean();

		System.out.println("\n----Product details-------");
		System.out.println("Product name: " + productName);
		System.out.println("Product price: " + productPrice);
		System.out.println("product Quantity: " + productQuantity);
		System.out.println("Is it in stock?: " + isAvailable);

		scanner.close();

	}

}
