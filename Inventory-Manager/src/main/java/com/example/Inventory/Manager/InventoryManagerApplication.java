package com.example.Inventory.Manager;

import com.example.Inventory.Manager.ui.Cart;
import com.example.Inventory.Manager.ui.Inventory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InventoryManagerApplication implements CommandLineRunner {

	@Autowired
	private Cart cart;

	@Autowired
	private Inventory inventory;

	@Value("${inventory.mode:cart}")
	private String mode;


	public static void main(String[] args) { SpringApplication.run(InventoryManagerApplication.class, args); }

	@Override
	public void run(String... args) throws Exception {
		if (mode.equalsIgnoreCase("admin")) {
			inventory.run();
		} else {
			cart.run();
		}
	}
}
