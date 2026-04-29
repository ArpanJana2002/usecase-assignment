package com.healthcare.service;

import com.healthcare.model.Patient;

public interface PatientService {
	void registerPatient(Patient patient);

	void showPatientDetails(int patientId);

}
