package day3_assignment;

public class BankAccount {
	private double balance;

	public BankAccount(double balance) {
		this.balance = balance;
	}

	public void deposit(double amount) {
		if (amount > 0) {
			balance += amount;
		}
	}

	public void withdraw(double amount) {
		if (amount > 0 && amount <= balance) {
			balance -= amount;
		} else {
			System.out.println("Invalid withdrawal!");
		}
	}

	public double getBalance() {
		return balance;
	}

	public static void main(String[] args) {
		System.out.println("\n---- Bank Account ----");
		BankAccount acc = new BankAccount(1000);
		acc.deposit(500);
		acc.withdraw(300);
		System.out.println("Balance: " + acc.getBalance());
	}

}
