package org.supermarket.checkout.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.supermarket.checkout.modal.Item;
import org.supermarket.checkout.modal.ItemDetail;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Supermarket Utility class which will perform some static loading which are required once
 * 
 * @author pankajmishra
 *
 */
public class SuperMarketUtil {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SuperMarketUtil.class);

	/**
	 * Method responsible for taking input from external system.
	 * 
	 * @return
	 * @throws IOException 
	 */
	public static List<String> takeOrders() throws IOException {
		LOGGER.debug("Started taking orders !!");
		ArrayList<String> inputItemList = new ArrayList<String>();
		Scanner input = new Scanner(new ClassPathResource(SuperMarketConstants.INPUT_FILE).getFile());
		while (input.hasNext()) {
			inputItemList.add(input.next());
		}
		input.close();
		return inputItemList;
	}
	
	/**
	 * Method responsible for loading stocks
	 * @return
	 */
	public static Map<Long, ItemDetail> loadStockOfItems() {

		Map<Long, ItemDetail> stock = null;
		ObjectMapper objectMapper = new ObjectMapper();

		// read json file data to String
		byte[] jsonData;
		try {
			jsonData = Files.readAllBytes(Paths.get(new ClassPathResource(SuperMarketConstants.STOCK_FILE).getURI()));
			// Convert JSON string to list of Item Detail
			List<ItemDetail> listOfItemDetails = Arrays.asList(objectMapper.readValue(jsonData, ItemDetail[].class));
			stock = listOfItemDetails.stream()
					.collect(Collectors.toMap(ItemDetail::getItemId, itemDetail -> itemDetail));

		} catch (IOException e) {
			LOGGER.debug("Parsing exception: "+ e.getMessage());
		}
		return stock;
	}

	/**
	 * Printing final bill and price of items
	 * @param finalItemList
	 */
	public static void printFinalBill(Map<String, Item> finalItemList) {
		List<Item> itemList = finalItemList.values().stream().collect(Collectors.toList());
		System.out.println("Bill Of Items: ");
		System.out.println("-------------------------------------------------------------------");
		System.out.println("Item Name | Item Quantity | Single ItemPrice | Discount Price");
		for (Item item : itemList) {
			System.out.println(item.getItemName() + " | " + item.getItemQuantity() + " | "
					+ item.getPrice().getNormalPrice() + " | " + item.getPrice().getDiscountedPrice());
		}
		System.out.println("-------------------------------------------------------------------");
		System.out.println("Total Price: " + itemList.stream()
				.mapToLong(item -> item.getPrice().getNormalPrice() + item.getPrice().getDiscountedPrice()).sum());
	}
}
