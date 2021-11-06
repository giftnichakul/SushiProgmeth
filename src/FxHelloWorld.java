

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class FxHelloWorld extends Application {

	// Override the start method in the Application class
	@Override
	public void start(Stage primaryStage) {
		// Create a scene and place a button in the scene
		Button btn = new Button("Hello world");
		StackPane root = new StackPane();
		root.getChildren().add(btn);
		
		btn.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("Mouse Clicked!!");
			}
		});
		
		Scene scene = new Scene(root, 300, 250);
		primaryStage.setTitle("MyJavaFX"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
