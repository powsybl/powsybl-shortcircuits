/**
 * Copyright (c) 2021, RTE (http://www.rte-france.com)
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.powsybl.shortcircuits.converters;

import com.powsybl.cgmes.conformity.test.Cgmes3Catalog;
import com.powsybl.cgmes.conformity.test.CgmesConformity1Catalog;
import com.powsybl.cgmes.conversion.CgmesImport;
import com.powsybl.cgmes.conversion.CgmesModelExtension;
import com.powsybl.cgmes.model.CgmesModel;
import com.powsybl.iidm.network.Bus;
import com.powsybl.iidm.network.BusbarSection;
import com.powsybl.iidm.network.Generator;
import com.powsybl.iidm.network.Network;
import com.powsybl.iidm.network.NetworkFactory;
import com.powsybl.iidm.network.extensions.GeneratorShortCircuit;
import com.powsybl.iidm.network.extensions.IdentifiableShortCircuit;
import com.powsybl.shortcircuits.converters.cgmes.CgmesShortCircuitImporter;
import com.powsybl.shortcircuits.converters.cgmes.CgmesShortCircuitModel;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.Properties;

/**
 * @author Luma Zamarreño <zamarrenolm at aia.es>
 * @author José Antonio Marqués <marquesja at aia.es>
 */
public class CgmesImporterTest {

    @Test
    public void testImportCgmesGeneratorShortCircuitData() {
        Network network = new CgmesImport().importData(CgmesConformity1Catalog.miniBusBranch().dataSource(),
            NetworkFactory.findDefault(), new Properties());

        CgmesModelExtension cgmesModelExtension = network.getExtension(CgmesModelExtension.class);
        assertNotNull(cgmesModelExtension);
        CgmesModel cgmesModel = cgmesModelExtension.getCgmesModel();
        assertNotNull(cgmesModel);

        CgmesShortCircuitModel cgmesScModel = new CgmesShortCircuitModel(cgmesModel.tripleStore());
        new CgmesShortCircuitImporter(cgmesScModel, network).importShortcircuitData();

        Generator generator = network.getGenerator("_392ea173-4f8e-48fa-b2a3-5c3721e93196");
        assertNotNull(generator);

        GeneratorShortCircuit generatorShortCircuit = generator.getExtension(GeneratorShortCircuit.class);
        assertNotNull(generatorShortCircuit);

        double tol = 0.000001;
        assertEquals(0.1, generatorShortCircuit.getDirectSubtransX(), tol);
        assertEquals(1.8, generatorShortCircuit.getDirectTransX(), tol);
        assertTrue(Double.isNaN(generatorShortCircuit.getStepUpTransformerX()));
    }

    @Test
    public void testImportCgmes3GeneratorShortCircuitData() {
        Network network = new CgmesImport().importData(Cgmes3Catalog.miniGrid().dataSource(),
            NetworkFactory.findDefault(), new Properties());

        CgmesModelExtension cgmesModelExtension = network.getExtension(CgmesModelExtension.class);
        assertNotNull(cgmesModelExtension);
        CgmesModel cgmesModel = cgmesModelExtension.getCgmesModel();
        assertNotNull(cgmesModel);

        CgmesShortCircuitModel cgmesScModel = new CgmesShortCircuitModel(cgmesModel.tripleStore());
        new CgmesShortCircuitImporter(cgmesScModel, network).importShortcircuitData();

        Generator generator = network.getGenerator("_ca67be42-750e-4ebf-bfaa-24d446e59a22");
        assertNotNull(generator);

        GeneratorShortCircuit generatorShortCircuit = generator.getExtension(GeneratorShortCircuit.class);
        assertNotNull(generatorShortCircuit);

        double tol = 0.000001;
        assertEquals(0.6174, generatorShortCircuit.getDirectSubtransX(), tol);
        assertEquals(7.938, generatorShortCircuit.getDirectTransX(), tol);
        assertTrue(Double.isNaN(generatorShortCircuit.getStepUpTransformerX()));
    }

    @Test
    public void testImportCgmesBranchModelBusbarSectionShortCircuitData() {
        Network network = new CgmesImport().importData(ShortCircuitCgmesConformity1ModifiedCatalog.smallGridBusBranchWithBusbarSectionsAndIpMax().dataSource(),
            NetworkFactory.findDefault(), new Properties());

        CgmesModelExtension cgmesModelExtension = network.getExtension(CgmesModelExtension.class);
        assertNotNull(cgmesModelExtension);
        CgmesModel cgmesModel = cgmesModelExtension.getCgmesModel();
        assertNotNull(cgmesModel);

        CgmesShortCircuitModel cgmesScModel = new CgmesShortCircuitModel(cgmesModel.tripleStore());
        new CgmesShortCircuitImporter(cgmesScModel, network).importShortcircuitData();

        Bus bus = network.getBusBreakerView().getBus("_0472a783-c766-11e1-8775-005056c00008");
        assertNotNull(bus);

        IdentifiableShortCircuit busShortCircuit = bus.getExtension(IdentifiableShortCircuit.class);
        assertNotNull(busShortCircuit);

        assertTrue(Double.isNaN(busShortCircuit.getIpMin()));
        assertEquals(1000.0, busShortCircuit.getIpMax(), 0.000001);
    }

    @Test
    public void testImportCgmesBusbarSectionShortCircuitData() {
        Network network = new CgmesImport().importData(CgmesConformity1Catalog.miniNodeBreaker().dataSource(),
            NetworkFactory.findDefault(), new Properties());

        CgmesModelExtension cgmesModelExtension = network.getExtension(CgmesModelExtension.class);
        assertNotNull(cgmesModelExtension);
        CgmesModel cgmesModel = cgmesModelExtension.getCgmesModel();
        assertNotNull(cgmesModel);

        CgmesShortCircuitModel cgmesScModel = new CgmesShortCircuitModel(cgmesModel.tripleStore());
        new CgmesShortCircuitImporter(cgmesScModel, network).importShortcircuitData();

        BusbarSection busbarSection = network.getBusbarSection("_d9f23c01-d924-4040-ab48-d5c36ccdf1a3");
        assertNotNull(busbarSection);

        IdentifiableShortCircuit busbarSectionShortCircuit = busbarSection.getExtension(IdentifiableShortCircuit.class);
        assertNull(busbarSectionShortCircuit);
    }

    @Test
    public void testImportCgmes3BusbarSectionShortCircuitData() {
        Network network = new CgmesImport().importData(Cgmes3Catalog.microGrid().dataSource(),
            NetworkFactory.findDefault(), new Properties());

        CgmesModelExtension cgmesModelExtension = network.getExtension(CgmesModelExtension.class);
        assertNotNull(cgmesModelExtension);
        CgmesModel cgmesModel = cgmesModelExtension.getCgmesModel();
        assertNotNull(cgmesModel);

        CgmesShortCircuitModel cgmesScModel = new CgmesShortCircuitModel(cgmesModel.tripleStore());
        new CgmesShortCircuitImporter(cgmesScModel, network).importShortcircuitData();

        BusbarSection busbarSection = network.getBusbarSection("_364c9ca2-0d1d-4363-8f46-e586f8f66a8c");
        assertNotNull(busbarSection);

        IdentifiableShortCircuit busbarSectionShortCircuit = busbarSection.getExtension(IdentifiableShortCircuit.class);
        assertNotNull(busbarSectionShortCircuit);

        assertTrue(Double.isNaN(busbarSectionShortCircuit.getIpMin()));
        assertEquals(5000.0, busbarSectionShortCircuit.getIpMax(), 0.000001);
    }
}
