package scene;

import java.time.Duration;

import javafx.animation.*;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class TopPane {
	
	private AnchorPane topPane;
	private Label presentLevel;
	private Label currentMoney;
	private ProgressBar time;
	private Font font = Font.font("Courier New", FontWeight.BOLD, 30);
	
	public TopPane(int level) {
		topPane = new AnchorPane();
		topPane.setMaxHeight(50);
		topPane.setMaxWidth(1000);
		topPane.setBackground(new Background(new BackgroundFill(Color.BURLYWOOD, CornerRadii.EMPTY, Insets.EMPTY)));
		
		ImageView levelBackground = this.getImageView("level.png", 180, 45);
		AnchorPane.setLeftAnchor(levelBackground, 15.0);
		AnchorPane.setTopAnchor(levelBackground, 2.0);
		
		ImageView background = this.getImageView("background.png", 175, 45);
		AnchorPane.setLeftAnchor(background, 240.0);
		AnchorPane.setTopAnchor(background, 1.0);
		
		setLevelLable(level);
		AnchorPane.setLeftAnchor(presentLevel, 40.0);
		AnchorPane.setTopAnchor(presentLevel, 8.0);
		
		Label moneyGoal = new Label("   /300");
		moneyGoal.setFont(font);
		AnchorPane.setLeftAnchor(moneyGoal, 270.0);
		AnchorPane.setTopAnchor(moneyGoal, 8.0);
		
		setCurrentMoney(100);
		AnchorPane.setLeftAnchor(currentMoney, 270.0);
		AnchorPane.setTopAnchor(currentMoney, 8.0);
		
		ImageView coin = this.getImageView("coin.png", 40, 40);
		AnchorPane.setLeftAnchor(coin, 220.0);
		AnchorPane.setTopAnchor(coin, 3.0);
		
		ImageView clock = this.getImageView("sandclock.png", 35, 45);
		AnchorPane.setLeftAnchor(clock, 430.0);
		AnchorPane.setTopAnchor(clock, 3.0);
		
		time = new ProgressBar();
		time.setPrefHeight(30);
		time.setPrefWidth(500);
		time.setStyle("-fx-accent: coral;");
		time.setProgress(0.5);

		AnchorPane.setLeftAnchor(time, 470.0);
		AnchorPane.setTopAnchor(time, 8.0);
		
		
		topPane.getChildren().addAll(levelBackground, presentLevel, background, currentMoney, coin, clock, moneyGoal,time);
	}
	
	public AnchorPane getTopPane() {
		return topPane;
	}
	
	public void setLevelLable(int level) {
		presentLevel = new Label("Level " + level);
		presentLevel.setFont(font);
	}
	
	public void setCurrentMoney(int money) {
		String text;
		if(money < 10) {
			text = "  " + money;
		}else if (money < 100) {
			text = " " + money;
		}else {
			text = "" + money;
 		}
		currentMoney = new Label(text);
		currentMoney.setFont(font);
	}
	
	public ImageView getImageView(String image, int width, int height) {
		ImageView imageview = new ImageView(new Image(ClassLoader.getSystemResource("images/" + image).toString()));
		imageview.setFitHeight(height);
		imageview.setFitWidth(width);
		return imageview;
	}

}
