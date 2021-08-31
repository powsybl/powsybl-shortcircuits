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
import org.junit.Assert;
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
        assertEquals(generatorShortCircuit.getDirectTransX(), 20, 0);
        assertEquals(generatorShortCircuit.getDirectSubtransX(), 20, 0);
        Assert.assertFalse(generatorShortCircuit.getStepUpTransformerX().isPresent());
        generatorShortCircuit.setDirectTransX(10);
        assertEquals(generatorShortCircuit.getDirectSubtransX(), 20, 0);
        generatorShortCircuit.setDirectSubtransX(30);
        assertEquals(generatorShortCircuit.getDirectSubtransX(), 30, 0);
    }

    @Test
    public void testWithTransformer() {
        Network network = EurostagTutorialExample1Factory.create();
        Generator gen = network.getGenerator("GEN");
        assertNotNull(gen);
        gen.newExtension(GeneratorShortCircuitAdder.class)
                .withDirectTransX(20)
                .withDirectSubtransX(20)
                .withSetUpTransformerX(20)
                .add();
        GeneratorShortCircuit generatorShortCircuit = gen.getExtension(GeneratorShortCircuit.class);
        assertEquals(generatorShortCircuit.getDirectTransX(), 20, 0);
        assertEquals(generatorShortCircuit.getDirectSubtransX(), 20, 0);
        Assert.assertTrue(generatorShortCircuit.getStepUpTransformerX().isPresent());
        assertEquals(generatorShortCircuit.getStepUpTransformerX().getAsDouble(), 20, 0);
        generatorShortCircuit.setDirectTransX(10);
        assertEquals(generatorShortCircuit.getDirectSubtransX(), 20, 0);
        generatorShortCircuit.setDirectSubtransX(30);
        assertEquals(generatorShortCircuit.getDirectSubtransX(), 30, 0);
    }
}
