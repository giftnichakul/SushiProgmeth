package scene;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class SceneController extends Application{
	private Scene scene;
	public static Stage stage;
	public static MediaPlayer sound;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		stage = primaryStage;
		//ScenePane firstScene = new StartScene();
		ScenePane firstScene = new DeliveryScene();
		//Level Ending Delivery GameScene
		scene = new Scene(firstScene.getPane() ,1000 ,600);
		this.sound = firstScene.getSoundBackground();
		sound.play();
		stage.setScene(scene);
		stage.setResizable(false);
		stage.show();
	}
	
	
}
