/** Backend exercise Nextail
 * 
 */
package checkout;


import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 * @author ChristianGm
 *
 */
public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//Create the pricing_rules object with the prices associated to the keys
		Hashtable<String, Double> pricing_rules = new Hashtable<String, Double>(); 	
		pricing_rules.put("VOUCHER", 5.00);
		pricing_rules.put("TSHIRT", 20.00);
		pricing_rules.put("PANTS", 7.50);
		
		List<String> my_products = new ArrayList<>();	//Create a list to store the products string format (initially empty)
		List<Product> list_products = new ArrayList<>(); //Create a list to store the objects
		Checkout my_checkout = new Checkout (pricing_rules);	//Create the checkout object with the pricing rules defined
		
		//Infinite loop to scan products
		String product_s = my_checkout.scan();
		Product product;
		while(!product_s.equals("")) {
			if(pricing_rules.containsKey(product_s)) {
				switch (product_s) {
					case "VOUCHER":
						product = new Voucher();
						list_products.add(product);
						my_products.add("VOUCHER");
						break;
					case "TSHIRT":
						product = new Tshirt();
						list_products.add(product);
						my_products.add("TSHIRT");
						break;
					case "PANTS":
						product = new Pants();
						list_products.add(product);
						my_products.add("PANTS");
						break;
				}
				product_s = my_checkout.scan();
			}
			else { //If wrong code print out error and request next product
				System.out.printf("That product does not exist in the system.\nThe available options are:\n");
				for (String s: pricing_rules.keySet()) {
					System.out.printf("\t%s\n",s.toString());
				}
				product_s = my_checkout.scan();
			}
		}
		
		//Calculate the total cost
		double total = my_checkout.total_value(list_products);
		System.out.printf("Items: " + my_products + " - Total: %.2f€", total);
	}

}
