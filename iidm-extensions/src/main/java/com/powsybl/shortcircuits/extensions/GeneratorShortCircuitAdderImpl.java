/**
 * Copyright (c) 2021, RTE (http://www.rte-france.com)
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.powsybl.shortcircuits.extensions;

import com.powsybl.commons.extensions.AbstractExtensionAdder;
import com.powsybl.iidm.network.Generator;

/**
 *
 * @author Coline Piloquet <coline.piloquet@rte-france.fr>
 */
public class GeneratorShortCircuitAdderImpl extends AbstractExtensionAdder<Generator, GeneratorShortCircuit>
        implements GeneratorShortCircuitAdder {

    double directTransX = Double.NaN;
    double directSubtransX = Double.NaN;
    Double setUpTransformerX = null;

    protected GeneratorShortCircuitAdderImpl(Generator extendable) {
        super(extendable);
    }

    @Override
    protected GeneratorShortCircuit createExtension(Generator extendable) {
        return new GeneratorShortCircuitImpl(extendable, directTransX, directSubtransX, setUpTransformerX);
    }

    @Override
    public GeneratorShortCircuitAdder withDirectTransX(double directTransX) {
        this.directTransX = directTransX;
        return this;
    }

    @Override
    public GeneratorShortCircuitAdder withDirectSubtransX(double direcSubtransX) {
        this.directSubtransX = direcSubtransX;
        return this;
    }

    @Override
    public GeneratorShortCircuitAdder withSetUpTransformerX(double setUpTransformerX) {
        this.setUpTransformerX = setUpTransformerX;
        return this;
    }
}
