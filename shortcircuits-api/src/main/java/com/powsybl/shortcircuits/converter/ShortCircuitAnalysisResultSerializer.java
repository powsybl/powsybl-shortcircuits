package com.powsybl.shortcircuits.converter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.powsybl.commons.json.JsonUtil;
import com.powsybl.shortcircuits.ShortCircuitAnalysisResult;

import java.io.IOException;

public class ShortCircuitAnalysisResultSerializer extends StdSerializer<ShortCircuitAnalysisResult> {

    private static final String VERSION = "1.0";

    ShortCircuitAnalysisResultSerializer() {
        super(ShortCircuitAnalysisResult.class);
    }

    @Override
    public void serialize(ShortCircuitAnalysisResult result, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();

        jsonGenerator.writeStringField("version", VERSION);
        if (result.getNetworkMetadata() != null) {
            jsonGenerator.writeObjectField("network", result.getNetworkMetadata());
        }
        jsonGenerator.writeObjectField("faultResults", result.getFaultResults());
        jsonGenerator.writeObjectField("limitViolations", result.getLimitViolations());

        JsonUtil.writeExtensions(result, jsonGenerator, serializerProvider);

        jsonGenerator.writeEndObject();
    }
}
