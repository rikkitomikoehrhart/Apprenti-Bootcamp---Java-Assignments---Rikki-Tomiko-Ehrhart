package org.example;

import org.example.exception.NullInputException;
import org.example.service.AppService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class AppServiceTest {
    private AppService ap;

    @BeforeEach
    void setUp() {
        ap = new AppService();
    }


}
