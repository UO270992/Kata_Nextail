package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import checkout.Checkout;

class tests {
	Hashtable<String, Double> pricing_rules = new Hashtable<String, Double>();
	Checkout my_checkout = new Checkout (pricing_rules);;
	
	@Before
	void setUp() {		 	
		pricing_rules.put("VOUCHER", 5.00);
		pricing_rules.put("TSHIRT", 20.00);
		pricing_rules.put("PANTS", 7.50);	
	}
	
	@Test
	void test_voucher() {
		assertEquals(5, my_checkout.total_voucher(2, pricing_rules.get("PANTS")));
	}
	
	@Test
	void test_pants() {
		assertEquals(15, my_checkout.total_voucher(2, pricing_rules.get("PANTS")));
	}
	
	@Test
	void test_tshirt() {
		assertEquals(57, my_checkout.total_voucher(3, pricing_rules.get("TSHIRT")));
	}
	@Test
	void test_total() {
		List<String> my_products = new ArrayList<String>();
		my_products.add("VOUCHER");
		my_products.add("TSHIRT");
		my_products.add("VOUCHER");
		my_products.add("VOUCHER");
		my_products.add("PANTS");
		my_products.add("TSHIRT");
		my_products.add("TSHIRT");
		assertEquals(74.50, my_checkout.total_value(my_products));
	}

}
