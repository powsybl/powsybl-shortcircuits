/**
 * Copyright (c) 2021, RTE (http://www.rte-france.com)
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package com.powsybl.shortcircuits;

import com.powsybl.commons.Versionable;
import com.powsybl.commons.config.PlatformConfigNamedProvider;
import com.powsybl.computation.ComputationManager;
import com.powsybl.iidm.network.Network;
import com.powsybl.shortcircuits.interceptors.ShortCircuitsAnalysisInterceptor;

import java.util.concurrent.CompletableFuture;

/**
 * @author Bertrand Rix <bertrand.rix at artelys.com>
 */
public interface ShortCircuitsAnalysisProvider extends Versionable, PlatformConfigNamedProvider {

    void addInterceptor(ShortCircuitsAnalysisInterceptor interceptor);

    boolean removeInterceptor(ShortCircuitsAnalysisInterceptor interceptor);

    default CompletableFuture<ShortCircuitsAnalysisResult> run(Network network, ShortCircuitsParameters parameters,
                                                               ComputationManager computationManager) {
        return ShortCircuitsAnalysis.runAsync(network, parameters, computationManager);
    }
}
