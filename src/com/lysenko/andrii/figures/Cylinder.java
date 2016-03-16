package com.lysenko.andrii.figures;

/*Creation not only Cylinder but a lot of other figures with different bottom shapes*/
public class Cylinder extends Figure{
    private double height;
    private Circle base;

    public Cylinder(double height, Circle base) {
        this.height = height;
        this.base = base;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public Circle getBase() {
        return base;
    }

    public void setBase(Circle base) {
        this.base = base;
    }

    public double getMeasure() {
        return base.getMeasure()*height;
    }

    public double getInnerMeasure() {
        return base.getInnerMeasure()*height;
    }

    @Override
    public String toString() {
        return "cylinder " + super.toString();
    }
}
