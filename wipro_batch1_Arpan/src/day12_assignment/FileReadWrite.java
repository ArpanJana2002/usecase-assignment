package day12_assignment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

public class FileReadWrite {
	static final String FILE_NAME = "demo.txt";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		writeFile();
		readFile();

	}

	@SuppressWarnings("resource")
	private static void writeFile() {
		// TODO Auto-generated method stub
		System.out.println("---------WRITING TO FILE-------");
		try {
			FileWriter fileWriter = new FileWriter(FILE_NAME);

			fileWriter.write("Name: Virat Kohli\n");
			fileWriter.write("Age: 37\n");
			fileWriter.write("Test Centuries: 30\n");
			fileWriter.write("Franchaise: RCB\n");

			fileWriter.close();

			System.out.println("File written successfully!");

			File f = new File(FILE_NAME);
			System.out.println("File Name : " + f.getName());
			System.out.println("File Path : " + f.getAbsolutePath());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println();

	}

	private static void readFile() {
		// TODO Auto-generated method stub
		System.out.println("---------Reading files---------");
		try {
			FileReader fileReader = new FileReader(FILE_NAME);
			int ch;
			while ((ch = fileReader.read()) != -1) {
				System.out.print((char) ch);
			}
			fileReader.close();
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
