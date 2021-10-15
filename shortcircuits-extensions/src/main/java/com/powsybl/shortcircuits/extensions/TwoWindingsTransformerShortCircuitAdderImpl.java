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

    boolean isPartOfGeneratorUnit = false;
    WindingTransformerShortCircuit windingLeg1 = new WindingTransformerShortCircuit(WindingTransformerShortCircuit.ConnectionKind.D, 0., 0.);
    WindingTransformerShortCircuit windingLeg2 = new WindingTransformerShortCircuit(WindingTransformerShortCircuit.ConnectionKind.D, 0., 0.);
    TwoWindingsTransformerShortCircuit.MagneticCircuit magneticCircuitType = TwoWindingsTransformerShortCircuit.MagneticCircuit.FREE_FLUXES;
    TwoWindingsTransformerShortCircuit.TransformerTwoWindingConfiguration transformerTwoWindingConfigurationType = TwoWindingsTransformerShortCircuit.TransformerTwoWindingConfiguration.SEPARATE_WINDINGS;

    protected TwoWindingsTransformerShortCircuitAdderImpl(TwoWindingsTransformer extendable) {
        super(extendable);
    }

    @Override
    protected TwoWindingsTransformerShortCircuit createExtension(TwoWindingsTransformer extendable) {
        return new TwoWindingsTransformerShortCircuitImpl(extendable, isPartOfGeneratorUnit, windingLeg1, windingLeg2, magneticCircuitType, transformerTwoWindingConfigurationType);
    }

    @Override
    public TwoWindingsTransformerShortCircuitAdder withIsPartOfGeneratorUnit(boolean isPartOfGeneratorUnit) {
        this.isPartOfGeneratorUnit = isPartOfGeneratorUnit;

        return this;
    }

    @Override
    public TwoWindingsTransformerShortCircuitAdder withMagneticCircuitType(TwoWindingsTransformerShortCircuit.MagneticCircuit magneticCircuitType) {
        this.magneticCircuitType = magneticCircuitType;
        return this;
    }

    @Override
    public TwoWindingsTransformerShortCircuitAdder withTransformerConfigurationType(TwoWindingsTransformerShortCircuit.TransformerTwoWindingConfiguration transformerTwoWindingConfigurationType) {
        this.transformerTwoWindingConfigurationType = transformerTwoWindingConfigurationType;
        return this;
    }

    @Override
    public TwoWindingsTransformerShortCircuitAdder withWindingLeg1(WindingTransformerShortCircuit w1) {
        this.windingLeg1 = w1;
        return this;
    }

    @Override
    public TwoWindingsTransformerShortCircuitAdder withWindingLeg2(WindingTransformerShortCircuit w2) {
        this.windingLeg2 = w2;
        return this;
    }

}
