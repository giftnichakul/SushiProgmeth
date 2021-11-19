package scene;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.paint.*;


public class LevelScene extends VBox{
	
	private final String levelBackground = "-fx-background-image: url('file:res/images/background-level.gif');"
			+ "fx-background-size: cover;"
			+ "-fx-background-repeat: no-repeat;"
			+ "-fx-background-position: center;";
	private GameButton homeButton;
	private GameButton level1;
	private GameButton level2;
	private GameButton level3;
	private Font font = Font.font("Algerian", FontWeight.BOLD, 120);
	private Label level;
	
	
	public LevelScene() {
		setMaxWidth(1000);
		setMaxHeight(600);
		//TopPart
		HBox topPart = new HBox();
		topPart.setAlignment(Pos.TOP_RIGHT);
		//topPart.setPrefSize(1000, 40);
		topPart.setPadding(new Insets(5,10,0,0));
		homeButton = new GameButton(40,60,"",null);
		homeButton.setBackgroundButton("home-button.png");
		topPart.getChildren().add(homeButton);
		//labelPart
		HBox middlePart = new HBox();
		middlePart.setAlignment(Pos.CENTER);
		//middlePart.setPrefSize(1000, 100);
		level = new Label("LEVEL"); 
		level.setFont(font);
		level.setTextFill(Color.WHITE);
		middlePart.getChildren().add(level);
		//ButtomPart
		HBox buttomPart = new HBox(90);
		//buttomPart.setPrefSize(1000, 450);
		buttomPart.setAlignment(Pos.CENTER);
		
	
		level1 = new GameButton(360,200,"Level1",Color.WHITE);
		level2 = new GameButton(360,200,"Level2",Color.WHITE);
		level3 = new GameButton(360,200,"Level3",Color.WHITE);
		level1.setBackgroundButton("wood-label1.png");
		level2.setBackgroundButton("wood-label1.png");
		level3.setBackgroundButton("wood-label1.png");
		buttomPart.getChildren().addAll(level1, level2, level3);
		
		
		setStyle(levelBackground);
		this.getChildren().addAll(topPart, middlePart, buttomPart);
	}
	

}
