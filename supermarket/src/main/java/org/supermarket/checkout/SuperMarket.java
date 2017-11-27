package org.supermarket.checkout;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.supermarket.checkout.modal.Item;
import org.supermarket.checkout.util.SuperMarketUtil;

/**
 * 
 * Start the super market software
 * @author pankajmishra
 *
 */
@Configuration
public class SuperMarket {

	@Autowired
	private CheckOutManager checkoutSystem;

	@PostConstruct
	public void checkOutOrders() throws IOException {
		
		/**
		 * Item List to purchase from Super market, For example list of {"ItemId,itentityQuantity"} 
		 * Also, This input is taken as a sample input
		 */
		List<String> inputItemList = SuperMarketUtil.takeOrders();

		/** Checkout system for scan and checkout of input list of items */
		Map<String, Item> finalItemList = checkoutSystem.processOrders(inputItemList);

		/** Print final bill with total price */
		SuperMarketUtil.printFinalBill(finalItemList);
	}

	

}
