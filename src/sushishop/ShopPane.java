package sushishop;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import game.InventoryItem;
import game.InventoryItemName;
import game.RecipeName;
import game.SushiGame;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import scene.TopPane;


public class ShopPane extends GamePane implements Shopable {
	
	
	protected int width;
	protected int height;
	protected ArrayList<CustomerPane> seats = new ArrayList<CustomerPane>();
	public RecipeName current; 
	public SushiOutPane op;
	private void createBackground() {
		ImageView fuji = new ImageView(new Image("file:res/images/background_fuji_blur.jpg"));
		fuji.setX(0);
		fuji.setY(0);
		fuji.setFitWidth(width);
		fuji.setFitHeight(height*0.5);
		this.getChildren().add(fuji);
		
		ImageView table = new ImageView(new Image("file:res/images/table02.png"));
		table.setX(0);
		table.setY(height*0.5);
		table.setFitWidth(width);
		table.setFitHeight(height*0.25);
		this.getChildren().add(table);
		
		ImageView table2  = new ImageView(new Image("file:res/images/wood01.png"));
		table2.setX(0);
		table2.setY(height*0.7);
		table2.setFitWidth(width);
		table2.setFitHeight(height*0.3);
		this.getChildren().add(table2);
		
		
	}
	
	
	
	public ShopPane (int width,int height) {
		super();
		this.width = width;
		this.height = height;
		
		
		createBackground();	
		System.out.println(sushiGame.getInventories().size());
		drawIngredients();
		drawCustomers();
		//addinitRecipes();
		TopPane tp = new TopPane(SushiGame.get().getCurrentLevel());
		this.getChildren().add(tp.getTopPane());
		MakeSushiPane mp = new MakeSushiPane();
		op = new SushiOutPane();
		//CustomerPane c = new CustomerPane();
		mp.setTranslateX(500);
		mp.setTranslateY(height*0.85-90);
		this.addChildren(mp);
		mp.setOnMouseClicked((e)->{
			Set<InventoryItemName> sel = new HashSet<InventoryItemName>();
			for(Node node: ShopPane.this.getChildren()) {
				if(node instanceof MaterialPane) {
					MaterialPane m = (MaterialPane)node;
					if(m.isSelected() && m.getMaterialName().getQuantity()>0) {
						ShopPane.this.println(ShopPane.this.toString(),m.toString());
						sel.add(m.getMaterialName());
					}
				}
			}
			try {
				RecipeName r =Recipes.getRecipe(sel);
				
				ShopPane.this.println(ShopPane.this.toString(),r.toString());
				op.showImage(r);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				op.showImage(null);
				ShopPane.this.println(ShopPane.this.toString(),"No sush menu ediot!!"+e1.getMessage());
//				e1.printStackTrace();
//				e1.Exception("Recipe not found");
			}
		});
		
		op.setOnMouseClicked(new EventHandler<MouseEvent>() {
			//it detects once when the mouse is released.
			@Override
			public void handle(MouseEvent event) {
				if(op.currentSushi != null) {
					current = op.currentSushi;
				}
			}	
		});
		
		
		op.setTranslateX(500);
		op.setTranslateY(height*0.82);
		this.addChildren(op);
		
		
		//c.setTranslateX(200);
		//c.setTranslateY(height*0.23-8);
		//this.addChildren(c);
		
	
//		ImageView rice  = new ImageView(sushiGame.getInventories().get(InventoryItemName.RICE).getImage());
//		rice.setX(0+90);
//		rice.setY(height*0.85-90);
//		rice.setFitWidth(90);
//		rice.setFitHeight(90);
//		this.getChildren().add(rice);
		
		
		
		
		
	}
	
	protected void drawCustomers() {
		for(int i= 0;i< 5;i++) {
			CustomerPane cus = new CustomerPane(this);
			cus.setTranslateY(height*0.23-8);
			cus.setTranslateX(i*200+20);
			seats.add(cus);
			this.addChildren(cus);
		}
	}



	protected void drawIngredients() {
		
		
		List<InventoryItemName> lst = new ArrayList<>();
		InventoryItemName[] invName = new InventoryItemName[] {
				InventoryItemName.RICE,
				InventoryItemName.SALMON,
				InventoryItemName.TUNA,
				InventoryItemName.EBI,
				InventoryItemName.NORI,								
				InventoryItemName.TAMAGO,
				InventoryItemName.IKURA,
				InventoryItemName.SQUID,
				InventoryItemName.OCTOPUS,
		};
		
		int i =0;
		int imgSize = 85;
		for(InventoryItemName x: invName) {
			MaterialPane item  = new MaterialPane(x);
			item.setTranslateX(0+(imgSize+10)*(i/2)+5);
			item.setTranslateY(height*0.85-(imgSize)*(i%2));

			this.addChildren(item);
			i++;
		}
		
	}
	/*
	protected void addinitRecipes() {
		Recipes.add(RecipeName.SUSHI_SALMON, new InventoryItemName[] {InventoryItemName.SALMON,InventoryItemName.RICE});
		Recipes.add(RecipeName.SUSHI_TAMAGO, new InventoryItemName[] {InventoryItemName.TAMAGO,InventoryItemName.RICE});
		Recipes.add(RecipeName.SUSHI_TUNA, new InventoryItemName[] {InventoryItemName.TUNA,InventoryItemName.RICE});
		Recipes.add(RecipeName.SUSHI_OCTOPUS, new InventoryItemName[] {InventoryItemName.OCTOPUS,InventoryItemName.RICE});
	}*/



	@Override
	public RecipeName itemArrived() {
		// TODO Auto-generated method stub
		op.showImage(null);
		return current;
	}

	
	

		

}
