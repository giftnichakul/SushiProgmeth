package sushishop;

import game.RecipeName;

public interface Shopable {
	public RecipeName itemArrived();
	public void dealItem();
	public void dealItem(RecipeName r); 
	public boolean currentAvailable();

}

