package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FruitRepositoryTest {
    // These variables are going to hold the repository under test and some expected test data
    // Collectively, they are called "test fixtures"
    FruitRepository repo;
    Fruit testFruit1;
    Fruit testFruit2;
    Fruit testFruit3;

    @BeforeEach     // This method will run once before EACH test case
    public void setUp() {
        repo = new FruitRepository();   // Resets the FruitRepository to a fresh, clean object

        // Regenerate the test values
        testFruit1 = new Fruit("Apple", "red");
        testFruit2 = new Fruit("Orange", "orange");
        testFruit3 = new Fruit("Banana", "yellow");

        // Set up the repository's known good state by saving the test data to it
        repo.save(testFruit1);
        repo.save(testFruit2);
        repo.save(testFruit3);
    }


    @Test
    public void testDeleteWorks() {
        repo.delete("Apple");
        Fruit fruit = repo.find("Apple");
        assertNull(fruit);
    }

}
