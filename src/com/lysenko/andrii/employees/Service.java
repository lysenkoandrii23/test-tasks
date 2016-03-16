package com.lysenko.andrii.employees;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Service {
    public static void writeToFile(List<Employee> employees, String file) throws IOException {
        FileWriter f = new FileWriter(file);
        try {
            for (Employee employee : employees) {
                f.write(employee.toString() + '\n');
            }
        }finally {
            f.close();
        }
    }

    public static void readFromFile(List<Employee> employees, String file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                try {
                    employees.add(parseLine(line));
                } catch (IllegalArgumentException e) {
                    System.out.println(line + "  = incorrect input line for employee");
                }
            }
        }finally {
            reader.close();
        }
    }

    private static Employee parseLine(String line) throws IllegalArgumentException {
        Employee employee;

        final String twoSpaces="  ";
        final String oneSpace=" ";
        line = line.trim();
        while(line.indexOf(twoSpaces) >= 0) {
            line.replace(twoSpaces, oneSpace);
        }
        String [] splitLine = line.split(" ");

        if (splitLine.length != 4) {
            throw new IllegalArgumentException();
        } else {
            int id;
            double averageMonthlySalary;
            String employeeType = splitLine[0];
            String name = splitLine[2];
            try {
                id = Integer.parseInt(splitLine[1]);
                averageMonthlySalary = Double.parseDouble(splitLine[3]);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }

            if ("hourlyWageEmployee".equals(employeeType)) {
                return new HourlyWageEmployee(name, id, averageMonthlySalary/(20.8*8));
            } else if ("fixedPaymentEmployee".equals(employeeType)){
                return new FixedPaymentEmployee(name, id, averageMonthlySalary);
            } else {
                throw new IllegalArgumentException();
            }
        }
    }
}
