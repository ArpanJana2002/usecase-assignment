package day1_assignment;

import java.util.Scanner;

public class SimpleInterestCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter principle: ");
		double principle = scanner.nextDouble();

		System.out.println("Enter anuual interest rate: ");
		double rate = scanner.nextDouble();

		System.out.println("Enter the time period: ");
		double time = scanner.nextDouble();

		double simpleInterest = (principle * rate * time) / 100;

		System.out.printf("\nThe simple interest is: %.2f%n", simpleInterest);

		scanner.close();

	}

}
