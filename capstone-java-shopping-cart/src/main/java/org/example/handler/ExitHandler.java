package org.example.handler;

import org.example.service.*;


public class ExitHandler implements HandlerInterface {

    @Override
    public void execute(AppService appService, CartService cartService) {
        appService.println("Thank you! Have a great day!");
        System.exit(0);
    }
}
