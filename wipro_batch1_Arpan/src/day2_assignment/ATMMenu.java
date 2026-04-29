package day2_assignment;

import java.util.Scanner;

public class ATMMenu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int balance = 2000;

		while (true) {
			System.out.println("\n=== ATM Menu ===");
			System.out.println("1. Check Balance");
			System.out.println("2. Withdraw");
			System.out.println("3. Deposit");
			System.out.println("4. Exit");
			System.out.print("Choose option: ");

			int choice = sc.nextInt();

			switch (choice) {
			case 1:
				System.out.println("Balance: " + balance);
				break;
			case 2:
				System.out.print("Enter amount: ");
				int withdraw = sc.nextInt();
				if (balance >= withdraw) {
					balance -= withdraw;
					System.out.println("Withdrawal successful!");
					System.out.println("Remaining Balance: " + balance);

				} else {
					System.out.println("Insufficient balance!");
				}
				break;
			case 3:
				System.out.print("Enter deposit amount: ");
				int deposit = sc.nextInt();
				balance += deposit;
				System.out.println("Deposit successful!");
				System.out.println("Updated Balance: " + balance);
				break;
			case 4:
				System.out.println("Thank you!");
				sc.close();
				return;
			default:
				System.out.println("Invalid option!");
			}
		}

	}

}
