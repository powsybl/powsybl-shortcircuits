/**
 * Copyright (c) 2021, RTE (http://www.rte-france.com)
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.powsybl.extensions;

import com.powsybl.commons.extensions.Extension;

/**
 *
 * @author Coline Piloquet <coline.piloquet@rte-france.fr>
 */
public interface LineShortCircuit extends Extension<com.powsybl.iidm.network.Line> {
    @Override
    default String getName() {
        return "lineShortCircuit";
    }

    public double getB0ch();

    public void setB0ch(double b0ch);

    public double getD0ch();

    public void setD0ch(double d0ch);

    public double getR0();

    public void setR0(double r0);

    public double getX0();

    public void setX0(double x0);
}
