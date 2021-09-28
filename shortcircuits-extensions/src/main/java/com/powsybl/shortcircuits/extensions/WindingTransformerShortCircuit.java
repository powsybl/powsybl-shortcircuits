
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
        this.xoE = 0.; //TODO : if ZoE not given in imput, put NaN since by default it is infinity
        this.roE = 0.; //TODO : if ZoE not given in imput, put NaN since by default it is infinity
        this.xoL = 0.; //if ZoL not given in input, XoL is 0, expecting non-zero value on another winding
        this.roL = 0.;
        this.rg = 0.; //TODO : if Zg not given in imput, put NaN since by default it is infinity
        this.xg = 0.; //TODO : if Zg not given in imput, put NaN since by default it is infinity

    }

    WindingTransformerShortCircuit(ConnectionKind connectionKind, double roL, double xoL) {
        this(connectionKind);
        this.roL = roL; //if ZoL not given in imput, XoL is 0, expecting non zero value on another winding
        this.xoL = xoL;
    }

    WindingTransformerShortCircuit(ConnectionKind connectionKind, double roL, double xoL, double roE, double xoE) {
        this(connectionKind, roL, xoL);
        this.roE = roE; //if ZoL not given in imput, XoL is 0, expecting non zero value on another winding
        this.xoE = xoE;
    }

    WindingTransformerShortCircuit(ConnectionKind connectionKind, double roL, double xoL, double roE, double xoE, double rg, double xg) {
        this(connectionKind, roL, xoL, roE, xoE);
        this.rg = rg; //if ZoL not given in imput, XoL is 0, expecting non zero value on another winding
        this.xg = xg;
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

    private double xoE; //exciting reactance (ZoE is the exciting impedance measured on the winding,
                        // with all other windings on the same core open-circuited and zero sequence
                        // voltage applied to the 3 phases of this winding)

    private double roE; //exciting resistance

    private double xoL; //leakage impedance of the winding (the full leakage impedance of a transfo the leakage impedance of other windings

    private double roL;

    private double rg; // grounding resistance (if any)

    private double xg; // grounding reactance (if any)

}
