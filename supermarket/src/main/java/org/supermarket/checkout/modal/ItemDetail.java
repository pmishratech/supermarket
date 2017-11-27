package org.supermarket.checkout.modal;

/**
 * Modal class responsible for Stock ItemDetail
 * 
 * @author pankajmishra
 *
 */
public class ItemDetail {
	private String itemName;
	private Long itemId;
	private Integer itemStock;
	private Long price;
	private String itemDescription;
	private Long discountPrice;
	private Integer minimumQuantityForDiscount;

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public Integer getItemStock() {
		return itemStock;
	}

	public void setItemStock(Integer itemStock) {
		this.itemStock = itemStock;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public Long getDiscountPrice() {
		return discountPrice;
	}

	public void setDiscountPrice(Long discountPrice) {
		this.discountPrice = discountPrice;
	}

	public Integer getMinimumQuantityForDiscount() {
		return minimumQuantityForDiscount;
	}

	public void setMinimumQuantityForDiscount(Integer minimumQuantityForDiscount) {
		this.minimumQuantityForDiscount = minimumQuantityForDiscount;
	}

	@Override
	public String toString() {
		return "ItemDetail [itemName=" + itemName + ", itemId=" + itemId + ", itemStock=" + itemStock + ", price=" + price
				+ ", itemDescription=" + itemDescription + ", discountPrice=" + discountPrice + ", minimumQuantityForDiscount="
				+ minimumQuantityForDiscount + "]";
	}

}
