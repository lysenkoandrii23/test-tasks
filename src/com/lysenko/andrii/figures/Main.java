package com.lysenko.andrii.figures;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Figure> figures = new ArrayList<Figure>();
        figures.add(new Circle(11));
        figures.add(new Circle(3));
        figures.add(new Cylinder(5, new Circle(3)));

        System.out.println("--------list of figures----------------");
        for(Figure figure : figures) {
            System.out.println(figure);
        }

        System.out.println("--------figure with max measure----------");
        System.out.println(Collections.max(figures));

        try {
            Service.writeToFile(figures, "D:/test.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*reading same information from file*/
        figures = new ArrayList<Figure>();
        try {
            Service.readFromFile(figures, "D:/test.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("-------------------figures from file---------");
        for(Figure figure : figures) {
            System.out.println(figure);
        }
    }
}
