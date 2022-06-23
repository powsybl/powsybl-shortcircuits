/**
 * Copyright (c) 2021, RTE (http://www.rte-france.com)
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.powsybl.shortcircuits.extensions;

import com.powsybl.commons.extensions.AbstractExtensionAdder;
import com.powsybl.iidm.network.TwoWindingsTransformer;

/**
 * @author Coline Piloquet <coline.piloquet@rte-france.com>
 */
public class TwoWindingsTransformerShortCircuitAdderImpl
        extends AbstractExtensionAdder<TwoWindingsTransformer, TwoWindingsTransformerShortCircuit>
        implements TwoWindingsTransformerShortCircuitAdder {

    private boolean isPartOfGeneratorUnit;

    private double b0Leg1;
    private double b0Leg2;

    private TwoWindingsTransformerShortCircuit.connectionKind connectionKindLeg1;
    private TwoWindingsTransformerShortCircuit.connectionKind connectionKindLeg2;

    private double g0Leg1;
    private double g0Leg2;

    private boolean groundedLeg1;
    private boolean groundedLeg2;

    private double r0Leg1;
    private double r0Leg2;

    private double x0Leg1;
    private double x0Leg2;

    private double rgroundLeg1;
    private double rgroundLeg2;

    private double xgroundLeg1;
    private double xgroundLeg2;

    protected TwoWindingsTransformerShortCircuitAdderImpl (TwoWindingsTransformer extendable) {
        super(extendable);
    }

    @Override
    protected TwoWindingsTransformerShortCircuit createExtension(TwoWindingsTransformer extendable) {
        return new TwoWindingsTransformerShortCircuitImpl (isPartOfGeneratorUnit, b0Leg1, b0Leg2, connectionKindLeg1,
                connectionKindLeg2, g0Leg1, g0Leg2, groundedLeg1, groundedLeg2, r0Leg1, r0Leg2, x0Leg1, x0Leg2, rgroundLeg1, rgroundLeg2, xgroundLeg1,
                xgroundLeg2, extendable);
    }

    @Override
    public TwoWindingsTransformerShortCircuitAdder withShortCircuitParameters(boolean isPartOfGeneratorUnit, double b0Leg1, double b0Leg2, TwoWindingsTransformerShortCircuit.connectionKind connectionKindLeg1,
                                                                              TwoWindingsTransformerShortCircuit.connectionKind connectionKindLeg2, double g0Leg1,double g0Leg2, boolean groundedLeg1, boolean groundedLeg2,
                                                                              double r0Leg1, double r0Leg2, double x0Leg1, double x0Leg2, double rgroundLeg1, double rgroundLeg2,
                                                                              double xgroundLeg1, double xgroundLeg2){
        this.isPartOfGeneratorUnit = isPartOfGeneratorUnit;
        this.b0Leg1 = b0Leg1;
        this.b0Leg2 = b0Leg2;
        this.connectionKindLeg1 = connectionKindLeg1;
        this.connectionKindLeg2 = connectionKindLeg2;
        this.g0Leg1 = g0Leg1;
        this.g0Leg2 = g0Leg2;
        this.groundedLeg1 = groundedLeg1;
        this.groundedLeg2 = groundedLeg2;
        this.r0Leg1 = r0Leg1;
        this.r0Leg2 = r0Leg2;
        this.x0Leg1 = x0Leg1;
        this.x0Leg2 = x0Leg2;
        this.rgroundLeg1 = rgroundLeg1;
        this.rgroundLeg2 = rgroundLeg2;
        this.xgroundLeg1 = xgroundLeg1;
        this.xgroundLeg2 = xgroundLeg2;
        return this;
    }

}