package CapstoneProject.models;

public class Battery {
	private final String name;
	private int charge; // current charge per KW
	private int capacity; // KW

	public Battery(String name, int capacity) throws Exception {
		this(name, capacity, 0);
	}

	public Battery(String name, int capacity, int charge) throws Exception {
		this.name = name;
		if(charge > capacity)
			throw new Exception("charge could not be more than capacity");
		this.capacity = capacity;
		this.charge = charge;
	}

	public String getName() {
		return name;
	}

	public int getCapacity() {
		return capacity;
	}

	public int getCharge() {
		return charge;
	}

	public void discharge(int amount) {
		charge = Math.max(0, charge - amount);
	}

	public void recharge(int amount) {
		charge = Math.min(charge + amount, capacity);
	}

	public int getChargePercentage() {
		return (charge * 100) / capacity; // Convert charge to percentage
	}
	
	public boolean isFull() {
		 return charge == capacity;
	}

	public boolean isEmpty() {
		return charge == 0;
	}
}
