package game;

import javafx.scene.image.Image;

public class InventoryItem {
	protected InventoryItemName name;
	protected double price;
	protected int quantity;
	protected boolean enable;
	protected Image image;


	public InventoryItem(InventoryItemName name, double price, int quantity,boolean enable,Image image) {
		super();
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.enable = enable;
		this.image = image;
		
	}
	
	public InventoryItemName getName() {
		return name;
	}
	public void setName(InventoryItemName name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}
	
}