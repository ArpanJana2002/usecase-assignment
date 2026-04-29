package day3_assignment;

public class Patient {
	private String name;
	private String medicalHistory;

	public Patient(String name, String medicalHistory) {
		super();
		this.name = name;
		this.medicalHistory = medicalHistory;
	}

	public String getMedicalHistory(String role) {
		if (role.equals("Doctor")) {
			return medicalHistory;
		}
		return "Access denied!";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("\n---- Patient ----");
		Patient p = new Patient("Putin", "Sizophrenia");
		System.out.println("Doctor Access: " + p.getMedicalHistory("Doctor"));
		System.out.println("User Access: " + p.getMedicalHistory("User"));

	}

}
