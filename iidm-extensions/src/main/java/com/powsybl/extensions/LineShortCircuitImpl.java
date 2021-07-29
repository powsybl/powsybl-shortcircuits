/**
 * Copyright (c) 2021, RTE (http://www.rte-france.com)
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.powsybl.extensions;

import com.powsybl.commons.extensions.AbstractExtension;
import com.powsybl.iidm.network.Line;

/**
 *
 * @author Coline Piloquet <coline.piloquet@rte-france.fr>
 */
public class LineShortCircuitImpl extends AbstractExtension<Line> implements LineShortCircuit {
    private double b0ch; // susceptance
    private double d0ch; // conductance
    private double r0; // resistance
    private double x0; // reactance

    LineShortCircuitImpl(double b0ch, double d0ch, double r0, double x0){
        this.b0ch = b0ch;
        this.d0ch = d0ch;
        this.r0 = r0;
        this.x0 = x0;
    }

    @Override
    public double getB0ch() {
        return b0ch;
    }

    @Override
    public void setB0ch(double b0ch) {
        this.b0ch = b0ch;
    }

    @Override
    public double getD0ch() {
        return d0ch;
    }

    @Override
    public void setD0ch(double d0ch) {
        this.d0ch = d0ch;
    }

    @Override
    public double getR0() {
        return r0;
    }

    @Override
    public void setR0(double r0) {
        this.r0 = r0;
    }

    @Override
    public double getX0() {
        return x0;
    }

    @Override
    public void setX0(double x0) {
        this.x0 = x0;
    }
}
