/**
 * Copyright (c) 2021, RTE (http://www.rte-france.com)
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.powsybl.shortcircuits.extensions;

import com.powsybl.commons.extensions.AbstractExtensionAdder;
import com.powsybl.iidm.network.TwoWindingsTransformer;

import java.util.Objects;

/**
 * @author Coline Piloquet <coline.piloquet@rte-france.com>
 *         Jean-Baptiste Heyberger <jean-baptiste.heyberger@rte-france.com>
 */
public class TwoWindingsTransformerShortCircuitAdderImpl
        extends AbstractExtensionAdder<TwoWindingsTransformer, TwoWindingsTransformerShortCircuit>
        implements TwoWindingsTransformerShortCircuitAdder {

    private boolean partOfGeneratorUnit = false;
    private WindingTransformerShortCircuit windingLeg1 = new WindingTransformerShortCircuit(WindingTransformerShortCircuit.ConnectionKind.D);
    private WindingTransformerShortCircuit windingLeg2 = new WindingTransformerShortCircuit(WindingTransformerShortCircuit.ConnectionKind.D);
    private TwoWindingsTransformerShortCircuit.MagneticCircuit magneticCircuitType = TwoWindingsTransformerShortCircuit.MagneticCircuit.FREE_FLUXES;
    private TwoWindingsTransformerShortCircuit.TransformerTwoWindingConfiguration transformerTwoWindingConfigurationType = TwoWindingsTransformerShortCircuit.TransformerTwoWindingConfiguration.SEPARATE_WINDINGS;

    protected TwoWindingsTransformerShortCircuitAdderImpl(TwoWindingsTransformer extendable) {
        super(extendable);
    }

    @Override
    protected TwoWindingsTransformerShortCircuit createExtension(TwoWindingsTransformer extendable) {
        return new TwoWindingsTransformerShortCircuitImpl(extendable, partOfGeneratorUnit, windingLeg1, windingLeg2, magneticCircuitType, transformerTwoWindingConfigurationType);
    }

    @Override
    public TwoWindingsTransformerShortCircuitAdder withPartOfGeneratorUnit(boolean partOfGeneratorUnit) {
        this.partOfGeneratorUnit = partOfGeneratorUnit;
        return this;
    }

    @Override
    public TwoWindingsTransformerShortCircuitAdder withMagneticCircuitType(TwoWindingsTransformerShortCircuit.MagneticCircuit magneticCircuitType) {
        this.magneticCircuitType = Objects.requireNonNull(magneticCircuitType);
        return this;
    }

    @Override
    public TwoWindingsTransformerShortCircuitAdder withTransformerConfigurationType(TwoWindingsTransformerShortCircuit.TransformerTwoWindingConfiguration transformerTwoWindingConfigurationType) {
        this.transformerTwoWindingConfigurationType = Objects.requireNonNull(transformerTwoWindingConfigurationType);
        return this;
    }

    @Override
    public TwoWindingsTransformerShortCircuitAdder withWindingLeg1(WindingTransformerShortCircuit windingLeg1) {
        this.windingLeg1 = Objects.requireNonNull(windingLeg1);
        return this;
    }

    @Override
    public TwoWindingsTransformerShortCircuitAdder withWindingLeg2(WindingTransformerShortCircuit windingLeg2) {
        this.windingLeg2 = Objects.requireNonNull(windingLeg2);
        return this;
    }
}
