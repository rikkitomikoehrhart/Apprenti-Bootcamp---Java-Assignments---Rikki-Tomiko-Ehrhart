package org.example.handler;

import org.example.service.AppService;

public class ExitHandler {

    public void execute(AppService appService) {
        appService.print("Thank you! Have a great day!");
        System.exit(0);
    }
}
