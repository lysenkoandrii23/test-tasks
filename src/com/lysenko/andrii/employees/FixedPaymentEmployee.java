package com.lysenko.andrii.employees;

public class FixedPaymentEmployee extends Employee {
    private double fixedMonthlyPayment;

    public FixedPaymentEmployee(String name, int id, double fixedMonthlyPayment) {
        super(name, id);
        this.fixedMonthlyPayment = fixedMonthlyPayment;
    }

    public double getFixedMonthlyPayment() {
        return fixedMonthlyPayment;
    }

    public void setFixedMonthlyPayment(double fixedMonthlyPayment) {
        this.fixedMonthlyPayment = fixedMonthlyPayment;
    }

    @Override
    public double averageMonthlySalary() {
        return fixedMonthlyPayment;
    }

    @Override
    public String toString() {
        return "fixedPaymentEmployee " + super.toString();
    }
}
