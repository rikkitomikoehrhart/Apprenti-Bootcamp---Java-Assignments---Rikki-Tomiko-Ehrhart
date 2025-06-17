package com.example;
import java.util.List;

import static java.lang.Math.*;

public class App {

    public static void main(String[] args) {

    }

    public static double calculateArea(double radius) {
        return PI * pow(radius, 2);
    }

    public static void square(List<Integer> a) {
        for (int i = 0; i < a.size(); i++) {
            a.set(i, a.get(i) * a.get(i));
        }
    }
}
