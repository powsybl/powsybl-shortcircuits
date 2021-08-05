/**
 * Copyright (c) 2021, RTE (http://www.rte-france.com)
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package com.powsybl.extensions;

import com.powsybl.commons.extensions.AbstractExtension;
import com.powsybl.iidm.network.TwoWindingsTransformer;

/**
 *
 * @author Coline Piloquet <coline.piloquet@rte-france.fr>
 */
public class TwoWindingsTransformerShortCircuitImpl extends AbstractExtension<TwoWindingsTransformer> implements TwoWindingsTransformerShortCircuit {

    boolean isPartOfGeneratorUnit; // indicates whether the machine is part of a power station unit

    double b0Leg1; // susceptance of the first leg
    double b0Leg2; // susceptance of the second leg

    connectionKind connectionKindLeg1; // Type of connection of the first leg
    connectionKind connectionKindLeg2; // Type of connection of the second leg

    double g0Leg1; // conductance of the first leg
    double g0Leg2; // conductance of the second leg

    boolean groundedLeg1;
    boolean groundedLeg2;

    double r0Leg1; // resistance of the first leg
    double r0Leg2; // resistance of the second leg

    double x0Leg1; // reactance of the first leg
    double x0Leg2; // reactance of the second leg

    double rgroundLeg1; // resistance of the first leg
    double rgroundLeg2; // resistance of the second leg

    double xgroundLeg1; // reactance of the first leg
    double xgroundLeg2; // reactance of the second leg

    public TwoWindingsTransformerShortCircuitImpl(boolean isPartOfGeneratorUnit, double b0Leg1, double b0Leg2, connectionKind connectionKindLeg1,
                                                  connectionKind connectionKindLeg2, double g0Leg1, double g0Leg2, boolean groundedLeg1, boolean groundedLeg2,
                                                  double r0Leg1, double r0Leg2, double x0Leg1, double x0Leg2, double rgroundLeg1, double rgroundLeg2,
                                                  double xgroundLeg1, double xgroundLeg2, TwoWindingsTransformer twt) {
        super(twt);
        this.isPartOfGeneratorUnit = isPartOfGeneratorUnit;
        this.b0Leg1 = b0Leg1;
        this.b0Leg2 = b0Leg2;
        this.connectionKindLeg1 = connectionKindLeg1;
        this.connectionKindLeg2 = connectionKindLeg2;
        this.g0Leg1 = g0Leg1;
        this.g0Leg2 = g0Leg2;
        this.groundedLeg1 = groundedLeg1;
        this.groundedLeg2 = groundedLeg2;
        this.r0Leg1 = r0Leg1;
        this.r0Leg2 = r0Leg2;
        this.x0Leg1 = x0Leg1;
        this.x0Leg2 = x0Leg2;
        this.rgroundLeg1 = rgroundLeg1;
        this.rgroundLeg2 = rgroundLeg2;
        this.xgroundLeg1 = xgroundLeg1;
        this.xgroundLeg2 = xgroundLeg2;
    }

    public TwoWindingsTransformerShortCircuitImpl(boolean isPartOfGeneratorUnit, double b0Leg1, double b0Leg2, connectionKind connectionKindLeg1,
                                                  connectionKind connectionKindLeg2, double g0Leg1, double g0Leg2, boolean groundedLeg1, boolean groundedLeg2,
                                                  double r0Leg1, double r0Leg2, double x0Leg1, double x0Leg2) {
        this.isPartOfGeneratorUnit = isPartOfGeneratorUnit;
        this.b0Leg1 = b0Leg1;
        this.b0Leg2 = b0Leg2;
        this.connectionKindLeg1 = connectionKindLeg1;
        this.connectionKindLeg2 = connectionKindLeg2;
        this.g0Leg1 = g0Leg1;
        this.g0Leg2 = g0Leg2;
        this.groundedLeg1 = groundedLeg1;
        this.groundedLeg2 = groundedLeg2;
        this.r0Leg1 = r0Leg1;
        this.r0Leg2 = r0Leg2;
        this.x0Leg1 = x0Leg1;
        this.x0Leg2 = x0Leg2;
    }

