package day2_assignment;

import java.util.Scanner;

public class ShoppingCart {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double total = 0;
		int itemCount = 0;

		System.out.println("Enter item prices: ");
		while (true) {
			System.out.print("Item price: ");
			double price = sc.nextDouble();

			if (price <= 0) {
				break;
			}
			total += price;
			itemCount++;
			System.out.println("Item " + itemCount + " added. Subtotal: " + total);
		}

		System.out.println("\n=== Final Bill ===");
		System.out.println("Total items: " + itemCount);
		System.out.printf("Total amount: ₹%.2f\n", total);
		sc.close();
	}
}