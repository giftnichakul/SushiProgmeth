package sushishop;

import java.util.ArrayList;

import game.Customer;
import game.RecipeName;
import game.SushiGame;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class DialoguePane extends GamePane {
	private ImageView menu;
	private HBox heart;
	private int numHeart;
	private boolean isServe;
	private ArrayList<ImageView> hearts = new ArrayList<ImageView>();
	private RecipeName recipe;
	
	public DialoguePane(Customer c) {
		this.isServe = false;
		this.setPrefHeight(200);
		this.setPrefWidth(125);
		
		recipe= SushiGame.get().getRandomRecipe();
		this.setBackground(new Background(new BackgroundFill(Color.BEIGE, CornerRadii.EMPTY, Insets.EMPTY)));
		//rename image name to name!!!!

		//menu = new ImageView(new Image(ClassLoader.getSystemResource("images/salmonGrillSushi.png"+name).toString()));
		menu  = new ImageView(SushiGame.get().getImage(recipe.fileName,125,125));
		menu.setScaleX(0.8);
		menu.setScaleY(0.8);
//		menu.setFitHeight(80);
//		menu.setFitWidth(140);
		//change recipes to each menu!!!
		setTooltip(recipe.ingredients);
		menu.setTranslateY(-12);
		
		System.out.println(numHeart);
		this.numHeart = c.patience;
		System.out.println(numHeart);
		initHeart();
		//this.addChildren(heart);
		this.getChildren().addAll(menu, heart);
	}
	
	public void initHeart() {
		heart = new HBox();
		heart.setMaxHeight(25);
		heart.setMaxWidth(75);
		for(int i = 0; i < numHeart; i++) {
			hearts.add(heartImages());
			heart.getChildren().add(hearts.get(i));
		}
	}
	
	public ImageView heartImages() {
		ImageView heartImage = new ImageView(new Image(ClassLoader.getSystemResource("images/heart.png").toString()));
		heartImage.setFitHeight(25);
		heartImage.setFitWidth(25);
		return heartImage;
	}
	
	public void decreseHeart() {
		if(numHeart ==0) {
			return;
		}
		this.numHeart -= 1;
		hearts.get(numHeart).setVisible(false);
		/*
		for(int i = 0; i < num; i++) {
			hearts.get(i).setVisible(true);
		}
		*/
	}
	
	public int getNumHeart() {
		return this.numHeart;
	}
	
	public void setTooltip(String recipes) {
		Tooltip recipesTooltip = new Tooltip(recipes);
		menu.setOnMousePressed((MouseEvent e) -> {
			if(!isServe) recipesTooltip.show(menu, e.getScreenX(), e.getScreenY());
		});
		menu.setOnMouseReleased((MouseEvent e) -> {
			recipesTooltip.hide();
		});
	}

	public boolean isServe() {
		return isServe;
	}

	public void setServe(boolean isServe) {
		this.isServe = isServe;
	}

	public RecipeName getRecipe() {
		return recipe;
	}


	
}
