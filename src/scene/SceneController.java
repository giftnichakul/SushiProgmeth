package scene;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

public class SceneController extends Application{
	private Scene scene;
	private Parent root;
	private Stage stage;
	private AudioClip sound;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		sound = new AudioClip("file:res/sounds/backgroundGameMusic.mp3");
		stage = primaryStage;
		root = new LevelScene();
		scene = new Scene(root,1000,600);
		stage.setScene(scene);
		stage.setResizable(false);
		sound.play();
		stage.show();
	}
	
	public void setToLevelScene() {
		root = new LevelScene();
		scene = new Scene(root,1000,600);
		stage.setScene(scene);
		stage.show();
	}
	

}
