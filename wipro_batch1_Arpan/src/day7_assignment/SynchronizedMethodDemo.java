package day7_assignment;

class Counter {
	private int cnt = 0;

	public synchronized void increment() {
		cnt++;
	}

	public int getCount() {
		return cnt;
	}
}

public class SynchronizedMethodDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		Counter counter = new Counter();

		Runnable task = () -> {
			for (int i = 0; i < 100; i++) {
				counter.increment();
			}
		};

		Thread t1 = new Thread(task);
		Thread t2 = new Thread(task);

		t1.start();
		t2.start();

		t1.join();
		t2.join();

		System.out.println("Final count: " + counter.getCount());

	}

}
