package day1_assignment;

import java.util.Scanner;

public class StudentInfo {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);

		System.out.println("Enter name: ");
		String studentName = input.nextLine();

		System.out.println("Enter age:");
		int studentAge = input.nextInt();

		System.out.println("Enter marks in Java: ");
		float marksJava = input.nextFloat();

		System.out.println("Enter marks in Python: ");
		float marksPython = input.nextFloat();

		final float avgMarks = (marksJava + marksPython) / 2;

		char grade = (avgMarks >= 80) ? 'A' : (avgMarks >= 60) ? 'B' : 'C';

		System.out.println("----------Student details----------");
		System.out.println("Name: " + studentName);
		System.out.println("Age: " + studentAge);
		System.out.println("Average: " + avgMarks);
		System.out.println("Grade: " + grade);

		input.close();

	}

}
