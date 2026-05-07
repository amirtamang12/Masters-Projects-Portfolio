package supermarket;

/**
 * Represents a fresh fruit item in the supermarket. Inherits common attributes
 * from Product and adds 'weight'.
 */
public class FreshFruit extends Product {
	private double weight; // Weight in grams

	/**
	 * Constructor to initialize all attributes of FreshFruit.
	 */
	public FreshFruit(String id, String name, double price, double weight) {
		super(id, name, "Fresh Fruit", price); // Calls Product constructor
		this.weight = weight;
	}

	// Getter and setter for weight
	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	/**
	 * Override: Fresh fruits have 0% tax, so return 0.
	 */
	@Override
	public double getTaxComponent() {
		return 0.0;
	}

	/**
	 * Override: Add weight info to the product's toString.
	 */
	@Override
	public String toString() {
		return super.toString() + "\nWeight: " + weight + "g";
	}
}
