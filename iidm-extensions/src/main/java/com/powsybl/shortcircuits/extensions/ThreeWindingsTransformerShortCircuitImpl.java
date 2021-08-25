/**
 * Copyright (c) 2021, RTE (http://www.rte-france.com)
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.powsybl.shortcircuits.extensions;

import com.powsybl.commons.extensions.AbstractExtension;
import com.powsybl.iidm.network.ThreeWindingsTransformer;

/**
 *
 * @author Coline Piloquet <coline.piloquet@rte-france.fr>
 */
public class ThreeWindingsTransformerShortCircuitImpl extends AbstractExtension<ThreeWindingsTransformer> implements ThreeWindingsTransformerShortCircuit{

    boolean isPartOfGeneratorUnit; // indicates whether the machine is part of a power station unit

    double b0Leg1; // susceptance of the first leg
    double b0Leg2; // susceptance of the second leg
    double b0Leg3; // susceptance of the third leg

    connectionKind connectionKindLeg1; // Type of connection of the first leg
    connectionKind connectionKindLeg2; // Type of connection of the second leg
    connectionKind connectionKindLeg3; // Type of connection of the third leg

    double g0Leg1; // conductance of the first leg
    double g0Leg2; // conductance of the second leg
    double g0Leg3; // conductance of the third leg

    boolean groundedLeg1;
    boolean groundedLeg2;
    boolean groundedLeg3;

    double r0Leg1; // resistance of the first leg
    double r0Leg2; // resistance of the second leg
    double r0Leg3; // resistance of the third leg

    double x0Leg1; // reactance of the first leg
    double x0Leg2; // reactance of the second leg
    double x0Leg3; // reactance of the third leg

    double rgroundLeg1; // resistance of the first leg
    double rgroundLeg2; // resistance of the second leg
    double rgroundLeg3; // resistance of the third leg

    double xgroundLeg1; // reactance of the first leg
    double xgroundLeg2; // reactance of the second leg
    double xgroundLeg3; // reactance of the third leg

    public ThreeWindingsTransformerShortCircuitImpl(boolean isPartOfGeneratorUnit, double b0Leg1, double b0Leg2, double b0Leg3, connectionKind connectionKindLeg1,
                                                    connectionKind connectionKindLeg2, connectionKind connectionKindLeg3, double g0Leg1, double g0Leg2, double g0Leg3,
                                                    boolean groundedLeg1, boolean groundedLeg2, boolean groundedLeg3, double r0Leg1, double r0Leg2, double r0Leg3,
                                                    double x0Leg1, double x0Leg2, double x0Leg3, double rgroundLeg1, double rgroundLeg2, double rgroundLeg3,
                                                    double xgroundLeg1, double xgroundLeg2, double xgroundLeg3) {
        this.isPartOfGeneratorUnit = isPartOfGeneratorUnit;
        this.b0Leg1 = b0Leg1;
        this.b0Leg2 = b0Leg2;
        this.b0Leg3 = b0Leg3;
        this.connectionKindLeg1 = connectionKindLeg1;
        this.connectionKindLeg2 = connectionKindLeg2;
        this.connectionKindLeg3 = connectionKindLeg3;
        this.g0Leg1 = g0Leg1;
        this.g0Leg2 = g0Leg2;
        this.g0Leg3 = g0Leg3;
        this.groundedLeg1 = groundedLeg1;
        this.groundedLeg2 = groundedLeg2;
        this.groundedLeg3 = groundedLeg3;
        this.r0Leg1 = r0Leg1;
        this.r0Leg2 = r0Leg2;
        this.r0Leg3 = r0Leg3;
        this.x0Leg1 = x0Leg1;
        this.x0Leg2 = x0Leg2;
        this.x0Leg3 = x0Leg3;
        this.rgroundLeg1 = rgroundLeg1;
        this.rgroundLeg2 = rgroundLeg2;
        this.rgroundLeg3 = rgroundLeg3;
        this.xgroundLeg1 = xgroundLeg1;
        this.xgroundLeg2 = xgroundLeg2;
        this.xgroundLeg3 = xgroundLeg3;
    }

