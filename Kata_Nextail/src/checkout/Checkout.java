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
	
	public Checkout (Hashtable<String, String> pricing_rules) {
		
	}

	public void scan() {
		System.out.print("Input next product: \n"); //Request user input
		String p = my_scanner.nextLine();	//User input
		my_products.add(p);
	
	}
	
}
