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
 * @author Coline Piloquet <coline.piloquet@rte-france.com>
 *         Jean-Baptiste Heyberger <jean-baptiste.heyberger@rte-france.com>
 */public interface TwoWindingsTransformerShortCircuit extends Extension<TwoWindingsTransformer> {

    enum MagneticCircuit {
        FREE_FLUXES,
        FORCED_FLUXES
    };

    enum TransformerConfiguration {
        TWO_WINDING_TRANSFORMER,
        AUTO_TRANSFORMER
    };

    @Override
    default String getName() {
        return "twoWindingsTransformerShortCircuit";
    }

    boolean isPartOfGeneratorUnit();

    TwoWindingsTransformerShortCircuit setPartOfGeneratorUnit(boolean partOfGeneratorUnit);

    MagneticCircuit getMagneticCircuitType();

    TwoWindingsTransformerShortCircuit setMagneticCircuitType(MagneticCircuit magneticCircuitType);

    TransformerConfiguration getTransformerConfigurationType();

    TwoWindingsTransformerShortCircuit setTransformerConfigurationType(TransformerConfiguration transformerConfigurationType);

    WindingTransformerShortCircuit getWinding1();

    TwoWindingsTransformerShortCircuit setWinding1(WindingTransformerShortCircuit w1);

    WindingTransformerShortCircuit getWinding2();

    TwoWindingsTransformerShortCircuit setWinding2(WindingTransformerShortCircuit w2);

}
