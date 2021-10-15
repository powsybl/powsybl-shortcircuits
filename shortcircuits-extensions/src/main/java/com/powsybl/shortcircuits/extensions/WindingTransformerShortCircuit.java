/**
 * Copyright (c) 2021, RTE (http://www.rte-france.com)
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package com.powsybl.shortcircuits.extensions;

/**
 *
 * @author Jean-Baptiste Heyberger <jean-baptiste.heyberger@rte-france.com>
 *
 */
public class WindingTransformerShortCircuit {

    WindingTransformerShortCircuit(ConnectionKind connectionKind) {
        this.connectionKind = connectionKind;
        this.excitingXo = 0.; //TODO : if ZoE not given in imput, put NaN since by default it is infinity
        this.excitingRo = 0.; //TODO : if ZoE not given in imput, put NaN since by default it is infinity
        this.leakageXo = 0.; //if ZoL not given in input, XoL is 0, expecting non-zero value on another winding
        this.leakageRo = 0.;
        this.toGroundR = 0.; //TODO : if Zg not given in imput, put NaN since by default it is infinity
        this.toGroundX = 0.; //TODO : if Zg not given in imput, put NaN since by default it is infinity

    }

    WindingTransformerShortCircuit(ConnectionKind connectionKind, double leakageRo, double leakageXo) {
        this(connectionKind);
        this.leakageRo = leakageRo; //if ZoL not given in imput, XoL is 0, expecting non zero value on another winding
        this.leakageXo = leakageXo;
    }

    WindingTransformerShortCircuit(ConnectionKind connectionKind, double leakageRo, double leakageXo, double excitingRo, double excitingXo) {
        this(connectionKind, leakageRo, leakageXo);
        this.excitingRo = excitingRo;
        this.excitingXo = excitingXo;
    }

    WindingTransformerShortCircuit(ConnectionKind connectionKind, double roL, double xoL, double roE, double xoE, double rg, double xg) {
        this(connectionKind, roL, xoL, roE, xoE);
        this.toGroundR = rg;
        this.toGroundX = xg;
    }

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
    };

    private ConnectionKind connectionKind;

    private double excitingXo; //exciting reactance (ZoE = excitingRo + j * excitingXo)  is the exciting impedance measured on the winding,
    // with all other windings on the same core open-circuited and zero sequence
    // voltage applied to the 3 phases of this winding

    private double excitingRo; //exciting resistance

    private double leakageXo; //leakage impedance of the winding (ZoL = leakageRo + j * leakageXo) (the full leakage impedance of a transfo the leakage impedance of other windings

    private double leakageRo;

    private double toGroundR; // grounding resistance (if any)

    private double toGroundX; // grounding reactance (if any)

}
