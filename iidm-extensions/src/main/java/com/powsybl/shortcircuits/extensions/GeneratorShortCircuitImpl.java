/**
 * Copyright (c) 2021, RTE (http://www.rte-france.com)
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package com.powsybl.shortcircuits.extensions;

import com.powsybl.commons.extensions.AbstractExtension;
import com.powsybl.iidm.network.Generator;

import java.util.OptionalDouble;

/**
 *
 * @author Coline Piloquet <coline.piloquet@rte-france.fr>
 */
public class GeneratorShortCircuitImpl extends AbstractExtension<Generator> implements GeneratorShortCircuit {

    private double directSubtransX; // X''d
    private double directTransX; // X'd
    private Double setUpTransformerX; // Reactance of the step-up transformer

    public GeneratorShortCircuitImpl(Generator generator, double directSubtransX, double directTransX) {
        super(generator);
        this.directSubtransX = directSubtransX;
        this.directTransX = directTransX;
    }

    public GeneratorShortCircuitImpl(Generator generator, double directSubtransX, double directTransX,
                                     Double setUpTransformerX) {
        super(generator);
        this.directSubtransX = directSubtransX;
        this.directTransX = directTransX;
        this.setUpTransformerX = setUpTransformerX;
    }

    @Override
    public double getDirectSubtransX() {
        return directSubtransX;
    }

    @Override
    public GeneratorShortCircuit setDirectSubtransX(double satDirectSubtranX) {
        this.directSubtransX = satDirectSubtranX;
        return this;
    }

    @Override
    public double getDirectTransX() {
        return directTransX;
    }

    @Override
    public GeneratorShortCircuit setDirectTransX(double directTransX) {
        this.directTransX = directTransX;
        return this;
    }

    @Override
    public OptionalDouble getStepUpTransformerX() {
        return setUpTransformerX != null ? OptionalDouble.of(setUpTransformerX) : OptionalDouble.empty();
    }

    @Override
    public GeneratorShortCircuit setSetUpTransformerX(double setUpTransformerX) {
        this.setUpTransformerX = setUpTransformerX;
        return this;
    }
}
