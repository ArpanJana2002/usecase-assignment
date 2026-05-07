package day9_assignment;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("---------PATIENT DATA MANAGEMENT---------");
		PatientDataManagement pdm = new PatientDataManagement();
		pdm.addPatient("Ram", 20, "Corona");
		pdm.addPatient("Laxman", 25, "Flu");
		pdm.addPatient("Bharat", 30, "kleptomeniac");

		pdm.listPatients();
		System.out.println("\nSraech patient by name.");
		pdm.searchPatientByName("Laxman");

		// Emergency

		System.out.println("\n-----------HOSPITAL QUEUE-----------");
		HospitalQueue hq = new HospitalQueue();
		hq.addPatient("Arjun");
		hq.addPatient("Bhim");
		hq.addEmergency("Judhisthir");
		hq.addEmergency("Draupadi");

		hq.viewQueue();
		hq.checkFirstAndLast();
		hq.removePatient();
		hq.viewQueue();

	}

}
