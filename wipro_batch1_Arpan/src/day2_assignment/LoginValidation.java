package day2_assignment;

public class LoginValidation {
	static String validUsername = "Donald Trump";
	static String validPassword = "911";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String username = "Donald Trump";
		String password = "911";

		if (username.equals(validUsername) && password.equals(validPassword)) {
			System.out.println("Login successful");
		} else {
			System.out.println("Login failed");
		}

	}

}
