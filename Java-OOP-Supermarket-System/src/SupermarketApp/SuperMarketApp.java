package supermarket;

import java.io.*;
import java.util.*;

/**
 * Main application to simulate a supermarket checkout system.
 */
public class SuperMarketApp {

	// List of all available products
	private static List<Product> productList = new ArrayList<>();
	// List of products the user wants to buy
	private static List<Product> cart = new ArrayList<>();

	public static void main(String[] args) {
		loadProducts("products.txt"); // Load product data

		Scanner scanner = new Scanner(System.in); // Scanner for user input

		// Show available products
		System.out.println("*** Supermarket Product Menu ***");
		for (Product p : productList) {
			System.out.println("\n" + p);
		}

		// Prompt user to add items to cart
		String input;
		do {
			System.out.print("\nEnter product ID to add to cart (or type 'done' to finish): ");
			input = scanner.nextLine().trim();

			if (!input.equalsIgnoreCase("done")) {
				Product selected = findProductById(input);
				if (selected != null) {
					cart.add(selected);
					System.out.println(selected.getName() + " added to cart.");
				} else {
					System.out.println("Invalid ID. Please try again.");
				}
			}
		} while (!input.equalsIgnoreCase("done"));

		scanner.close();

		printDocket(); // Print final receipt
	}

	/**
	 * Loads products from a text file. Each line should start with F (FreshFruit)
	 * or P (PackagedItem).
	 */

	private static void loadProducts(String filename) {
		try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
			String line;

			while ((line = reader.readLine()) != null) {
				String[] tokens = line.split(",");
				if (tokens[0].equals("F")) {
					// Format: F,ID,Name,Price,Weight
					FreshFruit fruit = new FreshFruit(tokens[1], tokens[2], Double.parseDouble(tokens[3]),
							Double.parseDouble(tokens[4]));
					productList.add(fruit);

				} else if (tokens[0].equals("P")) {
					// Format: P,ID,Name,Price,Quantity,UseByDate
					PackagedItem item = new PackagedItem(tokens[1], tokens[2], Double.parseDouble(tokens[3]),
							Integer.parseInt(tokens[4]), tokens[5]);
					productList.add(item);
				}
			}

		} catch (IOException e) {
			System.err.println("Error reading file: " + e.getMessage());
		} catch (NumberFormatException e) {
			System.err.println("Error parsing number in file: " + e.getMessage());
		} catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("Malformed line in file: " + e.getMessage());
		}
	}

	/**
	 * Searches for a product by ID (case-insensitive).
	 */
	private static Product findProductById(String id) {
		for (Product p : productList) {
			if (p.getId().equalsIgnoreCase(id)) {
				return p;
			}
		}
		return null;
	}

	/**
	 * Displays all products in the cart and shows total + tax.
	 */
	private static void printDocket() {
		System.out.println("\n*** Purchase Docket ***");
		double total = 0.0;
		double totalTax = 0.0;

		for (Product p : cart) {
			System.out.println("\n" + p);
			total += p.getPrice();
			totalTax += p.getTaxComponent();
		}

		System.out.println("\n-----------------------------");
		System.out.printf("Total Tax: $%.2f%n", totalTax);
		System.out.printf("Total Due: $%.2f%n", total);
	}
}
