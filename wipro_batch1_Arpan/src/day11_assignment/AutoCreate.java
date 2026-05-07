package day11_assignment;

import java.io.BufferedWriter;
import java.io.FileWriter;

/*public class AutoCreate {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileWriter fw = new FileWriter("sai.txt");
		fw.write("Hello!, welcome to Renu Sai's class!");
		fw.close();

		File file = new File("sai.txt");

		System.out.println("Done!, file created and written.");
		System.out.println("Absolutute path: " + file.getAbsolutePath());
		System.out.println("File length: " + file.length() + " bytes");

	}

}*/

public class AutoCreate {
	public static void main(String[] args) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("sonamoni.txt", true))) {
			writer.write("Hello janu");
			writer.write("Hi baby");
			writer.write("Let's hangout");
			System.out.println("File created and data written succesfully.");

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
