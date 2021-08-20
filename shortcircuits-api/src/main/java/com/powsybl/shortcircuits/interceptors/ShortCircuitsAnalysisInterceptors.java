/**
 * Copyright (c) 2021, RTE (http://www.rte-france.com)
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.powsybl.shortcircuits.interceptors;

import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.powsybl.commons.util.ServiceLoaderCache;

import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Teofil-Calin BANC <teofil-calin.banc at rte-france.com>
 */
public final class ShortCircuitsAnalysisInterceptors {

    private static final Supplier<Map<String, ShortCircuitsAnalysisInterceptorExtension>> EXTENSIONS
        = Suppliers.memoize(ShortCircuitsAnalysisInterceptors::loadExtensions);

    private static Map<String, ShortCircuitsAnalysisInterceptorExtension> loadExtensions() {
        return new ServiceLoaderCache<>(ShortCircuitsAnalysisInterceptorExtension.class).getServices().stream()
                                                                                        .collect(Collectors.toMap(ShortCircuitsAnalysisInterceptorExtension::getName, e -> e));
    }

    public static Set<String> getExtensionNames() {
        return EXTENSIONS.get().keySet();
    }

    public static ShortCircuitsAnalysisInterceptor createInterceptor(String name) {
        Objects.requireNonNull(name);

        ShortCircuitsAnalysisInterceptorExtension extension = EXTENSIONS.get().get(name);
        if (extension == null) {
            throw new IllegalArgumentException("The extension '" + name + "' doesn't exist");
        }

        return extension.createInterceptor();
    }

    private ShortCircuitsAnalysisInterceptors() {
    }
}
