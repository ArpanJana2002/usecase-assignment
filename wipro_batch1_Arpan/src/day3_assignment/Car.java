package day3_assignment;

public class Car {
	private boolean engineOn;
	private int speed;
	private double fuelLevel;

	public Car(double fuelLevel) {
		super();
		this.engineOn = false;
		this.speed = 0;
		this.fuelLevel = fuelLevel;
	}

	public void startEngine() {
		if (fuelLevel > 0) {
			engineOn = true;
		}
	}

	public void accelerate() {
		if (engineOn && fuelLevel > 0) {
			speed += 20;
			fuelLevel -= 5;
		}
	}

	public int getSpeed() {
		return speed;
	}

	public double getFuelLevel() {
		return fuelLevel;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("\n---- Car ----");
		Car car = new Car(10);
		car.startEngine();
		car.accelerate();
		System.out.println("Speed: " + car.getSpeed());
		System.out.println("Fuel: " + car.getFuelLevel());

	}

}
