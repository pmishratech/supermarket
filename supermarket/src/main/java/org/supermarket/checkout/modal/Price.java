package org.supermarket.checkout.modal;

/**
 * 
 * Modal class responsible for price
 * 
 * @author pankajmishra
 *
 */
public class Price {

	private Long normalPrice;
	private Long discountedPrice;

	public Long getNormalPrice() {
		return normalPrice;
	}

	public void setNormalPrice(Long singleItemPrice) {
		this.normalPrice = singleItemPrice;
	}

	public Long getDiscountedPrice() {
		return discountedPrice;
	}

	public void setDiscountedPrice(Long discountedPrice) {
		this.discountedPrice = discountedPrice;
	}

	@Override
	public String toString() {
		return "Price [singleItemPrice=" + normalPrice + ", discountedPrice=" + discountedPrice + "]";
	}

}
