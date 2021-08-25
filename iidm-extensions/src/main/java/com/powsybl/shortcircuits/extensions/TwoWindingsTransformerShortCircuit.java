/**
 * Copyright (c) 2021, RTE (http://www.rte-france.com)
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.powsybl.shortcircuits.extensions;

import com.powsybl.commons.extensions.Extension;
import com.powsybl.iidm.network.TwoWindingsTransformer;

/**
 *
 * @author Coline Piloquet <coline.piloquet@rte-france.fr>
 */
public interface TwoWindingsTransformerShortCircuit extends Extension<TwoWindingsTransformer> {
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

    TwoWindingsTransformerShortCircuit setPartOfGeneratorUnit(boolean partOfGeneratorUnit);

    double getB0Leg1();

    TwoWindingsTransformerShortCircuit setB0Leg1(double b0Leg1);

    double getB0Leg2();

    TwoWindingsTransformerShortCircuit setB0Leg2(double b0Leg2);

    connectionKind getConnectionKindLeg1();

    TwoWindingsTransformerShortCircuit setConnectionKindLeg1(connectionKind connectionKindLeg1);

    connectionKind getConnectionKindLeg2();

    TwoWindingsTransformerShortCircuit setConnectionKindLeg2(connectionKind connectionKindLeg2);

    double getG0Leg1();

    TwoWindingsTransformerShortCircuit setG0Leg1(double g0Leg1);

    double getG0Leg2();

    TwoWindingsTransformerShortCircuit setG0Leg2(double g0Leg2);

    boolean isGroundedLeg1();

    TwoWindingsTransformerShortCircuit setGroundedLeg1(boolean groundedLeg1);

    boolean isGroundedLeg2();

    TwoWindingsTransformerShortCircuit setGroundedLeg2(boolean groundedLeg2);

    double getR0Leg1();

    TwoWindingsTransformerShortCircuit setR0Leg1(double r0Leg1);

    double getR0Leg2();

    TwoWindingsTransformerShortCircuit setR0Leg2(double r0Leg2);

    double getX0Leg1();

    TwoWindingsTransformerShortCircuit setX0Leg1(double x0Leg1);

    double getX0Leg2();

    TwoWindingsTransformerShortCircuit setX0Leg2(double x0Leg2);

    double getRgroundLeg1();

    TwoWindingsTransformerShortCircuit setRgroundLeg1(double rgroundLeg1);

    double getRgroundLeg2();

    TwoWindingsTransformerShortCircuit setRgroundLeg2(double rgroundLeg2);

    double getXgroundLeg1();

    TwoWindingsTransformerShortCircuit setXgroundLeg1(double xgroundLeg1);

    double getXgroundLeg2();

    TwoWindingsTransformerShortCircuit setXgroundLeg2(double xgroundLeg2);
}