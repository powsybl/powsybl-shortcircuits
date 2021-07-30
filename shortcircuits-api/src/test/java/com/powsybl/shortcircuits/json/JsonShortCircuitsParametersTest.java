package com.powsybl.shortcircuits.json;

import java.io.IOException;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.google.auto.service.AutoService;
import com.powsybl.commons.AbstractConverterTest;
import com.powsybl.commons.extensions.AbstractExtension;
import com.powsybl.shortcircuits.ShortCircuitsParameters;

public class JsonShortCircuitsParametersTest extends AbstractConverterTest {

    @Test
    public void roundTrip() throws IOException {
        ShortCircuitsParameters parameters = new ShortCircuitsParameters();
        parameters.addExtension(DummyExtension.class, new DummyExtension());
        roundTripTest(parameters, JsonShortCircuitsParameters::write, JsonShortCircuitsParameters::read,
                "/ShortCircuitsParameters.json");
    }

    private static class DummyExtension extends AbstractExtension<ShortCircuitsParameters> {

        @Override
        public String getName() {
            return "dummy-extension";
        }
    }

    @AutoService(JsonShortCircuitsParameters.ExtensionSerializer.class)
    public static class DummySerializer implements JsonShortCircuitsParameters.ExtensionSerializer<DummyExtension> {

        @Override
        public void serialize(DummyExtension extension, JsonGenerator jsonGenerator,
                SerializerProvider serializerProvider) throws IOException {
            jsonGenerator.writeStartObject();
            jsonGenerator.writeEndObject();
        }

        @Override
        public DummyExtension deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) {
            return new DummyExtension();
        }

        @Override
        public String getExtensionName() {
            return "dummy-extension";
        }

        @Override
        public String getCategoryName() {
            return "short-circuit-parameters";
        }

        @Override
        public Class<? super DummyExtension> getExtensionClass() {
            return DummyExtension.class;
        }
    }
}
