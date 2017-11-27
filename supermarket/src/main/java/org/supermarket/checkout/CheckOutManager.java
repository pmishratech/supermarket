package org.supermarket.checkout;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.supermarket.checkout.modal.Item;
import org.supermarket.checkout.service.CheckOutService;

@Component
public class CheckOutManager {

	private static final Logger LOGGER = LoggerFactory.getLogger(CheckOutManager.class);

	@Autowired
	private CheckOutService checkOutService;
	
	/**
	 * Method responsible for performing scanning and checkout process of input
	 * items
	 * 
	 * @param inputItemList
	 * @return
	 */
	public Map<String, Item> processOrders(List<String> inputItemList) {
		Map<String, Item> checkOutList = new HashMap<>();

		// Scan every item and perform checkout
		for (Iterator<String> iterator = inputItemList.iterator(); iterator.hasNext();) {
			
			String inputItemDetail = (String) iterator.next();
			Long itemId = Long.valueOf(inputItemDetail.split(",")[0]);
			Integer itemQuantity = Integer.valueOf(inputItemDetail.split(",")[1]);
			
			Item item = checkOutService.checkOut(itemId, itemQuantity);
			if (item != null) {
				
				String key = item.getItemName() + " : " + item.getItemId();
				/**
				 * Re-Scan the item , If it comes again as an input and check if
				 * it is deserves for any further discount
				 */
				if (checkOutList.containsKey(key)) {
					Integer newItemQuantity = checkOutList.get(key).getItemQuantity() + itemQuantity;
					item = checkOutService.checkOut(itemId, newItemQuantity);
				}
				checkOutList.put(key, item);
				LOGGER.debug("Item processed for checkout: " + item);
			}

		}
		return checkOutList;
	}
}
