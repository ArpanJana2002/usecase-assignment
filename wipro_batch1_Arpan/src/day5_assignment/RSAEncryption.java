package day5_assignment;

public class RSAEncryption {
	private static final String SECRET_KEY = "sdbhRCBas82198^ye632c*r";

	public String encrypt(String data) {
		String str = new StringBuilder(data).reverse().toString();
		return "Encrypted data: " + SECRET_KEY.hashCode() + ":" + str;

	}

	public String decrypt(String encryptedData) {
		String[] parts = encryptedData.split(":", 3);
		return new StringBuilder(parts[2]).reverse().toString();

	}
}

class SecurityModule {
	public static void main(String[] args) {
		RSAEncryption rsa = new RSAEncryption();

		String original = "Password@123";
		String encrypted = rsa.encrypt(original);
		String decrypted = rsa.decrypt(encrypted);

		System.out.println("Original    : " + original);
		System.out.println("Encrypted   : " + encrypted);
		System.out.println("Decrypted   : " + decrypted);
	}
}
