package day5_assignment;

public class UPIdemo {
	public static void main(String[] args) {
		Gpay gpay = new Gpay();
		phonePe phonePeObj = new phonePe();
		Paytm paytm = new Paytm();

		System.out.println("==============Gpay Tnx=============");
		gpay.processTnx(500, "abc@okcici");
		// Initial: 10000 → After 500 payment: 9500

		System.out.println("\n==============Gpay Add Money=============");
		gpay.addMoney(100);
		// 9500 + 100 = 9600

		System.out.println("\n==============phonePe Tnx=============");
		phonePeObj.processTnx(-1200, "bcd@axis");

	}
}