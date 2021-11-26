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
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class StartScene extends SceneController{
	
	private final AnchorPane StartPane;
	private GameButton startButton;
	private Label gameName1;
	private Label gameName2;
	private ImageView image;
	private Font font = Font.loadFont("file:res/KGHAPPY.ttf",120);
	
	public StartScene() {
		
		StartPane = new AnchorPane();
		StartPane.setMaxWidth(1000);
		StartPane.setMaxHeight(600);
		Image imageBackground = new Image("file:res/images/background-start.gif");
		BackgroundImage backgroundImage = new BackgroundImage( imageBackground, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
		Background background = new Background(backgroundImage);
		StartPane.setBackground(background);
		
		//StartPane.setStyle(startBackground);
		startButton = new GameButton(100,230,"START",36,Color.BLACK);
		startButton.setBackgroundButton("start-button.png");
		//ImageView image = new ImageView(new Image("file:res/images/ChefLoco.png"));
		gameName1 = new Label("SUSHI");
		gameName2 = new Label("MAMA");
		
		gameName1.setTextFill(Color.WHITE);
		gameName2.setTextFill(Color.WHITE);
		gameName1.setFont(font);
		gameName2.setFont(font);
		
		image = new ImageView(new Image("file:res/images/ChefLoco3.png"));
		image.setFitHeight(400);
		image.setFitWidth(300);
		
		AnchorPane.setLeftAnchor(gameName1, 200.0);
		AnchorPane.setTopAnchor(gameName1, 60.0);
		AnchorPane.setLeftAnchor(gameName2, 120.0);
		AnchorPane.setTopAnchor(gameName2, 225.0);
		AnchorPane.setLeftAnchor(image, 580.0);
		AnchorPane.setTopAnchor(image, 60.0);
		
		AnchorPane.setRightAnchor(startButton, 385.0);
		AnchorPane.setTopAnchor(startButton, 450.0);
		StartPane.getChildren().addAll(startButton,gameName1,gameName2,image);
		changeScene();
	}
	
	public void changeScene() {
		
		startButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				setToLevelScene();
			}
		});
		
	}
	
	public Pane getStartPane() {
        return StartPane ;
    }

}
