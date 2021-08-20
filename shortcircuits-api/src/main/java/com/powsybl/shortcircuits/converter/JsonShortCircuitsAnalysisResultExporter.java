/**
 * Copyright (c) 2021, RTE (http://www.rte-france.com)
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.powsybl.shortcircuits.converter;

import java.io.IOException;
import java.io.Writer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.auto.service.AutoService;
import com.powsybl.commons.json.JsonUtil;
import com.powsybl.iidm.network.Network;
import com.powsybl.shortcircuits.ShortCircuitsAnalysisResult;

/**
 * Exports a short circuit analysis result in JSON format.
 */
@AutoService(ShortCircuitsAnalysisResultExporter.class)
public class JsonShortCircuitsAnalysisResultExporter implements ShortCircuitsAnalysisResultExporter {

    @Override
    public String getFormat() {
        return "JSON";
    }

    @Override
    public String getComment() {
        return "Export a result in JSON format";
    }

    @Override
    public void export(ShortCircuitsAnalysisResult result, Writer writer, Network network) throws IOException {
        ObjectMapper objectMapper = JsonUtil.createObjectMapper()
                .registerModule(new ShortCircuitsAnalysisJsonModule());

        ObjectWriter objectWriter = objectMapper.writerWithDefaultPrettyPrinter();
        objectWriter.writeValue(writer, result);

    }
}
