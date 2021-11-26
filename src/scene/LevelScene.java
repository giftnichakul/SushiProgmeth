package scene;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.paint.*;


public class LevelScene extends SceneController{
	
	private final VBox levelPane;
	
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
	private int nameLevel;
	
	
	public LevelScene() {
		levelPane = new VBox();
		levelPane.setMaxWidth(1000);
		levelPane.setMaxHeight(600);
		//TopPart
		HBox topPart = new HBox();
		topPart.setAlignment(Pos.TOP_RIGHT);
		//topPart.setPrefSize(1000, 40);
		topPart.setPadding(new Insets(5,10,0,0));
		homeButton = new GameButton(40,60,"",36,null);
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
		buttomPart.setAlignment(Pos.CENTER);
		
		level1 = levelButton(1);
		level2 = levelButton(2);
		level3 = levelButton(3);
		buttomPart.getChildren().addAll(level1, level2, level3);
		
		//test
		TopPane pane = new TopPane();
		AnchorPane pane1 = pane.getTopPane();
		
		
		levelPane.setStyle(levelBackground);
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
				
				System.out.println(nameLevel);
			}
		});
		
		return levelButton;
	}
	
	public Pane getLevelPane() {
        return levelPane ;
    }

}
