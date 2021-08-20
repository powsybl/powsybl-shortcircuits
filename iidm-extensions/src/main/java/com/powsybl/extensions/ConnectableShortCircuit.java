/**
 * Copyright (c) 2021, RTE (http://www.rte-france.com)
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.powsybl.extensions;

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

    public double getIpMax();

    public void setIpMax(double ipMax);

    public double getIpMin();

    public void setIpMin(double ipMin);
}
