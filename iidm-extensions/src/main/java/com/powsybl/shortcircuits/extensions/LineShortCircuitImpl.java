/**
 * Copyright (c) 2021, RTE (http://www.rte-france.com)
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.powsybl.shortcircuits.extensions;

import com.powsybl.commons.extensions.AbstractExtension;
import com.powsybl.iidm.network.Line;

/**
 *
 * @author Coline Piloquet <coline.piloquet@rte-france.fr>
 */
public class LineShortCircuitImpl extends AbstractExtension<Line> implements LineShortCircuit {
    private double b0ch; // zero sequence shunt susceptance, uniformly distributed, of the entire line section
    private double g0ch; // zero sequence shunt conductance, uniformly distributed, of the entire line section
    private double r0; // zero sequence series resistance of the entire line section
    private double x0; // zero sequence series reactance of the entire line section

    LineShortCircuitImpl(double b0ch, double g0ch, double r0, double x0){
        this.b0ch = b0ch;
        this.g0ch = g0ch;
        this.r0 = r0;
        this.x0 = x0;
    }

    @Override
    public double getB0ch() {
        return b0ch;
    }

    @Override
    public LineShortCircuit setB0ch(double b0ch) {
        this.b0ch = b0ch;
        return this;
    }

    @Override
    public double getG0ch() {
        return g0ch;
    }

    @Override
    public LineShortCircuit setG0ch(double g0ch) {
        this.g0ch = g0ch;
        return this;
    }

    @Override
    public double getR0() {
        return r0;
    }

    @Override
    public LineShortCircuit setR0(double r0) {
        this.r0 = r0;
        return this;
    }

    @Override
    public double getX0() {
        return x0;
    }

    @Override
    public LineShortCircuit setX0(double x0) {
        this.x0 = x0;
        return this;
    }
}