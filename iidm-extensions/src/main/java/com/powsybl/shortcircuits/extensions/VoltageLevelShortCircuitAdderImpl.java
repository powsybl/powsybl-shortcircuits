/**
 * Copyright (c) 2021, RTE (http://www.rte-france.com)
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.powsybl.shortcircuits.extensions;

import com.powsybl.commons.extensions.AbstractExtensionAdder;
import com.powsybl.iidm.network.VoltageLevel;

/**
 * @author Coline Piloquet <coline.piloquet@rte-france.fr>
 */
public class VoltageLevelShortCircuitAdderImpl extends AbstractExtensionAdder<VoltageLevel, VoltageLevelShortCircuit>
        implements VoltageLevelShortCircuitAdder {

    double ipMin=-1;
    double ipMax=-1;

    protected VoltageLevelShortCircuitAdderImpl(VoltageLevel extendable){
        super(extendable);
    }

    @Override
    protected VoltageLevelShortCircuit createExtension(VoltageLevel extendable){
        return new VoltageLevelShortCircuitImpl(extendable, ipMin, ipMax);
    }

    @Override
    public VoltageLevelShortCircuitAdder withIpMin(double ipMin){
        this.ipMin = ipMin;
        return this;
    }

    @Override
    public VoltageLevelShortCircuitAdder withIpMax(double ipMax){
        this.ipMax = ipMax;
        return this;
    }
}
