package sushishop;

import game.InventoryItemName;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class MaterialPane extends GamePane {
	protected MaterialPane self;
	protected boolean selected = false;
	protected int imgSize = 85;
	protected InventoryItemName materialName;
	public MaterialPane(InventoryItemName name) {
		self = this;
		this.materialName = name;
		ImageView item  = new ImageView(sushiGame.getInventories().get(name).getImage());
		item.setFitWidth(imgSize);
		item.setFitHeight(imgSize);
		
		this.setOnMouseClicked(new EventHandler<MouseEvent>() {
			//it detects once when the mouse is released.
			@Override
			public void handle(MouseEvent event) {
				
				setSelected(!isSelected());
				self.println(self.toString(),""+isSelected());
				if(isSelected()) {
					self.setStyle("-fx-border-color: black;");
				}
				else {
					self.setStyle("-fx-border-color: none;");
				}
			}	
		});
		
		this.setOnMouseEntered(new EventHandler<MouseEvent>() {
			//it detects once when the mouse is released.
			@Override
			public void handle(MouseEvent event) {
				item.setScaleX(1.05);
				item.setScaleY(1.05);
				self.println(self.toString(),"enter");
			}	
		});
		
		this.setOnMouseExited(new EventHandler<MouseEvent>() {
			//it detects once when the mouse is released.
			@Override
			public void handle(MouseEvent event) {
				item.setScaleX(1);
				item.setScaleY(1);
				self.println(self.toString(),"exit");
			}	
		});
		this.addChildren(item);
	}
	
	public String toString() {
		return this.getClass().getName() +"["+materialName +"]";
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean isSelected) {
		this.selected = isSelected;
	}

	public InventoryItemName getMaterialName() {
		return materialName;
	}

	public void setMaterialName(InventoryItemName materialName) {
		this.materialName = materialName;
	}
	
}
