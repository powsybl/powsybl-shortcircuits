/**
 * Copyright (c) 2021, RTE (http://www.rte-france.com)
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package com.powsybl.shortcircuits.extensions;

import com.powsybl.commons.extensions.AbstractExtension;
import com.powsybl.iidm.network.VoltageLevel;

/**
 * @author Coline Piloquet <coline.piloquet@rte-france.com>
 */
public class VoltageLevelShortCircuitImpl extends AbstractExtension<VoltageLevel> implements VoltageLevelShortCircuit {
    private double ipMin; // Minimum allowable peak short-circuit current
    private double ipMax; // Maximum allowable peak short-circuit current

    public VoltageLevelShortCircuitImpl(VoltageLevel extendable, double ipMin, double ipMax) {
        super(extendable);
        this.ipMin = ipMin;
        this.ipMax = ipMax;
    }

    @Override
    public double getIpMin() {
        return ipMin;
    }

    @Override
    public VoltageLevelShortCircuit setIpMin(double ipMin) {
        this.ipMin = ipMin;
        return this;
    }

    @Override
    public double getIpMax() {
        return ipMax;
    }

    @Override
    public VoltageLevelShortCircuit setIpMax(double ipMax) {
        this.ipMax = ipMax;
        return this;
    }
}
