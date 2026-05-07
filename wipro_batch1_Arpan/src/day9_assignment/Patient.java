package day9_assignment;

public class Patient {
	String name;
	int age;
	String disease;

	public Patient(String name, int age, String disease) {
		super();
		this.name = name;
		this.age = age;
		this.disease = disease;
	}

	@Override
	public String toString() {
		return "Patient [name=" + name + ", age=" + age + ", disease=" + disease + "]";
	}

}
