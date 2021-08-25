/**
 * Copyright (c) 2021, RTE (http://www.rte-france.com)
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package com.powsybl.shortcircuits.extensions;

import com.powsybl.commons.extensions.AbstractExtension;
import com.powsybl.iidm.network.Injection;

/**
 *
 * @author Coline Piloquet <coline.piloquet@rte-france.fr>
 */
public class InjectionShortCircuitImpl extends AbstractExtension<Injection> implements InjectionShortCircuit {
    private double r0; //resistance
    private double r2; //resistance
    private double x0; //reactance
    private double x2; //reactance

    public InjectionShortCircuitImpl(double r0, double r2, double x0, double x2) {
        this.r0 = r0;
        this.r2 = r2;
        this.x0 = x0;
        this.x2 = x2;
    }

    @Override
    public double getR0() {
        return r0;
    }

    @Override
    public InjectionShortCircuit setR0(double r0) {
        this.r0 = r0;
        return this;
    }

    @Override
    public double getR2() {
        return r2;
    }

    @Override
    public InjectionShortCircuit setR2(double r2) {
        this.r2 = r2;
        return this;
    }

    @Override
    public double getX0() {
        return x0;
    }

    @Override
    public InjectionShortCircuit setX0(double x0) {
        this.x0 = x0;
        return this;
    }

    @Override
    public double getX2() {
        return x2;
    }

    @Override
    public InjectionShortCircuit setX2(double x2) {
        this.x2 = x2;
        return this;
    }
}