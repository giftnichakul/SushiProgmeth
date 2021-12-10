package sushishop;

import game.RecipeName;
import game.SushiGame;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class FoodPane extends GamePane {
	protected FoodPane self;
	
	private int w = 150;
	private int h = 100;
	ImageView item;
	public FoodPane() {
		self = this;
		
		ImageView bg  = new ImageView(SushiGame.get().getImage("dialog02.png"));
		bg.setFitWidth(w);
		bg.setFitHeight(h);
		this.addChildren(bg);
		item  = new ImageView(SushiGame.get().getImage("dialog02.png"));
		item.setFitHeight(h*0.8);
		item.setFitWidth(w*0.8);
		this.addChildren(item);
		item.setVisible(false);
		
		

		
	}
	public void showImage(RecipeName name) {
		if(name==null) {
			item.setVisible(false);
		}
		else {
			item.setImage(SushiGame.get().getImage(name.fileName));
			item.setVisible(true);
		}
	}
	public void showWrongOrder() {
		item.setImage(SushiGame.get().getImage("UNJI01.png"));
		item.setVisible(true);
	}
}
