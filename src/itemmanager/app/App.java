/**
 * 
 */
package itemmanager.app;

import itemmanager.controller.ItemManagerController;
import itemmanager.dao.ItemManagerAuditDao;
import itemmanager.dao.ItemManagerAuditDaoFileImpl;
import itemmanager.dao.ItemManagerDao;
import itemmanager.dao.ItemManagerDaoFileImpl;
import itemmanager.service.ItemManagerServiceLayer;
import itemmanager.service.ItemManagerServiceLayerImpl;
import itemmanager.ui.ItemManagerView;
import itemmanager.ui.UserIO;
import itemmanager.ui.UserIOConsoleImpl;

/**
 * @author Flavio Silva
 *
 */
public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	/*
		// Instantiate the UserIO implementation
		UserIO myIO = new UserIOConsoleImpl();
		// Instantiate the View and wire the UserIO implementation into it
		ItemManagerView myView = new ItemManagerView(myIO);
		// Instantiate the DAO
		ItemManagerDao myDao = new ItemManagerDaoFileImpl();
		// Instantiate the Audit DAO
		ItemManagerAuditDao myAuditDao = new ItemManagerAuditDaoFileImpl();
		// Instantiate the Service Layer and wire the DAO and Audit DAO into it
		ItemManagerServiceLayer myService = new ItemManagerServiceLayerImpl(myDao, myAuditDao);
		// Instantiate the controller and wire Service Layer into it
		ItemManagerController controller = new ItemManagerController(myService, myView);
		// Kick off the controller
		controller.run();
	*/
	}

}
