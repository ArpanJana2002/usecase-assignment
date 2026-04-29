package day2_assignment;

public class ATMWithdrawal {
	static int balance = 1000;
	static int withdrawAmount = 450;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (balance >= withdrawAmount) {
			balance = balance - withdrawAmount;
			System.out.println("Withdrawal successful");
			System.out.println("Withdrawn Amount: " + withdrawAmount);
			System.out.println("Remaining Balance: " + balance);
		} else {
			System.out.println("Insufficient Balance");
			System.out.println("Current Balance: " + balance);
		}

	}

}
