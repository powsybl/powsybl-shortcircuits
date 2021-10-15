/**
 * Copyright (c) 2021, RTE (http://www.rte-france.com)
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package com.powsybl.shortcircuits.extensions;

import com.powsybl.commons.extensions.AbstractExtension;
import com.powsybl.iidm.network.TwoWindingsTransformer;

/**
 *
 * @author Coline Piloquet <coline.piloquet@rte-france.com>
 *         Jean-Baptiste Heyberger <jean-baptiste.heyberger@rte-france.com>
 */
public class TwoWindingsTransformerShortCircuitImpl extends AbstractExtension<TwoWindingsTransformer> implements TwoWindingsTransformerShortCircuit {

    private boolean isPartOfGeneratorUnit; // indicates whether the machine is part of a power station unit

    private WindingTransformerShortCircuit windingLeg1;

    private WindingTransformerShortCircuit windingLeg2;

    private MagneticCircuit magneticCircuitType;

    private TransformerTwoWindingConfiguration transformerTwoWindingConfigurationType;

    public TwoWindingsTransformerShortCircuitImpl(TwoWindingsTransformer twt,
                                                  boolean isPartOfGeneratorUnit,
                                                  WindingTransformerShortCircuit windingLeg1,
                                                  WindingTransformerShortCircuit windingLeg2,
                                                  MagneticCircuit magneticCircuitType,
                                                  TransformerTwoWindingConfiguration transformerTwoWindingConfigurationType) {
        super(twt);
        this.isPartOfGeneratorUnit = isPartOfGeneratorUnit;
        this.windingLeg1 = windingLeg1;
        this.windingLeg2 = windingLeg2;
        this.magneticCircuitType = magneticCircuitType;
        this.transformerTwoWindingConfigurationType = transformerTwoWindingConfigurationType;
    }

    @Override
    public boolean isPartOfGeneratorUnit() {
        return isPartOfGeneratorUnit;
    }

    @Override
    public TwoWindingsTransformerShortCircuit setIsPartOfGeneratorUnit(boolean partOfGeneratorUnit) {
        isPartOfGeneratorUnit = partOfGeneratorUnit;
        return this;
    }

    @Override
    public WindingTransformerShortCircuit getWindingLeg1() {
        return windingLeg1;
    }

    @Override
    public TwoWindingsTransformerShortCircuit setWindingLeg1(WindingTransformerShortCircuit w1) {
        windingLeg1 = w1;
        return this;
    }

    @Override
    public WindingTransformerShortCircuit getWindingLeg2() {
        return windingLeg2;
    }

    @Override
    public TwoWindingsTransformerShortCircuit setWindingLeg2(WindingTransformerShortCircuit w2) {
        windingLeg2 = w2;
        return this;
    }

    @Override
    public MagneticCircuit getMagneticCircuitType() {
        return magneticCircuitType;
    }

    @Override
    public TwoWindingsTransformerShortCircuit setMagneticCircuitType(MagneticCircuit magneticCircuitType) {
        this.magneticCircuitType = magneticCircuitType;
        return this;
    }

    @Override
    public TransformerTwoWindingConfiguration getTransformerConfigurationType() {
        return transformerTwoWindingConfigurationType;
    }

    @Override
    public TwoWindingsTransformerShortCircuit setTransformerConfigurationType(TransformerTwoWindingConfiguration transformerConfigurationType) {
        this.transformerTwoWindingConfigurationType = transformerConfigurationType;
        return this;
    }

}
