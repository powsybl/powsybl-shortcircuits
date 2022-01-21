/**
 * Copyright (c) 2021, RTE (http://www.rte-france.com)
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package com.powsybl.shortcircuits.extensions;

import com.powsybl.commons.extensions.AbstractExtension;
import com.powsybl.iidm.network.TwoWindingsTransformer;

import java.util.Objects;

/**
 *
 * @author Coline Piloquet <coline.piloquet@rte-france.com>
 * @author Jean-Baptiste Heyberger <jean-baptiste.heyberger@rte-france.com>
 */
public class TwoWindingsTransformerShortCircuitImpl extends AbstractExtension<TwoWindingsTransformer> implements TwoWindingsTransformerShortCircuit {

    private boolean partOfGeneratorUnit; // indicates whether the machine is part of a power station unit

    private WindingTransformerShortCircuit windingLeg1;

    private WindingTransformerShortCircuit windingLeg2;

    private MagneticCircuit magneticCircuitType;

    private TransformerTwoWindingConfiguration transformerTwoWindingConfigurationType;

    public TwoWindingsTransformerShortCircuitImpl(TwoWindingsTransformer twt,
                                                  boolean partOfGeneratorUnit,
                                                  WindingTransformerShortCircuit windingLeg1,
                                                  WindingTransformerShortCircuit windingLeg2,
                                                  MagneticCircuit magneticCircuitType,
                                                  TransformerTwoWindingConfiguration transformerTwoWindingConfigurationType) {
        super(twt);
        this.partOfGeneratorUnit = partOfGeneratorUnit;
        this.windingLeg1 = Objects.requireNonNull(windingLeg1);
        this.windingLeg2 = Objects.requireNonNull(windingLeg2);
        this.magneticCircuitType = Objects.requireNonNull(magneticCircuitType);
        this.transformerTwoWindingConfigurationType = Objects.requireNonNull(transformerTwoWindingConfigurationType);
    }

    @Override
    public boolean isPartOfGeneratorUnit() {
        return partOfGeneratorUnit;
    }

    @Override
    public TwoWindingsTransformerShortCircuit setPartOfGeneratorUnit(boolean partOfGeneratorUnit) {
        this.partOfGeneratorUnit = partOfGeneratorUnit;
        return this;
    }

    @Override
    public WindingTransformerShortCircuit getWindingLeg1() {
        return windingLeg1;
    }

    @Override
    public TwoWindingsTransformerShortCircuit setWindingLeg1(WindingTransformerShortCircuit windingLeg1) {
        this.windingLeg1 = Objects.requireNonNull(windingLeg1);
        return this;
    }

    @Override
    public WindingTransformerShortCircuit getWindingLeg2() {
        return windingLeg2;
    }

    @Override
    public TwoWindingsTransformerShortCircuit setWindingLeg2(WindingTransformerShortCircuit windingLeg2) {
        this.windingLeg2 = Objects.requireNonNull(windingLeg2);
        return this;
    }

    @Override
    public MagneticCircuit getMagneticCircuitType() {
        return magneticCircuitType;
    }

    @Override
    public TwoWindingsTransformerShortCircuit setMagneticCircuitType(MagneticCircuit magneticCircuitType) {
        this.magneticCircuitType = Objects.requireNonNull(magneticCircuitType);
        return this;
    }

    @Override
    public TransformerTwoWindingConfiguration getTransformerConfigurationType() {
        return transformerTwoWindingConfigurationType;
    }

    @Override
    public TwoWindingsTransformerShortCircuit setTransformerConfigurationType(TransformerTwoWindingConfiguration transformerTwoWindingConfigurationType) {
        this.transformerTwoWindingConfigurationType = Objects.requireNonNull(transformerTwoWindingConfigurationType);
        return this;
    }

}
