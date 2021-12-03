package scene;

import java.util.ArrayList;
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
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class MenuPane extends VBox{
	
	private ImageView menu;
	private HBox heart;
	private int numHeart;
	private boolean isServe;
	private ArrayList<ImageView> hearts = new ArrayList<ImageView>();
	
	public MenuPane(String name) {
		this.isServe = false;
		this.setMaxHeight(115);
		this.setMaxWidth(150);
		this.setAlignment(Pos.TOP_CENTER);
		this.setBackground(new Background(new BackgroundFill(Color.BEIGE, CornerRadii.EMPTY, Insets.EMPTY)));
		//rename image name to name!!!!
		menu = new ImageView(new Image(ClassLoader.getSystemResource("images/tamago02.png").toString()));
		menu.setFitHeight(80);
		menu.setFitWidth(145);
		//change recipes to each menu!!!
		setTooltip("rice + salmon");
		initHeart();
		this.numHeart = 5;
		this.getChildren().addAll(menu, heart);
	}
	
	public void initHeart() {
		heart = new HBox();
		heart.setMaxHeight(25);
		heart.setMaxWidth(75);
		for(int i = 0; i < 5; i++) {
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
	
	public void decreseHeart(int num) {
		this.numHeart -= num;
		for(int i = 0; i < num; i++) {
			hearts.get(i).setVisible(true);
		}
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

}
