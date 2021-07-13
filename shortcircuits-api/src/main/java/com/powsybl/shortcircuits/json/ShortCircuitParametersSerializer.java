package com.powsybl.shortcircuits.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.powsybl.commons.json.JsonUtil;
import com.powsybl.shortcircuits.ShortCircuitParameters;

public class ShortCircuitParametersSerializer extends StdSerializer<ShortCircuitParameters> {

    public ShortCircuitParametersSerializer() {
        super(ShortCircuitParameters.class);
    }

    @Override
    public void serialize(ShortCircuitParameters parameters, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        JsonUtil.writeExtensions(parameters, jsonGenerator, serializerProvider, JsonShortCircuitParameters.getExtensionSerializers());
        jsonGenerator.writeEndObject();
    }

}
