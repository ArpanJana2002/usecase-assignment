package day2_assignment;

import java.util.Scanner;

public class EmployeeSalaryIncrement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number of employees: ");
		int n = sc.nextInt();
		double incrementRate = 0.20;

		for (int i = 1; i <= n; i++) {
			System.out.print("Enter salary for employee " + i + ": ");
			double salary = sc.nextInt();
			double newSalary = salary + (salary * incrementRate);
			System.out.println("New salary: " + newSalary);
		}
		sc.close();

	}

}
