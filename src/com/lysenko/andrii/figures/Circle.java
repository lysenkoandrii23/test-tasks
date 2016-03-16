package com.lysenko.andrii.figures;

public class Circle extends Figure{
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getMeasure() {
        return 2*radius*Math.PI;
    }

    public double getInnerMeasure() {
        return Math.PI*radius*radius;
    }

    @Override
    public String toString() {
        return "circle " + super.toString();
    }
}
