package com.powsybl.shortcircuits.converter;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.ServiceLoader;

import com.powsybl.commons.PowsyblException;
import com.powsybl.iidm.network.Network;
import com.powsybl.shortcircuits.ShortCircuitsAnalysisResult;

/**
 * Provides easy access to known implementations of result "exporters". ({@link ShortCircuitsAnalysisResultExporter})
 */
public final class ShortCircuitAnalysisResultExporters {

    private ShortCircuitAnalysisResultExporters() {
    }

    public static Collection<String> getFormats() {
        List<String> formats = new ArrayList<>();
        for (ShortCircuitsAnalysisResultExporter e : ServiceLoader.load(ShortCircuitsAnalysisResultExporter.class, ShortCircuitAnalysisResultExporters.class.getClassLoader())) {
            formats.add(e.getFormat());
        }
        return formats;
    }

    public static ShortCircuitsAnalysisResultExporter getExporter(String format) {
        Objects.requireNonNull(format);
        for (ShortCircuitsAnalysisResultExporter e : ServiceLoader.load(ShortCircuitsAnalysisResultExporter.class, ShortCircuitAnalysisResultExporters.class.getClassLoader())) {
            if (format.equals(e.getFormat())) {
                return e;
            }
        }
        return null;
    }

    public static void export(ShortCircuitsAnalysisResult result, Path path, String format, Network network) {
        Objects.requireNonNull(path);
        try (Writer writer = Files.newBufferedWriter(path)) {
            export(result, writer, format, network);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public static void export(ShortCircuitsAnalysisResult result, Writer writer, String format, Network network) throws IOException {
        Objects.requireNonNull(result);
        Objects.requireNonNull(writer);
        Objects.requireNonNull(format);

        ShortCircuitsAnalysisResultExporter exporter = getExporter(format);
        if (exporter == null) {
            throw new PowsyblException("Unsupported format: " + format + " [" + getFormats() + "]");
        }

        exporter.export(result, writer, network);
    }
}
