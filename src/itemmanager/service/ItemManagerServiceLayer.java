/**
 * 
 */
package itemmanager.service;

import java.io.IOException;
import java.util.List;

import itemmanager.dao.ItemManagerPersistenceException;
import itemmanager.dto.Item;

/**
 * @author Flavio Silva
 *
 */
public interface ItemManagerServiceLayer {

	public List<Item> listItem() throws ItemManagerPersistenceException;

	public Item lookItem(String itemId) throws ItemManagerPersistenceException;

	public void addItem(Item item) throws ItemManagerPersistenceException, IOException;

	public Item removeItem(String itemId) throws ItemManagerPersistenceException;

}
