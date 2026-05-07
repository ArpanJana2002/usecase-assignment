package day12_assignment;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class FoodDeliveryApp {
	public static void saveMenu(String restaurant, String items) {
		try (PrintWriter out = new PrintWriter(new FileWriter("menu.txt", true))) {
			out.println(restaurant + " | " + items);
		} catch (IOException e) {
			System.err.println("Error saving menu: " + e.getMessage());
		}
	}

	public static void saveOrder(String orderId, String restaurant, String items, double total) {
		try (PrintWriter out = new PrintWriter(new FileWriter("orders.txt", true))) {
			out.println(orderId + " | " + restaurant + " | " + items + " | " + total);
		} catch (IOException e) {
			System.err.println("Error saving order: " + e.getMessage());
		}
	}

	public static void logDelivery(String orderId, String driver, String status) {
		try (PrintWriter out = new PrintWriter(new FileWriter("delivery_log.txt", true))) {
			out.println(orderId + " | " + driver + " | " + status + " at " + new Date());
		} catch (IOException e) {
			System.err.println("Error logging delivery: " + e.getMessage());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		saveMenu("MBA chai wala", "chai aur pakora");
		saveOrder("ORD100", "MBA chai wala", "chai aur pakora", 50.0);
		logDelivery("ORD100", "DeliveryGuy1", "Delivered");

	}

}
