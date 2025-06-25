package org.example.handler;

import org.example.service.*;


public class ExitHandler implements WorkFlowHandler {
    private AppService appService;

    public ExitHandler(AppService appService) {
        this.appService = appService;
    }

    @Override
    public void execute() {
        appService.println("Thank you! Have a great day!");
        System.exit(0);
    }
}
