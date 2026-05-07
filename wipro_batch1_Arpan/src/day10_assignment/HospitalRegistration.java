package day10_assignment;

import java.util.TreeSet;

public class HospitalRegistration {

	static class Patient implements Comparable<Patient> {
		int id;
		String name;

		public Patient(int id, String name) {
			this.id = id;
			this.name = name;
		}

		@Override
		public int compareTo(Patient o) {
			if (o == null) {
				throw new NullPointerException("Cannot compare with null");
			}
			return Integer.compare(this.id, o.id);
		}

		@Override
		public String toString() {
			return "Patient [id=" + id + ", name=" + name + "]";
		}
	}

	static TreeSet<Patient> registeredPatients = new TreeSet<Patient>();

	public static boolean isIdValid(int pId) {
		for (Patient p : registeredPatients) {
			if (p.id == pId)
				return true;
		}
		return false;
	}

	public static void registerPatient(int pId, String name) {
		if (isIdValid(pId)) {
			System.out.println("Patient id " + pId + " and name " + name + " is already registered.");
		} else {
			registeredPatients.add(new Patient(pId, name));

			System.out.println("Patient of id " + pId + " and name " + name + " is successfully registered.");
		}
	}

	public static void showPatients() {
		if (registeredPatients.isEmpty()) {
			System.out.println("No patients registered.");
		} else {
			System.out.println("\n----------Registered patients are:-----------");
			for (Patient p : registeredPatients) {
				System.out.println("Id: " + p.id + " and name " + p.name);
			}
			System.out.println("Total patients: " + registeredPatients.size());
		}
	}

	public static void main(String[] args) {
		registerPatient(1, "Rahul");
		registerPatient(2, "Priya");
		registerPatient(4, "Amit");
		registerPatient(1, "Rahul"); // duplicate
		registerPatient(3, "Sneha");

		System.out.println();

		showPatients();
	}
}

/*
 * public class HospitalRegistration {
 * 
 * static TreeSet<Integer> registeredPatient = new TreeSet<>();
 * 
 * public static void registeredPatients(int pID) { if
 * (registeredPatient.contains(pID)) { System.out.println("Patient of " + pID +
 * " is already registered."); } else { registeredPatient.add(pID);
 * System.out.println("Patient " + pID + " successfully registered."); } }
 * 
 * public static void showPatients() { if (registeredPatient.isEmpty()) {
 * System.out.println("No patient is registered."); } else {
 * System.out.println("Registered patients: " + registeredPatient); } }
 * 
 * public static void main(String[] args) { registeredPatients(1);
 * registeredPatients(2); registeredPatients(4); registeredPatients(3);
 * registeredPatients(3); // duplicate
 * 
 * System.out.println(); showPatients(); } }
 */
