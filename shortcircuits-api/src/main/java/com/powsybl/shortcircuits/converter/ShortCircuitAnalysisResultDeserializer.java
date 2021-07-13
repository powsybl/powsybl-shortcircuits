package com.powsybl.shortcircuits.converter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.powsybl.commons.extensions.*;
import com.powsybl.commons.json.JsonUtil;
import com.powsybl.security.LimitViolation;
import com.powsybl.security.NetworkMetadata;
import com.powsybl.shortcircuits.FaultResult;
import com.powsybl.shortcircuits.ShortCircuitAnalysisResult;

import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Teofil-Calin BANC <teofil-calin.banc at rte-france.com>
 */
public class ShortCircuitAnalysisResultDeserializer extends StdDeserializer<ShortCircuitAnalysisResult> {

    private static final Supplier<ExtensionProviders<ExtensionJsonSerializer>> SUPPLIER =
        Suppliers.memoize(() -> ExtensionProviders.createProvider(ExtensionJsonSerializer.class, "short-circuit-analysis"));

    ShortCircuitAnalysisResultDeserializer() {
        super(ShortCircuitAnalysisResult.class);
    }

    @Override
    public ShortCircuitAnalysisResult deserialize(JsonParser parser, DeserializationContext ctx) throws IOException {
        NetworkMetadata networkMetadata = null;
        List<FaultResult> faultResults = null;
        List<LimitViolation> limitViolations = Collections.emptyList();
        List<Extension<ShortCircuitAnalysisResult>> extensions = Collections.emptyList();

        while (parser.nextToken() != JsonToken.END_OBJECT) {
            switch (parser.getCurrentName()) {
                case "version":
                    parser.nextToken(); // skip
                    break;

                case "network":
                    parser.nextToken();
                    networkMetadata = parser.readValueAs(NetworkMetadata.class);
                    break;

                case "faultResults":
                    parser.nextToken();
                    faultResults = parser.readValueAs(new TypeReference<ArrayList<FaultResult>>() {
                    });
                    break;

                case "limitViolations":
                    parser.nextToken();
                    limitViolations = parser.readValueAs(new TypeReference<ArrayList<LimitViolation>>() {
                    });
                    break;

                case "extensions":
                    parser.nextToken();
                    extensions = JsonUtil.readExtensions(parser, ctx, SUPPLIER.get());
                    break;

                default:
                    throw new AssertionError("Unexpected field: " + parser.getCurrentName());
            }
        }

        ShortCircuitAnalysisResult result = new ShortCircuitAnalysisResult(faultResults, limitViolations);
        result.setNetworkMetadata(networkMetadata);
        SUPPLIER.get().addExtensions(result, extensions);

        return result;
    }

    public static ShortCircuitAnalysisResult read(Path jsonFile) {
        try (InputStream is = Files.newInputStream(jsonFile)) {
            return read(is);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public static ShortCircuitAnalysisResult read(InputStream is) {
        Objects.requireNonNull(is);

        ObjectMapper objectMapper = JsonUtil.createObjectMapper()
                .registerModule(new ShortCircuitAnalysisJsonModule());
        try {
            return objectMapper.readValue(is, ShortCircuitAnalysisResult.class);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }
}