    public ThreeWindingsTransformerShortCircuitImpl(boolean isPartOfGeneratorUnit, double b0Leg1, double b0Leg2, double b0Leg3, connectionKind connectionKindLeg1,
                                                    connectionKind connectionKindLeg2, connectionKind connectionKindLeg3, double g0Leg1, double g0Leg2, double g0Leg3,
                                                    boolean groundedLeg1, boolean groundedLeg2, boolean groundedLeg3, double r0Leg1, double r0Leg2, double r0Leg3,
                                                    double x0Leg1, double x0Leg2, double x0Leg3) {
        this.isPartOfGeneratorUnit = isPartOfGeneratorUnit;
        this.b0Leg1 = b0Leg1;
        this.b0Leg2 = b0Leg2;
        this.b0Leg3 = b0Leg3;
        this.connectionKindLeg1 = connectionKindLeg1;
        this.connectionKindLeg2 = connectionKindLeg2;
        this.connectionKindLeg3 = connectionKindLeg3;
        this.g0Leg1 = g0Leg1;
        this.g0Leg2 = g0Leg2;
        this.g0Leg3 = g0Leg3;
        this.groundedLeg1 = groundedLeg1;
        this.groundedLeg2 = groundedLeg2;
        this.groundedLeg3 = groundedLeg3;
        this.r0Leg1 = r0Leg1;
        this.r0Leg2 = r0Leg2;
        this.r0Leg3 = r0Leg3;
        this.x0Leg1 = x0Leg1;
        this.x0Leg2 = x0Leg2;
        this.x0Leg3 = x0Leg3;
    }



    @Override
    public boolean isPartOfGeneratorUnit() {
        return isPartOfGeneratorUnit;
    }

    @Override
    public ThreeWindingsTransformerShortCircuit setPartOfGeneratorUnit(boolean partOfGeneratorUnit) {
        isPartOfGeneratorUnit = partOfGeneratorUnit;
        return this;
    }

    @Override
    public double getB0Leg1() {
        return b0Leg1;
    }

    @Override
    public ThreeWindingsTransformerShortCircuit setB0Leg1(double b0Leg1) {
        this.b0Leg1 = b0Leg1;
        return this;
    }

    @Override
    public double getB0Leg2() {
        return b0Leg2;
    }

    @Override
    public ThreeWindingsTransformerShortCircuit setB0Leg2(double b0Leg2) {
        this.b0Leg2 = b0Leg2;
        return this;
    }

    @Override
    public double getB0Leg3() {
        return b0Leg3;
    }

    @Override
    public ThreeWindingsTransformerShortCircuit setB0Leg3(double b0Leg3) {
        this.b0Leg3 = b0Leg3;
        return this;
    }

    @Override
    public connectionKind getConnectionKindLeg1() {
        return connectionKindLeg1;
    }

    @Override
    public ThreeWindingsTransformerShortCircuit setConnectionKindLeg1(connectionKind connectionKindLeg1) {
        this.connectionKindLeg1 = connectionKindLeg1;
        return this;
    }

    @Override
    public connectionKind getConnectionKindLeg2() {
        return connectionKindLeg2;
    }

    @Override
    public ThreeWindingsTransformerShortCircuit setConnectionKindLeg2(connectionKind connectionKindLeg2) {
        this.connectionKindLeg2 = connectionKindLeg2;
        return this;
    }

    @Override
    public connectionKind getConnectionKindLeg3() {
        return connectionKindLeg3;
    }

    @Override
    public ThreeWindingsTransformerShortCircuit setConnectionKindLeg3(connectionKind connectionKindLeg3) {
        this.connectionKindLeg3 = connectionKindLeg3;
        return this;
    }

    @Override
    public double getG0Leg1() {
        return g0Leg1;
    }

    @Override
    public ThreeWindingsTransformerShortCircuit setG0Leg1(double g0Leg1) {
        this.g0Leg1 = g0Leg1;
        return this;
    }

    @Override
    public double getG0Leg2() {
        return g0Leg2;
    }

    @Override
    public ThreeWindingsTransformerShortCircuit setG0Leg2(double g0Leg2) {
        this.g0Leg2 = g0Leg2;
        return this;
    }

    @Override
    public double getG0Leg3() {
        return g0Leg3;
    }

