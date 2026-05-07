package day9_assignment;

import java.util.HashMap;
import java.util.HashSet;

public class HospitalPatientManagement {

	static HashSet<Integer> patientSet = new HashSet<>();
	static HashMap<Integer, String> patientMap = new HashMap<>();

	static void registerPatient(int id, String name) {
		if (patientSet.contains(id)) {
			System.out.println("Patient already registered of id: " + id + " and name: " + name);
		} else {
			patientSet.add(id);
			patientMap.put(id, name);

			System.out.println("Patient registration successful having id: " + id + " and name: " + name);
		}
	}

	static void showPatients() {
		System.out.println("\n----Registered patients-----");
		if (patientSet.isEmpty()) {
			System.out.println("No patients registered.");
			return;
		}
		for (int id : patientSet) {
			System.out.println("ID: " + id + " Name: " + patientMap.get(id));
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		registerPatient(1, "Amit");
		registerPatient(2, "Riya");
		registerPatient(3, "Durjoy");

		// add duplicate data
		registerPatient(3, "Durjoy");

		// show patients
		showPatients();

	}

}
