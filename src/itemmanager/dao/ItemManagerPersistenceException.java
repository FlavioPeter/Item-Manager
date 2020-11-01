/**
 * 
 */
package itemmanager.dao;

/**
 * @author Flavio Silva
 *
 */
public class ItemManagerPersistenceException extends Exception {
	
	public ItemManagerPersistenceException(String message) {
		super(message);
	}
	
	public ItemManagerPersistenceException(String message, Throwable cause) {
		super(message, cause);
	}
	
}
