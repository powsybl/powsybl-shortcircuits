package com.powsybl.extensions;

public class InjectionShortCircuit {
    private double r0; //resistance
    private double r2; //resistance
    private double x0; //reactance
    private double x2; //reactance

    public InjectionShortCircuit(double r0, double r2, double x0, double x2) {
        this.r0 = r0;
        this.r2 = r2;
        this.x0 = x0;
        this.x2 = x2;
    }

    public double getR0() {
        return r0;
    }

    public void setR0(double r0) {
        this.r0 = r0;
    }

    public double getR2() {
        return r2;
    }

    public void setR2(double r2) {
        this.r2 = r2;
    }

    public double getX0() {
        return x0;
    }

    public void setX0(double x0) {
        this.x0 = x0;
    }

    public double getX2() {
        return x2;
    }

    public void setX2(double x2) {
        this.x2 = x2;
    }
}
