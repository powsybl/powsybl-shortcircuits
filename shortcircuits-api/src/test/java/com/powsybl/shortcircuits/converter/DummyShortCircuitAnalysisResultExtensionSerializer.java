package com.powsybl.shortcircuits.converter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.google.auto.service.AutoService;
import com.powsybl.commons.extensions.ExtensionJsonSerializer;
import com.powsybl.shortcircuits.ShortCircuitAnalysisResult;

import java.io.IOException;

/**
 * @author Teofil-Calin BANC <teofil-calin.banc at rte-france.com>
 */
@AutoService(ExtensionJsonSerializer.class)
public class DummyShortCircuitAnalysisResultExtensionSerializer implements ExtensionJsonSerializer<ShortCircuitAnalysisResult, ShortCircuitAnalysisResultExportersTest.DummyShortCircuitAnalysisResultExtension> {

    @Override
    public String getExtensionName() {
        return "DummyShortCircuitAnalysisResultExtension";
    }

    @Override
    public String getCategoryName() {
        return "short-circuit-analysis";
    }

    @Override
    public Class<? super ShortCircuitAnalysisResultExportersTest.DummyShortCircuitAnalysisResultExtension> getExtensionClass() {
        return ShortCircuitAnalysisResultExportersTest.DummyShortCircuitAnalysisResultExtension.class;
    }

    @Override
    public void serialize(ShortCircuitAnalysisResultExportersTest.DummyShortCircuitAnalysisResultExtension extension, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeEndObject();
    }

    @Override
    public ShortCircuitAnalysisResultExportersTest.DummyShortCircuitAnalysisResultExtension deserialize(JsonParser parser, DeserializationContext deserializationContext)  throws IOException {
        while (parser.nextToken() != JsonToken.END_OBJECT) {
            continue;
        }
        return new ShortCircuitAnalysisResultExportersTest.DummyShortCircuitAnalysisResultExtension();
    }
}
