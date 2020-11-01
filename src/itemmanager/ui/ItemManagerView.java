/**
 * 
 */
package itemmanager.ui;

import java.math.BigDecimal;
import java.math.RoundingMode;

import itemmanager.dto.Item;
import itemmanager.dto.ItemCategory;

/**
 * @author Flavio Silva
 *
 */
public class ItemManagerView {
	
	UserIO io;
	
	public ItemManagerView(UserIO io) {
		this.io = io;
	}
	
	public void menuBanner() {
		io.print("___ Menu ___");
	}
	
	public void viewMenu() {
		io.print("1) List items");
		io.print("2) Look for an item");
		io.print("3) Add an item");
		io.print("4) Remove an item");
		io.print("5) Exit");
		io.print("");
	}
	
	public void listItemBanner() {
		io.print("=== LIST ITEM ===");
	}
	
	public void lookItemBanner() {
		io.print("=== LOOK ITEM ===");
	}
	
	public void addItemBanner() {
		io.print("=== ADD ITEM ===");
	}
	
	public void removeItemBanner() {
		io.print("=== REMOVE ITEM ===");
	}
	
	public void exitItemBanner() {
		io.print("=== EXIT ITEM ===");
	}
	
	public void byCategoryBannerDirector(ItemCategory category) {
		switch(category) {
		case CLOTHING:
			byClothingBanner();
			break;
		case ELECTRONIC:
			byElectronicBanner();
			break;
		case FURNITURE:
			byFurnitureBanner();
			break;
		case OTHER:
			byOtherBanner();
			break;
		case ALL:
			byIdBanner();
		}
	}
	
	public void byClothingBanner() {
		io.print("--- CLOTHING ---");
	}
	
	public void byElectronicBanner() {
		io.print("--- ELECTRONIC ---");
	}
	
	public void byFurnitureBanner() {
		io.print("--- FURNITURE ---");
	}
	
	public void byOtherBanner() {
		io.print("--- OTHER ---");
	}
	
	public void byIdBanner() {
		io.print("--- ALL ---");
	}

	public int getSelection() {
		return io.readInt("Please pick a selection from the menu: ");
	}

	public void promptErrorMessage(String message) {
		io.print(message);
	}

	public void exitSession() {
		io.print("Terminating Session.....");
	}
	
	public void goodByeMessage() {
		io.print("GOOD BYE");
	}

	public Item getNewItemInfo() {
		String itemId = io.readString("Please give the item a unique 4 digit ID (e.g: 0001, 0002, etc): ");
		String name = io.readString("What is the name of the item?: ");
		ItemCategory type = ItemCategory.valueOf(io.readString("Please pick a valid type "
				+ "\n among: \n CLOTHING, \n ELECTRONIC, \n FURNITURE, \n OTHER): "));
		BigDecimal worth = new BigDecimal(io.readString("Assign a value to the item: "));
		worth.setScale(2, RoundingMode.HALF_UP);
		Double weight = io.readDouble("Please assign a weight to the item: ");
		
		Item newItem = new Item(itemId);
		newItem.setName(name);
		newItem.setType(type);
		newItem.setWorth(worth);
		newItem.setWeight(weight);
		
		return newItem;
	}

	public String getItemId() {
		return io.readString("Type the item ID (e.g: 0001, 0002, ...): ");
	}

	public void dispItemInfo(Item item) {
		io.print("ID: "+item.getId()
		+"Name: "+item.getName()
		+"Type: "+item.getType()
		+"Worth: "+item.getWorth()
		+"Weight: "+item.getWeight()
		+"\n");
	}
}
