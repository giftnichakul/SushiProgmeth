package sushishop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import game.InventoryItem;
import game.InventoryItemName;
import game.RecipeName;

public class Recipes {
	
	//private private Map<InventoryItemName,InventoryItem> menu = new HashMap<InventoryItemName,InventoryItem>();
	public static List<Recipe> recipes = new ArrayList<Recipe>();
    public static void add(RecipeName output,InventoryItemName[] input){
        Recipes.recipes.add(new Recipe(output,input));
    }

    public static Recipe getRecipe(String[] input) throws Exception{
        Set<String> sInput = new HashSet<String>();
        for(String s: input){
            sInput.add(s);
        }
        /*
        for(Recipe recipe: recipes){
            if(recipe.isInputMatch(sInput)){
                return recipe;
            }
        }
        */
        throw new Exception("Recipe not found");
        
    }

}
