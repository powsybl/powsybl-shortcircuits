package com.powsybl.extensions;

public class LineShortCircuit {
    private double b0ch; // susceptance
    private double d0ch; // conductance
    private double r0; // resistance
    private double x0; // reactance

    LineShortCircuit(double b0ch, double d0ch, double r0, double x0){
        this.b0ch = b0ch;
        this.d0ch = d0ch;
        this.r0 = r0;
        this.x0 = x0;
    }

    public double getB0ch() {
        return b0ch;
    }

    public void setB0ch(double b0ch) {
        this.b0ch = b0ch;
    }

    public double getD0ch() {
        return d0ch;
    }

    public void setD0ch(double d0ch) {
        this.d0ch = d0ch;
    }

    public double getR0() {
        return r0;
    }

    public void setR0(double r0) {
        this.r0 = r0;
    }

    public double getX0() {
        return x0;
    }

    public void setX0(double x0) {
        this.x0 = x0;
    }
}
