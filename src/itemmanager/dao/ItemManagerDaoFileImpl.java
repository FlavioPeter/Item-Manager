/**
 * 
 */
package itemmanager.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import itemmanager.dto.Item;
import itemmanager.dto.ItemCategory;

/**
 * @author Flavio Silva
 *
 */
public class ItemManagerDaoFileImpl {
	
	private Map<String, Item> items = new TreeMap<>();
	
	private static final String ITEMS_FILE = "items.txt";
	private static final String DELIMITER = "::";
	
	private Item unmarshallItems(String itemAsText) {
		String[] itemTokens = itemAsText.split(DELIMITER);
		
		String itemId = itemTokens[0];
		
		Item item = new Item(itemTokens[0]);

		item.setName(itemTokens[1]);
		
		item.setType(ItemCategory.valueOf(itemTokens[2]));
		
		item.setWorth((new BigDecimal(itemTokens[3])).setScale(2,RoundingMode.HALF_UP));
		
		item.setWeight(Double.valueOf(itemTokens[4]));
		
		return item;
		
	}
	
	private void loadItem() throws ItemManagerPersistenceException {
		Scanner scanner;
		
		try {
			scanner = new Scanner(new BufferedReader(new FileReader(ITEMS_FILE)));
		}catch(FileNotFoundException e){
			throw new ItemManagerPersistenceException("ERROR: Could not load items from flat file", e);
		}
		
		String currentLine;
		
		Item currentItem;
		
		while(scanner.hasNextLine()) {
			
			currentLine = scanner.nextLine();
			
			currentItem = unmarshallItems(currentLine);
			
			items.put(currentItem.getId(), currentItem);
		}
		scanner.close();
	}
	
	private String marshallItems(Item item) {
		
		String itemAsText = item.getId() + DELIMITER;
		
		itemAsText += item.getName() + DELIMITER;
		
		itemAsText += item.getType() + DELIMITER;
		
		itemAsText += item.getWorth() + DELIMITER;
		
		return itemAsText += item.getWeight();
	}
	
	public void writeItems(Map<String, Item> items) throws ItemManagerPersistenceException, IOException {
		
		PrintWriter scanner;
		
		try {
			scanner = new PrintWriter(new FileWriter(ITEMS_FILE));
		}catch(FileNotFoundException e) {
			throw new ItemManagerPersistenceException("The flat file for storing date was not found.",e);
		}
		
		for(Map.Entry<String, Item> thisItem : items.entrySet()) {
			scanner.println(marshallItems(thisItem.getValue()));
		}
		
		scanner.close();
	}
}
