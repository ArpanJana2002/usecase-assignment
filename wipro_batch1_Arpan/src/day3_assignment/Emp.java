package day3_assignment;

public class Emp {
	private String name;
	private double salary;

	public Emp(String name, double salary) {
		super();
		this.name = name;
		this.salary = salary;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		if (salary > 0) {
			this.salary = salary;
		} else {
			System.out.println("Invalid salary!");
		}
	}

	public static void main(String[] args) {
		System.out.println("---- Employee ----");
		Emp emp1 = new Emp("Arpan", 1000);
		System.out.println("Salary: " + emp1.getSalary());
		emp1.setSalary(2000);
		System.out.println("Updated Salary: " + emp1.getSalary());
	}

}
