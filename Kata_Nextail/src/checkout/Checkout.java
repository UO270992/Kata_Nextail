/** Backend exercise Nextail
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
	List<String> my_products; //At the moment this is not used. Not escalable at the moment.
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
	
	//Methods to calculate the prices
	public double total_voucher(int n_items, double price) {
		return ((n_items+1)/2)*price;
	}
		
	public double total_tshirt(int n_items, double price) {
		if (n_items>=3) {
			return n_items*(price-1);
		}
		return n_items*price;
	}
		
	public double total_pants(int n_items, double price) {
		return n_items*price;
	}
	
	//Calculate the total amount in the list of products
	public double total_value(List<Product> my_products) {
		
		//Find out how many items of each type there are (required to apply discounts)
		int count_voucher=0;
		int count_tshirt=0;
		int count_pants=0;
		for (Product p: my_products) {
			switch(p.code) {
				case "VOUCHER":
					count_voucher++;
					break;
				case "TSHIRT":					
					count_tshirt++;
					break;
				case "PANTS":
					count_pants++;
					break;
				}
		}
		return total_tshirt(count_tshirt,my_prices.get("TSHIRT"))+total_pants(count_pants, my_prices.get("PANTS"))+total_voucher(count_voucher, my_prices.get("VOUCHER"));
	}
}
