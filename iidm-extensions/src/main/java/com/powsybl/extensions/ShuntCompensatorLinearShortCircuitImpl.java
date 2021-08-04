/**
 * Copyright (c) 2021, RTE (http://www.rte-france.com)
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.powsybl.extensions;

import com.powsybl.commons.extensions.AbstractExtension;
import com.powsybl.iidm.network.ShuntCompensatorLinearModel;

/**
 *
 * @author Coline Piloquet <coline.piloquet@rte-france.fr>
 */
public class ShuntCompensatorLinearShortCircuitImpl extends AbstractExtension<ShuntCompensatorLinearModel> implements ShuntCompensatorLinearShortCircuit{

    boolean grounded;
    double b0PerSection; //susceptance
    double g0PerSection; //conductance

    public ShuntCompensatorLinearShortCircuitImpl(boolean grounded, double b0PerSection, double g0PerSection) {
        this.grounded = grounded;
        this.b0PerSection = b0PerSection;
        this.g0PerSection = g0PerSection;
    }

    @Override
    public boolean isGrounded() {
        return grounded;
    }

    @Override
    public void setGrounded(boolean grounded) {
        this.grounded = grounded;
    }

    @Override
    public double getB0PerSection() {
        return b0PerSection;
    }

    @Override
    public void setB0PerSection(double b0PerSection) {
        this.b0PerSection = b0PerSection;
    }

    @Override
    public double getG0PerSection() {
        return g0PerSection;
    }

    @Override
    public void setG0PerSection(double g0PerSection) {
        this.g0PerSection = g0PerSection;
    }
}
