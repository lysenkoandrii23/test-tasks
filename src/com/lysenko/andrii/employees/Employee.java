package com.lysenko.andrii.employees;

public abstract class Employee implements Comparable<Employee>{
    private String name;
    private int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public abstract double averageMonthlySalary();

    public int compareTo(Employee employee) {
        int result =(int) Math.signum(employee.averageMonthlySalary() - averageMonthlySalary());
        if (result == 0) {
            result = name.compareTo(employee.name);
        }
        return result;
    }

    @Override
    public String toString() {
        return id + " " + name + " " + averageMonthlySalary();
    }

//    private void draw(Graphics graphics) {
//        setVisible(false);
//        graphics.
//
//                setVisible(true);
//    }
}
