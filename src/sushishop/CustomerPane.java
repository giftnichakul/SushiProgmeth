package sushishop;

import java.util.HashMap;
import java.util.Map;

import game.Customer;
import game.SushiGame;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import scene.MenuPane;

public class CustomerPane extends GamePane {
	private DialoguePane menu;
	private Customer c;
	protected Shopable shopable;
	private FoodPane foodTray;
	private ImageView customer;
	public CustomerPane(Shopable shopable) {
		// TODO Auto-generated constructor stub
		this.shopable = shopable;
		this.setPrefWidth(200);
		this.setPrefHeight(280);
		//menu = new MenuPane("");
		c = SushiGame.get().getRandomCustomer();
		menu = new DialoguePane(c);
		foodTray = new FoodPane();
		customer  = new ImageView(SushiGame.get().getImage(c.smileFile));
		this.getChildren().addAll(menu,customer,foodTray);
		customer.setFitHeight(170);
		customer.setFitWidth(115);
		//customer.setTranslateX(10);
		menu.setTranslateY(-80);
		menu.setTranslateX(-7);
		foodTray.setTranslateX(-15);
		foodTray.setTranslateY(170);
//		menu.setPrefWidth(125);
//		menu.setPrefHeight(150);
		//System.out.println();
		
		foodTray.setOnMouseClicked(new EventHandler<MouseEvent>() {
			//it detects once when the mouse is released.
			@Override
			public void handle(MouseEvent event) {
				foodTray.showImage(shopable.itemArrived());
//				ShopPane.current =null;
//				SushiOutPane.currentSushi = null;
			}	
		});
	}
	
	public void setCharacterImage() {
		if(menu.isServe()) {
			customer.setImage(SushiGame.get().getImage(c.happyFile));
		}else if(menu.getNumHeart() <= 3) {
			customer.setImage(SushiGame.get().getImage(c.unhappyFile));
		}else if(menu.getNumHeart() == 0) {
			customer.setImage(SushiGame.get().getImage(c.angryFile));
		}
	}
}
