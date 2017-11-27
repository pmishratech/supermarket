package org.supermarket.checkout.service;

import org.supermarket.checkout.modal.Item;

/**
 * 
 * Interface for CheckOutService
 * @author pankajmishra
 *
 */
public interface CheckOutService {

	Item checkOut(Long itemId, Integer itemQuantity);

}
