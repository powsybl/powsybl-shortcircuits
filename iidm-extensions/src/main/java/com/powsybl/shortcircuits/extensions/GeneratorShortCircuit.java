/**
 * Copyright (c) 2021, RTE (http://www.rte-france.com)
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.powsybl.shortcircuits.extensions;

import com.powsybl.commons.extensions.Extension;
import com.powsybl.iidm.network.Generator;

/**
 * @author Coline Piloquet <coline.piloquet@rte-france.fr>
 */
public interface GeneratorShortCircuit extends Extension<Generator> {
    @Override
    default String getName() {
        return "generatorShortCircuit";
    }

    public boolean isEarthing();

    public void setEarthing(boolean earthing);

    public double getR0();

    public void setR0(double r0);

    public double getR2();

    public void setR2(double r2);

    public double getSatDirectSubtranX();

    public void setSatDirectSubtranX(double satDirectSubtranX);

    public double getSatDirectSyncX();

    public void setGetSatDirectSyncX(double getSatDirectSyncX);

    public double getSatDirectTransX();

    public void setSatDirectTransX(double satDirectTransX);

    public double getX0();

    public void setX0(double x0);

    public double getX2();

    public void setX2(double x2);

}
