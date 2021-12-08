package game;



import javafx.scene.image.Image;

import java.util.*;



public enum RecipeName {
    SUSHI_TAMAGO("sushi_tamago01.png",3.0,new HashSet<InventoryItemName>(Arrays.asList(InventoryItemName.RICE, InventoryItemName.NORI, InventoryItemName.TAMAGO))),
    SUSHI_SALMON("sushi_salmon02.png",3.0,new HashSet<InventoryItemName>(Arrays.asList(InventoryItemName.RICE, InventoryItemName.NORI, InventoryItemName.SALMON))),
    SUSHI_EBI("sushi_ebi01.png",3.0,new HashSet<InventoryItemName>(Arrays.asList(InventoryItemName.RICE, InventoryItemName.NORI, InventoryItemName.EBI))),
    SUSHI_SQUID("sushi_squid02.png",3.0,new HashSet<InventoryItemName>(Arrays.asList(InventoryItemName.RICE, InventoryItemName.NORI, InventoryItemName.SQUID))),
    SUSHI_OCTOPUS("sushi_squid01.png",3.0,new HashSet<InventoryItemName>(Arrays.asList(InventoryItemName.RICE, InventoryItemName.NORI, InventoryItemName.OCTOPUS))),
    SUSHI_TUNA("sushi_tuna01.png",3.0,new HashSet<InventoryItemName>(Arrays.asList(InventoryItemName.RICE, InventoryItemName.NORI, InventoryItemName.TUNA))),
    ;
    
    private static Map map = new HashMap<>();
    public String fileName;
    public Set<InventoryItemName> material;
    public double price;
    RecipeName(String fileName,double price,Set<InventoryItemName> material) {
        
        this.fileName = fileName;
        this.price = price;
        this.material = material;
    }
    


    public static RecipeName valueOf(int pageType) {
        return (RecipeName) map.get(pageType);
    }



    //public Image getImage(int width, int height){
        //Image img = ResourceManager.getImage(fileName,width,height,true);
       //return null;
    //}
} 