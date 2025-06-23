package org.example.handler;

import org.example.exception.EmptyInputException;
import org.example.exception.NullInputException;
import org.example.service.AppService;
import org.example.service.CartService;

public interface HandlerInterface {
    void execute(AppService appService, CartService cartService) throws EmptyInputException, NullInputException;
}
