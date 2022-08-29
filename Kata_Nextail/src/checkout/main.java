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
		
		List<String> my_products = new ArrayList<>();	//Create a list to store the products (initially empty)
		Checkout my_checkout = new Checkout (pricing_rules);	//Create the checkout object with the pricing rules defined
		
		//Infinite loop to scan products
		String product = my_checkout.scan();
		while(!product.equals("")) {
			if(pricing_rules.containsKey(product)) {
				my_products.add(product);
				product = my_checkout.scan();
			}
			else { //If wrong code print out error and request next product
				System.out.printf("That product does not exist in the system.\nThe available options are:\n");
				for (String s: pricing_rules.keySet()) {
					System.out.printf("\t%s\n",s.toString());
				}
				product = my_checkout.scan();
			}
		}
		
		//Find out how many items of each type there are (required to apply discounts)
		int count_voucher=0;
		int count_tshirt=0;
		int count_pants=0;
		for (String p: my_products) { 
			if(p.equals("VOUCHER")) {
				count_voucher++;
			}else if(p.equals("TSHIRT")) {
				count_tshirt++;
			}
			else if(p.equals("PANTS")) {
				count_pants++;
			}
		}
	
		//Calculate the total cost
		double total = total_voucher(count_voucher, my_checkout.my_prices.get("VOUCHER")) + total_tshirt(count_tshirt, my_checkout.my_prices.get("TSHIRT")) + total_pants(count_pants,my_checkout.my_prices.get("PANTS"));
		System.out.printf("Items: " + my_products + " - Total: %.2f€", total);
		
	}

	public static double total_voucher(int n_items, double price) {
		return ((n_items+1)/2)*price;
	}
	
	public static double total_tshirt(int n_items, double price) {
		if (n_items>=3) {
			return n_items*price-1;
		}
		return n_items*price;
	}
	
	public static double total_pants(int n_items, double price) {
		return n_items*price;
	}
}
