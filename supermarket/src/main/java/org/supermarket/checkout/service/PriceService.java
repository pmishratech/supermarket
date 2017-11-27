package org.supermarket.checkout.service;

import org.supermarket.checkout.modal.ItemDetail;
import org.supermarket.checkout.modal.Price;

/**
 * 
 * Interface for Price Service
 * @author pankajmishra
 *
 */
public interface PriceService {

	Price calculatePrice(ItemDetail itemDetail, Integer itemQuantity);

}
