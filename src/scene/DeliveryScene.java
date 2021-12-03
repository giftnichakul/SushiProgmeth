package scene;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class DeliveryScene extends ScenePane{
	
	private AnchorPane deliveryPane;
	private GameButton backToPlay;
	private Label money;
	private MediaPlayer soundBackground;
	private ArrayList<sellItemPane> itemInventory;
	
	public DeliveryScene() {
		this.soundBackground = new MediaPlayer(new Media(ClassLoader.getSystemResource("sounds/backgroundGame1.mp3").toString()));
		Font font1 = this.getFont("Algerian", 120);
		Font font2 = this.getFont("Courier New", 24);
		
		deliveryPane = new AnchorPane();
		deliveryPane.setMaxWidth(1000);
		deliveryPane.setMaxHeight(600);
		deliveryPane.setBackground(this.getBackground("shopBackground1.jpg"));
		
		//shop background
		ImageView shopBackground = this.getImageView("orderBackground.png", 900, 400);
		AnchorPane.setLeftAnchor(shopBackground, 55.0);
		AnchorPane.setTopAnchor(shopBackground, 90.0);
		
		//name shop
		Label shop = this.getLabel("SHOP", font1, Color.WHITE);
		AnchorPane.setLeftAnchor(shop, 365.0);
		AnchorPane.setTopAnchor(shop, 15.0);
		
		//item
		initItems();
		GridPane items = this.getItemsPane();
		AnchorPane.setLeftAnchor(items, 132.0);
		AnchorPane.setTopAnchor(items, 127.0);
		
		ImageView moneyBackground = this.getImageView("level.png", 320, 80);
		AnchorPane.setLeftAnchor(moneyBackground, 110.0);
		AnchorPane.setTopAnchor(moneyBackground, 500.0);
		
		//current Money
		Label currentMoney = this.getLabel("Current Money $", font2, Color.BLACK);
		AnchorPane.setLeftAnchor(currentMoney, 140.0);
		AnchorPane.setTopAnchor(currentMoney, 525.0);
		
		//money
		setMoney(400);
		AnchorPane.setLeftAnchor(money, 360.0);
		AnchorPane.setTopAnchor(money, 525.0);
		
		//Go back to game
		backToPlay = new GameButton(80 , 300, "Go Back To Game", 24, Color.BLACK);
		backToPlay.setBackgroundButton("backToGameButton.png");
		/*NEED TO BE THE SAME SCREEN!!!!!!*/
		backToPlay.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				new Thread(()->{	
					setSceneOn(SceneController.stage, new GameScene());
				}).start();	
			}
		});
		AnchorPane.setLeftAnchor(backToPlay, 630.0);
		AnchorPane.setTopAnchor(backToPlay, 500.0);
		
		deliveryPane.getChildren().addAll(shopBackground,shop,items,backToPlay, moneyBackground, currentMoney, money);
		
	}
	
	public AnchorPane getPane() {
		return deliveryPane;
	}
	
	public GridPane getItemsPane() {
		GridPane items = new GridPane();
		items.setPrefHeight(300);
		items.setPrefWidth(750);
//		for(int i = 0; i < 5;i++) {
//			for(int k = 0; k < 2;k++) {
//				sellItemPane item = new sellItemPane(5,"");
//				items.add(item, i, k);
//			}
//		}
		for(int i = 0; i < itemInventory.size(); i++) {
			items.add(this.itemInventory.get(i), i%5, i < 5 ? 0 : 1);
		}
		return items;
		
	}
	
	public void setMoney(int moneys) {
		Font font2 = this.getFont("Courier New", 24);
		money = this.getLabel(""+moneys, font2, Color.BLACK);
		money.setPrefWidth(300);
		money.setMaxHeight(80);
	}
	
	public MediaPlayer getSoundBackground() {
		return this.soundBackground;
	}
	
	public void initItems() {
		this.itemInventory = new ArrayList<sellItemPane>();
		itemInventory.add(new sellItemPane(5, "nori2.png"));
		itemInventory.add(new sellItemPane(5, "rice1.png"));
		itemInventory.add(new sellItemPane(6, "tamago.png"));
		itemInventory.add(new sellItemPane(6, "ebi.png"));
		itemInventory.add(new sellItemPane(6, "shrimp.png"));
		itemInventory.add(new sellItemPane(6, "salmon.png"));
		itemInventory.add(new sellItemPane(6, "tuna.png"));
		itemInventory.add(new sellItemPane(6, "squid.png"));
		itemInventory.add(new sellItemPane(6, "salmonGrill.png"));
	}

}
