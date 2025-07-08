package com.example.Inventory.Manager;

import com.example.Inventory.Manager.model.MenuOption;
import com.example.Inventory.Manager.ui.View;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InventoryManagerApplication {
	public static void main(String[] args) {
		View view = new View();


		SpringApplication.run(InventoryManagerApplication.class, args);


		while(true) {
			view.displayMainMenu();

			MenuOption choice = view.getMenuChoiceFromUser();

			switch (choice) {
				case ADD_PRODUCT:
					break;
				case VIEW_PRODUCTS:
					break;
				case SEARCH_PRODUCTS:
					break;
				case UPDATE_PRODUCT:
					break;
				case DELETE_PRODUCT:
					break;
				case LOAD_INVENTORY:
					break;
				case EXIT:
					System.exit(0);
			}

		}



	}

}
