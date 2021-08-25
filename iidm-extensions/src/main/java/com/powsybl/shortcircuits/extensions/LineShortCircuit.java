/**
 * Copyright (c) 2021, RTE (http://www.rte-france.com)
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.powsybl.shortcircuits.extensions;

import com.powsybl.commons.extensions.Extension;

/**
 *
 * @author Coline Piloquet <coline.piloquet@rte-france.fr>
 */
public interface LineShortCircuit extends Extension<com.powsybl.iidm.network.Line> {
    @Override
    default String getName() {
        return "lineShortCircuit";
    }

    /**
     * Get the zero sequence shunt susceptance, uniformly distributed, of the entire line section
     */
    double getB0ch();

    /**
     * Set the zero sequence shunt susceptance, uniformly distributed, of the entire line section
     */
    LineShortCircuit setB0ch(double b0ch);

    /**
     * Get the zero sequence shunt conductance, uniformly distributed, of the entire line section
     */
    double getG0ch();

    /**
     * Set the zero sequence shunt conductance, uniformly distributed, of the entire line section
     */
    LineShortCircuit setG0ch(double g0ch);

    /**
     * Get the zero-sequence series resistance of the entire line section
     */
    double getR0();

    /**
     * Set the zero-sequence series resistance of the entire line section
     */
    LineShortCircuit setR0(double r0);

    /**
     * Get the zero-sequence series reactance of the entire line section
     */
    double getX0();

    /**
     * Set the zero-sequence series reactance of the entire line section
     */
    LineShortCircuit setX0(double x0);
}