package sushishop;

import game.RecipeName;
import game.SushiGame;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class SushiOutPane extends GamePane{
	
	protected SushiOutPane self;
	private int w = 150;
	private int h = 100;
	ImageView item;
	public SushiOutPane() {
		self = this;
		
		ImageView bg  = new ImageView(SushiGame.get().getImage("wood-label.png"));
		bg.setFitWidth(w);
		bg.setFitHeight(h);
		this.addChildren(bg);
		item  = new ImageView(SushiGame.get().getImage("wood-label.png"));
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
}