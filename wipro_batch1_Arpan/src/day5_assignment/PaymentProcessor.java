package day5_assignment;

import day5_assignment.PaymentProcessor.DebitCard;

public class PaymentProcessor {
	private double taxRate = 0.05;

	public final void processPayment(String recipient, double amt) {
		double tax = amt * taxRate;
		double total = amt - tax;
		System.out.println("=== Secure Payment Processing ===");
		System.out.println("Recipient   : " + recipient);
		System.out.println("Amount      : Rs." + amt);
		System.out.println("Tax (0.05%)   : Rs." + tax);
		System.out.println("Total       : Rs." + total);
		System.out.println("Status      : Payment Successful");

	}

	static class DebitCard extends PaymentProcessor {
		public void showCardDetails() {
			System.out.println("DebitCard Payment Mode Selected");
		}
	}

}

class Test {
	public static void main(String[] args) {
		DebitCard debitCard = new DebitCard();
		debitCard.showCardDetails();
		debitCard.processPayment("A", 2000);
	}
}
