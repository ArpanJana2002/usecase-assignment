package day2_assignment;

import java.util.Scanner;

public class PasswordRetry {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String correctPassword = "123";
		int attempts = 3;

		do {
			System.out.print("Enter password: ");
			String input = sc.nextLine();
			attempts--;

			if (input.equals(correctPassword)) {
				System.out.println("Login Successful!");
				break;
			} else {
				System.out.println("Wrong password! " + attempts + " attempts left.");
			}
		} while (attempts > 0);

		if (attempts == 0) {
			System.out.println("Account Locked!");
		}
		sc.close();

	}

}
