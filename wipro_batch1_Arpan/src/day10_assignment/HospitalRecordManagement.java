package day10_assignment;

import java.util.HashMap;
import java.util.TreeMap;

public class HospitalRecordManagement {
	static HashMap<Integer, String> hashMap = new HashMap<>();
	static TreeMap<Integer, String> treeMap = new TreeMap<>();

	// Add patient
	public static void addPatient(int id, String name) {
		if (hashMap.containsKey(id)) {
			System.out.println("Patient id " + id + " is already exists.");
		} else {
			hashMap.put(id, name);
			treeMap.put(id, name);
			System.out.println("Patient added having id: " + id + " and name: " + name);
		}
	}

	// Update patient
	public static void updatePatient(int id, String updatedPatinet) {
		if (hashMap.containsKey(id)) {
			hashMap.replace(id, updatedPatinet);
			treeMap.replace(id, updatedPatinet);
			System.out.println("Updated id is: " + id + " and patient name: " + updatedPatinet);
		} else {
			System.out.println("Patient id: " + id + " not found.");
		}
	}

	// find patient details
	public static void findPatientDetails(int id) {
		String name = hashMap.getOrDefault(id, "Not Found");
		System.out.println("Id found is: " + id + " , Name: " + name);
	}

	// remove patient
	public static void removePatient(int id) {
		if (hashMap.containsKey(id)) {
			String name = hashMap.get(id);
			hashMap.remove(id);
			treeMap.remove(id);
			System.out.println("Removed patient id is: " + id + " name: " + name);
		} else {
			System.out.println("Patient id: " + id + " not found");
		}

	}

	public static void showAllPatients() {
		if (hashMap.isEmpty()) {
			System.out.println("No patient found.");
			return;
		}

		System.out.println("\n------------HashMap implementation-----------");
		hashMap.forEach((id, name) -> System.out.println(" Id is: " + id + " , Name: " + name));
		System.out.println("\n------------TreeMap implementation-----------");
		treeMap.forEach((id, name) -> System.out.println(" Id is: " + id + " , Name: " + name));
	}

	// check patient exists or not by id
	public static void checkPatient(int id) {
		if (hashMap.containsKey(id)) {
			System.out.println("Patient id " + id + " exists of name: " + hashMap.get(id));
		} else {
			System.out.println("Patient id: " + id + " doesn't exist.");
		}
	}

	// count total number of patients
	public static void countPatients() {
		System.out.println("Total patient count: " + hashMap.size());
	}

	// clear all
	public static void clearSystem() {
		hashMap.clear();
		treeMap.clear();
		System.out.println("System cleared.");
	}

	public static void main(String[] args) {

		// Add patients
		addPatient(505, "Rahul");
		addPatient(102, "Priya");
		addPatient(789, "Amit");
		addPatient(301, "Sneha");
		addPatient(456, "Puja");
		addPatient(634, "Debanjan");
		addPatient(278, "Debashis");
		addPatient(102, "Priya"); // duplicate

		System.out.println();

		// Update
		updatePatient(789, "Ajit");
		updatePatient(999, "Sukumar");

		System.out.println();

		// Find patient
		findPatientDetails(505);
		findPatientDetails(700);

		System.out.println();

		// Check patient
		checkPatient(301);
		checkPatient(888);

		System.out.println();

		// Remove
		removePatient(456);
		removePatient(999);

		System.out.println();

		// show all patients
		showAllPatients();

		System.out.println();

		// Count total patients
		countPatients();

		System.out.println();

		// Clear
		clearSystem();
		countPatients();
	}

}
