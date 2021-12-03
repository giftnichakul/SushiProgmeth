package scene;

import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class GameScene extends ScenePane{
	
	private VBox gameScene;
	private MediaPlayer soundBackground;
	private int level;
	
	public GameScene(int level) {
		this.soundBackground = new MediaPlayer(new Media(ClassLoader.getSystemResource("sounds/backgroundGame1.mp3").toString()));
		this.level = level;
		gameScene = new VBox();
		gameScene.setPrefHeight(600);
		gameScene.setPrefWidth(1000);
		
		TopPane t = new TopPane(this.level);
		
		GridPane g = new GridPane();
		
		Image imageBackground = new Image(ClassLoader.getSystemResource("images/gameBackground.jpg").toString(),1000,300,false,false);
		BackgroundImage backgroundImage = new BackgroundImage( imageBackground, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
		Background background = new Background(backgroundImage);
		g.setBackground(background);
		g.add(new OrderPane(), 0, 0);
		g.add(new OrderPane(), 1, 0);
		g.add(new OrderPane(), 2, 0);
		g.add(new OrderPane(), 3, 0);
		g.add(new OrderPane(), 4, 0);
		gameScene.getChildren().addAll(t.getTopPane(),g);
		
	}
	
	public VBox getPane() {
		return gameScene;
	}
	
	public MediaPlayer getSoundBackground() {
		return this.soundBackground;
	}

	public int getLevel() {
		return level;
	}	

}
