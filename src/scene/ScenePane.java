package scene;

import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public abstract class ScenePane {
	
	public abstract Pane getPane();
	public abstract MediaPlayer getSoundBackground();
	//public abstract void setSceneOn(ScenePane scene);
	
	public ImageView getImageView(String image, int width, int height) {
		ImageView imageview = new ImageView(new Image(ClassLoader.getSystemResource("images/" + image).toString()));
		imageview.setFitHeight(height);
		imageview.setFitWidth(width);
		return imageview;
	}
	
	public Label getLabel(String name, Font font, Color color) {
		Label label = new Label(name); 
		label.setFont(font);
		label.setTextFill(color);
		return label;
	}
	
	public Background getBackground(String image) {
		Image imageBackground = new Image(ClassLoader.getSystemResource("images/"+image).toString());
		BackgroundImage backgroundImage = new BackgroundImage( imageBackground, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
		Background background = new Background(backgroundImage);
		return background;
	}
	
	public Font getFont(String name, int size) {
		Font font = Font.font(name, FontWeight.BOLD, size);
		return font;
	}
	
	public void setSceneOn(Stage stage, ScenePane scenePane) {
		Platform.runLater(new Runnable() {
			public void run() {
				Scene scene = new Scene(scenePane.getPane(), 1000, 600);
				stage.setScene(scene);
//				stage.setScene(new Scene(SceneManager.getInstance().getScenePane().getPane(), 1000, 600));
				
			}
		});
	}

}