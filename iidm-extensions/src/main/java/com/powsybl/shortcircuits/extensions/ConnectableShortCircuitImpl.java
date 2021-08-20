/**
 * Copyright (c) 2021, RTE (http://www.rte-france.com)
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.powsybl.shortcircuits.extensions;

import com.powsybl.commons.extensions.AbstractExtension;
import com.powsybl.iidm.network.Connectable;

/**
 * @author Coline Piloquet <coline.piloquet@rte-france.com>
 */
public class ConnectableShortCircuitImpl extends AbstractExtension<Connectable> implements ConnectableShortCircuit {

    private double ipMax; // maximum allowable peak short-circuit current of busbar
    private double ipMin; // minimum allowable peak short-circuit current of busbar

    public ConnectableShortCircuitImpl(double ipMax, double ipMin) {
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
