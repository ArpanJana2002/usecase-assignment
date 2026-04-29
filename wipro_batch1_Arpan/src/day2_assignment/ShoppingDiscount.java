package day2_assignment;

public class ShoppingDiscount {
	static double purchaseAmount = 2000;

	public static void main(String[] args) {
		// TODO Auto-generated method stub/
		double discountRate;
		double discountAmount;
		double finalAmount;

		if (purchaseAmount <= 800) {
			discountRate = 0;
		} else if (purchaseAmount <= 1500) {
			discountRate = 10;
		} else if (purchaseAmount <= 2500) {
			discountRate = 15;
		} else if (purchaseAmount <= 5000) {
			discountRate = 20;
		} else {
			discountRate = 30;
		}

		discountAmount = purchaseAmount * discountRate / 100;
		finalAmount = purchaseAmount - discountAmount;

		System.out.println("Purchase Amount: " + purchaseAmount);
		System.out.println("Discount Rate: " + discountRate + "%");
		System.out.println("Discount Amount: " + discountAmount);
		System.out.println("Final Payable Amount: " + finalAmount);

	}

}