    @Override
    public boolean isPartOfGeneratorUnit() {
        return isPartOfGeneratorUnit;
    }

    @Override
    public void setPartOfGeneratorUnit(boolean partOfGeneratorUnit) {
        isPartOfGeneratorUnit = partOfGeneratorUnit;
    }

    @Override
    public double getB0Leg1() {
        return b0Leg1;
    }

    @Override
    public void setB0Leg1(double b0Leg1) {
        this.b0Leg1 = b0Leg1;
    }

    @Override
    public double getB0Leg2() {
        return b0Leg2;
    }

    @Override
    public void setB0Leg2(double b0Leg2) {
        this.b0Leg2 = b0Leg2;
    }

    @Override
    public connectionKind getConnectionKindLeg1() {
        return connectionKindLeg1;
    }

    @Override
    public void setConnectionKindLeg1(connectionKind connectionKindLeg1) {
        this.connectionKindLeg1 = connectionKindLeg1;
    }

    @Override
    public connectionKind getConnectionKindLeg2() {
        return connectionKindLeg2;
    }

    @Override
    public void setConnectionKindLeg2(connectionKind connectionKindLeg2) {
        this.connectionKindLeg2 = connectionKindLeg2;
    }

    @Override
    public double getG0Leg1() {
        return g0Leg1;
    }

    @Override
    public void setG0Leg1(double g0Leg1) {
        this.g0Leg1 = g0Leg1;
    }

    @Override
    public double getG0Leg2() {
        return g0Leg2;
    }

    @Override
    public void setG0Leg2(double g0Leg2) {
        this.g0Leg2 = g0Leg2;
    }

    @Override
    public boolean isGroundedLeg1() {
        return groundedLeg1;
    }

    @Override
    public void setGroundedLeg1(boolean groundedLeg1) {
        this.groundedLeg1 = groundedLeg1;
    }

    @Override
    public boolean isGroundedLeg2() {
        return groundedLeg2;
    }

    @Override
    public void setGroundedLeg2(boolean groundedLeg2) {
        this.groundedLeg2 = groundedLeg2;
    }

    @Override
    public double getR0Leg1() {
        return r0Leg1;
    }

    @Override
    public void setR0Leg1(double r0Leg1) {
        this.r0Leg1 = r0Leg1;
    }

    @Override
    public double getR0Leg2() {
        return r0Leg2;
    }

    @Override
    public void setR0Leg2(double r0Leg2) {
        this.r0Leg2 = r0Leg2;
    }

    @Override
    public double getX0Leg1() {
        return x0Leg1;
    }

    @Override
    public void setX0Leg1(double x0Leg1) {
        this.x0Leg1 = x0Leg1;
    }

    @Override
    public double getX0Leg2() {
        return x0Leg2;
    }

    @Override
    public void setX0Leg2(double x0Leg2) {
        this.x0Leg2 = x0Leg2;
    }

    @Override
    public double getRgroundLeg1() {
        return rgroundLeg1;
    }

    @Override
    public void setRgroundLeg1(double rgroundLeg1) {
        this.rgroundLeg1 = rgroundLeg1;
    }

    @Override
    public double getRgroundLeg2() {
        return rgroundLeg2;
    }

    @Override
    public void setRgroundLeg2(double rgroundLeg2) {
        this.rgroundLeg2 = rgroundLeg2;
    }

    @Override
    public double getXgroundLeg1() {
        return xgroundLeg1;
    }

    @Override
    public void setXgroundLeg1(double xgroundLeg1) {
        this.xgroundLeg1 = xgroundLeg1;
    }

    @Override
    public double getXgroundLeg2() {
        return xgroundLeg2;
    }

    @Override
    public void setXgroundLeg2(double xgroundLeg2) {
        this.xgroundLeg2 = xgroundLeg2;
    }
}
