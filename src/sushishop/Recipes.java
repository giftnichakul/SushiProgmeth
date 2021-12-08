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
	//public static List<Recipe> recipes = new ArrayList<Recipe>();
    //public static void add(RecipeName output,InventoryItemName[] input){
    //    Recipes.recipes.add(new Recipe(output,input));
//   }

    public static RecipeName getRecipe(Set<InventoryItemName> sInput) throws Exception{
    	/*
        Set<InventoryItemName> sInput = new HashSet<InventoryItemName>();
        for(InventoryItemName s: input){
            sInput.add(s);
        }*/
        
        for(RecipeName recipe: RecipeName.values()){
            if(recipe.material.equals(sInput)){
                return recipe;
            }
        }
        
        throw new Exception("Recipe not found");
        
    }

}
