/** Backend exercise Nextail
 * 
 */
package checkout;
/**
 * @author ChristianGm
 *
 */
public class Product {
	
	String name;
	String code;
	double Price;
	
	public Product (String name, String code, double price) {
		this.name = name;
		this.code = code;
		this.Price = price;
	}
	
	public double total() {
		return 0.0;
	}
	
}
