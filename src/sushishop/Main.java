package sushishop;

import game.SushiGame;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;


public class Main extends Application {
	private int width = 800;
	private int height =600;
	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		SushiGame.get();
		Pane pane = new ShopPane(width,height);
		Scene scene = new Scene(pane,width,height);
		stage.setScene(scene);
		/*
		stage.setWidth(width);
		stage.setHeight(height);
		*/
		stage.show();
		
	}
	public static void main(String[] args) {
		launch(args);
	}
	
	
	

}
