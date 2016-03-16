package com.lysenko.andrii.employees;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
//        employees.add(new HourlyWageEmployee("Andrii",1,15));
//        employees.add(new FixedPaymentEmployee("Oleksii",1,2000));
//        employees.add(new FixedPaymentEmployee("Aleksander",1,2000));
//        employees.add(new HourlyWageEmployee("Boris",1,20));
//        employees.add(new FixedPaymentEmployee("Boria",1,2000));
//        employees.add(new FixedPaymentEmployee("Clause",1,2000));
//
//        for (Employee employee : employees) {
//            System.out.println(employee);
//        }
//
//        Collections.sort(employees);
//
//        System.out.println("sorted list-----------------------");
//        for (Employee employee : employees) {
//            System.out.println(employee);
//        }
//
//        System.out.println("first 5 employees-----------------------");
//        for (int i = 0; i < Math.min(5,employees.size());i++) {
//            System.out.println(employees.get(i));
//        }
//
//        System.out.println("last 3 employees-----------------------");
//        for (int i = Math.max(0, employees.size() - 3); i < employees.size();i++) {
//            System.out.println(employees.get(i));
//        }
//
//        try {
//            Service.writeToFile(employees, "D:/test.txt");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        System.out.println("from file-----------------------");
        try {
            Service.readFromFile(employees, "D:/test.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}
