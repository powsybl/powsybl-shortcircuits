/**
 * Copyright (c) 2021, RTE (http://www.rte-france.com)
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.powsybl.shortcircuits.extensions;

import com.powsybl.commons.extensions.Extension;
import com.powsybl.iidm.network.Connectable;

/**
 * @author Coline Piloquet <coline.piloquet@rte-france.com>
 */
public interface ConnectableShortCircuit extends Extension<Connectable> {
    @Override
    default String getName() {
        return "busBarSectionShortCircuit";
    }

    /**
     * Get the maximum allowable peak short-circuit current of the busbar.
     * It represents the mechanical limit of the busbar in the substation itself.
     */
    double getIpMax();

    /**
     * Set the maximum allowable peak short-circuit current of the busbar.
     * It represents the mechanical limit of the busbar in the substation itself.
     */
    ConnectableShortCircuit setIpMax(double ipMax);

    /**
     * Get the minimum allowable peak short-circuit current of the busbar.
     * It represents the mechanical limit of the busbar in the substation itself.
     */
    double getIpMin();

    /**
     * Set the maximum allowable peak short-circuit current of the busbar.
     * It represents the mechanical limit of the busbar in the substation itself.
     */
    ConnectableShortCircuit setIpMin(double ipMin);
}
