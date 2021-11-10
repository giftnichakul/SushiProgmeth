package scene;

import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;

public class StartScene extends AnchorPane{
	
	private Button startButton;
	private final String startBackground = "-fx-background-image: url('file:res/images/background_start.gif');"
			+ "fx-background-size: cover;"
			+ "    -fx-background-repeat: no-repeat;"
			+ "    -fx-background-position: center;";
	private final String startButtonStyle = "-fx-background-image: url('file:res/images/start_button1.png');"
			+ "fx-background-size: cover;"
			+ "-fx-background-position: center;"
			+ "-fx-background-radius: 35px;"
			+ "-fx-font-size: 36px;";
	
	public StartScene() {
		setMaxWidth(800);
		setMaxHeight(600);
		setStyle(startBackground);
		startButton = new Button("START");
		startButton.setMinWidth(230);
		startButton.setStyle(startButtonStyle);
		AnchorPane.setRightAnchor(startButton, 285.0);
		AnchorPane.setTopAnchor(startButton, 450.0);
		getChildren().add(startButton);
		
		startButton.setOnMouseEntered(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				startButton.setCursor(Cursor.HAND);;
			}
		});
	}

}
