package org.example.service;

import org.example.exception.EmptyInputException;
import org.example.exception.NullInputException;

import java.util.Scanner;

public class AppService {
    Scanner scanner = new Scanner(System.in);

    public void print(String message) {
        System.out.println(message);
    }

    public String getStringFromUser(String prompt) throws EmptyInputException, NullInputException {
        while (true) {
            print(prompt);
            String entry = scanner.nextLine();

            if (entry == processString(entry)) {
                return entry;
            } else {
                continue;
            }
        }
    }

    public String processString(String string) throws NullInputException, EmptyInputException {
        try {
            if (string == null) {
                throw new NullInputException("You cannot enter nothing");
            } else if (string == "" || string == " ") {
                throw new EmptyInputException("You must enter something.");
            }
        } catch (NullInputException | EmptyInputException e) {
            print(e.getMessage());
            return null;
        }

        return string;
    }


    
}
