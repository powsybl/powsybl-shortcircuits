/**
 * Copyright (c) 2021, RTE (http://www.rte-france.com)
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package com.powsybl.shortcircuits.extensions;

import com.powsybl.commons.extensions.Extension;
import com.powsybl.iidm.network.VoltageLevel;

/**
 * @author Coline Piloquet <coline.piloquet@rte-france.com>
 */
public interface VoltageLevelShortCircuit extends Extension<VoltageLevel> {
    @Override
    default String getName() {
        return "voltageLevelShortCircuits";
    }

    /**
     * Get minimum allowable peak short-circuit current
     */
    double getIpMin();

    /**
     * Set minimum allowable peak short-circuit current
     */
    VoltageLevelShortCircuit setIpMin (double ipMin);

    /**
     * Get maximum allowable peak short-circuit current
     */
    double getIpMax();

    /**
     * Set maximum allowable peak short-circuit current
     */
    VoltageLevelShortCircuit setIpMax(double ipMax);
}
