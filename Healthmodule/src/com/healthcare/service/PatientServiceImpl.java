package com.healthcare.service;

import java.util.HashMap;
import java.util.Map;

import com.healthcare.model.Patient;

public class PatientServiceImpl implements PatientService {
	private Map<Integer, Patient> patinetRecords = new HashMap<>();

	@Override
	public void registerPatient(Patient patient) {
		// TODO Auto-generated method stub
		patinetRecords.put(patient.getId(), patient);
		System.out.println("Patient registered " + patient.getName());

	}

	@Override
	public void showPatientDetails(int patientId) {
		// TODO Auto-generated method stub
		Patient patient = patinetRecords.get(patientId);
		if (patient != null) {
			System.out.println("---------------------------");
			System.out.println("Patient ID  : " + patient.getId());
			System.out.println("Name        : " + patient.getName());
			System.out.println("Age         : " + patient.getAge());
			System.out.println("Illness     : " + patient.getIllness());
			System.out.println("---------------------------");
		} else {
			System.out.println("Patient with ID " + patientId + " not found.");
		}

	}

}
