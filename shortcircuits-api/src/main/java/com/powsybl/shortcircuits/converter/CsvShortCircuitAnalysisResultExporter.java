package com.powsybl.shortcircuits.converter;

import com.google.auto.service.AutoService;
import com.powsybl.commons.io.table.CsvTableFormatterFactory;
import com.powsybl.commons.io.table.TableFormatterFactory;

/**
 * Exports a short circuit analysis result in CSV format.
 */
@AutoService(ShortCircuitAnalysisResultExporter.class)
public class CsvShortCircuitAnalysisResultExporter extends AbstractTableShortCircuitAnalysisResultExporter {

    private static final TableFormatterFactory FACTORY = new CsvTableFormatterFactory();

    @Override
    public String getFormat() {
        return "CSV";
    }

    @Override
    public String getComment() {
        return "Export a result in a CSV-like format";
    }

    @Override
    protected TableFormatterFactory getTableFormatterFactory() {
        return FACTORY;
    }
}
