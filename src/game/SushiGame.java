package game;
import java.util.ArrayList;

import javafx.scene.image.Image;

import java.util.*;


public class SushiGame {
	
	
	private static SushiGame self;
	private int gold;
	private Map<InventoryItemName,InventoryItem> inventories = new HashMap<InventoryItemName,InventoryItem>();
	
	private SushiGame() {
		init();
	}
	public static SushiGame get() {
		if(self == null) {
			self = new SushiGame();
			
		}
		return self;
	}
	public int getGold() {
		return gold;
	}
	public void setGold(int gold) {
		this.gold = gold;
	}
	public Map<InventoryItemName,InventoryItem> getInventories() {
		return inventories;
	}
	protected void addInventory(InventoryItemName name, double price, int quantity,boolean enable,String imageFileName) {
		Image image = new Image("file:res/images/"+imageFileName);
		InventoryItem item = new InventoryItem(name,price,quantity,enable,image);
		inventories.put(name, item);
	}
	public void addInventory(InventoryItemName name, int quantity) throws Exception{
		if(inventories.containsKey(name)) {
			inventories.get(name).quantity += quantity;
		}
		else {
			throw new Exception("item "+ name+ " not found!");
		}
	}
	public Image getImage(String name) {
		Image image = new Image("file:res/images/"+name);
		return image;
	}
	public Image getImage(String name,int width,int height) {
		Image image = new Image("file:res/images/"+name,width,height,false,true);
		return image;
	}
	public Customer getRandomCustomer() {
		 int id =(int) ((Math.random() * Customer.values().length));
		 Customer c = Customer.getCustomerFromId(id);
		 System.out.println(id);
		 return c;
	}
	public RecipeName getRandomRecipe() {
		 int id =(int) ((Math.random() * RecipeName.values().length));
		 RecipeName n = RecipeName.getRecipeFromId(id);
		 return n;
	}
	
	public void init() {
		//add inventory
		addInventory(InventoryItemName.SALMON,2.0,2,true,"salmon01.png");
		addInventory(InventoryItemName.RICE,2.0,2,true,"rice02.png");
		addInventory(InventoryItemName.NORI,2.0,2,true,"nori01.png");
		addInventory(InventoryItemName.EBI,2.0,2,true,"shrimp01.png");
		addInventory(InventoryItemName.IKURA,2.0,2,true,"salmon_egg01.png");
		addInventory(InventoryItemName.OCTOPUS,2.0,2,true,"octopus01.png");
		addInventory(InventoryItemName.SQUID,2.0,2,true,"squid01.png");
		addInventory(InventoryItemName.TAMAGO,2.0,2,true,"tamago01.png");
		addInventory(InventoryItemName.TUNA,2.0,2,true,"tuna01.png");
	}
	
	
	


}
