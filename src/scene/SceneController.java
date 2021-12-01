package scene;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
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
		ScenePane s = new GameScene();
		//Level Ending Deleivery GameScene
		pane = s.getPane();

//		GridPane pane = new GridPane();
//		pane.add(new OrderPane(), 0, 0);
//		pane.add(new OrderPane(), 1, 0);
//		pane.add(new OrderPane(), 2, 0);
//		pane.add(new OrderPane(), 3, 0);
//		pane.add(new OrderPane(), 4, 0);

		
		scene = new Scene(pane ,1000 ,600);
		stage.setScene(scene);
		stage.setResizable(false);
		//sound.play();
		stage.show();
	}
	
}
