/**
 * Copyright (c) 2021, RTE (http://www.rte-france.com)
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.powsybl.shortcircuits.extensions;

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

    boolean isGrounded();

    ShuntCompensatorLinearShortCircuit setGrounded(boolean grounded);

    double getB0PerSection();

    ShuntCompensatorLinearShortCircuit setB0PerSection(double b0PerSection);

    double getG0PerSection();

    ShuntCompensatorLinearShortCircuit setG0PerSection(double g0PerSection);

}