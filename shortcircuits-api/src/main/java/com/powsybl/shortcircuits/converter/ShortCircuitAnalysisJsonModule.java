package com.powsybl.shortcircuits.converter;

import com.fasterxml.jackson.databind.module.SimpleModule;
import com.powsybl.security.LimitViolation;
import com.powsybl.security.NetworkMetadata;
import com.powsybl.security.json.LimitViolationDeserializer;
import com.powsybl.security.json.LimitViolationSerializer;
import com.powsybl.security.json.NetworkMetadataDeserializer;
import com.powsybl.security.json.NetworkMetadataSerializer;
import com.powsybl.shortcircuits.ShortCircuitParameters;
import com.powsybl.shortcircuits.json.ShortCircuitParametersDeserializer;
import com.powsybl.shortcircuits.json.ShortCircuitParametersSerializer;
import com.powsybl.shortcircuits.FaultResult;
import com.powsybl.shortcircuits.ShortCircuitAnalysisResult;

public class ShortCircuitAnalysisJsonModule extends SimpleModule {

    public ShortCircuitAnalysisJsonModule() {
        addSerializer(LimitViolation.class, new LimitViolationSerializer());
        addDeserializer(LimitViolation.class, new LimitViolationDeserializer());
        addSerializer(FaultResult.class, new FaultResultSerializer());
        addDeserializer(FaultResult.class, new FaultResultDeserializer());
        addSerializer(ShortCircuitAnalysisResult.class, new ShortCircuitAnalysisResultSerializer());
        addDeserializer(ShortCircuitAnalysisResult.class, new ShortCircuitAnalysisResultDeserializer());
        addSerializer(NetworkMetadata.class, new NetworkMetadataSerializer());
        addDeserializer(NetworkMetadata.class, new NetworkMetadataDeserializer());
        addSerializer(ShortCircuitParameters.class, new ShortCircuitParametersSerializer());
        addDeserializer(ShortCircuitParameters.class, new ShortCircuitParametersDeserializer());
    }

}
