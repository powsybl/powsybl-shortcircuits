package com.powsybl.shortcircuits.converter;

import java.io.IOException;
import java.io.Writer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.auto.service.AutoService;
import com.powsybl.commons.json.JsonUtil;
import com.powsybl.iidm.network.Network;
import com.powsybl.shortcircuits.ShortCircuitAnalysisResult;

/**
 * Exports a short circuit analysis result in JSON format.
 */
@AutoService(ShortCircuitAnalysisResultExporter.class)
public class JsonShortCircuitAnalysisResultExporter implements ShortCircuitAnalysisResultExporter {

    @Override
    public String getFormat() {
        return "JSON";
    }

    @Override
    public String getComment() {
        return "Export a result in JSON format";
    }

    @Override
    public void export(ShortCircuitAnalysisResult result, Writer writer, Network network) throws IOException {
        ObjectMapper objectMapper = JsonUtil.createObjectMapper()
                .registerModule(new ShortCircuitAnalysisJsonModule());

        ObjectWriter objectWriter = objectMapper.writerWithDefaultPrettyPrinter();
        objectWriter.writeValue(writer, result);

    }
}
