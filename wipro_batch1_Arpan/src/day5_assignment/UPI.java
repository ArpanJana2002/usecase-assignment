package day5_assignment;

interface UPI {
	void Pay(double amt);

	double getBalance();

	default void processTnx(double amt, String upiID) {
		System.out.println("processing Upi transction: " + amt);
		System.out.println("upi id: " + upiID);

		if (amt <= 0) {
			validateTransactionAmt(amt);
			return;
		}

		validateTransactionAmt(amt);
		Pay(amt);
		sendMsg(amt);
	}

	default void addMoney(double amt) {
		System.out.println("Adding money: " + amt);
		if (amt <= 0) {
			System.err.println("Invalid Amount");
			System.out.println("Current Balance: " + getBalance());
			return;
		}
		Pay(-amt);
		System.out.println("Updated Balance: ₹" + getBalance());
	}

	default void withdrawMoney(double amt) {
		System.out.println("Withdrawing money: " + amt);
		if (amt <= 0 || amt > getBalance()) {
			System.err.println("Invalid/Insufficient Amount");
			System.out.println("Current Balance: " + getBalance());
			return;
		}
		Pay(amt);
		System.out.println("Updated Balance: " + getBalance());
	}

	default void validateTransactionAmt(double amt) {
		if (amt <= 0)
			System.err.println("Invalid Amount");
		else
			System.out.println("Transation Validated");
	}

	default void sendMsg(double amt) {
		System.out.println("Payment of Rs." + amt + "successful!");
	}
}

class Gpay implements UPI {
	private double balance = 10000;

	@Override
	public void Pay(double amt) {
		balance -= amt;
		System.out.println("Gpay: Balance updated to Rs." + balance);
	}

	@Override
	public double getBalance() {
		return balance;
	}

	public void sendMsg(double amt) {
		System.out.println("Gpay: Payment successful");
	}
}

class phonePe implements UPI {
	private double balance = 15000;

	@Override
	public void Pay(double amt) {
		balance -= amt;
		System.out.println("phonePe: Balance updated to Rs." + balance);
	}

	@Override
	public double getBalance() {
		return balance;
	}

	public void sendMsg(double amt) {
		System.out.println("phonePe: Payment successful");
	}
}

class Paytm implements UPI {
	private double balance = 8000;

	@Override
	public void Pay(double amt) {
		balance -= amt;
		System.out.println("Paytm: Balance updated to Rs." + balance);
	}

	@Override
	public double getBalance() {
		return balance;
	}

	public void sendMsg(double amt) {
		System.out.println("Paytm: Payment successful");
	}
}