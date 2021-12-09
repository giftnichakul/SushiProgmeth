package sushishop;

import game.SushiGame;
import javafx.application.Application;
import javafx.stage.Stage;
import scene.LevelScene;
import scene.StartScene;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;


public class NatTestMain extends Application {
	private int width = 1000;
	private int height =600;
	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		SushiGame.get();
		StartScene pane = new StartScene();
		
//		Scene scene = new Scene(new ShopPane(width,height));
//		stage.setScene(scene);
		Scene scene = new Scene(new ShopPane(width,height));
		stage.setScene(scene);
		
		/*
		stage.setWidth(width);
		stage.setHeight(height);
		*/
		stage.show();
		for(int i =0;i< 100;i++) {
			SushiGame.get().getRandomCustomer();
		}
		
	}
	public static void main(String[] args) {
		launch(args);
	}
	
	
	

}