package scene;

import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class DeliveryScene {
	
	private AnchorPane deliveryPane;
	private GameButton backToPlay;
	private ImageView shopBackground;
	private Label shop;
	private Label currentMoney;
	private Font font1 = Font.font("Algerian", FontWeight.BOLD, 120);
	private Font font2 = Font.font("Courier New", FontWeight.BOLD, 24);
	
	public DeliveryScene() {
		
		deliveryPane = new AnchorPane();
		deliveryPane .setMaxWidth(1000);
		deliveryPane .setMaxHeight(600);
		Image imageBackground = new Image("file:res/images/shopBackground1.jpg");
		BackgroundImage backgroundImage = new BackgroundImage( imageBackground, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
		Background background = new Background(backgroundImage);
		deliveryPane.setBackground(background);
		
		//shop background
		shopBackground = new ImageView(new Image("file:res/images/orderBackground.png"));
		shopBackground.setFitHeight(400);
		shopBackground.setFitWidth(900);
		
		AnchorPane.setLeftAnchor(shopBackground, 55.0);
		AnchorPane.setTopAnchor(shopBackground, 90.0);
		
		//name shop
		shop = new Label("SHOP"); 
		shop.setFont(font1);
		shop.setTextFill(Color.WHITE);
		
		AnchorPane.setLeftAnchor(shop, 365.0);
		AnchorPane.setTopAnchor(shop, 15.0);
		
		//item
		GridPane items = this.getItemsPane();
		
		AnchorPane.setLeftAnchor(items, 132.0);
		AnchorPane.setTopAnchor(items, 127.0);
		
		//current Money
		currentMoney = new Label("Current Money ");
		currentMoney.setFont(font2);
		currentMoney.setTextFill(Color.BLACK);
		currentMoney.setPrefWidth(300);
		currentMoney.setMaxHeight(80);
		

		AnchorPane.setLeftAnchor(currentMoney, 150.0);
		AnchorPane.setTopAnchor(currentMoney, 510.0);
		
		//Go back to game
		backToPlay = new GameButton(80 , 300, "Go Back To Game", 24, Color.BLACK);
		backToPlay.setBackgroundButton("backToGameButton.png");
		AnchorPane.setLeftAnchor(backToPlay, 630.0);
		AnchorPane.setTopAnchor(backToPlay, 500.0);
		
		deliveryPane.getChildren().addAll(shopBackground,shop,items,backToPlay, currentMoney);
		
	}
	
	public AnchorPane getDeliveryPane() {
		return deliveryPane;
	}
	
	public GridPane getItemsPane() {
		GridPane items = new GridPane();
		items.setPrefHeight(300);
		items.setPrefWidth(750);
		
		for(int i = 0; i < 5;i++) {
			for(int k = 0; k < 2;k++) {
				sellItemPane item = new sellItemPane(5);
				items.add(item, i, k);
			}
		}
		return items;
		
	}

}
