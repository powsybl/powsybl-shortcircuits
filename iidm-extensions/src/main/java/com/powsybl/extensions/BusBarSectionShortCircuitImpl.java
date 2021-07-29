/**
 * Copyright (c) 2021, RTE (http://www.rte-france.com)
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */

package com.powsybl.extensions;

import com.powsybl.commons.extensions.AbstractExtension;
import com.powsybl.iidm.network.BusbarSection;

/**
 *
 * @author Coline Piloquet <coline.piloquet@rte-france.fr>
 */
public class BusBarSectionShortCircuitImpl extends AbstractExtension<BusbarSection> implements BusBarSectionShortCircuit {
    private double ipMax; // current
    private double ipMin; // current

    public BusBarSectionShortCircuitImpl(double ipMax, double ipMin) {
        this.ipMax = ipMax;
        this.ipMin = ipMin;
    }

    @Override
    public double getIpMax() {
        return ipMax;
    }

    @Override
    public void setIpMax(double ipMax) {
        this.ipMax = ipMax;
    }

    @Override
    public double getIpMin() {
        return ipMin;
    }

    @Override
    public void setIpMin(double ipMin) {
        this.ipMin = ipMin;
    }
}
