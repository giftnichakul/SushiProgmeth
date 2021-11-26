package scene;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

public class SceneController extends Application{
	private Pane pane;
	private Scene scene;
	private Stage stage;
	private AudioClip sound;
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		sound = new AudioClip("file:res/sounds/backgroundGameMusic.mp3");
		stage = primaryStage;
		//StartScene start = new StartScene();
		//pane = start.getStartPane();
		//LevelScene level = new LevelScene();
		//pane = level.getLevelPane();
//		EndingScene end = new EndingScene();
//		pane = end.getEndPane();
		DeliveryScene d = new DeliveryScene();
		pane = d.getDeliveryPane();
		System.out.println("OK");
		scene = new Scene(pane,1000,600);
		stage.setScene(scene);
		stage.setResizable(false);
		//sound.play();
		stage.show();
	}
	
	public void setToLevelScene() {
		LevelScene level = new LevelScene();
		pane = level.getLevelPane();
		scene.setRoot(pane);
		stage.setScene(scene);
		stage.show();
	}
	

}
