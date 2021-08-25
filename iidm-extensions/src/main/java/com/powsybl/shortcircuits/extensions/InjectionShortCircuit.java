/**
 * Copyright (c) 2021, RTE (http://www.rte-france.com)
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.powsybl.shortcircuits.extensions;

import com.powsybl.commons.extensions.Extension;
import com.powsybl.iidm.network.Injection;

/**
 *
 * @author Coline Piloquet <coline.piloquet@rte-france.fr>
 */
public interface InjectionShortCircuit extends Extension<Injection> {
    @Override
    default String getName() {
        return "injectionShortCircuit";
    }

    double getR0();

    InjectionShortCircuit setR0(double r0);

    double getR2();

    InjectionShortCircuit setR2(double r2);

    double getX0();

    InjectionShortCircuit setX0(double x0);

    double getX2();

    InjectionShortCircuit setX2(double x2);

}