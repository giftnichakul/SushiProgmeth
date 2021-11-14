package sushishop;

import game.SushiGame;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

public class GamePane extends Pane {
	SushiGame sushiGame;
	public GamePane() {
		sushiGame = SushiGame.get();
	}
	
	public void println(String tag,String m) {
		System.out.println(tag+ " : "+m);
	}
	
	public void addChildren(Node p) {
		this.getChildren().add(p);
	}
}
