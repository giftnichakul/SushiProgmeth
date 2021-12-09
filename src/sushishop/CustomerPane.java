package sushishop;

import game.Customer;
import game.SushiGame;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import scene.MenuPane;

public class CustomerPane extends GamePane {
	private DialoguePane menu;
	private Customer c;
	public CustomerPane() {
		// TODO Auto-generated constructor stub
		this.setPrefWidth(200);
		this.setPrefHeight(280);
		//menu = new MenuPane("");
		c = SushiGame.get().getRandomCustomer();
		menu = new DialoguePane(c);
		ImageView customer  = new ImageView(SushiGame.get().getImage(c.smileFile));
		this.getChildren().addAll(menu,customer);
		customer.setFitHeight(170);
		customer.setFitWidth(115);
		//customer.setTranslateX(10);
		menu.setTranslateY(-80);
		menu.setTranslateX(-10);
//		menu.setPrefWidth(125);
//		menu.setPrefHeight(150);
	}
}
