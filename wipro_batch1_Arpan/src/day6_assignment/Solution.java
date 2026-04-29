package day6_assignment;

/*class InvalidPinException extends Exception {
	public InvalidPinException(String msg) {
		super(msg);
	}
}*/

class ATM {
	private int correctPin = 4245;

	public void validatePin(int enteredPin) {
		if (enteredPin != correctPin) {
			throw new IllegalArgumentException("Invalid Pin!. please try again");
		}
		System.out.println("Pin verified!");
	}
}

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ATM atm = new ATM();
		int enteredPin = 4246;
		try {
			System.out.println("Card Entered.");
			System.out.println("Entering pin...");
			atm.validatePin(enteredPin);
			System.out.println("Transaction successful!");
		} catch (IllegalArgumentException e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		} finally {
			System.out.println("Your history is logged");
		}

	}

}
