package org.example.handler;

import org.example.service.*;



public interface WorkFlowHandler {
    void execute(AppService appService, CartService cartService);
}
