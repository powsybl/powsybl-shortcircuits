package com.powsybl.extensions;

public class GeneratorShortCircuit {
    private boolean earthing; // earthed or not
    private double r0; // resistance
    private double r2; // resistance
    private double satDirectSubtranX; // reactance
    private double getSatDirectSyncX; // reactance
    private double satDirectTransX; // reactance
    private double x0; // reactance
    private double x2; // reactance

    public GeneratorShortCircuit(boolean earthing, double r0, double r2, double satDirectSubtranX, double getSatDirectSyncX, double satDirectTransX, double x0, double x2) {
        this.earthing = earthing;
        this.r0 = r0;
        this.r2 = r2;
        this.satDirectSubtranX = satDirectSubtranX;
        this.getSatDirectSyncX = getSatDirectSyncX;
        this.satDirectTransX = satDirectTransX;
        this.x0 = x0;
        this.x2 = x2;
    }

    public boolean isEarthing() {
        return earthing;
    }

    public void setEarthing(boolean earthing) {
        this.earthing = earthing;
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

    public double getSatDirectSubtranX() {
        return satDirectSubtranX;
    }

    public void setSatDirectSubtranX(double satDirectSubtranX) {
        this.satDirectSubtranX = satDirectSubtranX;
    }

    public double getGetSatDirectSyncX() {
        return getSatDirectSyncX;
    }

    public void setGetSatDirectSyncX(double getSatDirectSyncX) {
        this.getSatDirectSyncX = getSatDirectSyncX;
    }

    public double getSatDirectTransX() {
        return satDirectTransX;
    }

    public void setSatDirectTransX(double satDirectTransX) {
        this.satDirectTransX = satDirectTransX;
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
