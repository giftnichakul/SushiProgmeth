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
	private Label money;
	private Label stars;
	private GameButton toHome;
	private GameButton toLevel;
	private Font font1 = Font.font("Courier New", FontWeight.BOLD, 30);
	private Font font2 = Font.font("Courier New", FontWeight.BOLD, 24);
	
	private int playerScore = 70;
	
	
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
		
		showStar();
		
		money = new Label("scores");
		stars = new Label("stars"); 
		
		money.setFont(font2);
		stars.setFont(font2);
		
		
		AnchorPane.setLeftAnchor(money, 360.0);
		AnchorPane.setTopAnchor(money, 325.0);
		
		AnchorPane.setLeftAnchor(stars, 365.0);
		AnchorPane.setTopAnchor(stars, 400.0);
		
		toHome = new GameButton(70, 70, "", Color.TRANSPARENT);
		toLevel = new GameButton(70, 70, "", Color.TRANSPARENT);
		
		AnchorPane.setLeftAnchor(toHome, 380.0);
		AnchorPane.setTopAnchor(toHome, 475.0);
		
		AnchorPane.setLeftAnchor(toLevel, 545.0);
		AnchorPane.setTopAnchor(toLevel, 475.0);
		
		
		endPane.getChildren().addAll(showScore,star1,star2,star3,state,money,stars,toHome,toLevel);
	}

	public AnchorPane getEndPane() {
		return endPane;
	}
	
	public ImageView getsmallStar() {
		ImageView smallStar = new ImageView(new Image("file:res/images/smallStar.png"));
		smallStar.setFitHeight(90);
		smallStar.setFitWidth(90);
		return smallStar;
	}
	
	public ImageView getBigStar() {
		ImageView bigStar = new ImageView(new Image("file:res/images/bigStar.png"));
		bigStar.setFitHeight(120);
		bigStar.setFitWidth(120);
		return bigStar;
	}
	
	public void showStar() {
		star1 = this.getsmallStar();
		star2 = this.getsmallStar();
		star3 = this.getBigStar();
		
		AnchorPane.setLeftAnchor(star1, 345.0);
		AnchorPane.setTopAnchor(star1, 195.0);
		
		AnchorPane.setLeftAnchor(star2, 548.0);
		AnchorPane.setTopAnchor(star2, 195.0);
		
		AnchorPane.setLeftAnchor(star3, 433.0);
		AnchorPane.setTopAnchor(star3, 150.0);
		
		//show stars depend on player score
		
		//show 2 stars
		if(playerScore < 120) {
			star3.setVisible(false);
		}
		//show 1 stars
		if(playerScore < 80) {
			star2.setVisible(false);
		}
		//show no star
		if(playerScore < 10) {
			star1.setVisible(false);
		}
	}
	
	public boolean isPass(int score) {
		if(playerScore > score) return true;
		return false;
	}
}
	
