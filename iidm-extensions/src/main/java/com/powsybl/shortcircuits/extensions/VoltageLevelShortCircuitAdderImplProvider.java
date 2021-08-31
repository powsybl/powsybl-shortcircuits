/**
 * Copyright (c) 2021, RTE (http://www.rte-france.com)
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.powsybl.shortcircuits.extensions;

import com.google.auto.service.AutoService;
import com.powsybl.commons.extensions.ExtensionAdderProvider;
import com.powsybl.iidm.network.VoltageLevel;

/**
 * @author Coline Piloquet <coline.piloquet@rte-france.fr>
 */
@AutoService(ExtensionAdderProvider.class)
public class VoltageLevelShortCircuitAdderImplProvider
        implements ExtensionAdderProvider<VoltageLevel, VoltageLevelShortCircuit, VoltageLevelShortCircuitAdder>{

    @Override
    public String getImplementationName() {
        return "Default";
    }

    @Override
    public Class<VoltageLevelShortCircuitAdder> getAdderClass() {
        return VoltageLevelShortCircuitAdder.class;
    }

    @Override
    public VoltageLevelShortCircuitAdder newAdder(VoltageLevel extendable) {
        return new VoltageLevelShortCircuitAdderImpl (extendable);
    }
}
