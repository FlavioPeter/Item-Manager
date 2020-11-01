/**
 * 
 */
package itemmanager.dao;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

/**
 * @author Flavio Silva
 *
 */
public class ItemManagerAuditDaoFileImpl {

	private static final String AUDIT_FILE = "audit.txt";
	
	public void writeAuditEntry(String entry) throws ItemManagerPersistenceException {
		PrintWriter out;
		
		try {
			out = new PrintWriter(new FileWriter(AUDIT_FILE, true));
		}catch(IOException e) {
			throw new ItemManagerPersistenceException("ERROR: Could not persist audit entry into flat file.", e);
		}
		
		LocalDateTime timestamp = LocalDateTime.now();
		out.println(timestamp.toString()+" : "+entry);
		out.flush();
	}
	
}
