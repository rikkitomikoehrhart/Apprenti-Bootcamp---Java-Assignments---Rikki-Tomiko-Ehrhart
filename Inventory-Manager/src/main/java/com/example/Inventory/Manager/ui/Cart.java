package com.example.Inventory.Manager.ui;

import com.example.Inventory.Manager.config.InventoryConfig;
import com.example.Inventory.Manager.model.CartOption;
import com.example.Inventory.Manager.service.CartService;
import com.example.Inventory.Manager.service.InventoryService;
import com.example.Inventory.Manager.ui.cart_handlers.AddProductHandler;
import com.example.Inventory.Manager.ui.cart_handlers.CheckoutHandler;
import com.example.Inventory.Manager.ui.cart_handlers.UpdateCartHandler;
import com.example.Inventory.Manager.ui.cart_handlers.ViewCartHandler;
import com.example.Inventory.Manager.ui.inventory_handlers.SearchProductsHandler;
import com.example.Inventory.Manager.ui.inventory_handlers.ViewProductsHandler;
import org.springframework.stereotype.Component;

@Component
public class Cart {
    private final InventoryService service;
    private final CartService shoppingCart;
    private final View view;
    private final String fileName;

    public Cart(InventoryService service, CartService shoppingCart, View view, InventoryConfig config) {
        this.service = service;
        this.shoppingCart = shoppingCart;
        this.view = view;
        this.fileName = config.getFileName();
    }

    public void run() {
        AddProductHandler addProduct = new AddProductHandler(view, service, shoppingCart);
        ViewProductsHandler viewProducts = new ViewProductsHandler(view, service);
        SearchProductsHandler searchProducts = new SearchProductsHandler(view, service);
        UpdateCartHandler updateCart = new UpdateCartHandler(view, service, shoppingCart);
        ViewCartHandler viewCart = new ViewCartHandler(view, service, shoppingCart);
        CheckoutHandler checkout = new CheckoutHandler(view, service, shoppingCart);


        while (true) {
            view.displayCartMenu();

            CartOption choice = view.getCartChoiceFromUser();

            switch (choice) {
                case ADD_PRODUCT:
                    addProduct.execute();
                    break;
                case VIEW_PRODUCTS:
                    viewProducts.execute();
                    break;
                case SEARCH_PRODUCTS:
                    searchProducts.execute();
                    break;
                case UPDATE_CART:
                    updateCart.execute();
                    break;
                case VIEW_CART:
                    viewCart.execute();
                    break;
                case CHECKOUT:
                    checkout.execute();
                    break;
                case EXIT:
                    System.exit(0);
            }
        }
    }
}
