/**
 * Copyright (c) 2021, RTE (http://www.rte-france.com)
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.powsybl.shortcircuits.extensions;

import com.powsybl.commons.extensions.Extension;
import com.powsybl.iidm.network.Generator;

import java.util.Optional;

/**
 *
 * @author Coline Piloquet <coline.piloquet@rte-france.fr>
 */
public interface GeneratorShortCircuit extends Extension<Generator> {
    @Override
    default String getName() {
        return "generatorShortCircuit";
    }

    /**
     * Get the direct-axis subtransient reactance saturated (also known as Xd''sat)
     */
    double getSatDirectSubtranX();

    /**
     * Set the direct-axis subtransient reactance saturated (also known as Xd''sat)
     */
    GeneratorShortCircuit setSatDirectSubtranX(double satDirectSubtranX);

    /**
     * Get the saturated direct-axis transient reactance
     */
    double getSatDirectTransX();

    /**
     * Set the saturated direct-axis transient reactance
     */
    GeneratorShortCircuit setSatDirectTransX(double satDirectTransX);

    /**
     * Indicates whether the generator is linked to a transformer
     */
    boolean isHasTransformer();

    /**
     * Set whether the generator is linked to a transformer or not
     */
    GeneratorShortCircuit setHasTransformer(boolean hasTransformer);

    /**
     * Get the reactance of the transformer if hasTransformer is True
     */
    Optional<Double> getTransformerReactance();

    /**
     * Set the reactance of the transformer if hasTransformer is True
     */
    GeneratorShortCircuit setTransformerReactance(double transformerReactance);

}
