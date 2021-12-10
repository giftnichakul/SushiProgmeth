package game;



import javafx.scene.image.Image;

import java.util.*;



public enum RecipeName {
	SUSHI_TUNA(0,"sushi_tuna01.png",3,new HashSet<InventoryItemName>(Arrays.asList(InventoryItemName.RICE, InventoryItemName.NORI, InventoryItemName.TUNA)),"rice+tuna+nori"),
    SUSHI_TAMAGO(1,"sushi_tamago01.png",3,new HashSet<InventoryItemName>(Arrays.asList(InventoryItemName.RICE, InventoryItemName.NORI, InventoryItemName.TAMAGO)),"rice+egg+nori"),
    SUSHI_SALMON(2,"sushi_salmon01.png",3,new HashSet<InventoryItemName>(Arrays.asList(InventoryItemName.RICE, InventoryItemName.NORI, InventoryItemName.SALMON)),"rice+salmon+nori"),
    SUSHI_EBI(3,"sushi_ebi01.png",3,new HashSet<InventoryItemName>(Arrays.asList(InventoryItemName.RICE, InventoryItemName.NORI, InventoryItemName.EBI)),"rice+ebi+nori"),
    SUSHI_SQUID(4,"sushi_squid02.png",3,new HashSet<InventoryItemName>(Arrays.asList(InventoryItemName.RICE, InventoryItemName.NORI, InventoryItemName.SQUID)),"rice+squid+nori"),
    SUSHI_OCTOPUS(5,"sushi_squid01.png",3,new HashSet<InventoryItemName>(Arrays.asList(InventoryItemName.RICE, InventoryItemName.NORI, InventoryItemName.OCTOPUS)),"rice+octopus+nori"),
    
    ;
    
    private static Map map = new HashMap<>();
    public String fileName;
    public Set<InventoryItemName> material;
    public int price;
    public int id;
    public String ingredients;
    RecipeName(int id,String fileName,int price,Set<InventoryItemName> material,String ingredients) {
        this.id = id;
        this.fileName = fileName;
        this.price = price;
        this.material = material;
        this.ingredients = ingredients;
    }
    static {
        for (RecipeName n : RecipeName.values()) {
            map.put(n.id, n);
        }
    }


    public static RecipeName valueOf(int pageType) {
        return (RecipeName) map.get(pageType);
    }
    public static RecipeName getRecipeFromId(int id) {
    	
    	return (RecipeName)map.get(id);
    }



    //public Image getImage(int width, int height){
        //Image img = ResourceManager.getImage(fileName,width,height,true);
       //return null;
    //}
} 