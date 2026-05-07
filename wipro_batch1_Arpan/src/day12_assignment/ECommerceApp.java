package day12_assignment;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ECommerceApp {
	public static void saveOrder(int orderId, String items, double total) {
		try (PrintWriter out = new PrintWriter(new FileWriter("orders.txt", true))) {
			out.println(orderId + "," + items + "," + total);
		} catch (IOException e) {
			System.err.println("Error saving order: " + e.getMessage());
		}
	}

	public static void saveInvoice(int orderId, String customer, double total) {
		String filename = "invoice_" + orderId + ".txt";
		try (PrintWriter out = new PrintWriter(new FileWriter(filename))) {
			out.println("Invoice ID: " + orderId);
			out.println("Customer: " + customer);
			out.println("Amount: " + total);
			out.println("Thank you for shopping!");
		} catch (IOException e) {
			System.err.println("Error saving invoice: " + e.getMessage());
		}
	}

	public static void saveShippingDetails(int orderId, String address, String status) {
		String filename = "shipping_" + orderId + ".txt";
		try (PrintWriter out = new PrintWriter(new FileWriter(filename))) {
			out.println("Order ID: " + orderId);
			out.println("Address: " + address);
			out.println("Status: " + status);
		} catch (IOException e) {
			System.err.println("Error saving shipping: " + e.getMessage());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		saveOrder(1001, "Laptop,Mouse", 85000.0);
		saveInvoice(1001, "Arpan Jana", 85000.0);
		saveShippingDetails(1001, "Kolkata, WB", "Shipped");

	}

}
