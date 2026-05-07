package day9_assignment;

import java.util.ArrayList;

public class PatientDataManagement {
	ArrayList<Patient> patients = new ArrayList<>();

	// add patient
	void addPatient(String name, int age, String disease) {
		patients.add(new Patient(name, age, disease));
		System.out.println(name + " registered successfully!");
	}

	// show all patients
	void listPatients() {
		if (patients.isEmpty()) {
			System.out.println("No patient is found.");
			return;
		}
		System.out.println("\n----------patient list----------");
		for (int i = 0; i < patients.size(); i++) {
			System.out.println((i + 1) + ". " + patients.get(i));
		}
	}

	// search patient by name

	void searchPatientByName(String name) {
		for (Patient p : patients) {
			if (p.name.equalsIgnoreCase(name)) {
				System.out.println("Patient found: " + p);
				return;
			}
		}
		System.out.println("Sorry, Patient " + name + " not found");
	}

}
