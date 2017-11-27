package org.supermarket;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.supermarket.checkout.modal.Item;
import org.supermarket.checkout.modal.ItemDetail;
import org.supermarket.checkout.modal.Price;
import org.supermarket.checkout.service.CheckOutService;
import org.supermarket.checkout.service.PriceService;
import org.supermarket.checkout.util.SuperMarketUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LaunchApplicationTests {

	@Autowired
	CheckOutService checkoutService;

	@Autowired
	PriceService priceService;

	private static Map<Long, ItemDetail> stock;

	@Test
	public void testCheckOutService() {
		Item item = checkoutService.checkOut(1001L, 1);
		assertNotNull(item);
	}

	@Test
	public void testloadStock() {
		stock = SuperMarketUtil.loadStockOfItems();
		assertNotNull(stock);
	}

	@Test
	public void testInputFile() throws IOException {
		List<String> inputItemList = SuperMarketUtil.takeOrders();
		assertNotNull(inputItemList);
		;
	}

	@Test
	public void testPriceService() {
		Price price = priceService.calculatePrice(stock.get(1001L), 1);
		assertNotNull(price);
	}

}
