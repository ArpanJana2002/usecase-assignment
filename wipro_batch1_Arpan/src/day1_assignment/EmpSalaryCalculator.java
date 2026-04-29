package day1_assignment;

import java.util.Scanner;

public class EmpSalaryCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter basic slary: ");
		double basic = scanner.nextDouble();

		System.out.println("Enter bonus ammount: ");
		double bonus = scanner.nextDouble();

		System.out.println("Enter Tax Ammmount: ");
		double tax = scanner.nextDouble();

		double salary = (basic + bonus - tax);

		System.out.println("\n----------salary structure----------");
		System.out.println("Basic salary: " + basic);
		System.out.println("Bonus: " + bonus);
		System.out.println("Tax: " + tax);

		System.out.println("Actual Salary: " + salary);

		scanner.close();

	}

}
