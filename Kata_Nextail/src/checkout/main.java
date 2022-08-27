/**
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
		
		Hashtable<String, Double> pricing_rules = new Hashtable<String, Double>(); 	//Create the pricing_rules object with the prices associated to the keys
		pricing_rules.put("VOUCHER", 5.00);
		pricing_rules.put("TSHIRT", 20.00);
		pricing_rules.put("PANTS", 7.50);
		List<String> my_products = new ArrayList<>();	//Create a list to store the products (initially null)
		Checkout my_checkout = new Checkout (pricing_rules);	//Create the checkout object with the pricing rules
		String product = my_checkout.scan();
		while(!product.equals("")) {
			my_products.add(product);
			product = my_checkout.scan();
		}
		
		double total = 0.0;
		int count_voucher=0;
		int count_tshirt=0;
		int count_pants=0;
		for (String p: my_products) { //Iterate over the list of products to find out the discounts
			if(p.equals("VOUCHER")) {
				count_voucher++;
			}else if(p.equals("TSHIRT")) {
				count_tshirt++;
			}
			else if(p.equals("PANTS")) {
				count_pants++;
			}
		}
		double price_tshirts = my_checkout.my_prices.get("TSHIRT");
		if(count_tshirt >=3) {
			price_tshirts--;
		}
		total = count_voucher%2*my_checkout.my_prices.get("VOUCHER") + count_tshirt*price_tshirts + count_pants*my_checkout.my_prices.get("PANTS");
		System.out.printf("Items: " + my_products + " - Total: %f.2€", total);
		

	}

}
