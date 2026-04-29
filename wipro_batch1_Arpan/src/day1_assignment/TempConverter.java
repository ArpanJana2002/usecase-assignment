package day1_assignment;

import java.util.Scanner;

public class TempConverter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter temp in Celsius: ");
		float c = scanner.nextFloat();

		float f = (c * 9 / 5) + 32;

		System.out.println(c + " Celsius is equal to " + f + " Fahrenheit");

		scanner.close();

	}

}
