/**
 * Copyright (c) 2021, RTE (http://www.rte-france.com)
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package com.powsybl.shortcircuits.extensions.cgmesImporter;

import java.util.Objects;

import com.powsybl.iidm.network.BusbarSection;
import com.powsybl.iidm.network.Network;
import com.powsybl.shortcircuits.extensions.IdentifiableShortCircuitAdder;
import com.powsybl.triplestore.api.PropertyBag;

/**
 * @author Luma Zamarreño <zamarrenolm at aia.es>
 * @author José Antonio Marqués <marquesja at aia.es>
 */
class BusbarSectionScImporter {

    private Network network;

    public BusbarSectionScImporter(Network network) {
        this.network = Objects.requireNonNull(network);
    }

    void importData(PropertyBag busbarSectionPropertyBag) {
        Objects.requireNonNull(busbarSectionPropertyBag);

        String busbarSectionId = busbarSectionPropertyBag.getId("BusbarSection");
        BusbarSection busbarSection = network.getBusbarSection(busbarSectionId);
        if (busbarSection == null) {
            return;
        }
        double ipMax = busbarSectionPropertyBag.asDouble("ipMax");

        if (!Double.isNaN(ipMax)) {
            busbarSection.newExtension(IdentifiableShortCircuitAdder.class)
                .withIpMax(ipMax)
                .withIpMin(0.0)
                .add();
        }
    }
}

