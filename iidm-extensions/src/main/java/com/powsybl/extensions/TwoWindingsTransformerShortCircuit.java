/**
 * Copyright (c) 2021, RTE (http://www.rte-france.com)
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.powsybl.extensions;

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

    public boolean isPartOfGeneratorUnit();

    public void setPartOfGeneratorUnit(boolean partOfGeneratorUnit);

    public double getB0Leg1();

    public void setB0Leg1(double b0Leg1);

    public double getB0Leg2();

    public void setB0Leg2(double b0Leg2);

    public connectionKind getConnectionKindLeg1();

    public void setConnectionKindLeg1(connectionKind connectionKindLeg1);

    public connectionKind getConnectionKindLeg2();

    public void setConnectionKindLeg2(connectionKind connectionKindLeg2);

    public double getG0Leg1();

    public void setG0Leg1(double g0Leg1);

    public double getG0Leg2();

    public void setG0Leg2(double g0Leg2);

    public boolean isGroundedLeg1();

    public void setGroundedLeg1(boolean groundedLeg1);

    public boolean isGroundedLeg2();

    public void setGroundedLeg2(boolean groundedLeg2);

    public double getR0Leg1();

    public void setR0Leg1(double r0Leg1);

    public double getR0Leg2();

    public void setR0Leg2(double r0Leg2);

    public double getX0Leg1();

    public void setX0Leg1(double x0Leg1);

    public double getX0Leg2();

    public void setX0Leg2(double x0Leg2);

    public double getRgroundLeg1();

    public void setRgroundLeg1(double rgroundLeg1);

    public double getRgroundLeg2();

    public void setRgroundLeg2(double rgroundLeg2);

    public double getXgroundLeg1();

    public void setXgroundLeg1(double xgroundLeg1);

    public double getXgroundLeg2();

    public void setXgroundLeg2(double xgroundLeg2);
}
