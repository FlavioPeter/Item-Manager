/**
 * 
 */
package itemmanager.dao;

/**
 * @author Flavio Silva
 *
 */
public interface ItemManagerAuditDao {

	public void writeAuditEntry(String entry) throws ItemManagerPersistenceException;
	
}
