package day9_assignment;

import java.util.LinkedList;

public class HospitalQueue {
	LinkedList<String> q = new LinkedList<>();

	// add patient normal days
	void addPatient(String name) {
		q.add(name);
		System.out.println(name + " added to queue");
	}

	// add patient at beginning if emergency happens
	void addEmergency(String name) {
		q.addFirst(name);
		System.out.println(name + " added patient at first due to emergency.");
	}

	void removePatient() {
		if (q.isEmpty()) {
			System.out.println("Queue is empty.");
			return;
		}
		String releasedPatient = q.remove();
		System.out.println(releasedPatient + " has been released");
	}

	void viewQueue() {
		if (q.isEmpty()) {
			System.out.println("Queue is empty.");
			return;
		}
		System.out.println("------Queue------");
		int i = 1;
		for (String name : q) {
			System.out.println(i++ + ". " + name);
		}
	}

	void checkFirstAndLast() {
		if (q.isEmpty()) {
			System.out.println("Queue is empty.");
			return;
		}
		System.out.println("first in the queue: " + q.getFirst());
		System.out.println("last in the queue: " + q.getLast());
	}

}
