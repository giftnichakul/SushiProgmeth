package game;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public enum Customer {
	GIRLA(1,"happyFace1.png","unhappyFace1.png","angryFace1.png","happyFace1.png",5),
	BOYA(2,"happyFace2.png","unhappyFace2.png","angryFace2.png","happyFace2.png",4),
	BLONDGIRL(3,"happyFace3.png","unhappyFace3.png","angryFace3.png","happyFace3.png",5),
	PONYGIRL(4,"happyFace4.png","unhappyFace4.png","angryFace4.png","happyFace4.png",2),
	ASIAN(5,"happyFace5.png","unhappyFace5.png","angryFace5.png","happyFace5.png",4),
	SPANISH(6,"happyFace6.png","unhappyFace6.png","angryFace6.png","happyFace6.png",3),
	GREECE(7,"happyFace7.png","unhappyFace7.png","angryFace7.png","happyFace7.png",5),
	AFRICAN(8,"happyFace8.png","unhappyFace8.png","angryFace8.png","happyFace8.png",5),
	;
	public int id;
	public String smileFile;
	public String unhappyFile;
	public String angryFile;
	public String happyFile; 
	public int patience;
	private static Map map = new HashMap<>();

    Customer(int id,String smileFile,String unhappyFile,String angryFile,String happyFile,int patience) {
        this.smileFile = smileFile;
        this.id = id;
        this.unhappyFile = unhappyFile;
        this.angryFile = angryFile;
        this.happyFile = happyFile;
        this.patience = patience;
    }
    static {
        for (Customer c : Customer.values()) {
            map.put(c.id, c);
        }
    }
    public static Customer getCustomerFromId(int id) {
    	
    	return (Customer)map.get(id);
    }
}
