/**
 * Copyright (c) 2021, RTE (http://www.rte-france.com)
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package com.powsybl.shortcircuits.extensions.cgmesimporter;

import java.util.Objects;

import com.powsybl.iidm.network.Network;

/**
 * @author Luma Zamarreño <zamarrenolm at aia.es>
 * @author José Antonio Marqués <marquesja at aia.es>
 */

public class CgmesScImporter {

    private Network network;
    private CgmesScModel cgmesScModel;

    public CgmesScImporter(CgmesScModel cgmesScModel, Network network) {
        this.network = Objects.requireNonNull(network);
        this.cgmesScModel = Objects.requireNonNull(cgmesScModel);
    }

    public void importShortcircuitData() {
        importBusBarSections();
        importGenerators();
    }

    private void importBusBarSections() {
        BusbarSectionScImporter busbarSectionScImporter = new BusbarSectionScImporter(network);
        cgmesScModel.getBusbarSectionsShortcircuitData().forEach(busbarSectionScImporter::importData);
    }

    private void importGenerators() {
        GeneratorScImporter generatorImporter = new GeneratorScImporter(network);
        cgmesScModel.getSynchronousMachinesShortcircuitData().forEach(generatorImporter::importData);
    }
}

