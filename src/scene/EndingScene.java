package scene;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class EndingScene extends ScenePane{
	
	private AnchorPane endPane;
	private ImageView star1;
	private ImageView star2;
	private ImageView star3;
	private Label state;
	private int playerScore = 1000;
	private int numStar;
	private MediaPlayer soundBackground;
	
	public EndingScene() {
	
		endPane = new AnchorPane();
		endPane.setMaxWidth(1000);
		endPane.setMaxHeight(600);
		endPane.setBackground(this.getBackground("backgroundJapan.gif"));
		ImageView showScore = this.getImageView("wining.png", 420, 450); 
		
		Font font1 = this.getFont("Courier New", 30);
		Font font2 = this.getFont("Courier New", 24);
		if(isPass(10)) {
			state = this.getLabel("-COMPLETE-", font1, Color.WHITE);
			this.soundBackground = new MediaPlayer(new Media(ClassLoader.getSystemResource("sounds/winningSound.wav").toString()));
		}else {
			state = this.getLabel("-FAIL-", font1, Color.WHITE);
			this.soundBackground = new MediaPlayer(new Media(ClassLoader.getSystemResource("sounds/losindSound.wav").toString()));
		}
		state.setPrefHeight(35);
		state.setPrefWidth(190);
		state.setAlignment(Pos.CENTER);
		
		AnchorPane.setLeftAnchor(showScore, 290.0);
		AnchorPane.setTopAnchor(showScore, 70.0);
		
		AnchorPane.setLeftAnchor(state, 405.0);
		AnchorPane.setTopAnchor(state, 95.0);
		
		calculateStar(playerScore);
		showStar();
		Label score = this.getLabel("scores", font2, Color.BLACK);
		Label stars = this.getLabel("stars", font2, Color.BLACK);
		
		AnchorPane.setLeftAnchor(score, 360.0);
		AnchorPane.setTopAnchor(score, 325.0);
		
		AnchorPane.setLeftAnchor(stars, 365.0);
		AnchorPane.setTopAnchor(stars, 400.0);

		GameButton toHome = new GameButton(70, 70, "", 10, Color.TRANSPARENT);
		GameButton restart = new GameButton(70, 70, "", 10, Color.TRANSPARENT); 
		GameButton toLevel = new GameButton(70, 70, "", 10, Color.TRANSPARENT);
		
		toHome.setBackgroundButton("home-button.png");
		toHome.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				new Thread(()->{	
					setSceneOn(SceneController.stage, new StartScene());
				}).start();	
			}
		});
		toLevel.setBackgroundButton("levelButton.png");
		toLevel.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				new Thread(()->{	
					setSceneOn(SceneController.stage, new LevelScene());
				}).start();	
			}
		});
		restart.setBackgroundButton("replayButton.png");
		restart.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				new Thread(()->{	
					setSceneOn(SceneController.stage, new GameScene());
				}).start();	
			}
		});
		
		AnchorPane.setLeftAnchor(toHome, 360.0);
		AnchorPane.setTopAnchor(toHome, 475.0);
		
		AnchorPane.setLeftAnchor(restart, 460.0);
		AnchorPane.setTopAnchor(restart, 475.0);
		
		AnchorPane.setLeftAnchor(toLevel, 555.0);
		AnchorPane.setTopAnchor(toLevel, 475.0);
		
		Label money = this.getLabel(""+playerScore, font2, Color.BLACK);
		AnchorPane.setLeftAnchor(money, 540.0);
		AnchorPane.setTopAnchor(money, 325.0);
		
		Label numStars = this.getLabel(""+numStar, font2, Color.BLACK);
		AnchorPane.setLeftAnchor(numStars, 560.0);
		AnchorPane.setTopAnchor(numStars, 400.0);
		
		endPane.getChildren().addAll(showScore,star1,star2,star3,state,score,stars,toHome,restart,toLevel,money,numStars);
	}

	public AnchorPane getPane() {
		return endPane;
	}
	
	
	public void showStar() {
		star1 = this.getImageView("star.png", 90, 90);
		star2 = this.getImageView("star.png", 90, 90);
		star3 = this.getImageView("star.png", 120, 120);
		
		AnchorPane.setLeftAnchor(star1, 345.0);
		AnchorPane.setTopAnchor(star1, 195.0);
		
		AnchorPane.setLeftAnchor(star2, 548.0);
		AnchorPane.setTopAnchor(star2, 195.0);
		
		AnchorPane.setLeftAnchor(star3, 430.0);
		AnchorPane.setTopAnchor(star3, 150.0);
		
		if(numStar < 3) {
			star3.setVisible(false);
		}
		if (numStar < 2) {
			star2.setVisible(false);
		}
		if(numStar < 1) {
			star1.setVisible(false);
		}
	}
	
	public boolean isPass(int score) {
		if(playerScore > score) return true;
		return false;
	}
	
	public int calculateStar(int score){
		if(score > 120) {
			numStar = 3;
		}else if (score > 80) {
			numStar = 2;
		}else if(score > 60) {
			numStar = 1;
		}else {
			numStar = 0;
		}
		return numStar;
	}
	
	public MediaPlayer getSoundBackground() {
		return this.soundBackground;
	}
}
	
