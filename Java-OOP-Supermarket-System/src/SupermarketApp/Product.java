package supermarket;

/**
 * This is the superclass for all types of products in the supermarket. It
 * stores common details like ID, name, type, and price.
 */
public class Product {
	protected String id; // Unique product ID
	protected String name; // Name of the product
	protected String type; // Type/category of the product
	protected double price; // Price of the product

	/**
	 * Constructor to initialize all product attributes.
	 */
	public Product(String id, String name, String type, double price) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.price = price;
	}

	// Getters (accessor methods) to retrieve values
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public double getPrice() {
		return price;
	}

	/**
	 * Calculates the tax component of the product. By default, returns 0.
	 * Subclasses override this method.
	 */
	public double getTaxComponent() {
		return 0.0;
	}

	/**
	 * Returns a string representation of the product. Includes ID, name, type,
	 * price, and tax.
	 */
	@Override
	public String toString() {
		return "ID: " + id + "\nName: " + name + "\nType: " + type + "\nPrice: $" + String.format("%.2f", price)
				+ "\nTax: $" + String.format("%.2f", getTaxComponent());
	}
}
