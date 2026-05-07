package day12_assignment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

class Emp implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private double salary;

	public Emp(int id, String name, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Emp [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}

}

public class EmployeeSerializationApp {
	public static void saveEmployees(List<Emp> employees) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("employees.ser"))) {
			for (Emp e : employees) {
				oos.writeObject(e);
			}
			System.out.println("Employees saved to file.");
		} catch (IOException e) {
			System.err.println("Error saving employees: " + e.getMessage());
		}
	}

	public static void readEmployees() throws FileNotFoundException, IOException {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("employees.ser"))) {
			try {
				while (true) {
					Emp e = (Emp) ois.readObject();
					System.out.println("Loaded: " + e);
				}

			} catch (IOException | ClassNotFoundException e) {
				System.err.println("Error reading employees: " + e.getMessage());
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Emp> emps = Arrays.asList(new Emp(1, "Arpan", 70000.0), new Emp(2, "Rahul", 65000.0),
				new Emp(3, "Priya", 72000.0));

	}

}
