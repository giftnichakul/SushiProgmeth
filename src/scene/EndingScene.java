package scene;

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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class EndingScene {
	
	private AnchorPane endPane;
	private ImageView showScore;
	private ImageView star1;
	private ImageView star2;
	private ImageView star3;
	private Label state;
	private Font font1 = Font.font("Courier New", FontWeight.BOLD, 30);
	private Font font2 = Font.font("Courier New", FontWeight.BOLD, 24);
	
	private int playerScore = 1000;
	private int numStar;
	
	
	public EndingScene() {
	
		endPane = new AnchorPane();
		endPane.setMaxWidth(1000);
		endPane.setMaxHeight(600);
		Image imageBackground = new Image("file:res/images/backgroundJapan.gif");
		BackgroundImage backgroundImage = new BackgroundImage( imageBackground, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
		Background background = new Background(backgroundImage);
		endPane.setBackground(background);
		
		showScore = new ImageView(new Image("file:res/images/wining.png"));
		showScore.setFitHeight(450);
		showScore.setFitWidth(420);
		
		if(isPass(10)) {
			state = new Label("-COMPLETE-");
		}else {
			state = new Label("-FAIL-");
		}
		state.setPrefHeight(35);
		state.setPrefWidth(190);
		state.setAlignment(Pos.CENTER);
		state.setTextFill(Color.WHITE);
		state.setFont(font1);
		
		AnchorPane.setLeftAnchor(showScore, 290.0);
		AnchorPane.setTopAnchor(showScore, 70.0);
		
		AnchorPane.setLeftAnchor(state, 405.0);
		AnchorPane.setTopAnchor(state, 95.0);
		
		calculateStar(playerScore);
		showStar();
		
		Label score = new Label("scores");
		Label stars = new Label("stars"); 
		
		score.setFont(font2);
		stars.setFont(font2);
		
		
		AnchorPane.setLeftAnchor(score, 360.0);
		AnchorPane.setTopAnchor(score, 325.0);
		
		AnchorPane.setLeftAnchor(stars, 365.0);
		AnchorPane.setTopAnchor(stars, 400.0);
		
		GameButton toHome = new GameButton(70, 70, "", 10, Color.TRANSPARENT);
		GameButton restart = new GameButton(70, 70, "", 10, Color.TRANSPARENT); 
		GameButton toLevel = new GameButton(70, 70, "", 10, Color.TRANSPARENT);
		
		toHome.setBackgroundButton("home-button.png");
		toLevel.setBackgroundButton("levelButton.png");
		restart.setBackgroundButton("replayButton.png");
		
		AnchorPane.setLeftAnchor(toHome, 360.0);
		AnchorPane.setTopAnchor(toHome, 475.0);
		
		AnchorPane.setLeftAnchor(restart, 460.0);
		AnchorPane.setTopAnchor(restart, 475.0);
		
		AnchorPane.setLeftAnchor(toLevel, 555.0);
		AnchorPane.setTopAnchor(toLevel, 475.0);
		
		Label money = new Label(""+playerScore);
		money.setFont(font2);
		AnchorPane.setLeftAnchor(money, 540.0);
		AnchorPane.setTopAnchor(money, 325.0);
		
		Label numStars = new Label(""+numStar);
		numStars.setFont(font2);
		AnchorPane.setLeftAnchor(numStars, 560.0);
		AnchorPane.setTopAnchor(numStars, 400.0);
		
		
		endPane.getChildren().addAll(showScore,star1,star2,star3,state,score,stars,toHome,restart,toLevel,money,numStars);
	}

	public AnchorPane getEndPane() {
		return endPane;
	}
	
	public ImageView star(int size) {
		ImageView Star = new ImageView(new Image("file:res/images/star.png"));
		Star.setFitHeight(size);
		Star.setFitWidth(size);
		return Star;
	}
	
	public void showStar() {
		star1 = star(90);
		star2 = star(90);
		star3 = star(120);
		
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
}
	
