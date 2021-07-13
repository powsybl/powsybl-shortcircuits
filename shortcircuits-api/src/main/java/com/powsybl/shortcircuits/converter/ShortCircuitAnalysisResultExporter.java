package com.powsybl.shortcircuits.converter;

import java.io.IOException;
import java.io.Writer;

import com.powsybl.iidm.network.Network;
import com.powsybl.shortcircuits.ShortCircuitAnalysisResult;

/**
 * Implementations provide a method to write down the content of a {@link ShortCircuitAnalysisResult}.
 */
public interface ShortCircuitAnalysisResultExporter {

    String getFormat();

    String getComment();

    void export(ShortCircuitAnalysisResult result, Writer writer, Network network) throws IOException;

}
