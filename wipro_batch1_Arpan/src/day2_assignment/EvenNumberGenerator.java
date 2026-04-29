package day2_assignment;

import java.util.Scanner;

public class EvenNumberGenerator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter limit: ");
		int limit = sc.nextInt();

		System.out.println("Even numbers between 1 and " + limit + ":");
		for (int i = 2; i <= limit; i += 2) {
			System.out.print(i + " ");
		}
		sc.close();

	}

}
