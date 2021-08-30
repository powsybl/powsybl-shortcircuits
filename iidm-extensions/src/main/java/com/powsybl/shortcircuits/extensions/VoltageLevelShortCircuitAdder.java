/**
 * Copyright (c) 2021, RTE (http://www.rte-france.com)
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.powsybl.shortcircuits.extensions;

import com.powsybl.commons.extensions.ExtensionAdder;
import com.powsybl.iidm.network.VoltageLevel;

/**
 * @author Coline Piloquet <coline.piloquet@rte-france.fr>
 */
public interface VoltageLevelShortCircuitAdder extends ExtensionAdder<VoltageLevel, VoltageLevelShortCircuit> {

    @Override
    default Class<VoltageLevelShortCircuit> getExtensionClass() {
        return VoltageLevelShortCircuit.class;
    }

    VoltageLevelShortCircuitAdder withIpMin(double IpMin);

    VoltageLevelShortCircuitAdder withIpMax(double IpMax);

}
