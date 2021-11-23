package scene;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class GameButton extends Button{
	
	//private String sound = ClassLoader.getSystemResource("sounds/clickSound.wav").toString();
	
	private AudioClip buttonSound = new AudioClip("file:res/sounds/clickSound.wav");
	
		
	public GameButton(int height, int width, String text, Color color) {
		setPrefWidth(width);
		setPrefHeight(height);
		Font font = Font.font("Courier New", FontWeight.BOLD, 36);
		setFont(font);
		setText(text);
		setTextFill(color);
		setAlignment(Pos.CENTER);
		effectButton();
	}
	
	public void setBackgroundButton(String url) {
		//String imagePath = ClassLoader.getSystemResource("images/"+url).toString();
		//System.out.println(imagePath);
		Image image = new Image("file:res/images/"+url);
		BackgroundImage backgroundImage = new BackgroundImage( image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
		Background background = new Background(backgroundImage);
		setBackground(background);
		
	}
	
	public void effectButton() {
		
		//change cursor
		setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				setCursor(Cursor.HAND);
				setEffect(new DropShadow(10,Color.BLACK));
				ColorAdjust colorAdjust = new ColorAdjust();
				colorAdjust.setBrightness(-0.2);  
				setEffect(colorAdjust);
			}
		});
		
		setOnMouseExited(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent event) {
				setEffect(null);
				
			}
		});
		
		setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				buttonSound.play();
				
			}
		});
		
	}
	

}
