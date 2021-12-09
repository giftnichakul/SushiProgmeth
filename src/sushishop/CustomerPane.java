package sushishop;

import game.Customer;
import game.SushiGame;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import scene.MenuPane;

public class CustomerPane extends GamePane {
	private MenuPane menu;
	public CustomerPane() {
		// TODO Auto-generated constructor stub
		this.setPrefWidth(200);
		this.setPrefHeight(280);
		menu = new MenuPane("");
		Customer c = SushiGame.get().getRandomCustomer();
		ImageView customer  = new ImageView(SushiGame.get().getImage(c.smileFile));
		this.getChildren().addAll(menu,customer);
		customer.setFitHeight(170);
		customer.setFitWidth(115);
		//customer.setTranslateX(10);
		menu.setTranslateY(-100);
		menu.setTranslateX(-10);
		menu.setPrefWidth(100);
		menu.setPrefHeight(80);
	}
}
