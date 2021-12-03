package scene;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.scene.paint.*;


public class LevelScene extends ScenePane{
	
	private final VBox levelPane;
	private MediaPlayer soundBackground;
	private int nameLevel;
	
	public LevelScene() {
		this.soundBackground = new MediaPlayer(new Media(ClassLoader.getSystemResource("sounds/backgroundGameMusic.mp3").toString()));
		levelPane = new VBox();
		levelPane.setMaxWidth(1000);
		levelPane.setMaxHeight(600);
		//levelPane.setBackground(this.getBackground("background-level.gif"));
		Font font = this.getFont("Algerian", 120);
		
		//TopPart
		HBox topPart = new HBox();
		topPart.setAlignment(Pos.TOP_RIGHT);
		topPart.setPadding(new Insets(5,10,0,0));
		GameButton homeButton = new GameButton(60,60,"",36,null);
		homeButton.setBackgroundButton("home-button.png");
		homeButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				new Thread(()->{	
					setSceneOn(SceneController.stage, new StartScene());
				}).start();	
			}
		});
		topPart.getChildren().add(homeButton);
		
		//labelPart
		HBox middlePart = new HBox();
		middlePart.setAlignment(Pos.CENTER);
		Label level = this.getLabel("LEVEL", font, Color.WHITE);
		middlePart.getChildren().add(level);
		
		//ButtomPart
		HBox buttomPart = new HBox(90);
		buttomPart.setAlignment(Pos.CENTER);
		GameButton level1 = levelButton(1);
		GameButton level2 = levelButton(2);
		GameButton level3 = levelButton(3);
		buttomPart.getChildren().addAll(level1, level2, level3);
		
		levelPane.getChildren().addAll(topPart, middlePart, buttomPart);
	}
	
	public int getNameLevel() {
		return nameLevel;
	}
	
	private GameButton levelButton(int level) {
		GameButton levelButton = new GameButton(360,200,"Level" + level,36,Color.WHITE);
		levelButton.setBackgroundButton("wood-label1.png");
		levelButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				nameLevel = level;
				new Thread(()->{
					GameScene game = new GameScene();
					setSceneOn(SceneController.stage, game);
					SceneController.sound.pause();
					SceneController.sound = game.getSoundBackground();
					SceneController.sound.play();
				}).start();	
			}
		});
		return levelButton;
	}
	
	public Pane getPane() {
        return levelPane ;
    }
	
	public MediaPlayer getSoundBackground() {
		return this.soundBackground;
	}

}
