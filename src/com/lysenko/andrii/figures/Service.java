package com.lysenko.andrii.figures;

import com.lysenko.andrii.employees.Employee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Service {
    /*Information about each figure wil be written from new line.*/
    public static void writeToFile(List<Figure> figures, String file) throws IOException {
        FileWriter f = new FileWriter(file);
        try {
            for (Figure figure : figures) {
                f.write(figure.toString() + '\n');
            }
        }finally {
            f.close();
        }
    }

    /*Every line in file parsed to get figure or exception*/
    public static void readFromFile(List<Figure> figures, String file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                try {
                    figures.add(parseLine(line));
                } catch (IllegalArgumentException e) {
                    System.out.println(line + "  = incorrect input line for figure");
                }
            }
        }finally {
            reader.close();
        }
    }

    private static Figure parseLine(String line) throws IllegalArgumentException {
        Employee employee;

        /*delete all extra spaces*/
        final String twoSpaces="  ";
        final String oneSpace=" ";
        line = line.trim();
        while(line.indexOf(twoSpaces) >= 0) {
            line.replace(twoSpaces, oneSpace);
        }
        String [] splitLine = line.split(" ");

        if (splitLine.length != 3) {
            throw new IllegalArgumentException();
        } else {
            double measure;
            double innerMeasure;
            String figureType = splitLine[0];
            /*parsing measure and innerMeasure*/
            try {
                measure = Double.parseDouble(splitLine[1]);
                innerMeasure = Double.parseDouble(splitLine[2]);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }
            /*parsing figureType*/
            if ("circle".equals(figureType)) {
                return new Circle(measure/(2*Math.PI));
            } else if ("cylinder".equals(figureType)){
                Circle circle = new Circle((innerMeasure*2)/measure);
                return new Cylinder(innerMeasure/circle.getInnerMeasure(), circle);
            } else {
                throw new IllegalArgumentException();
            }
        }
    }
}
