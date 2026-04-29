package com.healthcare.doctor;

import com.healthcare.model.Patient;

public abstract class Doctor {
	private String name;
	private String specialization;

	public Doctor(String name, String specialization) {
		super();
		this.name = name;
		this.specialization = specialization;
	}

	public String getName() {
		return name;
	}

	public String getSpecialization() {
		return specialization;
	}

	public abstract void diagnose(Patient patient);

}
