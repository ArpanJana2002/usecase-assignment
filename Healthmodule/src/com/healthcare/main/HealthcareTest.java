package com.healthcare.main;

import com.healthcare.doctor.GeneralPhysician;
import com.healthcare.doctor.Neurologist;
import com.healthcare.model.Patient;
import com.healthcare.service.PatientServiceImpl;

public class HealthcareTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Create patients
		Patient p1 = new Patient(1, "Arjun Karmakar", 45, "Nerve disease");
		Patient p2 = new Patient(2, "Priya Sharma", 30, "Fever and cold");

		PatientServiceImpl patientServiceImpl = new PatientServiceImpl();

		patientServiceImpl.registerPatient(p1);
		patientServiceImpl.registerPatient(p2);

		// Show patient details
		System.out.println("=== Patient Details ===");

		patientServiceImpl.showPatientDetails(1);
		patientServiceImpl.showPatientDetails(2);

		// create doctors
		GeneralPhysician generalDoc = new GeneralPhysician("Tom Cruise");
		Neurologist neuroDoc = new Neurologist("Brad Pitt");

		System.out.println("=== Diagnosis Session ===");
		System.out.println();

		generalDoc.diagnose(p1);
		generalDoc.diagnose(p2);

		neuroDoc.diagnose(p1);
		neuroDoc.diagnose(p2);

	}

}
