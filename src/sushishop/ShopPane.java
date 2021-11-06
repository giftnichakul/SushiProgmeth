package sushishop;


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


public class ShopPane extends Pane {
	

	private void createBackground(int width, int height) {
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
		createBackground(width, height);
		SushiGame sushiGame  = SushiGame.get();
		System.out.println(sushiGame.getInventories().size());
		
		ImageView rice  = new ImageView(sushiGame.getInventories().get(InventoryItemName.RICE).getImage());
		rice.setX(0);
		rice.setY(height*0.8);
		rice.setFitWidth(90);
		rice.setFitHeight(90);
		this.getChildren().add(rice);
		
		
		
	}

	
	

		

}
