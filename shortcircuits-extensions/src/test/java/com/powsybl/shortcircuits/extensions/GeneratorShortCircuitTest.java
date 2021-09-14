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
import com.powsybl.commons.AbstractConverterTest;
import com.powsybl.iidm.xml.NetworkXml;
import org.joda.time.DateTime;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Coline Piloquet <coline.piloquet@rte-france.com>
 */
public class GeneratorShortCircuitTest extends AbstractConverterTest {
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

    @Test
    public void testXmlSerializer() throws IOException {
        Network network = EurostagTutorialExample1Factory.create();
        network.setCaseDate(DateTime.parse("2016-12-07T11:18:52.881+01:00"));
        Generator gen = network.getGenerator("GEN");
        assertNotNull(gen);
        gen.newExtension(GeneratorShortCircuitAdder.class)
                .withDirectTransX(20)
                .withDirectSubtransX(20)
                .withStepUpTransformerX(20)
                .add();
        GeneratorShortCircuit generatorShortCircuit = gen.getExtension(GeneratorShortCircuit.class);

        Network network2 = roundTripXmlTest(network,
                NetworkXml::writeAndValidate,
                NetworkXml::read, "/generatorShortCircuitRef.xml");

        Generator gen2 = network2.getGenerator("GEN");
        assertNotNull(gen2);
        GeneratorShortCircuit generatorShortCircuit2 = gen2.getExtension(GeneratorShortCircuit.class);
        assertNotNull(generatorShortCircuit2);

        assertEquals(generatorShortCircuit.getDirectSubtransX(), generatorShortCircuit2.getDirectSubtransX(), 0);
        assertEquals(generatorShortCircuit.getDirectTransX(), generatorShortCircuit2.getDirectTransX(), 0);
        assertEquals(generatorShortCircuit.getStepUpTransformerX(), generatorShortCircuit2.getStepUpTransformerX(), 0);

    }
}
