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

    private WindingTransformerShortCircuit winding1;

    private WindingTransformerShortCircuit winding2;

    private MagneticCircuit magneticCircuitType;

    private TransformerConfiguration transformerConfigurationType;

    public TwoWindingsTransformerShortCircuitImpl(boolean isPartOfGeneratorUnit, TwoWindingsTransformer twt) {
        super(twt);
        this.isPartOfGeneratorUnit = isPartOfGeneratorUnit;
    }

    public TwoWindingsTransformerShortCircuitImpl(boolean isPartOfGeneratorUnit) {
        this.isPartOfGeneratorUnit = isPartOfGeneratorUnit;
    }

    @Override
    public boolean isPartOfGeneratorUnit() {
        return isPartOfGeneratorUnit;
    }

    @Override
    public TwoWindingsTransformerShortCircuit setPartOfGeneratorUnit(boolean partOfGeneratorUnit) {
        isPartOfGeneratorUnit = partOfGeneratorUnit;
        return this;
    }

    @Override
    public WindingTransformerShortCircuit getWinding1() {
        return winding1;
    }

    @Override
    public TwoWindingsTransformerShortCircuit setWinding1(WindingTransformerShortCircuit w1) {
        winding1 = w1;
        return this;
    }

    @Override
    public WindingTransformerShortCircuit getWinding2() {
        return winding2;
    }

    @Override
    public TwoWindingsTransformerShortCircuit setWinding2(WindingTransformerShortCircuit w2) {
        winding2 = w2;
        return this;
    }

<<<<<<< HEAD
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
    public TransformerConfiguration getTransformerConfigurationType() {
        return transformerConfigurationType;
    }

    @Override
    public TwoWindingsTransformerShortCircuit setTransformerConfigurationType(TransformerConfiguration transformerConfigurationType) {
        this.transformerConfigurationType = transformerConfigurationType;
        return this;
    }

=======
>>>>>>> origin/T2E_extension_JB
}
