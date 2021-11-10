package scene;

import javafx.scene.layout.AnchorPane;

public class StartScene extends AnchorPane{
	
	
	private GameButton startButton;
	private final String startBackground = "-fx-background-image: url('file:res/images/background-start.gif');"
			+ "fx-background-size: cover;"
			+ "-fx-background-repeat: no-repeat;"
			+ "-fx-background-position: center;";
	
	public StartScene() {
		setMaxWidth(1000);
		setMaxHeight(600);
		setStyle(startBackground);
		startButton = new GameButton(100,230,"START");
		startButton.setBackgroundButton("start_button1.png");
		
		AnchorPane.setRightAnchor(startButton, 380.0);
		AnchorPane.setTopAnchor(startButton, 450.0);
		getChildren().add(startButton);
		
	}
	
	public void changeScene() {
		
	}

}
