package com.healthcare.doctor;

import com.healthcare.model.Patient;

public class GeneralPhysician extends Doctor {

	public GeneralPhysician(String name) {
		super(name, "Medicine");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void diagnose(Patient patient) {
		// TODO Auto-generated method stub
		System.out.println("Dr. " + getName() + " (General Physician) diagnosing patient: " + patient.getName());
		System.out.println("Illness reported: " + patient.getIllness());
		System.out.println("Advice: Rest well, stay hydrated, and take general medication.");
		System.out.println();

	}

}
