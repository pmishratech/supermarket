package org.supermarket.checkout.modal;

/**
 * Modal class responsible for items and their final price
 * 
 * @author pankajmishra
 *
 */
public class Item {

	private String itemName;
	private Long itemId;
	private Integer itemQuantity;
	private Price price;
	private String itemDescription;

	public Item(String itemName, Long itemId, Integer itemQuantity, Price price, String itemDescription) {
		super();
		this.itemName = itemName;
		this.itemId = itemId;
		this.itemQuantity = itemQuantity;
		this.price = price;
		this.itemDescription = itemDescription;
	}

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

	public Integer getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(Integer itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	@Override
	public String toString() {
		return "Item [itemName=" + itemName + ", itemId=" + itemId + ", itemQuantity=" + itemQuantity + ", price="
				+ price + ", itemDescription=" + itemDescription + "]";
	}
}
