package scene;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class StartScene extends AnchorPane{
	
	
	private GameButton startButton;
	private final String startBackground = "-fx-background-image: url('file:res/images/background-start.gif');"
			+ "fx-background-size: cover;"
			+ "-fx-background-repeat: no-repeat;"
			+ "-fx-background-position: center;";
	private Label gameName1;
	private Label gameName2;
	private Label loco;
	private Font font = Font.font("Courier New", FontWeight.BOLD, 150);
	
	public StartScene() {
		setMaxWidth(1000);
		setMaxHeight(600);
		setStyle(startBackground);
		startButton = new GameButton(100,230,"START",Color.BLACK);
		startButton.setBackgroundButton("start-button.png");
		//ImageView image = new ImageView(new Image("file:res/images/ChefLoco.png"));
		gameName1 = new Label("SUSHI");
		gameName2 = new Label("MAMA");
		loco = new Label();
		
		gameName1.setTextFill(Color.WHITE);
		gameName2.setTextFill(Color.WHITE);
		gameName1.setFont(font);
		gameName2.setFont(font);
		
		ImageView image = new ImageView(new Image("file:res/images/ChefLoco3.png"));
		image.setFitHeight(400);
		image.setFitWidth(300);
		
		loco.setGraphic(image);
		loco.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));
		
		AnchorPane.setLeftAnchor(gameName1, 160.0);
		AnchorPane.setTopAnchor(gameName1, 100.0);
		AnchorPane.setLeftAnchor(gameName2, 160.0);
		AnchorPane.setTopAnchor(gameName2, 250.0);
		AnchorPane.setLeftAnchor(loco, 540.0);
		AnchorPane.setTopAnchor(loco, 60.0);
		
		AnchorPane.setRightAnchor(startButton, 385.0);
		AnchorPane.setTopAnchor(startButton, 450.0);
		getChildren().addAll(startButton,gameName1,gameName2,loco);
		changeScene();
	}
	
	public void changeScene() {
		
		startButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				//setToLevelScene();
			}
		});
		
	}

}
