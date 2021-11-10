package scene;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Font;

public class GameButton extends Button{
	
	private Font cheri = Font.loadFont("file:res/cheri.regular.ttf", 36);
	
	
	public GameButton(int height, int width, String text) {
		setPrefWidth(width);
		setPrefHeight(height);
		
	
		setText(text);
		setAlignment(Pos.CENTER);
		effectButton();
	}
	
	public void setBackgroundButton(String url) {
		Image image = new Image("file:res/images/"+url);
		BackgroundImage backgroundImage = new BackgroundImage( image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
		Background background = new Background(backgroundImage);
		this.setBackground(background);
		
	}
	
	public void effectButton() {
		
		//change cursor
		setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				setCursor(Cursor.HAND);
			}
		});
		
		//sound effect
		
	}
	

}
