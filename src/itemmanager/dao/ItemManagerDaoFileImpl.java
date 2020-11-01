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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import itemmanager.dto.Item;
import itemmanager.dto.ItemCategory;

/**
 * @author Flavio Silva
 *
 */
public class ItemManagerDaoFileImpl implements ItemManagerDao {
	
	private Map<String, Item> items = new TreeMap<>();
	
	private final String ITEMS_FILE;
	private static final String DELIMITER = "::";
	
	public ItemManagerDaoFileImpl() {
		ITEMS_FILE = "items.txt";
	}
	
	public ItemManagerDaoFileImpl(String txtFile) {
		ITEMS_FILE = txtFile;
	}
	
	private Item unmarshallItems(String itemAsText) {
		String[] itemTokens = itemAsText.split(DELIMITER);
		
		String itemId = itemTokens[0];
		
		Item item = new Item(itemId);
		
		item.setName(itemTokens[1]);
		
		item.setType(ItemCategory.valueOf(itemTokens[2]));
		
		item.setWorth((new BigDecimal(itemTokens[3])).setScale(2,RoundingMode.HALF_UP));
		
		item.setWeight(Double.valueOf(itemTokens[4]));
		
		return item;
		
	}
	
	private void loadItems() throws ItemManagerPersistenceException {
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
	
	private void writeItems(Map<String, Item> items) throws ItemManagerPersistenceException, IOException {
		
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
	
	@Override
	public List<Item> getAllItems() throws ItemManagerPersistenceException {
		loadItems();
		return new ArrayList<Item>(items.values());
	}
	
	@Override
	public Item getItem(String itemId) throws ItemManagerPersistenceException {
		loadItems();
		return items.get(itemId);
	}
	
	@Override
	public Item addItem(String itemId, Item item) throws ItemManagerPersistenceException, IOException {
		loadItems();
		Item newItem = items.put(itemId, item);
		writeItems(items);
		return newItem;
	}
	
	@Override
	public Item removeItem(String itemId) throws ItemManagerPersistenceException, IOException {
		loadItems();
		Item removedItem = items.remove(itemId);
		writeItems(items);
		return removedItem;
	}
	
}
