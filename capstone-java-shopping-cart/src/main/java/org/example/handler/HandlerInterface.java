package org.example.handler;

import org.example.exception.*;
import org.example.service.*;


public interface HandlerInterface {
    void execute(AppService appService, CartService cartService) throws EmptyInputException, NullInputException;
}
