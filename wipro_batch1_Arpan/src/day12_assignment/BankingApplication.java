package day12_assignment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class BankingApplication {
	public static void saveAccount(String filename, String accNo, String name, double balance) {
		try (PrintWriter out = new PrintWriter(new FileWriter(filename, true))) {
			out.println(accNo + "," + name + "," + balance);
		} catch (IOException e) {
			System.err.println("Error saving account: " + e.getMessage());
		}
	}

	public static void logTransaction(String accNo, String type, double amount) {
		String filename = "transactions_" + accNo + ".txt";
		try (PrintWriter out = new PrintWriter(new FileWriter(filename, true))) {
			String time = new Date().toString();
			out.println(time + " | " + type + " | " + amount);
		} catch (IOException e) {
			System.err.println("Error logging transaction: " + e.getMessage());
		}
	}

	public static void readAccount(String filename) {
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println("Account: " + line);
			}
		} catch (IOException e) {
			System.err.println("Error reading account: " + e.getMessage());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		saveAccount("accounts.txt", "ACC123", "Arpan", 5000.0);
		logTransaction("ACC123", "DEBIT", 1000.0);
		logTransaction("ACC123", "CREDIT", 2000.0);
		readAccount("accounts.txt");

	}

}
