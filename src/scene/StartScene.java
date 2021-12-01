package scene;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class StartScene extends ScenePane{
	
	private AnchorPane StartPane;
	private MediaPlayer soundBackground;
	
	public StartScene() {
		this.soundBackground = new MediaPlayer(new Media(ClassLoader.getSystemResource("sounds/backgroundGameMusic.mp3").toString()));
		Font font = this.getFont("Berlin Sans FB Demi", 150);
		StartPane = new AnchorPane();
		StartPane.setMaxWidth(1000);
		StartPane.setMaxHeight(600);
		StartPane.setBackground(this.getBackground("background-start.gif"));
		
		GameButton startButton = new GameButton(100,230,"START",36,Color.BLACK);
		startButton.setBackgroundButton("start-button.png");
		
		startButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				new Thread(()->{	
					setSceneOn(SceneController.stage, new LevelScene());
				}).start();	
			}
		});
		
		
		Label gameName1 = this.getLabel("SUSHI", font, Color.WHITE);
		Label gameName2 = this.getLabel("MAMA", font, Color.WHITE);
		
		ImageView image = this.getImageView("ChefLoco3.png", 300, 400);
		
		AnchorPane.setLeftAnchor(gameName1, 200.0);
		AnchorPane.setTopAnchor(gameName1, 90.0);
		AnchorPane.setLeftAnchor(gameName2, 120.0);
		AnchorPane.setTopAnchor(gameName2, 255.0);
		AnchorPane.setLeftAnchor(image, 580.0);
		AnchorPane.setTopAnchor(image, 60.0);
		
		AnchorPane.setRightAnchor(startButton, 385.0);
		AnchorPane.setTopAnchor(startButton, 450.0);
		StartPane.getChildren().addAll(startButton,gameName1,gameName2,image);
	}
	
	public Pane getPane() {
        return StartPane ;
    }
	
	public MediaPlayer getSoundBackground() {
		return this.soundBackground;
	}
	
}
