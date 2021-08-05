/**
 * Copyright (c) 2021, RTE (http://www.rte-france.com)
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.powsybl.extensions;

import com.powsybl.commons.extensions.ExtensionAdder;
import com.powsybl.iidm.network.TwoWindingsTransformer;


/**
 * @author Coline Piloquet <coline.piloquet@rte-france.com>
 */
public interface TwoWindingsTransformerShortCircuitAdder
        extends ExtensionAdder<TwoWindingsTransformer, TwoWindingsTransformerShortCircuit> {

    @Override
    default Class<TwoWindingsTransformerShortCircuit> getExtensionClass() {
        return TwoWindingsTransformerShortCircuit.class;
    }

    public TwoWindingsTransformerShortCircuitAdder withShortCircuitParameters(boolean isPartOfGeneratorUnit, double b0Leg1, double b0Leg2, TwoWindingsTransformerShortCircuit.connectionKind connectionKindLeg1,
                                                                              TwoWindingsTransformerShortCircuit.connectionKind connectionKindLeg2, double g0Leg1,double g0Leg2, boolean groundedLeg1, boolean groundedLeg2,
                                                                              double r0Leg1, double r0Leg2, double x0Leg1, double x0Leg2, double rgroundLeg1, double rgroundLeg2,
                                                                              double xgroundLeg1, double xgroundLeg2);
}
