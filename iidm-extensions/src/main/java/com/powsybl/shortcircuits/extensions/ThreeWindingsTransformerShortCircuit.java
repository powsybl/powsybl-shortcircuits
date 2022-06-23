/**
 * Copyright (c) 2021, RTE (http://www.rte-france.com)
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.powsybl.shortcircuits.extensions;

import com.powsybl.commons.extensions.Extension;
import com.powsybl.iidm.network.ThreeWindingsTransformer;

/**
 *
 * @author Coline Piloquet <coline.piloquet@rte-france.fr>
 */
public interface ThreeWindingsTransformerShortCircuit extends Extension<ThreeWindingsTransformer> {
    enum connectionKind {
        D, // delta
        Y, // Wye
        Z, // Zigzag
        Yn, // Wye with neutral brought out for grounding
        Zn, // Zigzag with neutral brought out for grounding
        A, // autotransformer common winding
        I // independent winding
    };

    @Override
    default String getName() {
        return "twoWindingsTransformerShortCircuit";
    }

    boolean isPartOfGeneratorUnit();

    ThreeWindingsTransformerShortCircuit setPartOfGeneratorUnit(boolean partOfGeneratorUnit);

    double getB0Leg1();

    ThreeWindingsTransformerShortCircuit setB0Leg1(double b0Leg1);

    double getB0Leg2();

    ThreeWindingsTransformerShortCircuit setB0Leg2(double b0Leg2);

    double getB0Leg3();

    ThreeWindingsTransformerShortCircuit setB0Leg3(double b0Leg3);

    connectionKind getConnectionKindLeg1();

    ThreeWindingsTransformerShortCircuit setConnectionKindLeg1(connectionKind connectionKindLeg1);

    connectionKind getConnectionKindLeg2();

    ThreeWindingsTransformerShortCircuit setConnectionKindLeg2(connectionKind connectionKindLeg2);

    connectionKind getConnectionKindLeg3();

    ThreeWindingsTransformerShortCircuit setConnectionKindLeg3(connectionKind connectionKindLeg3);

    double getG0Leg1();

    ThreeWindingsTransformerShortCircuit setG0Leg1(double g0Leg1);

    double getG0Leg2();

    ThreeWindingsTransformerShortCircuit setG0Leg2(double g0Leg2);

    double getG0Leg3();

    ThreeWindingsTransformerShortCircuit setG0Leg3(double g0Leg3);

    boolean isGroundedLeg1();

    ThreeWindingsTransformerShortCircuit setGroundedLeg1(boolean groundedLeg1);

    boolean isGroundedLeg2();

    ThreeWindingsTransformerShortCircuit setGroundedLeg2(boolean groundedLeg2);

    boolean isGroundedLeg3();

    ThreeWindingsTransformerShortCircuit setGroundedLeg3(boolean groundedLeg3);

    double getR0Leg1();

    ThreeWindingsTransformerShortCircuit setR0Leg1(double r0Leg1);

    double getR0Leg2();

    ThreeWindingsTransformerShortCircuit setR0Leg2(double r0Leg2);

    double getR0Leg3();

    ThreeWindingsTransformerShortCircuit setR0Leg3(double r0Leg3);

    double getX0Leg1();

    ThreeWindingsTransformerShortCircuit setX0Leg1(double x0Leg1);

    double getX0Leg2();

    ThreeWindingsTransformerShortCircuit setX0Leg2(double x0Leg2);

    double getX0Leg3();

    ThreeWindingsTransformerShortCircuit setX0Leg3(double x0Leg3);

    double getRgroundLeg1();

    ThreeWindingsTransformerShortCircuit setRgroundLeg1(double rgroundLeg1);

    double getRgroundLeg2();

    ThreeWindingsTransformerShortCircuit setRgroundLeg2(double rgroundLeg2);

    double getRgroundLeg3();

    ThreeWindingsTransformerShortCircuit setRgroundLeg3(double rgroundLeg3);

    double getXgroundLeg1();

    ThreeWindingsTransformerShortCircuit setXgroundLeg1(double xgroundLeg1);

    double getXgroundLeg2();

    ThreeWindingsTransformerShortCircuit setXgroundLeg2(double xgroundLeg2);

    double getXgroundLeg3();

    ThreeWindingsTransformerShortCircuit setXgroundLeg3(double xgroundLeg3);
}