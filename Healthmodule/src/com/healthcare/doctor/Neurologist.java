package com.healthcare.doctor;

import com.healthcare.model.Patient;

public class Neurologist extends Doctor {

	public Neurologist(String name) {
		super(name, "Neurology");
		// TODO Auto-generated constructor stub
	}

	@Override
	public void diagnose(Patient patient) {
		// TODO Auto-generated method stub
		System.out.println("Dr. " + getName() + " (Neurology) diagnosing patient: " + patient.getName());
		System.out.println("Illness reported: " + patient.getIllness());
		if (patient.getIllness().toLowerCase().contains("nerve")) {
			System.out.println("Advice: Immediate Neural diagnosis required.");
		} else {
			System.out.println("Advice: No nerve disease detected. Refer to a general physician.");
		}
		System.out.println();

	}

}
