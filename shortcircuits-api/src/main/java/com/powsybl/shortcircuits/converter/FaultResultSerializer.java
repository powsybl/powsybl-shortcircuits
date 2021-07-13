package com.powsybl.shortcircuits.converter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.powsybl.commons.json.JsonUtil;
import com.powsybl.shortcircuits.FaultResult;

import java.io.IOException;

public class FaultResultSerializer extends StdSerializer<FaultResult> {

    public FaultResultSerializer() {
        super(FaultResult.class);
    }

    @Override
    public void serialize(FaultResult faultResult, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();

        jsonGenerator.writeStringField("id", faultResult.getId());
        jsonGenerator.writeNumberField("threePhaseFaultCurrent", faultResult.getThreePhaseFaultCurrent());

        JsonUtil.writeExtensions(faultResult, jsonGenerator, serializerProvider);

        jsonGenerator.writeEndObject();
    }
}
