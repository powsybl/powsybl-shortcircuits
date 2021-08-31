/**
 * Copyright (c) 2021, RTE (http://www.rte-france.com)
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.powsybl.shortcircuits.extensions;

import com.powsybl.iidm.network.Generator;
import com.powsybl.iidm.network.Network;
import com.powsybl.iidm.network.test.EurostagTutorialExample1Factory;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Coline Piloquet <coline.piloquet@rte-france.com>
 */
public class GeneratorShortCircuitTest {
    @Test
    public void testWithoutTransformer() {
        Network network = EurostagTutorialExample1Factory.create();
        Generator gen = network.getGenerator("GEN");
        assertNotNull(gen);
        gen.newExtension(GeneratorShortCircuitAdder.class)
                .withDirectTransX(20)
                .withDirectSubtransX(20)
                .add();
        GeneratorShortCircuit generatorShortCircuit = gen.getExtension(GeneratorShortCircuit.class);
        assertEquals(20, generatorShortCircuit.getDirectTransX(), 0);
        assertEquals(20, generatorShortCircuit.getDirectSubtransX(), 0);
        assertEquals(Double.NaN, generatorShortCircuit.getStepUpTransformerX(), 0);
        generatorShortCircuit.setDirectTransX(10);
        assertEquals(20, generatorShortCircuit.getDirectSubtransX(), 0);
        generatorShortCircuit.setDirectSubtransX(30);
        assertEquals(30, generatorShortCircuit.getDirectSubtransX(), 0);
    }

    @Test
    public void testWithTransformer() {
        Network network = EurostagTutorialExample1Factory.create();
        Generator gen = network.getGenerator("GEN");
        assertNotNull(gen);
        gen.newExtension(GeneratorShortCircuitAdder.class)
                .withDirectTransX(20)
                .withDirectSubtransX(20)
                .withStepUpTransformerX(20)
                .add();
        GeneratorShortCircuit generatorShortCircuit = gen.getExtension(GeneratorShortCircuit.class);
        assertEquals(20, generatorShortCircuit.getDirectTransX(), 0);
        assertEquals(20, generatorShortCircuit.getDirectSubtransX(), 0);
        assertEquals(20, generatorShortCircuit.getStepUpTransformerX(), 0);
        generatorShortCircuit.setDirectTransX(10);
        assertEquals(20, generatorShortCircuit.getDirectSubtransX(), 0);
        generatorShortCircuit.setDirectSubtransX(30);
        assertEquals(30, generatorShortCircuit.getDirectSubtransX(), 0);
        generatorShortCircuit.setStepUpTransformerX(10);
        assertEquals(10, generatorShortCircuit.getStepUpTransformerX(), 0);
    }
}
