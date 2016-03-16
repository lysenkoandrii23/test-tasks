package com.lysenko.andrii.figures;

public abstract class Figure implements Comparable<Figure>{
    public abstract double getMeasure();

    public abstract double getInnerMeasure();

    /*All figures will be compared only by measure.*/
    public int compareTo(Figure figure) {
        return (int) Math.signum(getMeasure() - figure.getMeasure());
    }

    @Override
    public String toString() {
        return getMeasure() + " " + getInnerMeasure();
    }
}
