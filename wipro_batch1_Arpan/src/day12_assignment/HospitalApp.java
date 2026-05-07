package day12_assignment;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class HospitalApp {
	public static void savePatient(String patientId, String name, int age, String disease) {
		String filename = "patients.txt";
		try (PrintWriter out = new PrintWriter(new FileWriter(filename, true))) {
			out.println(patientId + "," + name + "," + age + "," + disease);
		} catch (IOException e) {
			System.err.println("Error saving patient: " + e.getMessage());
		}
	}

	public static void generateReport(String patientId, String diagnosis, String treatment) {
		String filename = "report_" + patientId + ".txt";
		try (PrintWriter out = new PrintWriter(new FileWriter(filename))) {
			out.println("Patient ID: " + patientId);
			out.println("Diagnosis: " + diagnosis);
			out.println("Treatment: " + treatment);
			out.println("Generated on: " + new Date());
		} catch (IOException e) {
			System.err.println("Error generating report: " + e.getMessage());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		savePatient("P001", "Rahul", 32, "Fever");
		generateReport("P001", "Viral Fever", "Rest + Hydration");

	}

}
