/**
 * 
 */
package itemmanager.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import itemmanager.dto.Item;

/**
 * @author Flavio Silva
 *
 */
public interface ItemManagerDao {

	public List<Item> getAllItems() throws ItemManagerPersistenceException;

	public Item getItem(String itemId) throws ItemManagerPersistenceException;

	public Item addItem(String itemId, Item item) throws ItemManagerPersistenceException, IOException;
		
	public Item removeItem(String itemId) throws ItemManagerPersistenceException, IOException;

	public Item removeStudent(String itemId);
	
}
