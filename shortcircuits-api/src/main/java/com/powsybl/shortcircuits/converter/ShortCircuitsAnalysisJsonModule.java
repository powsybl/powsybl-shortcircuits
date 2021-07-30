package com.powsybl.shortcircuits.converter;

import com.fasterxml.jackson.databind.module.SimpleModule;
import com.powsybl.security.LimitViolation;
import com.powsybl.security.NetworkMetadata;
import com.powsybl.security.json.LimitViolationDeserializer;
import com.powsybl.security.json.LimitViolationSerializer;
import com.powsybl.security.json.NetworkMetadataDeserializer;
import com.powsybl.security.json.NetworkMetadataSerializer;
import com.powsybl.shortcircuits.ShortCircuitsParameters;
import com.powsybl.shortcircuits.json.ShortCircuitsParametersDeserializer;
import com.powsybl.shortcircuits.json.ShortCircuitsParametersSerializer;
import com.powsybl.shortcircuits.FaultResult;
import com.powsybl.shortcircuits.ShortCircuitsAnalysisResult;

public class ShortCircuitsAnalysisJsonModule extends SimpleModule {

    public ShortCircuitsAnalysisJsonModule() {
        addSerializer(LimitViolation.class, new LimitViolationSerializer());
        addDeserializer(LimitViolation.class, new LimitViolationDeserializer());
        addSerializer(FaultResult.class, new FaultResultSerializer());
        addDeserializer(FaultResult.class, new FaultResultDeserializer());
        addSerializer(ShortCircuitsAnalysisResult.class, new ShortCircuitsAnalysisResultSerializer());
        addDeserializer(ShortCircuitsAnalysisResult.class, new ShortCircuitsAnalysisResultDeserializer());
        addSerializer(NetworkMetadata.class, new NetworkMetadataSerializer());
        addDeserializer(NetworkMetadata.class, new NetworkMetadataDeserializer());
        addSerializer(ShortCircuitsParameters.class, new ShortCircuitsParametersSerializer());
        addDeserializer(ShortCircuitsParameters.class, new ShortCircuitsParametersDeserializer());
    }

}
