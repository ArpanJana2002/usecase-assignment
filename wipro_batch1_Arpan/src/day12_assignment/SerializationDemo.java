package day12_assignment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class player implements Serializable {

	private static final long serialVersionUID = 1L;

	public String name;
	public String address;
	public int number;

	public void playerCheck() {
		System.out.println("Check player of " + name + " " + address);
	}
}

public class SerializationDemo {

	public static void main(String[] args) {
		serialize();
		deserialize();
	}

	@SuppressWarnings("resource")
	static void serialize() {

		System.out.println("==========SERIALIZATION===========");

		// Create and fill player object
		player player = new player();
		player.name = "Rohit Sharma";
		player.address = "Mumbai";
		player.number = 45;

		try {

			FileOutputStream fileOutputStream = new FileOutputStream("players.ser");

			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

			objectOutputStream.writeObject(player);

			objectOutputStream.close();
			fileOutputStream.close();

			System.out.println("Serialized data saved in players.ser");
			System.out.println("Name    : " + player.name);
			System.out.println("Address : " + player.address);
			System.out.println("Number  : " + player.number);

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println();
	}

	@SuppressWarnings("resource")
	static void deserialize() {

		System.out.println("================DESERIALIZE================");

		player player = null;

		try {

			FileInputStream fileInputStream = new FileInputStream("players.ser");

			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

			player = (player) objectInputStream.readObject();

			objectInputStream.close();
			fileInputStream.close();

			System.out.println("Object deserialized successfully!");
			System.out.println("Name    : " + player.name);
			System.out.println("Address : " + player.address);
			System.out.println("Number  : " + player.number);

			player.playerCheck();

		} catch (FileNotFoundException e) {

			System.out.println("File not found: " + e.getMessage());

		} catch (ClassNotFoundException e) {

			System.out.println("Class not found: " + e.getMessage());

		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}