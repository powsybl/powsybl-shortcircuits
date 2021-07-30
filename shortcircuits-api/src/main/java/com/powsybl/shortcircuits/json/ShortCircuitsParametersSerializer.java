package com.powsybl.shortcircuits.json;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.powsybl.commons.json.JsonUtil;
import com.powsybl.shortcircuits.ShortCircuitsParameters;

public class ShortCircuitsParametersSerializer extends StdSerializer<ShortCircuitsParameters> {

    public ShortCircuitsParametersSerializer() {
        super(ShortCircuitsParameters.class);
    }

    @Override
    public void serialize(ShortCircuitsParameters parameters, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        JsonUtil.writeExtensions(parameters, jsonGenerator, serializerProvider, JsonShortCircuitsParameters.getExtensionSerializers());
        jsonGenerator.writeEndObject();
    }

}
