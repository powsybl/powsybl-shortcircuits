package com.powsybl.shortcircuits.converter;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.google.auto.service.AutoService;
import com.powsybl.commons.extensions.ExtensionJsonSerializer;
import com.powsybl.shortcircuits.FaultResult;

import java.io.IOException;

/**
 * @author Teofil-Calin BANC <teofil-calin.banc at rte-france.com>
 */
@AutoService(ExtensionJsonSerializer.class)
public class DummyFaultResultExtensionSerializer implements ExtensionJsonSerializer<FaultResult, ShortCircuitsAnalysisResultExportersTest.DummyFaultResultExtension> {

    @Override
    public String getExtensionName() {
        return "DummyFaultResultExtension";
    }

    @Override
    public String getCategoryName() {
        return "short-circuit-analysis";
    }

    @Override
    public Class<? super ShortCircuitsAnalysisResultExportersTest.DummyFaultResultExtension> getExtensionClass() {
        return ShortCircuitsAnalysisResultExportersTest.DummyFaultResultExtension.class;
    }

    @Override
    public void serialize(ShortCircuitsAnalysisResultExportersTest.DummyFaultResultExtension extension, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeEndObject();
    }

    @Override
    public ShortCircuitsAnalysisResultExportersTest.DummyFaultResultExtension deserialize(JsonParser parser, DeserializationContext deserializationContext) throws IOException {
        while (parser.nextToken() != JsonToken.END_OBJECT) {
            continue;
        }
        return new ShortCircuitsAnalysisResultExportersTest.DummyFaultResultExtension();
    }
}
