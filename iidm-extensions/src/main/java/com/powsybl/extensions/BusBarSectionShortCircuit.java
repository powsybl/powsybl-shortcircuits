package com.powsybl.extensions;

public class BusBarSectionShortCircuit {
    private double ipMax; // current
    private double ipMin; // current

    public BusBarSectionShortCircuit(double ipMax, double ipMin) {
        this.ipMax = ipMax;
        this.ipMin = ipMin;
    }

    public double getIpMax() {
        return ipMax;
    }

    public void setIpMax(double ipMax) {
        this.ipMax = ipMax;
    }

    public double getIpMin() {
        return ipMin;
    }

    public void setIpMin(double ipMin) {
        this.ipMin = ipMin;
    }
}
