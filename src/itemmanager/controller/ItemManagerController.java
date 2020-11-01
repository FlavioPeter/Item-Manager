/**
 * 
 */
package itemmanager.controller;

import itemmanager.service.ItemManagerOptionException;
import itemmanager.dao.ItemManagerPersistenceException;
import itemmanager.dto.Item;
import itemmanager.service.ItemManagerServiceLayer;
import itemmanager.ui.ItemManagerView;

/**
 * @author Flavio Silva
 *
 */
public class ItemManagerController {
	
	ItemManagerServiceLayer service;
	ItemManagerView view;
	
	ItemManagerController(ItemManagerServiceLayer service, ItemManagerView view){
		this.service = service;
		this.view = view;
	}
	
	public void run() {
		boolean keepEditing = true;
		int selection = 0;
		
		try {
			while(keepEditing) {
				try {
					showMenu();
					
					selection = receiveSelection();
					
					directSelection(selection);
					
					keepEditing = selectAgain();
				}catch(ItemManagerOptionException e) {
					promptError(e);
				}
			}
		}catch(ItemManagerPersistenceException e) {
			//promptError(e);
		}
		goodBye();
	}
	

	private void showMenu() {
		view.menuBanner();
		view.viewMenu();

	}

	private int receiveSelection() {
		return view.getSelection();
	}

	private void directSelection(int selection) throws ItemManagerOptionException {
		switch(selection) {
		case 1:
			view.listItemBanner();
			service.listItem();
			break;
		case 2:
			view.lookItemBanner();
			String itemIdSearch = view.getItemId();
			Item itemFound = service.lookItem(itemIdSearch);
			view.dispItemInfo(itemFound);
			break;
		case 3:
			view.addItemBanner();
			Item currentItem = view.getNewItemInfo();
			service.addItem(currentItem);
			view.dispItemInfo(currentItem);
			break;
		case 4:
			view.removeItemBanner();
			String itemIdRemove = view.getItemId();
			service.removeItem(itemIdRemove);
			break;
		case 5:
			view.exitItemBanner();
			view.exitSession();
			break;
		default:
			throw new ItemManagerOptionException("ERROR: The selection "+selection+" is not valid.");
		}
	}

	private boolean selectAgain() {
		// TODO Auto-generated method stub
		return false;
	}
	
	private void promptError(Exception e) {
		view.promptErrorMessage(e.getMessage());
	}
	
	private void goodBye() {
		view.goodByeMessage();
	}
	
}
