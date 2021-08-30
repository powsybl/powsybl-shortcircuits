/**
 * Copyright (c) 2021, RTE (http://www.rte-france.com)
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package com.powsybl.shortcircuits.extensions;

import com.powsybl.commons.extensions.AbstractExtension;
import com.powsybl.iidm.network.Generator;

import java.util.Optional;

/**
 *
 * @author Coline Piloquet <coline.piloquet@rte-france.fr>
 */
public class GeneratorShortCircuitImpl extends AbstractExtension<Generator> implements GeneratorShortCircuit {

    private double satDirectSubtranX; // Direct-axis subtransient reactance saturated
    private double satDirectTransX; // Saturated Direct-axis transient reactance
    private boolean hasTransformer; // Indicates whether the generator is linked to a transformer or not
    private double transformerReactance; // Reactance of the transformer if hasTransformer is True

    public GeneratorShortCircuitImpl(double satDirectSubtranX, double satDirectTransX, Generator gen,
                                     boolean hasTransformer, double transformerReactance) {
        super(gen);
        this.satDirectSubtranX = satDirectSubtranX;
        this.satDirectTransX = satDirectTransX;
        this.hasTransformer = hasTransformer;
        this.transformerReactance = transformerReactance;
    }

    @Override
    public double getSatDirectSubtranX() {
        return satDirectSubtranX;
    }

    @Override
    public GeneratorShortCircuit setSatDirectSubtranX(double satDirectSubtranX) {
        this.satDirectSubtranX = satDirectSubtranX;
        return this;
    }

    @Override
    public double getSatDirectTransX() {
        return satDirectTransX;
    }

    @Override
    public GeneratorShortCircuit setSatDirectTransX(double satDirectTransX) {
        this.satDirectTransX = satDirectTransX;
        return this;
    }

    @Override
    public boolean isHasTransformer() {
        return hasTransformer;
    }

    @Override
    public GeneratorShortCircuit setHasTransformer(boolean hasTransformer) {
        this.hasTransformer = hasTransformer;
        return this;
    }

    @Override
    public Optional<Double> getTransformerReactance() {
        return Optional.ofNullable(transformerReactance);
    }

    @Override
    public GeneratorShortCircuit setTransformerReactance(double transformerReactance) {
        this.transformerReactance = transformerReactance;
        return this;
    }
}
