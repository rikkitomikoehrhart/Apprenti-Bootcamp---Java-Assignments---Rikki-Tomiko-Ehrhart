package org.example.handler;

import org.example.exception.*;
import org.example.model.Item;
import org.example.model.ShoppingCart;
import org.example.service.*;

import java.util.HashMap;


public interface WorkFlowHandler {
    void execute(AppService appService, CartService cartService, ShoppingCart shoppingCart, HashMap<Item, Integer> cart) throws EmptyInputException, NullInputException;
}
