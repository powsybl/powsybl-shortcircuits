package com.powsybl.shortcircuits.converter;

import com.google.auto.service.AutoService;
import com.powsybl.commons.io.table.AsciiTableFormatterFactory;
import com.powsybl.commons.io.table.TableFormatterFactory;

/**
 * Exports a short circuit analysis result as an ASCII formatted table.
 */
@AutoService(ShortCircuitAnalysisResultExporter.class)
public class AsciiShortCircuitAnalysisResultExporter extends AbstractTableShortCircuitAnalysisResultExporter {

    private static final TableFormatterFactory FACTORY = new AsciiTableFormatterFactory();

    @Override
    public String getFormat() {
        return "ASCII";
    }

    @Override
    public String getComment() {
        return "Export a result in ASCII tables";
    }

    @Override
    protected TableFormatterFactory getTableFormatterFactory() {
        return FACTORY;
    }
}
