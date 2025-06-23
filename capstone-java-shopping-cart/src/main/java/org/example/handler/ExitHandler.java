package org.example.handler;

import org.example.service.AppService;
import org.example.service.CartService;

public class ExitHandler implements HandlerInterface {

    @Override
    public void execute(AppService appService, CartService cartService) {
        appService.print("Thank you! Have a great day!");
        System.exit(0);
    }
}
