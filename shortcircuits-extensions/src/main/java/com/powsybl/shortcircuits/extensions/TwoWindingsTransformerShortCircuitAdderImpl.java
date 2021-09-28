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
 *         Jean-Baptiste Heyberger <jean-baptiste.heyberger@rte-france.com>
 */
public class TwoWindingsTransformerShortCircuitAdderImpl
        extends AbstractExtensionAdder<TwoWindingsTransformer, TwoWindingsTransformerShortCircuit>
        implements TwoWindingsTransformerShortCircuitAdder {

    private boolean isPartOfGeneratorUnit;

    protected TwoWindingsTransformerShortCircuitAdderImpl(TwoWindingsTransformer extendable) {
        super(extendable);
    }

    @Override
    protected TwoWindingsTransformerShortCircuit createExtension(TwoWindingsTransformer extendable) {
        return new TwoWindingsTransformerShortCircuitImpl(isPartOfGeneratorUnit, extendable);
    }

    @Override
    public TwoWindingsTransformerShortCircuitAdder withShortCircuitParameters(boolean isPartOfGeneratorUnit) {
        this.isPartOfGeneratorUnit = isPartOfGeneratorUnit;

        return this;
    }
}
