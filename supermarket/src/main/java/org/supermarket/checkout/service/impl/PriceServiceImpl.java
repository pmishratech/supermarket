package org.supermarket.checkout.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.supermarket.checkout.modal.ItemDetail;
import org.supermarket.checkout.modal.Price;
import org.supermarket.checkout.service.PriceService;

/**
 * 
 * Service implementaion of Price service
 * @author pankajmishra
 *
 */
@Service
public class PriceServiceImpl implements PriceService {

	private static final Logger LOGGER = LoggerFactory.getLogger(PriceServiceImpl.class);

	@Override
	public Price calculatePrice(ItemDetail itemDetail, Integer itemQuantity) {
		Price price = new Price();
		//Checking if quantity of item falls for Discount
		if (itemDetail.getMinimumQuantityForDiscount() != null
				&& itemQuantity >= itemDetail.getMinimumQuantityForDiscount()) {
			int discountedChunks = itemQuantity / itemDetail.getMinimumQuantityForDiscount();
			int qunatityLeft = itemQuantity - itemDetail.getMinimumQuantityForDiscount() * discountedChunks;
			price.setDiscountedPrice(discountedChunks * itemDetail.getDiscountPrice());
			price.setNormalPrice(qunatityLeft * itemDetail.getPrice());
		} else {
			price.setDiscountedPrice(0L);
			price.setNormalPrice(itemQuantity * itemDetail.getPrice());
		}
		LOGGER.debug("price for item: " + itemDetail + "Is : " + price);
		return price;
	}

}
