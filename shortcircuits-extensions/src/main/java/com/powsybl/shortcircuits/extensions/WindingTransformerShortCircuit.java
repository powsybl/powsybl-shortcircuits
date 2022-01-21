/**
 * Copyright (c) 2021, RTE (http://www.rte-france.com)
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package com.powsybl.shortcircuits.extensions;

import java.util.Objects;

/**
 *
 * @author Jean-Baptiste Heyberger <jean-baptiste.heyberger@rte-france.com>
 */
public class WindingTransformerShortCircuit {

    //  Monophased Schematic view of a Leg model:
    //
    //    rhoLeg : 1
    // +---+---()()----[ZoL]----~
    //     |                    ~
    //     |                    ~
    //    ZoE                   ~
    //     |                    ~
    // +---+---------+----------~
    //               |
    //              Zg
    //               |
    //             /////

    public enum ConnectionKind {
        D, // delta
        Y, // Wye
        Z, // Zigzag
        Yn, // Wye with neutral brought out for grounding
        Zn // Zigzag with neutral brought out for grounding
    }

    private final ConnectionKind connectionKind;

    private final double excitingRo; //exciting resistance

    private final double excitingXo; //exciting reactance (ZoE = excitingRo + j * excitingXo)  is the exciting impedance measured on the winding,
    // with all other windings on the same core open-circuited and zero sequence
    // voltage applied to the 3 phases of this winding

    private final double leakageRo;

    private final double leakageXo; //leakage impedance of the winding (ZoL = leakageRo + j * leakageXo) (the full leakage impedance of a transfo the leakage impedance of other windings

    private final double toGroundR; // grounding resistance (if any)

    private final double toGroundX; // grounding reactance (if any)

    public WindingTransformerShortCircuit(ConnectionKind connectionKind, double excitingRo, double excitingXo, double leakageRo, double leakageXo, double toGroundR, double toGroundX) {
        this.connectionKind = Objects.requireNonNull(connectionKind);
        this.excitingRo = excitingRo;
        this.excitingXo = excitingXo;
        this.leakageRo = leakageRo;
        this.leakageXo = leakageXo;
        this.toGroundR = toGroundR;
        this.toGroundX = toGroundX;
    }

    WindingTransformerShortCircuit(ConnectionKind connectionKind) {
        this(connectionKind,
                0, //TODO : if ZoE not given in imput, put NaN since by default it is infinity
                0, //TODO : if ZoE not given in imput, put NaN since by default it is infinity
                0, //if ZoL not given in input, XoL is 0, expecting non-zero value on another winding
                0,
                0, //TODO : if Zg not given in imput, put NaN since by default it is infinity
                0); //TODO : if Zg not given in imput, put NaN since by default it is infinity
    }

    public ConnectionKind getConnectionKind() {
        return connectionKind;
    }

    public double getExcitingRo() {
        return excitingRo;
    }

    public double getExcitingXo() {
        return excitingXo;
    }

    public double getLeakageRo() {
        return leakageRo;
    }

    public double getLeakageXo() {
        return leakageXo;
    }

    public double getToGroundR() {
        return toGroundR;
    }

    public double getToGroundX() {
        return toGroundX;
    }
}
