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
 * @author Jean-Baptiste Heyberger <jean-baptiste.heyberger@rte-france.com>
 */
public interface TwoWindingsTransformerShortCircuit extends Extension<TwoWindingsTransformer> {

    enum MagneticCircuit {
        // depending on the value of this enum, the excitation parameters of a winding will taken into account or not
        FREE_FLUXES,
        FORCED_FLUXES
    }

    enum TransformerTwoWindingConfiguration {
        // The disposition of the Windings inside a 2 windings transformer will have an influence on how homopolar admittance terms will be computed
        SEPARATE_WINDINGS,
        AUTO_TRANSFORMER
    }

    @Override
    default String getName() {
        return "twoWindingsTransformerShortCircuit";
    }

    boolean isPartOfGeneratorUnit();

    TwoWindingsTransformerShortCircuit setPartOfGeneratorUnit(boolean partOfGeneratorUnit);

    MagneticCircuit getMagneticCircuitType();

    TwoWindingsTransformerShortCircuit setMagneticCircuitType(MagneticCircuit magneticCircuitType);

    TransformerTwoWindingConfiguration getTransformerConfigurationType();

    TwoWindingsTransformerShortCircuit setTransformerConfigurationType(TransformerTwoWindingConfiguration transformerTwoWindingConfigurationType);

    WindingTransformerShortCircuit getWindingLeg1();

    TwoWindingsTransformerShortCircuit setWindingLeg1(WindingTransformerShortCircuit w1);

    WindingTransformerShortCircuit getWindingLeg2();

    TwoWindingsTransformerShortCircuit setWindingLeg2(WindingTransformerShortCircuit w2);
}
