/**
 * Copyright (c) 2021, RTE (http://www.rte-france.com)
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.powsybl.extensions;

import com.powsybl.commons.extensions.Extension;
import com.powsybl.iidm.network.ShuntCompensatorLinearModel;

/**
 *
 * @author Coline Piloquet <coline.piloquet@rte-france.fr>
 */
public interface ShuntCompensatorLinearShortCircuit extends Extension<ShuntCompensatorLinearModel> {
    @Override
    default String getName() {
        return "linearShuntCompensatorShortCircuit";
    }

    public boolean isGrounded();

    public void setGrounded(boolean grounded);

    public double getB0PerSection();

    public void setB0PerSection(double b0PerSection);

    public double getG0PerSection();

    public void setG0PerSection(double g0PerSection);

}
