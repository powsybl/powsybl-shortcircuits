/**
 * Copyright (c) 2021, RTE (http://www.rte-france.com)
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package com.powsybl.extensions;

import com.powsybl.commons.extensions.AbstractExtension;
import com.powsybl.iidm.network.Generator;

/**
 *
 * @author Coline Piloquet <coline.piloquet@rte-france.fr>
 */
public class GeneratorShortCircuitImpl extends AbstractExtension<Generator> implements GeneratorShortCircuit {
    private boolean earthing; // earthed or not
    private double r0; // resistance
    private double r2; // resistance
    private double satDirectSubtranX; // reactance
    private double getSatDirectSyncX; // reactance
    private double satDirectTransX; // reactance
    private double x0; // reactance
    private double x2; // reactance

    public GeneratorShortCircuitImpl(boolean earthing, double r0, double r2, double satDirectSubtranX, double getSatDirectSyncX, double satDirectTransX, double x0, double x2) {
        this.earthing = earthing;
        this.r0 = r0;
        this.r2 = r2;
        this.satDirectSubtranX = satDirectSubtranX;
        this.getSatDirectSyncX = getSatDirectSyncX;
        this.satDirectTransX = satDirectTransX;
        this.x0 = x0;
        this.x2 = x2;
    }

    @Override
    public boolean isEarthing() {
        return earthing;
    }

    @Override
    public void setEarthing(boolean earthing) {
        this.earthing = earthing;
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
    public double getR2() {
        return r2;
    }

    @Override
    public void setR2(double r2) {
        this.r2 = r2;
    }

    @Override
    public double getSatDirectSubtranX() {
        return satDirectSubtranX;
    }

    @Override
    public void setSatDirectSubtranX(double satDirectSubtranX) {
        this.satDirectSubtranX = satDirectSubtranX;
    }

    @Override
    public double getGetSatDirectSyncX() {
        return getSatDirectSyncX;
    }

    @Override
    public void setGetSatDirectSyncX(double getSatDirectSyncX) {
        this.getSatDirectSyncX = getSatDirectSyncX;
    }

    @Override
    public double getSatDirectTransX() {
        return satDirectTransX;
    }

    @Override
    public void setSatDirectTransX(double satDirectTransX) {
        this.satDirectTransX = satDirectTransX;
    }

    @Override
    public double getX0() {
        return x0;
    }

    @Override
    public void setX0(double x0) {
        this.x0 = x0;
    }

    @Override
    public double getX2() {
        return x2;
    }

    @Override
    public void setX2(double x2) {
        this.x2 = x2;
    }

}
