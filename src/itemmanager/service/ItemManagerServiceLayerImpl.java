/**
 * 
 */
package itemmanager.service;

import java.io.IOException;
import java.util.List;

import itemmanager.dao.ItemManagerAuditDao;
import itemmanager.dao.ItemManagerDao;
import itemmanager.dao.ItemManagerPersistenceException;
import itemmanager.dto.Item;

/**
 * @author Flavio Silva
 *
 */
public class ItemManagerServiceLayerImpl implements ItemManagerServiceLayer {
	
	private ItemManagerDao dao;
	private ItemManagerAuditDao auditDao;
	
	public ItemManagerServiceLayerImpl(ItemManagerDao dao, ItemManagerAuditDao auditDao){
		this.dao = dao;
		this.auditDao = auditDao;
	}
	
	@Override
	public List<Item> listItem() throws ItemManagerPersistenceException {
		return dao.getAllItems();
	}
	
	@Override
	public Item lookItem(String itemId) throws ItemManagerPersistenceException {
		return dao.getItem(itemId);
	}
	
	@Override
	public void addItem(Item item) throws ItemManagerPersistenceException, IOException {
		dao.addItem(item.getId(), item);
	}
	
	@Override
	public Item removeItem(String itemId) throws ItemManagerPersistenceException {
		Item removedItem = dao.removeStudent(itemId);
		// Write to audit log
		auditDao.writeAuditEntry("Student "+itemId+" REMOVED.");
		return removedItem;
	}
}
