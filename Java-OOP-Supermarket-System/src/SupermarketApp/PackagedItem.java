package supermarket;

/**
 * Represents a packaged item in the supermarket. Adds quantity and use-by date
 * to the basic product info.
 */
public class PackagedItem extends Product {
	private int quantity; // Number of items in package
	private String useByDate; // Expiry date

	/**
	 * Constructor to initialize all attributes of PackagedItem.
	 */
	public PackagedItem(String id, String name, double price, int quantity, String useByDate) {
		super(id, name, "Packaged Item", price); // Call Product constructor
		this.quantity = quantity;
		this.useByDate = useByDate;
	}

	// Getters and setters
	public int getQuantity() {
		return quantity;
	}

	public String getUseByDate() {
		return useByDate;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setUseByDate(String useByDate) {
		this.useByDate = useByDate;
	}

	/**
	 * Override: Packaged items are taxed at 10%.
	 */
	@Override
	public double getTaxComponent() {
		return price * 0.10;
	}

	/**
	 * Override: Add quantity and expiry to the output.
	 */
	@Override
	public String toString() {
		return super.toString() + "\nQuantity: " + quantity + "\nUse-By Date: " + useByDate;
	}
}
