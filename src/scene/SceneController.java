package scene;

import game.SushiGame;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SceneController extends Application{
	private Scene scene;
	private Parent root;
	private Stage stage;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		stage = primaryStage;
		root = new StartScene();
		scene = new Scene(root,1000,600);
		stage.setScene(scene);
		stage.show();
	}
	
	public void setToLevelScene() {
		root = new LevelScene();
		scene = new Scene(root,1000,600);
		stage.setScene(scene);
		stage.show();
	}
	

}
