/**
 * Copyright (c) 2021, RTE (http://www.rte-france.com)
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.powsybl.shortcircuits.json;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.powsybl.commons.extensions.Extension;
import com.powsybl.commons.extensions.ExtensionJsonSerializer;
import com.powsybl.commons.extensions.ExtensionProviders;
import com.powsybl.commons.json.JsonUtil;
import com.powsybl.shortcircuits.ShortCircuitsParameters;
import com.powsybl.shortcircuits.converter.ShortCircuitsAnalysisJsonModule;

public final class JsonShortCircuitsParameters {
    public interface ExtensionSerializer<E extends Extension<ShortCircuitsParameters>> extends ExtensionJsonSerializer<ShortCircuitsParameters, E> {
    }

    private static final Supplier<ExtensionProviders<ExtensionSerializer>> SUPPLIER =
            Suppliers.memoize(() -> ExtensionProviders.createProvider(ExtensionSerializer.class, "short-circuit-parameters"));

    public static ExtensionProviders<ExtensionSerializer> getExtensionSerializers() {
        return SUPPLIER.get();
    }

    private JsonShortCircuitsParameters() {

    }

    public static ShortCircuitsParameters update(ShortCircuitsParameters parameters, Path jsonFile) {
        Objects.requireNonNull(jsonFile);

        try (InputStream is = Files.newInputStream(jsonFile)) {
            return update(parameters, is);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public static ShortCircuitsParameters update(ShortCircuitsParameters parameters, InputStream is) {
        try {
            ObjectMapper objectMapper = createObjectMapper();
            return objectMapper.readerForUpdating(parameters).readValue(is);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    private static ObjectMapper createObjectMapper() {
        return JsonUtil.createObjectMapper().registerModule(new ShortCircuitsAnalysisJsonModule());
    }

    public static void write(ShortCircuitsParameters parameters, Path jsonFile) {
        Objects.requireNonNull(jsonFile);

        try (OutputStream outputStream = Files.newOutputStream(jsonFile)) {
            write(parameters, outputStream);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public static void write(ShortCircuitsParameters parameters, OutputStream outputStream) {
        try {
            ObjectMapper objectMapper = createObjectMapper();
            ObjectWriter writer = objectMapper.writerWithDefaultPrettyPrinter();
            writer.writeValue(outputStream, parameters);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    public static ShortCircuitsParameters read(Path jsonFile) {
        return update(new ShortCircuitsParameters(), jsonFile);
    }

    public static ShortCircuitsParameters read(InputStream jsonStream) {
        return update(new ShortCircuitsParameters(), jsonStream);
    }
}
