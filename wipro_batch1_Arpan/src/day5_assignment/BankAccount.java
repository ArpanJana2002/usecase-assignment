package day5_assignment;

public class BankAccount {
	private final String accountNumber; // Cannot be changed after assignment
	private String ownerName;
	private double balance;

	public BankAccount(String accountNumber, String ownerName, double balance) {
		super();
		this.accountNumber = accountNumber;
		this.ownerName = ownerName;
		this.balance = balance;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public double getBalance() {
		return balance;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public static void main(String[] args) {
		BankAccount bankAccount = new BankAccount("A-123456789", "A", 10000);
		System.out.println("ACC no " + bankAccount.accountNumber);
		System.out.println("Acc holder name: " + bankAccount.ownerName);
		System.out.println("Available balance: " + bankAccount.balance);
	}

}
