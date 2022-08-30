package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import checkout.Checkout;
import checkout.Pants;
import checkout.Product;
import checkout.Tshirt;
import checkout.Voucher;

class tests {
	Hashtable<String, Double> pricing_rules = new Hashtable<String, Double>();
	Checkout my_checkout = new Checkout(pricing_rules);
	
	//This @Before does not work, probably due to the JUnit version.
	@Before
	void onSetUp() {		 	
		pricing_rules.put("VOUCHER", 5.00);
		pricing_rules.put("TSHIRT", 20.00);
		pricing_rules.put("PANTS", 7.50);
		System.out.print(pricing_rules.get("VOUCHER"));
		my_checkout = new Checkout (pricing_rules);
	}
	
	@Test
	void test_voucher() {
		pricing_rules.put("VOUCHER", 5.00);
		assertEquals(5.00, my_checkout.total_voucher(2, pricing_rules.get("VOUCHER")));
	}
	
	@Test
	void test_pants() {
		pricing_rules.put("PANTS", 7.50);
		assertEquals(15.00, my_checkout.total_pants(2, pricing_rules.get("PANTS")));
	}
	
	@Test
	void test_tshirt() {
		pricing_rules.put("TSHIRT", 20.00);
		assertEquals(57.00, my_checkout.total_tshirt(3, pricing_rules.get("TSHIRT")));
	}
	
	

}
