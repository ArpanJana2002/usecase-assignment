package day7_assignment;

class Order implements Runnable {
	@Override
	public void run() {
		try {
			System.out.println("Order received: Momo & soup - Thread: " + Thread.currentThread().getName());
			Thread.sleep(1000);

			System.out.println("Order is being prepared...");
			Thread.sleep(2000);

			System.out.println("Order is ready!");
		} catch (InterruptedException e) {
			System.out.println("Order thread interrupted!");
		}
	}
}

class Payment implements Runnable {
	@Override
	public void run() {
		try {
			System.out.println("Payment processing started - Thread: " + Thread.currentThread().getName());
			Thread.sleep(500);

			System.out.println("Charging card...");
			Thread.sleep(1500);

			System.out.println("Payment successful!");
		} catch (InterruptedException e) {
			System.out.println("Payment thread interrupted!");
		}
	}
}

class Notification implements Runnable {
	@Override
	public void run() {
		try {
			System.out.println("Notification service started - Thread: " + Thread.currentThread().getName());
			Thread.sleep(1000);

			System.out.println("Sending SMS: Your order is confirmed!");
			Thread.sleep(500);

			System.out.println("Sending Email: Thank you for your order!");
		} catch (InterruptedException e) {
			System.out.println("Notification thread interrupted!");
		}
	}
}

public class FoodOrderDemo {

	public static void main(String[] args) {

		Thread paymentThread = new Thread(new Payment());
		Thread orderThread = new Thread(new Order());
		Thread notificationThread = new Thread(new Notification());

		paymentThread.setName("Payment-Thread");
		orderThread.setName("Order-Thread");
		notificationThread.setName("Notification-Thread");

		paymentThread.setPriority(Thread.MAX_PRIORITY);
		orderThread.setPriority(Thread.NORM_PRIORITY);
		notificationThread.setPriority(Thread.MIN_PRIORITY);

		try {
			// PAYMENT
			paymentThread.start();
			if (paymentThread.isAlive()) {
				System.out.println("Payment is in progress...");
			}
			paymentThread.join();
			System.out.println("--- Payment completed ---\n");

			// ORDER
			orderThread.start();
			if (orderThread.isAlive()) {
				System.out.println("Order preparation started...");
			}
			orderThread.join();
			System.out.println("--- Order completed ---\n");

			// NOTIFICATION
			notificationThread.start();
			if (notificationThread.isAlive()) {
				System.out.println("Notification service running...");
			}
			notificationThread.join();
			System.out.println("--- Notification completed ---");

		} catch (InterruptedException e) {
			System.out.println("Main thread interrupted!");
		}

		System.out.println("=== Food Order Process Finished ===");
	}
}

// ================== Without Join================

/*
 * package day7_assignment;
 * 
 * class Order implements Runnable {
 * 
 * @Override public void run() { try {
 * System.out.println("Order received: Momo & soup - Thread: " +
 * Thread.currentThread().getName()); Thread.sleep(1000);
 * 
 * System.out.println("Order is being prepared..."); Thread.sleep(2000);
 * 
 * System.out.println("Order is ready!"); } catch (InterruptedException e) {
 * System.out.println("Order thread interrupted!"); } } }
 * 
 * class Payment implements Runnable {
 * 
 * @Override public void run() { try {
 * System.out.println("Payment processing started - Thread: " +
 * Thread.currentThread().getName()); Thread.sleep(500);
 * 
 * System.out.println("Charging card..."); Thread.sleep(1500);
 * 
 * System.out.println("Payment successful!"); } catch (InterruptedException e) {
 * System.out.println("Payment thread interrupted!"); } } }
 * 
 * class Notification implements Runnable {
 * 
 * @Override public void run() { try {
 * System.out.println("Notification service started - Thread: " +
 * Thread.currentThread().getName()); Thread.sleep(1000);
 * 
 * System.out.println("Sending SMS: Your order is confirmed!");
 * Thread.sleep(500);
 * 
 * System.out.println("Sending Email: Thank you for your order!"); } catch
 * (InterruptedException e) {
 * System.out.println("Notification thread interrupted!"); } } }
 * 
 * public class FoodOrderDemo {
 * 
 * public static void main(String[] args) {
 * 
 * Thread orderThread = new Thread(new Order(), "Order-Thread"); Thread
 * paymentThread = new Thread(new Payment(), "Payment-Thread"); Thread
 * notificationThread = new Thread(new Notification(), "Notification-Thread");
 * 
 * // Start all threads (no waiting) orderThread.start(); paymentThread.start();
 * notificationThread.start();
 * 
 * System.out.println("=== Main thread finished (not waiting) ==="); } }
 */