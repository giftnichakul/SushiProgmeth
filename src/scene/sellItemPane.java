package scene;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class sellItemPane extends VBox{
	
	private ImageView itemImage;
	
	public sellItemPane(int price, String name) {
		setPrefHeight(150);
		setPrefWidth(150);
		setAlignment(Pos.CENTER);
		//name to each picture
		itemImage = new ImageView(new Image(ClassLoader.getSystemResource("images/tamago03.png").toString()));
		itemImage.setFitHeight(100);
		itemImage.setFitWidth(100);
		GameButton priceButton = new GameButton(40, 120, "  "+price,20,Color.BLACK);
		priceButton.setBackgroundButton("price.png");
		this.getChildren().addAll(itemImage, priceButton);
	}
}
