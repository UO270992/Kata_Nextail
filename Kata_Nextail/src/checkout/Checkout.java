/**
 * 
 */
package checkout;

import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

/**
 * @author ChristianGm
 *
 */
public class Checkout {
	List<String> my_products;
	Scanner my_scanner = new Scanner(System.in);
	Hashtable<String, Double> my_prices;
	
	public Checkout (Hashtable<String, Double> pricing_rules) {
		my_prices = pricing_rules;
	}

	public String scan() {
		System.out.print("Input next product: \n"); //Request user input
		String s = my_scanner.nextLine();	//User input
		return s;
	
	}
	
}
