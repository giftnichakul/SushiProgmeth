package sushishop;


import java.util.ArrayList;
import java.util.List;

import game.InventoryItem;
import game.InventoryItemName;
import game.SushiGame;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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


public class ShopPane extends GamePane {
	
	
	protected int width;
	protected int height;
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
		MakeSushiPane mp = new MakeSushiPane();
		mp.setTranslateX(800);
		mp.setTranslateY(height*0.85-90);
		this.addChildren(mp);
	
//		ImageView rice  = new ImageView(sushiGame.getInventories().get(InventoryItemName.RICE).getImage());
//		rice.setX(0+90);
//		rice.setY(height*0.85-90);
//		rice.setFitWidth(90);
//		rice.setFitHeight(90);
//		this.getChildren().add(rice);
		
		
		
		
		
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

	
	

		

}
