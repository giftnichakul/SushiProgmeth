package sushishop;

import game.RecipeName;
import game.SushiGame;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class SushiOutPane extends GamePane{
	
	protected SushiOutPane self;
	private int w = 150;
	private int h = 100;
	private ImageView item;
	public static RecipeName currentSushi;
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
		item.setTranslateX(10);
//		this.setOnMouseClicked(new EventHandler<MouseEvent>() {
//			//it detects once when the mouse is released.
//			@Override
//			public void handle(MouseEvent event) {
//				if()
//			}	
//		});
		
	}
	public void showImage(RecipeName name) {
		currentSushi = name;
		if(currentSushi==null) {
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
	public void discard() {
		item.setVisible(false);
	}
	
	public static void discard2() {
		
	}
	
	
}