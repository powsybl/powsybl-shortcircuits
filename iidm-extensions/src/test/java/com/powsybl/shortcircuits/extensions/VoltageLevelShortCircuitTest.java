/**
 * Copyright (c) 2021, RTE (http://www.rte-france.com)
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.powsybl.shortcircuits.extensions;

import com.powsybl.iidm.network.Network;
import com.powsybl.iidm.network.VoltageLevel;
import com.powsybl.iidm.network.test.EurostagTutorialExample1Factory;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Coline Piloquet <coline.piloquet@rte-france.com>
 */
public class VoltageLevelShortCircuitTest {
    @Test
    public void test() {
        Network network = EurostagTutorialExample1Factory.create();
        VoltageLevel voltageLevel = network.getVoltageLevel("VLLOAD");
        assertNotNull(voltageLevel);
        voltageLevel.newExtension(VoltageLevelShortCircuitAdder.class)
                .withIpMin(2000)
                .withIpMax(1000)
                .add();
        VoltageLevelShortCircuit voltageLevelShortCircuit = voltageLevel.getExtension(VoltageLevelShortCircuit.class);
        assertEquals(1000, voltageLevelShortCircuit.getIpMin(), 0);
        assertEquals(2000, voltageLevelShortCircuit.getIpMax(), 0);
        voltageLevelShortCircuit.setIpMax(1500);
        voltageLevelShortCircuit.setIpMin(900);
        assertEquals(900, voltageLevelShortCircuit.getIpMin(), 0);
        assertEquals(1500, voltageLevelShortCircuit.getIpMax(), 0);
    }
}
