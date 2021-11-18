package sushishop;

import game.InventoryItemName;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class MakeSushiPane extends GamePane{
	protected MakeSushiPane self;
	private int w = 150;
	private int h = 40;
	public MakeSushiPane() {
		self = this;
		
		ImageView item  = new ImageView((new Image("file:res/images/start-button.png")));
		item.setFitWidth(w);
		item.setFitHeight(h);
		
		
		
		this.setOnMouseClicked(new EventHandler<MouseEvent>() {
			//it detects once when the mouse is released.
			@Override
			public void handle(MouseEvent event) {
				
//				setSelected(!isSelected());
//				self.println(self.toString(),""+isSelected());
//				if(isSelected()) {
//					self.setStyle("-fx-border-color: black;");
//				}
//				else {
//					self.setStyle("-fx-border-color: none;");
//				}
			}	
		});
		
		this.setOnMouseEntered(new EventHandler<MouseEvent>() {
			//it detects once when the mouse is released.
			@Override
			public void handle(MouseEvent event) {
				item.setScaleX(1.05);
				item.setScaleY(1.05);
				self.println(self.toString(),"enter");
			}	
		});
		
		this.setOnMouseExited(new EventHandler<MouseEvent>() {
			//it detects once when the mouse is released.
			@Override
			public void handle(MouseEvent event) {
				item.setScaleX(1);
				item.setScaleY(1);
				self.println(self.toString(),"exit");
			}	
		});
		this.addChildren(item);
		Label caption = new Label("Make");
		caption.setPrefHeight(h);
		caption.setPrefWidth(w);
		caption.setTextFill(Color.WHITE);
		caption.setStyle("-fx-font: 18 arial;");
		caption.setAlignment(Pos.CENTER);
		caption.setTranslateY(-2);
		
		this.addChildren(caption);
	}
}