    @Override
    public ThreeWindingsTransformerShortCircuit setG0Leg3(double g0Leg3) {
        this.g0Leg3 = g0Leg3;
        return this;
    }

    @Override
    public boolean isGroundedLeg1() {
        return groundedLeg1;
    }

    @Override
    public ThreeWindingsTransformerShortCircuit setGroundedLeg1(boolean groundedLeg1) {
        this.groundedLeg1 = groundedLeg1;
        return this;
    }

    @Override
    public boolean isGroundedLeg2() {
        return groundedLeg2;
    }

    @Override
    public ThreeWindingsTransformerShortCircuit setGroundedLeg2(boolean groundedLeg2) {
        this.groundedLeg2 = groundedLeg2;
        return this;
    }

    @Override
    public boolean isGroundedLeg3() {
        return groundedLeg3;
    }

    @Override
    public ThreeWindingsTransformerShortCircuit setGroundedLeg3(boolean groundedLeg3) {
        this.groundedLeg3 = groundedLeg3;
        return this;
    }

    @Override
    public double getR0Leg1() {
        return r0Leg1;
    }

    @Override
    public ThreeWindingsTransformerShortCircuit setR0Leg1(double r0Leg1) {
        this.r0Leg1 = r0Leg1;
        return this;
    }

    @Override
    public double getR0Leg2() {
        return r0Leg2;
    }

    @Override
    public ThreeWindingsTransformerShortCircuit setR0Leg2(double r0Leg2) {
        this.r0Leg2 = r0Leg2;
        return this;
    }

    @Override
    public double getR0Leg3() {
        return r0Leg3;
    }

    @Override
    public ThreeWindingsTransformerShortCircuit setR0Leg3(double r0Leg3) {
        this.r0Leg3 = r0Leg3;
        return this;
    }

    @Override
    public double getX0Leg1() {
        return x0Leg1;
    }

    @Override
    public ThreeWindingsTransformerShortCircuit setX0Leg1(double x0Leg1) {
        this.x0Leg1 = x0Leg1;
        return this;
    }

    @Override
    public double getX0Leg2() {
        return x0Leg2;
    }

    @Override
    public ThreeWindingsTransformerShortCircuit setX0Leg2(double x0Leg2) {
        this.x0Leg2 = x0Leg2;
        return this;
    }

    @Override
    public double getX0Leg3() {
        return x0Leg3;
    }

    @Override
    public ThreeWindingsTransformerShortCircuit setX0Leg3(double x0Leg3) {
        this.x0Leg3 = x0Leg3;
        return this;
    }

    @Override
    public double getRgroundLeg1() {
        return rgroundLeg1;
    }

    @Override
    public ThreeWindingsTransformerShortCircuit setRgroundLeg1(double rgroundLeg1) {
        this.rgroundLeg1 = rgroundLeg1;
        return this;
    }

    @Override
    public double getRgroundLeg2() {
        return rgroundLeg2;
    }

    @Override
    public ThreeWindingsTransformerShortCircuit setRgroundLeg2(double rgroundLeg2) {
        this.rgroundLeg2 = rgroundLeg2;
        return this;
    }

    @Override
    public double getRgroundLeg3() {
        return rgroundLeg3;
    }

    @Override
    public ThreeWindingsTransformerShortCircuit setRgroundLeg3(double rgroundLeg3) {
        this.rgroundLeg3 = rgroundLeg3;
        return this;
    }

    @Override
    public double getXgroundLeg1() {
        return xgroundLeg1;
    }

    @Override
    public ThreeWindingsTransformerShortCircuit setXgroundLeg1(double xgroundLeg1) {
        this.xgroundLeg1 = xgroundLeg1;
        return this;
    }

    @Override
    public double getXgroundLeg2() {
        return xgroundLeg2;
    }

    @Override
    public ThreeWindingsTransformerShortCircuit setXgroundLeg2(double xgroundLeg2) {
        this.xgroundLeg2 = xgroundLeg2;
        return this;
    }

    @Override
    public double getXgroundLeg3() {
        return xgroundLeg3;
    }

    @Override
    public ThreeWindingsTransformerShortCircuit setXgroundLeg3(double xgroundLeg3) {
        this.xgroundLeg3 = xgroundLeg3;
        return this;
    }
}