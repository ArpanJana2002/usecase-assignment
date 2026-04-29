package day2_assignment;

public class FoodOrderSystem {
	static int menuChoice = 3;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String item;

		switch (menuChoice) {
		case 1:
			item = "Idli Sambar";
			break;
		case 2:
			item = "Paneer Butter Masala with Roti";
			break;
		case 3:
			item = "Samosa aur chai";
			break;
		default:
			item = "Invalid choice";
			break;
		}

		System.out.println("Menu Choice: " + menuChoice);
		System.out.println("Selected Item: " + item);

	}

}
