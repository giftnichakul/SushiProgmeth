package game;
/*
public enum InventoryItemName {
	SALMON,RICE,NORI,TUNA,EBI,TAMAGO,IKURA,SQUID,OCTOPUS,
}
*/
public enum InventoryItemName {
    RICE("rice02.png",100),
    NORI("nori01.png",100),
    TUNA("tuna01.png",100),
    SALMON("salmon03.png",100),
    IKURA("salmon_egg01.png",100),
    EBI("shrimp01.png",2),
    OCTOPUS("octopus02.png",100),
    SQUID("squid01.png",100),
    TAMAGO("tamago02.png",100),
    CUCMOBER("cucumber01.png",100),
    WASABI("wasabi02.png",100)
    ;
    public String fileName;
    private int quantity;

    InventoryItemName(String fileName,int quantity) {
        this.fileName = fileName;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}