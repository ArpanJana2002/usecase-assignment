package com.healthcare.model;

public class Patient {
	private int id;
	private String name;
	private int age;
	private String illness;

	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Patient(int id, String name, int age, String illness) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.illness = illness;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getIllness() {
		return illness;
	}

	public void setIllness(String illness) {
		this.illness = illness;
	}

}
