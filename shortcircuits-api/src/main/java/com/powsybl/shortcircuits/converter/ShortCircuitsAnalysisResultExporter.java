package com.powsybl.shortcircuits.converter;

import java.io.IOException;
import java.io.Writer;

import com.powsybl.iidm.network.Network;
import com.powsybl.shortcircuits.ShortCircuitsAnalysisResult;

/**
 * Implementations provide a method to write down the content of a {@link ShortCircuitsAnalysisResult}.
 */
public interface ShortCircuitsAnalysisResultExporter {

    String getFormat();

    String getComment();

    void export(ShortCircuitsAnalysisResult result, Writer writer, Network network) throws IOException;

}
