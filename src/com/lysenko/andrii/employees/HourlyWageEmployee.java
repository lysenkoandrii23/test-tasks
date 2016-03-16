package com.lysenko.andrii.employees;

public class HourlyWageEmployee extends Employee {

    private double hourlyRate;

    public HourlyWageEmployee(String name, int id, double hourlyRate) {
        super(name, id);
        this.hourlyRate = hourlyRate;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double averageMonthlySalary() {
        return 20.8*8*hourlyRate;
    }

    @Override
    public String toString() {
        return "hourlyWageEmployee " + super.toString();
    }
}
