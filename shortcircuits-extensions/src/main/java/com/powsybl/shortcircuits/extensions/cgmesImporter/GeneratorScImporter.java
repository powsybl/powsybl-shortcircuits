/**
 * Copyright (c) 2021, RTE (http://www.rte-france.com)
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package com.powsybl.shortcircuits.extensions.cgmesimporter;

import java.util.Objects;

import com.powsybl.iidm.network.Generator;
import com.powsybl.iidm.network.Network;
import com.powsybl.shortcircuits.extensions.GeneratorShortCircuitAdder;
import com.powsybl.shortcircuits.extensions.PerUnit;
import com.powsybl.triplestore.api.PropertyBag;

/**
 * @author Luma Zamarreño <zamarrenolm at aia.es>
 * @author José Antonio Marqués <marquesja at aia.es>
 */
class GeneratorScImporter extends AbstractScImporter {

    private Network network;

    public GeneratorScImporter(Network network) {
        this.network = Objects.requireNonNull(network);
    }

    void importData(PropertyBag synchrohousMachine) {
        Objects.requireNonNull(synchrohousMachine);

        String generatorId = synchrohousMachine.getId("SynchronousMachine");
        Generator generator = network.getGenerator(generatorId);
        if (generator == null) {
            return;
        }
        double satDirectSubtransXpu = synchrohousMachine.asDouble("satDirectSubtransX");
        double satDirectTransXpu = synchrohousMachine.asDouble("satDirectTransX");

        double vNominal = generator.getTerminal().getVoltageLevel().getNominalV();
        double satDirectSubtransX = impedanceToEngineeringUnit(satDirectSubtransXpu, vNominal, PerUnit.SB);
        double satDirectTransX = impedanceToEngineeringUnit(satDirectTransXpu, vNominal, PerUnit.SB);

        if (!Double.isNaN(satDirectSubtransX) || !Double.isNaN(satDirectTransX)) {
            GeneratorShortCircuitAdder adder = generator.newExtension(GeneratorShortCircuitAdder.class);
            if (!Double.isNaN(satDirectSubtransX)) {
                adder.withDirectSubtransX(satDirectSubtransX);
            }
            if (!Double.isNaN(satDirectTransX)) {
                adder.withDirectTransX(satDirectTransX);
            }
            adder.add();
        }
    }
}

