/**
 * Copyright (c) 2021, RTE (http://www.rte-france.com)
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.powsybl.shortcircuits.converter;

import java.io.IOException;
import java.io.Writer;

import com.powsybl.iidm.network.Network;
import com.powsybl.shortcircuits.ShortCircuitsAnalysisResult;

/**
 * Implementations provide a method to write down the content of a {@link ShortCircuitsAnalysisResult}.
 */
public interface ShortCircuitsAnalysisResultExporter {

    String getFormat();

    String getComment();

    void export(ShortCircuitsAnalysisResult result, Writer writer, Network network) throws IOException;

}
