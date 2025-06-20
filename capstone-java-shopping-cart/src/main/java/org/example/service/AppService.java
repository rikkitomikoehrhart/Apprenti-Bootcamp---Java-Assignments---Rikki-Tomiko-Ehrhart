package org.example.service;

import org.example.exception.EmptyInputException;
import org.example.exception.NullInputException;

import java.util.Scanner;

public class AppService {
    Scanner scanner = new Scanner(System.in);

    public void print(String message) {
        System.out.println(message);
    }

    public String getStringFromUser(String prompt) throws NullInputException, EmptyInputException {
        print(prompt);
        String entry = "";
        while (true) {
            try {
                entry = scanner.nextLine();
                if (entry == null) {
                    throw new NullInputException("You cannot enter nothing.");
                } else if (entry == "" || entry == " ") {
                    throw new EmptyInputException("You must enter something.");
                }
            } catch (NullInputException e) {
                print(e.getMessage());
                continue;
            } catch (EmptyInputException e) {
                print(e.getMessage());
                continue;
            }

            return entry;
        }
    }
}
