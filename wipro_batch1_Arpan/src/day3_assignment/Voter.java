package day3_assignment;

public class Voter {
	private String name;
	private int age;
	private String voterId;
	private boolean hasVoted;

	public Voter(String voterId, String name, int age) {
		this.name = name;
		this.age = age;
		this.voterId = voterId;
		this.hasVoted = false;
	}

	public boolean isEligible() {
		return age >= 18;
	}

	public void vote() {
		if (!hasVoted) {
			hasVoted = true;
			System.out.println("Vote cast successfully.");
		} else {
			System.out.println("You have already voted!");
		}
	}

	public boolean hasVoted() {
		return hasVoted;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("\n---- Voting ----");
		Voter voter = new Voter("V123", "Naruto", 20);
		voter.vote();
		voter.vote(); // second attempt

	}

}
