package scene;

import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class OrderPane extends VBox{
	
	private ImageView characterImages;
	private int characterNumber;
	private MenuPane menu;
	private ArrayList<ImageView> smileFace = new ArrayList<ImageView>();
	private ArrayList<ImageView> unhappyFace = new ArrayList<ImageView>();
	private ArrayList<ImageView> angryFace = new ArrayList<ImageView>();
	private ArrayList<ImageView> happyFace = new ArrayList<ImageView>();
	
	public OrderPane() {
		this.setPrefWidth(200);
		this.setPrefHeight(280);
		this.setAlignment(Pos.TOP_CENTER);
		menu = new MenuPane("");
		this.setMargin(menu, new Insets(5, 0, 0, 0));
		initSmileFace();
		initUnhappyFace();
		initAngryFace();
		initHappyFace();
		this.characterNumber = this.getRandomNumber();
		characterImages = smileFace.get(this.characterNumber);
		setCharacterImage();
		setMenu();
		this.getChildren().addAll(menu, characterImages);
	}
	
	public ImageView getCharacter(String image) {
		ImageView characterImage = new ImageView(new Image(ClassLoader.getSystemResource("images/" + image).toString()));
		characterImage.setFitHeight(170);
		characterImage.setFitWidth(115);
		return characterImage;
	}
	
	private void initSmileFace() {
		for(int i = 1; i <= 8; i++) {
			smileFace.add(this.getCharacter("smileFace" +i +".png"));
		}
	}
	
	private void initAngryFace() {
		for(int i = 1; i <= 8; i++) {
			angryFace.add(this.getCharacter("angryFace"+i+".png"));
		}
	}
	
	private void initHappyFace() {
		for(int i = 1; i <= 8; i++) {
			happyFace.add(this.getCharacter("happyFace"+i+".png"));
		}
	}
	
	private void initUnhappyFace() {
		for(int i = 1; i <= 8; i++) {
			unhappyFace.add(this.getCharacter("unhappyFace"+i+".png"));
		}
	}
	
	public int getRandomNumber() {
	    return (int) ((Math.random() * 7) + 1);
	}
	
	public void setCharacterImage() {
		if(menu.isServe()) {
			characterImages = happyFace.get(characterNumber);
		}else if(menu.getNumHeart() <= 3) {
			characterImages = unhappyFace.get(characterNumber);
		}else if(menu.getNumHeart() == 0) {
			characterImages = angryFace.get(characterNumber);
		}
	}
	
	public void setMenu() {
		if(menu.isServe()) {
			menu.setVisible(false);
		}
	}
}
