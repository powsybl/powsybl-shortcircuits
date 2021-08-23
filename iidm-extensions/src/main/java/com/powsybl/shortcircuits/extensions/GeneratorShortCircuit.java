/**
 * Copyright (c) 2021, RTE (http://www.rte-france.com)
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.powsybl.shortcircuits.extensions;

import com.powsybl.commons.extensions.Extension;
import com.powsybl.iidm.network.Generator;

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
     * Get earthing status of the generator
     */
    boolean isEarthing();

    /**
     * Set the
     */
    GeneratorShortCircuit setEarthing(boolean earthing);

    /**
     * Get the zero sequence resistance of the synchronous machine
     */
    double getR0();

    /**
     * Set the zero sequence resistance of the synchronous machine
     */
    GeneratorShortCircuit setR0(double r0);

    /**
     * Get the negative sequence resistance of the synchronous machine
     */
    double getR2();

    /**
     * Set the negative sequence resistance of the synchronous machine
     */
    GeneratorShortCircuit setR2(double r2);

    /**
     * Get the direct-axis subtransient reactance saturated (also known as Xd''sat)
     */
    double getSatDirectSubtranX();

    /**
     * Set the direct-axis subtransient reactance saturated (also known as Xd''sat)
     */
    GeneratorShortCircuit setSatDirectSubtranX(double satDirectSubtranX);

    /**
     * Get the direct-axis saturated synchronous reactance (also known as Xdsat)
     */
    double getSatDirectSyncX();

    /**
     * Set the direct-axis saturated synchronous reactance (also known as Xdsat)
     */
    GeneratorShortCircuit setGetSatDirectSyncX(double getSatDirectSyncX);

    /**
     * Get the saturated direct-axis transient reactance
     */
    double getSatDirectTransX();

    /**
     * Set the saturated direct-axis transient reactance
     */
    GeneratorShortCircuit setSatDirectTransX(double satDirectTransX);

    /**
     * Get the zero sequence reactance of the synchronous machine
     */
    double getX0();

    /**
     * Set the zero sequence reactance of the synchronous machine
     */
    GeneratorShortCircuit setX0(double x0);

    /**
     * Get the negative sequence reactance of the synchronous machine
     */
    double getX2();

    /**
     * Get the negative sequence reactance of the synchronous machine
     */
    GeneratorShortCircuit setX2(double x2);

}
